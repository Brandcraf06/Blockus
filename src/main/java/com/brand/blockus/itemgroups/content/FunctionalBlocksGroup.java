package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusEntities;
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

            entries.add(WHITE_OAK.sign());
            entries.add(CHARRED.sign());
            entries.add(RAW_BAMBOO.sign());
            entries.add(WHITE_OAK.hangingSign());
            entries.add(CHARRED.hangingSign());
            entries.add(RAW_BAMBOO.hangingSign());
            entries.add(BlockusEntities.WHITE_OAK_BOAT.getItem());
            entries.add(BlockusEntities.CHARRED_BOAT.getItem());
            entries.add(BlockusEntities.RAW_BAMBOO_RAFT.getItem());
            entries.add(BlockusEntities.WHITE_OAK_BOAT.getChestItem());
            entries.add(BlockusEntities.CHARRED_BOAT.getChestItem());
            entries.add(BlockusEntities.RAW_BAMBOO_RAFT.getChestItem());
        });
    }
}
