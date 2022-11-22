package com.brand.blockus.world;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class BlockusConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<?, ?>> WHITE_OAK_TREE;
    public static final RegistryEntry<PlacedFeature> WHITE_OAK_CHECKED;
    public static final RegistryEntry<ConfiguredFeature<?, ?>> RAINBOW_ROSE_BONEMEAL;
    public static final RegistryEntry<ConfiguredFeature<?, ?>> LEGACY_OAK_TREE;

    public static TreeFeatureConfig.Builder white_oak() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LOG), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeFeatureConfig.Builder legacy_oak() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.LEGACY_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.of(BlockusBlocks.LEGACY_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(BlockusBlocks.LEGACY_GRASS_BLOCK))));
    }


    static {

        WHITE_OAK_TREE = BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, Blockus.id("white_oak_tree"), new ConfiguredFeature<>(Feature.TREE, white_oak().build()));
        WHITE_OAK_CHECKED = BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, Blockus.id("white_oak_checked"), new PlacedFeature(BlockusConfiguredFeatures.WHITE_OAK_TREE, List.of(new PlacementModifier[]{PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING)})));
        RAINBOW_ROSE_BONEMEAL = BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, Blockus.id("rainbow_rose_bonemeal"), new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchFeatureConfig(6, 5, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE))))));
        LEGACY_OAK_TREE = BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, Blockus.id("legacy_oak_tree"), new ConfiguredFeature<>(Feature.TREE, legacy_oak().build()));

    }


    public static void registerConfiguredFeature() {

        // limestone
        ConfiguredFeature<?, ?> ORE_LIMESTONE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.block.getDefaultState(), 64));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Blockus.id("ore_limestone"), ORE_LIMESTONE);

        RegistryKey<PlacedFeature> oreLimestoneUpper = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Blockus.id("ore_limestone_upper"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreLimestoneUpper.getValue(), new PlacedFeature(RegistryEntry.of(ORE_LIMESTONE), modifiersWithRarity(6, HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(128)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreLimestoneUpper);

        RegistryKey<PlacedFeature> oreLimestoneLower = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Blockus.id("ore_limestone_lower"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreLimestoneLower.getValue(), new PlacedFeature(RegistryEntry.of(ORE_LIMESTONE), modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(60)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreLimestoneLower);

        // marble
        ConfiguredFeature<?, ?> ORE_MARBLE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.MARBLE.block.getDefaultState(), 64));

        RegistryKey<PlacedFeature> oreMarble = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Blockus.id("ore_marble"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreMarble.getValue(), ORE_MARBLE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreMarble.getValue(), new PlacedFeature(RegistryEntry.of(ORE_MARBLE), modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreMarble);

        // bluestone
        ConfiguredFeature<?, ?> ORE_BLUESTONE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.BLUESTONE.block.getDefaultState(), 64));

        RegistryKey<PlacedFeature> oreBluestone = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Blockus.id("ore_bluestone"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreBluestone.getValue(), ORE_BLUESTONE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreBluestone.getValue(), new PlacedFeature(RegistryEntry.of(ORE_BLUESTONE), modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreBluestone);

        // viridite
        ConfiguredFeature<?, ?> ORE_VIRIDITE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockusBlocks.VIRIDITE.block.getDefaultState(), 33));

        RegistryKey<PlacedFeature> oreViridite = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Blockus.id("ore_viridite"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreViridite.getValue(), ORE_VIRIDITE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreViridite.getValue(), new PlacedFeature(RegistryEntry.of(ORE_VIRIDITE), modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-16)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreViridite);

        ConfiguredFeature<?, ?> ORE_VIRIDITE_EXTRA = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockusBlocks.VIRIDITE.block.getDefaultState(), 42));

        RegistryKey<PlacedFeature> oreViriditeExtra = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Blockus.id("ore_viridite_extra"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreViriditeExtra.getValue(), ORE_VIRIDITE_EXTRA);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreViriditeExtra.getValue(), new PlacedFeature(RegistryEntry.of(ORE_VIRIDITE_EXTRA), modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-16)))));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK), GenerationStep.Feature.UNDERGROUND_ORES, oreViriditeExtra);

        // white oak
        ConfiguredFeature<?, ?> WHITE_OAK = new ConfiguredFeature<>(Feature.TREE, white_oak().build());
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Blockus.id("white_oak"), WHITE_OAK);

        RegistryKey<PlacedFeature> treeWhiteOak = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Blockus.id("white_oak_tree"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeWhiteOak.getValue(), new PlacedFeature(RegistryEntry.of(WHITE_OAK), List.of(new PlacementModifier[]{RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))})));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, treeWhiteOak);

        RegistryKey<PlacedFeature> treeWhiteOakRare = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Blockus.id("white_oak_rare"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeWhiteOakRare.getValue(), new PlacedFeature(RegistryEntry.of(WHITE_OAK), List.of(new PlacementModifier[]{RarityFilterPlacementModifier.of(240), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))})));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, treeWhiteOakRare);

        // rainbow rose
        ConfiguredFeature<?, ?> RAINBOW_ROSE = new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchFeatureConfig(12, 7, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE)))));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Blockus.id("rainbow_rose"), RAINBOW_ROSE);

        RegistryKey<PlacedFeature> rainbowRose = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Blockus.id("rainbow_rose"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, rainbowRose.getValue(), new PlacedFeature(RegistryEntry.of(RAINBOW_ROSE), List.of(new PlacementModifier[]{SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()})));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST, BiomeKeys.MEADOW), GenerationStep.Feature.VEGETAL_DECORATION, rainbowRose);

    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
