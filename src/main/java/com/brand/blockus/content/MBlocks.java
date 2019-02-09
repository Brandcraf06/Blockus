package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.BlockPaper;
import com.brand.blockus.blocks.BlockWood;
import com.brand.blockus.blocks.ButtonWood;
import com.brand.blockus.blocks.FenceBase;
import com.brand.blockus.blocks.FenceGateBase;
import com.brand.blockus.blocks.LightBlockBase;
import com.brand.blockus.blocks.LightSlabBase;
import com.brand.blockus.blocks.LightStairsBase;
import com.brand.blockus.blocks.LightWallBase;
import com.brand.blockus.blocks.PaperWall;
import com.brand.blockus.blocks.PatternedWool;
import com.brand.blockus.blocks.PillarBase;
import com.brand.blockus.blocks.PressurePlateWood;
import com.brand.blockus.blocks.RottenFleshBlock;
import com.brand.blockus.blocks.SlabBase;
import com.brand.blockus.blocks.SlabWood;
import com.brand.blockus.blocks.StairsBase;
import com.brand.blockus.blocks.StairsWood;
import com.brand.blockus.blocks.StoneDoor;
import com.brand.blockus.blocks.WoodenDoor;
import com.brand.blockus.blocks.WoodenTrapdoor;

import net.minecraft.block.Blocks;

public class MBlocks {
	
	public static LightBlockBase BLAZE_BRICKS;
	public static LightWallBase BLAZE_BRICKS_WALL;
	public static LightStairsBase BLAZE_BRICKS_STAIRS;
	public static LightSlabBase BLAZE_BRICKS_SLAB;
	public static BlockBase PURPUR_BRICKS;
	public static BlockBase SMOOTH_PURPUR_BLOCK;
	public static BlockBase SANDSTONE_BRICKS;
	public static StairsBase SANDSTONE_BRICKS_STAIRS;
	public static SlabBase SANDSTONE_BRICKS_SLAB;
	public static BlockBase RED_SANDSTONE_BRICKS;
	public static StairsBase RED_SANDSTONE_BRICKS_STAIRS;
	public static SlabBase RED_SANDSTONE_BRICKS_SLAB;
	public static LightBlockBase LAVA_BRICKS;
	public static LightStairsBase LAVA_BRICKS_STAIRS;
	public static LightSlabBase LAVA_BRICKS_SLAB;
	public static BlockPaper PAPER_BLOCK;
	public static BlockPaper BURNED_PAPER_BLOCK;
	public static PaperWall PAPER_WALL;
	public static BlockBase STARS_BLOCK;
	public static BlockBase ENDER_BLOCK;
	public static RottenFleshBlock ROTTEN_FLESH_BLOCK;
	public static StairsBase SMOOTH_STONE_STAIRS;
	public static PillarBase STONE_BRICKS_PILLAR;
	public static BlockBase WHITE_STONE_BRICKS;
	public static BlockBase ORANGE_STONE_BRICKS;
	public static BlockBase MAGENTA_STONE_BRICKS;
	public static BlockBase LIGHT_BLUE_STONE_BRICKS;
	public static BlockBase YELLOW_STONE_BRICKS;
	public static BlockBase LIME_STONE_BRICKS;
	public static BlockBase PINK_STONE_BRICKS;
	public static BlockBase GRAY_STONE_BRICKS;
	public static BlockBase CYAN_STONE_BRICKS;
	public static BlockBase PURPLE_STONE_BRICKS;
	public static BlockBase BLUE_STONE_BRICKS;
	public static BlockBase BROWN_STONE_BRICKS;
	public static BlockBase GREEN_STONE_BRICKS;
	public static BlockBase RED_STONE_BRICKS;
	public static BlockBase BLACK_STONE_BRICKS;
	public static BlockBase GREEN_ORANGE_COLORED_TILES;
	public static BlockBase LIME_YELLOW_COLORED_TILES;
	public static BlockBase LIGHT_BLUE_YELLOW_COLORED_TILES;
	public static BlockBase PINK_MAGENTA_COLORED_TILES;
	public static BlockBase RED_BLUE_COLORED_TILES;
	public static BlockBase LIGHT_BLUE_WHITE_COLORED_TILES;
	public static BlockBase RED_WHITE_COLORED_TILES;
	public static BlockBase BLACK_WHITE_COLORED_TILES;
	public static BlockBase BLUE_CYAN_COLORED_TILES;
	public static BlockWood BAMBOO_PLANKS;
	public static SlabWood BAMBOO_SLAB;
	public static StairsWood BAMBOO_STAIRS;
	public static FenceBase BAMBOO_FENCE;
	public static FenceGateBase BAMBOO_FENCE_GATE;
	public static PressurePlateWood BAMBOO_PRESSURE_PLATE;
	public static ButtonWood BAMBOO_BUTTON;
	public static WoodenDoor BAMBOO_DOOR;
	public static WoodenTrapdoor BAMBOO_TRAPDOOR;
	public static BlockBase POLISHED_NETHERRACK;
	public static StairsBase POLISHED_NETHERRACK_STAIRS;
	public static SlabBase POLISHED_NETHERRACK_SLAB;
	public static BlockBase BLUESTONE;
	public static StairsBase BLUESTONE_STAIRS;
	public static SlabBase BLUESTONE_SLAB;
	public static BlockBase BLUESTONE_TILES;
	public static StairsBase BLUESTONE_TILES_STAIRS;
	public static SlabBase BLUESTONE_TILES_SLAB;
	public static PillarBase BLUESTONE_PILLAR;
	public static BlockBase BLUESTONE_BRICKS;
	public static BlockBase SMOOTH_BLUESTONE;
	public static BlockBase LARGE_BRICKS;
	public static PatternedWool WHITE_PATTERNED_WOOL;
	public static PatternedWool ORANGE_PATTERNED_WOOL;
	public static PatternedWool MAGENTA_PATTERNED_WOOL;
	public static PatternedWool LIGHT_BLUE_PATTERNED_WOOL;
	public static PatternedWool YELLOW_PATTERNED_WOOL;
	public static PatternedWool LIME_PATTERNED_WOOL;
	public static PatternedWool PINK_PATTERNED_WOOL;
	public static PatternedWool GRAY_PATTERNED_WOOL;
	public static PatternedWool LIGHT_GRAY_PATTERNED_WOOL;
	public static PatternedWool CYAN_PATTERNED_WOOL;
	public static PatternedWool PURPLE_PATTERNED_WOOL;
	public static PatternedWool BLUE_PATTERNED_WOOL;
	public static PatternedWool BROWN_PATTERNED_WOOL;
	public static PatternedWool GREEN_PATTERNED_WOOL;
	public static PatternedWool RED_PATTERNED_WOOL;
	public static PatternedWool BLACK_PATTERNED_WOOL;
	public static StoneDoor STONE_DOOR;
	
