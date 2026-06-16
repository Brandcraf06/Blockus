package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.BSSWBundle;
import com.brand.blockus.registry.content.bundles.ColoredTilesBundle;
import com.brand.blockus.registry.content.bundles.DyedBSSWBundle;
import com.brand.blockus.utils.blocks.ColorBlockItemCollection;
import com.brand.blockus.utils.helper.BlockOrder;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.world.level.block.Block;

import java.util.Collection;

public class ColoredGroups {


    public static void init() {

        CreativeModeTabEvents.modifyOutputEvent(BlockusItemGroups.BLOCKUS_COLORED_BLOCKS).register((entries) -> {

            for (ColorBlockItemCollection collection : BlockusBlocks.ASPHALT.all()) {
                addDyed(entries, collection);
            }
            entries.accept(BlockusBlocks.RAINBOW_ASPHALT);

            entries.accept(BlockusBlocks.RAINBOW_WOOL);
            entries.accept(BlockusBlocks.RAINBOW_CARPET);
            entries.accept(BlockusBlocks.RAINBOW_BED);
            for (ColorBlockItemCollection collection : BlockusBlocks.PATTERNED_WOOL.all()) {
                addDyed(entries, collection);
            }

            addBSSW(entries, BlockusBlocks.SHINGLES);
            addDyedBSSW(entries, BlockusBlocks.DYED_SHINGLES);

            addDyed(entries, BlockusBlocks.GLAZED_TERRACOTTA_PILLAR);

            addDyedBSSW(entries, BlockusBlocks.DYED_STONE_BRICKS);

            for (ColorBlockItemCollection collection : BlockusBlocks.CONCRETE_BRICKS.all()) {
                addDyed(entries, collection);
            }

            addDyed(entries, BlockusBlocks.COLORED_TILES);
            entries.accept(BlockusBlocks.RAINBOW_COLORED_TILES);

            addDyed(entries, BlockusBlocks.NEON);
            entries.accept(BlockusBlocks.RAINBOW_NEON);

            addDyed(entries, BlockusBlocks.FUTURNEO_BLOCK);
            entries.accept(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK);
            entries.accept(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK);

            addDyed(entries, BlockusBlocks.DYED_REDSTONE_LAMP);
            entries.accept(BlockusBlocks.RAINBOW_LAMP);
            entries.accept(BlockusBlocks.LIT_REDSTONE_LAMP);
            addDyed(entries, BlockusBlocks.DYED_LIT_REDSTONE_LAMP);
            entries.accept(BlockusBlocks.LIT_RAINBOW_LAMP);

            entries.accept(BlockusBlocks.BEVELED_GLASS);
            entries.accept(BlockusBlocks.TINTED_BEVELED_GLASS);
            addDyed(entries, BlockusBlocks.STAINED_BEVELED_GLASS);
            entries.accept(BlockusBlocks.RAINBOW_GLASS);
            entries.accept(BlockusBlocks.RAINBOW_BEVELED_GLASS);

            entries.accept(BlockusBlocks.BEVELED_GLASS_PANE);
            addDyed(entries, BlockusBlocks.STAINED_BEVELED_GLASS_PANE);
            entries.accept(BlockusBlocks.RAINBOW_GLASS_PANE);
            entries.accept(BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE);

            entries.accept(BlockusBlocks.RAINBOW_BLOCK);
            addBSSW(entries, BlockusBlocks.RAINBOW_BRICKS);

            entries.accept(BlockusBlocks.RAINBOW_GLOWSTONE);
        });

        CreativeModeTabEvents.modifyOutputEvent(BlockusItemGroups.BLOCKUS_COLORED_TILES).register((entries) -> {
            addDyed(entries, BlockusBlocks.COLORED_TILES);

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

    public static void addDyed(FabricCreativeModeTabOutput entries, ColorBlockItemCollection block) {
        BlockOrder.COLOR.forEach(color -> entries.accept(block.items().pick(color)));
    }

    public static void addDyedBSSW(FabricCreativeModeTabOutput entries, DyedBSSWBundle block) {
        for (ColorBlockItemCollection collection : block.all()) {
            addDyed(entries, collection);
        }
    }

    public static void add(FabricCreativeModeTabOutput entries, Collection<Block> blocks) {
        for (Block block : blocks) {
            entries.accept(block);
        }
    }
}
