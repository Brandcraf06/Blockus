package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;
import com.brand.blockus.blocks.Light.LightBlockBase;
import com.brand.blockus.blocks.Light.LightPillarBase;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlazeBricks {
	
	public static final LightBlockBase BLAZE_BRICKS = new LightBlockBase("blaze_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.NETHER);
	public static final WallBase BLAZE_BRICKS_WALL = new WallBase("blaze_bricks_wall", BLAZE_BRICKS);
	public static final StairsBase BLAZE_BRICKS_STAIRS = new StairsBase(BLAZE_BRICKS.getDefaultState(), "blaze_bricks_stairs", BLAZE_BRICKS);
	public static final SlabBase BLAZE_BRICKS_SLAB = new SlabBase("blaze_bricks_slab", BLAZE_BRICKS);
	public static final LightPillarBase BLAZE_PILLAR = new LightPillarBase("blaze_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15, MaterialColor.NETHER);
	
}
