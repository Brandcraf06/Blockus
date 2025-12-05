package com.brand.blockus.blocks.base;

import com.brand.blockus.utils.BlockusBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CookieBlock extends Block {
    public static final IntegerProperty BITES;
    protected static final VoxelShape[] BITES_TO_SHAPE;

    public CookieBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return BITES_TO_SHAPE[state.getValue(BITES)];
    }

    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world.isClientSide) {
            if (tryEat(world, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return tryEat(world, pos, state, player);
    }

    private InteractionResult tryEat(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.getFoodData().eat(2, 0.1F);
            int i = state.getValue(BITES);
            world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS);
            world.gameEvent(player, GameEvent.EAT, pos);
            if (i < 8) {
                world.setBlock(pos, state.setValue(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
                world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return InteractionResult.SUCCESS;
        }
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).isSolid();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
        return (9 - state.getValue(BITES)) * 2;
    }

    public boolean hasAnalogOutputSignal(BlockState blockState_1) {
        return true;
    }

    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    static {
        BITES = BlockusBlockStateProperties.BITES_9;
        BITES_TO_SHAPE = new VoxelShape[]
            {
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D)};
    }
}
