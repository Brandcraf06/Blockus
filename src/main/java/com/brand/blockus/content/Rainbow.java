package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.RedstoneLampBase;
import com.brand.blockus.blocks.Base.RedstoneLampBaseLit;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

public class Rainbow {
	
	
	public static PillarBase RAINBOW_BLOCK;
	public static BlockBase RAINBOW_BRICKS;
	public static StairsBase RAINBOW_BRICKS_STAIRS;
	public static SlabBase RAINBOW_BRICKS_SLAB;
	public static WallBase RAINBOW_BRICKS_WALL;
	public static RedstoneLampBase RAINBOW_LAMP;
	public static RedstoneLampBaseLit RAINBOW_LAMP_LIT;
	
	public static void init() {
		
	    RAINBOW_BLOCK = new PillarBase("rainbow_block", 5.0f, 6.0f);			
	    RAINBOW_BRICKS = new BlockBase("rainbow_bricks", 1.5f, 6.0f);
	    RAINBOW_BRICKS_STAIRS = new StairsBase(RAINBOW_BRICKS.getDefaultState(), "rainbow_bricks_stairs", 1.5f, 6.0f);
		RAINBOW_BRICKS_SLAB = new SlabBase("rainbow_bricks_slab", 2.0f, 6.0f);
		RAINBOW_BRICKS_WALL = new WallBase("rainbow_bricks_wall", 1.5f, 6.0f);
		RAINBOW_LAMP = new RedstoneLampBase("rainbow_lamp", 0.3f, 0.3f);
		RAINBOW_LAMP_LIT = new RedstoneLampBaseLit("rainbow_lamp_lit", 0.3f, 0.3f);
	    
	}
}
