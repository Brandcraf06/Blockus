package com.brand.blockus.blocks.base.redstone;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.sound.SoundEvent;

public class ButtonBase extends AbstractButtonBlock {

    public ButtonBase(Settings settings, int pressTicks, boolean wooden, SoundEvent clickOffSound, SoundEvent clickOnSound) {
        super(settings, pressTicks, wooden, clickOffSound, clickOnSound);
    }
}
