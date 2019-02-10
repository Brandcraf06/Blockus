package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.SlabBase;
import com.brand.blockus.blocks.StairsBase;

public class SandstoneBricks {
	
	public static BlockBase SANDSTONE_BRICKS;
	public static StairsBase SANDSTONE_BRICKS_STAIRS;
	public static SlabBase SANDSTONE_BRICKS_SLAB;
	public static BlockBase RED_SANDSTONE_BRICKS;
	public static StairsBase RED_SANDSTONE_BRICKS_STAIRS;
	public static SlabBase RED_SANDSTONE_BRICKS_SLAB;
	
	public static void init() {
		
		SANDSTONE_BRICKS = new BlockBase("sandstone_bricks", 8.0f, 4.0f);
		SANDSTONE_BRICKS_STAIRS = new StairsBase(SANDSTONE_BRICKS.getDefaultState(), "sandstone_bricks_stairs", 8.0f, 4.0f);
		SANDSTONE_BRICKS_SLAB = new SlabBase("sandstone_bricks_slab", 8.0f, 4.0f);
		RED_SANDSTONE_BRICKS = new BlockBase("red_sandstone_bricks", 8.0f, 4.0f);
		RED_SANDSTONE_BRICKS_STAIRS = new StairsBase(RED_SANDSTONE_BRICKS.getDefaultState(), "red_sandstone_bricks_stairs", 8.0f, 4.0f);
		RED_SANDSTONE_BRICKS_SLAB = new SlabBase("red_sandstone_bricks_slab", 8.0f, 4.0f);
			
	}

}
