package com.brand.blockus.registry.tag;

import com.brand.blockus.Blockus;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class BlockusItemTags {

    public static final TagKey<Item> BARRIERS = register("barriers");
    public static final TagKey<Item> NATURAL_ICE = register("natural_ice");
    public static final TagKey<Item> PATTERNED_WOOL = register("patterned_wool");
    public static final TagKey<Item> PATTERNED_WOOL_STAIRS = register("patterned_wool_stairs");
    public static final TagKey<Item> PATTERNED_WOOL_SLABS = register("patterned_wool_slabs");
    public static final TagKey<Item> PATTERNED_CARPETS = register("patterned_carpets");
    public static final TagKey<Item> ALL_PATTERNED_WOOLS = register("all_patterned_wools");
    public static final TagKey<Item> TIMBER_FRAMES = register("timber_frames");
    public static final TagKey<Item> HEDGES = register("hedges");
    public static final TagKey<Item> SOUL_SOILS = register("soul_soils");
    public static final TagKey<Item> DYED_STONE_BRICKS = register("dyed_stone_bricks");
    public static final TagKey<Item> SHINGLES = register("shingles");
    public static final TagKey<Item> CONCRETE_BRICKS = register("concrete_bricks");
    public static final TagKey<Item> GLAZED_TERRACOTTA_PILLARS = register("glazed_terracotta_pillars");
    public static final TagKey<Item> COLORED_TILES = register("colored_tiles");
    public static final TagKey<Item> ASPHALT = register("asphalt");
    public static final TagKey<Item> NEON = register("neon");
    public static final TagKey<Item> FUTURNEO_BLOCKS = register("futurneo_blocks");
    public static final TagKey<Item> LIT_REDSTONE_LAMPS = register("lit_redstone_lamps");
    public static final TagKey<Item> REDSTONE_LAMPS = register("redstone_lamps");
    public static final TagKey<Item> WARPED_NETHER_GRASS = register("warped_nether_grass");
    public static final TagKey<Item> WHITE_OAK_LOGS = register("white_oak_logs");
    public static final TagKey<Item> PLANKS_THAT_CAN_BE_CHARRED = register("planks_that_can_be_charred");
    public static final TagKey<Item> HERRINGBONE_PLANKS_THAT_CAN_BE_CHARRED = register("herringbone_planks_that_can_be_charred");
    public static final TagKey<Item> WOODEN_MOSAICS_THAT_CAN_BE_CHARRED = register("wooden_mosaics_that_can_be_charred");
    public static final TagKey<Item> LANTERN_BLOCKS = register("lantern_blocks");

    private BlockusItemTags() {
    }

    private static TagKey<Item> register(String name) {
        return TagKey.create(Registries.ITEM, Blockus.id(name));
    }
}
