package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class LegacyGroup {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_LEGACY_BLOCKS).register((entries) -> {
            entries.add(BlockusBlocks.LEGACY_ROSE);
            entries.add(BlockusBlocks.LEGACY_BLUE_ROSE);
            entries.add(BlockusBlocks.LEGACY_SAPLING);
            entries.add(BlockusBlocks.LEGACY_LEAVES);
            entries.add(BlockusBlocks.LEGACY_LOG);
            entries.add(BlockusBlocks.LEGACY_PLANKS);
            entries.add(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK);
            entries.add(BlockusBlocks.LEGACY_GRASS_BLOCK);
            entries.add(BlockusBlocks.LEGACY_FIRST_COBBLESTONE);
            entries.add(BlockusBlocks.LEGACY_COBBLESTONE);
            entries.add(BlockusBlocks.LEGACY_MOSSY_COBBLESTONE);
            entries.add(BlockusBlocks.LEGACY_GRAVEL);
            entries.add(BlockusBlocks.LEGACY_BRICKS);
            entries.add(BlockusBlocks.LEGACY_CRYING_OBSIDIAN);
            entries.add(BlockusBlocks.LEGACY_GLOWING_OBSIDIAN);
            entries.add(BlockusBlocks.LEGACY_GLOWSTONE);
            entries.add(BlockusBlocks.LEGACY_IRON_BLOCK);
            entries.add(BlockusBlocks.LEGACY_GOLD_BLOCK);
            entries.add(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK);
            entries.add(BlockusBlocks.LEGACY_COAL_BLOCK);
            entries.add(BlockusBlocks.LEGACY_DIAMOND_BLOCK);
            entries.add(BlockusBlocks.LEGACY_LAPIS_BLOCK);
            entries.add(BlockusBlocks.LEGACY_SPONGE);
            entries.add(BlockusBlocks.LEGACY_STONECUTTER);
            entries.add(BlockusBlocks.LEGACY_NETHER_REACTOR_CORE);
        });
    }
}
