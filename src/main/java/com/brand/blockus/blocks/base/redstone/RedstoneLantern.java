package com.brand.blockus.blocks.base.redstone;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RedstoneLantern extends LanternBlock {

    public RedstoneLantern(Properties settings) {
        super(settings);
    }

    public boolean isSignalSource(BlockState state) {
        return true;
    }

    public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
        return Direction.UP != direction ? 15 : 0;
    }

}


