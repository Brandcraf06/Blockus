package com.brand.blockus.utils.helper;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.blockitems.ColoredTilesBlockItem;
import com.brand.blockus.blocks.blockitems.LegacyBlockItem;
import com.brand.blockus.blocks.blockitems.NetherStarBlockItem;
import com.brand.blockus.utils.BlockChecker;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockBuilder {
    public static final Function<BlockBehaviour.Properties, Block> DEFAULT_FACTORY = Block::new;
    public static final Supplier<Item.Properties> DEFAULT_ITEM_PROPERTIES = () -> new Item.Properties().useBlockDescriptionPrefix();

    public Function<BlockBehaviour.Properties, Block> factory = DEFAULT_FACTORY;
    public BlockBehaviour.Properties properties;
    
    public Item.Properties itemProperties = DEFAULT_ITEM_PROPERTIES.get();

    public Block base;

    public BlockBuilder(Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        this.factory = factory;
        this.properties = properties;
    }

    public BlockBuilder(BlockBehaviour.Properties properties) {
        this.properties = properties;
    }

    public BlockBuilder(Block block) {
        this.properties = BlockBehaviour.Properties.ofFullCopy(block);
        this.base = block;
    }

    public BlockBuilder factory(Function<BlockBehaviour.Properties, Block> factory) {
        this.factory = factory;
        return this;
    }

    public BlockBuilder properties(BlockBehaviour.Properties properties) {
        this.properties = properties;
        return this;
    }

    public BlockBuilder properties(Function<BlockBehaviour.Properties, BlockBehaviour.Properties> propertiesConsumer) {
        this.properties = propertiesConsumer.apply(this.properties);
        return this;
    }

    public BlockBuilder itemProperties(Item.Properties properties) {
        this.itemProperties = properties;
        return this;
    }

    public BlockBuilder itemProperties(Function<Item.Properties, Item.Properties> properties) {
        this.itemProperties = properties.apply(this.itemProperties);
        return this;
    }

    public BlockBuilder noItem() {
        this.itemProperties = null;
        return this;
    }

    public Block getBase() {
        return this.base;
    }

    public Block register(String name, Function<Block, Item> itemFactory) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Blockus.id(name));
        if (this.factory == null) {
            throw new IllegalStateException("Cannot register block: factory is not set!");
        }
        var block = this.factory.apply(this.properties.setId(key));
        Registry.register(BuiltInRegistries.BLOCK, key, block);
        if (this.itemProperties instanceof Item.Properties) {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, key.identifier());
            Registry.register(BuiltInRegistries.ITEM, itemRegistryKey, itemFactory.apply(block)
            );
        }

        return block;
    }

    public Block register(String name) {
        return register(name, block -> {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, Blockus.id(name));
            Item.Properties itemProperties = this.itemProperties;
            if (BlockChecker.isNetherite(name) && itemProperties instanceof Item.Properties properties) {
                itemProperties = properties.fireResistant();
            }
            return new BlockItem(block, itemProperties.setId(itemRegistryKey));
        });
    }

    public Block registerNetherStarBlock(String name) {
        return register(name, block -> {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, Blockus.id(name));
            return new NetherStarBlockItem(block, this.itemProperties.setId(itemRegistryKey).rarity(Rarity.UNCOMMON));
        });
    }

    public Block registerLegacy(String name, String version) {
        return register(name, block -> {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, Blockus.id(name));
            return new LegacyBlockItem(block, this.itemProperties.setId(itemRegistryKey), version);
        });
    }

    public Block registerColoredTiles(String name) {
        return register(name, block -> {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, Blockus.id(name));
            return new ColoredTilesBlockItem(block, this.itemProperties.setId(itemRegistryKey).overrideDescription(Util.makeDescriptionId("block", Blockus.id("colored_tiles"))));
        });
    }
}
