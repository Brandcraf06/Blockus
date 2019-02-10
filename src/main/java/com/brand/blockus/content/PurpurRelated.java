package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;

public class PurpurRelated {
	
	public static BlockBase PURPUR_BRICKS;
	public static BlockBase SMOOTH_PURPUR_BLOCK;
	
	public static void init() {
		
		PURPUR_BRICKS = new BlockBase("purpur_bricks", 1.5f, 30.0f);
		SMOOTH_PURPUR_BLOCK = new BlockBase("smooth_purpur_block", 1.5f, 30.0f);
		
	}

}
