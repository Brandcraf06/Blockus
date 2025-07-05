package com.brand.blockus.registry.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.*;
import com.brand.blockus.blocks.base.amethyst.AmethystLampBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystPillarBlock;
import com.brand.blockus.blocks.base.asphalt.RainbowAsphalt;
import com.brand.blockus.blocks.base.redstone.FallingRedstoneBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneLantern;
import com.brand.blockus.blocks.base.redstone.RedstonePumpkinBlock;
import com.brand.blockus.blocks.generator.BlockusSaplingGenerator;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.registry.content.bundles.CopperBundle.OxidationType;
import com.brand.blockus.utils.helper.BlockFactory;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlockHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.DyeColor;

public class BlockusBlocks extends BlockFactory {

    // Stone
    public static final BSSWBundle STONE_TILES = BSSWBundle.of("stone_tiles", Blocks.STONE_BRICKS).register();
    public static final Block STONE_BRICK_PILLAR = pillar(Blocks.STONE_BRICKS);
    public static final Block HERRINGBONE_STONE_BRICKS = registerCopy("herringbone_stone_bricks", Blocks.STONE_BRICKS);
    public static final Block STONE_CIRCULAR_PAVING = registerCopy("stone_circular_paving", OrientableBlockBase::new, Blocks.STONE_BRICKS);
    public static final Block STONE_DOOR = stoneDoor("stone_door", 1.5f, 20.0f, BlockSoundGroup.STONE, MapColor.STONE_GRAY, BlockSetType.STONE);
    public static final Block STONE_TRAPDOOR = stoneTrapdoor("stone_trapdoor", 1.5f, 20.0f, BlockSoundGroup.STONE, MapColor.STONE_GRAY, BlockSetType.STONE);
    public static final Block SMOOTH_STONE_STAIRS = stairs(Blocks.SMOOTH_STONE);
    public static final Block STURDY_STONE = pistonProof("sturdy_stone", Blocks.COBBLESTONE);

    // Andesite
    public static final BSSWBundle ANDESITE_BRICKS = BSSWBundle.of("andesite_bricks", Blocks.POLISHED_ANDESITE).register();
    public static final Block CRACKED_ANDESITE_BRICKS = registerCopy("cracked_andesite_bricks", BlockusBlocks.ANDESITE_BRICKS.block());
    public static final Block CHISELED_ANDESITE_BRICKS = registerCopy("chiseled_andesite_bricks", BlockusBlocks.ANDESITE_BRICKS.block());
    public static final Block POLISHED_ANDESITE_PILLAR = pillar(Blocks.POLISHED_ANDESITE);
    public static final Block HERRINGBONE_ANDESITE_BRICKS = registerCopy("herringbone_andesite_bricks", BlockusBlocks.ANDESITE_BRICKS.block());
    public static final Block ANDESITE_CIRCULAR_PAVING = registerCopy("andesite_circular_paving", OrientableBlockBase::new, BlockusBlocks.ANDESITE_BRICKS.block());

    // Diorite
    public static final BSSWBundle DIORITE_BRICKS = BSSWBundle.of("diorite_bricks", Blocks.POLISHED_DIORITE).register();
    public static final Block CRACKED_DIORITE_BRICKS = registerCopy("cracked_diorite_bricks", BlockusBlocks.DIORITE_BRICKS.block());
    public static final Block CHISELED_DIORITE_BRICKS = registerCopy("chiseled_diorite_bricks", BlockusBlocks.DIORITE_BRICKS.block());
    public static final Block POLISHED_DIORITE_PILLAR = pillar(Blocks.POLISHED_DIORITE);
    public static final Block HERRINGBONE_DIORITE_BRICKS = registerCopy("herringbone_diorite_bricks", BlockusBlocks.DIORITE_BRICKS.block());
    public static final Block DIORITE_CIRCULAR_PAVING = registerCopy("diorite_circular_paving", OrientableBlockBase::new, BlockusBlocks.DIORITE_BRICKS.block());

    // Granite
    public static final BSSWBundle GRANITE_BRICKS = BSSWBundle.of("granite_bricks", Blocks.POLISHED_GRANITE).register();
    public static final Block CRACKED_GRANITE_BRICKS = registerCopy("cracked_granite_bricks", BlockusBlocks.GRANITE_BRICKS.block());
    public static final Block CHISELED_GRANITE_BRICKS = registerCopy("chiseled_granite_bricks", BlockusBlocks.GRANITE_BRICKS.block());
    public static final Block POLISHED_GRANITE_PILLAR = pillar(Blocks.POLISHED_GRANITE);
    public static final Block HERRINGBONE_GRANITE_BRICKS = registerCopy("herringbone_granite_bricks", BlockusBlocks.GRANITE_BRICKS.block());
    public static final Block GRANITE_CIRCULAR_PAVING = registerCopy("granite_circular_paving", OrientableBlockBase::new, BlockusBlocks.GRANITE_BRICKS.block());

    // Mud
    public static final Block CHISELED_MUD_BRICKS = registerCopy("chiseled_mud_bricks", Blocks.MUD_BRICKS);
    public static final Block MUD_BRICK_PILLAR = pillar(Blocks.MUD_BRICKS);

    // Dripstone
    public static final BSSWBundle POLISHED_DRIPSTONE = BSSWBundle.of("polished_dripstone", Blocks.DRIPSTONE_BLOCK).includeWall(false).register();
    public static final BSSWBundle DRIPSTONE_BRICKS = BSSWBundle.of("dripstone_bricks", BlockusBlocks.POLISHED_DRIPSTONE.block()).register();
    public static final BSSWBundle MOSSY_DRIPSTONE_BRICKS = BSSWBundle.of("mossy_dripstone_bricks", BlockusBlocks.DRIPSTONE_BRICKS.block()).register();
    public static final Block CRACKED_DRIPSTONE_BRICKS = registerCopy("cracked_dripstone_bricks", BlockusBlocks.DRIPSTONE_BRICKS.block());
    public static final Block CHISELED_DRIPSTONE = registerCopy("chiseled_dripstone", BlockusBlocks.DRIPSTONE_BRICKS.block());
    public static final Block DRIPSTONE_PILLAR = pillar("dripstone", BlockusBlocks.DRIPSTONE_BRICKS.block());

    // Tuff
    public static final BSSWBundle MOSSY_TUFF_BRICKS = BSSWBundle.of("mossy_tuff_bricks", Blocks.TUFF_BRICKS).register();
    public static final BSSWBundle TUFF_TILES = BSSWBundle.of("tuff_tiles", Blocks.TUFF_BRICKS).register();
    public static final Block CRACKED_TUFF_BRICKS = registerCopy("cracked_tuff_bricks", Blocks.TUFF_BRICKS);
    public static final Block CARVED_TUFF_BRICKS = registerCopy("carved_tuff_bricks", Blocks.TUFF_BRICKS);
    public static final Block HERRINGBONE_TUFF_BRICKS = registerCopy("herringbone_tuff_bricks", Blocks.TUFF_BRICKS);
    public static final Block TUFF_CIRCULAR_PAVING = registerCopy("tuff_circular_paving", OrientableBlockBase::new, Blocks.TUFF_BRICKS);
    public static final Block TUFF_PILLAR = pillar("tuff", Blocks.POLISHED_TUFF);

    // Deepslate
    public static final BSSWBundle MOSSY_DEEPSLATE_BRICKS = BSSWBundle.of("mossy_deepslate_bricks", Blocks.DEEPSLATE_BRICKS).register();
    public static final Block DEEPSLATE_PILLAR = pillar("deepslate", Blocks.POLISHED_DEEPSLATE);
    public static final Block HERRINGBONE_DEEPSLATE_BRICKS = registerCopy("herringbone_deepslate_bricks", Blocks.DEEPSLATE_BRICKS);
    public static final Block DEEPSLATE_CIRCULAR_PAVING = registerCopy("deepslate_circular_paving", OrientableBlockBase::new, Blocks.DEEPSLATE_BRICKS);
    public static final Block STURDY_DEEPSLATE = pistonProof("sturdy_deepslate", Blocks.COBBLED_DEEPSLATE);

    // Sculk
    public static final BSSWBundle POLISHED_SCULK = BSSWBundle.of("polished_sculk", Blocks.POLISHED_DEEPSLATE, MapColor.CYAN).includeWall(false).register();
    public static final BSSWBundle SCULK_BRICKS = BSSWBundle.of("sculk_bricks", BlockusBlocks.POLISHED_SCULK.block()).register();
    public static final Block CHISELED_SCULK_BRICKS = registerCopy("chiseled_sculk_bricks", BlockusBlocks.SCULK_BRICKS.block());
    public static final Block SCULK_PILLAR = pillar("sculk", BlockusBlocks.SCULK_BRICKS.block());

    // Amethyst
    public static final BSSWBundle POLISHED_AMETHYST = BSSWBundle.of("polished_amethyst", Blocks.AMETHYST_BLOCK).includeWall(false).register();
    public static final BSSWBundle AMETHYST_BRICKS = BSSWBundle.of("amethyst_bricks", POLISHED_AMETHYST.block()).register();
    public static final Block CHISELED_AMETHYST = registerCopy("chiseled_amethyst", AmethystBlock::new, AMETHYST_BRICKS.block());
    public static final Block AMETHYST_PILLAR = registerCopy("amethyst_pillar", AmethystPillarBlock::new, AMETHYST_BRICKS.block());

