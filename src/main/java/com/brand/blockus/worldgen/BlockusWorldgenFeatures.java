package com.brand.blockus.worldgen;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.worldgen.foliage.WhiteOakFoliagePlacer;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.FallenTreeFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLogsDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class BlockusWorldgenFeatures {

    public static final ResourceKey<Feature> LIMESTONE = configured("ore_limestone");
    public static final ResourceKey<PlacedFeature> PLACED_LIMESTONE_UPPER = placed("ore_limestone_upper");
    public static final ResourceKey<PlacedFeature> PLACED_LIMESTONE_LOWER = placed("ore_limestone_lower");

    public static final ResourceKey<Feature> MARBLE = configured("ore_marble");
    public static final ResourceKey<PlacedFeature> PLACED_MARBLE = placed("ore_marble");

    public static final ResourceKey<Feature> BLUESTONE = configured("ore_bluestone");
    public static final ResourceKey<PlacedFeature> PLACED_BLUESTONE = placed("ore_bluestone");

    public static final ResourceKey<Feature> VIRIDITE = configured("ore_viridite");
    public static final ResourceKey<PlacedFeature> PLACED_VIRIDITE = placed("ore_viridite");

    public static final ResourceKey<Feature> VIRIDITE_EXTRA = configured("ore_viridite_extra");
    public static final ResourceKey<PlacedFeature> PLACED_VIRIDITE_EXTRA = placed("ore_viridite_extra");

    public static final ResourceKey<Feature> WHITE_OAK = configured("white_oak");
    public static final ResourceKey<Feature> WHITE_OAK_LEAF_LITTER = configured("white_oak_leaf_litter");
    public static final ResourceKey<PlacedFeature> PLACED_WHITE_OAK = placed("white_oak");
    public static final ResourceKey<PlacedFeature> PLACED_WHITE_OAK_RARE = placed("white_oak_rare");
    public static final ResourceKey<PlacedFeature> WHITE_OAK_CHECKED = placed("white_oak_checked");
    public static final ResourceKey<Feature> FALLEN_WHITE_OAK = configured("fallen_white_oak");
    public static final ResourceKey<PlacedFeature> PLACED_FALLEN_WHITE_OAK = placed("fallen_white_oak");

    public static final ResourceKey<Feature> LEGACY_OAK = configured("legacy_oak");
    public static final ResourceKey<PlacedFeature> LEGACY_OAK_CHECKED = placed("legacy_oak_checked");

    public static final ResourceKey<Feature> RAINBOW_ROSE = configured("rainbow_rose");
    public static final ResourceKey<PlacedFeature> PLACED_RAINBOW_ROSE = placed("rainbow_rose");

    public static TreeFeature.Builder createWhiteOak(BlockStateProvider belowTrunkProvider) {
        return new TreeFeature.Builder(BlockStateProvider.simple(BlockusBlocks.WHITE_OAK_LOG), new StraightTrunkPlacer(7, 1, 0), BlockStateProvider.simple(BlockusBlocks.WHITE_OAK_LEAVES), new WhiteOakFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(6), 0.33F, 0.25F, 0.25F, 0.50F), new TwoLayersFeatureSize(1, 0, 1), belowTrunkProvider).ignoreVines();
    }

    public static TreeFeature.Builder createLegacyOak(BlockStateProvider belowTrunkProvider) {
        return new TreeFeature.Builder(BlockStateProvider.simple(BlockusBlocks.LEGACY_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(BlockusBlocks.LEGACY_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1), belowTrunkProvider).decorators(ImmutableList.of(new AlterGroundDecorator(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesTag(BlockTags.SUBSTRATE_OVERWORLD), BlockusBlocks.LEGACY_GRASS_BLOCK))));
    }

    public static void registerConfiguredFeature() {

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_LIMESTONE_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_LIMESTONE_LOWER);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_MARBLE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_BLUESTONE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_VIRIDITE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_DARK), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_VIRIDITE_EXTRA);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FOREST, Biomes.DARK_FOREST, Biomes.FLOWER_FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_WHITE_OAK);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FOREST, Biomes.DARK_FOREST, Biomes.FLOWER_FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_FALLEN_WHITE_OAK);
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.IS_PLAINS), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_WHITE_OAK_RARE);
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.IS_PLAINS), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_FALLEN_WHITE_OAK);

        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.IS_FLOWER_FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_RAINBOW_ROSE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.MEADOW), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_RAINBOW_ROSE);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacement.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilter.onAverageOnceEvery(chance), heightModifier);
    }

    public static ResourceKey<Feature> configured(String name) {
        return ResourceKey.create(Registries.FEATURE, Blockus.id(name));
    }

    public static ResourceKey<PlacedFeature> placed(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Blockus.id(name));
    }

    public static FallenTreeFeature.Builder fallen(Block log, int minLength, int maxLength) {
        return new FallenTreeFeature.Builder(BlockStateProvider.simple(log), UniformInt.of(minLength, maxLength)).logDecorator(new AttachedToLogsDecorator(0.1F, new WeightedStateProvider(WeightedList.<BlockState>builder().add(Blocks.RED_MUSHROOM.defaultBlockState(), 2).add(Blocks.BROWN_MUSHROOM.defaultBlockState(), 1)), List.of(Direction.UP)));
    }
}
