package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.blockitems.NetherStarBlockItem;
import com.brand.blockus.blocks.blockitems.SpeedBlockItem;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class BlockusItems {

    // Stone
    public static final Item STONE_BRICK_PILLAR = register(BlockusBlocks.STONE_BRICK_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_STONE_BRICKS = register(BlockusBlocks.ZIGZAGGED_STONE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item STONE_CIRCLE_PAVEMENT = register(BlockusBlocks.STONE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item STONE_DOOR = register(BlockusBlocks.STONE_DOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item STONE_TRAPDOOR = register(BlockusBlocks.STONE_TRAPDOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item SMOOTH_STONE_STAIRS = register(BlockusBlocks.SMOOTH_STONE_STAIRS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item STURDY_STONE = register(BlockusBlocks.STURDY_STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Andesite
    public static final Item ZIGZAGGED_ANDESITE = register(BlockusBlocks.ZIGZAGGED_ANDESITE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_ANDESITE_BRICKS = register(BlockusBlocks.CHISELED_ANDESITE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CRACKED_ANDESITE_BRICKS = register(BlockusBlocks.CRACKED_ANDESITE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POLISHED_ANDESITE_PILLAR = register(BlockusBlocks.POLISHED_ANDESITE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ANDESITE_CIRCLE_PAVEMENT = register(BlockusBlocks.ANDESITE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Diorite
    public static final Item ZIGZAGGED_DIORITE = register(BlockusBlocks.ZIGZAGGED_DIORITE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_DIORITE_BRICKS = register(BlockusBlocks.CHISELED_DIORITE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CRACKED_DIORITE_BRICKS = register(BlockusBlocks.CRACKED_DIORITE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POLISHED_DIORITE_PILLAR = register(BlockusBlocks.POLISHED_DIORITE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item DIORITE_CIRCLE_PAVEMENT = register(BlockusBlocks.DIORITE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Granite
    public static final Item ZIGZAGGED_GRANITE = register(BlockusBlocks.ZIGZAGGED_GRANITE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_GRANITE_BRICKS = register(BlockusBlocks.CHISELED_GRANITE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CRACKED_GRANITE_BRICKS = register(BlockusBlocks.CRACKED_GRANITE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POLISHED_GRANITE_PILLAR = register(BlockusBlocks.POLISHED_GRANITE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRANITE_CIRCLE_PAVEMENT = register(BlockusBlocks.GRANITE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Dripstone
    public static final Item CRACKED_DRIPSTONE_BRICKS = register(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_DRIPSTONE = register(BlockusBlocks.CHISELED_DRIPSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item DRIPSTONE_PILLAR = register(BlockusBlocks.DRIPSTONE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Tuff
    public static final Item CRACKED_TUFF_BRICKS = register(BlockusBlocks.CRACKED_TUFF_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_TUFF = register(BlockusBlocks.CHISELED_TUFF, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item TUFF_PILLAR = register(BlockusBlocks.TUFF_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_TUFF = register(BlockusBlocks.ZIGZAGGED_TUFF, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item TUFF_CIRCLE_PAVEMENT = register(BlockusBlocks.TUFF_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Deepslate
    public static final Item DEEPSLATE_PILLAR = register(BlockusBlocks.DEEPSLATE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_DEEPSLATE = register(BlockusBlocks.ZIGZAGGED_DEEPSLATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item DEEPSLATE_CIRCLE_PAVEMENT = register(BlockusBlocks.DEEPSLATE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item STURDY_DEEPSLATE = register(BlockusBlocks.STURDY_DEEPSLATE, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Amethyst
    public static final Item POLISHED_AMETHYST = register(BlockusBlocks.POLISHED_AMETHYST, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POLISHED_AMETHYST_STAIRS = register(BlockusBlocks.POLISHED_AMETHYST_STAIRS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POLISHED_AMETHYST_SLAB = register(BlockusBlocks.POLISHED_AMETHYST_SLAB, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item AMETHYST_BRICKS = register(BlockusBlocks.AMETHYST_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item AMETHYST_BRICK_STAIRS = register(BlockusBlocks.AMETHYST_BRICK_STAIRS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item AMETHYST_BRICK_SLAB = register(BlockusBlocks.AMETHYST_BRICK_SLAB, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item AMETHYST_BRICK_WALL = register(BlockusBlocks.AMETHYST_BRICK_WALL, Blockus.BLOCKUS_DECORATIONS);
    public static final Item CHISELED_AMETHYST = register(BlockusBlocks.CHISELED_AMETHYST, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item AMETHYST_PILLAR = register(BlockusBlocks.AMETHYST_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Blackstone
    public static final Item POLISHED_BLACKSTONE_PILLAR = register(BlockusBlocks.POLISHED_BLACKSTONE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_POLISHED_BLACKSTONE = register(BlockusBlocks.ZIGZAGGED_POLISHED_BLACKSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POLISHED_BLACKSTONE_CIRCLE_PAVEMENT = register(BlockusBlocks.POLISHED_BLACKSTONE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GOLD_DECORATED_POLISHED_BLACKSTONE = register(BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item STURDY_BLACKSTONE = register(BlockusBlocks.STURDY_BLACKSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACKSTONE_DOOR = register(BlockusBlocks.BLACKSTONE_DOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item BLACKSTONE_TRAPDOOR = register(BlockusBlocks.BLACKSTONE_TRAPDOOR, Blockus.BLOCKUS_REDSTONE);

    // Basalt
    public static final Item CRACKED_POLISHED_BASALT_BRICKS = register(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POLISHED_BASALT_PILLAR = register(BlockusBlocks.POLISHED_BASALT_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_POLISHED_BASALT = register(BlockusBlocks.ZIGZAGGED_POLISHED_BASALT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_POLISHED_BASALT = register(BlockusBlocks.CHISELED_POLISHED_BASALT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POLISHED_BASALT_CIRCLE_PAVEMENT = register(BlockusBlocks.POLISHED_BASALT_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);


    // Limestone
    public static final Item LIMESTONE_PILLAR = register(BlockusBlocks.LIMESTONE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIMESTONE_SQUARES = register(BlockusBlocks.LIMESTONE_SQUARES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_LIMESTONE = register(BlockusBlocks.CHISELED_LIMESTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIMESTONE_CIRCLE_PAVEMENT = register(BlockusBlocks.LIMESTONE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Marble
    public static final Item MARBLE_PILLAR = register(BlockusBlocks.MARBLE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MARBLE_SQUARES = register(BlockusBlocks.MARBLE_SQUARES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_MARBLE = register(BlockusBlocks.CHISELED_MARBLE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_MARBLE_PILLAR = register(BlockusBlocks.CHISELED_MARBLE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MARBLE_CIRCLE_PAVEMENT = register(BlockusBlocks.MARBLE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Bluestone
    public static final Item BLUESTONE_PILLAR = register(BlockusBlocks.BLUESTONE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUESTONE_SQUARES = register(BlockusBlocks.BLUESTONE_SQUARES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_BLUESTONE = register(BlockusBlocks.CHISELED_BLUESTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUESTONE_CIRCLE_PAVEMENT = register(BlockusBlocks.BLUESTONE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUESTONE_LINES = register(BlockusBlocks.BLUESTONE_LINES, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Lava	Bricks
    public static final Item CHISELED_LAVA_BRICKS = register(BlockusBlocks.CHISELED_LAVA_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Lava Blackstone Bricks
    public static final Item CHISELED_LAVA_POLISHED_BLACKSTONE = register(BlockusBlocks.CHISELED_LAVA_POLISHED_BLACKSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Water Bricks
    public static final Item CHISELED_WATER_BRICKS = register(BlockusBlocks.CHISELED_WATER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Snow Bricks
    public static final Item SNOW_BRICKS = register(BlockusBlocks.SNOW_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SNOW_BRICK_STAIRS = register(BlockusBlocks.SNOW_BRICK_STAIRS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SNOW_BRICK_SLAB = register(BlockusBlocks.SNOW_BRICK_SLAB, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SNOW_BRICK_WALL = register(BlockusBlocks.SNOW_BRICK_WALL, Blockus.BLOCKUS_DECORATIONS);
    public static final Item SNOW_PILLAR = register(BlockusBlocks.SNOW_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Packed Ice Bricks
    public static final Item ICE_BRICKS = register(BlockusBlocks.ICE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ICE_BRICK_WALL = register(BlockusBlocks.ICE_BRICK_WALL, Blockus.BLOCKUS_DECORATIONS);
    public static final Item ICE_PILLAR = register(BlockusBlocks.ICE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Magma Bricks
    public static final Item CHISELED_MAGMA_BRICKS = register(BlockusBlocks.CHISELED_MAGMA_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Blaze Bricks
    public static final Item BLAZE_PILLAR = register(BlockusBlocks.BLAZE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLAZE_LANTERN = register(BlockusBlocks.BLAZE_LANTERN, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Netherrack
    public static final Item NETHERRACK_CIRCLE_PAVEMENT = register(BlockusBlocks.NETHERRACK_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Nether Bricks
    public static final Item POLISHED_NETHER_BRICKS = register(BlockusBlocks.POLISHED_NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POLISHED_RED_NETHER_BRICKS = register(BlockusBlocks.POLISHED_RED_NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_NETHER_BRICKS = register(BlockusBlocks.ZIGZAGGED_NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_RED_NETHER_BRICKS = register(BlockusBlocks.ZIGZAGGED_RED_NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item NETHER_BRICK_PILLAR = register(BlockusBlocks.NETHER_BRICK_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_NETHER_BRICK_PILLAR = register(BlockusBlocks.RED_NETHER_BRICK_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Charred Nether Bricks
    public static final Item POLISHED_CHARRED_NETHER_BRICKS = register(BlockusBlocks.POLISHED_CHARRED_NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_CHARRED_NETHER_BRICKS = register(BlockusBlocks.ZIGZAGGED_CHARRED_NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHARRED_NETHER_BRICK_PILLAR = register(BlockusBlocks.CHARRED_NETHER_BRICK_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Teal Nether Bricks
    public static final Item POLISHED_TEAL_NETHER_BRICKS = register(BlockusBlocks.POLISHED_TEAL_NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_TEAL_NETHER_BRICKS = register(BlockusBlocks.ZIGZAGGED_TEAL_NETHER_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item TEAL_NETHER_BRICK_PILLAR = register(BlockusBlocks.TEAL_NETHER_BRICK_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Obsidian
    public static final Item CRACKED_OBSIDIAN_BRICKS = register(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item OBSIDIAN_PILLAR = register(BlockusBlocks.OBSIDIAN_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item OBSIDIAN_CIRCLE_PAVEMENT = register(BlockusBlocks.OBSIDIAN_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item OBSIDIAN_REINFORCED_DOOR = register(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item OBSIDIAN_REINFORCED_TRAPDOOR = register(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item GLOWING_OBSIDIAN = register(BlockusBlocks.GLOWING_OBSIDIAN, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Quartz Blocks
    public static final Item QUARTZ_CIRCLE_PAVEMENT = register(BlockusBlocks.QUARTZ_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Prismarine
    public static final Item CHISELED_PRISMARINE = register(BlockusBlocks.CHISELED_PRISMARINE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PRISMARINE_PILLAR = register(BlockusBlocks.PRISMARINE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PRISMARINE_CIRCLE_PAVEMENT = register(BlockusBlocks.PRISMARINE_CIRCLE_PAVEMENT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_DARK_PRISMARINE = register(BlockusBlocks.CHISELED_DARK_PRISMARINE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item DARK_PRISMARINE_PILLAR = register(BlockusBlocks.DARK_PRISMARINE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);


    // Bricks
    public static final Item ZIGZAGGED_BRICKS = register(BlockusBlocks.ZIGZAGGED_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Soaked Bricks
    public static final Item ZIGZAGGED_SOAKED_BRICKS = register(BlockusBlocks.ZIGZAGGED_SOAKED_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);


    // Sandy Bricks
    public static final Item ZIGZAGGED_SANDY_BRICKS = register(BlockusBlocks.ZIGZAGGED_SANDY_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);


    // Charred Bricks
    public static final Item ZIGZAGGED_CHARRED_BRICKS = register(BlockusBlocks.ZIGZAGGED_CHARRED_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);


    // Sandstone
    public static final Item SANDSTONE_PILLAR = register(BlockusBlocks.SANDSTONE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GOLD_DECORATED_SANDSTONE = register(BlockusBlocks.GOLD_DECORATED_SANDSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LAPIS_DECORATED_SANDSTONE = register(BlockusBlocks.LAPIS_DECORATED_SANDSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Red Sandstone
    public static final Item RED_SANDSTONE_PILLAR = register(BlockusBlocks.RED_SANDSTONE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GOLD_DECORATED_RED_SANDSTONE = register(BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LAPIS_DECORATED_RED_SANDSTONE = register(BlockusBlocks.LAPIS_DECORATED_RED_SANDSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Soul Sandstone
    public static final Item CUT_SOUL_SANDSTONE = register(BlockusBlocks.CUT_SOUL_SANDSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CUT_SOUL_SANDSTONE_SLAB = register(BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_SOUL_SANDSTONE = register(BlockusBlocks.CHISELED_SOUL_SANDSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SOUL_SANDSTONE_PILLAR = register(BlockusBlocks.SOUL_SANDSTONE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GOLD_DECORATED_SOUL_SANDSTONE = register(BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LAPIS_DECORATED_SOUL_SANDSTONE = register(BlockusBlocks.LAPIS_DECORATED_SOUL_SANDSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);


    // Honeycomb Bricks

    // Purpur Blocks
    public static final Item CHISELED_PURPUR = register(BlockusBlocks.CHISELED_PURPUR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPUR_SQUARES = register(BlockusBlocks.PURPUR_SQUARES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPUR_LINES = register(BlockusBlocks.PURPUR_LINES, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Phantom Purpur Blocks
    public static final Item PHANTOM_PURPUR_PILLAR = register(BlockusBlocks.PHANTOM_PURPUR_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_PHANTOM_PURPUR = register(BlockusBlocks.CHISELED_PHANTOM_PURPUR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PHANTOM_PURPUR_SQUARES = register(BlockusBlocks.PHANTOM_PURPUR_SQUARES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PHANTOM_PURPUR_LINES = register(BlockusBlocks.PHANTOM_PURPUR_LINES, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // End Stone
    public static final Item CHISELED_END_STONE_BRICKS = register(BlockusBlocks.CHISELED_END_STONE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ZIGZAGGED_END_STONE_BRICKS = register(BlockusBlocks.ZIGZAGGED_END_STONE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CRACKED_END_STONE_BRICKS = register(BlockusBlocks.CRACKED_END_STONE_BRICKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item END_STONE_PILLAR = register(BlockusBlocks.END_STONE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPUR_DECORATED_END_STONE = register(BlockusBlocks.PURPUR_DECORATED_END_STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PHANTOM_PURPUR_DECORATED_END_STONE = register(BlockusBlocks.PHANTOM_PURPUR_DECORATED_END_STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Bamboo Wood
    public static final Item BAMBOO_PLANKS = register(BlockusBlocks.BAMBOO_PLANKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BAMBOO_STAIRS = register(BlockusBlocks.BAMBOO_STAIRS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BAMBOO_SLAB = register(BlockusBlocks.BAMBOO_SLAB, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BAMBOO_FENCE = register(BlockusBlocks.BAMBOO_FENCE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item BAMBOO_FENCE_GATE = register(BlockusBlocks.BAMBOO_FENCE_GATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item BAMBOO_DOOR = register(BlockusBlocks.BAMBOO_DOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item BAMBOO_TRAPDOOR = register(BlockusBlocks.BAMBOO_TRAPDOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item BAMBOO_SIGN = register_sign(BlockusBlocks.BAMBOO_SIGN, BlockusBlocks.BAMBOO_WALL_SIGN);
    public static final Item BAMBOO_BOAT = register_boat("bamboo_boat", "bamboo");


    // Charred Wood
    public static final Item CHARRED_PLANKS = register(BlockusBlocks.CHARRED_PLANKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHARRED_STAIRS = register(BlockusBlocks.CHARRED_STAIRS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHARRED_SLAB = register(BlockusBlocks.CHARRED_SLAB, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHARRED_FENCE = register(BlockusBlocks.CHARRED_FENCE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item CHARRED_FENCE_GATE = register(BlockusBlocks.CHARRED_FENCE_GATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item CHARRED_DOOR = register(BlockusBlocks.CHARRED_DOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item CHARRED_TRAPDOOR = register(BlockusBlocks.CHARRED_TRAPDOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item CHARRED_SIGN = register_sign(BlockusBlocks.CHARRED_SIGN, BlockusBlocks.CHARRED_WALL_SIGN);
    public static final Item CHARRED_BOAT = register_boat("charred_boat", "charred");


    // White Oak Wood
    public static final Item WHITE_OAK_SAPLING = register(BlockusBlocks.WHITE_OAK_SAPLING, Blockus.BLOCKUS_DECORATIONS);
    public static final Item WHITE_OAK_LOG = register(BlockusBlocks.WHITE_OAK_LOG, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item STRIPPED_WHITE_OAK_LOG = register(BlockusBlocks.STRIPPED_WHITE_OAK_LOG, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_OAK_WOOD = register(BlockusBlocks.WHITE_OAK_WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item STRIPPED_WHITE_OAK_WOOD = register(BlockusBlocks.STRIPPED_WHITE_OAK_WOOD, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_OAK_LEAVES = register(BlockusBlocks.WHITE_OAK_LEAVES, Blockus.BLOCKUS_DECORATIONS);
    public static final Item WHITE_OAK_PLANKS = register(BlockusBlocks.WHITE_OAK_PLANKS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_OAK_STAIRS = register(BlockusBlocks.WHITE_OAK_STAIRS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_OAK_SLAB = register(BlockusBlocks.WHITE_OAK_SLAB, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_OAK_FENCE = register(BlockusBlocks.WHITE_OAK_FENCE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item WHITE_OAK_FENCE_GATE = register(BlockusBlocks.WHITE_OAK_FENCE_GATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item WHITE_OAK_DOOR = register(BlockusBlocks.WHITE_OAK_DOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item WHITE_OAK_TRAPDOOR = register(BlockusBlocks.WHITE_OAK_TRAPDOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item WHITE_OAK_SIGN = register_sign(BlockusBlocks.WHITE_OAK_SIGN, BlockusBlocks.WHITE_OAK_WALL_SIGN);
    public static final Item WHITE_OAK_BOAT = register_boat("white_oak_boat", "white_oak");


    // Small Logs
    public static final Item OAK_SMALL_LOGS = register(BlockusBlocks.OAK_SMALL_LOGS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SPRUCE_SMALL_LOGS = register(BlockusBlocks.SPRUCE_SMALL_LOGS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BIRCH_SMALL_LOGS = register(BlockusBlocks.BIRCH_SMALL_LOGS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item JUNGLE_SMALL_LOGS = register(BlockusBlocks.JUNGLE_SMALL_LOGS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ACACIA_SMALL_LOGS = register(BlockusBlocks.ACACIA_SMALL_LOGS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item DARK_OAK_SMALL_LOGS = register(BlockusBlocks.DARK_OAK_SMALL_LOGS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WARPED_SMALL_STEMS = register(BlockusBlocks.WARPED_SMALL_STEMS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CRIMSON_SMALL_STEMS = register(BlockusBlocks.CRIMSON_SMALL_STEMS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_OAK_SMALL_LOGS = register(BlockusBlocks.WHITE_OAK_SMALL_LOGS, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Timber Frames
    public static final Item OAK_TIMBER_FRAME = register(BlockusBlocks.OAK_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item OAK_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.OAK_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item OAK_CROSS_TIMBER_FRAME = register(BlockusBlocks.OAK_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BIRCH_TIMBER_FRAME = register(BlockusBlocks.BIRCH_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BIRCH_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.BIRCH_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BIRCH_CROSS_TIMBER_FRAME = register(BlockusBlocks.BIRCH_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SPRUCE_TIMBER_FRAME = register(BlockusBlocks.SPRUCE_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SPRUCE_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.SPRUCE_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SPRUCE_CROSS_TIMBER_FRAME = register(BlockusBlocks.SPRUCE_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item JUNGLE_TIMBER_FRAME = register(BlockusBlocks.JUNGLE_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item JUNGLE_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.JUNGLE_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item JUNGLE_CROSS_TIMBER_FRAME = register(BlockusBlocks.JUNGLE_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ACACIA_TIMBER_FRAME = register(BlockusBlocks.ACACIA_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ACACIA_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.ACACIA_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ACACIA_CROSS_TIMBER_FRAME = register(BlockusBlocks.ACACIA_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item DARK_OAK_TIMBER_FRAME = register(BlockusBlocks.DARK_OAK_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item DARK_OAK_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.DARK_OAK_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item DARK_OAK_CROSS_TIMBER_FRAME = register(BlockusBlocks.DARK_OAK_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WARPED_TIMBER_FRAME = register(BlockusBlocks.WARPED_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WARPED_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.WARPED_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WARPED_CROSS_TIMBER_FRAME = register(BlockusBlocks.WARPED_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CRIMSON_TIMBER_FRAME = register(BlockusBlocks.CRIMSON_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CRIMSON_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.CRIMSON_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CRIMSON_CROSS_TIMBER_FRAME = register(BlockusBlocks.CRIMSON_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BAMBOO_TIMBER_FRAME = register(BlockusBlocks.BAMBOO_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BAMBOO_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.BAMBOO_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BAMBOO_CROSS_TIMBER_FRAME = register(BlockusBlocks.BAMBOO_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHARRED_TIMBER_FRAME = register(BlockusBlocks.CHARRED_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHARRED_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.CHARRED_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHARRED_CROSS_TIMBER_FRAME = register(BlockusBlocks.CHARRED_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_OAK_TIMBER_FRAME = register(BlockusBlocks.WHITE_OAK_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_OAK_DIAGONAL_TIMBER_FRAME = register(BlockusBlocks.WHITE_OAK_DIAGONAL_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_OAK_CROSS_TIMBER_FRAME = register(BlockusBlocks.WHITE_OAK_CROSS_TIMBER_FRAME, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Small Hedges
    public static final Item OAK_SMALL_HEDGE = register(BlockusBlocks.OAK_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item SPRUCE_SMALL_HEDGE = register(BlockusBlocks.SPRUCE_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item BIRCH_SMALL_HEDGE = register(BlockusBlocks.BIRCH_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item JUNGLE_SMALL_HEDGE = register(BlockusBlocks.JUNGLE_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item ACACIA_SMALL_HEDGE = register(BlockusBlocks.ACACIA_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item DARK_OAK_SMALL_HEDGE = register(BlockusBlocks.DARK_OAK_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item WHITE_OAK_SMALL_HEDGE = register(BlockusBlocks.WHITE_OAK_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item AZALEA_SMALL_HEDGE = register(BlockusBlocks.AZALEA_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item FLOWERING_AZALEA_SMALL_HEDGE = register(BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item MOSS_SMALL_HEDGE = register(BlockusBlocks.MOSS_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item CRIMSON_SMALL_HEDGE = register(BlockusBlocks.CRIMSON_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item WARPED_SMALL_HEDGE = register(BlockusBlocks.WARPED_SMALL_HEDGE, Blockus.BLOCKUS_DECORATIONS);

    // Large Flower Pots
    public static final Item LARGE_FLOWER_POT = register(BlockusBlocks.LARGE_FLOWER_POT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Food Blocks
    public static final Item SWEET_BERRIES_CRATE = register(BlockusBlocks.SWEET_BERRIES_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GLOW_BERRIES_CRATE = register(BlockusBlocks.GLOW_BERRIES_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SALMON_CRATE = register(BlockusBlocks.SALMON_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PUFFERFISH_CRATE = register(BlockusBlocks.PUFFERFISH_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item TROPICAL_FISH_CRATE = register(BlockusBlocks.TROPICAL_FISH_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item COD_CRATE = register(BlockusBlocks.COD_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item COOKIE_BLOCK = register(BlockusBlocks.COOKIE_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHORUS_BLOCK = register(BlockusBlocks.CHORUS_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item POTATO_CRATE = register(BlockusBlocks.POTATO_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item APPLE_CRATE = register(BlockusBlocks.APPLE_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GOLDEN_APPLE_CRATE = register(BlockusBlocks.GOLDEN_APPLE_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BEETROOT_CRATE = register(BlockusBlocks.BEETROOT_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CARROT_CRATE = register(BlockusBlocks.CARROT_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GOLDEN_CARROT_CRATE = register(BlockusBlocks.GOLDEN_CARROT_CRATE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BREAD_BOX = register(BlockusBlocks.BREAD_BOX, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Rainbow
    public static final Item RAINBOW_ROSE = register(BlockusBlocks.RAINBOW_ROSE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item RAINBOW_PETAL = register("rainbow_petal", new Item(new Item.Settings().maxCount(64).group(ItemGroup.MATERIALS)));
    public static final Item RAINBOW_BLOCK = register(BlockusBlocks.RAINBOW_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RAINBOW_GLOWSTONE = register(BlockusBlocks.RAINBOW_GLOWSTONE, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Colored Stone Bricks

    public static final Item CHISELED_WHITE_CONCRETE = register(BlockusBlocks.CHISELED_WHITE_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_ORANGE_CONCRETE = register(BlockusBlocks.CHISELED_ORANGE_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_MAGENTA_CONCRETE = register(BlockusBlocks.CHISELED_MAGENTA_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_LIGHT_BLUE_CONCRETE = register(BlockusBlocks.CHISELED_LIGHT_BLUE_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_YELLOW_CONCRETE = register(BlockusBlocks.CHISELED_YELLOW_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_LIME_CONCRETE = register(BlockusBlocks.CHISELED_LIME_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_PINK_CONCRETE = register(BlockusBlocks.CHISELED_PINK_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_GRAY_CONCRETE = register(BlockusBlocks.CHISELED_GRAY_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_LIGHT_GRAY_CONCRETE = register(BlockusBlocks.CHISELED_LIGHT_GRAY_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_CYAN_CONCRETE = register(BlockusBlocks.CHISELED_CYAN_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_PURPLE_CONCRETE = register(BlockusBlocks.CHISELED_PURPLE_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_BLUE_CONCRETE = register(BlockusBlocks.CHISELED_BLUE_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_BROWN_CONCRETE = register(BlockusBlocks.CHISELED_BROWN_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_GREEN_CONCRETE = register(BlockusBlocks.CHISELED_GREEN_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_RED_CONCRETE = register(BlockusBlocks.CHISELED_RED_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CHISELED_BLACK_CONCRETE = register(BlockusBlocks.CHISELED_BLACK_CONCRETE, Blockus.BLOCKUS_BUILDING_BLOCKS);

    public static final Item WHITE_CONCRETE_PILLAR = register(BlockusBlocks.WHITE_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ORANGE_CONCRETE_PILLAR = register(BlockusBlocks.ORANGE_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MAGENTA_CONCRETE_PILLAR = register(BlockusBlocks.MAGENTA_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_BLUE_CONCRETE_PILLAR = register(BlockusBlocks.LIGHT_BLUE_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item YELLOW_CONCRETE_PILLAR = register(BlockusBlocks.YELLOW_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIME_CONCRETE_PILLAR = register(BlockusBlocks.LIME_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PINK_CONCRETE_PILLAR = register(BlockusBlocks.PINK_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRAY_CONCRETE_PILLAR = register(BlockusBlocks.GRAY_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_GRAY_CONCRETE_PILLAR = register(BlockusBlocks.LIGHT_GRAY_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CYAN_CONCRETE_PILLAR = register(BlockusBlocks.CYAN_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_CONCRETE_PILLAR = register(BlockusBlocks.PURPLE_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUE_CONCRETE_PILLAR = register(BlockusBlocks.BLUE_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BROWN_CONCRETE_PILLAR = register(BlockusBlocks.BROWN_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_CONCRETE_PILLAR = register(BlockusBlocks.GREEN_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_CONCRETE_PILLAR = register(BlockusBlocks.RED_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_CONCRETE_PILLAR = register(BlockusBlocks.BLACK_CONCRETE_PILLAR, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Redstone Lamps
    public static final Item WHITE_REDSTONE_LAMP = register(BlockusBlocks.WHITE_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item ORANGE_REDSTONE_LAMP = register(BlockusBlocks.ORANGE_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item MAGENTA_REDSTONE_LAMP = register(BlockusBlocks.MAGENTA_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item LIGHT_BLUE_REDSTONE_LAMP = register(BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item YELLOW_REDSTONE_LAMP = register(BlockusBlocks.YELLOW_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item LIME_REDSTONE_LAMP = register(BlockusBlocks.LIME_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item PINK_REDSTONE_LAMP = register(BlockusBlocks.PINK_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item GRAY_REDSTONE_LAMP = register(BlockusBlocks.GRAY_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item LIGHT_GRAY_REDSTONE_LAMP = register(BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item CYAN_REDSTONE_LAMP = register(BlockusBlocks.CYAN_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item PURPLE_REDSTONE_LAMP = register(BlockusBlocks.PURPLE_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item BLUE_REDSTONE_LAMP = register(BlockusBlocks.BLUE_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item BROWN_REDSTONE_LAMP = register(BlockusBlocks.BROWN_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item GREEN_REDSTONE_LAMP = register(BlockusBlocks.GREEN_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item RED_REDSTONE_LAMP = register(BlockusBlocks.RED_REDSTONE_LAMP, Blockus.BLOCKUS_REDSTONE);
    public static final Item REDSTONE_LAMP_LIT = register(BlockusBlocks.REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_REDSTONE_LAMP_LIT = register(BlockusBlocks.WHITE_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ORANGE_REDSTONE_LAMP_LIT = register(BlockusBlocks.ORANGE_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MAGENTA_REDSTONE_LAMP_LIT = register(BlockusBlocks.MAGENTA_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_BLUE_REDSTONE_LAMP_LIT = register(BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item YELLOW_REDSTONE_LAMP_LIT = register(BlockusBlocks.YELLOW_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIME_REDSTONE_LAMP_LIT = register(BlockusBlocks.LIME_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PINK_REDSTONE_LAMP_LIT = register(BlockusBlocks.PINK_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRAY_REDSTONE_LAMP_LIT = register(BlockusBlocks.GRAY_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_GRAY_REDSTONE_LAMP_LIT = register(BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CYAN_REDSTONE_LAMP_LIT = register(BlockusBlocks.CYAN_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_REDSTONE_LAMP_LIT = register(BlockusBlocks.PURPLE_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUE_REDSTONE_LAMP_LIT = register(BlockusBlocks.BLUE_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BROWN_REDSTONE_LAMP_LIT = register(BlockusBlocks.BROWN_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_REDSTONE_LAMP_LIT = register(BlockusBlocks.GREEN_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_REDSTONE_LAMP_LIT = register(BlockusBlocks.RED_REDSTONE_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RAINBOW_LAMP = register(BlockusBlocks.RAINBOW_LAMP, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RAINBOW_LAMP_LIT = register(BlockusBlocks.RAINBOW_LAMP_LIT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Neon Blocks
    public static final Item WHITE_NEON = register(BlockusBlocks.WHITE_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ORANGE_NEON = register(BlockusBlocks.ORANGE_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MAGENTA_NEON = register(BlockusBlocks.MAGENTA_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_BLUE_NEON = register(BlockusBlocks.LIGHT_BLUE_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item YELLOW_NEON = register(BlockusBlocks.YELLOW_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIME_NEON = register(BlockusBlocks.LIME_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PINK_NEON = register(BlockusBlocks.PINK_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRAY_NEON = register(BlockusBlocks.GRAY_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_GRAY_NEON = register(BlockusBlocks.LIGHT_GRAY_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CYAN_NEON = register(BlockusBlocks.CYAN_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_NEON = register(BlockusBlocks.PURPLE_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUE_NEON = register(BlockusBlocks.BLUE_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BROWN_NEON = register(BlockusBlocks.BROWN_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_NEON = register(BlockusBlocks.GREEN_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_NEON = register(BlockusBlocks.RED_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_NEON = register(BlockusBlocks.BLACK_NEON, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Futurneo Blocks
    public static final Item WHITE_FUTURNEO_BLOCK = register(BlockusBlocks.WHITE_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ORANGE_FUTURNEO_BLOCK = register(BlockusBlocks.ORANGE_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MAGENTA_FUTURNEO_BLOCK = register(BlockusBlocks.MAGENTA_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_BLUE_FUTURNEO_BLOCK = register(BlockusBlocks.LIGHT_BLUE_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item YELLOW_FUTURNEO_BLOCK = register(BlockusBlocks.YELLOW_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIME_FUTURNEO_BLOCK = register(BlockusBlocks.LIME_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PINK_FUTURNEO_BLOCK = register(BlockusBlocks.PINK_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRAY_FUTURNEO_BLOCK = register(BlockusBlocks.GRAY_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRAY_BRIGHT_FUTURNEO_BLOCK = register(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_GRAY_FUTURNEO_BLOCK = register(BlockusBlocks.LIGHT_GRAY_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CYAN_FUTURNEO_BLOCK = register(BlockusBlocks.CYAN_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_FUTURNEO_BLOCK = register(BlockusBlocks.PURPLE_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUE_FUTURNEO_BLOCK = register(BlockusBlocks.BLUE_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BROWN_FUTURNEO_BLOCK = register(BlockusBlocks.BROWN_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_FUTURNEO_BLOCK = register(BlockusBlocks.GREEN_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_FUTURNEO_BLOCK = register(BlockusBlocks.RED_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_FUTURNEO_BLOCK = register(BlockusBlocks.BLACK_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RAINBOW_FUTURNEO_BLOCK = register(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);


    // Asphalt
    public static final Item RAINBOW_ASPHALT = register(BlockusBlocks.RAINBOW_ASPHALT, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Shingles

    // Glass - Beveled Glass
    public static final Item RAINBOW_GLASS = register(BlockusBlocks.RAINBOW_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RAINBOW_GLASS_PANE = register(BlockusBlocks.RAINBOW_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item BEVELED_GLASS = register(BlockusBlocks.BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WHITE_BEVELED_GLASS = register(BlockusBlocks.WHITE_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ORANGE_BEVELED_GLASS = register(BlockusBlocks.ORANGE_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MAGENTA_BEVELED_GLASS = register(BlockusBlocks.MAGENTA_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_BLUE_BEVELED_GLASS = register(BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item YELLOW_BEVELED_GLASS = register(BlockusBlocks.YELLOW_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIME_BEVELED_GLASS = register(BlockusBlocks.LIME_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PINK_BEVELED_GLASS = register(BlockusBlocks.PINK_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_GRAY_BEVELED_GLASS = register(BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRAY_BEVELED_GLASS = register(BlockusBlocks.GRAY_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CYAN_BEVELED_GLASS = register(BlockusBlocks.CYAN_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_BEVELED_GLASS = register(BlockusBlocks.PURPLE_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUE_BEVELED_GLASS = register(BlockusBlocks.BLUE_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BROWN_BEVELED_GLASS = register(BlockusBlocks.BROWN_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_BEVELED_GLASS = register(BlockusBlocks.GREEN_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_BEVELED_GLASS = register(BlockusBlocks.RED_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_BEVELED_GLASS = register(BlockusBlocks.BLACK_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RAINBOW_BEVELED_GLASS = register(BlockusBlocks.RAINBOW_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BEVELED_GLASS_PANE = register(BlockusBlocks.BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item WHITE_BEVELED_GLASS_PANE = register(BlockusBlocks.WHITE_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item ORANGE_BEVELED_GLASS_PANE = register(BlockusBlocks.ORANGE_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item MAGENTA_BEVELED_GLASS_PANE = register(BlockusBlocks.MAGENTA_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item LIGHT_BLUE_BEVELED_GLASS_PANE = register(BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item YELLOW_BEVELED_GLASS_PANE = register(BlockusBlocks.YELLOW_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item LIME_BEVELED_GLASS_PANE = register(BlockusBlocks.LIME_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item PINK_BEVELED_GLASS_PANE = register(BlockusBlocks.PINK_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item LIGHT_GRAY_BEVELED_GLASS_PANE = register(BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item GRAY_BEVELED_GLASS_PANE = register(BlockusBlocks.GRAY_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item CYAN_BEVELED_GLASS_PANE = register(BlockusBlocks.CYAN_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item PURPLE_BEVELED_GLASS_PANE = register(BlockusBlocks.PURPLE_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item BLUE_BEVELED_GLASS_PANE = register(BlockusBlocks.BLUE_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item BROWN_BEVELED_GLASS_PANE = register(BlockusBlocks.BROWN_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item GREEN_BEVELED_GLASS_PANE = register(BlockusBlocks.GREEN_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item RED_BEVELED_GLASS_PANE = register(BlockusBlocks.RED_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item BLACK_BEVELED_GLASS_PANE = register(BlockusBlocks.BLACK_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item RAINBOW_BEVELED_GLASS_PANE = register(BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE, Blockus.BLOCKUS_DECORATIONS);
    public static final Item TINTED_BEVELED_GLASS = register(BlockusBlocks.TINTED_BEVELED_GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Patterned Wools
    public static final Item WHITE_PATTERNED_WOOL = register(BlockusBlocks.WHITE_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ORANGE_PATTERNED_WOOL = register(BlockusBlocks.ORANGE_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MAGENTA_PATTERNED_WOOL = register(BlockusBlocks.MAGENTA_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_BLUE_PATTERNED_WOOL = register(BlockusBlocks.LIGHT_BLUE_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item YELLOW_PATTERNED_WOOL = register(BlockusBlocks.YELLOW_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIME_PATTERNED_WOOL = register(BlockusBlocks.LIME_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PINK_PATTERNED_WOOL = register(BlockusBlocks.PINK_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRAY_PATTERNED_WOOL = register(BlockusBlocks.GRAY_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_GRAY_PATTERNED_WOOL = register(BlockusBlocks.LIGHT_GRAY_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CYAN_PATTERNED_WOOL = register(BlockusBlocks.CYAN_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_PATTERNED_WOOL = register(BlockusBlocks.PURPLE_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUE_PATTERNED_WOOL = register(BlockusBlocks.BLUE_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BROWN_PATTERNED_WOOL = register(BlockusBlocks.BROWN_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_PATTERNED_WOOL = register(BlockusBlocks.GREEN_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_PATTERNED_WOOL = register(BlockusBlocks.RED_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_PATTERNED_WOOL = register(BlockusBlocks.BLACK_PATTERNED_WOOL, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Colored Tiles
    public static final Item WHITE_COLORED_TILES = register(BlockusBlocks.WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ORANGE_COLORED_TILES = register(BlockusBlocks.ORANGE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MAGENTA_COLORED_TILES = register(BlockusBlocks.MAGENTA_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_BLUE_COLORED_TILES = register(BlockusBlocks.LIGHT_BLUE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item YELLOW_COLORED_TILES = register(BlockusBlocks.YELLOW_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIME_COLORED_TILES = register(BlockusBlocks.LIME_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PINK_COLORED_TILES = register(BlockusBlocks.PINK_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRAY_COLORED_TILES = register(BlockusBlocks.GRAY_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_GRAY_COLORED_TILES = register(BlockusBlocks.LIGHT_GRAY_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CYAN_COLORED_TILES = register(BlockusBlocks.CYAN_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_COLORED_TILES = register(BlockusBlocks.PURPLE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUE_COLORED_TILES = register(BlockusBlocks.BLUE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BROWN_COLORED_TILES = register(BlockusBlocks.BROWN_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_COLORED_TILES = register(BlockusBlocks.GREEN_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_COLORED_TILES = register(BlockusBlocks.RED_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_COLORED_TILES = register(BlockusBlocks.BLACK_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Colored Tiles (With white)
    public static final Item ORANGE_WHITE_COLORED_TILES = register(BlockusBlocks.ORANGE_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MAGENTA_WHITE_COLORED_TILES = register(BlockusBlocks.MAGENTA_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_BLUE_WHITE_COLORED_TILES = register(BlockusBlocks.LIGHT_BLUE_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item YELLOW_WHITE_COLORED_TILES = register(BlockusBlocks.YELLOW_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIME_WHITE_COLORED_TILES = register(BlockusBlocks.LIME_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PINK_WHITE_COLORED_TILES = register(BlockusBlocks.PINK_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GRAY_WHITE_COLORED_TILES = register(BlockusBlocks.GRAY_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_WHITE_GRAY_COLORED_TILES = register(BlockusBlocks.LIGHT_GRAY_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CYAN_WHITE_COLORED_TILES = register(BlockusBlocks.CYAN_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_WHITE_COLORED_TILES = register(BlockusBlocks.PURPLE_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUE_WHITE_COLORED_TILES = register(BlockusBlocks.BLUE_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BROWN_WHITE_COLORED_TILES = register(BlockusBlocks.BROWN_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_WHITE_COLORED_TILES = register(BlockusBlocks.GREEN_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_WHITE_COLORED_TILES = register(BlockusBlocks.RED_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_WHITE_COLORED_TILES = register(BlockusBlocks.BLACK_WHITE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Other colored Tiles
    public static final Item GRAY_LIGHT_GRAY_COLORED_TILES = register(BlockusBlocks.GRAY_LIGHT_GRAY_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_GRAY_COLORED_TILES = register(BlockusBlocks.BLACK_GRAY_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_RED_COLORED_TILES = register(BlockusBlocks.BLACK_RED_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLACK_BLUE_COLORED_TILES = register(BlockusBlocks.BLACK_BLUE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MAGENTA_BLACK_COLORED_TILES = register(BlockusBlocks.MAGENTA_BLACK_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PINK_MAGENTA_COLORED_TILES = register(BlockusBlocks.PINK_MAGENTA_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_ORANGE_COLORED_TILES = register(BlockusBlocks.PURPLE_ORANGE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item PURPLE_BLUE_COLORED_TILES = register(BlockusBlocks.PURPLE_BLUE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_ORANGE_COLORED_TILES = register(BlockusBlocks.GREEN_ORANGE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item GREEN_BROWN_COLORED_TILES = register(BlockusBlocks.GREEN_BROWN_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIME_YELLOW_COLORED_TILES = register(BlockusBlocks.LIME_YELLOW_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item LIGHT_BLUE_YELLOW_COLORED_TILES = register(BlockusBlocks.LIGHT_BLUE_YELLOW_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BLUE_CYAN_COLORED_TILES = register(BlockusBlocks.BLUE_CYAN_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RED_BLUE_COLORED_TILES = register(BlockusBlocks.RED_BLUE_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item RAINBOW_COLORED_TILES = register(BlockusBlocks.RAINBOW_COLORED_TILES, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Glazed Terracotta Pillars
    public static final Item WHITE_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.WHITE_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item ORANGE_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.ORANGE_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item MAGENTA_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.MAGENTA_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item YELLOW_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.YELLOW_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item LIME_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.LIME_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item PINK_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.PINK_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item GRAY_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.GRAY_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item CYAN_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.CYAN_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item PURPLE_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.PURPLE_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item BLUE_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.BLUE_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item BROWN_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.BROWN_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item GREEN_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.GREEN_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item RED_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.RED_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);
    public static final Item BLACK_GLAZED_TERRACOTTA_PILLAR = register(BlockusBlocks.BLACK_GLAZED_TERRACOTTA_PILLAR, Blockus.BLOCKUS_DECORATIONS);

    // Pressure Plates
    public static final Item POLISHED_ANDESITE_PRESSURE_PLATE = register(BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_DIORITE_PRESSURE_PLATE = register(BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_GRANITE_PRESSURE_PLATE = register(BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item LIMESTONE_PRESSURE_PLATE = register(BlockusBlocks.LIMESTONE_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item MARBLE_PRESSURE_PLATE = register(BlockusBlocks.MARBLE_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item BLUESTONE_PRESSURE_PLATE = register(BlockusBlocks.BLUESTONE_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_NETHERRACK_PRESSURE_PLATE = register(BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_END_STONE_PRESSURE_PLATE = register(BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item BAMBOO_PRESSURE_PLATE = register(BlockusBlocks.BAMBOO_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item CHARRED_PRESSURE_PLATE = register(BlockusBlocks.CHARRED_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item WHITE_OAK_PRESSURE_PLATE = register(BlockusBlocks.WHITE_OAK_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_BASALT_PRESSURE_PLATE = register(BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_DEEPSLATE_PRESSURE_PLATE = register(BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_TUFF_PRESSURE_PLATE = register(BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE, Blockus.BLOCKUS_REDSTONE);

    // Buttons
    public static final Item POLISHED_ANDESITE_BUTTON = register(BlockusBlocks.POLISHED_ANDESITE_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_DIORITE_BUTTON = register(BlockusBlocks.POLISHED_DIORITE_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_GRANITE_BUTTON = register(BlockusBlocks.POLISHED_GRANITE_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item LIMESTONE_BUTTON = register(BlockusBlocks.LIMESTONE_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item MARBLE_BUTTON = register(BlockusBlocks.MARBLE_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item BLUESTONE_BUTTON = register(BlockusBlocks.BLUESTONE_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_NETHERRACK_BUTTON = register(BlockusBlocks.POLISHED_NETHERRACK_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_END_STONE_BUTTON = register(BlockusBlocks.POLISHED_END_STONE_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item BAMBOO_BUTTON = register(BlockusBlocks.BAMBOO_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item CHARRED_BUTTON = register(BlockusBlocks.CHARRED_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item WHITE_OAK_BUTTON = register(BlockusBlocks.WHITE_OAK_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_BASALT_BUTTON = register(BlockusBlocks.POLISHED_BASALT_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_DEEPSLATE_BUTTON = register(BlockusBlocks.POLISHED_DEEPSLATE_BUTTON, Blockus.BLOCKUS_REDSTONE);
    public static final Item POLISHED_TUFF_BUTTON = register(BlockusBlocks.POLISHED_TUFF_BUTTON, Blockus.BLOCKUS_REDSTONE);

    // Thatch

    // Paper
    public static final Item PAPER_BLOCK = register(BlockusBlocks.PAPER_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item BURNED_PAPER_BLOCK = register(BlockusBlocks.BURNT_PAPER_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item FRAMED_PAPER_BLOCK = register(BlockusBlocks.FRAMED_PAPER_BLOCK, Blockus.BLOCKUS_DECORATIONS);
    public static final Item PAPER_WALL = register(BlockusBlocks.PAPER_WALL, Blockus.BLOCKUS_DECORATIONS);
    public static final Item PAPER_DOOR = register(BlockusBlocks.PAPER_DOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item PAPER_TRAPDOOR = register(BlockusBlocks.PAPER_TRAPDOOR, Blockus.BLOCKUS_REDSTONE);
    public static final Item PAPER_LAMP = register(BlockusBlocks.PAPER_LAMP, Blockus.BLOCKUS_DECORATIONS);

    // Iron Plating

    // Gates - chains - bars
    public static final Item IRON_GATE = register(BlockusBlocks.IRON_GATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item GOLDEN_GATE = register(BlockusBlocks.GOLDEN_GATE, Blockus.BLOCKUS_REDSTONE);
    public static final Item GOLDEN_BARS = register(BlockusBlocks.GOLDEN_BARS, Blockus.BLOCKUS_DECORATIONS);
    public static final Item GOLDEN_CHAIN = register(BlockusBlocks.GOLDEN_CHAIN, Blockus.BLOCKUS_DECORATIONS);

    // Lantern Blocks
    public static final Item LANTERN_BLOCK = register(BlockusBlocks.LANTERN_BLOCK, Blockus.BLOCKUS_DECORATIONS);
    public static final Item SOUL_LANTERN_BLOCK = register(BlockusBlocks.SOUL_LANTERN_BLOCK, Blockus.BLOCKUS_DECORATIONS);
    public static final Item SOUL_O_LANTERN = register(BlockusBlocks.SOUL_O_LANTERN, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Barriers
    public static final Item CAUTION_BARRIER_BLOCK = register(BlockusBlocks.CAUTION_BARRIER, Blockus.BLOCKUS_DECORATIONS);
    public static final Item ROAD_BARRIER_BLOCK = register(BlockusBlocks.ROAD_BARRIER, Blockus.BLOCKUS_DECORATIONS);

    // Netherite Blocks
    public static final Item NETHERITE_STAIRS = register_other(BlockusBlocks.NETHERITE_STAIRS, new BlockItem(BlockusBlocks.NETHERITE_STAIRS, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS).fireproof()));
    public static final Item NETHERITE_SLAB = register_other(BlockusBlocks.NETHERITE_SLAB, new BlockItem(BlockusBlocks.NETHERITE_SLAB, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS).fireproof()));

    // Other
    public static final Item PATH = register(BlockusBlocks.PATH, Blockus.BLOCKUS_DECORATIONS);
    public static final Item CHARCOAL_BLOCK = register(BlockusBlocks.CHARCOAL_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item SUGAR_BLOCK = register(BlockusBlocks.SUGAR_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ENDER_BLOCK = register(BlockusBlocks.ENDER_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item ROTTEN_FLESH_BLOCK = register(BlockusBlocks.ROTTEN_FLESH_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item MEMBRANE_BLOCK = register(BlockusBlocks.MEMBRANE_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item NETHER_STAR_BLOCK = register_other(BlockusBlocks.NETHER_STAR_BLOCK, new NetherStarBlockItem(BlockusBlocks.NETHER_STAR_BLOCK, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS).rarity(Rarity.UNCOMMON)));

    public static final Item WOODEN_FRAME = register(BlockusBlocks.WOODEN_FRAME, Blockus.BLOCKUS_DECORATIONS);
    public static final Item REDSTONE_SAND = register(BlockusBlocks.REDSTONE_SAND, Blockus.BLOCKUS_REDSTONE);
    public static final Item LOVE_BLOCK = register(BlockusBlocks.LOVE_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item WEIGHT_STORAGE_CUBE = register(BlockusBlocks.WEIGHT_STORAGE_CUBE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item COMPANION_CUBE = register(BlockusBlocks.COMPANION_CUBE, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item CAUTION_BLOCK = register(BlockusBlocks.CAUTION_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);
    public static final Item STARS_BLOCK = register(BlockusBlocks.STARS_BLOCK, Blockus.BLOCKUS_BUILDING_BLOCKS);

    // Legacy
    public static final Item LEGACY_FIRST_GRASS_BLOCK = register(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_GRASS_BLOCK = register(BlockusBlocks.LEGACY_GRASS_BLOCK, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_LEAVES = register(BlockusBlocks.LEGACY_LEAVES, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_BRICKS = register(BlockusBlocks.LEGACY_BRICKS, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_PLANKS = register(BlockusBlocks.LEGACY_PLANKS, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_FIRST_COBBLESTONE = register(BlockusBlocks.LEGACY_FIRST_COBBLESTONE, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_COBBLESTONE = register(BlockusBlocks.LEGACY_COBBLESTONE, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_MOSSY_COBBLESTONE = register(BlockusBlocks.LEGACY_MOSSY_COBBLESTONE, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_GRAVEL = register(BlockusBlocks.LEGACY_GRAVEL, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_IRON_BLOCK = register(BlockusBlocks.LEGACY_IRON_BLOCK, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_GOLD_BLOCK = register(BlockusBlocks.LEGACY_GOLD_BLOCK, Blockus.BLOCKUS_LEGACY);
    public static final Item EXPLOSION_PROOF_LEGACY_GOLD_BLOCK = register(BlockusBlocks.EXPLOSION_PROOF_LEGACY_GOLD_BLOCK, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_COAL_BLOCK = register(BlockusBlocks.LEGACY_COAL_BLOCK, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_DIAMOND_BLOCK = register(BlockusBlocks.LEGACY_DIAMOND_BLOCK, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_LAPIS_BLOCK = register(BlockusBlocks.LEGACY_LAPIS_BLOCK, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_SPONGE = register(BlockusBlocks.LEGACY_SPONGE, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_CRYING_OBSIDIAN = register(BlockusBlocks.LEGACY_CRYING_OBSIDIAN, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_GLOWSTONE = register(BlockusBlocks.LEGACY_GLOWSTONE, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_STONECUTTER = register(BlockusBlocks.LEGACY_STONECUTTER, Blockus.BLOCKUS_LEGACY);
    public static final Item LEGACY_GLOWING_OBSIDIAN = register(BlockusBlocks.LEGACY_GLOWING_OBSIDIAN, Blockus.BLOCKUS_LEGACY);
    public static final Item NETHER_REACTOR_CORE = register(BlockusBlocks.NETHER_REACTOR_CORE, Blockus.BLOCKUS_LEGACY);

    public static Item register(Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, Registry.BLOCK.getId(block), new BlockItem(block, new Item.Settings().maxCount(64).group(group)));
    }

    public static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, Blockus.id(id), item);
    }

    public static Item register_asphalt(Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, Registry.BLOCK.getId(block), new SpeedBlockItem(block, new Item.Settings().maxCount(64).group(group)));
    }

    public static Item register_sign(Block standingBlock, Block wallBlock) {
        return Registry.register(Registry.ITEM, Registry.BLOCK.getId(standingBlock), new SignItem(new Item.Settings().maxCount(16).group(Blockus.BLOCKUS_DECORATIONS), standingBlock, wallBlock));
    }

    public static Item register_boat(String path, String boatPath) {
        Identifier id = Blockus.id(path);
        Identifier boatId = Blockus.id(boatPath);

        Item item = TerraformBoatItemHelper.registerBoatItem(id, () -> {
            return TerraformBoatTypeRegistry.INSTANCE.get(boatId);
        });

        TerraformBoatType boatType = new TerraformBoatType.Builder().item(item).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, boatId, boatType);

        return item;
    }

    public static Item register_other(Block block, Item item) {
        return Registry.register(Registry.ITEM, Registry.BLOCK.getId(block), item);
    }
}
