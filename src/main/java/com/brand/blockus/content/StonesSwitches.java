package com.brand.blockus.content;


import com.brand.blockus.blocks.Switches.PressurePlateBase;
import com.brand.blockus.blocks.Switches.StoneButtonBase;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.sound.BlockSoundGroup;

public class StonesSwitches {

    public static final PressurePlateBase POLISHED_ANDESITE_PRESSURE_PLATE = new PressurePlateBase("polished_andesite_pressure_plate", BlockSoundGroup.STONE, ActivationRule.MOBS, Blocks.POLISHED_ANDESITE.getDefaultMapColor());
    public static final StoneButtonBase POLISHED_ANDESITE_BUTTON = new StoneButtonBase("polished_andesite_button");

    public static final PressurePlateBase POLISHED_DIORITE_PRESSURE_PLATE = new PressurePlateBase("polished_diorite_pressure_plate", BlockSoundGroup.STONE, ActivationRule.MOBS, Blocks.POLISHED_DIORITE.getDefaultMapColor());
    public static final StoneButtonBase POLISHED_DIORITE_BUTTON = new StoneButtonBase("polished_diorite_button");

    public static final PressurePlateBase POLISHED_GRANITE_PRESSURE_PLATE = new PressurePlateBase("polished_granite_pressure_plate", BlockSoundGroup.STONE, ActivationRule.MOBS, Blocks.POLISHED_GRANITE.getDefaultMapColor());
    public static final StoneButtonBase POLISHED_GRANITE_BUTTON = new StoneButtonBase("polished_granite_button");

    public static final PressurePlateBase LIMESTONE_PRESSURE_PLATE = new PressurePlateBase("limestone_pressure_plate", BlockSoundGroup.STONE, ActivationRule.MOBS, NewStones.LIMESTONE.getDefaultMapColor());
    public static final StoneButtonBase LIMESTONE_BUTTON = new StoneButtonBase("limestone_button");

    public static final PressurePlateBase MARBLE_PRESSURE_PLATE = new PressurePlateBase("marble_pressure_plate", BlockSoundGroup.STONE, ActivationRule.MOBS, NewStones.MARBLE.getDefaultMapColor());
    public static final StoneButtonBase MARBLE_BUTTON = new StoneButtonBase("marble_button");

    public static final PressurePlateBase BLUESTONE_PRESSURE_PLATE = new PressurePlateBase("bluestone_pressure_plate", BlockSoundGroup.STONE, ActivationRule.MOBS, NewStones.BLUESTONE.getDefaultMapColor());
    public static final StoneButtonBase BLUESTONE_BUTTON = new StoneButtonBase("bluestone_button");

    public static final PressurePlateBase POLISHED_NETHERRACK_PRESSURE_PLATE = new PressurePlateBase("polished_netherrack_pressure_plate", BlockSoundGroup.NETHERRACK, ActivationRule.MOBS, NetherrackRelated.POLISHED_NETHERRACK.getDefaultMapColor());
    public static final StoneButtonBase POLISHED_NETHERRACK_BUTTON = new StoneButtonBase("polished_netherrack_button");

    public static final PressurePlateBase POLISHED_END_STONE_PRESSURE_PLATE = new PressurePlateBase("polished_end_stone_pressure_plate", BlockSoundGroup.STONE, ActivationRule.MOBS, EndStoneRelated.POLISHED_END_STONE.getDefaultMapColor());
    public static final StoneButtonBase POLISHED_END_STONE_BUTTON = new StoneButtonBase("polished_end_stone_button");

}
