package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseBT;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseHand;
import com.brand.blockus.blocks.Base.OrientableBlockBase;
import com.brand.blockus.blocks.FoodBlocks.EatableBase;
import com.brand.blockus.blocks.FoodBlocks.RareCrate;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class FoodBlocks {

	public static final BlockBaseBT SWEET_BERRIES_CRATE = new BlockBaseBT("sweet_berries_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final BlockBaseBT SALMON_CRATE = new BlockBaseBT("salmon_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final BlockBaseBT PUFFERFISH_CRATE = new BlockBaseBT("pufferfish_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final BlockBaseBT TROPICAL_FISH_CRATE = new BlockBaseBT("tropical_fish_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final BlockBaseBT COD_CRATE = new BlockBaseBT("cod_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final EatableBase COOKIE_BLOCK = new EatableBase("cookie_block", 0.5f, 0.5f, MaterialColor.ORANGE);
	public static final BlockBaseHand CHORUS_BLOCK = new BlockBaseHand("chorus_block", 0.5f, 0.5f, Material.LEAVES, BlockSoundGroup.GRASS, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.PURPLE);
	public static final BlockBaseBT POTATO_CRATE = new BlockBaseBT("potato_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final BlockBaseBT APPLE_CRATE = new BlockBaseBT("apple_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final BlockBaseBT BEETROOT_CRATE = new BlockBaseBT("beetroot_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final BlockBaseBT CARROT_CRATE = new BlockBaseBT("carrot_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final OrientableBlockBase BREAD_BOX = new OrientableBlockBase("bread_box", 2.5f, 2.5f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final RareCrate GOLDEN_APPLE_CRATE = new RareCrate("golden_apple_crate", 2.5f, 2.5f);
	public static final BlockBaseBT GOLDEN_CARROT_CRATE = new BlockBaseBT("golden_carrot_crate", 2.5f, 2.5f, Material.SOLID_ORGANIC, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, Blocks.OAK_PLANKS.getDefaultMaterialColor());
	public static final BlockBaseHand ROTTEN_FLESH_BLOCK = new BlockBaseHand("rotten_flesh_block", 1.5f, 1.5f, Material.SOLID_ORGANIC, BlockSoundGroup.SLIME, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.RED_TERRACOTTA);
	
	}