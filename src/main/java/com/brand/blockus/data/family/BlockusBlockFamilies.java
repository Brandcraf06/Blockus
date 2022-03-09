package com.brand.blockus.data.family;

import com.brand.blockus.content.BlockusBlocks;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.util.registry.Registry;

import java.util.Map;
import java.util.stream.Stream;

public class BlockusBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();
    private static final String WOODEN_GROUP = "wooden";
    private static final String WOODEN_UNLOCK_CRITERION_NAME = "has_planks";
    public static final BlockFamily WHITE_OAK;
    public static final BlockFamily CHARRED;
    public static final BlockFamily BAMBOO;
    public static final BlockFamily STONE;
    public static final BlockFamily POLISHED_ANDESITE;
    public static final BlockFamily ANDESITE_BRICK;
    public static final BlockFamily POLISHED_DIORITE;
    public static final BlockFamily DIORITE_BRICK;
    public static final BlockFamily POLISHED_GRANITE;
    public static final BlockFamily GRANITE_BRICK;
    public static final BlockFamily POLISHED_DRIPSTONE;
    public static final BlockFamily DRIPSTONE_BRICK;
    public static final BlockFamily POLISHED_TUFF;
    public static final BlockFamily TUFF_BRICK;
    public static final BlockFamily POLISHED_DEEPSLATE;
    public static final BlockFamily MOSSY_DEEPSLATE_BRICK;
    public static final BlockFamily POLISHED_AMETHYST;
    public static final BlockFamily AMETHYST_BRICK;
    public static final BlockFamily BLACKSTONE;
    public static final BlockFamily CRIMSON_WARTY_BLACKSTONE_BRICK;
    public static final BlockFamily WARPED_WARTY_BLACKSTONE_BRICK;
    public static final BlockFamily ROUGH_BASALT;
    public static final BlockFamily POLISHED_BASALT;
    public static final BlockFamily POLISHED_BASALT_BRICK;
    public static final BlockFamily LIMESTONE;
    public static final BlockFamily POLISHED_LIMESTONE;
    public static final BlockFamily LIMESTONE_BRICK;
    public static final BlockFamily SMALL_LIMESTONE_BRICK;
    public static final BlockFamily LIMESTONE_TILE;
    public static final BlockFamily MARBLE;
    public static final BlockFamily POLISHED_MARBLE;
    public static final BlockFamily MARBLE_BRICK;
    public static final BlockFamily SMALL_MARBLE_BRICK;
    public static final BlockFamily MARBLE_TILE;
    public static final BlockFamily BLUESTONE;
    public static final BlockFamily POLISHED_BLUESTONE;
    public static final BlockFamily BLUESTONE_BRICK;
    public static final BlockFamily SMALL_BLUESTONE_BRICK;
    public static final BlockFamily BLUESTONE_TILE;
    public static final BlockFamily LAVA_BRICK;
    public static final BlockFamily LAVA_POLISHED_BLACKSTONE_BRICK;
    public static final BlockFamily WATER_BRICK;
    public static final BlockFamily SNOW_BRICK;
    public static final BlockFamily ICE_BRICK;
    public static final BlockFamily MAGMA_BRICK;
    public static final BlockFamily SMALL_MAGMA_BRICK;
    public static final BlockFamily BLAZE_BRICK;
    public static final BlockFamily POLISHED_NETHERRACK;
    public static final BlockFamily NETHERRACK_BRICK;
    public static final BlockFamily CHARRED_NETHER_BRICK;
    public static final BlockFamily TEAL_NETHER_BRICK;
    public static final BlockFamily OBSIDIAN;
    public static final BlockFamily OBSIDIAN_BRICK;
    public static final BlockFamily SMALL_OBSIDIAN_BRICK;
    public static final BlockFamily QUARTZ_TILE;
    public static final BlockFamily LARGE_BRICK;
    public static final BlockFamily SOAKED_BRICK;
    public static final BlockFamily SANDY_BRICK;
    public static final BlockFamily CHARRED_BRICK;
    public static final BlockFamily HONEYCOMB_BRICK;
    public static final BlockFamily ROUGH_SANDSTONE;
    public static final BlockFamily SANDSTONE_BRICK;
    public static final BlockFamily SMALL_SANDSTONE_BRICK;
    public static final BlockFamily ROUGH_RED_SANDSTONE;
    public static final BlockFamily RED_SANDSTONE_BRICK;
    public static final BlockFamily SMALL_RED_SANDSTONE_BRICK;
    public static final BlockFamily SOUL_SANDSTONE;
    public static final BlockFamily ROUGH_SOUL_SANDSTONE;
    public static final BlockFamily SOUL_SANDSTONE_BRICK;
    public static final BlockFamily SMALL_SOUL_SANDSTONE_BRICK;
    public static final BlockFamily SMOOTH_SOUL_SANDSTONE;
    public static final BlockFamily CUT_SOUL_SANDSTONE;
    public static final BlockFamily POLISHED_PURPUR;
    public static final BlockFamily PURPUR_BRICK;
    public static final BlockFamily SMALL_PURPUR_BRICK;
    public static final BlockFamily PHANTOM_PURPUR_BLOCK;
    public static final BlockFamily POLISHED_PHANTOM_PURPUR;
    public static final BlockFamily PHANTOM_PURPUR_BRICK;
    public static final BlockFamily SMALL_PHANTOM_PURPUR_BRICK;
    public static final BlockFamily POLISHED_END_STONE;
    public static final BlockFamily SMALL_END_STONE_BRICK;
    public static final BlockFamily RAINBOW_BRICK;
    public static final BlockFamily WHITE_STONE_BRICK;
    public static final BlockFamily ORANGE_STONE_BRICK;
    public static final BlockFamily MAGENTA_STONE_BRICK;
    public static final BlockFamily LIGHT_BLUE_STONE_BRICK;
    public static final BlockFamily YELLOW_STONE_BRICK;
    public static final BlockFamily LIME_STONE_BRICK;
    public static final BlockFamily PINK_STONE_BRICK;
    public static final BlockFamily GRAY_STONE_BRICK;
    public static final BlockFamily CYAN_STONE_BRICK;
    public static final BlockFamily PURPLE_STONE_BRICK;
    public static final BlockFamily BLUE_STONE_BRICK;
    public static final BlockFamily BROWN_STONE_BRICK;
    public static final BlockFamily GREEN_STONE_BRICK;
    public static final BlockFamily RED_STONE_BRICK;
    public static final BlockFamily BLACK_STONE_BRICK;
    public static final BlockFamily WHITE_CONCRETE_BRICK;
    public static final BlockFamily ORANGE_CONCRETE_BRICK;
    public static final BlockFamily MAGENTA_CONCRETE_BRICK;
    public static final BlockFamily LIGHT_BLUE_CONCRETE_BRICK;
    public static final BlockFamily YELLOW_CONCRETE_BRICK;
    public static final BlockFamily LIME_CONCRETE_BRICK;
    public static final BlockFamily PINK_CONCRETE_BRICK;
    public static final BlockFamily GRAY_CONCRETE_BRICK;
    public static final BlockFamily LIGHT_GRAY_CONCRETE_BRICK;
    public static final BlockFamily CYAN_CONCRETE_BRICK;
    public static final BlockFamily PURPLE_CONCRETE_BRICK;
    public static final BlockFamily BLUE_CONCRETE_BRICK;
    public static final BlockFamily BROWN_CONCRETE_BRICK;
    public static final BlockFamily GREEN_CONCRETE_BRICK;
    public static final BlockFamily RED_CONCRETE_BRICK;
    public static final BlockFamily BLACK_CONCRETE_BRICK;
    public static final BlockFamily ASPHALT;
    public static final BlockFamily WHITE_ASPHALT;
    public static final BlockFamily ORANGE_ASPHALT;
    public static final BlockFamily MAGENTA_ASPHALT;
    public static final BlockFamily LIGHT_BLUE_ASPHALT;
    public static final BlockFamily YELLOW_ASPHALT;
    public static final BlockFamily LIME_ASPHALT;
    public static final BlockFamily PINK_ASPHALT;
    public static final BlockFamily GRAY_ASPHALT;
    public static final BlockFamily LIGHT_GRAY_ASPHALT;
    public static final BlockFamily CYAN_ASPHALT;
    public static final BlockFamily PURPLE_ASPHALT;
    public static final BlockFamily BLUE_ASPHALT;
    public static final BlockFamily BROWN_ASPHALT;
    public static final BlockFamily GREEN_ASPHALT;
    public static final BlockFamily RED_ASPHALT;
    public static final BlockFamily SHINGLES;
    public static final BlockFamily WHITE_SHINGLES;
    public static final BlockFamily ORANGE_SHINGLES;
    public static final BlockFamily MAGENTA_SHINGLES;
    public static final BlockFamily LIGHT_BLUE_SHINGLES;
    public static final BlockFamily YELLOW_SHINGLES;
    public static final BlockFamily LIME_SHINGLES;
    public static final BlockFamily PINK_SHINGLES;
    public static final BlockFamily GRAY_SHINGLES;
    public static final BlockFamily LIGHT_GRAY_SHINGLES;
    public static final BlockFamily CYAN_SHINGLES;
    public static final BlockFamily PURPLE_SHINGLES;
    public static final BlockFamily BLUE_SHINGLES;
    public static final BlockFamily BROWN_SHINGLES;
    public static final BlockFamily GREEN_SHINGLES;
    public static final BlockFamily RED_SHINGLES;
    public static final BlockFamily BLACK_SHINGLES;
    public static final BlockFamily THATCH;
    public static final BlockFamily PAPER_WALL;
    public static final BlockFamily IRON_PLATING;
    public static final BlockFamily GOLD_PLATING;
    public static final BlockFamily NETHERITE_BLOCK;

    static {
        // Woods
        WHITE_OAK = register(BlockusBlocks.WHITE_OAK_PLANKS).button(BlockusBlocks.WHITE_OAK_BUTTON).fence(BlockusBlocks.WHITE_OAK_FENCE).fenceGate(BlockusBlocks.WHITE_OAK_FENCE_GATE).pressurePlate(BlockusBlocks.WHITE_OAK_PRESSURE_PLATE).sign(BlockusBlocks.WHITE_OAK_SIGN, BlockusBlocks.WHITE_OAK_WALL_SIGN).slab(BlockusBlocks.WHITE_OAK_SLAB).stairs(BlockusBlocks.WHITE_OAK_STAIRS).door(BlockusBlocks.WHITE_OAK_DOOR).trapdoor(BlockusBlocks.WHITE_OAK_TRAPDOOR).group("wooden").unlockCriterionName("has_planks").build();
        CHARRED = register(BlockusBlocks.CHARRED_PLANKS).button(BlockusBlocks.CHARRED_BUTTON).fence(BlockusBlocks.CHARRED_FENCE).fenceGate(BlockusBlocks.CHARRED_FENCE_GATE).pressurePlate(BlockusBlocks.CHARRED_PRESSURE_PLATE).sign(BlockusBlocks.CHARRED_SIGN, BlockusBlocks.CHARRED_WALL_SIGN).slab(BlockusBlocks.CHARRED_SLAB).stairs(BlockusBlocks.CHARRED_STAIRS).door(BlockusBlocks.CHARRED_DOOR).trapdoor(BlockusBlocks.CHARRED_TRAPDOOR).group("wooden").unlockCriterionName("has_planks").build();
        BAMBOO = register(BlockusBlocks.BAMBOO_PLANKS).button(BlockusBlocks.BAMBOO_BUTTON).fence(BlockusBlocks.BAMBOO_FENCE).fenceGate(BlockusBlocks.BAMBOO_FENCE_GATE).pressurePlate(BlockusBlocks.BAMBOO_PRESSURE_PLATE).sign(BlockusBlocks.BAMBOO_SIGN, BlockusBlocks.BAMBOO_WALL_SIGN).slab(BlockusBlocks.BAMBOO_SLAB).stairs(BlockusBlocks.BAMBOO_STAIRS).door(BlockusBlocks.BAMBOO_DOOR).trapdoor(BlockusBlocks.BAMBOO_TRAPDOOR).group("wooden").unlockCriterionName("has_planks").build();

        // Stone, Andesite, Diorite, Granite, Dripstone, Tuff, Deepslate, Blackstone & Basalt
        STONE = register(Blocks.STONE).door(BlockusBlocks.STONE_DOOR).trapdoor(BlockusBlocks.STONE_TRAPDOOR).build();
        POLISHED_ANDESITE = register(Blocks.POLISHED_ANDESITE).pressurePlate(BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_ANDESITE_BUTTON).polished(BlockusBlocks.ANDESITE_BRICKS).build();
        ANDESITE_BRICK = register(BlockusBlocks.ANDESITE_BRICKS).wall(BlockusBlocks.ANDESITE_BRICK_WALL).stairs(BlockusBlocks.ANDESITE_BRICK_STAIRS).slab(BlockusBlocks.ANDESITE_BRICK_SLAB).cracked(BlockusBlocks.CRACKED_ANDESITE_BRICKS).build();
        POLISHED_DIORITE = register(Blocks.POLISHED_DIORITE).pressurePlate(BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_DIORITE_BUTTON).polished(BlockusBlocks.DIORITE_BRICKS).build();
        DIORITE_BRICK = register(BlockusBlocks.DIORITE_BRICKS).wall(BlockusBlocks.DIORITE_BRICK_WALL).stairs(BlockusBlocks.DIORITE_BRICK_STAIRS).slab(BlockusBlocks.DIORITE_BRICK_SLAB).cracked(BlockusBlocks.CRACKED_DIORITE_BRICKS).build();
        POLISHED_GRANITE = register(Blocks.POLISHED_GRANITE).pressurePlate(BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_GRANITE_BUTTON).polished(BlockusBlocks.GRANITE_BRICKS).build();
        GRANITE_BRICK = register(BlockusBlocks.GRANITE_BRICKS).wall(BlockusBlocks.GRANITE_BRICK_WALL).stairs(BlockusBlocks.GRANITE_BRICK_STAIRS).slab(BlockusBlocks.GRANITE_BRICK_SLAB).cracked(BlockusBlocks.CRACKED_GRANITE_BRICKS).build();
        POLISHED_DRIPSTONE = register(BlockusBlocks.POLISHED_DRIPSTONE).stairs(BlockusBlocks.POLISHED_DRIPSTONE_STAIRS).slab(BlockusBlocks.POLISHED_DRIPSTONE_SLAB).polished(BlockusBlocks.DRIPSTONE_BRICKS).build();
        DRIPSTONE_BRICK = register(BlockusBlocks.DRIPSTONE_BRICKS).wall(BlockusBlocks.DRIPSTONE_BRICK_WALL).stairs(BlockusBlocks.DRIPSTONE_BRICK_STAIRS).slab(BlockusBlocks.DRIPSTONE_BRICK_SLAB).cracked(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS).build();
        POLISHED_TUFF = register(BlockusBlocks.POLISHED_TUFF).stairs(BlockusBlocks.POLISHED_TUFF_STAIRS).slab(BlockusBlocks.POLISHED_TUFF_SLAB).pressurePlate(BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_TUFF_BUTTON).polished(BlockusBlocks.TUFF_BRICKS).build();
        TUFF_BRICK = register(BlockusBlocks.TUFF_BRICKS).wall(BlockusBlocks.TUFF_BRICK_WALL).stairs(BlockusBlocks.TUFF_BRICK_STAIRS).slab(BlockusBlocks.TUFF_BRICK_SLAB).cracked(BlockusBlocks.CRACKED_TUFF_BRICKS).build();
        POLISHED_DEEPSLATE = register(Blocks.POLISHED_DEEPSLATE).pressurePlate(BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_DEEPSLATE_BUTTON).build();
        MOSSY_DEEPSLATE_BRICK = register(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS).wall(BlockusBlocks.MOSSY_DEEPSLATE_BRICK_WALL).stairs(BlockusBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS).slab(BlockusBlocks.MOSSY_DEEPSLATE_BRICK_SLAB).build();
        POLISHED_AMETHYST = register(BlockusBlocks.POLISHED_AMETHYST).stairs(BlockusBlocks.POLISHED_AMETHYST_STAIRS).slab(BlockusBlocks.POLISHED_AMETHYST_SLAB).polished(BlockusBlocks.AMETHYST_BRICKS).build();
        AMETHYST_BRICK = register(BlockusBlocks.AMETHYST_BRICKS).wall(BlockusBlocks.AMETHYST_BRICK_WALL).stairs(BlockusBlocks.AMETHYST_BRICK_STAIRS).slab(BlockusBlocks.AMETHYST_BRICK_SLAB).build();
        BLACKSTONE = register(Blocks.BLACKSTONE).door(BlockusBlocks.BLACKSTONE_DOOR).trapdoor(BlockusBlocks.BLACKSTONE_TRAPDOOR).build();
        CRIMSON_WARTY_BLACKSTONE_BRICK = register(BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS).wall(BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICK_WALL).stairs(BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICK_STAIRS).slab(BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICK_SLAB).build();
        WARPED_WARTY_BLACKSTONE_BRICK = register(BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS).wall(BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICK_WALL).stairs(BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICK_STAIRS).slab(BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICK_SLAB).build();
        ROUGH_BASALT = register(BlockusBlocks.ROUGH_BASALT).stairs(BlockusBlocks.ROUGH_BASALT_STAIRS).slab(BlockusBlocks.ROUGH_BASALT_SLAB).build();
        POLISHED_BASALT = register(Blocks.POLISHED_BASALT).pressurePlate(BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_BASALT_BUTTON).polished(BlockusBlocks.POLISHED_BASALT_BRICKS).build();
        POLISHED_BASALT_BRICK = register(BlockusBlocks.POLISHED_BASALT_BRICKS).wall(BlockusBlocks.POLISHED_BASALT_BRICK_WALL).stairs(BlockusBlocks.POLISHED_BASALT_BRICK_STAIRS).slab(BlockusBlocks.POLISHED_BASALT_BRICK_SLAB).cracked(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS).build();

        // Limestone, Marble & Bluestone
        LIMESTONE = register(BlockusBlocks.LIMESTONE).wall(BlockusBlocks.LIMESTONE_WALL).stairs(BlockusBlocks.LIMESTONE_STAIRS).slab(BlockusBlocks.LIMESTONE_SLAB).pressurePlate(BlockusBlocks.LIMESTONE_PRESSURE_PLATE).button(BlockusBlocks.LIMESTONE_BUTTON).polished(BlockusBlocks.POLISHED_LIMESTONE).build();
        POLISHED_LIMESTONE = register(BlockusBlocks.POLISHED_LIMESTONE).stairs(BlockusBlocks.POLISHED_LIMESTONE_STAIRS).slab(BlockusBlocks.POLISHED_LIMESTONE_SLAB).polished(BlockusBlocks.LIMESTONE_BRICKS).build();
        LIMESTONE_BRICK = register(BlockusBlocks.LIMESTONE_BRICKS).wall(BlockusBlocks.LIMESTONE_BRICK_WALL).stairs(BlockusBlocks.LIMESTONE_BRICK_STAIRS).slab(BlockusBlocks.LIMESTONE_BRICK_SLAB).build();
        SMALL_LIMESTONE_BRICK = register(BlockusBlocks.SMALL_LIMESTONE_BRICKS).wall(BlockusBlocks.SMALL_LIMESTONE_BRICK_WALL).stairs(BlockusBlocks.SMALL_LIMESTONE_BRICK_STAIRS).slab(BlockusBlocks.SMALL_LIMESTONE_BRICK_SLAB).build();
        LIMESTONE_TILE = register(BlockusBlocks.LIMESTONE_TILES).wall(BlockusBlocks.LIMESTONE_TILE_WALL).stairs(BlockusBlocks.LIMESTONE_TILE_STAIRS).slab(BlockusBlocks.LIMESTONE_TILE_SLAB).build();
        MARBLE = register(BlockusBlocks.MARBLE).wall(BlockusBlocks.MARBLE_WALL).stairs(BlockusBlocks.MARBLE_STAIRS).slab(BlockusBlocks.MARBLE_SLAB).pressurePlate(BlockusBlocks.MARBLE_PRESSURE_PLATE).button(BlockusBlocks.MARBLE_BUTTON).polished(BlockusBlocks.POLISHED_MARBLE).build();
        POLISHED_MARBLE = register(BlockusBlocks.POLISHED_MARBLE).stairs(BlockusBlocks.POLISHED_MARBLE_STAIRS).slab(BlockusBlocks.POLISHED_MARBLE_SLAB).polished(BlockusBlocks.MARBLE_BRICKS).build();
        MARBLE_BRICK = register(BlockusBlocks.MARBLE_BRICKS).wall(BlockusBlocks.MARBLE_BRICK_WALL).stairs(BlockusBlocks.MARBLE_BRICK_STAIRS).slab(BlockusBlocks.MARBLE_BRICK_SLAB).build();
        SMALL_MARBLE_BRICK = register(BlockusBlocks.SMALL_MARBLE_BRICKS).wall(BlockusBlocks.SMALL_MARBLE_BRICK_WALL).stairs(BlockusBlocks.SMALL_MARBLE_BRICK_STAIRS).slab(BlockusBlocks.SMALL_MARBLE_BRICK_SLAB).build();
        MARBLE_TILE = register(BlockusBlocks.MARBLE_TILES).wall(BlockusBlocks.MARBLE_TILE_WALL).stairs(BlockusBlocks.MARBLE_TILE_STAIRS).slab(BlockusBlocks.MARBLE_TILE_SLAB).build();
        BLUESTONE = register(BlockusBlocks.BLUESTONE).wall(BlockusBlocks.BLUESTONE_WALL).stairs(BlockusBlocks.BLUESTONE_STAIRS).slab(BlockusBlocks.BLUESTONE_SLAB).pressurePlate(BlockusBlocks.BLUESTONE_PRESSURE_PLATE).button(BlockusBlocks.BLUESTONE_BUTTON).polished(BlockusBlocks.POLISHED_BLUESTONE).build();
        POLISHED_BLUESTONE = register(BlockusBlocks.POLISHED_BLUESTONE).stairs(BlockusBlocks.POLISHED_BLUESTONE_STAIRS).slab(BlockusBlocks.POLISHED_BLUESTONE_SLAB).polished(BlockusBlocks.BLUESTONE_BRICKS).build();
        BLUESTONE_BRICK = register(BlockusBlocks.BLUESTONE_BRICKS).wall(BlockusBlocks.BLUESTONE_BRICK_WALL).stairs(BlockusBlocks.BLUESTONE_BRICK_STAIRS).slab(BlockusBlocks.BLUESTONE_BRICK_SLAB).build();
        SMALL_BLUESTONE_BRICK = register(BlockusBlocks.SMALL_BLUESTONE_BRICKS).wall(BlockusBlocks.SMALL_BLUESTONE_BRICK_WALL).stairs(BlockusBlocks.SMALL_BLUESTONE_BRICK_STAIRS).slab(BlockusBlocks.SMALL_BLUESTONE_BRICK_SLAB).build();
        BLUESTONE_TILE = register(BlockusBlocks.BLUESTONE_TILES).wall(BlockusBlocks.BLUESTONE_TILE_WALL).stairs(BlockusBlocks.BLUESTONE_TILE_STAIRS).slab(BlockusBlocks.BLUESTONE_TILE_SLAB).build();

        // Lava	& Water Bricks
        LAVA_BRICK = register(BlockusBlocks.LAVA_BRICKS).wall(BlockusBlocks.LAVA_BRICK_WALL).stairs(BlockusBlocks.LAVA_BRICK_STAIRS).slab(BlockusBlocks.LAVA_BRICK_SLAB).build();
        LAVA_POLISHED_BLACKSTONE_BRICK = register(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS).wall(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_WALL).stairs(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_STAIRS).slab(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_SLAB).build();
        WATER_BRICK = register(BlockusBlocks.WATER_BRICKS).wall(BlockusBlocks.WATER_BRICK_WALL).stairs(BlockusBlocks.WATER_BRICK_STAIRS).slab(BlockusBlocks.WATER_BRICK_SLAB).build();
        SNOW_BRICK = register(BlockusBlocks.SNOW_BRICKS).wall(BlockusBlocks.SNOW_BRICK_WALL).stairs(BlockusBlocks.SNOW_BRICK_STAIRS).slab(BlockusBlocks.SNOW_BRICK_SLAB).build();
        ICE_BRICK = register(BlockusBlocks.ICE_BRICKS).wall(BlockusBlocks.ICE_BRICK_WALL).build();
        MAGMA_BRICK = register(BlockusBlocks.MAGMA_BRICKS).wall(BlockusBlocks.MAGMA_BRICK_WALL).stairs(BlockusBlocks.MAGMA_BRICK_STAIRS).slab(BlockusBlocks.MAGMA_BRICK_SLAB).build();
        SMALL_MAGMA_BRICK = register(BlockusBlocks.SMALL_MAGMA_BRICKS).wall(BlockusBlocks.SMALL_MAGMA_BRICK_WALL).stairs(BlockusBlocks.SMALL_MAGMA_BRICK_STAIRS).slab(BlockusBlocks.SMALL_MAGMA_BRICK_SLAB).build();

        // Nether Bricks
        BLAZE_BRICK = register(BlockusBlocks.BLAZE_BRICKS).wall(BlockusBlocks.BLAZE_BRICK_WALL).stairs(BlockusBlocks.BLAZE_BRICK_STAIRS).slab(BlockusBlocks.BLAZE_BRICK_SLAB).build();
        POLISHED_NETHERRACK = register(BlockusBlocks.POLISHED_NETHERRACK).stairs(BlockusBlocks.POLISHED_NETHERRACK_STAIRS).slab(BlockusBlocks.POLISHED_NETHERRACK_SLAB).pressurePlate(BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_NETHERRACK_BUTTON).build();
        NETHERRACK_BRICK = register(BlockusBlocks.NETHERRACK_BRICKS).wall(BlockusBlocks.NETHERRACK_BRICK_WALL).stairs(BlockusBlocks.NETHERRACK_BRICK_STAIRS).slab(BlockusBlocks.NETHERRACK_BRICK_SLAB).build();
        CHARRED_NETHER_BRICK = register(BlockusBlocks.CHARRED_NETHER_BRICKS).slab(BlockusBlocks.CHARRED_NETHER_BRICK_SLAB).stairs(BlockusBlocks.CHARRED_NETHER_BRICK_STAIRS).wall(BlockusBlocks.CHARRED_NETHER_BRICK_WALL).build();
        TEAL_NETHER_BRICK = register(BlockusBlocks.TEAL_NETHER_BRICKS).slab(BlockusBlocks.TEAL_NETHER_BRICK_SLAB).stairs(BlockusBlocks.TEAL_NETHER_BRICK_STAIRS).wall(BlockusBlocks.TEAL_NETHER_BRICK_WALL).build();

        // Obsidian & Quartz
        OBSIDIAN = register(Blocks.OBSIDIAN).door(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR).trapdoor(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR).build();
        OBSIDIAN_BRICK = register(BlockusBlocks.OBSIDIAN_BRICKS).wall(BlockusBlocks.OBSIDIAN_BRICK_WALL).stairs(BlockusBlocks.OBSIDIAN_BRICK_STAIRS).slab(BlockusBlocks.OBSIDIAN_BRICK_SLAB).cracked(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS).build();
        SMALL_OBSIDIAN_BRICK = register(BlockusBlocks.SMALL_OBSIDIAN_BRICKS).wall(BlockusBlocks.SMALL_OBSIDIAN_BRICK_WALL).stairs(BlockusBlocks.SMALL_OBSIDIAN_BRICK_STAIRS).slab(BlockusBlocks.SMALL_OBSIDIAN_BRICK_SLAB).build();
        QUARTZ_TILE = register(BlockusBlocks.QUARTZ_TILES).wall(BlockusBlocks.QUARTZ_TILE_WALL).stairs(BlockusBlocks.QUARTZ_TILE_STAIRS).slab(BlockusBlocks.QUARTZ_TILE_SLAB).build();

        // Bricks
        LARGE_BRICK = register(BlockusBlocks.LARGE_BRICKS).wall(BlockusBlocks.LARGE_BRICK_WALL).stairs(BlockusBlocks.LARGE_BRICK_STAIRS).slab(BlockusBlocks.LARGE_BRICK_SLAB).build();
        SOAKED_BRICK = register(BlockusBlocks.SOAKED_BRICKS).wall(BlockusBlocks.SOAKED_BRICK_WALL).stairs(BlockusBlocks.SOAKED_BRICK_STAIRS).slab(BlockusBlocks.SOAKED_BRICK_SLAB).build();
        SANDY_BRICK = register(BlockusBlocks.SANDY_BRICKS).wall(BlockusBlocks.SANDY_BRICK_WALL).stairs(BlockusBlocks.SANDY_BRICK_STAIRS).slab(BlockusBlocks.SANDY_BRICK_SLAB).build();
        CHARRED_BRICK = register(BlockusBlocks.CHARRED_BRICKS).wall(BlockusBlocks.CHARRED_BRICK_WALL).stairs(BlockusBlocks.CHARRED_BRICK_STAIRS).slab(BlockusBlocks.CHARRED_BRICK_SLAB).build();
        HONEYCOMB_BRICK = register(BlockusBlocks.HONEYCOMB_BRICKS).wall(BlockusBlocks.HONEYCOMB_BRICK_WALL).stairs(BlockusBlocks.HONEYCOMB_BRICK_STAIRS).slab(BlockusBlocks.HONEYCOMB_BRICK_SLAB).build();

        // Sandstone
        ROUGH_SANDSTONE = register(BlockusBlocks.ROUGH_SANDSTONE).stairs(BlockusBlocks.ROUGH_SANDSTONE_STAIRS).slab(BlockusBlocks.ROUGH_SANDSTONE_SLAB).build();
        SANDSTONE_BRICK = register(BlockusBlocks.SANDSTONE_BRICKS).wall(BlockusBlocks.SANDSTONE_BRICK_WALL).stairs(BlockusBlocks.SANDSTONE_BRICK_STAIRS).slab(BlockusBlocks.SANDSTONE_BRICK_SLAB).build();
        SMALL_SANDSTONE_BRICK = register(BlockusBlocks.SMALL_SANDSTONE_BRICKS).wall(BlockusBlocks.SMALL_SANDSTONE_BRICK_WALL).stairs(BlockusBlocks.SMALL_SANDSTONE_BRICK_STAIRS).slab(BlockusBlocks.SMALL_SANDSTONE_BRICK_SLAB).build();
        ROUGH_RED_SANDSTONE = register(BlockusBlocks.ROUGH_RED_SANDSTONE).stairs(BlockusBlocks.ROUGH_RED_SANDSTONE_STAIRS).slab(BlockusBlocks.ROUGH_RED_SANDSTONE_SLAB).build();
        RED_SANDSTONE_BRICK = register(BlockusBlocks.RED_SANDSTONE_BRICKS).wall(BlockusBlocks.RED_SANDSTONE_BRICK_WALL).stairs(BlockusBlocks.RED_SANDSTONE_BRICK_STAIRS).slab(BlockusBlocks.RED_SANDSTONE_BRICK_SLAB).build();
        SMALL_RED_SANDSTONE_BRICK = register(BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS).wall(BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_WALL).stairs(BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_STAIRS).slab(BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_SLAB).build();
        SOUL_SANDSTONE = register(BlockusBlocks.SOUL_SANDSTONE).wall(BlockusBlocks.SOUL_SANDSTONE_WALL).stairs(BlockusBlocks.SOUL_SANDSTONE_STAIRS).slab(BlockusBlocks.SOUL_SANDSTONE_SLAB).build();
        ROUGH_SOUL_SANDSTONE = register(BlockusBlocks.ROUGH_SOUL_SANDSTONE).stairs(BlockusBlocks.ROUGH_SOUL_SANDSTONE_STAIRS).slab(BlockusBlocks.ROUGH_SOUL_SANDSTONE_SLAB).build();
        SOUL_SANDSTONE_BRICK = register(BlockusBlocks.SOUL_SANDSTONE_BRICKS).wall(BlockusBlocks.SOUL_SANDSTONE_BRICK_WALL).stairs(BlockusBlocks.SOUL_SANDSTONE_BRICK_STAIRS).slab(BlockusBlocks.SOUL_SANDSTONE_BRICK_SLAB).build();
        SMALL_SOUL_SANDSTONE_BRICK = register(BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS).wall(BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_WALL).stairs(BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_STAIRS).slab(BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_SLAB).build();
        SMOOTH_SOUL_SANDSTONE = register(BlockusBlocks.SMOOTH_SOUL_SANDSTONE).stairs(BlockusBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS).slab(BlockusBlocks.SMOOTH_SOUL_SANDSTONE_SLAB).build();
        CUT_SOUL_SANDSTONE = register(BlockusBlocks.CUT_SOUL_SANDSTONE).slab(BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB).build();

        // Purpur & End Stone
        POLISHED_PURPUR = register(BlockusBlocks.POLISHED_PURPUR).stairs(BlockusBlocks.POLISHED_PURPUR_STAIRS).slab(BlockusBlocks.POLISHED_PURPUR_SLAB).build();
        PURPUR_BRICK = register(BlockusBlocks.PURPUR_BRICKS).wall(BlockusBlocks.PURPUR_BRICK_WALL).stairs(BlockusBlocks.PURPUR_BRICK_STAIRS).slab(BlockusBlocks.PURPUR_BRICK_SLAB).build();
        SMALL_PURPUR_BRICK = register(BlockusBlocks.SMALL_PURPUR_BRICKS).wall(BlockusBlocks.SMALL_PURPUR_BRICK_WALL).stairs(BlockusBlocks.SMALL_PURPUR_BRICK_STAIRS).slab(BlockusBlocks.SMALL_PURPUR_BRICK_SLAB).build();
        PHANTOM_PURPUR_BLOCK = register(BlockusBlocks.PHANTOM_PURPUR_BLOCK).stairs(BlockusBlocks.PHANTOM_PURPUR_STAIRS).slab(BlockusBlocks.PHANTOM_PURPUR_SLAB).polished(BlockusBlocks.POLISHED_PHANTOM_PURPUR).build();
        POLISHED_PHANTOM_PURPUR = register(BlockusBlocks.POLISHED_PHANTOM_PURPUR).stairs(BlockusBlocks.POLISHED_PHANTOM_PURPUR_STAIRS).slab(BlockusBlocks.POLISHED_PHANTOM_PURPUR_SLAB).build();
        PHANTOM_PURPUR_BRICK = register(BlockusBlocks.PHANTOM_PURPUR_BRICKS).wall(BlockusBlocks.PHANTOM_PURPUR_BRICK_WALL).stairs(BlockusBlocks.PHANTOM_PURPUR_BRICK_STAIRS).slab(BlockusBlocks.PHANTOM_PURPUR_BRICK_SLAB).build();
        SMALL_PHANTOM_PURPUR_BRICK = register(BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS).wall(BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_WALL).stairs(BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_STAIRS).slab(BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_SLAB).build();
        POLISHED_END_STONE = register(BlockusBlocks.POLISHED_END_STONE).stairs(BlockusBlocks.POLISHED_END_STONE_STAIRS).slab(BlockusBlocks.POLISHED_END_STONE_SLAB).pressurePlate(BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_END_STONE_BUTTON).build();
        SMALL_END_STONE_BRICK = register(BlockusBlocks.SMALL_END_STONE_BRICKS).wall(BlockusBlocks.SMALL_END_STONE_BRICK_WALL).stairs(BlockusBlocks.SMALL_END_STONE_BRICK_STAIRS).slab(BlockusBlocks.SMALL_END_STONE_BRICK_SLAB).build();

        // Rainbow Bricks
        RAINBOW_BRICK = register(BlockusBlocks.RAINBOW_BRICKS).wall(BlockusBlocks.RAINBOW_BRICK_WALL).stairs(BlockusBlocks.RAINBOW_BRICK_STAIRS).slab(BlockusBlocks.RAINBOW_BRICK_SLAB).build();

        // Stained Stone Bricks
        WHITE_STONE_BRICK = register(BlockusBlocks.WHITE_STONE_BRICKS).stairs(BlockusBlocks.WHITE_STONE_BRICK_STAIRS).slab(BlockusBlocks.WHITE_STONE_BRICK_SLAB).wall(BlockusBlocks.WHITE_STONE_BRICK_WALL).build();
        ORANGE_STONE_BRICK = register(BlockusBlocks.ORANGE_STONE_BRICKS).stairs(BlockusBlocks.ORANGE_STONE_BRICK_STAIRS).slab(BlockusBlocks.ORANGE_STONE_BRICK_SLAB).wall(BlockusBlocks.ORANGE_STONE_BRICK_WALL).build();
        MAGENTA_STONE_BRICK = register(BlockusBlocks.MAGENTA_STONE_BRICKS).stairs(BlockusBlocks.MAGENTA_STONE_BRICK_STAIRS).slab(BlockusBlocks.MAGENTA_STONE_BRICK_SLAB).wall(BlockusBlocks.MAGENTA_STONE_BRICK_WALL).build();
        LIGHT_BLUE_STONE_BRICK = register(BlockusBlocks.LIGHT_BLUE_STONE_BRICKS).stairs(BlockusBlocks.LIGHT_BLUE_STONE_BRICK_STAIRS).slab(BlockusBlocks.LIGHT_BLUE_STONE_BRICK_SLAB).wall(BlockusBlocks.LIGHT_BLUE_STONE_BRICK_WALL).build();
        YELLOW_STONE_BRICK = register(BlockusBlocks.YELLOW_STONE_BRICKS).stairs(BlockusBlocks.YELLOW_STONE_BRICK_STAIRS).slab(BlockusBlocks.YELLOW_STONE_BRICK_SLAB).wall(BlockusBlocks.YELLOW_STONE_BRICK_WALL).build();
        LIME_STONE_BRICK = register(BlockusBlocks.LIME_STONE_BRICKS).stairs(BlockusBlocks.LIME_STONE_BRICK_STAIRS).slab(BlockusBlocks.LIME_STONE_BRICK_SLAB).wall(BlockusBlocks.LIME_STONE_BRICK_WALL).build();
        PINK_STONE_BRICK = register(BlockusBlocks.PINK_STONE_BRICKS).stairs(BlockusBlocks.PINK_STONE_BRICK_STAIRS).slab(BlockusBlocks.PINK_STONE_BRICK_SLAB).wall(BlockusBlocks.PINK_STONE_BRICK_WALL).build();
        GRAY_STONE_BRICK = register(BlockusBlocks.GRAY_STONE_BRICKS).stairs(BlockusBlocks.GRAY_STONE_BRICK_STAIRS).slab(BlockusBlocks.GRAY_STONE_BRICK_SLAB).wall(BlockusBlocks.GRAY_STONE_BRICK_WALL).build();
        CYAN_STONE_BRICK = register(BlockusBlocks.CYAN_STONE_BRICKS).stairs(BlockusBlocks.CYAN_STONE_BRICK_STAIRS).slab(BlockusBlocks.CYAN_STONE_BRICK_SLAB).wall(BlockusBlocks.CYAN_STONE_BRICK_WALL).build();
        PURPLE_STONE_BRICK = register(BlockusBlocks.PURPLE_STONE_BRICKS).stairs(BlockusBlocks.PURPLE_STONE_BRICK_STAIRS).slab(BlockusBlocks.PURPLE_STONE_BRICK_SLAB).wall(BlockusBlocks.PURPLE_STONE_BRICK_WALL).build();
        BLUE_STONE_BRICK = register(BlockusBlocks.BLUE_STONE_BRICKS).stairs(BlockusBlocks.BLUE_STONE_BRICK_STAIRS).slab(BlockusBlocks.BLUE_STONE_BRICK_SLAB).wall(BlockusBlocks.BLUE_STONE_BRICK_WALL).build();
        BROWN_STONE_BRICK = register(BlockusBlocks.BROWN_STONE_BRICKS).stairs(BlockusBlocks.BROWN_STONE_BRICK_STAIRS).slab(BlockusBlocks.BROWN_STONE_BRICK_SLAB).wall(BlockusBlocks.BROWN_STONE_BRICK_WALL).build();
        GREEN_STONE_BRICK = register(BlockusBlocks.GREEN_STONE_BRICKS).stairs(BlockusBlocks.GREEN_STONE_BRICK_STAIRS).slab(BlockusBlocks.GREEN_STONE_BRICK_SLAB).wall(BlockusBlocks.GREEN_STONE_BRICK_WALL).build();
        RED_STONE_BRICK = register(BlockusBlocks.RED_STONE_BRICKS).stairs(BlockusBlocks.RED_STONE_BRICK_STAIRS).slab(BlockusBlocks.RED_STONE_BRICK_SLAB).wall(BlockusBlocks.RED_STONE_BRICK_WALL).build();
        BLACK_STONE_BRICK = register(BlockusBlocks.BLACK_STONE_BRICKS).stairs(BlockusBlocks.BLACK_STONE_BRICK_STAIRS).slab(BlockusBlocks.BLACK_STONE_BRICK_SLAB).wall(BlockusBlocks.BLACK_STONE_BRICK_WALL).build();

        // Concrete Bricks
        WHITE_CONCRETE_BRICK = register(BlockusBlocks.WHITE_CONCRETE_BRICKS).stairs(BlockusBlocks.WHITE_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.WHITE_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.WHITE_CONCRETE_BRICK_WALL).build();
        ORANGE_CONCRETE_BRICK = register(BlockusBlocks.ORANGE_CONCRETE_BRICKS).stairs(BlockusBlocks.ORANGE_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.ORANGE_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.ORANGE_CONCRETE_BRICK_WALL).build();
        MAGENTA_CONCRETE_BRICK = register(BlockusBlocks.MAGENTA_CONCRETE_BRICKS).stairs(BlockusBlocks.MAGENTA_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.MAGENTA_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.MAGENTA_CONCRETE_BRICK_WALL).build();
        LIGHT_BLUE_CONCRETE_BRICK = register(BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS).stairs(BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICK_WALL).build();
        YELLOW_CONCRETE_BRICK = register(BlockusBlocks.YELLOW_CONCRETE_BRICKS).stairs(BlockusBlocks.YELLOW_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.YELLOW_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.YELLOW_CONCRETE_BRICK_WALL).build();
        LIME_CONCRETE_BRICK = register(BlockusBlocks.LIME_CONCRETE_BRICKS).stairs(BlockusBlocks.LIME_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.LIME_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.LIME_CONCRETE_BRICK_WALL).build();
        PINK_CONCRETE_BRICK = register(BlockusBlocks.PINK_CONCRETE_BRICKS).stairs(BlockusBlocks.PINK_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.PINK_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.PINK_CONCRETE_BRICK_WALL).build();
        GRAY_CONCRETE_BRICK = register(BlockusBlocks.GRAY_CONCRETE_BRICKS).stairs(BlockusBlocks.GRAY_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.GRAY_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.GRAY_CONCRETE_BRICK_WALL).build();
        LIGHT_GRAY_CONCRETE_BRICK = register(BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS).stairs(BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICK_WALL).build();
        CYAN_CONCRETE_BRICK = register(BlockusBlocks.CYAN_CONCRETE_BRICKS).stairs(BlockusBlocks.CYAN_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.CYAN_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.CYAN_CONCRETE_BRICK_WALL).build();
        PURPLE_CONCRETE_BRICK = register(BlockusBlocks.PURPLE_CONCRETE_BRICKS).stairs(BlockusBlocks.PURPLE_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.PURPLE_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.PURPLE_CONCRETE_BRICK_WALL).build();
        BLUE_CONCRETE_BRICK = register(BlockusBlocks.BLUE_CONCRETE_BRICKS).stairs(BlockusBlocks.BLUE_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.BLUE_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.BLUE_CONCRETE_BRICK_WALL).build();
        BROWN_CONCRETE_BRICK = register(BlockusBlocks.BROWN_CONCRETE_BRICKS).stairs(BlockusBlocks.BROWN_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.BROWN_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.BROWN_CONCRETE_BRICK_WALL).build();
        GREEN_CONCRETE_BRICK = register(BlockusBlocks.GREEN_CONCRETE_BRICKS).stairs(BlockusBlocks.GREEN_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.GREEN_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.GREEN_CONCRETE_BRICK_WALL).build();
        RED_CONCRETE_BRICK = register(BlockusBlocks.RED_CONCRETE_BRICKS).stairs(BlockusBlocks.RED_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.RED_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.RED_CONCRETE_BRICK_WALL).build();
        BLACK_CONCRETE_BRICK = register(BlockusBlocks.BLACK_CONCRETE_BRICKS).stairs(BlockusBlocks.BLACK_CONCRETE_BRICK_STAIRS).slab(BlockusBlocks.BLACK_CONCRETE_BRICK_SLAB).wall(BlockusBlocks.BLACK_CONCRETE_BRICK_WALL).build();

        // Asphalt
        ASPHALT = register(BlockusBlocks.ASPHALT).stairs(BlockusBlocks.ASPHALT_STAIRS).slab(BlockusBlocks.ASPHALT_SLAB).build();
        WHITE_ASPHALT = register(BlockusBlocks.WHITE_ASPHALT).stairs(BlockusBlocks.WHITE_ASPHALT_STAIRS).slab(BlockusBlocks.WHITE_ASPHALT_SLAB).build();
        ORANGE_ASPHALT = register(BlockusBlocks.ORANGE_ASPHALT).stairs(BlockusBlocks.ORANGE_ASPHALT_STAIRS).slab(BlockusBlocks.ORANGE_ASPHALT_SLAB).build();
        MAGENTA_ASPHALT = register(BlockusBlocks.MAGENTA_ASPHALT).stairs(BlockusBlocks.MAGENTA_ASPHALT_STAIRS).slab(BlockusBlocks.MAGENTA_ASPHALT_SLAB).build();
        LIGHT_BLUE_ASPHALT = register(BlockusBlocks.LIGHT_BLUE_ASPHALT).stairs(BlockusBlocks.LIGHT_BLUE_ASPHALT_STAIRS).slab(BlockusBlocks.LIGHT_BLUE_ASPHALT_SLAB).build();
        YELLOW_ASPHALT = register(BlockusBlocks.YELLOW_ASPHALT).stairs(BlockusBlocks.YELLOW_ASPHALT_STAIRS).slab(BlockusBlocks.YELLOW_ASPHALT_SLAB).build();
        LIME_ASPHALT = register(BlockusBlocks.LIME_ASPHALT).stairs(BlockusBlocks.LIME_ASPHALT_STAIRS).slab(BlockusBlocks.LIME_ASPHALT_SLAB).build();
        PINK_ASPHALT = register(BlockusBlocks.PINK_ASPHALT).stairs(BlockusBlocks.PINK_ASPHALT_STAIRS).slab(BlockusBlocks.PINK_ASPHALT_SLAB).build();
        GRAY_ASPHALT = register(BlockusBlocks.GRAY_ASPHALT).stairs(BlockusBlocks.GRAY_ASPHALT_STAIRS).slab(BlockusBlocks.GRAY_ASPHALT_SLAB).build();
        LIGHT_GRAY_ASPHALT = register(BlockusBlocks.LIGHT_GRAY_ASPHALT).stairs(BlockusBlocks.LIGHT_GRAY_ASPHALT_STAIRS).slab(BlockusBlocks.LIGHT_GRAY_ASPHALT_SLAB).build();
        CYAN_ASPHALT = register(BlockusBlocks.CYAN_ASPHALT).stairs(BlockusBlocks.CYAN_ASPHALT_STAIRS).slab(BlockusBlocks.CYAN_ASPHALT_SLAB).build();
        PURPLE_ASPHALT = register(BlockusBlocks.PURPLE_ASPHALT).stairs(BlockusBlocks.PURPLE_ASPHALT_STAIRS).slab(BlockusBlocks.PURPLE_ASPHALT_SLAB).build();
        BLUE_ASPHALT = register(BlockusBlocks.BLUE_ASPHALT).stairs(BlockusBlocks.BLUE_ASPHALT_STAIRS).slab(BlockusBlocks.BLUE_ASPHALT_SLAB).build();
        BROWN_ASPHALT = register(BlockusBlocks.BROWN_ASPHALT).stairs(BlockusBlocks.BROWN_ASPHALT_STAIRS).slab(BlockusBlocks.BROWN_ASPHALT_SLAB).build();
        GREEN_ASPHALT = register(BlockusBlocks.GREEN_ASPHALT).stairs(BlockusBlocks.GREEN_ASPHALT_STAIRS).slab(BlockusBlocks.GREEN_ASPHALT_SLAB).build();
        RED_ASPHALT = register(BlockusBlocks.RED_ASPHALT).stairs(BlockusBlocks.RED_ASPHALT_STAIRS).slab(BlockusBlocks.RED_ASPHALT_SLAB).build();

        // Shingles
        SHINGLES = register(BlockusBlocks.SHINGLES).stairs(BlockusBlocks.SHINGLES_STAIRS).slab(BlockusBlocks.SHINGLES_SLAB).build();
        WHITE_SHINGLES = register(BlockusBlocks.WHITE_SHINGLES).stairs(BlockusBlocks.WHITE_SHINGLES_STAIRS).slab(BlockusBlocks.WHITE_SHINGLES_SLAB).build();
        ORANGE_SHINGLES = register(BlockusBlocks.ORANGE_SHINGLES).stairs(BlockusBlocks.ORANGE_SHINGLES_STAIRS).slab(BlockusBlocks.ORANGE_SHINGLES_SLAB).build();
        MAGENTA_SHINGLES = register(BlockusBlocks.MAGENTA_SHINGLES).stairs(BlockusBlocks.MAGENTA_SHINGLES_STAIRS).slab(BlockusBlocks.MAGENTA_SHINGLES_SLAB).build();
        LIGHT_BLUE_SHINGLES = register(BlockusBlocks.LIGHT_BLUE_SHINGLES).stairs(BlockusBlocks.LIGHT_BLUE_SHINGLES_STAIRS).slab(BlockusBlocks.LIGHT_BLUE_SHINGLES_SLAB).build();
        YELLOW_SHINGLES = register(BlockusBlocks.YELLOW_SHINGLES).stairs(BlockusBlocks.YELLOW_SHINGLES_STAIRS).slab(BlockusBlocks.YELLOW_SHINGLES_SLAB).build();
        LIME_SHINGLES = register(BlockusBlocks.LIME_SHINGLES).stairs(BlockusBlocks.LIME_SHINGLES_STAIRS).slab(BlockusBlocks.LIME_SHINGLES_SLAB).build();
        PINK_SHINGLES = register(BlockusBlocks.PINK_SHINGLES).stairs(BlockusBlocks.PINK_SHINGLES_STAIRS).slab(BlockusBlocks.PINK_SHINGLES_SLAB).build();
        GRAY_SHINGLES = register(BlockusBlocks.GRAY_SHINGLES).stairs(BlockusBlocks.GRAY_SHINGLES_STAIRS).slab(BlockusBlocks.GRAY_SHINGLES_SLAB).build();
        LIGHT_GRAY_SHINGLES = register(BlockusBlocks.LIGHT_GRAY_SHINGLES).stairs(BlockusBlocks.LIGHT_GRAY_SHINGLES_STAIRS).slab(BlockusBlocks.LIGHT_GRAY_SHINGLES_SLAB).build();
        CYAN_SHINGLES = register(BlockusBlocks.CYAN_SHINGLES).stairs(BlockusBlocks.CYAN_SHINGLES_STAIRS).slab(BlockusBlocks.CYAN_SHINGLES_SLAB).build();
        PURPLE_SHINGLES = register(BlockusBlocks.PURPLE_SHINGLES).stairs(BlockusBlocks.PURPLE_SHINGLES_STAIRS).slab(BlockusBlocks.PURPLE_SHINGLES_SLAB).build();
        BLUE_SHINGLES = register(BlockusBlocks.BLUE_SHINGLES).stairs(BlockusBlocks.BLUE_SHINGLES_STAIRS).slab(BlockusBlocks.BLUE_SHINGLES_SLAB).build();
        BROWN_SHINGLES = register(BlockusBlocks.BROWN_SHINGLES).stairs(BlockusBlocks.BROWN_SHINGLES_STAIRS).slab(BlockusBlocks.BROWN_SHINGLES_SLAB).build();
        GREEN_SHINGLES = register(BlockusBlocks.GREEN_SHINGLES).stairs(BlockusBlocks.GREEN_SHINGLES_STAIRS).slab(BlockusBlocks.GREEN_SHINGLES_SLAB).build();
        RED_SHINGLES = register(BlockusBlocks.RED_SHINGLES).stairs(BlockusBlocks.RED_SHINGLES_STAIRS).slab(BlockusBlocks.RED_SHINGLES_SLAB).build();
        BLACK_SHINGLES = register(BlockusBlocks.BLACK_SHINGLES).stairs(BlockusBlocks.BLACK_SHINGLES_STAIRS).slab(BlockusBlocks.BLACK_SHINGLES_SLAB).build();

        // Other
        THATCH = register(BlockusBlocks.THATCH).stairs(BlockusBlocks.THATCH_STAIRS).slab(BlockusBlocks.THATCH_SLAB).build();
        PAPER_WALL = register(BlockusBlocks.PAPER_WALL).door(BlockusBlocks.PAPER_DOOR).trapdoor(BlockusBlocks.PAPER_TRAPDOOR).build();
        IRON_PLATING = register(BlockusBlocks.IRON_PLATING).stairs(BlockusBlocks.IRON_PLATING_STAIRS).slab(BlockusBlocks.IRON_PLATING_SLAB).build();
        GOLD_PLATING = register(BlockusBlocks.GOLD_PLATING).stairs(BlockusBlocks.GOLD_PLATING_STAIRS).slab(BlockusBlocks.GOLD_PLATING_SLAB).build();
        NETHERITE_BLOCK = register(Blocks.NETHERITE_BLOCK).stairs(BlockusBlocks.NETHERITE_STAIRS).slab(BlockusBlocks.NETHERITE_SLAB).build();

    }

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registry.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }
}

