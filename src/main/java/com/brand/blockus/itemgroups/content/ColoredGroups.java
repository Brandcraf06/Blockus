package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.AsphaltBundle;
import com.brand.blockus.registry.content.bundles.ColoredTilesBundle;
import com.brand.blockus.registry.content.bundles.ConcreteBundle;
import com.brand.blockus.registry.content.bundles.WoolBundle;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class ColoredGroups {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_COLORED_BLOCKS).register((entries) -> {
            for (AsphaltBundle asphaltBundle : AsphaltBundle.values()) {
                entries.add(asphaltBundle.block);
                entries.add(asphaltBundle.stairs);
                entries.add(asphaltBundle.slab);
            }
            entries.add(BlockusBlocks.RAINBOW_ASPHALT);

            for (WoolBundle woolBundle : WoolBundle.values()) {
                entries.add(woolBundle.block);
                entries.add(woolBundle.stairs);
                entries.add(woolBundle.slab);
                entries.add(woolBundle.carpet);
            }

            entries.add(BlockusBlocks.SHINGLES.block);
            entries.add(BlockusBlocks.WHITE_SHINGLES.block);
            entries.add(BlockusBlocks.LIGHT_GRAY_SHINGLES.block);
            entries.add(BlockusBlocks.GRAY_SHINGLES.block);
            entries.add(BlockusBlocks.BLACK_SHINGLES.block);
            entries.add(BlockusBlocks.BROWN_SHINGLES.block);
            entries.add(BlockusBlocks.RED_SHINGLES.block);
            entries.add(BlockusBlocks.ORANGE_SHINGLES.block);
            entries.add(BlockusBlocks.YELLOW_SHINGLES.block);
            entries.add(BlockusBlocks.LIME_SHINGLES.block);
            entries.add(BlockusBlocks.GREEN_SHINGLES.block);
            entries.add(BlockusBlocks.CYAN_SHINGLES.block);
            entries.add(BlockusBlocks.LIGHT_BLUE_SHINGLES.block);
            entries.add(BlockusBlocks.BLUE_SHINGLES.block);
            entries.add(BlockusBlocks.PURPLE_SHINGLES.block);
            entries.add(BlockusBlocks.MAGENTA_SHINGLES.block);
            entries.add(BlockusBlocks.PINK_SHINGLES.block);
            entries.add(BlockusBlocks.SHINGLES.stairs);
            entries.add(BlockusBlocks.WHITE_SHINGLES.stairs);
            entries.add(BlockusBlocks.LIGHT_GRAY_SHINGLES.stairs);
            entries.add(BlockusBlocks.GRAY_SHINGLES.stairs);
            entries.add(BlockusBlocks.BLACK_SHINGLES.stairs);
            entries.add(BlockusBlocks.BROWN_SHINGLES.stairs);
            entries.add(BlockusBlocks.RED_SHINGLES.stairs);
            entries.add(BlockusBlocks.ORANGE_SHINGLES.stairs);
            entries.add(BlockusBlocks.YELLOW_SHINGLES.stairs);
            entries.add(BlockusBlocks.LIME_SHINGLES.stairs);
            entries.add(BlockusBlocks.GREEN_SHINGLES.stairs);
            entries.add(BlockusBlocks.CYAN_SHINGLES.stairs);
            entries.add(BlockusBlocks.LIGHT_BLUE_SHINGLES.stairs);
            entries.add(BlockusBlocks.BLUE_SHINGLES.stairs);
            entries.add(BlockusBlocks.PURPLE_SHINGLES.stairs);
            entries.add(BlockusBlocks.MAGENTA_SHINGLES.stairs);
            entries.add(BlockusBlocks.PINK_SHINGLES.stairs);
            entries.add(BlockusBlocks.SHINGLES.slab);
            entries.add(BlockusBlocks.WHITE_SHINGLES.slab);
            entries.add(BlockusBlocks.LIGHT_GRAY_SHINGLES.slab);
            entries.add(BlockusBlocks.GRAY_SHINGLES.slab);
            entries.add(BlockusBlocks.BLACK_SHINGLES.slab);
            entries.add(BlockusBlocks.BROWN_SHINGLES.slab);
            entries.add(BlockusBlocks.RED_SHINGLES.slab);
            entries.add(BlockusBlocks.ORANGE_SHINGLES.slab);
            entries.add(BlockusBlocks.YELLOW_SHINGLES.slab);
            entries.add(BlockusBlocks.LIME_SHINGLES.slab);
            entries.add(BlockusBlocks.GREEN_SHINGLES.slab);
            entries.add(BlockusBlocks.CYAN_SHINGLES.slab);
            entries.add(BlockusBlocks.LIGHT_BLUE_SHINGLES.slab);
            entries.add(BlockusBlocks.BLUE_SHINGLES.slab);
            entries.add(BlockusBlocks.PURPLE_SHINGLES.slab);
            entries.add(BlockusBlocks.MAGENTA_SHINGLES.slab);
            entries.add(BlockusBlocks.PINK_SHINGLES.slab);

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

            entries.add(BlockusBlocks.WHITE_STONE_BRICKS.block);
            entries.add(BlockusBlocks.GRAY_STONE_BRICKS.block);
            entries.add(BlockusBlocks.BLACK_STONE_BRICKS.block);
            entries.add(BlockusBlocks.BROWN_STONE_BRICKS.block);
            entries.add(BlockusBlocks.RED_STONE_BRICKS.block);
            entries.add(BlockusBlocks.ORANGE_STONE_BRICKS.block);
            entries.add(BlockusBlocks.YELLOW_STONE_BRICKS.block);
            entries.add(BlockusBlocks.LIME_STONE_BRICKS.block);
            entries.add(BlockusBlocks.GREEN_STONE_BRICKS.block);
            entries.add(BlockusBlocks.CYAN_STONE_BRICKS.block);
            entries.add(BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.block);
            entries.add(BlockusBlocks.BLUE_STONE_BRICKS.block);
            entries.add(BlockusBlocks.PURPLE_STONE_BRICKS.block);
            entries.add(BlockusBlocks.MAGENTA_STONE_BRICKS.block);
            entries.add(BlockusBlocks.PINK_STONE_BRICKS.block);
            entries.add(BlockusBlocks.WHITE_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.GRAY_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.BLACK_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.BROWN_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.RED_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.ORANGE_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.YELLOW_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.LIME_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.GREEN_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.CYAN_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.BLUE_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.PURPLE_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.MAGENTA_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.PINK_STONE_BRICKS.stairs);
            entries.add(BlockusBlocks.WHITE_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.GRAY_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.BLACK_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.BROWN_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.RED_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.ORANGE_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.YELLOW_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.LIME_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.GREEN_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.CYAN_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.BLUE_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.PURPLE_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.MAGENTA_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.PINK_STONE_BRICKS.slab);
            entries.add(BlockusBlocks.WHITE_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.GRAY_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.BLACK_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.BROWN_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.RED_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.ORANGE_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.YELLOW_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.LIME_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.GREEN_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.CYAN_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.BLUE_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.PURPLE_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.MAGENTA_STONE_BRICKS.wall);
            entries.add(BlockusBlocks.PINK_STONE_BRICKS.wall);

            for (ConcreteBundle concreteBundle : ConcreteBundle.values()) {
                entries.add(concreteBundle.block);
                entries.add(concreteBundle.stairs);
                entries.add(concreteBundle.slab);
                entries.add(concreteBundle.wall);
                entries.add(concreteBundle.chiseled);
                entries.add(concreteBundle.pillar);
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
            entries.add(BlockusBlocks.RAINBOW_BRICKS.block);
            entries.add(BlockusBlocks.RAINBOW_BRICKS.stairs);
            entries.add(BlockusBlocks.RAINBOW_BRICKS.slab);
            entries.add(BlockusBlocks.RAINBOW_BRICKS.wall);

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
                entries.add(coloredTilesVariants.block);
            }

            entries.add(BlockusBlocks.RAINBOW_COLORED_TILES);
        });
    }
}
