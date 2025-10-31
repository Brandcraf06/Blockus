package com.brand.blockus.blocks.base.amethyst;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.redstone.Orientation;
import org.jetbrains.annotations.Nullable;

public class AmethystLampBlock extends Block {
    public static final IntegerProperty POWER = BlockStateProperties.POWER;

    public AmethystLampBlock(Properties settings) {
        super(settings.lightLevel(state -> state.getValue(POWER)));
        this.registerDefaultState(this.stateDefinition.any().setValue(POWER, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(POWER, Math.min(15, ctx.getLevel().getBestNeighborSignal(ctx.getClickedPos())));
    }

    protected void neighborChanged(BlockState state, Level world, BlockPos pos, Block sourceBlock, @Nullable Orientation wireOrientation, boolean notify) {
        if (!world.isClientSide()) {
            int power = Math.min(15, world.getBestNeighborSignal(pos));
            if (power != state.getValue(POWER)) {
                world.setBlock(pos, state.setValue(POWER, power), Block.UPDATE_ALL);
            }
        }
    }

    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos, Direction direction) {
        return state.getValue(POWER);
    }
}
