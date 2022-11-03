package com.brand.blockus.itemgroups;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

public class BlockusLegacyBlocks {

    private static final ItemGroup BLOCKUS_NATURE_BLOCKS = new FabricItemGroup(new Identifier(Blockus.MOD_ID, "blockus_legacy")) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockusBlocks.LEGACY_BRICKS);
        }

        @Override
        protected void addItems(FeatureSet enabledFeatures, Entries entries, boolean opItems) {

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
            entries.add(BlockusBlocks.LEGACY_COAL_BLOCK);
            entries.add(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK);
            entries.add(BlockusBlocks.LEGACY_DIAMOND_BLOCK);
            entries.add(BlockusBlocks.LEGACY_LAPIS_BLOCK);
            entries.add(BlockusBlocks.LEGACY_SPONGE);
            entries.add(BlockusBlocks.LEGACY_STONECUTTER);
            entries.add(BlockusBlocks.LEGACY_NETHER_REACTOR_CORE);

        }
    };
}
