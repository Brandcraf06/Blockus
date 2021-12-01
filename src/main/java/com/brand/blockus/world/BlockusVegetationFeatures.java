package com.brand.blockus.world;

import com.brand.blockus.content.BlockusBlocks;
import net.minecraft.util.dynamic.Range;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.DualNoiseBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class BlockusVegetationFeatures {

    public static final ConfiguredFeature<TreeFeatureConfig, ?> WHITE_OAK;
    public static final PlacedFeature WHITE_OAK_CHECKED;
    public static final PlacedFeature WHITE_OAK_TREE;
    public static final PlacedFeature WHITE_OAK_TREE_RARE;
    public static final ConfiguredFeature<?, ?> RAINBOW_ROSE;


    private static TreeFeatureConfig.Builder builder() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LOG), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5), new TwoLayersFeatureSize(1, 0, 1));
    }

    static {
        WHITE_OAK = ConfiguredFeatures.register("white_oak", Feature.TREE.configure(builder().ignoreVines().build()));
        WHITE_OAK_CHECKED = BlockusVegetationFeatures.WHITE_OAK.withWouldSurviveFilter(BlockusBlocks.WHITE_OAK_SAPLING);
        WHITE_OAK_TREE = BlockusVegetationFeatures.WHITE_OAK.withPlacement(RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)));
        WHITE_OAK_TREE_RARE = BlockusVegetationFeatures.WHITE_OAK.withPlacement(RarityFilterPlacementModifier.of(240), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)));
        RAINBOW_ROSE = ConfiguredFeatures.register("rainbow_rose", Feature.FLOWER.configure(new RandomPatchFeatureConfig(96, 6, 2, () -> Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(new DualNoiseBlockStateProvider(new Range(1, 3), new DoublePerlinNoiseSampler.NoiseParameters(-10, 1.0D), 1.0F, 2345L, new DoublePerlinNoiseSampler.NoiseParameters(-3, 1.0D), 1.0F, List.of(BlockusBlocks.RAINBOW_ROSE.getDefaultState())))).withInAirFilter())));
    }
}