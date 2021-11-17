package com.brand.blockus.world;

import com.brand.blockus.content.BlockusBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class BlockusVegetationPlacedFeatures {

    public static final PlacedFeature WHITE_OAK_TREE;
    public static final PlacedFeature WHITE_OAK_TREE_RARE;



    static {
        WHITE_OAK_TREE = BlockusTreeConfiguredFeatures.WHITE_OAK.withPlacement(new PlacementModifier[]{RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))});
        WHITE_OAK_TREE_RARE = BlockusTreeConfiguredFeatures.WHITE_OAK.withPlacement(new PlacementModifier[]{RarityFilterPlacementModifier.of(118), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))});
    }
}