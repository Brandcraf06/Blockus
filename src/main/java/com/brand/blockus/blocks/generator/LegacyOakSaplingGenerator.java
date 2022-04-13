package com.brand.blockus.blocks.generator;

import com.brand.blockus.world.BlockusConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.util.math.random.AbstractRandom;

import java.util.Random;

public class LegacyOakSaplingGenerator extends SaplingGenerator {


    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(AbstractRandom random, boolean bees) {
        return BlockusConfiguredFeatures.LEGACY_OAK_TREE;
    }
}
