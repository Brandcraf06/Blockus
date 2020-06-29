package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BaseSpongeBlock;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.FallingGravelBase;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseBT;
import com.brand.blockus.blocks.Leaves.LegacyLeavesBlock;
import com.brand.blockus.blocks.Light.LightBlockBase;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class LegacyBlocks {
	
	public static final BlockBase LEGACY_BRICKS = new BlockBase("legacy_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.RED);
	public static final BlockBase LEGACY_STONECUTTER = new BlockBase("legacy_stonecutter", 1.5f, 17.5f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
	public static final BlockBase LEGACY_GRASS_BLOCK = new BlockBase("legacy_grass_block", 0.6f, 3.0f, Material.LEAVES, BlockSoundGroup.GRASS, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.GRASS);
	public static final LegacyLeavesBlock LEGACY_LEAVES = new LegacyLeavesBlock("legacy_leaves", 0.6f, 3.0f);
	public static final FallingGravelBase LEGACY_GRAVEL = new FallingGravelBase("legacy_gravel", 2.0f, 6.0f);
	public static final BlockBase LEGACY_COBBLESTONE = new BlockBase("legacy_cobblestone", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
	public static final BlockBase LEGACY_MOSSY_COBBLESTONE = new BlockBase("legacy_mossy_cobblestone", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
	public static final BlockBase LEGACY_IRON_BLOCK = new BlockBase("legacy_iron_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.IRON);
	public static final BlockBase LEGACY_GOLD_BLOCK = new BlockBase("legacy_gold_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.GOLD);
	public static final BlockBase EXPLOSION_PROOF_LEGACY_GOLD_BLOCK = new BlockBase("legacy_explosion_proof_gold_block", 5.0f, 6000.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.GOLD);
	public static final BlockBase LEGACY_DIAMOND_BLOCK = new BlockBase("legacy_diamond_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.DIAMOND);
	public static final BlockBase LEGACY_LAPIS_BLOCK = new BlockBase("legacy_lapis_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.LAPIS);
	public static final BaseSpongeBlock LEGACY_SPONGE = new BaseSpongeBlock("legacy_sponge", 0.6f, 3.0f);
	public static final BlockBase CRYING_OBSIDIAN = new BlockBase("legacy_crying_obsidian", 1.5f, 6000.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BLACK);
	public static final LightBlockBase GLOWING_OBSIDIAN = new LightBlockBase("legacy_glowing_obsidian", 1.5f, 6000.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.BLACK);
	public static final BlockBase NETHER_REACTOR_CORE = new BlockBase("legacy_nether_reactor_core", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.LIGHT_BLUE);
	public static final BlockBaseBT LEGACY_PLANKS = new BlockBaseBT("legacy_planks", 2.0f, 15.0f, Material.WOOD, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, MaterialColor.WOOD);

}
