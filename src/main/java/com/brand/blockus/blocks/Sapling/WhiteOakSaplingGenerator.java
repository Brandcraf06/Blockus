package com.brand.blockus.blocks.Sapling;

import java.util.Random;

import com.brand.blockus.world.BlockusGen;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class WhiteOakSaplingGenerator extends SaplingGenerator {
	
	   protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
		   return Feature.TREE.configure(BlockusGen.WHITE_OAK_TREE_CONFIG);
	   }
	}
