package com.brand.blockus.blocks.base;

import com.brand.blockus.registry.tag.BlockusBlockTags;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import net.minecraft.block.*;
import net.minecraft.block.enums.WallShape;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Iterator;
import java.util.Map;

public class SmallHedgeBlock extends Block implements Waterloggable {
    public static final BooleanProperty UP;
    public static final EnumProperty<WallShape> EAST_SHAPE;
    public static final EnumProperty<WallShape> NORTH_SHAPE;
    public static final EnumProperty<WallShape> SOUTH_SHAPE;
    public static final EnumProperty<WallShape> WEST_SHAPE;
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

    public SmallHedgeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(UP, true).with(NORTH_SHAPE, WallShape.NONE).with(EAST_SHAPE, WallShape.NONE).with(SOUTH_SHAPE, WallShape.NONE).with(WEST_SHAPE, WallShape.NONE).with(WATERLOGGED, false));
        this.shapeMap = this.getShapeMap(3.0F, 3.0F, 16.0F, 0.0F, 16.0F, 16.0F);
        this.collisionShapeMap = this.getShapeMap(3.0F, 3.0F, 24.0F, 0.0F, 24.0F, 24.0F);
    }

    private static VoxelShape getVoxelShape(VoxelShape base, WallShape wallShape, VoxelShape tall, VoxelShape low) {
        if (wallShape == WallShape.TALL) {
            return VoxelShapes.union(base, low);
        } else {
            return wallShape == WallShape.LOW ? VoxelShapes.union(base, tall) : base;
        }
    }

    private Map<BlockState, VoxelShape> getShapeMap(float f, float g, float h, float i, float j, float k) {
        float l = 8.0F - f;
        float m = 8.0F + f;
        float n = 8.0F - g;
        float o = 8.0F + g;
        VoxelShape voxelShape = Block.createCuboidShape(l, 0.0D, l, m, h, m);
        VoxelShape voxelShape2 = Block.createCuboidShape(n, i, 0.0D, o, j, o);
        VoxelShape voxelShape3 = Block.createCuboidShape(n, i, n, o, j, 16.0D);
        VoxelShape voxelShape4 = Block.createCuboidShape(0.0D, i, n, o, j, o);
        VoxelShape voxelShape5 = Block.createCuboidShape(n, i, n, 16.0D, j, o);
        VoxelShape voxelShape6 = Block.createCuboidShape(n, i, 0.0D, o, k, o);
        VoxelShape voxelShape7 = Block.createCuboidShape(n, i, n, o, k, 16.0D);
        VoxelShape voxelShape8 = Block.createCuboidShape(0.0D, i, n, o, k, o);
        VoxelShape voxelShape9 = Block.createCuboidShape(n, i, n, 16.0D, k, o);
        Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();
        Iterator var21 = UP.getValues().iterator();

        while (var21.hasNext()) {
            Boolean boolean_ = (Boolean) var21.next();
            Iterator var23 = EAST_SHAPE.getValues().iterator();

            while (var23.hasNext()) {
                WallShape wallShape = (WallShape) var23.next();
                Iterator var25 = NORTH_SHAPE.getValues().iterator();

                while (var25.hasNext()) {
                    WallShape wallShape2 = (WallShape) var25.next();
                    Iterator var27 = WEST_SHAPE.getValues().iterator();

                    while (var27.hasNext()) {
                        WallShape wallShape3 = (WallShape) var27.next();
                        Iterator var29 = SOUTH_SHAPE.getValues().iterator();

                        while (var29.hasNext()) {
                            WallShape wallShape4 = (WallShape) var29.next();
                            VoxelShape voxelShape10 = VoxelShapes.empty();
                            voxelShape10 = getVoxelShape(voxelShape10, wallShape, voxelShape5, voxelShape9);
                            voxelShape10 = getVoxelShape(voxelShape10, wallShape3, voxelShape4, voxelShape8);
                            voxelShape10 = getVoxelShape(voxelShape10, wallShape2, voxelShape2, voxelShape6);
                            voxelShape10 = getVoxelShape(voxelShape10, wallShape4, voxelShape3, voxelShape7);
                            if (boolean_) {
                                voxelShape10 = VoxelShapes.union(voxelShape10, voxelShape);
                            }

                            BlockState blockState = this.getDefaultState().with(UP, boolean_).with(EAST_SHAPE, wallShape).with(WEST_SHAPE, wallShape3).with(NORTH_SHAPE, wallShape2).with(SOUTH_SHAPE, wallShape4);
                            builder.put(blockState.with(WATERLOGGED, false), voxelShape10);
                            builder.put(blockState.with(WATERLOGGED, true), voxelShape10);
                        }
                    }
                }
            }
        }

        return builder.build();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.shapeMap.get(state);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.collisionShapeMap.get(state);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    private boolean shouldConnectTo(BlockState state, boolean faceFullSquare, Direction side) {
        Block block = state.getBlock();
        boolean bl = block instanceof FenceGateBlock && FenceGateBlock.canWallConnect(state, side);
        return state.isIn(BlockusBlockTags.SMALL_HEDGES) || !cannotConnect(state) && faceFullSquare || block instanceof PaneBlock || bl;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        WorldView worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.east();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockPos blockPos6 = blockPos.up();
        BlockState blockState = worldView.getBlockState(blockPos2);
        BlockState blockState2 = worldView.getBlockState(blockPos3);
        BlockState blockState3 = worldView.getBlockState(blockPos4);
        BlockState blockState4 = worldView.getBlockState(blockPos5);
        BlockState blockState5 = worldView.getBlockState(blockPos6);
        boolean bl = this.shouldConnectTo(blockState, blockState.isSideSolidFullSquare(worldView, blockPos2, Direction.SOUTH), Direction.SOUTH);
        boolean bl2 = this.shouldConnectTo(blockState2, blockState2.isSideSolidFullSquare(worldView, blockPos3, Direction.WEST), Direction.WEST);
        boolean bl3 = this.shouldConnectTo(blockState3, blockState3.isSideSolidFullSquare(worldView, blockPos4, Direction.NORTH), Direction.NORTH);
        boolean bl4 = this.shouldConnectTo(blockState4, blockState4.isSideSolidFullSquare(worldView, blockPos5, Direction.EAST), Direction.EAST);
        BlockState blockState6 = this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        return this.getStateWith(worldView, blockState6, blockPos6, blockState5, bl, bl2, bl3, bl4);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if (direction == Direction.DOWN) {
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        } else {
            return direction == Direction.UP ? this.getStateAt(world, state, neighborPos, neighborState) : this.getStateWithNeighbor(world, pos, state, neighborPos, neighborState, direction);
        }
    }

    private static boolean isConnected(BlockState state, Property<WallShape> property) {
        return state.get(property) != WallShape.NONE;
    }

    private static boolean shouldUseTallShape(VoxelShape aboveShape, VoxelShape tallShape) {
        return !VoxelShapes.matchesAnywhere(tallShape, aboveShape, BooleanBiFunction.ONLY_FIRST);
    }

    private BlockState getStateAt(WorldView world, BlockState state, BlockPos pos, BlockState aboveState) {
        boolean bl = isConnected(state, NORTH_SHAPE);
        boolean bl2 = isConnected(state, EAST_SHAPE);
        boolean bl3 = isConnected(state, SOUTH_SHAPE);
        boolean bl4 = isConnected(state, WEST_SHAPE);
        return this.getStateWith(world, state, pos, aboveState, bl, bl2, bl3, bl4);
    }

    private BlockState getStateWithNeighbor(WorldView world, BlockPos pos, BlockState state, BlockPos neighborPos, BlockState neighborState, Direction direction) {
        Direction direction2 = direction.getOpposite();
        boolean bl = direction == Direction.NORTH ? this.shouldConnectTo(neighborState, neighborState.isSideSolidFullSquare(world, neighborPos, direction2), direction2) : isConnected(state, NORTH_SHAPE);
        boolean bl2 = direction == Direction.EAST ? this.shouldConnectTo(neighborState, neighborState.isSideSolidFullSquare(world, neighborPos, direction2), direction2) : isConnected(state, EAST_SHAPE);
        boolean bl3 = direction == Direction.SOUTH ? this.shouldConnectTo(neighborState, neighborState.isSideSolidFullSquare(world, neighborPos, direction2), direction2) : isConnected(state, SOUTH_SHAPE);
        boolean bl4 = direction == Direction.WEST ? this.shouldConnectTo(neighborState, neighborState.isSideSolidFullSquare(world, neighborPos, direction2), direction2) : isConnected(state, WEST_SHAPE);
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        return this.getStateWith(world, state, blockPos, blockState, bl, bl2, bl3, bl4);
    }

    private BlockState getStateWith(WorldView world, BlockState state, BlockPos pos, BlockState aboveState, boolean north, boolean east, boolean south, boolean west) {
        VoxelShape voxelShape = aboveState.getCollisionShape(world, pos).getFace(Direction.DOWN);
        BlockState blockState = this.getStateWith(state, north, east, south, west, voxelShape);
        return blockState.with(UP, this.shouldHavePost(blockState, aboveState, voxelShape));
    }

    private boolean shouldHavePost(BlockState state, BlockState aboveState, VoxelShape aboveShape) {
        boolean bl = aboveState.getBlock() instanceof WallBlock && aboveState.get(UP);
        if (bl) {
            return true;
        } else {
            WallShape wallShape = state.get(NORTH_SHAPE);
            WallShape wallShape2 = state.get(SOUTH_SHAPE);
            WallShape wallShape3 = state.get(EAST_SHAPE);
            WallShape wallShape4 = state.get(WEST_SHAPE);
            boolean bl2 = wallShape2 == WallShape.NONE;
            boolean bl3 = wallShape4 == WallShape.NONE;
            boolean bl4 = wallShape3 == WallShape.NONE;
            boolean bl5 = wallShape == WallShape.NONE;
            boolean bl6 = bl5 && bl2 && bl3 && bl4 || bl5 != bl2 || bl3 != bl4;
            if (bl6) {
                return true;
            } else {
                boolean bl7 = wallShape == WallShape.TALL && wallShape2 == WallShape.TALL || wallShape3 == WallShape.TALL && wallShape4 == WallShape.TALL;
                if (bl7) {
                    return false;
                } else {
                    return aboveState.isIn(BlockTags.WALL_POST_OVERRIDE) || shouldUseTallShape(aboveShape, TALL_POST_SHAPE);
                }
            }
        }
    }

    private BlockState getStateWith(BlockState state, boolean north, boolean east, boolean south, boolean west, VoxelShape aboveShape) {
        return state.with(NORTH_SHAPE, this.getWallShape(north, aboveShape, TALL_NORTH_SHAPE)).with(EAST_SHAPE, this.getWallShape(east, aboveShape, TALL_EAST_SHAPE)).with(SOUTH_SHAPE, this.getWallShape(south, aboveShape, TALL_SOUTH_SHAPE)).with(WEST_SHAPE, this.getWallShape(west, aboveShape, TALL_WEST_SHAPE));
    }

    private WallShape getWallShape(boolean connected, VoxelShape aboveShape, VoxelShape tallShape) {
        if (connected) {
            return shouldUseTallShape(aboveShape, tallShape) ? WallShape.TALL : WallShape.LOW;
        } else {
            return WallShape.NONE;
        }
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return !(Boolean) state.get(WATERLOGGED);
    }

    protected void appendProperties(net.minecraft.state.StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH_SHAPE, EAST_SHAPE, WEST_SHAPE, SOUTH_SHAPE, WATERLOGGED);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        switch (rotation) {
            case CLOCKWISE_180:
                return state.with(NORTH_SHAPE, state.get(SOUTH_SHAPE)).with(EAST_SHAPE, state.get(WEST_SHAPE)).with(SOUTH_SHAPE, state.get(NORTH_SHAPE)).with(WEST_SHAPE, state.get(EAST_SHAPE));
            case COUNTERCLOCKWISE_90:
                return state.with(NORTH_SHAPE, state.get(EAST_SHAPE)).with(EAST_SHAPE, state.get(SOUTH_SHAPE)).with(SOUTH_SHAPE, state.get(WEST_SHAPE)).with(WEST_SHAPE, state.get(NORTH_SHAPE));
            case CLOCKWISE_90:
                return state.with(NORTH_SHAPE, state.get(WEST_SHAPE)).with(EAST_SHAPE, state.get(NORTH_SHAPE)).with(SOUTH_SHAPE, state.get(EAST_SHAPE)).with(WEST_SHAPE, state.get(SOUTH_SHAPE));
            default:
                return state;
        }
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        switch (mirror) {
            case LEFT_RIGHT:
                return state.with(NORTH_SHAPE, state.get(SOUTH_SHAPE)).with(SOUTH_SHAPE, state.get(NORTH_SHAPE));
            case FRONT_BACK:
                return state.with(EAST_SHAPE, state.get(WEST_SHAPE)).with(WEST_SHAPE, state.get(EAST_SHAPE));
            default:
                return super.mirror(state, mirror);
        }
    }

    static {
        UP = Properties.UP;
        EAST_SHAPE = Properties.EAST_WALL_SHAPE;
        NORTH_SHAPE = Properties.NORTH_WALL_SHAPE;
        SOUTH_SHAPE = Properties.SOUTH_WALL_SHAPE;
        WEST_SHAPE = Properties.WEST_WALL_SHAPE;
        WATERLOGGED = Properties.WATERLOGGED;
        TALL_POST_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
        TALL_NORTH_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 11.0D);
        TALL_SOUTH_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 16.0D);
        TALL_WEST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
        TALL_EAST_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
    }
}
