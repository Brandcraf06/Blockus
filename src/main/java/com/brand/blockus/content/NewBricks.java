package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class NewBricks {

//soaked
	public static final BlockBase SOAKED_BRICKS = new BlockBase("soaked_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.CYAN);
	public static final StairsBase SOAKED_BRICKS_STAIRS = new StairsBase(SOAKED_BRICKS.getDefaultState(), "soaked_bricks_stairs", SOAKED_BRICKS);
	public static final SlabBase SOAKED_BRICKS_SLAB = new SlabBase("soaked_bricks_slab", SOAKED_BRICKS);
	public static final WallBase SOAKED_BRICKS_WALL = new WallBase("soaked_bricks_wall", SOAKED_BRICKS);
	
//honeycomb	
	public static final BlockBase HONEYCOMB_BRICKS = new BlockBase("honeycomb_bricks", 0.6f, 1.0f, Material.ORGANIC_PRODUCT, BlockSoundGroup.CORAL, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.ORANGE);
	public static final StairsBase HONEYCOMB_BRICKS_STAIRS = new StairsBase(HONEYCOMB_BRICKS.getDefaultState(), "honeycomb_bricks_stairs", HONEYCOMB_BRICKS);
	public static final SlabBase HONEYCOMB_BRICKS_SLAB = new SlabBase("honeycomb_bricks_slab", HONEYCOMB_BRICKS);
	public static final WallBase HONEYCOMB_BRICKS_WALL = new WallBase("honeycomb_bricks_wall", HONEYCOMB_BRICKS);
	
	//soaked
	public static final BlockBase CHARRED_BRICKS = new BlockBase("charred_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BLACK);
	public static final WallBase CHARRED_BRICKS_WALL = new WallBase("charred_bricks_wall", CHARRED_BRICKS);
	public static final StairsBase CHARRED_BRICKS_STAIRS = new StairsBase(CHARRED_BRICKS.getDefaultState(), "charred_bricks_stairs", CHARRED_BRICKS);
	public static final SlabBase CHARRED_BRICKS_SLAB = new SlabBase("charred_bricks_slab", CHARRED_BRICKS);
	
//bricks	
	public static final BlockBase LARGE_BRICKS = new BlockBase("large_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.RED);
	public static final BlockBase ZIGZAGGED_BRICKS = new BlockBase("zigzagged_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.RED);

}
