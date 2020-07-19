package com.brand.blockus.world;

import com.brand.blockus.content.NewStones;
import com.brand.blockus.content.NewWoods;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.decorator.CountChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDepthDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.Feature;

public class BlockusGen {
	
	public static final TreeFeatureConfig WHITE_OAK_TREE_CONFIG;
	private static final BlockState WHITE_OAK_LOG;
	private static final BlockState WHITE_OAK_LEAVES;
	private static final BlockState OAK_LOG;
	private static final BlockState OAK_LEAVES;
	public static final TreeFeatureConfig OAK_TREE_CONFIG;
	
	public static void addMineables(Biome biome) {
       biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, NewStones.LIMESTONE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 120))));
	   biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, NewStones.MARBLE.getDefaultState(), 70)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(1, 0, 0, 75))));
	   biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, NewStones.BLUESTONE.getDefaultState(), 20)).createDecoratedFeature(Decorator.COUNT_DEPTH_AVERAGE.configure(new CountDepthDecoratorConfig(8, 16, 16))));
	}
	public static void addWhiteOakTrees(Biome biome) {
		if (biome == Biomes.FOREST || biome == Biomes.WOODED_HILLS || biome == Biomes.FLOWER_FOREST) {
			biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(WHITE_OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(1, 0.05F))));
      }
    }
	public static void addPlainsWhiteOakTrees(Biome biome) {
		if (biome.getCategory() == Biome.Category.PLAINS) {
			biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(WHITE_OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(1, 0.0085F))));
      }
    }
	   static {
	 OAK_LOG = Blocks.OAK_LOG.getDefaultState();
	 OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
	 OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
     WHITE_OAK_LOG = NewWoods.WHITE_OAK_LOG.getDefaultState();
     WHITE_OAK_LEAVES = NewWoods.WHITE_OAK_LEAVES.getDefaultState();
     WHITE_OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_OAK_LOG), new SimpleBlockStateProvider(WHITE_OAK_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 5), new StraightTrunkPlacer(7, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
		   
	}
  }