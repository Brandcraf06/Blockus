package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.*;
import com.brand.blockus.blocks.blockentity.WoodenBarrelBlockEntity;
import com.brand.blockus.blocks.generator.WhiteOakSaplingGenerator;
import com.brand.blockus.blocks.special.*;
import com.mojang.datafixers.types.Type;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockusBlocks extends BlocksRegistration {
    // Stone
    public static final Block STONE_BRICKS_PILLAR = registerPillar(Blocks.STONE_BRICKS);
    public static final Block ZIGZAGGED_STONE_BRICKS = registerBlockCopy("zigzagged_stone_bricks", Blocks.STONE_BRICKS);
    public static final Block STONE_CIRCLE_PAVEMENT = registerCirclePavement("stone", Blocks.STONE_BRICKS);
    public static final Block STONE_DOOR = registerDoor2("stone", 1.5f, 20.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.STONE);
    public static final Block STONE_TRAPDOOR = registerTrapdoor2("stone", 1.5f, 20.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.STONE);
    public static final Block SMOOTH_STONE_STAIRS = registerStairs(Blocks.SMOOTH_STONE);

    // Andesite
    public static final Block ANDESITE_BRICKS = registerBlockCopy("andesite_bricks", Blocks.POLISHED_ANDESITE);
    public static final Block ANDESITE_BRICKS_STAIRS = registerStairs(ANDESITE_BRICKS);
    public static final Block ANDESITE_BRICKS_SLAB = registerSlab(ANDESITE_BRICKS);
    public static final Block ZIGZAGGED_ANDESITE = registerBlockCopy("zigzagged_andesite", Blocks.POLISHED_ANDESITE);
    public static final Block CHISELED_ANDESITE_BRICKS = registerBlockCopy("chiseled_andesite_bricks", Blocks.POLISHED_ANDESITE);
    public static final Block CRACKED_ANDESITE_BRICKS = registerBlockCopy("cracked_andesite_bricks", Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_ANDESITE_PILLAR = registerPillar(Blocks.POLISHED_ANDESITE);
    public static final Block ANDESITE_CIRCLE_PAVEMENT = registerCirclePavement("andesite", Blocks.POLISHED_ANDESITE);

    // Diorite
    public static final Block DIORITE_BRICKS = registerBlockCopy("diorite_bricks", Blocks.POLISHED_DIORITE);
    public static final Block DIORITE_BRICKS_STAIRS = registerStairs(DIORITE_BRICKS);
    public static final Block DIORITE_BRICKS_SLAB = registerSlab(DIORITE_BRICKS);
    public static final Block ZIGZAGGED_DIORITE = registerBlockCopy("zigzagged_diorite", Blocks.POLISHED_DIORITE);
    public static final Block CHISELED_DIORITE_BRICKS = registerBlockCopy("chiseled_diorite_bricks", Blocks.POLISHED_DIORITE);
    public static final Block CRACKED_DIORITE_BRICKS = registerBlockCopy("cracked_diorite_bricks", Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_DIORITE_PILLAR = registerPillar(Blocks.POLISHED_DIORITE);
    public static final Block DIORITE_CIRCLE_PAVEMENT = registerCirclePavement("diorite", Blocks.POLISHED_DIORITE);

    // Granite
    public static final Block GRANITE_BRICKS = registerBlockCopy("granite_bricks", Blocks.POLISHED_GRANITE);
    public static final Block GRANITE_BRICKS_STAIRS = registerStairs(GRANITE_BRICKS);
    public static final Block GRANITE_BRICKS_SLAB = registerSlab(GRANITE_BRICKS);
    public static final Block ZIGZAGGED_GRANITE = registerBlockCopy("zigzagged_granite", Blocks.POLISHED_GRANITE);
    public static final Block CHISELED_GRANITE_BRICKS = registerBlockCopy("chiseled_granite_bricks", Blocks.POLISHED_GRANITE);
    public static final Block CRACKED_GRANITE_BRICKS = registerBlockCopy("cracked_granite_bricks", Blocks.POLISHED_GRANITE);
    public static final Block POLISHED_GRANITE_PILLAR = registerPillar(Blocks.POLISHED_GRANITE);
    public static final Block GRANITE_CIRCLE_PAVEMENT = registerCirclePavement("granite", Blocks.POLISHED_GRANITE);

    // Blackstone
    public static final Block POLISHED_BLACKSTONE_PILLAR = registerPillar(Blocks.POLISHED_BLACKSTONE);
    public static final Block ZIGZAGGED_POLISHED_BLACKSTONE = registerBlockCopy("zigzagged_polished_blackstone", Blocks.POLISHED_BLACKSTONE);
    public static final Block POLISHED_BLACKSTONE_CIRCLE_PAVEMENT = registerCirclePavement("polished_blackstone", Blocks.POLISHED_BLACKSTONE);
    public static final Block CRIMSON_WARTY_BLACKSTONE_BRICKS = registerBlockCopy("crimson_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE);
    public static final Block CRIMSON_WARTY_BLACKSTONE_BRICKS_STAIRS = registerStairs(CRIMSON_WARTY_BLACKSTONE_BRICKS);
    public static final Block CRIMSON_WARTY_BLACKSTONE_BRICKS_SLAB = registerSlab(CRIMSON_WARTY_BLACKSTONE_BRICKS);
    public static final Block CRIMSON_WARTY_BLACKSTONE_BRICKS_WALL = registerWall(CRIMSON_WARTY_BLACKSTONE_BRICKS);
    public static final Block WARPED_WARTY_BLACKSTONE_BRICKS = registerBlockCopy("warped_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE);
    public static final Block WARPED_WARTY_BLACKSTONE_BRICKS_STAIRS = registerStairs(WARPED_WARTY_BLACKSTONE_BRICKS);
    public static final Block WARPED_WARTY_BLACKSTONE_BRICKS_SLAB = registerSlab(WARPED_WARTY_BLACKSTONE_BRICKS);
    public static final Block WARPED_WARTY_BLACKSTONE_BRICKS_WALL = registerWall(WARPED_WARTY_BLACKSTONE_BRICKS);

    // Limestone
    public static final Block LIMESTONE = register("limestone", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.WOOD).strength(1.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block LIMESTONE_STAIRS = registerStairs(LIMESTONE);
    public static final Block LIMESTONE_SLAB = registerSlab(LIMESTONE);
    public static final Block LIMESTONE_BRICKS = registerBlockCopy("limestone_bricks", LIMESTONE);
    public static final Block LIMESTONE_BRICKS_STAIRS = registerStairs(LIMESTONE_BRICKS);
    public static final Block LIMESTONE_BRICKS_SLAB = registerSlab(LIMESTONE_BRICKS);
    public static final Block LIMESTONE_BRICKS_WALL = registerWall(LIMESTONE_BRICKS);
    public static final Block LIMESTONE_PILLAR = registerPillar(LIMESTONE);
    public static final Block CHISELED_LIMESTONE = registerBlockCopy("chiseled_limestone", LIMESTONE);
    public static final Block LIMESTONE_CIRCLE_PAVEMENT = registerCirclePavement("limestone", LIMESTONE);

    // Marble
    public static final Block MARBLE = register("marble", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block MARBLE_STAIRS = registerStairs(MARBLE);
    public static final Block MARBLE_SLAB = registerSlab(MARBLE);
    public static final Block MARBLE_BRICKS = registerBlockCopy("marble_bricks", MARBLE);
    public static final Block MARBLE_BRICKS_STAIRS = registerStairs(MARBLE_BRICKS);
    public static final Block MARBLE_BRICKS_SLAB = registerSlab(MARBLE_BRICKS);
    public static final Block MARBLE_BRICKS_WALL = registerWall(MARBLE_BRICKS);
    public static final Block MARBLE_PILLAR = registerPillar(MARBLE);
    public static final Block CHISELED_MARBLE = registerBlockCopy("chiseled_marble", MARBLE);
    public static final Block CHISELED_MARBLE_PILLAR = registerPillar(CHISELED_MARBLE);
    public static final Block MARBLE_CIRCLE_PAVEMENT = registerCirclePavement("marble", MARBLE);

    // Bluestone
    public static final Block BLUESTONE = register("bluestone", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.CYAN).strength(1.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block BLUESTONE_STAIRS = registerStairs(BLUESTONE);
    public static final Block BLUESTONE_SLAB = registerSlab(BLUESTONE);
    public static final Block BLUESTONE_TILES = registerBlockCopy("bluestone_tiles", BLUESTONE);
    public static final Block BLUESTONE_TILES_STAIRS = registerStairs(BLUESTONE_TILES);
    public static final Block BLUESTONE_TILES_SLAB = registerSlab(BLUESTONE_TILES);
    public static final Block BLUESTONE_PILLAR = registerPillar(BLUESTONE);
    public static final Block BLUESTONE_BRICKS = registerBlockCopy("bluestone_bricks", BLUESTONE);
    public static final Block SMOOTH_BLUESTONE = registerBlockCopy("smooth_bluestone", BLUESTONE);
    public static final Block SMOOTH_BLUESTONE_STAIRS = registerStairs(SMOOTH_BLUESTONE);
    public static final Block SMOOTH_BLUESTONE_SLAB = registerSlab(SMOOTH_BLUESTONE);
    public static final Block BLUESTONE_SQUARES = registerBlockCopy("bluestone_squares", BLUESTONE);
    public static final Block BLUESTONE_LITTLE_BRICKS = registerBlockCopy("bluestone_little_bricks", BLUESTONE);
    public static final Block CHISELED_BLUESTONE = registerBlockCopy("chiseled_bluestone", BLUESTONE);
    public static final Block BLUESTONE_LINES = registerPillar2("bluestone_lines", BLUESTONE);

    // Lava	Bricks
    public static final Block LAVA_BRICKS = registerLightBlock("lava_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15, MaterialColor.STONE);
    public static final Block LAVA_BRICKS_STAIRS = registerStairs(LAVA_BRICKS);
    public static final Block LAVA_BRICKS_SLAB = registerSlab(LAVA_BRICKS);
    public static final Block LAVA_BRICKS_WALL = registerWall(LAVA_BRICKS);
    public static final Block CHISELED_LAVA_BRICKS = registerLightBlock("chiseled_lava_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15, MaterialColor.STONE);

    // Lava Blackstone Bricks
    public static final Block LAVA_POLISHED_BLACKSTONE_BRICKS = registerLightBlock("lava_polished_blackstone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15, MaterialColor.BLACK);
    public static final Block LAVA_POLISHED_BLACKSTONE_WALL = registerWall("lava_polished_blackstone", LAVA_POLISHED_BLACKSTONE_BRICKS);
    public static final Block LAVA_POLISHED_BLACKSTONE_STAIRS = registerStairs("lava_polished_blackstone", LAVA_POLISHED_BLACKSTONE_BRICKS);
    public static final Block LAVA_POLISHED_BLACKSTONE_SLAB = registerSlab("lava_polished_blackstone", LAVA_POLISHED_BLACKSTONE_BRICKS);
    public static final Block CHISELED_LAVA_POLISHED_BLACKSTONE = registerLightBlock("chiseled_lava_polished_blackstone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15, MaterialColor.BLACK);

    // Water Bricks
    public static final Block WATER_BRICKS = register("water_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block WATER_BRICKS_STAIRS = registerStairs(WATER_BRICKS);
    public static final Block WATER_BRICKS_SLAB = registerSlab(WATER_BRICKS);
    public static final Block WATER_BRICKS_WALL = registerWall(WATER_BRICKS);
    public static final Block CHISELED_WATER_BRICKS = registerBlockCopy("chiseled_water_bricks", WATER_BRICKS);

    // Snow Bricks
    public static final Block SNOW_BRICKS = register("snow_bricks", new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).strength(2.0f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SNOW_BRICKS_STAIRS = registerStairs(SNOW_BRICKS);
    public static final Block SNOW_BRICKS_SLAB = registerSlab(SNOW_BRICKS);
    public static final Block SNOW_BRICKS_WALL = registerWall(SNOW_BRICKS);
    public static final Block SNOW_PILLAR = registerPillar("snow", SNOW_BRICKS);

    // Packed Ice Bricks
    public static final Block ICE_BRICKS = registerBlockCopy("ice_bricks", Blocks.PACKED_ICE);
    public static final Block ICE_BRICKS_WALL = registerWall(ICE_BRICKS);
    public static final Block ICE_PILLAR = registerPillar("ice", ICE_BRICKS);

    // Magma Bricks
    public static final Block MAGMA_BRICKS = registerLightBlock("magma_bricks", 0.5f, 1.0f, Material.STONE, BlockSoundGroup.STONE, 15, MaterialColor.NETHER);
    public static final Block MAGMA_BRICKS_STAIRS = registerStairs(MAGMA_BRICKS);
    public static final Block MAGMA_BRICKS_SLAB = registerSlab(MAGMA_BRICKS);
    public static final Block MAGMA_BRICKS_WALL = registerWall(MAGMA_BRICKS);

    // Blaze Bricks
    public static final Block BLAZE_BRICKS = registerLightBlock("blaze_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, 15, MaterialColor.NETHER);
    public static final Block BLAZE_BRICKS_STAIRS = registerStairs(BLAZE_BRICKS);
    public static final Block BLAZE_BRICKS_SLAB = registerSlab(BLAZE_BRICKS);
    public static final Block BLAZE_BRICKS_WALL = registerWall(BLAZE_BRICKS);
    public static final Block BLAZE_PILLAR = registerPillar("blaze", BLAZE_BRICKS);
    public static final Block BLAZE_LANTERN = registerLampBlock("blaze_block", 0.3F, 0.3F, Material.GLASS, BlockSoundGroup.GLASS, 15, MaterialColor.ORANGE);

    // Netherrack
    public static final Block POLISHED_NETHERRACK = registerBlockCopy("polished_netherrack", Blocks.NETHERRACK);
    public static final Block POLISHED_NETHERRACK_STAIRS = registerStairs(POLISHED_NETHERRACK);
    public static final Block POLISHED_NETHERRACK_SLAB = registerSlab(POLISHED_NETHERRACK);
    public static final Block NETHERRACK_CIRCLE_PAVEMENT = registerCirclePavement("netherrack", POLISHED_NETHERRACK);

    // Nether Bricks
    public static final Block SMOOTH_NETHER_BRICKS = registerBlockCopy("smooth_nether_bricks", Blocks.NETHER_BRICKS);
    public static final Block SMOOTH_RED_NETHER_BRICKS = registerBlockCopy("smooth_red_nether_bricks", Blocks.NETHER_BRICKS);
    public static final Block ZIGZAGGED_NETHER_BRICKS = registerBlockCopy("zigzagged_nether_bricks", Blocks.NETHER_BRICKS);
    public static final Block ZIGZAGGED_RED_NETHER_BRICKS = registerBlockCopy("zigzagged_red_nether_bricks", Blocks.NETHER_BRICKS);
    public static final Block NETHER_PILLAR = registerPillar("nether", Blocks.NETHER_BRICKS);
    public static final Block RED_NETHER_PILLAR = registerPillar("red_nether", Blocks.NETHER_BRICKS);

    // Charred Nether Bricks
    public static final Block CHARRED_NETHER_BRICKS = register("charred_nether_bricks", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.BLACK).strength(2.0f, 6.0f).sounds(BlockSoundGroup.NETHER_BRICKS).requiresTool()));
    public static final Block CHARRED_NETHER_BRICKS_STAIRS = registerStairs(CHARRED_NETHER_BRICKS);
    public static final Block CHARRED_NETHER_BRICKS_SLAB = registerSlab(CHARRED_NETHER_BRICKS);
    public static final Block CHARRED_NETHER_BRICKS_WALL = registerWall(CHARRED_NETHER_BRICKS);
    public static final Block SMOOTH_CHARRED_NETHER_BRICKS = registerBlockCopy("smooth_charred_nether_bricks", CHARRED_NETHER_BRICKS);
    public static final Block ZIGZAGGED_CHARRED_NETHER_BRICKS = registerBlockCopy("zigzagged_charred_nether_bricks", CHARRED_NETHER_BRICKS);
    public static final Block CHARRED_NETHER_PILLAR = registerPillar("charred_nether", CHARRED_NETHER_BRICKS);

    // Teal Nether Bricks
    public static final Block TEAL_NETHER_BRICKS = register("teal_nether_bricks", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.CYAN).strength(2.0f, 6.0f).sounds(BlockSoundGroup.NETHER_BRICKS).requiresTool()));
    public static final Block TEAL_NETHER_BRICK_STAIRS = registerStairs("teal_nether_brick", TEAL_NETHER_BRICKS);
    public static final Block TEAL_NETHER_BRICK_SLAB = registerSlab("teal_nether_brick", TEAL_NETHER_BRICKS);
    public static final Block TEAL_NETHER_BRICK_WALL = registerWall("teal_nether_brick", TEAL_NETHER_BRICKS);
    public static final Block SMOOTH_TEAL_NETHER_BRICKS = registerBlockCopy("smooth_teal_nether_bricks", TEAL_NETHER_BRICKS);
    public static final Block ZIGZAGGED_TEAL_NETHER_BRICKS = registerBlockCopy("zigzagged_teal_nether_bricks", TEAL_NETHER_BRICKS);
    public static final Block TEAL_NETHER_PILLAR = registerPillar("teal_nether", TEAL_NETHER_BRICKS);

    // Obsidian
    public static final Block OBSIDIAN_BRICKS = registerBlockCopy("obsidian_bricks", Blocks.OBSIDIAN);
    public static final Block OBSIDIAN_BRICKS_STAIRS = registerStairs(OBSIDIAN_BRICKS);
    public static final Block OBSIDIAN_BRICKS_SLAB = registerSlab(OBSIDIAN_BRICKS);
    public static final Block OBSIDIAN_BRICKS_WALL = registerWall(OBSIDIAN_BRICKS);
    public static final Block CRACKED_OBSIDIAN_BRICKS = registerBlockCopy("cracked_obsidian_bricks", OBSIDIAN_BRICKS);
    public static final Block OBSIDIAN_PILLAR = registerPillar("obsidian", OBSIDIAN_BRICKS);
    public static final Block OBSIDIAN_CIRCLE_PAVEMENT = registerCirclePavement("obsidian", OBSIDIAN_BRICKS);
    public static final Block OBSIDIAN_REINFORCED_DOOR = registerDoor2("obsidian_reinforced", 50.0F, 1200.0F, Material.METAL, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3, MaterialColor.BLACK);
    public static final Block OBSIDIAN_REINFORCED_TRAPDOOR = registerTrapdoor2("obsidian_reinforced", 50.0F, 1200.0F, Material.METAL, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3, MaterialColor.BLACK);
    public static final Block GLOWING_OBSIDIAN = registerLightBlock("glowing_obsidian", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, 15, MaterialColor.BLACK);

    // Quartz Blocks
    public static final Block QUARTZ_TILES = registerBlockCopy("quartz_bricks", Blocks.QUARTZ_BLOCK);
    public static final Block QUARTZ_CIRCLE_PAVEMENT = registerCirclePavement("quartz", QUARTZ_TILES);

    // Prismarine
    public static final Block PRISMARINE_CIRCLE_PAVEMENT = registerCirclePavement("prismarine", Blocks.PRISMARINE);

    // Bricks
    public static final Block LARGE_BRICKS = registerBlockCopy("large_bricks", Blocks.BRICKS);
    public static final Block ZIGZAGGED_BRICKS = registerBlockCopy("zigzagged_bricks", Blocks.BRICKS);

    // Soaked Bricks
    public static final Block SOAKED_BRICKS = register("soaked_bricks", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.CYAN).strength(2.0f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SOAKED_BRICKS_STAIRS = registerStairs(SOAKED_BRICKS);
    public static final Block SOAKED_BRICKS_SLAB = registerSlab(SOAKED_BRICKS);
    public static final Block SOAKED_BRICKS_WALL = registerWall(SOAKED_BRICKS);

    // Sandy Bricks
    public static final Block SANDY_BRICKS = register("sandy_bricks", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.SPRUCE).strength(2.0f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SANDY_BRICKS_STAIRS = registerStairs(SANDY_BRICKS);
    public static final Block SANDY_BRICKS_SLAB = registerSlab(SANDY_BRICKS);
    public static final Block SANDY_BRICKS_WALL = registerWall(SANDY_BRICKS);

    // Charred Bricks
    public static final Block CHARRED_BRICKS = register("charred_bricks", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.BLACK).strength(2.0f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block CHARRED_BRICKS_STAIRS = registerStairs(CHARRED_BRICKS);
    public static final Block CHARRED_BRICKS_SLAB = registerSlab(CHARRED_BRICKS);
    public static final Block CHARRED_BRICKS_WALL = registerWall(CHARRED_BRICKS);

    // Sandstone
    public static final Block ROUGH_SANDSTONE = registerBlockCopy("rough_sandstone", Blocks.SANDSTONE);
    public static final Block ROUGH_SANDSTONE_STAIRS = registerStairs(ROUGH_SANDSTONE);
    public static final Block ROUGH_SANDSTONE_SLAB = registerSlab(ROUGH_SANDSTONE);
    public static final Block SANDSTONE_BRICKS = registerBlockCopy("sandstone_bricks", Blocks.SANDSTONE);
    public static final Block SANDSTONE_BRICKS_STAIRS = registerStairs(SANDSTONE_BRICKS);
    public static final Block SANDSTONE_BRICKS_SLAB = registerSlab(SANDSTONE_BRICKS);
    public static final Block SMALL_SANDSTONE_BRICKS = registerBlockCopy("small_sandstone_bricks", Blocks.SANDSTONE);
    public static final Block SMALL_SANDSTONE_BRICKS_STAIRS = registerStairs(SMALL_SANDSTONE_BRICKS);
    public static final Block SMALL_SANDSTONE_BRICKS_SLAB = registerSlab(SMALL_SANDSTONE_BRICKS);
    public static final Block SANDSTONE_PILLAR = registerPillar("sandstone", Blocks.SANDSTONE);

    // Red Sandstone
    public static final Block ROUGH_RED_SANDSTONE = registerBlockCopy("rough_red_sandstone", Blocks.RED_SANDSTONE);
    public static final Block ROUGH_RED_SANDSTONE_STAIRS = registerStairs(ROUGH_RED_SANDSTONE);
    public static final Block ROUGH_RED_SANDSTONE_SLAB = registerSlab(ROUGH_RED_SANDSTONE);
    public static final Block RED_SANDSTONE_BRICKS = registerBlockCopy("red_sandstone_bricks", Blocks.RED_SANDSTONE);
    public static final Block RED_SANDSTONE_BRICKS_STAIRS = registerStairs(RED_SANDSTONE_BRICKS);
    public static final Block RED_SANDSTONE_BRICKS_SLAB = registerSlab(RED_SANDSTONE_BRICKS);
    public static final Block SMALL_RED_SANDSTONE_BRICKS = registerBlockCopy("small_red_sandstone_bricks", Blocks.RED_SANDSTONE);
    public static final Block SMALL_RED_SANDSTONE_BRICKS_STAIRS = registerStairs(SMALL_RED_SANDSTONE_BRICKS);
    public static final Block SMALL_RED_SANDSTONE_BRICKS_SLAB = registerSlab(SMALL_RED_SANDSTONE_BRICKS);
    public static final Block RED_SANDSTONE_PILLAR = registerPillar("red_sandstone", Blocks.RED_SANDSTONE);

    // Soul Sandstone
    public static final Block SOUL_SANDSTONE = register("soul_sandstone", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.BROWN).strength(0.8f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SOUL_SANDSTONE_STAIRS = registerStairs(SOUL_SANDSTONE);
    public static final Block SOUL_SANDSTONE_SLAB = registerSlab(SOUL_SANDSTONE);
    public static final Block SOUL_SANDSTONE_WALL = registerWall(SOUL_SANDSTONE);
    public static final Block SOUL_SANDSTONE_BRICKS = registerBlockCopy("soul_sandstone_bricks", SOUL_SANDSTONE);
    public static final Block SOUL_SANDSTONE_BRICKS_STAIRS = registerStairs(SOUL_SANDSTONE_BRICKS);
    public static final Block SOUL_SANDSTONE_BRICKS_SLAB = registerSlab(SOUL_SANDSTONE_BRICKS);
    public static final Block SMOOTH_SOUL_SANDSTONE = registerBlockCopy("smooth_soul_sandstone", SOUL_SANDSTONE);
    public static final Block SMOOTH_SOUL_SANDSTONE_STAIRS = registerStairs(SMOOTH_SOUL_SANDSTONE);
    public static final Block SMOOTH_SOUL_SANDSTONE_SLAB = registerSlab(SMOOTH_SOUL_SANDSTONE);
    public static final Block ROUGH_SOUL_SANDSTONE = registerBlockCopy("rough_soul_sandstone", SOUL_SANDSTONE);
    public static final Block ROUGH_SOUL_SANDSTONE_STAIRS = registerStairs(ROUGH_SOUL_SANDSTONE);
    public static final Block ROUGH_SOUL_SANDSTONE_SLAB = registerSlab(ROUGH_SOUL_SANDSTONE);
    public static final Block CUT_SOUL_SANDSTONE = registerBlockCopy("cut_soul_sandstone", SOUL_SANDSTONE);
    public static final Block CUT_SOUL_SANDSTONE_SLAB = registerSlab(CUT_SOUL_SANDSTONE);
    public static final Block CHISELED_SOUL_SANDSTONE = registerBlockCopy("chiseled_soul_sandstone", SOUL_SANDSTONE);
    public static final Block SMALL_SOUL_SANDSTONE_BRICKS = registerBlockCopy("small_soul_sandstone_bricks", SOUL_SANDSTONE);
    public static final Block SMALL_SOUL_SANDSTONE_BRICKS_STAIRS = registerStairs(SMALL_SOUL_SANDSTONE_BRICKS);
    public static final Block SMALL_SOUL_SANDSTONE_BRICKS_SLAB = registerSlab(SMALL_SOUL_SANDSTONE_BRICKS);
    public static final Block SOUL_SANDSTONE_PILLAR = registerPillar("soul_sandstone", SOUL_SANDSTONE);

    // Honeycomb Bricks
    public static final Block HONEYCOMB_BRICKS = registerBlockCopy("honeycomb_bricks", Blocks.HONEYCOMB_BLOCK);
    public static final Block HONEYCOMB_BRICKS_STAIRS = registerStairs(HONEYCOMB_BRICKS);
    public static final Block HONEYCOMB_BRICKS_SLAB = registerSlab(HONEYCOMB_BRICKS);
    public static final Block HONEYCOMB_BRICKS_WALL = registerWall(HONEYCOMB_BRICKS);

    // End Stone
    public static final Block CHISELED_END_STONE_BRICKS = registerBlockCopy("chiseled_end_stone_bricks", Blocks.END_STONE_BRICKS);
    public static final Block ZIGZAGGED_END_STONE_BRICKS = registerBlockCopy("zigzagged_end_stone_bricks", Blocks.END_STONE_BRICKS);
    public static final Block POLISHED_END_STONE = registerBlockCopy("polished_end_stone", Blocks.END_STONE_BRICKS);
    public static final Block CRACKED_END_STONE_BRICKS = registerBlockCopy("cracked_end_stone_bricks", Blocks.END_STONE_BRICKS);
    public static final Block END_STONE_PILLAR = registerPillar("end_stone", Blocks.END_STONE_BRICKS);

    // Purpur Blocks
    public static final Block PURPUR_BRICKS = registerBlockCopy("purpur_bricks", Blocks.PURPUR_BLOCK);
    public static final Block SMOOTH_PURPUR = registerBlockCopy("smooth_purpur", Blocks.PURPUR_BLOCK);
    public static final Block SMOOTH_PURPUR_STAIRS = registerStairs(SMOOTH_PURPUR);
    public static final Block SMOOTH_PURPUR_SLAB = registerSlab(SMOOTH_PURPUR);
    public static final Block PURPUR_SQUARES = registerBlockCopy("purpur_squares", Blocks.PURPUR_BLOCK);
    public static final Block PURPUR_LITTLE_BRICKS = registerBlockCopy("purpur_little_bricks", Blocks.PURPUR_BLOCK);
    public static final Block CHISELED_PURPUR = registerBlockCopy("chiseled_purpur", Blocks.PURPUR_BLOCK);
    public static final Block PURPUR_LINES = registerPillar2("purpur_lines", Blocks.PURPUR_BLOCK);

    // Bamboo Wood
    public static final Block BAMBOO_PLANKS = register("bamboo_planks", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.SAND).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0)));
    public static final Block BAMBOO_STAIRS = registerStairs("bamboo", BAMBOO_PLANKS);
    public static final Block BAMBOO_SLAB = registerSlab("bamboo", BAMBOO_PLANKS);
    public static final Block BAMBOO_FENCE = registerFence("bamboo", BAMBOO_PLANKS);
    public static final Block BAMBOO_FENCE_GATE = registerFenceGate("bamboo", BAMBOO_PLANKS);
    public static final Block BAMBOO_DOOR = registerDoor("bamboo", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, BAMBOO_PLANKS.getDefaultMaterialColor());
    public static final Block BAMBOO_TRAPDOOR = registerTrapdoor("bamboo", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, BAMBOO_PLANKS.getDefaultMaterialColor());

    // Charred Wood
    public static final Block CHARRED_PLANKS = register("charred_planks", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.GRAY_TERRACOTTA).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0)));
    public static final Block CHARRED_STAIRS = registerStairs("charred", CHARRED_PLANKS);
    public static final Block CHARRED_SLAB = registerSlab("charred", CHARRED_PLANKS);
    public static final Block CHARRED_FENCE = registerFence("charred", CHARRED_PLANKS);
    public static final Block CHARRED_FENCE_GATE = registerFenceGate("charred", CHARRED_PLANKS);
    public static final Block CHARRED_DOOR = registerDoor("charred", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, CHARRED_PLANKS.getDefaultMaterialColor());
    public static final Block CHARRED_TRAPDOOR = registerTrapdoor("charred", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, CHARRED_PLANKS.getDefaultMaterialColor());

    // White Oak Wood
    public static final Block WHITE_OAK_SAPLING = register_decoration("white_oak_sapling", new SaplingBlockBase(new WhiteOakSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_WHITE_OAK_SAPLING = registerPottedPlant(WHITE_OAK_SAPLING, "white_oak_sapling");
    public static final Block WHITE_OAK_LOG = register("white_oak_log", new PillarBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.LIGHT_GRAY_TERRACOTTA).strength(2.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0)));
    public static final Block STRIPPED_WHITE_OAK_LOG = registerLogs("stripped_white_oak_log", WHITE_OAK_LOG);
    public static final Block WHITE_OAK_WOOD = registerLogs("white_oak_wood", WHITE_OAK_LOG);
    public static final Block STRIPPED_WHITE_OAK_WOOD = registerLogs("stripped_white_oak_wood", WHITE_OAK_LOG);
    public static final Block WHITE_OAK_LEAVES = registerLeaves("white_oak_leaves", Blocks.OAK_LEAVES);
    public static final Block WHITE_OAK_PLANKS = register("white_oak_planks", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0)));
    public static final Block WHITE_OAK_STAIRS = registerStairs("white_oak", WHITE_OAK_PLANKS);
    public static final Block WHITE_OAK_SLAB = registerSlab("white_oak", WHITE_OAK_PLANKS);
    public static final Block WHITE_OAK_FENCE = registerFence("white_oak", WHITE_OAK_PLANKS);
    public static final Block WHITE_OAK_FENCE_GATE = registerFenceGate("white_oak", WHITE_OAK_PLANKS);
    public static final Block WHITE_OAK_DOOR = registerDoor("white_oak", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, WHITE_OAK_PLANKS.getDefaultMaterialColor());
    public static final Block WHITE_OAK_TRAPDOOR = registerTrapdoor("white_oak", 2.0f, 3.0f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, WHITE_OAK_PLANKS.getDefaultMaterialColor());

    // Small Logs
    public static final Block OAK_SMALL_LOGS = registerLogs("oak_small_logs", Blocks.OAK_LOG);
    public static final Block SPRUCE_SMALL_LOGS = registerLogs("spruce_small_logs", Blocks.SPRUCE_LOG);
    public static final Block BIRCH_SMALL_LOGS = registerLogs("birch_small_logs", Blocks.BIRCH_LOG);
    public static final Block JUNGLE_SMALL_LOGS = registerLogs("jungle_small_logs", Blocks.JUNGLE_LOG);
    public static final Block ACACIA_SMALL_LOGS = registerLogs("acacia_small_logs", Blocks.ACACIA_LOG);
    public static final Block DARK_OAK_SMALL_LOGS = registerLogs("dark_oak_small_logs", Blocks.DARK_OAK_LOG);
    public static final Block WARPED_SMALL_STEMS = registerLogs("warped_small_stems", Blocks.WARPED_STEM);
    public static final Block CRIMSON_SMALL_STEMS = registerLogs("crimson_small_stems", Blocks.CRIMSON_STEM);
    public static final Block WHITE_OAK_SMALL_LOGS = registerLogs("white_oak_small_logs", WHITE_OAK_LOG);

    // Timber Frames
    public static final Block OAK_TIMBER_FRAME = registerTimberFrame("oak", Blocks.OAK_PLANKS);
    public static final Block OAK_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("oak_diagonal", Blocks.OAK_PLANKS);
    public static final Block OAK_CROSS_TIMBER_FRAME = registerTimberFrame("oak_cross", Blocks.OAK_PLANKS);
    public static final Block BIRCH_TIMBER_FRAME = registerTimberFrame("birch", Blocks.BIRCH_PLANKS);
    public static final Block BIRCH_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("birch_diagonal", Blocks.BIRCH_PLANKS);
    public static final Block BIRCH_CROSS_TIMBER_FRAME = registerTimberFrame("birch_cross", Blocks.BIRCH_PLANKS);
    public static final Block SPRUCE_TIMBER_FRAME = registerTimberFrame("spruce", Blocks.SPRUCE_PLANKS);
    public static final Block SPRUCE_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("spruce_diagonal", Blocks.SPRUCE_PLANKS);
    public static final Block SPRUCE_CROSS_TIMBER_FRAME = registerTimberFrame("spruce_cross", Blocks.SPRUCE_PLANKS);
    public static final Block JUNGLE_TIMBER_FRAME = registerTimberFrame("jungle", Blocks.JUNGLE_PLANKS);
    public static final Block JUNGLE_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("jungle_diagonal", Blocks.JUNGLE_PLANKS);
    public static final Block JUNGLE_CROSS_TIMBER_FRAME = registerTimberFrame("jungle_cross", Blocks.JUNGLE_PLANKS);
    public static final Block ACACIA_TIMBER_FRAME = registerTimberFrame("acacia", Blocks.ACACIA_PLANKS);
    public static final Block ACACIA_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("acacia_diagonal", Blocks.ACACIA_PLANKS);
    public static final Block ACACIA_CROSS_TIMBER_FRAME = registerTimberFrame("acacia_cross", Blocks.ACACIA_PLANKS);
    public static final Block DARK_OAK_TIMBER_FRAME = registerTimberFrame("dark_oak", Blocks.DARK_OAK_PLANKS);
    public static final Block DARK_OAK_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("dark_oak_diagonal", Blocks.DARK_OAK_PLANKS);
    public static final Block DARK_OAK_CROSS_TIMBER_FRAME = registerTimberFrame("dark_oak_cross", Blocks.DARK_OAK_PLANKS);
    public static final Block WARPED_TIMBER_FRAME = registerTimberFrame("warped", Blocks.WARPED_PLANKS);
    public static final Block WARPED_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("warped_diagonal", Blocks.WARPED_PLANKS);
    public static final Block WARPED_CROSS_TIMBER_FRAME = registerTimberFrame("warped_cross", Blocks.WARPED_PLANKS);
    public static final Block CRIMSON_TIMBER_FRAME = registerTimberFrame("crimson", Blocks.CRIMSON_PLANKS);
    public static final Block CRIMSON_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("crimson_diagonal", Blocks.CRIMSON_PLANKS);
    public static final Block CRIMSON_CROSS_TIMBER_FRAME = registerTimberFrame("crimson_cross", Blocks.CRIMSON_PLANKS);
    public static final Block BAMBOO_TIMBER_FRAME = registerTimberFrame("bamboo", BAMBOO_PLANKS);
    public static final Block BAMBOO_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("bamboo_diagonal", BAMBOO_PLANKS);
    public static final Block BAMBOO_CROSS_TIMBER_FRAME = registerTimberFrame("bamboo_cross", BAMBOO_PLANKS);
    public static final Block CHARRED_TIMBER_FRAME = registerTimberFrame("charred", CHARRED_PLANKS);
    public static final Block CHARRED_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("charred_diagonal", CHARRED_PLANKS);
    public static final Block CHARRED_CROSS_TIMBER_FRAME = registerTimberFrame("charred_cross", CHARRED_PLANKS);
    public static final Block WHITE_OAK_TIMBER_FRAME = registerTimberFrame("white_oak", WHITE_OAK_PLANKS);
    public static final Block WHITE_OAK_DIAGONAL_TIMBER_FRAME = registerOrientableTimberFrame("white_oak_diagonal", WHITE_OAK_PLANKS);
    public static final Block WHITE_OAK_CROSS_TIMBER_FRAME = registerTimberFrame("white_oak_cross", WHITE_OAK_PLANKS);

    // Small Hedges
    public static final Block OAK_SMALL_HEDGE = registerSmallHedge("small_hedge", Blocks.OAK_LEAVES);
    public static final Block SPRUCE_SMALL_HEDGE = registerSmallHedge("spruce_small_hedge", Blocks.SPRUCE_LEAVES);
    public static final Block BIRCH_SMALL_HEDGE = registerSmallHedge("birch_small_hedge", Blocks.BIRCH_LEAVES);
    public static final Block JUNGLE_SMALL_HEDGE = registerSmallHedge("jungle_small_hedge", Blocks.JUNGLE_LEAVES);
    public static final Block ACACIA_SMALL_HEDGE = registerSmallHedge("acacia_small_hedge", Blocks.ACACIA_LEAVES);
    public static final Block DARK_OAK_SMALL_HEDGE = registerSmallHedge("dark_oak_small_hedge", Blocks.DARK_OAK_LEAVES);
    public static final Block WHITE_OAK_SMALL_HEDGE = registerSmallHedge("white_oak_small_hedge", BlockusBlocks.WHITE_OAK_LEAVES);

    // Large Flower Pots
    public static final Block LARGE_FLOWER_POT = registerLargeFlowerPot(Blocks.AIR, "large_flower_pot");
    public static final Block POTTED_ROSE_BUSH = registerPottedDoublePlant(Blocks.ROSE_BUSH, "rose_bush");
    public static final Block POTTED_LILAC = registerPottedDoublePlant(Blocks.LILAC, "lilac");
    public static final Block POTTED_PEONY = registerPottedDoublePlant(Blocks.PEONY, "peony");
    public static final Block POTTED_LARGE_FERN = registerPottedDoublePlant(Blocks.LARGE_FERN, "large_fern");
    public static final Block POTTED_OAK = registerPottedDoublePlant(Blocks.OAK_SAPLING, "oak");
    public static final Block POTTED_SPRUCE = registerPottedDoublePlant(Blocks.SPRUCE_SAPLING, "spruce");
    public static final Block POTTED_BIRCH = registerPottedDoublePlant(Blocks.BIRCH_SAPLING, "birch");
    public static final Block POTTED_JUNGLE = registerPottedDoublePlant(Blocks.JUNGLE_SAPLING, "jungle");
    public static final Block POTTED_ACACIA = registerPottedDoublePlant(Blocks.ACACIA_SAPLING, "acacia");
    public static final Block POTTED_DARK_OAK = registerPottedDoublePlant(Blocks.DARK_OAK_SAPLING, "dark_oak");
    public static final Block POTTED_WHITE_OAK = registerPottedDoublePlant(BlockusBlocks.WHITE_OAK_SAPLING, "white_oak");
    public static final Block POTTED_HUGE_RED_MUSHROOM = registerPottedDoublePlant(Blocks.RED_MUSHROOM, "huge_red_mushroom");
    public static final Block POTTED_HUGE_BROWN_MUSHROOM = registerPottedDoublePlant(Blocks.BROWN_MUSHROOM, "huge_brown_mushroom");
    public static final Block POTTED_HUGE_CRIMSON_FUNGUS = registerPottedDoublePlant(Blocks.CRIMSON_FUNGUS, "huge_crimson_fungus");
    public static final Block POTTED_HUGE_WARPED_FUNGUS = registerPottedDoublePlant(Blocks.WARPED_FUNGUS, "huge_warped_fungus");

    // Food Blocks
    public static final Block SWEET_BERRIES_CRATE = registerCrates("sweet_berries");
    public static final Block SALMON_CRATE = registerCrates("salmon");
    public static final Block PUFFERFISH_CRATE = registerCrates("pufferfish");
    public static final Block TROPICAL_FISH_CRATE = registerCrates("tropical_fish");
    public static final Block COD_CRATE = registerCrates("cod");
    public static final Block COOKIE_BLOCK = register("cookie_block", new CookieBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MaterialColor.ORANGE).strength(0.5F).sounds(BlockSoundGroup.GRASS)));
    public static final Block CHORUS_BLOCK = register("chorus_block", new Block(FabricBlockSettings.of(Material.LEAVES, MaterialColor.PURPLE).strength(0.5f).sounds(BlockSoundGroup.GRASS)));
    public static final Block POTATO_CRATE = registerCrates("potato");
    public static final Block APPLE_CRATE = registerCrates("apple");
    public static final Block BEETROOT_CRATE = registerCrates("beetroot");
    public static final Block CARROT_CRATE = registerCrates("carrot");
    public static final Block BREAD_BOX = register("bread_box", new OrientableBlockBase(FabricBlockSettings.of(Material.WOOD, Blocks.OAK_PLANKS.getDefaultMaterialColor()).strength(2.5f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0)));
    public static final Block GOLDEN_APPLE_CRATE = registerCrates("golden_apple");
    public static final Block GOLDEN_CARROT_CRATE = registerCrates("golden_carrot");

    // Rainbow
    public static final Block RAINBOW_BLOCK = register("rainbow_block", new PillarBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.LIGHT_BLUE).strength(5.0f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block RAINBOW_BRICKS = register("rainbow_bricks", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block RAINBOW_BRICKS_STAIRS = registerStairs(RAINBOW_BRICKS);
    public static final Block RAINBOW_BRICKS_SLAB = registerSlab(RAINBOW_BRICKS);
    public static final Block RAINBOW_BRICKS_WALL = registerWall(RAINBOW_BRICKS);

    // Colored Stone Bricks
    public static final Block WHITE_STONE_BRICKS = registerColoredStoneBricks("white", MaterialColor.WHITE);
    public static final Block ORANGE_STONE_BRICKS = registerColoredStoneBricks("orange", MaterialColor.ORANGE);
    public static final Block MAGENTA_STONE_BRICKS = registerColoredStoneBricks("magenta", MaterialColor.MAGENTA);
    public static final Block LIGHT_BLUE_STONE_BRICKS = registerColoredStoneBricks("light_blue", MaterialColor.LIGHT_BLUE);
    public static final Block YELLOW_STONE_BRICKS = registerColoredStoneBricks("yellow", MaterialColor.YELLOW);
    public static final Block LIME_STONE_BRICKS = registerColoredStoneBricks("lime", MaterialColor.LIME);
    public static final Block PINK_STONE_BRICKS = registerColoredStoneBricks("pink", MaterialColor.PINK);
    public static final Block GRAY_STONE_BRICKS = registerColoredStoneBricks("gray", MaterialColor.GRAY);
    public static final Block CYAN_STONE_BRICKS = registerColoredStoneBricks("cyan", MaterialColor.CYAN);
    public static final Block PURPLE_STONE_BRICKS = registerColoredStoneBricks("purple", MaterialColor.PURPLE);
    public static final Block BLUE_STONE_BRICKS = registerColoredStoneBricks("blue", MaterialColor.BLUE);
    public static final Block BROWN_STONE_BRICKS = registerColoredStoneBricks("brown", MaterialColor.BROWN);
    public static final Block GREEN_STONE_BRICKS = registerColoredStoneBricks("green", MaterialColor.GREEN);
    public static final Block RED_STONE_BRICKS = registerColoredStoneBricks("red", MaterialColor.RED);
    public static final Block BLACK_STONE_BRICKS = registerColoredStoneBricks("black", MaterialColor.BLACK);

    // Redstone Lamps
    public static final Block WHITE_REDSTONE_LAMP = registerRedstoneLamp("white_redstone_lamp");
    public static final Block ORANGE_REDSTONE_LAMP = registerRedstoneLamp("orange_redstone_lamp");
    public static final Block MAGENTA_REDSTONE_LAMP = registerRedstoneLamp("magenta_redstone_lamp");
    public static final Block LIGHT_BLUE_REDSTONE_LAMP = registerRedstoneLamp("light_blue_redstone_lamp");
    public static final Block YELLOW_REDSTONE_LAMP = registerRedstoneLamp("yellow_redstone_lamp");
    public static final Block LIME_REDSTONE_LAMP = registerRedstoneLamp("lime_redstone_lamp");
    public static final Block PINK_REDSTONE_LAMP = registerRedstoneLamp("pink_redstone_lamp");
    public static final Block GRAY_REDSTONE_LAMP = registerRedstoneLamp("gray_redstone_lamp");
    public static final Block LIGHT_GRAY_REDSTONE_LAMP = registerRedstoneLamp("light_gray_redstone_lamp");
    public static final Block CYAN_REDSTONE_LAMP = registerRedstoneLamp("cyan_redstone_lamp");
    public static final Block PURPLE_REDSTONE_LAMP = registerRedstoneLamp("purple_redstone_lamp");
    public static final Block BLUE_REDSTONE_LAMP = registerRedstoneLamp("blue_redstone_lamp");
    public static final Block BROWN_REDSTONE_LAMP = registerRedstoneLamp("brown_redstone_lamp");
    public static final Block GREEN_REDSTONE_LAMP = registerRedstoneLamp("green_redstone_lamp");
    public static final Block RED_REDSTONE_LAMP = registerRedstoneLamp("red_redstone_lamp");
    public static final Block REDSTONE_LAMP_LIT = registerLitRedstoneLamp("redstone_lamp");
    public static final Block WHITE_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("white_redstone_lamp");
    public static final Block ORANGE_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("orange_redstone_lamp");
    public static final Block MAGENTA_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("magenta_redstone_lamp");
    public static final Block LIGHT_BLUE_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("light_blue_redstone_lamp");
    public static final Block YELLOW_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("yellow_redstone_lamp");
    public static final Block LIME_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("lime_redstone_lamp");
    public static final Block PINK_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("pink_redstone_lamp");
    public static final Block GRAY_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("gray_redstone_lamp");
    public static final Block LIGHT_GRAY_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("light_gray_redstone_lamp");
    public static final Block CYAN_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("cyan_redstone_lamp");
    public static final Block PURPLE_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("purple_redstone_lamp");
    public static final Block BLUE_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("blue_redstone_lamp");
    public static final Block BROWN_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("brown_redstone_lamp");
    public static final Block GREEN_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("green_redstone_lamp");
    public static final Block RED_REDSTONE_LAMP_LIT = registerLitRedstoneLamp("red_redstone_lamp");
    public static final Block RAINBOW_LAMP = registerRedstoneLamp("rainbow_lamp");
    public static final Block RAINBOW_LAMP_LIT = registerLitRedstoneLamp("rainbow_lamp");

    // Futurneo Blocks
    public static final Block WHITE_FUTURNEO_BLOCK = registerLampBlock("white_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block ORANGE_FUTURNEO_BLOCK = registerLampBlock("orange_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block MAGENTA_FUTURNEO_BLOCK = registerLampBlock("magenta_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block LIGHT_BLUE_FUTURNEO_BLOCK = registerLampBlock("light_blue_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block YELLOW_FUTURNEO_BLOCK = registerLampBlock("yellow_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block LIME_FUTURNEO_BLOCK = registerLampBlock("lime_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block PINK_FUTURNEO_BLOCK = registerLampBlock("pink_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block GRAY_FUTURNEO_BLOCK = registerLampBlock("gray_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block GRAY_BRIGHT_FUTURNEO_BLOCK = registerLampBlock("gray_bright_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.WHITE);
    public static final Block LIGHT_GRAY_FUTURNEO_BLOCK = registerLampBlock("light_gray_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block CYAN_FUTURNEO_BLOCK = registerLampBlock("cyan_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block PURPLE_FUTURNEO_BLOCK = registerLampBlock("purple_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block BLUE_FUTURNEO_BLOCK = registerLampBlock("blue_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block BROWN_FUTURNEO_BLOCK = registerLampBlock("brown_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block GREEN_FUTURNEO_BLOCK = registerLampBlock("green_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block RED_FUTURNEO_BLOCK = registerLampBlock("red_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);
    public static final Block BLACK_FUTURNEO_BLOCK = registerLampBlock("black_futurneo_block", 0.5f, 0.5f, Material.REDSTONE_LAMP, BlockSoundGroup.GLASS, 15, MaterialColor.BLACK);

    // Asphalt
    public static final Block ASPHALT = register_asphalt("asphalt", DyeColor.BLACK);
    public static final Block WHITE_ASPHALT = register_asphalt("white_asphalt", DyeColor.WHITE);
    public static final Block ORANGE_ASPHALT = register_asphalt("orange_asphalt", DyeColor.ORANGE);
    public static final Block MAGENTA_ASPHALT = register_asphalt("magenta_asphalt", DyeColor.MAGENTA);
    public static final Block LIGHT_BLUE_ASPHALT = register_asphalt("light_blue_asphalt", DyeColor.LIGHT_BLUE);
    public static final Block YELLOW_ASPHALT = register_asphalt("yellow_asphalt", DyeColor.YELLOW);
    public static final Block LIME_ASPHALT = register_asphalt("lime_asphalt", DyeColor.LIME);
    public static final Block PINK_ASPHALT = register_asphalt("pink_asphalt", DyeColor.PINK);
    public static final Block LIGHT_GRAY_ASPHALT = register_asphalt("light_gray_asphalt", DyeColor.LIGHT_GRAY);
    public static final Block GRAY_ASPHALT = register_asphalt("gray_asphalt", DyeColor.GRAY);
    public static final Block CYAN_ASPHALT = register_asphalt("cyan_asphalt", DyeColor.CYAN);
    public static final Block PURPLE_ASPHALT = register_asphalt("purple_asphalt", DyeColor.PURPLE);
    public static final Block BLUE_ASPHALT = register_asphalt("blue_asphalt", DyeColor.BLUE);
    public static final Block BROWN_ASPHALT = register_asphalt("brown_asphalt", DyeColor.BROWN);
    public static final Block GREEN_ASPHALT = register_asphalt("green_asphalt", DyeColor.GREEN);
    public static final Block RED_ASPHALT = register_asphalt("red_asphalt", DyeColor.RED);
    public static final Block ASPHALT_STAIRS = registerAsphaltStairs(ASPHALT);
    public static final Block WHITE_ASPHALT_STAIRS = registerAsphaltStairs(WHITE_ASPHALT);
    public static final Block ORANGE_ASPHALT_STAIRS = registerAsphaltStairs(ORANGE_ASPHALT);
    public static final Block MAGENTA_ASPHALT_STAIRS = registerAsphaltStairs(MAGENTA_ASPHALT);
    public static final Block LIGHT_BLUE_ASPHALT_STAIRS = registerAsphaltStairs(LIGHT_BLUE_ASPHALT);
    public static final Block YELLOW_ASPHALT_STAIRS = registerAsphaltStairs(YELLOW_ASPHALT);
    public static final Block LIME_ASPHALT_STAIRS = registerAsphaltStairs(LIME_ASPHALT);
    public static final Block PINK_ASPHALT_STAIRS = registerAsphaltStairs(PINK_ASPHALT);
    public static final Block LIGHT_GRAY_ASPHALT_STAIRS = registerAsphaltStairs(LIGHT_GRAY_ASPHALT);
    public static final Block GRAY_ASPHALT_STAIRS = registerAsphaltStairs(GRAY_ASPHALT);
    public static final Block CYAN_ASPHALT_STAIRS = registerAsphaltStairs(CYAN_ASPHALT);
    public static final Block PURPLE_ASPHALT_STAIRS = registerAsphaltStairs(PURPLE_ASPHALT);
    public static final Block BLUE_ASPHALT_STAIRS = registerAsphaltStairs(BLUE_ASPHALT);
    public static final Block BROWN_ASPHALT_STAIRS = registerAsphaltStairs(BROWN_ASPHALT);
    public static final Block GREEN_ASPHALT_STAIRS = registerAsphaltStairs(GREEN_ASPHALT);
    public static final Block RED_ASPHALT_STAIRS = registerAsphaltStairs(RED_ASPHALT);
    public static final Block ASPHALT_SLAB = registerAsphaltSlab(ASPHALT);
    public static final Block WHITE_ASPHALT_SLAB = registerAsphaltSlab(WHITE_ASPHALT);
    public static final Block ORANGE_ASPHALT_SLAB = registerAsphaltSlab(ORANGE_ASPHALT);
    public static final Block MAGENTA_ASPHALT_SLAB = registerAsphaltSlab(MAGENTA_ASPHALT);
    public static final Block LIGHT_BLUE_ASPHALT_SLAB = registerAsphaltSlab(LIGHT_BLUE_ASPHALT);
    public static final Block YELLOW_ASPHALT_SLAB = registerAsphaltSlab(YELLOW_ASPHALT);
    public static final Block LIME_ASPHALT_SLAB = registerAsphaltSlab(LIME_ASPHALT);
    public static final Block PINK_ASPHALT_SLAB = registerAsphaltSlab(PINK_ASPHALT);
    public static final Block LIGHT_GRAY_ASPHALT_SLAB = registerAsphaltSlab(LIGHT_GRAY_ASPHALT);
    public static final Block GRAY_ASPHALT_SLAB = registerAsphaltSlab(GRAY_ASPHALT);
    public static final Block CYAN_ASPHALT_SLAB = registerAsphaltSlab(CYAN_ASPHALT);
    public static final Block PURPLE_ASPHALT_SLAB = registerAsphaltSlab(PURPLE_ASPHALT);
    public static final Block BLUE_ASPHALT_SLAB = registerAsphaltSlab(BLUE_ASPHALT);
    public static final Block BROWN_ASPHALT_SLAB = registerAsphaltSlab(BROWN_ASPHALT);
    public static final Block GREEN_ASPHALT_SLAB = registerAsphaltSlab(GREEN_ASPHALT);
    public static final Block RED_ASPHALT_SLAB = registerAsphaltSlab(RED_ASPHALT);

    // Shingles
    public static final Block SHINGLES = registerBlockCopy("shingles", Blocks.TERRACOTTA);
    public static final Block WHITE_SHINGLES = registerBlockCopy("white_shingles", Blocks.WHITE_TERRACOTTA);
    public static final Block ORANGE_SHINGLES = registerBlockCopy("orange_shingles", Blocks.ORANGE_TERRACOTTA);
    public static final Block MAGENTA_SHINGLES = registerBlockCopy("magenta_shingles", Blocks.MAGENTA_TERRACOTTA);
    public static final Block LIGHT_BLUE_SHINGLES = registerBlockCopy("light_blue_shingles", Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final Block YELLOW_SHINGLES = registerBlockCopy("yellow_shingles", Blocks.YELLOW_TERRACOTTA);
    public static final Block LIME_SHINGLES = registerBlockCopy("lime_shingles", Blocks.LIME_TERRACOTTA);
    public static final Block PINK_SHINGLES = registerBlockCopy("pink_shingles", Blocks.PINK_TERRACOTTA);
    public static final Block LIGHT_GRAY_SHINGLES = registerBlockCopy("light_gray_shingles", Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final Block GRAY_SHINGLES = registerBlockCopy("gray_shingles", Blocks.GRAY_TERRACOTTA);
    public static final Block CYAN_SHINGLES = registerBlockCopy("cyan_shingles", Blocks.CYAN_TERRACOTTA);
    public static final Block PURPLE_SHINGLES = registerBlockCopy("purple_shingles", Blocks.PURPLE_TERRACOTTA);
    public static final Block BLUE_SHINGLES = registerBlockCopy("blue_shingles", Blocks.BLUE_TERRACOTTA);
    public static final Block BROWN_SHINGLES = registerBlockCopy("brown_shingles", Blocks.BROWN_TERRACOTTA);
    public static final Block GREEN_SHINGLES = registerBlockCopy("green_shingles", Blocks.GREEN_TERRACOTTA);
    public static final Block RED_SHINGLES = registerBlockCopy("red_shingles", Blocks.RED_TERRACOTTA);
    public static final Block BLACK_SHINGLES = registerBlockCopy("black_shingles", Blocks.BLACK_TERRACOTTA);
    public static final Block SHINGLES_STAIRS = registerStairs(SHINGLES);
    public static final Block WHITE_SHINGLES_STAIRS = registerStairs(WHITE_SHINGLES);
    public static final Block ORANGE_SHINGLES_STAIRS = registerStairs(ORANGE_SHINGLES);
    public static final Block MAGENTA_SHINGLES_STAIRS = registerStairs(MAGENTA_SHINGLES);
    public static final Block LIGHT_BLUE_SHINGLES_STAIRS = registerStairs(LIGHT_BLUE_SHINGLES);
    public static final Block YELLOW_SHINGLES_STAIRS = registerStairs(YELLOW_SHINGLES);
    public static final Block LIME_SHINGLES_STAIRS = registerStairs(LIME_SHINGLES);
    public static final Block PINK_SHINGLES_STAIRS = registerStairs(PINK_SHINGLES);
    public static final Block LIGHT_GRAY_SHINGLES_STAIRS = registerStairs(LIGHT_GRAY_SHINGLES);
    public static final Block GRAY_SHINGLES_STAIRS = registerStairs(GRAY_SHINGLES);
    public static final Block CYAN_SHINGLES_STAIRS = registerStairs(CYAN_SHINGLES);
    public static final Block PURPLE_SHINGLES_STAIRS = registerStairs(PURPLE_SHINGLES);
    public static final Block BLUE_SHINGLES_STAIRS = registerStairs(BLUE_SHINGLES);
    public static final Block BROWN_SHINGLES_STAIRS = registerStairs(BROWN_SHINGLES);
    public static final Block GREEN_SHINGLES_STAIRS = registerStairs(GREEN_SHINGLES);
    public static final Block RED_SHINGLES_STAIRS = registerStairs(RED_SHINGLES);
    public static final Block BLACK_SHINGLES_STAIRS = registerStairs(BLACK_SHINGLES);
    public static final Block SHINGLES_SLAB = registerSlab(SHINGLES);
    public static final Block WHITE_SHINGLES_SLAB = registerSlab(WHITE_SHINGLES);
    public static final Block ORANGE_SHINGLES_SLAB = registerSlab(ORANGE_SHINGLES);
    public static final Block MAGENTA_SHINGLES_SLAB = registerSlab(MAGENTA_SHINGLES);
    public static final Block LIGHT_BLUE_SHINGLES_SLAB = registerSlab(LIGHT_BLUE_SHINGLES);
    public static final Block YELLOW_SHINGLES_SLAB = registerSlab(YELLOW_SHINGLES);
    public static final Block LIME_SHINGLES_SLAB = registerSlab(LIME_SHINGLES);
    public static final Block PINK_SHINGLES_SLAB = registerSlab(PINK_SHINGLES);
    public static final Block LIGHT_GRAY_SHINGLES_SLAB = registerSlab(LIGHT_GRAY_SHINGLES);
    public static final Block GRAY_SHINGLES_SLAB = registerSlab(GRAY_SHINGLES);
    public static final Block CYAN_SHINGLES_SLAB = registerSlab(CYAN_SHINGLES);
    public static final Block PURPLE_SHINGLES_SLAB = registerSlab(PURPLE_SHINGLES);
    public static final Block BLUE_SHINGLES_SLAB = registerSlab(BLUE_SHINGLES);
    public static final Block BROWN_SHINGLES_SLAB = registerSlab(BROWN_SHINGLES);
    public static final Block GREEN_SHINGLES_SLAB = registerSlab(GREEN_SHINGLES);
    public static final Block RED_SHINGLES_SLAB = registerSlab(RED_SHINGLES);
    public static final Block BLACK_SHINGLES_SLAB = registerSlab(BLACK_SHINGLES);

    // Beveled Glass
    public static final Block BEVELED_GLASS = registerGlass("beveled_glass", Blocks.GLASS);
    public static final Block WHITE_BEVELED_GLASS = registerStainedGlass("white_beveled_glass", DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS);
    public static final Block ORANGE_BEVELED_GLASS = registerStainedGlass("orange_beveled_glass", DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS);
    public static final Block MAGENTA_BEVELED_GLASS = registerStainedGlass("magenta_beveled_glass", DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS);
    public static final Block LIGHT_BLUE_BEVELED_GLASS = registerStainedGlass("light_blue_beveled_glass", DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS);
    public static final Block YELLOW_BEVELED_GLASS = registerStainedGlass("yellow_beveled_glass", DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS);
    public static final Block LIME_BEVELED_GLASS = registerStainedGlass("lime_beveled_glass", DyeColor.LIME, Blocks.LIME_STAINED_GLASS);
    public static final Block PINK_BEVELED_GLASS = registerStainedGlass("pink_beveled_glass", DyeColor.PINK, Blocks.PINK_STAINED_GLASS);
    public static final Block LIGHT_GRAY_BEVELED_GLASS = registerStainedGlass("light_gray_beveled_glass", DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS);
    public static final Block GRAY_BEVELED_GLASS = registerStainedGlass("gray_beveled_glass", DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS);
    public static final Block CYAN_BEVELED_GLASS = registerStainedGlass("cyan_beveled_glass", DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS);
    public static final Block PURPLE_BEVELED_GLASS = registerStainedGlass("purple_beveled_glass", DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS);
    public static final Block BLUE_BEVELED_GLASS = registerStainedGlass("blue_beveled_glass", DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS);
    public static final Block BROWN_BEVELED_GLASS = registerStainedGlass("brown_beveled_glass", DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS);
    public static final Block GREEN_BEVELED_GLASS = registerStainedGlass("green_beveled_glass", DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS);
    public static final Block RED_BEVELED_GLASS = registerStainedGlass("red_beveled_glass", DyeColor.RED, Blocks.RED_STAINED_GLASS);
    public static final Block BLACK_BEVELED_GLASS = registerStainedGlass("black_beveled_glass", DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS);
    public static final Block BEVELED_GLASS_PANE = registerPane("beveled_glass_pane", Blocks.GLASS);
    public static final Block WHITE_BEVELED_GLASS_PANE = registerStainedGlassPane("white_beveled_glass_pane", DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS);
    public static final Block ORANGE_BEVELED_GLASS_PANE = registerStainedGlassPane("orange_beveled_glass_pane", DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS);
    public static final Block MAGENTA_BEVELED_GLASS_PANE = registerStainedGlassPane("magenta_beveled_glass_pane", DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS);
    public static final Block LIGHT_BLUE_BEVELED_GLASS_PANE = registerStainedGlassPane("light_blue_beveled_glass_pane", DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS);
    public static final Block YELLOW_BEVELED_GLASS_PANE = registerStainedGlassPane("yellow_beveled_glass_pane", DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS);
    public static final Block LIME_BEVELED_GLASS_PANE = registerStainedGlassPane("lime_beveled_glass_pane", DyeColor.LIME, Blocks.LIME_STAINED_GLASS);
    public static final Block PINK_BEVELED_GLASS_PANE = registerStainedGlassPane("pink_beveled_glass_pane", DyeColor.PINK, Blocks.PINK_STAINED_GLASS);
    public static final Block LIGHT_GRAY_BEVELED_GLASS_PANE = registerStainedGlassPane("light_gray_beveled_glass_pane", DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS);
    public static final Block GRAY_BEVELED_GLASS_PANE = registerStainedGlassPane("gray_beveled_glass_pane", DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS);
    public static final Block CYAN_BEVELED_GLASS_PANE = registerStainedGlassPane("cyan_beveled_glass_pane", DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS);
    public static final Block PURPLE_BEVELED_GLASS_PANE = registerStainedGlassPane("purple_beveled_glass_pane", DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS);
    public static final Block BLUE_BEVELED_GLASS_PANE = registerStainedGlassPane("blue_beveled_glass_pane", DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS);
    public static final Block BROWN_BEVELED_GLASS_PANE = registerStainedGlassPane("brown_beveled_glass_pane", DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS);
    public static final Block GREEN_BEVELED_GLASS_PANE = registerStainedGlassPane("green_beveled_glass_pane", DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS);
    public static final Block RED_BEVELED_GLASS_PANE = registerStainedGlassPane("red_beveled_glass_pane", DyeColor.RED, Blocks.RED_STAINED_GLASS);
    public static final Block BLACK_BEVELED_GLASS_PANE = registerStainedGlassPane("black_beveled_glass_pane", DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS);

    // Patterned Wools
    public static final Block WHITE_PATTERNED_WOOL = registerPatternedWool("white", Blocks.WHITE_WOOL);
    public static final Block ORANGE_PATTERNED_WOOL = registerPatternedWool("orange", Blocks.ORANGE_WOOL);
    public static final Block MAGENTA_PATTERNED_WOOL = registerPatternedWool("magenta", Blocks.MAGENTA_WOOL);
    public static final Block LIGHT_BLUE_PATTERNED_WOOL = registerPatternedWool("light_blue", Blocks.LIGHT_BLUE_WOOL);
    public static final Block YELLOW_PATTERNED_WOOL = registerPatternedWool("yellow", Blocks.YELLOW_WOOL);
    public static final Block LIME_PATTERNED_WOOL = registerPatternedWool("lime", Blocks.LIME_WOOL);
    public static final Block PINK_PATTERNED_WOOL = registerPatternedWool("pink", Blocks.PINK_WOOL);
    public static final Block GRAY_PATTERNED_WOOL = registerPatternedWool("gray", Blocks.GRAY_WOOL);
    public static final Block LIGHT_GRAY_PATTERNED_WOOL = registerPatternedWool("light_gray", Blocks.LIGHT_GRAY_WOOL);
    public static final Block CYAN_PATTERNED_WOOL = registerPatternedWool("cyan", Blocks.CYAN_WOOL);
    public static final Block PURPLE_PATTERNED_WOOL = registerPatternedWool("purple", Blocks.PURPLE_WOOL);
    public static final Block BLUE_PATTERNED_WOOL = registerPatternedWool("blue", Blocks.BLUE_WOOL);
    public static final Block BROWN_PATTERNED_WOOL = registerPatternedWool("brown", Blocks.BROWN_WOOL);
    public static final Block GREEN_PATTERNED_WOOL = registerPatternedWool("green", Blocks.GREEN_WOOL);
    public static final Block RED_PATTERNED_WOOL = registerPatternedWool("red", Blocks.RED_WOOL);
    public static final Block BLACK_PATTERNED_WOOL = registerPatternedWool("black", Blocks.BLACK_WOOL);

    // Colored Tiles
    public static final Block LIGHT_BLUE_WHITE_COLORED_TILES = registerColoredTiles("light_blue_white", MaterialColor.LIGHT_BLUE);
    public static final Block RED_WHITE_COLORED_TILES = registerColoredTiles("red_white", MaterialColor.RED);
    public static final Block BLACK_WHITE_COLORED_TILES = registerColoredTiles("black_white", MaterialColor.BLACK);
    public static final Block LIME_YELLOW_COLORED_TILES = registerColoredTiles("lime_yellow", MaterialColor.LIME);
    public static final Block LIGHT_BLUE_YELLOW_COLORED_TILES = registerColoredTiles("light_blue_yellow", MaterialColor.LIGHT_BLUE);
    public static final Block PINK_MAGENTA_COLORED_TILES = registerColoredTiles("pink_magenta", MaterialColor.PINK);
    public static final Block RED_BLUE_COLORED_TILES = registerColoredTiles("red_blue", MaterialColor.RED);
    public static final Block BLUE_CYAN_COLORED_TILES = registerColoredTiles("blue_cyan", MaterialColor.BLUE);
    public static final Block GREEN_ORANGE_COLORED_TILES = registerColoredTiles("green_orange", MaterialColor.GREEN);
    public static final Block BLACK_GRAY_COLORED_TILES = registerColoredTiles("black_gray", MaterialColor.BLACK);
    public static final Block BLACK_RED_COLORED_TILES = registerColoredTiles("black_red", MaterialColor.BLACK);
    public static final Block BLACK_BLUE_COLORED_TILES = registerColoredTiles("black_blue", MaterialColor.BLACK);
    public static final Block MAGENTA_BLACK_COLORED_TILES = registerColoredTiles("magenta_black", MaterialColor.MAGENTA);
    public static final Block PURPLE_ORANGE_COLORED_TILES = registerColoredTiles("purple_orange", MaterialColor.PURPLE);
    public static final Block PURPLE_BLUE_COLORED_TILES = registerColoredTiles("purple_blue", MaterialColor.PURPLE);
    public static final Block GREEN_BROWN_COLORED_TILES = registerColoredTiles("green_brown", MaterialColor.GREEN);
    public static final Block RAINBOW_COLORED_TILES = registerColoredTiles("rainbow", MaterialColor.LIGHT_BLUE);

    // Glazed Terracotta Pillars
    public static final Block WHITE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.WHITE_GLAZED_TERRACOTTA);
    public static final Block ORANGE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.ORANGE_GLAZED_TERRACOTTA);
    public static final Block MAGENTA_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.MAGENTA_GLAZED_TERRACOTTA);
    public static final Block LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
    public static final Block YELLOW_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.YELLOW_GLAZED_TERRACOTTA);
    public static final Block LIME_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.LIME_GLAZED_TERRACOTTA);
    public static final Block PINK_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.PINK_GLAZED_TERRACOTTA);
    public static final Block GRAY_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.GRAY_GLAZED_TERRACOTTA);
    public static final Block LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
    public static final Block CYAN_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.CYAN_GLAZED_TERRACOTTA);
    public static final Block PURPLE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.PURPLE_GLAZED_TERRACOTTA);
    public static final Block BLUE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.BLUE_GLAZED_TERRACOTTA);
    public static final Block BROWN_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.BROWN_GLAZED_TERRACOTTA);
    public static final Block GREEN_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.GREEN_GLAZED_TERRACOTTA);
    public static final Block RED_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.RED_GLAZED_TERRACOTTA);
    public static final Block BLACK_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.BLACK_GLAZED_TERRACOTTA);

    // Pressure Plates
    public static final Block POLISHED_ANDESITE_PRESSURE_PLATE = registerPressurePlate("polished_andesite", PressurePlateBlock.ActivationRule.MOBS, Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_DIORITE_PRESSURE_PLATE = registerPressurePlate("polished_diorite", PressurePlateBlock.ActivationRule.MOBS, Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_GRANITE_PRESSURE_PLATE = registerPressurePlate("polished_granite", PressurePlateBlock.ActivationRule.MOBS, Blocks.POLISHED_GRANITE);
    public static final Block LIMESTONE_PRESSURE_PLATE = registerPressurePlate("limestone", PressurePlateBlock.ActivationRule.MOBS, LIMESTONE);
    public static final Block MARBLE_PRESSURE_PLATE = registerPressurePlate("marble", PressurePlateBlock.ActivationRule.MOBS, MARBLE);
    public static final Block BLUESTONE_PRESSURE_PLATE = registerPressurePlate("bluestone", PressurePlateBlock.ActivationRule.MOBS, BLUESTONE);
    public static final Block POLISHED_NETHERRACK_PRESSURE_PLATE = registerPressurePlate("polished_netherrack", PressurePlateBlock.ActivationRule.MOBS, BlockusBlocks.POLISHED_NETHERRACK);
    public static final Block POLISHED_END_STONE_PRESSURE_PLATE = registerPressurePlate("polished_end_stone", PressurePlateBlock.ActivationRule.MOBS, BlockusBlocks.POLISHED_END_STONE);
    public static final Block BAMBOO_PRESSURE_PLATE = registerPressurePlate("bamboo", PressurePlateBlock.ActivationRule.EVERYTHING, BAMBOO_PLANKS);
    public static final Block CHARRED_PRESSURE_PLATE = registerPressurePlate("charred", PressurePlateBlock.ActivationRule.EVERYTHING, CHARRED_PLANKS);
    public static final Block WHITE_OAK_PRESSURE_PLATE = registerPressurePlate("white_oak", PressurePlateBlock.ActivationRule.EVERYTHING, WHITE_OAK_PLANKS);

    // Buttons
    public static final Block POLISHED_ANDESITE_BUTTON = registerStoneButton(Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_DIORITE_BUTTON = registerStoneButton(Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_GRANITE_BUTTON = registerStoneButton(Blocks.POLISHED_GRANITE);
    public static final Block LIMESTONE_BUTTON = registerStoneButton(LIMESTONE);
    public static final Block MARBLE_BUTTON = registerStoneButton(MARBLE);
    public static final Block BLUESTONE_BUTTON = registerStoneButton(BLUESTONE);
    public static final Block POLISHED_NETHERRACK_BUTTON = registerStoneButton(POLISHED_NETHERRACK);
    public static final Block POLISHED_END_STONE_BUTTON = registerStoneButton(POLISHED_END_STONE);
    public static final Block BAMBOO_BUTTON = registerWoodenButton("bamboo", BAMBOO_PLANKS);
    public static final Block CHARRED_BUTTON = registerWoodenButton("charred", CHARRED_PLANKS);
    public static final Block WHITE_OAK_BUTTON = registerWoodenButton("white_oak", WHITE_OAK_PLANKS);

    // Thatch
    public static final Block THATCH = registerBlockCopy("thatch", Blocks.HAY_BLOCK);
    public static final Block THATCH_STAIRS = registerStairs(THATCH);
    public static final Block THATCH_SLAB = registerSlab(THATCH);

    // Paper
    public static final Block PAPER_BLOCK = register("paper_block", new Block(FabricBlockSettings.of(Material.WOOL, MaterialColor.QUARTZ).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS)));
    public static final Block BURNED_PAPER_BLOCK = register("burned_paper_block", new Block(FabricBlockSettings.of(Material.WOOL, MaterialColor.STONE).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS)));
    public static final Block PAPER_WALL = registerWoodenPane("paper_wall");
    public static final Block PAPER_DOOR = registerDoor("paper", 0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, MaterialColor.QUARTZ);
    public static final Block PAPER_TRAPDOOR = registerTrapdoor("paper", 0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, MaterialColor.QUARTZ);
    public static final Block PAPER_LAMP = register_decoration("paper_lamp", new PaperLampBlock(FabricBlockSettings.of(Material.WOOL, MaterialColor.QUARTZ).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS).luminance(15)));

    // Iron Plating
    public static final Block IRON_PLATING = registerBlockCopy("iron_plating", Blocks.IRON_BLOCK);
    public static final Block IRON_PLATING_STAIRS = registerStairs(IRON_PLATING);
    public static final Block IRON_PLATING_SLAB = registerSlab(IRON_PLATING);

    // Gates - chains - bars
    public static final Block IRON_GATE = registerGate("iron", Blocks.IRON_DOOR);
    public static final Block GOLDEN_GATE = registerGate("golden", Blocks.IRON_DOOR);
    public static final Block GOLDEN_BARS = registerPane("golden_bars", Blocks.IRON_BARS);
    public static final Block GOLDEN_CHAIN = registerChain("golden", Blocks.CHAIN);

    // Lantern Blocks
    public static final Block LANTERN_BLOCK = registerLanternBlock("lantern_block", Blocks.LANTERN);
    public static final Block SOUL_LANTERN_BLOCK = registerLanternBlock("soul_lantern_block", Blocks.SOUL_LANTERN);
    public static final Block SOUL_O_LANTERN = register("soul_o_lantern", new CarvedPumpkinBlockBase(FabricBlockSettings.of(Material.GOURD, MaterialColor.ORANGE).strength(1).sounds(BlockSoundGroup.WOOD).luminance(10).breakByTool(FabricToolTags.AXES, 0)));

    // Barriers
    public static final Block CAUTION_BARRIER_BLOCK = registerBarrier("caution", 1.5f, 1200.0f);
    public static final Block ROAD_BARRIER_BLOCK = registerBarrier("road", 2f, 6.0f);

    // Netherite Blocks
    public static final Block NETHERITE_STAIRS = registerFireproofStairs("netherite", Blocks.NETHERITE_BLOCK);
    public static final Block NETHERITE_SLAB = registerFireproofSlab("netherite", Blocks.NETHERITE_BLOCK);

    // Other
    public static final Block STARS_BLOCK = register("stars_block", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BLACK).strength(5.0f, 6.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.PICKAXES, 1)));
    public static final Block ENDER_BLOCK = register("ender_block", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.GREEN_TERRACOTTA).strength(5.0f, 6.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.PICKAXES, 1)));
    public static final Block MEMBRANE_BLOCK = register("membrane_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, MaterialColor.WHITE_TERRACOTTA).strength(1.5f).sounds(BlockSoundGroup.SLIME)));
    public static final Block ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, MaterialColor.RED_TERRACOTTA).strength(1.5f).sounds(BlockSoundGroup.SLIME)));
    public static final Block NETHER_STARS_BLOCK = register("nether_stars_block", new NetherStarsBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.QUARTZ).strength(5.0f, 6.0f).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool()));
    public static final Block STURDY_STONE = register("sturdy_stone", new SturdyStoneBlock(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block CAUTION_BLOCK = register("caution_block", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.ORANGE).strength(1.5f, 1200.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block WOODEN_FRAME = registerWoodenPane("wooden_frame");
    public static final Block SUGAR_BLOCK = registerFallingBlock("sugar_block", 0.5f, 0.5f, Material.AGGREGATE, BlockSoundGroup.SAND, FabricToolTags.SHOVELS, 0, MaterialColor.QUARTZ);
    public static final Block REDSTONE_SAND = register_redstone("redstone_sand", new FallingRedstoneBlock(FabricBlockSettings.of(Material.AGGREGATE, MaterialColor.LAVA).strength(2.0f, 6.0f).sounds(BlockSoundGroup.SAND).breakByTool(FabricToolTags.SHOVELS, 0)));
    public static final Block LOVE_BLOCK = register("love_block", new LoveBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.PINK).strength(2, 6.0f).requiresTool()));
    public static final Block WEIGHT_STORAGE_CUBE = registerFallingBlock("weight_storage_cube", 0.1f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.IRON);
    public static final Block COMPANION_CUBE = registerFallingBlock("companion_cube", 0.1f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.IRON);
    public static final Block PATH = register_decoration("dirt_path", new PathBlock(FabricBlockSettings.copy(Blocks.GRASS_PATH)));

    // Legacy
    public static final Block LEGACY_GRASS_BLOCK = registerBlockCopy("legacy_grass_block", Blocks.GRASS_BLOCK);
    public static final Block LEGACY_LEAVES = registerLeaves("legacy_leaves", Blocks.OAK_LEAVES);
    public static final Block LEGACY_BRICKS = registerBlockCopy("legacy_bricks", Blocks.BRICKS);
    public static final Block LEGACY_PLANKS = registerBlockCopy("legacy_planks", Blocks.OAK_PLANKS);
    public static final Block LEGACY_COBBLESTONE = registerBlockCopy("legacy_cobblestone", Blocks.COBBLESTONE);
    public static final Block LEGACY_MOSSY_COBBLESTONE = registerBlockCopy("legacy_mossy_cobblestone", Blocks.MOSSY_COBBLESTONE);
    public static final Block LEGACY_GRAVEL = register("legacy_gravel", new GravelBlock(FabricBlockSettings.copy(Blocks.GRAVEL)));
    public static final Block LEGACY_IRON_BLOCK = registerBlockCopy("legacy_iron_block", Blocks.IRON_BLOCK);
    public static final Block LEGACY_GOLD_BLOCK = registerBlockCopy("legacy_gold_block", Blocks.GOLD_BLOCK);
    public static final Block EXPLOSION_PROOF_LEGACY_GOLD_BLOCK = register("legacy_explosion_proof_gold_block", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.GOLD).strength(5.0f, 6000.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block LEGACY_DIAMOND_BLOCK = registerBlockCopy("legacy_diamond_block", Blocks.DIAMOND_BLOCK);
    public static final Block LEGACY_LAPIS_BLOCK = registerBlockCopy("legacy_lapis_block", Blocks.LAPIS_BLOCK);
    public static final Block LEGACY_SPONGE = register("legacy_sponge", new SpongeBlockBase(FabricBlockSettings.copy(Blocks.SPONGE)));
    public static final Block LEGACY_CRYING_OBSIDIAN = registerBlockCopy("legacy_crying_obsidian", Blocks.CRYING_OBSIDIAN);
    public static final Block LEGACY_STONECUTTER = register("legacy_stonecutter", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).strength(1.5f, 17.5f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block LEGACY_GLOWING_OBSIDIAN = registerLightBlock("legacy_glowing_obsidian", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, 12, MaterialColor.BLACK);
    public static final Block NETHER_REACTOR_CORE = register("legacy_nether_reactor_core", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.LIGHT_BLUE).strength(1.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));

    // Barrels
    public static final BarrelBlockBase OAK_BARREL = new BarrelBlockBase("oak_barrel", Blocks.OAK_PLANKS.getDefaultMaterialColor());
    public static final BarrelBlockBase BIRCH_BARREL = new BarrelBlockBase("birch_barrel", Blocks.BIRCH_PLANKS.getDefaultMaterialColor());
    public static final BarrelBlockBase JUNGLE_BARREL = new BarrelBlockBase("jungle_barrel", Blocks.JUNGLE_PLANKS.getDefaultMaterialColor());
    public static final BarrelBlockBase ACACIA_BARREL = new BarrelBlockBase("acacia_barrel", Blocks.ACACIA_PLANKS.getDefaultMaterialColor());
    public static final BarrelBlockBase DARK_OAK_BARREL = new BarrelBlockBase("dark_oak_barrel", Blocks.DARK_OAK_PLANKS.getDefaultMaterialColor());
    public static final BarrelBlockBase CRIMSON_BARREL = new BarrelBlockBase("crimson_barrel", Blocks.CRIMSON_PLANKS.getDefaultMaterialColor());
    public static final BarrelBlockBase WARPED_BARREL = new BarrelBlockBase("warped_barrel", Blocks.WARPED_PLANKS.getDefaultMaterialColor());
    public static final BarrelBlockBase WHITE_OAK_BARREL = new BarrelBlockBase("white_oak_barrel", BlockusBlocks.WHITE_OAK_PLANKS.getDefaultMaterialColor());
    public static final BarrelBlockBase BAMBOO_BARREL = new BarrelBlockBase("bamboo_barrel", BlockusBlocks.BAMBOO_PLANKS.getDefaultMaterialColor());
    public static final BarrelBlockBase CHARRED_BARREL = new BarrelBlockBase("charred_barrel", BlockusBlocks.CHARRED_PLANKS.getDefaultMaterialColor());

    public static final BlockEntityType<WoodenBarrelBlockEntity> WOODEN_BARREL = registerBe("wooden_barrel", BlockEntityType.Builder.create(WoodenBarrelBlockEntity::new, OAK_BARREL, BIRCH_BARREL, JUNGLE_BARREL, ACACIA_BARREL, DARK_OAK_BARREL, CRIMSON_BARREL, WARPED_BARREL, WHITE_OAK_BARREL, BAMBOO_BARREL, CHARRED_BARREL));

    @SuppressWarnings("rawtypes")
    private static <T extends BlockEntity> BlockEntityType<T> registerBe(String name, BlockEntityType.Builder<T> builder) {
        Type type = null;
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Blockus.MOD_ID, name), builder.build(type));
    }
}
