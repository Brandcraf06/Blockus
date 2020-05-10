package com.brand.blockus.content;


import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.DoorBase;
import com.brand.blockus.blocks.Base.FenceBase;
import com.brand.blockus.blocks.Base.FenceGateBase;
import com.brand.blockus.blocks.Base.PressurePlateBase;
import com.brand.blockus.blocks.Base.TrapdoorBase;
import com.brand.blockus.blocks.Base.SpecificTool.BlockBase2;
import com.brand.blockus.blocks.Base.SpecificTool.SlabBase2;
import com.brand.blockus.blocks.Base.SpecificTool.StairsBase2;
import com.brand.blockus.blocks.Wood.WoodButtonBase;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.sound.BlockSoundGroup;

public class CharredPlanks {
	
	public static final BlockBase2 CHARRED_PLANKS = new BlockBase2("charred_planks", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final SlabBase2 CHARRED_SLAB = new SlabBase2("charred_slab", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0);
	public static final StairsBase2 CHARRED_STAIRS = new StairsBase2(CHARRED_PLANKS.getDefaultState(), "charred_stairs", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0);
	public static final FenceBase CHARRED_FENCE = new FenceBase("charred_fence", 2.0f, 3.0f);
	public static final FenceGateBase CHARRED_FENCE_GATE = new FenceGateBase("charred_fence_gate", 2.0f, 3.0f);
	public static final PressurePlateBase CHARRED_PRESSURE_PLATE = new PressurePlateBase("charred_pressure_plate", 2.0f, 3.0f, ActivationRule.EVERYTHING);
	public static final WoodButtonBase CHARRED_BUTTON = new WoodButtonBase("charred_button", 2.0f, 3.0f);
	public static final DoorBase CHARRED_DOOR = new DoorBase("charred_door", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0);
	public static final TrapdoorBase CHARRED_TRAPDOOR = new TrapdoorBase("charred_trapdoor", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0);

}
