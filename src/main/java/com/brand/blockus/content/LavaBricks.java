package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;
import com.brand.blockus.blocks.Light.LightBlockBase;

import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class LavaBricks {
	
	public static final LightBlockBase LAVA_BRICKS = new LightBlockBase("lava_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.STONE);
	public static final WallBase LAVA_BRICKS_WALL = new WallBase("lava_bricks_wall", LAVA_BRICKS);
	public static final StairsBase LAVA_BRICKS_STAIRS = new StairsBase(LAVA_BRICKS.getDefaultState(), "lava_bricks_stairs", LAVA_BRICKS);
	public static final SlabBase LAVA_BRICKS_SLAB = new SlabBase("lava_bricks_slab", LAVA_BRICKS);
	public static final LightBlockBase CHISELED_LAVA_BRICKS = new LightBlockBase("chiseled_lava_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.STONE);
	
	// blackstone
	public static final LightBlockBase LAVA_POLISHED_BLACKSTONE_BRICKS = new LightBlockBase("lava_polished_blackstone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.BLACK);
	public static final WallBase LAVA_POLISHED_BLACKSTONE_WALL = new WallBase("lava_polished_blackstone_wall", LAVA_POLISHED_BLACKSTONE_BRICKS);
	public static final StairsBase LAVA_POLISHED_BLACKSTONE_STAIRS = new StairsBase(LAVA_POLISHED_BLACKSTONE_BRICKS.getDefaultState(), "lava_polished_blackstone_stairs", LAVA_POLISHED_BLACKSTONE_BRICKS);
	public static final SlabBase LAVA_POLISHED_BLACKSTONE_SLAB = new SlabBase("lava_polished_blackstone_slab", LAVA_POLISHED_BLACKSTONE_BRICKS);
	public static final LightBlockBase CHISELED_LAVA_POLISHED_BLACKSTONE = new LightBlockBase("chiseled_lava_polished_blackstone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.BLACK);

}