	public static void init() {
		
		BLAZE_BRICKS = new LightBlockBase("blaze_bricks", 2f, 30.0f);
		BLAZE_BRICKS_WALL = new LightWallBase("blaze_bricks_wall", 2f, 30.0f);
		BLAZE_BRICKS_STAIRS = new LightStairsBase(BLAZE_BRICKS.getDefaultState(), "blaze_bricks_stairs", 2f, 30.0f);
		BLAZE_BRICKS_SLAB = new LightSlabBase("blaze_bricks_slab", 2f, 30.0f);
		
		PURPUR_BRICKS = new BlockBase("purpur_bricks", 1.5f, 30.0f);
		SMOOTH_PURPUR_BLOCK = new BlockBase("smooth_purpur_block", 1.5f, 30.0f);
		
		SANDSTONE_BRICKS = new BlockBase("sandstone_bricks", 8.0f, 4.0f);
		SANDSTONE_BRICKS_STAIRS = new StairsBase(SANDSTONE_BRICKS.getDefaultState(), "sandstone_bricks_stairs", 8.0f, 4.0f);
		SANDSTONE_BRICKS_SLAB = new SlabBase("sandstone_bricks_slab", 8.0f, 4.0f);
		RED_SANDSTONE_BRICKS = new BlockBase("red_sandstone_bricks", 8.0f, 4.0f);
		RED_SANDSTONE_BRICKS_STAIRS = new StairsBase(RED_SANDSTONE_BRICKS.getDefaultState(), "red_sandstone_bricks_stairs", 8.0f, 4.0f);
		RED_SANDSTONE_BRICKS_SLAB = new SlabBase("red_sandstone_bricks_slab", 8.0f, 4.0f);
		
		LAVA_BRICKS = new LightBlockBase("lava_bricks", 1.5f, 30.0f);
		LAVA_BRICKS_STAIRS = new LightStairsBase(LAVA_BRICKS.getDefaultState(), "lava_bricks_stairs", 1.5f, 30.0f);
		LAVA_BRICKS_SLAB = new LightSlabBase("lava_bricks_slab", 1.5f, 30.0f);
		
		STARS_BLOCK = new BlockBase("stars_block", 5.0f, 30.0f);
		ENDER_BLOCK = new BlockBase("ender_block", 5.0f, 30.0f);
		ROTTEN_FLESH_BLOCK = new RottenFleshBlock("rotten_flesh_block", 1.5f, 9.0f);
		
		PAPER_BLOCK = new BlockPaper("paper_block", 0.1f, 4.0f);
		BURNED_PAPER_BLOCK = new BlockPaper("burned_paper_block", 0.1f, 4.0f);
		PAPER_WALL = new PaperWall("paper_wall", 0.1f, 4.0f);
		
		SMOOTH_STONE_STAIRS = new StairsBase(Blocks.SMOOTH_STONE.getDefaultState(), "smooth_stone_stairs", 1.5f, 30.0f);
		STONE_BRICKS_PILLAR = new PillarBase("stone_bricks_pillar", 1.5f, 30.0f);
		
		WHITE_STONE_BRICKS = new BlockBase("white_stone_bricks", 1.5f, 30.0f);
		ORANGE_STONE_BRICKS = new BlockBase("orange_stone_bricks", 1.5f, 30.0f);
		MAGENTA_STONE_BRICKS = new BlockBase("magenta_stone_bricks", 1.5f, 30.0f);
		LIGHT_BLUE_STONE_BRICKS = new BlockBase("light_blue_stone_bricks", 1.5f, 30.0f);
		YELLOW_STONE_BRICKS = new BlockBase("yellow_stone_bricks", 1.5f, 30.0f);
		LIME_STONE_BRICKS = new BlockBase("lime_stone_bricks", 1.5f, 30.0f);
		PINK_STONE_BRICKS = new BlockBase("pink_stone_bricks", 1.5f, 30.0f);
		GRAY_STONE_BRICKS = new BlockBase("gray_stone_bricks", 1.5f, 30.0f);
		CYAN_STONE_BRICKS = new BlockBase("cyan_stone_bricks", 1.5f, 30.0f);
		PURPLE_STONE_BRICKS = new BlockBase("purple_stone_bricks", 1.5f, 30.0f);
		BLUE_STONE_BRICKS = new BlockBase("blue_stone_bricks", 1.5f, 30.0f);
		BROWN_STONE_BRICKS = new BlockBase("brown_stone_bricks", 1.5f, 30.0f);
		GREEN_STONE_BRICKS = new BlockBase("green_stone_bricks", 1.5f, 30.0f);
		RED_STONE_BRICKS = new BlockBase("red_stone_bricks", 1.5f, 30.0f);
		BLACK_STONE_BRICKS = new BlockBase("black_stone_bricks", 1.5f, 30.0f);
		
		GREEN_ORANGE_COLORED_TILES = new BlockBase("green_orange_colored_tiles", 1.8f, 9.0f);
		LIME_YELLOW_COLORED_TILES = new BlockBase("lime_yellow_colored_tiles", 1.8f, 9.0f);
		LIGHT_BLUE_YELLOW_COLORED_TILES = new BlockBase("light_blue_yellow_colored_tiles", 1.8f, 9.0f);
		PINK_MAGENTA_COLORED_TILES = new BlockBase("pink_magenta_colored_tiles", 1.8f, 9.0f);
		RED_BLUE_COLORED_TILES = new BlockBase("red_blue_colored_tiles", 1.8f, 9.0f);
		LIGHT_BLUE_WHITE_COLORED_TILES = new BlockBase("light_blue_white_colored_tiles", 1.8f, 9.0f);
		RED_WHITE_COLORED_TILES = new BlockBase("red_white_colored_tiles", 1.8f, 9.0f);
		BLACK_WHITE_COLORED_TILES = new BlockBase("black_white_colored_tiles", 1.8f, 9.0f);
		BLUE_CYAN_COLORED_TILES = new BlockBase("blue_cyan_colored_tiles", 1.8f, 9.0f);
		
		BAMBOO_PLANKS = new BlockWood("bamboo_planks", 2.0f, 15.0f);
		BAMBOO_SLAB = new SlabWood("bamboo_slab", 2.0f, 15.0f);
		BAMBOO_STAIRS = new StairsWood(BAMBOO_PLANKS.getDefaultState(), "bamboo_stairs", 2.0f, 15.0f);
		BAMBOO_FENCE = new FenceBase("bamboo_fence", 2.0f, 15.0f);
		BAMBOO_FENCE_GATE = new FenceGateBase("bamboo_fence_gate", 2.0f, 15.0f);
		BAMBOO_PRESSURE_PLATE = new PressurePlateWood("bamboo_pressure_plate", 2.0f, 15.0f);
		BAMBOO_BUTTON = new ButtonWood("bamboo_button", 2.0f, 15.0f);
		BAMBOO_DOOR = new WoodenDoor("bamboo_door", 2.0f, 15.0f);
		BAMBOO_TRAPDOOR = new WoodenTrapdoor("bamboo_trapdoor", 2.0f, 15.0f);
		
		POLISHED_NETHERRACK = new BlockBase("polished_netherrack", 0.4f, 2.0f);
		POLISHED_NETHERRACK_STAIRS = new StairsBase(POLISHED_NETHERRACK.getDefaultState(),"polished_netherrack_stairs", 0.4f, 2.0f);
		POLISHED_NETHERRACK_SLAB = new SlabBase("polished_netherrack_slab", 0.4f, 2.0f);
		
		BLUESTONE = new BlockBase("bluestone", 1.5f, 30.0f);
		BLUESTONE_STAIRS = new StairsBase(BLUESTONE.getDefaultState(), "bluestone_stairs", 1.5f, 30.0f);
		BLUESTONE_SLAB = new SlabBase("bluestone_slab", 1.5f, 30.0f);
		BLUESTONE_TILES = new BlockBase("bluestone_tiles", 1.5f, 30.0f);
		BLUESTONE_TILES_STAIRS = new StairsBase(BLUESTONE_TILES.getDefaultState(), "bluestone_tiles_stairs", 1.5f, 30.0f);
		BLUESTONE_TILES_SLAB = new SlabBase("bluestone_tiles_slab", 1.5f, 30.0f);
		BLUESTONE_PILLAR = new PillarBase("bluestone_pillar", 1.5f, 30.0f);
		BLUESTONE_BRICKS = new BlockBase("bluestone_bricks", 1.5f, 30.0f);
		SMOOTH_BLUESTONE = new BlockBase("smooth_bluestone", 1.5f, 30.0f);
		
		LARGE_BRICKS = new BlockBase("large_bricks", 2f, 30.0f);
		
		WHITE_PATTERNED_WOOL = new PatternedWool("white_patterned_wool", 0.8f, 4.0f);
		ORANGE_PATTERNED_WOOL = new PatternedWool("orange_patterned_wool", 0.8f, 4.0f);
		MAGENTA_PATTERNED_WOOL = new PatternedWool("magenta_patterned_wool", 0.8f, 4.0f);
		LIGHT_BLUE_PATTERNED_WOOL = new PatternedWool("light_blue_patterned_wool", 0.8f, 4.0f);
		YELLOW_PATTERNED_WOOL = new PatternedWool("yellow_patterned_wool", 0.8f, 4.0f);
		LIME_PATTERNED_WOOL = new PatternedWool("lime_patterned_wool", 0.8f, 4.0f);
		PINK_PATTERNED_WOOL = new PatternedWool("pink_patterned_wool", 0.8f, 4.0f);
		GRAY_PATTERNED_WOOL = new PatternedWool("gray_patterned_wool", 0.8f, 4.0f);
		LIGHT_GRAY_PATTERNED_WOOL = new PatternedWool("light_gray_patterned_wool", 0.8f, 4.0f);
		CYAN_PATTERNED_WOOL = new PatternedWool("cyan_patterned_wool", 0.8f, 4.0f);
		PURPLE_PATTERNED_WOOL = new PatternedWool("purple_patterned_wool", 0.8f, 4.0f);
		BLUE_PATTERNED_WOOL = new PatternedWool("blue_patterned_wool", 0.8f, 4.0f);
		BROWN_PATTERNED_WOOL = new PatternedWool("brown_patterned_wool", 0.8f, 4.0f);
		GREEN_PATTERNED_WOOL = new PatternedWool("green_patterned_wool", 0.8f, 4.0f);
		RED_PATTERNED_WOOL = new PatternedWool("red_patterned_wool", 0.8f, 4.0f);
		BLACK_PATTERNED_WOOL = new PatternedWool("black_patterned_wool", 0.8f, 4.0f);
		
		STONE_DOOR = new StoneDoor("stone_door", 1.5f, 20.0f);
		
		
			
	}

}
