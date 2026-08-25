package com.brand.blockus.blocks.base;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.util.Prediction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class LargeFlowerPotBlock extends Block {
    private static final Map<Block, Block> POTTED_BY_CONTENT = Maps.newHashMap();
    protected static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
    private final Block potted;

    public LargeFlowerPotBlock(Block potted, BlockBehaviour.Properties properties) {
        super(properties);
        this.potted = potted;
        POTTED_BY_CONTENT.put(potted, this);
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item var10 = itemStack.getItem();
        Block var10000;
        if (var10 instanceof BlockItem blockItem) {
            var10000 = (Block)POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
        } else {
            var10000 = Blocks.AIR;
        }

        BlockState newContents = var10000.defaultBlockState();
        if (newContents.isAir()) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        } else if (!this.isEmpty()) {
            return InteractionResult.CONSUME;
        } else {
            level.setBlockAndUpdate(pos, newContents);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            player.awardStat(Stats.POT_FLOWER);
            itemStack.consume(1, player);
            return InteractionResult.SUCCESS;
        }
    }

    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (this.isEmpty()) {
            return InteractionResult.CONSUME;
        } else {
            ItemStack plant = new ItemStack(this.potted);
            if (!player.addItem(plant)) {
                player.drop(plant, false, Prediction.PREDICTED);
            }

            level.setBlockAndUpdate(pos, Blocks.FLOWER_POT.defaultBlockState());
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return InteractionResult.SUCCESS;
        }
    }

    protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        return this.isEmpty() ? super.getCloneItemStack(level, pos, state, includeData) : new ItemStack(this.potted);
    }

    private boolean isEmpty() {
        return this.potted == Blocks.AIR;
    }

    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        return directionToNeighbour == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    public Block getPotted() {
        return this.potted;
    }

    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}
