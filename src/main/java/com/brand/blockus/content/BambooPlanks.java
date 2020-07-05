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

public class BambooPlanks {

    public static final BlockBaseBT BAMBOO_PLANKS = new BlockBaseBT("bamboo_planks", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.AXES, 0, MaterialColor.SAND);
    public static final SlabBase BAMBOO_SLAB = new SlabBase("bamboo_slab", BAMBOO_PLANKS);
    public static final StairsBase BAMBOO_STAIRS = new StairsBase(BAMBOO_PLANKS.getDefaultState(), "bamboo_stairs", BAMBOO_PLANKS);
    public static final FenceBase BAMBOO_FENCE = new FenceBase("bamboo_fence", 2.0f, 3.0f, BAMBOO_PLANKS.getDefaultMaterialColor());
    public static final FenceGateBase BAMBOO_FENCE_GATE = new FenceGateBase("bamboo_fence_gate", 2.0f, 3.0f, BAMBOO_PLANKS.getDefaultMaterialColor());
    public static final PressurePlateBase BAMBOO_PRESSURE_PLATE = new PressurePlateBase("bamboo_pressure_plate", 2.0f, 3.0f, ActivationRule.EVERYTHING, BAMBOO_PLANKS.getDefaultMaterialColor());
    public static final WoodButtonBase BAMBOO_BUTTON = new WoodButtonBase("bamboo_button", 2.0f, 3.0f);
    public static final DoorBase BAMBOO_DOOR = new DoorBase("bamboo_door", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, BAMBOO_PLANKS.getDefaultMaterialColor());
    public static final TrapdoorBase BAMBOO_TRAPDOOR = new TrapdoorBase("bamboo_trapdoor", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, BAMBOO_PLANKS.getDefaultMaterialColor());

}
