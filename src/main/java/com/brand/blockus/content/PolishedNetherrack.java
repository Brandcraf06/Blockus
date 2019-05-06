package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.SlabBase;
import com.brand.blockus.blocks.StairsBase;


public class PolishedNetherrack {
	
	public static BlockBase POLISHED_NETHERRACK;
	public static StairsBase POLISHED_NETHERRACK_STAIRS;
	public static SlabBase POLISHED_NETHERRACK_SLAB;
	
	public static void init() {
		
		POLISHED_NETHERRACK = new BlockBase("polished_netherrack", 0.4f, 0.4f);
		POLISHED_NETHERRACK_STAIRS = new StairsBase(POLISHED_NETHERRACK.getDefaultState(),"polished_netherrack_stairs", 0.4f, 0.4f);
		POLISHED_NETHERRACK_SLAB = new SlabBase("polished_netherrack_slab", 1.0f, 0.4f);
				
	}

}