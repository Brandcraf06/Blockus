package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.DoorBase;
import com.brand.blockus.blocks.Base.TrapdoorBase;
import com.brand.blockus.blocks.Base.SpecificTool.BlockBase2;
import com.brand.blockus.blocks.Base.SpecificTool.SlabBase2;
import com.brand.blockus.blocks.Base.SpecificTool.StairsBase2;
import com.brand.blockus.blocks.Leaves.LeavesBlockBase;
import com.brand.blockus.blocks.Sapling.PottedBlockBase;
import com.brand.blockus.blocks.Sapling.SaplingBlockBase;
import com.brand.blockus.blocks.Sapling.WhiteOakSaplingGenerator;
import com.brand.blockus.blocks.Wood.ButtonWood;
import com.brand.blockus.blocks.Wood.FenceBase;
import com.brand.blockus.blocks.Wood.FenceGateBase;
import com.brand.blockus.blocks.Wood.LogBlockBase;
import com.brand.blockus.blocks.Wood.PressurePlateWood;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.sound.BlockSoundGroup;

public class WhiteOak {
		
	public static final SaplingBlockBase WHITE_OAK_SAPLING = new SaplingBlockBase(new WhiteOakSaplingGenerator(), "white_oak_sapling");
	public static final PottedBlockBase POTTED_WHITE_OAK_SAPLING = new PottedBlockBase(WHITE_OAK_SAPLING, "potted_white_oak_sapling");
	public static final LogBlockBase WHITE_OAK_LOG = new LogBlockBase(MaterialColor.WHITE, MaterialColor.LIGHT_GRAY_TERRACOTTA, "white_oak_log", 2.0f, 2.0f);
	public static final LogBlockBase STRIPPED_WHITE_OAK_LOG = new LogBlockBase(MaterialColor.WHITE, MaterialColor.QUARTZ, "stripped_white_oak_log", 2.0f, 2.0f);
	public static final LogBlockBase WHITE_OAK_WOOD = new LogBlockBase(MaterialColor.LIGHT_GRAY_TERRACOTTA, MaterialColor.LIGHT_GRAY_TERRACOTTA,"white_oak_wood", 2.0f, 2.0f);
	public static final LogBlockBase STRIPPED_WHITE_OAK_WOOD = new LogBlockBase(MaterialColor.QUARTZ, MaterialColor.QUARTZ, "stripped_white_oak_wood", 2.0f, 2.0f);
	public static final LeavesBlockBase WHITE_OAK_LEAVES = new LeavesBlockBase("white_oak_leaves", 2.0f, 2.0f);
	public static final BlockBase2 WHITE_OAK_PLANKS = new BlockBase2("white_oak_planks", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0);
	public static final SlabBase2 WHITE_OAK_SLAB = new SlabBase2("white_oak_slab", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0);
	public static final StairsBase2 WHITE_OAK_STAIRS = new StairsBase2(WHITE_OAK_PLANKS.getDefaultState(), "white_oak_stairs", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0);
	public static final FenceBase WHITE_OAK_FENCE = new FenceBase("white_oak_fence", 2.0f, 3.0f);
	public static final FenceGateBase WHITE_OAK_FENCE_GATE = new FenceGateBase("white_oak_fence_gate", 2.0f, 3.0f);
	public static final PressurePlateWood WHITE_OAK_PRESSURE_PLATE = new PressurePlateWood("white_oak_pressure_plate", 2.0f, 3.0f, ActivationRule.EVERYTHING);
	public static final ButtonWood WHITE_OAK_BUTTON = new ButtonWood("white_oak_button", 2.0f, 3.0f);
	public static final DoorBase WHITE_OAK_DOOR = new DoorBase("white_oak_door", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0);
	public static final TrapdoorBase WHITE_OAK_TRAPDOOR = new TrapdoorBase("white_oak_trapdoor", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0);


}
