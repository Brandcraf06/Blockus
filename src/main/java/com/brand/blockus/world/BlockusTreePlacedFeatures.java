package com.brand.blockus.world;

import com.brand.blockus.content.BlockusBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class BlockusTreePlacedFeatures {

    public static final PlacedFeature WHITE_OAK_CHECKED;

    static {
        WHITE_OAK_CHECKED = BlockusTreeConfiguredFeatures.WHITE_OAK.withWouldSurviveFilter(BlockusBlocks.WHITE_OAK_SAPLING);
    }
}