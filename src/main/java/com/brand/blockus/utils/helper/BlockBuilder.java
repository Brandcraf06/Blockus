package com.brand.blockus.utils.helper;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.blockitems.ColoredTilesBlockItem;
import com.brand.blockus.blocks.blockitems.LegacyBlockItem;
import com.brand.blockus.blocks.blockitems.NetherStarBlockItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BlockBuilder {
    public static final Function<BlockBehaviour.Properties, Block> DEFAULT_FACTORY = Block::new;
    public static final Supplier<Item.Properties> DEFAULT_ITEM_PROPERTIES = () -> new Item.Properties().useBlockDescriptionPrefix();
    public static final Map<Block, BlockItemId> IDS = new HashMap<>();

    public Function<BlockBehaviour.Properties, Block> factory = DEFAULT_FACTORY;
    public BlockBehaviour.Properties properties;
    public BlockItemId id;

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

    public BlockBuilder itemProperties(UnaryOperator<Item.Properties> itemPropertiesFunction) {
        this.itemProperties = itemPropertiesFunction.apply(DEFAULT_ITEM_PROPERTIES.get());
        return this;
    }

    public BlockBuilder cookingFuel(ResourceKey<ContextIntProvider> burnTime) {
        this.itemProperties.cookingFuel(burnTime);
        return this;
    }

    public BlockBuilder compostable(ResourceKey<ContextIntProvider> compostable) {
        this.itemProperties.compostable(compostable);
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

    public BlockBuilder noItem() {
        this.itemProperties = null;
        return this;
    }

    public static BlockItemId getId(Block block) {
        return IDS.get(block);
    }

    public Block getBase() {
        return this.base;
    }

    public Block register(BlockItemId id, Function<Block, Item> itemFactory) {
        if (this.factory == null) {
            throw new IllegalStateException("Cannot register block: factory is not set!");
        }
        var block = this.factory.apply(this.properties.setId(id.block()));
        Registry.register(BuiltInRegistries.BLOCK, id.block(), block);
        if (this.itemProperties instanceof Item.Properties) {
            Registry.register(BuiltInRegistries.ITEM, id.item(), itemFactory.apply(block)
            );
        }

        IDS.put(block, id);

        return block;
    }

    public static Block registerBlock(BlockItemId id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        return registerBlock(id.block(), factory, properties);
    }

    public static Block registerBlock(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public Block register(BlockItemId id) {
        return register(id, block -> {
            Item.Properties itemProperties = this.itemProperties;
            if (id.toString().contains("netherite") && itemProperties instanceof Item.Properties properties) {
                itemProperties = properties.fireResistant();
            }
            return new BlockItem(block, itemProperties.setId(id.item()));
        });
    }

    public Block registerNetherStarBlock(BlockItemId id) {
        return register(id, block -> new NetherStarBlockItem(block, this.itemProperties.setId(id.item()).rarity(Rarity.UNCOMMON)));
    }

    public Block registerLegacy(BlockItemId id, String version) {
        return register(id, block -> new LegacyBlockItem(block, this.itemProperties.setId(id.item()), version));
    }

    public Block registerColoredTiles(BlockItemId id) {
        return register(id, block -> new ColoredTilesBlockItem(block, this.itemProperties.setId(id.item()).overrideDescription(Util.makeDescriptionId("block", Blockus.id("colored_tiles")))));
    }
}
