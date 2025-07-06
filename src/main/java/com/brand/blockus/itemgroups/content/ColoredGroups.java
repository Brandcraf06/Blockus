package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.helper.BlockMaps;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.DyeColor;

import java.util.Map;

public class ColoredGroups {

    public static final DyeColor[] COLOR_ORDER = {
        DyeColor.WHITE, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.BLACK,
        DyeColor.BROWN, DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW,
        DyeColor.LIME, DyeColor.GREEN, DyeColor.CYAN, DyeColor.LIGHT_BLUE,
        DyeColor.BLUE, DyeColor.PURPLE, DyeColor.MAGENTA, DyeColor.PINK
    };

    public static void init() {

        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_COLORED_BLOCKS).register((entries) -> {
            for (AsphaltBundle asphaltBundle : AsphaltBundle.values()) {
                for (Block block : asphaltBundle.all()) {
                    entries.add(block);
                }
            }
            entries.add(BlockusBlocks.RAINBOW_ASPHALT);

            for (WoolBundle woolBundle : WoolBundle.values()) {
                for (Block block : woolBundle.all()) {
                    entries.add(block);
                }
            }

            addBSSW(entries, BlockusBlocks.SHINGLES);
            addBSSW(entries, BlockusBlocks.STAINED_SHINGLES);

            entries.add(BlockusBlocks.WHITE_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.GRAY_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.BLACK_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.BROWN_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.RED_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.ORANGE_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.YELLOW_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.LIME_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.GREEN_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.CYAN_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.BLUE_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.PURPLE_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.MAGENTA_GLAZED_TERRACOTTA_PILLAR);
            entries.add(BlockusBlocks.PINK_GLAZED_TERRACOTTA_PILLAR);

            addBSSW(entries, BlockusBlocks.STAINED_STONE_BRICKS);

            for (ConcreteBundle concreteBundle : ConcreteBundle.values()) {
                for (Block block : concreteBundle.all()) {
                    entries.add(block);
                }
            }

            entries.add(BlockusBlocks.WHITE_COLORED_TILES);
            entries.add(BlockusBlocks.LIGHT_GRAY_COLORED_TILES);
            entries.add(BlockusBlocks.GRAY_COLORED_TILES);
            entries.add(BlockusBlocks.BLACK_COLORED_TILES);
            entries.add(BlockusBlocks.BROWN_COLORED_TILES);
            entries.add(BlockusBlocks.RED_COLORED_TILES);
            entries.add(BlockusBlocks.ORANGE_COLORED_TILES);
            entries.add(BlockusBlocks.YELLOW_COLORED_TILES);
            entries.add(BlockusBlocks.LIME_COLORED_TILES);
            entries.add(BlockusBlocks.GREEN_COLORED_TILES);
            entries.add(BlockusBlocks.CYAN_COLORED_TILES);
            entries.add(BlockusBlocks.LIGHT_BLUE_COLORED_TILES);
            entries.add(BlockusBlocks.BLUE_COLORED_TILES);
            entries.add(BlockusBlocks.PURPLE_COLORED_TILES);
            entries.add(BlockusBlocks.MAGENTA_COLORED_TILES);
            entries.add(BlockusBlocks.PINK_COLORED_TILES);
            entries.add(BlockusBlocks.RAINBOW_COLORED_TILES);

            entries.add(BlockusBlocks.WHITE_NEON);
            entries.add(BlockusBlocks.LIGHT_GRAY_NEON);
            entries.add(BlockusBlocks.GRAY_NEON);
            entries.add(BlockusBlocks.BLACK_NEON);
            entries.add(BlockusBlocks.BROWN_NEON);
            entries.add(BlockusBlocks.RED_NEON);
            entries.add(BlockusBlocks.ORANGE_NEON);
            entries.add(BlockusBlocks.YELLOW_NEON);
            entries.add(BlockusBlocks.LIME_NEON);
            entries.add(BlockusBlocks.GREEN_NEON);
            entries.add(BlockusBlocks.CYAN_NEON);
            entries.add(BlockusBlocks.LIGHT_BLUE_NEON);
            entries.add(BlockusBlocks.BLUE_NEON);
            entries.add(BlockusBlocks.PURPLE_NEON);
            entries.add(BlockusBlocks.MAGENTA_NEON);
            entries.add(BlockusBlocks.PINK_NEON);
            entries.add(BlockusBlocks.RAINBOW_NEON);

            entries.add(BlockusBlocks.WHITE_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.LIGHT_GRAY_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.GRAY_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.BLACK_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.BROWN_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.RED_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.ORANGE_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.YELLOW_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.LIME_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.GREEN_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.CYAN_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.LIGHT_BLUE_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.BLUE_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.PURPLE_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.MAGENTA_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.PINK_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK);

            entries.add(BlockusBlocks.WHITE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP);
            entries.add(BlockusBlocks.GRAY_REDSTONE_LAMP);
            entries.add(BlockusBlocks.BROWN_REDSTONE_LAMP);
            entries.add(BlockusBlocks.RED_REDSTONE_LAMP);
            entries.add(BlockusBlocks.ORANGE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.YELLOW_REDSTONE_LAMP);
            entries.add(BlockusBlocks.LIME_REDSTONE_LAMP);
            entries.add(BlockusBlocks.GREEN_REDSTONE_LAMP);
            entries.add(BlockusBlocks.CYAN_REDSTONE_LAMP);
            entries.add(BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.BLUE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.PURPLE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.MAGENTA_REDSTONE_LAMP);
            entries.add(BlockusBlocks.PINK_REDSTONE_LAMP);
            entries.add(BlockusBlocks.RAINBOW_LAMP);

            entries.add(BlockusBlocks.REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.WHITE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.GRAY_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.BROWN_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.RED_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.ORANGE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.YELLOW_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.LIME_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.GREEN_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.CYAN_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.BLUE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.PURPLE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.MAGENTA_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.PINK_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.RAINBOW_LAMP_LIT);

            entries.add(BlockusBlocks.BEVELED_GLASS);
            entries.add(BlockusBlocks.TINTED_BEVELED_GLASS);
            entries.add(BlockusBlocks.WHITE_BEVELED_GLASS);
            entries.add(BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS);
            entries.add(BlockusBlocks.GRAY_BEVELED_GLASS);
            entries.add(BlockusBlocks.BLACK_BEVELED_GLASS);
            entries.add(BlockusBlocks.BROWN_BEVELED_GLASS);
            entries.add(BlockusBlocks.RED_BEVELED_GLASS);
            entries.add(BlockusBlocks.ORANGE_BEVELED_GLASS);
            entries.add(BlockusBlocks.YELLOW_BEVELED_GLASS);
            entries.add(BlockusBlocks.LIME_BEVELED_GLASS);
            entries.add(BlockusBlocks.GREEN_BEVELED_GLASS);
            entries.add(BlockusBlocks.CYAN_BEVELED_GLASS);
            entries.add(BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS);
            entries.add(BlockusBlocks.BLUE_BEVELED_GLASS);
            entries.add(BlockusBlocks.PURPLE_BEVELED_GLASS);
            entries.add(BlockusBlocks.MAGENTA_BEVELED_GLASS);
            entries.add(BlockusBlocks.PINK_BEVELED_GLASS);
            entries.add(BlockusBlocks.RAINBOW_GLASS);
            entries.add(BlockusBlocks.RAINBOW_BEVELED_GLASS);

            entries.add(BlockusBlocks.BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.WHITE_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.GRAY_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.BLACK_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.BROWN_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.RED_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.ORANGE_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.YELLOW_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.LIME_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.GREEN_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.CYAN_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.BLUE_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.PURPLE_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.MAGENTA_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.PINK_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.RAINBOW_GLASS_PANE);
            entries.add(BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE);

            entries.add(BlockusBlocks.RAINBOW_BLOCK);
            addBSSW(entries, BlockusBlocks.RAINBOW_BRICKS);

            entries.add(BlockusBlocks.RAINBOW_GLOWSTONE);
        });

        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_COLORED_TILES).register((entries) -> {
            entries.add(BlockusBlocks.WHITE_COLORED_TILES);
            entries.add(BlockusBlocks.LIGHT_GRAY_COLORED_TILES);
            entries.add(BlockusBlocks.GRAY_COLORED_TILES);
            entries.add(BlockusBlocks.BLACK_COLORED_TILES);
            entries.add(BlockusBlocks.BROWN_COLORED_TILES);
            entries.add(BlockusBlocks.RED_COLORED_TILES);
            entries.add(BlockusBlocks.ORANGE_COLORED_TILES);
            entries.add(BlockusBlocks.YELLOW_COLORED_TILES);
            entries.add(BlockusBlocks.LIME_COLORED_TILES);
            entries.add(BlockusBlocks.GREEN_COLORED_TILES);
            entries.add(BlockusBlocks.CYAN_COLORED_TILES);
            entries.add(BlockusBlocks.LIGHT_BLUE_COLORED_TILES);
            entries.add(BlockusBlocks.BLUE_COLORED_TILES);
            entries.add(BlockusBlocks.PURPLE_COLORED_TILES);
            entries.add(BlockusBlocks.MAGENTA_COLORED_TILES);
            entries.add(BlockusBlocks.PINK_COLORED_TILES);

            for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
                entries.add(coloredTilesVariants.block());
            }

            entries.add(BlockusBlocks.RAINBOW_COLORED_TILES);
        });
    }

    public static void addBSSW(FabricItemGroupEntries entries, BSSWBundle bsswBundle) {
        for (Block block : bsswBundle.all()) {
            entries.add(block);
        }
    }

    public static void addBSSW(FabricItemGroupEntries entries, StainedBSSWBundle stainedBssw) {
        for (DyeColor dyeColor : COLOR_ORDER) {
            addBSSW(entries, stainedBssw.colorMap().get(dyeColor));
        }
    }
}
