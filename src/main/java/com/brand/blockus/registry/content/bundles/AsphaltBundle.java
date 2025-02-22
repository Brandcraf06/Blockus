package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.blocks.blockitems.AsphaltBlockItem;
import com.brand.blockus.utils.BlockFactory;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;
import java.util.function.Function;

public class AsphaltBundle {
    public static final ArrayList<AsphaltBundle> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;

    public AsphaltBundle(DyeColor color) {
        String type = color.getId() + "_asphalt";
        String type2 = type.replace("black_asphalt", "asphalt");

        Block.Settings blockSettings = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASEDRUM).strength(1.5f, 6.0f).requiresTool();

        this.block = register(type2, AsphaltBlock::new, blockSettings);
        this.slab = register(type2 + "_slab", AsphaltSlab::new, AbstractBlock.Settings.copy(block));
        this.stairs = register(type2 + "_stairs", (settings) -> new AsphaltStairs(block.getDefaultState(), settings), AbstractBlock.Settings.copy(block));

        LIST.add(this);
    }

    public static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Blockus.id(id));
        Block block = BlockFactory.registerNoItem(id, factory, blockSettings);
        var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, key.getValue());
        Registry.register(Registries.ITEM, itemRegistryKey, new AsphaltBlockItem(block, new Item.Settings().registryKey(itemRegistryKey).useBlockPrefixedTranslationKey()));
        return block;
    }

    public static ArrayList<AsphaltBundle> values() {
        return LIST;
    }
}
