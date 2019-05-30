package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.BlockStonePickaxe;
import com.brand.blockus.blocks.Barrier;
import com.brand.blockus.blocks.CautionBlock;
import com.brand.blockus.blocks.FallingRedstoneBase;
import com.brand.blockus.blocks.LightBlockBase;
import com.brand.blockus.blocks.LoveBlock;
import com.brand.blockus.blocks.NetherStarsBlock;
import com.brand.blockus.blocks.PaperWall;
import com.brand.blockus.blocks.PillarBase;
import com.brand.blockus.blocks.RottenFleshBlock;
import com.brand.blockus.blocks.SmallHedge;

public class Other {
	
	public static NetherStarsBlock NETHER_STARS_BLOCK;
	public static BlockStonePickaxe STARS_BLOCK;
	public static BlockStonePickaxe ENDER_BLOCK;
	public static RottenFleshBlock ROTTEN_FLESH_BLOCK;
	public static BlockBase LARGE_BRICKS;
	public static LoveBlock LOVE_BLOCK;
	public static PaperWall WOODEN_FRAME;
	public static RottenFleshBlock MEMBRANE_BLOCK;
	public static LightBlockBase BLAZE_BLOCK;
	public static SmallHedge SMALL_HEDGE;
	public static CautionBlock CAUTION_BLOCK;
	public static Barrier CAUTION_BARRIER;
	public static Barrier ROAD_BARRIER;
	public static PillarBase RAINBOW_BLOCK;
	public static FallingRedstoneBase REDSTONE_SAND;
	
	public static void init() {
		
		NETHER_STARS_BLOCK = new NetherStarsBlock("nether_stars_block", 5.0f, 30.0f);
		STARS_BLOCK = new BlockStonePickaxe("stars_block", 5.0f, 30.0f);
		ENDER_BLOCK = new BlockStonePickaxe("ender_block", 5.0f, 30.0f);
		ROTTEN_FLESH_BLOCK = new RottenFleshBlock("rotten_flesh_block", 1.5f, 9.0f);
		LARGE_BRICKS = new BlockBase("large_bricks", 2f, 30.0f);
		LOVE_BLOCK = new LoveBlock("love_block", 2f, 30.0f);
		WOODEN_FRAME = new PaperWall("wooden_frame", 0.1f, 4.0f);
		MEMBRANE_BLOCK = new RottenFleshBlock("membrane_block", 5.0f, 30.0f);
		BLAZE_BLOCK = new LightBlockBase("blaze_block", 2f, 30.0f);
		SMALL_HEDGE = new SmallHedge("small_hedge", 0.2f, 1.0f);
	    CAUTION_BLOCK = new CautionBlock("caution_block", 1.5f, 6000.0f);
	    CAUTION_BARRIER = new Barrier("caution_barrier", 1.5f, 6000.0f);
	    ROAD_BARRIER = new Barrier("road_barrier", 2f, 30.0f);
	    RAINBOW_BLOCK = new PillarBase("rainbow_block", 5.0f, 30.0f);			
	    REDSTONE_SAND = new FallingRedstoneBase("redstone_sand", 2.0f, 30.0f);			
	    
	}
}
