package com.brand.blockus.blocks.base;

import com.brand.blockus.blocks.Utils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import net.minecraft.block.*;
import net.minecraft.block.enums.WallShape;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.tag.BlockTags;
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

import java.util.Map;

public class SmallHedgeBlock extends Block implements Waterloggable {
    public static final BooleanProperty UP;
    public static final EnumProperty<WallShape> EAST_SHAPE;
    public static final EnumProperty<WallShape> NORTH_SHAPE;
    public static final EnumProperty<WallShape> SOUTH_SHAPE;
    public static final EnumProperty<WallShape> WEST_SHAPE;
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape field_22163;
    private static final VoxelShape field_22164;
    private static final VoxelShape field_22165;
    private static final VoxelShape field_22166;
    private static final VoxelShape field_22167;

    static {
        UP = Properties.UP;
        EAST_SHAPE = Properties.EAST_WALL_SHAPE;
        NORTH_SHAPE = Properties.NORTH_WALL_SHAPE;
        SOUTH_SHAPE = Properties.SOUTH_WALL_SHAPE;
        WEST_SHAPE = Properties.WEST_WALL_SHAPE;
        WATERLOGGED = Properties.WATERLOGGED;
        field_22163 = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
        field_22164 = Block.createCuboidShape(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 11.0D);
        field_22165 = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 16.0D);
        field_22166 = Block.createCuboidShape(0.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
        field_22167 = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
    }

    private final Map<BlockState, VoxelShape> shapeMap;
    private final Map<BlockState, VoxelShape> collisionShapeMap;

