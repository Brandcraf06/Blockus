package com.brand.blockus.data.provider;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.tag.BlockusItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BlockusItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public BlockusItemTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    private FabricTagBuilder<Item> getOrCreateTagBuilder(Identifier id) {
        Tag.Identified<Item> tag = TagFactory.ITEM.create(id);
        return this.getOrCreateTagBuilder(tag);
    }

    @Override
    protected void generateTags() {
        this.getOrCreateTagBuilder(BlockusItemTags.BARRELS)
            .add(BlockusBlocks.OAK_BARREL.asItem())
            .add(Items.BARREL)
            .add(BlockusBlocks.BIRCH_BARREL.asItem())
            .add(BlockusBlocks.JUNGLE_BARREL.asItem())
            .add(BlockusBlocks.ACACIA_BARREL.asItem())
            .add(BlockusBlocks.DARK_OAK_BARREL.asItem())
            .add(BlockusBlocks.CRIMSON_BARREL.asItem())
            .add(BlockusBlocks.WARPED_BARREL.asItem())
            .add(BlockusBlocks.BAMBOO_BARREL.asItem())
            .add(BlockusBlocks.CHARRED_BARREL.asItem())
            .add(BlockusBlocks.WHITE_OAK_BARREL.asItem());

        this.getOrCreateTagBuilder(BlockusItemTags.BARRIERS)
            .add(BlockusItems.CAUTION_BARRIER_BLOCK)
            .add(BlockusItems.ROAD_BARRIER_BLOCK);

        this.getOrCreateTagBuilder(BlockusItemTags.BLOCKUS_BARRELS)
            .add(BlockusBlocks.OAK_BARREL.asItem())
            .add(BlockusBlocks.BIRCH_BARREL.asItem())
            .add(BlockusBlocks.JUNGLE_BARREL.asItem())
            .add(BlockusBlocks.ACACIA_BARREL.asItem())
            .add(BlockusBlocks.DARK_OAK_BARREL.asItem())
            .add(BlockusBlocks.CRIMSON_BARREL.asItem())
            .add(BlockusBlocks.WARPED_BARREL.asItem())
            .add(BlockusBlocks.BAMBOO_BARREL.asItem())
            .add(BlockusBlocks.CHARRED_BARREL.asItem())
            .add(BlockusBlocks.WHITE_OAK_BARREL.asItem());

        this.getOrCreateTagBuilder(BlockusItemTags.PATTERNED_WOOL)
            .add(BlockusItems.WHITE_PATTERNED_WOOL)
            .add(BlockusItems.ORANGE_PATTERNED_WOOL)
            .add(BlockusItems.MAGENTA_PATTERNED_WOOL)
            .add(BlockusItems.LIGHT_BLUE_PATTERNED_WOOL)
            .add(BlockusItems.YELLOW_PATTERNED_WOOL)
            .add(BlockusItems.LIME_PATTERNED_WOOL)
            .add(BlockusItems.PINK_PATTERNED_WOOL)
            .add(BlockusItems.GRAY_PATTERNED_WOOL)
            .add(BlockusItems.LIGHT_GRAY_PATTERNED_WOOL)
            .add(BlockusItems.CYAN_PATTERNED_WOOL)
            .add(BlockusItems.PURPLE_PATTERNED_WOOL)
            .add(BlockusItems.BLUE_PATTERNED_WOOL)
            .add(BlockusItems.BROWN_PATTERNED_WOOL)
            .add(BlockusItems.GREEN_PATTERNED_WOOL)
            .add(BlockusItems.RED_PATTERNED_WOOL)
            .add(BlockusItems.BLACK_PATTERNED_WOOL);

        this.getOrCreateTagBuilder(BlockusItemTags.SMALL_HEDGES)
            .add(BlockusItems.OAK_SMALL_HEDGE)
            .add(BlockusItems.SPRUCE_SMALL_HEDGE)
            .add(BlockusItems.BIRCH_SMALL_HEDGE)
            .add(BlockusItems.JUNGLE_SMALL_HEDGE)
            .add(BlockusItems.ACACIA_SMALL_HEDGE)
            .add(BlockusItems.DARK_OAK_SMALL_HEDGE)
            .add(BlockusItems.WHITE_OAK_SMALL_HEDGE)
            .add(BlockusItems.CRIMSON_SMALL_HEDGE)
            .add(BlockusItems.WARPED_SMALL_HEDGE)
            .add(BlockusItems.AZALEA_SMALL_HEDGE)
            .add(BlockusItems.FLOWERING_AZALEA_SMALL_HEDGE)
            .add(BlockusItems.MOSS_SMALL_HEDGE)
            .addOptional(new Identifier(Blockus.MOD_ID, "autumn_oak_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "autumn_birch_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "pink_cherry_oak_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "white_cherry_oak_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "palm_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "dark_amaranth_small_hedge"));

        this.getOrCreateTagBuilder(BlockusItemTags.SOUL_SOILS)
            .add(Items.SOUL_SAND)
            .add(Items.SOUL_SOIL);

        this.getOrCreateTagBuilder(BlockusItemTags.STAINED_STONE_BRICKS)
            .add(BlockusItems.WHITE_STONE_BRICKS)
            .add(BlockusItems.ORANGE_STONE_BRICKS)
            .add(BlockusItems.MAGENTA_STONE_BRICKS)
            .add(BlockusItems.LIGHT_BLUE_STONE_BRICKS)
            .add(BlockusItems.YELLOW_STONE_BRICKS)
            .add(BlockusItems.LIME_STONE_BRICKS)
            .add(BlockusItems.PINK_STONE_BRICKS)
            .add(BlockusItems.GRAY_STONE_BRICKS)
            .add(Items.STONE_BRICKS)
            .add(BlockusItems.CYAN_STONE_BRICKS)
            .add(BlockusItems.PURPLE_STONE_BRICKS)
            .add(BlockusItems.BLUE_STONE_BRICKS)
            .add(BlockusItems.BROWN_STONE_BRICKS)
            .add(BlockusItems.GREEN_STONE_BRICKS)
            .add(BlockusItems.RED_STONE_BRICKS)
            .add(BlockusItems.BLACK_STONE_BRICKS);

        this.getOrCreateTagBuilder(BlockusItemTags.WARPED_NETHER_GRASS)
            .add(Items.NETHER_SPROUTS)
            .add(Items.WARPED_ROOTS);

        this.getOrCreateTagBuilder(BlockusItemTags.WHITE_OAK_LOGS)
            .add(BlockusItems.WHITE_OAK_LOG)
            .add(BlockusItems.WHITE_OAK_WOOD)
            .add(BlockusItems.STRIPPED_WHITE_OAK_LOG)
            .add(BlockusItems.STRIPPED_WHITE_OAK_WOOD)
            .add(BlockusItems.WHITE_OAK_SMALL_LOGS);

        this.getOrCreateTagBuilder(new Identifier("c", "planks_that_burn"))
            .add(Items.OAK_PLANKS)
            .add(Items.SPRUCE_PLANKS)
            .add(Items.BIRCH_PLANKS)
            .add(Items.JUNGLE_PLANKS)
            .add(Items.ACACIA_PLANKS)
            .add(Items.DARK_OAK_PLANKS)
            .add(BlockusItems.BAMBOO_PLANKS)
            .add(BlockusItems.WHITE_OAK_PLANKS);

        this.getOrCreateTagBuilder(new Identifier("c", "purpur_blocks"))
            .add(BlockusItems.PURPUR_BRICKS)
            .add(BlockusItems.POLISHED_PURPUR)
            .add(BlockusItems.PURPUR_SQUARES)
            .add(BlockusItems.SMALL_PURPUR_BRICKS)
            .add(BlockusItems.CHISELED_PURPUR)
            .add(BlockusItems.PURPUR_LINES)
            .add(BlockusItems.PHANTOM_PURPUR_BLOCK)
            .add(BlockusItems.PHANTOM_PURPUR_PILLAR)
            .add(BlockusItems.PHANTOM_PURPUR_BRICKS)
            .add(BlockusItems.POLISHED_PHANTOM_PURPUR)
            .add(BlockusItems.PHANTOM_PURPUR_SQUARES)
            .add(BlockusItems.SMALL_PHANTOM_PURPUR_BRICKS)
            .add(BlockusItems.CHISELED_PHANTOM_PURPUR)
            .add(BlockusItems.PHANTOM_PURPUR_LINES);

        this.getOrCreateTagBuilder(new Identifier("c", "quartz_blocks"))
            .add(BlockusItems.QUARTZ_TILES)
            .add(BlockusItems.QUARTZ_CIRCLE_PAVEMENT);

        this.getOrCreateTagBuilder(new Identifier("c", "red_sandstones"))
            .add(BlockusItems.RED_SANDSTONE_BRICKS)
            .add(BlockusItems.SMALL_RED_SANDSTONE_BRICKS)
            .add(BlockusItems.ROUGH_RED_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_RED_SANDSTONE)
            .add(BlockusItems.RED_SANDSTONE_PILLAR);

        this.getOrCreateTagBuilder(new Identifier("c", "wooden_barrels"))
            .addTag(BlockusItemTags.BARRELS);

        this.getOrCreateTagBuilder(new Identifier("c", "yellow_sandstones"))
            .add(BlockusItems.SANDSTONE_BRICKS)
            .add(BlockusItems.SMALL_SANDSTONE_BRICKS)
            .add(BlockusItems.ROUGH_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_SANDSTONE)
            .add(BlockusItems.LAPIS_DECORATED_SANDSTONE)
            .add(BlockusItems.SANDSTONE_PILLAR);

        this.getOrCreateTagBuilder(new Identifier("columns", "columns"))
            .addOptional(new Identifier(Blockus.MOD_ID, "andesite_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "blaze_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "bluestone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "bluestone_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "bluestone_tile_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "charred_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "charred_nether_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "crimson_warty_blackstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "diorite_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "dripstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_end_stone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "granite_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "honeycomb_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "ice_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "large_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "lava_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "lava_polished_blackstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "limestone_tile_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_limestone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "limestone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "limestone_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_magma_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "magma_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "marble_tile_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_marble_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "marble_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "marble_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "netherrack_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "obsidian_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_obsidian_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "quartz_tile_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_phantom_purpur_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "phantom_purpur_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "polished_basalt_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "purpur_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_purpur_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "rainbow_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "red_sandstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "sandstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "sandy_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_bluestone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_red_sandstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_sandstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_soul_sandstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "snow_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "soaked_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "soul_sandstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "soul_sandstone_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "teal_nether_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "tuff_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "warped_warty_blackstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "water_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "mossy_deepslate_brick_column"));

        this.getOrCreateTagBuilder(ItemTags.ACACIA_LOGS)
            .add(BlockusItems.ACACIA_SMALL_LOGS);

        this.getOrCreateTagBuilder(ItemTags.BIRCH_LOGS)
            .add(BlockusItems.BIRCH_SMALL_LOGS);

        this.getOrCreateTagBuilder(ItemTags.BUTTONS)
            .add(BlockusItems.POLISHED_ANDESITE_BUTTON)
            .add(BlockusItems.POLISHED_DIORITE_BUTTON)
            .add(BlockusItems.POLISHED_GRANITE_BUTTON)
            .add(BlockusItems.LIMESTONE_BUTTON)
            .add(BlockusItems.MARBLE_BUTTON)
            .add(BlockusItems.BLUESTONE_BUTTON)
            .add(BlockusItems.POLISHED_NETHERRACK_BUTTON)
            .add(BlockusItems.POLISHED_END_STONE_BUTTON);

        this.getOrCreateTagBuilder(ItemTags.CRIMSON_STEMS)
            .add(BlockusItems.CRIMSON_SMALL_STEMS);

        this.getOrCreateTagBuilder(ItemTags.DARK_OAK_LOGS)
            .add(BlockusItems.DARK_OAK_SMALL_LOGS);

        this.getOrCreateTagBuilder(ItemTags.DOORS)
            .add(BlockusItems.PAPER_DOOR)
            .add(BlockusItems.OBSIDIAN_REINFORCED_DOOR)
            .add(BlockusItems.STONE_DOOR)
            .add(BlockusItems.BLACKSTONE_DOOR);

        this.getOrCreateTagBuilder(ItemTags.FLOWERS)
            .add(BlockusItems.FLOWERING_AZALEA_SMALL_HEDGE);

        this.getOrCreateTagBuilder(new Identifier("minecraft", "ice"))
            .add(Items.ICE)
            .add(Items.PACKED_ICE)
            .add(Items.BLUE_ICE);

        this.getOrCreateTagBuilder(ItemTags.JUNGLE_LOGS)
            .add(BlockusItems.JUNGLE_SMALL_LOGS);

        this.getOrCreateTagBuilder(ItemTags.LEAVES)
            .add(BlockusItems.WHITE_OAK_LEAVES);

        this.getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
            .addTag(BlockusItemTags.WHITE_OAK_LOGS);

        this.getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
            .add(BlockusItems.CHARRED_PLANKS)
            .add(BlockusItems.CHARRED_SLAB)
            .add(BlockusItems.CHARRED_PRESSURE_PLATE)
            .add(BlockusItems.CHARRED_FENCE)
            .add(BlockusItems.CHARRED_TRAPDOOR)
            .add(BlockusItems.CHARRED_FENCE_GATE)
            .add(BlockusItems.CHARRED_STAIRS)
            .add(BlockusItems.CHARRED_BUTTON)
            .add(BlockusItems.CHARRED_DOOR)
            .add(BlockusItems.WARPED_SMALL_STEMS)
            .add(BlockusItems.CRIMSON_SMALL_STEMS);

        this.getOrCreateTagBuilder(ItemTags.OAK_LOGS)
            .add(BlockusItems.OAK_SMALL_LOGS);

        this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
            .add(BlockusItems.LEGACY_GOLD_BLOCK)
            .add(BlockusItems.EXPLOSION_PROOF_LEGACY_GOLD_BLOCK)
            .add(BlockusItems.GOLDEN_CHAIN)
            .add(BlockusItems.GOLDEN_BARS)
            .add(BlockusItems.GOLDEN_GATE)
            .add(BlockusItems.GOLD_DECORATED_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_RED_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_SOUL_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_POLISHED_BLACKSTONE)
            .add(BlockusItems.GOLD_PLATING)
            .add(BlockusItems.GOLD_PLATING_STAIRS)
            .add(BlockusItems.GOLD_PLATING_SLAB)
            .add(BlockusItems.GOLDEN_APPLE_CRATE)
            .add(BlockusItems.GOLDEN_CARROT_CRATE);

        this.getOrCreateTagBuilder(ItemTags.PIGLIN_REPELLENTS)
            .add(BlockusItems.SOUL_LANTERN_BLOCK)
            .add(BlockusItems.SOUL_O_LANTERN);

        this.getOrCreateTagBuilder(ItemTags.PLANKS)
            .add(BlockusItems.BAMBOO_PLANKS)
            .add(BlockusItems.CHARRED_PLANKS)
            .add(BlockusItems.WHITE_OAK_PLANKS);

        this.getOrCreateTagBuilder(ItemTags.SAPLINGS)
            .add(BlockusItems.WHITE_OAK_SAPLING);

        this.getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
            .add(BlockusItems.RAINBOW_ROSE);

        this.getOrCreateTagBuilder(ItemTags.SPRUCE_LOGS)
            .add(BlockusItems.SPRUCE_SMALL_LOGS);

        this.getOrCreateTagBuilder(ItemTags.TRAPDOORS)
            .add(BlockusItems.PAPER_TRAPDOOR)
            .add(BlockusItems.OBSIDIAN_REINFORCED_TRAPDOOR)
            .add(BlockusItems.STONE_TRAPDOOR)
            .add(BlockusItems.BLACKSTONE_TRAPDOOR);

        this.getOrCreateTagBuilder(ItemTags.WALLS)
            .add(BlockusItems.BLAZE_BRICK_WALL)
            .add(BlockusItems.LAVA_BRICK_WALL)
            .add(BlockusItems.SOUL_SANDSTONE_WALL)
            .add(BlockusItems.CHARRED_NETHER_BRICK_WALL)
            .add(BlockusItems.SOAKED_BRICK_WALL)
            .add(BlockusItems.MAGMA_BRICK_WALL)
            .add(BlockusItems.NETHERRACK_BRICK_WALL)
            .add(BlockusItems.SMALL_MAGMA_BRICK_WALL)
            .add(BlockusItems.LIMESTONE_BRICK_WALL)
            .add(BlockusItems.SMALL_LIMESTONE_BRICK_WALL)
            .add(BlockusItems.OBSIDIAN_BRICK_WALL)
            .add(BlockusItems.SMALL_OBSIDIAN_BRICK_WALL)
            .add(BlockusItems.RAINBOW_BRICK_WALL)
            .add(BlockusItems.WATER_BRICK_WALL)
            .add(BlockusItems.MARBLE_BRICK_WALL)
            .add(BlockusItems.SMALL_MARBLE_BRICK_WALL)
            .add(BlockusItems.HONEYCOMB_BRICK_WALL)
            .add(BlockusItems.SANDY_BRICK_WALL)
            .add(BlockusItems.CHARRED_BRICK_WALL)
            .add(BlockusItems.TEAL_NETHER_BRICK_WALL)
            .add(BlockusItems.LAVA_POLISHED_BLACKSTONE_WALL)
            .add(BlockusItems.CRIMSON_WARTY_BLACKSTONE_BRICK_WALL)
            .add(BlockusItems.WARPED_WARTY_BLACKSTONE_BRICK_WALL)
            .add(BlockusItems.SNOW_BRICK_WALL)
            .add(BlockusItems.ICE_BRICK_WALL)
            .add(BlockusItems.POLISHED_BASALT_BRICK_WALL)
            .add(BlockusItems.BLUESTONE_BRICK_WALL)
            .add(BlockusItems.SMALL_BLUESTONE_BRICK_WALL)
            .add(BlockusItems.PURPUR_BRICK_WALL)
            .add(BlockusItems.SMALL_PURPUR_BRICK_WALL)
            .add(BlockusItems.ANDESITE_BRICK_WALL)
            .add(BlockusItems.DIORITE_BRICK_WALL)
            .add(BlockusItems.GRANITE_BRICK_WALL)
            .add(BlockusItems.LIMESTONE_WALL)
            .add(BlockusItems.LIMESTONE_TILE_WALL)
            .add(BlockusItems.MARBLE_WALL)
            .add(BlockusItems.MARBLE_TILE_WALL)
            .add(BlockusItems.BLUESTONE_WALL)
            .add(BlockusItems.BLUESTONE_TILE_WALL)
            .add(BlockusItems.SANDSTONE_BRICK_WALL)
            .add(BlockusItems.SMALL_SANDSTONE_BRICK_WALL)
            .add(BlockusItems.RED_SANDSTONE_BRICK_WALL)
            .add(BlockusItems.SMALL_RED_SANDSTONE_BRICK_WALL)
            .add(BlockusItems.SOUL_SANDSTONE_BRICK_WALL)
            .add(BlockusItems.SMALL_SOUL_SANDSTONE_BRICK_WALL)
            .add(BlockusItems.PURPUR_BRICK_WALL)
            .add(BlockusItems.PHANTOM_PURPUR_BRICK_WALL)
            .add(BlockusItems.SMALL_PHANTOM_PURPUR_BRICK_WALL)
            .add(BlockusItems.QUARTZ_TILE_WALL)
            .add(BlockusItems.LARGE_BRICK_WALL)
            .add(BlockusItems.MOSSY_DEEPSLATE_BRICK_WALL)
            .add(BlockusItems.DRIPSTONE_BRICK_WALL)
            .add(BlockusItems.TUFF_BRICK_WALL)
            .add(BlockusItems.SMALL_END_STONE_BRICK_WALL)
            .add(BlockusItems.WHITE_STONE_BRICK_WALL)
            .add(BlockusItems.ORANGE_STONE_BRICK_WALL)
            .add(BlockusItems.MAGENTA_STONE_BRICK_WALL)
            .add(BlockusItems.LIGHT_BLUE_STONE_BRICK_WALL)
            .add(BlockusItems.YELLOW_STONE_BRICK_WALL)
            .add(BlockusItems.LIME_STONE_BRICK_WALL)
            .add(BlockusItems.PINK_STONE_BRICK_WALL)
            .add(BlockusItems.GRAY_STONE_BRICK_WALL)
            .add(BlockusItems.CYAN_STONE_BRICK_WALL)
            .add(BlockusItems.PURPLE_STONE_BRICK_WALL)
            .add(BlockusItems.BLUE_STONE_BRICK_WALL)
            .add(BlockusItems.BROWN_STONE_BRICK_WALL)
            .add(BlockusItems.GREEN_STONE_BRICK_WALL)
            .add(BlockusItems.RED_STONE_BRICK_WALL)
            .add(BlockusItems.BLACK_STONE_BRICK_WALL)
            .addTag(BlockusItemTags.BARRIERS);

        this.getOrCreateTagBuilder(ItemTags.WARPED_STEMS)
            .add(BlockusItems.WARPED_SMALL_STEMS);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
            .add(BlockusItems.BAMBOO_BUTTON)
            .add(BlockusItems.CHARRED_BUTTON)
            .add(BlockusItems.WHITE_OAK_BUTTON);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
            .add(BlockusItems.BAMBOO_DOOR)
            .add(BlockusItems.CHARRED_DOOR)
            .add(BlockusItems.WHITE_OAK_DOOR);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
            .add(BlockusItems.BAMBOO_FENCE)
            .add(BlockusItems.CHARRED_FENCE)
            .add(BlockusItems.WHITE_OAK_FENCE);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
            .add(BlockusItems.BAMBOO_PRESSURE_PLATE)
            .add(BlockusItems.CHARRED_PRESSURE_PLATE)
            .add(BlockusItems.WHITE_OAK_PRESSURE_PLATE);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
            .add(BlockusItems.BAMBOO_SLAB)
            .add(BlockusItems.CHARRED_SLAB)
            .add(BlockusItems.WHITE_OAK_SLAB);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
            .add(BlockusItems.BAMBOO_STAIRS)
            .add(BlockusItems.CHARRED_STAIRS)
            .add(BlockusItems.WHITE_OAK_STAIRS);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
            .add(BlockusItems.BAMBOO_TRAPDOOR)
            .add(BlockusItems.CHARRED_TRAPDOOR)
            .add(BlockusItems.WHITE_OAK_TRAPDOOR);

        this.getOrCreateTagBuilder(ItemTags.WOOL)
            .addTag(BlockusItemTags.PATTERNED_WOOL);

        this.getOrCreateTagBuilder(new Identifier("promenade", "cherry_oak_logs"))
            .addOptional(new Identifier(Blockus.MOD_ID, "cherry_oak_small_logs"));

        this.getOrCreateTagBuilder(new Identifier("promenade", "dark_amaranth_stems"))
            .addOptional(new Identifier(Blockus.MOD_ID, "dark_amaranth_small_stems"));

        this.getOrCreateTagBuilder(new Identifier("promenade", "palm_logs"))
            .addOptional(new Identifier(Blockus.MOD_ID, "palm_small_logs"));
    }
}
