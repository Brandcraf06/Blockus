package com.brand.blockus.worldgen;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.worldgen.foliage.WhiteOakFoliagePlacer;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class BlockusWorldgenFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> LIMESTONE = configured("ore_limestone");
    public static final RegistryKey<PlacedFeature> PLACED_LIMESTONE_UPPER = placed("ore_limestone_upper");
    public static final RegistryKey<PlacedFeature> PLACED_LIMESTONE_LOWER = placed("ore_limestone_lower");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MARBLE = configured("ore_marble");
    public static final RegistryKey<PlacedFeature> PLACED_MARBLE = placed("ore_marble");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUESTONE = configured("ore_bluestone");
    public static final RegistryKey<PlacedFeature> PLACED_BLUESTONE = placed("ore_bluestone");

    public static final RegistryKey<ConfiguredFeature<?, ?>> VIRIDITE = configured("ore_viridite");
    public static final RegistryKey<PlacedFeature> PLACED_VIRIDITE = placed("ore_viridite");

    public static final RegistryKey<ConfiguredFeature<?, ?>> VIRIDITE_EXTRA = configured("ore_viridite_extra");
    public static final RegistryKey<PlacedFeature> PLACED_VIRIDITE_EXTRA = placed("ore_viridite_extra");

    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_OAK = configured("white_oak");
    public static final RegistryKey<PlacedFeature> PLACED_WHITE_OAK = placed("white_oak");
    public static final RegistryKey<PlacedFeature> PLACED_WHITE_OAK_RARE = placed("white_oak_rare");
    public static final RegistryKey<PlacedFeature> WHITE_OAK_CHECKED = placed("white_oak_checked");

    public static final RegistryKey<ConfiguredFeature<?, ?>> LEGACY_OAK = configured("legacy_oak");
    public static final RegistryKey<PlacedFeature> LEGACY_OAK_CHECKED = placed("legacy_oak_checked");

    public static final RegistryKey<ConfiguredFeature<?, ?>> RAINBOW_ROSE = configured("rainbow_rose");
    public static final RegistryKey<PlacedFeature> PLACED_RAINBOW_ROSE = placed("rainbow_rose");


    public static TreeFeatureConfig.Builder white_oak() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LOG), new StraightTrunkPlacer(7, 1, 0), BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LEAVES), new WhiteOakFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(6), 0.33F, 0.25F, 0.25F, 0.50F), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    public static TreeFeatureConfig.Builder legacy_oak() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.LEGACY_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.of(BlockusBlocks.LEGACY_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(BlockusBlocks.LEGACY_GRASS_BLOCK))));
    }

    public static void registerConfiguredFeature() {

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PLACED_LIMESTONE_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PLACED_LIMESTONE_LOWER);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PLACED_MARBLE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PLACED_BLUESTONE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PLACED_VIRIDITE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK), GenerationStep.Feature.UNDERGROUND_ORES, PLACED_VIRIDITE_EXTRA);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, PLACED_WHITE_OAK);
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, PLACED_WHITE_OAK_RARE);

        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.FLOWER_FORESTS), GenerationStep.Feature.VEGETAL_DECORATION, PLACED_RAINBOW_ROSE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW), GenerationStep.Feature.VEGETAL_DECORATION, PLACED_RAINBOW_ROSE);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> configured(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blockus.id(id));
    }

    public static RegistryKey<PlacedFeature> placed(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id(id));
    }
}
