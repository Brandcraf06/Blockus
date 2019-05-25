package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.CirclePavementBlock;
import com.brand.blockus.blocks.SlabBase;
import com.brand.blockus.blocks.StairsBase;


public class NetherrackRelated {
	
	public static BlockBase POLISHED_NETHERRACK;
	public static StairsBase POLISHED_NETHERRACK_STAIRS;
	public static SlabBase POLISHED_NETHERRACK_SLAB;
	public static CirclePavementBlock NETHERRACK_CIRCLE_PAVEMENT;
	
	public static void init() {
		
		POLISHED_NETHERRACK = new BlockBase("polished_netherrack", 0.4f, 2.0f);
		POLISHED_NETHERRACK_STAIRS = new StairsBase(POLISHED_NETHERRACK.getDefaultState(),"polished_netherrack_stairs", 0.4f, 2.0f);
		POLISHED_NETHERRACK_SLAB = new SlabBase("polished_netherrack_slab", 1.0f, 2.0f);
		NETHERRACK_CIRCLE_PAVEMENT = new CirclePavementBlock("netherrack_circle_pavement", 1.0f, 2.0f);
			
	}

}