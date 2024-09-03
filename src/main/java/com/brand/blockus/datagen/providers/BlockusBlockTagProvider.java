package com.brand.blockus.datagen.providers;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.registry.tag.BlockusBlockTags;
import com.brand.blockus.utils.BlockChecker;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BlockusBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public FabricTagBuilder getOrCreateTagBuilder(Identifier id) {
        TagKey<Block> tag = TagKey.of(RegistryKeys.BLOCK, id);
        return this.getOrCreateTagBuilder(tag);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        this.getOrCreateTagBuilder(BlockusBlockTags.AMETHYST_BLOCKS)
            .add(bsswBundle(POLISHED_AMETHYST))
            .add(bsswBundle(AMETHYST_BRICKS))
            .add(CHISELED_AMETHYST)
            .add(AMETHYST_PILLAR)
            .add(AMETHYST_LAMP);

        this.getOrCreateTagBuilder(BlockusBlockTags.ANDESITE_BLOCKS)
            .add(bsswBundle(ANDESITE_BRICKS))
            .add(HERRINGBONE_ANDESITE_BRICKS)
            .add(CHISELED_ANDESITE_BRICKS)
            .add(CRACKED_ANDESITE_BRICKS)
            .add(POLISHED_ANDESITE_PILLAR)
            .add(ANDESITE_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockTags.VIBRATION_RESONATORS)
            .addTag(BlockusBlockTags.AMETHYST_BLOCKS);

        for (AsphaltBundle asphaltType : AsphaltBundle.values()) {
            this.getOrCreateTagBuilder(BlockusBlockTags.ASPHALT)
                .add(asphaltType.block)
                .add(asphaltType.stairs)
                .add(asphaltType.slab);
        }

        this.getOrCreateTagBuilder(BlockusBlockTags.ASPHALT)
            .add(RAINBOW_ASPHALT);

        this.getOrCreateTagBuilder(BlockusBlockTags.BARRIERS)
            .add(CAUTION_BARRIER)
            .add(ROAD_BARRIER);

        this.getOrCreateTagBuilder(BlockusBlockTags.BASALT_BLOCKS)
            .add(bsswBundle(ROUGH_BASALT))
            .add(bsswBundle(POLISHED_BASALT_BRICKS))
            .add(CHISELED_POLISHED_BASALT)
            .add(CRACKED_POLISHED_BASALT_BRICKS)
            .add(POLISHED_BASALT_PILLAR)
            .add(HERRINGBONE_POLISHED_BASALT_BRICKS)
            .add(POLISHED_BASALT_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.BEVELED_GLASS)
            .add(BEVELED_GLASS)
            .add(WHITE_BEVELED_GLASS)
            .add(ORANGE_BEVELED_GLASS)
            .add(MAGENTA_BEVELED_GLASS)
            .add(LIGHT_BLUE_BEVELED_GLASS)
            .add(YELLOW_BEVELED_GLASS)
            .add(LIME_BEVELED_GLASS)
            .add(PINK_BEVELED_GLASS)
            .add(GRAY_BEVELED_GLASS)
            .add(LIGHT_GRAY_BEVELED_GLASS)
            .add(CYAN_BEVELED_GLASS)
            .add(PURPLE_BEVELED_GLASS)
            .add(BLUE_BEVELED_GLASS)
            .add(BROWN_BEVELED_GLASS)
            .add(GREEN_BEVELED_GLASS)
            .add(RED_BEVELED_GLASS)
            .add(BLACK_BEVELED_GLASS)
            .add(RAINBOW_BEVELED_GLASS);

        this.getOrCreateTagBuilder(BlockusBlockTags.BLACKSTONE_BLOCKS)
            .add(bsswBundle(POLISHED_BLACKSTONE_TILES))
            .add(POLISHED_BLACKSTONE_PILLAR)
            .add(HERRINGBONE_POLISHED_BLACKSTONE_BRICKS)
            .add(POLISHED_BLACKSTONE_CIRCULAR_PAVING)
            .add(bsswBundle(CRIMSON_WARTY_BLACKSTONE_BRICKS))
            .add(bsswBundle(WARPED_WARTY_BLACKSTONE_BRICKS))
            .add(GOLD_DECORATED_POLISHED_BLACKSTONE)
            .add(BLACKSTONE_DOOR)
            .add(BLACKSTONE_TRAPDOOR)
            .add(STURDY_BLACKSTONE);

        this.getOrCreateTagBuilder(BlockusBlockTags.BLAZE_BRICKS)
            .add(bsswBundle(BLAZE_BRICKS))
            .add(BLAZE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.BLUESTONE)
            .add(bsswBundle(BLUESTONE))
            .add(BLUESTONE_PILLAR)
            .add(bsswBundle(BLUESTONE_BRICKS))
            .add(bsswBundle(BLUESTONE_TILES))
            .add(bsswBundle(POLISHED_BLUESTONE))
            .add(BLUESTONE_SQUARES)
            .add(bsswBundle(SMALL_BLUESTONE_BRICKS))
            .add(CHISELED_BLUESTONE)
            .add(BLUESTONE_CIRCULAR_PAVING)
            .add(CHISELED_BLUESTONE_PILLAR)
            .add(BLUESTONE_LINES);

        this.getOrCreateTagBuilder(BlockusBlockTags.BRICKS_BLOCKS)
            .add(bsswBundle(LARGE_BRICKS))
            .add(HERRINGBONE_BRICKS)
            .add(bsswBundle(SOAKED_BRICKS))
            .add(HERRINGBONE_SOAKED_BRICKS)
            .add(bsswBundle(SANDY_BRICKS))
            .add(HERRINGBONE_SANDY_BRICKS)
            .add(bsswBundle(CHARRED_BRICKS))
            .add(HERRINGBONE_CHARRED_BRICKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.CHOCOLATE_BLOCKS)
            .add(bsswBundle(CHOCOLATE_BLOCK))
            .add(bsswBundle(CHOCOLATE_BRICKS))
            .add(CHOCOLATE_SQUARES)
            .add(CHOCOLATE_TABLET);

        this.getOrCreateTagBuilder(BlockusBlockTags.COLORED_TILES)
            .add(WHITE_COLORED_TILES)
            .add(ORANGE_COLORED_TILES)
            .add(MAGENTA_COLORED_TILES)
            .add(LIGHT_BLUE_COLORED_TILES)
            .add(YELLOW_COLORED_TILES)
            .add(LIME_COLORED_TILES)
            .add(PINK_COLORED_TILES)
            .add(GRAY_COLORED_TILES)
            .add(LIGHT_GRAY_COLORED_TILES)
            .add(CYAN_COLORED_TILES)
            .add(PURPLE_COLORED_TILES)
            .add(BLUE_COLORED_TILES)
            .add(BROWN_COLORED_TILES)
            .add(GREEN_COLORED_TILES)
            .add(RED_COLORED_TILES)
            .add(BLACK_COLORED_TILES)
            .add(RAINBOW_COLORED_TILES);

        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            this.getOrCreateTagBuilder(BlockusBlockTags.COLORED_TILES).add(coloredTilesVariants.block);
        }

        for (ConcreteBundle concreteType : ConcreteBundle.values()) {
            this.getOrCreateTagBuilder(BlockusBlockTags.CONCRETE_BLOCKS)
                .add(concreteType.block)
                .add(concreteType.stairs)
                .add(concreteType.slab)
                .add(concreteType.chiseled)
                .add(concreteType.pillar);
        }

        this.getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS)
            .addTag(BlockusBlockTags.AMETHYST_BLOCKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.DEEPSLATE_BLOCKS)
            .add(bsswBundle(MOSSY_DEEPSLATE_BRICKS))
            .add(HERRINGBONE_DEEPSLATE_BRICKS)
            .add(DEEPSLATE_PILLAR)
            .add(DEEPSLATE_CIRCULAR_PAVING)
            .add(STURDY_DEEPSLATE);

        this.getOrCreateTagBuilder(BlockusBlockTags.DIORITE_BLOCKS)
            .add(bsswBundle(DIORITE_BRICKS))
            .add(HERRINGBONE_DIORITE_BRICKS)
            .add(CHISELED_DIORITE_BRICKS)
            .add(CRACKED_DIORITE_BRICKS)
            .add(POLISHED_DIORITE_PILLAR)
            .add(DIORITE_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.DRIPSTONE_BLOCKS)
            .add(bsswBundle(POLISHED_DRIPSTONE))
            .add(bsswBundle(DRIPSTONE_BRICKS))
            .add(bsswBundle(MOSSY_DRIPSTONE_BRICKS))
            .add(CRACKED_DRIPSTONE_BRICKS)
            .add(CHISELED_DRIPSTONE)
            .add(DRIPSTONE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.END_STONE_BLOCKS)
            .add(CHISELED_END_STONE_BRICKS)
            .add(HERRINGBONE_END_STONE_BRICKS)
            .add(bsswBundle(POLISHED_END_STONE))
            .add(CRACKED_END_STONE_BRICKS)
            .add(END_STONE_PILLAR)
            .add(bsswBundle(SMALL_END_STONE_BRICKS))
            .add(PURPUR_DECORATED_END_STONE)
            .add(PHANTOM_PURPUR_DECORATED_END_STONE);

        this.getOrCreateTagBuilder(BlockusBlockTags.FOOD_CRATES)
            .add(SWEET_BERRIES_CRATE)
            .add(SALMON_CRATE)
            .add(PUFFERFISH_CRATE)
            .add(TROPICAL_FISH_CRATE)
            .add(COD_CRATE)
            .add(POTATO_CRATE)
            .add(APPLE_CRATE)
            .add(BEETROOT_CRATE)
            .add(CARROT_CRATE)
            .add(BREAD_BOX)
            .add(GOLDEN_APPLE_CRATE)
            .add(GOLDEN_CARROT_CRATE)
            .add(GLOW_BERRIES_CRATE)
            .addOptional(Blockus.id("blueberries_crate"));

        this.getOrCreateTagBuilder(BlockusBlockTags.FRAMED_PAPER_BLOCKS)
            .add(FRAMED_PAPER_BLOCK)
            .add(PAPER_WALL)
            .add(PAPER_DOOR)
            .add(PAPER_TRAPDOOR);

        this.getOrCreateTagBuilder(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS)
            .add(WHITE_GLAZED_TERRACOTTA_PILLAR)
            .add(ORANGE_GLAZED_TERRACOTTA_PILLAR)
            .add(MAGENTA_GLAZED_TERRACOTTA_PILLAR)
            .add(LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR)
            .add(YELLOW_GLAZED_TERRACOTTA_PILLAR)
            .add(LIME_GLAZED_TERRACOTTA_PILLAR)
            .add(PINK_GLAZED_TERRACOTTA_PILLAR)
            .add(GRAY_GLAZED_TERRACOTTA_PILLAR)
            .add(LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR)
            .add(CYAN_GLAZED_TERRACOTTA_PILLAR)
            .add(PURPLE_GLAZED_TERRACOTTA_PILLAR)
            .add(BLUE_GLAZED_TERRACOTTA_PILLAR)
            .add(BROWN_GLAZED_TERRACOTTA_PILLAR)
            .add(GREEN_GLAZED_TERRACOTTA_PILLAR)
            .add(RED_GLAZED_TERRACOTTA_PILLAR)
            .add(BLACK_GLAZED_TERRACOTTA_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.GRANITE_BLOCKS)
            .add(bsswBundle(GRANITE_BRICKS))
            .add(HERRINGBONE_GRANITE_BRICKS)
            .add(CHISELED_GRANITE_BRICKS)
            .add(CRACKED_GRANITE_BRICKS)
            .add(POLISHED_GRANITE_PILLAR)
            .add(GRANITE_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.HONEYCOMB_BLOCKS)
            .add(bsswBundle(HONEYCOMB_BRICKS));

        this.getOrCreateTagBuilder(BlockusBlockTags.ICE_BRICKS)
            .add(ICE_BRICKS)
            .add(ICE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.LARGE_FLOWER_POTS)
            .add(LARGE_FLOWER_POT)
            .add(POTTED_ROSE_BUSH.block)
            .add(POTTED_LILAC.block)
            .add(POTTED_PEONY.block)
            .add(POTTED_LARGE_FERN.block)
            .add(POTTED_OAK.block)
            .add(POTTED_SPRUCE.block)
            .add(POTTED_BIRCH.block)
            .add(POTTED_JUNGLE.block)
            .add(POTTED_ACACIA.block)
            .add(POTTED_DARK_OAK.block)
            .add(POTTED_MANGROVE.block)
            .add(POTTED_CHERRY_BLOSSOM.block)
            .add(POTTED_WHITE_OAK.block)
            .add(POTTED_HUGE_RED_MUSHROOM.block)
            .add(POTTED_HUGE_BROWN_MUSHROOM.block)
            .add(POTTED_HUGE_CRIMSON_FUNGUS.block)
            .add(POTTED_HUGE_WARPED_FUNGUS.block)
            .add(POTTED_CACTUS_LARGE.block)
            .add(POTTED_BAMBOO_LARGE.block)
            .add(POTTED_PITCHER_PLANT.block)
            .addOptional(Blockus.id("potted_autumn_birch"))
            .addOptional(Blockus.id("potted_autumn_oak"))
            .addOptional(Blockus.id("potted_palm"))
            .addOptional(Blockus.id("potted_pink_cherry_oak"))
            .addOptional(Blockus.id("potted_white_cherry_oak"))
            .addOptional(Blockus.id("potted_huge_dark_amaranth_fungus"));

        this.getOrCreateTagBuilder(BlockusBlockTags.LAVA_BRICKS)
            .add(bsswBundle(LAVA_BRICKS))
            .add(CHISELED_LAVA_BRICKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.LAVA_POLISHED_BLACKSTONE_BRICKS)
            .add(bsswBundle(LAVA_POLISHED_BLACKSTONE_BRICKS))
            .add(CHISELED_LAVA_POLISHED_BLACKSTONE);

        this.getOrCreateTagBuilder(BlockusBlockTags.LIMESTONE)
            .add(bsswBundle(LIMESTONE))
            .add(bsswBundle(POLISHED_LIMESTONE))
            .add(bsswBundle(LIMESTONE_BRICKS))
            .add(bsswBundle(LIMESTONE_TILES))
            .add(LIMESTONE_PILLAR)
            .add(LIMESTONE_SQUARES)
            .add(bsswBundle(SMALL_LIMESTONE_BRICKS))
            .add(CHISELED_LIMESTONE)
            .add(CHISELED_LIMESTONE_PILLAR)
            .add(LIMESTONE_LINES)
            .add(LIMESTONE_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.VIRIDITE)
            .add(bsswBundle(VIRIDITE))
            .add(bsswBundle(POLISHED_VIRIDITE))
            .add(bsswBundle(VIRIDITE_BRICKS))
            .add(bsswBundle(VIRIDITE_TILES))
            .add(VIRIDITE_PILLAR)
            .add(VIRIDITE_SQUARES)
            .add(bsswBundle(SMALL_VIRIDITE_BRICKS))
            .add(CHISELED_VIRIDITE)
            .add(CHISELED_VIRIDITE_PILLAR)
            .add(VIRIDITE_CIRCULAR_PAVING)
            .add(VIRIDITE_LINES);

        this.getOrCreateTagBuilder(BlockusBlockTags.MAGMA_BRICKS)
            .add(bsswBundle(MAGMA_BRICKS))
            .add(bsswBundle(SMALL_MAGMA_BRICKS))
            .add(CHISELED_MAGMA_BRICKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.MARBLE)
            .add(bsswBundle(MARBLE))
            .add(bsswBundle(POLISHED_MARBLE))
            .add(bsswBundle(MARBLE_BRICKS))
            .add(bsswBundle(MARBLE_TILES))
            .add(MARBLE_PILLAR)
            .add(MARBLE_SQUARES)
            .add(bsswBundle(SMALL_MARBLE_BRICKS))
            .add(CHISELED_MARBLE_PILLAR)
            .add(CHISELED_MARBLE)
            .add(MARBLE_LINES)
            .add(MARBLE_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.NEON)
            .add(WHITE_NEON)
            .add(ORANGE_NEON)
            .add(MAGENTA_NEON)
            .add(LIGHT_BLUE_NEON)
            .add(YELLOW_NEON)
            .add(LIME_NEON)
            .add(PINK_NEON)
            .add(GRAY_NEON)
            .add(LIGHT_GRAY_NEON)
            .add(CYAN_NEON)
            .add(PURPLE_NEON)
            .add(BLUE_NEON)
            .add(BROWN_NEON)
            .add(GREEN_NEON)
            .add(RED_NEON)
            .add(BLACK_NEON);

        this.getOrCreateTagBuilder(BlockusBlockTags.NETHER_BRICKS)
            .add(bsswBundle(POLISHED_NETHER_BRICKS))
            .add(bsswBundle(POLISHED_RED_NETHER_BRICKS))
            .add(HERRINGBONE_NETHER_BRICKS)
            .add(HERRINGBONE_RED_NETHER_BRICKS)
            .add(NETHER_BRICK_PILLAR)
            .add(RED_NETHER_BRICK_PILLAR)
            .add(bsswBundle(CHARRED_NETHER_BRICKS))
            .add(bsswBundle(POLISHED_CHARRED_NETHER_BRICKS))
            .add(HERRINGBONE_CHARRED_NETHER_BRICKS)
            .add(CHARRED_NETHER_BRICK_PILLAR)
            .add(bsswBundle(TEAL_NETHER_BRICKS))
            .add(bsswBundle(POLISHED_TEAL_NETHER_BRICKS))
            .add(HERRINGBONE_TEAL_NETHER_BRICKS)
            .add(TEAL_NETHER_BRICK_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.NETHERRACK_BLOCKS)
            .add(bsswBundle(POLISHED_NETHERRACK))
            .add(bsswBundle(NETHERRACK_BRICKS))
            .add(NETHERRACK_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.OBSIDIAN)
            .add(bsswBundle(OBSIDIAN_BRICKS))
            .add(CRACKED_OBSIDIAN_BRICKS)
            .add(bsswBundle(SMALL_OBSIDIAN_BRICKS))
            .add(OBSIDIAN_PILLAR)
            .add(OBSIDIAN_CIRCULAR_PAVING)
            .add(OBSIDIAN_REINFORCED_DOOR)
            .add(OBSIDIAN_REINFORCED_TRAPDOOR)
            .add(GLOWING_OBSIDIAN)
            .add(LEGACY_CRYING_OBSIDIAN)
            .add(LEGACY_GLOWING_OBSIDIAN);

        this.getOrCreateTagBuilder(BlockusBlockTags.ALL_PATTERNED_WOOLS)
            .addTag(BlockusBlockTags.PATTERNED_WOOL);

        for (WoolBundle woolBundle : WoolBundle.values()) {
            this.getOrCreateTagBuilder(BlockusBlockTags.PATTERNED_WOOL)
                .add(woolBundle.block);
            this.getOrCreateTagBuilder(BlockusBlockTags.PATTERNED_CARPETS)
                .add(woolBundle.carpet);
            this.getOrCreateTagBuilder(BlockusBlockTags.ALL_PATTERNED_WOOLS)
                .add(woolBundle.stairs)
                .add(woolBundle.slab);
        }

        this.getOrCreateTagBuilder(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS)
            .add(bsswBundle(PHANTOM_PURPUR_BLOCK))
            .add(PHANTOM_PURPUR_PILLAR)
            .add(bsswBundle(PHANTOM_PURPUR_BRICKS))
            .add(bsswBundle(POLISHED_PHANTOM_PURPUR))
            .add(PHANTOM_PURPUR_SQUARES)
            .add(bsswBundle(SMALL_PHANTOM_PURPUR_BRICKS))
            .add(CHISELED_PHANTOM_PURPUR)
            .add(PHANTOM_PURPUR_LINES);

        this.getOrCreateTagBuilder(BlockusBlockTags.PLATINGS)
            .add(bsswBundle(IRON_PLATING))
            .add(bsswBundle(GOLD_PLATING));

        this.getOrCreateTagBuilder(BlockusBlockTags.PRISMARINE_BLOCKS)
            .add(PRISMARINE_CIRCULAR_PAVING)
            .add(CHISELED_DARK_PRISMARINE)
            .add(DARK_PRISMARINE_PILLAR)
            .add(CHISELED_PRISMARINE)
            .add(PRISMARINE_PILLAR)
            .add(bsswBundle(PRISMARINE_TILES));

        this.getOrCreateTagBuilder(BlockusBlockTags.PURPUR_BLOCKS)
            .add(bsswBundle(PURPUR_BRICKS))
            .add(bsswBundle(POLISHED_PURPUR))
            .add(PURPUR_SQUARES)
            .add(bsswBundle(SMALL_PURPUR_BRICKS))
            .add(CHISELED_PURPUR)
            .add(PURPUR_LINES)
            .addTag(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.QUARTZ_BLOCKS)
            .add(bsswBundle(QUARTZ_TILES))
            .add(QUARTZ_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.RAINBOW_BLOCKS)
            .add(RAINBOW_BLOCK)
            .add(bsswBundle(RAINBOW_BRICKS));

        this.getOrCreateTagBuilder(BlockusBlockTags.RED_SANDSTONE)
            .add(bsswBundle(ROUGH_RED_SANDSTONE))
            .add(bsswBundle(RED_SANDSTONE_BRICKS))
            .add(bsswBundle(SMALL_RED_SANDSTONE_BRICKS))
            .add(GOLD_DECORATED_RED_SANDSTONE)
            .add(LAPIS_DECORATED_RED_SANDSTONE)
            .add(RED_SANDSTONE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.SANDSTONE)
            .add(bsswBundle(ROUGH_SANDSTONE))
            .add(bsswBundle(SANDSTONE_BRICKS))
            .add(bsswBundle(SMALL_SANDSTONE_BRICKS))
            .add(GOLD_DECORATED_SANDSTONE)
            .add(LAPIS_DECORATED_SANDSTONE)
            .add(SANDSTONE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.SCULK_BLOCKS)
            .add(bsswBundle(POLISHED_SCULK))
            .add(bsswBundle(SCULK_BRICKS))
            .add(CHISELED_SCULK_BRICKS)
            .add(SCULK_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.SHINGLES)
            .add(bsswBundle(SHINGLES))
            .add(bsswBundle(WHITE_SHINGLES))
            .add(bsswBundle(ORANGE_SHINGLES))
            .add(bsswBundle(MAGENTA_SHINGLES))
            .add(bsswBundle(LIGHT_BLUE_SHINGLES))
            .add(bsswBundle(YELLOW_SHINGLES))
            .add(bsswBundle(LIME_SHINGLES))
            .add(bsswBundle(PINK_SHINGLES))
            .add(bsswBundle(GRAY_SHINGLES))
            .add(bsswBundle(LIGHT_GRAY_SHINGLES))
            .add(bsswBundle(CYAN_SHINGLES))
            .add(bsswBundle(PURPLE_SHINGLES))
            .add(bsswBundle(BLUE_SHINGLES))
            .add(bsswBundle(BROWN_SHINGLES))
            .add(bsswBundle(GREEN_SHINGLES))
            .add(bsswBundle(RED_SHINGLES))
            .add(bsswBundle(BLACK_SHINGLES));

        for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
            this.getOrCreateTagBuilder(BlockusBlockTags.WOODEN_POSTS)
                .add(woodenPost.block)
                .add(woodenPost.stripped);
        }

        this.getOrCreateTagBuilder(BlockusBlockTags.SMALL_HEDGES)
            .add(OAK_SMALL_HEDGE)
            .add(SPRUCE_SMALL_HEDGE)
            .add(BIRCH_SMALL_HEDGE)
            .add(JUNGLE_SMALL_HEDGE)
            .add(ACACIA_SMALL_HEDGE)
            .add(DARK_OAK_SMALL_HEDGE)
            .add(MANGROVE_SMALL_HEDGE)
            .add(CHERRY_SMALL_HEDGE)
            .add(WHITE_OAK_SMALL_HEDGE)
            .add(CRIMSON_SMALL_HEDGE)
            .add(WARPED_SMALL_HEDGE)
            .add(AZALEA_SMALL_HEDGE)
            .add(FLOWERING_AZALEA_SMALL_HEDGE)
            .add(MOSS_SMALL_HEDGE)
            .addOptional(Blockus.id("sap_maple_small_hedge"))
            .addOptional(Blockus.id("vermilion_maple_small_hedge"))
            .addOptional(Blockus.id("fulvous_maple_small_hedge"))
            .addOptional(Blockus.id("mikado_maple_small_hedge"))
            .addOptional(Blockus.id("pink_cherry_oak_small_hedge"))
            .addOptional(Blockus.id("white_cherry_oak_small_hedge"))
            .addOptional(Blockus.id("palm_small_hedge"))
            .addOptional(Blockus.id("dark_amaranth_small_hedge"));

        this.getOrCreateTagBuilder(BlockusBlockTags.SNOW_BRICKS)
            .add(bsswBundle(SNOW_BRICKS))
            .add(SNOW_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.SOUL_SANDSTONE)
            .add(bsswBundle(SOUL_SANDSTONE))
            .add(bsswBundle(ROUGH_SOUL_SANDSTONE))
            .add(bsswBundle(SMOOTH_SOUL_SANDSTONE))
            .add(bsswBundle(SOUL_SANDSTONE_BRICKS))
            .add(bsswBundle(SMALL_SOUL_SANDSTONE_BRICKS))
            .add(CUT_SOUL_SANDSTONE)
            .add(CUT_SOUL_SANDSTONE_SLAB)
            .add(CHISELED_SOUL_SANDSTONE)
            .add(GOLD_DECORATED_SOUL_SANDSTONE)
            .add(LAPIS_DECORATED_SOUL_SANDSTONE)
            .add(SOUL_SANDSTONE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.SOUL_SOILS)
            .add(Blocks.SOUL_SAND)
            .add(Blocks.SOUL_SOIL);

        this.getOrCreateTagBuilder(BlockusBlockTags.STAINED_STONE_BRICKS)
            .add(bsswBundle(WHITE_STONE_BRICKS))
            .add(bsswBundle(ORANGE_STONE_BRICKS))
            .add(bsswBundle(MAGENTA_STONE_BRICKS))
            .add(bsswBundle(LIGHT_BLUE_STONE_BRICKS))
            .add(bsswBundle(YELLOW_STONE_BRICKS))
            .add(bsswBundle(LIME_STONE_BRICKS))
            .add(bsswBundle(PINK_STONE_BRICKS))
            .add(bsswBundle(GRAY_STONE_BRICKS))
            .add(bsswBundle(CYAN_STONE_BRICKS))
            .add(bsswBundle(PURPLE_STONE_BRICKS))
            .add(bsswBundle(BLUE_STONE_BRICKS))
            .add(bsswBundle(BROWN_STONE_BRICKS))
            .add(bsswBundle(GREEN_STONE_BRICKS))
            .add(bsswBundle(RED_STONE_BRICKS))
            .add(bsswBundle(BLACK_STONE_BRICKS));

        this.getOrCreateTagBuilder(BlockusBlockTags.STONE_BLOCKS)
            .add(bsswBundle(STONE_TILES))
            .add(STONE_BRICK_PILLAR)
            .add(HERRINGBONE_STONE_BRICKS)
            .add(STONE_CIRCULAR_PAVING)
            .add(SMOOTH_STONE_STAIRS)
            .add(STONE_DOOR)
            .add(STONE_TRAPDOOR)
            .add(STURDY_STONE);

        this.getOrCreateTagBuilder(BlockTags.STONE_BUTTONS)
            .add(POLISHED_ANDESITE_BUTTON)
            .add(POLISHED_DIORITE_BUTTON)
            .add(POLISHED_GRANITE_BUTTON)
            .add(LIMESTONE_BUTTON)
            .add(MARBLE_BUTTON)
            .add(BLUESTONE_BUTTON)
            .add(POLISHED_NETHERRACK_BUTTON)
            .add(POLISHED_END_STONE_BUTTON)
            .add(POLISHED_BASALT_BUTTON)
            .add(POLISHED_DEEPSLATE_BUTTON)
            .add(POLISHED_TUFF_BUTTON)
            .add(POLISHED_SCULK_BUTTON)
            .add(VIRIDITE_BUTTON);

        this.getOrCreateTagBuilder(BlockusBlockTags.THATCH)
            .add(bsswBundle(THATCH));


        for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
            this.getOrCreateTagBuilder(BlockusBlockTags.TIMBER_FRAMES)
                .add(timberFrameBundle.block)
                .add(timberFrameBundle.diagonal)
                .add(timberFrameBundle.cross);

            this.getOrCreateTagBuilder(BlockusBlockTags.WOODEN_LATTICES)
                .add(timberFrameBundle.lattice);

            this.getOrCreateTagBuilder(BlockusBlockTags.WOODEN_GRATES)
                .add(timberFrameBundle.grate);
        }

        this.getOrCreateTagBuilder(BlockusBlockTags.TUFF_BLOCKS)
            .add(bsswBundle(MOSSY_TUFF_BRICKS))
            .add(bsswBundle(TUFF_TILES))
            .add(CRACKED_TUFF_BRICKS)
            .add(CARVED_TUFF_BRICKS)
            .add(HERRINGBONE_TUFF_BRICKS)
            .add(TUFF_PILLAR)
            .add(TUFF_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.WARPED_NETHER_GRASS)
            .add(Blocks.NETHER_SPROUTS)
            .add(Blocks.WARPED_ROOTS);

        this.getOrCreateTagBuilder(BlockusBlockTags.WATER_BRICKS)
            .add(bsswBundle(WATER_BRICKS))
            .add(CHISELED_WATER_BRICKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.WHITE_OAK_LOGS)
            .add(WHITE_OAK_LOG)
            .add(WHITE_OAK_WOOD)
            .add(STRIPPED_WHITE_OAK_LOG)
            .add(STRIPPED_WHITE_OAK_WOOD)
            .add(WHITE_OAK_SMALL_LOGS);

        for (BSSWBundle block : BSSWBundle.values()) {
            if (BlockChecker.isWoodenMosaic(block.type, BlockChecker.WOODS)) {
                this.getOrCreateTagBuilder(BlockusBlockTags.ALL_WOODEN_MOSAICS)
                    .add(block.block)
                    .add(block.stairs)
                    .add(block.slab);
            }
            if (BlockChecker.isMossyPlanks(block.type, BlockChecker.WOODS)) {
                this.getOrCreateTagBuilder(BlockusBlockTags.ALL_MOSSY_PLANKS)
                    .add(block.block)
                    .add(block.stairs)
                    .add(block.slab);
            }
        }

        this.getOrCreateTagBuilder(BlockusBlockTags.ALL_WOODEN_MOSAICS)
            .add(Blocks.BAMBOO_MOSAIC)
            .add(Blocks.BAMBOO_MOSAIC_STAIRS)
            .add(Blocks.BAMBOO_MOSAIC_SLAB);

        for (BSSWBundle block : BSSWBundle.values()) {
            if (BlockChecker.isWoodenMosaic(block.type, BlockChecker.FLAMMABLE_WOODS) || BlockChecker.isMossyPlanks(block.type, BlockChecker.FLAMMABLE_WOODS)) {
                this.getOrCreateTagBuilder(Identifier.of("c", "planks_that_burn"))
                    .add(block.block);
            }
        }

        for (CopperBundle copperBundle : CopperBundle.values()) {
            for (Block block : copperBundle.all()) {
                if (block.toString().contains("tuff")) {
                    this.getOrCreateTagBuilder(BlockusBlockTags.TUFF_BLOCKS)
                        .add(block);
                } else {
                    this.getOrCreateTagBuilder(BlockusBlockTags.COPPER_BLOCKS)
                        .add(block);
                }
            }

            this.getOrCreateTagBuilder(BlockTags.WALLS)
                .add(copperBundle.walls());
        }

        this.getOrCreateTagBuilder(Identifier.of("c", "planks_that_burn"))
            .add(Blocks.OAK_PLANKS)
            .add(Blocks.SPRUCE_PLANKS)
            .add(Blocks.BIRCH_PLANKS)
            .add(Blocks.JUNGLE_PLANKS)
            .add(Blocks.ACACIA_PLANKS)
            .add(Blocks.DARK_OAK_PLANKS)
            .add(Blocks.MANGROVE_PLANKS)
            .add(Blocks.CHERRY_PLANKS)
            .add(Blocks.BAMBOO_PLANKS)
            .add(RAW_BAMBOO.planks)
            .add(WHITE_OAK.planks)
            .add(LEGACY_PLANKS)

            .add(HERRINGBONE_OAK_PLANKS)
            .add(HERRINGBONE_BIRCH_PLANKS)
            .add(HERRINGBONE_SPRUCE_PLANKS)
            .add(HERRINGBONE_JUNGLE_PLANKS)
            .add(HERRINGBONE_ACACIA_PLANKS)
            .add(HERRINGBONE_DARK_OAK_PLANKS)
            .add(HERRINGBONE_MANGROVE_PLANKS)
            .add(HERRINGBONE_CHERRY_PLANKS)
            .add(HERRINGBONE_BAMBOO_PLANKS)
            .add(HERRINGBONE_WHITE_OAK_PLANKS)
            .add(HERRINGBONE_RAW_BAMBOO_PLANKS);

        this.getOrCreateTagBuilder(Identifier.of("c", "bars"))
            .add(GOLDEN_BARS);

        // Vanilla Block Tags
        this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(LEGACY_PLANKS)
            .add(SOUL_O_LANTERN)
            .add(REDSTONE_O_LANTERN)
            .add(WOODEN_FRAME)
            .addTag(BlockusBlockTags.FRAMED_PAPER_BLOCKS)
            .addTag(BlockusBlockTags.TIMBER_FRAMES)
            .addTag(BlockusBlockTags.WOODEN_LATTICES)
            .addTag(BlockusBlockTags.WOODEN_GRATES)
            .addTag(BlockusBlockTags.FOOD_CRATES)
            .addTag(BlockusBlockTags.ALL_WOODEN_MOSAICS)
            .addTag(BlockusBlockTags.ALL_MOSSY_PLANKS)
            .addTag(BlockusBlockTags.WOODEN_POSTS);

        this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
            .add(ROTTEN_FLESH_BLOCK)
            .add(CHORUS_BLOCK)
            .add(LEGACY_SPONGE)
            .add(WHITE_OAK_LEAVES)
            .add(LEGACY_LEAVES)
            .addTag(BlockusBlockTags.THATCH)
            .addTag(BlockusBlockTags.SMALL_HEDGES);

        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(NETHERITE_STAIRS)
            .add(NETHERITE_SLAB)
            .add(CHARCOAL_BLOCK)
            .add(ENDER_BLOCK)
            .add(NETHER_STAR_BLOCK)
            .add(LOVE_BLOCK)
            .add(WEIGHT_STORAGE_CUBE)
            .add(COMPANION_CUBE)
            .add(CAUTION_BLOCK)
            .add(STARS_BLOCK)
            .add(LEGACY_BRICKS)
            .add(LEGACY_FIRST_COBBLESTONE)
            .add(LEGACY_COBBLESTONE)
            .add(LEGACY_MOSSY_COBBLESTONE)
            .add(LEGACY_IRON_BLOCK)
            .add(LEGACY_GOLD_BLOCK)
            .add(LEGACY_COAL_BLOCK)
            .add(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK)
            .add(LEGACY_DIAMOND_BLOCK)
            .add(LEGACY_LAPIS_BLOCK)
            .add(LEGACY_STONECUTTER)
            .add(LEGACY_NETHER_REACTOR_CORE)
            .add(GOLDEN_BARS)
            .add(GOLDEN_CHAIN)
            .add(GOLDEN_GATE)
            .add(IRON_GATE)
            .add(LANTERN_BLOCK)
            .add(SOUL_LANTERN_BLOCK)
            .add(REDSTONE_LANTERN)
            .add(REDSTONE_LANTERN_BLOCK)
            .add(AMETHYST_LANTERN)
            .add(AMETHYST_LANTERN_BLOCK)
            .add(bsswBundle(CRIMSON_WART_BRICKS))
            .add(bsswBundle(WARPED_WART_BRICKS))
            .add(bsswBundle(NETHER_TILES))
            .add(bsswBundle(END_TILES))
            .add(CHISELED_MUD_BRICKS)
            .add(MUD_BRICK_PILLAR)
            .add(bsswBundle(IRON_BRICKS))
            .add(bsswBundle(GOLD_BRICKS))
            .add(bsswBundle(LAPIS_BRICKS))
            .add(bsswBundle(REDSTONE_BRICKS))
            .add(bsswBundle(EMERALD_BRICKS))
            .add(bsswBundle(DIAMOND_BRICKS))
            .add(bsswBundle(NETHERITE_BRICKS))
            .addTag(BlockusBlockTags.AMETHYST_BLOCKS)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .addTag(BlockusBlockTags.STAINED_STONE_BRICKS)
            .addTag(BlockusBlockTags.MARBLE)
            .addTag(BlockusBlockTags.LIMESTONE)
            .addTag(BlockusBlockTags.BLUESTONE)
            .addTag(BlockusBlockTags.VIRIDITE)
            .addTag(BlockusBlockTags.PURPUR_BLOCKS)
            .addTag(BlockusBlockTags.QUARTZ_BLOCKS)
            .addTag(BlockusBlockTags.SANDSTONE)
            .addTag(BlockusBlockTags.RED_SANDSTONE)
            .addTag(BlockusBlockTags.SOUL_SANDSTONE)
            .addTag(BlockusBlockTags.STONE_BLOCKS)
            .addTag(BlockusBlockTags.ANDESITE_BLOCKS)
            .addTag(BlockusBlockTags.DIORITE_BLOCKS)
            .addTag(BlockusBlockTags.GRANITE_BLOCKS)
            .addTag(BlockusBlockTags.BLACKSTONE_BLOCKS)
            .addTag(BlockusBlockTags.BASALT_BLOCKS)
            .addTag(BlockusBlockTags.LAVA_BRICKS)
            .addTag(BlockusBlockTags.LAVA_POLISHED_BLACKSTONE_BRICKS)
            .addTag(BlockusBlockTags.WATER_BRICKS)
            .addTag(BlockusBlockTags.SNOW_BRICKS)
            .addTag(BlockusBlockTags.ICE_BRICKS)
            .addTag(BlockusBlockTags.MAGMA_BRICKS)
            .addTag(BlockusBlockTags.BLAZE_BRICKS)
            .addTag(BlockusBlockTags.NETHERRACK_BLOCKS)
            .addTag(BlockusBlockTags.NETHER_BRICKS)
            .addTag(BlockusBlockTags.PRISMARINE_BLOCKS)
            .addTag(BlockusBlockTags.BRICKS_BLOCKS)
            .addTag(BlockusBlockTags.HONEYCOMB_BLOCKS)
            .addTag(BlockusBlockTags.END_STONE_BLOCKS)
            .addTag(BlockusBlockTags.RAINBOW_BLOCKS)
            .addTag(BlockusBlockTags.CONCRETE_BLOCKS)
            .addTag(BlockusBlockTags.DEEPSLATE_BLOCKS)
            .addTag(BlockusBlockTags.SCULK_BLOCKS)
            .addTag(BlockusBlockTags.TUFF_BLOCKS)
            .addTag(BlockusBlockTags.DRIPSTONE_BLOCKS)
            .addTag(BlockusBlockTags.CHOCOLATE_BLOCKS)
            .addTag(BlockusBlockTags.ASPHALT)
            .addTag(BlockusBlockTags.SHINGLES)
            .addTag(BlockusBlockTags.COLORED_TILES)
            .addTag(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS)
            .addTag(BlockusBlockTags.PLATINGS)
            .addTag(BlockusBlockTags.LARGE_FLOWER_POTS)
            .addTag(BlockusBlockTags.COPPER_BLOCKS)
            .addTag(BlockTags.STONE_PRESSURE_PLATES)
            .add(OBSIDIAN_PRESSURE_PLATE);

        this.getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
            .add(PATH)
            .add(SUGAR_BLOCK)
            .add(REDSTONE_SAND)
            .add(LEGACY_FIRST_GRASS_BLOCK)
            .add(LEGACY_GRASS_BLOCK)
            .add(LEGACY_GRAVEL)
            .add(SUGAR_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.ACACIA_LOGS)
            .add(ACACIA_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.BASE_STONE_OVERWORLD)
            .add(LIMESTONE.block)
            .add(MARBLE.block)
            .add(BLUESTONE.block)
            .add(VIRIDITE.block);

        this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
            .add(LEGACY_GOLD_BLOCK)
            .add(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK)
            .add(LEGACY_IRON_BLOCK)
            .add(LEGACY_DIAMOND_BLOCK)
            .add(NETHERITE_SLAB)
            .add(NETHERITE_STAIRS)
            .add(NETHER_STAR_BLOCK)
            .add(bssBundle(IRON_BRICKS))
            .add(bssBundle(GOLD_BRICKS))
            .add(bssBundle(EMERALD_BRICKS))
            .add(bssBundle(DIAMOND_BRICKS))
            .add(bssBundle(NETHERITE_BRICKS));

        this.getOrCreateTagBuilder(BlockTags.BIRCH_LOGS)
            .add(BIRCH_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.BUTTONS)
            .add(POLISHED_ANDESITE_BUTTON)
            .add(POLISHED_DIORITE_BUTTON)
            .add(POLISHED_GRANITE_BUTTON)
            .add(LIMESTONE_BUTTON)
            .add(MARBLE_BUTTON)
            .add(BLUESTONE_BUTTON)
            .add(POLISHED_NETHERRACK_BUTTON)
            .add(POLISHED_END_STONE_BUTTON)
            .add(POLISHED_BASALT_BUTTON)
            .add(POLISHED_DEEPSLATE_BUTTON)
            .add(POLISHED_TUFF_BUTTON)
            .add(POLISHED_SCULK_BUTTON)
            .add(VIRIDITE_BUTTON);

        this.getOrCreateTagBuilder(BlockTags.CHERRY_LOGS)
            .add(CHERRY_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.CRIMSON_STEMS)
            .add(CRIMSON_SMALL_STEMS);

        this.getOrCreateTagBuilder(BlockTags.DARK_OAK_LOGS)
            .add(DARK_OAK_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
            .add(BLUESTONE.block)
            .add(VIRIDITE.block);

        this.getOrCreateTagBuilder(BlockTags.DOORS)
            .add(OBSIDIAN_REINFORCED_DOOR)
            .add(STONE_DOOR)
            .add(BLACKSTONE_DOOR)
            .add(IRON_GATE)
            .add(GOLDEN_GATE);

        this.getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .add(NETHER_STAR_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.FENCE_GATES)
            .add(RAW_BAMBOO.fence_gate)
            .add(CHARRED.fence_gate)
            .add(WHITE_OAK.fence_gate);

        this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
            .add(POTTED_WHITE_OAK_SAPLING)
            .add(POTTED_RAINBOW_ROSE)
            .add(POTTED_LEGACY_ROSE)
            .add(POTTED_LEGACY_BLUE_ROSE);

        this.getOrCreateTagBuilder(BlockTags.FLOWERS)
            .add(FLOWERING_AZALEA_SMALL_HEDGE);

        this.getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
            .add(LEGACY_GOLD_BLOCK)
            .add(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK)
            .add(GOLDEN_CHAIN)
            .add(GOLDEN_BARS)
            .add(GOLDEN_GATE)
            .add(GOLD_DECORATED_SANDSTONE)
            .add(GOLD_DECORATED_RED_SANDSTONE)
            .add(GOLD_DECORATED_SOUL_SANDSTONE)
            .add(GOLD_DECORATED_POLISHED_BLACKSTONE)
            .add(bsswBundle(GOLD_PLATING))
            .add(bsswBundle(GOLD_BRICKS))
            .add(GOLDEN_APPLE_CRATE)
            .add(GOLDEN_CARROT_CRATE);

        this.getOrCreateTagBuilder(BlockTags.ICE)
            .addTag(BlockusBlockTags.ICE_BRICKS)
            .add(ICE_BRICK_WALL);

        this.getOrCreateTagBuilder(BlockTags.IMPERMEABLE)
            .addTag(BlockusBlockTags.BEVELED_GLASS)
            .addTag(BlockusBlockTags.NEON);

        this.getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD)
            .addTag(BlockusBlockTags.NETHERRACK_BLOCKS)
            .addTag(BlockusBlockTags.MAGMA_BRICKS)
            .add(CHARCOAL_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.JUNGLE_LOGS)
            .add(JUNGLE_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.LEAVES)
            .add(WHITE_OAK_LEAVES)
            .add(LEGACY_LEAVES);

        this.getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
            .addTag(BlockusBlockTags.WHITE_OAK_LOGS)
            .add(LEGACY_LOG);

        this.getOrCreateTagBuilder(BlockTags.MANGROVE_LOGS)
            .add(MANGROVE_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .add(NETHERITE_STAIRS)
            .add(NETHERITE_SLAB)
            .add(bsswBundle(NETHERITE_BRICKS));

        this.getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(bsswBundle(GOLD_BRICKS))
            .add(bsswBundle(DIAMOND_BRICKS))
            .add(bsswBundle(EMERALD_BRICKS))
            .add(NETHER_STAR_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(ENDER_BLOCK)
            .add(bsswBundle(IRON_BRICKS))
            .add(bsswBundle(LAPIS_BRICKS));

        this.getOrCreateTagBuilder(BlockTags.OAK_LOGS)
            .add(OAK_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
            .add(WHITE_OAK_LOG);

        this.getOrCreateTagBuilder(BlockTags.PIGLIN_REPELLENTS)
            .add(SOUL_LANTERN_BLOCK)
            .add(SOUL_O_LANTERN);

        this.getOrCreateTagBuilder(BlockTags.PLANKS)
            .add(RAW_BAMBOO.planks)
            .add(CHARRED.planks)
            .add(WHITE_OAK.planks)
            .add(LEGACY_PLANKS)
            .add(HERRINGBONE_OAK_PLANKS)
            .add(HERRINGBONE_BIRCH_PLANKS)
            .add(HERRINGBONE_SPRUCE_PLANKS)
            .add(HERRINGBONE_JUNGLE_PLANKS)
            .add(HERRINGBONE_ACACIA_PLANKS)
            .add(HERRINGBONE_DARK_OAK_PLANKS)
            .add(HERRINGBONE_MANGROVE_PLANKS)
            .add(HERRINGBONE_CHERRY_PLANKS)
            .add(HERRINGBONE_BAMBOO_PLANKS)
            .add(HERRINGBONE_RAW_BAMBOO_PLANKS)
            .add(HERRINGBONE_WHITE_OAK_PLANKS)
            .add(HERRINGBONE_CRIMSON_PLANKS)
            .add(HERRINGBONE_WARPED_PLANKS)
            .add(HERRINGBONE_CHARRED_PLANKS);

        this.getOrCreateTagBuilder(BlockTags.SAPLINGS)
            .add(WHITE_OAK_SAPLING);

        this.getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
            .add(RAINBOW_ROSE)
            .add(LEGACY_ROSE)
            .add(LEGACY_BLUE_ROSE);

        this.getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
            .addTag(BlockusBlockTags.SOUL_SANDSTONE)
            .addTag(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS);

        this.getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS)
            .addTag(BlockusBlockTags.SOUL_SANDSTONE)
            .add(SOUL_SANDSTONE.wall)
            .add(SOUL_SANDSTONE_BRICKS.wall)
            .add(SMALL_SOUL_SANDSTONE_BRICKS.wall);

        this.getOrCreateTagBuilder(BlockTags.SPRUCE_LOGS)
            .add(SPRUCE_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
            .add(RAW_BAMBOO.standing_sign)
            .add(CHARRED.standing_sign)
            .add(WHITE_OAK.standing_sign);

        this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
            .add(RAW_BAMBOO.wall_sign)
            .add(CHARRED.wall_sign)
            .add(WHITE_OAK.wall_sign);

        this.getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
            .add(RAW_BAMBOO.ceiling_hanging_sign)
            .add(CHARRED.ceiling_hanging_sign)
            .add(WHITE_OAK.ceiling_hanging_sign);

        this.getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
            .add(RAW_BAMBOO.wall_hanging_sign)
            .add(CHARRED.wall_hanging_sign)
            .add(WHITE_OAK.wall_hanging_sign);

        this.getOrCreateTagBuilder(BlockTags.STONE_ORE_REPLACEABLES)
            .add(LIMESTONE.block)
            .add(MARBLE.block);

        this.getOrCreateTagBuilder(BlockTags.STONE_PRESSURE_PLATES)
            .add(POLISHED_ANDESITE_PRESSURE_PLATE)
            .add(POLISHED_DIORITE_PRESSURE_PLATE)
            .add(POLISHED_GRANITE_PRESSURE_PLATE)
            .add(LIMESTONE_PRESSURE_PLATE)
            .add(MARBLE_PRESSURE_PLATE)
            .add(BLUESTONE_PRESSURE_PLATE)
            .add(POLISHED_NETHERRACK_PRESSURE_PLATE)
            .add(POLISHED_END_STONE_PRESSURE_PLATE)
            .add(POLISHED_BASALT_PRESSURE_PLATE)
            .add(POLISHED_DEEPSLATE_PRESSURE_PLATE)
            .add(POLISHED_SCULK_PRESSURE_PLATE)
            .add(POLISHED_TUFF_PRESSURE_PLATE)
            .add(VIRIDITE_PRESSURE_PLATE);

        this.getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
            .add(OBSIDIAN_PRESSURE_PLATE);

        this.getOrCreateTagBuilder(BlockTags.TRAPDOORS)
            .add(OBSIDIAN_REINFORCED_TRAPDOOR)
            .add(STONE_TRAPDOOR)
            .add(BLACKSTONE_TRAPDOOR);


        for (BSSWBundle bsswBundle : BSSWBundle.values()) {
            this.getOrCreateTagBuilder(BlockTags.STAIRS).add(bsswBundle.stairs);
            this.getOrCreateTagBuilder(BlockTags.SLABS).add(bsswBundle.slab);
            if (bsswBundle.wall != null) {
                this.getOrCreateTagBuilder(BlockTags.WALLS).add(bsswBundle.wall);
            }
        }

        for (ConcreteBundle concreteType : ConcreteBundle.values()) {
            this.getOrCreateTagBuilder(BlockTags.STAIRS).add(concreteType.stairs);
            this.getOrCreateTagBuilder(BlockTags.SLABS).add(concreteType.slab);
            this.getOrCreateTagBuilder(BlockTags.WALLS).add(concreteType.wall);
        }

        this.getOrCreateTagBuilder(BlockTags.WALLS)
            .addTag(BlockusBlockTags.BARRIERS);

        this.getOrCreateTagBuilder(BlockTags.WARPED_STEMS)
            .add(WARPED_SMALL_STEMS);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
            .add(RAW_BAMBOO.button)
            .add(CHARRED.button)
            .add(WHITE_OAK.button);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
            .add(RAW_BAMBOO.door)
            .add(CHARRED.door)
            .add(WHITE_OAK.door)
            .add(PAPER_DOOR);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
            .add(RAW_BAMBOO.fence)
            .add(CHARRED.fence)
            .add(WHITE_OAK.fence);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
            .add(RAW_BAMBOO.pressure_plate)
            .add(CHARRED.pressure_plate)
            .add(WHITE_OAK.pressure_plate);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
            .add(RAW_BAMBOO.slab)
            .add(CHARRED.slab)
            .add(WHITE_OAK.slab);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
            .add(RAW_BAMBOO.stairs)
            .add(CHARRED.stairs)
            .add(WHITE_OAK.stairs);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
            .add(RAW_BAMBOO.trapdoor)
            .add(CHARRED.trapdoor)
            .add(WHITE_OAK.trapdoor)
            .add(PAPER_TRAPDOOR);

        this.getOrCreateTagBuilder(BlockTags.WOOL)
            .addTag(BlockusBlockTags.ALL_PATTERNED_WOOLS);

        this.getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
            .addTag(BlockusBlockTags.PATTERNED_CARPETS);

        this.getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
            .add(RAINBOW_PETALS);

        this.getOrCreateTagBuilder(BlockTags.ANIMALS_SPAWNABLE_ON)
            .add(LEGACY_GRASS_BLOCK)
            .add(LEGACY_FIRST_GRASS_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.DIRT)
            .add(LEGACY_GRASS_BLOCK)
            .add(LEGACY_FIRST_GRASS_BLOCK);

//        this.getOrCreateTagBuilder(new Identifier("promenade", "cherry_oak_logs"))
//            .addOptional(Blockus.id("cherry_oak_small_logs"));
//
//        this.getOrCreateTagBuilder(new Identifier("promenade", "dark_amaranth_stems"))
//            .addOptional(Blockus.id("dark_amaranth_small_stems"));
//
//        this.getOrCreateTagBuilder(new Identifier("promenade", "leaf_piles"))
//            .addOptional(Blockus.id("white_oak_leaf_pile"));
//
//        this.getOrCreateTagBuilder(new Identifier("promenade", "palm_logs"))
//            .addOptional(Blockus.id("palm_small_logs"));
//
//        this.getOrCreateTagBuilder(new Identifier("promenade", "maple_logs"))
//            .addOptional(Blockus.id("maple_small_logs"));

        // Conventional Block Tags
        this.getOrCreateTagBuilder(ConventionalBlockTags.GLASS_BLOCKS)
            .addTag(BlockusBlockTags.BEVELED_GLASS);
    }

    public static Block[] bsswBundle(BSSWBundle block) {
        // Block, stairs & slab & wall (if exist) variants of a block
        List<Block> list = new ArrayList<>();
        list.add(block.block);
        list.add(block.stairs);
        list.add(block.slab);
        if (block.wall != null) {
            list.add(block.wall);
        }
        return list.toArray(new Block[0]);
    }

    public static Block[] bssBundle(BSSWBundle block) {
        // Block, stairs & slab variants of a block
        return new Block[]{block.block, block.stairs, block.slab};
    }
}
