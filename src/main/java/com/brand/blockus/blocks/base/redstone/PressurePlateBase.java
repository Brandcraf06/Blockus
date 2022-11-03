package com.brand.blockus.blocks.base.redstone;

import net.minecraft.block.PressurePlateBlock;
import net.minecraft.sound.SoundEvent;

public class PressurePlateBase extends PressurePlateBlock {

    public PressurePlateBase(PressurePlateBlock.ActivationRule type, Settings settings, SoundEvent depressSound, SoundEvent pressSound) {
        super(type, settings, depressSound, pressSound);
    }

}
