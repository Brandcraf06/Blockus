package com.brand.blockus.world;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;

import java.util.List;

public class BlockusConfiguredFeatures {

    public static void registerConfiguredFeature() {

        // limestone
        RegistryKey<PlacedFeature> oreLimestoneUpper = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier(Blockus.MOD_ID, "ore_limestone_upper"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreLimestoneUpper.getValue(), BlockusOreFeatures.ORE_LIMESTONE.withPlacement(modifiersWithRarity(6, HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(128)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreLimestoneUpper);

        RegistryKey<PlacedFeature> oreLimestoneLower = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier(Blockus.MOD_ID, "ore_limestone_lower"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreLimestoneLower.getValue(), BlockusOreFeatures.ORE_LIMESTONE.withPlacement(modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(60)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreLimestoneLower);

        // marble
        RegistryKey<PlacedFeature> oreMarble = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier(Blockus.MOD_ID, "ore_marble"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreMarble.getValue(), BlockusOreFeatures.ORE_MARBLE.withPlacement(modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreMarble);

        // bluestone
        RegistryKey<PlacedFeature> oreBluestone = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier(Blockus.MOD_ID, "ore_bluestone"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreBluestone.getValue(), BlockusOreFeatures.ORE_BLUESTONE.withPlacement(modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreBluestone);

        // white oak
        RegistryKey<PlacedFeature> treeWhiteOak = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier(Blockus.MOD_ID, "white_oak_tree"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeWhiteOak.getValue(), BlockusVegetationFeatures.WHITE_OAK_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, treeWhiteOak);

        RegistryKey<PlacedFeature> treeWhiteOakRare = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier(Blockus.MOD_ID, "white_oak_tree_rare"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeWhiteOakRare.getValue(), BlockusVegetationFeatures.WHITE_OAK_TREE_RARE);
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, treeWhiteOakRare);

        RegistryKey<PlacedFeature> treeWhiteOakChecked = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier(Blockus.MOD_ID, "white_oak_checked"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeWhiteOakChecked.getValue(), BlockusVegetationFeatures.WHITE_OAK_CHECKED);

        // rainbow rose
        RegistryKey<PlacedFeature> rainbowRose = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier(Blockus.MOD_ID, "rainbow_rose"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, rainbowRose.getValue(), BlockusVegetationFeatures.RAINBOW_ROSE.withPlacement(SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST, BiomeKeys.MEADOW), GenerationStep.Feature.VEGETAL_DECORATION, rainbowRose);

    }

    private static List<PlacementModifier> modifiers(PlacementModifier first, PlacementModifier second) {
        return List.of(first, SquarePlacementModifier.of(), second, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier modifier) {
        return modifiers(CountPlacementModifier.of(count), modifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier modifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), modifier);
    }
}
