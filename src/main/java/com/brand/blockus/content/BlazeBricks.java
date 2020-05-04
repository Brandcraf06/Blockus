package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Light.LightBlockBase;
import com.brand.blockus.blocks.Light.LightPillarBase;
import com.brand.blockus.blocks.Light.LightSlabBase;
import com.brand.blockus.blocks.Light.LightStairsBase;
import com.brand.blockus.blocks.Light.LightWallBase;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class BlazeBricks {
	
	public static final LightBlockBase BLAZE_BRICKS = new LightBlockBase("blaze_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15);
	public static final LightWallBase BLAZE_BRICKS_WALL = new LightWallBase("blaze_bricks_wall", 2f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15);
	public static final LightStairsBase BLAZE_BRICKS_STAIRS = new LightStairsBase(BLAZE_BRICKS.getDefaultState(), "blaze_bricks_stairs", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15);
	public static final LightSlabBase BLAZE_BRICKS_SLAB = new LightSlabBase("blaze_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15);
	public static final LightPillarBase BLAZE_PILLAR = new LightPillarBase("blaze_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15);
	
}
