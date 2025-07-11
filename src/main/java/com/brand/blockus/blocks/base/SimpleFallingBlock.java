package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class SimpleFallingBlock extends FallingBlock {
    public static final MapCodec<SimpleFallingBlock> CODEC = createCodec(SimpleFallingBlock::new);

    public MapCodec<SimpleFallingBlock> getCodec() {
        return CODEC;
    }

    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return state.getMapColor(world, pos).color;
    }

    public SimpleFallingBlock(Settings settings) {
        super(settings);
    }

}
