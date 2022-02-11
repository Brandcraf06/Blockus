package com.brand.blockus.world;

import com.brand.blockus.content.BlockusBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

public class BlockusOreFeatures {

    public static final ConfiguredFeature<?, ?> ORE_LIMESTONE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.LIMESTONE.getDefaultState(), 64));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_MARBLE = ConfiguredFeatures.register("ore_marble", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.MARBLE.getDefaultState(), 64));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_BLUESTONE = ConfiguredFeatures.register("ore_bluestone", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockusBlocks.BLUESTONE.getDefaultState(), 64));

}
