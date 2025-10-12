package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;

import java.util.Collection;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BuildingBlocksGroup {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_BUILDING_BLOCKS).register((entries) -> {
            entries.add(WHITE_OAK_LOG);
            entries.add(WHITE_OAK_WOOD);
            entries.add(STRIPPED_WHITE_OAK_LOG);
            entries.add(STRIPPED_WHITE_OAK_WOOD);

            for (WoodBundle woodBundle : WoodBundle.values()) {
                entries.add(woodBundle.planks());
                entries.add(woodBundle.stairs());
                entries.add(woodBundle.slab());
                entries.add(woodBundle.fence());
                entries.add(woodBundle.fenceGate());
                entries.add(woodBundle.door());
                entries.add(woodBundle.trapdoor());
                entries.add(woodBundle.pressurePlate());
                entries.add(woodBundle.button());
            }

            for (var wood : WoodMaps.values()) {
                var bundle = HERRINGBONE_PLANKS.bundle().get(wood.getId());
                entries.add(bundle);
            }

            for (var wood : WoodMaps.values()) {
                var bundle = WOODEN_MOSAIC.bundle().get(wood.getId());
                if (bundle != null) {
                    entries.add(bundle.block());
                    entries.add(bundle.stairs());
                    entries.add(bundle.slab());
                }
            }

            for (var wood : WoodMaps.values()) {
                var bundle = MOSSY_PLANKS.bundle().get(wood.getId());
                if (bundle != null) {
                    entries.add(bundle.block());
                    entries.add(bundle.stairs());
                    entries.add(bundle.slab());
                }
            }

            for (var wood : WoodMaps.values()) {
                var bundle = SMALL_LOGS.bundle().get(wood.getId());
                if (bundle != null) {
                    entries.add(bundle);
                }
            }

            for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
                add(entries, woodenPost.all());
            }

            for (var wood : WoodMaps.values()) {
                var bundle = TIMBER_FRAME.woodMap().get(wood);
                entries.add(bundle.lattice());
                entries.add(bundle.grate());
            }
            entries.add(WOODEN_FRAME);
            for (var wood : WoodMaps.values()) {
                var bundle = TIMBER_FRAME.woodMap().get(wood);
                entries.add(bundle.block());
                entries.add(bundle.diagonal());
                entries.add(bundle.cross());
            }

            entries.add(CHISELED_MUD_BRICKS);
            entries.add(MUD_BRICK_PILLAR);

            addBssw(entries, THATCH);

            entries.add(PAPER_BLOCK);
            entries.add(BURNT_PAPER_BLOCK);
            entries.add(FRAMED_PAPER_BLOCK);
            entries.add(PAPER_WALL);
            entries.add(PAPER_DOOR);
            entries.add(PAPER_TRAPDOOR);
            entries.add(PAPER_LAMP);

            addBssw(entries, SNOW_BRICKS);
            entries.add(SNOW_PILLAR);

            entries.add(ICE_BRICKS);
            entries.add(ICE_BRICK_WALL);
            entries.add(ICE_PILLAR);

            addBssw(entries, STONE_TILES);
            entries.add(STONE_BRICK_PILLAR);
            entries.add(HERRINGBONE_STONE_BRICKS);
            entries.add(STONE_CIRCULAR_PAVING);
            entries.add(SMOOTH_STONE_STAIRS);
            entries.add(STONE_DOOR);
            entries.add(STONE_TRAPDOOR);
            entries.add(STURDY_STONE);

            entries.add(POLISHED_GRANITE_PRESSURE_PLATE);
            entries.add(POLISHED_GRANITE_BUTTON);
            addBssw(entries, GRANITE_BRICKS);
            entries.add(HERRINGBONE_GRANITE_BRICKS);
            entries.add(CHISELED_GRANITE_BRICKS);
            entries.add(CRACKED_GRANITE_BRICKS);
            entries.add(POLISHED_GRANITE_PILLAR);
            entries.add(GRANITE_CIRCULAR_PAVING);

            entries.add(POLISHED_DIORITE_PRESSURE_PLATE);
            entries.add(POLISHED_DIORITE_BUTTON);
            addBssw(entries, DIORITE_BRICKS);
            entries.add(HERRINGBONE_DIORITE_BRICKS);
            entries.add(CHISELED_DIORITE_BRICKS);
            entries.add(CRACKED_DIORITE_BRICKS);
            entries.add(POLISHED_DIORITE_PILLAR);
            entries.add(DIORITE_CIRCULAR_PAVING);

            entries.add(POLISHED_ANDESITE_PRESSURE_PLATE);
            entries.add(POLISHED_ANDESITE_BUTTON);
            addBssw(entries, ANDESITE_BRICKS);
            entries.add(HERRINGBONE_ANDESITE_BRICKS);
            entries.add(CHISELED_ANDESITE_BRICKS);
            entries.add(CRACKED_ANDESITE_BRICKS);
            entries.add(POLISHED_ANDESITE_PILLAR);
            entries.add(ANDESITE_CIRCULAR_PAVING);

            addBssw(entries, WATER_BRICKS);
            entries.add(CHISELED_WATER_BRICKS);

            addBssw(entries, LAVA_BRICKS);
            entries.add(CHISELED_LAVA_BRICKS);

            addBssw(entries, LIMESTONE);
            entries.add(LIMESTONE_PRESSURE_PLATE);
            entries.add(LIMESTONE_BUTTON);
            addBssw(entries, POLISHED_LIMESTONE);
            addBssw(entries, LIMESTONE_BRICKS);
            addBssw(entries, SMALL_LIMESTONE_BRICKS);
            addBssw(entries, LIMESTONE_TILES);
            entries.add(CHISELED_LIMESTONE);
            entries.add(CHISELED_LIMESTONE_BRICKS);
            entries.add(LIMESTONE_PILLAR);
            entries.add(CHISELED_LIMESTONE_PILLAR);
            entries.add(LIMESTONE_SQUARES);
            entries.add(LIMESTONE_CIRCULAR_PAVING);
            entries.add(LIMESTONE_LINES);

            addBssw(entries, MARBLE);
            entries.add(MARBLE_PRESSURE_PLATE);
            entries.add(MARBLE_BUTTON);
            addBssw(entries, POLISHED_MARBLE);
            addBssw(entries, MARBLE_BRICKS);
            addBssw(entries, SMALL_MARBLE_BRICKS);
            addBssw(entries, MARBLE_TILES);
            entries.add(CHISELED_MARBLE);
            entries.add(CHISELED_MARBLE_BRICKS);
            entries.add(MARBLE_PILLAR);
            entries.add(CHISELED_MARBLE_PILLAR);
            entries.add(MARBLE_SQUARES);
            entries.add(MARBLE_CIRCULAR_PAVING);
            entries.add(MARBLE_LINES);

            addBssw(entries, POLISHED_DRIPSTONE);
            addBssw(entries, DRIPSTONE_BRICKS);
            addBssw(entries, MOSSY_DRIPSTONE_BRICKS);
            entries.add(CRACKED_DRIPSTONE_BRICKS);
            entries.add(CHISELED_DRIPSTONE);
            entries.add(DRIPSTONE_PILLAR);

            entries.add(POLISHED_TUFF_PRESSURE_PLATE);
            entries.add(POLISHED_TUFF_BUTTON);
            addBssw(entries, MOSSY_TUFF_BRICKS);
            entries.add(CRACKED_TUFF_BRICKS);
            addBssw(entries, TUFF_TILES);
            entries.add(CARVED_TUFF_BRICKS);
            entries.add(HERRINGBONE_TUFF_BRICKS);
            entries.add(TUFF_PILLAR);
            entries.add(TUFF_CIRCULAR_PAVING);

            entries.add(POLISHED_DEEPSLATE_PRESSURE_PLATE);
            entries.add(POLISHED_DEEPSLATE_BUTTON);
            addBssw(entries, MOSSY_DEEPSLATE_BRICKS);
            entries.add(HERRINGBONE_DEEPSLATE_BRICKS);
            entries.add(DEEPSLATE_PILLAR);
            entries.add(DEEPSLATE_CIRCULAR_PAVING);
            entries.add(STURDY_DEEPSLATE);

            addBssw(entries, BLUESTONE);
            entries.add(BLUESTONE_PRESSURE_PLATE);
            entries.add(BLUESTONE_BUTTON);
            addBssw(entries, POLISHED_BLUESTONE);
            addBssw(entries, BLUESTONE_BRICKS);
            addBssw(entries, SMALL_BLUESTONE_BRICKS);
            addBssw(entries, BLUESTONE_TILES);
            entries.add(CHISELED_BLUESTONE);
            entries.add(CHISELED_BLUESTONE_BRICKS);
            entries.add(BLUESTONE_PILLAR);
            entries.add(CHISELED_BLUESTONE_PILLAR);
            entries.add(BLUESTONE_SQUARES);
            entries.add(BLUESTONE_CIRCULAR_PAVING);
            entries.add(BLUESTONE_LINES);

            addBssw(entries, VIRIDITE);
            entries.add(VIRIDITE_PRESSURE_PLATE);
            entries.add(VIRIDITE_BUTTON);
            addBssw(entries, POLISHED_VIRIDITE);
            addBssw(entries, VIRIDITE_BRICKS);
            addBssw(entries, SMALL_VIRIDITE_BRICKS);
            addBssw(entries, VIRIDITE_TILES);
            entries.add(CHISELED_VIRIDITE);
            entries.add(CHISELED_VIRIDITE_BRICKS);
            entries.add(VIRIDITE_PILLAR);
            entries.add(CHISELED_VIRIDITE_PILLAR);
            entries.add(VIRIDITE_SQUARES);
            entries.add(VIRIDITE_CIRCULAR_PAVING);
            entries.add(VIRIDITE_LINES);

            addBssw(entries, POLISHED_SCULK);
            entries.add(POLISHED_SCULK_PRESSURE_PLATE);
            entries.add(POLISHED_SCULK_BUTTON);
            addBssw(entries, SCULK_BRICKS);
            entries.add(CHISELED_SCULK_BRICKS);
            entries.add(SCULK_PILLAR);

            addBssw(entries, HONEYCOMB_BRICKS);

            addBssw(entries, LARGE_BRICKS);
            entries.add(HERRINGBONE_BRICKS);
            addBssw(entries, SOAKED_BRICKS);
            entries.add(HERRINGBONE_SOAKED_BRICKS);
            addBssw(entries, SANDY_BRICKS);
            entries.add(HERRINGBONE_SANDY_BRICKS);
            addBssw(entries, CHARRED_BRICKS);
            entries.add(HERRINGBONE_CHARRED_BRICKS);

            addBssw(entries, LARGE_RESIN_BRICKS);
            entries.add(HERRINGBONE_RESIN_BRICKS);
            entries.add(RESIN_BRICK_PILLAR);

            addBssw(entries, ROUGH_SANDSTONE);
            addBssw(entries, SANDSTONE_BRICKS);
            addBssw(entries, SMALL_SANDSTONE_BRICKS);
            entries.add(SANDSTONE_PILLAR);
            entries.add(GOLD_DECORATED_SANDSTONE);
            entries.add(LAPIS_DECORATED_SANDSTONE);

            addBssw(entries, ROUGH_RED_SANDSTONE);
            addBssw(entries, RED_SANDSTONE_BRICKS);
            addBssw(entries, SMALL_RED_SANDSTONE_BRICKS);
            entries.add(RED_SANDSTONE_PILLAR);
            entries.add(GOLD_DECORATED_RED_SANDSTONE);
            entries.add(LAPIS_DECORATED_RED_SANDSTONE);

            addBssw(entries, SOUL_SANDSTONE);
            addBssw(entries, ROUGH_SOUL_SANDSTONE);
            addBssw(entries, SMOOTH_SOUL_SANDSTONE);
            addBssw(entries, SOUL_SANDSTONE_BRICKS);
            addBssw(entries, SMALL_SOUL_SANDSTONE_BRICKS);
            entries.add(CHISELED_SOUL_SANDSTONE);
            entries.add(CUT_SOUL_SANDSTONE);
            entries.add(CUT_SOUL_SANDSTONE_SLAB);
            entries.add(SOUL_SANDSTONE_PILLAR);
            entries.add(GOLD_DECORATED_SOUL_SANDSTONE);
            entries.add(LAPIS_DECORATED_SOUL_SANDSTONE);

            entries.add(PRISMARINE_CIRCULAR_PAVING);
            entries.add(CHISELED_DARK_PRISMARINE);
            entries.add(DARK_PRISMARINE_PILLAR);
            entries.add(CHISELED_PRISMARINE);
            entries.add(PRISMARINE_PILLAR);
            addBssw(entries, PRISMARINE_TILES);

            addBssw(entries, OBSIDIAN_BRICKS);
            entries.add(CRACKED_OBSIDIAN_BRICKS);
            addBssw(entries, SMALL_OBSIDIAN_BRICKS);
            entries.add(OBSIDIAN_PILLAR);
            entries.add(OBSIDIAN_CIRCULAR_PAVING);
            entries.add(OBSIDIAN_REINFORCED_DOOR);
            entries.add(OBSIDIAN_REINFORCED_TRAPDOOR);
            entries.add(GLOWING_OBSIDIAN);

            addBssw(entries, POLISHED_NETHERRACK);
            entries.add(POLISHED_NETHERRACK_PRESSURE_PLATE);
            entries.add(POLISHED_NETHERRACK_BUTTON);
            addBssw(entries, NETHERRACK_BRICKS);
            entries.add(NETHERRACK_CIRCULAR_PAVING);

            addBssw(entries, MAGMA_BRICKS);
            addBssw(entries, SMALL_MAGMA_BRICKS);
            entries.add(CHISELED_MAGMA_BRICKS);

            addBssw(entries, CRIMSON_WART_BRICKS);
            addBssw(entries, WARPED_WART_BRICKS);

            addBssw(entries, NETHER_TILES);

            addBssw(entries, POLISHED_NETHER_BRICKS);
            entries.add(HERRINGBONE_NETHER_BRICKS);
            entries.add(NETHER_BRICK_PILLAR);
            addBssw(entries, POLISHED_RED_NETHER_BRICKS);
            entries.add(HERRINGBONE_RED_NETHER_BRICKS);
            entries.add(RED_NETHER_BRICK_PILLAR);
            addBssw(entries, CHARRED_NETHER_BRICKS);
            addBssw(entries, POLISHED_CHARRED_NETHER_BRICKS);
            entries.add(HERRINGBONE_CHARRED_NETHER_BRICKS);
            entries.add(CHARRED_NETHER_BRICK_PILLAR);
            addBssw(entries, TEAL_NETHER_BRICKS);
            addBssw(entries, POLISHED_TEAL_NETHER_BRICKS);
            entries.add(HERRINGBONE_TEAL_NETHER_BRICKS);
            entries.add(TEAL_NETHER_BRICK_PILLAR);

            entries.add(BLAZE_LANTERN);
            addBssw(entries, BLAZE_BRICKS);
            entries.add(BLAZE_PILLAR);

            addBssw(entries, ROUGH_BASALT);
            addBssw(entries, POLISHED_BASALT_BRICKS);
            entries.add(POLISHED_BASALT_PRESSURE_PLATE);
            entries.add(POLISHED_BASALT_BUTTON);
            entries.add(CHISELED_POLISHED_BASALT);
            entries.add(CRACKED_POLISHED_BASALT_BRICKS);
            entries.add(POLISHED_BASALT_PILLAR);
            entries.add(HERRINGBONE_POLISHED_BASALT_BRICKS);
            entries.add(POLISHED_BASALT_CIRCULAR_PAVING);

            addBssw(entries, POLISHED_BLACKSTONE_TILES);
            entries.add(POLISHED_BLACKSTONE_PILLAR);
            entries.add(HERRINGBONE_POLISHED_BLACKSTONE_BRICKS);
            entries.add(POLISHED_BLACKSTONE_CIRCULAR_PAVING);
            addBssw(entries, CRIMSON_WARTY_BLACKSTONE_BRICKS);
            addBssw(entries, WARPED_WARTY_BLACKSTONE_BRICKS);
            entries.add(BLACKSTONE_DOOR);
            entries.add(BLACKSTONE_TRAPDOOR);
            entries.add(GOLD_DECORATED_POLISHED_BLACKSTONE);
            entries.add(STURDY_BLACKSTONE);

            addBssw(entries, LAVA_POLISHED_BLACKSTONE_BRICKS);
            entries.add(CHISELED_LAVA_POLISHED_BLACKSTONE);

            entries.add(CHISELED_END_STONE_BRICKS);
            entries.add(HERRINGBONE_END_STONE_BRICKS);
            addBssw(entries, POLISHED_END_STONE);
            entries.add(POLISHED_END_STONE_PRESSURE_PLATE);
            entries.add(POLISHED_END_STONE_BUTTON);
            entries.add(CRACKED_END_STONE_BRICKS);
            entries.add(END_STONE_PILLAR);
            addBssw(entries, SMALL_END_STONE_BRICKS);

            entries.add(PURPUR_DECORATED_END_STONE);
            entries.add(PHANTOM_PURPUR_DECORATED_END_STONE);

            addBssw(entries, END_TILES);
            addBssw(entries, PURPUR_BRICKS);
            addBssw(entries, POLISHED_PURPUR);
            entries.add(PURPUR_SQUARES);
            addBssw(entries, SMALL_PURPUR_BRICKS);
            entries.add(CHISELED_PURPUR);
            entries.add(PURPUR_LINES);

            addBssw(entries, PHANTOM_PURPUR_BLOCK);
            entries.add(PHANTOM_PURPUR_PILLAR);
            addBssw(entries, PHANTOM_PURPUR_BRICKS);
            addBssw(entries, POLISHED_PHANTOM_PURPUR);
            entries.add(PHANTOM_PURPUR_SQUARES);
            addBssw(entries, SMALL_PHANTOM_PURPUR_BRICKS);
            entries.add(CHISELED_PHANTOM_PURPUR);
            entries.add(PHANTOM_PURPUR_LINES);

            entries.add(LANTERN_BLOCK);
            entries.add(SOUL_LANTERN_BLOCK);
            entries.add(AMETHYST_LANTERN_BLOCK);

            entries.add(CAUTION_BLOCK);
            entries.add(CAUTION_BARRIER);
            entries.add(ROAD_BARRIER);

            addBssw(entries, IRON_PLATING);
            entries.add(IRON_GATE);

            addBssw(entries, GOLD_PLATING);
            entries.add(GOLDEN_BARS);
            entries.add(GOLDEN_CHAIN);
            entries.add(GOLDEN_GATE);

            addBssw(entries, IRON_BRICKS);
            addBssw(entries, GOLD_BRICKS);
            addBssw(entries, REDSTONE_BRICKS);
            addBssw(entries, EMERALD_BRICKS);
            addBssw(entries, LAPIS_BRICKS);
            addBssw(entries, DIAMOND_BRICKS);
            addBssw(entries, NETHERITE_BRICKS);

            entries.add(NETHERITE_STAIRS);
            entries.add(NETHERITE_SLAB);


            for (CopperBSSWBundle copperBundle : CopperBSSWBundle.values()) {
                for (Block block : copperBundle.all()) {
                    entries.add(block);
                }
            }
            COPPER_GATE.forEach(entries::add);

            entries.add(CHARCOAL_BLOCK);
            entries.add(ENDER_BLOCK);
            entries.add(NETHER_STAR_BLOCK);


            addBssw(entries, QUARTZ_TILES);
            entries.add(QUARTZ_CIRCULAR_PAVING);

            addBssw(entries, POLISHED_AMETHYST);
            addBssw(entries, AMETHYST_BRICKS);
            entries.add(CHISELED_AMETHYST);
            entries.add(AMETHYST_PILLAR);

            addBssw(entries, CHOCOLATE_BLOCK);
            addBssw(entries, CHOCOLATE_BRICKS);
            entries.add(CHOCOLATE_SQUARES);
            entries.add(CHOCOLATE_TABLET);

            entries.add(ROTTEN_FLESH_BLOCK);
            entries.add(CHORUS_BLOCK);
            entries.add(SUGAR_BLOCK);
            entries.add(COOKIE_BLOCK);
            entries.add(SWEET_BERRIES_CRATE);
            entries.add(SALMON_CRATE);
            entries.add(PUFFERFISH_CRATE);
            entries.add(TROPICAL_FISH_CRATE);
            entries.add(COD_CRATE);
            entries.add(POTATO_CRATE);
            entries.add(APPLE_CRATE);
            entries.add(BEETROOT_CRATE);
            entries.add(CARROT_CRATE);
            entries.add(BREAD_BOX);
            entries.add(GOLDEN_APPLE_CRATE);
            entries.add(GOLDEN_CARROT_CRATE);
            entries.add(GLOW_BERRIES_CRATE);
           /* if (FabricLoader.getInstance().isModLoaded("promenade")) {
                entries.add(BlockusPromenadeBlocks.BLUEBERRIES_CRATE);
            }*/

            entries.add(RAINBOW_BLOCK);
            addBssw(entries, RAINBOW_BRICKS);
            entries.add(RAINBOW_GLOWSTONE);

            entries.add(WEIGHT_STORAGE_CUBE);
            entries.add(COMPANION_CUBE);
            entries.add(LOVE_BLOCK);
            entries.add(STARS_BLOCK);
        });
    }

    public static void addBssw(FabricItemGroupEntries entries, BSSWBundle bsswBundle) {
        // Block, stairs & slab & wall (if exist) variants of a block
        for (Block block : bsswBundle.all()) {
            entries.add(block);
        }
    }

    public static void add(FabricItemGroupEntries entries, Collection<Block> blocks) {
        for (Block block : blocks) {
            entries.add(block);
        }
    }
}
