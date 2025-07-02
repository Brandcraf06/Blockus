package com.brand.blockus.utils.helper;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.blockitems.LegacyBlockItem;
import com.brand.blockus.blocks.blockitems.NetherStarBlockItem;
import com.brand.blockus.utils.BlockChecker;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockBuilder {
    private static final Function<AbstractBlock.Settings, Block> DEFAULT_FACTORY = Block::new;
    private static final Supplier<Item.Settings> DEFAULT_ITEM_SETTINGS = () -> new Item.Settings().useBlockPrefixedTranslationKey();

    private Function<AbstractBlock.Settings, Block> factory = DEFAULT_FACTORY;
    private AbstractBlock.Settings settings;

    private Item.Settings itemSettings = DEFAULT_ITEM_SETTINGS.get();

    public BlockBuilder(Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        this.factory = factory;
        this.settings = settings;
    }

    public BlockBuilder(AbstractBlock.Settings settings) {
        this.settings = settings;
    }

    public BlockBuilder(Block block) {
        this.settings = AbstractBlock.Settings.copy(block);
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

    public Block register(String id, Function<Block, Item> itemFactory) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Blockus.id(id));
        if (this.factory == null) {
            throw new IllegalStateException("Cannot register block: factory is not set!");
        }
        var block = this.factory.apply(this.settings.registryKey(key));
        Registry.register(Registries.BLOCK, key, block);
        if (this.itemSettings instanceof Item.Settings) {
            var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, key.getValue());
            Registry.register(Registries.ITEM, itemRegistryKey, itemFactory.apply(block)
            );
        }

        return block;
    }

    public Block register(String id) {
        return register(id, block -> {
            var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, Blockus.id(id));
            Item.Settings itemSettings = this.itemSettings;
            if (BlockChecker.isNetherite(id) && itemSettings instanceof Item.Settings settings) {
                itemSettings = settings.fireproof();
            }
            return new BlockItem(block, itemSettings.registryKey(itemRegistryKey));
        });
    }

    public Block registerNetherStarBlock(String id) {
        return register(id, block -> {
            var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, Blockus.id(id));
            return new NetherStarBlockItem(block, this.itemSettings.registryKey(itemRegistryKey).rarity(Rarity.UNCOMMON));
        });
    }

    public Block registerLegacy(String id, String version) {
        return register(id, block -> {
            var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, Blockus.id(id));
            return new LegacyBlockItem(block, this.itemSettings.registryKey(itemRegistryKey), version);
        });
    }
}
