package com.brand.blockus.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BellAttachType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PostBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED;
    public static final EnumProperty<ConnectionType> NORTH;
    public static final EnumProperty<ConnectionType> SOUTH;
    public static final EnumProperty<ConnectionType> WEST;
    public static final EnumProperty<ConnectionType> EAST;
    public static final EnumProperty<ConnectionType> UP;
    public static final EnumProperty<ConnectionType> DOWN;
    public static final EnumProperty<Axis> AXIS;
    public static final VoxelShape CENTER_SHAPE = Block.box(6.0, 6.0, 6.0, 10.0, 10.0, 10.0);
    public static final VoxelShape DOWN_SHAPE = Block.box(6.0, 0.0, 6.0, 10.0, 6.0, 10.0);
    public static final VoxelShape UP_SHAPE = Block.box(6.0, 10.0, 6.0, 10.0, 16.0, 10.0);
    public static final VoxelShape NORTH_SHAPE = Block.box(6.0, 6.0, 0.0, 10.0, 10.0, 6.0);
    public static final VoxelShape SOUTH_SHAPE = Block.box(6.0, 6.0, 10.0, 10.0, 10.0, 16.0);
    public static final VoxelShape WEST_SHAPE = Block.box(0.0, 6.0, 6.0, 6.0, 10.0, 10.0);
    public static final VoxelShape EAST_SHAPE = Block.box(10.0, 6.0, 6.0, 16.0, 10.0, 10.0);
    public static final VoxelShape[] CONNECTION_SHAPES = new VoxelShape[]{DOWN_SHAPE, UP_SHAPE, NORTH_SHAPE, SOUTH_SHAPE, WEST_SHAPE, EAST_SHAPE};
    public static final VoxelShape[] SHAPE_CACHE = new VoxelShape[64 * 3];
    public static final EnumProperty<ConnectionType>[] SIDES;


    public PostBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(WATERLOGGED, false)
            .setValue(AXIS, Axis.Y)
            .setValue(NORTH, ConnectionType.NONE)
            .setValue(SOUTH, ConnectionType.NONE)
            .setValue(WEST, ConnectionType.NONE)
            .setValue(EAST, ConnectionType.NONE)
            .setValue(UP, ConnectionType.NONE)
            .setValue(DOWN, ConnectionType.NONE)
        );
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        int index = 0;
        for (Direction direction : Direction.values()) {
            if (state.getValue(SIDES[direction.ordinal()]) != ConnectionType.NONE) {
                index += (1 << direction.ordinal());
            }
        }
        index += (64 * state.getValue(AXIS).ordinal());

        VoxelShape shapeCache = SHAPE_CACHE[index];
        if (shapeCache == null) {
            VoxelShape centerShape = CENTER_SHAPE;

            for (Direction dir : Direction.values()) {
                if (isConnected(state, dir)) {
                    centerShape = Shapes.or(centerShape, CONNECTION_SHAPES[dir.ordinal()]);
                }
            }

            SHAPE_CACHE[index] = centerShape;
            shapeCache = centerShape;
        }

        return shapeCache;
    }

    private boolean isConnected(BlockState state, Direction dir) {
        if (state.getValue(AXIS) == dir.getAxis()) {
            return true;
        }
        return state.getValue(SIDES[dir.ordinal()]) != ConnectionType.NONE;
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        boolean bl = fluidState.getType() == Fluids.WATER;
        return super.getStateForPlacement(ctx).setValue(WATERLOGGED, bl);
    }

    private ConnectionType shouldConnect(Level world, BlockPos pos, Direction direction) {
        BlockState neighborState = world.getBlockState(pos.relative(direction));

        if (neighborState.getBlock() instanceof WallSignBlock) {
            return direction == neighborState.getValue(BlockStateProperties.HORIZONTAL_FACING) ? ConnectionType.POST : ConnectionType.NONE;
        }

        if ((neighborState.getBlock() instanceof ChainBlock && neighborState.getValue(BlockStateProperties.AXIS) == direction.getAxis())
            || (direction == Direction.DOWN && neighborState.getBlock() instanceof LanternBlock && neighborState.getValue(LanternBlock.HANGING))
            || (direction == Direction.DOWN && neighborState.getBlock() instanceof CeilingHangingSignBlock)) {
            return ConnectionType.CHAIN;
        }

        if ((neighborState.getBlock() instanceof PostBlock && neighborState.getValue(BlockStateProperties.AXIS) == direction.getAxis())
            || (direction == Direction.UP && neighborState.is(BlockTags.WALL_POST_OVERRIDE))
            || (direction == Direction.DOWN && neighborState.getBlock() instanceof BellBlock) && neighborState.getValue(BlockStateProperties.BELL_ATTACHMENT) == BellAttachType.CEILING) {
            return ConnectionType.POST;
        }

        return ConnectionType.NONE;
    }

    protected BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            tickView.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        state = state.setValue(SIDES[direction.ordinal()], this.shouldConnect((Level) world, pos, direction));
        return super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS, NORTH, SOUTH, WEST, EAST, UP, DOWN);
    }

    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        AXIS = BlockStateProperties.AXIS;
        NORTH = EnumProperty.create("north", ConnectionType.class);
        SOUTH = EnumProperty.create("south", ConnectionType.class);
        WEST = EnumProperty.create("west", ConnectionType.class);
        EAST = EnumProperty.create("east", ConnectionType.class);
        UP = EnumProperty.create("up", ConnectionType.class);
        DOWN = EnumProperty.create("down", ConnectionType.class);
        SIDES = new EnumProperty[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};
    }

    public enum ConnectionType implements StringRepresentable {
        NONE("none"),
        CHAIN("chain"),
        POST("post");

        private final String name;

        ConnectionType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
