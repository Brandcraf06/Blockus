package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BaseGrassBlock;
import com.brand.blockus.blocks.Base.BaseSpongeBlock;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.FallingGravelBase;
import com.brand.blockus.blocks.Leaves.LegacyLeavesBlock;
import com.brand.blockus.blocks.Light.LightBlockBase;
import com.brand.blockus.blocks.Wood.BlockWood;

public class LegacyBlocks {
	
	public static BlockBase LEGACY_BRICKS;
	public static BlockBase LEGACY_STONECUTTER;
	public static BaseGrassBlock LEGACY_GRASS_BLOCK;
	public static LegacyLeavesBlock LEGACY_LEAVES;
	public static FallingGravelBase LEGACY_GRAVEL;
	public static BlockBase LEGACY_COBBLESTONE;
	public static BlockBase LEGACY_MOSSY_COBBLESTONE;
	public static BlockBase LEGACY_IRON_BLOCK;
	public static BlockBase LEGACY_GOLD_BLOCK;
	public static BlockBase EXPLOSION_PROOF_LEGACY_GOLD_BLOCK;
	public static BlockBase LEGACY_DIAMOND_BLOCK;
	public static BlockBase LEGACY_LAPIS_BLOCK;
	public static BaseSpongeBlock LEGACY_SPONGE;
	public static BlockBase CRYING_OBSIDIAN;
	public static LightBlockBase GLOWING_OBSIDIAN;
	public static BlockBase NETHER_REACTOR_CORE;
	public static BlockWood LEGACY_PLANKS;

	public static void init() {
	
	LEGACY_BRICKS = new BlockBase("legacy_bricks", 2.0f, 6.0f);
	LEGACY_STONECUTTER = new BlockBase("legacy_stonecutter", 1.5f, 17.5f);
	LEGACY_GRASS_BLOCK = new BaseGrassBlock("legacy_grass_block", 0.6f, 3.0f);
	LEGACY_LEAVES = new LegacyLeavesBlock("legacy_leaves", 0.6f, 3.0f);
	LEGACY_GRAVEL = new FallingGravelBase("legacy_gravel", 2.0f, 6.0f);
	LEGACY_COBBLESTONE = new BlockBase("legacy_cobblestone", 2.0f, 6.0f);
	LEGACY_MOSSY_COBBLESTONE = new BlockBase("legacy_mossy_cobblestone", 2.0f, 6.0f);
	LEGACY_IRON_BLOCK = new BlockBase("legacy_iron_block", 5.0f, 6.0f);
	LEGACY_GOLD_BLOCK = new BlockBase("legacy_gold_block", 5.0f, 6.0f);
	EXPLOSION_PROOF_LEGACY_GOLD_BLOCK = new BlockBase("legacy_explosion_proof_gold_block", 5.0f, 6000.0f);
	LEGACY_DIAMOND_BLOCK = new BlockBase("legacy_diamond_block", 5.0f, 6.0f);
	LEGACY_LAPIS_BLOCK = new BlockBase("legacy_lapis_block", 5.0f, 6.0f);
	LEGACY_SPONGE = new BaseSpongeBlock("legacy_sponge", 0.6f, 3.0f);
	CRYING_OBSIDIAN = new BlockBase("legacy_crying_obsidian", 1.5f, 6000.0f);
	GLOWING_OBSIDIAN = new LightBlockBase("legacy_glowing_obsidian", 1.5f, 6000.0f);
	NETHER_REACTOR_CORE = new BlockBase("legacy_nether_reactor_core", 1.5f, 6.0f);
	LEGACY_PLANKS = new BlockWood("legacy_planks", 2.0f, 15.0f);

	}
}
