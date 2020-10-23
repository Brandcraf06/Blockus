package com.brand.blockus.blocks.Wood;

import com.brand.blockus.Blockus;
import com.brand.blockus.blockentity.WoodenBarrelBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class WoodenBarrels extends BarrelBlock {
	
	public WoodenBarrels(String name, float hardness, float resistance, MaterialColor color) {
		super(FabricBlockSettings.of(Material.WOOD, color).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0).strength(hardness, resistance));
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_DECORATIONS)));
	}
	
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
	      if (world.isClient) {
	         return ActionResult.SUCCESS;
	      } else {
	         BlockEntity blockEntity = world.getBlockEntity(pos);
	         if (blockEntity instanceof WoodenBarrelBlockEntity) {
	            player.openHandledScreen((WoodenBarrelBlockEntity)blockEntity);
	            player.incrementStat(Stats.OPEN_BARREL);
	            PiglinBrain.onGuardedBlockInteracted(player, true);
	         }

	         return ActionResult.SUCCESS;
	      }
	   }
	
	@Override
	public void scheduledTick(BlockState state, ServerWorld serverWorld_1, BlockPos pos, Random random) {
		BlockEntity be = serverWorld_1.getBlockEntity(pos);
		if (be instanceof WoodenBarrelBlockEntity) {
			((WoodenBarrelBlockEntity)be).tick();
		}
	}
	
	@Override
	public BlockEntity createBlockEntity(BlockView blockView_1) {
		return new WoodenBarrelBlockEntity();
	}
	
	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
		if (stack.hasCustomName()) {
			BlockEntity be = world.getBlockEntity(pos);
			if (be instanceof WoodenBarrelBlockEntity) {
				((WoodenBarrelBlockEntity)be).setCustomName(stack.getName());
			}
		}
	}
}
