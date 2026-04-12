package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.registry.content.bundles.WoodBundle;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class FunctionalBlocksGroup {

    public static void init() {
        CreativeModeTabEvents.modifyOutputEvent(BlockusItemGroups.BLOCKUS_FUNCTIONAL_BLOCKS).register((entries) -> {
            entries.accept(AMETHYST_LANTERN);
            entries.accept(REDSTONE_LANTERN);

            entries.accept(LANTERN_BLOCK);
            entries.accept(SOUL_LANTERN_BLOCK);
            entries.accept(AMETHYST_LANTERN_BLOCK);
            entries.accept(REDSTONE_LANTERN_BLOCK);
            COPPER_LANTERN_BLOCK.forEach(entries::accept);

            entries.accept(REDSTONE_O_LANTERN);
            entries.accept(REDSTONE_SAND);
            BuildingBlocksGroup.addBSSW(entries, REDSTONE_BRICKS);

            entries.accept(AMETHYST_LAMP);

            entries.accept(OBSIDIAN_PRESSURE_PLATE);

            entries.accept(GOLDEN_CHAIN);

            entries.accept(BLAZE_LANTERN);

            ColoredGroups.addDyed(entries, BlockusBlocks.DYED_REDSTONE_LAMP);
            entries.accept(RAINBOW_LAMP);
            entries.accept(RAINBOW_GLOWSTONE);
            entries.accept(GLOWING_OBSIDIAN);

            entries.accept(LARGE_FLOWER_POT);

            entries.accept(TINTED_BEVELED_GLASS);

            for (WoodBundle woodBundle : WoodBundle.values()) {
                entries.accept(woodBundle.shelf());
            }
            for (WoodBundle woodBundle : WoodBundle.values()) {
                entries.accept(woodBundle.sign());
                entries.accept(woodBundle.hangingSign());
            }
            entries.accept(BlockusItems.WHITE_OAK_BOAT);
            entries.accept(BlockusItems.WHITE_OAK_CHEST_BOAT);
            entries.accept(BlockusItems.RAW_BAMBOO_RAFT);
            entries.accept(BlockusItems.RAW_BAMBOO_CHEST_RAFT);
            entries.accept(BlockusItems.CHARRED_BOAT);
            entries.accept(BlockusItems.CHARRED_CHEST_BOAT);
        });
    }
}
