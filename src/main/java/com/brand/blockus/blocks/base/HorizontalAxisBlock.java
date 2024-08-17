package com.brand.blockus.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class HorizontalAxisBlock extends Block {
    public static final EnumProperty<Direction.Axis> HORIZONTAL_AXIS;

    public HorizontalAxisBlock(Settings settings) {
        super(settings);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_AXIS);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(HORIZONTAL_AXIS, ctx.getHorizontalPlayerFacing().getAxis());
    }

    static {
        HORIZONTAL_AXIS = Properties.HORIZONTAL_AXIS;
    }
}

