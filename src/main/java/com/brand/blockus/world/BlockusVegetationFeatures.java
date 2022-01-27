package com.brand.blockus.world;

import com.brand.blockus.content.BlockusBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class BlockusVegetationFeatures {

    public static final ConfiguredFeature<TreeFeatureConfig, ?> WHITE_OAK;
    public static final PlacedFeature WHITE_OAK_CHECKED;
    public static final PlacedFeature WHITE_OAK_TREE;
    public static final PlacedFeature WHITE_OAK_TREE_RARE;
    public static final ConfiguredFeature<?, ?> RAINBOW_ROSE;
    public static final ConfiguredFeature<?, ?> RAINBOW_ROSE_BONEMEAL;


    private static TreeFeatureConfig.Builder builder() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LOG), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5), new TwoLayersFeatureSize(1, 0, 1));
    }

    static {
        WHITE_OAK = ConfiguredFeatures.register("white_oak", Feature.TREE.configure(builder().ignoreVines().build()));
        WHITE_OAK_CHECKED = BlockusVegetationFeatures.WHITE_OAK.withWouldSurviveFilter(BlockusBlocks.WHITE_OAK_SAPLING);
        WHITE_OAK_TREE = BlockusVegetationFeatures.WHITE_OAK.withPlacement(RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)));
        WHITE_OAK_TREE_RARE = BlockusVegetationFeatures.WHITE_OAK.withPlacement(RarityFilterPlacementModifier.of(240), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)));
        RAINBOW_ROSE = ConfiguredFeatures.register("rainbow_rose", Feature.FLOWER.configure(new RandomPatchFeatureConfig(12, 7, 2, () -> Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE))).withInAirFilter())));
        RAINBOW_ROSE_BONEMEAL = ConfiguredFeatures.register("rainbow_rose_bonemeal", Feature.FLOWER.configure(new RandomPatchFeatureConfig(6, 5, 2, () -> Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE))).withBlockPredicateFilter(BlockPredicate.matchingBlocks(List.of(Blocks.AIR, Blocks.GRASS, Blocks.TALL_GRASS, Blocks.FERN, Blocks.LARGE_FERN), BlockPos.ORIGIN)))));
    }
}
