package com.brand.blockus.content;

import com.brand.blockus.blocks.Water.WaterBlockBase;
import com.brand.blockus.blocks.Water.WaterSlabBase;
import com.brand.blockus.blocks.Water.WaterStairsBase;
import com.brand.blockus.blocks.Water.WaterWallBase;

public class WaterBricks {
	
	public static WaterBlockBase WATER_BRICKS;
	public static WaterWallBase WATER_BRICKS_WALL;
	public static WaterStairsBase WATER_BRICKS_STAIRS;
	public static WaterSlabBase WATER_BRICKS_SLAB;
	public static WaterBlockBase CHISELED_WATER_BRICKS;
	
	public static void init() {
		
		WATER_BRICKS = new WaterBlockBase("water_bricks", 1.5f, 6.0f);
		WATER_BRICKS_WALL = new WaterWallBase("water_bricks_wall", 1.5f, 6.0f);
		WATER_BRICKS_STAIRS = new WaterStairsBase(WATER_BRICKS.getDefaultState(), "water_bricks_stairs", 1.5f, 6.0f);
		WATER_BRICKS_SLAB = new WaterSlabBase("water_bricks_slab", 2.0f, 6.0f);
		CHISELED_WATER_BRICKS = new WaterBlockBase("chiseled_water_bricks", 1.5f, 6.0f);
				
	}

}
