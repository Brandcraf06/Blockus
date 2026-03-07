package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class OrientableBlockBase extends HorizontalDirectionalBlock {
    public static final MapCodec<OrientableBlockBase> CODEC = simpleCodec(OrientableBlockBase::new);


    public OrientableBlockBase(Properties properties) {
        super(properties);
    }

    public MapCodec<OrientableBlockBase> codec() {
        return CODEC;
    }

    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }
}

