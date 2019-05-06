package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.PillarBase;

public class PurpurRelated {
	
	public static BlockBase PURPUR_BRICKS;
	public static BlockBase SMOOTH_PURPUR;
	public static BlockBase PURPUR_SQUARES;
	public static BlockBase PURPUR_LITTLE_BRICKS;
	public static BlockBase CHISELED_PURPUR;
	public static PillarBase PURPUR_LINES;
	
	public static void init() {
		
		PURPUR_BRICKS = new BlockBase("purpur_bricks", 1.5f, 6.0f);
		SMOOTH_PURPUR = new BlockBase("smooth_purpur", 1.5f, 6.0f);
		PURPUR_SQUARES = new BlockBase("purpur_squares", 1.5f, 6.0f);
		PURPUR_LITTLE_BRICKS = new BlockBase("purpur_little_bricks", 1.5f, 6.0f);
		CHISELED_PURPUR = new BlockBase("chiseled_purpur", 1.5f, 6.0f);
		PURPUR_LINES = new PillarBase("purpur_lines", 1.5f, 6.0f);
		
	}

}
