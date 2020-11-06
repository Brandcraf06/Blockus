package com.brand.blockus.blockentity;

import com.brand.blockus.content.Barrels;

import net.minecraft.class_5561;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class WoodenBarrelBlockEntity extends LootableContainerBlockEntity {
	private DefaultedList<ItemStack> inventory;
	private class_5561 field_27207;
	
	public WoodenBarrelBlockEntity(BlockPos blockPos, BlockState blockState) {
	      super(Barrels.WOODEN_BARREL, blockPos, blockState);
		this.inventory = DefaultedList.ofSize(27, ItemStack.EMPTY);
		this.field_27207 = new class_5561() {
	         protected void method_31681(World world, BlockPos blockPos, BlockState blockState) {
	        	WoodenBarrelBlockEntity.this.playSound(blockState, SoundEvents.BLOCK_BARREL_OPEN);
	        	WoodenBarrelBlockEntity.this.setOpen(blockState, true);
	         }

	         protected void method_31683(World world, BlockPos blockPos, BlockState blockState) {
	        	WoodenBarrelBlockEntity.this.playSound(blockState, SoundEvents.BLOCK_BARREL_CLOSE);
	        	WoodenBarrelBlockEntity.this.setOpen(blockState, false);
	         }

	         protected void method_31682(World world, BlockPos blockPos, BlockState blockState, int i, int j) {
	         }

	         protected boolean method_31679(PlayerEntity playerEntity) {
	            if (playerEntity.currentScreenHandler instanceof GenericContainerScreenHandler) {
	               Inventory inventory = ((GenericContainerScreenHandler)playerEntity.currentScreenHandler).getInventory();
	               return inventory == WoodenBarrelBlockEntity.this;
	            } else {
	               return false;
	            }
	         }
	      };
	   }
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		if (!this.serializeLootTable(tag)) {
			Inventories.toTag(tag, this.inventory);
		}
		return tag;
	}
	
	   public void fromTag(CompoundTag compoundTag) {
		      super.fromTag(compoundTag);
		      this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
		      if (!this.deserializeLootTable(compoundTag)) {
		         Inventories.fromTag(compoundTag, this.inventory);
		      }

		   }
	
	public int size() {
		return 27;
	}
	
	protected DefaultedList<ItemStack> getInvStackList() {
		return this.inventory;
	}
	
	protected void setInvStackList(DefaultedList<ItemStack> defaultedList_1) {
		this.inventory = defaultedList_1;
	}
	
	protected Text getContainerName() {
		return new TranslatableText("container.barrel", new Object[0]);
	}
	
	protected ScreenHandler createScreenHandler(int i, PlayerInventory playerInventory) {
	      return GenericContainerScreenHandler.createGeneric9x3(i, playerInventory, this);
	}
	
	public void onOpen(PlayerEntity player) {
		      if (!player.isSpectator()) {
		         this.field_27207.method_31684(this.getWorld(), this.getPos(), this.getCachedState());
		      }

		   }

		   public void onClose(PlayerEntity player) {
		      if (!player.isSpectator()) {
		         this.field_27207.method_31685(this.getWorld(), this.getPos(), this.getCachedState());
		      }

		   }

		   public void tick() {
		      this.field_27207.method_31686(this.getWorld(), this.getPos(), this.getCachedState());
		   }
		
	private void setOpen(BlockState state, boolean boolean_1) {
		this.world.setBlockState(this.getPos(), state.with(BarrelBlock.OPEN, boolean_1), 3);
	}
	
	private void playSound(BlockState state, SoundEvent sound) {
		Vec3i vec3i_1 = state.get(BarrelBlock.FACING).getVector();
		double double_1 = this.pos.getX() + 0.5D + vec3i_1.getX() / 2.0D;
		double double_2 = this.pos.getY() + 0.5D + vec3i_1.getY() / 2.0D;
		double double_3 = this.pos.getZ() + 0.5D + vec3i_1.getZ() / 2.0D;
		this.world.playSound(null, double_1, double_2, double_3, sound, SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
	}
}
