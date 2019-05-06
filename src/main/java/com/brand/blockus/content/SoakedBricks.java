package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.SlabBase;
import com.brand.blockus.blocks.StairsBase;
import com.brand.blockus.blocks.WallBase;

public class SoakedBricks {
	
	public static BlockBase SOAKED_BRICKS;
	public static WallBase SOAKED_BRICKS_WALL;
	public static StairsBase SOAKED_BRICKS_STAIRS;
	public static SlabBase SOAKED_BRICKS_SLAB;

	public static void init() {
		
		SOAKED_BRICKS = new BlockBase("soaked_bricks", 2.0f, 6.0f);
		SOAKED_BRICKS_WALL = new WallBase("soaked_bricks_wall", 2.0f, 6.0f);
		SOAKED_BRICKS_STAIRS = new StairsBase(SOAKED_BRICKS.getDefaultState(), "soaked_bricks_stairs", 2.0f, 6.0f);
		SOAKED_BRICKS_SLAB = new SlabBase("soaked_bricks_slab", 2.0f, 6.0f);		
	}

}
