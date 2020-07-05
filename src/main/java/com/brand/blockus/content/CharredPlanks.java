package com.brand.blockus.content;


import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseBT;
import com.brand.blockus.blocks.Base.*;
import com.brand.blockus.blocks.Wood.WoodButtonBase;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.sound.BlockSoundGroup;

public class CharredPlanks {

    public static final BlockBaseBT CHARRED_PLANKS = new BlockBaseBT("charred_planks", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, MaterialColor.GRAY_TERRACOTTA);
    public static final SlabBase CHARRED_SLAB = new SlabBase("charred_slab", CHARRED_PLANKS);
    public static final StairsBase CHARRED_STAIRS = new StairsBase(CHARRED_PLANKS.getDefaultState(), "charred_stairs", CHARRED_PLANKS);
    public static final FenceBase CHARRED_FENCE = new FenceBase("charred_fence", 2.0f, 3.0f, CHARRED_PLANKS.getDefaultMaterialColor());
    public static final FenceGateBase CHARRED_FENCE_GATE = new FenceGateBase("charred_fence_gate", 2.0f, 3.0f, CHARRED_PLANKS.getDefaultMaterialColor());
    public static final PressurePlateBase CHARRED_PRESSURE_PLATE = new PressurePlateBase("charred_pressure_plate", 2.0f, 3.0f, ActivationRule.EVERYTHING, CHARRED_PLANKS.getDefaultMaterialColor());
    public static final WoodButtonBase CHARRED_BUTTON = new WoodButtonBase("charred_button", 2.0f, 3.0f);
    public static final DoorBase CHARRED_DOOR = new DoorBase("charred_door", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, CHARRED_PLANKS.getDefaultMaterialColor());
    public static final TrapdoorBase CHARRED_TRAPDOOR = new TrapdoorBase("charred_trapdoor", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, CHARRED_PLANKS.getDefaultMaterialColor());

}
