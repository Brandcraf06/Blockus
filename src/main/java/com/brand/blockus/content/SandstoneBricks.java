package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class SandstoneBricks {
	
	// Sandstone
	public static final BlockBase ROUGH_SANDSTONE = new BlockBase("rough_sandstone", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.SAND);
	public static final BlockBase SANDSTONE_BRICKS = new BlockBase("sandstone_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.SAND);
	public static final StairsBase SANDSTONE_BRICKS_STAIRS = new StairsBase(SANDSTONE_BRICKS.getDefaultState(), "sandstone_bricks_stairs", SANDSTONE_BRICKS);
	public static final SlabBase SANDSTONE_BRICKS_SLAB = new SlabBase("sandstone_bricks_slab", SANDSTONE_BRICKS);
	
	public static final BlockBase SMALL_SANDSTONE_BRICKS = new BlockBase("small_sandstone_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.SAND);
	public static final StairsBase SMALL_SANDSTONE_BRICKS_STAIRS = new StairsBase(SMALL_SANDSTONE_BRICKS.getDefaultState(), "small_sandstone_bricks_stairs", SMALL_SANDSTONE_BRICKS);
	public static final SlabBase SMALL_SANDSTONE_BRICKS_SLAB = new SlabBase("small_sandstone_bricks_slab", SMALL_SANDSTONE_BRICKS);
	
	// Red Sandstone	
	public static final BlockBase RED_SANDSTONE_BRICKS = new BlockBase("red_sandstone_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.SAND);
	public static final StairsBase RED_SANDSTONE_BRICKS_STAIRS = new StairsBase(RED_SANDSTONE_BRICKS.getDefaultState(), "red_sandstone_bricks_stairs", RED_SANDSTONE_BRICKS);
	public static final SlabBase RED_SANDSTONE_BRICKS_SLAB = new SlabBase("red_sandstone_bricks_slab", RED_SANDSTONE_BRICKS);
	
	public static final BlockBase SMALL_RED_SANDSTONE_BRICKS = new BlockBase("small_red_sandstone_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.SAND);
	public static final StairsBase SMALL_RED_SANDSTONE_BRICKS_STAIRS = new StairsBase(SMALL_RED_SANDSTONE_BRICKS.getDefaultState(), "small_red_sandstone_bricks_stairs", SMALL_RED_SANDSTONE_BRICKS);
	public static final SlabBase SMALL_RED_SANDSTONE_BRICKS_SLAB = new SlabBase("small_red_sandstone_bricks_slab", SMALL_RED_SANDSTONE_BRICKS);
	
	
	// Sandy Bricks	
	public static final BlockBase SANDY_BRICKS = new BlockBase("sandy_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.SPRUCE);
	public static final StairsBase SANDY_BRICKS_STAIRS = new StairsBase(SANDY_BRICKS.getDefaultState(), "sandy_bricks_stairs", SANDY_BRICKS);
	public static final SlabBase SANDY_BRICKS_SLAB = new SlabBase("sandy_bricks_slab", SANDY_BRICKS);
	public static final WallBase SANDY_BRICKS_WALL = new WallBase("sandy_bricks_wall", SANDY_BRICKS);

}
