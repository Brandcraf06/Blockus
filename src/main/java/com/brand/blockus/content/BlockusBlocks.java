package com.brand.blockus.content;

import com.brand.blockus.blocks.base.*;
import com.brand.blockus.blocks.base.amethyst.AmethystPillarBlock;
import com.brand.blockus.blocks.base.asphalt.RainbowAsphalt;
import com.brand.blockus.blocks.base.redstone.FallingRedstoneBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneLantern;
import com.brand.blockus.blocks.base.redstone.RedstonePumpkinBlock;
import com.brand.blockus.blocks.generator.BlockusSaplingGenerator;
import com.brand.blockus.content.types.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.DyeColor;

public class BlockusBlocks extends BlocksRegistration {

    // Stone
    public static final BSSWTypes STONE_TILES = new BSSWTypes("stone_tiles", Blocks.STONE_BRICKS);
    public static final Block STONE_BRICK_PILLAR = registerPillar(Blocks.STONE_BRICKS);
    public static final Block HERRINGBONE_STONE_BRICKS = register("herringbone_stone_bricks", createCopy(Blocks.STONE_BRICKS));
    public static final Block STONE_CIRCULAR_PAVING = register("stone_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_DOOR = register("stone_door", createStoneDoor(1.5f, 20.0f, BlockSoundGroup.STONE, MapColor.STONE_GRAY, BlockSetType.STONE));
    public static final Block STONE_TRAPDOOR = register("stone_trapdoor", createStoneTrapdoor(1.5f, 20.0f, BlockSoundGroup.STONE, MapColor.STONE_GRAY, BlockSetType.STONE));
    public static final Block SMOOTH_STONE_STAIRS = registerStairs(Blocks.SMOOTH_STONE);
    public static final Block STURDY_STONE = register("sturdy_stone", new Block(AbstractBlock.Settings.copy(Blocks.COBBLESTONE).pistonBehavior(PistonBehavior.BLOCK)));

    // Andesite
    public static final BSSWTypes ANDESITE_BRICKS = new BSSWTypes("andesite_bricks", Blocks.POLISHED_ANDESITE);
    public static final Block CRACKED_ANDESITE_BRICKS = register("cracked_andesite_bricks", createCopy(BlockusBlocks.ANDESITE_BRICKS.block));
    public static final Block CHISELED_ANDESITE_BRICKS = register("chiseled_andesite_bricks", createCopy(BlockusBlocks.ANDESITE_BRICKS.block));
    public static final Block POLISHED_ANDESITE_PILLAR = registerPillar(Blocks.POLISHED_ANDESITE);

    public static final Block HERRINGBONE_ANDESITE_BRICKS = register("herringbone_andesite_bricks", createCopy(BlockusBlocks.ANDESITE_BRICKS.block));
    public static final Block ANDESITE_CIRCULAR_PAVING = register("andesite_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.ANDESITE_BRICKS.block)));

    // Diorite
    public static final BSSWTypes DIORITE_BRICKS = new BSSWTypes("diorite_bricks", Blocks.POLISHED_DIORITE);
    public static final Block CRACKED_DIORITE_BRICKS = register("cracked_diorite_bricks", createCopy(BlockusBlocks.DIORITE_BRICKS.block));
    public static final Block CHISELED_DIORITE_BRICKS = register("chiseled_diorite_bricks", createCopy(BlockusBlocks.DIORITE_BRICKS.block));
    public static final Block POLISHED_DIORITE_PILLAR = registerPillar(Blocks.POLISHED_DIORITE);
    public static final Block HERRINGBONE_DIORITE_BRICKS = register("herringbone_diorite_bricks", createCopy(BlockusBlocks.DIORITE_BRICKS.block));
    public static final Block DIORITE_CIRCULAR_PAVING = register("diorite_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.DIORITE_BRICKS.block)));

    // Granite
    public static final BSSWTypes GRANITE_BRICKS = new BSSWTypes("granite_bricks", Blocks.POLISHED_GRANITE);
    public static final Block CRACKED_GRANITE_BRICKS = register("cracked_granite_bricks", createCopy(BlockusBlocks.GRANITE_BRICKS.block));
    public static final Block CHISELED_GRANITE_BRICKS = register("chiseled_granite_bricks", createCopy(BlockusBlocks.GRANITE_BRICKS.block));
    public static final Block POLISHED_GRANITE_PILLAR = registerPillar(Blocks.POLISHED_GRANITE);
    public static final Block HERRINGBONE_GRANITE_BRICKS = register("herringbone_granite_bricks", createCopy(BlockusBlocks.GRANITE_BRICKS.block));
    public static final Block GRANITE_CIRCULAR_PAVING = register("granite_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.GRANITE_BRICKS.block)));

    // Mud
    public static final Block CHISELED_MUD_BRICKS = register("chiseled_mud_bricks", createCopy(Blocks.MUD_BRICKS));
    public static final Block MUD_BRICK_PILLAR = registerPillar(Blocks.MUD_BRICKS);

    // Dripstone
    public static final BSSWTypes POLISHED_DRIPSTONE = new BSSWTypes("polished_dripstone", Blocks.DRIPSTONE_BLOCK, false);
    public static final BSSWTypes DRIPSTONE_BRICKS = new BSSWTypes("dripstone_bricks", BlockusBlocks.POLISHED_DRIPSTONE.block);
    public static final Block CRACKED_DRIPSTONE_BRICKS = register("cracked_dripstone_bricks", createCopy(BlockusBlocks.DRIPSTONE_BRICKS.block));
    public static final Block CHISELED_DRIPSTONE = register("chiseled_dripstone", createCopy(BlockusBlocks.DRIPSTONE_BRICKS.block));
    public static final Block DRIPSTONE_PILLAR = createPillar("dripstone", BlockusBlocks.DRIPSTONE_BRICKS.block);

    // Tuff
    public static final BSSWTypes MOSSY_TUFF_BRICKS = new BSSWTypes("mossy_tuff_bricks", Blocks.TUFF_BRICKS);
    public static final Block CRACKED_TUFF_BRICKS = register("cracked_tuff_bricks", createCopy(Blocks.TUFF_BRICKS));
    public static final Block CARVED_TUFF_BRICKS = register("carved_tuff_bricks", createCopy(Blocks.TUFF_BRICKS));
    public static final Block HERRINGBONE_TUFF_BRICKS = register("herringbone_tuff_bricks", createCopy(Blocks.TUFF_BRICKS));
    public static final Block TUFF_CIRCULAR_PAVING = register("tuff_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(Blocks.TUFF_BRICKS)));
    public static final Block TUFF_PILLAR = createPillar("tuff", Blocks.POLISHED_TUFF);

    // Deepslate
    public static final BSSWTypes MOSSY_DEEPSLATE_BRICKS = new BSSWTypes("mossy_deepslate_bricks", Blocks.DEEPSLATE_BRICKS);
    public static final Block DEEPSLATE_PILLAR = createPillar("deepslate", Blocks.POLISHED_DEEPSLATE);
    public static final Block HERRINGBONE_DEEPSLATE_BRICKS = register("herringbone_deepslate_bricks", createCopy(Blocks.DEEPSLATE_BRICKS));
    public static final Block DEEPSLATE_CIRCULAR_PAVING = register("deepslate_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final Block STURDY_DEEPSLATE = register("sturdy_deepslate", new Block(AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE).pistonBehavior(PistonBehavior.BLOCK)));

    // Sculk
    public static final BSSWTypes POLISHED_SCULK = new BSSWTypes("polished_sculk", Blocks.POLISHED_DEEPSLATE, MapColor.CYAN, false);
    public static final BSSWTypes SCULK_BRICKS = new BSSWTypes("sculk_bricks", BlockusBlocks.POLISHED_SCULK.block);
    public static final Block CHISELED_SCULK_BRICKS = register("chiseled_sculk_bricks", createCopy(BlockusBlocks.SCULK_BRICKS.block));
    public static final Block SCULK_PILLAR = createPillar("sculk", BlockusBlocks.SCULK_BRICKS.block);

    // Amethyst
    public static final BSSWTypes POLISHED_AMETHYST = new BSSWTypes("polished_amethyst", Blocks.AMETHYST_BLOCK, false);
    public static final BSSWTypes AMETHYST_BRICKS = new BSSWTypes("amethyst_bricks", POLISHED_AMETHYST.block);
    public static final Block CHISELED_AMETHYST = register("chiseled_amethyst", new AmethystBlock(AbstractBlock.Settings.copy(AMETHYST_BRICKS.block)));
    public static final Block AMETHYST_PILLAR = register("amethyst_pillar", new AmethystPillarBlock(AbstractBlock.Settings.copy(AMETHYST_BRICKS.block)));

    // Blackstone
    public static final BSSWTypes POLISHED_BLACKSTONE_TILES = new BSSWTypes("polished_blackstone_tiles", Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final BSSWTypes CRIMSON_WARTY_BLACKSTONE_BRICKS = new BSSWTypes("crimson_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE);
    public static final BSSWTypes WARPED_WARTY_BLACKSTONE_BRICKS = new BSSWTypes("warped_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE);
    public static final Block POLISHED_BLACKSTONE_PILLAR = registerPillar(Blocks.POLISHED_BLACKSTONE);
    public static final Block HERRINGBONE_POLISHED_BLACKSTONE_BRICKS = register("herringbone_polished_blackstone_bricks", createCopy(Blocks.POLISHED_BLACKSTONE));
    public static final Block POLISHED_BLACKSTONE_CIRCULAR_PAVING = register("polished_blackstone_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE)));
    public static final Block GOLD_DECORATED_POLISHED_BLACKSTONE = register("gold_decorated_polished_blackstone", createCopy(Blocks.POLISHED_BLACKSTONE));
    public static final Block STURDY_BLACKSTONE = register("sturdy_blackstone", new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE).pistonBehavior(PistonBehavior.BLOCK)));
    public static final Block BLACKSTONE_DOOR = register("blackstone_door", createStoneDoor(1.5f, 6.0f, BlockSoundGroup.STONE, MapColor.BLACK, BlockSetType.STONE));
    public static final Block BLACKSTONE_TRAPDOOR = register("blackstone_trapdoor", createStoneTrapdoor(1.5f, 6.0f, BlockSoundGroup.STONE, MapColor.BLACK, BlockSetType.STONE));

    // Basalt
    public static final BSSWTypes ROUGH_BASALT = new BSSWTypes("rough_basalt", Blocks.BASALT, false);
    public static final BSSWTypes POLISHED_BASALT_BRICKS = new BSSWTypes("polished_basalt_bricks", Blocks.POLISHED_BASALT);
    public static final Block CRACKED_POLISHED_BASALT_BRICKS = register("cracked_polished_basalt_bricks", createCopy(BlockusBlocks.POLISHED_BASALT_BRICKS.block));
    public static final Block CHISELED_POLISHED_BASALT = register("chiseled_polished_basalt", createCopy(BlockusBlocks.POLISHED_BASALT_BRICKS.block));
    public static final Block POLISHED_BASALT_PILLAR = createPillar("polished_basalt", BlockusBlocks.POLISHED_BASALT_BRICKS.block);
    public static final Block HERRINGBONE_POLISHED_BASALT_BRICKS = register("herringbone_polished_basalt_bricks", createCopy(BlockusBlocks.POLISHED_BASALT_BRICKS.block));
    public static final Block POLISHED_BASALT_CIRCULAR_PAVING = register("polished_basalt_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.POLISHED_BASALT_BRICKS.block)));

    // Wart Blocks
    public static final BSSWTypes CRIMSON_WART_BRICKS = new BSSWTypes("crimson_wart_bricks", Blocks.NETHER_WART_BLOCK, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSWTypes WARPED_WART_BRICKS = new BSSWTypes("warped_wart_bricks", Blocks.WARPED_WART_BLOCK, BlockSoundGroup.NETHER_BRICKS);

    // Limestone
    public static final BSSWTypes LIMESTONE = new BSSWTypes("limestone", Blocks.STONE, MapColor.OAK_TAN);
    public static final BSSWTypes POLISHED_LIMESTONE = new BSSWTypes("polished_limestone", BlockusBlocks.LIMESTONE.block, false);
    public static final BSSWTypes LIMESTONE_BRICKS = new BSSWTypes("limestone_bricks", LIMESTONE.block);
    public static final BSSWTypes SMALL_LIMESTONE_BRICKS = new BSSWTypes("small_limestone_bricks", LIMESTONE_BRICKS.block);
    public static final BSSWTypes LIMESTONE_TILES = new BSSWTypes("limestone_tiles", LIMESTONE_BRICKS.block);
    public static final Block CHISELED_LIMESTONE = register("chiseled_limestone", createCopy(BlockusBlocks.LIMESTONE_BRICKS.block));
    public static final Block CHISELED_LIMESTONE_PILLAR = registerPillar(BlockusBlocks.CHISELED_LIMESTONE);
    public static final Block LIMESTONE_SQUARES = register("limestone_squares", createCopy(BlockusBlocks.LIMESTONE_BRICKS.block));
    public static final Block LIMESTONE_CIRCULAR_PAVING = register("limestone_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.LIMESTONE_BRICKS.block)));
    public static final Block LIMESTONE_LINES = register("limestone_lines", createPillarCopy(BlockusBlocks.LIMESTONE_BRICKS.block));
    public static final Block LIMESTONE_PILLAR = registerPillar(BlockusBlocks.LIMESTONE.block);
    // Marble
    public static final BSSWTypes MARBLE = new BSSWTypes("marble", Blocks.STONE, MapColor.OFF_WHITE);
    public static final BSSWTypes POLISHED_MARBLE = new BSSWTypes("polished_marble", BlockusBlocks.MARBLE.block, false);
    public static final BSSWTypes MARBLE_BRICKS = new BSSWTypes("marble_bricks", MARBLE.block);
    public static final BSSWTypes SMALL_MARBLE_BRICKS = new BSSWTypes("small_marble_bricks", MARBLE_BRICKS.block);
    public static final BSSWTypes MARBLE_TILES = new BSSWTypes("marble_tiles", MARBLE_BRICKS.block);
    public static final Block CHISELED_MARBLE = register("chiseled_marble", createCopy(BlockusBlocks.MARBLE_BRICKS.block));
    public static final Block CHISELED_MARBLE_PILLAR = registerPillar(BlockusBlocks.CHISELED_MARBLE);
    public static final Block MARBLE_SQUARES = register("marble_squares", createCopy(BlockusBlocks.MARBLE_BRICKS.block));
    public static final Block MARBLE_CIRCULAR_PAVING = register("marble_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.MARBLE_BRICKS.block)));
    public static final Block MARBLE_LINES = register("marble_lines", createPillarCopy(BlockusBlocks.MARBLE_BRICKS.block));
    public static final Block MARBLE_PILLAR = registerPillar(BlockusBlocks.MARBLE.block);
    // Bluestone
    public static final BSSWTypes BLUESTONE = new BSSWTypes("bluestone", Blocks.STONE, MapColor.CYAN);
    public static final BSSWTypes POLISHED_BLUESTONE = new BSSWTypes("polished_bluestone", BlockusBlocks.BLUESTONE.block, false);
    public static final BSSWTypes BLUESTONE_BRICKS = new BSSWTypes("bluestone_bricks", BLUESTONE.block);
    public static final BSSWTypes SMALL_BLUESTONE_BRICKS = new BSSWTypes("small_bluestone_bricks", BLUESTONE_BRICKS.block);
    public static final BSSWTypes BLUESTONE_TILES = new BSSWTypes("bluestone_tiles", BLUESTONE_BRICKS.block);
    public static final Block CHISELED_BLUESTONE = register("chiseled_bluestone", createCopy(BlockusBlocks.BLUESTONE_BRICKS.block));
    public static final Block CHISELED_BLUESTONE_PILLAR = registerPillar(BlockusBlocks.CHISELED_BLUESTONE);
    public static final Block BLUESTONE_SQUARES = register("bluestone_squares", createCopy(BlockusBlocks.BLUESTONE_BRICKS.block));
    public static final Block BLUESTONE_CIRCULAR_PAVING = register("bluestone_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.BLUESTONE_BRICKS.block)));
    public static final Block BLUESTONE_LINES = register("bluestone_lines", createPillarCopy(BlockusBlocks.BLUESTONE_BRICKS.block));
    public static final Block BLUESTONE_PILLAR = registerPillar(BlockusBlocks.BLUESTONE.block);
    // Viridite
    public static final BSSWTypes VIRIDITE = new BSSWTypes("viridite", Blocks.DEEPSLATE, MapColor.DARK_GREEN);
    public static final BSSWTypes POLISHED_VIRIDITE = new BSSWTypes("polished_viridite", BlockusBlocks.VIRIDITE.block, false);
    public static final BSSWTypes VIRIDITE_BRICKS = new BSSWTypes("viridite_bricks", VIRIDITE.block);
    public static final BSSWTypes SMALL_VIRIDITE_BRICKS = new BSSWTypes("small_viridite_bricks", VIRIDITE_BRICKS.block);
    public static final BSSWTypes VIRIDITE_TILES = new BSSWTypes("viridite_tiles", VIRIDITE_BRICKS.block);
    public static final Block CHISELED_VIRIDITE = register("chiseled_viridite", createCopy(BlockusBlocks.VIRIDITE_BRICKS.block));
    public static final Block CHISELED_VIRIDITE_PILLAR = registerPillar(BlockusBlocks.CHISELED_VIRIDITE);
    public static final Block VIRIDITE_SQUARES = register("viridite_squares", createCopy(BlockusBlocks.VIRIDITE_BRICKS.block));
    public static final Block VIRIDITE_CIRCULAR_PAVING = register("viridite_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.VIRIDITE_BRICKS.block)));
    public static final Block VIRIDITE_LINES = register("viridite_lines", createPillarCopy(BlockusBlocks.VIRIDITE_BRICKS.block));
    public static final Block VIRIDITE_PILLAR = registerPillar(BlockusBlocks.VIRIDITE.block);
    // Lava	Bricks
    public static final BSSWTypes LAVA_BRICKS = new BSSWTypes("lava_bricks", Blocks.STONE_BRICKS, 15);
    public static final Block CHISELED_LAVA_BRICKS = register("chiseled_lava_bricks", createCopy(BlockusBlocks.LAVA_BRICKS.block));

    // Lava Blackstone Bricks
    public static final BSSWTypes LAVA_POLISHED_BLACKSTONE_BRICKS = new BSSWTypes("lava_polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS, 15);
    public static final Block CHISELED_LAVA_POLISHED_BLACKSTONE = register("chiseled_lava_polished_blackstone", createCopy(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.block));

    // Water Bricks
    public static final BSSWTypes WATER_BRICKS = new BSSWTypes("water_bricks", Blocks.STONE_BRICKS);
    public static final Block CHISELED_WATER_BRICKS = register("chiseled_water_bricks", createCopy(BlockusBlocks.WATER_BRICKS.block));

    // Snow Bricks
    public static final BSSWTypes SNOW_BRICKS = new BSSWTypes("snow_bricks", Blocks.STONE_BRICKS, 1.0f, 3.0f, MapColor.WHITE);
    public static final Block SNOW_PILLAR = createPillar("snow", SNOW_BRICKS.block);

    // Ice Bricks
    public static final Block ICE_BRICKS = register("ice_bricks", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS)));
    public static final Block ICE_BRICK_WALL = registerWall(ICE_BRICKS);
    public static final Block ICE_PILLAR = createPillar("ice", ICE_BRICKS);

    // Obsidian
    public static final BSSWTypes OBSIDIAN_BRICKS = new BSSWTypes("obsidian_bricks", Blocks.OBSIDIAN, PistonBehavior.BLOCK);
    public static final BSSWTypes SMALL_OBSIDIAN_BRICKS = new BSSWTypes("small_obsidian_bricks", OBSIDIAN_BRICKS.block);
    public static final Block CRACKED_OBSIDIAN_BRICKS = register("cracked_obsidian_bricks", createCopy(BlockusBlocks.OBSIDIAN_BRICKS.block));
    public static final Block OBSIDIAN_PILLAR = createPillar("obsidian", BlockusBlocks.OBSIDIAN_BRICKS.block);
    public static final Block OBSIDIAN_CIRCULAR_PAVING = register("obsidian_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.OBSIDIAN_BRICKS.block)));
    public static final Block OBSIDIAN_REINFORCED_DOOR = register("obsidian_reinforced_door", createStoneDoor(50.0F, 1200.0F, BlockSoundGroup.STONE, MapColor.BLACK, BlockSetType.IRON));
    public static final Block OBSIDIAN_REINFORCED_TRAPDOOR = register("obsidian_reinforced_trapdoor", createStoneTrapdoor(50.0F, 1200.0F, BlockSoundGroup.STONE, MapColor.BLACK, BlockSetType.IRON));
    public static final Block GLOWING_OBSIDIAN = register("glowing_obsidian", createGlowingObsidian(Blocks.OBSIDIAN, 15, PistonBehavior.BLOCK));

    // Netherrack
    public static final BSSWTypes POLISHED_NETHERRACK = new BSSWTypes("polished_netherrack", Blocks.NETHERRACK, false);
    public static final BSSWTypes NETHERRACK_BRICKS = new BSSWTypes("netherrack_bricks", Blocks.NETHERRACK);
    public static final Block NETHERRACK_CIRCULAR_PAVING = register("netherrack_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.POLISHED_NETHERRACK.block)));

    // Quartz Blocks
    public static final BSSWTypes QUARTZ_TILES = new BSSWTypes("quartz_tiles", Blocks.QUARTZ_BLOCK);
    public static final Block QUARTZ_CIRCULAR_PAVING = register("quartz_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(BlockusBlocks.QUARTZ_TILES.block)));

    // Magma Bricks
    public static final BSSWTypes MAGMA_BRICKS = new BSSWTypes("magma_bricks", Blocks.MAGMA_BLOCK, 15);
    public static final BSSWTypes SMALL_MAGMA_BRICKS = new BSSWTypes("small_magma_bricks", Blocks.MAGMA_BLOCK, 15);
    public static final Block CHISELED_MAGMA_BRICKS = register("chiseled_magma_bricks", createCopy(BlockusBlocks.MAGMA_BRICKS.block));

    // Blaze Bricks
    public static final BSSWTypes BLAZE_BRICKS = new BSSWTypes("blaze_bricks", Blocks.NETHER_BRICKS, 15);
    public static final Block BLAZE_PILLAR = createPillar("blaze", BlockusBlocks.BLAZE_BRICKS.block);
    public static final Block BLAZE_LANTERN = register("blaze_lantern", createLampBlock(0.3F, 0.3F, BlockSoundGroup.GLASS, 15, MapColor.ORANGE));

    // Nether Bricks
    public static final Block POLISHED_NETHER_BRICKS = register("polished_nether_bricks", createCopy(Blocks.NETHER_BRICKS));
    public static final Block POLISHED_RED_NETHER_BRICKS = register("polished_red_nether_bricks", createCopy(Blocks.RED_NETHER_BRICKS));
    public static final Block HERRINGBONE_NETHER_BRICKS = register("herringbone_nether_bricks", createCopy(Blocks.NETHER_BRICKS));
    public static final Block HERRINGBONE_RED_NETHER_BRICKS = register("herringbone_red_nether_bricks", createCopy(Blocks.RED_NETHER_BRICKS));
    public static final Block NETHER_BRICK_PILLAR = registerPillar(Blocks.NETHER_BRICKS);
    public static final Block RED_NETHER_BRICK_PILLAR = registerPillar(Blocks.RED_NETHER_BRICKS);
    public static final BSSWTypes NETHER_TILES = new BSSWTypes("nether_tiles", Blocks.NETHER_BRICKS);

    // Charred Nether Bricks
    public static final BSSWTypes CHARRED_NETHER_BRICKS = new BSSWTypes("charred_nether_bricks", Blocks.NETHER_BRICKS, MapColor.BLACK);
    public static final Block POLISHED_CHARRED_NETHER_BRICKS = register("polished_charred_nether_bricks", createCopy(BlockusBlocks.CHARRED_NETHER_BRICKS.block));
    public static final Block HERRINGBONE_CHARRED_NETHER_BRICKS = register("herringbone_charred_nether_bricks", createCopy(BlockusBlocks.CHARRED_NETHER_BRICKS.block));
    public static final Block CHARRED_NETHER_BRICK_PILLAR = registerPillar(BlockusBlocks.CHARRED_NETHER_BRICKS.block);

    // Teal Nether Bricks
    public static final BSSWTypes TEAL_NETHER_BRICKS = new BSSWTypes("teal_nether_bricks", Blocks.NETHER_BRICKS, MapColor.CYAN);
    public static final Block POLISHED_TEAL_NETHER_BRICKS = register("polished_teal_nether_bricks", createCopy(BlockusBlocks.TEAL_NETHER_BRICKS.block));
    public static final Block HERRINGBONE_TEAL_NETHER_BRICKS = register("herringbone_teal_nether_bricks", createCopy(BlockusBlocks.TEAL_NETHER_BRICKS.block));
    public static final Block TEAL_NETHER_BRICK_PILLAR = registerPillar(BlockusBlocks.TEAL_NETHER_BRICKS.block);

    // Prismarine
    public static final Block CHISELED_PRISMARINE = register("chiseled_prismarine", createCopy(Blocks.PRISMARINE_BRICKS));
    public static final Block PRISMARINE_PILLAR = createPillar("prismarine", Blocks.PRISMARINE_BRICKS);
    public static final Block PRISMARINE_CIRCULAR_PAVING = register("prismarine_circular_paving", new OrientableBlockBase(AbstractBlock.Settings.copy(Blocks.PRISMARINE_BRICKS)));
    public static final Block CHISELED_DARK_PRISMARINE = register("chiseled_dark_prismarine", new OrientableBlockBase(AbstractBlock.Settings.copy(Blocks.DARK_PRISMARINE)));
    public static final Block DARK_PRISMARINE_PILLAR = createPillar("dark_prismarine", Blocks.DARK_PRISMARINE);
    public static final BSSWTypes PRISMARINE_TILES = new BSSWTypes("prismarine_tiles", Blocks.DARK_PRISMARINE);

    // Bricks
    public static final BSSWTypes LARGE_BRICKS = new BSSWTypes("large_bricks", Blocks.BRICKS);
    public static final Block HERRINGBONE_BRICKS = register("herringbone_bricks", createCopy(Blocks.BRICKS));

    // Soaked Bricks
    public static final BSSWTypes SOAKED_BRICKS = new BSSWTypes("soaked_bricks", Blocks.BRICKS);
    public static final Block HERRINGBONE_SOAKED_BRICKS = register("herringbone_soaked_bricks", createCopy(BlockusBlocks.SOAKED_BRICKS.block));

    // Charred Bricks
    public static final BSSWTypes CHARRED_BRICKS = new BSSWTypes("charred_bricks", Blocks.BRICKS);
    public static final Block HERRINGBONE_CHARRED_BRICKS = register("herringbone_charred_bricks", createCopy(BlockusBlocks.CHARRED_BRICKS.block));

    // Sandy Bricks
    public static final BSSWTypes SANDY_BRICKS = new BSSWTypes("sandy_bricks", Blocks.BRICKS);
    public static final Block HERRINGBONE_SANDY_BRICKS = register("herringbone_sandy_bricks", createCopy(BlockusBlocks.SANDY_BRICKS.block));

    // Sandstone
    public static final BSSWTypes ROUGH_SANDSTONE = new BSSWTypes("rough_sandstone", Blocks.SANDSTONE, false);
    public static final BSSWTypes SANDSTONE_BRICKS = new BSSWTypes("sandstone_bricks", Blocks.SANDSTONE);
    public static final BSSWTypes SMALL_SANDSTONE_BRICKS = new BSSWTypes("small_sandstone_bricks", Blocks.SANDSTONE);
    public static final Block SANDSTONE_PILLAR = createPillar("sandstone", Blocks.SANDSTONE);
    public static final Block GOLD_DECORATED_SANDSTONE = register("gold_decorated_sandstone", createCopy(Blocks.SANDSTONE));
    public static final Block LAPIS_DECORATED_SANDSTONE = register("lapis_decorated_sandstone", createCopy(Blocks.SANDSTONE));

    // Red Sandstone
    public static final BSSWTypes ROUGH_RED_SANDSTONE = new BSSWTypes("rough_red_sandstone", Blocks.RED_SANDSTONE, false);
    public static final BSSWTypes RED_SANDSTONE_BRICKS = new BSSWTypes("red_sandstone_bricks", Blocks.RED_SANDSTONE);
    public static final BSSWTypes SMALL_RED_SANDSTONE_BRICKS = new BSSWTypes("small_red_sandstone_bricks", Blocks.RED_SANDSTONE);
    public static final Block RED_SANDSTONE_PILLAR = createPillar("red_sandstone", Blocks.RED_SANDSTONE);
    public static final Block GOLD_DECORATED_RED_SANDSTONE = register("gold_decorated_red_sandstone", createCopy(Blocks.RED_SANDSTONE));
    public static final Block LAPIS_DECORATED_RED_SANDSTONE = register("lapis_decorated_red_sandstone", createCopy(Blocks.RED_SANDSTONE));

    // Soul Sandstone
    public static final BSSWTypes SOUL_SANDSTONE = new BSSWTypes("soul_sandstone", Blocks.SANDSTONE, MapColor.BROWN);
    public static final BSSWTypes ROUGH_SOUL_SANDSTONE = new BSSWTypes("rough_soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block, false);
    public static final BSSWTypes SOUL_SANDSTONE_BRICKS = new BSSWTypes("soul_sandstone_bricks", SOUL_SANDSTONE.block);
    public static final BSSWTypes SMALL_SOUL_SANDSTONE_BRICKS = new BSSWTypes("small_soul_sandstone_bricks", SOUL_SANDSTONE.block);
    public static final BSSWTypes SMOOTH_SOUL_SANDSTONE = new BSSWTypes("smooth_soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block, false);
    public static final Block CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", createCopy(BlockusBlocks.SOUL_SANDSTONE.block));
    public static final Block CUT_SOUL_SANDSTONE_SLAB = registerSlab(CUT_SOUL_SANDSTONE);
    public static final Block CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", createCopy(BlockusBlocks.SOUL_SANDSTONE.block));
    public static final Block SOUL_SANDSTONE_PILLAR = createPillar("soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block);
    public static final Block GOLD_DECORATED_SOUL_SANDSTONE = register("gold_decorated_soul_sandstone", createCopy(BlockusBlocks.SOUL_SANDSTONE.block));
    public static final Block LAPIS_DECORATED_SOUL_SANDSTONE = register("lapis_decorated_soul_sandstone", createCopy(BlockusBlocks.SOUL_SANDSTONE.block));

    // Rainbow
    public static final Block RAINBOW_ROSE = register("rainbow_rose", new FertilizableFlowerBlock(StatusEffects.GLOWING, 8, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)));
    public static final Block RAINBOW_PETAL = register("rainbow_petal", new FlowerbedBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().sounds(BlockSoundGroup.PINK_PETALS).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block POTTED_RAINBOW_ROSE = registerNoItem("potted_rainbow_rose", createPottedPlant(RAINBOW_ROSE));
    public static final Block RAINBOW_BLOCK = register("rainbow_block", new FullFacingBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(5.0f, 6.0f).requiresTool()));
    public static final BSSWTypes RAINBOW_BRICKS = new BSSWTypes("rainbow_bricks", Blocks.BRICKS);
    public static final Block RAINBOW_GLOWSTONE = register("rainbow_glowstone", createCopy(Blocks.GLOWSTONE));

    // Honeycomb Bricks
    public static final BSSWTypes HONEYCOMB_BRICKS = new BSSWTypes("honeycomb_bricks", Blocks.BRICKS);

    // Purpur Blocks
    public static final BSSWTypes PURPUR_BRICKS = new BSSWTypes("purpur_bricks", Blocks.PURPUR_BLOCK);
    public static final BSSWTypes SMALL_PURPUR_BRICKS = new BSSWTypes("small_purpur_bricks", Blocks.PURPUR_BLOCK);
    public static final BSSWTypes POLISHED_PURPUR = new BSSWTypes("polished_purpur", Blocks.PURPUR_BLOCK, false);
    public static final Block CHISELED_PURPUR = register("chiseled_purpur", createCopy(BlockusBlocks.PURPUR_BRICKS.block));
    public static final Block PURPUR_SQUARES = register("purpur_squares", createCopy(BlockusBlocks.PURPUR_BRICKS.block));
    public static final Block PURPUR_LINES = register("purpur_lines", createPillarCopy(BlockusBlocks.PURPUR_BRICKS.block));

    // Phantom Purpur Blocks
    public static final BSSWTypes PHANTOM_PURPUR_BRICKS = new BSSWTypes("phantom_purpur_bricks", Blocks.PURPUR_BLOCK);
    public static final BSSWTypes SMALL_PHANTOM_PURPUR_BRICKS = new BSSWTypes("small_phantom_purpur_bricks", Blocks.PURPUR_BLOCK);
    public static final BSSWTypes PHANTOM_PURPUR_BLOCK = new BSSWTypes("phantom_purpur_block", Blocks.PURPUR_BLOCK, false);
    public static final BSSWTypes POLISHED_PHANTOM_PURPUR = new BSSWTypes("polished_phantom_purpur", Blocks.PURPUR_BLOCK, false);
    public static final Block PHANTOM_PURPUR_PILLAR = createPillar("phantom_purpur", Blocks.PURPUR_PILLAR);
    public static final Block CHISELED_PHANTOM_PURPUR = register("chiseled_phantom_purpur", createCopy(BlockusBlocks.PHANTOM_PURPUR_BRICKS.block));
    public static final Block PHANTOM_PURPUR_SQUARES = register("phantom_purpur_squares", createCopy(BlockusBlocks.PHANTOM_PURPUR_BRICKS.block));
    public static final Block PHANTOM_PURPUR_LINES = register("phantom_purpur_lines", createPillarCopy(BlockusBlocks.PHANTOM_PURPUR_BRICKS.block));

    // End Stone
    public static final BSSWTypes POLISHED_END_STONE = new BSSWTypes("polished_end_stone", Blocks.END_STONE, false);
    public static final BSSWTypes SMALL_END_STONE_BRICKS = new BSSWTypes("small_end_stone_bricks", Blocks.END_STONE);
    public static final Block CHISELED_END_STONE_BRICKS = register("chiseled_end_stone_bricks", createCopy(Blocks.END_STONE_BRICKS));
    public static final Block HERRINGBONE_END_STONE_BRICKS = register("herringbone_end_stone_bricks", createCopy(Blocks.END_STONE_BRICKS));
    public static final Block CRACKED_END_STONE_BRICKS = register("cracked_end_stone_bricks", createCopy(Blocks.END_STONE_BRICKS));
    public static final Block END_STONE_PILLAR = createPillar("end_stone", Blocks.END_STONE_BRICKS);
    public static final Block PURPUR_DECORATED_END_STONE = register("purpur_decorated_end_stone", createCopy(Blocks.END_STONE_BRICKS));
    public static final Block PHANTOM_PURPUR_DECORATED_END_STONE = register("phantom_purpur_decorated_end_stone", createCopy(Blocks.END_STONE_BRICKS));
    public static final BSSWTypes END_TILES = new BSSWTypes("end_tiles", Blocks.END_STONE_BRICKS);

    // White Oak Wood
    public static final Block WHITE_OAK_SAPLING = register("white_oak_sapling", new SaplingBlock(BlockusSaplingGenerator.WHITE_OAK, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_WHITE_OAK_SAPLING = registerNoItem("potted_white_oak_sapling", createPottedPlant(WHITE_OAK_SAPLING));
    public static final Block WHITE_OAK_LOG = register("white_oak_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)));
    public static final Block STRIPPED_WHITE_OAK_LOG = register("stripped_white_oak_log", createPillarCopy(WHITE_OAK_LOG));
    public static final Block WHITE_OAK_WOOD = register("white_oak_wood", createPillarCopy(WHITE_OAK_LOG));
    public static final Block STRIPPED_WHITE_OAK_WOOD = register("stripped_white_oak_wood", createPillarCopy(WHITE_OAK_LOG));
    public static final Block WHITE_OAK_LEAVES = register("white_oak_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.ORANGE).pistonBehavior(PistonBehavior.DESTROY).allowsSpawning(BlockusBlocks::canSpawnOnLeaves).suffocates(BlockusBlocks::never).blockVision(BlockusBlocks::never)));
    public static final WoodTypes WHITE_OAK = new WoodTypes("white_oak", Blocks.OAK_PLANKS, MapColor.OFF_WHITE, BlockSoundGroup.WOOD);

    // Raw Bamboo
    public static final WoodTypes RAW_BAMBOO = new WoodTypes("raw_bamboo", Blocks.BAMBOO_PLANKS, MapColor.DARK_GREEN, BlockSoundGroup.BAMBOO_WOOD, WoodType.BAMBOO, BlockSetType.BAMBOO);

    // Charred
    public static final WoodTypes CHARRED = new WoodTypes("charred", Blocks.OAK_PLANKS, MapColor.TERRACOTTA_GRAY, BlockSoundGroup.WOOD, false);

    // Mosaics
    public static final BSSWTypes OAK_MOSAIC = new BSSWTypes("oak_mosaic", Blocks.OAK_PLANKS, false);
    public static final BSSWTypes SPRUCE_MOSAIC = new BSSWTypes("spruce_mosaic", Blocks.SPRUCE_PLANKS, false);
    public static final BSSWTypes BIRCH_MOSAIC = new BSSWTypes("birch_mosaic", Blocks.BIRCH_PLANKS, false);
    public static final BSSWTypes JUNGLE_MOSAIC = new BSSWTypes("jungle_mosaic", Blocks.JUNGLE_PLANKS, false);
    public static final BSSWTypes ACACIA_MOSAIC = new BSSWTypes("acacia_mosaic", Blocks.ACACIA_PLANKS, false);
    public static final BSSWTypes DARK_OAK_MOSAIC = new BSSWTypes("dark_oak_mosaic", Blocks.DARK_OAK_PLANKS, false);
    public static final BSSWTypes CHERRY_MOSAIC = new BSSWTypes("cherry_mosaic", Blocks.CHERRY_PLANKS, false);
    public static final BSSWTypes MANGROVE_MOSAIC = new BSSWTypes("mangrove_mosaic", Blocks.MANGROVE_PLANKS, false);
    public static final BSSWTypes RAW_BAMBOO_MOSAIC = new BSSWTypes("raw_bamboo_mosaic", RAW_BAMBOO.planks, false);
    public static final BSSWTypes WHITE_OAK_MOSAIC = new BSSWTypes("white_oak_mosaic", WHITE_OAK.planks, false);
    public static final BSSWTypes WARPED_MOSAIC = new BSSWTypes("warped_mosaic", Blocks.WARPED_PLANKS, false);
    public static final BSSWTypes CRIMSON_MOSAIC = new BSSWTypes("crimson_mosaic", Blocks.CRIMSON_PLANKS, false);
    public static final BSSWTypes CHARRED_MOSAIC = new BSSWTypes("charred_mosaic", CHARRED.planks, false);

    // Mossy Planks
    public static final BSSWTypes MOSSY_OAK_PLANKS = new BSSWTypes("mossy_oak_planks", Blocks.OAK_PLANKS, false);
    public static final BSSWTypes MOSSY_SPRUCE_PLANKS = new BSSWTypes("mossy_spruce_planks", Blocks.SPRUCE_PLANKS, false);
    public static final BSSWTypes MOSSY_BIRCH_PLANKS = new BSSWTypes("mossy_birch_planks", Blocks.BIRCH_PLANKS, false);
    public static final BSSWTypes MOSSY_JUNGLE_PLANKS = new BSSWTypes("mossy_jungle_planks", Blocks.JUNGLE_PLANKS, false);
    public static final BSSWTypes MOSSY_ACACIA_PLANKS = new BSSWTypes("mossy_acacia_planks", Blocks.ACACIA_PLANKS, false);
    public static final BSSWTypes MOSSY_DARK_OAK_PLANKS = new BSSWTypes("mossy_dark_oak_planks", Blocks.DARK_OAK_PLANKS, false);
    public static final BSSWTypes MOSSY_CHERRY_PLANKS = new BSSWTypes("mossy_cherry_planks", Blocks.CHERRY_PLANKS, false);
    public static final BSSWTypes MOSSY_MANGROVE_PLANKS = new BSSWTypes("mossy_mangrove_planks", Blocks.MANGROVE_PLANKS, false);
    public static final BSSWTypes MOSSY_BAMBOO_PLANKS = new BSSWTypes("mossy_bamboo_planks", Blocks.BAMBOO_PLANKS, false);
    public static final BSSWTypes MOSSY_RAW_BAMBOO_PLANKS = new BSSWTypes("mossy_raw_bamboo_planks", RAW_BAMBOO.planks, false);
    public static final BSSWTypes MOSSY_WHITE_OAK_PLANKS = new BSSWTypes("mossy_white_oak_planks", WHITE_OAK.planks, false);
    public static final BSSWTypes MOSSY_WARPED_PLANKS = new BSSWTypes("mossy_warped_planks", Blocks.WARPED_PLANKS, false);
    public static final BSSWTypes MOSSY_CRIMSON_PLANKS = new BSSWTypes("mossy_crimson_planks", Blocks.CRIMSON_PLANKS, false);
    public static final BSSWTypes MOSSY_CHARRED_PLANKS = new BSSWTypes("mossy_charred_planks", CHARRED.planks, false);

    // Herringbone Planks
    public static final Block HERRINGBONE_OAK_PLANKS = register("herringbone_oak_planks", createCopy(Blocks.OAK_PLANKS));
    public static final Block HERRINGBONE_SPRUCE_PLANKS = register("herringbone_spruce_planks", createCopy(Blocks.SPRUCE_PLANKS));
    public static final Block HERRINGBONE_BIRCH_PLANKS = register("herringbone_birch_planks", createCopy(Blocks.BIRCH_PLANKS));
    public static final Block HERRINGBONE_JUNGLE_PLANKS = register("herringbone_jungle_planks", createCopy(Blocks.JUNGLE_PLANKS));
    public static final Block HERRINGBONE_ACACIA_PLANKS = register("herringbone_acacia_planks", createCopy(Blocks.ACACIA_PLANKS));
    public static final Block HERRINGBONE_DARK_OAK_PLANKS = register("herringbone_dark_oak_planks", createCopy(Blocks.DARK_OAK_PLANKS));
    public static final Block HERRINGBONE_CHERRY_PLANKS = register("herringbone_cherry_planks", createCopy(Blocks.CHERRY_PLANKS));
    public static final Block HERRINGBONE_MANGROVE_PLANKS = register("herringbone_mangrove_planks", createCopy(Blocks.MANGROVE_PLANKS));
    public static final Block HERRINGBONE_BAMBOO_PLANKS = register("herringbone_bamboo_planks", createCopy(Blocks.BAMBOO_PLANKS));
    public static final Block HERRINGBONE_RAW_BAMBOO_PLANKS = register("herringbone_raw_bamboo_planks", createCopy(RAW_BAMBOO.planks));
    public static final Block HERRINGBONE_WHITE_OAK_PLANKS = register("herringbone_white_oak_planks", createCopy(WHITE_OAK.planks));
    public static final Block HERRINGBONE_WARPED_PLANKS = register("herringbone_warped_planks", createCopy(Blocks.WARPED_PLANKS));
    public static final Block HERRINGBONE_CRIMSON_PLANKS = register("herringbone_crimson_planks", createCopy(Blocks.CRIMSON_PLANKS));
    public static final Block HERRINGBONE_CHARRED_PLANKS = register("herringbone_charred_planks", createCopy(CHARRED.planks));

    // Small Logs
    public static final Block OAK_SMALL_LOGS = register("oak_small_logs", createPillarCopy(Blocks.OAK_LOG));
    public static final Block SPRUCE_SMALL_LOGS = register("spruce_small_logs", createPillarCopy(Blocks.SPRUCE_LOG));
    public static final Block BIRCH_SMALL_LOGS = register("birch_small_logs", createPillarCopy(Blocks.BIRCH_LOG));
    public static final Block JUNGLE_SMALL_LOGS = register("jungle_small_logs", createPillarCopy(Blocks.JUNGLE_LOG));
    public static final Block ACACIA_SMALL_LOGS = register("acacia_small_logs", createPillarCopy(Blocks.ACACIA_LOG));
    public static final Block DARK_OAK_SMALL_LOGS = register("dark_oak_small_logs", createPillarCopy(Blocks.DARK_OAK_LOG));
    public static final Block MANGROVE_SMALL_LOGS = register("mangrove_small_logs", createPillarCopy(Blocks.MANGROVE_LOG));
    public static final Block CHERRY_SMALL_LOGS = register("cherry_small_logs", createPillarCopy(Blocks.CHERRY_LOG));
    public static final Block WARPED_SMALL_STEMS = register("warped_small_stems", createPillarCopy(Blocks.WARPED_STEM));
    public static final Block CRIMSON_SMALL_STEMS = register("crimson_small_stems", createPillarCopy(Blocks.CRIMSON_STEM));
    public static final Block WHITE_OAK_SMALL_LOGS = register("white_oak_small_logs", createPillarCopy(WHITE_OAK_LOG));

    // Timber Frames & Grates
    public static final TimberFrameTypes OAK_TIMBER_FRAME = new TimberFrameTypes(Blocks.OAK_PLANKS);
    public static final TimberFrameTypes BIRCH_TIMBER_FRAME = new TimberFrameTypes(Blocks.BIRCH_PLANKS);
    public static final TimberFrameTypes SPRUCE_TIMBER_FRAME = new TimberFrameTypes(Blocks.SPRUCE_PLANKS);
    public static final TimberFrameTypes JUNGLE_TIMBER_FRAME = new TimberFrameTypes(Blocks.JUNGLE_PLANKS);
    public static final TimberFrameTypes ACACIA_TIMBER_FRAME = new TimberFrameTypes(Blocks.ACACIA_PLANKS);
    public static final TimberFrameTypes DARK_OAK_TIMBER_FRAME = new TimberFrameTypes(Blocks.DARK_OAK_PLANKS);
    public static final TimberFrameTypes MANGROVE_TIMBER_FRAME = new TimberFrameTypes(Blocks.MANGROVE_PLANKS);
    public static final TimberFrameTypes BAMBOO_TIMBER_FRAME = new TimberFrameTypes(Blocks.BAMBOO_PLANKS);
    public static final TimberFrameTypes CHERRY_TIMBER_FRAME = new TimberFrameTypes(Blocks.CHERRY_PLANKS);
    public static final TimberFrameTypes RAW_BAMBOO_TIMBER_FRAME = new TimberFrameTypes(BlockusBlocks.RAW_BAMBOO.planks);
    public static final TimberFrameTypes WHITE_OAK_TIMBER_FRAME = new TimberFrameTypes(BlockusBlocks.WHITE_OAK.planks);
    public static final TimberFrameTypes WARPED_TIMBER_FRAME = new TimberFrameTypes(Blocks.WARPED_PLANKS, true);
    public static final TimberFrameTypes CRIMSON_TIMBER_FRAME = new TimberFrameTypes(Blocks.CRIMSON_PLANKS, true);
    public static final TimberFrameTypes CHARRED_TIMBER_FRAME = new TimberFrameTypes(BlockusBlocks.CHARRED.planks, true);

    // Small Hedges
    public static final Block OAK_SMALL_HEDGE = registerSmallHedge("oak_small_hedge", Blocks.OAK_LEAVES);
    public static final Block SPRUCE_SMALL_HEDGE = registerSmallHedge("spruce_small_hedge", Blocks.SPRUCE_LEAVES);
    public static final Block BIRCH_SMALL_HEDGE = registerSmallHedge("birch_small_hedge", Blocks.BIRCH_LEAVES);
    public static final Block JUNGLE_SMALL_HEDGE = registerSmallHedge("jungle_small_hedge", Blocks.JUNGLE_LEAVES);
    public static final Block ACACIA_SMALL_HEDGE = registerSmallHedge("acacia_small_hedge", Blocks.ACACIA_LEAVES);
    public static final Block DARK_OAK_SMALL_HEDGE = registerSmallHedge("dark_oak_small_hedge", Blocks.DARK_OAK_LEAVES);
    public static final Block MANGROVE_SMALL_HEDGE = registerSmallHedge("mangrove_small_hedge", Blocks.MANGROVE_LEAVES);
    public static final Block CHERRY_SMALL_HEDGE = registerSmallHedge("cherry_small_hedge", Blocks.CHERRY_LEAVES);
    public static final Block WHITE_OAK_SMALL_HEDGE = registerSmallHedge("white_oak_small_hedge", WHITE_OAK_LEAVES);
    public static final Block AZALEA_SMALL_HEDGE = registerSmallHedge("azalea_small_hedge", Blocks.AZALEA_LEAVES);
    public static final Block FLOWERING_AZALEA_SMALL_HEDGE = registerSmallHedge("azalea_small_hedge_flowers", Blocks.FLOWERING_AZALEA_LEAVES);
    public static final Block MOSS_SMALL_HEDGE = registerSmallHedge("moss_small_hedge", Blocks.MOSS_BLOCK);
    public static final Block CRIMSON_SMALL_HEDGE = registerSmallHedge("crimson_small_hedge", Blocks.NETHER_WART_BLOCK);
    public static final Block WARPED_SMALL_HEDGE = registerSmallHedge("warped_small_hedge", Blocks.WARPED_WART_BLOCK);

    // Large Flower Pots
    public static final Block LARGE_FLOWER_POT = register("large_flower_pot", createLargeFlowerPot(Blocks.AIR));
    public static final PottedLargeTypes POTTED_ROSE_BUSH = new PottedLargeTypes("potted_rose_bush", Blocks.ROSE_BUSH);
    public static final PottedLargeTypes POTTED_LILAC = new PottedLargeTypes("potted_lilac", Blocks.LILAC);
    public static final PottedLargeTypes POTTED_PEONY = new PottedLargeTypes("potted_peony", Blocks.PEONY);
    public static final PottedLargeTypes POTTED_LARGE_FERN = new PottedLargeTypes("potted_large_fern", Blocks.LARGE_FERN);
    public static final PottedLargeTypes POTTED_OAK = new PottedLargeTypes("potted_oak", Blocks.OAK_SAPLING);
    public static final PottedLargeTypes POTTED_SPRUCE = new PottedLargeTypes("potted_spruce", Blocks.SPRUCE_SAPLING);
    public static final PottedLargeTypes POTTED_BIRCH = new PottedLargeTypes("potted_birch", Blocks.BIRCH_SAPLING);
    public static final PottedLargeTypes POTTED_JUNGLE = new PottedLargeTypes("potted_jungle", Blocks.JUNGLE_SAPLING);
    public static final PottedLargeTypes POTTED_ACACIA = new PottedLargeTypes("potted_acacia", Blocks.ACACIA_SAPLING);
    public static final PottedLargeTypes POTTED_DARK_OAK = new PottedLargeTypes("potted_dark_oak", Blocks.DARK_OAK_SAPLING);
    public static final PottedLargeTypes POTTED_MANGROVE = new PottedLargeTypes("potted_mangrove", Blocks.MANGROVE_PROPAGULE);
    public static final PottedLargeTypes POTTED_CHERRY_BLOSSOM = new PottedLargeTypes("potted_cherry_blossom", Blocks.CHERRY_SAPLING);
    public static final PottedLargeTypes POTTED_WHITE_OAK = new PottedLargeTypes("potted_white_oak", WHITE_OAK_SAPLING);
    public static final PottedLargeTypes POTTED_HUGE_RED_MUSHROOM = new PottedLargeTypes("potted_huge_red_mushroom", Blocks.RED_MUSHROOM);
    public static final PottedLargeTypes POTTED_HUGE_BROWN_MUSHROOM = new PottedLargeTypes("potted_huge_brown_mushroom", Blocks.BROWN_MUSHROOM);
    public static final PottedLargeTypes POTTED_HUGE_CRIMSON_FUNGUS = new PottedLargeTypes("potted_huge_crimson_fungus", Blocks.CRIMSON_FUNGUS);
    public static final PottedLargeTypes POTTED_HUGE_WARPED_FUNGUS = new PottedLargeTypes("potted_huge_warped_fungus", Blocks.WARPED_FUNGUS);
    public static final PottedLargeTypes POTTED_CACTUS_LARGE = new PottedLargeTypes("potted_cactus_large", Blocks.CACTUS);
    public static final PottedLargeTypes POTTED_BAMBOO_LARGE = new PottedLargeTypes("potted_bamboo_large", Blocks.BAMBOO);
    public static final PottedLargeTypes POTTED_AZALEA_LARGE = new PottedLargeTypes("potted_azalea_large", Blocks.AZALEA);
    public static final PottedLargeTypes POTTED_FLOWERING_AZALEA_LARGE = new PottedLargeTypes("potted_flowering_azalea_large", Blocks.FLOWERING_AZALEA);
    public static final PottedLargeTypes POTTED_PITCHER_PLANT = new PottedLargeTypes("potted_pitcher_plant", Blocks.PITCHER_PLANT);

    // Chocolate
    public static final BSSWTypes CHOCOLATE_BLOCK = new BSSWTypes("chocolate_block", 1.0F, 1.0F, MapColor.BROWN, false);
    public static final BSSWTypes CHOCOLATE_BRICKS = new BSSWTypes("chocolate_bricks", BlockusBlocks.CHOCOLATE_BLOCK.block);
    public static final Block CHOCOLATE_SQUARES = register("chocolate_squares", createCopy(BlockusBlocks.CHOCOLATE_BRICKS.block));
    public static final Block CHOCOLATE_TABLET = register("chocolate_tablet", new ChocolateTabletBlock(AbstractBlock.Settings.copy(BlockusBlocks.CHOCOLATE_BLOCK.block).strength(0.2F, 1.0F)));

    // Ore Bricks
    public static final BSSWTypes IRON_BRICKS = new BSSWTypes("iron_bricks", Blocks.IRON_BLOCK);
    public static final BSSWTypes GOLD_BRICKS = new BSSWTypes("gold_bricks", Blocks.GOLD_BLOCK);
    public static final BSSWTypes LAPIS_BRICKS = new BSSWTypes("lapis_bricks", Blocks.LAPIS_BLOCK);
    public static final BSSWTypes REDSTONE_BRICKS = new BSSWTypes("redstone_bricks", Blocks.REDSTONE_BLOCK);
    public static final BSSWTypes EMERALD_BRICKS = new BSSWTypes("emerald_bricks", Blocks.EMERALD_BLOCK);
    public static final BSSWTypes DIAMOND_BRICKS = new BSSWTypes("diamond_bricks", Blocks.DIAMOND_BLOCK);
    public static final BSSWTypes NETHERITE_BRICKS = new BSSWTypes("netherite_bricks", Blocks.NETHERITE_BLOCK);

    // Food Blocks
    public static final Block SWEET_BERRIES_CRATE = register("sweet_berries_crate", createCrates());
    public static final Block GLOW_BERRIES_CRATE = register("glow_berries_crate", createLightCrate());
    public static final Block SALMON_CRATE = register("salmon_crate", createCrates());
    public static final Block PUFFERFISH_CRATE = register("pufferfish_crate", createCrates());
    public static final Block TROPICAL_FISH_CRATE = register("tropical_fish_crate", createCrates());
    public static final Block COD_CRATE = register("cod_crate", createCrates());
    public static final Block COOKIE_BLOCK = register("cookie_block", new CookieBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).strength(0.5F).sounds(BlockSoundGroup.GRASS)));
    public static final Block CHORUS_BLOCK = register("chorus_block", new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(0.5f).sounds(BlockSoundGroup.GRASS)));
    public static final Block POTATO_CRATE = register("potato_crate", createCrates());
    public static final Block APPLE_CRATE = register("apple_crate", createCrates());
    public static final Block GOLDEN_APPLE_CRATE = register("golden_apple_crate", createCrates());
    public static final Block BEETROOT_CRATE = register("beetroot_crate", createCrates());
    public static final Block CARROT_CRATE = register("carrot_crate", createCrates());
    public static final Block GOLDEN_CARROT_CRATE = register("golden_carrot_crate", createCrates());
    public static final Block BREAD_BOX = register("bread_box", new OrientableBlockBase(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(2.5f)));

    // Stained Stone Bricks
    public static final BSSWTypes WHITE_STONE_BRICKS = new BSSWTypes("white_stone_bricks", Blocks.STONE_BRICKS, MapColor.WHITE);
    public static final BSSWTypes GRAY_STONE_BRICKS = new BSSWTypes("gray_stone_bricks", Blocks.STONE_BRICKS, MapColor.GRAY);
    public static final BSSWTypes BLACK_STONE_BRICKS = new BSSWTypes("black_stone_bricks", Blocks.STONE_BRICKS, MapColor.BLACK);
    public static final BSSWTypes BROWN_STONE_BRICKS = new BSSWTypes("brown_stone_bricks", Blocks.STONE_BRICKS, MapColor.BROWN);
    public static final BSSWTypes RED_STONE_BRICKS = new BSSWTypes("red_stone_bricks", Blocks.STONE_BRICKS, MapColor.RED);
    public static final BSSWTypes ORANGE_STONE_BRICKS = new BSSWTypes("orange_stone_bricks", Blocks.STONE_BRICKS, MapColor.ORANGE);
    public static final BSSWTypes YELLOW_STONE_BRICKS = new BSSWTypes("yellow_stone_bricks", Blocks.STONE_BRICKS, MapColor.YELLOW);
    public static final BSSWTypes LIME_STONE_BRICKS = new BSSWTypes("lime_stone_bricks", Blocks.STONE_BRICKS, MapColor.LIME);
    public static final BSSWTypes GREEN_STONE_BRICKS = new BSSWTypes("green_stone_bricks", Blocks.STONE_BRICKS, MapColor.GREEN);
    public static final BSSWTypes CYAN_STONE_BRICKS = new BSSWTypes("cyan_stone_bricks", Blocks.STONE_BRICKS, MapColor.CYAN);
    public static final BSSWTypes LIGHT_BLUE_STONE_BRICKS = new BSSWTypes("light_blue_stone_bricks", Blocks.STONE_BRICKS, MapColor.LIGHT_BLUE);
    public static final BSSWTypes BLUE_STONE_BRICKS = new BSSWTypes("blue_stone_bricks", Blocks.STONE_BRICKS, MapColor.BLUE);
    public static final BSSWTypes PURPLE_STONE_BRICKS = new BSSWTypes("purple_stone_bricks", Blocks.STONE_BRICKS, MapColor.PURPLE);
    public static final BSSWTypes MAGENTA_STONE_BRICKS = new BSSWTypes("magenta_stone_bricks", Blocks.STONE_BRICKS, MapColor.MAGENTA);
    public static final BSSWTypes PINK_STONE_BRICKS = new BSSWTypes("pink_stone_bricks", Blocks.STONE_BRICKS, MapColor.PINK);

    // Concrete
    public static final ConcreteTypes WHITE_CONCRETE_BRICKS = new ConcreteTypes("white_concrete_bricks", Blocks.WHITE_CONCRETE);
    public static final ConcreteTypes LIGHT_GRAY_CONCRETE_BRICKS = new ConcreteTypes("light_gray_concrete_bricks", Blocks.LIGHT_GRAY_CONCRETE);
    public static final ConcreteTypes GRAY_CONCRETE_BRICKS = new ConcreteTypes("gray_concrete_bricks", Blocks.GRAY_CONCRETE);
    public static final ConcreteTypes BLACK_CONCRETE_BRICKS = new ConcreteTypes("black_concrete_bricks", Blocks.BLACK_CONCRETE);
    public static final ConcreteTypes BROWN_CONCRETE_BRICKS = new ConcreteTypes("brown_concrete_bricks", Blocks.BROWN_CONCRETE);
    public static final ConcreteTypes RED_CONCRETE_BRICKS = new ConcreteTypes("red_concrete_bricks", Blocks.RED_CONCRETE);
    public static final ConcreteTypes ORANGE_CONCRETE_BRICKS = new ConcreteTypes("orange_concrete_bricks", Blocks.ORANGE_CONCRETE);
    public static final ConcreteTypes YELLOW_CONCRETE_BRICKS = new ConcreteTypes("yellow_concrete_bricks", Blocks.YELLOW_CONCRETE);
    public static final ConcreteTypes LIME_CONCRETE_BRICKS = new ConcreteTypes("lime_concrete_bricks", Blocks.LIME_CONCRETE);
    public static final ConcreteTypes GREEN_CONCRETE_BRICKS = new ConcreteTypes("green_concrete_bricks", Blocks.GREEN_CONCRETE);
    public static final ConcreteTypes CYAN_CONCRETE_BRICKS = new ConcreteTypes("cyan_concrete_bricks", Blocks.CYAN_CONCRETE);
    public static final ConcreteTypes LIGHT_BLUE_CONCRETE_BRICKS = new ConcreteTypes("light_blue_concrete_bricks", Blocks.LIGHT_BLUE_CONCRETE);
    public static final ConcreteTypes BLUE_CONCRETE_BRICKS = new ConcreteTypes("blue_concrete_bricks", Blocks.BLUE_CONCRETE);
    public static final ConcreteTypes PURPLE_CONCRETE_BRICKS = new ConcreteTypes("purple_concrete_bricks", Blocks.PURPLE_CONCRETE);
    public static final ConcreteTypes MAGENTA_CONCRETE_BRICKS = new ConcreteTypes("magenta_concrete_bricks", Blocks.MAGENTA_CONCRETE);
    public static final ConcreteTypes PINK_CONCRETE_BRICKS = new ConcreteTypes("pink_concrete_bricks", Blocks.PINK_CONCRETE);

    // Redstone Lamps
    public static final Block WHITE_REDSTONE_LAMP = register("white_redstone_lamp", createRedstoneLamp());
    public static final Block ORANGE_REDSTONE_LAMP = register("orange_redstone_lamp", createRedstoneLamp());
    public static final Block MAGENTA_REDSTONE_LAMP = register("magenta_redstone_lamp", createRedstoneLamp());
    public static final Block LIGHT_BLUE_REDSTONE_LAMP = register("light_blue_redstone_lamp", createRedstoneLamp());
    public static final Block YELLOW_REDSTONE_LAMP = register("yellow_redstone_lamp", createRedstoneLamp());
    public static final Block LIME_REDSTONE_LAMP = register("lime_redstone_lamp", createRedstoneLamp());
    public static final Block PINK_REDSTONE_LAMP = register("pink_redstone_lamp", createRedstoneLamp());
    public static final Block GRAY_REDSTONE_LAMP = register("gray_redstone_lamp", createRedstoneLamp());
    public static final Block LIGHT_GRAY_REDSTONE_LAMP = register("light_gray_redstone_lamp", createRedstoneLamp());
    public static final Block CYAN_REDSTONE_LAMP = register("cyan_redstone_lamp", createRedstoneLamp());
    public static final Block PURPLE_REDSTONE_LAMP = register("purple_redstone_lamp", createRedstoneLamp());
    public static final Block BLUE_REDSTONE_LAMP = register("blue_redstone_lamp", createRedstoneLamp());
    public static final Block BROWN_REDSTONE_LAMP = register("brown_redstone_lamp", createRedstoneLamp());
    public static final Block GREEN_REDSTONE_LAMP = register("green_redstone_lamp", createRedstoneLamp());
    public static final Block RED_REDSTONE_LAMP = register("red_redstone_lamp", createRedstoneLamp());
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
    public static final Block RAINBOW_LAMP = register("rainbow_lamp", createRedstoneLamp());
    public static final Block RAINBOW_LAMP_LIT = register("rainbow_lamp_lit", createLitRedstoneLamp());

    // Neon Blocks
    public static final Block WHITE_NEON = register("white_neon", createNeonBlock(DyeColor.WHITE));
    public static final Block LIGHT_GRAY_NEON = register("light_gray_neon", createNeonBlock(DyeColor.LIGHT_GRAY));
    public static final Block GRAY_NEON = register("gray_neon", createNeonBlock(DyeColor.GRAY));
    public static final Block BLACK_NEON = register("black_neon", createNeonBlock(DyeColor.BLACK));
    public static final Block BROWN_NEON = register("brown_neon", createNeonBlock(DyeColor.BROWN));
    public static final Block RED_NEON = register("red_neon", createNeonBlock(DyeColor.RED));
    public static final Block ORANGE_NEON = register("orange_neon", createNeonBlock(DyeColor.ORANGE));
    public static final Block YELLOW_NEON = register("yellow_neon", createNeonBlock(DyeColor.YELLOW));
    public static final Block LIME_NEON = register("lime_neon", createNeonBlock(DyeColor.LIME));
    public static final Block GREEN_NEON = register("green_neon", createNeonBlock(DyeColor.GREEN));
    public static final Block CYAN_NEON = register("cyan_neon", createNeonBlock(DyeColor.CYAN));
    public static final Block LIGHT_BLUE_NEON = register("light_blue_neon", createNeonBlock(DyeColor.LIGHT_BLUE));
    public static final Block BLUE_NEON = register("blue_neon", createNeonBlock(DyeColor.BLUE));
    public static final Block PURPLE_NEON = register("purple_neon", createNeonBlock(DyeColor.PURPLE));
    public static final Block MAGENTA_NEON = register("magenta_neon", createNeonBlock(DyeColor.MAGENTA));
    public static final Block PINK_NEON = register("pink_neon", createNeonBlock(DyeColor.PINK));

    // Futurneo Blocks
    public static final Block WHITE_FUTURNEO_BLOCK = register("white_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block LIGHT_GRAY_FUTURNEO_BLOCK = register("light_gray_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block GRAY_FUTURNEO_BLOCK = register("gray_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block BLACK_FUTURNEO_BLOCK = register("black_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block BROWN_FUTURNEO_BLOCK = register("brown_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block RED_FUTURNEO_BLOCK = register("red_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block ORANGE_FUTURNEO_BLOCK = register("orange_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block YELLOW_FUTURNEO_BLOCK = register("yellow_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block LIME_FUTURNEO_BLOCK = register("lime_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block GREEN_FUTURNEO_BLOCK = register("green_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block CYAN_FUTURNEO_BLOCK = register("cyan_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block LIGHT_BLUE_FUTURNEO_BLOCK = register("light_blue_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block BLUE_FUTURNEO_BLOCK = register("blue_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block PURPLE_FUTURNEO_BLOCK = register("purple_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block MAGENTA_FUTURNEO_BLOCK = register("magenta_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block PINK_FUTURNEO_BLOCK = register("pink_futurneo_block", createFuturneoBlock(MapColor.BLACK));
    public static final Block GRAY_BRIGHT_FUTURNEO_BLOCK = register("gray_bright_futurneo_block", createFuturneoBlock(MapColor.WHITE));
    public static final Block RAINBOW_FUTURNEO_BLOCK = register("rainbow_futurneo_block", createFuturneoBlock(MapColor.BLACK));

    // Asphalt
    public static final AsphaltTypes ASPHALT = new AsphaltTypes(DyeColor.BLACK);
    public static final AsphaltTypes WHITE_ASPHALT = new AsphaltTypes(DyeColor.WHITE);
    public static final AsphaltTypes LIGHT_GRAY_ASPHALT = new AsphaltTypes(DyeColor.LIGHT_GRAY);
    public static final AsphaltTypes GRAY_ASPHALT = new AsphaltTypes(DyeColor.GRAY);
    public static final AsphaltTypes BROWN_ASPHALT = new AsphaltTypes(DyeColor.BROWN);
    public static final AsphaltTypes RED_ASPHALT = new AsphaltTypes(DyeColor.RED);
    public static final AsphaltTypes ORANGE_ASPHALT = new AsphaltTypes(DyeColor.ORANGE);
    public static final AsphaltTypes YELLOW_ASPHALT = new AsphaltTypes(DyeColor.YELLOW);
    public static final AsphaltTypes LIME_ASPHALT = new AsphaltTypes(DyeColor.LIME);
    public static final AsphaltTypes GREEN_ASPHALT = new AsphaltTypes(DyeColor.GREEN);
    public static final AsphaltTypes CYAN_ASPHALT = new AsphaltTypes(DyeColor.CYAN);
    public static final AsphaltTypes LIGHT_BLUE_ASPHALT = new AsphaltTypes(DyeColor.LIGHT_BLUE);
    public static final AsphaltTypes BLUE_ASPHALT = new AsphaltTypes(DyeColor.BLUE);
    public static final AsphaltTypes PURPLE_ASPHALT = new AsphaltTypes(DyeColor.PURPLE);
    public static final AsphaltTypes MAGENTA_ASPHALT = new AsphaltTypes(DyeColor.MAGENTA);
    public static final AsphaltTypes PINK_ASPHALT = new AsphaltTypes(DyeColor.PINK);
    public static final Block RAINBOW_ASPHALT = register("rainbow_asphalt", new RainbowAsphalt(AbstractBlock.Settings.create().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(1.5f, 6.0f).requiresTool()));

    // Shingles
    public static final BSSWTypes SHINGLES = new BSSWTypes("shingles", Blocks.TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes WHITE_SHINGLES = new BSSWTypes("white_shingles", Blocks.WHITE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes LIGHT_GRAY_SHINGLES = new BSSWTypes("light_gray_shingles", Blocks.LIGHT_GRAY_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes GRAY_SHINGLES = new BSSWTypes("gray_shingles", Blocks.GRAY_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes BLACK_SHINGLES = new BSSWTypes("black_shingles", Blocks.BLACK_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes BROWN_SHINGLES = new BSSWTypes("brown_shingles", Blocks.BROWN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes RED_SHINGLES = new BSSWTypes("red_shingles", Blocks.RED_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes ORANGE_SHINGLES = new BSSWTypes("orange_shingles", Blocks.ORANGE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes YELLOW_SHINGLES = new BSSWTypes("yellow_shingles", Blocks.YELLOW_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes LIME_SHINGLES = new BSSWTypes("lime_shingles", Blocks.LIME_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes GREEN_SHINGLES = new BSSWTypes("green_shingles", Blocks.GREEN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes CYAN_SHINGLES = new BSSWTypes("cyan_shingles", Blocks.CYAN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes LIGHT_BLUE_SHINGLES = new BSSWTypes("light_blue_shingles", Blocks.LIGHT_BLUE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes BLUE_SHINGLES = new BSSWTypes("blue_shingles", Blocks.BLUE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes PURPLE_SHINGLES = new BSSWTypes("purple_shingles", Blocks.PURPLE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes MAGENTA_SHINGLES = new BSSWTypes("magenta_shingles", Blocks.MAGENTA_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);
    public static final BSSWTypes PINK_SHINGLES = new BSSWTypes("pink_shingles", Blocks.PINK_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS, false);

    // Glass - Beveled Glass
    public static final Block RAINBOW_GLASS = register("rainbow_glass", createStainedGlass(DyeColor.YELLOW, Blocks.GLASS));
    public static final Block RAINBOW_GLASS_PANE = register("rainbow_glass_pane", createstainedGlassPane(DyeColor.YELLOW, Blocks.GLASS_PANE));
    public static final Block BEVELED_GLASS = register("beveled_glass", createCopy(Blocks.GLASS));
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
    public static final Block BEVELED_GLASS_PANE = register("beveled_glass_pane", new PaneBlock(AbstractBlock.Settings.copy(Blocks.GLASS_PANE)));
    public static final Block WHITE_BEVELED_GLASS_PANE = register("white_beveled_glass_pane", createstainedGlassPane(DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS_PANE));
    public static final Block ORANGE_BEVELED_GLASS_PANE = register("orange_beveled_glass_pane", createstainedGlassPane(DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS_PANE));
    public static final Block MAGENTA_BEVELED_GLASS_PANE = register("magenta_beveled_glass_pane", createstainedGlassPane(DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS_PANE));
    public static final Block LIGHT_BLUE_BEVELED_GLASS_PANE = register("light_blue_beveled_glass_pane", createstainedGlassPane(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE));
    public static final Block YELLOW_BEVELED_GLASS_PANE = register("yellow_beveled_glass_pane", createstainedGlassPane(DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS_PANE));
    public static final Block LIME_BEVELED_GLASS_PANE = register("lime_beveled_glass_pane", createstainedGlassPane(DyeColor.LIME, Blocks.LIME_STAINED_GLASS_PANE));
    public static final Block PINK_BEVELED_GLASS_PANE = register("pink_beveled_glass_pane", createstainedGlassPane(DyeColor.PINK, Blocks.PINK_STAINED_GLASS_PANE));
    public static final Block LIGHT_GRAY_BEVELED_GLASS_PANE = register("light_gray_beveled_glass_pane", createstainedGlassPane(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE));
    public static final Block GRAY_BEVELED_GLASS_PANE = register("gray_beveled_glass_pane", createstainedGlassPane(DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS_PANE));
    public static final Block CYAN_BEVELED_GLASS_PANE = register("cyan_beveled_glass_pane", createstainedGlassPane(DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS_PANE));
    public static final Block PURPLE_BEVELED_GLASS_PANE = register("purple_beveled_glass_pane", createstainedGlassPane(DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS_PANE));
    public static final Block BLUE_BEVELED_GLASS_PANE = register("blue_beveled_glass_pane", createstainedGlassPane(DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS_PANE));
    public static final Block BROWN_BEVELED_GLASS_PANE = register("brown_beveled_glass_pane", createstainedGlassPane(DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS_PANE));
    public static final Block GREEN_BEVELED_GLASS_PANE = register("green_beveled_glass_pane", createstainedGlassPane(DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS_PANE));
    public static final Block RED_BEVELED_GLASS_PANE = register("red_beveled_glass_pane", createstainedGlassPane(DyeColor.RED, Blocks.RED_STAINED_GLASS_PANE));
    public static final Block BLACK_BEVELED_GLASS_PANE = register("black_beveled_glass_pane", createstainedGlassPane(DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS_PANE));
    public static final Block RAINBOW_BEVELED_GLASS_PANE = register("rainbow_beveled_glass_pane", createstainedGlassPane(DyeColor.YELLOW, RAINBOW_GLASS_PANE));
    public static final Block TINTED_BEVELED_GLASS = register("tinted_beveled_glass", new TintedGlassBlock(AbstractBlock.Settings.copy(Blocks.TINTED_GLASS).allowsSpawning(BlockusBlocks::never).solidBlock(BlockusBlocks::never).suffocates(BlockusBlocks::never).blockVision(BlockusBlocks::never)));

    // Patterned Wools
    public static final WoolTypes WHITE_PATTERNED_WOOL = new WoolTypes(Blocks.WHITE_WOOL, Blocks.WHITE_CARPET, DyeColor.WHITE);
    public static final WoolTypes LIGHT_GRAY_PATTERNED_WOOL = new WoolTypes(Blocks.LIGHT_GRAY_WOOL, Blocks.LIGHT_GRAY_CARPET, DyeColor.LIGHT_GRAY);
    public static final WoolTypes GRAY_PATTERNED_WOOL = new WoolTypes(Blocks.GRAY_WOOL, Blocks.GRAY_CARPET, DyeColor.GRAY);
    public static final WoolTypes BLACK_PATTERNED_WOOL = new WoolTypes(Blocks.BLACK_WOOL, Blocks.BLACK_CARPET, DyeColor.BLACK);
    public static final WoolTypes BROWN_PATTERNED_WOOL = new WoolTypes(Blocks.BROWN_WOOL, Blocks.BROWN_CARPET, DyeColor.BROWN);
    public static final WoolTypes RED_PATTERNED_WOOL = new WoolTypes(Blocks.RED_WOOL, Blocks.RED_CARPET, DyeColor.RED);
    public static final WoolTypes ORANGE_PATTERNED_WOOL = new WoolTypes(Blocks.ORANGE_WOOL, Blocks.ORANGE_CARPET, DyeColor.ORANGE);
    public static final WoolTypes YELLOW_PATTERNED_WOOL = new WoolTypes(Blocks.YELLOW_WOOL, Blocks.YELLOW_CARPET, DyeColor.YELLOW);
    public static final WoolTypes LIME_PATTERNED_WOOL = new WoolTypes(Blocks.LIME_WOOL, Blocks.LIME_CARPET, DyeColor.LIME);
    public static final WoolTypes GREEN_PATTERNED_WOOL = new WoolTypes(Blocks.GREEN_WOOL, Blocks.GREEN_CARPET, DyeColor.GREEN);
    public static final WoolTypes CYAN_PATTERNED_WOOL = new WoolTypes(Blocks.CYAN_WOOL, Blocks.CYAN_CARPET, DyeColor.CYAN);
    public static final WoolTypes LIGHT_BLUE_PATTERNED_WOOL = new WoolTypes(Blocks.LIGHT_BLUE_WOOL, Blocks.LIGHT_BLUE_CARPET, DyeColor.LIGHT_BLUE);
    public static final WoolTypes BLUE_PATTERNED_WOOL = new WoolTypes(Blocks.BLUE_WOOL, Blocks.BLUE_CARPET, DyeColor.BLUE);
    public static final WoolTypes PURPLE_PATTERNED_WOOL = new WoolTypes(Blocks.PURPLE_WOOL, Blocks.PURPLE_CARPET, DyeColor.PURPLE);
    public static final WoolTypes MAGENTA_PATTERNED_WOOL = new WoolTypes(Blocks.MAGENTA_WOOL, Blocks.MAGENTA_CARPET, DyeColor.MAGENTA);
    public static final WoolTypes PINK_PATTERNED_WOOL = new WoolTypes(Blocks.PINK_WOOL, Blocks.PINK_CARPET, DyeColor.PINK);

    // Gingham Wools
    public static final WoolTypes WHITE_GINGHAM_WOOL = new WoolTypes(Blocks.WHITE_WOOL, Blocks.WHITE_CARPET, DyeColor.WHITE, WoolTypes.GINGHAM);
    public static final WoolTypes LIGHT_GRAY_GINGHAM_WOOL = new WoolTypes(Blocks.LIGHT_GRAY_WOOL, Blocks.LIGHT_GRAY_CARPET, DyeColor.LIGHT_GRAY, WoolTypes.GINGHAM);
    public static final WoolTypes GRAY_GINGHAM_WOOL = new WoolTypes(Blocks.GRAY_WOOL, Blocks.GRAY_CARPET, DyeColor.GRAY, WoolTypes.GINGHAM);
    public static final WoolTypes BLACK_GINGHAM_WOOL = new WoolTypes(Blocks.BLACK_WOOL, Blocks.BLACK_CARPET, DyeColor.BLACK, WoolTypes.GINGHAM);
    public static final WoolTypes BROWN_GINGHAM_WOOL = new WoolTypes(Blocks.BROWN_WOOL, Blocks.BROWN_CARPET, DyeColor.BROWN, WoolTypes.GINGHAM);
    public static final WoolTypes RED_GINGHAM_WOOL = new WoolTypes(Blocks.RED_WOOL, Blocks.RED_CARPET, DyeColor.RED, WoolTypes.GINGHAM);
    public static final WoolTypes ORANGE_GINGHAM_WOOL = new WoolTypes(Blocks.ORANGE_WOOL, Blocks.ORANGE_CARPET, DyeColor.ORANGE, WoolTypes.GINGHAM);
    public static final WoolTypes YELLOW_GINGHAM_WOOL = new WoolTypes(Blocks.YELLOW_WOOL, Blocks.YELLOW_CARPET, DyeColor.YELLOW, WoolTypes.GINGHAM);
    public static final WoolTypes LIME_GINGHAM_WOOL = new WoolTypes(Blocks.LIME_WOOL, Blocks.LIME_CARPET, DyeColor.LIME, WoolTypes.GINGHAM);
    public static final WoolTypes GREEN_GINGHAM_WOOL = new WoolTypes(Blocks.GREEN_WOOL, Blocks.GREEN_CARPET, DyeColor.GREEN, WoolTypes.GINGHAM);
    public static final WoolTypes CYAN_GINGHAM_WOOL = new WoolTypes(Blocks.CYAN_WOOL, Blocks.CYAN_CARPET, DyeColor.CYAN, WoolTypes.GINGHAM);
    public static final WoolTypes LIGHT_BLUE_GINGHAM_WOOL = new WoolTypes(Blocks.LIGHT_BLUE_WOOL, Blocks.LIGHT_BLUE_CARPET, DyeColor.LIGHT_BLUE, WoolTypes.GINGHAM);
    public static final WoolTypes BLUE_GINGHAM_WOOL = new WoolTypes(Blocks.BLUE_WOOL, Blocks.BLUE_CARPET, DyeColor.BLUE, WoolTypes.GINGHAM);
    public static final WoolTypes PURPLE_GINGHAM_WOOL = new WoolTypes(Blocks.PURPLE_WOOL, Blocks.PURPLE_CARPET, DyeColor.PURPLE, WoolTypes.GINGHAM);
    public static final WoolTypes MAGENTA_GINGHAM_WOOL = new WoolTypes(Blocks.MAGENTA_WOOL, Blocks.MAGENTA_CARPET, DyeColor.MAGENTA, WoolTypes.GINGHAM);
    public static final WoolTypes PINK_GINGHAM_WOOL = new WoolTypes(Blocks.PINK_WOOL, Blocks.PINK_CARPET, DyeColor.PINK, WoolTypes.GINGHAM);

    // Glazed Terracotta Pillars
    public static final Block WHITE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.WHITE_GLAZED_TERRACOTTA);
    public static final Block LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
    public static final Block GRAY_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.GRAY_GLAZED_TERRACOTTA);
    public static final Block BLACK_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.BLACK_GLAZED_TERRACOTTA);
    public static final Block BROWN_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.BROWN_GLAZED_TERRACOTTA);
    public static final Block RED_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.RED_GLAZED_TERRACOTTA);
    public static final Block ORANGE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.ORANGE_GLAZED_TERRACOTTA);
    public static final Block YELLOW_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.YELLOW_GLAZED_TERRACOTTA);
    public static final Block LIME_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.LIME_GLAZED_TERRACOTTA);
    public static final Block GREEN_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.GREEN_GLAZED_TERRACOTTA);
    public static final Block CYAN_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.CYAN_GLAZED_TERRACOTTA);
    public static final Block LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
    public static final Block BLUE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.BLUE_GLAZED_TERRACOTTA);
    public static final Block PURPLE_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.PURPLE_GLAZED_TERRACOTTA);
    public static final Block MAGENTA_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.MAGENTA_GLAZED_TERRACOTTA);
    public static final Block PINK_GLAZED_TERRACOTTA_PILLAR = registerPillar(Blocks.PINK_GLAZED_TERRACOTTA);

    // Pressure Plates
    public static final Block POLISHED_ANDESITE_PRESSURE_PLATE = registerStonePressurePlate(Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_DIORITE_PRESSURE_PLATE = registerStonePressurePlate(Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_GRANITE_PRESSURE_PLATE = registerStonePressurePlate(Blocks.POLISHED_GRANITE);
    public static final Block LIMESTONE_PRESSURE_PLATE = registerStonePressurePlate(BlockusBlocks.LIMESTONE.block);
    public static final Block MARBLE_PRESSURE_PLATE = registerStonePressurePlate(BlockusBlocks.MARBLE.block);
    public static final Block BLUESTONE_PRESSURE_PLATE = registerStonePressurePlate(BlockusBlocks.BLUESTONE.block);
    public static final Block VIRIDITE_PRESSURE_PLATE = registerStonePressurePlate(BlockusBlocks.VIRIDITE.block);
    public static final Block POLISHED_NETHERRACK_PRESSURE_PLATE = registerStonePressurePlate(BlockusBlocks.POLISHED_NETHERRACK.block);
    public static final Block POLISHED_END_STONE_PRESSURE_PLATE = registerStonePressurePlate(BlockusBlocks.POLISHED_END_STONE.block);
    public static final Block POLISHED_BASALT_PRESSURE_PLATE = registerStonePressurePlate(Blocks.POLISHED_BASALT);
    public static final Block POLISHED_DEEPSLATE_PRESSURE_PLATE = registerStonePressurePlate(Blocks.POLISHED_DEEPSLATE);
    public static final Block POLISHED_TUFF_PRESSURE_PLATE = registerStonePressurePlate(Blocks.POLISHED_TUFF);
    public static final Block POLISHED_SCULK_PRESSURE_PLATE = registerStonePressurePlate(BlockusBlocks.POLISHED_SCULK.block);
    public static final Block OBSIDIAN_PRESSURE_PLATE = register("obsidian_pressure_plate", new ObsidianPressurePlateBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN).solid().noCollision().pistonBehavior(PistonBehavior.DESTROY)));

    // Buttons
    public static final Block POLISHED_ANDESITE_BUTTON = registerStoneButton(Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_DIORITE_BUTTON = registerStoneButton(Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_GRANITE_BUTTON = registerStoneButton(Blocks.POLISHED_GRANITE);
    public static final Block LIMESTONE_BUTTON = registerStoneButton(BlockusBlocks.LIMESTONE.block);
    public static final Block MARBLE_BUTTON = registerStoneButton(BlockusBlocks.MARBLE.block);
    public static final Block BLUESTONE_BUTTON = registerStoneButton(BlockusBlocks.BLUESTONE.block);
    public static final Block VIRIDITE_BUTTON = registerStoneButton(BlockusBlocks.VIRIDITE.block);
    public static final Block POLISHED_NETHERRACK_BUTTON = registerStoneButton(BlockusBlocks.POLISHED_NETHERRACK.block);
    public static final Block POLISHED_END_STONE_BUTTON = registerStoneButton(BlockusBlocks.POLISHED_END_STONE.block);
    public static final Block POLISHED_BASALT_BUTTON = registerStoneButton(Blocks.POLISHED_BASALT);
    public static final Block POLISHED_DEEPSLATE_BUTTON = registerStoneButton(Blocks.POLISHED_DEEPSLATE);
    public static final Block POLISHED_TUFF_BUTTON = registerStoneButton(Blocks.POLISHED_TUFF);
    public static final Block POLISHED_SCULK_BUTTON = registerStoneButton(BlockusBlocks.POLISHED_SCULK.block);

    // Thatch
    public static final BSSWTypes THATCH = new BSSWTypes("thatch", Blocks.HAY_BLOCK, false);

    // Paper
    public static final Block PAPER_BLOCK = register("paper_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS)));
    public static final Block BURNT_PAPER_BLOCK = register("burnt_paper_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS)));
    public static final Block FRAMED_PAPER_BLOCK = register("framed_paper_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASS).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block PAPER_WALL = register("paper_wall", createWoodenPane());
    public static final Block PAPER_DOOR = register("paper_door", createWoodenDoor(0.1f, 0.8f, BlockSoundGroup.WOOD, MapColor.OFF_WHITE, BlockSetType.OAK));
    public static final Block PAPER_TRAPDOOR = register("paper_trapdoor", createWoodenTrapdoor(0.1f, 0.8f, BlockSoundGroup.WOOD, MapColor.OFF_WHITE, BlockSetType.OAK));
    public static final Block PAPER_LAMP = register("paper_lamp", new PaperLampBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS).luminance((state) -> 15).instrument(NoteBlockInstrument.BASS)));

    // Plating
    public static final BSSWTypes IRON_PLATING = new BSSWTypes("iron_plating", Blocks.IRON_BLOCK, MapColor.STONE_GRAY, false);
    public static final BSSWTypes GOLD_PLATING = new BSSWTypes("gold_plating", Blocks.GOLD_BLOCK, false);

    // Gates - chains - bars
    public static final Block IRON_GATE = register("iron_gate", new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
    public static final Block GOLDEN_GATE = register("golden_gate", new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
    public static final Block GOLDEN_BARS = register("golden_bars", new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)));
    public static final Block GOLDEN_CHAIN = register("golden_chain", new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN)));

    // Lantern Blocks
    public static final Block LANTERN_BLOCK = register("lantern_block", createCopy(Blocks.LANTERN));
    public static final Block SOUL_LANTERN_BLOCK = register("soul_lantern_block", createCopy(Blocks.SOUL_LANTERN));
    public static final Block REDSTONE_LANTERN = register("redstone_lantern", new RedstoneLantern(AbstractBlock.Settings.copy(Blocks.LANTERN).luminance((state) -> 7).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block REDSTONE_LANTERN_BLOCK = register("redstone_lantern_block", new RedstoneBlock(AbstractBlock.Settings.copy(REDSTONE_LANTERN).luminance((state) -> 7)));
    public static final Block SOUL_O_LANTERN = register("soul_o_lantern", new CarvedPumpkinBlock(AbstractBlock.Settings.copy(Blocks.JACK_O_LANTERN).luminance((state) -> 10).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block REDSTONE_O_LANTERN = register("redstone_o_lantern", new RedstonePumpkinBlock(AbstractBlock.Settings.copy(Blocks.JACK_O_LANTERN).luminance((state) -> 7).pistonBehavior(PistonBehavior.DESTROY)));

    // Barriers
    public static final Block CAUTION_BARRIER = register("caution_barrier", createBarrier(1.5f, 1200.0f, MapColor.YELLOW));
    public static final Block ROAD_BARRIER = register("road_barrier", createBarrier(2f, 6.0f, MapColor.STONE_GRAY));

    // Netherite Blocks
    public static final Block NETHERITE_STAIRS = registerStairs(Blocks.NETHERITE_BLOCK);
    public static final Block NETHERITE_SLAB = registerSlab(Blocks.NETHERITE_BLOCK);

    // Other
    public static final Block PATH = register("path", new DirtPathBlock(AbstractBlock.Settings.copy(Blocks.DIRT_PATH)));
    public static final Block CHARCOAL_BLOCK = register("charcoal_block", createCopy(Blocks.COAL_BLOCK));
    public static final Block SUGAR_BLOCK = register("sugar_block", createFallingBlock(0.5f, 0.5f, BlockSoundGroup.SAND, MapColor.OFF_WHITE));
    public static final Block ENDER_BLOCK = register("ender_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GREEN).strength(5.0f, 6.0f)));
    public static final Block ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_RED).strength(0.5f).sounds(BlockSoundGroup.SLIME)));
    public static final Block MEMBRANE_BLOCK = register("membrane_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.5f).sounds(BlockSoundGroup.SLIME)));
    public static final Block NETHER_STAR_BLOCK = registerGlint("nether_stars_block", new NetherStarBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).strength(5.0f, 6.0f).requiresTool()));
    public static final Block REDSTONE_SAND = register("redstone_sand", new FallingRedstoneBlock(AbstractBlock.Settings.copy(Blocks.SAND).mapColor(MapColor.BRIGHT_RED)));
    public static final Block LOVE_BLOCK = register("love_block", new LoveBlock(AbstractBlock.Settings.create().mapColor(MapColor.PINK).strength(2, 6.0f).requiresTool()));
    public static final Block WEIGHT_STORAGE_CUBE = register("weight_storage_cube", new WeightStorageCubeBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).strength(0.1f, 6.0f)));
    public static final Block COMPANION_CUBE = register("companion_cube", createFallingBlock(0.1f, 6.0f, BlockSoundGroup.STONE, MapColor.IRON_GRAY));
    public static final Block CAUTION_BLOCK = register("caution_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).strength(1.5f, 1200.0f).requiresTool()));
    public static final Block STARS_BLOCK = register("stars_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(5.0f, 6.0f)));

    // Legacy
    public static final Block LEGACY_SAPLING = registerLegacy("legacy_sapling", new SaplingBlock(BlockusSaplingGenerator.LEGACY_OAK, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    public static final PottedLargeTypes POTTED_LEGACY_TREE = new PottedLargeTypes("potted_legacy_tree", BlockusBlocks.LEGACY_SAPLING);
    public static final Block POTTED_LEGACY_SAPLING = registerNoItem("potted_legacy_sapling", createPottedPlant(LEGACY_SAPLING));
    public static final Block LEGACY_FIRST_GRASS_BLOCK = registerLegacy("legacy_first_grass_block", createCopy(Blocks.GRASS_BLOCK));
    public static final Block LEGACY_GRASS_BLOCK = registerLegacy("legacy_grass_block", createCopy(Blocks.GRASS_BLOCK));
    public static final Block LEGACY_LEAVES = registerLegacy("legacy_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.LIME).allowsSpawning(BlockusBlocks::canSpawnOnLeaves).suffocates(BlockusBlocks::never).blockVision(BlockusBlocks::never)));
    public static final Block LEGACY_LOG = registerLegacy("legacy_log", createPillarCopy(Blocks.OAK_LOG));
    public static final Block LEGACY_BRICKS = registerLegacy("legacy_bricks", createCopy(Blocks.BRICKS));
    public static final Block LEGACY_PLANKS = registerLegacy("legacy_planks", createCopy(Blocks.OAK_PLANKS));
    public static final Block LEGACY_FIRST_COBBLESTONE = registerLegacy("legacy_first_cobblestone", createCopy(Blocks.COBBLESTONE));
    public static final Block LEGACY_COBBLESTONE = registerLegacy("legacy_cobblestone", createCopy(Blocks.COBBLESTONE));
    public static final Block LEGACY_MOSSY_COBBLESTONE = registerLegacy("legacy_mossy_cobblestone", createCopy(Blocks.MOSSY_COBBLESTONE));
    public static final Block LEGACY_GRAVEL = registerLegacy("legacy_gravel", new ColoredFallingBlock(new ColorCode(-8356741),AbstractBlock.Settings.copy(Blocks.GRAVEL)));
    public static final Block LEGACY_IRON_BLOCK = registerLegacy("legacy_iron_block", createCopy(Blocks.IRON_BLOCK));
    public static final Block LEGACY_GOLD_BLOCK = registerLegacy("legacy_gold_block", createCopy(Blocks.GOLD_BLOCK));
    public static final Block LEGACY_EXPLOSION_PROOF_GOLD_BLOCK = registerLegacy("legacy_explosion_proof_gold_block", new Block(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).strength(5.0f, 6000.0f)));
    public static final Block LEGACY_COAL_BLOCK = registerLegacy("legacy_coal_block", createCopy(Blocks.COAL_BLOCK));
    public static final Block LEGACY_DIAMOND_BLOCK = registerLegacy("legacy_diamond_block", createCopy(Blocks.DIAMOND_BLOCK));
    public static final Block LEGACY_LAPIS_BLOCK = registerLegacy("legacy_lapis_block", createCopy(Blocks.LAPIS_BLOCK));
    public static final Block LEGACY_SPONGE = registerLegacy("legacy_sponge", new SpongeBlock(AbstractBlock.Settings.copy(Blocks.SPONGE)));
    public static final Block LEGACY_CRYING_OBSIDIAN = registerLegacy("legacy_crying_obsidian", createCopy(Blocks.CRYING_OBSIDIAN, PistonBehavior.BLOCK));
    public static final Block LEGACY_GLOWSTONE = registerLegacy("legacy_glowstone", createCopy(Blocks.GLOWSTONE));
    public static final Block LEGACY_STONECUTTER = registerLegacy("legacy_stonecutter", new LegacyStonecutterBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE).strength(1.5f, 17.5f)));
    public static final Block LEGACY_GLOWING_OBSIDIAN = registerLegacy("legacy_glowing_obsidian", createCopy(BlockusBlocks.GLOWING_OBSIDIAN));
    public static final Block LEGACY_NETHER_REACTOR_CORE = registerLegacy("legacy_nether_reactor_core", new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.5f, 6.0f).requiresTool()));

    // Colored Tiles
    /**
     * <p>Bicolor variants in {@link ColoredTilesTypes}.
     */
    public static final Block WHITE_COLORED_TILES = register("white_colored_tiles", createCopy(Blocks.WHITE_CONCRETE));
    public static final Block ORANGE_COLORED_TILES = register("orange_colored_tiles", createCopy(Blocks.ORANGE_CONCRETE));
    public static final Block MAGENTA_COLORED_TILES = register("magenta_colored_tiles", createCopy(Blocks.MAGENTA_CONCRETE));
    public static final Block LIGHT_BLUE_COLORED_TILES = register("light_blue_colored_tiles", createCopy(Blocks.LIGHT_BLUE_CONCRETE));
    public static final Block YELLOW_COLORED_TILES = register("yellow_colored_tiles", createCopy(Blocks.YELLOW_CONCRETE));
    public static final Block LIME_COLORED_TILES = register("lime_colored_tiles", createCopy(Blocks.LIME_CONCRETE));
    public static final Block PINK_COLORED_TILES = register("pink_colored_tiles", createCopy(Blocks.PINK_CONCRETE));
    public static final Block GRAY_COLORED_TILES = register("gray_colored_tiles", createCopy(Blocks.GRAY_CONCRETE));
    public static final Block LIGHT_GRAY_COLORED_TILES = register("light_gray_colored_tiles", createCopy(Blocks.LIGHT_GRAY_CONCRETE));
    public static final Block CYAN_COLORED_TILES = register("cyan_colored_tiles", createCopy(Blocks.CYAN_CONCRETE));
    public static final Block PURPLE_COLORED_TILES = register("purple_colored_tiles", createCopy(Blocks.PURPLE_CONCRETE));
    public static final Block BLUE_COLORED_TILES = register("blue_colored_tiles", createCopy(Blocks.BLUE_CONCRETE));
    public static final Block BROWN_COLORED_TILES = register("brown_colored_tiles", createCopy(Blocks.BROWN_CONCRETE));
    public static final Block GREEN_COLORED_TILES = register("green_colored_tiles", createCopy(Blocks.GREEN_CONCRETE));
    public static final Block RED_COLORED_TILES = register("red_colored_tiles", createCopy(Blocks.RED_CONCRETE));
    public static final Block BLACK_COLORED_TILES = register("black_colored_tiles", createCopy(Blocks.BLACK_CONCRETE));
    public static final Block RAINBOW_COLORED_TILES = register("rainbow_colored_tiles", new HorizontalAxisBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE)));

}
