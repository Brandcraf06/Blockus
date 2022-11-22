package com.brand.blockus.blocks.generator;

import com.brand.blockus.world.BlockusConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class LegacyOakSaplingGenerator extends SaplingGenerator {


    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return BlockusConfiguredFeatures.LEGACY_OAK_TREE;
    }
}
