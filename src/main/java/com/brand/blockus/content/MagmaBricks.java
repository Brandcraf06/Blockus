package com.brand.blockus.content;

import com.brand.blockus.blocks.LightBlockBase;
import com.brand.blockus.blocks.LightSlabBase;
import com.brand.blockus.blocks.LightStairsBase;
import com.brand.blockus.blocks.LightWallBase;

public class MagmaBricks {
	
	public static LightBlockBase MAGMA_BRICKS;
	public static LightWallBase MAGMA_BRICKS_WALL;
	public static LightStairsBase MAGMA_BRICKS_STAIRS;
	public static LightSlabBase MAGMA_BRICKS_SLAB;
	
	public static void init() {
		
		MAGMA_BRICKS = new LightBlockBase("magma_bricks", 0.5f, 1.0f);
		MAGMA_BRICKS_WALL = new LightWallBase("magma_bricks_wall", 0.5f, 1.0f);
		MAGMA_BRICKS_STAIRS = new LightStairsBase(MAGMA_BRICKS.getDefaultState(), "magma_bricks_stairs", 0.5f, 1.0f);
		MAGMA_BRICKS_SLAB = new LightSlabBase("magma_bricks_slab", 1.0f, 1.0f);
				
	}

}
