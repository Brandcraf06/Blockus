package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.*;
import com.brand.blockus.blocks.base.amethyst.AmethystPillarBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystSlabBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystStairsBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystWallBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.redstone.DoorBase;
import com.brand.blockus.blocks.base.redstone.FallingRedstoneBlock;
import com.brand.blockus.blocks.blockentity.WoodenBarrelBlockEntity;
import com.brand.blockus.blocks.generator.WhiteOakSaplingGenerator;
import com.brand.blockus.content.types.BSSTypes;
import com.brand.blockus.content.types.BSSWTypes;
import com.brand.blockus.content.types.WoodTypesB;
import com.brand.blockus.content.types.WoodTypesNB;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockusBlocks extends BlocksRegistration {

    // Stone
    public static final Block STONE_BRICK_PILLAR = registerPillar(Blocks.STONE_BRICKS);
    public static final Block ZIGZAGGED_STONE_BRICKS = register("zigzagged_stone_bricks", new Block(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_CIRCLE_PAVEMENT = register("stone_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_DOOR = registerRedstone("stone_door", createStoneDoor(1.5f, 20.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.STONE_GRAY));
    public static final Block STONE_TRAPDOOR = registerRedstone("stone_trapdoor", createStoneTrapdoor(1.5f, 20.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.STONE_GRAY));
    public static final Block SMOOTH_STONE_STAIRS = registerStairs(Blocks.SMOOTH_STONE);
    public static final Block STURDY_STONE = register("sturdy_stone", new SturdyStoneBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE)));

    // Andesite
    public static final Block ZIGZAGGED_ANDESITE = register("zigzagged_andesite", new Block(FabricBlockSettings.copy(BSSWTypes.ANDESITE_BRICKS.block)));
    public static final Block CHISELED_ANDESITE_BRICKS = register("chiseled_andesite_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.ANDESITE_BRICKS.block)));
    public static final Block CRACKED_ANDESITE_BRICKS = register("cracked_andesite_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.ANDESITE_BRICKS.block)));
    public static final Block POLISHED_ANDESITE_PILLAR = registerPillar(Blocks.POLISHED_ANDESITE);
    public static final Block ANDESITE_CIRCLE_PAVEMENT = register("andesite_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.ANDESITE_BRICKS.block)));

    // Diorite
    public static final Block ZIGZAGGED_DIORITE = register("zigzagged_diorite", new Block(FabricBlockSettings.copy(BSSWTypes.DIORITE_BRICKS.block)));
    public static final Block CHISELED_DIORITE_BRICKS = register("chiseled_diorite_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.DIORITE_BRICKS.block)));
    public static final Block CRACKED_DIORITE_BRICKS = register("cracked_diorite_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.DIORITE_BRICKS.block)));
    public static final Block POLISHED_DIORITE_PILLAR = registerPillar(Blocks.POLISHED_DIORITE);
    public static final Block DIORITE_CIRCLE_PAVEMENT = register("diorite_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.DIORITE_BRICKS.block)));

    // Granite
    public static final Block ZIGZAGGED_GRANITE = register("zigzagged_granite", new Block(FabricBlockSettings.copy(BSSWTypes.GRANITE_BRICKS.block)));
    public static final Block CHISELED_GRANITE_BRICKS = register("chiseled_granite_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.GRANITE_BRICKS.block)));
    public static final Block CRACKED_GRANITE_BRICKS = register("cracked_granite_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.GRANITE_BRICKS.block)));
    public static final Block POLISHED_GRANITE_PILLAR = registerPillar(Blocks.POLISHED_GRANITE);
    public static final Block GRANITE_CIRCLE_PAVEMENT = register("granite_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.GRANITE_BRICKS.block)));

    // Dripstone
    public static final Block CRACKED_DRIPSTONE_BRICKS = register("cracked_dripstone_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.DRIPSTONE_BRICKS.block)));
    public static final Block CHISELED_DRIPSTONE = register("chiseled_dripstone", new Block(FabricBlockSettings.copy(BSSWTypes.DRIPSTONE_BRICKS.block)));
    public static final Block DRIPSTONE_PILLAR = createPillar("dripstone", BSSWTypes.DRIPSTONE_BRICKS.block);

    // Tuff
    public static final Block CRACKED_TUFF_BRICKS = register("cracked_tuff_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.TUFF_BRICKS.block)));
    public static final Block CHISELED_TUFF = register("chiseled_tuff", new Block(FabricBlockSettings.copy(BSSWTypes.TUFF_BRICKS.block)));
    public static final Block TUFF_PILLAR = createPillar("tuff", BSSTypes.POLISHED_TUFF.block);
    public static final Block ZIGZAGGED_TUFF = register("zigzagged_tuff", new Block(FabricBlockSettings.copy(BSSWTypes.TUFF_BRICKS.block)));
    public static final Block TUFF_CIRCLE_PAVEMENT = register("tuff_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.TUFF_BRICKS.block)));

    // Deepslate
    public static final Block DEEPSLATE_PILLAR = createPillar("deepslate", Blocks.POLISHED_DEEPSLATE);
    public static final Block ZIGZAGGED_DEEPSLATE = register("zigzagged_deepslate", new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final Block DEEPSLATE_CIRCLE_PAVEMENT = register("deepslate_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final Block STURDY_DEEPSLATE = register("sturdy_deepslate", new SturdyStoneBlock(FabricBlockSettings.copy(Blocks.COBBLED_DEEPSLATE)));

    // Amethyst
    public static final Block POLISHED_AMETHYST = register("polished_amethyst", new AmethystBlock(FabricBlockSettings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block POLISHED_AMETHYST_STAIRS = register("polished_amethyst_stairs", new AmethystStairsBlock(POLISHED_AMETHYST.getDefaultState(), FabricBlockSettings.copy(POLISHED_AMETHYST)));
    public static final Block POLISHED_AMETHYST_SLAB = register("polished_amethyst_slab", new AmethystSlabBlock(FabricBlockSettings.copy(POLISHED_AMETHYST)));
    public static final Block AMETHYST_BRICKS = register("amethyst_bricks", new AmethystBlock(FabricBlockSettings.copy(POLISHED_AMETHYST)));
    public static final Block AMETHYST_BRICK_STAIRS = register("amethyst_brick_stairs", new AmethystStairsBlock(AMETHYST_BRICKS.getDefaultState(), FabricBlockSettings.copy(AMETHYST_BRICKS)));
    public static final Block AMETHYST_BRICK_SLAB = register("amethyst_brick_slab", new AmethystSlabBlock(FabricBlockSettings.copy(AMETHYST_BRICKS)));
    public static final Block AMETHYST_BRICK_WALL = registerDecoration("amethyst_brick_wall", new AmethystWallBlock(FabricBlockSettings.copy(AMETHYST_BRICKS)));
    public static final Block CHISELED_AMETHYST = register("chiseled_amethyst", new AmethystBlock(FabricBlockSettings.copy(AMETHYST_BRICKS)));
    public static final Block AMETHYST_PILLAR = register("amethyst_pillar", new AmethystPillarBlock(FabricBlockSettings.copy(AMETHYST_BRICKS)));

    // Blackstone
    public static final Block POLISHED_BLACKSTONE_PILLAR = registerPillar(Blocks.POLISHED_BLACKSTONE);
    public static final Block ZIGZAGGED_POLISHED_BLACKSTONE = register("zigzagged_polished_blackstone", new Block(FabricBlockSettings.copy(Blocks.POLISHED_BLACKSTONE)));
    public static final Block POLISHED_BLACKSTONE_CIRCLE_PAVEMENT = register("polished_blackstone_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(Blocks.POLISHED_BLACKSTONE)));
    public static final Block GOLD_DECORATED_POLISHED_BLACKSTONE = register("gold_decorated_polished_blackstone", new Block(FabricBlockSettings.copy(Blocks.POLISHED_BLACKSTONE)));
    public static final Block STURDY_BLACKSTONE = register("sturdy_blackstone", new SturdyStoneBlock(FabricBlockSettings.copy(Blocks.BLACKSTONE)));
    public static final Block BLACKSTONE_DOOR = registerRedstone("blackstone_door", createStoneDoor(1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.BLACK));
    public static final Block BLACKSTONE_TRAPDOOR = registerRedstone("blackstone_trapdoor", createStoneTrapdoor(1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.BLACK));

    // Basalt
    public static final Block CRACKED_POLISHED_BASALT_BRICKS = register("cracked_polished_basalt_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.POLISHED_BASALT_BRICKS.block)));
    public static final Block POLISHED_BASALT_PILLAR = createPillar("polished_basalt", BSSWTypes.POLISHED_BASALT_BRICKS.block);
    public static final Block ZIGZAGGED_POLISHED_BASALT = register("zigzagged_polished_basalt", new Block(FabricBlockSettings.copy(BSSWTypes.POLISHED_BASALT_BRICKS.block)));
    public static final Block CHISELED_POLISHED_BASALT = register("chiseled_polished_basalt", new Block(FabricBlockSettings.copy(BSSWTypes.POLISHED_BASALT_BRICKS.block)));
    public static final Block POLISHED_BASALT_CIRCLE_PAVEMENT = register("polished_basalt_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.POLISHED_BASALT_BRICKS.block)));

    // Limestone
    public static final Block LIMESTONE_PILLAR = registerPillar(BSSWTypes.LIMESTONE.block);
    public static final Block LIMESTONE_SQUARES = register("limestone_squares", new Block(FabricBlockSettings.copy(BSSWTypes.LIMESTONE_BRICKS.block)));
    public static final Block CHISELED_LIMESTONE = register("chiseled_limestone", new Block(FabricBlockSettings.copy(BSSWTypes.LIMESTONE_BRICKS.block)));
    public static final Block LIMESTONE_CIRCLE_PAVEMENT = register("limestone_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.LIMESTONE_BRICKS.block)));

    // Marble
    public static final Block MARBLE_PILLAR = registerPillar(BSSWTypes.MARBLE.block);
    public static final Block MARBLE_SQUARES = register("marble_squares", new Block(FabricBlockSettings.copy(BSSWTypes.MARBLE_BRICKS.block)));
    public static final Block CHISELED_MARBLE = register("chiseled_marble", new Block(FabricBlockSettings.copy(BSSWTypes.MARBLE_BRICKS.block)));
    public static final Block CHISELED_MARBLE_PILLAR = registerPillar(CHISELED_MARBLE);
    public static final Block MARBLE_CIRCLE_PAVEMENT = register("marble_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.MARBLE_BRICKS.block)));

    // Bluestone
    public static final Block BLUESTONE_PILLAR = registerPillar(BSSWTypes.BLUESTONE.block);
    public static final Block BLUESTONE_SQUARES = register("bluestone_squares", new Block(FabricBlockSettings.copy(BSSWTypes.BLUESTONE_BRICKS.block)));
    public static final Block CHISELED_BLUESTONE = register("chiseled_bluestone", new Block(FabricBlockSettings.copy(BSSWTypes.BLUESTONE_BRICKS.block)));
    public static final Block BLUESTONE_CIRCLE_PAVEMENT = register("bluestone_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.BLUESTONE_BRICKS.block)));
    public static final Block BLUESTONE_LINES = register("bluestone_lines", new PillarBlock(FabricBlockSettings.copy(BSSWTypes.BLUESTONE_BRICKS.block)));

    // Lava	Bricks
    public static final Block CHISELED_LAVA_BRICKS = register("chiseled_lava_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.LAVA_BRICKS.block)));

    // Lava Blackstone Bricks
    public static final Block CHISELED_LAVA_POLISHED_BLACKSTONE = register("chiseled_lava_polished_blackstone", new Block(FabricBlockSettings.copy(BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.block)));

    // Water Bricks
    public static final Block CHISELED_WATER_BRICKS = register("chiseled_water_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.WATER_BRICKS.block)));

    // Snow Bricks
    public static final Block SNOW_BRICKS = register("snow_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f, 3.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SNOW_BRICK_STAIRS = registerStairs(SNOW_BRICKS);
    public static final Block SNOW_BRICK_SLAB = registerSlab(SNOW_BRICKS);
    public static final Block SNOW_BRICK_WALL = registerWall(SNOW_BRICKS);
    public static final Block SNOW_PILLAR = createPillar("snow", SNOW_BRICKS);

    // Ice Bricks
    public static final Block ICE_BRICKS = register("ice_bricks", new Block(FabricBlockSettings.of(Material.DENSE_ICE).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS)));
    public static final Block ICE_BRICK_WALL = registerWall(ICE_BRICKS);
    public static final Block ICE_PILLAR = createPillar("ice", ICE_BRICKS);

    // Magma Bricks
    public static final Block CHISELED_MAGMA_BRICKS = register("chiseled_magma_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.MAGMA_BRICKS.block)));

    // Blaze Bricks
    public static final Block BLAZE_PILLAR = createPillar("blaze", BSSWTypes.BLAZE_BRICKS.block);
    public static final Block BLAZE_LANTERN = register("blaze_lantern", createLampBlock(0.3F, 0.3F, Material.GLASS, BlockSoundGroup.GLASS, 15, MapColor.ORANGE));

    // Netherrack
    public static final Block NETHERRACK_CIRCLE_PAVEMENT = register("netherrack_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSTypes.POLISHED_NETHERRACK.block)));

    // Nether Bricks
    public static final Block POLISHED_NETHER_BRICKS = register("polished_nether_bricks", new Block(FabricBlockSettings.copy(Blocks.NETHER_BRICKS)));
    public static final Block POLISHED_RED_NETHER_BRICKS = register("polished_red_nether_bricks", new Block(FabricBlockSettings.copy(Blocks.RED_NETHER_BRICKS)));
    public static final Block ZIGZAGGED_NETHER_BRICKS = register("zigzagged_nether_bricks", new Block(FabricBlockSettings.copy(Blocks.NETHER_BRICKS)));
    public static final Block ZIGZAGGED_RED_NETHER_BRICKS = register("zigzagged_red_nether_bricks", new Block(FabricBlockSettings.copy(Blocks.RED_NETHER_BRICKS)));
    public static final Block NETHER_BRICK_PILLAR = registerPillar(Blocks.NETHER_BRICKS);
    public static final Block RED_NETHER_BRICK_PILLAR = registerPillar(Blocks.RED_NETHER_BRICKS);

    // Charred Nether Bricks
    public static final Block POLISHED_CHARRED_NETHER_BRICKS = register("polished_charred_nether_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.CHARRED_NETHER_BRICKS.block)));
    public static final Block ZIGZAGGED_CHARRED_NETHER_BRICKS = register("zigzagged_charred_nether_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.CHARRED_NETHER_BRICKS.block)));
    public static final Block CHARRED_NETHER_BRICK_PILLAR = registerPillar(BSSWTypes.CHARRED_NETHER_BRICKS.block);

    // Teal Nether Bricks
    public static final Block POLISHED_TEAL_NETHER_BRICKS = register("polished_teal_nether_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.TEAL_NETHER_BRICKS.block)));
    public static final Block ZIGZAGGED_TEAL_NETHER_BRICKS = register("zigzagged_teal_nether_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.TEAL_NETHER_BRICKS.block)));
    public static final Block TEAL_NETHER_BRICK_PILLAR = registerPillar(BSSWTypes.TEAL_NETHER_BRICKS.block);

    // Obsidian
    public static final Block CRACKED_OBSIDIAN_BRICKS = register("cracked_obsidian_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.OBSIDIAN_BRICKS.block)));
    public static final Block OBSIDIAN_PILLAR = createPillar("obsidian", BSSWTypes.OBSIDIAN_BRICKS.block);
    public static final Block OBSIDIAN_CIRCLE_PAVEMENT = register("obsidian_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.OBSIDIAN_BRICKS.block)));
    public static final Block OBSIDIAN_REINFORCED_DOOR = registerRedstone("obsidian_reinforced_door", createStoneDoor(50.0F, 1200.0F, Material.METAL, BlockSoundGroup.STONE, MapColor.BLACK));
    public static final Block OBSIDIAN_REINFORCED_TRAPDOOR = registerRedstone("obsidian_reinforced_trapdoor", createStoneTrapdoor(50.0F, 1200.0F, Material.METAL, BlockSoundGroup.STONE, MapColor.BLACK));
    public static final Block GLOWING_OBSIDIAN = register("glowing_obsidian", createLightBlock(50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, 15, MapColor.BLACK));

    // Quartz Blocks
    public static final Block QUARTZ_CIRCLE_PAVEMENT = register("quartz_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(BSSWTypes.QUARTZ_TILES.block)));

    // Prismarine
    public static final Block CHISELED_PRISMARINE = register("chiseled_prismarine", new Block(FabricBlockSettings.copy(Blocks.PRISMARINE_BRICKS)));
    public static final Block PRISMARINE_PILLAR = createPillar("prismarine", Blocks.PRISMARINE_BRICKS);
    public static final Block PRISMARINE_CIRCLE_PAVEMENT = register("prismarine_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(Blocks.PRISMARINE_BRICKS)));
    public static final Block CHISELED_DARK_PRISMARINE = register("chiseled_dark_prismarine", new OrientableBlockBase(FabricBlockSettings.copy(Blocks.DARK_PRISMARINE)));
    public static final Block DARK_PRISMARINE_PILLAR = createPillar("dark_prismarine", Blocks.DARK_PRISMARINE);

    // Bricks
    public static final Block ZIGZAGGED_BRICKS = register("zigzagged_bricks", new Block(FabricBlockSettings.copy(Blocks.BRICKS)));

    // Soaked Bricks
    public static final Block ZIGZAGGED_SOAKED_BRICKS = register("zigzagged_soaked_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.SOAKED_BRICKS.block)));

    // Sandy Bricks
    public static final Block ZIGZAGGED_SANDY_BRICKS = register("zigzagged_sandy_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.SANDY_BRICKS.block)));

    // Charred Bricks
    public static final Block ZIGZAGGED_CHARRED_BRICKS = register("zigzagged_charred_bricks", new Block(FabricBlockSettings.copy(BSSWTypes.CHARRED_BRICKS.block)));

    // Sandstone
    public static final Block SANDSTONE_PILLAR = createPillar("sandstone", Blocks.SANDSTONE);
    public static final Block GOLD_DECORATED_SANDSTONE = register("gold_decorated_sandstone", new Block(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block LAPIS_DECORATED_SANDSTONE = register("lapis_decorated_sandstone", new Block(FabricBlockSettings.copy(Blocks.SANDSTONE)));

    // Red Sandstone
    public static final Block RED_SANDSTONE_PILLAR = createPillar("red_sandstone", Blocks.RED_SANDSTONE);
    public static final Block GOLD_DECORATED_RED_SANDSTONE = register("gold_decorated_red_sandstone", new Block(FabricBlockSettings.copy(Blocks.RED_SANDSTONE)));
    public static final Block LAPIS_DECORATED_RED_SANDSTONE = register("lapis_decorated_red_sandstone", new Block(FabricBlockSettings.copy(Blocks.RED_SANDSTONE)));

    // Soul Sandstone
    public static final Block CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new Block(FabricBlockSettings.copy(BSSWTypes.SOUL_SANDSTONE.block)));
    public static final Block CUT_SOUL_SANDSTONE_SLAB = registerSlab(CUT_SOUL_SANDSTONE);
    public static final Block CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new Block(FabricBlockSettings.copy(BSSWTypes.SOUL_SANDSTONE.block)));
    public static final Block SOUL_SANDSTONE_PILLAR = createPillar("soul_sandstone", BSSWTypes.SOUL_SANDSTONE.block);
    public static final Block GOLD_DECORATED_SOUL_SANDSTONE = register("gold_decorated_soul_sandstone", new Block(FabricBlockSettings.copy(BSSWTypes.SOUL_SANDSTONE.block)));
    public static final Block LAPIS_DECORATED_SOUL_SANDSTONE = register("lapis_decorated_soul_sandstone", new Block(FabricBlockSettings.copy(BSSWTypes.SOUL_SANDSTONE.block)));

    // Honeycomb Bricks

    // Purpur Blocks
    public static final Block CHISELED_PURPUR = register("chiseled_purpur", new Block(FabricBlockSettings.copy(BSSWTypes.PURPUR_BRICKS.block)));
    public static final Block PURPUR_SQUARES = register("purpur_squares", new Block(FabricBlockSettings.copy(BSSWTypes.PURPUR_BRICKS.block)));
    public static final Block PURPUR_LINES = register("purpur_lines", new PillarBlock(FabricBlockSettings.copy(BSSWTypes.PURPUR_BRICKS.block)));

    // Phantom Purpur Blocks
    public static final Block PHANTOM_PURPUR_PILLAR = createPillar("phantom_purpur", Blocks.PURPUR_PILLAR);
    public static final Block CHISELED_PHANTOM_PURPUR = register("chiseled_phantom_purpur", new Block(FabricBlockSettings.copy(BSSWTypes.PHANTOM_PURPUR_BRICKS.block)));
    public static final Block PHANTOM_PURPUR_SQUARES = register("phantom_purpur_squares", new Block(FabricBlockSettings.copy(BSSWTypes.PHANTOM_PURPUR_BRICKS.block)));
    public static final Block PHANTOM_PURPUR_LINES = register("phantom_purpur_lines", new PillarBlock(FabricBlockSettings.copy(BSSWTypes.PHANTOM_PURPUR_BRICKS.block)));

    // End Stone
    public static final Block CHISELED_END_STONE_BRICKS = register("chiseled_end_stone_bricks", new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block ZIGZAGGED_END_STONE_BRICKS = register("zigzagged_end_stone_bricks", new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block CRACKED_END_STONE_BRICKS = register("cracked_end_stone_bricks", new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block END_STONE_PILLAR = createPillar("end_stone", Blocks.END_STONE_BRICKS);
    public static final Block PURPUR_DECORATED_END_STONE = register("purpur_decorated_end_stone", new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block PHANTOM_PURPUR_DECORATED_END_STONE = register("phantom_purpur_decorated_end_stone", new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));

    // White Oak Wood
    public static final Block WHITE_OAK_SAPLING = registerDecoration("white_oak_sapling", new SaplingBlockBase(new WhiteOakSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_WHITE_OAK_SAPLING = registerNoItem("potted_white_oak_sapling", createPottedPlant(WHITE_OAK_SAPLING));
    public static final Block WHITE_OAK_LOG = register("white_oak_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)));
    public static final Block STRIPPED_WHITE_OAK_LOG = register("stripped_white_oak_log", new PillarBlock(FabricBlockSettings.copy(WHITE_OAK_LOG)));
    public static final Block WHITE_OAK_WOOD = register("white_oak_wood", new PillarBlock(FabricBlockSettings.copy(WHITE_OAK_LOG)));
    public static final Block STRIPPED_WHITE_OAK_WOOD = register("stripped_white_oak_wood", new PillarBlock(FabricBlockSettings.copy(WHITE_OAK_LOG)));
    public static final Block WHITE_OAK_LEAVES = registerDecoration("white_oak_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.ORANGE).allowsSpawning(BlockusBlocks::canSpawnOnLeaves).suffocates(BlockusBlocks::never).blockVision(BlockusBlocks::never)));

    // Small Logs
    public static final Block OAK_SMALL_LOGS = register("oak_small_logs", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block SPRUCE_SMALL_LOGS = register("spruce_small_logs", new PillarBlock(FabricBlockSettings.copy(Blocks.SPRUCE_LOG)));
    public static final Block BIRCH_SMALL_LOGS = register("birch_small_logs", new PillarBlock(FabricBlockSettings.copy(Blocks.BIRCH_LOG)));
    public static final Block JUNGLE_SMALL_LOGS = register("jungle_small_logs", new PillarBlock(FabricBlockSettings.copy(Blocks.JUNGLE_LOG)));
    public static final Block ACACIA_SMALL_LOGS = register("acacia_small_logs", new PillarBlock(FabricBlockSettings.copy(Blocks.ACACIA_LOG)));
    public static final Block DARK_OAK_SMALL_LOGS = register("dark_oak_small_logs", new PillarBlock(FabricBlockSettings.copy(Blocks.DARK_OAK_LOG)));
    public static final Block WARPED_SMALL_STEMS = register("warped_small_stems", new PillarBlock(FabricBlockSettings.copy(Blocks.WARPED_STEM)));
    public static final Block CRIMSON_SMALL_STEMS = register("crimson_small_stems", new PillarBlock(FabricBlockSettings.copy(Blocks.CRIMSON_STEM)));
    public static final Block WHITE_OAK_SMALL_LOGS = register("white_oak_small_logs", new PillarBlock(FabricBlockSettings.copy(WHITE_OAK_LOG)));

    // Timber Frames

    // Small Hedges
    public static final Block OAK_SMALL_HEDGE = registerSmallHedge("oak_small_hedge", Blocks.OAK_LEAVES);
    public static final Block SPRUCE_SMALL_HEDGE = registerSmallHedge("spruce_small_hedge", Blocks.SPRUCE_LEAVES);
    public static final Block BIRCH_SMALL_HEDGE = registerSmallHedge("birch_small_hedge", Blocks.BIRCH_LEAVES);
    public static final Block JUNGLE_SMALL_HEDGE = registerSmallHedge("jungle_small_hedge", Blocks.JUNGLE_LEAVES);
    public static final Block ACACIA_SMALL_HEDGE = registerSmallHedge("acacia_small_hedge", Blocks.ACACIA_LEAVES);
    public static final Block DARK_OAK_SMALL_HEDGE = registerSmallHedge("dark_oak_small_hedge", Blocks.DARK_OAK_LEAVES);
    public static final Block WHITE_OAK_SMALL_HEDGE = registerSmallHedge("white_oak_small_hedge", WHITE_OAK_LEAVES);
    public static final Block AZALEA_SMALL_HEDGE = registerSmallHedge("azalea_small_hedge", Blocks.AZALEA_LEAVES);
    public static final Block FLOWERING_AZALEA_SMALL_HEDGE = registerSmallHedge("azalea_small_hedge_flowers", Blocks.FLOWERING_AZALEA_LEAVES);
    public static final Block MOSS_SMALL_HEDGE = registerSmallHedge("moss_small_hedge", Blocks.MOSS_BLOCK);
    public static final Block CRIMSON_SMALL_HEDGE = registerSmallHedge("crimson_small_hedge", Blocks.NETHER_WART_BLOCK);
    public static final Block WARPED_SMALL_HEDGE = registerSmallHedge("warped_small_hedge", Blocks.WARPED_WART_BLOCK);

    // Large Flower Pots
    public static final Block LARGE_FLOWER_POT = register("large_flower_pot", createLargeFlowerPot(Blocks.AIR));
    public static final Block POTTED_ROSE_BUSH = registerNoItem("potted_rose_bush", createPottedDoublePlant(Blocks.ROSE_BUSH));
    public static final Block POTTED_LILAC = registerNoItem("potted_lilac", createPottedDoublePlant(Blocks.LILAC));
    public static final Block POTTED_PEONY = registerNoItem( "potted_peony", createPottedDoublePlant(Blocks.PEONY));
    public static final Block POTTED_LARGE_FERN = registerNoItem( "potted_large_fern", createPottedDoublePlant(Blocks.LARGE_FERN));
    public static final Block POTTED_OAK = registerNoItem( "potted_oak", createPottedDoublePlant(Blocks.OAK_SAPLING));
    public static final Block POTTED_SPRUCE = registerNoItem( "potted_spruce", createPottedDoublePlant(Blocks.SPRUCE_SAPLING));
    public static final Block POTTED_BIRCH = registerNoItem( "potted_birch", createPottedDoublePlant(Blocks.BIRCH_SAPLING));
    public static final Block POTTED_JUNGLE = registerNoItem("potted_jungle", createPottedDoublePlant(Blocks.JUNGLE_SAPLING));
    public static final Block POTTED_ACACIA = registerNoItem( "potted_acacia", createPottedDoublePlant(Blocks.ACACIA_SAPLING));
    public static final Block POTTED_DARK_OAK = registerNoItem( "potted_dark_oak", createPottedDoublePlant(Blocks.DARK_OAK_SAPLING));
    public static final Block POTTED_WHITE_OAK = registerNoItem("potted_white_oak", createPottedDoublePlant(WHITE_OAK_SAPLING));
    public static final Block POTTED_HUGE_RED_MUSHROOM = registerNoItem("potted_huge_red_mushroom", createPottedDoublePlant(Blocks.RED_MUSHROOM));
    public static final Block POTTED_HUGE_BROWN_MUSHROOM = registerNoItem( "potted_huge_brown_mushroom", createPottedDoublePlant(Blocks.BROWN_MUSHROOM));
    public static final Block POTTED_HUGE_CRIMSON_FUNGUS = registerNoItem( "potted_huge_crimson_fungus", createPottedDoublePlant(Blocks.CRIMSON_FUNGUS));
    public static final Block POTTED_HUGE_WARPED_FUNGUS = registerNoItem( "potted_huge_warped_fungus", createPottedDoublePlant(Blocks.WARPED_FUNGUS));
    public static final Block POTTED_CACTUS_LARGE = registerNoItem( "potted_cactus_large", createPottedDoublePlant(Blocks.CACTUS));
    public static final Block POTTED_BAMBOO_LARGE = registerNoItem( "potted_bamboo_large", createPottedDoublePlant(Blocks.BAMBOO));
    public static final Block POTTED_AZALEA_LARGE = registerNoItem( "potted_azalea_large", createPottedDoublePlant(Blocks.AZALEA));
    public static final Block POTTED_FLOWERING_AZALEA_LARGE = registerNoItem("potted_flowering_azalea_large", createPottedDoublePlant(Blocks.FLOWERING_AZALEA));


    // Food Blocks
    public static final Block SWEET_BERRIES_CRATE = register("sweet_berries_crate", createCrates());
    public static final Block GLOW_BERRIES_CRATE = register("glow_berries_crate", createLightCrates());
    public static final Block SALMON_CRATE = register("salmon_crate", createCrates());
    public static final Block PUFFERFISH_CRATE = register("pufferfish_crate", createCrates());
    public static final Block TROPICAL_FISH_CRATE = register("tropical_fish_crate", createCrates());
    public static final Block COD_CRATE = register("cod_crate", createCrates());
    public static final Block COOKIE_BLOCK = register("cookie_block", new CookieBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.ORANGE).strength(0.5F).sounds(BlockSoundGroup.GRASS)));
    public static final Block CHORUS_BLOCK = register("chorus_block", new PillarBlock(FabricBlockSettings.of(Material.LEAVES, MapColor.PURPLE).strength(0.5f).sounds(BlockSoundGroup.GRASS)));
    public static final Block POTATO_CRATE = register("potato_crate", createCrates());
    public static final Block APPLE_CRATE = register("apple_crate", createCrates());
    public static final Block GOLDEN_APPLE_CRATE = register("golden_apple_crate", createCrates());
    public static final Block BEETROOT_CRATE = register("beetroot_crate", createCrates());
    public static final Block CARROT_CRATE = register("carrot_crate", createCrates());
    public static final Block GOLDEN_CARROT_CRATE = register("golden_carrot_crate", createCrates());
    public static final Block BREAD_BOX = register("bread_box", new OrientableBlockBase(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.5f)));

    // Rainbow
    public static final Block RAINBOW_ROSE = registerDecoration("rainbow_rose", new FertilizableFlowerBlock(StatusEffects.GLOWING, 8, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block POTTED_RAINBOW_ROSE = registerNoItem("potted_rainbow_rose", createPottedPlant(RAINBOW_ROSE));
    public static final Block RAINBOW_BLOCK = register("rainbow_block", new PillarBlock(FabricBlockSettings.of(Material.STONE, MapColor.LIGHT_BLUE).strength(5.0f, 6.0f).requiresTool()));
    public static final Block RAINBOW_GLOWSTONE = register("rainbow_glowstone", new Block(FabricBlockSettings.copy(Blocks.GLOWSTONE)));

    // Stained Stone Bricks

    // Concrete

    public static final Block CHISELED_WHITE_CONCRETE = register("chiseled_white_concrete", new Block(FabricBlockSettings.copy(Blocks.WHITE_CONCRETE)));
    public static final Block CHISELED_ORANGE_CONCRETE = register("chiseled_orange_concrete", new Block(FabricBlockSettings.copy(Blocks.ORANGE_CONCRETE)));
    public static final Block CHISELED_MAGENTA_CONCRETE = register("chiseled_magenta_concrete", new Block(FabricBlockSettings.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Block CHISELED_LIGHT_BLUE_CONCRETE = register("chiseled_light_blue_concrete", new Block(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block CHISELED_YELLOW_CONCRETE = register("chiseled_yellow_concrete", new Block(FabricBlockSettings.copy(Blocks.YELLOW_CONCRETE)));
    public static final Block CHISELED_LIME_CONCRETE = register("chiseled_lime_concrete", new Block(FabricBlockSettings.copy(Blocks.LIME_CONCRETE)));
    public static final Block CHISELED_PINK_CONCRETE = register("chiseled_pink_concrete", new Block(FabricBlockSettings.copy(Blocks.PINK_CONCRETE)));
    public static final Block CHISELED_GRAY_CONCRETE = register("chiseled_gray_concrete", new Block(FabricBlockSettings.copy(Blocks.GRAY_CONCRETE)));
    public static final Block CHISELED_LIGHT_GRAY_CONCRETE = register("chiseled_light_gray_concrete", new Block(FabricBlockSettings.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block CHISELED_CYAN_CONCRETE = register("chiseled_cyan_concrete", new Block(FabricBlockSettings.copy(Blocks.CYAN_CONCRETE)));
    public static final Block CHISELED_PURPLE_CONCRETE = register("chiseled_purple_concrete", new Block(FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)));
    public static final Block CHISELED_BLUE_CONCRETE = register("chiseled_blue_concrete", new Block(FabricBlockSettings.copy(Blocks.BLUE_CONCRETE)));
    public static final Block CHISELED_BROWN_CONCRETE = register("chiseled_brown_concrete", new Block(FabricBlockSettings.copy(Blocks.BROWN_CONCRETE)));
    public static final Block CHISELED_GREEN_CONCRETE = register("chiseled_green_concrete", new Block(FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)));
    public static final Block CHISELED_RED_CONCRETE = register("chiseled_red_concrete", new Block(FabricBlockSettings.copy(Blocks.RED_CONCRETE)));
    public static final Block CHISELED_BLACK_CONCRETE = register("chiseled_black_concrete", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)));

    public static final Block WHITE_CONCRETE_PILLAR = createPillar("white_concrete", Blocks.WHITE_CONCRETE);
    public static final Block ORANGE_CONCRETE_PILLAR = createPillar("orange_concrete", Blocks.ORANGE_CONCRETE);
    public static final Block MAGENTA_CONCRETE_PILLAR = createPillar("magenta_concrete", Blocks.MAGENTA_CONCRETE);
    public static final Block LIGHT_BLUE_CONCRETE_PILLAR = createPillar("light_blue_concrete", Blocks.LIGHT_BLUE_CONCRETE);
    public static final Block YELLOW_CONCRETE_PILLAR = createPillar("yellow_concrete", Blocks.YELLOW_CONCRETE);
    public static final Block LIME_CONCRETE_PILLAR = createPillar("lime_concrete", Blocks.LIME_CONCRETE);
    public static final Block PINK_CONCRETE_PILLAR = createPillar("pink_concrete", Blocks.PINK_CONCRETE);
    public static final Block GRAY_CONCRETE_PILLAR = createPillar("gray_concrete", Blocks.GRAY_CONCRETE);
    public static final Block LIGHT_GRAY_CONCRETE_PILLAR = createPillar("light_gray_concrete", Blocks.LIGHT_GRAY_CONCRETE);
    public static final Block CYAN_CONCRETE_PILLAR = createPillar("cyan_concrete", Blocks.CYAN_CONCRETE);
    public static final Block PURPLE_CONCRETE_PILLAR = createPillar("purple_concrete", Blocks.PURPLE_CONCRETE);
    public static final Block BLUE_CONCRETE_PILLAR = createPillar("blue_concrete", Blocks.BLUE_CONCRETE);
    public static final Block BROWN_CONCRETE_PILLAR = createPillar("brown_concrete", Blocks.BROWN_CONCRETE);
    public static final Block GREEN_CONCRETE_PILLAR = createPillar("green_concrete", Blocks.GREEN_CONCRETE);
    public static final Block RED_CONCRETE_PILLAR = createPillar("red_concrete", Blocks.RED_CONCRETE);
    public static final Block BLACK_CONCRETE_PILLAR = createPillar("black_concrete", Blocks.BLACK_CONCRETE);

    // Redstone Lamps
    public static final Block WHITE_REDSTONE_LAMP = registerRedstone("white_redstone_lamp", createRedstoneLamp());
    public static final Block ORANGE_REDSTONE_LAMP = registerRedstone("orange_redstone_lamp", createRedstoneLamp());
    public static final Block MAGENTA_REDSTONE_LAMP = registerRedstone("magenta_redstone_lamp", createRedstoneLamp());
    public static final Block LIGHT_BLUE_REDSTONE_LAMP = registerRedstone("light_blue_redstone_lamp", createRedstoneLamp());
    public static final Block YELLOW_REDSTONE_LAMP = registerRedstone("yellow_redstone_lamp", createRedstoneLamp());
    public static final Block LIME_REDSTONE_LAMP = registerRedstone("lime_redstone_lamp", createRedstoneLamp());
    public static final Block PINK_REDSTONE_LAMP = registerRedstone("pink_redstone_lamp", createRedstoneLamp());
    public static final Block GRAY_REDSTONE_LAMP = registerRedstone("gray_redstone_lamp", createRedstoneLamp());
    public static final Block LIGHT_GRAY_REDSTONE_LAMP = registerRedstone("light_gray_redstone_lamp", createRedstoneLamp());
    public static final Block CYAN_REDSTONE_LAMP = registerRedstone("cyan_redstone_lamp", createRedstoneLamp());
    public static final Block PURPLE_REDSTONE_LAMP = registerRedstone("purple_redstone_lamp", createRedstoneLamp());
    public static final Block BLUE_REDSTONE_LAMP = registerRedstone("blue_redstone_lamp", createRedstoneLamp());
    public static final Block BROWN_REDSTONE_LAMP = registerRedstone("brown_redstone_lamp", createRedstoneLamp());
    public static final Block GREEN_REDSTONE_LAMP = registerRedstone("green_redstone_lamp", createRedstoneLamp());
    public static final Block RED_REDSTONE_LAMP = registerRedstone("red_redstone_lamp", createRedstoneLamp());
    public static final Block REDSTONE_LAMP_LIT = register("redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block WHITE_REDSTONE_LAMP_LIT = register("white_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block ORANGE_REDSTONE_LAMP_LIT = register("orange_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block MAGENTA_REDSTONE_LAMP_LIT = register("magenta_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block LIGHT_BLUE_REDSTONE_LAMP_LIT = register("light_blue_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block YELLOW_REDSTONE_LAMP_LIT = register("yellow_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block LIME_REDSTONE_LAMP_LIT = register("lime_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block PINK_REDSTONE_LAMP_LIT = register("pink_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block GRAY_REDSTONE_LAMP_LIT = register("gray_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block LIGHT_GRAY_REDSTONE_LAMP_LIT = register("light_gray_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block CYAN_REDSTONE_LAMP_LIT = register("cyan_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block PURPLE_REDSTONE_LAMP_LIT = register("purple_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block BLUE_REDSTONE_LAMP_LIT = register("blue_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block BROWN_REDSTONE_LAMP_LIT = register("brown_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block GREEN_REDSTONE_LAMP_LIT = register("green_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block RED_REDSTONE_LAMP_LIT = register("red_redstone_lamp_lit", createLitRedstoneLamp());
    public static final Block RAINBOW_LAMP = registerRedstone("rainbow_lamp", createRedstoneLamp());
    public static final Block RAINBOW_LAMP_LIT = register("rainbow_lamp_lit", createLitRedstoneLamp());

    // Neon Blocks
    public static final Block WHITE_NEON = register("white_neon", createNeonBlock(DyeColor.WHITE));
    public static final Block ORANGE_NEON = register("orange_neon", createNeonBlock(DyeColor.ORANGE));
    public static final Block MAGENTA_NEON = register("magenta_neon", createNeonBlock(DyeColor.MAGENTA));
    public static final Block LIGHT_BLUE_NEON = register("light_blue_neon", createNeonBlock(DyeColor.LIGHT_BLUE));
    public static final Block YELLOW_NEON = register("yellow_neon", createNeonBlock(DyeColor.YELLOW));
    public static final Block LIME_NEON = register("lime_neon", createNeonBlock(DyeColor.LIME));
    public static final Block PINK_NEON = register("pink_neon", createNeonBlock(DyeColor.PINK));
    public static final Block LIGHT_GRAY_NEON = register("light_gray_neon", createNeonBlock(DyeColor.LIGHT_GRAY));
    public static final Block GRAY_NEON = register("gray_neon", createNeonBlock(DyeColor.GRAY));
    public static final Block CYAN_NEON = register("cyan_neon", createNeonBlock(DyeColor.CYAN));
    public static final Block PURPLE_NEON = register("purple_neon", createNeonBlock(DyeColor.PURPLE));
    public static final Block BLUE_NEON = register("blue_neon", createNeonBlock(DyeColor.BLUE));
    public static final Block BROWN_NEON = register("brown_neon", createNeonBlock(DyeColor.BROWN));
    public static final Block GREEN_NEON = register("green_neon", createNeonBlock(DyeColor.GREEN));
    public static final Block RED_NEON = register("red_neon", createNeonBlock(DyeColor.RED));
    public static final Block BLACK_NEON = register("black_neon", createNeonBlock(DyeColor.BLACK));

    // Futurneo Blocks
    public static final Block WHITE_FUTURNEO_BLOCK = register("white_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block ORANGE_FUTURNEO_BLOCK = register("orange_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block MAGENTA_FUTURNEO_BLOCK = register("magenta_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block LIGHT_BLUE_FUTURNEO_BLOCK = register("light_blue_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block YELLOW_FUTURNEO_BLOCK = register("yellow_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block LIME_FUTURNEO_BLOCK = register("lime_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block PINK_FUTURNEO_BLOCK = register("pink_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block GRAY_FUTURNEO_BLOCK = register("gray_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block GRAY_BRIGHT_FUTURNEO_BLOCK = register("gray_bright_futurneo_block", createFuturneoBlock(MapColor.WHITE));
    public static final Block LIGHT_GRAY_FUTURNEO_BLOCK = register("light_gray_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block CYAN_FUTURNEO_BLOCK = register("cyan_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block PURPLE_FUTURNEO_BLOCK = register("purple_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block BLUE_FUTURNEO_BLOCK = register("blue_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block BROWN_FUTURNEO_BLOCK = register("brown_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block GREEN_FUTURNEO_BLOCK = register("green_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block RED_FUTURNEO_BLOCK = register("red_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block BLACK_FUTURNEO_BLOCK = register("black_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block RAINBOW_FUTURNEO_BLOCK = register("rainbow_futurneo_block", createFuturneoBlock(MapColor.BLACK));

    // Asphalt
    public static final Block RAINBOW_ASPHALT = register("rainbow_asphalt",new AsphaltBlock(FabricBlockSettings.of(Material.STONE, DyeColor.BLUE).strength(1.5f, 6.0f).requiresTool()));

    // Shingles

    // Glass - Beveled Glass
    public static final Block RAINBOW_GLASS = register("rainbow_glass", createStainedGlass(DyeColor.YELLOW, Blocks.GLASS));
    public static final Block RAINBOW_GLASS_PANE = registerDecoration("rainbow_glass_pane", createstainedGlassPane(DyeColor.YELLOW, Blocks.GLASS_PANE));
    public static final Block BEVELED_GLASS = register("beveled_glass", new Block(FabricBlockSettings.copy(Blocks.GLASS)));
    public static final Block WHITE_BEVELED_GLASS = register("white_beveled_glass", createStainedGlass(DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS));
    public static final Block ORANGE_BEVELED_GLASS = register("orange_beveled_glass", createStainedGlass(DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS));
    public static final Block MAGENTA_BEVELED_GLASS = register("magenta_beveled_glass", createStainedGlass(DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS));
    public static final Block LIGHT_BLUE_BEVELED_GLASS = register("light_blue_beveled_glass", createStainedGlass(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS));
    public static final Block YELLOW_BEVELED_GLASS = register("yellow_beveled_glass", createStainedGlass(DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS));
    public static final Block LIME_BEVELED_GLASS = register("lime_beveled_glass", createStainedGlass(DyeColor.LIME, Blocks.LIME_STAINED_GLASS));
    public static final Block PINK_BEVELED_GLASS = register("pink_beveled_glass", createStainedGlass(DyeColor.PINK, Blocks.PINK_STAINED_GLASS));
    public static final Block LIGHT_GRAY_BEVELED_GLASS = register("light_gray_beveled_glass", createStainedGlass(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS));
    public static final Block GRAY_BEVELED_GLASS = register("gray_beveled_glass", createStainedGlass(DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS));
    public static final Block CYAN_BEVELED_GLASS = register("cyan_beveled_glass", createStainedGlass(DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS));
    public static final Block PURPLE_BEVELED_GLASS = register("purple_beveled_glass", createStainedGlass(DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS));
    public static final Block BLUE_BEVELED_GLASS = register("blue_beveled_glass", createStainedGlass(DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS));
    public static final Block BROWN_BEVELED_GLASS = register("brown_beveled_glass", createStainedGlass(DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS));
    public static final Block GREEN_BEVELED_GLASS = register("green_beveled_glass", createStainedGlass(DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS));
    public static final Block RED_BEVELED_GLASS = register("red_beveled_glass", createStainedGlass(DyeColor.RED, Blocks.RED_STAINED_GLASS));
    public static final Block BLACK_BEVELED_GLASS = register("black_beveled_glass", createStainedGlass(DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS));
    public static final Block RAINBOW_BEVELED_GLASS = register("rainbow_beveled_glass", createStainedGlass(DyeColor.YELLOW, RAINBOW_GLASS));
    public static final Block BEVELED_GLASS_PANE = registerDecoration("beveled_glass_pane", new PaneBlockBase(FabricBlockSettings.copy(Blocks.GLASS_PANE)));
    public static final Block WHITE_BEVELED_GLASS_PANE = registerDecoration("white_beveled_glass_pane", createstainedGlassPane(DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS_PANE));
    public static final Block ORANGE_BEVELED_GLASS_PANE = registerDecoration("orange_beveled_glass_pane", createstainedGlassPane(DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS_PANE));
    public static final Block MAGENTA_BEVELED_GLASS_PANE = registerDecoration("magenta_beveled_glass_pane", createstainedGlassPane(DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS_PANE));
    public static final Block LIGHT_BLUE_BEVELED_GLASS_PANE = registerDecoration("light_blue_beveled_glass_pane", createstainedGlassPane(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE));
    public static final Block YELLOW_BEVELED_GLASS_PANE = registerDecoration("yellow_beveled_glass_pane", createstainedGlassPane(DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS_PANE));
    public static final Block LIME_BEVELED_GLASS_PANE = registerDecoration("lime_beveled_glass_pane", createstainedGlassPane(DyeColor.LIME, Blocks.LIME_STAINED_GLASS_PANE));
    public static final Block PINK_BEVELED_GLASS_PANE = registerDecoration("pink_beveled_glass_pane", createstainedGlassPane(DyeColor.PINK, Blocks.PINK_STAINED_GLASS_PANE));
    public static final Block LIGHT_GRAY_BEVELED_GLASS_PANE = registerDecoration("light_gray_beveled_glass_pane", createstainedGlassPane(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE));
    public static final Block GRAY_BEVELED_GLASS_PANE = registerDecoration("gray_beveled_glass_pane", createstainedGlassPane(DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS_PANE));
    public static final Block CYAN_BEVELED_GLASS_PANE = registerDecoration("cyan_beveled_glass_pane", createstainedGlassPane(DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS_PANE));
    public static final Block PURPLE_BEVELED_GLASS_PANE = registerDecoration("purple_beveled_glass_pane", createstainedGlassPane(DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS_PANE));
    public static final Block BLUE_BEVELED_GLASS_PANE = registerDecoration("blue_beveled_glass_pane", createstainedGlassPane(DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS_PANE));
    public static final Block BROWN_BEVELED_GLASS_PANE = registerDecoration("brown_beveled_glass_pane", createstainedGlassPane(DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS_PANE));
    public static final Block GREEN_BEVELED_GLASS_PANE = registerDecoration("green_beveled_glass_pane", createstainedGlassPane(DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS_PANE));
    public static final Block RED_BEVELED_GLASS_PANE = registerDecoration("red_beveled_glass_pane", createstainedGlassPane(DyeColor.RED, Blocks.RED_STAINED_GLASS_PANE));
    public static final Block BLACK_BEVELED_GLASS_PANE = registerDecoration("black_beveled_glass_pane", createstainedGlassPane(DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS_PANE));
    public static final Block RAINBOW_BEVELED_GLASS_PANE = registerDecoration("rainbow_beveled_glass_pane", createstainedGlassPane(DyeColor.YELLOW, RAINBOW_GLASS_PANE));
    public static final Block TINTED_BEVELED_GLASS = register("tinted_beveled_glass", new TintedGlassBlock(FabricBlockSettings.copy(Blocks.TINTED_GLASS).allowsSpawning(BlockusBlocks::never).solidBlock(BlockusBlocks::never).suffocates(BlockusBlocks::never).blockVision(BlockusBlocks::never)));

    // Patterned Wools
    public static final Block WHITE_PATTERNED_WOOL = register("white_patterned_wool", new OrientableBlockBase(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    public static final Block ORANGE_PATTERNED_WOOL = register("orange_patterned_wool", new OrientableBlockBase(FabricBlockSettings.copy(Blocks.ORANGE_WOOL)));
    public static final Block MAGENTA_PATTERNED_WOOL = register("magenta_patterned_wool", new OrientableBlockBase(FabricBlockSettings.copy(Blocks.MAGENTA_WOOL)));
    public static final Block LIGHT_BLUE_PATTERNED_WOOL = register("light_blue_patterned_wool", new OrientableBlockBase(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_WOOL)));
    public static final Block YELLOW_PATTERNED_WOOL = register("yellow_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.YELLOW_WOOL)));
    public static final Block LIME_PATTERNED_WOOL = register("lime_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.LIME_WOOL)));
    public static final Block PINK_PATTERNED_WOOL = register("pink_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.PINK_WOOL)));
    public static final Block GRAY_PATTERNED_WOOL = register("gray_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.GRAY_WOOL)));
    public static final Block LIGHT_GRAY_PATTERNED_WOOL = register("light_gray_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.LIGHT_GRAY_WOOL)));
    public static final Block CYAN_PATTERNED_WOOL = register("cyan_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.CYAN_WOOL)));
    public static final Block PURPLE_PATTERNED_WOOL = register("purple_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.PURPLE_WOOL)));
    public static final Block BLUE_PATTERNED_WOOL = register("blue_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.BLUE_WOOL)));
    public static final Block BROWN_PATTERNED_WOOL = register("brown_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.BROWN_WOOL)));
    public static final Block GREEN_PATTERNED_WOOL = register("green_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.GREEN_WOOL)));
    public static final Block RED_PATTERNED_WOOL = register("red_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.RED_WOOL)));
    public static final Block BLACK_PATTERNED_WOOL = register("black_patterned_wool",  new OrientableBlockBase(FabricBlockSettings.copy(Blocks.BLACK_WOOL)));

    // Colored Tiles
    public static final Block WHITE_COLORED_TILES = register("white_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.WHITE_CONCRETE)));
    public static final Block ORANGE_COLORED_TILES = register("orange_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.ORANGE_CONCRETE)));
    public static final Block MAGENTA_COLORED_TILES = register("magenta_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Block LIGHT_BLUE_COLORED_TILES = register("light_blue_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block YELLOW_COLORED_TILES = register("yellow_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.YELLOW_CONCRETE)));
    public static final Block LIME_COLORED_TILES = register("lime_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.LIME_CONCRETE)));
    public static final Block PINK_COLORED_TILES = register("pink_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.PINK_CONCRETE)));
    public static final Block GRAY_COLORED_TILES = register("gray_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.GRAY_CONCRETE)));
    public static final Block LIGHT_GRAY_COLORED_TILES = register("light_gray_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block CYAN_COLORED_TILES = register("cyan_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.CYAN_CONCRETE)));
    public static final Block PURPLE_COLORED_TILES = register("purple_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)));
    public static final Block BLUE_COLORED_TILES = register("blue_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.BLUE_CONCRETE)));
    public static final Block BROWN_COLORED_TILES = register("brown_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.BROWN_CONCRETE)));
    public static final Block GREEN_COLORED_TILES = register("green_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)));
    public static final Block RED_COLORED_TILES = register("red_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.RED_CONCRETE)));
    public static final Block BLACK_COLORED_TILES = register("black_colored_tiles", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)));

    // Colored Tiles (With white)
    public static final Block ORANGE_WHITE_COLORED_TILES = register("orange_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.ORANGE_CONCRETE)));
    public static final Block MAGENTA_WHITE_COLORED_TILES = register("magenta_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Block LIGHT_BLUE_WHITE_COLORED_TILES = register("light_blue_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block YELLOW_WHITE_COLORED_TILES = register("yellow_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.YELLOW_CONCRETE)));
    public static final Block LIME_WHITE_COLORED_TILES = register("lime_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.LIME_CONCRETE)));
    public static final Block PINK_WHITE_COLORED_TILES = register("pink_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.PINK_CONCRETE)));
    public static final Block GRAY_WHITE_COLORED_TILES = register("gray_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.GRAY_CONCRETE)));
    public static final Block LIGHT_GRAY_WHITE_COLORED_TILES = register("light_gray_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block CYAN_WHITE_COLORED_TILES = register("cyan_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.CYAN_CONCRETE)));
    public static final Block PURPLE_WHITE_COLORED_TILES = register("purple_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)));
    public static final Block BLUE_WHITE_COLORED_TILES = register("blue_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.BLUE_CONCRETE)));
    public static final Block BROWN_WHITE_COLORED_TILES = register("brown_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.BROWN_CONCRETE)));
    public static final Block GREEN_WHITE_COLORED_TILES = register("green_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)));
    public static final Block RED_WHITE_COLORED_TILES = register("red_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.RED_CONCRETE)));
    public static final Block BLACK_WHITE_COLORED_TILES = register("black_white_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)));

    // Other colored Tiles
    public static final Block GRAY_LIGHT_GRAY_COLORED_TILES = register("gray_light_gray_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.GRAY_CONCRETE)));
    public static final Block BLACK_GRAY_COLORED_TILES = register("black_gray_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)));
    public static final Block BLACK_RED_COLORED_TILES = register("black_red_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)));
    public static final Block BLACK_BLUE_COLORED_TILES = register("black_blue_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)));
    public static final Block MAGENTA_BLACK_COLORED_TILES = register("magenta_black_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Block PINK_MAGENTA_COLORED_TILES = register("pink_magenta_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.PINK_CONCRETE)));
    public static final Block PURPLE_ORANGE_COLORED_TILES = register("purple_orange_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)));
    public static final Block PURPLE_BLUE_COLORED_TILES = register("purple_blue_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)));
    public static final Block GREEN_ORANGE_COLORED_TILES = register("green_orange_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)));
    public static final Block GREEN_BROWN_COLORED_TILES = register("green_brown_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)));
    public static final Block LIME_YELLOW_COLORED_TILES = register("lime_yellow_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.LIME_CONCRETE)));
    public static final Block LIGHT_BLUE_YELLOW_COLORED_TILES = register("light_blue_yellow_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block BLUE_CYAN_COLORED_TILES = register("blue_cyan_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.BLUE_CONCRETE)));
    public static final Block RED_BLUE_COLORED_TILES = register("red_blue_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.RED_CONCRETE)));
    public static final Block RAINBOW_COLORED_TILES = register("rainbow_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)));

    // Glazed Terracotta Pillars
    public static final Block WHITE_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.WHITE_GLAZED_TERRACOTTA);
    public static final Block ORANGE_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.ORANGE_GLAZED_TERRACOTTA);
    public static final Block MAGENTA_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.MAGENTA_GLAZED_TERRACOTTA);
    public static final Block LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
    public static final Block YELLOW_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.YELLOW_GLAZED_TERRACOTTA);
    public static final Block LIME_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.LIME_GLAZED_TERRACOTTA);
    public static final Block PINK_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.PINK_GLAZED_TERRACOTTA);
    public static final Block GRAY_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.GRAY_GLAZED_TERRACOTTA);
    public static final Block LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
    public static final Block CYAN_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.CYAN_GLAZED_TERRACOTTA);
    public static final Block PURPLE_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.PURPLE_GLAZED_TERRACOTTA);
    public static final Block BLUE_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.BLUE_GLAZED_TERRACOTTA);
    public static final Block BROWN_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.BROWN_GLAZED_TERRACOTTA);
    public static final Block GREEN_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.GREEN_GLAZED_TERRACOTTA);
    public static final Block RED_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.RED_GLAZED_TERRACOTTA);
    public static final Block BLACK_GLAZED_TERRACOTTA_PILLAR = registerGTPillar(Blocks.BLACK_GLAZED_TERRACOTTA);

    // Pressure Plates
    public static final Block POLISHED_ANDESITE_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_DIORITE_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_GRANITE_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, Blocks.POLISHED_GRANITE);
    public static final Block LIMESTONE_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, BSSWTypes.LIMESTONE.block);
    public static final Block MARBLE_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, BSSWTypes.MARBLE.block);
    public static final Block BLUESTONE_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, BSSWTypes.BLUESTONE.block);
    public static final Block POLISHED_NETHERRACK_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, BSSTypes.POLISHED_NETHERRACK.block);
    public static final Block POLISHED_END_STONE_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, BSSTypes.POLISHED_END_STONE.block);
    public static final Block POLISHED_BASALT_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, Blocks.POLISHED_BASALT);
    public static final Block POLISHED_DEEPSLATE_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, Blocks.POLISHED_DEEPSLATE);
    public static final Block POLISHED_TUFF_PRESSURE_PLATE = registerPressurePlate(PressurePlateBlock.ActivationRule.MOBS, BSSTypes.POLISHED_TUFF.block);

    // Buttons
    public static final Block POLISHED_ANDESITE_BUTTON = registerStoneButton(Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_DIORITE_BUTTON = registerStoneButton(Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_GRANITE_BUTTON = registerStoneButton(Blocks.POLISHED_GRANITE);
    public static final Block LIMESTONE_BUTTON = registerStoneButton(BSSWTypes.LIMESTONE.block);
    public static final Block MARBLE_BUTTON = registerStoneButton(BSSWTypes.MARBLE.block);
    public static final Block BLUESTONE_BUTTON = registerStoneButton(BSSWTypes.BLUESTONE.block);
    public static final Block POLISHED_NETHERRACK_BUTTON = registerStoneButton(BSSTypes.POLISHED_NETHERRACK.block);
    public static final Block POLISHED_END_STONE_BUTTON = registerStoneButton(BSSTypes.POLISHED_END_STONE.block);
    public static final Block POLISHED_BASALT_BUTTON = registerStoneButton(Blocks.POLISHED_BASALT);
    public static final Block POLISHED_DEEPSLATE_BUTTON = registerStoneButton(Blocks.POLISHED_DEEPSLATE);
    public static final Block POLISHED_TUFF_BUTTON = registerStoneButton(BSSTypes.POLISHED_TUFF.block);

    // Thatch

    // Paper
    public static final Block PAPER_BLOCK = register("paper_block", new Block(FabricBlockSettings.of(Material.WOOL, MapColor.OFF_WHITE).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS)));
    public static final Block BURNT_PAPER_BLOCK = register("burned_paper_block", new Block(FabricBlockSettings.of(Material.WOOL, MapColor.STONE_GRAY).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS)));
    public static final Block FRAMED_PAPER_BLOCK = registerDecoration("framed_paper_block", new Block(FabricBlockSettings.of(Material.WOOD, MapColor.OFF_WHITE).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD)));
    public static final Block PAPER_WALL = registerDecoration("paper_wall", createWoodenPane());
    public static final Block PAPER_DOOR = registerRedstone("paper_door", createDoor(0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, MapColor.OFF_WHITE));
    public static final Block PAPER_TRAPDOOR = registerRedstone("paper_trapdoor", createTrapdoor(0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, MapColor.OFF_WHITE));
    public static final Block PAPER_LAMP = registerDecoration("paper_lamp", new PaperLampBlock(FabricBlockSettings.of(Material.WOOL, MapColor.OFF_WHITE).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS).luminance(15)));

    // Plating

    // Gates - chains - bars
    public static final Block IRON_GATE = registerRedstone("iron_gate", new DoorBase(FabricBlockSettings.copy(Blocks.IRON_DOOR)));
    public static final Block GOLDEN_GATE = registerRedstone("golden_gate", new DoorBase(FabricBlockSettings.copy(Blocks.IRON_DOOR)));
    public static final Block GOLDEN_BARS = registerDecoration("golden_bars", new PaneBlockBase(FabricBlockSettings.copy(Blocks.IRON_BARS)));
    public static final Block GOLDEN_CHAIN = registerDecoration("golden_chain", new ChainBlock(FabricBlockSettings.copy(Blocks.CHAIN)));

    // Lantern Blocks
    public static final Block LANTERN_BLOCK = registerDecoration("lantern_block", new Block(FabricBlockSettings.copy(Blocks.LANTERN)));
    public static final Block SOUL_LANTERN_BLOCK = registerDecoration("soul_lantern_block", new Block(FabricBlockSettings.copy(Blocks.SOUL_LANTERN)));
    public static final Block SOUL_O_LANTERN = register("soul_o_lantern", new CarvedPumpkinBlockBase(FabricBlockSettings.copyOf(Blocks.JACK_O_LANTERN).luminance(10)));

    // Barriers
    public static final Block CAUTION_BARRIER = registerDecoration("caution_barrier", createBarrier(1.5f, 1200.0f));
    public static final Block ROAD_BARRIER = registerDecoration("road_barrier", createBarrier(2f, 6.0f));

    // Netherite Blocks
    public static final Block NETHERITE_STAIRS = registerFireproof("netherite_stairs", new StairsBase(Blocks.NETHERITE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    public static final Block NETHERITE_SLAB = registerFireproof("netherite_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));

    // Other
    public static final Block PATH = registerDecoration("path", new PathBlock(FabricBlockSettings.copyOf(Blocks.DIRT_PATH)));
    public static final Block CHARCOAL_BLOCK = register("charcoal_block", new Block(FabricBlockSettings.copy(Blocks.COAL_BLOCK)));
    public static final Block SUGAR_BLOCK = register("sugar_block", createFallingBlock(0.5f, 0.5f, Material.AGGREGATE, BlockSoundGroup.SAND, MapColor.OFF_WHITE));
    public static final Block ENDER_BLOCK = register("ender_block", new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_GREEN).strength(5.0f, 6.0f)));
    public static final Block ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.TERRACOTTA_RED).strength(0.5f).sounds(BlockSoundGroup.SLIME)));
    public static final Block MEMBRANE_BLOCK = register("membrane_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.TERRACOTTA_WHITE).strength(0.5f).sounds(BlockSoundGroup.SLIME)));
    public static final Block NETHER_STAR_BLOCK = registerGlint("nether_stars_block", new NetherStarBlock(FabricBlockSettings.of(Material.STONE, MapColor.OFF_WHITE).strength(5.0f, 6.0f).requiresTool()));
    public static final Block WOODEN_FRAME = registerDecoration("wooden_frame", createWoodenPane());
    public static final Block REDSTONE_SAND = registerRedstone("redstone_sand", new FallingRedstoneBlock(FabricBlockSettings.copyOf(Blocks.SAND).mapColor(MapColor.BRIGHT_RED)));
    public static final Block LOVE_BLOCK = register("love_block", new LoveBlock(FabricBlockSettings.of(Material.STONE, MapColor.PINK).strength(2, 6.0f).requiresTool()));
    public static final Block WEIGHT_STORAGE_CUBE = register("weight_storage_cube", new WeightStorageCubeBlock(FabricBlockSettings.of(Material.STONE, MapColor.IRON_GRAY).strength(0.1f, 6.0f)));;
    public static final Block COMPANION_CUBE = register("companion_cube", createFallingBlock(0.1f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.IRON_GRAY));
    public static final Block CAUTION_BLOCK = register("caution_block", new Block(FabricBlockSettings.of(Material.STONE, MapColor.ORANGE).strength(1.5f, 1200.0f).requiresTool()));
    public static final Block STARS_BLOCK = register("stars_block", new Block(FabricBlockSettings.of(Material.STONE, MapColor.BLACK).strength(5.0f, 6.0f)));

    // Legacy
    public static final Block LEGACY_FIRST_GRASS_BLOCK = registerLegacy("legacy_first_grass_block", new Block(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block LEGACY_GRASS_BLOCK = registerLegacy("legacy_grass_block", new Block(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block LEGACY_LEAVES = registerLegacy("legacy_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.LIME).allowsSpawning(BlockusBlocks::canSpawnOnLeaves).suffocates(BlockusBlocks::never).blockVision(BlockusBlocks::never)));
    public static final Block LEGACY_BRICKS = registerLegacy("legacy_bricks", new Block(FabricBlockSettings.copy( Blocks.BRICKS)));
    public static final Block LEGACY_PLANKS = registerLegacy("legacy_planks", new Block(FabricBlockSettings.copy( Blocks.OAK_PLANKS)));
    public static final Block LEGACY_FIRST_COBBLESTONE = registerLegacy("legacy_first_cobblestone", new Block(FabricBlockSettings.copy( Blocks.COBBLESTONE)));
    public static final Block LEGACY_COBBLESTONE = registerLegacy("legacy_cobblestone", new Block(FabricBlockSettings.copy( Blocks.COBBLESTONE)));
    public static final Block LEGACY_MOSSY_COBBLESTONE = registerLegacy("legacy_mossy_cobblestone", new Block(FabricBlockSettings.copy( Blocks.MOSSY_COBBLESTONE)));
    public static final Block LEGACY_GRAVEL = registerLegacy("legacy_gravel", new GravelBlock(FabricBlockSettings.copyOf(Blocks.GRAVEL)));
    public static final Block LEGACY_IRON_BLOCK = registerLegacy("legacy_iron_block",  new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block LEGACY_GOLD_BLOCK = registerLegacy("legacy_gold_block",  new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block EXPLOSION_PROOF_LEGACY_GOLD_BLOCK = registerLegacy("legacy_explosion_proof_gold_block", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).strength(5.0f, 6000.0f)));
    public static final Block LEGACY_COAL_BLOCK = registerLegacy("legacy_coal_block",  new Block(FabricBlockSettings.copy(Blocks.COAL_BLOCK)));
    public static final Block LEGACY_DIAMOND_BLOCK = registerLegacy("legacy_diamond_block",  new Block(FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK)));
    public static final Block LEGACY_LAPIS_BLOCK = registerLegacy("legacy_lapis_block",  new Block(FabricBlockSettings.copy(Blocks.LAPIS_BLOCK)));
    public static final Block LEGACY_SPONGE = registerLegacy("legacy_sponge", new SpongeBlockBase(FabricBlockSettings.copyOf(Blocks.SPONGE)));
    public static final Block LEGACY_CRYING_OBSIDIAN = registerLegacy("legacy_crying_obsidian",  new Block(FabricBlockSettings.copy(Blocks.CRYING_OBSIDIAN)));
    public static final Block LEGACY_GLOWSTONE = registerLegacy("legacy_glowstone",  new Block(FabricBlockSettings.copy(Blocks.GLOWSTONE)));
    public static final Block LEGACY_STONECUTTER = registerLegacy("legacy_stonecutter", new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f, 17.5f).requiresTool()));
    public static final Block LEGACY_GLOWING_OBSIDIAN = registerLegacy("legacy_glowing_obsidian", createLightBlock(50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, 12, MapColor.BLACK));
    public static final Block NETHER_REACTOR_CORE = registerLegacy("legacy_nether_reactor_core", new Block(FabricBlockSettings.of(Material.STONE, MapColor.LIGHT_BLUE).strength(1.5f, 6.0f).requiresTool()));

    // Barrels (creative)
    public static final BarrelBlockBase OAK_BARREL = new BarrelBlockBase("oak_barrel", Blocks.OAK_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase BIRCH_BARREL = new BarrelBlockBase("birch_barrel", Blocks.BIRCH_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase JUNGLE_BARREL = new BarrelBlockBase("jungle_barrel", Blocks.JUNGLE_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase ACACIA_BARREL = new BarrelBlockBase("acacia_barrel", Blocks.ACACIA_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase DARK_OAK_BARREL = new BarrelBlockBase("dark_oak_barrel", Blocks.DARK_OAK_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase CRIMSON_BARREL = new BarrelBlockBase("crimson_barrel", Blocks.CRIMSON_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase WARPED_BARREL = new BarrelBlockBase("warped_barrel", Blocks.WARPED_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase WHITE_OAK_BARREL = new BarrelBlockBase("white_oak_barrel", WoodTypesB.WHITE_OAK.planks.getDefaultMapColor());
    public static final BarrelBlockBase BAMBOO_BARREL = new BarrelBlockBase("bamboo_barrel", WoodTypesB.BAMBOO.planks.getDefaultMapColor());
    public static final BarrelBlockBase CHARRED_BARREL = new BarrelBlockBase("charred_barrel", WoodTypesNB.CHARRED.planks.getDefaultMapColor());

    public static final BlockEntityType<WoodenBarrelBlockEntity> WOODEN_BARREL = registerBe("wooden_barrel", FabricBlockEntityTypeBuilder.create(WoodenBarrelBlockEntity::new, OAK_BARREL, BIRCH_BARREL, JUNGLE_BARREL, ACACIA_BARREL, DARK_OAK_BARREL, CRIMSON_BARREL, WARPED_BARREL, WHITE_OAK_BARREL, BAMBOO_BARREL, CHARRED_BARREL));

    private static <T extends BlockEntity> BlockEntityType<T> registerBe(String name, FabricBlockEntityTypeBuilder<T> builder) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Blockus.MOD_ID, name), builder.build());
    }
}
