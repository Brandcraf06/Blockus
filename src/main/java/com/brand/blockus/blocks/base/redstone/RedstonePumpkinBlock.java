package com.brand.blockus.blocks.base.redstone;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RedstonePumpkinBlock extends CarvedPumpkinBlock {

    public RedstonePumpkinBlock(Properties settings) {
        super(settings);
    }

    public boolean isSignalSource(BlockState state) {
        return true;
    }

    public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
        return state.getValue(FACING).getOpposite() == direction ? 15 : 0;
    }

}


