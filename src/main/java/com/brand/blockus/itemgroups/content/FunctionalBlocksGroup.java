package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.registry.content.bundles.WoodBundle;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class FunctionalBlocksGroup {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_FUNCTIONAL_BLOCKS).register((entries) -> {
            entries.add(AMETHYST_LANTERN);
            entries.add(REDSTONE_LANTERN);

            entries.add(LANTERN_BLOCK);
            entries.add(SOUL_LANTERN_BLOCK);
            entries.add(AMETHYST_LANTERN_BLOCK);
            entries.add(REDSTONE_LANTERN_BLOCK);

            entries.add(REDSTONE_O_LANTERN);
            entries.add(REDSTONE_SAND);
            BuildingBlocksGroup.addBssw(entries, REDSTONE_BRICKS);

            entries.add(AMETHYST_LAMP);

            entries.add(OBSIDIAN_PRESSURE_PLATE);

            entries.add(GOLDEN_CHAIN);

            entries.add(BLAZE_LANTERN);

            ColoredGroups.add(entries, BlockusBlocks.STAINED_REDSTONE_LAMP);
            entries.add(RAINBOW_LAMP);
            entries.add(RAINBOW_GLOWSTONE);
            entries.add(GLOWING_OBSIDIAN);

            entries.add(LARGE_FLOWER_POT);

            entries.add(TINTED_BEVELED_GLASS);

            for (WoodBundle woodBundle : WoodBundle.values()) {
                entries.add(woodBundle.shelf());
            }
            for (WoodBundle woodBundle : WoodBundle.values()) {
                entries.add(woodBundle.sign());
                entries.add(woodBundle.hangingSign());
            }
            entries.add(BlockusEntities.WHITE_OAK_BOAT);
            entries.add(BlockusEntities.WHITE_OAK_CHEST_BOAT);
            entries.add(BlockusEntities.RAW_BAMBOO_RAFT);
            entries.add(BlockusEntities.RAW_BAMBOO_CHEST_RAFT);
            entries.add(BlockusEntities.CHARRED_BOAT);
            entries.add(BlockusEntities.CHARRED_CHEST_BOAT);
        });
    }
}
