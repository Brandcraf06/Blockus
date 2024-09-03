package com.brand.blockus.blocks.base;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ObsidianPressurePlateBlock extends AbstractPressurePlateBlock {
    public static final BooleanProperty POWERED;

    public ObsidianPressurePlateBlock(Settings settings) {
        super(settings, BlockSetType.STONE);
        this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false));
    }

    protected int getRedstoneOutput(BlockState state) {
        return state.get(POWERED) ? 15 : 0;
    }

    protected BlockState setRedstoneOutput(BlockState state, int rsOut) {
        return state.with(POWERED, rsOut > 0);
    }

    protected int getRedstoneOutput(World world, BlockPos pos) {
        return getEntityCount(world, BOX.offset(pos), PlayerEntity.class) > 0 ? 15 : 0;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    static {
        POWERED = Properties.POWERED;
    }
}
