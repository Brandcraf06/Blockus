package com.brand.blockus.world;

import com.brand.blockus.content.BlockusBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class BlockusTreeConfiguredFeatures {

    public static final ConfiguredFeature<TreeFeatureConfig, ?> WHITE_OAK;

    private static TreeFeatureConfig.Builder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(log), new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight), BlockStateProvider.of(leaves), new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 5), new TwoLayersFeatureSize(1, 0, 1));
    }

    static {
        WHITE_OAK = ConfiguredFeatures.register("white_oak", Feature.TREE.configure(builder(BlockusBlocks.WHITE_OAK_LOG, BlockusBlocks.WHITE_OAK_LEAVES, 7, 2, 0, 2).ignoreVines().build()));
    }
}