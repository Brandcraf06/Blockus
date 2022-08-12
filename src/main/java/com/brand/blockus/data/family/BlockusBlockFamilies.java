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
    public static final BlockFamily POLISHED_AMETHYST;
    public static final BlockFamily AMETHYST_BRICK;
    public static final BlockFamily BLACKSTONE;
    public static final BlockFamily POLISHED_BASALT;
    public static final BlockFamily POLISHED_BASALT_BRICK;
    public static final BlockFamily LIMESTONE;
    public static final BlockFamily MARBLE;
    public static final BlockFamily BLUESTONE;
    public static final BlockFamily VIRIDITE;
    public static final BlockFamily SNOW_BRICK;
    public static final BlockFamily ICE_BRICK;
    public static final BlockFamily POLISHED_NETHERRACK;
    public static final BlockFamily OBSIDIAN;
    public static final BlockFamily OBSIDIAN_BRICK;
    public static final BlockFamily CUT_SOUL_SANDSTONE;
    public static final BlockFamily PHANTOM_PURPUR_BLOCK;
    public static final BlockFamily POLISHED_END_STONE;
    public static final BlockFamily PAPER_WALL;
    public static final BlockFamily NETHERITE_BLOCK;

    static {
        // Woods
        WHITE_OAK = register(BlockusBlocks.WHITE_OAK.planks).button(BlockusBlocks.WHITE_OAK.button).fence(BlockusBlocks.WHITE_OAK.fence).fenceGate(BlockusBlocks.WHITE_OAK.fence_gate).pressurePlate(BlockusBlocks.WHITE_OAK.pressure_plate).sign(BlockusBlocks.WHITE_OAK.standing_sign, BlockusBlocks.WHITE_OAK.wall_sign).slab(BlockusBlocks.WHITE_OAK.slab).stairs(BlockusBlocks.WHITE_OAK.stairs).door(BlockusBlocks.WHITE_OAK.door).trapdoor(BlockusBlocks.WHITE_OAK.trapdoor).group("wooden").unlockCriterionName("has_planks").build();
        CHARRED = register(BlockusBlocks.CHARRED.planks).button(BlockusBlocks.CHARRED.button).fence(BlockusBlocks.CHARRED.fence).fenceGate(BlockusBlocks.CHARRED.fence_gate).pressurePlate(BlockusBlocks.CHARRED.pressure_plate).sign(BlockusBlocks.CHARRED.standing_sign, BlockusBlocks.CHARRED.wall_sign).slab(BlockusBlocks.CHARRED.slab).stairs(BlockusBlocks.CHARRED.stairs).door(BlockusBlocks.CHARRED.door).trapdoor(BlockusBlocks.CHARRED.trapdoor).group("wooden").unlockCriterionName("has_planks").build();
        BAMBOO = register(BlockusBlocks.BAMBOO.planks).button(BlockusBlocks.BAMBOO.button).fence(BlockusBlocks.BAMBOO.fence).fenceGate(BlockusBlocks.BAMBOO.fence_gate).pressurePlate(BlockusBlocks.BAMBOO.pressure_plate).sign(BlockusBlocks.BAMBOO.standing_sign, BlockusBlocks.BAMBOO.wall_sign).slab(BlockusBlocks.BAMBOO.slab).stairs(BlockusBlocks.BAMBOO.stairs).door(BlockusBlocks.BAMBOO.door).trapdoor(BlockusBlocks.BAMBOO.trapdoor).group("wooden").unlockCriterionName("has_planks").build();

        // Stone, Andesite, Diorite, Granite, Dripstone, Tuff, Deepslate, Blackstone & Basalt
        STONE = register(Blocks.STONE).door(BlockusBlocks.STONE_DOOR).trapdoor(BlockusBlocks.STONE_TRAPDOOR).build();
        POLISHED_ANDESITE = register(Blocks.POLISHED_ANDESITE).pressurePlate(BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_ANDESITE_BUTTON).polished(BlockusBlocks.ANDESITE_BRICKS.block).build();
        ANDESITE_BRICK = register(BlockusBlocks.ANDESITE_BRICKS.block).cracked(BlockusBlocks.CRACKED_ANDESITE_BRICKS).build();
        POLISHED_DIORITE = register(Blocks.POLISHED_DIORITE).pressurePlate(BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_DIORITE_BUTTON).polished(BlockusBlocks.DIORITE_BRICKS.block).build();
        DIORITE_BRICK = register(BlockusBlocks.DIORITE_BRICKS.block).cracked(BlockusBlocks.CRACKED_DIORITE_BRICKS).build();
        POLISHED_GRANITE = register(Blocks.POLISHED_GRANITE).pressurePlate(BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_GRANITE_BUTTON).polished(BlockusBlocks.GRANITE_BRICKS.block).build();
        GRANITE_BRICK = register(BlockusBlocks.GRANITE_BRICKS.block).cracked(BlockusBlocks.CRACKED_GRANITE_BRICKS).build();
        POLISHED_DRIPSTONE = register(BlockusBlocks.POLISHED_DRIPSTONE.block).polished(BlockusBlocks.DRIPSTONE_BRICKS.block).build();
        DRIPSTONE_BRICK = register(BlockusBlocks.DRIPSTONE_BRICKS.block).cracked(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS).build();
        POLISHED_TUFF = register(BlockusBlocks.POLISHED_TUFF.block).pressurePlate(BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_TUFF_BUTTON).polished(BlockusBlocks.TUFF_BRICKS.block).build();
        TUFF_BRICK = register(BlockusBlocks.TUFF_BRICKS.block).cracked(BlockusBlocks.CRACKED_TUFF_BRICKS).build();
        POLISHED_DEEPSLATE = register(Blocks.POLISHED_DEEPSLATE).pressurePlate(BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_DEEPSLATE_BUTTON).build();
        POLISHED_AMETHYST = register(BlockusBlocks.POLISHED_AMETHYST).stairs(BlockusBlocks.POLISHED_AMETHYST_STAIRS).slab(BlockusBlocks.POLISHED_AMETHYST_SLAB).polished(BlockusBlocks.AMETHYST_BRICKS).build();
        AMETHYST_BRICK = register(BlockusBlocks.AMETHYST_BRICKS).wall(BlockusBlocks.AMETHYST_BRICK_WALL).stairs(BlockusBlocks.AMETHYST_BRICK_STAIRS).slab(BlockusBlocks.AMETHYST_BRICK_SLAB).build();
        BLACKSTONE = register(Blocks.BLACKSTONE).door(BlockusBlocks.BLACKSTONE_DOOR).build();
        POLISHED_BASALT = register(Blocks.POLISHED_BASALT).pressurePlate(BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_BASALT_BUTTON).polished(BlockusBlocks.POLISHED_BASALT_BRICKS.block).build();
        POLISHED_BASALT_BRICK = register(BlockusBlocks.POLISHED_BASALT_BRICKS.block).cracked(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS).build();

        // Limestone, Marble & Bluestone
        LIMESTONE = register(BlockusBlocks.LIMESTONE.block).pressurePlate(BlockusBlocks.LIMESTONE_PRESSURE_PLATE).button(BlockusBlocks.LIMESTONE_BUTTON).polished(BlockusBlocks.POLISHED_LIMESTONE.block).build();
        MARBLE = register(BlockusBlocks.MARBLE.block).pressurePlate(BlockusBlocks.MARBLE_PRESSURE_PLATE).button(BlockusBlocks.MARBLE_BUTTON).polished(BlockusBlocks.POLISHED_MARBLE.block).build();
        BLUESTONE = register(BlockusBlocks.BLUESTONE.block).pressurePlate(BlockusBlocks.BLUESTONE_PRESSURE_PLATE).button(BlockusBlocks.BLUESTONE_BUTTON).polished(BlockusBlocks.POLISHED_BLUESTONE.block).build();
        VIRIDITE = register(BlockusBlocks.VIRIDITE.block).pressurePlate(BlockusBlocks.VIRIDITE_PRESSURE_PLATE).button(BlockusBlocks.VIRIDITE_BUTTON).polished(BlockusBlocks.POLISHED_VIRIDITE.block).build();

        // Snow & Ice Bricks
        SNOW_BRICK = register(BlockusBlocks.SNOW_BRICKS).wall(BlockusBlocks.SNOW_BRICK_WALL).stairs(BlockusBlocks.SNOW_BRICK_STAIRS).slab(BlockusBlocks.SNOW_BRICK_SLAB).build();
        ICE_BRICK = register(BlockusBlocks.ICE_BRICKS).wall(BlockusBlocks.ICE_BRICK_WALL).build();

        // Netherrack
        POLISHED_NETHERRACK = register(BlockusBlocks.POLISHED_NETHERRACK.block).pressurePlate(BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_NETHERRACK_BUTTON).build();

        // Obsidian
        OBSIDIAN = register(Blocks.OBSIDIAN).door(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR).trapdoor(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR).build();
        OBSIDIAN_BRICK = register(BlockusBlocks.OBSIDIAN_BRICKS.block).cracked(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS).build();

        // Sandstone
        CUT_SOUL_SANDSTONE = register(BlockusBlocks.CUT_SOUL_SANDSTONE).slab(BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB).build();

        // Purpur & End Stone
        PHANTOM_PURPUR_BLOCK = register(BlockusBlocks.PHANTOM_PURPUR_BLOCK.block).polished(BlockusBlocks.POLISHED_PHANTOM_PURPUR.block).build();
        POLISHED_END_STONE = register(BlockusBlocks.POLISHED_END_STONE.block).pressurePlate(BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_END_STONE_BUTTON).build();

        // Other
        PAPER_WALL = register(BlockusBlocks.PAPER_WALL).door(BlockusBlocks.PAPER_DOOR).trapdoor(BlockusBlocks.PAPER_TRAPDOOR).build();
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

