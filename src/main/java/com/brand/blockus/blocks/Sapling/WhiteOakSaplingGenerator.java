package com.brand.blockus.blocks.Sapling;

import java.util.Random;

import com.brand.blockus.world.BlockusGen;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.BranchedTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

public class WhiteOakSaplingGenerator extends SaplingGenerator {
	
	   protected ConfiguredFeature<BranchedTreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
		   return Feature.NORMAL_TREE.configure(BlockusGen.WHITE_OAK_TREE_CONFIG);
	   }
	}
