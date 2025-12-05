package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class LegacyGroup {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_LEGACY_BLOCKS).register((entries) -> {
            entries.accept(BlockusBlocks.LEGACY_ROSE);
            entries.accept(BlockusBlocks.LEGACY_BLUE_ROSE);
            entries.accept(BlockusBlocks.LEGACY_SAPLING);
            entries.accept(BlockusBlocks.LEGACY_LEAVES);
            entries.accept(BlockusBlocks.LEGACY_LOG);
            entries.accept(BlockusBlocks.LEGACY_PLANKS);
            entries.accept(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK);
            entries.accept(BlockusBlocks.LEGACY_GRASS_BLOCK);
            entries.accept(BlockusBlocks.LEGACY_FIRST_COBBLESTONE);
            entries.accept(BlockusBlocks.LEGACY_COBBLESTONE);
            entries.accept(BlockusBlocks.LEGACY_MOSSY_COBBLESTONE);
            entries.accept(BlockusBlocks.LEGACY_GRAVEL);
            entries.accept(BlockusBlocks.LEGACY_BRICKS);
            entries.accept(BlockusBlocks.LEGACY_CRYING_OBSIDIAN);
            entries.accept(BlockusBlocks.LEGACY_GLOWING_OBSIDIAN);
            entries.accept(BlockusBlocks.LEGACY_GLOWSTONE);
            entries.accept(BlockusBlocks.LEGACY_IRON_BLOCK);
            entries.accept(BlockusBlocks.LEGACY_GOLD_BLOCK);
            entries.accept(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK);
            entries.accept(BlockusBlocks.LEGACY_COAL_BLOCK);
            entries.accept(BlockusBlocks.LEGACY_DIAMOND_BLOCK);
            entries.accept(BlockusBlocks.LEGACY_LAPIS_BLOCK);
            entries.accept(BlockusBlocks.LEGACY_SPONGE);
            entries.accept(BlockusBlocks.LEGACY_STONECUTTER);
            entries.accept(BlockusBlocks.LEGACY_NETHER_REACTOR_CORE);
        });
    }
}
