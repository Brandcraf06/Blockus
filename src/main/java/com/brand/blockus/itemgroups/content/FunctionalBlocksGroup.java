package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.registry.content.bundles.BSSWBundle;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
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

            entries.add(WHITE_REDSTONE_LAMP);
            entries.add(LIGHT_GRAY_REDSTONE_LAMP);
            entries.add(GRAY_REDSTONE_LAMP);
            entries.add(BROWN_REDSTONE_LAMP);
            entries.add(RED_REDSTONE_LAMP);
            entries.add(ORANGE_REDSTONE_LAMP);
            entries.add(YELLOW_REDSTONE_LAMP);
            entries.add(LIME_REDSTONE_LAMP);
            entries.add(GREEN_REDSTONE_LAMP);
            entries.add(CYAN_REDSTONE_LAMP);
            entries.add(LIGHT_BLUE_REDSTONE_LAMP);
            entries.add(BLUE_REDSTONE_LAMP);
            entries.add(PURPLE_REDSTONE_LAMP);
            entries.add(MAGENTA_REDSTONE_LAMP);
            entries.add(PINK_REDSTONE_LAMP);
            entries.add(RAINBOW_LAMP);
            entries.add(RAINBOW_GLOWSTONE);
            entries.add(GLOWING_OBSIDIAN);

            entries.add(LARGE_FLOWER_POT);

            entries.add(TINTED_BEVELED_GLASS);

            entries.add(WHITE_OAK.sign);
            entries.add(CHARRED.sign);
            entries.add(RAW_BAMBOO.sign);
            entries.add(WHITE_OAK.hanging_sign);
            entries.add(CHARRED.hanging_sign);
            entries.add(RAW_BAMBOO.hanging_sign);
            entries.add(BlockusEntities.WHITE_OAK_BOAT.getItem());
            entries.add(BlockusEntities.CHARRED_BOAT.getItem());
            entries.add(BlockusEntities.RAW_BAMBOO_RAFT.getItem());
            entries.add(BlockusEntities.WHITE_OAK_BOAT.getChestItem());
            entries.add(BlockusEntities.CHARRED_BOAT.getChestItem());
            entries.add(BlockusEntities.RAW_BAMBOO_RAFT.getChestItem());
        });
    }

    public static void addBSSW(FabricItemGroupEntries entries, BSSWBundle BSSWBundle) {
        entries.add(BSSWBundle.block);
        entries.add(BSSWBundle.stairs);
        entries.add(BSSWBundle.slab);
        if (BSSWBundle.wall != null) {
            entries.add(BSSWBundle.wall);
        }
    }
}
