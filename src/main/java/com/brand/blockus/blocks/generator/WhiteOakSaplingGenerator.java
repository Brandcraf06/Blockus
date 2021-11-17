package com.brand.blockus.blocks.generator;

import com.brand.blockus.world.BlockusConfiguredFeatures;
import com.brand.blockus.world.BlockusTreeConfiguredFeatures;
import com.brand.blockus.world.BlockusTreePlacedFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class WhiteOakSaplingGenerator extends SaplingGenerator {


    protected ConfiguredFeature<?, ?> getTreeFeature(Random random, boolean bees) {
        return BlockusTreeConfiguredFeatures.WHITE_OAK;
    }
}
