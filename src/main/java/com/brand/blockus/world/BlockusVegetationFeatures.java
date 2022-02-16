package com.brand.blockus.world;

import com.brand.blockus.content.BlockusBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class BlockusVegetationFeatures {

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> WHITE_OAK;
    /*
    public static final RegistryEntry<PlacedFeature> WHITE_OAK_CHECKED;
    public static final RegistryEntry<PlacedFeature> WHITE_OAK_RARE;
    */
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> RAINBOW_ROSE_BONEMEAL;

    public static TreeFeatureConfig.Builder builder() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LOG), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5), new TwoLayersFeatureSize(1, 0, 1));
    }

    static {

        WHITE_OAK = ConfiguredFeatures.register("white_oak", Feature.TREE, builder().ignoreVines().build());
        /*
        WHITE_OAK_CHECKED = PlacedFeatures.register("white_oak_checked", BlockusVegetationFeatures.WHITE_OAK, new PlacementModifier[]{RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))});
        WHITE_OAK_RARE = PlacedFeatures.register("white_oak_rare", BlockusVegetationFeatures.WHITE_OAK, new PlacementModifier[]{RarityFilterPlacementModifier.of(240), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))});
        */
        RAINBOW_ROSE_BONEMEAL = ConfiguredFeatures.register("rainbow_rose_bonemeal", Feature.FLOWER, new RandomPatchFeatureConfig(6, 5, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE)))));

    }
}
