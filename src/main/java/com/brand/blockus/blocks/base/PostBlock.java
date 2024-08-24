package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.data.client.Models;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class PostBlock extends PillarBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED;
    public static final BooleanProperty NORTH;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    public static final BooleanProperty EAST;
    public static final MapCodec<PostBlock> CODEC = createCodec(PostBlock::new);
    protected static final float field_31054 = 6.5F;
    protected static final float field_31055 = 9.5F;
    protected static final VoxelShape Y_SHAPE;
    protected static final VoxelShape Z_SHAPE;
    protected static final VoxelShape X_SHAPE;
    protected static final VoxelShape COMPLETE_SHAPE;

    public PostBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(AXIS, Axis.Y).with(NORTH, false).with(SOUTH, false).with(WEST, false).with(EAST, false));
    }

    public MapCodec<PostBlock> getCodec() {
        return CODEC;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = this.getBaseShape(state);

        if (state.get(NORTH)) {
            shape = VoxelShapes.union(shape, Block.createCuboidShape(6.0, 6.0, 0.0, 10.0, 10.0, 6.0));
        }
        if (state.get(SOUTH)) {
            shape = VoxelShapes.union(shape, Block.createCuboidShape(6.0, 6.0, 10.0, 10.0, 10.0, 16.0));
        }
        if (state.get(WEST)) {
            shape = VoxelShapes.union(shape, Block.createCuboidShape(0.0, 6.0, 6.0, 6.0, 10.0, 10.0));
        }
        if (state.get(EAST)) {
            shape = VoxelShapes.union(shape, Block.createCuboidShape(10.0, 6.0, 6.0, 16.0, 10.0, 10.0));
        }

        return shape;
    }

    private VoxelShape getBaseShape(BlockState state) {
        switch (state.get(AXIS)) {
            case X:
                return X_SHAPE;
            case Z:
                return Z_SHAPE;
            case Y:
            default:
                return Y_SHAPE;
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;
        return super.getPlacementState(ctx).with(WATERLOGGED, bl);
    }

    private BlockState getConnections(World world, BlockPos pos, BlockState state) {
        Axis axis = state.get(AXIS);
        return state.with(NORTH, axis != Axis.Z && this.shouldConnect(world, pos, Direction.NORTH))
            .with(SOUTH, axis != Axis.Z && this.shouldConnect(world, pos, Direction.SOUTH))
            .with(WEST, axis != Axis.X && this.shouldConnect(world, pos, Direction.WEST))
            .with(EAST, axis != Axis.X && this.shouldConnect(world, pos, Direction.EAST));
    }

    private boolean shouldConnect(World world, BlockPos pos, Direction direction) {
        BlockState neighborState = world.getBlockState(pos.offset(direction));

        if (neighborState.getBlock() instanceof WallSignBlock) {
            return direction == neighborState.get(Properties.HORIZONTAL_FACING);
        }

        return false;
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return this.getConnections((World) world, pos, super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS, NORTH, SOUTH, WEST, EAST);
    }

    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
        NORTH = ConnectingBlock.NORTH;
        EAST = ConnectingBlock.EAST;
        SOUTH = ConnectingBlock.SOUTH;
        WEST = ConnectingBlock.WEST;

        Y_SHAPE = Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
        Z_SHAPE = Block.createCuboidShape(6.0, 6.0, 0.0, 10.0, 10.0, 16.0);
        X_SHAPE = Block.createCuboidShape(0.0, 6.0, 6.0, 16.0, 10.0, 10.0);
        COMPLETE_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0); // Placeholder for a fully connected shape
    }
}
