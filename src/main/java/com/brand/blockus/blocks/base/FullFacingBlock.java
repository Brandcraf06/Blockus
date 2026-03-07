package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class FullFacingBlock extends DirectionalBlock {

    public static final MapCodec<FullFacingBlock> CODEC = simpleCodec(FullFacingBlock::new);


    public FullFacingBlock(Properties properties) {
        super(properties);
    }

    public MapCodec<FullFacingBlock> codec() {
        return CODEC;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getNearestLookingDirection().getOpposite());
    }
}
