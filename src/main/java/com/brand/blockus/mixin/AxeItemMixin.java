package com.brand.blockus.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.brand.blockus.content.WhiteOak;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Mixin( {AxeItem.class} )
public abstract class AxeItemMixin {

	@Inject(method = "useOnBlock", at = @At(value = "HEAD"), cancellable = true)
	private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		World world = context.getWorld();
	      BlockPos blockPos = context.getBlockPos();
	      BlockState blockState = world.getBlockState(blockPos);
	      ImmutableMap STRIPPED_BLOCKS = (new Builder()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
	    		                                        .put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG)
	    		                                        .put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG)
	    		                                        .put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG)
	    		                                        .put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG)
	    		                                        .put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG)
	    		                                        .put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
	    		                                        .put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE)
	    		                                        .put(WhiteOak.WHITE_OAK_LOG, WhiteOak.STRIPPED_WHITE_OAK_LOG).put(WhiteOak.WHITE_OAK_WOOD, WhiteOak.STRIPPED_WHITE_OAK_WOOD).build();	  
		  Block block = (Block)STRIPPED_BLOCKS.get(blockState.getBlock());
	      if (block != null) {
	         PlayerEntity playerEntity = context.getPlayer();
	         world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
	         if (!world.isClient) {
	            world.setBlockState(blockPos, (BlockState)block.getDefaultState().with(PillarBlock.AXIS, blockState.get(PillarBlock.AXIS)), 11);
	            if (playerEntity != null) {
	               context.getStack().damage(1, (LivingEntity)playerEntity, (Consumer)((p) -> {
	                  ((LivingEntity) p).sendToolBreakStatus(context.getHand());
	               }));
	            }
	         }

	         cir.setReturnValue(ActionResult.SUCCESS);
	      } else {
	    	  cir.setReturnValue(ActionResult.PASS);
	      }
	   }

	   static {
		   
	   }
	}