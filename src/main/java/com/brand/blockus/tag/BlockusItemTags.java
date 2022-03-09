package com.brand.blockus.tag;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;

public final class BlockusItemTags {
    public static final Tag.Identified<Item> BARRELS = create("barrels");
    public static final Tag.Identified<Item> BARRIERS = create("barriers");
    public static final Tag.Identified<Item> BLOCKUS_BARRELS = create("blockus_barrels");
    public static final Tag.Identified<Item> NATURAL_ICE = create("natural_ice");
    public static final Tag.Identified<Item> PATTERNED_WOOL = create("patterned_wool");
    public static final Tag.Identified<Item> SMALL_HEDGES = create("small_hedges");
    public static final Tag.Identified<Item> SOUL_SOILS = create("soul_soils");
    public static final Tag.Identified<Item> STAINED_STONE_BRICKS = create("stained_stone_bricks");
    public static final Tag.Identified<Item> WARPED_NETHER_GRASS = create("warped_nether_grass");
    public static final Tag.Identified<Item> WHITE_OAK_LOGS = create("white_oak_logs");
    public static final Tag.Identified<Item> PLANKS_THAT_BURN = create("planks_that_burn");


    private BlockusItemTags() {
        return;
    }

    private static Tag.Identified<Item> create(String path) {
        return TagFactory.ITEM.create(Blockus.id(path));
    }
}
