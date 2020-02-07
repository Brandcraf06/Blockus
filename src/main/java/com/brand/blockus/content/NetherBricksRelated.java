package com.brand.blockus.content;

import com.brand.blockus.blocks.Nether.NetherBlockBase;
import com.brand.blockus.blocks.Nether.NetherPillarBase;
import com.brand.blockus.blocks.Nether.NetherSlabBase;
import com.brand.blockus.blocks.Nether.NetherStairsBase;
import com.brand.blockus.blocks.Nether.NetherWallBase;

import net.minecraft.sound.BlockSoundGroup;

public class NetherBricksRelated {
	
	public static NetherBlockBase SMOOTH_NETHER_BRICKS;
	public static NetherBlockBase SMOOTH_RED_NETHER_BRICKS;
	public static NetherPillarBase NETHER_PILLAR;
	public static NetherPillarBase RED_NETHER_PILLAR;
	public static NetherPillarBase CHARRED_NETHER_PILLAR;
	public static NetherBlockBase SMOOTH_CHARRED_NETHER_BRICKS;
	public static NetherWallBase CHARRED_NETHER_BRICKS_WALL;
	public static NetherStairsBase CHARRED_NETHER_BRICKS_STAIRS;
	public static NetherSlabBase CHARRED_NETHER_BRICKS_SLAB;
	public static NetherBlockBase CHARRED_NETHER_BRICKS;
	
	public static void init() {
		
		SMOOTH_NETHER_BRICKS = new NetherBlockBase("smooth_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		SMOOTH_RED_NETHER_BRICKS = new NetherBlockBase("smooth_red_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		NETHER_PILLAR = new NetherPillarBase("nether_pillar", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		RED_NETHER_PILLAR = new NetherPillarBase("red_nether_pillar", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		CHARRED_NETHER_BRICKS = new NetherBlockBase("charred_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		CHARRED_NETHER_BRICKS_STAIRS = new NetherStairsBase(NetherBricksRelated.CHARRED_NETHER_BRICKS.getDefaultState(), "charred_nether_bricks_stairs", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		CHARRED_NETHER_BRICKS_SLAB = new NetherSlabBase("charred_nether_bricks_slab", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		CHARRED_NETHER_BRICKS_WALL = new NetherWallBase("charred_nether_bricks_wall", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		SMOOTH_CHARRED_NETHER_BRICKS = new NetherBlockBase("smooth_charred_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		CHARRED_NETHER_PILLAR = new NetherPillarBase("charred_nether_pillar", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
				
	}

}