    public SmallHedgeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(UP, true).with(NORTH_SHAPE, WallShape.NONE).with(EAST_SHAPE, WallShape.NONE).with(SOUTH_SHAPE, WallShape.NONE).with(WEST_SHAPE, WallShape.NONE).with(WATERLOGGED, false));
        this.shapeMap = this.getShapeMap(3.0F, 3.0F, 16.0F, 0.0F, 16.0F, 16.0F);
        this.collisionShapeMap = this.getShapeMap(3.0F, 3.0F, 24.0F, 0.0F, 24.0F, 24.0F);
    }

    private static VoxelShape method_24426(VoxelShape voxelShape, WallShape wallShape, VoxelShape voxelShape2, VoxelShape voxelShape3) {
        if (wallShape == WallShape.TALL) {
            return VoxelShapes.union(voxelShape, voxelShape3);
        } else {
            return wallShape == WallShape.LOW ? VoxelShapes.union(voxelShape, voxelShape2) : voxelShape;
        }
    }

    private static boolean method_24424(BlockState blockState, Property<WallShape> property) {
        return blockState.get(property) != WallShape.NONE;
    }

    private static boolean method_24427(VoxelShape voxelShape, VoxelShape voxelShape2) {
        return !VoxelShapes.matchesAnywhere(voxelShape2, voxelShape, BooleanBiFunction.ONLY_FIRST);
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

        for (Boolean boolean_ : UP.getValues()) {

            for (WallShape wallShape : EAST_SHAPE.getValues()) {

                for (WallShape wallShape2 : NORTH_SHAPE.getValues()) {

                    for (WallShape wallShape3 : WEST_SHAPE.getValues()) {

                        for (WallShape wallShape4 : SOUTH_SHAPE.getValues()) {
                            VoxelShape voxelShape10 = VoxelShapes.empty();
                            voxelShape10 = method_24426(voxelShape10, wallShape, voxelShape5, voxelShape9);
                            voxelShape10 = method_24426(voxelShape10, wallShape3, voxelShape4, voxelShape8);
                            voxelShape10 = method_24426(voxelShape10, wallShape2, voxelShape2, voxelShape6);
                            voxelShape10 = method_24426(voxelShape10, wallShape4, voxelShape3, voxelShape7);
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
        return state.isIn(Utils.SMALL_HEDGES) || !cannotConnect(block) && faceFullSquare || block instanceof PaneBlock || bl;
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
        return this.method_24422(worldView, blockState6, blockPos6, blockState5, bl, bl2, bl3, bl4);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if (direction == Direction.DOWN) {
            return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
        } else {
            return direction == Direction.UP ? this.method_24421(world, state, posFrom, newState) : this.method_24423(world, pos, state, posFrom, newState, direction);
        }
    }

    private BlockState method_24421(WorldView worldView, BlockState blockState, BlockPos blockPos, BlockState blockState2) {
        boolean bl = method_24424(blockState, NORTH_SHAPE);
        boolean bl2 = method_24424(blockState, EAST_SHAPE);
        boolean bl3 = method_24424(blockState, SOUTH_SHAPE);
        boolean bl4 = method_24424(blockState, WEST_SHAPE);
        return this.method_24422(worldView, blockState, blockPos, blockState2, bl, bl2, bl3, bl4);
    }

    private BlockState method_24423(WorldView worldView, BlockPos blockPos, BlockState blockState, BlockPos blockPos2, BlockState blockState2, Direction direction) {
        Direction direction2 = direction.getOpposite();
        boolean bl = direction == Direction.NORTH ? this.shouldConnectTo(blockState2, blockState2.isSideSolidFullSquare(worldView, blockPos2, direction2), direction2) : method_24424(blockState, NORTH_SHAPE);
        boolean bl2 = direction == Direction.EAST ? this.shouldConnectTo(blockState2, blockState2.isSideSolidFullSquare(worldView, blockPos2, direction2), direction2) : method_24424(blockState, EAST_SHAPE);
        boolean bl3 = direction == Direction.SOUTH ? this.shouldConnectTo(blockState2, blockState2.isSideSolidFullSquare(worldView, blockPos2, direction2), direction2) : method_24424(blockState, SOUTH_SHAPE);
        boolean bl4 = direction == Direction.WEST ? this.shouldConnectTo(blockState2, blockState2.isSideSolidFullSquare(worldView, blockPos2, direction2), direction2) : method_24424(blockState, WEST_SHAPE);
        BlockPos blockPos3 = blockPos.up();
        BlockState blockState3 = worldView.getBlockState(blockPos3);
        return this.method_24422(worldView, blockState, blockPos3, blockState3, bl, bl2, bl3, bl4);
    }

    private BlockState method_24422(WorldView worldView, BlockState blockState, BlockPos blockPos, BlockState blockState2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        VoxelShape voxelShape = blockState2.getCollisionShape(worldView, blockPos).getFace(Direction.DOWN);
        BlockState blockState3 = this.method_24425(blockState, bl, bl2, bl3, bl4, voxelShape);
        return blockState3.with(UP, this.method_27092(blockState3, blockState2, voxelShape));
    }

    private boolean method_27092(BlockState blockState, BlockState blockState2, VoxelShape voxelShape) {
        boolean bl = blockState2.getBlock() instanceof WallBlock && blockState2.get(UP);
        if (bl) {
            return true;
        } else {
            WallShape wallShape = blockState.get(NORTH_SHAPE);
            WallShape wallShape2 = blockState.get(SOUTH_SHAPE);
            WallShape wallShape3 = blockState.get(EAST_SHAPE);
            WallShape wallShape4 = blockState.get(WEST_SHAPE);
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
                    return blockState2.getBlock().isIn(BlockTags.WALL_POST_OVERRIDE) || method_24427(voxelShape, field_22163);
                }
            }
        }
    }

    private BlockState method_24425(BlockState blockState, boolean bl, boolean bl2, boolean bl3, boolean bl4, VoxelShape voxelShape) {
        return blockState.with(NORTH_SHAPE, this.method_24428(bl, voxelShape, field_22164)).with(EAST_SHAPE, this.method_24428(bl2, voxelShape, field_22167)).with(SOUTH_SHAPE, this.method_24428(bl3, voxelShape, field_22165)).with(WEST_SHAPE, this.method_24428(bl4, voxelShape, field_22166));
    }

    private WallShape method_24428(boolean bl, VoxelShape voxelShape, VoxelShape voxelShape2) {
        if (bl) {
            return method_24427(voxelShape, voxelShape2) ? WallShape.TALL : WallShape.LOW;
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

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
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
}