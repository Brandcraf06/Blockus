package com.brand.blockus.mixin;

import com.brand.blockus.content.Other;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.function.Consumer;

@Mixin( {ShovelItem.class} )
public abstract class ShovelItemMixin {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Inject(method = "useOnBlock", at = @At(value = "HEAD"), cancellable = true)
	private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		World world = context.getWorld();
	      BlockPos blockPos = context.getBlockPos();
	      BlockState blockState = world.getBlockState(blockPos);
	      if (context.getSide() == Direction.DOWN) {
	    	  cir.setReturnValue(ActionResult.PASS);
	      } else {
	         PlayerEntity playerEntity = context.getPlayer();
	         HashMap<Block, BlockState> PATH_STATES = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState(),
	        		                                                                  Blocks.DIRT, Other.DIRT_PATH.getDefaultState(),
	        		                                                                  Blocks.COARSE_DIRT, Other.DIRT_PATH.getDefaultState(),    
             																		  Blocks.PODZOL, Other.DIRT_PATH.getDefaultState()));	                                                         
	         BlockState blockState2 = (BlockState)PATH_STATES.get(blockState.getBlock());
	         BlockState blockState3 = null;
	         if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
	            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
	            blockState3 = blockState2;
	         } else if (blockState.getBlock() instanceof CampfireBlock && (Boolean)blockState.get(CampfireBlock.LIT)) {
	            if (!world.isClient()) {
	               world.syncWorldEvent((PlayerEntity)null, 1009, blockPos, 0);
	            }

	            CampfireBlock.extinguish(world, blockPos, blockState);
	            blockState3 = (BlockState)blockState.with(CampfireBlock.LIT, false);
	         }

	         if (blockState3 != null) {
	            if (!world.isClient) {
	               world.setBlockState(blockPos, blockState3, 11);
	               if (playerEntity != null) {
	                  context.getStack().damage(1, (LivingEntity)playerEntity, (Consumer)((p) -> {
	                     ((LivingEntity) p).sendToolBreakStatus(context.getHand());
	                  }));
	               }
	            }

	            cir.setReturnValue(ActionResult.success(world.isClient));
	         } else {
	        	 cir.setReturnValue(ActionResult.PASS);
	         }
		  }
	   }
    }
