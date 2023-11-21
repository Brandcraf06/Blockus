package com.brand.blockus.blocks.base;

import com.brand.blockus.content.BlockusBlocks;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Map;

public class LargeFlowerPotBlock extends FlowerPotBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 10.0D, 15.0D);
    public static final Map<Block, Block> CONTENT_TO_POTTED = Maps.newHashMap();
    public final Block content;

    public LargeFlowerPotBlock(Block content, Settings settings) {
        super(content, settings);
        this.content = content;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        BlockState blockState = (item instanceof BlockItem ? CONTENT_TO_POTTED.getOrDefault(((BlockItem) item).getBlock(), Blocks.AIR) : Blocks.AIR).getDefaultState();
        boolean bl = blockState.isOf(Blocks.AIR);
        boolean bl2 = this.isEmpty();
        if (bl != bl2) {
            if (bl2) {
                world.setBlockState(pos, blockState, 3);
                player.incrementStat(Stats.POT_FLOWER);
                if (!player.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }
            } else {
                ItemStack itemStack2 = new ItemStack(this.content);
                if (itemStack.isEmpty()) {
                    player.setStackInHand(hand, itemStack2);
                } else if (!player.giveItemStack(itemStack2)) {
                    player.dropItem(itemStack2, false);
                }

                world.setBlockState(pos, BlockusBlocks.LARGE_FLOWER_POT.getDefaultState(), 3);
            }

            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.CONSUME;
        }
    }


    public boolean isEmpty() {
        return this.content == Blocks.AIR;
    }

}
