package com.brand.blockus.blocks.base.redstone;

import com.brand.blockus.blocks.base.SimpleFallingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class FallingRedstoneBlock extends SimpleFallingBlock {

    public FallingRedstoneBlock(Properties settings) {
        super(settings);
    }

    public boolean isSignalSource(BlockState state) {
        return true;
    }

    public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
        return 15;
    }
}

