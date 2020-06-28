package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class SoakedBricks {
	
	public static final BlockBase SOAKED_BRICKS = new BlockBase("soaked_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.CYAN);
	public static final WallBase SOAKED_BRICKS_WALL = new WallBase("soaked_bricks_wall", SOAKED_BRICKS);
	public static final StairsBase SOAKED_BRICKS_STAIRS = new StairsBase(SOAKED_BRICKS.getDefaultState(), "soaked_bricks_stairs", SOAKED_BRICKS);
	public static final SlabBase SOAKED_BRICKS_SLAB = new SlabBase("soaked_bricks_slab", SOAKED_BRICKS);	

}
