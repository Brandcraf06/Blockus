package com.brand.blockus.blocks.base;

import com.brand.blockus.content.BlockusBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WeightStorageCubeBlock extends FallingBlock {

    public WeightStorageCubeBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!isPoppy(itemStack)) {
            return ActionResult.PASS;
        } else if (isPoppy(itemStack)) {
            change(world, pos, state);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
                return ActionResult.success(world.isClient);
            }
        }
        return ActionResult.CONSUME;
    }

    private static boolean isPoppy(ItemStack stack) {
        return stack.isOf(Items.POPPY);
    }

    public static void change(World world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, BlockusBlocks.COMPANION_CUBE.getDefaultState());
        world.addBlockBreakParticles(pos, state);
        world.playSound(null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

}
