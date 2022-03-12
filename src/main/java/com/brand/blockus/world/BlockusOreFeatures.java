package com.brand.blockus.world;

import com.brand.blockus.content.types.BSSWTypes;
import net.minecraft.world.gen.feature.*;

public class BlockusOreFeatures {

    public static final ConfiguredFeature<?, ?> ORE_LIMESTONE = ConfiguredFeatures.register("ore_limestone", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BSSWTypes.LIMESTONE.block.getDefaultState(), 64)));
    public static final ConfiguredFeature<?, ?> ORE_MARBLE = ConfiguredFeatures.register("ore_marble", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BSSWTypes.MARBLE.block.getDefaultState(), 64)));
    public static final ConfiguredFeature<?, ?> ORE_BLUESTONE = ConfiguredFeatures.register("ore_bluestone", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BSSWTypes.BLUESTONE.block.getDefaultState(), 64)));

}
