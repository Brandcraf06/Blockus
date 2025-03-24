package com.brand.blockus.registry;

import com.brand.blockus.Blockus;
import net.minecraft.registry.Registries;

public class RegistryAliases {
    public static void init() {
            Registries.BLOCK.addAlias(Blockus.id("rainbow_petal"), Blockus.id("rainbow_petals"));
    }
}
