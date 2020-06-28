package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;

import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class Bluestone {
	
	public static final BlockBase BLUESTONE = new BlockBase("bluestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.CYAN);
	public static final StairsBase BLUESTONE_STAIRS = new StairsBase(BLUESTONE.getDefaultState(), "bluestone_stairs", BLUESTONE);
	public static final SlabBase BLUESTONE_SLAB = new SlabBase("bluestone_slab", BLUESTONE);
	public static final BlockBase BLUESTONE_TILES = new BlockBase("bluestone_tiles", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.CYAN);
	public static final StairsBase BLUESTONE_TILES_STAIRS = new StairsBase(BLUESTONE_TILES.getDefaultState(), "bluestone_tiles_stairs", BLUESTONE_TILES);
	public static final SlabBase BLUESTONE_TILES_SLAB = new SlabBase("bluestone_tiles_slab", BLUESTONE_TILES);
	public static final PillarBase BLUESTONE_PILLAR = new PillarBase("bluestone_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.CYAN);
	public static final BlockBase BLUESTONE_BRICKS = new BlockBase("bluestone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.CYAN);
	public static final BlockBase SMOOTH_BLUESTONE = new BlockBase("smooth_bluestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.CYAN);
	public static final BlockBase BLUESTONE_SQUARES = new BlockBase("bluestone_squares", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.CYAN);
	public static final BlockBase BLUESTONE_LITTLE_BRICKS = new BlockBase("bluestone_little_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.CYAN);
	public static final BlockBase CHISELED_BLUESTONE = new BlockBase("chiseled_bluestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.CYAN);
	public static final PillarBase BLUESTONE_LINES = new PillarBase("bluestone_lines", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.CYAN);
	
	
	}

