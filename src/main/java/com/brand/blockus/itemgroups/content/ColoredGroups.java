package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.helper.BlockOrder;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.Collection;

public class ColoredGroups {


    public static void init() {

        CreativeModeTabEvents.modifyOutputEvent(BlockusItemGroups.BLOCKUS_COLORED_BLOCKS).register((entries) -> {

            add(entries, BlockusBlocks.ASPHALT.all());
            entries.accept(BlockusBlocks.RAINBOW_ASPHALT);

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
            entries.accept(BlockusBlocks.RAINBOW_COLORED_TILES);

            add(entries, BlockusBlocks.NEON_BLOCK);
            entries.accept(BlockusBlocks.RAINBOW_NEON);

            add(entries, BlockusBlocks.FUTURNEO_BLOCK);
            entries.accept(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK);
            entries.accept(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK);

            add(entries, BlockusBlocks.STAINED_REDSTONE_LAMP);
            entries.accept(BlockusBlocks.RAINBOW_LAMP);
            entries.accept(BlockusBlocks.LIT_REDSTONE_LAMP);
            add(entries, BlockusBlocks.STAINED_REDSTONE_LAMP_LIT);
            entries.accept(BlockusBlocks.LIT_RAINBOW_LAMP);

            entries.accept(BlockusBlocks.BEVELED_GLASS);
            entries.accept(BlockusBlocks.TINTED_BEVELED_GLASS);
            add(entries, BlockusBlocks.STAINED_BEVELED_GLASS);
            entries.accept(BlockusBlocks.RAINBOW_GLASS);
            entries.accept(BlockusBlocks.RAINBOW_BEVELED_GLASS);

            entries.accept(BlockusBlocks.BEVELED_GLASS_PANE);
            add(entries, BlockusBlocks.STAINED_BEVELED_GLASS_PANE);
            entries.accept(BlockusBlocks.RAINBOW_GLASS_PANE);
            entries.accept(BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE);

            entries.accept(BlockusBlocks.RAINBOW_BLOCK);
            addBSSW(entries, BlockusBlocks.RAINBOW_BRICKS);

            entries.accept(BlockusBlocks.RAINBOW_GLOWSTONE);
        });

        CreativeModeTabEvents.modifyOutputEvent(BlockusItemGroups.BLOCKUS_COLORED_TILES).register((entries) -> {
            add(entries, BlockusBlocks.COLORED_TILES);

            for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
                entries.accept(coloredTilesVariants.block());
            }

            entries.accept(BlockusBlocks.RAINBOW_COLORED_TILES);
        });
    }

    public static void addBSSW(FabricCreativeModeTabOutput entries, BSSWBundle bsswBundle) {
        for (Block block : bsswBundle.all()) {
            entries.accept(block);
        }
    }

    public static void addBSSW(FabricCreativeModeTabOutput entries, StainedBSSWBundle stainedBssw) {
        for (DyeColor dyeColor : BlockOrder.COLOR) {
            addBSSW(entries, stainedBssw.colorMap().get(dyeColor));
        }
    }

    public static void add(FabricCreativeModeTabOutput entries, Collection<Block> blocks) {
        for (Block block : blocks) {
            entries.accept(block);
        }
    }

    public static void add(FabricCreativeModeTabOutput entries, StainedBlockBundle stainedBlock) {
        for (DyeColor dyeColor : BlockOrder.COLOR) {
            entries.accept(stainedBlock.colorMap().get(dyeColor));
        }
    }
}
