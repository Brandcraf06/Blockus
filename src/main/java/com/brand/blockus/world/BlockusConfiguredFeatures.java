package com.brand.blockus.world;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;


public class BlockusConfiguredFeatures {

    public static final TreeFeatureConfig WHITE_OAK_CONFIG;
    public static final ConfiguredFeature<?, ?> LIMESTONE_UPPER;
    public static final ConfiguredFeature<?, ?> LIMESTONE_LOWER;
    public static final ConfiguredFeature<?, ?> MARBLE;
    public static final ConfiguredFeature<?, ?> BLUESTONE;
    public static final ConfiguredFeature<?, ?> WHITE_OAK_CHECKED;
    public static final ConfiguredFeature<?, ?> WHITE_OAK;
    public static final ConfiguredFeature<?, ?> WHITE_OAK_RARE;

    private static TreeFeatureConfig.Builder method_38746() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LOG.getDefaultState()), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LEAVES.getDefaultState()), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    static {
        LIMESTONE_UPPER = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.getDefaultState(), 64)).uniformRange(YOffset.fixed(64), YOffset.fixed(128)).spreadHorizontally().applyChance(6);
        LIMESTONE_LOWER = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.getDefaultState(), 64)).uniformRange(YOffset.fixed(0), YOffset.fixed(60)).spreadHorizontally().repeat(2);
        MARBLE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.MARBLE.getDefaultState(), 64)).uniformRange(YOffset.fixed(0), YOffset.fixed(75)).spreadHorizontally().repeat(2);
        BLUESTONE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.BLUESTONE.getDefaultState(), 64)).uniformRange(YOffset.getBottom(), YOffset.fixed(0)).spreadHorizontally().repeat(2);
        WHITE_OAK_CONFIG = new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LOG.getDefaultState()), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.of(BlockusBlocks.WHITE_OAK_LEAVES.getDefaultState()), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build();
        WHITE_OAK = Feature.TREE.configure(WHITE_OAK_CONFIG).decorate(Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.05F, 1)));
        WHITE_OAK_RARE = Feature.TREE.configure(WHITE_OAK_CONFIG).decorate(Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.0085F, 1)));
        WHITE_OAK_CHECKED = WHITE_OAK.method_38670(BlockusBlocks.WHITE_OAK_SAPLING);

    }

    public static void registerConfiguredFeature() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "limestone_upper"), LIMESTONE_UPPER);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "limestone_lower"), LIMESTONE_LOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "marble"), MARBLE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "bluestone"), BLUESTONE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "white_oak"), WHITE_OAK);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "white_oak_rare"), WHITE_OAK_RARE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "white_oak_checked"), WHITE_OAK_CHECKED);
    }

       public static void registerBiomeModifications() {
        BiomeModifications.create(new Identifier(Blockus.MOD_ID, "world_features"))
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.foundInOverworld(),
                        context -> {
                            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, LIMESTONE_UPPER);
                            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, LIMESTONE_LOWER);
                            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, MARBLE);
                            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, BLUESTONE);
                        })
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.WOODED_HILLS, BiomeKeys.FLOWER_FOREST),
                        context -> context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.VEGETAL_DECORATION, WHITE_OAK))
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.categories(Biome.Category.PLAINS),
                        context -> context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.VEGETAL_DECORATION, WHITE_OAK_RARE));
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