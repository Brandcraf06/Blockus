package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.CirclePavementBlock;
import com.brand.blockus.blocks.SlabBase;
import com.brand.blockus.blocks.StairsBase;


public class ADGRelated {
	
	
	public static BlockBase ANDESITE_BRICKS;
	public static BlockBase DIORITE_BRICKS;
	public static BlockBase GRANITE_BRICKS;
	public static StairsBase ANDESITE_BRICKS_STAIRS;
	public static SlabBase ANDESITE_BRICKS_SLAB;
	public static StairsBase DIORITE_BRICKS_STAIRS;
	public static SlabBase DIORITE_BRICKS_SLAB;
	public static StairsBase GRANITE_BRICKS_STAIRS;
	public static SlabBase GRANITE_BRICKS_SLAB;
	public static BlockBase ZIGZAGGED_ANDESITE;
	public static BlockBase ZIGZAGGED_DIORITE;
	public static BlockBase ZIGZAGGED_GRANITE;
	public static CirclePavementBlock ANDESITE_CIRCLE_PAVEMENT;
	public static CirclePavementBlock DIORITE_CIRCLE_PAVEMENT;
	public static CirclePavementBlock GRANITE_CIRCLE_PAVEMENT;

	public static void init() {

		ANDESITE_BRICKS = new BlockBase("andesite_bricks", 1.5f, 6.0f);
		ANDESITE_BRICKS_STAIRS = new StairsBase(ADGRelated.ANDESITE_BRICKS.getDefaultState(), "andesite_bricks_stairs", 1.5f, 6.0f);
		ANDESITE_BRICKS_SLAB = new SlabBase("andesite_bricks_slab", 2.0f, 6.0f);
		DIORITE_BRICKS = new BlockBase("diorite_bricks", 1.5f, 6.0f);
		DIORITE_BRICKS_STAIRS = new StairsBase(ADGRelated.DIORITE_BRICKS.getDefaultState(), "diorite_bricks_stairs", 1.5f, 6.0f);
		DIORITE_BRICKS_SLAB = new SlabBase("diorite_bricks_slab", 2.0f, 6.0f);
		GRANITE_BRICKS = new BlockBase("granite_bricks", 1.5f, 6.0f);
		GRANITE_BRICKS_STAIRS = new StairsBase(ADGRelated.GRANITE_BRICKS.getDefaultState(), "granite_bricks_stairs", 1.5f, 6.0f);
		GRANITE_BRICKS_SLAB = new SlabBase("granite_bricks_slab", 2.0f, 6.0f);
		ZIGZAGGED_ANDESITE = new BlockBase("zigzagged_andesite", 1.5f, 6.0f);
		ZIGZAGGED_DIORITE = new BlockBase("zigzagged_diorite", 1.5f, 6.0f);
		ZIGZAGGED_GRANITE = new BlockBase("zigzagged_granite", 1.5f, 6.0f);
		ANDESITE_CIRCLE_PAVEMENT = new CirclePavementBlock("andesite_circle_pavement", 1.5f, 6.0f);
		DIORITE_CIRCLE_PAVEMENT = new CirclePavementBlock("diorite_circle_pavement", 1.5f, 6.0f);
		GRANITE_CIRCLE_PAVEMENT = new CirclePavementBlock("granite_circle_pavement", 1.5f, 6.0f);
			
	}
}
