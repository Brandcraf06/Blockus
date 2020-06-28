package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class SoulSandstone {
	
	public static final BlockBase SOUL_SANDSTONE_BRICKS = new BlockBase("soul_sandstone_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BROWN);
	public static final StairsBase SOUL_SANDSTONE_BRICKS_STAIRS = new StairsBase(SOUL_SANDSTONE_BRICKS.getDefaultState(), "soul_sandstone_bricks_stairs", SOUL_SANDSTONE_BRICKS);
	public static final SlabBase SOUL_SANDSTONE_BRICKS_SLAB = new SlabBase("soul_sandstone_bricks_slab", SOUL_SANDSTONE_BRICKS);
	public static final BlockBase SOUL_SANDSTONE = new BlockBase("soul_sandstone", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BROWN);
	public static final StairsBase SOUL_SANDSTONE_STAIRS = new StairsBase(SOUL_SANDSTONE.getDefaultState(), "soul_sandstone_stairs", SOUL_SANDSTONE);
	public static final SlabBase SOUL_SANDSTONE_SLAB = new SlabBase("soul_sandstone_slab", SOUL_SANDSTONE);
	public static final WallBase SOUL_SANDSTONE_WALL = new WallBase("soul_sandstone_wall", SOUL_SANDSTONE);
	public static final BlockBase SMOOTH_SOUL_SANDSTONE = new BlockBase("smooth_soul_sandstone", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BROWN);
	public static final StairsBase SMOOTH_SOUL_SANDSTONE_STAIRS = new StairsBase(SMOOTH_SOUL_SANDSTONE.getDefaultState(), "smooth_soul_sandstone_stairs", SMOOTH_SOUL_SANDSTONE);
	public static final SlabBase SMOOTH_SOUL_SANDSTONE_SLAB = new SlabBase("smooth_soul_sandstone_slab", SMOOTH_SOUL_SANDSTONE);
	public static final BlockBase CUT_SOUL_SANDSTONE = new BlockBase("cut_soul_sandstone", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BROWN);
	public static final SlabBase CUT_SOUL_SANDSTONE_SLAB = new SlabBase("cut_soul_sandstone_slab", CUT_SOUL_SANDSTONE);
	public static final BlockBase CHISELED_SOUL_SANDSTONE = new BlockBase("chiseled_soul_sandstone", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BROWN);
	
	public static final BlockBase SMALL_SOUL_SANDSTONE_BRICKS = new BlockBase("small_soul_sandstone_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BROWN);
	public static final StairsBase SMALL_SOUL_SANDSTONE_BRICKS_STAIRS = new StairsBase(SMALL_SOUL_SANDSTONE_BRICKS.getDefaultState(), "small_soul_sandstone_bricks_stairs", SMALL_SOUL_SANDSTONE_BRICKS);
	public static final SlabBase SMALL_SOUL_SANDSTONE_BRICKS_SLAB = new SlabBase("small_soul_sandstone_bricks_slab", SMALL_SOUL_SANDSTONE_BRICKS);
	
}
