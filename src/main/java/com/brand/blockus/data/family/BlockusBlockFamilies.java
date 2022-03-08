package com.brand.blockus.data.family;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.types.BlockTypes;
import com.brand.blockus.content.types.LightBlockTypes;
import com.brand.blockus.content.types.WallTypes;
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
    public static final BlockFamily WATER_BRICK;
    public static final BlockFamily SNOW_BRICK;
    public static final BlockFamily ICE_BRICK;
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
    public static final BlockFamily SANDSTONE_BRICK;
    public static final BlockFamily SMALL_SANDSTONE_BRICK;
    public static final BlockFamily RED_SANDSTONE_BRICK;
    public static final BlockFamily SMALL_RED_SANDSTONE_BRICK;
    public static final BlockFamily SOUL_SANDSTONE;
    public static final BlockFamily SOUL_SANDSTONE_BRICK;
    public static final BlockFamily SMALL_SOUL_SANDSTONE_BRICK;
    public static final BlockFamily SMOOTH_SOUL_SANDSTONE;
    public static final BlockFamily CUT_SOUL_SANDSTONE;
    public static final BlockFamily PURPUR_BRICK;
    public static final BlockFamily SMALL_PURPUR_BRICK;
    public static final BlockFamily PHANTOM_PURPUR_BLOCK;
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
    public static final BlockFamily PAPER_WALL;
    public static final BlockFamily NETHERITE_BLOCK;

    static {
        // Woods
        WHITE_OAK = register(BlockusBlocks.WHITE_OAK_PLANKS).button(BlockusBlocks.WHITE_OAK_BUTTON).fence(BlockusBlocks.WHITE_OAK_FENCE).fenceGate(BlockusBlocks.WHITE_OAK_FENCE_GATE).pressurePlate(BlockusBlocks.WHITE_OAK_PRESSURE_PLATE).sign(BlockusBlocks.WHITE_OAK_SIGN, BlockusBlocks.WHITE_OAK_WALL_SIGN).slab(BlockusBlocks.WHITE_OAK_SLAB).stairs(BlockusBlocks.WHITE_OAK_STAIRS).door(BlockusBlocks.WHITE_OAK_DOOR).trapdoor(BlockusBlocks.WHITE_OAK_TRAPDOOR).group("wooden").unlockCriterionName("has_planks").build();
        CHARRED = register(BlockusBlocks.CHARRED_PLANKS).button(BlockusBlocks.CHARRED_BUTTON).fence(BlockusBlocks.CHARRED_FENCE).fenceGate(BlockusBlocks.CHARRED_FENCE_GATE).pressurePlate(BlockusBlocks.CHARRED_PRESSURE_PLATE).sign(BlockusBlocks.CHARRED_SIGN, BlockusBlocks.CHARRED_WALL_SIGN).slab(BlockusBlocks.CHARRED_SLAB).stairs(BlockusBlocks.CHARRED_STAIRS).door(BlockusBlocks.CHARRED_DOOR).trapdoor(BlockusBlocks.CHARRED_TRAPDOOR).group("wooden").unlockCriterionName("has_planks").build();
        BAMBOO = register(BlockusBlocks.BAMBOO_PLANKS).button(BlockusBlocks.BAMBOO_BUTTON).fence(BlockusBlocks.BAMBOO_FENCE).fenceGate(BlockusBlocks.BAMBOO_FENCE_GATE).pressurePlate(BlockusBlocks.BAMBOO_PRESSURE_PLATE).sign(BlockusBlocks.BAMBOO_SIGN, BlockusBlocks.BAMBOO_WALL_SIGN).slab(BlockusBlocks.BAMBOO_SLAB).stairs(BlockusBlocks.BAMBOO_STAIRS).door(BlockusBlocks.BAMBOO_DOOR).trapdoor(BlockusBlocks.BAMBOO_TRAPDOOR).group("wooden").unlockCriterionName("has_planks").build();

        // Stone, Andesite, Diorite, Granite, Dripstone, Tuff, Deepslate, Blackstone & Basalt
        STONE = register(Blocks.STONE).door(BlockusBlocks.STONE_DOOR).trapdoor(BlockusBlocks.STONE_TRAPDOOR).build();
        POLISHED_ANDESITE = register(Blocks.POLISHED_ANDESITE).pressurePlate(BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_ANDESITE_BUTTON).polished(BlockTypes.ANDESITE_BRICKS.block).build();
        ANDESITE_BRICK = register(BlockTypes.ANDESITE_BRICKS.block).wall(WallTypes.ANDESITE_BRICKS.wall).cracked(BlockusBlocks.CRACKED_ANDESITE_BRICKS).build();
        POLISHED_DIORITE = register(Blocks.POLISHED_DIORITE).pressurePlate(BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_DIORITE_BUTTON).polished(BlockTypes.DIORITE_BRICKS.block).build();
        DIORITE_BRICK = register(BlockTypes.DIORITE_BRICKS.block).cracked(BlockusBlocks.CRACKED_DIORITE_BRICKS).build();
        POLISHED_GRANITE = register(Blocks.POLISHED_GRANITE).pressurePlate(BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_GRANITE_BUTTON).polished(BlockTypes.GRANITE_BRICKS.block).build();
        GRANITE_BRICK = register(BlockTypes.GRANITE_BRICKS.block).cracked(BlockusBlocks.CRACKED_GRANITE_BRICKS).build();
        POLISHED_DRIPSTONE = register(BlockTypes.POLISHED_DRIPSTONE.block).polished(BlockTypes.DRIPSTONE_BRICKS.block).build();
        DRIPSTONE_BRICK = register(BlockTypes.DRIPSTONE_BRICKS.block).wall(WallTypes.DRIPSTONE_BRICKS.wall).cracked(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS).build();
        POLISHED_TUFF = register(BlockTypes.POLISHED_TUFF.block).pressurePlate(BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_TUFF_BUTTON).polished(BlockTypes.TUFF_BRICKS.block).build();
        TUFF_BRICK = register(BlockTypes.TUFF_BRICKS.block).wall(WallTypes.TUFF_BRICKS.wall).cracked(BlockusBlocks.CRACKED_TUFF_BRICKS).build();
        POLISHED_DEEPSLATE = register(Blocks.POLISHED_DEEPSLATE).pressurePlate(BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_DEEPSLATE_BUTTON).build();
        MOSSY_DEEPSLATE_BRICK = register(BlockTypes.MOSSY_DEEPSLATE_BRICKS.block).wall(WallTypes.MOSSY_DEEPSLATE_BRICKS.wall).build();
        POLISHED_AMETHYST = register(BlockusBlocks.POLISHED_AMETHYST).stairs(BlockusBlocks.POLISHED_AMETHYST_STAIRS).slab(BlockusBlocks.POLISHED_AMETHYST_SLAB).polished(BlockusBlocks.AMETHYST_BRICKS).build();
        AMETHYST_BRICK = register(BlockusBlocks.AMETHYST_BRICKS).wall(BlockusBlocks.AMETHYST_BRICK_WALL).stairs(BlockusBlocks.AMETHYST_BRICK_STAIRS).slab(BlockusBlocks.AMETHYST_BRICK_SLAB).build();
        BLACKSTONE = register(Blocks.BLACKSTONE).door(BlockusBlocks.BLACKSTONE_DOOR).trapdoor(BlockusBlocks.BLACKSTONE_TRAPDOOR).build();
        CRIMSON_WARTY_BLACKSTONE_BRICK = register(BlockTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.block).wall(WallTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.wall).build();
        WARPED_WARTY_BLACKSTONE_BRICK = register(BlockTypes.WARPED_WARTY_BLACKSTONE_BRICKS.block).wall(WallTypes.WARPED_WARTY_BLACKSTONE_BRICKS.wall).build();
        ROUGH_BASALT = register(BlockTypes.ROUGH_BASALT.block).build();
        POLISHED_BASALT = register(Blocks.POLISHED_BASALT).pressurePlate(BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_BASALT_BUTTON).polished(BlockTypes.POLISHED_BASALT_BRICKS.block).build();
        POLISHED_BASALT_BRICK = register(BlockTypes.POLISHED_BASALT_BRICKS.block).wall(WallTypes.POLISHED_BASALT_BRICKS.wall).cracked(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS).build();

        // Limestone, Marble & Bluestone
        LIMESTONE = register(BlockTypes.LIMESTONE.block).wall(WallTypes.LIMESTONE.wall).pressurePlate(BlockusBlocks.LIMESTONE_PRESSURE_PLATE).button(BlockusBlocks.LIMESTONE_BUTTON).polished(BlockTypes.POLISHED_LIMESTONE.block).build();
        POLISHED_LIMESTONE = register(BlockTypes.POLISHED_LIMESTONE.block).polished(BlockTypes.LIMESTONE_BRICKS.block).build();
        LIMESTONE_BRICK = register(BlockTypes.LIMESTONE_BRICKS.block).wall(WallTypes.LIMESTONE_BRICKS.wall).build();
        SMALL_LIMESTONE_BRICK = register(BlockTypes.SMALL_LIMESTONE_BRICKS.block).wall(WallTypes.SMALL_LIMESTONE_BRICKS.wall).build();
        LIMESTONE_TILE = register(BlockTypes.LIMESTONE_TILES.block).wall(WallTypes.LIMESTONE_TILES.wall).build();
        MARBLE = register(BlockTypes.MARBLE.block).wall(WallTypes.MARBLE.wall).pressurePlate(BlockusBlocks.MARBLE_PRESSURE_PLATE).button(BlockusBlocks.MARBLE_BUTTON).polished(BlockTypes.POLISHED_MARBLE.block).build();
        POLISHED_MARBLE = register(BlockTypes.POLISHED_MARBLE.block).polished(BlockTypes.MARBLE_BRICKS.block).build();
        MARBLE_BRICK = register(BlockTypes.MARBLE_BRICKS.block).wall(WallTypes.MARBLE_BRICKS.wall).build();
        SMALL_MARBLE_BRICK = register(BlockTypes.SMALL_MARBLE_BRICKS.block).wall(WallTypes.SMALL_MARBLE_BRICKS.wall).build();
        MARBLE_TILE = register(BlockTypes.MARBLE_TILES.block).wall(WallTypes.MARBLE_TILES.wall).build();
        BLUESTONE = register(BlockTypes.BLUESTONE.block).wall(WallTypes.BLUESTONE.wall).pressurePlate(BlockusBlocks.BLUESTONE_PRESSURE_PLATE).button(BlockusBlocks.BLUESTONE_BUTTON).polished(BlockTypes.POLISHED_BLUESTONE.block).build();
        POLISHED_BLUESTONE = register(BlockTypes.POLISHED_BLUESTONE.block).polished(BlockTypes.BLUESTONE_BRICKS.block).build();
        BLUESTONE_BRICK = register(BlockTypes.BLUESTONE_BRICKS.block).wall(WallTypes.BLUESTONE_BRICKS.wall).build();
        SMALL_BLUESTONE_BRICK = register(BlockTypes.SMALL_BLUESTONE_BRICKS.block).wall(WallTypes.SMALL_BLUESTONE_BRICKS.wall).build();
        BLUESTONE_TILE = register(BlockTypes.BLUESTONE_TILES.block).wall(WallTypes.BLUESTONE_TILES.wall).build();

        // Lava	& Water Bricks
        WATER_BRICK = register(BlockTypes.WATER_BRICKS.block).wall(WallTypes.WATER_BRICKS.wall).build();
        SNOW_BRICK = register(BlockusBlocks.SNOW_BRICKS).wall(BlockusBlocks.SNOW_BRICK_WALL).stairs(BlockusBlocks.SNOW_BRICK_STAIRS).slab(BlockusBlocks.SNOW_BRICK_SLAB).build();
        ICE_BRICK = register(BlockusBlocks.ICE_BRICKS).wall(BlockusBlocks.ICE_BRICK_WALL).build();

        // Nether Bricks
        POLISHED_NETHERRACK = register(BlockTypes.POLISHED_NETHERRACK.block).pressurePlate(BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_NETHERRACK_BUTTON).build();
        NETHERRACK_BRICK = register(BlockTypes.NETHERRACK_BRICKS.block).wall(WallTypes.NETHERRACK_BRICKS.wall).build();
        CHARRED_NETHER_BRICK = register(BlockTypes.CHARRED_NETHER_BRICKS.block).wall(WallTypes.CHARRED_NETHER_BRICKS.wall).build();
        TEAL_NETHER_BRICK = register(BlockTypes.TEAL_NETHER_BRICKS.block).wall(WallTypes.TEAL_NETHER_BRICKS.wall).build();

        // Obsidian & Quartz
        OBSIDIAN = register(Blocks.OBSIDIAN).door(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR).trapdoor(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR).build();
        OBSIDIAN_BRICK = register(BlockTypes.OBSIDIAN_BRICKS.block).wall(WallTypes.OBSIDIAN_BRICKS.wall).cracked(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS).build();
        SMALL_OBSIDIAN_BRICK = register(BlockTypes.SMALL_OBSIDIAN_BRICKS.block).wall(WallTypes.SMALL_OBSIDIAN_BRICKS.wall).build();
        QUARTZ_TILE = register(BlockTypes.QUARTZ_TILES.block).wall(WallTypes.QUARTZ_TILES.wall).build();

        // Bricks
        LARGE_BRICK = register(BlockTypes.LARGE_BRICKS.block).wall(WallTypes.LARGE_BRICKS.wall).build();
        SOAKED_BRICK = register(BlockTypes.SOAKED_BRICKS.block).wall(WallTypes.SOAKED_BRICKS.wall).build();
        SANDY_BRICK = register(BlockTypes.SANDY_BRICKS.block).wall(WallTypes.SANDY_BRICKS.wall).build();
        CHARRED_BRICK = register(BlockTypes.CHARRED_BRICKS.block).wall(WallTypes.CHARRED_BRICKS.wall).build();
        HONEYCOMB_BRICK = register(BlockTypes.HONEYCOMB_BRICKS.block).wall(WallTypes.HONEYCOMB_BRICKS.wall).build();

        // Sandstone
        SANDSTONE_BRICK = register(BlockTypes.SANDSTONE_BRICKS.block).wall(WallTypes.SANDSTONE_BRICKS.wall).build();
        SMALL_SANDSTONE_BRICK = register(BlockTypes.SMALL_SANDSTONE_BRICKS.block).wall(WallTypes.SMALL_SANDSTONE_BRICKS.wall).build();
        RED_SANDSTONE_BRICK = register(BlockTypes.RED_SANDSTONE_BRICKS.block).wall(WallTypes.RED_SANDSTONE_BRICKS.wall).build();
        SMALL_RED_SANDSTONE_BRICK = register(BlockTypes.SMALL_RED_SANDSTONE_BRICKS.block).wall(WallTypes.SMALL_RED_SANDSTONE_BRICKS.wall).build();
        SOUL_SANDSTONE = register(BlockTypes.SOUL_SANDSTONE.block).wall(WallTypes.SOUL_SANDSTONE.wall).build();
        SOUL_SANDSTONE_BRICK = register(BlockTypes.SOUL_SANDSTONE_BRICKS.block).wall(WallTypes.SOUL_SANDSTONE_BRICKS.wall).build();
        SMALL_SOUL_SANDSTONE_BRICK = register(BlockTypes.SMALL_SOUL_SANDSTONE_BRICKS.block).wall(WallTypes.SMALL_SOUL_SANDSTONE_BRICKS.wall).build();
        SMOOTH_SOUL_SANDSTONE = register(BlockTypes.SMOOTH_SOUL_SANDSTONE.block).build();
        CUT_SOUL_SANDSTONE = register(BlockusBlocks.CUT_SOUL_SANDSTONE).slab(BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB).build();

        // Purpur & End Stone
        PURPUR_BRICK = register(BlockTypes.PURPUR_BRICKS.block).wall(WallTypes.PURPUR_BRICKS.wall).build();
        SMALL_PURPUR_BRICK = register(BlockTypes.SMALL_PURPUR_BRICKS.block).wall(WallTypes.SMALL_PURPUR_BRICKS.wall).build();
        PHANTOM_PURPUR_BLOCK = register(BlockTypes.PHANTOM_PURPUR_BLOCK.block).polished(BlockTypes.POLISHED_PHANTOM_PURPUR.block).build();
        PHANTOM_PURPUR_BRICK = register(BlockTypes.PHANTOM_PURPUR_BRICKS.block).wall(WallTypes.PHANTOM_PURPUR_BRICKS.wall).build();
        SMALL_PHANTOM_PURPUR_BRICK = register(BlockTypes.SMALL_PHANTOM_PURPUR_BRICKS.block).wall(WallTypes.SMALL_PHANTOM_PURPUR_BRICKS.wall).build();
        POLISHED_END_STONE = register(BlockTypes.POLISHED_END_STONE.block).pressurePlate(BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_END_STONE_BUTTON).build();
        SMALL_END_STONE_BRICK = register(BlockTypes.SMALL_END_STONE_BRICKS.block).wall(WallTypes.SMALL_END_STONE_BRICKS.wall).build();

        // Rainbow Bricks
        RAINBOW_BRICK = register(BlockTypes.RAINBOW_BRICKS.block).wall(WallTypes.RAINBOW_BRICKS.wall).build();

        // Stained Stone Bricks
        WHITE_STONE_BRICK = register(BlockTypes.WHITE_STONE_BRICKS.block).wall(WallTypes.WHITE_STONE_BRICKS.wall).build();
        ORANGE_STONE_BRICK = register(BlockTypes.ORANGE_STONE_BRICKS.block).wall(WallTypes.ORANGE_STONE_BRICKS.wall).build();
        MAGENTA_STONE_BRICK = register(BlockTypes.MAGENTA_STONE_BRICKS.block).wall(WallTypes.MAGENTA_STONE_BRICKS.wall).build();
        LIGHT_BLUE_STONE_BRICK = register(BlockTypes.LIGHT_BLUE_STONE_BRICKS.block).wall(WallTypes.LIGHT_BLUE_STONE_BRICKS.wall).build();
        YELLOW_STONE_BRICK = register(BlockTypes.YELLOW_STONE_BRICKS.block).wall(WallTypes.YELLOW_STONE_BRICKS.wall).build();
        LIME_STONE_BRICK = register(BlockTypes.LIME_STONE_BRICKS.block).wall(WallTypes.LIME_STONE_BRICKS.wall).build();
        PINK_STONE_BRICK = register(BlockTypes.PINK_STONE_BRICKS.block).wall(WallTypes.PINK_STONE_BRICKS.wall).build();
        GRAY_STONE_BRICK = register(BlockTypes.GRAY_STONE_BRICKS.block).wall(WallTypes.GRAY_STONE_BRICKS.wall).build();
        CYAN_STONE_BRICK = register(BlockTypes.CYAN_STONE_BRICKS.block).wall(WallTypes.CYAN_STONE_BRICKS.wall).build();
        PURPLE_STONE_BRICK = register(BlockTypes.PURPLE_STONE_BRICKS.block).wall(WallTypes.PURPLE_STONE_BRICKS.wall).build();
        BLUE_STONE_BRICK = register(BlockTypes.BLUE_STONE_BRICKS.block).wall(WallTypes.BLUE_STONE_BRICKS.wall).build();
        BROWN_STONE_BRICK = register(BlockTypes.BROWN_STONE_BRICKS.block).wall(WallTypes.BROWN_STONE_BRICKS.wall).build();
        GREEN_STONE_BRICK = register(BlockTypes.GREEN_STONE_BRICKS.block).wall(WallTypes.GREEN_STONE_BRICKS.wall).build();
        RED_STONE_BRICK = register(BlockTypes.RED_STONE_BRICKS.block).wall(WallTypes.RED_STONE_BRICKS.wall).build();
        BLACK_STONE_BRICK = register(BlockTypes.BLACK_STONE_BRICKS.block).wall(WallTypes.BLACK_STONE_BRICKS.wall).build();

        // Concrete Bricks
        WHITE_CONCRETE_BRICK = register(BlockTypes.WHITE_CONCRETE_BRICKS.block).wall(WallTypes.WHITE_CONCRETE_BRICKS.wall).build();
        ORANGE_CONCRETE_BRICK = register(BlockTypes.ORANGE_CONCRETE_BRICKS.block).wall(WallTypes.ORANGE_CONCRETE_BRICKS.wall).build();
        MAGENTA_CONCRETE_BRICK = register(BlockTypes.MAGENTA_CONCRETE_BRICKS.block).wall(WallTypes.MAGENTA_CONCRETE_BRICKS.wall).build();
        LIGHT_BLUE_CONCRETE_BRICK = register(BlockTypes.LIGHT_BLUE_CONCRETE_BRICKS.block).wall(WallTypes.LIGHT_BLUE_CONCRETE_BRICKS.wall).build();
        YELLOW_CONCRETE_BRICK = register(BlockTypes.YELLOW_CONCRETE_BRICKS.block).wall(WallTypes.YELLOW_CONCRETE_BRICKS.wall).build();
        LIME_CONCRETE_BRICK = register(BlockTypes.LIME_CONCRETE_BRICKS.block).wall(WallTypes.LIME_CONCRETE_BRICKS.wall).build();
        PINK_CONCRETE_BRICK = register(BlockTypes.PINK_CONCRETE_BRICKS.block).wall(WallTypes.PINK_CONCRETE_BRICKS.wall).build();
        GRAY_CONCRETE_BRICK = register(BlockTypes.GRAY_CONCRETE_BRICKS.block).wall(WallTypes.GRAY_CONCRETE_BRICKS.wall).build();
        LIGHT_GRAY_CONCRETE_BRICK = register(BlockTypes.LIGHT_GRAY_CONCRETE_BRICKS.block).wall(WallTypes.LIGHT_GRAY_CONCRETE_BRICKS.wall).build();
        CYAN_CONCRETE_BRICK = register(BlockTypes.CYAN_CONCRETE_BRICKS.block).wall(WallTypes.CYAN_CONCRETE_BRICKS.wall).build();
        PURPLE_CONCRETE_BRICK = register(BlockTypes.PURPLE_CONCRETE_BRICKS.block).wall(WallTypes.PURPLE_CONCRETE_BRICKS.wall).build();
        BLUE_CONCRETE_BRICK = register(BlockTypes.BLUE_CONCRETE_BRICKS.block).wall(WallTypes.BLUE_CONCRETE_BRICKS.wall).build();
        BROWN_CONCRETE_BRICK = register(BlockTypes.BROWN_CONCRETE_BRICKS.block).wall(WallTypes.BROWN_CONCRETE_BRICKS.wall).build();
        GREEN_CONCRETE_BRICK = register(BlockTypes.GREEN_CONCRETE_BRICKS.block).wall(WallTypes.GREEN_CONCRETE_BRICKS.wall).build();
        RED_CONCRETE_BRICK = register(BlockTypes.RED_CONCRETE_BRICKS.block).wall(WallTypes.RED_CONCRETE_BRICKS.wall).build();
        BLACK_CONCRETE_BRICK = register(BlockTypes.BLACK_CONCRETE_BRICKS.block).wall(WallTypes.BLACK_CONCRETE_BRICKS.wall).build();

        // Other
        PAPER_WALL = register(BlockusBlocks.PAPER_WALL).door(BlockusBlocks.PAPER_DOOR).trapdoor(BlockusBlocks.PAPER_TRAPDOOR).build();
        NETHERITE_BLOCK = register(Blocks.NETHERITE_BLOCK).stairs(BlockusBlocks.NETHERITE_STAIRS).slab(BlockusBlocks.NETHERITE_SLAB).build();

    }

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = (BlockFamily)BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
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

