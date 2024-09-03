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
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class BlockusWorldgenFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> LIMESTONE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blockus.id("ore_limestone"));
    public static final RegistryKey<PlacedFeature> PLACED_LIMESTONE_UPPER = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_limestone_upper"));
    public static final RegistryKey<PlacedFeature> PLACED_LIMESTONE_LOWER = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_limestone_lower"));

    public static final RegistryKey<ConfiguredFeature<?, ?>> MARBLE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blockus.id("ore_marble"));
    public static final RegistryKey<PlacedFeature> PLACED_MARBLE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_marble"));

    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUESTONE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blockus.id("ore_bluestone"));
    public static final RegistryKey<PlacedFeature> PLACED_BLUESTONE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_bluestone"));

    public static final RegistryKey<ConfiguredFeature<?, ?>> VIRIDITE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blockus.id("ore_viridite"));
    public static final RegistryKey<PlacedFeature> PLACED_VIRIDITE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_viridite"));

    public static final RegistryKey<ConfiguredFeature<?, ?>> VIRIDITE_EXTRA = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blockus.id("ore_viridite_extra"));
    public static final RegistryKey<PlacedFeature> PLACED_VIRIDITE_EXTRA = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_viridite_extra"));

    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_OAK = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blockus.id("white_oak"));
    public static final RegistryKey<PlacedFeature> PLACED_WHITE_OAK = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("white_oak"));
    public static final RegistryKey<PlacedFeature> PLACED_WHITE_OAK_RARE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("white_oak_rare"));
    public static final RegistryKey<PlacedFeature> WHITE_OAK_CHECKED = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("white_oak_checked"));

    public static final RegistryKey<ConfiguredFeature<?, ?>> LEGACY_OAK = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blockus.id("legacy_oak"));
    public static final RegistryKey<PlacedFeature> LEGACY_OAK_CHECKED = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("legacy_oak_checked"));


    public static final RegistryKey<ConfiguredFeature<?, ?>> RAINBOW_ROSE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blockus.id("rainbow_rose"));
    public static final RegistryKey<PlacedFeature> PLACED_RAINBOW_ROSE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("rainbow_rose"));


    public static TreeFeatureConfig.Builder white_oak() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LOG), new StraightTrunkPlacer(7, 1, 0), BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LEAVES), new WhiteOakFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(6), 0.33F, 0.25F, 0.25F, 0.50F), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    public static TreeFeatureConfig.Builder legacy_oak() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.LEGACY_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.of(BlockusBlocks.LEGACY_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(BlockusBlocks.LEGACY_GRASS_BLOCK))));
    }

    public static void registerConfiguredFeature() {

        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_limestone_upper")));

        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_limestone_lower")));

        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_marble")));

        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_bluestone")));

        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_viridite")));

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("ore_viridite_extra")));

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
            GenerationStep.Feature.VEGETAL_DECORATION,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("white_oak")));

        BiomeModifications.addFeature(
            BiomeSelectors.tag(ConventionalBiomeTags.PLAINS),
            GenerationStep.Feature.VEGETAL_DECORATION,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("white_oak_rare")));

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST, BiomeKeys.MEADOW),
            GenerationStep.Feature.VEGETAL_DECORATION,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blockus.id("rainbow_rose")));

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
}
