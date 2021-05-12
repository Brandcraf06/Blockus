package com.brand.blockus.blocks.base.redstone;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class FallingRedstoneBlock extends FallingBlock {

    public FallingRedstoneBlock(Settings settings) {
        super(settings);
    }

    public boolean emitsRedstonePower(BlockState blockState_1) {
        return true;
    }

    public int getWeakRedstonePower(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, Direction direction_1) {
        return 15;
    }
}
