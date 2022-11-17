package com.brand.blockus.tag;

import com.brand.blockus.Blockus;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKeys;

public final class BlockusItemTags {

    public static final TagKey<Item> BARRELS = register("barrels");
    public static final TagKey<Item> BARRIERS = register("barriers");
    public static final TagKey<Item> BLOCKUS_BARRELS = register("blockus_barrels");
    public static final TagKey<Item> NATURAL_ICE = register("natural_ice");
    public static final TagKey<Item> PATTERNED_WOOL = register("patterned_wool");
    public static final TagKey<Item> SMALL_HEDGES = register("small_hedges");
    public static final TagKey<Item> SOUL_SOILS = register("soul_soils");
    public static final TagKey<Item> STAINED_STONE_BRICKS = register("stained_stone_bricks");
    public static final TagKey<Item> WARPED_NETHER_GRASS = register("warped_nether_grass");
    public static final TagKey<Item> WHITE_OAK_LOGS = register("white_oak_logs");
    public static final TagKey<Item> PLANKS_THAT_BURN = register("planks_that_burn");
	public static final TagKey<Item> HERRINGBONE_PLANKS_THAT_BURN = register("herringbone_planks_that_burn");



    private BlockusItemTags() {
        return;
    }

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(Blockus.MOD_ID, id));
    }
}