    // Blackstone
    public static final BSSWBundle POLISHED_BLACKSTONE_TILES = BSSWBundle.of("polished_blackstone_tiles", Blocks.POLISHED_BLACKSTONE_BRICKS).register();
    public static final BSSWBundle CRIMSON_WARTY_BLACKSTONE_BRICKS = BSSWBundle.of("crimson_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE).register();
    public static final BSSWBundle WARPED_WARTY_BLACKSTONE_BRICKS = BSSWBundle.of("warped_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE).register();
    public static final Block POLISHED_BLACKSTONE_PILLAR = pillar(Blocks.POLISHED_BLACKSTONE);
    public static final Block HERRINGBONE_POLISHED_BLACKSTONE_BRICKS = registerCopy("herringbone_polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE);
    public static final Block POLISHED_BLACKSTONE_CIRCULAR_PAVING = registerCopy("polished_blackstone_circular_paving", OrientableBlockBase::new, Blocks.POLISHED_BLACKSTONE);
    public static final Block GOLD_DECORATED_POLISHED_BLACKSTONE = registerCopy("gold_decorated_polished_blackstone", Blocks.POLISHED_BLACKSTONE);
    public static final Block BLACKSTONE_DOOR = stoneDoor("blackstone_door", 1.5f, 6.0f, BlockSoundGroup.STONE, MapColor.BLACK, BlockSetType.STONE);
    public static final Block BLACKSTONE_TRAPDOOR = stoneTrapdoor("blackstone_trapdoor", 1.5f, 6.0f, BlockSoundGroup.STONE, MapColor.BLACK, BlockSetType.STONE);
    public static final Block STURDY_BLACKSTONE = pistonProof("sturdy_blackstone", Blocks.BLACKSTONE);

    // Basalt
    public static final BSSWBundle ROUGH_BASALT = BSSWBundle.of("rough_basalt", Blocks.BASALT).includeWall(false).register();
    public static final BSSWBundle POLISHED_BASALT_BRICKS = BSSWBundle.of("polished_basalt_bricks", Blocks.POLISHED_BASALT).register();
    public static final Block CRACKED_POLISHED_BASALT_BRICKS = registerCopy("cracked_polished_basalt_bricks", BlockusBlocks.POLISHED_BASALT_BRICKS.block());
    public static final Block CHISELED_POLISHED_BASALT = registerCopy("chiseled_polished_basalt", BlockusBlocks.POLISHED_BASALT_BRICKS.block());
    public static final Block POLISHED_BASALT_PILLAR = pillar("polished_basalt", BlockusBlocks.POLISHED_BASALT_BRICKS.block());
    public static final Block HERRINGBONE_POLISHED_BASALT_BRICKS = registerCopy("herringbone_polished_basalt_bricks", BlockusBlocks.POLISHED_BASALT_BRICKS.block());
    public static final Block POLISHED_BASALT_CIRCULAR_PAVING = registerCopy("polished_basalt_circular_paving", OrientableBlockBase::new, BlockusBlocks.POLISHED_BASALT_BRICKS.block());

    // Wart Blocks
    public static final BSSWBundle CRIMSON_WART_BRICKS = BSSWBundle.of("crimson_wart_bricks", Blocks.NETHER_WART_BLOCK, BlockSoundGroup.NETHER_BRICKS).register();
    public static final BSSWBundle WARPED_WART_BRICKS = BSSWBundle.of("warped_wart_bricks", Blocks.WARPED_WART_BLOCK, BlockSoundGroup.NETHER_BRICKS).register();

    // Limestone
    public static final BSSWBundle LIMESTONE = BSSWBundle.of("limestone", Blocks.STONE, MapColor.OAK_TAN).register();
    public static final BSSWBundle POLISHED_LIMESTONE = BSSWBundle.of("polished_limestone", BlockusBlocks.LIMESTONE.block()).includeWall(false).register();
    public static final BSSWBundle LIMESTONE_BRICKS = BSSWBundle.of("limestone_bricks", LIMESTONE.block()).register();
    public static final BSSWBundle SMALL_LIMESTONE_BRICKS = BSSWBundle.of("small_limestone_bricks", LIMESTONE_BRICKS.block()).register();
    public static final BSSWBundle LIMESTONE_TILES = BSSWBundle.of("limestone_tiles", LIMESTONE_BRICKS.block()).register();
    public static final Block CHISELED_LIMESTONE = registerCopy("chiseled_limestone", BlockusBlocks.LIMESTONE_BRICKS.block());
    public static final Block CHISELED_LIMESTONE_BRICKS = pillar2("chiseled_limestone_bricks", BlockusBlocks.LIMESTONE_BRICKS.block());
    public static final Block CHISELED_LIMESTONE_PILLAR = pillar(BlockusBlocks.CHISELED_LIMESTONE);
    public static final Block LIMESTONE_SQUARES = registerCopy("limestone_squares", BlockusBlocks.LIMESTONE_BRICKS.block());
    public static final Block LIMESTONE_CIRCULAR_PAVING = registerCopy("limestone_circular_paving", OrientableBlockBase::new, BlockusBlocks.LIMESTONE_BRICKS.block());
    public static final Block LIMESTONE_LINES = pillar2("limestone_lines", BlockusBlocks.LIMESTONE_BRICKS.block());
    public static final Block LIMESTONE_PILLAR = pillar(BlockusBlocks.LIMESTONE.block());

    // Marble
    public static final BSSWBundle MARBLE = BSSWBundle.of("marble", Blocks.STONE, MapColor.OFF_WHITE).register();
    public static final BSSWBundle POLISHED_MARBLE = BSSWBundle.of("polished_marble", BlockusBlocks.MARBLE.block()).includeWall(false).register();
    public static final BSSWBundle MARBLE_BRICKS = BSSWBundle.of("marble_bricks", MARBLE.block()).register();
    public static final BSSWBundle SMALL_MARBLE_BRICKS = BSSWBundle.of("small_marble_bricks", MARBLE_BRICKS.block()).register();
    public static final BSSWBundle MARBLE_TILES = BSSWBundle.of("marble_tiles", MARBLE_BRICKS.block()).register();
    public static final Block CHISELED_MARBLE = registerCopy("chiseled_marble", BlockusBlocks.MARBLE_BRICKS.block());
    public static final Block CHISELED_MARBLE_BRICKS = pillar2("chiseled_marble_bricks", BlockusBlocks.MARBLE_BRICKS.block());
    public static final Block CHISELED_MARBLE_PILLAR = pillar(BlockusBlocks.CHISELED_MARBLE);
    public static final Block MARBLE_SQUARES = registerCopy("marble_squares", BlockusBlocks.MARBLE_BRICKS.block());
    public static final Block MARBLE_CIRCULAR_PAVING = registerCopy("marble_circular_paving", OrientableBlockBase::new, BlockusBlocks.MARBLE_BRICKS.block());
    public static final Block MARBLE_LINES = pillar2("marble_lines", BlockusBlocks.MARBLE_BRICKS.block());
    public static final Block MARBLE_PILLAR = pillar(BlockusBlocks.MARBLE.block());

    // Bluestone
    public static final BSSWBundle BLUESTONE = BSSWBundle.of("bluestone", Blocks.STONE, MapColor.CYAN).register();;
    public static final BSSWBundle POLISHED_BLUESTONE = BSSWBundle.of("polished_bluestone", BlockusBlocks.BLUESTONE.block()).includeWall(false).register();
    public static final BSSWBundle BLUESTONE_BRICKS = BSSWBundle.of("bluestone_bricks", BLUESTONE.block()).register();
    public static final BSSWBundle SMALL_BLUESTONE_BRICKS = BSSWBundle.of("small_bluestone_bricks", BLUESTONE_BRICKS.block()).register();
    public static final BSSWBundle BLUESTONE_TILES = BSSWBundle.of("bluestone_tiles", BLUESTONE_BRICKS.block()).register();
    public static final Block CHISELED_BLUESTONE = registerCopy("chiseled_bluestone", BlockusBlocks.BLUESTONE_BRICKS.block());
    public static final Block CHISELED_BLUESTONE_BRICKS = pillar2("chiseled_bluestone_bricks", BlockusBlocks.BLUESTONE_BRICKS.block());
    public static final Block CHISELED_BLUESTONE_PILLAR = pillar(BlockusBlocks.CHISELED_BLUESTONE);
    public static final Block BLUESTONE_SQUARES = registerCopy("bluestone_squares", BlockusBlocks.BLUESTONE_BRICKS.block());
    public static final Block BLUESTONE_CIRCULAR_PAVING = registerCopy("bluestone_circular_paving", OrientableBlockBase::new, BlockusBlocks.BLUESTONE_BRICKS.block());
    public static final Block BLUESTONE_LINES = pillar2("bluestone_lines", BlockusBlocks.BLUESTONE_BRICKS.block());
    public static final Block BLUESTONE_PILLAR = pillar(BlockusBlocks.BLUESTONE.block());

    // Viridite
    public static final BSSWBundle VIRIDITE = BSSWBundle.of("viridite", Blocks.DEEPSLATE, MapColor.DARK_GREEN).register();
    public static final BSSWBundle POLISHED_VIRIDITE = BSSWBundle.of("polished_viridite", BlockusBlocks.VIRIDITE.block()).includeWall(false).register();
    public static final BSSWBundle VIRIDITE_BRICKS = BSSWBundle.of("viridite_bricks", VIRIDITE.block()).register();
    public static final BSSWBundle SMALL_VIRIDITE_BRICKS = BSSWBundle.of("small_viridite_bricks", VIRIDITE_BRICKS.block()).register();
    public static final BSSWBundle VIRIDITE_TILES = BSSWBundle.of("viridite_tiles", VIRIDITE_BRICKS.block()).register();
    public static final Block CHISELED_VIRIDITE = registerCopy("chiseled_viridite", BlockusBlocks.VIRIDITE_BRICKS.block());
    public static final Block CHISELED_VIRIDITE_BRICKS = pillar2("chiseled_viridite_bricks", BlockusBlocks.VIRIDITE_BRICKS.block());
    public static final Block CHISELED_VIRIDITE_PILLAR = pillar(BlockusBlocks.CHISELED_VIRIDITE);
    public static final Block VIRIDITE_SQUARES = registerCopy("viridite_squares", BlockusBlocks.VIRIDITE_BRICKS.block());
    public static final Block VIRIDITE_CIRCULAR_PAVING = registerCopy("viridite_circular_paving", OrientableBlockBase::new, BlockusBlocks.VIRIDITE_BRICKS.block());
    public static final Block VIRIDITE_LINES = pillar2("viridite_lines", BlockusBlocks.VIRIDITE_BRICKS.block());
    public static final Block VIRIDITE_PILLAR = pillar(BlockusBlocks.VIRIDITE.block());

    // Lava	Bricks
    public static final BSSWBundle LAVA_BRICKS = BSSWBundle.of("lava_bricks", Blocks.STONE_BRICKS, 15).register();
    public static final Block CHISELED_LAVA_BRICKS = registerCopy("chiseled_lava_bricks", BlockusBlocks.LAVA_BRICKS.block());

    // Lava Blackstone Bricks
    public static final BSSWBundle LAVA_POLISHED_BLACKSTONE_BRICKS = BSSWBundle.of("lava_polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS, 15).register();
    public static final Block CHISELED_LAVA_POLISHED_BLACKSTONE = registerCopy("chiseled_lava_polished_blackstone", BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.block());

    // Water Bricks
    public static final BSSWBundle WATER_BRICKS = BSSWBundle.of("water_bricks", Blocks.STONE_BRICKS).register();
    public static final Block CHISELED_WATER_BRICKS = registerCopy("chiseled_water_bricks", BlockusBlocks.WATER_BRICKS.block());

    // Snow Bricks
    public static final BSSWBundle SNOW_BRICKS = BSSWBundle.of("snow_bricks", Blocks.STONE_BRICKS, 1.0f, 3.0f, MapColor.WHITE).register();
    public static final Block SNOW_PILLAR = pillar("snow", SNOW_BRICKS.block());

    // Ice Bricks
    public static final Block ICE_BRICKS = registerOf("ice_bricks", create().mapColor(MapColor.PALE_PURPLE).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS));
    public static final Block ICE_BRICK_WALL = wall(ICE_BRICKS);
    public static final Block ICE_PILLAR = pillar("ice", ICE_BRICKS);

    // Obsidian
    public static final BSSWBundle OBSIDIAN_BRICKS = BSSWBundle.of("obsidian_bricks", Blocks.OBSIDIAN, PistonBehavior.BLOCK).register();
    public static final BSSWBundle SMALL_OBSIDIAN_BRICKS = BSSWBundle.of("small_obsidian_bricks", OBSIDIAN_BRICKS.block()).register();
    public static final Block CRACKED_OBSIDIAN_BRICKS = registerCopy("cracked_obsidian_bricks", BlockusBlocks.OBSIDIAN_BRICKS.block());
    public static final Block OBSIDIAN_PILLAR = pillar("obsidian", BlockusBlocks.OBSIDIAN_BRICKS.block());
    public static final Block OBSIDIAN_CIRCULAR_PAVING = registerCopy("obsidian_circular_paving", OrientableBlockBase::new, BlockusBlocks.OBSIDIAN_BRICKS.block());
    public static final Block OBSIDIAN_REINFORCED_DOOR = stoneDoor("obsidian_reinforced_door", 50.0F, 1200.0F, BlockSoundGroup.STONE, MapColor.BLACK, BlockSetType.GOLD);
    public static final Block OBSIDIAN_REINFORCED_TRAPDOOR = stoneTrapdoor("obsidian_reinforced_trapdoor", 50.0F, 1200.0F, BlockSoundGroup.STONE, MapColor.BLACK, BlockSetType.GOLD);
    public static final Block GLOWING_OBSIDIAN = registerCopy("glowing_obsidian", Blocks.OBSIDIAN, settings -> settings.mapColor(MapColor.RED).pistonBehavior(PistonBehavior.BLOCK).luminance((state) -> 15));

    // Netherrack
    public static final BSSWBundle POLISHED_NETHERRACK = BSSWBundle.of("polished_netherrack", Blocks.NETHERRACK).includeWall(false).register();
    public static final BSSWBundle NETHERRACK_BRICKS = BSSWBundle.of("netherrack_bricks", Blocks.NETHERRACK).register();
    public static final Block NETHERRACK_CIRCULAR_PAVING = registerCopy("netherrack_circular_paving", OrientableBlockBase::new, BlockusBlocks.POLISHED_NETHERRACK.block());

    // Quartz Blocks
    public static final BSSWBundle QUARTZ_TILES = BSSWBundle.of("quartz_tiles", Blocks.QUARTZ_BLOCK).register();
    public static final Block QUARTZ_CIRCULAR_PAVING = registerCopy("quartz_circular_paving", OrientableBlockBase::new, BlockusBlocks.QUARTZ_TILES.block());

    // Magma Bricks
    public static final BSSWBundle MAGMA_BRICKS = BSSWBundle.of("magma_bricks", Blocks.MAGMA_BLOCK, 15).register();
    public static final BSSWBundle SMALL_MAGMA_BRICKS = BSSWBundle.of("small_magma_bricks", Blocks.MAGMA_BLOCK, 15).register();
    public static final Block CHISELED_MAGMA_BRICKS = registerCopy("chiseled_magma_bricks", BlockusBlocks.MAGMA_BRICKS.block());

    // Blaze Bricks
    public static final BSSWBundle BLAZE_BRICKS = BSSWBundle.of("blaze_bricks", Blocks.NETHER_BRICKS, 15).register();
    public static final Block BLAZE_PILLAR = pillar("blaze", BlockusBlocks.BLAZE_BRICKS.block());
    public static final Block BLAZE_LANTERN = lampBlock("blaze_lantern", 0.3F, 0.3F, BlockSoundGroup.GLASS, 15, MapColor.ORANGE);

    // Nether Bricks
    public static final BSSWBundle POLISHED_NETHER_BRICKS = BSSWBundle.of("polished_nether_bricks", Blocks.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle POLISHED_RED_NETHER_BRICKS = BSSWBundle.of("polished_red_nether_bricks", Blocks.RED_NETHER_BRICKS).includeWall(false).register();
    public static final Block HERRINGBONE_NETHER_BRICKS = registerCopy("herringbone_nether_bricks", Blocks.NETHER_BRICKS);
    public static final Block HERRINGBONE_RED_NETHER_BRICKS = registerCopy("herringbone_red_nether_bricks", Blocks.RED_NETHER_BRICKS);
    public static final Block NETHER_BRICK_PILLAR = pillar(Blocks.NETHER_BRICKS);
    public static final Block RED_NETHER_BRICK_PILLAR = pillar(Blocks.RED_NETHER_BRICKS);
    public static final BSSWBundle NETHER_TILES = BSSWBundle.of("nether_tiles", Blocks.NETHER_BRICKS).register();

    // Charred Nether Bricks
    public static final BSSWBundle CHARRED_NETHER_BRICKS = BSSWBundle.of("charred_nether_bricks", Blocks.NETHER_BRICKS, MapColor.BLACK).register();
    public static final BSSWBundle POLISHED_CHARRED_NETHER_BRICKS = BSSWBundle.of("polished_charred_nether_bricks", BlockusBlocks.CHARRED_NETHER_BRICKS.block()).includeWall(false).register();
    public static final Block HERRINGBONE_CHARRED_NETHER_BRICKS = registerCopy("herringbone_charred_nether_bricks", BlockusBlocks.CHARRED_NETHER_BRICKS.block());
    public static final Block CHARRED_NETHER_BRICK_PILLAR = pillar(BlockusBlocks.CHARRED_NETHER_BRICKS.block());

    // Teal Nether Bricks
    public static final BSSWBundle TEAL_NETHER_BRICKS = BSSWBundle.of("teal_nether_bricks", Blocks.NETHER_BRICKS, MapColor.CYAN).register();
    public static final BSSWBundle POLISHED_TEAL_NETHER_BRICKS = BSSWBundle.of("polished_teal_nether_bricks", BlockusBlocks.TEAL_NETHER_BRICKS.block()).includeWall(false).register();
    public static final Block HERRINGBONE_TEAL_NETHER_BRICKS = registerCopy("herringbone_teal_nether_bricks", BlockusBlocks.TEAL_NETHER_BRICKS.block());
    public static final Block TEAL_NETHER_BRICK_PILLAR = pillar(BlockusBlocks.TEAL_NETHER_BRICKS.block());

    // Prismarine
    public static final Block CHISELED_PRISMARINE = registerCopy("chiseled_prismarine", Blocks.PRISMARINE_BRICKS);
    public static final Block PRISMARINE_PILLAR = pillar("prismarine", Blocks.PRISMARINE_BRICKS);
    public static final Block PRISMARINE_CIRCULAR_PAVING = registerCopy("prismarine_circular_paving", OrientableBlockBase::new, Blocks.PRISMARINE_BRICKS);
    public static final Block CHISELED_DARK_PRISMARINE = registerCopy("chiseled_dark_prismarine", OrientableBlockBase::new, Blocks.DARK_PRISMARINE);
    public static final Block DARK_PRISMARINE_PILLAR = pillar("dark_prismarine", Blocks.DARK_PRISMARINE);
    public static final BSSWBundle PRISMARINE_TILES = BSSWBundle.of("prismarine_tiles", Blocks.DARK_PRISMARINE).register();

    // Bricks
    public static final BSSWBundle LARGE_BRICKS = BSSWBundle.of("large_bricks", Blocks.BRICKS).register();
    public static final Block HERRINGBONE_BRICKS = registerCopy("herringbone_bricks", Blocks.BRICKS);

    // Soaked Bricks
    public static final BSSWBundle SOAKED_BRICKS = BSSWBundle.of("soaked_bricks", Blocks.BRICKS).register();
    public static final Block HERRINGBONE_SOAKED_BRICKS = registerCopy("herringbone_soaked_bricks", BlockusBlocks.SOAKED_BRICKS.block());

    // Charred Bricks
    public static final BSSWBundle CHARRED_BRICKS = BSSWBundle.of("charred_bricks", Blocks.BRICKS).register();
    public static final Block HERRINGBONE_CHARRED_BRICKS = registerCopy("herringbone_charred_bricks", BlockusBlocks.CHARRED_BRICKS.block());

    // Sandy Bricks
    public static final BSSWBundle SANDY_BRICKS = BSSWBundle.of("sandy_bricks", Blocks.BRICKS).register();
    public static final Block HERRINGBONE_SANDY_BRICKS = registerCopy("herringbone_sandy_bricks", BlockusBlocks.SANDY_BRICKS.block());

    // Resin Bricks
    public static final BSSWBundle LARGE_RESIN_BRICKS = BSSWBundle.of("large_resin_bricks", Blocks.RESIN_BRICKS).register();
    public static final Block HERRINGBONE_RESIN_BRICKS = registerCopy("herringbone_resin_bricks", Blocks.RESIN_BRICKS);
    public static final Block RESIN_BRICK_PILLAR = pillar(Blocks.RESIN_BRICKS);

    // Sandstone
    public static final BSSWBundle ROUGH_SANDSTONE = BSSWBundle.of("rough_sandstone", Blocks.SANDSTONE).includeWall(false).register();
    public static final BSSWBundle SANDSTONE_BRICKS = BSSWBundle.of("sandstone_bricks", Blocks.SANDSTONE).register();
    public static final BSSWBundle SMALL_SANDSTONE_BRICKS = BSSWBundle.of("small_sandstone_bricks", Blocks.SANDSTONE).register();
    public static final Block SANDSTONE_PILLAR = pillar("sandstone", Blocks.SANDSTONE);
    public static final Block GOLD_DECORATED_SANDSTONE = registerCopy("gold_decorated_sandstone", Blocks.SANDSTONE);
    public static final Block LAPIS_DECORATED_SANDSTONE = registerCopy("lapis_decorated_sandstone", Blocks.SANDSTONE);

    // Red Sandstone
    public static final BSSWBundle ROUGH_RED_SANDSTONE = BSSWBundle.of("rough_red_sandstone", Blocks.RED_SANDSTONE).includeWall(false).register();
    public static final BSSWBundle RED_SANDSTONE_BRICKS = BSSWBundle.of("red_sandstone_bricks", Blocks.RED_SANDSTONE).register();
    public static final BSSWBundle SMALL_RED_SANDSTONE_BRICKS = BSSWBundle.of("small_red_sandstone_bricks", Blocks.RED_SANDSTONE).register();
    public static final Block RED_SANDSTONE_PILLAR = pillar("red_sandstone", Blocks.RED_SANDSTONE);
    public static final Block GOLD_DECORATED_RED_SANDSTONE = registerCopy("gold_decorated_red_sandstone", Blocks.RED_SANDSTONE);
    public static final Block LAPIS_DECORATED_RED_SANDSTONE = registerCopy("lapis_decorated_red_sandstone", Blocks.RED_SANDSTONE);

    // Soul Sandstone
    public static final BSSWBundle SOUL_SANDSTONE = BSSWBundle.of("soul_sandstone", Blocks.SANDSTONE, MapColor.BROWN).register();
    public static final BSSWBundle ROUGH_SOUL_SANDSTONE = BSSWBundle.of("rough_soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block()).includeWall(false).register();
    public static final BSSWBundle SOUL_SANDSTONE_BRICKS = BSSWBundle.of("soul_sandstone_bricks", SOUL_SANDSTONE.block()).register();
    public static final BSSWBundle SMALL_SOUL_SANDSTONE_BRICKS = BSSWBundle.of("small_soul_sandstone_bricks", SOUL_SANDSTONE.block()).register();
    public static final BSSWBundle SMOOTH_SOUL_SANDSTONE = BSSWBundle.of("smooth_soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block()).includeWall(false).register();
    public static final Block CUT_SOUL_SANDSTONE = registerCopy("cut_soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block());
    public static final Block CUT_SOUL_SANDSTONE_SLAB = slab(CUT_SOUL_SANDSTONE);
    public static final Block CHISELED_SOUL_SANDSTONE = registerCopy("chiseled_soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block());
    public static final Block SOUL_SANDSTONE_PILLAR = pillar("soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block());
    public static final Block GOLD_DECORATED_SOUL_SANDSTONE = registerCopy("gold_decorated_soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block());
    public static final Block LAPIS_DECORATED_SOUL_SANDSTONE = registerCopy("lapis_decorated_soul_sandstone", BlockusBlocks.SOUL_SANDSTONE.block());

    // Rainbow
    public static final Block RAINBOW_ROSE = registerOf("rainbow_rose", settings -> new FertilizableFlowerBlock(StatusEffects.GLOWING, 8, settings), create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ));
    public static final Block RAINBOW_PETALS = registerOf("rainbow_petals", FlowerbedBlock::new, create().mapColor(MapColor.DARK_GREEN).noCollision().sounds(BlockSoundGroup.FLOWERBED).pistonBehavior(PistonBehavior.DESTROY));

    public static final Block POTTED_RAINBOW_ROSE = pottedPlant("potted_rainbow_rose", RAINBOW_ROSE);
    public static final Block RAINBOW_BLOCK = registerOf("rainbow_block", FullFacingBlock::new, create().mapColor(MapColor.LIGHT_BLUE).strength(5.0f, 6.0f).requiresTool());
    public static final BSSWBundle RAINBOW_BRICKS = BSSWBundle.of("rainbow_bricks", Blocks.BRICKS).register();
    public static final Block RAINBOW_GLOWSTONE = registerCopy("rainbow_glowstone", Blocks.GLOWSTONE);

    // Honeycomb Bricks
    public static final BSSWBundle HONEYCOMB_BRICKS = BSSWBundle.of("honeycomb_bricks", Blocks.BRICKS).register();

    // Purpur Blocks
    public static final BSSWBundle PURPUR_BRICKS = BSSWBundle.of("purpur_bricks", Blocks.PURPUR_BLOCK).register();
    public static final BSSWBundle SMALL_PURPUR_BRICKS = BSSWBundle.of("small_purpur_bricks", Blocks.PURPUR_BLOCK).register();
    public static final BSSWBundle POLISHED_PURPUR = BSSWBundle.of("polished_purpur", Blocks.PURPUR_BLOCK).includeWall(false).register();
    public static final Block CHISELED_PURPUR = registerCopy("chiseled_purpur", BlockusBlocks.PURPUR_BRICKS.block());
    public static final Block PURPUR_SQUARES = registerCopy("purpur_squares", BlockusBlocks.PURPUR_BRICKS.block());
    public static final Block PURPUR_LINES = pillar2("purpur_lines", BlockusBlocks.PURPUR_BRICKS.block());

    // Phantom Purpur Blocks
    public static final BSSWBundle PHANTOM_PURPUR_BRICKS = BSSWBundle.of("phantom_purpur_bricks", Blocks.PURPUR_BLOCK).register();
    public static final BSSWBundle SMALL_PHANTOM_PURPUR_BRICKS = BSSWBundle.of("small_phantom_purpur_bricks", Blocks.PURPUR_BLOCK).register();
    public static final BSSWBundle PHANTOM_PURPUR_BLOCK = BSSWBundle.of("phantom_purpur_block", Blocks.PURPUR_BLOCK).includeWall(false).register();
    public static final BSSWBundle POLISHED_PHANTOM_PURPUR = BSSWBundle.of("polished_phantom_purpur", Blocks.PURPUR_BLOCK).includeWall(false).register();
    public static final Block PHANTOM_PURPUR_PILLAR = pillar("phantom_purpur", Blocks.PURPUR_PILLAR);
    public static final Block CHISELED_PHANTOM_PURPUR = registerCopy("chiseled_phantom_purpur", BlockusBlocks.PHANTOM_PURPUR_BRICKS.block());
    public static final Block PHANTOM_PURPUR_SQUARES = registerCopy("phantom_purpur_squares", BlockusBlocks.PHANTOM_PURPUR_BRICKS.block());
    public static final Block PHANTOM_PURPUR_LINES = pillar2("phantom_purpur_lines", BlockusBlocks.PHANTOM_PURPUR_BRICKS.block());

    // End Stone
    public static final BSSWBundle POLISHED_END_STONE = BSSWBundle.of("polished_end_stone", Blocks.END_STONE).includeWall(false).register();
    public static final BSSWBundle SMALL_END_STONE_BRICKS = BSSWBundle.of("small_end_stone_bricks", Blocks.END_STONE).register();
    public static final Block CHISELED_END_STONE_BRICKS = registerCopy("chiseled_end_stone_bricks", Blocks.END_STONE_BRICKS);
    public static final Block HERRINGBONE_END_STONE_BRICKS = registerCopy("herringbone_end_stone_bricks", Blocks.END_STONE_BRICKS);
    public static final Block CRACKED_END_STONE_BRICKS = registerCopy("cracked_end_stone_bricks", Blocks.END_STONE_BRICKS);
    public static final Block END_STONE_PILLAR = pillar("end_stone", Blocks.END_STONE_BRICKS);
    public static final Block PURPUR_DECORATED_END_STONE = registerCopy("purpur_decorated_end_stone", Blocks.END_STONE_BRICKS);
    public static final Block PHANTOM_PURPUR_DECORATED_END_STONE = registerCopy("phantom_purpur_decorated_end_stone", Blocks.END_STONE_BRICKS);
    public static final BSSWBundle END_TILES = BSSWBundle.of("end_tiles", Blocks.END_STONE_BRICKS).register();

    // White Oak Wood
    private static final WoodType WHITE_OAK_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(Blockus.id("white_oak"));
    public static final Block WHITE_OAK_SAPLING = registerCopy("white_oak_sapling", settings -> new SaplingBlock(BlockusSaplingGenerator.WHITE_OAK, settings), Blocks.OAK_SAPLING, settings -> settings.pistonBehavior(PistonBehavior.DESTROY));
    public static final Block POTTED_WHITE_OAK_SAPLING = pottedPlant("potted_white_oak_sapling", WHITE_OAK_SAPLING);
    public static final Block WHITE_OAK_LOG = registerCopy("white_oak_log", PillarBlock::new, Blocks.OAK_LOG, settings -> settings.mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block STRIPPED_WHITE_OAK_LOG = pillar2("stripped_white_oak_log", WHITE_OAK_LOG);
    public static final Block WHITE_OAK_WOOD = pillar2("white_oak_wood", WHITE_OAK_LOG);
    public static final Block STRIPPED_WHITE_OAK_WOOD = pillar2("stripped_white_oak_wood", WHITE_OAK_LOG);
    public static final Block WHITE_OAK_LEAVES = registerCopy("white_oak_leaves", settings -> new UntintedParticleLeavesBlock(0.01F, EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, 14061641), settings), Blocks.OAK_LEAVES, settings -> settings.mapColor(MapColor.ORANGE).pistonBehavior(PistonBehavior.DESTROY).allowsSpawning(BlockusBlocks::canSpawnOnLeaves).suffocates(BlockusBlocks::never).blockVision(BlockusBlocks::never));
    public static final WoodBundle WHITE_OAK = WoodBundle.of("white_oak", Blocks.OAK_PLANKS, MapColor.OFF_WHITE, BlockSoundGroup.WOOD, WHITE_OAK_WOOD_TYPE, BlockSetType.OAK, true).register();

    // Raw Bamboo
    private static final WoodType RAW_BAMBOO_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.BAMBOO).register(Blockus.id("raw_bamboo"), BlockSetTypeBuilder.copyOf(BlockSetType.BAMBOO).register(Blockus.id("raw_bamboo")));
    public static final WoodBundle RAW_BAMBOO = WoodBundle.of("raw_bamboo", Blocks.BAMBOO_PLANKS, MapColor.DARK_GREEN, BlockSoundGroup.BAMBOO_WOOD, RAW_BAMBOO_WOOD_TYPE, BlockSetType.BAMBOO, true).register();

    // Charred
    private static final WoodType CHARRED_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(Blockus.id("charred"));
    public static final WoodBundle CHARRED = WoodBundle.of("charred", Blocks.OAK_PLANKS, MapColor.TERRACOTTA_GRAY, BlockSoundGroup.WOOD, CHARRED_WOOD_TYPE, BlockSetType.OAK, false).register();

    // Mosaics
    public static final BSSWBundle OAK_MOSAIC = BSSWBundle.of("oak_mosaic", Blocks.OAK_PLANKS).includeWall(false).register();
    public static final BSSWBundle SPRUCE_MOSAIC = BSSWBundle.of("spruce_mosaic", Blocks.SPRUCE_PLANKS).includeWall(false).register();
    public static final BSSWBundle BIRCH_MOSAIC = BSSWBundle.of("birch_mosaic", Blocks.BIRCH_PLANKS).includeWall(false).register();
    public static final BSSWBundle JUNGLE_MOSAIC = BSSWBundle.of("jungle_mosaic", Blocks.JUNGLE_PLANKS).includeWall(false).register();
    public static final BSSWBundle ACACIA_MOSAIC = BSSWBundle.of("acacia_mosaic", Blocks.ACACIA_PLANKS).includeWall(false).register();
    public static final BSSWBundle DARK_OAK_MOSAIC = BSSWBundle.of("dark_oak_mosaic", Blocks.DARK_OAK_PLANKS).includeWall(false).register();
    public static final BSSWBundle MANGROVE_MOSAIC = BSSWBundle.of("mangrove_mosaic", Blocks.MANGROVE_PLANKS).includeWall(false).register();
    public static final BSSWBundle CHERRY_MOSAIC = BSSWBundle.of("cherry_mosaic", Blocks.CHERRY_PLANKS).includeWall(false).register();
    public static final BSSWBundle PALE_OAK_MOSAIC = BSSWBundle.of("pale_oak_mosaic", Blocks.PALE_OAK_PLANKS).includeWall(false).register();
    public static final BSSWBundle RAW_BAMBOO_MOSAIC = BSSWBundle.of("raw_bamboo_mosaic", RAW_BAMBOO.planks()).includeWall(false).register();
    public static final BSSWBundle WHITE_OAK_MOSAIC = BSSWBundle.of("white_oak_mosaic", WHITE_OAK.planks()).includeWall(false).register();
    public static final BSSWBundle CRIMSON_MOSAIC = BSSWBundle.of("crimson_mosaic", Blocks.CRIMSON_PLANKS).includeWall(false).register();
    public static final BSSWBundle WARPED_MOSAIC = BSSWBundle.of("warped_mosaic", Blocks.WARPED_PLANKS).includeWall(false).register();
    public static final BSSWBundle CHARRED_MOSAIC = BSSWBundle.of("charred_mosaic", CHARRED.planks()).includeWall(false).register();


    // Mossy Planks
    public static final BSSWBundle MOSSY_OAK_PLANKS = BSSWBundle.of("mossy_oak_planks", Blocks.OAK_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_SPRUCE_PLANKS = BSSWBundle.of("mossy_spruce_planks", Blocks.SPRUCE_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_BIRCH_PLANKS = BSSWBundle.of("mossy_birch_planks", Blocks.BIRCH_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_JUNGLE_PLANKS = BSSWBundle.of("mossy_jungle_planks", Blocks.JUNGLE_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_ACACIA_PLANKS = BSSWBundle.of("mossy_acacia_planks", Blocks.ACACIA_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_DARK_OAK_PLANKS = BSSWBundle.of("mossy_dark_oak_planks", Blocks.DARK_OAK_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_MANGROVE_PLANKS = BSSWBundle.of("mossy_mangrove_planks", Blocks.MANGROVE_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_CHERRY_PLANKS = BSSWBundle.of("mossy_cherry_planks", Blocks.CHERRY_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_PALE_OAK_PLANKS = BSSWBundle.of("mossy_pale_oak_planks", Blocks.PALE_OAK_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_BAMBOO_PLANKS = BSSWBundle.of("mossy_bamboo_planks", Blocks.BAMBOO_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_RAW_BAMBOO_PLANKS = BSSWBundle.of("mossy_raw_bamboo_planks", RAW_BAMBOO.planks()).includeWall(false).register();
    public static final BSSWBundle MOSSY_WHITE_OAK_PLANKS = BSSWBundle.of("mossy_white_oak_planks", WHITE_OAK.planks()).includeWall(false).register();
    public static final BSSWBundle MOSSY_CRIMSON_PLANKS = BSSWBundle.of("mossy_crimson_planks", Blocks.CRIMSON_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_WARPED_PLANKS = BSSWBundle.of("mossy_warped_planks", Blocks.WARPED_PLANKS).includeWall(false).register();
    public static final BSSWBundle MOSSY_CHARRED_PLANKS = BSSWBundle.of("mossy_charred_planks", CHARRED.planks()).includeWall(false).register();

    // Herringbone Planks
    public static final Block HERRINGBONE_OAK_PLANKS = registerCopy("herringbone_oak_planks", Blocks.OAK_PLANKS);
    public static final Block HERRINGBONE_SPRUCE_PLANKS = registerCopy("herringbone_spruce_planks", Blocks.SPRUCE_PLANKS);
    public static final Block HERRINGBONE_BIRCH_PLANKS = registerCopy("herringbone_birch_planks", Blocks.BIRCH_PLANKS);
    public static final Block HERRINGBONE_JUNGLE_PLANKS = registerCopy("herringbone_jungle_planks", Blocks.JUNGLE_PLANKS);
    public static final Block HERRINGBONE_ACACIA_PLANKS = registerCopy("herringbone_acacia_planks", Blocks.ACACIA_PLANKS);
    public static final Block HERRINGBONE_DARK_OAK_PLANKS = registerCopy("herringbone_dark_oak_planks", Blocks.DARK_OAK_PLANKS);
    public static final Block HERRINGBONE_MANGROVE_PLANKS = registerCopy("herringbone_mangrove_planks", Blocks.MANGROVE_PLANKS);
    public static final Block HERRINGBONE_CHERRY_PLANKS = registerCopy("herringbone_cherry_planks", Blocks.CHERRY_PLANKS);
    public static final Block HERRINGBONE_PALE_OAK_PLANKS = registerCopy("herringbone_pale_oak_planks", Blocks.PALE_OAK_PLANKS);
    public static final Block HERRINGBONE_BAMBOO_PLANKS = registerCopy("herringbone_bamboo_planks", Blocks.BAMBOO_PLANKS);
    public static final Block HERRINGBONE_RAW_BAMBOO_PLANKS = registerCopy("herringbone_raw_bamboo_planks", RAW_BAMBOO.planks());
    public static final Block HERRINGBONE_WHITE_OAK_PLANKS = registerCopy("herringbone_white_oak_planks", WHITE_OAK.planks());
    public static final Block HERRINGBONE_CRIMSON_PLANKS = registerCopy("herringbone_crimson_planks", Blocks.CRIMSON_PLANKS);
    public static final Block HERRINGBONE_WARPED_PLANKS = registerCopy("herringbone_warped_planks", Blocks.WARPED_PLANKS);
    public static final Block HERRINGBONE_CHARRED_PLANKS = registerCopy("herringbone_charred_planks", CHARRED.planks());

    // Small Logs
    public static final Block OAK_SMALL_LOGS = pillar2("oak_small_logs", Blocks.OAK_LOG);
    public static final Block SPRUCE_SMALL_LOGS = pillar2("spruce_small_logs", Blocks.SPRUCE_LOG);
    public static final Block BIRCH_SMALL_LOGS = pillar2("birch_small_logs", Blocks.BIRCH_LOG);
    public static final Block JUNGLE_SMALL_LOGS = pillar2("jungle_small_logs", Blocks.JUNGLE_LOG);
    public static final Block ACACIA_SMALL_LOGS = pillar2("acacia_small_logs", Blocks.ACACIA_LOG);
    public static final Block DARK_OAK_SMALL_LOGS = pillar2("dark_oak_small_logs", Blocks.DARK_OAK_LOG);
    public static final Block MANGROVE_SMALL_LOGS = pillar2("mangrove_small_logs", Blocks.MANGROVE_LOG);
    public static final Block CHERRY_SMALL_LOGS = pillar2("cherry_small_logs", Blocks.CHERRY_LOG);
    public static final Block PALE_OAK_SMALL_LOGS = pillar2("pale_oak_small_logs", Blocks.PALE_OAK_LOG);
    public static final Block WHITE_OAK_SMALL_LOGS = pillar2("white_oak_small_logs", WHITE_OAK_LOG);
    public static final Block CRIMSON_SMALL_STEMS = pillar2("crimson_small_stems", Blocks.CRIMSON_STEM);
    public static final Block WARPED_SMALL_STEMS = pillar2("warped_small_stems", Blocks.WARPED_STEM);

    // Posts
    public static final WoodenPostBundle OAK_POST = WoodenPostBundle.of("oak_post", Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).register();
    public static final WoodenPostBundle SPRUCE_POST = WoodenPostBundle.of("spruce_post", Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).register();
    public static final WoodenPostBundle BIRCH_POST = WoodenPostBundle.of("birch_post", Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).register();
    public static final WoodenPostBundle JUNGLE_POST = WoodenPostBundle.of("jungle_post", Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).register();
    public static final WoodenPostBundle ACACIA_POST = WoodenPostBundle.of("acacia_post", Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).register();
    public static final WoodenPostBundle DARK_OAK_POST = WoodenPostBundle.of("dark_oak_post", Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).register();
    public static final WoodenPostBundle MANGROVE_POST = WoodenPostBundle.of("mangrove_post", Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG).register();
    public static final WoodenPostBundle CHERRY_POST = WoodenPostBundle.of("cherry_post", Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG).register();
    public static final WoodenPostBundle PALE_OAK_POST = WoodenPostBundle.of("pale_oak_post", Blocks.PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG).register();
    public static final WoodenPostBundle WHITE_OAK_POST = WoodenPostBundle.of("white_oak_post", WHITE_OAK_LOG, STRIPPED_WHITE_OAK_LOG,false).register();
    public static final WoodenPostBundle CRIMSON_POST = WoodenPostBundle.of("crimson_post", Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, false).register();
    public static final WoodenPostBundle WARPED_POST = WoodenPostBundle.of("warped_post", Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, false).register();

    // Timber Frames & Grates
    public static final TimberFrameBundle OAK_TIMBER_FRAME = TimberFrameBundle.of(Blocks.OAK_PLANKS).register();
    public static final TimberFrameBundle BIRCH_TIMBER_FRAME = TimberFrameBundle.of(Blocks.BIRCH_PLANKS).register();
    public static final TimberFrameBundle SPRUCE_TIMBER_FRAME = TimberFrameBundle.of(Blocks.SPRUCE_PLANKS).register();
    public static final TimberFrameBundle JUNGLE_TIMBER_FRAME = TimberFrameBundle.of(Blocks.JUNGLE_PLANKS).register();
    public static final TimberFrameBundle ACACIA_TIMBER_FRAME = TimberFrameBundle.of(Blocks.ACACIA_PLANKS).register();
    public static final TimberFrameBundle DARK_OAK_TIMBER_FRAME = TimberFrameBundle.of(Blocks.DARK_OAK_PLANKS).register();
    public static final TimberFrameBundle MANGROVE_TIMBER_FRAME = TimberFrameBundle.of(Blocks.MANGROVE_PLANKS).register();
    public static final TimberFrameBundle CHERRY_TIMBER_FRAME = TimberFrameBundle.of(Blocks.CHERRY_PLANKS).register();
    public static final TimberFrameBundle PALE_OAK_TIMBER_FRAME = TimberFrameBundle.of(Blocks.PALE_OAK_PLANKS).register();
    public static final TimberFrameBundle BAMBOO_TIMBER_FRAME = TimberFrameBundle.of(Blocks.BAMBOO_PLANKS).register();
    public static final TimberFrameBundle RAW_BAMBOO_TIMBER_FRAME = TimberFrameBundle.of(BlockusBlocks.RAW_BAMBOO.planks()).register();
    public static final TimberFrameBundle WHITE_OAK_TIMBER_FRAME = TimberFrameBundle.of(BlockusBlocks.WHITE_OAK.planks()).register();
    public static final TimberFrameBundle CRIMSON_TIMBER_FRAME = TimberFrameBundle.of(Blocks.CRIMSON_PLANKS,false).register();
    public static final TimberFrameBundle WARPED_TIMBER_FRAME = TimberFrameBundle.of(Blocks.WARPED_PLANKS,false).register();
    public static final TimberFrameBundle CHARRED_TIMBER_FRAME = TimberFrameBundle.of(BlockusBlocks.CHARRED.planks(),false).register();
    public static final Block WOODEN_FRAME = woodenPane("wooden_frame");

    // Hedges
    public static final Block OAK_HEDGE = hedge("oak_hedge", Blocks.OAK_LEAVES);
    public static final Block SPRUCE_HEDGE = hedge("spruce_hedge", Blocks.SPRUCE_LEAVES);
    public static final Block BIRCH_HEDGE = hedge("birch_hedge", Blocks.BIRCH_LEAVES);
    public static final Block JUNGLE_HEDGE = hedge("jungle_hedge", Blocks.JUNGLE_LEAVES);
    public static final Block ACACIA_HEDGE = hedge("acacia_hedge", Blocks.ACACIA_LEAVES);
    public static final Block DARK_OAK_HEDGE = hedge("dark_oak_hedge", Blocks.DARK_OAK_LEAVES);
    public static final Block MANGROVE_HEDGE = hedge("mangrove_hedge", Blocks.MANGROVE_LEAVES);
    public static final Block CHERRY_HEDGE = hedge("cherry_hedge", Blocks.CHERRY_LEAVES);
    public static final Block PALE_OAK_HEDGE = hedge("pale_oak_hedge", Blocks.PALE_OAK_LEAVES);
    public static final Block WHITE_OAK_HEDGE = hedge("white_oak_hedge", WHITE_OAK_LEAVES);
    public static final Block AZALEA_HEDGE = hedge("azalea_hedge", Blocks.AZALEA_LEAVES);
    public static final Block FLOWERING_AZALEA_HEDGE = hedge("flowering_azalea_hedge", Blocks.FLOWERING_AZALEA_LEAVES);
    public static final Block MOSS_HEDGE = hedge("moss_hedge", Blocks.MOSS_BLOCK);
    public static final Block PALE_MOSS_HEDGE = hedge("pale_moss_hedge", Blocks.PALE_MOSS_BLOCK);
    public static final Block CRIMSON_HEDGE = hedge("crimson_hedge", Blocks.NETHER_WART_BLOCK);
    public static final Block WARPED_HEDGE = hedge("warped_hedge", Blocks.WARPED_WART_BLOCK);

    // Large Flower Pots
    public static final Block LARGE_FLOWER_POT = largeFlowerPot("large_flower_pot");
    public static final PottedLargeBundle POTTED_ROSE_BUSH = PottedLargeBundle.of("potted_rose_bush", Blocks.ROSE_BUSH).register();
    public static final PottedLargeBundle POTTED_LILAC = PottedLargeBundle.of("potted_lilac", Blocks.LILAC).register();
    public static final PottedLargeBundle POTTED_PEONY = PottedLargeBundle.of("potted_peony", Blocks.PEONY).register();
    public static final PottedLargeBundle POTTED_LARGE_FERN = PottedLargeBundle.of("potted_large_fern", Blocks.LARGE_FERN).register();
    public static final PottedLargeBundle POTTED_OAK = PottedLargeBundle.of("potted_oak", Blocks.OAK_SAPLING).register();
    public static final PottedLargeBundle POTTED_SPRUCE = PottedLargeBundle.of("potted_spruce", Blocks.SPRUCE_SAPLING).register();
    public static final PottedLargeBundle POTTED_BIRCH = PottedLargeBundle.of("potted_birch", Blocks.BIRCH_SAPLING).register();
    public static final PottedLargeBundle POTTED_JUNGLE = PottedLargeBundle.of("potted_jungle", Blocks.JUNGLE_SAPLING).register();
    public static final PottedLargeBundle POTTED_ACACIA = PottedLargeBundle.of("potted_acacia", Blocks.ACACIA_SAPLING).register();
    public static final PottedLargeBundle POTTED_DARK_OAK = PottedLargeBundle.of("potted_dark_oak", Blocks.DARK_OAK_SAPLING).register();
    public static final PottedLargeBundle POTTED_MANGROVE = PottedLargeBundle.of("potted_mangrove", Blocks.MANGROVE_PROPAGULE).register();
    public static final PottedLargeBundle POTTED_CHERRY_BLOSSOM = PottedLargeBundle.of("potted_cherry_blossom", Blocks.CHERRY_SAPLING).register();
    public static final PottedLargeBundle POTTED_PALE_OAK = PottedLargeBundle.of("potted_pale_oak", Blocks.PALE_OAK_SAPLING).register();
    public static final PottedLargeBundle POTTED_WHITE_OAK = PottedLargeBundle.of("potted_white_oak", WHITE_OAK_SAPLING).register();
    public static final PottedLargeBundle POTTED_HUGE_RED_MUSHROOM = PottedLargeBundle.of("potted_huge_red_mushroom", Blocks.RED_MUSHROOM).register();
    public static final PottedLargeBundle POTTED_HUGE_BROWN_MUSHROOM = PottedLargeBundle.of("potted_huge_brown_mushroom", Blocks.BROWN_MUSHROOM).register();
    public static final PottedLargeBundle POTTED_HUGE_CRIMSON_FUNGUS = PottedLargeBundle.of("potted_huge_crimson_fungus", Blocks.CRIMSON_FUNGUS).register();
    public static final PottedLargeBundle POTTED_HUGE_WARPED_FUNGUS = PottedLargeBundle.of("potted_huge_warped_fungus", Blocks.WARPED_FUNGUS).register();
    public static final PottedLargeBundle POTTED_CACTUS_LARGE = PottedLargeBundle.of("potted_cactus_large", Blocks.CACTUS).register();
    public static final PottedLargeBundle POTTED_BAMBOO_LARGE = PottedLargeBundle.of("potted_bamboo_large", Blocks.BAMBOO).register();
    public static final PottedLargeBundle POTTED_AZALEA_LARGE = PottedLargeBundle.of("potted_azalea_large", Blocks.AZALEA).register();
    public static final PottedLargeBundle POTTED_FLOWERING_AZALEA_LARGE = PottedLargeBundle.of("potted_flowering_azalea_large", Blocks.FLOWERING_AZALEA).register();
    public static final PottedLargeBundle POTTED_PITCHER_PLANT = PottedLargeBundle.of("potted_pitcher_plant", Blocks.PITCHER_PLANT).register();

    // Chocolate
    public static final BSSWBundle CHOCOLATE_BLOCK = BSSWBundle.of("chocolate_block", 1.0F, 1.0F, MapColor.BROWN).includeWall(false).register();
    public static final BSSWBundle CHOCOLATE_BRICKS = BSSWBundle.of("chocolate_bricks", BlockusBlocks.CHOCOLATE_BLOCK.block()).register();
    public static final Block CHOCOLATE_SQUARES = registerCopy("chocolate_squares", BlockusBlocks.CHOCOLATE_BRICKS.block());
    public static final Block CHOCOLATE_TABLET = registerCopy("chocolate_tablet", ChocolateTabletBlock::new, BlockusBlocks.CHOCOLATE_BLOCK.block(), settings -> settings.strength(0.2F, 1.0F));

    // Ore Bricks
    public static final BSSWBundle IRON_BRICKS = BSSWBundle.of("iron_bricks", Blocks.IRON_BLOCK).register();
    public static final BSSWBundle GOLD_BRICKS = BSSWBundle.of("gold_bricks", Blocks.GOLD_BLOCK).register();
    public static final BSSWBundle LAPIS_BRICKS = BSSWBundle.of("lapis_bricks", Blocks.LAPIS_BLOCK).register();
    public static final BSSWBundle REDSTONE_BRICKS = BSSWBundle.of("redstone_bricks", Blocks.REDSTONE_BLOCK).register();
    public static final BSSWBundle EMERALD_BRICKS = BSSWBundle.of("emerald_bricks", Blocks.EMERALD_BLOCK).register();
    public static final BSSWBundle DIAMOND_BRICKS = BSSWBundle.of("diamond_bricks", Blocks.DIAMOND_BLOCK).register();
    public static final BSSWBundle NETHERITE_BRICKS = BSSWBundle.of("netherite_bricks", Blocks.NETHERITE_BLOCK).register();

    // Copper
    public static final CopperBundle COPPER_BRICKS = CopperBundle.of("copper_bricks", OxidationType.UNAFFECTED, Blocks.COPPER_BLOCK).register();
    public static final CopperBundle EXPOSED_COPPER_BRICKS = CopperBundle.of("copper_bricks", OxidationType.EXPOSED, Blocks.EXPOSED_COPPER).register();
    public static final CopperBundle WEATHERED_COPPER_BRICKS = CopperBundle.of("copper_bricks", OxidationType.WEATHERED, Blocks.WEATHERED_COPPER).register();
    public static final CopperBundle OXIDIZED_COPPER_BRICKS = CopperBundle.of("copper_bricks", OxidationType.OXIDIZED, Blocks.OXIDIZED_COPPER).register();
    public static final CopperBundle COPPER_TUFF_BRICKS = CopperBundle.of("copper_tuff_bricks", OxidationType.UNAFFECTED, Blocks.TUFF_BRICKS).register();
    public static final CopperBundle EXPOSED_COPPER_TUFF_BRICKS = CopperBundle.of("copper_tuff_bricks", OxidationType.EXPOSED, Blocks.TUFF_BRICKS).register();
    public static final CopperBundle WEATHERED_COPPER_TUFF_BRICKS = CopperBundle.of("copper_tuff_bricks", OxidationType.WEATHERED, Blocks.TUFF_BRICKS).register();
    public static final CopperBundle OXIDIZED_COPPER_TUFF_BRICKS = CopperBundle.of("copper_tuff_bricks", OxidationType.OXIDIZED, Blocks.TUFF_BRICKS).register();

    // Food Blocks
    public static final Block SWEET_BERRIES_CRATE = crate("sweet_berries_crate");
    public static final Block GLOW_BERRIES_CRATE = crate("glow_berries_crate", 14);
    public static final Block SALMON_CRATE = crate("salmon_crate");
    public static final Block PUFFERFISH_CRATE = crate("pufferfish_crate");
    public static final Block TROPICAL_FISH_CRATE = crate("tropical_fish_crate");
    public static final Block COD_CRATE = crate("cod_crate");
    public static final Block COOKIE_BLOCK = registerOf("cookie_block", CookieBlock::new, create().mapColor(MapColor.ORANGE).strength(0.5F).sounds(BlockSoundGroup.GRASS));
    public static final Block CHORUS_BLOCK = registerOf("chorus_block", PillarBlock::new, create().mapColor(MapColor.PURPLE).strength(0.5f).sounds(BlockSoundGroup.GRASS));
    public static final Block POTATO_CRATE = crate("potato_crate");
    public static final Block APPLE_CRATE = crate("apple_crate");
    public static final Block GOLDEN_APPLE_CRATE = crate("golden_apple_crate");
    public static final Block BEETROOT_CRATE = crate("beetroot_crate");
    public static final Block CARROT_CRATE = crate("carrot_crate");
    public static final Block GOLDEN_CARROT_CRATE = crate("golden_carrot_crate");
    public static final Block BREAD_BOX = registerCopy("bread_box", OrientableBlockBase::new, Blocks.OAK_PLANKS, settings -> settings.strength(2.5f));

    // Stained Stone Bricks
    public static final BSSWBundle WHITE_STONE_BRICKS = BSSWBundle.of("white_stone_bricks", Blocks.STONE_BRICKS, MapColor.WHITE).register();
    public static final BSSWBundle GRAY_STONE_BRICKS = BSSWBundle.of("gray_stone_bricks", Blocks.STONE_BRICKS, MapColor.GRAY).register();
    public static final BSSWBundle BLACK_STONE_BRICKS = BSSWBundle.of("black_stone_bricks", Blocks.STONE_BRICKS, MapColor.BLACK).register();
    public static final BSSWBundle BROWN_STONE_BRICKS = BSSWBundle.of("brown_stone_bricks", Blocks.STONE_BRICKS, MapColor.BROWN).register();
    public static final BSSWBundle RED_STONE_BRICKS = BSSWBundle.of("red_stone_bricks", Blocks.STONE_BRICKS, MapColor.RED).register();
    public static final BSSWBundle ORANGE_STONE_BRICKS = BSSWBundle.of("orange_stone_bricks", Blocks.STONE_BRICKS, MapColor.ORANGE).register();
    public static final BSSWBundle YELLOW_STONE_BRICKS = BSSWBundle.of("yellow_stone_bricks", Blocks.STONE_BRICKS, MapColor.YELLOW).register();
    public static final BSSWBundle LIME_STONE_BRICKS = BSSWBundle.of("lime_stone_bricks", Blocks.STONE_BRICKS, MapColor.LIME).register();
    public static final BSSWBundle GREEN_STONE_BRICKS = BSSWBundle.of("green_stone_bricks", Blocks.STONE_BRICKS, MapColor.GREEN).register();
    public static final BSSWBundle CYAN_STONE_BRICKS = BSSWBundle.of("cyan_stone_bricks", Blocks.STONE_BRICKS, MapColor.CYAN).register();
    public static final BSSWBundle LIGHT_BLUE_STONE_BRICKS = BSSWBundle.of("light_blue_stone_bricks", Blocks.STONE_BRICKS, MapColor.LIGHT_BLUE).register();
    public static final BSSWBundle BLUE_STONE_BRICKS = BSSWBundle.of("blue_stone_bricks", Blocks.STONE_BRICKS, MapColor.BLUE).register();
    public static final BSSWBundle PURPLE_STONE_BRICKS = BSSWBundle.of("purple_stone_bricks", Blocks.STONE_BRICKS, MapColor.PURPLE).register();
    public static final BSSWBundle MAGENTA_STONE_BRICKS = BSSWBundle.of("magenta_stone_bricks", Blocks.STONE_BRICKS, MapColor.MAGENTA).register();
    public static final BSSWBundle PINK_STONE_BRICKS = BSSWBundle.of("pink_stone_bricks", Blocks.STONE_BRICKS, MapColor.PINK).register();

    // Concrete
    public static final ConcreteBundle WHITE_CONCRETE_BRICKS = ConcreteBundle.of("white_concrete_bricks", Blocks.WHITE_CONCRETE).register();
    public static final ConcreteBundle LIGHT_GRAY_CONCRETE_BRICKS = ConcreteBundle.of("light_gray_concrete_bricks", Blocks.LIGHT_GRAY_CONCRETE).register();
    public static final ConcreteBundle GRAY_CONCRETE_BRICKS = ConcreteBundle.of("gray_concrete_bricks", Blocks.GRAY_CONCRETE).register();
    public static final ConcreteBundle BLACK_CONCRETE_BRICKS = ConcreteBundle.of("black_concrete_bricks", Blocks.BLACK_CONCRETE).register();
    public static final ConcreteBundle BROWN_CONCRETE_BRICKS = ConcreteBundle.of("brown_concrete_bricks", Blocks.BROWN_CONCRETE).register();
    public static final ConcreteBundle RED_CONCRETE_BRICKS = ConcreteBundle.of("red_concrete_bricks", Blocks.RED_CONCRETE).register();
    public static final ConcreteBundle ORANGE_CONCRETE_BRICKS = ConcreteBundle.of("orange_concrete_bricks", Blocks.ORANGE_CONCRETE).register();
    public static final ConcreteBundle YELLOW_CONCRETE_BRICKS = ConcreteBundle.of("yellow_concrete_bricks", Blocks.YELLOW_CONCRETE).register();
    public static final ConcreteBundle LIME_CONCRETE_BRICKS = ConcreteBundle.of("lime_concrete_bricks", Blocks.LIME_CONCRETE).register();
    public static final ConcreteBundle GREEN_CONCRETE_BRICKS = ConcreteBundle.of("green_concrete_bricks", Blocks.GREEN_CONCRETE).register();
    public static final ConcreteBundle CYAN_CONCRETE_BRICKS = ConcreteBundle.of("cyan_concrete_bricks", Blocks.CYAN_CONCRETE).register();
    public static final ConcreteBundle LIGHT_BLUE_CONCRETE_BRICKS = ConcreteBundle.of("light_blue_concrete_bricks", Blocks.LIGHT_BLUE_CONCRETE).register();
    public static final ConcreteBundle BLUE_CONCRETE_BRICKS = ConcreteBundle.of("blue_concrete_bricks", Blocks.BLUE_CONCRETE).register();
    public static final ConcreteBundle PURPLE_CONCRETE_BRICKS = ConcreteBundle.of("purple_concrete_bricks", Blocks.PURPLE_CONCRETE).register();
    public static final ConcreteBundle MAGENTA_CONCRETE_BRICKS = ConcreteBundle.of("magenta_concrete_bricks", Blocks.MAGENTA_CONCRETE).register();
    public static final ConcreteBundle PINK_CONCRETE_BRICKS = ConcreteBundle.of("pink_concrete_bricks", Blocks.PINK_CONCRETE).register();

    // Redstone Lamps
    public static final Block WHITE_REDSTONE_LAMP = redstoneLamp("white_redstone_lamp", MapColor.WHITE);
    public static final Block ORANGE_REDSTONE_LAMP = redstoneLamp("orange_redstone_lamp", MapColor.ORANGE);
    public static final Block MAGENTA_REDSTONE_LAMP = redstoneLamp("magenta_redstone_lamp", MapColor.MAGENTA);
    public static final Block LIGHT_BLUE_REDSTONE_LAMP = redstoneLamp("light_blue_redstone_lamp", MapColor.LIGHT_BLUE);
    public static final Block YELLOW_REDSTONE_LAMP = redstoneLamp("yellow_redstone_lamp", MapColor.YELLOW);
    public static final Block LIME_REDSTONE_LAMP = redstoneLamp("lime_redstone_lamp", MapColor.LIME);
    public static final Block PINK_REDSTONE_LAMP = redstoneLamp("pink_redstone_lamp", MapColor.PINK);
    public static final Block GRAY_REDSTONE_LAMP = redstoneLamp("gray_redstone_lamp", MapColor.GRAY);
    public static final Block LIGHT_GRAY_REDSTONE_LAMP = redstoneLamp("light_gray_redstone_lamp", MapColor.LIGHT_GRAY);
    public static final Block CYAN_REDSTONE_LAMP = redstoneLamp("cyan_redstone_lamp", MapColor.CYAN);
    public static final Block PURPLE_REDSTONE_LAMP = redstoneLamp("purple_redstone_lamp", MapColor.PURPLE);
    public static final Block BLUE_REDSTONE_LAMP = redstoneLamp("blue_redstone_lamp", MapColor.BLUE);
    public static final Block BROWN_REDSTONE_LAMP = redstoneLamp("brown_redstone_lamp", MapColor.BROWN);
    public static final Block GREEN_REDSTONE_LAMP = redstoneLamp("green_redstone_lamp", MapColor.GREEN);
    public static final Block RED_REDSTONE_LAMP = redstoneLamp("red_redstone_lamp", MapColor.RED);
    public static final Block REDSTONE_LAMP_LIT = litRedstoneLamp("redstone_lamp_lit", Blocks.REDSTONE_LAMP);
    public static final Block WHITE_REDSTONE_LAMP_LIT = litRedstoneLamp("white_redstone_lamp_lit", WHITE_REDSTONE_LAMP);
    public static final Block ORANGE_REDSTONE_LAMP_LIT = litRedstoneLamp("orange_redstone_lamp_lit", ORANGE_REDSTONE_LAMP);
    public static final Block MAGENTA_REDSTONE_LAMP_LIT = litRedstoneLamp("magenta_redstone_lamp_lit", MAGENTA_REDSTONE_LAMP);
    public static final Block LIGHT_BLUE_REDSTONE_LAMP_LIT = litRedstoneLamp("light_blue_redstone_lamp_lit", LIGHT_BLUE_REDSTONE_LAMP);
    public static final Block YELLOW_REDSTONE_LAMP_LIT = litRedstoneLamp("yellow_redstone_lamp_lit", YELLOW_REDSTONE_LAMP);
    public static final Block LIME_REDSTONE_LAMP_LIT = litRedstoneLamp("lime_redstone_lamp_lit", LIME_REDSTONE_LAMP);
    public static final Block PINK_REDSTONE_LAMP_LIT = litRedstoneLamp("pink_redstone_lamp_lit", PINK_REDSTONE_LAMP);
    public static final Block GRAY_REDSTONE_LAMP_LIT = litRedstoneLamp("gray_redstone_lamp_lit", GRAY_REDSTONE_LAMP);
    public static final Block LIGHT_GRAY_REDSTONE_LAMP_LIT = litRedstoneLamp("light_gray_redstone_lamp_lit", LIGHT_GRAY_REDSTONE_LAMP);
    public static final Block CYAN_REDSTONE_LAMP_LIT = litRedstoneLamp("cyan_redstone_lamp_lit", CYAN_REDSTONE_LAMP);
    public static final Block PURPLE_REDSTONE_LAMP_LIT = litRedstoneLamp("purple_redstone_lamp_lit", PURPLE_REDSTONE_LAMP);
    public static final Block BLUE_REDSTONE_LAMP_LIT = litRedstoneLamp("blue_redstone_lamp_lit", BLUE_REDSTONE_LAMP);
    public static final Block BROWN_REDSTONE_LAMP_LIT = litRedstoneLamp("brown_redstone_lamp_lit", BROWN_REDSTONE_LAMP);
    public static final Block GREEN_REDSTONE_LAMP_LIT = litRedstoneLamp("green_redstone_lamp_lit", GREEN_REDSTONE_LAMP);
    public static final Block RED_REDSTONE_LAMP_LIT = litRedstoneLamp("red_redstone_lamp_lit", RED_REDSTONE_LAMP);
    public static final Block RAINBOW_LAMP = redstoneLamp("rainbow_lamp", MapColor.TERRACOTTA_ORANGE);
    public static final Block RAINBOW_LAMP_LIT = litRedstoneLamp("rainbow_lamp_lit", RAINBOW_LAMP);

    // Neon Blocks
    public static final Block WHITE_NEON = neonBlock("white_neon", DyeColor.WHITE);
    public static final Block LIGHT_GRAY_NEON = neonBlock("light_gray_neon", DyeColor.LIGHT_GRAY);
    public static final Block GRAY_NEON = neonBlock("gray_neon", DyeColor.GRAY);
    public static final Block BLACK_NEON = neonBlock("black_neon", DyeColor.BLACK);
    public static final Block BROWN_NEON = neonBlock("brown_neon", DyeColor.BROWN);
    public static final Block RED_NEON = neonBlock("red_neon", DyeColor.RED);
    public static final Block ORANGE_NEON = neonBlock("orange_neon", DyeColor.ORANGE);
    public static final Block YELLOW_NEON = neonBlock("yellow_neon", DyeColor.YELLOW);
    public static final Block LIME_NEON = neonBlock("lime_neon", DyeColor.LIME);
    public static final Block GREEN_NEON = neonBlock("green_neon", DyeColor.GREEN);
    public static final Block CYAN_NEON = neonBlock("cyan_neon", DyeColor.CYAN);
    public static final Block LIGHT_BLUE_NEON = neonBlock("light_blue_neon", DyeColor.LIGHT_BLUE);
    public static final Block BLUE_NEON = neonBlock("blue_neon", DyeColor.BLUE);
    public static final Block PURPLE_NEON = neonBlock("purple_neon", DyeColor.PURPLE);
    public static final Block MAGENTA_NEON = neonBlock("magenta_neon", DyeColor.MAGENTA);
    public static final Block PINK_NEON = neonBlock("pink_neon", DyeColor.PINK);
    public static final Block RAINBOW_NEON = neonBlock("rainbow_neon", DyeColor.LIGHT_BLUE);

    // Futurneo Blocks
    public static final Block WHITE_FUTURNEO_BLOCK = futurneoBlock("white_futurneo_block", MapColor.BLACK);
    public static final Block LIGHT_GRAY_FUTURNEO_BLOCK = futurneoBlock("light_gray_futurneo_block", MapColor.BLACK);
    public static final Block GRAY_FUTURNEO_BLOCK = futurneoBlock("gray_futurneo_block", MapColor.BLACK);
    public static final Block BLACK_FUTURNEO_BLOCK = futurneoBlock("black_futurneo_block", MapColor.BLACK);
    public static final Block BROWN_FUTURNEO_BLOCK = futurneoBlock("brown_futurneo_block", MapColor.BLACK);
    public static final Block RED_FUTURNEO_BLOCK = futurneoBlock("red_futurneo_block", MapColor.BLACK);
    public static final Block ORANGE_FUTURNEO_BLOCK = futurneoBlock("orange_futurneo_block", MapColor.BLACK);
    public static final Block YELLOW_FUTURNEO_BLOCK = futurneoBlock("yellow_futurneo_block", MapColor.BLACK);
    public static final Block LIME_FUTURNEO_BLOCK = futurneoBlock("lime_futurneo_block", MapColor.BLACK);
    public static final Block GREEN_FUTURNEO_BLOCK = futurneoBlock("green_futurneo_block", MapColor.BLACK);
    public static final Block CYAN_FUTURNEO_BLOCK = futurneoBlock("cyan_futurneo_block", MapColor.BLACK);
    public static final Block LIGHT_BLUE_FUTURNEO_BLOCK = futurneoBlock("light_blue_futurneo_block", MapColor.BLACK);
    public static final Block BLUE_FUTURNEO_BLOCK = futurneoBlock("blue_futurneo_block", MapColor.BLACK);
    public static final Block PURPLE_FUTURNEO_BLOCK = futurneoBlock("purple_futurneo_block", MapColor.BLACK);
    public static final Block MAGENTA_FUTURNEO_BLOCK = futurneoBlock("magenta_futurneo_block", MapColor.BLACK);
    public static final Block PINK_FUTURNEO_BLOCK = futurneoBlock("pink_futurneo_block", MapColor.BLACK);
    public static final Block GRAY_BRIGHT_FUTURNEO_BLOCK = futurneoBlock("gray_bright_futurneo_block", MapColor.WHITE);
    public static final Block RAINBOW_FUTURNEO_BLOCK = futurneoBlock("rainbow_futurneo_block", MapColor.BLACK);

    // Asphalt
    public static final AsphaltBundle ASPHALT = AsphaltBundle.of(DyeColor.BLACK).register();
    public static final AsphaltBundle WHITE_ASPHALT = AsphaltBundle.of(DyeColor.WHITE).register();
    public static final AsphaltBundle LIGHT_GRAY_ASPHALT = AsphaltBundle.of(DyeColor.LIGHT_GRAY).register();
    public static final AsphaltBundle GRAY_ASPHALT = AsphaltBundle.of(DyeColor.GRAY).register();
    public static final AsphaltBundle BROWN_ASPHALT = AsphaltBundle.of(DyeColor.BROWN).register();
    public static final AsphaltBundle RED_ASPHALT = AsphaltBundle.of(DyeColor.RED).register();
    public static final AsphaltBundle ORANGE_ASPHALT = AsphaltBundle.of(DyeColor.ORANGE).register();
    public static final AsphaltBundle YELLOW_ASPHALT = AsphaltBundle.of(DyeColor.YELLOW).register();
    public static final AsphaltBundle LIME_ASPHALT = AsphaltBundle.of(DyeColor.LIME).register();
    public static final AsphaltBundle GREEN_ASPHALT = AsphaltBundle.of(DyeColor.GREEN).register();
    public static final AsphaltBundle CYAN_ASPHALT = AsphaltBundle.of(DyeColor.CYAN).register();
    public static final AsphaltBundle LIGHT_BLUE_ASPHALT = AsphaltBundle.of(DyeColor.LIGHT_BLUE).register();
    public static final AsphaltBundle BLUE_ASPHALT = AsphaltBundle.of(DyeColor.BLUE).register();
    public static final AsphaltBundle PURPLE_ASPHALT = AsphaltBundle.of(DyeColor.PURPLE).register();
    public static final AsphaltBundle MAGENTA_ASPHALT = AsphaltBundle.of(DyeColor.MAGENTA).register();
    public static final AsphaltBundle PINK_ASPHALT = AsphaltBundle.of(DyeColor.PINK).register();
    public static final Block RAINBOW_ASPHALT = registerOf("rainbow_asphalt", RainbowAsphalt::new, create().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(1.5f, 6.0f).requiresTool());

    // Shingles
    public static final BSSWBundle SHINGLES = BSSWBundle.of("shingles", Blocks.TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle WHITE_SHINGLES = BSSWBundle.of("white_shingles", Blocks.WHITE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle LIGHT_GRAY_SHINGLES = BSSWBundle.of("light_gray_shingles", Blocks.LIGHT_GRAY_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle GRAY_SHINGLES = BSSWBundle.of("gray_shingles", Blocks.GRAY_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle BLACK_SHINGLES = BSSWBundle.of("black_shingles", Blocks.BLACK_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle BROWN_SHINGLES = BSSWBundle.of("brown_shingles", Blocks.BROWN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle RED_SHINGLES = BSSWBundle.of("red_shingles", Blocks.RED_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle ORANGE_SHINGLES = BSSWBundle.of("orange_shingles", Blocks.ORANGE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle YELLOW_SHINGLES = BSSWBundle.of("yellow_shingles", Blocks.YELLOW_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle LIME_SHINGLES = BSSWBundle.of("lime_shingles", Blocks.LIME_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle GREEN_SHINGLES = BSSWBundle.of("green_shingles", Blocks.GREEN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle CYAN_SHINGLES = BSSWBundle.of("cyan_shingles", Blocks.CYAN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle LIGHT_BLUE_SHINGLES = BSSWBundle.of("light_blue_shingles", Blocks.LIGHT_BLUE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle BLUE_SHINGLES = BSSWBundle.of("blue_shingles", Blocks.BLUE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle PURPLE_SHINGLES = BSSWBundle.of("purple_shingles", Blocks.PURPLE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle MAGENTA_SHINGLES = BSSWBundle.of("magenta_shingles", Blocks.MAGENTA_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();
    public static final BSSWBundle PINK_SHINGLES = BSSWBundle.of("pink_shingles", Blocks.PINK_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS).includeWall(false).register();

    // Glass - Beveled Glass
    public static final Block RAINBOW_GLASS = stainedGlass("rainbow_glass", DyeColor.YELLOW, Blocks.GLASS);
    public static final Block RAINBOW_GLASS_PANE = stainedGlassPane("rainbow_glass_pane", DyeColor.YELLOW, Blocks.GLASS_PANE);
    public static final Block BEVELED_GLASS = registerCopy("beveled_glass", TransparentBlock::new, Blocks.GLASS);
    public static final Block WHITE_BEVELED_GLASS = stainedGlass("white_beveled_glass", DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS);
    public static final Block ORANGE_BEVELED_GLASS = stainedGlass("orange_beveled_glass", DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS);
    public static final Block MAGENTA_BEVELED_GLASS = stainedGlass("magenta_beveled_glass", DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS);
    public static final Block LIGHT_BLUE_BEVELED_GLASS = stainedGlass("light_blue_beveled_glass", DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS);
    public static final Block YELLOW_BEVELED_GLASS = stainedGlass("yellow_beveled_glass", DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS);
    public static final Block LIME_BEVELED_GLASS = stainedGlass("lime_beveled_glass", DyeColor.LIME, Blocks.LIME_STAINED_GLASS);
    public static final Block PINK_BEVELED_GLASS = stainedGlass("pink_beveled_glass", DyeColor.PINK, Blocks.PINK_STAINED_GLASS);
    public static final Block LIGHT_GRAY_BEVELED_GLASS = stainedGlass("light_gray_beveled_glass", DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS);
    public static final Block GRAY_BEVELED_GLASS = stainedGlass("gray_beveled_glass", DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS);
    public static final Block CYAN_BEVELED_GLASS = stainedGlass("cyan_beveled_glass", DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS);
    public static final Block PURPLE_BEVELED_GLASS = stainedGlass("purple_beveled_glass", DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS);
    public static final Block BLUE_BEVELED_GLASS = stainedGlass("blue_beveled_glass", DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS);
    public static final Block BROWN_BEVELED_GLASS = stainedGlass("brown_beveled_glass", DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS);
    public static final Block GREEN_BEVELED_GLASS = stainedGlass("green_beveled_glass", DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS);
    public static final Block RED_BEVELED_GLASS = stainedGlass("red_beveled_glass", DyeColor.RED, Blocks.RED_STAINED_GLASS);
    public static final Block BLACK_BEVELED_GLASS = stainedGlass("black_beveled_glass", DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS);
    public static final Block RAINBOW_BEVELED_GLASS = stainedGlass("rainbow_beveled_glass", DyeColor.YELLOW, RAINBOW_GLASS);
    public static final Block BEVELED_GLASS_PANE = registerCopy("beveled_glass_pane", PaneBlock::new, Blocks.GLASS_PANE);
    public static final Block WHITE_BEVELED_GLASS_PANE = stainedGlassPane("white_beveled_glass_pane", DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS_PANE);
    public static final Block ORANGE_BEVELED_GLASS_PANE = stainedGlassPane("orange_beveled_glass_pane", DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS_PANE);
    public static final Block MAGENTA_BEVELED_GLASS_PANE = stainedGlassPane("magenta_beveled_glass_pane", DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS_PANE);
    public static final Block LIGHT_BLUE_BEVELED_GLASS_PANE = stainedGlassPane("light_blue_beveled_glass_pane", DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final Block YELLOW_BEVELED_GLASS_PANE = stainedGlassPane("yellow_beveled_glass_pane", DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS_PANE);
    public static final Block LIME_BEVELED_GLASS_PANE = stainedGlassPane("lime_beveled_glass_pane", DyeColor.LIME, Blocks.LIME_STAINED_GLASS_PANE);
    public static final Block PINK_BEVELED_GLASS_PANE = stainedGlassPane("pink_beveled_glass_pane", DyeColor.PINK, Blocks.PINK_STAINED_GLASS_PANE);
    public static final Block LIGHT_GRAY_BEVELED_GLASS_PANE = stainedGlassPane("light_gray_beveled_glass_pane", DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final Block GRAY_BEVELED_GLASS_PANE = stainedGlassPane("gray_beveled_glass_pane", DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS_PANE);
    public static final Block CYAN_BEVELED_GLASS_PANE = stainedGlassPane("cyan_beveled_glass_pane", DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS_PANE);
    public static final Block PURPLE_BEVELED_GLASS_PANE = stainedGlassPane("purple_beveled_glass_pane", DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS_PANE);
    public static final Block BLUE_BEVELED_GLASS_PANE = stainedGlassPane("blue_beveled_glass_pane", DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS_PANE);
    public static final Block BROWN_BEVELED_GLASS_PANE = stainedGlassPane("brown_beveled_glass_pane", DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS_PANE);
    public static final Block GREEN_BEVELED_GLASS_PANE = stainedGlassPane("green_beveled_glass_pane", DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS_PANE);
    public static final Block RED_BEVELED_GLASS_PANE = stainedGlassPane("red_beveled_glass_pane", DyeColor.RED, Blocks.RED_STAINED_GLASS_PANE);
    public static final Block BLACK_BEVELED_GLASS_PANE = stainedGlassPane("black_beveled_glass_pane", DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS_PANE);
    public static final Block RAINBOW_BEVELED_GLASS_PANE = stainedGlassPane("rainbow_beveled_glass_pane", DyeColor.YELLOW, RAINBOW_GLASS_PANE);
    public static final Block TINTED_BEVELED_GLASS = registerCopy("tinted_beveled_glass", TintedGlassBlock::new, Blocks.TINTED_GLASS, settings -> settings.allowsSpawning(BlockusBlocks::never).solidBlock(BlockusBlocks::never).suffocates(BlockusBlocks::never).blockVision(BlockusBlocks::never));

    // Patterned Wools
    public static final WoolBundle WHITE_PATTERNED_WOOL = WoolBundle.of(Blocks.WHITE_WOOL, Blocks.WHITE_CARPET, DyeColor.WHITE).register();
    public static final WoolBundle LIGHT_GRAY_PATTERNED_WOOL = WoolBundle.of(Blocks.LIGHT_GRAY_WOOL, Blocks.LIGHT_GRAY_CARPET, DyeColor.LIGHT_GRAY).register();
    public static final WoolBundle GRAY_PATTERNED_WOOL = WoolBundle.of(Blocks.GRAY_WOOL, Blocks.GRAY_CARPET, DyeColor.GRAY).register();
    public static final WoolBundle BLACK_PATTERNED_WOOL = WoolBundle.of(Blocks.BLACK_WOOL, Blocks.BLACK_CARPET, DyeColor.BLACK).register();
    public static final WoolBundle BROWN_PATTERNED_WOOL = WoolBundle.of(Blocks.BROWN_WOOL, Blocks.BROWN_CARPET, DyeColor.BROWN).register();
    public static final WoolBundle RED_PATTERNED_WOOL = WoolBundle.of(Blocks.RED_WOOL, Blocks.RED_CARPET, DyeColor.RED).register();
    public static final WoolBundle ORANGE_PATTERNED_WOOL = WoolBundle.of(Blocks.ORANGE_WOOL, Blocks.ORANGE_CARPET, DyeColor.ORANGE).register();
    public static final WoolBundle YELLOW_PATTERNED_WOOL = WoolBundle.of(Blocks.YELLOW_WOOL, Blocks.YELLOW_CARPET, DyeColor.YELLOW).register();
    public static final WoolBundle LIME_PATTERNED_WOOL = WoolBundle.of(Blocks.LIME_WOOL, Blocks.LIME_CARPET, DyeColor.LIME).register();
    public static final WoolBundle GREEN_PATTERNED_WOOL = WoolBundle.of(Blocks.GREEN_WOOL, Blocks.GREEN_CARPET, DyeColor.GREEN).register();
    public static final WoolBundle CYAN_PATTERNED_WOOL = WoolBundle.of(Blocks.CYAN_WOOL, Blocks.CYAN_CARPET, DyeColor.CYAN).register();
    public static final WoolBundle LIGHT_BLUE_PATTERNED_WOOL = WoolBundle.of(Blocks.LIGHT_BLUE_WOOL, Blocks.LIGHT_BLUE_CARPET, DyeColor.LIGHT_BLUE).register();
    public static final WoolBundle BLUE_PATTERNED_WOOL = WoolBundle.of(Blocks.BLUE_WOOL, Blocks.BLUE_CARPET, DyeColor.BLUE).register();
    public static final WoolBundle PURPLE_PATTERNED_WOOL = WoolBundle.of(Blocks.PURPLE_WOOL, Blocks.PURPLE_CARPET, DyeColor.PURPLE).register();
    public static final WoolBundle MAGENTA_PATTERNED_WOOL = WoolBundle.of(Blocks.MAGENTA_WOOL, Blocks.MAGENTA_CARPET, DyeColor.MAGENTA).register();
    public static final WoolBundle PINK_PATTERNED_WOOL = WoolBundle.of(Blocks.PINK_WOOL, Blocks.PINK_CARPET, DyeColor.PINK).register();

    // Gingham Wools
    public static final WoolBundle WHITE_GINGHAM_WOOL = WoolBundle.of(Blocks.WHITE_WOOL, Blocks.WHITE_CARPET, DyeColor.WHITE, WoolBundle.GINGHAM).register();
    public static final WoolBundle LIGHT_GRAY_GINGHAM_WOOL = WoolBundle.of(Blocks.LIGHT_GRAY_WOOL, Blocks.LIGHT_GRAY_CARPET, DyeColor.LIGHT_GRAY, WoolBundle.GINGHAM).register();
    public static final WoolBundle GRAY_GINGHAM_WOOL = WoolBundle.of(Blocks.GRAY_WOOL, Blocks.GRAY_CARPET, DyeColor.GRAY, WoolBundle.GINGHAM).register();
    public static final WoolBundle BLACK_GINGHAM_WOOL = WoolBundle.of(Blocks.BLACK_WOOL, Blocks.BLACK_CARPET, DyeColor.BLACK, WoolBundle.GINGHAM).register();
    public static final WoolBundle BROWN_GINGHAM_WOOL = WoolBundle.of(Blocks.BROWN_WOOL, Blocks.BROWN_CARPET, DyeColor.BROWN, WoolBundle.GINGHAM).register();
    public static final WoolBundle RED_GINGHAM_WOOL = WoolBundle.of(Blocks.RED_WOOL, Blocks.RED_CARPET, DyeColor.RED, WoolBundle.GINGHAM).register();
    public static final WoolBundle ORANGE_GINGHAM_WOOL = WoolBundle.of(Blocks.ORANGE_WOOL, Blocks.ORANGE_CARPET, DyeColor.ORANGE, WoolBundle.GINGHAM).register();
    public static final WoolBundle YELLOW_GINGHAM_WOOL = WoolBundle.of(Blocks.YELLOW_WOOL, Blocks.YELLOW_CARPET, DyeColor.YELLOW, WoolBundle.GINGHAM).register();
    public static final WoolBundle LIME_GINGHAM_WOOL = WoolBundle.of(Blocks.LIME_WOOL, Blocks.LIME_CARPET, DyeColor.LIME, WoolBundle.GINGHAM).register();
    public static final WoolBundle GREEN_GINGHAM_WOOL = WoolBundle.of(Blocks.GREEN_WOOL, Blocks.GREEN_CARPET, DyeColor.GREEN, WoolBundle.GINGHAM).register();
    public static final WoolBundle CYAN_GINGHAM_WOOL = WoolBundle.of(Blocks.CYAN_WOOL, Blocks.CYAN_CARPET, DyeColor.CYAN, WoolBundle.GINGHAM).register();
    public static final WoolBundle LIGHT_BLUE_GINGHAM_WOOL = WoolBundle.of(Blocks.LIGHT_BLUE_WOOL, Blocks.LIGHT_BLUE_CARPET, DyeColor.LIGHT_BLUE, WoolBundle.GINGHAM).register();
    public static final WoolBundle BLUE_GINGHAM_WOOL = WoolBundle.of(Blocks.BLUE_WOOL, Blocks.BLUE_CARPET, DyeColor.BLUE, WoolBundle.GINGHAM).register();
    public static final WoolBundle PURPLE_GINGHAM_WOOL = WoolBundle.of(Blocks.PURPLE_WOOL, Blocks.PURPLE_CARPET, DyeColor.PURPLE, WoolBundle.GINGHAM).register();
    public static final WoolBundle MAGENTA_GINGHAM_WOOL = WoolBundle.of(Blocks.MAGENTA_WOOL, Blocks.MAGENTA_CARPET, DyeColor.MAGENTA, WoolBundle.GINGHAM).register();
    public static final WoolBundle PINK_GINGHAM_WOOL = WoolBundle.of(Blocks.PINK_WOOL, Blocks.PINK_CARPET, DyeColor.PINK, WoolBundle.GINGHAM).register();

    // Glazed Terracotta Pillars
    public static final Block WHITE_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.WHITE_GLAZED_TERRACOTTA);
    public static final Block LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
    public static final Block GRAY_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.GRAY_GLAZED_TERRACOTTA);
    public static final Block BLACK_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.BLACK_GLAZED_TERRACOTTA);
    public static final Block BROWN_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.BROWN_GLAZED_TERRACOTTA);
    public static final Block RED_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.RED_GLAZED_TERRACOTTA);
    public static final Block ORANGE_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.ORANGE_GLAZED_TERRACOTTA);
    public static final Block YELLOW_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.YELLOW_GLAZED_TERRACOTTA);
    public static final Block LIME_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.LIME_GLAZED_TERRACOTTA);
    public static final Block GREEN_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.GREEN_GLAZED_TERRACOTTA);
    public static final Block CYAN_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.CYAN_GLAZED_TERRACOTTA);
    public static final Block LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
    public static final Block BLUE_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.BLUE_GLAZED_TERRACOTTA);
    public static final Block PURPLE_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.PURPLE_GLAZED_TERRACOTTA);
    public static final Block MAGENTA_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.MAGENTA_GLAZED_TERRACOTTA);
    public static final Block PINK_GLAZED_TERRACOTTA_PILLAR = pillar(Blocks.PINK_GLAZED_TERRACOTTA);

    // Pressure Plates
    public static final Block POLISHED_ANDESITE_PRESSURE_PLATE = stonePressurePlate(Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_DIORITE_PRESSURE_PLATE = stonePressurePlate(Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_GRANITE_PRESSURE_PLATE = stonePressurePlate(Blocks.POLISHED_GRANITE);
    public static final Block LIMESTONE_PRESSURE_PLATE = stonePressurePlate(BlockusBlocks.LIMESTONE.block());
    public static final Block MARBLE_PRESSURE_PLATE = stonePressurePlate(BlockusBlocks.MARBLE.block());
    public static final Block BLUESTONE_PRESSURE_PLATE = stonePressurePlate(BlockusBlocks.BLUESTONE.block());
    public static final Block VIRIDITE_PRESSURE_PLATE = stonePressurePlate(BlockusBlocks.VIRIDITE.block());
    public static final Block POLISHED_NETHERRACK_PRESSURE_PLATE = stonePressurePlate(BlockusBlocks.POLISHED_NETHERRACK.block());
    public static final Block POLISHED_END_STONE_PRESSURE_PLATE = stonePressurePlate(BlockusBlocks.POLISHED_END_STONE.block());
    public static final Block POLISHED_BASALT_PRESSURE_PLATE = stonePressurePlate(Blocks.POLISHED_BASALT);
    public static final Block POLISHED_DEEPSLATE_PRESSURE_PLATE = stonePressurePlate(Blocks.POLISHED_DEEPSLATE);
    public static final Block POLISHED_TUFF_PRESSURE_PLATE = stonePressurePlate(Blocks.POLISHED_TUFF);
    public static final Block POLISHED_SCULK_PRESSURE_PLATE = stonePressurePlate(BlockusBlocks.POLISHED_SCULK.block());
    public static final Block OBSIDIAN_PRESSURE_PLATE = registerOf("obsidian_pressure_plate", ObsidianPressurePlateBlock::new, pressurePlateButtonSettings(Blocks.OBSIDIAN).solid());

    // Buttons
    public static final Block POLISHED_ANDESITE_BUTTON = stoneButton(Blocks.POLISHED_ANDESITE);
    public static final Block POLISHED_DIORITE_BUTTON = stoneButton(Blocks.POLISHED_DIORITE);
    public static final Block POLISHED_GRANITE_BUTTON = stoneButton(Blocks.POLISHED_GRANITE);
    public static final Block LIMESTONE_BUTTON = stoneButton(BlockusBlocks.LIMESTONE.block());
    public static final Block MARBLE_BUTTON = stoneButton(BlockusBlocks.MARBLE.block());
    public static final Block BLUESTONE_BUTTON = stoneButton(BlockusBlocks.BLUESTONE.block());
    public static final Block VIRIDITE_BUTTON = stoneButton(BlockusBlocks.VIRIDITE.block());
    public static final Block POLISHED_NETHERRACK_BUTTON = stoneButton(BlockusBlocks.POLISHED_NETHERRACK.block());
    public static final Block POLISHED_END_STONE_BUTTON = stoneButton(BlockusBlocks.POLISHED_END_STONE.block());
    public static final Block POLISHED_BASALT_BUTTON = stoneButton(Blocks.POLISHED_BASALT);
    public static final Block POLISHED_DEEPSLATE_BUTTON = stoneButton(Blocks.POLISHED_DEEPSLATE);
    public static final Block POLISHED_TUFF_BUTTON = stoneButton(Blocks.POLISHED_TUFF);
    public static final Block POLISHED_SCULK_BUTTON = stoneButton(BlockusBlocks.POLISHED_SCULK.block());

    // Thatch
    public static final BSSWBundle THATCH = BSSWBundle.of("thatch", Blocks.HAY_BLOCK).includeWall(false).register();

    // Paper
    public static final Block PAPER_BLOCK = registerOf("paper_block", create().mapColor(MapColor.OFF_WHITE).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS));
    public static final Block BURNT_PAPER_BLOCK = registerOf("burnt_paper_block", create().mapColor(MapColor.STONE_GRAY).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS));
    public static final Block FRAMED_PAPER_BLOCK = registerOf("framed_paper_block", create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASS).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Block PAPER_WALL = woodenPane("paper_wall");
    public static final Block PAPER_DOOR = woodenDoor("paper_door", 0.1f, 0.8f, BlockSoundGroup.WOOD, MapColor.OFF_WHITE, BlockSetType.OAK);
    public static final Block PAPER_TRAPDOOR = woodenTrapdoor("paper_trapdoor", 0.1f, 0.8f, BlockSoundGroup.WOOD, MapColor.OFF_WHITE, BlockSetType.OAK);
    public static final Block PAPER_LAMP = registerOf("paper_lamp", PaperLampBlock::new, create().mapColor(MapColor.OFF_WHITE).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS).luminance((state) -> 15).instrument(NoteBlockInstrument.BASS));

    // Plating
    public static final BSSWBundle IRON_PLATING = BSSWBundle.of("iron_plating", Blocks.IRON_BLOCK, MapColor.STONE_GRAY).includeWall(false).register();
    public static final BSSWBundle GOLD_PLATING = BSSWBundle.of("gold_plating", Blocks.GOLD_BLOCK).includeWall(false).register();

    // Gates - chains - bars
    public static final Block IRON_GATE = registerCopy("iron_gate", settings -> new DoorBlock(BlockSetType.IRON, settings), Blocks.IRON_DOOR);
    public static final Block GOLDEN_GATE = registerCopy("golden_gate", settings -> new DoorBlock(BlockSetType.GOLD, settings), Blocks.IRON_DOOR);
    public static final Block GOLDEN_BARS = registerCopy("golden_bars", PaneBlock::new, Blocks.IRON_BARS, settings -> settings.sounds(BlockSoundGroup.METAL));
    public static final Block GOLDEN_CHAIN = registerCopy("golden_chain", ChainBlock::new, Blocks.CHAIN);

    // Lantern Blocks
    public static final Block LANTERN_BLOCK = registerCopy("lantern_block", Blocks.LANTERN, settings -> settings.pistonBehavior(PistonBehavior.NORMAL));
    public static final Block SOUL_LANTERN_BLOCK = registerCopy("soul_lantern_block", Blocks.SOUL_LANTERN, settings -> settings.pistonBehavior(PistonBehavior.NORMAL));
    public static final Block AMETHYST_LANTERN = registerCopy("amethyst_lantern", LanternBlock::new, Blocks.LANTERN);
    public static final Block AMETHYST_LANTERN_BLOCK = registerCopy("amethyst_lantern_block", Blocks.LANTERN, settings -> settings.pistonBehavior(PistonBehavior.NORMAL));
    public static final Block REDSTONE_LANTERN = registerCopy("redstone_lantern", RedstoneLantern::new, Blocks.LANTERN, settings -> settings.luminance((state) -> 7));
    public static final Block REDSTONE_LANTERN_BLOCK = registerCopy("redstone_lantern_block", RedstoneBlock::new, REDSTONE_LANTERN, settings -> settings.luminance((state) -> 7).pistonBehavior(PistonBehavior.NORMAL));
    public static final Block SOUL_O_LANTERN = registerCopy("soul_o_lantern", CarvedPumpkinBlock::new, Blocks.JACK_O_LANTERN, settings -> settings.luminance((state) -> 10));
    public static final Block REDSTONE_O_LANTERN = registerCopy("redstone_o_lantern", RedstonePumpkinBlock::new, Blocks.JACK_O_LANTERN, settings -> settings.luminance((state) -> 7));
    public static final Block AMETHYST_LAMP = registerCopy("amethyst_lamp", AmethystLampBlock::new, Blocks.AMETHYST_BLOCK);

    // Barriers
    public static final Block CAUTION_BARRIER = registerOf("caution_barrier", Barrier::new, create().mapColor(MapColor.YELLOW).strength(1.5F, 1200.0F).instrument(NoteBlockInstrument.BASEDRUM).requiresTool());
    public static final Block ROAD_BARRIER = registerOf("road_barrier", Barrier::new, create().mapColor(MapColor.STONE_GRAY).strength(2.0F, 6.0F).instrument(NoteBlockInstrument.BASEDRUM).requiresTool());

    // Netherite Blocks
    public static final Block NETHERITE_STAIRS = stairs(Blocks.NETHERITE_BLOCK);
    public static final Block NETHERITE_SLAB = slab(Blocks.NETHERITE_BLOCK);

    // Other
    public static final Block PATH = registerCopy("path", DirtPathBlock::new, Blocks.DIRT_PATH);
    public static final Block CHARCOAL_BLOCK = registerCopy("charcoal_block", Blocks.COAL_BLOCK);
    public static final Block SUGAR_BLOCK = registerOf("sugar_block", SimpleFallingBlock::new, create().mapColor(MapColor.OFF_WHITE).strength(0.5F).sounds(BlockSoundGroup.SAND));
    public static final Block ENDER_BLOCK = registerOf("ender_block", create().mapColor(MapColor.TERRACOTTA_GREEN).strength(5.0f, 6.0f));
    public static final Block ROTTEN_FLESH_BLOCK = registerOf("rotten_flesh_block", create().mapColor(MapColor.TERRACOTTA_RED).strength(0.5f).sounds(BlockSoundGroup.SLIME));
    public static final Block MEMBRANE_BLOCK = registerOf("membrane_block", create().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.5f).sounds(BlockSoundGroup.SLIME));
    public static final Block NETHER_STAR_BLOCK = registerNetherStarBlock("nether_stars_block", NetherStarBlock::new, create().mapColor(MapColor.OFF_WHITE).strength(5.0f, 6.0f).requiresTool());
    public static final Block REDSTONE_SAND = registerCopy("redstone_sand", FallingRedstoneBlock::new, Blocks.SAND, settings -> settings.mapColor(MapColor.BRIGHT_RED));
    public static final Block LOVE_BLOCK = registerOf("love_block", LoveBlock::new, create().mapColor(MapColor.PINK).strength(2, 6.0f).requiresTool());
    public static final Block WEIGHT_STORAGE_CUBE = registerOf("weight_storage_cube", WeightStorageCubeBlock::new, create().mapColor(MapColor.IRON_GRAY).strength(0.1f, 6.0f));
    public static final Block COMPANION_CUBE = registerOf("companion_cube", SimpleFallingBlock::new, create().mapColor(MapColor.IRON_GRAY).strength(0.1F, 6.0F).sounds(BlockSoundGroup.STONE));
    public static final Block CAUTION_BLOCK = registerOf("caution_block", create().mapColor(MapColor.ORANGE).strength(1.5f, 1200.0f).requiresTool());
    public static final Block STARS_BLOCK = registerOf("stars_block", create().mapColor(MapColor.BLACK).strength(5.0f, 6.0f));

    // Legacy
    public static final Block LEGACY_SAPLING = registerLegacy("legacy_sapling", settings -> new SaplingBlock(BlockusSaplingGenerator.LEGACY_OAK, settings), createCopy(Blocks.OAK_SAPLING), "Indev");
    public static final PottedLargeBundle POTTED_LEGACY_TREE = PottedLargeBundle.of("potted_legacy_tree", BlockusBlocks.LEGACY_SAPLING).register();
    public static final Block POTTED_LEGACY_SAPLING = pottedPlant("potted_legacy_sapling", LEGACY_SAPLING);
    public static final Block LEGACY_FIRST_GRASS_BLOCK = registerLegacy("legacy_first_grass_block", createCopy(Blocks.GRASS_BLOCK), "Cave game");
    public static final Block LEGACY_GRASS_BLOCK = registerLegacy("legacy_grass_block", createCopy(Blocks.GRASS_BLOCK), "Pre-Classic");
    public static final Block LEGACY_LEAVES = registerLegacy("legacy_leaves", settings -> new TintedParticleLeavesBlock(0, settings), createCopy(Blocks.OAK_LEAVES).mapColor(MapColor.LIME).allowsSpawning(BlockusBlocks::canSpawnOnLeaves).suffocates(BlockusBlocks::never).blockVision(BlockusBlocks::never), "Classic 0.0.15a");
    public static final Block LEGACY_LOG = registerLegacy("legacy_log", PillarBlock::new, createCopy(Blocks.OAK_LOG), "Classic 0.0.14a");
    public static final Block LEGACY_BRICKS = registerLegacy("legacy_bricks", createCopy(Blocks.BRICKS), "Classic 0.26");
    public static final Block LEGACY_PLANKS = registerLegacy("legacy_planks", createCopy(Blocks.OAK_PLANKS), "Pre-Classic");
    public static final Block LEGACY_FIRST_COBBLESTONE = registerLegacy("legacy_first_cobblestone", createCopy(Blocks.COBBLESTONE), "Pre-Classic");
    public static final Block LEGACY_COBBLESTONE = registerLegacy("legacy_cobblestone", createCopy(Blocks.COBBLESTONE), "Classic 0.0.14a");
    public static final Block LEGACY_MOSSY_COBBLESTONE = registerLegacy("legacy_mossy_cobblestone", createCopy(Blocks.MOSSY_COBBLESTONE), "Classic 0.26");
    public static final Block LEGACY_GRAVEL = registerLegacy("legacy_gravel", settings -> new ColoredFallingBlock(new ColorCode(-8356741), settings), createCopy(Blocks.GRAVEL), "Classic 0.0.15a");
    public static final Block LEGACY_IRON_BLOCK = registerLegacy("legacy_iron_block", createCopy(Blocks.IRON_BLOCK), "Classic 0.26");
    public static final Block LEGACY_GOLD_BLOCK = registerLegacy("legacy_gold_block", createCopy(Blocks.GOLD_BLOCK), "Classic 0.26");
    public static final Block LEGACY_EXPLOSION_PROOF_GOLD_BLOCK = registerLegacy("legacy_explosion_proof_gold_block", createCopy(Blocks.GOLD_BLOCK).strength(5.0f, 6000.0f), "Classic 0.0.20a");
    public static final Block LEGACY_COAL_BLOCK = registerLegacy("legacy_coal_block", createCopy(Blocks.COAL_BLOCK), "2.0 April Fool");
    public static final Block LEGACY_DIAMOND_BLOCK = registerLegacy("legacy_diamond_block", createCopy(Blocks.DIAMOND_BLOCK), "Indev");
    public static final Block LEGACY_LAPIS_BLOCK = registerLegacy("legacy_lapis_block", createCopy(Blocks.LAPIS_BLOCK), "Beta 1.2");
    public static final Block LEGACY_SPONGE = registerLegacy("legacy_sponge", SpongeBlock::new, createCopy(Blocks.SPONGE), "Classic 0.0.19a");
    public static final Block LEGACY_CRYING_OBSIDIAN = registerLegacy("legacy_crying_obsidian", createCopy(Blocks.CRYING_OBSIDIAN).pistonBehavior(PistonBehavior.BLOCK), "Beta 1.3 (texture)");
    public static final Block LEGACY_GLOWSTONE = registerLegacy("legacy_glowstone", createCopy(Blocks.GLOWSTONE), "Alpha 1.2.0");
    public static final Block LEGACY_STONECUTTER = registerLegacy("legacy_stonecutter", LegacyStonecutterBlock::new, createCopy(Blocks.COBBLESTONE).strength(1.5f, 17.5f), "PE Alpha");
    public static final Block LEGACY_GLOWING_OBSIDIAN = registerLegacy("legacy_glowing_obsidian", createCopy(BlockusBlocks.GLOWING_OBSIDIAN), "PE Alpha");
    public static final Block LEGACY_NETHER_REACTOR_CORE = registerLegacy("legacy_nether_reactor_core", create().mapColor(MapColor.LIGHT_BLUE).strength(1.5f, 6.0f).requiresTool(), "PE Alpha");
    public static final Block LEGACY_ROSE = registerLegacy("legacy_rose", settings -> new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, settings), createCopy(Blocks.POPPY), "Beta 1.8");
    public static final Block POTTED_LEGACY_ROSE = pottedPlant("potted_legacy_rose", LEGACY_ROSE);
    public static final Block LEGACY_BLUE_ROSE = registerLegacy("legacy_blue_rose", settings -> new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, settings), createCopy(Blocks.POPPY), "PE Alpha");
    public static final Block POTTED_LEGACY_BLUE_ROSE = pottedPlant("potted_legacy_blue_rose", LEGACY_BLUE_ROSE);


    // Colored Tiles
    /**
     * <p>Bicolor variants in {@link ColoredTilesBundle}.
     */
    public static final Block WHITE_COLORED_TILES = registerCopy("white_colored_tiles", Blocks.WHITE_CONCRETE);
    public static final Block ORANGE_COLORED_TILES = registerCopy("orange_colored_tiles", Blocks.ORANGE_CONCRETE);
    public static final Block MAGENTA_COLORED_TILES = registerCopy("magenta_colored_tiles", Blocks.MAGENTA_CONCRETE);
    public static final Block LIGHT_BLUE_COLORED_TILES = registerCopy("light_blue_colored_tiles", Blocks.LIGHT_BLUE_CONCRETE);
    public static final Block YELLOW_COLORED_TILES = registerCopy("yellow_colored_tiles", Blocks.YELLOW_CONCRETE);
    public static final Block LIME_COLORED_TILES = registerCopy("lime_colored_tiles", Blocks.LIME_CONCRETE);
    public static final Block PINK_COLORED_TILES = registerCopy("pink_colored_tiles", Blocks.PINK_CONCRETE);
    public static final Block GRAY_COLORED_TILES = registerCopy("gray_colored_tiles", Blocks.GRAY_CONCRETE);
    public static final Block LIGHT_GRAY_COLORED_TILES = registerCopy("light_gray_colored_tiles", Blocks.LIGHT_GRAY_CONCRETE);
    public static final Block CYAN_COLORED_TILES = registerCopy("cyan_colored_tiles", Blocks.CYAN_CONCRETE);
    public static final Block PURPLE_COLORED_TILES = registerCopy("purple_colored_tiles", Blocks.PURPLE_CONCRETE);
    public static final Block BLUE_COLORED_TILES = registerCopy("blue_colored_tiles", Blocks.BLUE_CONCRETE);
    public static final Block BROWN_COLORED_TILES = registerCopy("brown_colored_tiles", Blocks.BROWN_CONCRETE);
    public static final Block GREEN_COLORED_TILES = registerCopy("green_colored_tiles", Blocks.GREEN_CONCRETE);
    public static final Block RED_COLORED_TILES = registerCopy("red_colored_tiles", Blocks.RED_CONCRETE);
    public static final Block BLACK_COLORED_TILES = registerCopy("black_colored_tiles", Blocks.BLACK_CONCRETE);
    public static final Block RAINBOW_COLORED_TILES = registerCopy("rainbow_colored_tiles", HorizontalAxisBlock::new, Blocks.LIGHT_BLUE_CONCRETE);
}
