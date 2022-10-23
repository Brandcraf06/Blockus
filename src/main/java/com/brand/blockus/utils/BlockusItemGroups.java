package com.brand.blockus.utils;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.types.WoodTypesB;
import com.brand.blockus.content.types.WoodTypesNB;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

public class BlockusItemGroups {

    private static final ItemGroup BLOCKUS_BUILDING_BLOCKS = new FabricItemGroup(new Identifier(Blockus.MOD_ID, "blockus_building_blocks")) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockusBlocks.BLAZE_BRICKS.block);
        }

        @Override
        protected void addItems(FeatureSet enabledFeatures, Entries entries) {
            entries.add(BlockusBlocks.WHITE_OAK_LOG);
            entries.add(BlockusBlocks.WHITE_OAK_WOOD);
            entries.add(BlockusBlocks.STRIPPED_WHITE_OAK_LOG);
            entries.add(BlockusBlocks.STRIPPED_WHITE_OAK_WOOD);

            for (WoodTypesB woodType : WoodTypesB.values()) {
                entries.add(woodType.planks);
                entries.add(woodType.stairs);
                entries.add(woodType.slab);
                entries.add(woodType.fence);
                entries.add(woodType.fence_gate);
                entries.add(woodType.door);
                entries.add(woodType.trapdoor);
            }

            for (WoodTypesNB woodType : WoodTypesNB.values()) {
                entries.add(woodType.planks);
                entries.add(woodType.stairs);
                entries.add(woodType.slab);
                entries.add(woodType.fence);
                entries.add(woodType.fence_gate);
                entries.add(woodType.door);
                entries.add(woodType.trapdoor);
            }
        }
    };
}
