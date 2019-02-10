package com.brand.blockus.content;

import com.brand.blockus.blocks.LightBlockBase;
import com.brand.blockus.blocks.LightSlabBase;
import com.brand.blockus.blocks.LightStairsBase;
import com.brand.blockus.blocks.LightWallBase;

public class BlazeBricks {
	
	public static LightBlockBase BLAZE_BRICKS;
	public static LightWallBase BLAZE_BRICKS_WALL;
	public static LightStairsBase BLAZE_BRICKS_STAIRS;
	public static LightSlabBase BLAZE_BRICKS_SLAB;
	
	public static void init() {
		
		BLAZE_BRICKS = new LightBlockBase("blaze_bricks", 2f, 30.0f);
		BLAZE_BRICKS_WALL = new LightWallBase("blaze_bricks_wall", 2f, 30.0f);
		BLAZE_BRICKS_STAIRS = new LightStairsBase(BLAZE_BRICKS.getDefaultState(), "blaze_bricks_stairs", 2f, 30.0f);
		BLAZE_BRICKS_SLAB = new LightSlabBase("blaze_bricks_slab", 2f, 30.0f);
			
	}

}
