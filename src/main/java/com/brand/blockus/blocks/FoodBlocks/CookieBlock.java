package com.brand.blockus.blocks.FoodBlocks;

import com.brand.blockus.BlockusProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class CookieBlock extends Block {
    public static final IntProperty BITES;
    protected static final VoxelShape[] BITES_TO_SHAPE;

    static {
        BITES = BlockusProperties.BITES_9;
        BITES_TO_SHAPE = new VoxelShape[]
                {Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                        Block.createCuboidShape(2.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                        Block.createCuboidShape(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                        Block.createCuboidShape(6.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                        Block.createCuboidShape(7.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                        Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                        Block.createCuboidShape(10.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                        Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                        Block.createCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    }

    protected CookieBlock(Block.Settings block$Settings_1) {
        super(block$Settings_1);
        this.setDefaultState(this.stateManager.getDefaultState().with(BITES, 0));
    }

    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, ShapeContext entityContext_1) {
        return BITES_TO_SHAPE[blockState_1.get(BITES)];
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (this.tryEat(world, pos, state, player) == ActionResult.SUCCESS) {
                return ActionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return this.tryEat(world, pos, state, player);
    }

    private ActionResult tryEat(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(2, 0.1F);
            int i = state.get(BITES);
            if (i < 6) {
                world.setBlockState(pos, state.with(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return ActionResult.SUCCESS;
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, World iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
        return direction_1 == Direction.DOWN && !blockState_1.canPlaceAt(iWorld_1, blockPos_1) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(blockState_1, direction_1, blockState_2, iWorld_1, blockPos_1, blockPos_2);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).getMaterial().isSolid();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> stateFactory$Builder_1) {
        stateFactory$Builder_1.add(BITES);
    }

    public int getComparatorOutput(BlockState blockState_1, World world_1, BlockPos blockPos_1) {
        return (9 - blockState_1.get(BITES)) * 2;
    }

    public boolean hasComparatorOutput(BlockState blockState_1) {
        return true;
    }

    public boolean canPlaceAtSide(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, NavigationType blockPlacementEnvironment_1) {
        return false;
    }
}
