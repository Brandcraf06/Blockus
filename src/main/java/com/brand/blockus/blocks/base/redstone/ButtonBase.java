package com.brand.blockus.blocks.base.redstone;

import net.minecraft.block.ButtonBlock;
import net.minecraft.sound.SoundEvent;

public class ButtonBase extends ButtonBlock {

    public ButtonBase(Settings settings, int pressTicks, boolean wooden, SoundEvent clickOffSound, SoundEvent clickOnSound) {
        super(settings, pressTicks, wooden, clickOffSound, clickOnSound);
    }
}
