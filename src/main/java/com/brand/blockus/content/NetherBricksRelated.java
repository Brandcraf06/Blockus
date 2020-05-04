package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class NetherBricksRelated {
	
	public static final BlockBase SMOOTH_NETHER_BRICKS = new BlockBase("smooth_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final BlockBase SMOOTH_RED_NETHER_BRICKS = new BlockBase("smooth_red_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final BlockBase ZIGZAGGED_NETHER_BRICKS = new BlockBase("zigzagged_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final BlockBase ZIGZAGGED_RED_NETHER_BRICKS = new BlockBase("zigzagged_red_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final PillarBase NETHER_PILLAR = new PillarBase("nether_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
	public static final PillarBase RED_NETHER_PILLAR = new PillarBase("red_nether_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
//charred
	public static final BlockBase CHARRED_NETHER_BRICKS = new BlockBase("charred_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase CHARRED_NETHER_BRICKS_STAIRS = new StairsBase(NetherBricksRelated.CHARRED_NETHER_BRICKS.getDefaultState(), "charred_nether_bricks_stairs", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
	public static final SlabBase CHARRED_NETHER_BRICKS_SLAB = new SlabBase("charred_nether_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
	public static final WallBase CHARRED_NETHER_BRICKS_WALL = new WallBase("charred_nether_bricks_wall", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
	public static final BlockBase SMOOTH_CHARRED_NETHER_BRICKS = new BlockBase("smooth_charred_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final PillarBase CHARRED_NETHER_PILLAR = new PillarBase("charred_nether_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
	public static final BlockBase ZIGZAGGED_CHARRED_NETHER_BRICKS = new BlockBase("zigzagged_charred_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);
//teal
	public static final BlockBase TEAL_NETHER_BRICKS = new BlockBase("teal_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase TEAL_NETHER_BRICK_STAIRS = new StairsBase(NetherBricksRelated.TEAL_NETHER_BRICKS.getDefaultState(), "teal_nether_brick_stairs", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
	public static final SlabBase TEAL_NETHER_BRICK_SLAB = new SlabBase("teal_nether_brick_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
	public static final WallBase TEAL_NETHER_BRICK_WALL = new WallBase("teal_nether_brick_wall", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
	public static final BlockBase SMOOTH_TEAL_NETHER_BRICKS = new BlockBase("smooth_teal_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final PillarBase TEAL_NETHER_PILLAR = new PillarBase("teal_nether_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK);
	public static final BlockBase ZIGZAGGED_TEAL_NETHER_BRICKS = new BlockBase("zigzagged_teal_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICK, Blockus.BLOCKUS_BUILDING_BLOCKS);

	}
