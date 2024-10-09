package com.brand.blockus.blocks.base;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class PostBlock extends PillarBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED;
    public static final EnumProperty<ConnectionType> NORTH;
    public static final EnumProperty<ConnectionType> SOUTH;
    public static final EnumProperty<ConnectionType> WEST;
    public static final EnumProperty<ConnectionType> EAST;
    public static final EnumProperty<ConnectionType> UP;
    public static final EnumProperty<ConnectionType> DOWN;
    public static final EnumProperty<Axis> AXIS;
    public static final VoxelShape CENTER_SHAPE = Block.createCuboidShape(6.0, 6.0, 6.0, 10.0, 10.0, 10.0);
    public static final VoxelShape DOWN_SHAPE = Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 6.0, 10.0);
    public static final VoxelShape UP_SHAPE = Block.createCuboidShape(6.0, 10.0, 6.0, 10.0, 16.0, 10.0);
    public static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(6.0, 6.0, 0.0, 10.0, 10.0, 6.0);
    public static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(6.0, 6.0, 10.0, 10.0, 10.0, 16.0);
    public static final VoxelShape WEST_SHAPE = Block.createCuboidShape(0.0, 6.0, 6.0, 6.0, 10.0, 10.0);
    public static final VoxelShape EAST_SHAPE = Block.createCuboidShape(10.0, 6.0, 6.0, 16.0, 10.0, 10.0);
    public static final VoxelShape[] CONNECTION_SHAPES = new VoxelShape[]{DOWN_SHAPE, UP_SHAPE, NORTH_SHAPE, SOUTH_SHAPE, WEST_SHAPE, EAST_SHAPE};
    public static final VoxelShape[] SHAPE_CACHE = new VoxelShape[64 * 3];
    public static final EnumProperty<ConnectionType>[] SIDES;


    public PostBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(WATERLOGGED, false)
                .with(AXIS, Axis.Y)
                .with(NORTH, ConnectionType.NONE)
                .with(SOUTH, ConnectionType.NONE)
                .with(WEST, ConnectionType.NONE)
                .with(EAST, ConnectionType.NONE)
                .with(UP, ConnectionType.NONE)
                .with(DOWN, ConnectionType.NONE)
        );
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int index = 0;
        for (Direction direction : Direction.values()) {
            if (state.get(SIDES[direction.ordinal()]) != ConnectionType.NONE) {
                index += (1 << direction.ordinal());
            }
        }
        index += (64 * state.get(AXIS).ordinal());

        VoxelShape shapeCache = SHAPE_CACHE[index];
        if (shapeCache == null) {
            VoxelShape centerShape = CENTER_SHAPE;

            for (Direction dir : Direction.values()) {
                if (isConnected(state, dir)) {
                    centerShape = VoxelShapes.union(centerShape, CONNECTION_SHAPES[dir.ordinal()]);
                }
            }

            SHAPE_CACHE[index] = centerShape;
            shapeCache = centerShape;
        }

        return shapeCache;
    }

    private boolean isConnected(BlockState state, Direction dir) {
        if (state.get(AXIS) == dir.getAxis()) {
            return true;
        }
        return state.get(SIDES[dir.ordinal()]) != ConnectionType.NONE;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;
        return super.getPlacementState(ctx).with(WATERLOGGED, bl);
    }

    private ConnectionType shouldConnect(World world, BlockPos pos, Direction direction) {
        BlockState neighborState = world.getBlockState(pos.offset(direction));

        if (neighborState.getBlock() instanceof WallSignBlock) {
            return direction == neighborState.get(Properties.HORIZONTAL_FACING) ? ConnectionType.POST : ConnectionType.NONE;
        }

        if (neighborState.getBlock() instanceof ChainBlock && neighborState.get(Properties.AXIS) == direction.getAxis()) {
            return ConnectionType.CHAIN;
        }

        if (neighborState.getBlock() instanceof PostBlock && neighborState.get(Properties.AXIS) == direction.getAxis()) {
            return ConnectionType.POST;
        }

        if (direction == Direction.UP && neighborState.isIn(BlockTags.WALL_POST_OVERRIDE)) {
            return ConnectionType.POST;
        }

        return ConnectionType.NONE;
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (state.get(WATERLOGGED)) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        state = state.with(SIDES[direction.ordinal()], this.shouldConnect((World) world, pos, direction));
        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS, NORTH, SOUTH, WEST, EAST, UP, DOWN);
    }

    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
        AXIS = Properties.AXIS;
        NORTH = EnumProperty.of("north", ConnectionType.class);
        SOUTH = EnumProperty.of("south", ConnectionType.class);
        WEST = EnumProperty.of("west", ConnectionType.class);
        EAST = EnumProperty.of("east", ConnectionType.class);
        UP = EnumProperty.of("up", ConnectionType.class);
        DOWN = EnumProperty.of("down", ConnectionType.class);
        SIDES = new EnumProperty[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};
    }

    public enum ConnectionType implements StringIdentifiable {
        NONE("none"),
        CHAIN("chain"),
        POST("post");

        private final String name;

        ConnectionType(String name) {
            this.name = name;
        }

        @Override
        public String asString() {
            return this.name;
        }
    }
}
