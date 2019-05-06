package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockWood;
import com.brand.blockus.blocks.ButtonWood;
import com.brand.blockus.blocks.FenceBase;
import com.brand.blockus.blocks.FenceGateBase;
import com.brand.blockus.blocks.PressurePlateWood;
import com.brand.blockus.blocks.SlabWood;
import com.brand.blockus.blocks.StairsWood;
import com.brand.blockus.blocks.WoodenDoor;
import com.brand.blockus.blocks.WoodenTrapdoor;

public class BambooPlanks {
	
	public static BlockWood BAMBOO_PLANKS;
	public static SlabWood BAMBOO_SLAB;
	public static StairsWood BAMBOO_STAIRS;
	public static FenceBase BAMBOO_FENCE;
	public static FenceGateBase BAMBOO_FENCE_GATE;
	public static PressurePlateWood BAMBOO_PRESSURE_PLATE;
	public static ButtonWood BAMBOO_BUTTON;
	public static WoodenDoor BAMBOO_DOOR;
	public static WoodenTrapdoor BAMBOO_TRAPDOOR;
	
	public static void init() {

		BAMBOO_PLANKS = new BlockWood("bamboo_planks", 2.0f, 3.0f);
		BAMBOO_SLAB = new SlabWood("bamboo_slab", 2.0f, 3.0f);
		BAMBOO_STAIRS = new StairsWood(BAMBOO_PLANKS.getDefaultState(), "bamboo_stairs", 2.0f, 3.0f);
		BAMBOO_FENCE = new FenceBase("bamboo_fence", 2.0f, 3.0f);
		BAMBOO_FENCE_GATE = new FenceGateBase("bamboo_fence_gate", 2.0f, 3.0f);
		BAMBOO_PRESSURE_PLATE = new PressurePlateWood("bamboo_pressure_plate", 2.0f, 3.0f);
		BAMBOO_BUTTON = new ButtonWood("bamboo_button", 2.0f, 3.0f);
		BAMBOO_DOOR = new WoodenDoor("bamboo_door", 2.0f, 3.0f);
		BAMBOO_TRAPDOOR = new WoodenTrapdoor("bamboo_trapdoor", 2.0f, 3.0f);
			
	}

}
