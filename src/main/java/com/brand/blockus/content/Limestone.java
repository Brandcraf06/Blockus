package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.CirclePavementBlock;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class Limestone {
	
	public static final BlockBase LIMESTONE = new BlockBase("limestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase LIMESTONE_STAIRS = new StairsBase(LIMESTONE.getDefaultState(), "limestone_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase LIMESTONE_SLAB = new SlabBase("limestone_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase LIMESTONE_BRICKS = new BlockBase("limestone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase LIMESTONE_BRICKS_STAIRS = new StairsBase(LIMESTONE_BRICKS.getDefaultState(), "limestone_bricks_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase LIMESTONE_BRICKS_SLAB = new SlabBase("limestone_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final WallBase LIMESTONE_BRICKS_WALL = new WallBase("limestone_bricks_wall", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final PillarBase LIMESTONE_PILLAR = new PillarBase("limestone_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase CHISELED_LIMESTONE = new BlockBase("chiseled_limestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final CirclePavementBlock LIMESTONE_CIRCLE_PAVEMENT = new CirclePavementBlock("limestone_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);

}
