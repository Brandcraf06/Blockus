package com.brand.blockus.itemgroups.content;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.bundles.BSSWBundle;
import com.brand.blockus.registry.content.bundles.CopperBundle;
import com.brand.blockus.registry.content.bundles.WoodBundle;
import com.brand.blockus.registry.content.bundles.WoodenPostBundle;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.level.block.Block;

import java.util.Collection;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BuildingBlocksGroup {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(BlockusItemGroups.BLOCKUS_BUILDING_BLOCKS).register((entries) -> {
            entries.accept(WHITE_OAK_LOG);
            entries.accept(WHITE_OAK_WOOD);
            entries.accept(STRIPPED_WHITE_OAK_LOG);
            entries.accept(STRIPPED_WHITE_OAK_WOOD);

            for (WoodBundle woodBundle : WoodBundle.values()) {
                entries.accept(woodBundle.planks());
                entries.accept(woodBundle.stairs());
                entries.accept(woodBundle.slab());
                entries.accept(woodBundle.fence());
                entries.accept(woodBundle.fenceGate());
                entries.accept(woodBundle.door());
                entries.accept(woodBundle.trapdoor());
                entries.accept(woodBundle.pressurePlate());
                entries.accept(woodBundle.button());
            }

            for (var wood : WoodMaps.values()) {
                var bundle = HERRINGBONE_PLANKS.bundle().get(wood.getId());
                entries.accept(bundle);
            }

            for (var wood : WoodMaps.values()) {
                var bundle = WOODEN_MOSAIC.bundle().get(wood.getId());
                if (bundle != null) {
                    entries.accept(bundle.block());
                    entries.accept(bundle.stairs());
                    entries.accept(bundle.slab());
                }
            }

            for (var wood : WoodMaps.values()) {
                var bundle = MOSSY_PLANKS.bundle().get(wood.getId());
                if (bundle != null) {
                    entries.accept(bundle.block());
                    entries.accept(bundle.stairs());
                    entries.accept(bundle.slab());
                }
            }

            for (var wood : WoodMaps.values()) {
                var bundle = SMALL_LOGS.bundle().get(wood.getId());
                if (bundle != null) {
                    entries.accept(bundle);
                }
            }

            for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
                add(entries, woodenPost.all());
            }

            for (var wood : WoodMaps.values()) {
                var bundle = TIMBER_FRAME.woodMap().get(wood);
                entries.accept(bundle.lattice());
                entries.accept(bundle.grate());
            }
            entries.accept(WOODEN_FRAME);
            for (var wood : WoodMaps.values()) {
                var bundle = TIMBER_FRAME.woodMap().get(wood);
                entries.accept(bundle.block());
                entries.accept(bundle.diagonal());
                entries.accept(bundle.cross());
            }

            entries.accept(CHISELED_MUD_BRICKS);
            entries.accept(MUD_BRICK_PILLAR);

            addBssw(entries, THATCH);

            entries.accept(PAPER_BLOCK);
            entries.accept(BURNT_PAPER_BLOCK);
            entries.accept(FRAMED_PAPER_BLOCK);
            entries.accept(PAPER_WALL);
            entries.accept(PAPER_DOOR);
            entries.accept(PAPER_TRAPDOOR);
            entries.accept(PAPER_LAMP);

            addBssw(entries, SNOW_BRICKS);
            entries.accept(SNOW_PILLAR);

            entries.accept(ICE_BRICKS);
            entries.accept(ICE_BRICK_WALL);
            entries.accept(ICE_PILLAR);

            addBssw(entries, COBBLESTONE_BRICKS);
            addBssw(entries, STONE_TILES);
            entries.accept(STONE_BRICK_PILLAR);
            entries.accept(HERRINGBONE_STONE_BRICKS);
            entries.accept(STONE_CIRCULAR_PAVING);
            entries.accept(SMOOTH_STONE_STAIRS);
            entries.accept(STONE_DOOR);
            entries.accept(STONE_TRAPDOOR);
            entries.accept(STURDY_STONE);
            addBssw(entries, MOSSY_COBBLESTONE_BRICKS);

            entries.accept(POLISHED_GRANITE_PRESSURE_PLATE);
            entries.accept(POLISHED_GRANITE_BUTTON);
            addBssw(entries, GRANITE_BRICKS);
            entries.accept(HERRINGBONE_GRANITE_BRICKS);
            entries.accept(CHISELED_GRANITE_BRICKS);
            entries.accept(CRACKED_GRANITE_BRICKS);
            entries.accept(POLISHED_GRANITE_PILLAR);
            entries.accept(GRANITE_CIRCULAR_PAVING);

            entries.accept(POLISHED_DIORITE_PRESSURE_PLATE);
            entries.accept(POLISHED_DIORITE_BUTTON);
            addBssw(entries, DIORITE_BRICKS);
            entries.accept(HERRINGBONE_DIORITE_BRICKS);
            entries.accept(CHISELED_DIORITE_BRICKS);
            entries.accept(CRACKED_DIORITE_BRICKS);
            entries.accept(POLISHED_DIORITE_PILLAR);
            entries.accept(DIORITE_CIRCULAR_PAVING);

            entries.accept(POLISHED_ANDESITE_PRESSURE_PLATE);
            entries.accept(POLISHED_ANDESITE_BUTTON);
            addBssw(entries, ANDESITE_BRICKS);
            entries.accept(HERRINGBONE_ANDESITE_BRICKS);
            entries.accept(CHISELED_ANDESITE_BRICKS);
            entries.accept(CRACKED_ANDESITE_BRICKS);
            entries.accept(POLISHED_ANDESITE_PILLAR);
            entries.accept(ANDESITE_CIRCULAR_PAVING);

            addBssw(entries, WATER_BRICKS);
            entries.accept(CHISELED_WATER_BRICKS);

            addBssw(entries, LAVA_BRICKS);
            entries.accept(CHISELED_LAVA_BRICKS);

            addBssw(entries, LIMESTONE);
            entries.accept(LIMESTONE_PRESSURE_PLATE);
            entries.accept(LIMESTONE_BUTTON);
            addBssw(entries, POLISHED_LIMESTONE);
            addBssw(entries, LIMESTONE_BRICKS);
            addBssw(entries, SMALL_LIMESTONE_BRICKS);
            addBssw(entries, LIMESTONE_TILES);
            entries.accept(CHISELED_LIMESTONE);
            entries.accept(CHISELED_LIMESTONE_BRICKS);
            entries.accept(LIMESTONE_PILLAR);
            entries.accept(CHISELED_LIMESTONE_PILLAR);
            entries.accept(LIMESTONE_SQUARES);
            entries.accept(LIMESTONE_CIRCULAR_PAVING);
            entries.accept(LIMESTONE_LINES);

            addBssw(entries, MARBLE);
            entries.accept(MARBLE_PRESSURE_PLATE);
            entries.accept(MARBLE_BUTTON);
            addBssw(entries, POLISHED_MARBLE);
            addBssw(entries, MARBLE_BRICKS);
            addBssw(entries, SMALL_MARBLE_BRICKS);
            addBssw(entries, MARBLE_TILES);
            entries.accept(CHISELED_MARBLE);
            entries.accept(CHISELED_MARBLE_BRICKS);
            entries.accept(MARBLE_PILLAR);
            entries.accept(CHISELED_MARBLE_PILLAR);
            entries.accept(MARBLE_SQUARES);
            entries.accept(MARBLE_CIRCULAR_PAVING);
            entries.accept(MARBLE_LINES);

            addBssw(entries, POLISHED_DRIPSTONE);
            addBssw(entries, DRIPSTONE_BRICKS);
            addBssw(entries, MOSSY_DRIPSTONE_BRICKS);
            entries.accept(CRACKED_DRIPSTONE_BRICKS);
            entries.accept(CHISELED_DRIPSTONE);
            entries.accept(DRIPSTONE_PILLAR);

            entries.accept(POLISHED_TUFF_PRESSURE_PLATE);
            entries.accept(POLISHED_TUFF_BUTTON);
            addBssw(entries, MOSSY_TUFF_BRICKS);
            entries.accept(CRACKED_TUFF_BRICKS);
            addBssw(entries, TUFF_TILES);
            entries.accept(CARVED_TUFF_BRICKS);
            entries.accept(HERRINGBONE_TUFF_BRICKS);
            entries.accept(TUFF_PILLAR);
            entries.accept(TUFF_CIRCULAR_PAVING);

            addBssw(entries, COBBLED_DEEPSLATE_BRICKS);
            entries.accept(POLISHED_DEEPSLATE_PRESSURE_PLATE);
            entries.accept(POLISHED_DEEPSLATE_BUTTON);
            addBssw(entries, MOSSY_DEEPSLATE_BRICKS);
            entries.accept(HERRINGBONE_DEEPSLATE_BRICKS);
            entries.accept(DEEPSLATE_PILLAR);
            entries.accept(DEEPSLATE_CIRCULAR_PAVING);
            entries.accept(STURDY_DEEPSLATE);

            addBssw(entries, BLUESTONE);
            entries.accept(BLUESTONE_PRESSURE_PLATE);
            entries.accept(BLUESTONE_BUTTON);
            addBssw(entries, POLISHED_BLUESTONE);
            addBssw(entries, BLUESTONE_BRICKS);
            addBssw(entries, SMALL_BLUESTONE_BRICKS);
            addBssw(entries, BLUESTONE_TILES);
            entries.accept(CHISELED_BLUESTONE);
            entries.accept(CHISELED_BLUESTONE_BRICKS);
            entries.accept(BLUESTONE_PILLAR);
            entries.accept(CHISELED_BLUESTONE_PILLAR);
            entries.accept(BLUESTONE_SQUARES);
            entries.accept(BLUESTONE_CIRCULAR_PAVING);
            entries.accept(BLUESTONE_LINES);

            addBssw(entries, VIRIDITE);
            entries.accept(VIRIDITE_PRESSURE_PLATE);
            entries.accept(VIRIDITE_BUTTON);
            addBssw(entries, POLISHED_VIRIDITE);
            addBssw(entries, VIRIDITE_BRICKS);
            addBssw(entries, SMALL_VIRIDITE_BRICKS);
            addBssw(entries, VIRIDITE_TILES);
            entries.accept(CHISELED_VIRIDITE);
            entries.accept(CHISELED_VIRIDITE_BRICKS);
            entries.accept(VIRIDITE_PILLAR);
            entries.accept(CHISELED_VIRIDITE_PILLAR);
            entries.accept(VIRIDITE_SQUARES);
            entries.accept(VIRIDITE_CIRCULAR_PAVING);
            entries.accept(VIRIDITE_LINES);

            addBssw(entries, POLISHED_SCULK);
            entries.accept(POLISHED_SCULK_PRESSURE_PLATE);
            entries.accept(POLISHED_SCULK_BUTTON);
            addBssw(entries, SCULK_BRICKS);
            entries.accept(CHISELED_SCULK_BRICKS);
            entries.accept(SCULK_PILLAR);

            addBssw(entries, HONEYCOMB_BRICKS);

            addBssw(entries, LARGE_BRICKS);
            entries.accept(HERRINGBONE_BRICKS);
            addBssw(entries, SOAKED_BRICKS);
            entries.accept(HERRINGBONE_SOAKED_BRICKS);
            addBssw(entries, SANDY_BRICKS);
            entries.accept(HERRINGBONE_SANDY_BRICKS);
            addBssw(entries, CHARRED_BRICKS);
            entries.accept(HERRINGBONE_CHARRED_BRICKS);

            addBssw(entries, ROUGH_SANDSTONE);
            addBssw(entries, SANDSTONE_BRICKS);
            addBssw(entries, SMALL_SANDSTONE_BRICKS);
            entries.accept(SANDSTONE_PILLAR);
            entries.accept(GOLD_DECORATED_SANDSTONE);
            entries.accept(LAPIS_DECORATED_SANDSTONE);

            addBssw(entries, ROUGH_RED_SANDSTONE);
            addBssw(entries, RED_SANDSTONE_BRICKS);
            addBssw(entries, SMALL_RED_SANDSTONE_BRICKS);
            entries.accept(RED_SANDSTONE_PILLAR);
            entries.accept(GOLD_DECORATED_RED_SANDSTONE);
            entries.accept(LAPIS_DECORATED_RED_SANDSTONE);

            addBssw(entries, SOUL_SANDSTONE);
            addBssw(entries, ROUGH_SOUL_SANDSTONE);
            addBssw(entries, SMOOTH_SOUL_SANDSTONE);
            addBssw(entries, SOUL_SANDSTONE_BRICKS);
            addBssw(entries, SMALL_SOUL_SANDSTONE_BRICKS);
            entries.accept(CHISELED_SOUL_SANDSTONE);
            entries.accept(CUT_SOUL_SANDSTONE);
            entries.accept(CUT_SOUL_SANDSTONE_SLAB);
            entries.accept(SOUL_SANDSTONE_PILLAR);
            entries.accept(GOLD_DECORATED_SOUL_SANDSTONE);
            entries.accept(LAPIS_DECORATED_SOUL_SANDSTONE);

            entries.accept(PRISMARINE_CIRCULAR_PAVING);
            entries.accept(CHISELED_DARK_PRISMARINE);
            entries.accept(DARK_PRISMARINE_PILLAR);
            entries.accept(CHISELED_PRISMARINE);
            entries.accept(PRISMARINE_PILLAR);
            addBssw(entries, PRISMARINE_TILES);

            addBssw(entries, OBSIDIAN_BRICKS);
            entries.accept(CRACKED_OBSIDIAN_BRICKS);
            addBssw(entries, SMALL_OBSIDIAN_BRICKS);
            entries.accept(OBSIDIAN_PILLAR);
            entries.accept(OBSIDIAN_CIRCULAR_PAVING);
            entries.accept(OBSIDIAN_REINFORCED_DOOR);
            entries.accept(OBSIDIAN_REINFORCED_TRAPDOOR);
            entries.accept(GLOWING_OBSIDIAN);

            addBssw(entries, POLISHED_NETHERRACK);
            entries.accept(POLISHED_NETHERRACK_PRESSURE_PLATE);
            entries.accept(POLISHED_NETHERRACK_BUTTON);
            addBssw(entries, NETHERRACK_BRICKS);
            entries.accept(NETHERRACK_CIRCULAR_PAVING);

            addBssw(entries, MAGMA_BRICKS);
            addBssw(entries, SMALL_MAGMA_BRICKS);
            entries.accept(CHISELED_MAGMA_BRICKS);

            addBssw(entries, CRIMSON_WART_BRICKS);
            addBssw(entries, WARPED_WART_BRICKS);

            addBssw(entries, NETHER_TILES);

            addBssw(entries, POLISHED_NETHER_BRICKS);
            entries.accept(HERRINGBONE_NETHER_BRICKS);
            entries.accept(NETHER_BRICK_PILLAR);
            addBssw(entries, POLISHED_RED_NETHER_BRICKS);
            entries.accept(HERRINGBONE_RED_NETHER_BRICKS);
            entries.accept(RED_NETHER_BRICK_PILLAR);
            addBssw(entries, CHARRED_NETHER_BRICKS);
            addBssw(entries, POLISHED_CHARRED_NETHER_BRICKS);
            entries.accept(HERRINGBONE_CHARRED_NETHER_BRICKS);
            entries.accept(CHARRED_NETHER_BRICK_PILLAR);
            addBssw(entries, TEAL_NETHER_BRICKS);
            addBssw(entries, POLISHED_TEAL_NETHER_BRICKS);
            entries.accept(HERRINGBONE_TEAL_NETHER_BRICKS);
            entries.accept(TEAL_NETHER_BRICK_PILLAR);

            entries.accept(BLAZE_LANTERN);
            addBssw(entries, BLAZE_BRICKS);
            entries.accept(BLAZE_PILLAR);

            addBssw(entries, ROUGH_BASALT);
            addBssw(entries, POLISHED_BASALT_BRICKS);
            entries.accept(POLISHED_BASALT_PRESSURE_PLATE);
            entries.accept(POLISHED_BASALT_BUTTON);
            entries.accept(CHISELED_POLISHED_BASALT);
            entries.accept(CRACKED_POLISHED_BASALT_BRICKS);
            entries.accept(POLISHED_BASALT_PILLAR);
            entries.accept(HERRINGBONE_POLISHED_BASALT_BRICKS);
            entries.accept(POLISHED_BASALT_CIRCULAR_PAVING);

            addBssw(entries, POLISHED_BLACKSTONE_TILES);
            entries.accept(POLISHED_BLACKSTONE_PILLAR);
            entries.accept(HERRINGBONE_POLISHED_BLACKSTONE_BRICKS);
            entries.accept(POLISHED_BLACKSTONE_CIRCULAR_PAVING);
            addBssw(entries, CRIMSON_WARTY_BLACKSTONE_BRICKS);
            addBssw(entries, WARPED_WARTY_BLACKSTONE_BRICKS);
            entries.accept(BLACKSTONE_DOOR);
            entries.accept(BLACKSTONE_TRAPDOOR);
            entries.accept(GOLD_DECORATED_POLISHED_BLACKSTONE);
            entries.accept(STURDY_BLACKSTONE);

            addBssw(entries, LAVA_POLISHED_BLACKSTONE_BRICKS);
            entries.accept(CHISELED_LAVA_POLISHED_BLACKSTONE);

            entries.accept(CHISELED_END_STONE_BRICKS);
            entries.accept(HERRINGBONE_END_STONE_BRICKS);
            addBssw(entries, POLISHED_END_STONE);
            entries.accept(POLISHED_END_STONE_PRESSURE_PLATE);
            entries.accept(POLISHED_END_STONE_BUTTON);
            entries.accept(CRACKED_END_STONE_BRICKS);
            entries.accept(END_STONE_PILLAR);
            addBssw(entries, SMALL_END_STONE_BRICKS);

            entries.accept(PURPUR_DECORATED_END_STONE);
            entries.accept(PHANTOM_PURPUR_DECORATED_END_STONE);

            addBssw(entries, END_TILES);
            addBssw(entries, PURPUR_BRICKS);
            addBssw(entries, POLISHED_PURPUR);
            entries.accept(PURPUR_SQUARES);
            addBssw(entries, SMALL_PURPUR_BRICKS);
            entries.accept(CHISELED_PURPUR);
            entries.accept(PURPUR_LINES);

            addBssw(entries, PHANTOM_PURPUR_BLOCK);
            entries.accept(PHANTOM_PURPUR_PILLAR);
            addBssw(entries, PHANTOM_PURPUR_BRICKS);
            addBssw(entries, POLISHED_PHANTOM_PURPUR);
            entries.accept(PHANTOM_PURPUR_SQUARES);
            addBssw(entries, SMALL_PHANTOM_PURPUR_BRICKS);
            entries.accept(CHISELED_PHANTOM_PURPUR);
            entries.accept(PHANTOM_PURPUR_LINES);

            entries.accept(LANTERN_BLOCK);
            entries.accept(SOUL_LANTERN_BLOCK);
            entries.accept(AMETHYST_LANTERN_BLOCK);

            entries.accept(CAUTION_BLOCK);
            entries.accept(CAUTION_BARRIER);
            entries.accept(ROAD_BARRIER);

            addBssw(entries, IRON_PLATING);
            entries.accept(IRON_GATE);

            addBssw(entries, GOLD_PLATING);
            entries.accept(GOLDEN_BARS);
            entries.accept(GOLDEN_CHAIN);
            entries.accept(GOLDEN_GATE);

            addBssw(entries, IRON_BRICKS);
            addBssw(entries, GOLD_BRICKS);
            addBssw(entries, REDSTONE_BRICKS);
            addBssw(entries, EMERALD_BRICKS);
            addBssw(entries, LAPIS_BRICKS);
            addBssw(entries, DIAMOND_BRICKS);
            addBssw(entries, NETHERITE_BRICKS);

            entries.accept(NETHERITE_STAIRS);
            entries.accept(NETHERITE_SLAB);


            for (CopperBundle copperBundle : CopperBundle.values()) {
                for (Block block : copperBundle.all()) {
                    entries.accept(block);
                }
            }

            entries.accept(CHARCOAL_BLOCK);
            entries.accept(ENDER_BLOCK);
            entries.accept(NETHER_STAR_BLOCK);


            addBssw(entries, QUARTZ_TILES);
            entries.accept(QUARTZ_CIRCULAR_PAVING);

            addBssw(entries, POLISHED_AMETHYST);
            addBssw(entries, AMETHYST_BRICKS);
            entries.accept(CHISELED_AMETHYST);
            entries.accept(AMETHYST_PILLAR);

            addBssw(entries, CHOCOLATE_BLOCK);
            addBssw(entries, CHOCOLATE_BRICKS);
            entries.accept(CHOCOLATE_SQUARES);
            entries.accept(CHOCOLATE_TABLET);

            entries.accept(ROTTEN_FLESH_BLOCK);
            entries.accept(CHORUS_BLOCK);
            entries.accept(SUGAR_BLOCK);
            entries.accept(COOKIE_BLOCK);
            entries.accept(SWEET_BERRIES_CRATE);
            entries.accept(SALMON_CRATE);
            entries.accept(PUFFERFISH_CRATE);
            entries.accept(TROPICAL_FISH_CRATE);
            entries.accept(COD_CRATE);
            entries.accept(POTATO_CRATE);
            entries.accept(APPLE_CRATE);
            entries.accept(BEETROOT_CRATE);
            entries.accept(CARROT_CRATE);
            entries.accept(BREAD_BOX);
            entries.accept(GOLDEN_APPLE_CRATE);
            entries.accept(GOLDEN_CARROT_CRATE);
            entries.accept(GLOW_BERRIES_CRATE);
           /* if (FabricLoader.getInstance().isModLoaded("promenade")) {
                entries.add(BlockusPromenadeBlocks.BLUEBERRIES_CRATE);
            }*/

            entries.accept(RAINBOW_BLOCK);
            addBssw(entries, RAINBOW_BRICKS);
            entries.accept(RAINBOW_GLOWSTONE);

            entries.accept(WEIGHT_STORAGE_CUBE);
            entries.accept(COMPANION_CUBE);
            entries.accept(LOVE_BLOCK);
            entries.accept(STARS_BLOCK);
        });
    }

    public static void addBssw(FabricItemGroupEntries entries, BSSWBundle bsswBundle) {
        // Block, stairs & slab & wall (if exist) variants of a block
        for (Block block : bsswBundle.all()) {
            entries.accept(block);
        }
    }

    public static void add(FabricItemGroupEntries entries, Collection<Block> blocks) {
        for (Block block : blocks) {
            entries.accept(block);
        }
    }
}
