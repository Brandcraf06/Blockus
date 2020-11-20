package com.brand.blockus.world;

import me.shedaniel.cloth.api.dynamic.registry.v1.BiomesRegistry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class BlockusGen {


    public static void addMineables(RegistryKey<Biome> registryKey, Biome biome) {
        BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> BlockusConfiguredFeatures.LIMESTONE);
        BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> BlockusConfiguredFeatures.BLUESTONE);
        BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> BlockusConfiguredFeatures.MARBLE);
    }

    public static void addWhiteOakTrees(RegistryKey<Biome> registryKey, Biome biome) {
        if (registryKey.equals(BiomeKeys.FOREST) || registryKey.equals(BiomeKeys.WOODED_HILLS) || registryKey.equals(BiomeKeys.FLOWER_FOREST)) {
            BiomesRegistry.registerFeature(biome, GenerationStep.Feature.VEGETAL_DECORATION, () -> BlockusConfiguredFeatures.WHITE_OAK_TREE);
        }
    }

    public static void addPlainsWhiteOakTrees(RegistryKey<Biome> registryKey, Biome biome) {
        if (biome.getCategory() == Biome.Category.PLAINS) {
            BiomesRegistry.registerFeature(biome, GenerationStep.Feature.VEGETAL_DECORATION, () -> BlockusConfiguredFeatures.WHITE_OAK_TREE_RARE);
        }
    }
}