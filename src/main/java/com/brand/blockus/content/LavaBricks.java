package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Light.LightBlockBase;
import com.brand.blockus.blocks.Light.LightSlabBase;
import com.brand.blockus.blocks.Light.LightStairsBase;
import com.brand.blockus.blocks.Light.LightWallBase;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class LavaBricks {
	
	public static final LightBlockBase LAVA_BRICKS = new LightBlockBase("lava_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15);
	public static final LightWallBase LAVA_BRICKS_WALL = new LightWallBase("lava_bricks_wall", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15);
	public static final LightStairsBase LAVA_BRICKS_STAIRS = new LightStairsBase(LAVA_BRICKS.getDefaultState(), "lava_bricks_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15);
	public static final LightSlabBase LAVA_BRICKS_SLAB = new LightSlabBase("lava_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15);
	public static final LightBlockBase CHISELED_LAVA_BRICKS = new LightBlockBase("chiseled_lava_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15);

}
