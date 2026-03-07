package com.brand.blockus.blocks.base;

import com.brand.blockus.registry.tag.BlockusBlockTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmallHedgeBlock extends CrossCollisionBlock {
    public static final MapCodec<SmallHedgeBlock> CODEC = simpleCodec(SmallHedgeBlock::new);

    public MapCodec<? extends SmallHedgeBlock> codec() {
        return CODEC;
    }

    public SmallHedgeBlock(BlockBehaviour.Properties properties) {
        super(6.0F, 16.0F, 6.0F, 16.0F, 24.0F, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false));
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockGetter blockView = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.south();
        BlockPos blockPos4 = blockPos.west();
        BlockPos blockPos5 = blockPos.east();
        BlockState blockState = blockView.getBlockState(blockPos2);
        BlockState blockState2 = blockView.getBlockState(blockPos3);
        BlockState blockState3 = blockView.getBlockState(blockPos4);
        BlockState blockState4 = blockView.getBlockState(blockPos5);
        return this.defaultBlockState().setValue(NORTH, this.connectsTo(blockState, blockState.isFaceSturdy(blockView, blockPos2, Direction.SOUTH), Direction.SOUTH)).setValue(SOUTH, this.connectsTo(blockState2, blockState2.isFaceSturdy(blockView, blockPos3, Direction.NORTH), Direction.NORTH)).setValue(WEST, this.connectsTo(blockState3, blockState3.isFaceSturdy(blockView, blockPos4, Direction.EAST), Direction.EAST)).setValue(EAST, this.connectsTo(blockState4, blockState4.isFaceSturdy(blockView, blockPos5, Direction.WEST), Direction.WEST)).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    public BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            tickView.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return direction.getAxis().isHorizontal() ? state.setValue(PROPERTY_BY_DIRECTION.get(direction), this.connectsTo(neighborState, neighborState.isFaceSturdy(world, neighborPos, direction.getOpposite()), direction.getOpposite())) : super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    public boolean skipRendering(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.is(this)) {
            if (!direction.getAxis().isHorizontal()) {
                return true;
            }

            if ((Boolean) state.getValue((Property) PROPERTY_BY_DIRECTION.get(direction)) && (Boolean) stateFrom.getValue((Property) PROPERTY_BY_DIRECTION.get(direction.getOpposite()))) {
                return true;
            }
        }

        return super.skipRendering(state, stateFrom, direction);
    }

    public final boolean connectsTo(BlockState state, boolean faceFullSquare, Direction side) {
        Block block = state.getBlock();
        boolean bl = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(state, side);
        return state.is(BlockusBlockTags.HEDGES) || block instanceof LeavesBlock || !isExceptionForConnection(state) && faceFullSquare || block instanceof IronBarsBlock || bl;
    }

    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
