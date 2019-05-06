package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.PillarBase;
import com.brand.blockus.blocks.SlabBase;
import com.brand.blockus.blocks.StairsBase;

public class Bluestone {
	
	public static BlockBase BLUESTONE;
	public static StairsBase BLUESTONE_STAIRS;
	public static SlabBase BLUESTONE_SLAB;
	public static BlockBase BLUESTONE_TILES;
	public static StairsBase BLUESTONE_TILES_STAIRS;
	public static SlabBase BLUESTONE_TILES_SLAB;
	public static PillarBase BLUESTONE_PILLAR;
	public static BlockBase BLUESTONE_BRICKS;
	public static BlockBase SMOOTH_BLUESTONE;
	public static BlockBase BLUESTONE_SQUARES;
	public static BlockBase BLUESTONE_LITTLE_BRICKS;
	public static BlockBase CHISELED_BLUESTONE;
	public static PillarBase BLUESTONE_LINES;
	
	public static void init() {
		
		BLUESTONE = new BlockBase("bluestone", 1.5f, 6.0f);
		BLUESTONE_STAIRS = new StairsBase(BLUESTONE.getDefaultState(), "bluestone_stairs", 1.5f, 6.0f);
		BLUESTONE_SLAB = new SlabBase("bluestone_slab", 2.0f, 6.0f);
		BLUESTONE_TILES = new BlockBase("bluestone_tiles", 1.5f, 6.0f);
		BLUESTONE_TILES_STAIRS = new StairsBase(BLUESTONE_TILES.getDefaultState(), "bluestone_tiles_stairs", 1.5f, 6.0f);
		BLUESTONE_TILES_SLAB = new SlabBase("bluestone_tiles_slab", 2.0f, 6.0f);
		BLUESTONE_PILLAR = new PillarBase("bluestone_pillar", 1.5f, 6.0f);
		BLUESTONE_BRICKS = new BlockBase("bluestone_bricks", 1.5f, 6.0f);
		SMOOTH_BLUESTONE = new BlockBase("smooth_bluestone", 1.5f, 6.0f);
		BLUESTONE_SQUARES = new BlockBase("bluestone_squares", 1.5f, 6.0f);
		BLUESTONE_LITTLE_BRICKS = new BlockBase("bluestone_little_bricks", 1.5f, 6.0f);
		CHISELED_BLUESTONE = new BlockBase("chiseled_bluestone", 1.5f, 6.0f);
		BLUESTONE_LINES = new PillarBase("bluestone_lines", 1.5f, 6.0f);
		
	}

}
