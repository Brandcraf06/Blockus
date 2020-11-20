package com.brand.blockus.blocks.Sapling;

import com.brand.blockus.world.BlockusConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class WhiteOakSaplingGenerator extends SaplingGenerator {

    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return Feature.TREE.configure(BlockusConfiguredFeatures.WHITE_OAK_TREE_CONFIG);
    }
}
