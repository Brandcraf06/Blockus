package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class SoulSandstone {
	
	public static final BlockBase SOUL_SANDSTONE_BRICKS = new BlockBase("soul_sandstone_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase SOUL_SANDSTONE_BRICKS_STAIRS = new StairsBase(SOUL_SANDSTONE_BRICKS.getDefaultState(), "soul_sandstone_bricks_stairs", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase SOUL_SANDSTONE_BRICKS_SLAB = new SlabBase("soul_sandstone_bricks_slab", 2.0f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase SOUL_SANDSTONE = new BlockBase("soul_sandstone", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase SOUL_SANDSTONE_STAIRS = new StairsBase(SOUL_SANDSTONE.getDefaultState(), "soul_sandstone_stairs", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase SOUL_SANDSTONE_SLAB = new SlabBase("soul_sandstone_slab", 2.0f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase SMOOTH_SOUL_SANDSTONE = new BlockBase("smooth_soul_sandstone", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase SMOOTH_SOUL_SANDSTONE_STAIRS = new StairsBase(SMOOTH_SOUL_SANDSTONE.getDefaultState(), "smooth_soul_sandstone_stairs", 8.0f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase SMOOTH_SOUL_SANDSTONE_SLAB = new SlabBase("smooth_soul_sandstone_slab", 2.0f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase CUT_SOUL_SANDSTONE = new BlockBase("cut_soul_sandstone", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final SlabBase CUT_SOUL_SANDSTONE_SLAB = new SlabBase("cut_soul_sandstone_slab", 2.0f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase CHISELED_SOUL_SANDSTONE = new BlockBase("chiseled_soul_sandstone", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final WallBase SOUL_SANDSTONE_WALL = new WallBase("soul_sandstone_wall", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	
    public static final BlockBase SMALL_SOUL_SANDSTONE_BRICKS = new BlockBase("small_soul_sandstone_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final StairsBase SMALL_SOUL_SANDSTONE_BRICKS_STAIRS = new StairsBase(SMALL_SOUL_SANDSTONE_BRICKS.getDefaultState(), "small_soul_sandstone_bricks_stairs", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
    public static final SlabBase SMALL_SOUL_SANDSTONE_BRICKS_SLAB = new SlabBase("small_soul_sandstone_bricks_slab", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	
}
