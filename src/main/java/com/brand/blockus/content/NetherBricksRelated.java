package com.brand.blockus.content;



import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

public class NetherBricksRelated {
	
	public static BlockBase SMOOTH_NETHER_BRICKS;
	public static BlockBase SMOOTH_RED_NETHER_BRICKS;
	public static PillarBase NETHER_PILLAR;
	public static PillarBase RED_NETHER_PILLAR;
	public static PillarBase CHARRED_NETHER_PILLAR;
	public static BlockBase SMOOTH_CHARRED_NETHER_BRICKS;
	public static WallBase CHARRED_NETHER_BRICKS_WALL;
	public static StairsBase CHARRED_NETHER_BRICKS_STAIRS;
	public static SlabBase CHARRED_NETHER_BRICKS_SLAB;
	public static BlockBase CHARRED_NETHER_BRICKS;
	public static BlockBase ZIGZAGGED_NETHER_BRICKS;
	public static BlockBase ZIGZAGGED_RED_NETHER_BRICKS;
	public static BlockBase ZIGZAGGED_CHARRED_NETHER_BRICKS;
	
	public static void init() {
		
		SMOOTH_NETHER_BRICKS = new BlockBase("smooth_nether_bricks", 2.0f, 6.0f);
		SMOOTH_RED_NETHER_BRICKS = new BlockBase("smooth_red_nether_bricks", 2.0f, 6.0f);
		ZIGZAGGED_NETHER_BRICKS = new BlockBase("zigzagged_nether_bricks", 2.0f, 6.0f);
		ZIGZAGGED_RED_NETHER_BRICKS = new BlockBase("zigzagged_red_nether_bricks", 2.0f, 6.0f);
		NETHER_PILLAR = new PillarBase("nether_pillar", 2.0f, 6.0f);
		RED_NETHER_PILLAR = new PillarBase("red_nether_pillar", 2.0f, 6.0f);
// charred
		CHARRED_NETHER_BRICKS = new BlockBase("charred_nether_bricks", 2.0f, 6.0f);
		CHARRED_NETHER_BRICKS_STAIRS = new StairsBase(NetherBricksRelated.CHARRED_NETHER_BRICKS.getDefaultState(), "charred_nether_bricks_stairs", 2.0f, 6.0f);
		CHARRED_NETHER_BRICKS_SLAB = new SlabBase("charred_nether_bricks_slab", 2.0f, 6.0f);
		CHARRED_NETHER_BRICKS_WALL = new WallBase("charred_nether_bricks_wall", 2.0f, 6.0f);
		SMOOTH_CHARRED_NETHER_BRICKS = new BlockBase("smooth_charred_nether_bricks", 2.0f, 6.0f);
		CHARRED_NETHER_PILLAR = new PillarBase("charred_nether_pillar", 2.0f, 6.0f);
		ZIGZAGGED_CHARRED_NETHER_BRICKS = new BlockBase("zigzagged_charred_nether_bricks", 2.0f, 6.0f);

	}

}
