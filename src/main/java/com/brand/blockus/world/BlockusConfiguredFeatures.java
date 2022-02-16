package com.brand.blockus.world;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class BlockusConfiguredFeatures {

    public static void registerConfiguredFeature() {

        // limestone
        ConfiguredFeature<?, ?> ORE_LIMESTONE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.getDefaultState(), 64));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID,  "ore_limestone"), ORE_LIMESTONE);
        RegistryEntry<ConfiguredFeature<?, ?>> oreLimestoneFeature = BuiltinRegistries.CONFIGURED_FEATURE.getOrCreateEntry(BuiltinRegistries.CONFIGURED_FEATURE.getKey(ORE_LIMESTONE).orElseThrow());

        RegistryKey<PlacedFeature> oreLimestoneUpper = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "ore_limestone_upper"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreLimestoneUpper.getValue(),  new PlacedFeature(oreLimestoneFeature, modifiersWithRarity(6, HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(128)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreLimestoneUpper);

        RegistryKey<PlacedFeature> oreLimestoneLower = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "ore_limestone_lower"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreLimestoneLower.getValue(), new PlacedFeature(oreLimestoneFeature, modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(60)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreLimestoneLower);

        // marble
        ConfiguredFeature<?, ?> ORE_MARBLE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.MARBLE.getDefaultState(), 64));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID,  "ore_marble"), ORE_MARBLE);
        RegistryEntry<ConfiguredFeature<?, ?>> oreMarbleFeature = BuiltinRegistries.CONFIGURED_FEATURE.getOrCreateEntry(BuiltinRegistries.CONFIGURED_FEATURE.getKey(ORE_MARBLE).orElseThrow());

        RegistryKey<PlacedFeature> oreMarble = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "ore_marble"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreMarble.getValue(), new PlacedFeature(oreMarbleFeature, modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreMarble);

        // bluestone
        ConfiguredFeature<?, ?> ORE_BLUESTONE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.MARBLE.getDefaultState(), 64));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID,  "ore_bluestone"), ORE_BLUESTONE);
        RegistryEntry<ConfiguredFeature<?, ?>> oreBluestoneFeature = BuiltinRegistries.CONFIGURED_FEATURE.getOrCreateEntry(BuiltinRegistries.CONFIGURED_FEATURE.getKey(ORE_BLUESTONE).orElseThrow());

        RegistryKey<PlacedFeature> oreBluestone = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "ore_bluestone"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreBluestone.getValue(), new PlacedFeature(oreBluestoneFeature, modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreBluestone);

        // white oak
        ConfiguredFeature<?, ?> WHITE_OAK_TREE = new ConfiguredFeature<>(Feature.TREE, BlockusVegetationFeatures.builder().ignoreVines().build());
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID,  "white_oak_tree"), WHITE_OAK_TREE);
        RegistryEntry<ConfiguredFeature<?, ?>> treeWhiteOakFeature = BuiltinRegistries.CONFIGURED_FEATURE.getOrCreateEntry(BuiltinRegistries.CONFIGURED_FEATURE.getKey(WHITE_OAK_TREE).orElseThrow());

        RegistryKey<PlacedFeature> treeWhiteOak = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "white_oak_checked"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeWhiteOak.getValue(), new PlacedFeature(treeWhiteOakFeature, List.of(new PlacementModifier[]{RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))})));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, treeWhiteOak);

        RegistryKey<PlacedFeature> treeWhiteOakRare = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "white_oak_rare"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeWhiteOakRare.getValue(), new PlacedFeature(treeWhiteOakFeature, List.of(new PlacementModifier[]{RarityFilterPlacementModifier.of(240), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))})));
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, treeWhiteOakRare);

        // rainbow rose
        ConfiguredFeature<?, ?> RAINBOW_ROSE = new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchFeatureConfig(12, 7, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE)))));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID,  "rainbow_rose"), RAINBOW_ROSE);
        RegistryEntry<ConfiguredFeature<?, ?>> rainbowRoseFeature = BuiltinRegistries.CONFIGURED_FEATURE.getOrCreateEntry(BuiltinRegistries.CONFIGURED_FEATURE.getKey(RAINBOW_ROSE).orElseThrow());

        RegistryKey<PlacedFeature> rainbowRose = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier(Blockus.MOD_ID, "rainbow_rose"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, rainbowRose.getValue(), new PlacedFeature(rainbowRoseFeature, List.of(new PlacementModifier[]{SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()})));
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
