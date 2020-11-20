package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.*;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class NetherBricksRelated {

    public static final BlockBase SMOOTH_NETHER_BRICKS = new BlockBase("smooth_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.NETHER);
    public static final BlockBase SMOOTH_RED_NETHER_BRICKS = new BlockBase("smooth_red_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.NETHER);
    public static final BlockBase ZIGZAGGED_NETHER_BRICKS = new BlockBase("zigzagged_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.NETHER);
    public static final BlockBase ZIGZAGGED_RED_NETHER_BRICKS = new BlockBase("zigzagged_red_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.NETHER);
    public static final PillarBase NETHER_PILLAR = new PillarBase("nether_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, MapColor.NETHER);
    public static final PillarBase RED_NETHER_PILLAR = new PillarBase("red_nether_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, MapColor.NETHER);
    //charred
    public static final BlockBase CHARRED_NETHER_BRICKS = new BlockBase("charred_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.BLACK);
    public static final StairsBase CHARRED_NETHER_BRICKS_STAIRS = new StairsBase(NetherBricksRelated.CHARRED_NETHER_BRICKS.getDefaultState(), "charred_nether_bricks_stairs", CHARRED_NETHER_BRICKS);
    public static final SlabBase CHARRED_NETHER_BRICKS_SLAB = new SlabBase("charred_nether_bricks_slab", CHARRED_NETHER_BRICKS);
    public static final WallBase CHARRED_NETHER_BRICKS_WALL = new WallBase("charred_nether_bricks_wall", CHARRED_NETHER_BRICKS);
    public static final BlockBase SMOOTH_CHARRED_NETHER_BRICKS = new BlockBase("smooth_charred_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.BLACK);
    public static final PillarBase CHARRED_NETHER_PILLAR = new PillarBase("charred_nether_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, MapColor.BLACK);
    public static final BlockBase ZIGZAGGED_CHARRED_NETHER_BRICKS = new BlockBase("zigzagged_charred_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.BLACK);
    //teal
    public static final BlockBase TEAL_NETHER_BRICKS = new BlockBase("teal_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);
    public static final StairsBase TEAL_NETHER_BRICK_STAIRS = new StairsBase(NetherBricksRelated.TEAL_NETHER_BRICKS.getDefaultState(), "teal_nether_brick_stairs", TEAL_NETHER_BRICKS);
    public static final SlabBase TEAL_NETHER_BRICK_SLAB = new SlabBase("teal_nether_brick_slab", TEAL_NETHER_BRICKS);
    public static final WallBase TEAL_NETHER_BRICK_WALL = new WallBase("teal_nether_brick_wall", TEAL_NETHER_BRICKS);
    public static final BlockBase SMOOTH_TEAL_NETHER_BRICKS = new BlockBase("smooth_teal_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);
    public static final PillarBase TEAL_NETHER_PILLAR = new PillarBase("teal_nether_pillar", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, MapColor.CYAN);
    public static final BlockBase ZIGZAGGED_TEAL_NETHER_BRICKS = new BlockBase("zigzagged_teal_nether_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);

}
