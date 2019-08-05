package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.CirclePavementBlock;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

public class Marble {
	
	public static BlockBase MARBLE;
	public static StairsBase MARBLE_STAIRS;
	public static SlabBase MARBLE_SLAB;
	public static BlockBase MARBLE_BRICKS;
	public static StairsBase MARBLE_BRICKS_STAIRS;
	public static SlabBase MARBLE_BRICKS_SLAB;
	public static WallBase MARBLE_BRICKS_WALL;
	public static PillarBase MARBLE_PILLAR;
	public static PillarBase CHISELED_MARBLE_PILLAR;
	public static BlockBase CHISELED_MARBLE;
	public static CirclePavementBlock MARBLE_CIRCLE_PAVEMENT;
	
	public static void init() {
		
		MARBLE = new BlockBase("marble", 1.5f, 6.0f);
		MARBLE_STAIRS = new StairsBase(MARBLE.getDefaultState(), "marble_stairs", 1.5f, 6.0f);
		MARBLE_SLAB = new SlabBase("marble_slab", 2.0f, 6.0f);
		MARBLE_BRICKS = new BlockBase("marble_bricks", 1.5f, 6.0f);
		MARBLE_BRICKS_STAIRS = new StairsBase(MARBLE_BRICKS.getDefaultState(), "marble_bricks_stairs", 1.5f, 6.0f);
		MARBLE_BRICKS_SLAB = new SlabBase("marble_bricks_slab", 2.0f, 6.0f);
		MARBLE_BRICKS_WALL = new WallBase("marble_bricks_wall", 2.0f, 6.0f);
		MARBLE_PILLAR = new PillarBase("marble_pillar", 1.5f, 6.0f);
		CHISELED_MARBLE_PILLAR = new PillarBase("chiseled_marble_pillar", 1.5f, 6.0f);
		CHISELED_MARBLE = new BlockBase("chiseled_marble", 1.5f, 6.0f);
		MARBLE_CIRCLE_PAVEMENT = new CirclePavementBlock("marble_circle_pavement", 1.5f, 6.0f);
		
	}

}
