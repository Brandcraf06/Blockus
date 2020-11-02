package com.brand.blockus.content;


import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseBT;
import com.brand.blockus.blocks.Base.*;
import com.brand.blockus.blocks.Leaves.LeavesBlockBase;
import com.brand.blockus.blocks.Sapling.PottedBlockBase;
import com.brand.blockus.blocks.Sapling.SaplingBlockBase;
import com.brand.blockus.blocks.Sapling.WhiteOakSaplingGenerator;
import com.brand.blockus.blocks.Switches.PressurePlateBase;
import com.brand.blockus.blocks.Switches.WoodenButtonBase;
import com.brand.blockus.blocks.Wood.LogBlockBase;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.sound.BlockSoundGroup;

public class NewWoods{
	
// bamboo
	public static final BlockBaseBT BAMBOO_PLANKS = new BlockBaseBT("bamboo_planks", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, MaterialColor.SAND);
	public static final SlabBase BAMBOO_SLAB = new SlabBase("bamboo_slab", BAMBOO_PLANKS);
	public static final StairsBase BAMBOO_STAIRS = new StairsBase(BAMBOO_PLANKS.getDefaultState(), "bamboo_stairs", BAMBOO_PLANKS);
	public static final FenceBase BAMBOO_FENCE = new FenceBase("bamboo_fence", 2.0f, 3.0f, BAMBOO_PLANKS.getDefaultMaterialColor());
	public static final FenceGateBase BAMBOO_FENCE_GATE = new FenceGateBase("bamboo_fence_gate", 2.0f, 3.0f, BAMBOO_PLANKS.getDefaultMaterialColor());
	public static final PressurePlateBase BAMBOO_PRESSURE_PLATE = new PressurePlateBase("bamboo_pressure_plate", BlockSoundGroup.WOOD, ActivationRule.EVERYTHING, BAMBOO_PLANKS.getDefaultMaterialColor());
	public static final WoodenButtonBase BAMBOO_BUTTON = new WoodenButtonBase("bamboo_button");
	public static final DoorBase BAMBOO_DOOR = new DoorBase("bamboo_door", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, BAMBOO_PLANKS.getDefaultMaterialColor());
	public static final TrapdoorBase BAMBOO_TRAPDOOR = new TrapdoorBase("bamboo_trapdoor", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, BAMBOO_PLANKS.getDefaultMaterialColor());
	
// charred	
	public static final BlockBaseBT CHARRED_PLANKS = new BlockBaseBT("charred_planks", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, MaterialColor.GRAY_TERRACOTTA);
	public static final SlabBase CHARRED_SLAB = new SlabBase("charred_slab", CHARRED_PLANKS);
	public static final StairsBase CHARRED_STAIRS = new StairsBase(CHARRED_PLANKS.getDefaultState(), "charred_stairs", CHARRED_PLANKS);
	public static final FenceBase CHARRED_FENCE = new FenceBase("charred_fence", 2.0f, 3.0f, CHARRED_PLANKS.getDefaultMaterialColor());
	public static final FenceGateBase CHARRED_FENCE_GATE = new FenceGateBase("charred_fence_gate", 2.0f, 3.0f, CHARRED_PLANKS.getDefaultMaterialColor());
	public static final PressurePlateBase CHARRED_PRESSURE_PLATE = new PressurePlateBase("charred_pressure_plate", BlockSoundGroup.WOOD, ActivationRule.EVERYTHING, CHARRED_PLANKS.getDefaultMaterialColor());
	public static final WoodenButtonBase CHARRED_BUTTON = new WoodenButtonBase("charred_button");
	public static final DoorBase CHARRED_DOOR = new DoorBase("charred_door", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, CHARRED_PLANKS.getDefaultMaterialColor());
	public static final TrapdoorBase CHARRED_TRAPDOOR = new TrapdoorBase("charred_trapdoor", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, CHARRED_PLANKS.getDefaultMaterialColor());
	
// white oak
	public static final SaplingBlockBase WHITE_OAK_SAPLING = new SaplingBlockBase(new WhiteOakSaplingGenerator(), "white_oak_sapling");
	public static final PottedBlockBase POTTED_WHITE_OAK_SAPLING = new PottedBlockBase(WHITE_OAK_SAPLING, "potted_white_oak_sapling");
	public static final LogBlockBase WHITE_OAK_LOG = new LogBlockBase("white_oak_log", 2.0f, 2.0f, Material.WOOD, MaterialColor.LIGHT_GRAY_TERRACOTTA);
	public static final LogBlockBase STRIPPED_WHITE_OAK_LOG = new LogBlockBase("stripped_white_oak_log", 2.0f, 2.0f, Material.WOOD, MaterialColor.LIGHT_GRAY_TERRACOTTA);
	public static final LogBlockBase WHITE_OAK_WOOD = new LogBlockBase("white_oak_wood", 2.0f, 2.0f, Material.WOOD, MaterialColor.LIGHT_GRAY_TERRACOTTA);
	public static final LogBlockBase STRIPPED_WHITE_OAK_WOOD = new LogBlockBase("stripped_white_oak_wood", 2.0f, 2.0f, Material.WOOD, MaterialColor.LIGHT_GRAY_TERRACOTTA);
	public static final LeavesBlockBase WHITE_OAK_LEAVES = new LeavesBlockBase("white_oak_leaves", 0.2f, 0.2f);
	public static final BlockBaseBT WHITE_OAK_PLANKS = new BlockBaseBT("white_oak_planks", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, MaterialColor.WHITE_TERRACOTTA);
	public static final SlabBase WHITE_OAK_SLAB = new SlabBase("white_oak_slab", WHITE_OAK_PLANKS);
	public static final StairsBase WHITE_OAK_STAIRS = new StairsBase(WHITE_OAK_PLANKS.getDefaultState(), "white_oak_stairs", WHITE_OAK_PLANKS);
	public static final FenceBase WHITE_OAK_FENCE = new FenceBase("white_oak_fence", 2.0f, 3.0f, WHITE_OAK_PLANKS.getDefaultMaterialColor());
	public static final FenceGateBase WHITE_OAK_FENCE_GATE = new FenceGateBase("white_oak_fence_gate", 2.0f, 3.0f, WHITE_OAK_PLANKS.getDefaultMaterialColor());
	public static final PressurePlateBase WHITE_OAK_PRESSURE_PLATE = new PressurePlateBase("white_oak_pressure_plate", BlockSoundGroup.WOOD, ActivationRule.EVERYTHING, WHITE_OAK_PLANKS.getDefaultMaterialColor());
	public static final WoodenButtonBase WHITE_OAK_BUTTON = new WoodenButtonBase("white_oak_button");
	public static final DoorBase WHITE_OAK_DOOR = new DoorBase("white_oak_door", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, WHITE_OAK_PLANKS.getDefaultMaterialColor());
	public static final TrapdoorBase WHITE_OAK_TRAPDOOR = new TrapdoorBase("white_oak_trapdoor", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, WHITE_OAK_PLANKS.getDefaultMaterialColor());
	
}
