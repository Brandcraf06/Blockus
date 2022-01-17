package com.brand.blockus.tag;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BlockusBlockTags {
    public static final Tag.Identified<Block> ANDESITE_BLOCKS = create("andesite_blocks");
    public static final Tag.Identified<Block> ASPHALT = create("asphalt");
    public static final Tag.Identified<Block> BARRELS = create("barrels");
    public static final Tag.Identified<Block> BARRIERS = create("barriers");
    public static final Tag.Identified<Block> BASALT_BLOCKS = create("basalt_blocks");
    public static final Tag.Identified<Block> BEVELED_GLASS = create("beveled_glass");
    public static final Tag.Identified<Block> BLACKSTONE_BLOCKS = create("blackstone_blocks");
    public static final Tag.Identified<Block> BLAZE_BRICKS = create("blaze_bricks");
    public static final Tag.Identified<Block> BLUESTONE = create("bluestone");
    public static final Tag.Identified<Block> BRICKS_BLOCKS = create("bricks_blocks");
    public static final Tag.Identified<Block> COLORED_TILES = create("colored_tiles");
    public static final Tag.Identified<Block> CONCRETE_BLOCKS = create("concrete_blocks");
    public static final Tag.Identified<Block> DEEPSLATE_BLOCKS = create("deepslate_blocks");
    public static final Tag.Identified<Block> DIORITE_BLOCKS = create("diorite_blocks");
    public static final Tag.Identified<Block> DRIPSTONE_BLOCKS = create("dripstone_blocks");
    public static final Tag.Identified<Block> END_STONE_BLOCKS = create("end_stone_blocks");
    public static final Tag.Identified<Block> FOOD_CRATES = create("food_crates");
    public static final Tag.Identified<Block> FRAMED_PAPER_BLOCKS = create("framed_paper_blocks");
    public static final Tag.Identified<Block> GLAZED_TERRACOTTA_PILLARS = create("glazed_terracotta_pillars");
    public static final Tag.Identified<Block> GRANITE_BLOCKS = create("granite_blocks");
    public static final Tag.Identified<Block> HONEYCOMB_BLOCKS = create("honeycomb_blocks");
    public static final Tag.Identified<Block> ICE_BRICKS = create("ice_bricks");
    public static final Tag.Identified<Block> LARGE_FLOWER_POTS = create("large_flower_pots");
    public static final Tag.Identified<Block> LAVA_BRICKS = create("lava_bricks");
    public static final Tag.Identified<Block> LAVA_POLISHED_BLACKSTONE_BRICKS = create("lava_polished_blackstone_bricks");
    public static final Tag.Identified<Block> LIMESTONE = create("limestone");
    public static final Tag.Identified<Block> MAGMA_BRICKS = create("magma_bricks");
    public static final Tag.Identified<Block> MARBLE = create("marble");
    public static final Tag.Identified<Block> NEON = create("neon");
    public static final Tag.Identified<Block> NETHER_BRICKS = create("nether_bricks");
    public static final Tag.Identified<Block> NETHERRACK_BLOCKS = create("netherrack_blocks");
    public static final Tag.Identified<Block> OBSIDIAN = create("obsidian");
    public static final Tag.Identified<Block> PATTERNED_WOOL = create("patterned_wool");
    public static final Tag.Identified<Block> PHANTOM_PURPUR_BLOCKS = create("phantom_purpur_blocks");
    public static final Tag.Identified<Block> PLATINGS = create("platings");
    public static final Tag.Identified<Block> PRISMARINE_BLOCKS = create("prismarine_blocks");
    public static final Tag.Identified<Block> PURPUR_BLOCKS = create("purpur_blocks");
    public static final Tag.Identified<Block> QUARTZ_BLOCKS = create("quartz_blocks");
    public static final Tag.Identified<Block> RAINBOW_BLOCKS = create("rainbow_blocks");
    public static final Tag.Identified<Block> RED_SANDSTONE = create("red_sandstone");
    public static final Tag.Identified<Block> SANDSTONE = create("sandstone");
    public static final Tag.Identified<Block> SHINGLES = create("shingles");
    public static final Tag.Identified<Block> SMALL_HEDGES = create("small_hedges");
    public static final Tag.Identified<Block> SNOW_BRICKS = create("snow_bricks");
    public static final Tag.Identified<Block> SOUL_SANDSTONE = create("soul_sandstone");
    public static final Tag.Identified<Block> SOUL_SOILS = create("soul_soils");
    public static final Tag.Identified<Block> STAINED_STONE_BRICKS = create("stained_stone_bricks");
    public static final Tag.Identified<Block> STONE_BLOCKS = create("stone_blocks");
    public static final Tag.Identified<Block> STONE_BUTTONS = create("stone_buttons");
    public static final Tag.Identified<Block> THATCH = create("thatch");
    public static final Tag.Identified<Block> TIMBER_FRAMES = create("timber_frames");
    public static final Tag.Identified<Block> TUFF_BLOCKS = create("tuff_blocks");
    public static final Tag.Identified<Block> WARPED_NETHER_GRASS = create("warped_nether_grass");
    public static final Tag.Identified<Block> WATER_BRICKS = create("water_bricks");
    public static final Tag.Identified<Block> WHITE_OAK_LOGS = create("white_oak_logs");

    private BlockusBlockTags() {
        return;
    }

    private static Tag.Identified<Block> create(String path) {
        return TagFactory.BLOCK.create(new Identifier(Blockus.MOD_ID, path));
    }
}
