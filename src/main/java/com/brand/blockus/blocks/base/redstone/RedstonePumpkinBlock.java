package com.brand.blockus.blocks.base.redstone;

import net.minecraft.block.BlockState;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class RedstonePumpkinBlock extends CarvedPumpkinBlock {

    public RedstonePumpkinBlock(Settings settings) {
        super(settings);
    }

    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(FACING).getOpposite() == direction ? 15 : 0;
    }

}


