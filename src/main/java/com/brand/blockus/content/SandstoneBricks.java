package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

public class SandstoneBricks {
	
	public static BlockBase SANDSTONE_BRICKS;
	public static StairsBase SANDSTONE_BRICKS_STAIRS;
	public static SlabBase SANDSTONE_BRICKS_SLAB;
	public static BlockBase RED_SANDSTONE_BRICKS;
	public static StairsBase RED_SANDSTONE_BRICKS_STAIRS;
	public static SlabBase RED_SANDSTONE_BRICKS_SLAB;
	public static BlockBase SANDY_BRICKS;
	public static StairsBase SANDY_BRICKS_STAIRS;
	public static SlabBase SANDY_BRICKS_SLAB;
	public static WallBase SANDY_BRICKS_WALL;

	public static void init() {
		
		SANDSTONE_BRICKS = new BlockBase("sandstone_bricks", 0.8f, 0.8f);
		SANDSTONE_BRICKS_STAIRS = new StairsBase(SANDSTONE_BRICKS.getDefaultState(), "sandstone_bricks_stairs", 0.8f, 0.8f);
		SANDSTONE_BRICKS_SLAB = new SlabBase("sandstone_bricks_slab", 2.0f, 0.8f);
		RED_SANDSTONE_BRICKS = new BlockBase("red_sandstone_bricks", 0.8f, 0.8f);
		RED_SANDSTONE_BRICKS_STAIRS = new StairsBase(RED_SANDSTONE_BRICKS.getDefaultState(), "red_sandstone_bricks_stairs", 0.8f, 0.8f);
		RED_SANDSTONE_BRICKS_SLAB = new SlabBase("red_sandstone_bricks_slab", 2.0f, 0.8f);
	    SANDY_BRICKS = new BlockBase("sandy_bricks", 2.0f, 6.0f);
	    SANDY_BRICKS_STAIRS = new StairsBase(SANDY_BRICKS.getDefaultState(), "sandy_bricks_stairs", 2.0f, 6.0f);
	    SANDY_BRICKS_SLAB = new SlabBase("sandy_bricks_slab", 2.0f, 6.0f);
	    SANDY_BRICKS_WALL = new WallBase("sandy_bricks_wall", 2.0f, 6.0f);

			
	}

}
