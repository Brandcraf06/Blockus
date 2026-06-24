package com.brand.blockus.blocks.generator;

import com.brand.blockus.worldgen.BlockusWorldgenFeatures;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

public final class BlockusTreeGrower {
    public static final TreeGrower WHITE_OAK;
    public static final TreeGrower LEGACY_OAK;

    static {
        WHITE_OAK = new TreeGrower("white_oak", WeightedList.of(BlockusWorldgenFeatures.WHITE_OAK), WeightedList.of(), WeightedList.of(), BlockusWorldgenFeatures.WHITE_OAK);
        LEGACY_OAK = new TreeGrower("legacy_oak", WeightedList.of(BlockusWorldgenFeatures.LEGACY_OAK), WeightedList.of(), WeightedList.of(), BlockusWorldgenFeatures.LEGACY_OAK);
    }
}
