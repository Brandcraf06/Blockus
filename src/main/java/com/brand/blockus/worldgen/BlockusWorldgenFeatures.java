package com.brand.blockus.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

import static com.brand.blockus.worldgen.BlockusWorldgenProvider.*;


public class BlockusWorldgenFeatures {
    public static void registerFeature() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_LIMESTONE_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_LIMESTONE_LOWER);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_MARBLE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_BLUESTONE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_VIRIDITE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_DARK), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_VIRIDITE_EXTRA);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FOREST, Biomes.DARK_FOREST, Biomes.FLOWER_FOREST, Biomes.CHERRY_GROVE), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_WHITE_OAK);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FOREST, Biomes.FLOWER_FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_FALLEN_WHITE_OAK);
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.IS_PLAINS), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_WHITE_OAK_RARE);
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.IS_PLAINS), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_FALLEN_WHITE_OAK);

        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.IS_FLOWER_FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_RAINBOW_ROSE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.MEADOW), GenerationStep.Decoration.VEGETAL_DECORATION, PLACED_RAINBOW_ROSE);
    }
}
