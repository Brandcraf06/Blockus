package com.brand.blockus.blocks.generator;

import com.brand.blockus.worldgen.BlockusWorldgenFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public final class BlockusSaplingGenerator {
    public static final TreeGrower WHITE_OAK;
    public static final TreeGrower LEGACY_OAK;

    static {
        WHITE_OAK = new TreeGrower("white_oak", Optional.empty(), Optional.of(BlockusWorldgenFeatures.WHITE_OAK), Optional.empty());
        LEGACY_OAK = new TreeGrower("legacy_oak", Optional.empty(), Optional.of(BlockusWorldgenFeatures.LEGACY_OAK), Optional.empty());
    }
}
