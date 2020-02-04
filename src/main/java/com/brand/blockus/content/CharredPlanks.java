package com.brand.blockus.content;


import com.brand.blockus.blocks.Wood.BlockWood;
import com.brand.blockus.blocks.Wood.ButtonWood;
import com.brand.blockus.blocks.Wood.FenceBase;
import com.brand.blockus.blocks.Wood.FenceGateBase;
import com.brand.blockus.blocks.Wood.PressurePlateWood;
import com.brand.blockus.blocks.Wood.SlabWood;
import com.brand.blockus.blocks.Wood.StairsWood;
import com.brand.blockus.blocks.Wood.WoodenDoor;
import com.brand.blockus.blocks.Wood.WoodenTrapdoor;

import net.minecraft.block.PressurePlateBlock.ActivationRule;

public class CharredPlanks {
	
	public static BlockWood CHARRED_PLANKS;
	public static SlabWood CHARRED_SLAB;
	public static StairsWood CHARRED_STAIRS;
	public static FenceBase CHARRED_FENCE;
	public static FenceGateBase CHARRED_FENCE_GATE;
	public static PressurePlateWood CHARRED_PRESSURE_PLATE;
	public static ButtonWood CHARRED_BUTTON;
	public static WoodenDoor CHARRED_DOOR;
	public static WoodenTrapdoor CHARRED_TRAPDOOR;
	
	public static void init() {

		CHARRED_PLANKS = new BlockWood("charred_planks", 2.0f, 3.0f);
		CHARRED_SLAB = new SlabWood("charred_slab", 2.0f, 3.0f);
		CHARRED_STAIRS = new StairsWood(CHARRED_PLANKS.getDefaultState(), "charred_stairs", 2.0f, 3.0f);
		CHARRED_FENCE = new FenceBase("charred_fence", 2.0f, 3.0f);
		CHARRED_FENCE_GATE = new FenceGateBase("charred_fence_gate", 2.0f, 3.0f);
		CHARRED_PRESSURE_PLATE = new PressurePlateWood("charred_pressure_plate", 2.0f, 3.0f, ActivationRule.EVERYTHING);
		CHARRED_BUTTON = new ButtonWood("charred_button", 2.0f, 3.0f);
		CHARRED_DOOR = new WoodenDoor("charred_door", 2.0f, 3.0f);
		CHARRED_TRAPDOOR = new WoodenTrapdoor("charred_trapdoor", 2.0f, 3.0f);
			
	}

}
