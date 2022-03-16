package com.brand.blockus.blocks.generator;

import com.brand.blockus.world.BlockusConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class WhiteOakSaplingGenerator extends SaplingGenerator {


    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return BlockusConfiguredFeatures.WHITE_OAK_TREE;
    }
}
