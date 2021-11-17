package com.brand.blockus.world;

import com.brand.blockus.content.BlockusBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.*;

public class BlockusOreConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> ORE_LIMESTONE;
    public static final ConfiguredFeature<?, ?> ORE_MARBLE;
    public static final ConfiguredFeature<?, ?> ORE_BLUESTONE;

    static {
        ORE_LIMESTONE = ConfiguredFeatures.register("ore_limestone", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.getDefaultState(), 64)));
        ORE_MARBLE = ConfiguredFeatures.register("ore_marble", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.MARBLE.getDefaultState(), 64)));
        ORE_BLUESTONE = ConfiguredFeatures.register("ore_bluestone", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.BLUESTONE.getDefaultState(), 64)));
    }
}
