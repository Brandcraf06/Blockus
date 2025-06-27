package com.brand.blockus.registry;

import com.brand.blockus.Blockus;
import net.minecraft.registry.Registries;

public class BlockusAliases {
    public static void init() {
        addBlockAndItemAlias("rainbow_petal", "rainbow_petals");
        String[] hedges = {
            "oak", "spruce", "birch", "jungle", "acacia", "dark_oak",
            "mangrove", "cherry", "pale_oak", "white_oak",
            "azalea", "moss", "pale_moss",
            "crimson", "warped"
        };

        for (String type : hedges) {
            addBlockAndItemAlias(type + "_small_hedge", type + "_hedge");
        }
        addBlockAndItemAlias("azalea_small_hedge_flowers", "flowering_azalea_hedge");
    }

    private static void addBlockAndItemAlias(String from, String to) {
        Registries.BLOCK.addAlias(Blockus.id(from), Blockus.id(to));
        Registries.ITEM.addAlias(Blockus.id(from), Blockus.id(to));
    }
}
