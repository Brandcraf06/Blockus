package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.CirclePavementBlock;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;
import com.brand.blockus.blocks.StoneDoor;
import com.brand.blockus.blocks.StoneTrapdoor;

import net.minecraft.block.Blocks;

public class StoneRelated {
	
	public static StairsBase SMOOTH_STONE_STAIRS;
	public static PillarBase STONE_BRICKS_PILLAR;
	public static StoneDoor STONE_DOOR;
	public static StoneTrapdoor STONE_TRAPDOOR;
	public static BlockBase ZIGZAGGED_STONE_BRICKS;
	public static CirclePavementBlock STONE_CIRCLE_PAVEMENT;
	
	public static PillarBase POLISHED_BLACKSTONE_PILLAR;
	public static BlockBase ZIGZAGGED_POLISHED_BLACKSTONE;
	public static CirclePavementBlock POLISHED_BLACKSTONE_CIRCLE_PAVEMENT;
	public static StoneDoor POLISHED_BLACKSTONE_DOOR;
	public static StoneTrapdoor POLISHED_BLACKSTONE_TRAPDOOR;
	public static BlockBase CRIMSON_WARTY_BLACKSTONE_BRICKS;
	public static WallBase CRIMSON_WARTY_BLACKSTONE_BRICKS_WALL;
	public static StairsBase CRIMSON_WARTY_BLACKSTONE_BRICKS_STAIRS;
	public static SlabBase CRIMSON_WARTY_BLACKSTONE_BRICKS_SLAB;
	public static BlockBase WARPED_WARTY_BLACKSTONE_BRICKS;
	public static WallBase WARPED_WARTY_BLACKSTONE_BRICKS_WALL;
	public static StairsBase WARPED_WARTY_BLACKSTONE_BRICKS_STAIRS;
	public static SlabBase WARPED_WARTY_BLACKSTONE_BRICKS_SLAB;
	
	public static void init() {

		SMOOTH_STONE_STAIRS = new StairsBase(Blocks.SMOOTH_STONE.getDefaultState(), "smooth_stone_stairs", 2.0f, 6.0f);
		STONE_BRICKS_PILLAR = new PillarBase("stone_bricks_pillar", 1.5f, 6.0f);
		STONE_DOOR = new StoneDoor("stone_door", 1.5f, 20.0f);
		STONE_TRAPDOOR = new StoneTrapdoor("stone_trapdoor", 1.5f, 20.0f);
		ZIGZAGGED_STONE_BRICKS = new BlockBase("zigzagged_stone_bricks", 1.5f, 6.0f);
		STONE_CIRCLE_PAVEMENT = new CirclePavementBlock("stone_circle_pavement", 1.5f, 6.0f);
		
 // blackstone		
		POLISHED_BLACKSTONE_PILLAR = new PillarBase("polished_blackstone_pillar", 1.5f, 6.0f);
		ZIGZAGGED_POLISHED_BLACKSTONE = new BlockBase("zigzagged_polished_blackstone", 1.5f, 6.0f);
		POLISHED_BLACKSTONE_CIRCLE_PAVEMENT = new CirclePavementBlock("polished_blackstone_circle_pavement", 1.5f, 6.0f);
		
		CRIMSON_WARTY_BLACKSTONE_BRICKS = new BlockBase("crimson_warty_blackstone_bricks", 1.5f, 6.0f);
		CRIMSON_WARTY_BLACKSTONE_BRICKS_WALL = new WallBase("crimson_warty_blackstone_bricks_wall", 1.5f, 6.0f);
		CRIMSON_WARTY_BLACKSTONE_BRICKS_STAIRS = new StairsBase(CRIMSON_WARTY_BLACKSTONE_BRICKS.getDefaultState(), "crimson_warty_blackstone_bricks_stairs", 1.5f, 6.0f);
		CRIMSON_WARTY_BLACKSTONE_BRICKS_SLAB = new SlabBase("crimson_warty_blackstone_bricks_slab", 2.0f, 6.0f);
		
		WARPED_WARTY_BLACKSTONE_BRICKS = new BlockBase("warped_warty_blackstone_bricks", 1.5f, 6.0f);
		WARPED_WARTY_BLACKSTONE_BRICKS_WALL = new WallBase("warped_warty_blackstone_bricks_wall", 1.5f, 6.0f);
		WARPED_WARTY_BLACKSTONE_BRICKS_STAIRS = new StairsBase(WARPED_WARTY_BLACKSTONE_BRICKS.getDefaultState(), "warped_warty_blackstone_bricks_stairs", 1.5f, 6.0f);
		WARPED_WARTY_BLACKSTONE_BRICKS_SLAB = new SlabBase("warped_warty_blackstone_bricks_slab", 2.0f, 6.0f);
			
	}
}
