package com.brand.blockus.content;

import com.brand.blockus.blocks.Leaves.LeavesBlockBase;
import com.brand.blockus.blocks.Sapling.SaplingBlockBase;
import com.brand.blockus.blocks.Sapling.WhiteOakSaplingGenerator;
import com.brand.blockus.blocks.Wood.BlockWood;
import com.brand.blockus.blocks.Wood.ButtonWood;
import com.brand.blockus.blocks.Wood.FenceBase;
import com.brand.blockus.blocks.Wood.FenceGateBase;
import com.brand.blockus.blocks.Wood.LogBlockBase;
import com.brand.blockus.blocks.Wood.PressurePlateWood;
import com.brand.blockus.blocks.Wood.SlabWood;
import com.brand.blockus.blocks.Wood.StairsWood;
import com.brand.blockus.blocks.Wood.WoodenDoor;
import com.brand.blockus.blocks.Wood.WoodenTrapdoor;

import net.minecraft.block.MaterialColor;
import net.minecraft.block.PressurePlateBlock.ActivationRule;

public class WhiteOak {
	
	public static SaplingBlockBase WHITE_OAK_SAPLING;
	public static LogBlockBase WHITE_OAK_LOG;
	public static LogBlockBase STRIPPED_WHITE_OAK_LOG;
	public static LogBlockBase WHITE_OAK_WOOD;
	public static LogBlockBase STRIPPED_WHITE_OAK_WOOD;
	public static BlockWood WHITE_OAK_PLANKS;
	public static SlabWood WHITE_OAK_SLAB;
	public static StairsWood WHITE_OAK_STAIRS;
	public static FenceBase WHITE_OAK_FENCE;
	public static FenceGateBase WHITE_OAK_FENCE_GATE;
	public static PressurePlateWood WHITE_OAK_PRESSURE_PLATE;
	public static ButtonWood WHITE_OAK_BUTTON;
	public static WoodenDoor WHITE_OAK_DOOR;
	public static WoodenTrapdoor WHITE_OAK_TRAPDOOR;
	public static LeavesBlockBase WHITE_OAK_LEAVES;

	
	public static void init() {
		
		WHITE_OAK_SAPLING = new SaplingBlockBase(new WhiteOakSaplingGenerator(), "white_oak_sapling", 0.0f, 0.0f);
		WHITE_OAK_LOG = new LogBlockBase(MaterialColor.WHITE, MaterialColor.LIGHT_GRAY_TERRACOTTA, "white_oak_log", 2.0f, 2.0f);
		STRIPPED_WHITE_OAK_LOG = new LogBlockBase(MaterialColor.WHITE, MaterialColor.QUARTZ, "stripped_white_oak_log", 2.0f, 2.0f);
		WHITE_OAK_WOOD = new LogBlockBase(MaterialColor.LIGHT_GRAY_TERRACOTTA, MaterialColor.LIGHT_GRAY_TERRACOTTA,"white_oak_wood", 2.0f, 2.0f);
		STRIPPED_WHITE_OAK_WOOD = new LogBlockBase(MaterialColor.QUARTZ, MaterialColor.QUARTZ, "stripped_white_oak_wood", 2.0f, 2.0f);
		WHITE_OAK_LEAVES = new LeavesBlockBase("white_oak_leaves", 2.0f, 2.0f);
		WHITE_OAK_PLANKS = new BlockWood("white_oak_planks", 2.0f, 3.0f);
		WHITE_OAK_SLAB = new SlabWood("white_oak_slab", 2.0f, 3.0f);
		WHITE_OAK_STAIRS = new StairsWood(WHITE_OAK_PLANKS.getDefaultState(), "white_oak_stairs", 2.0f, 3.0f);
		WHITE_OAK_FENCE = new FenceBase("white_oak_fence", 2.0f, 3.0f);
		WHITE_OAK_FENCE_GATE = new FenceGateBase("white_oak_fence_gate", 2.0f, 3.0f);
		WHITE_OAK_PRESSURE_PLATE = new PressurePlateWood("white_oak_pressure_plate", 2.0f, 3.0f, ActivationRule.EVERYTHING);
		WHITE_OAK_BUTTON = new ButtonWood("white_oak_button", 2.0f, 3.0f);
		WHITE_OAK_DOOR = new WoodenDoor("white_oak_door", 2.0f, 3.0f);
		WHITE_OAK_TRAPDOOR = new WoodenTrapdoor("white_oak_trapdoor", 2.0f, 3.0f);
			
	}

}
