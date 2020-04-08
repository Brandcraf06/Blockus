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
	public static NetherPillarBase TEAL_NETHER_PILLAR;
	public static NetherBlockBase SMOOTH_TEAL_NETHER_BRICKS;
	public static NetherWallBase TEAL_NETHER_BRICK_WALL;
	public static NetherStairsBase TEAL_NETHER_BRICK_STAIRS;
	public static NetherSlabBase TEAL_NETHER_BRICK_SLAB;
	public static NetherBlockBase TEAL_NETHER_BRICKS;
	public static NetherBlockBase ZIGZAGGED_NETHER_BRICKS;
	public static NetherBlockBase ZIGZAGGED_RED_NETHER_BRICKS;
	public static NetherBlockBase ZIGZAGGED_CHARRED_NETHER_BRICKS;
	public static NetherBlockBase ZIGZAGGED_TEAL_NETHER_BRICKS;
	
	public static void init() {
		
		SMOOTH_NETHER_BRICKS = new NetherBlockBase("smooth_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		SMOOTH_RED_NETHER_BRICKS = new NetherBlockBase("smooth_red_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		ZIGZAGGED_NETHER_BRICKS = new NetherBlockBase("zigzagged_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		ZIGZAGGED_RED_NETHER_BRICKS = new NetherBlockBase("zigzagged_red_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		NETHER_PILLAR = new NetherPillarBase("nether_pillar", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		RED_NETHER_PILLAR = new NetherPillarBase("red_nether_pillar", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
// charred
		CHARRED_NETHER_BRICKS = new NetherBlockBase("charred_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		CHARRED_NETHER_BRICKS_STAIRS = new NetherStairsBase(NetherBricksRelated.CHARRED_NETHER_BRICKS.getDefaultState(), "charred_nether_bricks_stairs", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		CHARRED_NETHER_BRICKS_SLAB = new NetherSlabBase("charred_nether_bricks_slab", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		CHARRED_NETHER_BRICKS_WALL = new NetherWallBase("charred_nether_bricks_wall", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		SMOOTH_CHARRED_NETHER_BRICKS = new NetherBlockBase("smooth_charred_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		CHARRED_NETHER_PILLAR = new NetherPillarBase("charred_nether_pillar", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		ZIGZAGGED_CHARRED_NETHER_BRICKS = new NetherBlockBase("zigzagged_charred_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
// teal
		TEAL_NETHER_BRICKS = new NetherBlockBase("teal_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		TEAL_NETHER_BRICK_STAIRS = new NetherStairsBase(NetherBricksRelated.TEAL_NETHER_BRICKS.getDefaultState(), "teal_nether_brick_stairs", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		TEAL_NETHER_BRICK_SLAB = new NetherSlabBase("teal_nether_brick_slab", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		TEAL_NETHER_BRICK_WALL = new NetherWallBase("teal_nether_brick_wall", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		SMOOTH_TEAL_NETHER_BRICKS = new NetherBlockBase("smooth_teal_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		TEAL_NETHER_PILLAR = new NetherPillarBase("teal_nether_pillar", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);
		ZIGZAGGED_TEAL_NETHER_BRICKS = new NetherBlockBase("zigzagged_teal_nether_bricks", 2.0f, 6.0f, BlockSoundGroup.NETHER_BRICK);

	}

}
