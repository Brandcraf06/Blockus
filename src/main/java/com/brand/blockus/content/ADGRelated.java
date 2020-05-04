package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.CirclePavementBlock;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ADGRelated {
	
	// andesite
	public static final BlockBase ANDESITE_BRICKS = new BlockBase("andesite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase ANDESITE_BRICKS_STAIRS = new StairsBase(ADGRelated.ANDESITE_BRICKS.getDefaultState(), "andesite_bricks_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase ANDESITE_BRICKS_SLAB = new SlabBase("andesite_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase ZIGZAGGED_ANDESITE = new BlockBase("zigzagged_andesite", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final CirclePavementBlock ANDESITE_CIRCLE_PAVEMENT = new CirclePavementBlock("andesite_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	
	// diorite
	public static final BlockBase DIORITE_BRICKS = new BlockBase("diorite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase DIORITE_BRICKS_STAIRS = new StairsBase(ADGRelated.DIORITE_BRICKS.getDefaultState(), "diorite_bricks_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase DIORITE_BRICKS_SLAB = new SlabBase("diorite_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase ZIGZAGGED_DIORITE = new BlockBase("zigzagged_diorite", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final CirclePavementBlock DIORITE_CIRCLE_PAVEMENT = new CirclePavementBlock("diorite_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	
	// granite
	public static final BlockBase GRANITE_BRICKS = new BlockBase("granite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase GRANITE_BRICKS_STAIRS = new StairsBase(ADGRelated.GRANITE_BRICKS.getDefaultState(), "granite_bricks_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase GRANITE_BRICKS_SLAB = new SlabBase("granite_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase ZIGZAGGED_GRANITE = new BlockBase("zigzagged_granite", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final CirclePavementBlock GRANITE_CIRCLE_PAVEMENT = new CirclePavementBlock("granite_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
  }