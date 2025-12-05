package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class FunctionalBlocksGroup {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_FUNCTIONAL_BLOCKS).register((entries) -> {
            entries.accept(AMETHYST_LANTERN);
            entries.accept(REDSTONE_LANTERN);

            entries.accept(LANTERN_BLOCK);
            entries.accept(SOUL_LANTERN_BLOCK);
            entries.accept(AMETHYST_LANTERN_BLOCK);
            entries.accept(REDSTONE_LANTERN_BLOCK);

            entries.accept(REDSTONE_O_LANTERN);
            entries.accept(REDSTONE_SAND);
            BuildingBlocksGroup.addBssw(entries, REDSTONE_BRICKS);

            entries.accept(AMETHYST_LAMP);

            entries.accept(OBSIDIAN_PRESSURE_PLATE);

            entries.accept(GOLDEN_CHAIN);

            entries.accept(BLAZE_LANTERN);

            ColoredGroups.add(entries, BlockusBlocks.STAINED_REDSTONE_LAMP);
            entries.accept(RAINBOW_LAMP);
            entries.accept(RAINBOW_GLOWSTONE);
            entries.accept(GLOWING_OBSIDIAN);

            entries.accept(LARGE_FLOWER_POT);

            entries.accept(TINTED_BEVELED_GLASS);

            entries.accept(WHITE_OAK.sign());
            entries.accept(CHARRED.sign());
            entries.accept(RAW_BAMBOO.sign());
            entries.accept(WHITE_OAK.hangingSign());
            entries.accept(CHARRED.hangingSign());
            entries.accept(RAW_BAMBOO.hangingSign());
            entries.accept(BlockusEntities.WHITE_OAK_BOAT.getItem());
            entries.accept(BlockusEntities.CHARRED_BOAT.getItem());
            entries.accept(BlockusEntities.RAW_BAMBOO_RAFT.getItem());
            entries.accept(BlockusEntities.WHITE_OAK_BOAT.getChestItem());
            entries.accept(BlockusEntities.CHARRED_BOAT.getChestItem());
            entries.accept(BlockusEntities.RAW_BAMBOO_RAFT.getChestItem());
        });
    }
}
