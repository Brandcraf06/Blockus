package com.brand.blockus.registry;

import com.brand.blockus.Blockus;
import net.minecraft.registry.Registries;

public class BlockusAliases {
    public static void init() {
            Registries.BLOCK.addAlias(Blockus.id("rainbow_petal"), Blockus.id("rainbow_petals"));
            Registries.ITEM.addAlias(Blockus.id("rainbow_petal"), Blockus.id("rainbow_petals"));
    }
}
