package com.brand.blockus.blocks.base;

import com.brand.blockus.content.BlockusBlocks;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

import java.util.Map;

public class LargeFlowerPotBlock extends Block {
    public static final MapCodec<LargeFlowerPotBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(Registries.BLOCK.getCodec().fieldOf("potted").forGetter((block) -> block.content), createSettingsCodec()).apply(instance, LargeFlowerPotBlock::new));
    private static final Map<Block, Block> CONTENT_TO_POTTED = Maps.newHashMap();
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
    private final Block content;

    public MapCodec<LargeFlowerPotBlock> getCodec() {
        return CODEC;
    }

    public LargeFlowerPotBlock(Block content, AbstractBlock.Settings settings) {
        super(settings);
        this.content = content;
        CONTENT_TO_POTTED.put(content, this);
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Item var10 = stack.getItem();
        Block var10000;
        if (var10 instanceof BlockItem blockItem) {
            var10000 = CONTENT_TO_POTTED.getOrDefault(blockItem.getBlock(), Blocks.AIR);
        } else {
            var10000 = Blocks.AIR;
        }

        BlockState blockState = var10000.getDefaultState();
        if (blockState.isAir()) {
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else if (!this.isEmpty()) {
            return ItemActionResult.CONSUME;
        } else {
            world.setBlockState(pos, blockState, 3);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            player.incrementStat(Stats.POT_FLOWER);
            stack.decrementUnlessCreative(1, player);
            return ItemActionResult.success(world.isClient);
        }
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (this.isEmpty()) {
            return ActionResult.CONSUME;
        } else {
            ItemStack itemStack = new ItemStack(this.content);
            if (!player.giveItemStack(itemStack)) {
                player.dropItem(itemStack, false);
            }

            world.setBlockState(pos, BlockusBlocks.LARGE_FLOWER_POT.getDefaultState(), 3);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return ActionResult.success(world.isClient);
        }
    }

    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return this.isEmpty() ? super.getPickStack(world, pos, state) : new ItemStack(this.content);
    }

    private boolean isEmpty() {
        return this.content == Blocks.AIR;
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public Block getContent() {
        return this.content;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}
