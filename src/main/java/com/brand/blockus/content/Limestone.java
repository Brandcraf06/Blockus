package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.CirclePavementBlock;
import com.brand.blockus.blocks.PillarBase;
import com.brand.blockus.blocks.SlabBase;
import com.brand.blockus.blocks.StairsBase;
import com.brand.blockus.blocks.WallBase;

public class Limestone {
	
	public static BlockBase LIMESTONE;
	public static StairsBase LIMESTONE_STAIRS;
	public static SlabBase LIMESTONE_SLAB;
	public static BlockBase LIMESTONE_BRICKS;
	public static StairsBase LIMESTONE_BRICKS_STAIRS;
	public static SlabBase LIMESTONE_BRICKS_SLAB;
	public static WallBase LIMESTONE_BRICKS_WALL;
	public static PillarBase LIMESTONE_PILLAR;
	public static BlockBase CHISELED_LIMESTONE;
	public static CirclePavementBlock LIMESTONE_CIRCLE_PAVEMENT;
	
	public static void init() {
		
		LIMESTONE = new BlockBase("limestone", 1.5f, 6.0f);
		LIMESTONE_STAIRS = new StairsBase(LIMESTONE.getDefaultState(), "limestone_stairs", 1.5f, 6.0f);
		LIMESTONE_SLAB = new SlabBase("limestone_slab", 2.0f, 6.0f);
		LIMESTONE_BRICKS = new BlockBase("limestone_bricks", 1.5f, 6.0f);
		LIMESTONE_BRICKS_STAIRS = new StairsBase(LIMESTONE_BRICKS.getDefaultState(), "limestone_bricks_stairs", 1.5f, 6.0f);
		LIMESTONE_BRICKS_SLAB = new SlabBase("limestone_bricks_slab", 2.0f, 6.0f);
		LIMESTONE_BRICKS_WALL = new WallBase("limestone_bricks_wall", 2.0f, 6.0f);
		LIMESTONE_PILLAR = new PillarBase("limestone_pillar", 1.5f, 6.0f);
		CHISELED_LIMESTONE = new BlockBase("chiseled_limestone", 1.5f, 6.0f);
		LIMESTONE_CIRCLE_PAVEMENT = new CirclePavementBlock("limestone_circle_pavement", 1.5f, 6.0f);
		
	}

}
