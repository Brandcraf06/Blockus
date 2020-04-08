package com.brand.blockus.content;

import com.brand.blockus.blocks.Light.LightBlockBase;
import com.brand.blockus.blocks.Light.LightSlabBase;
import com.brand.blockus.blocks.Light.LightStairsBase;
import com.brand.blockus.blocks.Light.LightWallBase;

public class LavaBricks {
	
	public static LightBlockBase LAVA_BRICKS;
	public static LightWallBase LAVA_BRICKS_WALL;
	public static LightStairsBase LAVA_BRICKS_STAIRS;
	public static LightSlabBase LAVA_BRICKS_SLAB;
	public static LightBlockBase CHISELED_LAVA_BRICKS;
	public static LightBlockBase LAVA_POLISHED_BLACKSTONE_BRICKS;
	public static LightWallBase LAVA_POLISHED_BLACKSTONE_WALL;
	public static LightStairsBase LAVA_POLISHED_BLACKSTONE_STAIRS;
	public static LightSlabBase LAVA_POLISHED_BLACKSTONE_SLAB;
	public static LightBlockBase CHISELED_LAVA_POLISHED_BLACKSTONE;
	
	public static void init() {
		
		LAVA_BRICKS = new LightBlockBase("lava_bricks", 1.5f, 6.0f);
		LAVA_BRICKS_WALL = new LightWallBase("lava_bricks_wall", 1.5f, 6.0f);
		LAVA_BRICKS_STAIRS = new LightStairsBase(LAVA_BRICKS.getDefaultState(), "lava_bricks_stairs", 1.5f, 6.0f);
		LAVA_BRICKS_SLAB = new LightSlabBase("lava_bricks_slab", 2.0f, 6.0f);
		CHISELED_LAVA_BRICKS = new LightBlockBase("chiseled_lava_bricks", 1.5f, 6.0f);
		
// blackstone			
		LAVA_POLISHED_BLACKSTONE_BRICKS = new LightBlockBase("lava_polished_blackstone_bricks", 1.5f, 6.0f);
		LAVA_POLISHED_BLACKSTONE_WALL = new LightWallBase("lava_polished_blackstone_wall", 1.5f, 6.0f);
		LAVA_POLISHED_BLACKSTONE_STAIRS = new LightStairsBase(LAVA_POLISHED_BLACKSTONE_BRICKS.getDefaultState(), "lava_polished_blackstone_stairs", 1.5f, 6.0f);
		LAVA_POLISHED_BLACKSTONE_SLAB = new LightSlabBase("lava_polished_blackstone_slab", 2.0f, 6.0f);
		CHISELED_LAVA_POLISHED_BLACKSTONE = new LightBlockBase("chiseled_lava_polished_blackstone", 1.5f, 6.0f);
				
	}

}
