package com.brand.blockus.itemgroups;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.types.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

public class BlockusRedstoneBlocks {

    private static final ItemGroup BLOCKUS_REDSTONE_BLOCKS = new FabricItemGroup(new Identifier(Blockus.MOD_ID, "blockus_redstone")) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockusBlocks.REDSTONE_LANTERN_BLOCK);
        }

        @Override
        protected void addItems(FeatureSet enabledFeatures, Entries entries) {

            entries.add(BlockusBlocks.REDSTONE_LANTERN);
            entries.add(BlockusBlocks.REDSTONE_LANTERN_BLOCK);
            entries.add(BlockusBlocks.REDSTONE_SAND);
            entries.add(BlockusBlocks.REDSTONE_O_LANTERN);

            entries.add(BlockusBlocks.WHITE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP);
            entries.add(BlockusBlocks.GRAY_REDSTONE_LAMP);
            entries.add(BlockusBlocks.BROWN_REDSTONE_LAMP);
            entries.add(BlockusBlocks.RED_REDSTONE_LAMP);
            entries.add(BlockusBlocks.ORANGE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.YELLOW_REDSTONE_LAMP);
            entries.add(BlockusBlocks.LIME_REDSTONE_LAMP);
            entries.add(BlockusBlocks.GREEN_REDSTONE_LAMP);
            entries.add(BlockusBlocks.CYAN_REDSTONE_LAMP);
            entries.add(BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.BLUE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.PURPLE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.MAGENTA_REDSTONE_LAMP);
            entries.add(BlockusBlocks.PINK_REDSTONE_LAMP);
            entries.add(BlockusBlocks.RAINBOW_LAMP);

            entries.add(BlockusBlocks.REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.WHITE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.GRAY_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.BROWN_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.RED_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.ORANGE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.YELLOW_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.LIME_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.GREEN_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.CYAN_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.BLUE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.PURPLE_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.MAGENTA_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.PINK_REDSTONE_LAMP_LIT);
            entries.add(BlockusBlocks.RAINBOW_LAMP_LIT);

            entries.add(BlockusBlocks.WHITE_OAK.chest_boat);
            entries.add(BlockusBlocks.CHARRED.chest_boat);
            entries.add(BlockusBlocks.BAMBOO.chest_boat);

            for (WoodTypesB woodType : WoodTypesB.values()) {
                entries.add(woodType.button);
            }

            for (WoodTypesNB woodType : WoodTypesNB.values()) {
                entries.add(woodType.button);
            }

            entries.add(BlockusBlocks.POLISHED_ANDESITE_BUTTON);
            entries.add(BlockusBlocks.POLISHED_DIORITE_BUTTON);
            entries.add(BlockusBlocks.POLISHED_GRANITE_BUTTON);
            entries.add(BlockusBlocks.LIMESTONE_BUTTON);
            entries.add(BlockusBlocks.MARBLE_BUTTON);
            entries.add(BlockusBlocks.BLUESTONE_BUTTON);
            entries.add(BlockusBlocks.VIRIDITE_BUTTON);
            entries.add(BlockusBlocks.POLISHED_NETHERRACK_BUTTON);
            entries.add(BlockusBlocks.POLISHED_END_STONE_BUTTON);
            entries.add(BlockusBlocks.POLISHED_BASALT_BUTTON);
            entries.add(BlockusBlocks.POLISHED_DEEPSLATE_BUTTON);
            entries.add(BlockusBlocks.POLISHED_SCULK_BUTTON);
            entries.add(BlockusBlocks.POLISHED_TUFF_BUTTON);

            for (WoodTypesB woodType : WoodTypesB.values()) {
                entries.add(woodType.pressure_plate);
            }

            for (WoodTypesNB woodType : WoodTypesNB.values()) {
                entries.add(woodType.pressure_plate);
            }

            entries.add(BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE);
            entries.add(BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE);
            entries.add(BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE);
            entries.add(BlockusBlocks.LIMESTONE_PRESSURE_PLATE);
            entries.add(BlockusBlocks.MARBLE_PRESSURE_PLATE);
            entries.add(BlockusBlocks.BLUESTONE_PRESSURE_PLATE);
            entries.add(BlockusBlocks.VIRIDITE_PRESSURE_PLATE);
            entries.add(BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE);
            entries.add(BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE);
            entries.add(BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE);
            entries.add(BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE);
            entries.add(BlockusBlocks.POLISHED_SCULK_PRESSURE_PLATE);
            entries.add(BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE);

            for (WoodTypesB woodType : WoodTypesB.values()) {
                entries.add(woodType.door);
            }

            for (WoodTypesNB woodType : WoodTypesNB.values()) {
                entries.add(woodType.door);
            }

            entries.add(BlockusBlocks.PAPER_DOOR);
            entries.add(BlockusBlocks.STONE_DOOR);
            entries.add(BlockusBlocks.BLACKSTONE_DOOR);
            entries.add(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR);


            for (WoodTypesB woodType : WoodTypesB.values()) {
                entries.add(woodType.trapdoor);
            }

            for (WoodTypesNB woodType : WoodTypesNB.values()) {
                entries.add(woodType.trapdoor);
            }

            entries.add(BlockusBlocks.PAPER_TRAPDOOR);
            entries.add(BlockusBlocks.STONE_TRAPDOOR);
            entries.add(BlockusBlocks.BLACKSTONE_TRAPDOOR);
            entries.add(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR);


            for (WoodTypesB woodType : WoodTypesB.values()) {
                entries.add(woodType.fence_gate);
            }

            for (WoodTypesNB woodType : WoodTypesNB.values()) {
                entries.add(woodType.fence_gate);
            }

        }
    };
}
