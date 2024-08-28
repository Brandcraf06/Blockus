package com.brand.blockus.blocks.base;

import com.brand.blockus.registry.content.BlockusBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WeightStorageCubeBlock extends SimpleFallingBlock {
    public WeightStorageCubeBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (stack.isOf(Items.POPPY)) {
            change(world, pos, state);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
                return ItemActionResult.success(world.isClient);
            }
        }
        return ItemActionResult.CONSUME;
    }

    public static void change(World world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, BlockusBlocks.COMPANION_CUBE.getDefaultState());
        world.addBlockBreakParticles(pos, state);
        world.playSound(null, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

}
