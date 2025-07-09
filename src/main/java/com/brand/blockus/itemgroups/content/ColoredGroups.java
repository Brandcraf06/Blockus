package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.helper.BlockOrder;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.util.DyeColor;

import java.util.Collection;

public class ColoredGroups {


    public static void init() {

        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_COLORED_BLOCKS).register((entries) -> {

            add(entries, BlockusBlocks.ASPHALT.all());
            entries.add(BlockusBlocks.RAINBOW_ASPHALT);

            for (WoolBundle woolBundle : WoolBundle.values()) {
                add(entries, woolBundle.all());
            }

            addBSSW(entries, BlockusBlocks.SHINGLES);
            addBSSW(entries, BlockusBlocks.STAINED_SHINGLES);

            add(entries, BlockusBlocks.GLAZED_TERRACOTTA_PILLAR);

            addBSSW(entries, BlockusBlocks.STAINED_STONE_BRICKS);

            for (ConcreteBundle concreteBundle : ConcreteBundle.values()) {
                add(entries, concreteBundle.all());
            }

            add(entries, BlockusBlocks.COLORED_TILES);
            entries.add(BlockusBlocks.RAINBOW_COLORED_TILES);

            add(entries, BlockusBlocks.NEON_BLOCK);
            entries.add(BlockusBlocks.RAINBOW_NEON);

            add(entries, BlockusBlocks.FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK);
            entries.add(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK);

            add(entries, BlockusBlocks.STAINED_REDSTONE_LAMP);
            entries.add(BlockusBlocks.RAINBOW_LAMP);
            entries.add(BlockusBlocks.REDSTONE_LAMP_LIT);
            add(entries, BlockusBlocks.STAINED_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.RAINBOW_LAMP_LIT);

            entries.add(BlockusBlocks.BEVELED_GLASS);
            entries.add(BlockusBlocks.TINTED_BEVELED_GLASS);
            add(entries, BlockusBlocks.STAINED_BEVELED_GLASS);
            entries.add(BlockusBlocks.RAINBOW_GLASS);
            entries.add(BlockusBlocks.RAINBOW_BEVELED_GLASS);

            entries.add(BlockusBlocks.BEVELED_GLASS_PANE);
            add(entries, BlockusBlocks.STAINED_BEVELED_GLASS_PANE);
            entries.add(BlockusBlocks.RAINBOW_GLASS_PANE);
            entries.add(BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE);

            entries.add(BlockusBlocks.RAINBOW_BLOCK);
            addBSSW(entries, BlockusBlocks.RAINBOW_BRICKS);

            entries.add(BlockusBlocks.RAINBOW_GLOWSTONE);
        });

        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_COLORED_TILES).register((entries) -> {
            add(entries, BlockusBlocks.COLORED_TILES);

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
        for (DyeColor dyeColor : BlockOrder.COLOR) {
            addBSSW(entries, stainedBssw.colorMap().get(dyeColor));
        }
    }

    public static void add(FabricItemGroupEntries entries, Collection<Block> blocks) {
        for (Block block : blocks) {
            entries.add(block);
        }
    }

    public static void add(FabricItemGroupEntries entries, StainedBlockBundle stainedBlock) {
        for (DyeColor dyeColor : BlockOrder.COLOR) {
            entries.add(stainedBlock.colorMap().get(dyeColor));
        }
    }
}
