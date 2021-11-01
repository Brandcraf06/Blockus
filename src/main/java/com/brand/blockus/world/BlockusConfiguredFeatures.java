package com.brand.blockus.world;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;


public class BlockusConfiguredFeatures {

    public static final ConfiguredFeature<TreeFeatureConfig, ?> WHITE_OAK;
    public static final ConfiguredFeature<?, ?> LIMESTONE_UPPER;
    public static final ConfiguredFeature<?, ?> LIMESTONE_LOWER;
    public static final ConfiguredFeature<?, ?> MARBLE;
    public static final ConfiguredFeature<?, ?> BLUESTONE;
    public static final ConfiguredFeature<?, ?> WHITE_OAK_CHECKED;

    private static TreeFeatureConfig.Builder buildWhiteOakTree() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LOG), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5), new TwoLayersFeatureSize(1, 0, 1));
    }

    static {
        LIMESTONE_UPPER = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.getDefaultState(), 64)).uniformRange(YOffset.fixed(64), YOffset.fixed(128)).spreadHorizontally().applyChance(6);
        LIMESTONE_LOWER = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.getDefaultState(), 64)).uniformRange(YOffset.fixed(0), YOffset.fixed(60)).spreadHorizontally().repeat(2);
        MARBLE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.MARBLE.getDefaultState(), 64)).uniformRange(YOffset.fixed(0), YOffset.fixed(75)).spreadHorizontally().repeat(2);
        BLUESTONE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.BLUESTONE.getDefaultState(), 64)).uniformRange(YOffset.getBottom(), YOffset.fixed(0)).spreadHorizontally().repeat(2);
        WHITE_OAK = Feature.TREE.configure(buildWhiteOakTree().build());
        WHITE_OAK_CHECKED = WHITE_OAK.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING);

    }

    public static void registerConfiguredFeature() {

        RegistryKey<ConfiguredFeature<?, ?>> oreLimestoneUpper = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Blockus.MOD_ID, "limestone_upper"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreLimestoneUpper.getValue(), LIMESTONE_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreLimestoneUpper);

        RegistryKey<ConfiguredFeature<?, ?>> oreLimestoneLower = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Blockus.MOD_ID, "limestone_lower"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreLimestoneLower.getValue(), LIMESTONE_LOWER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreLimestoneLower);

        RegistryKey<ConfiguredFeature<?, ?>> oreMarble = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Blockus.MOD_ID, "marble"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreMarble.getValue(), MARBLE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreMarble);

        RegistryKey<ConfiguredFeature<?, ?>> oreBluestone = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Blockus.MOD_ID, "bluestone"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreBluestone.getValue(), BLUESTONE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreBluestone);

        RegistryKey<ConfiguredFeature<?, ?>> treeWhiteOak = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Blockus.MOD_ID, "white_oak"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeWhiteOak.getValue(), WHITE_OAK_CHECKED.decorate(Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.05F, 1))));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, treeWhiteOak);

        RegistryKey<ConfiguredFeature<?, ?>> treeWhiteOakRare = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Blockus.MOD_ID, "white_oak_rare"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeWhiteOakRare.getValue(), WHITE_OAK_CHECKED.decorate(Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.0085F, 1))));
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, treeWhiteOakRare);

        RegistryKey<ConfiguredFeature<?, ?>> treeWhiteOakChecked = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Blockus.MOD_ID, "white_oak_checked"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeWhiteOakChecked.getValue(), WHITE_OAK_CHECKED);

    }

    public static final class Decorators {
        public static final ConfiguredDecorator<HeightmapDecoratorConfig> HEIGHTMAP_OCEAN_FLOOR;
        public static final ConfiguredDecorator<?> SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER;
        public static final ConfiguredDecorator<?> HEIGHTMAP_OCEAN_FLOOR_NO_WATER;

        static {
            HEIGHTMAP_OCEAN_FLOOR = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR));
            HEIGHTMAP_OCEAN_FLOOR_NO_WATER = HEIGHTMAP_OCEAN_FLOOR.decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(0)));
            SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER = HEIGHTMAP_OCEAN_FLOOR_NO_WATER.spreadHorizontally();

        }
    }
}