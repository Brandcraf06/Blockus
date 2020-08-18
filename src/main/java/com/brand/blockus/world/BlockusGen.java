package com.brand.blockus.world;

import com.brand.blockus.content.NewStones;
import com.brand.blockus.content.NewWoods;
import me.shedaniel.cloth.api.dynamic.registry.v1.BiomesRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class BlockusGen {
	
	public static final TreeFeatureConfig WHITE_OAK_TREE_CONFIG;
	private static final BlockState WHITE_OAK_LOG;
	private static final BlockState WHITE_OAK_LEAVES;
	private static final BlockState OAK_LOG;
	private static final BlockState OAK_LEAVES;
	public static final TreeFeatureConfig OAK_TREE_CONFIG;
	
	public static void addMineables(RegistryKey<Biome> registryKey, Biome biome) {
		BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NewStones.LIMESTONE.getDefaultState(), 33)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 120)).spreadHorizontally().repeat(10)));
		BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NewStones.MARBLE.getDefaultState(), 70)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 75)).spreadHorizontally().repeat(1)));
		BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NewStones.BLUESTONE.getDefaultState(), 20)).decorate(Decorator.DEPTH_AVERAGE.configure(new DepthAverageDecoratorConfig(16, 16)).spreadHorizontally().repeat(8)));
	}
	
	public static void addWhiteOakTrees(RegistryKey<Biome> registryKey, Biome biome) {
		if (registryKey.equals(BiomeKeys.FOREST) || registryKey.equals(BiomeKeys.WOODED_HILLS) || registryKey.equals(BiomeKeys.FLOWER_FOREST)) {
			BiomesRegistry.registerFeature(biome, GenerationStep.Feature.VEGETAL_DECORATION, () -> Feature.TREE.configure(WHITE_OAK_TREE_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.05F, 1))));
		}
	}
	
	public static void addPlainsWhiteOakTrees(RegistryKey<Biome> registryKey, Biome biome) {
		if (biome.getCategory() == Biome.Category.PLAINS) {
			BiomesRegistry.registerFeature(biome, GenerationStep.Feature.VEGETAL_DECORATION, () -> Feature.TREE.configure(WHITE_OAK_TREE_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.0085F, 1))));
		}
	}
	
	static {
		OAK_LOG = Blocks.OAK_LOG.getDefaultState();
		OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
		OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
		WHITE_OAK_LOG = NewWoods.WHITE_OAK_LOG.getDefaultState();
		WHITE_OAK_LEAVES = NewWoods.WHITE_OAK_LEAVES.getDefaultState();
		WHITE_OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_OAK_LOG), new SimpleBlockStateProvider(WHITE_OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 5), new StraightTrunkPlacer(7, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
	}
}