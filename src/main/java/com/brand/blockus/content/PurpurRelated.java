package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;

import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class PurpurRelated {
	
	public static final BlockBase PURPUR_BRICKS = new BlockBase("purpur_bricks", 1.5f, 1.2f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.MAGENTA);
	public static final BlockBase SMOOTH_PURPUR = new BlockBase("smooth_purpur", 1.5f, 1.2f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.MAGENTA);
	public static final StairsBase SMOOTH_PURPUR_STAIRS = new StairsBase(SMOOTH_PURPUR.getDefaultState(), "smooth_purpur_stairs", SMOOTH_PURPUR);
	public static final SlabBase SMOOTH_PURPUR_SLAB = new SlabBase("smooth_purpur_slab", SMOOTH_PURPUR);
	public static final BlockBase PURPUR_SQUARES = new BlockBase("purpur_squares", 1.5f, 1.2f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.MAGENTA);
	public static final BlockBase PURPUR_LITTLE_BRICKS = new BlockBase("purpur_little_bricks", 1.5f, 1.2f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.MAGENTA);
	public static final BlockBase CHISELED_PURPUR = new BlockBase("chiseled_purpur", 1.5f, 1.2f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.MAGENTA);
	public static final PillarBase PURPUR_LINES = new PillarBase("purpur_lines", 1.5f, 1.2f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.MAGENTA);

}
