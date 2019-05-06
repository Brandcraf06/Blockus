package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.PillarBase;
import com.brand.blockus.blocks.StairsBase;
import com.brand.blockus.blocks.StoneDoor;
import com.brand.blockus.blocks.StoneTrapdoor;

import net.minecraft.block.Blocks;

public class StoneRelated {
	
	public static StairsBase SMOOTH_STONE_STAIRS;
	public static PillarBase STONE_BRICKS_PILLAR;
	public static StoneDoor STONE_DOOR;
	public static StoneTrapdoor STONE_TRAPDOOR;
	public static BlockBase ZIGZAGGED_STONE_BRICKS;
	
	public static void init() {

		SMOOTH_STONE_STAIRS = new StairsBase(Blocks.SMOOTH_STONE.getDefaultState(), "smooth_stone_stairs", 2.0f, 6.0f);
		STONE_BRICKS_PILLAR = new PillarBase("stone_bricks_pillar", 1.5f, 6.0f);
		STONE_DOOR = new StoneDoor("stone_door", 1.5f, 4.0f);
		STONE_TRAPDOOR = new StoneTrapdoor("stone_trapdoor", 1.5f, 4.0f);
		ZIGZAGGED_STONE_BRICKS = new BlockBase("zigzagged_stone_bricks", 1.5f, 6.0f);
			
	}
}
