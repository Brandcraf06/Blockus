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
import net.minecraft.world.gen.decorator.ConfiguredDecorator;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class BlockusConfiguredFeatures {

    public static final TreeFeatureConfig WHITE_OAK_CONFIG;
    public static final ConfiguredFeature<?, ?> LIMESTONE;
    public static final ConfiguredFeature<?, ?> MARBLE;
    public static final ConfiguredFeature<?, ?> BLUESTONE;
    public static final ConfiguredFeature<?, ?> WHITE_OAK;
    public static final ConfiguredFeature<?, ?> WHITE_OAK_RARE;

    static {
        LIMESTONE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.getDefaultState(), 33)).uniformRange(YOffset.fixed(32), YOffset.fixed(128)).spreadHorizontally().repeat(10);
        MARBLE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.MARBLE.getDefaultState(), 33)).uniformRange(YOffset.fixed(0), YOffset.fixed(75)).spreadHorizontally().repeat(10);
        BLUESTONE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.BLUESTONE.getDefaultState(), 33)).uniformRange(YOffset.getBottom(), YOffset.fixed(25)).spreadHorizontally().repeat(10);
        WHITE_OAK_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockusBlocks.WHITE_OAK_LOG.getDefaultState()),
                new StraightTrunkPlacer(7, 2, 0),
                new SimpleBlockStateProvider(BlockusBlocks.WHITE_OAK_LEAVES.getDefaultState()),
                new SimpleBlockStateProvider(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState()),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5),
                new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
        WHITE_OAK = Feature.TREE.configure(WHITE_OAK_CONFIG).decorate(Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.05F, 1)));
        WHITE_OAK_RARE = Feature.TREE.configure(WHITE_OAK_CONFIG).decorate(Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.0085F, 1)));
    }

    public static void registerConfiguredFeature() {
        RegistryKey<ConfiguredFeature<?, ?>> ORE_LIMESTONE = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "limestone"));
        RegistryKey<ConfiguredFeature<?, ?>> ORE_MARBLE = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "marble"));
        RegistryKey<ConfiguredFeature<?, ?>> ORE_BLUESTONE = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "bluestone"));
        RegistryKey<ConfiguredFeature<?, ?>> TREE_WHITE_OAK = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "white_oak"));
        RegistryKey<ConfiguredFeature<?, ?>> TREE_WHITE_OAK_RARE = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Blockus.MOD_ID, "white_oak_rare"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ORE_LIMESTONE.getValue(), LIMESTONE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ORE_MARBLE.getValue(), MARBLE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ORE_BLUESTONE.getValue(), BLUESTONE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, TREE_WHITE_OAK.getValue(), WHITE_OAK);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, TREE_WHITE_OAK_RARE.getValue(), WHITE_OAK_RARE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_LIMESTONE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_MARBLE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_BLUESTONE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.WOODED_HILLS, BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, TREE_WHITE_OAK);
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, TREE_WHITE_OAK_RARE);
    }

    public static final class Decorators {
        public static final ConfiguredDecorator<HeightmapDecoratorConfig> HEIGHTMAP;
        public static final ConfiguredDecorator<?> SQUARE_HEIGHTMAP;

        static {
            HEIGHTMAP = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING));
            SQUARE_HEIGHTMAP = HEIGHTMAP.spreadHorizontally();
        }
    }
}
