package com.brand.blockus.utils.helper;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.blockitems.ColoredTilesBlockItem;
import com.brand.blockus.blocks.blockitems.LegacyBlockItem;
import com.brand.blockus.blocks.blockitems.NetherStarBlockItem;
import com.brand.blockus.utils.BlockChecker;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockBuilder {
    public static final Function<AbstractBlock.Settings, Block> DEFAULT_FACTORY = Block::new;
    public static final Supplier<Item.Settings> DEFAULT_ITEM_SETTINGS = Item.Settings::new;

    public Function<AbstractBlock.Settings, Block> factory = DEFAULT_FACTORY;
    public AbstractBlock.Settings settings;

    public Item.Settings itemSettings = DEFAULT_ITEM_SETTINGS.get();
    public Block base;

    public BlockBuilder(Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        this.factory = factory;
        this.settings = settings;
    }

    public BlockBuilder(AbstractBlock.Settings settings) {
        this.settings = settings;
    }

    public BlockBuilder(Block block) {
        this.settings = AbstractBlock.Settings.copy(block);
        this.base = block;
    }

    public BlockBuilder factory(Function<AbstractBlock.Settings, Block> factory) {
        this.factory = factory;
        return this;
    }

    public BlockBuilder settings(AbstractBlock.Settings settings) {
        this.settings = settings;
        return this;
    }

    public BlockBuilder settings(Function<AbstractBlock.Settings, AbstractBlock.Settings> settingsConsumer) {
        this.settings = settingsConsumer.apply(this.settings);
        return this;
    }

    public BlockBuilder itemSettings(Item.Settings settings) {
        this.itemSettings = settings;
        return this;
    }

    public BlockBuilder itemSettings(Function<Item.Settings, Item.Settings> settings) {
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
        Identifier identifier = Blockus.id(id);
        Block block = this.factory.apply(this.settings);
        Registry.register(Registries.BLOCK, identifier, block);

        if (this.itemSettings != null) {
            Item item = itemFactory.apply(block);
            Registry.register(Registries.ITEM, identifier, item);
        }

        return block;
    }

    public Block register(String id) {
        return register(id, block -> {
            Item.Settings settings = this.itemSettings;
            if (BlockChecker.isNetherite(id)) {
                settings = new Item.Settings().fireproof();
            }
            return new BlockItem(block, settings);
        });
    }

    public Block registerNetherStarBlock(String id) {
        return register(id, block -> new NetherStarBlockItem(block, this.itemSettings));
    }

    public Block registerLegacy(String id, String version) {
        return register(id, block -> new LegacyBlockItem(block, this.itemSettings, version));
    }

    public Block registerColoredTiles(String id) {
        return register(id, block -> new ColoredTilesBlockItem(block, this.itemSettings));
    }
}

