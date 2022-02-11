package com.brand.blockus.blocks.generator;

import com.brand.blockus.world.BlockusVegetationFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class WhiteOakSaplingGenerator extends SaplingGenerator {


    protected RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> getTreeFeature(Random random, boolean bees) {
        return BlockusVegetationFeatures.WHITE_OAK;
    }
}
