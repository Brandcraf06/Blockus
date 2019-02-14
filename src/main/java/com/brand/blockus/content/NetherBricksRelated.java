package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.PillarBase;

public class NetherBricksRelated {
	
	public static BlockBase SMOOTH_NETHER_BRICKS;
	public static BlockBase SMOOTH_RED_NETHER_BRICKS;
	public static PillarBase NETHER_PILLAR;
	public static PillarBase RED_NETHER_PILLAR;
	
	public static void init() {
		
		SMOOTH_NETHER_BRICKS = new BlockBase("smooth_nether_bricks", 2f, 30f);
		SMOOTH_RED_NETHER_BRICKS = new BlockBase("smooth_red_nether_bricks", 2f, 30f);
		NETHER_PILLAR = new PillarBase("nether_pillar", 2f, 30f);
		RED_NETHER_PILLAR = new PillarBase("red_nether_pillar", 2f, 30f);
				
	}

}
