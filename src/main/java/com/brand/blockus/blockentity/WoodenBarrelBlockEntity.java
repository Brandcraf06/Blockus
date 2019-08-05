package com.brand.blockus.blockentity;

import java.util.Iterator;

import com.brand.blockus.content.Barrels;

import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.container.Container;
import net.minecraft.container.GenericContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.math.Vec3i;

public class WoodenBarrelBlockEntity extends LootableContainerBlockEntity {
	private DefaultedList<ItemStack> inventory;
	private int viewerCount;
	
	private WoodenBarrelBlockEntity(BlockEntityType<?> blockEntityType_1) {
		super(blockEntityType_1);
		this.inventory = DefaultedList.ofSize(27, ItemStack.EMPTY);
	}
	
	public WoodenBarrelBlockEntity() {
		this(Barrels.WOODEN_BARREL);
	}
	
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		if (!this.serializeLootTable(tag)) {
			Inventories.toTag(tag, this.inventory);
		}
		return tag;
	}
	
	public void fromTag(CompoundTag tag) {
		super.fromTag(tag);
		this.inventory = DefaultedList.ofSize(this.getInvSize(), ItemStack.EMPTY);
		if (!this.deserializeLootTable(tag)) {
			Inventories.fromTag(tag, this.inventory);
		}
	}
	
	public int getInvSize() {
		return 27;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean isInvEmpty() {
		Iterator i = this.inventory.iterator();
		ItemStack stack;
		do {
			if (!i.hasNext()) {
				return true;
			}
			stack = (ItemStack)i.next();
		} while(stack.isEmpty());
		return false;
	}
	
	public ItemStack getInvStack(int int_1) {
		return (ItemStack)this.inventory.get(int_1);
	}
	
	public ItemStack takeInvStack(int int_1, int int_2) {
		return Inventories.splitStack(this.inventory, int_1, int_2);
	}
	
	public ItemStack removeInvStack(int int_1) {
		return Inventories.removeStack(this.inventory, int_1);
	}
	
	public void setInvStack(int int_1, ItemStack stack) {
		this.inventory.set(int_1, stack);
		if (stack.getCount() > this.getInvMaxStackAmount()) {
			stack.setCount(this.getInvMaxStackAmount());
		}
	}
	
	public void clear() {
		this.inventory.clear();
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
	
	protected Container createContainer(int int_1, PlayerInventory inventory) {
		return GenericContainer.createGeneric9x3(int_1, inventory, this);
	}
	
	public void onInvOpen(PlayerEntity player) {
		if (!player.isSpectator()) {
			if (this.viewerCount < 0) {
				this.viewerCount = 0;
			}
			++this.viewerCount;
			BlockState state = this.getCachedState();
			boolean boolean_1 = state.get(BarrelBlock.OPEN);
			if (!boolean_1) {
				this.playSound(state, SoundEvents.BLOCK_BARREL_OPEN);
				this.setOpen(state, true);
			}
			this.scheduleUpdate();
		}
	}
	
	private void scheduleUpdate() {
		this.world.getBlockTickScheduler().schedule(this.getPos(), this.getCachedState().getBlock(), 5);
	}
	
	public void tick() {
		int int_1 = this.pos.getX();
		int int_2 = this.pos.getY();
		int int_3 = this.pos.getZ();
		this.viewerCount = ChestBlockEntity.countViewers(this.world, this, int_1, int_2, int_3);
		if (this.viewerCount > 0) {
			this.scheduleUpdate();
		} else {
			BlockState state = this.getCachedState();
			if (state.getBlock() != Barrels.OAK_BARREL && state.getBlock() != Barrels.BIRCH_BARREL && state.getBlock() != Barrels.JUNGLE_BARREL && state.getBlock() != Barrels.ACACIA_BARREL && state.getBlock() != Barrels.DARK_OAK_BARREL && state.getBlock() != Barrels.BAMBOO_BARREL) {
				this.invalidate();
				return;
			}
			boolean boolean_1 = state.get(BarrelBlock.OPEN);
			if (boolean_1) {
				this.playSound(state, SoundEvents.BLOCK_BARREL_CLOSE);
				this.setOpen(state, false);
			}
		}
	}
	
	public void onInvClose(PlayerEntity player) {
		if (!player.isSpectator()) {
			--this.viewerCount;
		}
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
