package com.brand.blockus.blocks.base;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Iterator;
import java.util.Map;

public class Barrier extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty UP;
    public static final EnumProperty<WallSide> EAST_SHAPE;
    public static final EnumProperty<WallSide> NORTH_SHAPE;
    public static final EnumProperty<WallSide> SOUTH_SHAPE;
    public static final EnumProperty<WallSide> WEST_SHAPE;
    public static final BooleanProperty WATERLOGGED;
    private final Map<BlockState, VoxelShape> shapeMap;
    private final Map<BlockState, VoxelShape> collisionShapeMap;
    private static final int field_31276 = 3;
    private static final int field_31277 = 14;
    private static final int field_31278 = 4;
    private static final int field_31279 = 1;
    private static final int field_31280 = 7;
    private static final int field_31281 = 9;
    private static final VoxelShape TALL_POST_SHAPE;
    private static final VoxelShape TALL_NORTH_SHAPE;
    private static final VoxelShape TALL_SOUTH_SHAPE;
    private static final VoxelShape TALL_WEST_SHAPE;
    private static final VoxelShape TALL_EAST_SHAPE;

    public Barrier(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, true).setValue(NORTH_SHAPE, WallSide.NONE).setValue(EAST_SHAPE, WallSide.NONE).setValue(SOUTH_SHAPE, WallSide.NONE).setValue(WEST_SHAPE, WallSide.NONE).setValue(WATERLOGGED, false));
        this.shapeMap = this.getShapeMap(2.0F, 1.0F, 16.0F, 0.0F, 14.0F, 16.0F);
        this.collisionShapeMap = this.getShapeMap(2.0F, 1.0F, 24.0F, 0.0F, 24.0F, 24.0F);
    }

    private static VoxelShape getVoxelShape(VoxelShape base, WallSide wallShape, VoxelShape tall, VoxelShape low) {
        if (wallShape == WallSide.TALL) {
            return Shapes.or(base, low);
        } else {
            return wallShape == WallSide.LOW ? Shapes.or(base, tall) : base;
        }
    }

    private Map<BlockState, VoxelShape> getShapeMap(float f, float g, float h, float i, float j, float k) {
        float l = 8.0F - f;
        float m = 8.0F + f;
        float n = 8.0F - g;
        float o = 8.0F + g;
        VoxelShape voxelShape = Block.box(l, 0.0D, l, m, h, m);
        VoxelShape voxelShape2 = Block.box(n, i, 0.0D, o, j, o);
        VoxelShape voxelShape3 = Block.box(n, i, n, o, j, 16.0D);
        VoxelShape voxelShape4 = Block.box(0.0D, i, n, o, j, o);
        VoxelShape voxelShape5 = Block.box(n, i, n, 16.0D, j, o);
        VoxelShape voxelShape6 = Block.box(n, i, 0.0D, o, k, o);
        VoxelShape voxelShape7 = Block.box(n, i, n, o, k, 16.0D);
        VoxelShape voxelShape8 = Block.box(0.0D, i, n, o, k, o);
        VoxelShape voxelShape9 = Block.box(n, i, n, 16.0D, k, o);
        Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();
        Iterator var21 = UP.getPossibleValues().iterator();

        while (var21.hasNext()) {
            Boolean boolean_ = (Boolean) var21.next();
            Iterator var23 = EAST_SHAPE.getPossibleValues().iterator();

            while (var23.hasNext()) {
                WallSide wallShape = (WallSide) var23.next();
                Iterator var25 = NORTH_SHAPE.getPossibleValues().iterator();

                while (var25.hasNext()) {
                    WallSide wallShape2 = (WallSide) var25.next();
                    Iterator var27 = WEST_SHAPE.getPossibleValues().iterator();

                    while (var27.hasNext()) {
                        WallSide wallShape3 = (WallSide) var27.next();
                        Iterator var29 = SOUTH_SHAPE.getPossibleValues().iterator();

                        while (var29.hasNext()) {
                            WallSide wallShape4 = (WallSide) var29.next();
                            VoxelShape voxelShape10 = Shapes.empty();
                            voxelShape10 = getVoxelShape(voxelShape10, wallShape, voxelShape5, voxelShape9);
                            voxelShape10 = getVoxelShape(voxelShape10, wallShape3, voxelShape4, voxelShape8);
                            voxelShape10 = getVoxelShape(voxelShape10, wallShape2, voxelShape2, voxelShape6);
                            voxelShape10 = getVoxelShape(voxelShape10, wallShape4, voxelShape3, voxelShape7);
                            if (boolean_) {
                                voxelShape10 = Shapes.or(voxelShape10, voxelShape);
                            }

                            BlockState blockState = this.defaultBlockState().setValue(UP, boolean_).setValue(EAST_SHAPE, wallShape).setValue(WEST_SHAPE, wallShape3).setValue(NORTH_SHAPE, wallShape2).setValue(SOUTH_SHAPE, wallShape4);
                            builder.put(blockState.setValue(WATERLOGGED, false), voxelShape10);
                            builder.put(blockState.setValue(WATERLOGGED, true), voxelShape10);
                        }
                    }
                }
            }
        }

        return builder.build();
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return this.shapeMap.get(state);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return this.collisionShapeMap.get(state);
    }

    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    private boolean shouldConnectTo(BlockState state, boolean faceFullSquare, Direction side) {
        Block block = state.getBlock();
        boolean bl = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(state, side);
        return state.is(BlockTags.WALLS) || !isExceptionForConnection(state) && faceFullSquare || block instanceof IronBarsBlock || bl;
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        LevelReader worldView = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.east();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockPos blockPos6 = blockPos.above();
        BlockState blockState = worldView.getBlockState(blockPos2);
        BlockState blockState2 = worldView.getBlockState(blockPos3);
        BlockState blockState3 = worldView.getBlockState(blockPos4);
        BlockState blockState4 = worldView.getBlockState(blockPos5);
        BlockState blockState5 = worldView.getBlockState(blockPos6);
        boolean bl = this.shouldConnectTo(blockState, blockState.isFaceSturdy(worldView, blockPos2, Direction.SOUTH), Direction.SOUTH);
        boolean bl2 = this.shouldConnectTo(blockState2, blockState2.isFaceSturdy(worldView, blockPos3, Direction.WEST), Direction.WEST);
        boolean bl3 = this.shouldConnectTo(blockState3, blockState3.isFaceSturdy(worldView, blockPos4, Direction.NORTH), Direction.NORTH);
        boolean bl4 = this.shouldConnectTo(blockState4, blockState4.isFaceSturdy(worldView, blockPos5, Direction.EAST), Direction.EAST);
        BlockState blockState6 = this.defaultBlockState().setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return this.getStateWith(worldView, blockState6, blockPos6, blockState5, bl, bl2, bl3, bl4);
    }

    protected BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            tickView.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        if (direction == Direction.DOWN) {
            return super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
        } else {
            return direction == Direction.UP ? this.getStateAt(world, state, neighborPos, neighborState) : this.getStateWithNeighbor(world, pos, state, neighborPos, neighborState, direction);
        }
    }

    private static boolean isConnected(BlockState state, Property<WallSide> property) {
        return state.getValue(property) != WallSide.NONE;
    }

    private static boolean shouldUseTallShape(VoxelShape aboveShape, VoxelShape tallShape) {
        return !Shapes.joinIsNotEmpty(tallShape, aboveShape, BooleanOp.ONLY_FIRST);
    }

    private BlockState getStateAt(LevelReader world, BlockState state, BlockPos pos, BlockState aboveState) {
        boolean bl = isConnected(state, NORTH_SHAPE);
        boolean bl2 = isConnected(state, EAST_SHAPE);
        boolean bl3 = isConnected(state, SOUTH_SHAPE);
        boolean bl4 = isConnected(state, WEST_SHAPE);
        return this.getStateWith(world, state, pos, aboveState, bl, bl2, bl3, bl4);
    }

    private BlockState getStateWithNeighbor(LevelReader world, BlockPos pos, BlockState state, BlockPos neighborPos, BlockState neighborState, Direction direction) {
        Direction direction2 = direction.getOpposite();
        boolean bl = direction == Direction.NORTH ? this.shouldConnectTo(neighborState, neighborState.isFaceSturdy(world, neighborPos, direction2), direction2) : isConnected(state, NORTH_SHAPE);
        boolean bl2 = direction == Direction.EAST ? this.shouldConnectTo(neighborState, neighborState.isFaceSturdy(world, neighborPos, direction2), direction2) : isConnected(state, EAST_SHAPE);
        boolean bl3 = direction == Direction.SOUTH ? this.shouldConnectTo(neighborState, neighborState.isFaceSturdy(world, neighborPos, direction2), direction2) : isConnected(state, SOUTH_SHAPE);
        boolean bl4 = direction == Direction.WEST ? this.shouldConnectTo(neighborState, neighborState.isFaceSturdy(world, neighborPos, direction2), direction2) : isConnected(state, WEST_SHAPE);
        BlockPos blockPos = pos.above();
        BlockState blockState = world.getBlockState(blockPos);
        return this.getStateWith(world, state, blockPos, blockState, bl, bl2, bl3, bl4);
    }

    private BlockState getStateWith(LevelReader world, BlockState state, BlockPos pos, BlockState aboveState, boolean north, boolean east, boolean south, boolean west) {
        VoxelShape voxelShape = aboveState.getCollisionShape(world, pos).getFaceShape(Direction.DOWN);
        BlockState blockState = this.getStateWith(state, north, east, south, west, voxelShape);
        return blockState.setValue(UP, this.shouldHavePost(blockState, aboveState, voxelShape));
    }

    private boolean shouldHavePost(BlockState state, BlockState aboveState, VoxelShape aboveShape) {
        boolean bl = aboveState.getBlock() instanceof WallBlock && aboveState.getValue(UP);
        if (bl) {
            return true;
        } else {
            WallSide wallShape = state.getValue(NORTH_SHAPE);
            WallSide wallShape2 = state.getValue(SOUTH_SHAPE);
            WallSide wallShape3 = state.getValue(EAST_SHAPE);
            WallSide wallShape4 = state.getValue(WEST_SHAPE);
            boolean bl2 = wallShape2 == WallSide.NONE;
            boolean bl3 = wallShape4 == WallSide.NONE;
            boolean bl4 = wallShape3 == WallSide.NONE;
            boolean bl5 = wallShape == WallSide.NONE;
            boolean bl6 = bl5 && bl2 && bl3 && bl4 || bl5 != bl2 || bl3 != bl4;
            if (bl6) {
                return true;
            } else {
                boolean bl7 = wallShape == WallSide.TALL && wallShape2 == WallSide.TALL || wallShape3 == WallSide.TALL && wallShape4 == WallSide.TALL;
                if (bl7) {
                    return false;
                } else {
                    return aboveState.is(BlockTags.WALL_POST_OVERRIDE) || shouldUseTallShape(aboveShape, TALL_POST_SHAPE);
                }
            }
        }
    }

    private BlockState getStateWith(BlockState state, boolean north, boolean east, boolean south, boolean west, VoxelShape aboveShape) {
        return state.setValue(NORTH_SHAPE, this.getWallShape(north, aboveShape, TALL_NORTH_SHAPE)).setValue(EAST_SHAPE, this.getWallShape(east, aboveShape, TALL_EAST_SHAPE)).setValue(SOUTH_SHAPE, this.getWallShape(south, aboveShape, TALL_SOUTH_SHAPE)).setValue(WEST_SHAPE, this.getWallShape(west, aboveShape, TALL_WEST_SHAPE));
    }

    private WallSide getWallShape(boolean connected, VoxelShape aboveShape, VoxelShape tallShape) {
        if (connected) {
            return shouldUseTallShape(aboveShape, tallShape) ? WallSide.TALL : WallSide.LOW;
        } else {
            return WallSide.NONE;
        }
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean propagatesSkylightDown(BlockState state) {
        return !(Boolean) state.getValue(WATERLOGGED);
    }

    protected void createBlockStateDefinition(net.minecraft.world.level.block.state.StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH_SHAPE, EAST_SHAPE, WEST_SHAPE, SOUTH_SHAPE, WATERLOGGED);
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        switch (rotation) {
            case CLOCKWISE_180:
                return state.setValue(NORTH_SHAPE, state.getValue(SOUTH_SHAPE)).setValue(EAST_SHAPE, state.getValue(WEST_SHAPE)).setValue(SOUTH_SHAPE, state.getValue(NORTH_SHAPE)).setValue(WEST_SHAPE, state.getValue(EAST_SHAPE));
            case COUNTERCLOCKWISE_90:
                return state.setValue(NORTH_SHAPE, state.getValue(EAST_SHAPE)).setValue(EAST_SHAPE, state.getValue(SOUTH_SHAPE)).setValue(SOUTH_SHAPE, state.getValue(WEST_SHAPE)).setValue(WEST_SHAPE, state.getValue(NORTH_SHAPE));
            case CLOCKWISE_90:
                return state.setValue(NORTH_SHAPE, state.getValue(WEST_SHAPE)).setValue(EAST_SHAPE, state.getValue(NORTH_SHAPE)).setValue(SOUTH_SHAPE, state.getValue(EAST_SHAPE)).setValue(WEST_SHAPE, state.getValue(SOUTH_SHAPE));
            default:
                return state;
        }
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        switch (mirror) {
            case LEFT_RIGHT:
                return state.setValue(NORTH_SHAPE, state.getValue(SOUTH_SHAPE)).setValue(SOUTH_SHAPE, state.getValue(NORTH_SHAPE));
            case FRONT_BACK:
                return state.setValue(EAST_SHAPE, state.getValue(WEST_SHAPE)).setValue(WEST_SHAPE, state.getValue(EAST_SHAPE));
            default:
                return super.mirror(state, mirror);
        }
    }

    static {
        UP = BlockStateProperties.UP;
        EAST_SHAPE = BlockStateProperties.EAST_WALL;
        NORTH_SHAPE = BlockStateProperties.NORTH_WALL;
        SOUTH_SHAPE = BlockStateProperties.SOUTH_WALL;
        WEST_SHAPE = BlockStateProperties.WEST_WALL;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        TALL_POST_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
        TALL_NORTH_SHAPE = Block.box(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 11.0D);
        TALL_SOUTH_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 16.0D);
        TALL_WEST_SHAPE = Block.box(0.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
        TALL_EAST_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
    }
}
