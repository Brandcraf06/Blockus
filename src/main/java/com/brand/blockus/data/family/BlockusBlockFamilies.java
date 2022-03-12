package com.brand.blockus.data.family;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.types.BSSTypes;
import com.brand.blockus.content.types.BSSWTypes;
import com.brand.blockus.content.types.WoodTypesB;
import com.brand.blockus.content.types.WoodTypesNB;
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
        WHITE_OAK = register(WoodTypesB.WHITE_OAK.planks).button(WoodTypesB.WHITE_OAK.button).fence(WoodTypesB.WHITE_OAK.fence).fenceGate(WoodTypesB.WHITE_OAK.fence_gate).pressurePlate(WoodTypesB.WHITE_OAK.pressure_plate).sign(WoodTypesB.WHITE_OAK.standing_sign, WoodTypesB.WHITE_OAK.wall_sign).slab(WoodTypesB.WHITE_OAK.slab).stairs(WoodTypesB.WHITE_OAK.stairs).door(WoodTypesB.WHITE_OAK.door).trapdoor(WoodTypesB.WHITE_OAK.trapdoor).group("wooden").unlockCriterionName("has_planks").build();
        CHARRED = register(WoodTypesNB.CHARRED.planks).button(WoodTypesNB.CHARRED.button).fence(WoodTypesNB.CHARRED.fence).fenceGate(WoodTypesNB.CHARRED.fence_gate).pressurePlate(WoodTypesNB.CHARRED.pressure_plate).sign(WoodTypesNB.CHARRED.standing_sign, WoodTypesNB.CHARRED.wall_sign).slab(WoodTypesNB.CHARRED.slab).stairs(WoodTypesNB.CHARRED.stairs).door(WoodTypesNB.CHARRED.door).trapdoor(WoodTypesNB.CHARRED.trapdoor).group("wooden").unlockCriterionName("has_planks").build();
        BAMBOO = register(WoodTypesB.BAMBOO.planks).button(WoodTypesB.BAMBOO.button).fence(WoodTypesB.BAMBOO.fence).fenceGate(WoodTypesB.BAMBOO.fence_gate).pressurePlate(WoodTypesB.BAMBOO.pressure_plate).sign(WoodTypesB.BAMBOO.standing_sign, WoodTypesB.BAMBOO.wall_sign).slab(WoodTypesB.BAMBOO.slab).stairs(WoodTypesB.BAMBOO.stairs).door(WoodTypesB.BAMBOO.door).trapdoor(WoodTypesB.BAMBOO.trapdoor).group("wooden").unlockCriterionName("has_planks").build();

        // Stone, Andesite, Diorite, Granite, Dripstone, Tuff, Deepslate, Blackstone & Basalt
        STONE = register(Blocks.STONE).door(BlockusBlocks.STONE_DOOR).trapdoor(BlockusBlocks.STONE_TRAPDOOR).build();
        POLISHED_ANDESITE = register(Blocks.POLISHED_ANDESITE).pressurePlate(BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_ANDESITE_BUTTON).polished(BSSWTypes.ANDESITE_BRICKS.block).build();
        ANDESITE_BRICK = register(BSSWTypes.ANDESITE_BRICKS.block).cracked(BlockusBlocks.CRACKED_ANDESITE_BRICKS).build();
        POLISHED_DIORITE = register(Blocks.POLISHED_DIORITE).pressurePlate(BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_DIORITE_BUTTON).polished(BSSWTypes.DIORITE_BRICKS.block).build();
        DIORITE_BRICK = register(BSSWTypes.DIORITE_BRICKS.block).cracked(BlockusBlocks.CRACKED_DIORITE_BRICKS).build();
        POLISHED_GRANITE = register(Blocks.POLISHED_GRANITE).pressurePlate(BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_GRANITE_BUTTON).polished(BSSWTypes.GRANITE_BRICKS.block).build();
        GRANITE_BRICK = register(BSSWTypes.GRANITE_BRICKS.block).cracked(BlockusBlocks.CRACKED_GRANITE_BRICKS).build();
        POLISHED_DRIPSTONE = register(BSSTypes.POLISHED_DRIPSTONE.block).polished(BSSWTypes.DRIPSTONE_BRICKS.block).build();
        DRIPSTONE_BRICK = register(BSSWTypes.DRIPSTONE_BRICKS.block).cracked(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS).build();
        POLISHED_TUFF = register(BSSTypes.POLISHED_TUFF.block).pressurePlate(BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_TUFF_BUTTON).polished(BSSWTypes.TUFF_BRICKS.block).build();
        TUFF_BRICK = register(BSSWTypes.TUFF_BRICKS.block).cracked(BlockusBlocks.CRACKED_TUFF_BRICKS).build();
        POLISHED_DEEPSLATE = register(Blocks.POLISHED_DEEPSLATE).pressurePlate(BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_DEEPSLATE_BUTTON).build();
        POLISHED_AMETHYST = register(BlockusBlocks.POLISHED_AMETHYST).stairs(BlockusBlocks.POLISHED_AMETHYST_STAIRS).slab(BlockusBlocks.POLISHED_AMETHYST_SLAB).polished(BlockusBlocks.AMETHYST_BRICKS).build();
        AMETHYST_BRICK = register(BlockusBlocks.AMETHYST_BRICKS).wall(BlockusBlocks.AMETHYST_BRICK_WALL).stairs(BlockusBlocks.AMETHYST_BRICK_STAIRS).slab(BlockusBlocks.AMETHYST_BRICK_SLAB).build();
        BLACKSTONE = register(Blocks.BLACKSTONE).door(BlockusBlocks.BLACKSTONE_DOOR).trapdoor(BlockusBlocks.BLACKSTONE_TRAPDOOR).build();
        POLISHED_BASALT = register(Blocks.POLISHED_BASALT).pressurePlate(BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_BASALT_BUTTON).polished(BSSWTypes.POLISHED_BASALT_BRICKS.block).build();
        POLISHED_BASALT_BRICK = register(BSSWTypes.POLISHED_BASALT_BRICKS.block).cracked(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS).build();

        // Limestone, Marble & Bluestone
        LIMESTONE = register(BSSWTypes.LIMESTONE.block).pressurePlate(BlockusBlocks.LIMESTONE_PRESSURE_PLATE).button(BlockusBlocks.LIMESTONE_BUTTON).polished(BSSTypes.POLISHED_LIMESTONE.block).build();
        MARBLE = register(BSSWTypes.MARBLE.block).pressurePlate(BlockusBlocks.MARBLE_PRESSURE_PLATE).button(BlockusBlocks.MARBLE_BUTTON).polished(BSSTypes.POLISHED_MARBLE.block).build();
        BLUESTONE = register(BSSWTypes.BLUESTONE.block).pressurePlate(BlockusBlocks.BLUESTONE_PRESSURE_PLATE).button(BlockusBlocks.BLUESTONE_BUTTON).polished(BSSTypes.POLISHED_BLUESTONE.block).build();

        // Snow & Ice Bricks
        SNOW_BRICK = register(BlockusBlocks.SNOW_BRICKS).wall(BlockusBlocks.SNOW_BRICK_WALL).stairs(BlockusBlocks.SNOW_BRICK_STAIRS).slab(BlockusBlocks.SNOW_BRICK_SLAB).build();
        ICE_BRICK = register(BlockusBlocks.ICE_BRICKS).wall(BlockusBlocks.ICE_BRICK_WALL).build();

        // Netherrack
        POLISHED_NETHERRACK = register(BSSTypes.POLISHED_NETHERRACK.block).pressurePlate(BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_NETHERRACK_BUTTON).build();

        // Obsidian
        OBSIDIAN = register(Blocks.OBSIDIAN).door(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR).trapdoor(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR).build();
        OBSIDIAN_BRICK = register(BSSWTypes.OBSIDIAN_BRICKS.block).cracked(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS).build();

        // Sandstone
        CUT_SOUL_SANDSTONE = register(BlockusBlocks.CUT_SOUL_SANDSTONE).slab(BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB).build();

        // Purpur & End Stone
        PHANTOM_PURPUR_BLOCK = register(BSSTypes.PHANTOM_PURPUR_BLOCK.block).polished(BSSTypes.POLISHED_PHANTOM_PURPUR.block).build();
        POLISHED_END_STONE = register(BSSTypes.POLISHED_END_STONE.block).pressurePlate(BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE).button(BlockusBlocks.POLISHED_END_STONE_BUTTON).build();

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

