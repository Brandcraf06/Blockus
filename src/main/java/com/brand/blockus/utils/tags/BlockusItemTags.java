package com.brand.blockus.utils.tags;

import com.brand.blockus.Blockus;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class BlockusItemTags {

    public static final TagKey<Item> BARRIERS = register("barriers");
    public static final TagKey<Item> NATURAL_ICE = register("natural_ice");
    public static final TagKey<Item> PATTERNED_WOOL = register("patterned_wool");
    public static final TagKey<Item> PATTERNED_CARPETS = register("patterned_carpets");
    public static final TagKey<Item> ALL_PATTERNED_WOOLS = register("all_patterned_wools");
    public static final TagKey<Item> SMALL_HEDGES = register("small_hedges");
    public static final TagKey<Item> SOUL_SOILS = register("soul_soils");
    public static final TagKey<Item> STAINED_STONE_BRICKS = register("stained_stone_bricks");
    public static final TagKey<Item> WARPED_NETHER_GRASS = register("warped_nether_grass");
    public static final TagKey<Item> WHITE_OAK_LOGS = register("white_oak_logs");
    public static final TagKey<Item> PLANKS_THAT_BURN = register("planks_that_burn");
    public static final TagKey<Item> HERRINGBONE_PLANKS_THAT_BURN = register("herringbone_planks_that_burn");
    public static final TagKey<Item> WOODEN_MOSAIC_THAT_BURN = register("wooden_mosaic_that_burn");


    private BlockusItemTags() {
    }

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, Blockus.id(id));
    }
}
