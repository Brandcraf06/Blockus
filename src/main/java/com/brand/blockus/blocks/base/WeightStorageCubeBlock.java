package com.brand.blockus.blocks.base;

import com.brand.blockus.registry.content.BlockusBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class WeightStorageCubeBlock extends SimpleFallingBlock {
    public WeightStorageCubeBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (stack.is(Items.POPPY)) {
            change(world, pos, state);
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.CONSUME;
    }

    public static void change(Level world, BlockPos pos, BlockState state) {
        world.setBlockAndUpdate(pos, BlockusBlocks.COMPANION_CUBE.defaultBlockState());
        world.addDestroyBlockEffect(pos, state);
        world.playSound(null, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

}
