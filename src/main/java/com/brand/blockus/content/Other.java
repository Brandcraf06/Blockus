package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.LoveBlock;
import com.brand.blockus.blocks.PaperWall;
import com.brand.blockus.blocks.PillarBase;
import com.brand.blockus.blocks.RottenFleshBlock;
import com.brand.blockus.blocks.StairsBase;
import com.brand.blockus.blocks.StoneDoor;

import net.minecraft.block.Blocks;

public class Other {
	
	public static BlockBase STARS_BLOCK;
	public static BlockBase ENDER_BLOCK;
	public static RottenFleshBlock ROTTEN_FLESH_BLOCK;
	public static StairsBase SMOOTH_STONE_STAIRS;
	public static PillarBase STONE_BRICKS_PILLAR;
	public static StoneDoor STONE_DOOR;
	public static BlockBase LARGE_BRICKS;
	public static LoveBlock LOVE_BLOCK;
	public static PaperWall WOODEN_FRAME;
	
	public static void init() {

		STARS_BLOCK = new BlockBase("stars_block", 5.0f, 30.0f);
		ENDER_BLOCK = new BlockBase("ender_block", 5.0f, 30.0f);
		ROTTEN_FLESH_BLOCK = new RottenFleshBlock("rotten_flesh_block", 1.5f, 9.0f);
		SMOOTH_STONE_STAIRS = new StairsBase(Blocks.SMOOTH_STONE.getDefaultState(), "smooth_stone_stairs", 1.5f, 30.0f);
		STONE_BRICKS_PILLAR = new PillarBase("stone_bricks_pillar", 1.5f, 30.0f);
		STONE_DOOR = new StoneDoor("stone_door", 1.5f, 20.0f);
		LARGE_BRICKS = new BlockBase("large_bricks", 2f, 30.0f);
		LOVE_BLOCK = new LoveBlock("love_block", 2f, 30.0f);
		WOODEN_FRAME = new PaperWall("wooden_frame", 0.1f, 4.0f);
			
	}

}
