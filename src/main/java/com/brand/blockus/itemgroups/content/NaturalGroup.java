package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public class NaturalGroup {

    public static void init() {
        CreativeModeTabEvents.modifyOutputEvent(BlockusItemGroups.BLOCKUS_NATURAL).register((entries) -> {
            entries.accept(BlockusBlocks.PATH);
            entries.accept(BlockusBlocks.LIMESTONE.block());
            entries.accept(BlockusBlocks.MARBLE.block());
            entries.accept(BlockusBlocks.BLUESTONE.block());
            entries.accept(BlockusBlocks.VIRIDITE.block());

            entries.accept(BlockusBlocks.WHITE_OAK_LOG);
            entries.accept(BlockusBlocks.WHITE_OAK_SAPLING);
            entries.accept(BlockusBlocks.WHITE_OAK_LEAVES);

            entries.accept(BlockusBlocks.OAK_HEDGE);
            entries.accept(BlockusBlocks.SPRUCE_HEDGE);
            entries.accept(BlockusBlocks.BIRCH_HEDGE);
            entries.accept(BlockusBlocks.JUNGLE_HEDGE);
            entries.accept(BlockusBlocks.ACACIA_HEDGE);
            entries.accept(BlockusBlocks.DARK_OAK_HEDGE);
            entries.accept(BlockusBlocks.MANGROVE_HEDGE);
            entries.accept(BlockusBlocks.CHERRY_HEDGE);
            entries.accept(BlockusBlocks.PALE_OAK_HEDGE);
            entries.accept(BlockusBlocks.RED_POPLAR_HEDGE);
            entries.accept(BlockusBlocks.ORANGE_POPLAR_HEDGE);
            entries.accept(BlockusBlocks.YELLOW_POPLAR_HEDGE);
            entries.accept(BlockusBlocks.WHITE_OAK_HEDGE);
            entries.accept(BlockusBlocks.CRIMSON_HEDGE);
            entries.accept(BlockusBlocks.WARPED_HEDGE);
            entries.accept(BlockusBlocks.AZALEA_HEDGE);
            entries.accept(BlockusBlocks.FLOWERING_AZALEA_HEDGE);
            entries.accept(BlockusBlocks.MOSS_HEDGE);
            entries.accept(BlockusBlocks.PALE_MOSS_HEDGE);

            entries.accept(BlockusBlocks.SOUL_O_LANTERN);
            entries.accept(BlockusBlocks.COPPER_JACK_O_LANTERN);
            entries.accept(BlockusBlocks.REDSTONE_O_LANTERN);

            entries.accept(BlockusBlocks.RAINBOW_ROSE);
            entries.accept(BlockusBlocks.RAINBOW_PETALS);

        });
    }
}
