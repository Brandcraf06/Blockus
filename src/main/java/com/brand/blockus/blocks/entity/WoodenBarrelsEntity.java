package com.brand.blockus.blocks.entity;

import com.brand.blockus.blocks.WoodenBarrels;
import com.brand.blockus.content.Barrels;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3i;

public class WoodenBarrelsEntity extends BarrelBlockEntity {
	private int viewerCount;
	
	@Override
	public void onInvOpen(PlayerEntity player) {
		if (!player.isSpectator()) {
			if (this.viewerCount < 0) {
				this.viewerCount = 0;
			}
			++this.viewerCount;
			BlockState state = this.getCachedState();
			boolean bool = state.get(WoodenBarrels.OPEN);
			if (!bool) {
				this.playSound(state, SoundEvents.BLOCK_BARREL_OPEN);
				this.setOpen(state, true);
			}
			this.scheduleUpdate();
		}
	}
	
	public void scheduleUpdate() {
		this.world.getBlockTickScheduler().schedule(this.getPos(), this.getCachedState().getBlock(), 5);
	}
	
	@Override
	public void tick() {
		int int_1 = this.pos.getX();
		int int_2 = this.pos.getY();
		int int_3 = this.pos.getZ();
		this.viewerCount = ChestBlockEntity.countViewers(this.world, this, int_1, int_2, int_3);
		if (this.viewerCount > 0) {
			this.scheduleUpdate();
		} else {
			BlockState blockState_1 = this.getCachedState();
			if (blockState_1.getBlock() != Barrels.OAK_BARREL && blockState_1.getBlock() != Barrels.BIRCH_BARREL && blockState_1.getBlock() != Barrels.JUNGLE_BARREL && blockState_1.getBlock() != Barrels.ACACIA_BARREL && blockState_1.getBlock() != Barrels.DARK_OAK_BARREL && blockState_1.getBlock() != Barrels.BAMBOO_BARREL) {
				this.invalidate();
				return;
			}
			boolean boolean_1 = blockState_1.get(WoodenBarrels.OPEN);
			if (boolean_1) {
				this.playSound(blockState_1, SoundEvents.BLOCK_BARREL_CLOSE);
				this.setOpen(blockState_1, false);
			}
		}
	}
	
	@Override
	public void onInvClose(PlayerEntity playerEntity_1) {
		if (!playerEntity_1.isSpectator()) {
			--this.viewerCount;
		}
	}
	
	public void setOpen(BlockState blockState_1, boolean boolean_1) {
		this.world.setBlockState(this.getPos(), blockState_1.with(WoodenBarrels.OPEN, boolean_1), 3);
	}
	
	public void playSound(BlockState blockState_1, SoundEvent soundEvent_1) {
		Vec3i vec3i_1 = (blockState_1.get(WoodenBarrels.FACING)).getVector();
		double double_1 = this.pos.getX() + 0.5D + vec3i_1.getX() / 2.0D;
		double double_2 = this.pos.getY() + 0.5D + vec3i_1.getY() / 2.0D;
		double double_3 = this.pos.getZ() + 0.5D + vec3i_1.getZ() / 2.0D;
		this.world.playSound(null, double_1, double_2, double_3, soundEvent_1, SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
	}
}
