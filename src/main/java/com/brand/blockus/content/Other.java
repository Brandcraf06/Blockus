package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.BlockStonePickaxe;
import com.brand.blockus.blocks.BarrierBase;
import com.brand.blockus.blocks.CautionBlock;
import com.brand.blockus.blocks.LanternFullBlock;
import com.brand.blockus.blocks.Base.FallingRedstoneBase;
import com.brand.blockus.blocks.LoveBlock;
import com.brand.blockus.blocks.NetherStarsBlock;
import com.brand.blockus.blocks.Paper.PaperWall;
import com.brand.blockus.blocks.Base.RedstoneLampBaseLit;
import com.brand.blockus.blocks.FoodBlocks.MeatBlock;
import com.brand.blockus.blocks.IronGate.IronGateBase;
import com.brand.blockus.blocks.Light.LightBlockBase;

public class Other {
	
	public static NetherStarsBlock NETHER_STARS_BLOCK;
	public static BlockStonePickaxe STARS_BLOCK;
	public static BlockStonePickaxe ENDER_BLOCK;
	public static BlockBase LARGE_BRICKS;
	public static BlockBase ZIGZAGGED_BRICKS;
	public static LoveBlock LOVE_BLOCK;
	public static PaperWall WOODEN_FRAME;
	public static MeatBlock MEMBRANE_BLOCK;
	public static LightBlockBase BLAZE_BLOCK;
	public static CautionBlock CAUTION_BLOCK;
	public static BarrierBase CAUTION_BARRIER;
	public static BarrierBase ROAD_BARRIER;
	public static FallingRedstoneBase REDSTONE_SAND;
	public static RedstoneLampBaseLit REDSTONE_LAMP_LIT;
	public static IronGateBase IRON_GATE;
	public static LanternFullBlock LANTERN_BLOCK;
	public static LanternFullBlock SOUL_LANTERN_BLOCK;
	
	public static void init() {
		NETHER_STARS_BLOCK = new NetherStarsBlock("nether_stars_block", 5.0f, 6.0f);
		STARS_BLOCK = new BlockStonePickaxe("stars_block", 5.0f, 6.0f);
		ENDER_BLOCK = new BlockStonePickaxe("ender_block", 5.0f, 6.0f);
		LARGE_BRICKS = new BlockBase("large_bricks", 2f, 6.0f);
		ZIGZAGGED_BRICKS = new BlockBase("zigzagged_bricks", 2f, 6.0f);
		LOVE_BLOCK = new LoveBlock("love_block", 2f, 6.0f);
		WOODEN_FRAME = new PaperWall("wooden_frame", 0.1f, 0.8f);
		MEMBRANE_BLOCK = new MeatBlock("membrane_block", 5.0f, 6.0f);
		BLAZE_BLOCK = new LightBlockBase("blaze_block", 2f, 6.0f);
	    CAUTION_BLOCK = new CautionBlock("caution_block", 1.5f, 1200.0f);
	    CAUTION_BARRIER = new BarrierBase("caution_barrier", 1.5f, 1200.0f);
	    ROAD_BARRIER = new BarrierBase("road_barrier", 2f, 6.0f);	
	    REDSTONE_SAND = new FallingRedstoneBase("redstone_sand", 2.0f, 6.0f);
	    REDSTONE_LAMP_LIT = new RedstoneLampBaseLit("redstone_lamp_lit", 0.3f, 0.3f);
	    IRON_GATE = new IronGateBase("iron_gate", 5.0f, 5.0f);
	    LANTERN_BLOCK = new LanternFullBlock("lantern_block", 0.3f, 0.3f, 15);
	    SOUL_LANTERN_BLOCK = new LanternFullBlock("soul_lantern_block", 0.3f, 0.3f, 10);
	}
}
