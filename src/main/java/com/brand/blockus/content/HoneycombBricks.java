package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class HoneycombBricks {
	
	public static final BlockBase HONEYCOMB_BRICKS = new BlockBase("honeycomb_bricks", 0.6f, 1.0f, Material.CLAY, BlockSoundGroup.CORAL, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final WallBase HONEYCOMB_BRICKS_WALL = new WallBase("honeycomb_bricks_wall", 0.6f, 1.0f, Material.CLAY, BlockSoundGroup.CORAL);
	public static final StairsBase HONEYCOMB_BRICKS_STAIRS = new StairsBase(HONEYCOMB_BRICKS.getDefaultState(), "honeycomb_bricks_stairs", 0.6f, 1.0f, Material.CLAY, BlockSoundGroup.CORAL);
	public static final SlabBase HONEYCOMB_BRICKS_SLAB = new SlabBase("honeycomb_bricks_slab", 0.6f, 1.0f, Material.CLAY, BlockSoundGroup.CORAL);
	

}
