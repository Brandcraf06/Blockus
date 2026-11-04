package com.brand.blockus.registry;

import com.brand.blockus.Blockus;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class BlockusAliases {
    public static void init() {
        addBlockAndItemAlias("obsidian_reinforced_door", "obsidian_door");
        addBlockAndItemAlias("obsidian_reinforced_trapdoor", "obsidian_trapdoor");

        addBlockAndItemAlias("ice_bricks", Identifier.withDefaultNamespace("packed_ice_bricks"));
        addBlockAndItemAlias("ice_brick_wall", Identifier.withDefaultNamespace("packed_ice_brick_wall"));
        addBlockAndItemAlias("ice_pillar", "packed_ice_pillar");

        addDefaultNamespaceAlias("packed_ice_bricks");
        addDefaultNamespaceAlias("packed_ice_brick_stairs");
        addDefaultNamespaceAlias("packed_ice_brick_slab");
        addDefaultNamespaceAlias("packed_ice_brick_wall");
        addDefaultNamespaceAlias("chiseled_packed_ice");

        addDefaultNamespaceAlias("snow_bricks");
        addDefaultNamespaceAlias("snow_brick_stairs");
        addDefaultNamespaceAlias("snow_brick_slab");
        addDefaultNamespaceAlias("snow_brick_wall");
    }

    private static void addBlockAndItemAlias(Identifier from, Identifier to) {
        BuiltInRegistries.BLOCK.addAlias(from, to);
        BuiltInRegistries.ITEM.addAlias(from, to);
    }

    private static void addBlockAndItemAlias(String from, Identifier to) {
        addBlockAndItemAlias(Blockus.id(from), to);
    }

    private static void addBlockAndItemAlias(String from, String to) {
        addBlockAndItemAlias(Blockus.id(from), Blockus.id(to));
    }

    private static void addDefaultNamespaceAlias(String name) {
        addBlockAndItemAlias(Blockus.id(name), Identifier.withDefaultNamespace(name));
    }
}
