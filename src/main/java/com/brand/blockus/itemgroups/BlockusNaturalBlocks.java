package com.brand.blockus.itemgroups;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

public class BlockusNaturalBlocks {

    private static final ItemGroup BLOCKUS_NATURAL_BLOCKS = new FabricItemGroup(new Identifier(Blockus.MOD_ID, "blockus_nature")) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockusBlocks.OAK_SMALL_HEDGE);
        }

        @Override
        protected void addItems(FeatureSet enabledFeatures, Entries entries, boolean opItems) {

            entries.add(BlockusBlocks.PATH);
            entries.add(BlockusBlocks.LIMESTONE.block);
            entries.add(BlockusBlocks.MARBLE.block);
            entries.add(BlockusBlocks.BLUESTONE.block);
            entries.add(BlockusBlocks.VIRIDITE.block);

            entries.add(BlockusBlocks.WHITE_OAK_LOG);
            entries.add(BlockusBlocks.WHITE_OAK_SAPLING);
            entries.add(BlockusBlocks.WHITE_OAK_LEAVES);

            entries.add(BlockusBlocks.OAK_SMALL_HEDGE);
            entries.add(BlockusBlocks.SPRUCE_SMALL_HEDGE);
            entries.add(BlockusBlocks.BIRCH_SMALL_HEDGE);
            entries.add(BlockusBlocks.JUNGLE_SMALL_HEDGE);
            entries.add(BlockusBlocks.ACACIA_SMALL_HEDGE);
            entries.add(BlockusBlocks.DARK_OAK_SMALL_HEDGE);
            entries.add(BlockusBlocks.MANGROVE_SMALL_HEDGE);
            entries.add(BlockusBlocks.WHITE_OAK_SMALL_HEDGE);
            entries.add(BlockusBlocks.CRIMSON_SMALL_HEDGE);
            entries.add(BlockusBlocks.WARPED_SMALL_HEDGE);
            entries.add(BlockusBlocks.AZALEA_SMALL_HEDGE);
            entries.add(BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE);
            entries.add(BlockusBlocks.MOSS_SMALL_HEDGE);

            entries.add(BlockusBlocks.SOUL_O_LANTERN);
            entries.add(BlockusBlocks.REDSTONE_O_LANTERN);

            entries.add(BlockusBlocks.COOKIE_BLOCK);

            entries.add(BlockusBlocks.RAINBOW_ROSE);
            entries.add(BlockusItems.RAINBOW_PETAL);
            entries.add(BlockusBlocks.LARGE_FLOWER_POT);

            entries.add(BlockusBlocks.GOLDEN_CHAIN);

            entries.add(BlockusBlocks.WHITE_OAK.sign);
            entries.add(BlockusBlocks.CHARRED.sign);
            entries.add(BlockusBlocks.BAMBOO.sign);
            entries.add(BlockusBlocks.WHITE_OAK.boat);
            entries.add(BlockusBlocks.CHARRED.boat);
            entries.add(BlockusBlocks.BAMBOO.boat);
            entries.add(BlockusBlocks.WHITE_OAK.chest_boat);
            entries.add(BlockusBlocks.CHARRED.chest_boat);
            entries.add(BlockusBlocks.BAMBOO.chest_boat);

        }
    };
}
