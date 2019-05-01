package com.brand.blockus.blocks;

import java.util.Random;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.entity.WoodenBarrelsEntity;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class WoodenBarrels extends BarrelBlock {

	public WoodenBarrels(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.WOOD).strength(hardness, resistance).build());
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().stackSize(64).itemGroup(Blockus.BLOCKUS_DECORATIONS)));
    }
	
	@Override
	public void onScheduledTick(BlockState state, World world, BlockPos pos, Random random) {
		BlockEntity be = world.getBlockEntity(pos);
		if (be instanceof WoodenBarrelsEntity) {
			((WoodenBarrelsEntity)be).tick();
		}
	}
	
	@Override
	public BlockEntity createBlockEntity(BlockView view) {
		return new WoodenBarrelsEntity();
	}
}
