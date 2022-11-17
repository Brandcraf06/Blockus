package com.brand.blockus.blocks.generator;

import com.brand.blockus.worldgen.BlockusWorldgenFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class LegacyOakSaplingGenerator extends SaplingGenerator {


    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return BlockusWorldgenFeatures.LEGACY_OAK;
    }
}
