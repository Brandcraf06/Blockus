package com.brand.blockus.world;

import com.brand.blockus.content.Bluestone;
import com.brand.blockus.content.Limestone;
import com.brand.blockus.content.Marble;
import com.brand.blockus.content.WhiteOak;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.decorator.CountChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDepthDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.BranchedTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class BlockusGen {
	
	public static final BranchedTreeFeatureConfig WHITE_OAK_TREE_CONFIG;
	private static final BlockState WHITE_OAK_LOG;
	private static final BlockState WHITE_OAK_LEAVES;
	private static final BlockState OAK_LOG;
	private static final BlockState OAK_LEAVES;
	public static final BranchedTreeFeatureConfig OAK_TREE_CONFIG;
	
	public static void addMineables(Biome biome) {
       biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Limestone.LIMESTONE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 120))));
	   biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Marble.MARBLE.getDefaultState(), 70)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(1, 0, 0, 75))));
	   biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Bluestone.BLUESTONE.getDefaultState(), 20)).createDecoratedFeature(Decorator.COUNT_DEPTH_AVERAGE.configure(new CountDepthDecoratorConfig(8, 16, 16))));
	}
	public static void addWhiteOakTrees(Biome biome) {
		if (biome == Biomes.FOREST || biome == Biomes.WOODED_HILLS || biome == Biomes.FLOWER_FOREST) {
			biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(WHITE_OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(1, 0.05F))));
      }
    }
	public static void addPlainsWhiteOakTrees(Biome biome) {
		if (biome.getCategory() == Biome.Category.PLAINS) {
			biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(WHITE_OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(1, 0.0085F))));
      }
    }

	   static {
	 OAK_LOG = Blocks.OAK_LOG.getDefaultState();
	 OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
	 OAK_TREE_CONFIG = (new BranchedTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).noVines().build();
     WHITE_OAK_LOG = WhiteOak.WHITE_OAK_LOG.getDefaultState();
     WHITE_OAK_LEAVES = WhiteOak.WHITE_OAK_LEAVES.getDefaultState();
     WHITE_OAK_TREE_CONFIG = (new BranchedTreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_OAK_LOG), new SimpleBlockStateProvider(WHITE_OAK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(7).heightRandA(2).foliageHeight(5).noVines().build();
		   
	}
  }