package com.brand.blockus.content;

import com.brand.blockus.blocks.ObsidianBlockBase;
import com.brand.blockus.blocks.ObsidianCirclePavementBlock;
import com.brand.blockus.blocks.ObsidianDoor;
import com.brand.blockus.blocks.ObsidianPillarBase;
import com.brand.blockus.blocks.ObsidianSlabBase;
import com.brand.blockus.blocks.ObsidianStairsBase;
import com.brand.blockus.blocks.ObsidianTrapdoor;
import com.brand.blockus.blocks.ObsidianWallBase;

public class ObsidianRelated {
	
	public static ObsidianBlockBase OBSIDIAN_BRICKS;
	public static ObsidianStairsBase OBSIDIAN_BRICKS_STAIRS;
	public static ObsidianSlabBase OBSIDIAN_BRICKS_SLAB;
	public static ObsidianWallBase OBSIDIAN_BRICKS_WALL;
	public static ObsidianPillarBase OBSIDIAN_PILLAR;
	public static ObsidianCirclePavementBlock OBSIDIAN_CIRCLE_PAVEMENT;
	public static ObsidianDoor OBSIDIAN_REINFORCED_DOOR;
	public static ObsidianTrapdoor OBSIDIAN_REINFORCED_TRAPDOOR;


	public static void init() {
		
		OBSIDIAN_BRICKS = new ObsidianBlockBase("obsidian_bricks", 50.0F, 1200.0F);
		OBSIDIAN_BRICKS_STAIRS = new ObsidianStairsBase(OBSIDIAN_BRICKS.getDefaultState(), "obsidian_bricks_stairs", 50.0F, 1200.0F);
		OBSIDIAN_BRICKS_SLAB = new ObsidianSlabBase("obsidian_bricks_slab", 4.0F, 1200.0F);
		OBSIDIAN_BRICKS_WALL = new ObsidianWallBase("obsidian_bricks_wall", 50.0F, 1200.0F);
		OBSIDIAN_PILLAR = new ObsidianPillarBase("obsidian_pillar", 50.0F, 1200.0F);
		OBSIDIAN_CIRCLE_PAVEMENT = new ObsidianCirclePavementBlock("obsidian_circle_pavement", 50.0F, 1200.0F);
		OBSIDIAN_REINFORCED_DOOR = new ObsidianDoor("obsidian_reinforced_door", 50.0F, 1200.0F);
		OBSIDIAN_REINFORCED_TRAPDOOR = new ObsidianTrapdoor("obsidian_reinforced_trapdoor", 50.0F, 1200.0F);
		
	}

}
