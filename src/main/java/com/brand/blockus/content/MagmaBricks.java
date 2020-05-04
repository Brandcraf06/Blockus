package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Light.LightBlockBase;
import com.brand.blockus.blocks.Light.LightSlabBase;
import com.brand.blockus.blocks.Light.LightStairsBase;
import com.brand.blockus.blocks.Light.LightWallBase;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class MagmaBricks {
	
	public static LightBlockBase MAGMA_BRICKS = new LightBlockBase("magma_bricks", 0.5f, 1.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15);
	public static LightWallBase MAGMA_BRICKS_WALL = new LightWallBase("magma_bricks_wall", 0.5f, 1.0f, Material.STONE, BlockSoundGroup.STONE, 15);
	public static LightStairsBase MAGMA_BRICKS_STAIRS = new LightStairsBase(MAGMA_BRICKS.getDefaultState(), "magma_bricks_stairs", 0.5f, 1.0f, Material.STONE, BlockSoundGroup.STONE, 15);
	public static LightSlabBase MAGMA_BRICKS_SLAB = new LightSlabBase("magma_bricks_slab", 1.0f, 1.0f, Material.STONE, BlockSoundGroup.STONE, 15);

}
