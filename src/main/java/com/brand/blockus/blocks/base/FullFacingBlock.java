package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;

public class FullFacingBlock extends FacingBlock {

    public static final MapCodec<FullFacingBlock> CODEC = createCodec(FullFacingBlock::new);


    public FullFacingBlock(Settings settings) {
        super(settings);
    }

    public MapCodec<FullFacingBlock> getCodec() {
        return CODEC;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }
}
