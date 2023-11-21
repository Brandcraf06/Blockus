package com.brand.blockus.blocks.base.redstone;

import com.brand.blockus.blocks.base.SimpleFallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class FallingRedstoneBlock extends SimpleFallingBlock {

    public FallingRedstoneBlock(Settings settings) {
        super(settings);
    }

    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 15;
    }
}

