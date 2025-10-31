package com.brand.blockus.utils.helper;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.blockitems.ColoredTilesBlockItem;
import com.brand.blockus.blocks.blockitems.LegacyBlockItem;
import com.brand.blockus.blocks.blockitems.NetherStarBlockItem;
import com.brand.blockus.utils.BlockChecker;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockBuilder {
    public static final Function<BlockBehaviour.Properties, Block> DEFAULT_FACTORY = Block::new;
    public static final Supplier<Item.Properties> DEFAULT_ITEM_SETTINGS = () -> new Item.Properties().useBlockDescriptionPrefix();

    public Function<BlockBehaviour.Properties, Block> factory = DEFAULT_FACTORY;
    public BlockBehaviour.Properties settings;

    public Item.Properties itemSettings = DEFAULT_ITEM_SETTINGS.get();

    public Block base;

    public BlockBuilder(Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        this.factory = factory;
        this.settings = settings;
    }

    public BlockBuilder(BlockBehaviour.Properties settings) {
        this.settings = settings;
    }

    public BlockBuilder(Block block) {
        this.settings = BlockBehaviour.Properties.ofFullCopy(block);
        this.base = block;
    }

    public BlockBuilder factory(Function<BlockBehaviour.Properties, Block> factory) {
        this.factory = factory;
        return this;
    }

    public BlockBuilder settings(BlockBehaviour.Properties settings) {
        this.settings = settings;
        return this;
    }

    public BlockBuilder settings(Function<BlockBehaviour.Properties, BlockBehaviour.Properties> settingsConsumer) {
        this.settings = settingsConsumer.apply(this.settings);
        return this;
    }

    public BlockBuilder itemSettings(Item.Properties settings) {
        this.itemSettings = settings;
        return this;
    }

    public BlockBuilder itemSettings(Function<Item.Properties, Item.Properties> settings) {
        this.itemSettings = settings.apply(this.itemSettings);
        return this;
    }

    public BlockBuilder noItem() {
        this.itemSettings = null;
        return this;
    }

    public Block getBase() {
        return this.base;
    }

    public Block register(String id, Function<Block, Item> itemFactory) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Blockus.id(id));
        if (this.factory == null) {
            throw new IllegalStateException("Cannot register block: factory is not set!");
        }
        var block = this.factory.apply(this.settings.setId(key));
        Registry.register(BuiltInRegistries.BLOCK, key, block);
        if (this.itemSettings instanceof Item.Properties) {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, key.location());
            Registry.register(BuiltInRegistries.ITEM, itemRegistryKey, itemFactory.apply(block)
            );
        }

        return block;
    }

    public Block register(String id) {
        return register(id, block -> {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, Blockus.id(id));
            Item.Properties itemSettings = this.itemSettings;
            if (BlockChecker.isNetherite(id) && itemSettings instanceof Item.Properties settings) {
                itemSettings = settings.fireResistant();
            }
            return new BlockItem(block, itemSettings.setId(itemRegistryKey));
        });
    }

    public Block registerNetherStarBlock(String id) {
        return register(id, block -> {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, Blockus.id(id));
            return new NetherStarBlockItem(block, this.itemSettings.setId(itemRegistryKey).rarity(Rarity.UNCOMMON));
        });
    }

    public Block registerLegacy(String id, String version) {
        return register(id, block -> {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, Blockus.id(id));
            return new LegacyBlockItem(block, this.itemSettings.setId(itemRegistryKey), version);
        });
    }

    public Block registerColoredTiles(String id) {
        return register(id, block -> {
            var itemRegistryKey = ResourceKey.create(Registries.ITEM, Blockus.id(id));
            return new ColoredTilesBlockItem(block, this.itemSettings.setId(itemRegistryKey).overrideDescription(Util.makeDescriptionId("block", Blockus.id("colored_tiles"))));
        });
    }
}
