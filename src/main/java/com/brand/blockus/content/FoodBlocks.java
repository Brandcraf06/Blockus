package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SpecificTool.BlockBase2;
import com.brand.blockus.blocks.Base.SpecificTool.BlockBaseHand;
import com.brand.blockus.blocks.FoodBlocks.EatableBase;
import com.brand.blockus.blocks.FoodBlocks.OrientableCrate;
import com.brand.blockus.blocks.FoodBlocks.RareCrate;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class FoodBlocks {

	public static final BlockBase2 SWEET_BERRIES_CRATE = new BlockBase2("sweet_berries_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final BlockBase2 SALMON_CRATE = new BlockBase2("salmon_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final BlockBase2 PUFFERFISH_CRATE = new BlockBase2("pufferfish_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final BlockBase2 TROPICAL_FISH_CRATE = new BlockBase2("tropical_fish_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final BlockBase2 COD_CRATE = new BlockBase2("cod_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final EatableBase COOKIE_BLOCK = new EatableBase("cookie_block", 1.5f, 1.5f);
	public static final BlockBase CHORUS_BLOCK = new BlockBase("chorus_block", 1.5f, 1.5f, Material.LEAVES, BlockSoundGroup.GRASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final BlockBase2 POTATO_CRATE = new BlockBase2("potato_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final BlockBase2 APPLE_CRATE = new BlockBase2("apple_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final BlockBase2 BEETROOT_CRATE = new BlockBase2("beetroot_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final BlockBase2 CARROT_CRATE = new BlockBase2("carrot_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final OrientableCrate BREAD_BOX = new OrientableCrate("bread_box", 2.5f, 2.5f);
	public static final RareCrate GOLDEN_APPLE_CRATE = new RareCrate("golden_apple_crate", 2.5f, 2.5f);
	public static final BlockBase2 GOLDEN_CARROT_CRATE = new BlockBase2("golden_carrot_crate", 2.5f, 2.5f, Material.ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final BlockBaseHand ROTTEN_FLESH_BLOCK = new BlockBaseHand("rotten_flesh_block", 1.5f, 1.5f, Material.ORGANIC, BlockSoundGroup.SLIME, Blockus.BLOCKUS_BUILDING_BLOCKS);
	
	}