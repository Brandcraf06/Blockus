package com.brand.blockus.world;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
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
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class BlockusConfiguredFeatures {

    public static final TreeFeatureConfig WHITE_OAK_TREE_CONFIG;
    public static final ConfiguredFeature<?, ?> LIMESTONE;
    public static final ConfiguredFeature<?, ?> MARBLE;
    public static final ConfiguredFeature<?, ?> BLUESTONE;
    public static final ConfiguredFeature<?, ?> WHITE_OAK_TREE;
    public static final ConfiguredFeature<?, ?> WHITE_OAK_TREE_RARE;

    static {
        LIMESTONE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.getDefaultState(), 33)).uniformRange(YOffset.fixed(32), YOffset.fixed(128)).spreadHorizontally().repeat(10);
        MARBLE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.MARBLE.getDefaultState(), 33)).uniformRange(YOffset.fixed(0), YOffset.fixed(75)).spreadHorizontally().repeat(10);
        BLUESTONE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockusBlocks.BLUESTONE.getDefaultState(), 33)).uniformRange(YOffset.getBottom(), YOffset.fixed(25)).spreadHorizontally().repeat(10);
        WHITE_OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockusBlocks.WHITE_OAK_LOG.getDefaultState()),
                new StraightTrunkPlacer(7, 2, 0),
                new SimpleBlockStateProvider(BlockusBlocks.WHITE_OAK_LEAVES.getDefaultState()),
                new SimpleBlockStateProvider(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState()),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5),
                new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
        WHITE_OAK_TREE = Feature.TREE.configure(WHITE_OAK_TREE_CONFIG).decorate(Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.05F, 1)));
        WHITE_OAK_TREE_RARE = Feature.TREE.configure(WHITE_OAK_TREE_CONFIG).decorate(Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.0085F, 1)));
    }

    public static void registerConfiguredFeature() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "limestone"), LIMESTONE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "marble"), MARBLE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "bluestone"), BLUESTONE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "white_oak_tree"), WHITE_OAK_TREE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "white_oak_tree_rare"), WHITE_OAK_TREE_RARE);
    }

    public static void registerBiomeModifications() {
        BiomeModifications.create(new Identifier(Blockus.MOD_ID, "world_features"))
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.foundInOverworld(),
                        context -> {
                            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, LIMESTONE);
                            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, MARBLE);
                            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, BLUESTONE);
                        })
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.WOODED_HILLS, BiomeKeys.FLOWER_FOREST),
                        context -> context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.VEGETAL_DECORATION, WHITE_OAK_TREE))
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.categories(Biome.Category.PLAINS),
                        context -> context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.VEGETAL_DECORATION, WHITE_OAK_TREE_RARE));
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
