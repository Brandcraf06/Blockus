package com.brand.blockus.datagen.providers;

import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.registry.effect.BlockusEffects;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BlockusLangEnProvider extends FabricLanguageProvider {
    public BlockusLangEnProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.add(BlockusEffects.ASPHALT_SPRINT.value(), "Asphalt Sprint");
        translationBuilder.add(BlockusItemGroups.BLOCKUS_BUILDING_BLOCKS, "Building Blocks");
        translationBuilder.add(BlockusItemGroups.BLOCKUS_COLORED_BLOCKS, "Colored Blocks");
        translationBuilder.add(BlockusItemGroups.BLOCKUS_COLORED_TILES, "Colored Tiles");
        translationBuilder.add(BlockusItemGroups.BLOCKUS_NATURAL, "Natural");
        translationBuilder.add(BlockusItemGroups.BLOCKUS_FUNCTIONAL_BLOCKS, "Functional Blocks");
        translationBuilder.add(BlockusItemGroups.BLOCKUS_LEGACY_BLOCKS, "Legacy Blocks");
        translationBuilder.add("blockitem.blockus.when_stepped_on", "When stepped on:");
        translationBuilder.add("blockitem.blockus.legacy", "Legacy");

        // Blaze
        addBssw(translationBuilder, BlockusBlocks.BLAZE_BRICKS, "Blaze Bricks");
        translationBuilder.add(BlockusBlocks.BLAZE_PILLAR, "Blaze Brick Pillar");
        translationBuilder.add(BlockusBlocks.BLAZE_LANTERN, "Blaze Lantern");

        // Sandstone
        addBssw(translationBuilder, BlockusBlocks.ROUGH_SANDSTONE, "Rough Sandstone");
        addBssw(translationBuilder, BlockusBlocks.SANDSTONE_BRICKS, "Sandstone Bricks");
        addBssw(translationBuilder, BlockusBlocks.SMALL_SANDSTONE_BRICKS, "Small Sandstone Bricks");
        translationBuilder.add(BlockusBlocks.SANDSTONE_PILLAR, "Sandstone Pillar");
        addBssw(translationBuilder, BlockusBlocks.ROUGH_RED_SANDSTONE, "Rough Red Sandstone");
        addBssw(translationBuilder, BlockusBlocks.RED_SANDSTONE_BRICKS, "Red Sandstone Bricks");
        addBssw(translationBuilder, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS, "Small Red Sandstone Bricks");
        translationBuilder.add(BlockusBlocks.RED_SANDSTONE_PILLAR, "Red Sandstone Pillar");
        addBssw(translationBuilder, BlockusBlocks.SOUL_SANDSTONE, "Soul Sandstone");
        addBssw(translationBuilder, BlockusBlocks.SMOOTH_SOUL_SANDSTONE, "Smooth Soul Sandstone");
        addBssw(translationBuilder, BlockusBlocks.ROUGH_SOUL_SANDSTONE, "Rough Soul Sandstone");
        addBssw(translationBuilder, BlockusBlocks.SOUL_SANDSTONE_BRICKS, "Soul Sandstone Bricks");
        addBssw(translationBuilder, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS, "Small Soul Sandstone Bricks");
        translationBuilder.add(BlockusBlocks.CUT_SOUL_SANDSTONE, "Cut Soul Sandstone");
        translationBuilder.add(BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, "Cut Soul Sandstone Slab");
        translationBuilder.add(BlockusBlocks.CHISELED_SOUL_SANDSTONE, "Chiseled Soul Sandstone");
        translationBuilder.add(BlockusBlocks.SOUL_SANDSTONE_PILLAR, "Soul Sandstone Pillar");
        translationBuilder.add(BlockusBlocks.LAPIS_DECORATED_SANDSTONE, "Lapis-Decorated Sandstone");
        translationBuilder.add(BlockusBlocks.LAPIS_DECORATED_RED_SANDSTONE, "Lapis-Decorated Red Sandstone");
        translationBuilder.add(BlockusBlocks.LAPIS_DECORATED_SOUL_SANDSTONE, "Lapis-Decorated Soul Sandstone");
        translationBuilder.add(BlockusBlocks.GOLD_DECORATED_SANDSTONE, "Gold-Decorated Sandstone");
        translationBuilder.add(BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE, "Gold-Decorated Red Sandstone");
        translationBuilder.add(BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE, "Gold-Decorated Soul Sandstone");

        // Paper Blocks
        translationBuilder.add(BlockusBlocks.PAPER_BLOCK, "Paper Block");
        translationBuilder.add(BlockusBlocks.BURNT_PAPER_BLOCK, "Burnt Paper Block");
        translationBuilder.add(BlockusBlocks.FRAMED_PAPER_BLOCK, "Framed Paper Block");
        translationBuilder.add(BlockusBlocks.PAPER_WALL, "Paper Wall");
        translationBuilder.add(BlockusBlocks.PAPER_DOOR, "Paper Door");
        translationBuilder.add(BlockusBlocks.PAPER_TRAPDOOR, "Paper Trapdoor");
        translationBuilder.add(BlockusBlocks.PAPER_LAMP, "Paper Lamp");

        // Stained Stone Bricks
        addBssw(translationBuilder, BlockusBlocks.WHITE_STONE_BRICKS, "White Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.ORANGE_STONE_BRICKS, "Orange Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.MAGENTA_STONE_BRICKS, "Magenta Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.LIGHT_BLUE_STONE_BRICKS, "Light Blue Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.YELLOW_STONE_BRICKS, "Yellow Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.LIME_STONE_BRICKS, "Lime Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.PINK_STONE_BRICKS, "Pink Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.GRAY_STONE_BRICKS, "Gray Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.CYAN_STONE_BRICKS, "Cyan Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.PURPLE_STONE_BRICKS, "Purple Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.BLUE_STONE_BRICKS, "Blue Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.BROWN_STONE_BRICKS, "Brown Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.GREEN_STONE_BRICKS, "Green Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.RED_STONE_BRICKS, "Red Stone Bricks");
        addBssw(translationBuilder, BlockusBlocks.BLACK_STONE_BRICKS, "Black Stone Bricks");

        // Shingles
        addBssw(translationBuilder, BlockusBlocks.SHINGLES, "Shingles");
        addBssw(translationBuilder, BlockusBlocks.WHITE_SHINGLES, "White Shingles");
        addBssw(translationBuilder, BlockusBlocks.ORANGE_SHINGLES, "Orange Shingles");
        addBssw(translationBuilder, BlockusBlocks.MAGENTA_SHINGLES, "Magenta Shingles");
        addBssw(translationBuilder, BlockusBlocks.LIGHT_BLUE_SHINGLES, "Light Blue Shingles");
        addBssw(translationBuilder, BlockusBlocks.YELLOW_SHINGLES, "Yellow Shingles");
        addBssw(translationBuilder, BlockusBlocks.LIME_SHINGLES, "Lime Shingles");
        addBssw(translationBuilder, BlockusBlocks.PINK_SHINGLES, "Pink Shingles");
        addBssw(translationBuilder, BlockusBlocks.LIGHT_GRAY_SHINGLES, "Light Gray Shingles");
        addBssw(translationBuilder, BlockusBlocks.GRAY_SHINGLES, "Gray Shingles");
        addBssw(translationBuilder, BlockusBlocks.CYAN_SHINGLES, "Cyan Shingles");
        addBssw(translationBuilder, BlockusBlocks.PURPLE_SHINGLES, "Purple Shingles");
        addBssw(translationBuilder, BlockusBlocks.BLUE_SHINGLES, "Blue Shingles");
        addBssw(translationBuilder, BlockusBlocks.BROWN_SHINGLES, "Brown Shingles");
        addBssw(translationBuilder, BlockusBlocks.GREEN_SHINGLES, "Green Shingles");
        addBssw(translationBuilder, BlockusBlocks.RED_SHINGLES, "Red Shingles");
        addBssw(translationBuilder, BlockusBlocks.BLACK_SHINGLES, "Black Shingles");

        // Concrete
        addConcrete(translationBuilder, BlockusBlocks.WHITE_CONCRETE_BRICKS, "White Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.ORANGE_CONCRETE_BRICKS, "Orange Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.MAGENTA_CONCRETE_BRICKS, "Magenta Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS, "Light Blue Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.YELLOW_CONCRETE_BRICKS, "Yellow Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.LIME_CONCRETE_BRICKS, "Lime Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.PINK_CONCRETE_BRICKS, "Pink Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.GRAY_CONCRETE_BRICKS, "Gray Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS, "Light Gray Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.CYAN_CONCRETE_BRICKS, "Cyan Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.PURPLE_CONCRETE_BRICKS, "Purple Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.BLUE_CONCRETE_BRICKS, "Blue Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.BROWN_CONCRETE_BRICKS, "Brown Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.GREEN_CONCRETE_BRICKS, "Green Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.RED_CONCRETE_BRICKS, "Red Concrete Bricks");
        addConcrete(translationBuilder, BlockusBlocks.BLACK_CONCRETE_BRICKS, "Black Concrete Bricks");

        // Basalt
        addBssw(translationBuilder, BlockusBlocks.ROUGH_BASALT, "Rough Basalt");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_BASALT_BRICKS, "Polished Basalt Bricks");
        translationBuilder.add(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS, "Cracked Polished Basalt Bricks");
        translationBuilder.add(BlockusBlocks.POLISHED_BASALT_PILLAR, "Polished Basalt Pillar");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_POLISHED_BASALT_BRICKS, "Herringbone Polished Basalt Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_POLISHED_BASALT, "Chiseled Polished Basalt");
        translationBuilder.add(BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE, "Polished Basalt Pressure Plate");
        translationBuilder.add(BlockusBlocks.POLISHED_BASALT_BUTTON, "Polished Basalt Button");

        // Prismarine
        translationBuilder.add(BlockusBlocks.DARK_PRISMARINE_PILLAR, "Dark Prismarine Pillar");
        translationBuilder.add(BlockusBlocks.CHISELED_DARK_PRISMARINE, "Chiseled Dark Prismarine");
        translationBuilder.add(BlockusBlocks.PRISMARINE_PILLAR, "Prismarine Pillar");
        translationBuilder.add(BlockusBlocks.CHISELED_PRISMARINE, "Chiseled Prismarine");
        addBssw(translationBuilder, BlockusBlocks.PRISMARINE_TILES, "Prismarine Tiles");

        // Blackstone
        addBssw(translationBuilder, BlockusBlocks.POLISHED_BLACKSTONE_TILES, "Polished Blackstone Tiles");
        addBssw(translationBuilder, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS, "Crimson Warty Blackstone Bricks");
        addBssw(translationBuilder, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS, "Warped Warty Blackstone Bricks");
        addBssw(translationBuilder, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS, "Lava Polished Blackstone Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_POLISHED_BLACKSTONE_BRICKS, "Herringbone Polished Blackstone Bricks");
        translationBuilder.add(BlockusBlocks.POLISHED_BLACKSTONE_PILLAR, "Polished Blackstone Pillar");
        translationBuilder.add(BlockusBlocks.POLISHED_BLACKSTONE_CIRCULAR_PAVING, "Polished Blackstone Circular Paving");
        translationBuilder.add(BlockusBlocks.CHISELED_LAVA_POLISHED_BLACKSTONE, "Chiseled Lava Polished Blackstone");
        translationBuilder.add(BlockusBlocks.STURDY_BLACKSTONE, "Sturdy Blackstone");
        translationBuilder.add(BlockusBlocks.BLACKSTONE_DOOR, "Blackstone Door");
        translationBuilder.add(BlockusBlocks.BLACKSTONE_TRAPDOOR, "Blackstone Trapdoor");
        translationBuilder.add(BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE, "Gold-Decorated Polished Blackstone");

        // Colored Tiles
        translationBuilder.add("block.blockus.colored_tiles", "Colored Tiles");
        translationBuilder.add(BlockusBlocks.WHITE_COLORED_TILES, "White Colored Tiles");
        translationBuilder.add(BlockusBlocks.ORANGE_COLORED_TILES, "Orange Colored Tiles");
        translationBuilder.add(BlockusBlocks.MAGENTA_COLORED_TILES, "Magenta Colored Tiles");
        translationBuilder.add(BlockusBlocks.LIGHT_BLUE_COLORED_TILES, "Light Blue Colored Tiles");
        translationBuilder.add(BlockusBlocks.YELLOW_COLORED_TILES, "Yellow Colored Tiles");
        translationBuilder.add(BlockusBlocks.LIME_COLORED_TILES, "Lime Colored Tiles");
        translationBuilder.add(BlockusBlocks.PINK_COLORED_TILES, "Pink Colored Tiles");
        translationBuilder.add(BlockusBlocks.GRAY_COLORED_TILES, "Gray Colored Tiles");
        translationBuilder.add(BlockusBlocks.LIGHT_GRAY_COLORED_TILES, "Light Gray Colored Tiles");
        translationBuilder.add(BlockusBlocks.CYAN_COLORED_TILES, "Cyan Colored Tiles");
        translationBuilder.add(BlockusBlocks.PURPLE_COLORED_TILES, "Purple Colored Tiles");
        translationBuilder.add(BlockusBlocks.BLUE_COLORED_TILES, "Blue Colored Tiles");
        translationBuilder.add(BlockusBlocks.BROWN_COLORED_TILES, "Brown Colored Tiles");
        translationBuilder.add(BlockusBlocks.GREEN_COLORED_TILES, "Green Colored Tiles");
        translationBuilder.add(BlockusBlocks.RED_COLORED_TILES, "Red Colored Tiles");
        translationBuilder.add(BlockusBlocks.BLACK_COLORED_TILES, "Black Colored Tiles");
        translationBuilder.add(BlockusBlocks.RAINBOW_COLORED_TILES, "Rainbow Colored Tiles");

        // Woods
        translationBuilder.add(BlockusBlocks.WHITE_OAK_SAPLING, "White Oak Sapling");
        translationBuilder.add(BlockusBlocks.POTTED_WHITE_OAK_SAPLING, "Potted White Oak Sapling");
        translationBuilder.add(BlockusBlocks.WHITE_OAK_LOG, "White Oak Log");
        translationBuilder.add(BlockusBlocks.STRIPPED_WHITE_OAK_LOG, "Stripped White Oak Log");
        translationBuilder.add(BlockusBlocks.WHITE_OAK_WOOD, "White Oak Wood");
        translationBuilder.add(BlockusBlocks.STRIPPED_WHITE_OAK_WOOD, "Stripped White Oak Wood");
        translationBuilder.add(BlockusBlocks.WHITE_OAK_LEAVES, "White Oak Leaves");
        addWoodBundle(translationBuilder, BlockusBlocks.WHITE_OAK, "White Oak Planks");
        translationBuilder.add(BlockusEntities.WHITE_OAK_BOAT.getItem(), "White Oak Boat");
        translationBuilder.add(BlockusEntities.WHITE_OAK_BOAT.getChestItem(), "White Oak Boat with Chest");
        addWoodBundle(translationBuilder, BlockusBlocks.RAW_BAMBOO, "Raw Bamboo Planks");
        translationBuilder.add(BlockusEntities.RAW_BAMBOO_RAFT.getItem(), "Raw Bamboo Raft");
        translationBuilder.add(BlockusEntities.RAW_BAMBOO_RAFT.getChestItem(), "Raw Bamboo Raft with Chest");
        addWoodBundle(translationBuilder, BlockusBlocks.CHARRED, "Charred Planks");
        translationBuilder.add(BlockusEntities.CHARRED_BOAT.getItem(), "Charred Boat");
        translationBuilder.add(BlockusEntities.CHARRED_BOAT.getChestItem(), "Charred Boat with Chest");

        // Small logs
        translationBuilder.add(BlockusBlocks.OAK_SMALL_LOGS, "Small Oak Logs");
        translationBuilder.add(BlockusBlocks.SPRUCE_SMALL_LOGS, "Small Spruce Logs");
        translationBuilder.add(BlockusBlocks.BIRCH_SMALL_LOGS, "Small Birch Logs");
        translationBuilder.add(BlockusBlocks.JUNGLE_SMALL_LOGS, "Small Jungle Logs");
        translationBuilder.add(BlockusBlocks.ACACIA_SMALL_LOGS, "Small Acacia Logs");
        translationBuilder.add(BlockusBlocks.DARK_OAK_SMALL_LOGS, "Small Dark Oak Logs");
        translationBuilder.add(BlockusBlocks.MANGROVE_SMALL_LOGS, "Small Mangrove Logs");
        translationBuilder.add(BlockusBlocks.CHERRY_SMALL_LOGS, "Small Cherry Logs");
        translationBuilder.add(BlockusBlocks.WHITE_OAK_SMALL_LOGS, "Small White Oak Logs");
        translationBuilder.add(BlockusBlocks.CRIMSON_SMALL_STEMS, "Small Crimson Stems");
        translationBuilder.add(BlockusBlocks.WARPED_SMALL_STEMS, "Small Warped Stems");

        // Wooden Posts
        addWoodenPost(translationBuilder, BlockusBlocks.OAK_POST, "Oak Post");
        addWoodenPost(translationBuilder, BlockusBlocks.SPRUCE_POST, "Spruce Post");
        addWoodenPost(translationBuilder, BlockusBlocks.BIRCH_POST, "Birch Post");
        addWoodenPost(translationBuilder, BlockusBlocks.JUNGLE_POST, "Jungle Post");
        addWoodenPost(translationBuilder, BlockusBlocks.ACACIA_POST, "Acacia Post");
        addWoodenPost(translationBuilder, BlockusBlocks.DARK_OAK_POST, "Dark Oak Post");
        addWoodenPost(translationBuilder, BlockusBlocks.MANGROVE_POST, "Mangrove Post");
        addWoodenPost(translationBuilder, BlockusBlocks.CHERRY_POST, "Cherry Post");
        addWoodenPost(translationBuilder, BlockusBlocks.WHITE_OAK_POST, "White Oak Post");
        addWoodenPost(translationBuilder, BlockusBlocks.CRIMSON_POST, "Crimson Post");
        addWoodenPost(translationBuilder, BlockusBlocks.WARPED_POST, "Warped Post");

        // Mosaics
        addBssw(translationBuilder, BlockusBlocks.RAW_BAMBOO_MOSAIC, "Raw Bamboo Mosaic");
        addBssw(translationBuilder, BlockusBlocks.OAK_MOSAIC, "Oak Mosaic");
        addBssw(translationBuilder, BlockusBlocks.SPRUCE_MOSAIC, "Spruce Mosaic");
        addBssw(translationBuilder, BlockusBlocks.BIRCH_MOSAIC, "Birch Mosaic");
        addBssw(translationBuilder, BlockusBlocks.JUNGLE_MOSAIC, "Jungle Mosaic");
        addBssw(translationBuilder, BlockusBlocks.ACACIA_MOSAIC, "Acacia Mosaic");
        addBssw(translationBuilder, BlockusBlocks.DARK_OAK_MOSAIC, "Dark Oak Mosaic");
        addBssw(translationBuilder, BlockusBlocks.CHERRY_MOSAIC, "Cherry Mosaic");
        addBssw(translationBuilder, BlockusBlocks.MANGROVE_MOSAIC, "Mangrove Mosaic");
        addBssw(translationBuilder, BlockusBlocks.WHITE_OAK_MOSAIC, "White Oak Mosaic");
        addBssw(translationBuilder, BlockusBlocks.WARPED_MOSAIC, "Warped Mosaic");
        addBssw(translationBuilder, BlockusBlocks.CRIMSON_MOSAIC, "Crimson Mosaic");
        addBssw(translationBuilder, BlockusBlocks.CHARRED_MOSAIC, "Charred Mosaic");

        // Mossy Planks
        addBssw(translationBuilder, BlockusBlocks.MOSSY_OAK_PLANKS, "Mossy Oak Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_SPRUCE_PLANKS, "Mossy Spruce Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_BIRCH_PLANKS, "Mossy Birch Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_JUNGLE_PLANKS, "Mossy Jungle Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_ACACIA_PLANKS, "Mossy Acacia Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_DARK_OAK_PLANKS, "Mossy Dark Oak Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_MANGROVE_PLANKS, "Mossy Mangrove Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_CHERRY_PLANKS, "Mossy Cherry Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_WHITE_OAK_PLANKS, "Mossy White Oak Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_BAMBOO_PLANKS, "Mossy Bamboo Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_RAW_BAMBOO_PLANKS, "Mossy Raw Bamboo Planks");
        addWoodenBss(translationBuilder, BlockusBlocks.MOSSY_CHARRED_PLANKS, "Mossy Charred Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_CRIMSON_PLANKS, "Mossy Crimson Planks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_WARPED_PLANKS, "Mossy Warped Planks");

        // Herringbone Planks
        translationBuilder.add(BlockusBlocks.HERRINGBONE_OAK_PLANKS, "Herringbone Oak Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_SPRUCE_PLANKS, "Herringbone Spruce Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_BIRCH_PLANKS, "Herringbone Birch Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_JUNGLE_PLANKS, "Herringbone Jungle Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_ACACIA_PLANKS, "Herringbone Acacia Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_DARK_OAK_PLANKS, "Herringbone Dark Oak Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_MANGROVE_PLANKS, "Herringbone Mangrove Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_CHERRY_PLANKS, "Herringbone Cherry Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_WHITE_OAK_PLANKS, "Herringbone White Oak Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_BAMBOO_PLANKS, "Herringbone Bamboo Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_RAW_BAMBOO_PLANKS, "Herringbone Raw Bamboo Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_CHARRED_PLANKS, "Herringbone Charred Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_CRIMSON_PLANKS, "Herringbone Crimson Planks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_WARPED_PLANKS, "Herringbone Warped Planks");

        // Timber Frames, Lattices & Wooden Grates
        addTimberFrame(translationBuilder, BlockusBlocks.OAK_TIMBER_FRAME, "Oak");
        addTimberFrame(translationBuilder, BlockusBlocks.SPRUCE_TIMBER_FRAME, "Spruce");
        addTimberFrame(translationBuilder, BlockusBlocks.BIRCH_TIMBER_FRAME, "Birch");
        addTimberFrame(translationBuilder, BlockusBlocks.JUNGLE_TIMBER_FRAME, "Jungle");
        addTimberFrame(translationBuilder, BlockusBlocks.ACACIA_TIMBER_FRAME, "Acacia");
        addTimberFrame(translationBuilder, BlockusBlocks.DARK_OAK_TIMBER_FRAME, "Dark Oak");
        addTimberFrame(translationBuilder, BlockusBlocks.MANGROVE_TIMBER_FRAME, "Mangrove");
        addTimberFrame(translationBuilder, BlockusBlocks.CHERRY_TIMBER_FRAME, "Cherry");
        addTimberFrame(translationBuilder, BlockusBlocks.CHARRED_TIMBER_FRAME, "Charred");
        addTimberFrame(translationBuilder, BlockusBlocks.WHITE_OAK_TIMBER_FRAME, "White Oak");
        addTimberFrame(translationBuilder, BlockusBlocks.BAMBOO_TIMBER_FRAME, "Bamboo");
        addTimberFrame(translationBuilder, BlockusBlocks.RAW_BAMBOO_TIMBER_FRAME, "Raw Bamboo");
        addTimberFrame(translationBuilder, BlockusBlocks.CRIMSON_TIMBER_FRAME, "Crimson");
        addTimberFrame(translationBuilder, BlockusBlocks.WARPED_TIMBER_FRAME, "Warped");
        translationBuilder.add(BlockusBlocks.WOODEN_FRAME, "Wooden Frame");

        // Netherrack
        addBssw(translationBuilder, BlockusBlocks.POLISHED_NETHERRACK, "Polished Netherrack");
        addBssw(translationBuilder, BlockusBlocks.NETHERRACK_BRICKS, "Netherrack Bricks");

        // Stone
        addBssw(translationBuilder, BlockusBlocks.STONE_TILES, "Stone Tiles");
        translationBuilder.add(BlockusBlocks.STONE_BRICK_PILLAR, "Stone Brick Pillar");
        translationBuilder.add(BlockusBlocks.SMOOTH_STONE_STAIRS, "Smooth Stone Stairs");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_STONE_BRICKS, "Herringbone Stone Bricks");
        translationBuilder.add(BlockusBlocks.STURDY_STONE, "Sturdy Stone");
        translationBuilder.add(BlockusBlocks.STONE_DOOR, "Stone Door");
        translationBuilder.add(BlockusBlocks.STONE_TRAPDOOR, "Stone Trapdoor");

        // Purpur
        addBssw(translationBuilder, BlockusBlocks.PURPUR_BRICKS, "Purpur Bricks");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_PURPUR, "Polished Purpur");
        translationBuilder.add(BlockusBlocks.PURPUR_LINES, "Purpur Lines");
        translationBuilder.add(BlockusBlocks.PURPUR_SQUARES, "Purpur Squares");
        addBssw(translationBuilder, BlockusBlocks.SMALL_PURPUR_BRICKS, "Small Purpur Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_PURPUR, "Chiseled Purpur");

        addBssw(translationBuilder, BlockusBlocks.PHANTOM_PURPUR_BLOCK, "Phantom Purpur Block");
        addBssw(translationBuilder, BlockusBlocks.PHANTOM_PURPUR_BRICKS, "Phantom Purpur Bricks");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_PHANTOM_PURPUR, "Polished Phantom Purpur");
        translationBuilder.add(BlockusBlocks.PHANTOM_PURPUR_PILLAR, "Phantom Purpur Pillar");
        translationBuilder.add(BlockusBlocks.PHANTOM_PURPUR_LINES, "Phantom Purpur Lines");
        translationBuilder.add(BlockusBlocks.PHANTOM_PURPUR_SQUARES, "Phantom Purpur Squares");
        addBssw(translationBuilder, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS, "Small Phantom Purpur Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_PHANTOM_PURPUR, "Chiseled Phantom Purpur");
        translationBuilder.add(BlockusBlocks.PURPUR_DECORATED_END_STONE, "Purpur-Decorated End Stone");
        translationBuilder.add(BlockusBlocks.PHANTOM_PURPUR_DECORATED_END_STONE, "Phantom Purpur-Decorated End Stone");
        addBssw(translationBuilder, BlockusBlocks.END_TILES, "End Tiles");

        // Nether Brick
        addBssw(translationBuilder, BlockusBlocks.NETHER_TILES, "Nether Tiles");
        translationBuilder.add(BlockusBlocks.NETHER_BRICK_PILLAR, "Nether Brick Pillar");
        translationBuilder.add(BlockusBlocks.RED_NETHER_BRICK_PILLAR, "Red Nether Brick Pillar");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_NETHER_BRICKS, "Polished Nether Bricks");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_RED_NETHER_BRICKS, "Polished Red Nether Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_NETHER_BRICKS, "Herringbone Nether Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_RED_NETHER_BRICKS, "Herringbone Red Nether Bricks");

        addBssw(translationBuilder, BlockusBlocks.CHARRED_NETHER_BRICKS, "Charred Nether Bricks");
        translationBuilder.add(BlockusBlocks.CHARRED_NETHER_BRICK_PILLAR, "Charred Nether Brick Pillar");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_CHARRED_NETHER_BRICKS, "Polished Charred Nether Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_CHARRED_NETHER_BRICKS, "Herringbone Charred Nether Bricks");

        addBssw(translationBuilder, BlockusBlocks.TEAL_NETHER_BRICKS, "Teal Nether Bricks");
        translationBuilder.add(BlockusBlocks.TEAL_NETHER_BRICK_PILLAR, "Teal Nether Brick Pillar");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_TEAL_NETHER_BRICKS, "Polished Teal Nether Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_TEAL_NETHER_BRICKS, "Herringbone Teal Nether Bricks");

        // Quartz
        addBssw(translationBuilder, BlockusBlocks.QUARTZ_TILES, "Quartz Tiles");

        // Andesite, Diorite & Granite
        addBssw(translationBuilder, BlockusBlocks.ANDESITE_BRICKS, "Andesite Bricks");
        addBssw(translationBuilder, BlockusBlocks.DIORITE_BRICKS, "Diorite Bricks");
        addBssw(translationBuilder, BlockusBlocks.GRANITE_BRICKS, "Granite Bricks");
        translationBuilder.add(BlockusBlocks.CRACKED_ANDESITE_BRICKS, "Cracked Andesite Bricks");
        translationBuilder.add(BlockusBlocks.CRACKED_DIORITE_BRICKS, "Cracked Diorite Bricks");
        translationBuilder.add(BlockusBlocks.CRACKED_GRANITE_BRICKS, "Cracked Granite Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_ANDESITE_BRICKS, "Chiseled Andesite Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_DIORITE_BRICKS, "Chiseled Diorite Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_GRANITE_BRICKS, "Chiseled Granite Bricks");
        translationBuilder.add(BlockusBlocks.POLISHED_ANDESITE_PILLAR, "Polished Andesite Pillar");
        translationBuilder.add(BlockusBlocks.POLISHED_DIORITE_PILLAR, "Polished Diorite Pillar");
        translationBuilder.add(BlockusBlocks.POLISHED_GRANITE_PILLAR, "Polished Granite Pillar");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_ANDESITE_BRICKS, "Herringbone Andesite Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_DIORITE_BRICKS, "Herringbone Diorite Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_GRANITE_BRICKS, "Herringbone Granite Bricks");

        // Caution & Road Barriers
        translationBuilder.add(BlockusBlocks.CAUTION_BLOCK, "Caution Block");
        translationBuilder.add(BlockusBlocks.CAUTION_BARRIER, "Caution Barrier");
        translationBuilder.add(BlockusBlocks.ROAD_BARRIER, "Road Barrier");

        // Bricks
        addBssw(translationBuilder, BlockusBlocks.LAVA_BRICKS, "Lava Bricks");
        addBssw(translationBuilder, BlockusBlocks.WATER_BRICKS, "Water Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_LAVA_BRICKS, "Chiseled Lava Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_WATER_BRICKS, "Chiseled Water Bricks");
        addBssw(translationBuilder, BlockusBlocks.SOAKED_BRICKS, "Soaked Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_SOAKED_BRICKS, "Herringbone Soaked Bricks");
        addBssw(translationBuilder, BlockusBlocks.SANDY_BRICKS, "Sandy Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_SANDY_BRICKS, "Herringbone Sandy Bricks");
        addBssw(translationBuilder, BlockusBlocks.CHARRED_BRICKS, "Charred Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_CHARRED_BRICKS, "Herringbone Charred Bricks");
        addBssw(translationBuilder, BlockusBlocks.LARGE_BRICKS, "Large Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_BRICKS, "Herringbone Bricks");
        addBssw(translationBuilder, BlockusBlocks.HONEYCOMB_BRICKS, "Honeycomb Bricks");

        // Glass
        translationBuilder.add(BlockusBlocks.RAINBOW_GLASS, "Rainbow Glass");
        translationBuilder.add(BlockusBlocks.RAINBOW_GLASS_PANE, "Rainbow Glass Pane");
        translationBuilder.add(BlockusBlocks.BEVELED_GLASS, "Beveled Glass");
        translationBuilder.add(BlockusBlocks.WHITE_BEVELED_GLASS, "White Beveled Glass");
        translationBuilder.add(BlockusBlocks.ORANGE_BEVELED_GLASS, "Orange Beveled Glass");
        translationBuilder.add(BlockusBlocks.MAGENTA_BEVELED_GLASS, "Magenta Beveled Glass");
        translationBuilder.add(BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS, "Light Blue Beveled Glass");
        translationBuilder.add(BlockusBlocks.YELLOW_BEVELED_GLASS, "Yellow Beveled Glass");
        translationBuilder.add(BlockusBlocks.LIME_BEVELED_GLASS, "Lime Beveled Glass");
        translationBuilder.add(BlockusBlocks.PINK_BEVELED_GLASS, "Pink Beveled Glass");
        translationBuilder.add(BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS, "Light Gray Beveled Glass");
        translationBuilder.add(BlockusBlocks.GRAY_BEVELED_GLASS, "Gray Beveled Glass");
        translationBuilder.add(BlockusBlocks.CYAN_BEVELED_GLASS, "Cyan Beveled Glass");
        translationBuilder.add(BlockusBlocks.PURPLE_BEVELED_GLASS, "Purple Beveled Glass");
        translationBuilder.add(BlockusBlocks.BLUE_BEVELED_GLASS, "Blue Beveled Glass");
        translationBuilder.add(BlockusBlocks.BROWN_BEVELED_GLASS, "Brown Beveled Glass");
        translationBuilder.add(BlockusBlocks.GREEN_BEVELED_GLASS, "Green Beveled Glass");
        translationBuilder.add(BlockusBlocks.RED_BEVELED_GLASS, "Red Beveled Glass");
        translationBuilder.add(BlockusBlocks.BLACK_BEVELED_GLASS, "Black Beveled Glass");
        translationBuilder.add(BlockusBlocks.RAINBOW_BEVELED_GLASS, "Rainbow Beveled Glass");
        translationBuilder.add(BlockusBlocks.BEVELED_GLASS_PANE, "Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.WHITE_BEVELED_GLASS_PANE, "White Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.ORANGE_BEVELED_GLASS_PANE, "Orange Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.MAGENTA_BEVELED_GLASS_PANE, "Magenta Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS_PANE, "Light Blue Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.YELLOW_BEVELED_GLASS_PANE, "Yellow Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.LIME_BEVELED_GLASS_PANE, "Lime Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.PINK_BEVELED_GLASS_PANE, "Pink Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS_PANE, "Light Gray Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.GRAY_BEVELED_GLASS_PANE, "Gray Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.CYAN_BEVELED_GLASS_PANE, "Cyan Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.PURPLE_BEVELED_GLASS_PANE, "Purple Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.BLUE_BEVELED_GLASS_PANE, "Blue Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.BROWN_BEVELED_GLASS_PANE, "Brown Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.GREEN_BEVELED_GLASS_PANE, "Green Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.RED_BEVELED_GLASS_PANE, "Red Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.BLACK_BEVELED_GLASS_PANE, "Black Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE, "Rainbow Beveled Glass Pane");
        translationBuilder.add(BlockusBlocks.TINTED_BEVELED_GLASS, "Tinted Beveled Glass");

        // Magma
        addBssw(translationBuilder, BlockusBlocks.MAGMA_BRICKS, "Magma Bricks");
        addBssw(translationBuilder, BlockusBlocks.SMALL_MAGMA_BRICKS, "Small Magma Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_MAGMA_BRICKS, "Chiseled Magma Bricks");

        // End Stone
        addBssw(translationBuilder, BlockusBlocks.POLISHED_END_STONE, "Polished End Stone");
        addBssw(translationBuilder, BlockusBlocks.SMALL_END_STONE_BRICKS, "Small End Stone Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_END_STONE_BRICKS, "Chiseled End Stone Bricks");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_END_STONE_BRICKS, "Herringbone End Stone Bricks");
        translationBuilder.add(BlockusBlocks.CRACKED_END_STONE_BRICKS, "Cracked End Stone Bricks");
        translationBuilder.add(BlockusBlocks.END_STONE_PILLAR, "End Stone Pillar");

        // Glazed Terracotta
        translationBuilder.add(BlockusBlocks.WHITE_GLAZED_TERRACOTTA_PILLAR, "White Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.ORANGE_GLAZED_TERRACOTTA_PILLAR, "Orange Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.MAGENTA_GLAZED_TERRACOTTA_PILLAR, "Magenta Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR, "Light Blue Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.YELLOW_GLAZED_TERRACOTTA_PILLAR, "Yellow Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.LIME_GLAZED_TERRACOTTA_PILLAR, "Lime Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.PINK_GLAZED_TERRACOTTA_PILLAR, "Pink Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR, "Light Gray Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.GRAY_GLAZED_TERRACOTTA_PILLAR, "Gray Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.CYAN_GLAZED_TERRACOTTA_PILLAR, "Cyan Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.PURPLE_GLAZED_TERRACOTTA_PILLAR, "Purple Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.BLUE_GLAZED_TERRACOTTA_PILLAR, "Blue Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.BROWN_GLAZED_TERRACOTTA_PILLAR, "Brown Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.GREEN_GLAZED_TERRACOTTA_PILLAR, "Green Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.RED_GLAZED_TERRACOTTA_PILLAR, "Red Glazed Terracotta Pillar");
        translationBuilder.add(BlockusBlocks.BLACK_GLAZED_TERRACOTTA_PILLAR, "Black Glazed Terracotta Pillar");

        // Asphalt
        addAsphalt(translationBuilder, BlockusBlocks.ASPHALT, "Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.WHITE_ASPHALT, "White Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.ORANGE_ASPHALT, "Orange Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.MAGENTA_ASPHALT, "Magenta Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.LIGHT_BLUE_ASPHALT, "Light Blue Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.YELLOW_ASPHALT, "Yellow Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.LIME_ASPHALT, "Lime Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.PINK_ASPHALT, "Pink Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.LIGHT_GRAY_ASPHALT, "Light Gray Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.GRAY_ASPHALT, "Gray Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.CYAN_ASPHALT, "Cyan Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.PURPLE_ASPHALT, "Purple Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.BLUE_ASPHALT, "Blue Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.BROWN_ASPHALT, "Brown Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.GREEN_ASPHALT, "Green Asphalt");
        addAsphalt(translationBuilder, BlockusBlocks.RED_ASPHALT, "Red Asphalt");
        translationBuilder.add(BlockusBlocks.RAINBOW_ASPHALT, "Rainbow Asphalt");

        // Obsidian
        addBssw(translationBuilder, BlockusBlocks.OBSIDIAN_BRICKS, "Obsidian Bricks");
        addBssw(translationBuilder, BlockusBlocks.SMALL_OBSIDIAN_BRICKS, "Small Obsidian Bricks");
        translationBuilder.add(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS, "Cracked Obsidian Bricks");
        translationBuilder.add(BlockusBlocks.OBSIDIAN_PILLAR, "Obsidian Pillar");
        translationBuilder.add(BlockusBlocks.OBSIDIAN_CIRCULAR_PAVING, "Obsidian Circular Paving");
        translationBuilder.add(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR, "Obsidian Reinforced Door");
        translationBuilder.add(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR, "Obsidian Reinforced Trapdoor");
        translationBuilder.add(BlockusBlocks.OBSIDIAN_PRESSURE_PLATE, "Obsidian Pressure Plate");
        translationBuilder.add(BlockusBlocks.GLOWING_OBSIDIAN, "Glowing Obsidian");

        // Limestone
        addBssw(translationBuilder, BlockusBlocks.LIMESTONE, "Limestone");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_LIMESTONE, "Polished Limestone");
        addBssw(translationBuilder, BlockusBlocks.LIMESTONE_BRICKS, "Limestone Bricks");
        addBssw(translationBuilder, BlockusBlocks.LIMESTONE_TILES, "Limestone Tiles");
        addBssw(translationBuilder, BlockusBlocks.SMALL_LIMESTONE_BRICKS, "Small Limestone Bricks");
        translationBuilder.add(BlockusBlocks.LIMESTONE_PILLAR, "Limestone Pillar");
        translationBuilder.add(BlockusBlocks.CHISELED_LIMESTONE, "Chiseled Limestone");
        translationBuilder.add(BlockusBlocks.CHISELED_LIMESTONE_PILLAR, "Chiseled Limestone Pillar");
        translationBuilder.add(BlockusBlocks.LIMESTONE_SQUARES, "Limestone Squares");
        translationBuilder.add(BlockusBlocks.LIMESTONE_LINES, "Limestone Lines");

        // Marble
        addBssw(translationBuilder, BlockusBlocks.MARBLE, "Marble");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_MARBLE, "Polished Marble");
        addBssw(translationBuilder, BlockusBlocks.MARBLE_BRICKS, "Marble Bricks");
        addBssw(translationBuilder, BlockusBlocks.MARBLE_TILES, "Marble Tiles");
        addBssw(translationBuilder, BlockusBlocks.SMALL_MARBLE_BRICKS, "Small Marble Bricks");
        translationBuilder.add(BlockusBlocks.MARBLE_PILLAR, "Marble Pillar");
        translationBuilder.add(BlockusBlocks.CHISELED_MARBLE, "Chiseled Marble");
        translationBuilder.add(BlockusBlocks.CHISELED_MARBLE_PILLAR, "Chiseled Marble Pillar");
        translationBuilder.add(BlockusBlocks.MARBLE_SQUARES, "Marble Squares");
        translationBuilder.add(BlockusBlocks.MARBLE_LINES, "Marble Lines");

        // Bluestone
        addBssw(translationBuilder, BlockusBlocks.BLUESTONE, "Bluestone");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_BLUESTONE, "Polished Bluestone");
        addBssw(translationBuilder, BlockusBlocks.BLUESTONE_BRICKS, "Bluestone Bricks");
        addBssw(translationBuilder, BlockusBlocks.BLUESTONE_TILES, "Bluestone Tiles");
        addBssw(translationBuilder, BlockusBlocks.SMALL_BLUESTONE_BRICKS, "Small Bluestone Bricks");
        translationBuilder.add(BlockusBlocks.BLUESTONE_PILLAR, "Bluestone Pillar");
        translationBuilder.add(BlockusBlocks.CHISELED_BLUESTONE, "Chiseled Bluestone");
        translationBuilder.add(BlockusBlocks.CHISELED_BLUESTONE_PILLAR, "Chiseled Bluestone Pillar");
        translationBuilder.add(BlockusBlocks.BLUESTONE_SQUARES, "Bluestone Squares");
        translationBuilder.add(BlockusBlocks.BLUESTONE_LINES, "Bluestone Lines");

        // Viridite
        addBssw(translationBuilder, BlockusBlocks.VIRIDITE, "Viridite");
        addBssw(translationBuilder, BlockusBlocks.POLISHED_VIRIDITE, "Polished Viridite");
        addBssw(translationBuilder, BlockusBlocks.VIRIDITE_BRICKS, "Viridite Bricks");
        addBssw(translationBuilder, BlockusBlocks.VIRIDITE_TILES, "Viridite Tiles");
        addBssw(translationBuilder, BlockusBlocks.SMALL_VIRIDITE_BRICKS, "Small Viridite Bricks");
        translationBuilder.add(BlockusBlocks.VIRIDITE_PILLAR, "Viridite Pillar");
        translationBuilder.add(BlockusBlocks.CHISELED_VIRIDITE, "Chiseled Viridite");
        translationBuilder.add(BlockusBlocks.CHISELED_VIRIDITE_PILLAR, "Chiseled Viridite Pillar");
        translationBuilder.add(BlockusBlocks.VIRIDITE_SQUARES, "Viridite Squares");
        translationBuilder.add(BlockusBlocks.VIRIDITE_LINES, "Viridite Lines");

        // Circular Pavings
        translationBuilder.add(BlockusBlocks.STONE_CIRCULAR_PAVING, "Stone Circular Paving");
        translationBuilder.add(BlockusBlocks.ANDESITE_CIRCULAR_PAVING, "Andesite Circular Paving");
        translationBuilder.add(BlockusBlocks.DIORITE_CIRCULAR_PAVING, "Diorite Circular Paving");
        translationBuilder.add(BlockusBlocks.GRANITE_CIRCULAR_PAVING, "Granite Circular Paving");
        translationBuilder.add(BlockusBlocks.MARBLE_CIRCULAR_PAVING, "Marble Circular Paving");
        translationBuilder.add(BlockusBlocks.LIMESTONE_CIRCULAR_PAVING, "Limestone Circular Paving");
        translationBuilder.add(BlockusBlocks.BLUESTONE_CIRCULAR_PAVING, "Bluestone Circular Paving");
        translationBuilder.add(BlockusBlocks.VIRIDITE_CIRCULAR_PAVING, "Viridite Circular Paving");
        translationBuilder.add(BlockusBlocks.QUARTZ_CIRCULAR_PAVING, "Quartz Circular Paving");
        translationBuilder.add(BlockusBlocks.NETHERRACK_CIRCULAR_PAVING, "Netherrack Circular Paving");
        translationBuilder.add(BlockusBlocks.POLISHED_BASALT_CIRCULAR_PAVING, "Polished Basalt Circular Paving");
        translationBuilder.add(BlockusBlocks.PRISMARINE_CIRCULAR_PAVING, "Prismarine Circular Paving");

        // Rainbow
        translationBuilder.add(BlockusBlocks.RAINBOW_ROSE, "Rainbow Rose");
        translationBuilder.add(BlockusBlocks.POTTED_RAINBOW_ROSE, "Potted Rainbow Rose");
        addBssw(translationBuilder, BlockusBlocks.RAINBOW_BRICKS, "Rainbow Bricks");
        translationBuilder.add(BlockusBlocks.RAINBOW_PETALS, "Rainbow Petals");
        translationBuilder.add(BlockusBlocks.RAINBOW_BLOCK, "Rainbow Block");
        translationBuilder.add(BlockusBlocks.RAINBOW_GLOWSTONE, "Rainbow Glowstone");

        // Redstone Lamps
        translationBuilder.add(BlockusBlocks.RAINBOW_LAMP, "Rainbow Lamp");
        translationBuilder.add(BlockusBlocks.RAINBOW_LAMP_LIT, "Lit Rainbow Lamp");
        translationBuilder.add(BlockusBlocks.REDSTONE_LAMP_LIT, "Lit Redstone Lamp");
        translationBuilder.add(BlockusBlocks.WHITE_REDSTONE_LAMP, "White Redstone Lamp");
        translationBuilder.add(BlockusBlocks.WHITE_REDSTONE_LAMP_LIT, "Lit White Redstone Lamp");
        translationBuilder.add(BlockusBlocks.ORANGE_REDSTONE_LAMP, "Orange Redstone Lamp");
        translationBuilder.add(BlockusBlocks.ORANGE_REDSTONE_LAMP_LIT, "Lit Orange Redstone Lamp");
        translationBuilder.add(BlockusBlocks.MAGENTA_REDSTONE_LAMP, "Magenta Redstone Lamp");
        translationBuilder.add(BlockusBlocks.MAGENTA_REDSTONE_LAMP_LIT, "Lit Magenta Redstone Lamp");
        translationBuilder.add(BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP, "Light Blue Redstone Lamp");
        translationBuilder.add(BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP_LIT, "Lit Light Blue Redstone Lamp");
        translationBuilder.add(BlockusBlocks.YELLOW_REDSTONE_LAMP, "Yellow Redstone Lamp");
        translationBuilder.add(BlockusBlocks.YELLOW_REDSTONE_LAMP_LIT, "Lit Yellow Redstone Lamp");
        translationBuilder.add(BlockusBlocks.LIME_REDSTONE_LAMP, "Lime Redstone Lamp");
        translationBuilder.add(BlockusBlocks.LIME_REDSTONE_LAMP_LIT, "Lit Lime Redstone Lamp");
        translationBuilder.add(BlockusBlocks.PINK_REDSTONE_LAMP, "Pink Redstone Lamp");
        translationBuilder.add(BlockusBlocks.PINK_REDSTONE_LAMP_LIT, "Lit Pink Redstone Lamp");
        translationBuilder.add(BlockusBlocks.GRAY_REDSTONE_LAMP, "Gray Redstone Lamp");
        translationBuilder.add(BlockusBlocks.GRAY_REDSTONE_LAMP_LIT, "Lit Gray Redstone Lamp");
        translationBuilder.add(BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP, "Light Gray Redstone Lamp");
        translationBuilder.add(BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP_LIT, "Lit Light Gray Redstone Lamp");
        translationBuilder.add(BlockusBlocks.CYAN_REDSTONE_LAMP, "Cyan Redstone Lamp");
        translationBuilder.add(BlockusBlocks.CYAN_REDSTONE_LAMP_LIT, "Lit Cyan Redstone Lamp");
        translationBuilder.add(BlockusBlocks.PURPLE_REDSTONE_LAMP, "Purple Redstone Lamp");
        translationBuilder.add(BlockusBlocks.PURPLE_REDSTONE_LAMP_LIT, "Lit Purple Redstone Lamp");
        translationBuilder.add(BlockusBlocks.BLUE_REDSTONE_LAMP, "Blue Redstone Lamp");
        translationBuilder.add(BlockusBlocks.BLUE_REDSTONE_LAMP_LIT, "Lit Blue Redstone Lamp");
        translationBuilder.add(BlockusBlocks.BROWN_REDSTONE_LAMP, "Brown Redstone Lamp");
        translationBuilder.add(BlockusBlocks.BROWN_REDSTONE_LAMP_LIT, "Lit Brown Redstone Lamp");
        translationBuilder.add(BlockusBlocks.GREEN_REDSTONE_LAMP, "Green Redstone Lamp");
        translationBuilder.add(BlockusBlocks.GREEN_REDSTONE_LAMP_LIT, "Lit Green Redstone Lamp");
        translationBuilder.add(BlockusBlocks.RED_REDSTONE_LAMP, "Red Redstone Lamp");
        translationBuilder.add(BlockusBlocks.RED_REDSTONE_LAMP_LIT, "Lit Red Redstone Lamp");

        // Food Crates
        translationBuilder.add(BlockusBlocks.COD_CRATE, "Cod Crate");
        translationBuilder.add(BlockusBlocks.SALMON_CRATE, "Salmon Crate");
        translationBuilder.add(BlockusBlocks.PUFFERFISH_CRATE, "Pufferfish Crate");
        translationBuilder.add(BlockusBlocks.TROPICAL_FISH_CRATE, "Tropical Fish Crate");
        translationBuilder.add(BlockusBlocks.APPLE_CRATE, "Apple Crate");
        translationBuilder.add(BlockusBlocks.GOLDEN_APPLE_CRATE, "Golden Apple Crate");
        translationBuilder.add(BlockusBlocks.POTATO_CRATE, "Potato Crate");
        translationBuilder.add(BlockusBlocks.CARROT_CRATE, "Carrot Crate");
        translationBuilder.add(BlockusBlocks.GOLDEN_CARROT_CRATE, "Golden Carrot Crate");
        translationBuilder.add(BlockusBlocks.BEETROOT_CRATE, "Beetroot Crate");
        translationBuilder.add(BlockusBlocks.SWEET_BERRIES_CRATE, "Sweet Berries Crate");
        translationBuilder.add(BlockusBlocks.GLOW_BERRIES_CRATE, "Glow Berries Crate");
        translationBuilder.add(BlockusBlocks.BREAD_BOX, "Bread Box");

        // Hedges
        translationBuilder.add(BlockusBlocks.OAK_SMALL_HEDGE, "Oak Small Hedge");
        translationBuilder.add(BlockusBlocks.SPRUCE_SMALL_HEDGE, "Spruce Small Hedge");
        translationBuilder.add(BlockusBlocks.BIRCH_SMALL_HEDGE, "Birch Small Hedge");
        translationBuilder.add(BlockusBlocks.JUNGLE_SMALL_HEDGE, "Jungle Small Hedge");
        translationBuilder.add(BlockusBlocks.ACACIA_SMALL_HEDGE, "Acacia Small Hedge");
        translationBuilder.add(BlockusBlocks.DARK_OAK_SMALL_HEDGE, "Dark Oak Small Hedge");
        translationBuilder.add(BlockusBlocks.MANGROVE_SMALL_HEDGE, "Mangrove Small Hedge");
        translationBuilder.add(BlockusBlocks.CHERRY_SMALL_HEDGE, "Cherry Small Hedge");
        translationBuilder.add(BlockusBlocks.WHITE_OAK_SMALL_HEDGE, "White Oak Small Hedge");
        translationBuilder.add(BlockusBlocks.AZALEA_SMALL_HEDGE, "Azalea Small Hedge");
        translationBuilder.add(BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE, "Flowering Azalea Small Hedge");
        translationBuilder.add(BlockusBlocks.MOSS_SMALL_HEDGE, "Moss Small Hedge");
        translationBuilder.add(BlockusBlocks.WARPED_SMALL_HEDGE, "Warped Small Hedge");
        translationBuilder.add(BlockusBlocks.CRIMSON_SMALL_HEDGE, "Crimson Small Hedge");

        // Patterned Wools
        addWoolBundle(translationBuilder, BlockusBlocks.WHITE_PATTERNED_WOOL, "White Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.ORANGE_PATTERNED_WOOL, "Orange Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.MAGENTA_PATTERNED_WOOL, "Magenta Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.LIGHT_BLUE_PATTERNED_WOOL, "Light Blue Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.YELLOW_PATTERNED_WOOL, "Yellow Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.LIME_PATTERNED_WOOL, "Lime Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.PINK_PATTERNED_WOOL, "Pink Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.GRAY_PATTERNED_WOOL, "Gray Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.LIGHT_GRAY_PATTERNED_WOOL, "Light Gray Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.CYAN_PATTERNED_WOOL, "Cyan Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.PURPLE_PATTERNED_WOOL, "Purple Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.BLUE_PATTERNED_WOOL, "Blue Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.BROWN_PATTERNED_WOOL, "Brown Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.GREEN_PATTERNED_WOOL, "Green Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.RED_PATTERNED_WOOL, "Red Patterned Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.BLACK_PATTERNED_WOOL, "Black Patterned Wool");

        addWoolBundle(translationBuilder, BlockusBlocks.WHITE_GINGHAM_WOOL, "White Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.ORANGE_GINGHAM_WOOL, "Orange Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.MAGENTA_GINGHAM_WOOL, "Magenta Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.LIGHT_BLUE_GINGHAM_WOOL, "Light Blue Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.YELLOW_GINGHAM_WOOL, "Yellow Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.LIME_GINGHAM_WOOL, "Lime Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.PINK_GINGHAM_WOOL, "Pink Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.GRAY_GINGHAM_WOOL, "Gray Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.LIGHT_GRAY_GINGHAM_WOOL, "Light Gray Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.CYAN_GINGHAM_WOOL, "Cyan Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.PURPLE_GINGHAM_WOOL, "Purple Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.BLUE_GINGHAM_WOOL, "Blue Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.BROWN_GINGHAM_WOOL, "Brown Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.GREEN_GINGHAM_WOOL, "Green Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.RED_GINGHAM_WOOL, "Red Gingham Wool");
        addWoolBundle(translationBuilder, BlockusBlocks.BLACK_GINGHAM_WOOL, "Black Gingham Wool");

        // Neons
        translationBuilder.add(BlockusBlocks.WHITE_NEON, "White Neon");
        translationBuilder.add(BlockusBlocks.ORANGE_NEON, "Orange Neon");
        translationBuilder.add(BlockusBlocks.MAGENTA_NEON, "Magenta Neon");
        translationBuilder.add(BlockusBlocks.LIGHT_BLUE_NEON, "Light Blue Neon");
        translationBuilder.add(BlockusBlocks.YELLOW_NEON, "Yellow Neon");
        translationBuilder.add(BlockusBlocks.LIME_NEON, "Lime Neon");
        translationBuilder.add(BlockusBlocks.PINK_NEON, "Pink Neon");
        translationBuilder.add(BlockusBlocks.GRAY_NEON, "Gray Neon");
        translationBuilder.add(BlockusBlocks.LIGHT_GRAY_NEON, "Light Gray Neon");
        translationBuilder.add(BlockusBlocks.CYAN_NEON, "Cyan Neon");
        translationBuilder.add(BlockusBlocks.PURPLE_NEON, "Purple Neon");
        translationBuilder.add(BlockusBlocks.BLUE_NEON, "Blue Neon");
        translationBuilder.add(BlockusBlocks.BROWN_NEON, "Brown Neon");
        translationBuilder.add(BlockusBlocks.GREEN_NEON, "Green Neon");
        translationBuilder.add(BlockusBlocks.RED_NEON, "Red Neon");
        translationBuilder.add(BlockusBlocks.BLACK_NEON, "Black Neon");

        // Futurneo Blocks
        translationBuilder.add(BlockusBlocks.WHITE_FUTURNEO_BLOCK, "White Futurneo Block");
        translationBuilder.add(BlockusBlocks.ORANGE_FUTURNEO_BLOCK, "Orange Futurneo Block");
        translationBuilder.add(BlockusBlocks.MAGENTA_FUTURNEO_BLOCK, "Magenta Futurneo Block");
        translationBuilder.add(BlockusBlocks.LIGHT_BLUE_FUTURNEO_BLOCK, "Light Blue Futurneo Block");
        translationBuilder.add(BlockusBlocks.YELLOW_FUTURNEO_BLOCK, "Yellow Futurneo Block");
        translationBuilder.add(BlockusBlocks.LIME_FUTURNEO_BLOCK, "Lime Futurneo Block");
        translationBuilder.add(BlockusBlocks.PINK_FUTURNEO_BLOCK, "Pink Futurneo Block");
        translationBuilder.add(BlockusBlocks.GRAY_FUTURNEO_BLOCK, "Gray Futurneo Block");
        translationBuilder.add(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK, "Gray Bright Futurneo Block");
        translationBuilder.add(BlockusBlocks.LIGHT_GRAY_FUTURNEO_BLOCK, "Light Gray Futurneo Block");
        translationBuilder.add(BlockusBlocks.CYAN_FUTURNEO_BLOCK, "Cyan Futurneo Block");
        translationBuilder.add(BlockusBlocks.PURPLE_FUTURNEO_BLOCK, "Purple Futurneo Block");
        translationBuilder.add(BlockusBlocks.BLUE_FUTURNEO_BLOCK, "Blue Futurneo Block");
        translationBuilder.add(BlockusBlocks.BROWN_FUTURNEO_BLOCK, "Brown Futurneo Block");
        translationBuilder.add(BlockusBlocks.GREEN_FUTURNEO_BLOCK, "Green Futurneo Block");
        translationBuilder.add(BlockusBlocks.RED_FUTURNEO_BLOCK, "Red Futurneo Block");
        translationBuilder.add(BlockusBlocks.BLACK_FUTURNEO_BLOCK, "Black Futurneo Block");
        translationBuilder.add(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK, "Rainbow Futurneo Block");

        // Large flower pot
        translationBuilder.add(BlockusBlocks.LARGE_FLOWER_POT, "Large Flower Pot");
        translationBuilder.add(BlockusBlocks.POTTED_ROSE_BUSH.block, "Potted Rose Bush");
        translationBuilder.add(BlockusBlocks.POTTED_LILAC.block, "Potted Lilac");
        translationBuilder.add(BlockusBlocks.POTTED_PEONY.block, "Potted Peony");
        translationBuilder.add(BlockusBlocks.POTTED_LARGE_FERN.block, "Potted Large Fern");
        translationBuilder.add(BlockusBlocks.POTTED_OAK.block, "Potted Oak");
        translationBuilder.add(BlockusBlocks.POTTED_SPRUCE.block, "Potted Spruce");
        translationBuilder.add(BlockusBlocks.POTTED_BIRCH.block, "Potted Birch");
        translationBuilder.add(BlockusBlocks.POTTED_JUNGLE.block, "Potted Jungle");
        translationBuilder.add(BlockusBlocks.POTTED_ACACIA.block, "Potted Acacia");
        translationBuilder.add(BlockusBlocks.POTTED_DARK_OAK.block, "Potted Dark Oak");
        translationBuilder.add(BlockusBlocks.POTTED_MANGROVE.block, "Potted Mangrove");
        translationBuilder.add(BlockusBlocks.POTTED_CHERRY_BLOSSOM.block, "Potted Cherry Blossom");
        translationBuilder.add(BlockusBlocks.POTTED_WHITE_OAK.block, "Potted White Oak");
        translationBuilder.add(BlockusBlocks.POTTED_HUGE_RED_MUSHROOM.block, "Potted Huge Red Mushroom");
        translationBuilder.add(BlockusBlocks.POTTED_HUGE_BROWN_MUSHROOM.block, "Potted Huge Brown Mushroom");
        translationBuilder.add(BlockusBlocks.POTTED_HUGE_CRIMSON_FUNGUS.block, "Potted Huge Crimson Fungus");
        translationBuilder.add(BlockusBlocks.POTTED_HUGE_WARPED_FUNGUS.block, "Potted Huge Warped Fungus");
        translationBuilder.add(BlockusBlocks.POTTED_CACTUS_LARGE.block, "Large Potted Cactus");
        translationBuilder.add(BlockusBlocks.POTTED_BAMBOO_LARGE.block, "Large Potted Bamboo");
        translationBuilder.add(BlockusBlocks.POTTED_AZALEA_LARGE.block, "Large Potted Azalea");
        translationBuilder.add(BlockusBlocks.POTTED_FLOWERING_AZALEA_LARGE.block, "Large Potted Flowering Azalea");
        translationBuilder.add(BlockusBlocks.POTTED_PITCHER_PLANT.block, "Potted Pitcher Plant");

        // Thatch
        addBssw(translationBuilder, BlockusBlocks.THATCH, "Thatch");

        // PLatings
        addBssw(translationBuilder, BlockusBlocks.IRON_PLATING, "Iron Plating");
        addBssw(translationBuilder, BlockusBlocks.GOLD_PLATING, "Gold Plating");

        // Gates, Chains, Bars
        translationBuilder.add(BlockusBlocks.IRON_GATE, "Iron Gate");
        translationBuilder.add(BlockusBlocks.GOLDEN_GATE, "Golden Gate");
        translationBuilder.add(BlockusBlocks.GOLDEN_CHAIN, "Golden Chain");
        translationBuilder.add(BlockusBlocks.GOLDEN_BARS, "Golden Bars");

        // Lanterns
        translationBuilder.add(BlockusBlocks.LANTERN_BLOCK, "Lantern Block");
        translationBuilder.add(BlockusBlocks.SOUL_LANTERN_BLOCK, "Soul Lantern Block");
        translationBuilder.add(BlockusBlocks.SOUL_O_LANTERN, "Soul o'Lantern");
        translationBuilder.add(BlockusBlocks.AMETHYST_LANTERN, "Amethyst Lantern");
        translationBuilder.add(BlockusBlocks.AMETHYST_LANTERN_BLOCK, "Amethyst Lantern Block");
        translationBuilder.add(BlockusBlocks.REDSTONE_LANTERN, "Redstone Lantern");
        translationBuilder.add(BlockusBlocks.REDSTONE_LANTERN_BLOCK, "Redstone Lantern Block");
        translationBuilder.add(BlockusBlocks.REDSTONE_O_LANTERN, "Redstone o'Lantern");

        // Pressure plates & Buttons
        translationBuilder.add(BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE, "Polished Andesite Pressure Plate");
        translationBuilder.add(BlockusBlocks.POLISHED_ANDESITE_BUTTON, "Polished Andesite Button");
        translationBuilder.add(BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE, "Polished Granite Pressure Plate");
        translationBuilder.add(BlockusBlocks.POLISHED_GRANITE_BUTTON, "Polished Granite Button");
        translationBuilder.add(BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE, "Polished Diorite Pressure Plate");
        translationBuilder.add(BlockusBlocks.POLISHED_DIORITE_BUTTON, "Polished Diorite Button");
        translationBuilder.add(BlockusBlocks.LIMESTONE_PRESSURE_PLATE, "Limestone Pressure Plate");
        translationBuilder.add(BlockusBlocks.LIMESTONE_BUTTON, "Limestone Button");
        translationBuilder.add(BlockusBlocks.MARBLE_PRESSURE_PLATE, "Marble Pressure Plate");
        translationBuilder.add(BlockusBlocks.MARBLE_BUTTON, "Marble Button");
        translationBuilder.add(BlockusBlocks.BLUESTONE_PRESSURE_PLATE, "Bluestone Pressure Plate");
        translationBuilder.add(BlockusBlocks.BLUESTONE_BUTTON, "Bluestone Button");
        translationBuilder.add(BlockusBlocks.VIRIDITE_PRESSURE_PLATE, "Viridite Pressure Plate");
        translationBuilder.add(BlockusBlocks.VIRIDITE_BUTTON, "Viridite Button");
        translationBuilder.add(BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE, "Polished Netherrack Pressure Plate");
        translationBuilder.add(BlockusBlocks.POLISHED_NETHERRACK_BUTTON, "Polished Netherrack Button");
        translationBuilder.add(BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE, "Polished End Stone Pressure Plate");
        translationBuilder.add(BlockusBlocks.POLISHED_END_STONE_BUTTON, "Polished End Stone Button");

        // Snow & Ice
        addBssw(translationBuilder, BlockusBlocks.SNOW_BRICKS, "Snow Bricks");
        translationBuilder.add(BlockusBlocks.SNOW_PILLAR, "Snow Pillar");
        translationBuilder.add(BlockusBlocks.ICE_BRICKS, "Ice Bricks");
        translationBuilder.add(BlockusBlocks.ICE_BRICK_WALL, "Ice Brick Wall");
        translationBuilder.add(BlockusBlocks.ICE_PILLAR, "Ice Pillar");

        // Netherite
        translationBuilder.add(BlockusBlocks.NETHERITE_STAIRS, "Swaggiest Stairs Ever");
        translationBuilder.add(BlockusBlocks.NETHERITE_SLAB, "Swaggiest Slab Ever");

        // Wart Blocks
        translationBuilder.add(Blocks.NETHER_WART_BLOCK, "Crimson Wart Block");
        addBssw(translationBuilder, BlockusBlocks.CRIMSON_WART_BRICKS, "Crimson Wart Bricks");
        addBssw(translationBuilder, BlockusBlocks.WARPED_WART_BRICKS, "Warped Wart Bricks");

        // Amethyst
        addBssw(translationBuilder, BlockusBlocks.POLISHED_AMETHYST, "Polished Amethyst");
        addBssw(translationBuilder, BlockusBlocks.AMETHYST_BRICKS, "Amethyst Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_AMETHYST, "Chiseled Amethyst");
        translationBuilder.add(BlockusBlocks.AMETHYST_PILLAR, "Amethyst Pillar");
        translationBuilder.add(BlockusBlocks.AMETHYST_LAMP, "Amethyst Lamp");

        // Dripstone
        addBssw(translationBuilder, BlockusBlocks.POLISHED_DRIPSTONE, "Polished Dripstone");
        addBssw(translationBuilder, BlockusBlocks.DRIPSTONE_BRICKS, "Dripstone Bricks");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_DRIPSTONE_BRICKS, "Mossy Dripstone Bricks");
        translationBuilder.add(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS, "Cracked Dripstone Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_DRIPSTONE, "Chiseled Dripstone");
        translationBuilder.add(BlockusBlocks.DRIPSTONE_PILLAR, "Dripstone Pillar");

        // Tuff
        addBssw(translationBuilder, BlockusBlocks.TUFF_TILES, "Tuff Tiles");
        translationBuilder.add(BlockusBlocks.CRACKED_TUFF_BRICKS, "Cracked Tuff Bricks");
        translationBuilder.add(BlockusBlocks.CARVED_TUFF_BRICKS, "Carved Tuff Bricks");
        translationBuilder.add(BlockusBlocks.TUFF_PILLAR, "Tuff Pillar");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_TUFF_BRICKS, "Herringbone Tuff Bricks");
        translationBuilder.add(BlockusBlocks.TUFF_CIRCULAR_PAVING, "Tuff Circular Paving");
        translationBuilder.add(BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE, "Polished Tuff Pressure Plate");
        translationBuilder.add(BlockusBlocks.POLISHED_TUFF_BUTTON, "Polished Tuff Button");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_TUFF_BRICKS, "Mossy Tuff Bricks");

        // Deepslate
        translationBuilder.add(BlockusBlocks.DEEPSLATE_PILLAR, "Deepslate Pillar");
        translationBuilder.add(BlockusBlocks.HERRINGBONE_DEEPSLATE_BRICKS, "Herringbone Deepslate Bricks");
        translationBuilder.add(BlockusBlocks.DEEPSLATE_CIRCULAR_PAVING, "Deepslate Circular Paving");
        translationBuilder.add(BlockusBlocks.STURDY_DEEPSLATE, "Sturdy Deepslate");
        translationBuilder.add(BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE, "Polished Deepslate Pressure Plate");
        translationBuilder.add(BlockusBlocks.POLISHED_DEEPSLATE_BUTTON, "Polished Deepslate Button");
        addBssw(translationBuilder, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS, "Mossy Deepslate Bricks");

        // Sculk
        addBssw(translationBuilder, BlockusBlocks.POLISHED_SCULK, "Polished Sculk");
        addBssw(translationBuilder, BlockusBlocks.SCULK_BRICKS, "Sculk Bricks");
        translationBuilder.add(BlockusBlocks.CHISELED_SCULK_BRICKS, "Chiseled Sculk Bricks");
        translationBuilder.add(BlockusBlocks.SCULK_PILLAR, "Sculk Pillar");
        translationBuilder.add(BlockusBlocks.POLISHED_SCULK_PRESSURE_PLATE, "Polished Sculk Pressure Plate");
        translationBuilder.add(BlockusBlocks.POLISHED_SCULK_BUTTON, "Polished Sculk Button");

        // Mud
        translationBuilder.add(BlockusBlocks.MUD_BRICK_PILLAR, "Mud Brick Pillar");
        translationBuilder.add(BlockusBlocks.CHISELED_MUD_BRICKS, "Chiseled Mud Bricks");

        // Chocolate
        addBssw(translationBuilder, BlockusBlocks.CHOCOLATE_BLOCK, "Chocolate Block");
        addBssw(translationBuilder, BlockusBlocks.CHOCOLATE_BRICKS, "Chocolate Bricks");
        translationBuilder.add(BlockusBlocks.CHOCOLATE_SQUARES, "Chocolate Squares");
        translationBuilder.add(BlockusBlocks.CHOCOLATE_TABLET, "Chocolate Tablet");

        // Ore Bricks
        addBssw(translationBuilder, BlockusBlocks.IRON_BRICKS, "Iron Bricks");
        addBssw(translationBuilder, BlockusBlocks.GOLD_BRICKS, "Gold Bricks");
        addBssw(translationBuilder, BlockusBlocks.REDSTONE_BRICKS, "Redstone Bricks");
        addBssw(translationBuilder, BlockusBlocks.EMERALD_BRICKS, "Emerald Bricks");
        addBssw(translationBuilder, BlockusBlocks.LAPIS_BRICKS, "Lapis Bricks");
        addBssw(translationBuilder, BlockusBlocks.DIAMOND_BRICKS, "Diamond Bricks");
        addBssw(translationBuilder, BlockusBlocks.NETHERITE_BRICKS, "Netherite Bricks");

        addCopper(translationBuilder, BlockusBlocks.COPPER_BRICKS, "Copper Bricks");
        addCopper(translationBuilder, BlockusBlocks.EXPOSED_COPPER_BRICKS, "Exposed Copper Bricks");
        addCopper(translationBuilder, BlockusBlocks.WEATHERED_COPPER_BRICKS, "Weathered Copper Bricks");
        addCopper(translationBuilder, BlockusBlocks.OXIDIZED_COPPER_BRICKS, "Oxidized Copper Bricks");
        addCopper(translationBuilder, BlockusBlocks.COPPER_TUFF_BRICKS, "Copper Tuff Bricks");
        addCopper(translationBuilder, BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS, "Exposed Copper Tuff Bricks");
        addCopper(translationBuilder, BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS, "Weathered Copper Tuff Bricks");
        addCopper(translationBuilder, BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS, "Oxidized Copper Tuff Bricks");

        // Legacy Blocks
        translationBuilder.add(BlockusBlocks.LEGACY_BRICKS, "Bricks");
        translationBuilder.add(BlockusBlocks.LEGACY_STONECUTTER, "Stonecutter");
        translationBuilder.add(BlockusBlocks.LEGACY_GRASS_BLOCK, "Grass Block");
        translationBuilder.add(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK, "Grass Block");
        translationBuilder.add(BlockusBlocks.LEGACY_LEAVES, "Leaves");
        translationBuilder.add(BlockusBlocks.LEGACY_LOG, "Wood");
        translationBuilder.add(BlockusBlocks.LEGACY_SAPLING, "Sapling");
        translationBuilder.add(BlockusBlocks.LEGACY_GRAVEL, "Gravel");
        translationBuilder.add(BlockusBlocks.LEGACY_COBBLESTONE, "Cobblestone");
        translationBuilder.add(BlockusBlocks.LEGACY_FIRST_COBBLESTONE, "Cobblestone");
        translationBuilder.add(BlockusBlocks.LEGACY_MOSSY_COBBLESTONE, "Mossy Cobblestone");
        translationBuilder.add(BlockusBlocks.LEGACY_IRON_BLOCK, "Block of Iron");
        translationBuilder.add(BlockusBlocks.LEGACY_GOLD_BLOCK, "Block of Gold");
        translationBuilder.add(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, "Block of Gold");
        translationBuilder.add(BlockusBlocks.LEGACY_DIAMOND_BLOCK, "Block of Diamond");
        translationBuilder.add(BlockusBlocks.LEGACY_COAL_BLOCK, "Block of Coal");
        translationBuilder.add(BlockusBlocks.LEGACY_LAPIS_BLOCK, "Block of Lapis Lazuli");
        translationBuilder.add(BlockusBlocks.LEGACY_SPONGE, "Sponge");
        translationBuilder.add(BlockusBlocks.LEGACY_CRYING_OBSIDIAN, "Crying Obsidian");
        translationBuilder.add(BlockusBlocks.LEGACY_GLOWING_OBSIDIAN, "Glowing Obsidian");
        translationBuilder.add(BlockusBlocks.LEGACY_GLOWSTONE, "Glowstone");
        translationBuilder.add(BlockusBlocks.LEGACY_NETHER_REACTOR_CORE, "Nether Reactor Core");
        translationBuilder.add(BlockusBlocks.LEGACY_PLANKS, "Planks");
        translationBuilder.add(BlockusBlocks.POTTED_LEGACY_TREE.block, "Potted Legacy Tree");
        translationBuilder.add(BlockusBlocks.POTTED_LEGACY_SAPLING, "Potted Legacy Sapling");
        translationBuilder.add(BlockusBlocks.LEGACY_ROSE, "Rose");
        translationBuilder.add(BlockusBlocks.POTTED_LEGACY_ROSE, "Potted Rose");
        translationBuilder.add(BlockusBlocks.LEGACY_BLUE_ROSE, "Rose");
        translationBuilder.add(BlockusBlocks.POTTED_LEGACY_BLUE_ROSE, "Potted Rose");

        // Other
        translationBuilder.add(BlockusBlocks.PATH, "Path");
        translationBuilder.add(BlockusBlocks.STARS_BLOCK, "Stars Block");
        translationBuilder.add(BlockusBlocks.ENDER_BLOCK, "Ender Block");
        translationBuilder.add(BlockusBlocks.CHARCOAL_BLOCK, "Block of Charcoal");
        translationBuilder.add(BlockusBlocks.ROTTEN_FLESH_BLOCK, "Block of Rotten Flesh");
        translationBuilder.add(BlockusBlocks.SUGAR_BLOCK, "Sugar Block");
        translationBuilder.add(BlockusBlocks.LOVE_BLOCK, "Love Block §4<3");
        translationBuilder.add(BlockusBlocks.MEMBRANE_BLOCK, "Membrane Block");
        translationBuilder.add(BlockusBlocks.REDSTONE_SAND, "Redstone Sand");
        translationBuilder.add(BlockusBlocks.NETHER_STAR_BLOCK, "Block of Nether Star");
        translationBuilder.add(BlockusBlocks.CHORUS_BLOCK, "Chorus Block");
        translationBuilder.add(BlockusBlocks.COOKIE_BLOCK, "Block of Cookie");
        translationBuilder.add(BlockusBlocks.WEIGHT_STORAGE_CUBE, "Weight Storage Cube");
        translationBuilder.add(BlockusBlocks.COMPANION_CUBE, "Companion Cube");
    }

    public static String editedString(String string) {
        return string.replace("Bricks", "Brick").replace("Tiles", "Tile").replace(" Block", "").replace(" Planks", "");
    }

    // Stairs & slab
    public static void addStairsSlab(TranslationBuilder translationBuilder, String string, Block stairs, Block slab) {
        translationBuilder.add(stairs, editedString(string) + " Stairs");
        translationBuilder.add(slab, editedString(string) + " Slab");
    }

    // Block, stairs & slab
    public static void addBlockStairsSlab(TranslationBuilder translationBuilder, String string, Block block, Block stairs, Block slab) {
        translationBuilder.add(block, string);
        addStairsSlab(translationBuilder, string, stairs, slab);
    }

    // Block, stairs & slab & wall
    public static void addBlockStairsSlabWall(TranslationBuilder translationBuilder, String string, Block block, Block stairs, Block slab, Block wall) {
        addBlockStairsSlab(translationBuilder, string, block, stairs, slab);
        translationBuilder.add(wall, editedString(string) + " Wall");
    }

    // Block, stairs & slab & wall (if exist)
    public static void addBssw(TranslationBuilder translationBuilder, BSSWBundle bundle, String string) {
        addBlockStairsSlab(translationBuilder, string, bundle.block, bundle.stairs, bundle.slab);
        if (bundle.wall != null) {
            translationBuilder.add(bundle.wall, editedString(string) + " Wall");
        }
    }

    public static void addWoodenBss(TranslationBuilder translationBuilder, BSSWBundle bundle, String string) {
        // Stairs & Slab with "Wooden" specified - Used for Mossy Charred Planks
        translationBuilder.add(bundle.block, string);
        translationBuilder.add(bundle.stairs, editedString(string) + " Wooden Stairs");
        translationBuilder.add(bundle.slab, editedString(string) + " Wooden Slab");
    }

    // Wood
    public static void addWoodBundle(TranslationBuilder translationBuilder, WoodBundle bundle, String string) {
        String charredException = editedString(string).replace("Charred", "Charred Wooden");
        translationBuilder.add(bundle.planks, string);
        translationBuilder.add(bundle.stairs, charredException + " Stairs");
        translationBuilder.add(bundle.slab, charredException + " Slab");
        translationBuilder.add(bundle.fence, editedString(string) + " Fence");
        translationBuilder.add(bundle.fence_gate, editedString(string) + " Fence Gate");
        translationBuilder.add(bundle.door, charredException + " Door");
        translationBuilder.add(bundle.trapdoor, charredException + " Trapdoor");
        translationBuilder.add(bundle.pressure_plate, charredException + " Pressure Plate");
        translationBuilder.add(bundle.button, charredException + " Button");
        translationBuilder.add(bundle.sign, editedString(string) + " Sign");
        translationBuilder.add(bundle.sign.getTranslationKey().replace("sign", "wall_sign"), editedString(string) + " Wall Sign");
        translationBuilder.add(bundle.hanging_sign, editedString(string) + " Hanging Sign");
        translationBuilder.add(bundle.hanging_sign.getTranslationKey().replace("hanging_sign", "wall_hanging_sign"), editedString(string) + " Wall Hanging Sign");
    }

    // Wooden Posts
    public static void addWoodenPost(TranslationBuilder translationBuilder, WoodenPostBundle bundle, String string) {
        translationBuilder.add(bundle.block, string);
        translationBuilder.add(bundle.stripped, "Stripped " + string);
    }

    // Timber Frames, Lattice & Grate
    public static void addTimberFrame(TranslationBuilder translationBuilder, TimberFrameBundle bundle, String wood) {
        translationBuilder.add(bundle.block, wood + " Timber Frame");
        translationBuilder.add(bundle.diagonal, wood + " Diagonal Timber Frame");
        translationBuilder.add(bundle.cross, wood + " Cross Timber Frame");
        translationBuilder.add(bundle.lattice, wood + " Lattice");
        translationBuilder.add(bundle.grate, wood + " Grate");
    }

    // Concrete
    public static void addConcrete(TranslationBuilder translationBuilder, ConcreteBundle bundle, String string) {
        String removeBricks = string.replace(" Bricks", "");
        addBlockStairsSlabWall(translationBuilder, string, bundle.block, bundle.stairs, bundle.slab, bundle.wall);
        translationBuilder.add(bundle.chiseled, "Chiseled " + removeBricks);
        translationBuilder.add(bundle.pillar, removeBricks + " Pillar");
    }

    // Patterned Wools
    public static void addWoolBundle(TranslationBuilder translationBuilder, WoolBundle bundle, String string) {
        addBlockStairsSlab(translationBuilder, string, bundle.block, bundle.stairs, bundle.slab);
        translationBuilder.add(bundle.carpet, string.replace("Wool", "Carpet"));
    }

    // Asphalt
    public static void addAsphalt(TranslationBuilder translationBuilder, AsphaltBundle bundle, String string) {
        addBlockStairsSlab(translationBuilder, string, bundle.block, bundle.stairs, bundle.slab);
    }

    // Copper
    public static void addCopper(TranslationBuilder translationBuilder, CopperBundle bundle, String string) {
        String waxedString = "Waxed " + string;
        addBlockStairsSlabWall(translationBuilder, string, bundle.block, bundle.stairs, bundle.slab, bundle.wall);
        addBlockStairsSlabWall(translationBuilder, waxedString, bundle.blockWaxed, bundle.stairsWaxed, bundle.slabWaxed, bundle.wallWaxed);
    }
}
