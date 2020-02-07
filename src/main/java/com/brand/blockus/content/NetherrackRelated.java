package com.brand.blockus.content;

import com.brand.blockus.blocks.Nether.NetherBlockBase;
import com.brand.blockus.blocks.Nether.NetherSlabBase;
import com.brand.blockus.blocks.Nether.NetherStairsBase;

import net.minecraft.sound.BlockSoundGroup;

import com.brand.blockus.blocks.Nether.NetherCirclePavementBlock;


public class NetherrackRelated {
	
	public static NetherBlockBase POLISHED_NETHERRACK;
	public static NetherStairsBase POLISHED_NETHERRACK_STAIRS;
	public static NetherSlabBase POLISHED_NETHERRACK_SLAB;
	public static NetherCirclePavementBlock NETHERRACK_CIRCLE_PAVEMENT;
	
	public static void init() {
		
		POLISHED_NETHERRACK = new NetherBlockBase("polished_netherrack", 0.4f, 0.4f, BlockSoundGroup.NETHERRACK);
		POLISHED_NETHERRACK_STAIRS = new NetherStairsBase(POLISHED_NETHERRACK.getDefaultState(),"polished_netherrack_stairs", 0.4f, 0.4f, BlockSoundGroup.NETHERRACK);
		POLISHED_NETHERRACK_SLAB = new NetherSlabBase("polished_netherrack_slab", 1.0f, 0.4f, BlockSoundGroup.NETHERRACK);
		NETHERRACK_CIRCLE_PAVEMENT = new NetherCirclePavementBlock("netherrack_circle_pavement", 1.0f, 0.4f, BlockSoundGroup.NETHERRACK);
			
	}

}