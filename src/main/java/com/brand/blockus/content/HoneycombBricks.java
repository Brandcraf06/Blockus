package com.brand.blockus.content;

import com.brand.blockus.blocks.Honey.HoneycombBlockBase;
import com.brand.blockus.blocks.Honey.HoneycombSlab;
import com.brand.blockus.blocks.Honey.HoneycombStairs;
import com.brand.blockus.blocks.Honey.HoneycombWall;
public class HoneycombBricks {
	
	public static HoneycombBlockBase HONEYCOMB_BRICKS;
	public static HoneycombWall HONEYCOMB_BRICKS_WALL;
	public static HoneycombStairs HONEYCOMB_BRICKS_STAIRS;
	public static HoneycombSlab HONEYCOMB_BRICKS_SLAB;
	
	public static void init() {
		
		HONEYCOMB_BRICKS = new HoneycombBlockBase("honeycomb_bricks", 0.6f, 1.0f);
		HONEYCOMB_BRICKS_WALL = new HoneycombWall("honeycomb_bricks_wall", 0.6f, 1.0f);
		HONEYCOMB_BRICKS_STAIRS = new HoneycombStairs(HONEYCOMB_BRICKS.getDefaultState(), "honeycomb_bricks_stairs", 0.6f, 1.0f);
		HONEYCOMB_BRICKS_SLAB = new HoneycombSlab("honeycomb_bricks_slab", 0.6f, 1.0f);
				
	}

}
