package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.ColoredTilesBlock;
import com.brand.blockus.blocks.blockitems.ColoredTilesBlockItem;
import com.brand.blockus.utils.BlockFactory;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Util;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;

public class ColoredTilesBundle {
    private static final ArrayList<ColoredTilesBundle> LIST = new ArrayList<>();
    public final Block block;
    public final Block tile1;
    public final Block tile2;

    public ColoredTilesBundle(Block tile1, Block tile2) {
        String type = getColor(tile1) + "_" + getColor(tile2) + "_colored_tiles";
        this.block = register(type, (settings) -> new ColoredTilesBlock(tile1, tile2, settings), BlockFactory.createCopy(tile2));
        this.tile1 = tile1;
        this.tile2 = tile2;
        LIST.add(this);
    }

    public static String getColor(Block block) {
        return Registries.BLOCK.getId(block).getPath().replace("_concrete", "");
    }

    public static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Blockus.id(id));
        Block block = BlockFactory.registerNoItem(id, factory, blockSettings);
        var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, key.getValue());
        Registry.register(Registries.ITEM, itemRegistryKey, new ColoredTilesBlockItem(block, new Item.Settings().registryKey(itemRegistryKey).translationKey(Util.createTranslationKey("block", Blockus.id("colored_tiles")))));
        return block;
    }

    public static ArrayList<ColoredTilesBundle> values() {
        return LIST;
    }

    private static final Map<Block, Block[]> tilePairs = Map.ofEntries(
        Map.entry(Blocks.WHITE_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BLACK_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.RED_CONCRETE,
            Blocks.ORANGE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.LIME_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.CYAN_CONCRETE,
            Blocks.LIGHT_BLUE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.PINK_CONCRETE
        }),
        Map.entry(Blocks.BLACK_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.RED_CONCRETE,
            Blocks.ORANGE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.LIME_CONCRETE, Blocks.GREEN_CONCRETE,
            Blocks.CYAN_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.PURPLE_CONCRETE,
            Blocks.MAGENTA_CONCRETE, Blocks.PINK_CONCRETE
        }),
        Map.entry(Blocks.RED_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.YELLOW_CONCRETE,
            Blocks.LIME_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.BLUE_CONCRETE,
            Blocks.PURPLE_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.PINK_CONCRETE
        }),
        Map.entry(Blocks.BLUE_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.YELLOW_CONCRETE,
            Blocks.LIME_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.PURPLE_CONCRETE,
            Blocks.MAGENTA_CONCRETE, Blocks.PINK_CONCRETE
        }),
        Map.entry(Blocks.LIGHT_BLUE_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.YELLOW_CONCRETE,
            Blocks.LIME_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.PURPLE_CONCRETE,
            Blocks.MAGENTA_CONCRETE, Blocks.PINK_CONCRETE
        }),
        Map.entry(Blocks.GREEN_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.YELLOW_CONCRETE,
            Blocks.LIME_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.PINK_CONCRETE
        }),
        Map.entry(Blocks.LIME_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.YELLOW_CONCRETE,
            Blocks.CYAN_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.PINK_CONCRETE
        }),
        Map.entry(Blocks.YELLOW_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.ORANGE_CONCRETE,
            Blocks.CYAN_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.PINK_CONCRETE
        }),
        Map.entry(Blocks.PINK_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.ORANGE_CONCRETE,
            Blocks.CYAN_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.MAGENTA_CONCRETE
        }),
        Map.entry(Blocks.PURPLE_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.ORANGE_CONCRETE,
            Blocks.CYAN_CONCRETE, Blocks.MAGENTA_CONCRETE
        }),
        Map.entry(Blocks.MAGENTA_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.CYAN_CONCRETE
        }),
        Map.entry(Blocks.ORANGE_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.CYAN_CONCRETE
        }),
        Map.entry(Blocks.CYAN_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BROWN_CONCRETE
        }),
        Map.entry(Blocks.BROWN_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE, Blocks.GRAY_CONCRETE
        }),
        Map.entry(Blocks.GRAY_CONCRETE, new Block[]{
            Blocks.LIGHT_GRAY_CONCRETE
        })
    );

    public static ColoredTilesBundle get(Block tile1, Block tile2) {
        for (ColoredTilesBundle bundle : LIST) {
            if (bundle.tile1 == tile1 && bundle.tile2 == tile2) {
                return bundle;
            }
        }
        return null;
    }

    static {
        tilePairs.forEach((tile1, tile2List) -> {
            for (Block tile2 : tile2List) {
                new ColoredTilesBundle(tile1, tile2);
            }
        });
    }
}
