package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleFallingBlock extends FallingBlock {
    public static final MapCodec<SimpleFallingBlock> CODEC = simpleCodec(SimpleFallingBlock::new);

    public MapCodec<SimpleFallingBlock> codec() {
        return CODEC;
    }

    public int getDustColor(BlockState state, BlockGetter world, BlockPos pos) {
        return state.getMapColor(world, pos).col;
    }

    public SimpleFallingBlock(Properties properties) {
        super(properties);
    }

}
