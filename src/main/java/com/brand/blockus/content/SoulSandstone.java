package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.SlabBase;
import com.brand.blockus.blocks.StairsBase;
import com.brand.blockus.blocks.WallBase;

public class SoulSandstone {
	
	public static BlockBase SOUL_SANDSTONE;
	public static StairsBase SOUL_SANDSTONE_STAIRS;
	public static SlabBase SOUL_SANDSTONE_SLAB;
	public static BlockBase SMOOTH_SOUL_SANDSTONE;
	public static StairsBase SMOOTH_SOUL_SANDSTONE_STAIRS;
	public static SlabBase SMOOTH_SOUL_SANDSTONE_SLAB;
	public static BlockBase SOUL_SANDSTONE_BRICKS;
	public static StairsBase SOUL_SANDSTONE_BRICKS_STAIRS;
	public static SlabBase SOUL_SANDSTONE_BRICKS_SLAB;
	public static BlockBase CUT_SOUL_SANDSTONE;
	public static BlockBase CHISELED_SOUL_SANDSTONE;
	public static WallBase SOUL_SANDSTONE_WALL;
	
	public static void init() {
		
		SOUL_SANDSTONE_BRICKS = new BlockBase("soul_sandstone_bricks", 8.0f, 4.0f);
		SOUL_SANDSTONE_BRICKS_STAIRS = new StairsBase(SOUL_SANDSTONE_BRICKS.getDefaultState(), "soul_sandstone_bricks_stairs", 8.0f, 4.0f);
		SOUL_SANDSTONE_BRICKS_SLAB = new SlabBase("soul_sandstone_bricks_slab", 8.0f, 4.0f);
		SOUL_SANDSTONE = new BlockBase("soul_sandstone", 8.0f, 4.0f);
		SOUL_SANDSTONE_STAIRS = new StairsBase(SOUL_SANDSTONE.getDefaultState(), "soul_sandstone_stairs", 8.0f, 4.0f);
		SOUL_SANDSTONE_SLAB = new SlabBase("soul_sandstone_slab", 8.0f, 4.0f);
		SMOOTH_SOUL_SANDSTONE = new BlockBase("smooth_soul_sandstone", 8.0f, 4.0f);
		SMOOTH_SOUL_SANDSTONE_STAIRS = new StairsBase(SMOOTH_SOUL_SANDSTONE.getDefaultState(), "smooth_soul_sandstone_stairs", 8.0f, 4.0f);
		SMOOTH_SOUL_SANDSTONE_SLAB = new SlabBase("smooth_soul_sandstone_slab", 8.0f, 4.0f);
		CUT_SOUL_SANDSTONE = new BlockBase("cut_soul_sandstone", 8.0f, 4.0f);
		CHISELED_SOUL_SANDSTONE = new BlockBase("chiseled_soul_sandstone", 8.0f, 4.0f);
		SOUL_SANDSTONE_WALL = new WallBase("soul_sandstone_wall", 8.0f, 4.0f);	
	}

}
