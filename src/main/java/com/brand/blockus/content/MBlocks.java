package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.BlockPaper;
import com.brand.blockus.blocks.BlockWood;
import com.brand.blockus.blocks.ButtonWood;
import com.brand.blockus.blocks.FenceBase;
import com.brand.blockus.blocks.FenceGateBase;
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
import net.minecraft.item.ItemProvider;

public class MBlocks {
	
	public static BlockBase PURPUR_BRICKS;
	public static BlockBase SMOOTH_PURPUR_BLOCK;
	public static BlockBase LAVA_BRICKS;
	public static StairsBase LAVA_BRICKS_STAIRS;
	public static SlabBase LAVA_BRICKS_SLAB;
	public static BlockPaper PAPER_BLOCK;
	public static BlockPaper BURNED_PAPER_BLOCK;
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
	public static StoneDoor STONE_DOOR;
	
	public static void init() {
		
		PURPUR_BRICKS = new BlockBase("purpur_bricks", 1.5f, 30.0f);
		SMOOTH_PURPUR_BLOCK = new BlockBase("smooth_purpur_block", 1.5f, 30.0f);
		
		LAVA_BRICKS = new BlockBase("lava_bricks", 1.5f, 30.0f);
		LAVA_BRICKS_STAIRS = new StairsBase(LAVA_BRICKS.getDefaultState(), "lava_bricks_stairs", 1.5f, 30.0f);
		LAVA_BRICKS_SLAB = new SlabBase("lava_bricks_slab", 1.5f, 30.0f);
		
		STARS_BLOCK = new BlockBase("stars_block", 5.0f, 30.0f);
		ENDER_BLOCK = new BlockBase("ender_block", 5.0f, 30.0f);
		ROTTEN_FLESH_BLOCK = new RottenFleshBlock("rotten_flesh_block", 1.5f, 9.0f);
		
		PAPER_BLOCK = new BlockPaper("paper_block", 0.1f, 4.0f);
		BURNED_PAPER_BLOCK = new BlockPaper("burned_paper_block", 0.1f, 4.0f);
		
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
		
		BAMBOO_PLANKS = new BlockWood("bamboo_planks", 2f, 15f);
		BAMBOO_SLAB = new SlabWood("bamboo_slab", 2f, 15f);
		BAMBOO_STAIRS = new StairsWood(BAMBOO_PLANKS.getDefaultState(), "bamboo_stairs", 2f, 15f);
		BAMBOO_FENCE = new FenceBase("bamboo_fence", 2f, 15f);
		BAMBOO_FENCE_GATE = new FenceGateBase("bamboo_fence_gate", 2f, 15f);
		BAMBOO_PRESSURE_PLATE = new PressurePlateWood("bamboo_pressure_plate", 2f, 15f);
		BAMBOO_BUTTON = new ButtonWood("bamboo_button", 2f, 15f);
		BAMBOO_DOOR = new WoodenDoor("bamboo_door", 2f, 15f);
		BAMBOO_TRAPDOOR = new WoodenTrapdoor("bamboo_trapdoor", 2f, 15f);
		
		STONE_DOOR = new StoneDoor("stone_door", 1.5f, 20.0f);
		
		
			
	}

}
