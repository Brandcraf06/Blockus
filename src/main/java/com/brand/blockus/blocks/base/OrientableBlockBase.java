package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;

public class OrientableBlockBase extends HorizontalFacingBlock {
    public static final MapCodec<OrientableBlockBase> CODEC = createCodec(OrientableBlockBase::new);


    public OrientableBlockBase(Settings settings) {
        super(settings);
    }

    public MapCodec<OrientableBlockBase> getCodec() {
        return CODEC;
    }

    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}

