package com.brand.blockus;

import net.minecraft.state.property.IntProperty;

public class BlockusProperties {
    public static final IntProperty BITES_9;

    static {

        BITES_9 = IntProperty.of("bites", 0, 8);

    }
}

