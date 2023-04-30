package com.brand.blockus.tags;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class BlockusBlockTags {

    public static final TagKey<Block> AMETHYST_BLOCKS = register("amethyst_blocks");
    public static final TagKey<Block> ANDESITE_BLOCKS = register("andesite_blocks");
    public static final TagKey<Block> ASPHALT = register("asphalt");
    public static final TagKey<Block> BARRIERS = register("barriers");
    public static final TagKey<Block> BASALT_BLOCKS = register("basalt_blocks");
    public static final TagKey<Block> BEVELED_GLASS = register("beveled_glass");
    public static final TagKey<Block> BLACKSTONE_BLOCKS = register("blackstone_blocks");
    public static final TagKey<Block> BLAZE_BRICKS = register("blaze_bricks");
    public static final TagKey<Block> BLUESTONE = register("bluestone");
    public static final TagKey<Block> BRICKS_BLOCKS = register("bricks_blocks");
    public static final TagKey<Block> CHOCOLATE_BLOCKS = register("chocolate_blocks");
    public static final TagKey<Block> COLORED_TILES = register("colored_tiles");
    public static final TagKey<Block> CONCRETE_BLOCKS = register("concrete_blocks");
    public static final TagKey<Block> DEEPSLATE_BLOCKS = register("deepslate_blocks");
    public static final TagKey<Block> DIORITE_BLOCKS = register("diorite_blocks");
    public static final TagKey<Block> DRIPSTONE_BLOCKS = register("dripstone_blocks");
    public static final TagKey<Block> END_STONE_BLOCKS = register("end_stone_blocks");
    public static final TagKey<Block> FOOD_CRATES = register("food_crates");
    public static final TagKey<Block> FRAMED_PAPER_BLOCKS = register("framed_paper_blocks");
    public static final TagKey<Block> GLAZED_TERRACOTTA_PILLARS = register("glazed_terracotta_pillars");
    public static final TagKey<Block> GRANITE_BLOCKS = register("granite_blocks");
    public static final TagKey<Block> HONEYCOMB_BLOCKS = register("honeycomb_blocks");
    public static final TagKey<Block> ICE_BRICKS = register("ice_bricks");
    public static final TagKey<Block> LARGE_FLOWER_POTS = register("large_flower_pots");
    public static final TagKey<Block> LAVA_BRICKS = register("lava_bricks");
    public static final TagKey<Block> LAVA_POLISHED_BLACKSTONE_BRICKS = register("lava_polished_blackstone_bricks");
    public static final TagKey<Block> LIMESTONE = register("limestone");
    public static final TagKey<Block> MAGMA_BRICKS = register("magma_bricks");
    public static final TagKey<Block> MARBLE = register("marble");
    public static final TagKey<Block> NEON = register("neon");
    public static final TagKey<Block> NETHER_BRICKS = register("nether_bricks");
    public static final TagKey<Block> NETHERRACK_BLOCKS = register("netherrack_blocks");
    public static final TagKey<Block> OBSIDIAN = register("obsidian");
    public static final TagKey<Block> PATTERNED_WOOL = register("patterned_wool");
    public static final TagKey<Block> PATTERNED_CARPETS = register("patterned_carpets");
    public static final TagKey<Block> ALL_PATTERNED_WOOLS = register("all_patterned_wools");
    public static final TagKey<Block> PHANTOM_PURPUR_BLOCKS = register("phantom_purpur_blocks");
    public static final TagKey<Block> PLATINGS = register("platings");
    public static final TagKey<Block> PRISMARINE_BLOCKS = register("prismarine_blocks");
    public static final TagKey<Block> PURPUR_BLOCKS = register("purpur_blocks");
    public static final TagKey<Block> QUARTZ_BLOCKS = register("quartz_blocks");
    public static final TagKey<Block> RAINBOW_BLOCKS = register("rainbow_blocks");
    public static final TagKey<Block> RED_SANDSTONE = register("red_sandstone");
    public static final TagKey<Block> SANDSTONE = register("sandstone");
    public static final TagKey<Block> SCULK_BLOCKS = register("sculk_blocks");
    public static final TagKey<Block> SHINGLES = register("shingles");
    public static final TagKey<Block> SMALL_HEDGES = register("small_hedges");
    public static final TagKey<Block> SNOW_BRICKS = register("snow_bricks");
    public static final TagKey<Block> SOUL_SANDSTONE = register("soul_sandstone");
    public static final TagKey<Block> SOUL_SOILS = register("soul_soils");
    public static final TagKey<Block> STAINED_STONE_BRICKS = register("stained_stone_bricks");
    public static final TagKey<Block> STONE_BLOCKS = register("stone_blocks");
    public static final TagKey<Block> THATCH = register("thatch");
    public static final TagKey<Block> TIMBER_FRAMES = register("timber_frames");
    public static final TagKey<Block> TUFF_BLOCKS = register("tuff_blocks");
    public static final TagKey<Block> VIRIDITE = register("viridite");
    public static final TagKey<Block> WARPED_NETHER_GRASS = register("warped_nether_grass");
    public static final TagKey<Block> WATER_BRICKS = register("water_bricks");
    public static final TagKey<Block> WHITE_OAK_LOGS = register("white_oak_logs");

    private BlockusBlockTags() {
        return;
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(Blockus.MOD_ID, id));
    }
}
