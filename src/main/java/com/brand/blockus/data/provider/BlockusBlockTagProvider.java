package com.brand.blockus.data.provider;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.types.*;
import com.brand.blockus.tags.BlockusBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

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
            .add(BlockusBlocks.POLISHED_AMETHYST.block)
            .add(BlockusBlocks.POLISHED_AMETHYST.stairs)
            .add(BlockusBlocks.POLISHED_AMETHYST.slab)
            .add(BlockusBlocks.AMETHYST_BRICKS.block)
            .add(BlockusBlocks.AMETHYST_BRICKS.stairs)
            .add(BlockusBlocks.AMETHYST_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_AMETHYST)
            .add(BlockusBlocks.AMETHYST_PILLAR)
            .addOptional(new Identifier(Blockus.MOD_ID, "amethyst_brick_column"));

        this.getOrCreateTagBuilder(BlockusBlockTags.ANDESITE_BLOCKS)
            .add(BlockusBlocks.ANDESITE_BRICKS.block)
            .add(BlockusBlocks.ANDESITE_BRICKS.stairs)
            .add(BlockusBlocks.ANDESITE_BRICKS.slab)
            .add(BlockusBlocks.HERRINGBONE_ANDESITE_BRICKS)
            .add(BlockusBlocks.CHISELED_ANDESITE_BRICKS)
            .add(BlockusBlocks.CRACKED_ANDESITE_BRICKS)
            .add(BlockusBlocks.POLISHED_ANDESITE_PILLAR)
            .add(BlockusBlocks.ANDESITE_CIRCULAR_PAVING);

        for (AsphaltTypes asphaltType : AsphaltTypes.values()) {
            this.getOrCreateTagBuilder(BlockusBlockTags.ASPHALT)
                .add(asphaltType.block)
                .add(asphaltType.stairs)
                .add(asphaltType.slab);
        }

        this.getOrCreateTagBuilder(BlockusBlockTags.ASPHALT)
            .add(BlockusBlocks.RAINBOW_ASPHALT);

        this.getOrCreateTagBuilder(BlockusBlockTags.BARRELS)
            .add(BlockusBlocks.OAK_BARREL)
            .add(Blocks.BARREL)
            .add(BlockusBlocks.BIRCH_BARREL)
            .add(BlockusBlocks.JUNGLE_BARREL)
            .add(BlockusBlocks.ACACIA_BARREL)
            .add(BlockusBlocks.DARK_OAK_BARREL)
            .add(BlockusBlocks.CRIMSON_BARREL)
            .add(BlockusBlocks.WARPED_BARREL)
            .add(BlockusBlocks.BAMBOO_BARREL)
            .add(BlockusBlocks.CHARRED_BARREL)
            .add(BlockusBlocks.WHITE_OAK_BARREL);

        this.getOrCreateTagBuilder(BlockusBlockTags.BARRIERS)
            .add(BlockusBlocks.CAUTION_BARRIER)
            .add(BlockusBlocks.ROAD_BARRIER);

        this.getOrCreateTagBuilder(BlockusBlockTags.BASALT_BLOCKS)
            .add(BlockusBlocks.ROUGH_BASALT.block)
            .add(BlockusBlocks.ROUGH_BASALT.slab)
            .add(BlockusBlocks.ROUGH_BASALT.stairs)
            .add(BlockusBlocks.POLISHED_BASALT_BRICKS.block)
            .add(BlockusBlocks.POLISHED_BASALT_BRICKS.stairs)
            .add(BlockusBlocks.POLISHED_BASALT_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_POLISHED_BASALT)
            .add(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS)
            .add(BlockusBlocks.POLISHED_BASALT_PILLAR)
            .add(BlockusBlocks.HERRINGBONE_POLISHED_BASALT_BRICKS)
            .add(BlockusBlocks.POLISHED_BASALT_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.BEVELED_GLASS)
            .add(BlockusBlocks.BEVELED_GLASS)
            .add(BlockusBlocks.WHITE_BEVELED_GLASS)
            .add(BlockusBlocks.ORANGE_BEVELED_GLASS)
            .add(BlockusBlocks.MAGENTA_BEVELED_GLASS)
            .add(BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS)
            .add(BlockusBlocks.YELLOW_BEVELED_GLASS)
            .add(BlockusBlocks.LIME_BEVELED_GLASS)
            .add(BlockusBlocks.PINK_BEVELED_GLASS)
            .add(BlockusBlocks.GRAY_BEVELED_GLASS)
            .add(BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS)
            .add(BlockusBlocks.CYAN_BEVELED_GLASS)
            .add(BlockusBlocks.PURPLE_BEVELED_GLASS)
            .add(BlockusBlocks.BLUE_BEVELED_GLASS)
            .add(BlockusBlocks.BROWN_BEVELED_GLASS)
            .add(BlockusBlocks.GREEN_BEVELED_GLASS)
            .add(BlockusBlocks.RED_BEVELED_GLASS)
            .add(BlockusBlocks.BLACK_BEVELED_GLASS)
            .add(BlockusBlocks.RAINBOW_BEVELED_GLASS);

        this.getOrCreateTagBuilder(BlockusBlockTags.BLACKSTONE_BLOCKS)
            .add(BlockusBlocks.POLISHED_BLACKSTONE_TILES.block)
            .add(BlockusBlocks.POLISHED_BLACKSTONE_TILES.stairs)
            .add(BlockusBlocks.POLISHED_BLACKSTONE_TILES.slab)
            .add(BlockusBlocks.POLISHED_BLACKSTONE_PILLAR)
            .add(BlockusBlocks.HERRINGBONE_POLISHED_BLACKSTONE_BRICKS)
            .add(BlockusBlocks.POLISHED_BLACKSTONE_CIRCULAR_PAVING)
            .add(BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.block)
            .add(BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.stairs)
            .add(BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.slab)
            .add(BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.block)
            .add(BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.stairs)
            .add(BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.slab)
            .add(BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE)
            .add(BlockusBlocks.BLACKSTONE_DOOR)
            .add(BlockusBlocks.BLACKSTONE_TRAPDOOR)
            .add(BlockusBlocks.STURDY_BLACKSTONE);

        this.getOrCreateTagBuilder(BlockusBlockTags.BLAZE_BRICKS)
            .add(BlockusBlocks.BLAZE_BRICKS.block)
            .add(BlockusBlocks.BLAZE_BRICKS.stairs)
            .add(BlockusBlocks.BLAZE_BRICKS.slab)
            .add(BlockusBlocks.BLAZE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.BLUESTONE)
            .add(BlockusBlocks.BLUESTONE.block)
            .add(BlockusBlocks.BLUESTONE.slab)
            .add(BlockusBlocks.BLUESTONE.stairs)
            .add(BlockusBlocks.BLUESTONE_PILLAR)
            .add(BlockusBlocks.BLUESTONE_BRICKS.block)
            .add(BlockusBlocks.BLUESTONE_BRICKS.stairs)
            .add(BlockusBlocks.BLUESTONE_BRICKS.slab)
            .add(BlockusBlocks.BLUESTONE_TILES.block)
            .add(BlockusBlocks.BLUESTONE_TILES.stairs)
            .add(BlockusBlocks.BLUESTONE_TILES.slab)
            .add(BlockusBlocks.POLISHED_BLUESTONE.block)
            .add(BlockusBlocks.POLISHED_BLUESTONE.stairs)
            .add(BlockusBlocks.POLISHED_BLUESTONE.slab)
            .add(BlockusBlocks.BLUESTONE_SQUARES)
            .add(BlockusBlocks.SMALL_BLUESTONE_BRICKS.block)
            .add(BlockusBlocks.SMALL_BLUESTONE_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_BLUESTONE_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_BLUESTONE)
            .add(BlockusBlocks.BLUESTONE_CIRCULAR_PAVING)
            .add(BlockusBlocks.CHISELED_BLUESTONE_PILLAR)
            .add(BlockusBlocks.BLUESTONE_LINES);

        this.getOrCreateTagBuilder(BlockusBlockTags.BRICKS_BLOCKS)
            .add(BlockusBlocks.LARGE_BRICKS.block)
            .add(BlockusBlocks.LARGE_BRICKS.stairs)
            .add(BlockusBlocks.LARGE_BRICKS.slab)
            .add(BlockusBlocks.HERRINGBONE_BRICKS)
            .add(BlockusBlocks.SOAKED_BRICKS.block)
            .add(BlockusBlocks.SOAKED_BRICKS.stairs)
            .add(BlockusBlocks.SOAKED_BRICKS.slab)
            .add(BlockusBlocks.HERRINGBONE_SOAKED_BRICKS)
            .add(BlockusBlocks.SANDY_BRICKS.block)
            .add(BlockusBlocks.SANDY_BRICKS.stairs)
            .add(BlockusBlocks.SANDY_BRICKS.slab)
            .add(BlockusBlocks.HERRINGBONE_SANDY_BRICKS)
            .add(BlockusBlocks.CHARRED_BRICKS.block)
            .add(BlockusBlocks.CHARRED_BRICKS.stairs)
            .add(BlockusBlocks.CHARRED_BRICKS.slab)
            .add(BlockusBlocks.HERRINGBONE_CHARRED_BRICKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.CHOCOLATE_BLOCKS)
            .add(BlockusBlocks.CHOCOLATE_BLOCK.block)
            .add(BlockusBlocks.CHOCOLATE_BLOCK.stairs)
            .add(BlockusBlocks.CHOCOLATE_BLOCK.slab)
            .add(BlockusBlocks.CHOCOLATE_BRICKS.block)
            .add(BlockusBlocks.CHOCOLATE_BRICKS.stairs)
            .add(BlockusBlocks.CHOCOLATE_BRICKS.slab)
            .add(BlockusBlocks.CHOCOLATE_SQUARES)
            .add(BlockusBlocks.CHOCOLATE_TABLET);


        this.getOrCreateTagBuilder(BlockusBlockTags.COLORED_TILES)
            .add(BlockusBlocks.WHITE_COLORED_TILES)
            .add(BlockusBlocks.ORANGE_COLORED_TILES)
            .add(BlockusBlocks.MAGENTA_COLORED_TILES)
            .add(BlockusBlocks.LIGHT_BLUE_COLORED_TILES)
            .add(BlockusBlocks.YELLOW_COLORED_TILES)
            .add(BlockusBlocks.LIME_COLORED_TILES)
            .add(BlockusBlocks.PINK_COLORED_TILES)
            .add(BlockusBlocks.GRAY_COLORED_TILES)
            .add(BlockusBlocks.LIGHT_GRAY_COLORED_TILES)
            .add(BlockusBlocks.CYAN_COLORED_TILES)
            .add(BlockusBlocks.PURPLE_COLORED_TILES)
            .add(BlockusBlocks.BLUE_COLORED_TILES)
            .add(BlockusBlocks.BROWN_COLORED_TILES)
            .add(BlockusBlocks.GREEN_COLORED_TILES)
            .add(BlockusBlocks.RED_COLORED_TILES)
            .add(BlockusBlocks.BLACK_COLORED_TILES)
            .add(BlockusBlocks.ORANGE_WHITE_COLORED_TILES)
            .add(BlockusBlocks.MAGENTA_WHITE_COLORED_TILES)
            .add(BlockusBlocks.LIGHT_BLUE_WHITE_COLORED_TILES)
            .add(BlockusBlocks.YELLOW_WHITE_COLORED_TILES)
            .add(BlockusBlocks.LIME_WHITE_COLORED_TILES)
            .add(BlockusBlocks.PINK_WHITE_COLORED_TILES)
            .add(BlockusBlocks.GRAY_WHITE_COLORED_TILES)
            .add(BlockusBlocks.LIGHT_GRAY_WHITE_COLORED_TILES)
            .add(BlockusBlocks.CYAN_WHITE_COLORED_TILES)
            .add(BlockusBlocks.PURPLE_WHITE_COLORED_TILES)
            .add(BlockusBlocks.BLUE_WHITE_COLORED_TILES)
            .add(BlockusBlocks.BROWN_WHITE_COLORED_TILES)
            .add(BlockusBlocks.GREEN_WHITE_COLORED_TILES)
            .add(BlockusBlocks.RED_WHITE_COLORED_TILES)
            .add(BlockusBlocks.BLACK_WHITE_COLORED_TILES)
            .add(BlockusBlocks.GRAY_LIGHT_GRAY_COLORED_TILES)
            .add(BlockusBlocks.BLACK_GRAY_COLORED_TILES)
            .add(BlockusBlocks.BLACK_RED_COLORED_TILES)
            .add(BlockusBlocks.BLACK_BLUE_COLORED_TILES)
            .add(BlockusBlocks.MAGENTA_BLACK_COLORED_TILES)
            .add(BlockusBlocks.PINK_MAGENTA_COLORED_TILES)
            .add(BlockusBlocks.PURPLE_ORANGE_COLORED_TILES)
            .add(BlockusBlocks.PURPLE_BLUE_COLORED_TILES)
            .add(BlockusBlocks.GREEN_ORANGE_COLORED_TILES)
            .add(BlockusBlocks.GREEN_BROWN_COLORED_TILES)
            .add(BlockusBlocks.LIME_YELLOW_COLORED_TILES)
            .add(BlockusBlocks.LIGHT_BLUE_YELLOW_COLORED_TILES)
            .add(BlockusBlocks.BLUE_CYAN_COLORED_TILES)
            .add(BlockusBlocks.RED_BLUE_COLORED_TILES)
            .add(BlockusBlocks.RAINBOW_COLORED_TILES);

        for (ConcreteTypes concreteType : ConcreteTypes.values()) {
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
            .add(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block)
            .add(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.stairs)
            .add(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.slab)
            .add(BlockusBlocks.HERRINGBONE_DEEPSLATE_BRICKS)
            .add(BlockusBlocks.DEEPSLATE_PILLAR)
            .add(BlockusBlocks.DEEPSLATE_CIRCULAR_PAVING)
            .add(BlockusBlocks.STURDY_DEEPSLATE);

        this.getOrCreateTagBuilder(BlockusBlockTags.DIORITE_BLOCKS)
            .add(BlockusBlocks.DIORITE_BRICKS.block)
            .add(BlockusBlocks.DIORITE_BRICKS.stairs)
            .add(BlockusBlocks.DIORITE_BRICKS.slab)
            .add(BlockusBlocks.HERRINGBONE_DIORITE_BRICKS)
            .add(BlockusBlocks.CHISELED_DIORITE_BRICKS)
            .add(BlockusBlocks.CRACKED_DIORITE_BRICKS)
            .add(BlockusBlocks.POLISHED_DIORITE_PILLAR)
            .add(BlockusBlocks.DIORITE_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.DRIPSTONE_BLOCKS)
            .add(BlockusBlocks.POLISHED_DRIPSTONE.block)
            .add(BlockusBlocks.POLISHED_DRIPSTONE.stairs)
            .add(BlockusBlocks.POLISHED_DRIPSTONE.slab)
            .add(BlockusBlocks.DRIPSTONE_BRICKS.block)
            .add(BlockusBlocks.DRIPSTONE_BRICKS.stairs)
            .add(BlockusBlocks.DRIPSTONE_BRICKS.slab)
            .add(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS)
            .add(BlockusBlocks.CHISELED_DRIPSTONE)
            .add(BlockusBlocks.DRIPSTONE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.END_STONE_BLOCKS)
            .add(BlockusBlocks.CHISELED_END_STONE_BRICKS)
            .add(BlockusBlocks.HERRINGBONE_END_STONE_BRICKS)
            .add(BlockusBlocks.POLISHED_END_STONE.block)
            .add(BlockusBlocks.POLISHED_END_STONE.stairs)
            .add(BlockusBlocks.POLISHED_END_STONE.slab)
            .add(BlockusBlocks.CRACKED_END_STONE_BRICKS)
            .add(BlockusBlocks.END_STONE_PILLAR)
            .add(BlockusBlocks.SMALL_END_STONE_BRICKS.block)
            .add(BlockusBlocks.SMALL_END_STONE_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_END_STONE_BRICKS.slab)
            .add(BlockusBlocks.PURPUR_DECORATED_END_STONE)
            .add(BlockusBlocks.PHANTOM_PURPUR_DECORATED_END_STONE);

        this.getOrCreateTagBuilder(BlockusBlockTags.FOOD_CRATES)
            .add(BlockusBlocks.SWEET_BERRIES_CRATE)
            .add(BlockusBlocks.SALMON_CRATE)
            .add(BlockusBlocks.PUFFERFISH_CRATE)
            .add(BlockusBlocks.TROPICAL_FISH_CRATE)
            .add(BlockusBlocks.COD_CRATE)
            .add(BlockusBlocks.POTATO_CRATE)
            .add(BlockusBlocks.APPLE_CRATE)
            .add(BlockusBlocks.BEETROOT_CRATE)
            .add(BlockusBlocks.CARROT_CRATE)
            .add(BlockusBlocks.BREAD_BOX)
            .add(BlockusBlocks.GOLDEN_APPLE_CRATE)
            .add(BlockusBlocks.GOLDEN_CARROT_CRATE)
            .add(BlockusBlocks.GLOW_BERRIES_CRATE)
            .addOptional(new Identifier(Blockus.MOD_ID, "blueberries_crate"));

        this.getOrCreateTagBuilder(BlockusBlockTags.FRAMED_PAPER_BLOCKS)
            .add(BlockusBlocks.FRAMED_PAPER_BLOCK)
            .add(BlockusBlocks.PAPER_WALL)
            .add(BlockusBlocks.PAPER_DOOR)
            .add(BlockusBlocks.PAPER_TRAPDOOR);

        this.getOrCreateTagBuilder(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS)
            .add(BlockusBlocks.WHITE_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.ORANGE_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.MAGENTA_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.YELLOW_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.LIME_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.PINK_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.GRAY_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.CYAN_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.PURPLE_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.BLUE_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.BROWN_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.GREEN_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.RED_GLAZED_TERRACOTTA_PILLAR)
            .add(BlockusBlocks.BLACK_GLAZED_TERRACOTTA_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.GRANITE_BLOCKS)
            .add(BlockusBlocks.GRANITE_BRICKS.block)
            .add(BlockusBlocks.GRANITE_BRICKS.stairs)
            .add(BlockusBlocks.GRANITE_BRICKS.slab)
            .add(BlockusBlocks.HERRINGBONE_GRANITE_BRICKS)
            .add(BlockusBlocks.CHISELED_GRANITE_BRICKS)
            .add(BlockusBlocks.CRACKED_GRANITE_BRICKS)
            .add(BlockusBlocks.POLISHED_GRANITE_PILLAR)
            .add(BlockusBlocks.GRANITE_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.HONEYCOMB_BLOCKS)
            .add(BlockusBlocks.HONEYCOMB_BRICKS.block)
            .add(BlockusBlocks.HONEYCOMB_BRICKS.stairs)
            .add(BlockusBlocks.HONEYCOMB_BRICKS.slab);

        this.getOrCreateTagBuilder(BlockusBlockTags.ICE_BRICKS)
            .add(BlockusBlocks.ICE_BRICKS)
            .add(BlockusBlocks.ICE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.LARGE_FLOWER_POTS)
            .add(BlockusBlocks.LARGE_FLOWER_POT)
            .add(BlockusBlocks.POTTED_ROSE_BUSH.block)
            .add(BlockusBlocks.POTTED_LILAC.block)
            .add(BlockusBlocks.POTTED_PEONY.block)
            .add(BlockusBlocks.POTTED_LARGE_FERN.block)
            .add(BlockusBlocks.POTTED_OAK.block)
            .add(BlockusBlocks.POTTED_SPRUCE.block)
            .add(BlockusBlocks.POTTED_BIRCH.block)
            .add(BlockusBlocks.POTTED_JUNGLE.block)
            .add(BlockusBlocks.POTTED_ACACIA.block)
            .add(BlockusBlocks.POTTED_DARK_OAK.block)
            .add(BlockusBlocks.POTTED_MANGROVE.block)
            .add(BlockusBlocks.POTTED_WHITE_OAK.block)
            .add(BlockusBlocks.POTTED_HUGE_RED_MUSHROOM.block)
            .add(BlockusBlocks.POTTED_HUGE_BROWN_MUSHROOM.block)
            .add(BlockusBlocks.POTTED_HUGE_CRIMSON_FUNGUS.block)
            .add(BlockusBlocks.POTTED_HUGE_WARPED_FUNGUS.block)
            .add(BlockusBlocks.POTTED_CACTUS_LARGE.block)
            .add(BlockusBlocks.POTTED_BAMBOO_LARGE.block)
            .addOptional(new Identifier(Blockus.MOD_ID, "potted_autumn_birch"))
            .addOptional(new Identifier(Blockus.MOD_ID, "potted_autumn_oak"))
            .addOptional(new Identifier(Blockus.MOD_ID, "potted_palm"))
            .addOptional(new Identifier(Blockus.MOD_ID, "potted_pink_cherry_oak"))
            .addOptional(new Identifier(Blockus.MOD_ID, "potted_white_cherry_oak"))
            .addOptional(new Identifier(Blockus.MOD_ID, "potted_huge_dark_amaranth_fungus"));

        this.getOrCreateTagBuilder(BlockusBlockTags.LAVA_BRICKS)
            .add(BlockusBlocks.LAVA_BRICKS.block)
            .add(BlockusBlocks.LAVA_BRICKS.stairs)
            .add(BlockusBlocks.LAVA_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_LAVA_BRICKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.LAVA_POLISHED_BLACKSTONE_BRICKS)
            .add(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.block)
            .add(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.stairs)
            .add(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_LAVA_POLISHED_BLACKSTONE);

        this.getOrCreateTagBuilder(BlockusBlockTags.LIMESTONE)
            .add(BlockusBlocks.LIMESTONE.block)
            .add(BlockusBlocks.LIMESTONE.stairs)
            .add(BlockusBlocks.LIMESTONE.slab)
            .add(BlockusBlocks.POLISHED_LIMESTONE.block)
            .add(BlockusBlocks.POLISHED_LIMESTONE.stairs)
            .add(BlockusBlocks.POLISHED_LIMESTONE.slab)
            .add(BlockusBlocks.LIMESTONE_BRICKS.block)
            .add(BlockusBlocks.LIMESTONE_BRICKS.stairs)
            .add(BlockusBlocks.LIMESTONE_BRICKS.slab)
            .add(BlockusBlocks.LIMESTONE_TILES.block)
            .add(BlockusBlocks.LIMESTONE_TILES.stairs)
            .add(BlockusBlocks.LIMESTONE_TILES.slab)
            .add(BlockusBlocks.LIMESTONE_PILLAR)
            .add(BlockusBlocks.LIMESTONE_SQUARES)
            .add(BlockusBlocks.SMALL_LIMESTONE_BRICKS.block)
            .add(BlockusBlocks.SMALL_LIMESTONE_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_LIMESTONE_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_LIMESTONE)
            .add(BlockusBlocks.CHISELED_LIMESTONE_PILLAR)
            .add(BlockusBlocks.LIMESTONE_LINES)
            .add(BlockusBlocks.LIMESTONE_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.VIRIDITE)
            .add(BlockusBlocks.VIRIDITE.block)
            .add(BlockusBlocks.VIRIDITE.stairs)
            .add(BlockusBlocks.VIRIDITE.slab)
            .add(BlockusBlocks.POLISHED_VIRIDITE.block)
            .add(BlockusBlocks.POLISHED_VIRIDITE.stairs)
            .add(BlockusBlocks.POLISHED_VIRIDITE.slab)
            .add(BlockusBlocks.VIRIDITE_BRICKS.block)
            .add(BlockusBlocks.VIRIDITE_BRICKS.stairs)
            .add(BlockusBlocks.VIRIDITE_BRICKS.slab)
            .add(BlockusBlocks.VIRIDITE_TILES.block)
            .add(BlockusBlocks.VIRIDITE_TILES.stairs)
            .add(BlockusBlocks.VIRIDITE_TILES.slab)
            .add(BlockusBlocks.VIRIDITE_PILLAR)
            .add(BlockusBlocks.VIRIDITE_SQUARES)
            .add(BlockusBlocks.SMALL_VIRIDITE_BRICKS.block)
            .add(BlockusBlocks.SMALL_VIRIDITE_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_VIRIDITE_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_VIRIDITE)
            .add(BlockusBlocks.CHISELED_VIRIDITE_PILLAR)
            .add(BlockusBlocks.VIRIDITE_CIRCULAR_PAVING)
            .add(BlockusBlocks.VIRIDITE_LINES);

        this.getOrCreateTagBuilder(BlockusBlockTags.MAGMA_BRICKS)
            .add(BlockusBlocks.MAGMA_BRICKS.block)
            .add(BlockusBlocks.MAGMA_BRICKS.stairs)
            .add(BlockusBlocks.MAGMA_BRICKS.slab)
            .add(BlockusBlocks.SMALL_MAGMA_BRICKS.block)
            .add(BlockusBlocks.SMALL_MAGMA_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_MAGMA_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_MAGMA_BRICKS)
            .addOptional(new Identifier(Blockus.MOD_ID, "magma_brick_column"));

        this.getOrCreateTagBuilder(BlockusBlockTags.MARBLE)
            .add(BlockusBlocks.MARBLE.block)
            .add(BlockusBlocks.MARBLE.stairs)
            .add(BlockusBlocks.MARBLE.slab)
            .add(BlockusBlocks.POLISHED_MARBLE.block)
            .add(BlockusBlocks.POLISHED_MARBLE.stairs)
            .add(BlockusBlocks.POLISHED_MARBLE.slab)
            .add(BlockusBlocks.MARBLE_BRICKS.block)
            .add(BlockusBlocks.MARBLE_BRICKS.stairs)
            .add(BlockusBlocks.MARBLE_BRICKS.slab)
            .add(BlockusBlocks.MARBLE_TILES.block)
            .add(BlockusBlocks.MARBLE_TILES.stairs)
            .add(BlockusBlocks.MARBLE_TILES.slab)
            .add(BlockusBlocks.MARBLE_PILLAR)
            .add(BlockusBlocks.MARBLE_SQUARES)
            .add(BlockusBlocks.SMALL_MARBLE_BRICKS.block)
            .add(BlockusBlocks.SMALL_MARBLE_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_MARBLE_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_MARBLE_PILLAR)
            .add(BlockusBlocks.CHISELED_MARBLE)
            .add(BlockusBlocks.MARBLE_LINES)
            .add(BlockusBlocks.MARBLE_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.NEON)
            .add(BlockusBlocks.WHITE_NEON)
            .add(BlockusBlocks.ORANGE_NEON)
            .add(BlockusBlocks.MAGENTA_NEON)
            .add(BlockusBlocks.LIGHT_BLUE_NEON)
            .add(BlockusBlocks.YELLOW_NEON)
            .add(BlockusBlocks.LIME_NEON)
            .add(BlockusBlocks.PINK_NEON)
            .add(BlockusBlocks.GRAY_NEON)
            .add(BlockusBlocks.LIGHT_GRAY_NEON)
            .add(BlockusBlocks.CYAN_NEON)
            .add(BlockusBlocks.PURPLE_NEON)
            .add(BlockusBlocks.BLUE_NEON)
            .add(BlockusBlocks.BROWN_NEON)
            .add(BlockusBlocks.GREEN_NEON)
            .add(BlockusBlocks.RED_NEON)
            .add(BlockusBlocks.BLACK_NEON);

        this.getOrCreateTagBuilder(BlockusBlockTags.NETHER_BRICKS)
            .add(BlockusBlocks.POLISHED_NETHER_BRICKS)
            .add(BlockusBlocks.POLISHED_RED_NETHER_BRICKS)
            .add(BlockusBlocks.HERRINGBONE_NETHER_BRICKS)
            .add(BlockusBlocks.HERRINGBONE_RED_NETHER_BRICKS)
            .add(BlockusBlocks.NETHER_BRICK_PILLAR)
            .add(BlockusBlocks.RED_NETHER_BRICK_PILLAR)
            .add(BlockusBlocks.CHARRED_NETHER_BRICKS.block)
            .add(BlockusBlocks.CHARRED_NETHER_BRICKS.stairs)
            .add(BlockusBlocks.CHARRED_NETHER_BRICKS.slab)
            .add(BlockusBlocks.POLISHED_CHARRED_NETHER_BRICKS)
            .add(BlockusBlocks.HERRINGBONE_CHARRED_NETHER_BRICKS)
            .add(BlockusBlocks.CHARRED_NETHER_BRICK_PILLAR)
            .add(BlockusBlocks.TEAL_NETHER_BRICKS.block)
            .add(BlockusBlocks.TEAL_NETHER_BRICKS.stairs)
            .add(BlockusBlocks.TEAL_NETHER_BRICKS.slab)
            .add(BlockusBlocks.POLISHED_TEAL_NETHER_BRICKS)
            .add(BlockusBlocks.HERRINGBONE_TEAL_NETHER_BRICKS)
            .add(BlockusBlocks.TEAL_NETHER_BRICK_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.NETHERRACK_BLOCKS)
            .add(BlockusBlocks.POLISHED_NETHERRACK.block)
            .add(BlockusBlocks.POLISHED_NETHERRACK.stairs)
            .add(BlockusBlocks.POLISHED_NETHERRACK.slab)
            .add(BlockusBlocks.NETHERRACK_BRICKS.block)
            .add(BlockusBlocks.NETHERRACK_BRICKS.stairs)
            .add(BlockusBlocks.NETHERRACK_BRICKS.slab)
            .add(BlockusBlocks.NETHERRACK_CIRCULAR_PAVING)
            .addOptional(new Identifier(Blockus.MOD_ID, "netherrack_brick_column"));

        this.getOrCreateTagBuilder(BlockusBlockTags.OBSIDIAN)
            .add(BlockusBlocks.OBSIDIAN_BRICKS.block)
            .add(BlockusBlocks.OBSIDIAN_BRICKS.stairs)
            .add(BlockusBlocks.OBSIDIAN_BRICKS.slab)
            .add(BlockusBlocks.OBSIDIAN_BRICKS.wall)
            .add(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS)
            .add(BlockusBlocks.SMALL_OBSIDIAN_BRICKS.block)
            .add(BlockusBlocks.SMALL_OBSIDIAN_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_OBSIDIAN_BRICKS.slab)
            .add(BlockusBlocks.SMALL_OBSIDIAN_BRICKS.wall)
            .add(BlockusBlocks.OBSIDIAN_PILLAR)
            .add(BlockusBlocks.OBSIDIAN_CIRCULAR_PAVING)
            .add(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR)
            .add(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR)
            .add(BlockusBlocks.GLOWING_OBSIDIAN)
            .add(BlockusBlocks.LEGACY_CRYING_OBSIDIAN)
            .add(BlockusBlocks.LEGACY_GLOWING_OBSIDIAN)
            .addOptional(new Identifier(Blockus.MOD_ID, "obsidian_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_obsidian_brick_column"));

        this.getOrCreateTagBuilder(BlockusBlockTags.PATTERNED_WOOL)
            .add(BlockusBlocks.WHITE_PATTERNED_WOOL.block)
            .add(BlockusBlocks.ORANGE_PATTERNED_WOOL.block)
            .add(BlockusBlocks.MAGENTA_PATTERNED_WOOL.block)
            .add(BlockusBlocks.LIGHT_BLUE_PATTERNED_WOOL.block)
            .add(BlockusBlocks.YELLOW_PATTERNED_WOOL.block)
            .add(BlockusBlocks.LIME_PATTERNED_WOOL.block)
            .add(BlockusBlocks.PINK_PATTERNED_WOOL.block)
            .add(BlockusBlocks.GRAY_PATTERNED_WOOL.block)
            .add(BlockusBlocks.LIGHT_GRAY_PATTERNED_WOOL.block)
            .add(BlockusBlocks.CYAN_PATTERNED_WOOL.block)
            .add(BlockusBlocks.PURPLE_PATTERNED_WOOL.block)
            .add(BlockusBlocks.BLUE_PATTERNED_WOOL.block)
            .add(BlockusBlocks.BROWN_PATTERNED_WOOL.block)
            .add(BlockusBlocks.GREEN_PATTERNED_WOOL.block)
            .add(BlockusBlocks.RED_PATTERNED_WOOL.block)
            .add(BlockusBlocks.BLACK_PATTERNED_WOOL.block);

        this.getOrCreateTagBuilder(BlockusBlockTags.PATTERNED_CARPETS)
            .add(BlockusBlocks.WHITE_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.ORANGE_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.MAGENTA_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.LIGHT_BLUE_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.YELLOW_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.LIME_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.PINK_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.GRAY_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.LIGHT_GRAY_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.CYAN_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.PURPLE_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.BLUE_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.BROWN_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.GREEN_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.RED_PATTERNED_WOOL.carpet)
            .add(BlockusBlocks.BLACK_PATTERNED_WOOL.carpet);

        this.getOrCreateTagBuilder(BlockusBlockTags.ALL_PATTERNED_WOOLS)
            .addTag(BlockusBlockTags.PATTERNED_WOOL)
            .addTag(BlockusBlockTags.PATTERNED_CARPETS)
            .add(BlockusBlocks.WHITE_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.ORANGE_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.MAGENTA_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.LIGHT_BLUE_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.YELLOW_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.LIME_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.PINK_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.GRAY_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.LIGHT_GRAY_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.CYAN_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.PURPLE_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.BLUE_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.BROWN_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.GREEN_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.RED_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.BLACK_PATTERNED_WOOL.stairs)
            .add(BlockusBlocks.WHITE_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.ORANGE_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.MAGENTA_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.LIGHT_BLUE_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.YELLOW_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.LIME_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.PINK_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.GRAY_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.LIGHT_GRAY_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.CYAN_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.PURPLE_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.BLUE_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.BROWN_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.GREEN_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.RED_PATTERNED_WOOL.slab)
            .add(BlockusBlocks.BLACK_PATTERNED_WOOL.slab);

        this.getOrCreateTagBuilder(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS)
            .add(BlockusBlocks.PHANTOM_PURPUR_BLOCK.block)
            .add(BlockusBlocks.PHANTOM_PURPUR_BLOCK.slab)
            .add(BlockusBlocks.PHANTOM_PURPUR_BLOCK.stairs)
            .add(BlockusBlocks.PHANTOM_PURPUR_PILLAR)
            .add(BlockusBlocks.PHANTOM_PURPUR_BRICKS.block)
            .add(BlockusBlocks.PHANTOM_PURPUR_BRICKS.stairs)
            .add(BlockusBlocks.PHANTOM_PURPUR_BRICKS.slab)
            .add(BlockusBlocks.POLISHED_PHANTOM_PURPUR.block)
            .add(BlockusBlocks.POLISHED_PHANTOM_PURPUR.stairs)
            .add(BlockusBlocks.POLISHED_PHANTOM_PURPUR.slab)
            .add(BlockusBlocks.PHANTOM_PURPUR_SQUARES)
            .add(BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.block)
            .add(BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_PHANTOM_PURPUR)
            .add(BlockusBlocks.PHANTOM_PURPUR_LINES)
            .addOptional(new Identifier(Blockus.MOD_ID, "phantom_purpur_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_phantom_purpur_brick_column"));

        this.getOrCreateTagBuilder(BlockusBlockTags.PLATINGS)
            .add(BlockusBlocks.IRON_PLATING.block)
            .add(BlockusBlocks.IRON_PLATING.stairs)
            .add(BlockusBlocks.IRON_PLATING.slab)
            .add(BlockusBlocks.GOLD_PLATING.block)
            .add(BlockusBlocks.GOLD_PLATING.stairs)
            .add(BlockusBlocks.GOLD_PLATING.slab);

        this.getOrCreateTagBuilder(BlockusBlockTags.PRISMARINE_BLOCKS)
            .add(BlockusBlocks.PRISMARINE_CIRCULAR_PAVING)
            .add(BlockusBlocks.CHISELED_DARK_PRISMARINE)
            .add(BlockusBlocks.DARK_PRISMARINE_PILLAR)
            .add(BlockusBlocks.CHISELED_PRISMARINE)
            .add(BlockusBlocks.PRISMARINE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.PURPUR_BLOCKS)
            .add(BlockusBlocks.PURPUR_BRICKS.block)
            .add(BlockusBlocks.PURPUR_BRICKS.stairs)
            .add(BlockusBlocks.PURPUR_BRICKS.slab)
            .add(BlockusBlocks.POLISHED_PURPUR.block)
            .add(BlockusBlocks.POLISHED_PURPUR.stairs)
            .add(BlockusBlocks.POLISHED_PURPUR.slab)
            .add(BlockusBlocks.PURPUR_SQUARES)
            .add(BlockusBlocks.SMALL_PURPUR_BRICKS.block)
            .add(BlockusBlocks.SMALL_PURPUR_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_PURPUR_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_PURPUR)
            .add(BlockusBlocks.PURPUR_LINES)
            .addTag(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.QUARTZ_BLOCKS)
            .add(BlockusBlocks.QUARTZ_TILES.block)
            .add(BlockusBlocks.QUARTZ_TILES.stairs)
            .add(BlockusBlocks.QUARTZ_TILES.slab)
            .add(BlockusBlocks.QUARTZ_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.RAINBOW_BLOCKS)
            .add(BlockusBlocks.RAINBOW_BLOCK)
            .add(BlockusBlocks.RAINBOW_BRICKS.block)
            .add(BlockusBlocks.RAINBOW_BRICKS.stairs)
            .add(BlockusBlocks.RAINBOW_BRICKS.slab);

        this.getOrCreateTagBuilder(BlockusBlockTags.RED_SANDSTONE)
            .add(BlockusBlocks.ROUGH_RED_SANDSTONE.block)
            .add(BlockusBlocks.ROUGH_RED_SANDSTONE.slab)
            .add(BlockusBlocks.ROUGH_RED_SANDSTONE.stairs)
            .add(BlockusBlocks.RED_SANDSTONE_BRICKS.block)
            .add(BlockusBlocks.RED_SANDSTONE_BRICKS.slab)
            .add(BlockusBlocks.RED_SANDSTONE_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.block)
            .add(BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.slab)
            .add(BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.stairs)
            .add(BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE)
            .add(BlockusBlocks.LAPIS_DECORATED_RED_SANDSTONE)
            .add(BlockusBlocks.RED_SANDSTONE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.SANDSTONE)
            .add(BlockusBlocks.ROUGH_SANDSTONE.block)
            .add(BlockusBlocks.ROUGH_SANDSTONE.slab)
            .add(BlockusBlocks.ROUGH_SANDSTONE.stairs)
            .add(BlockusBlocks.SANDSTONE_BRICKS.block)
            .add(BlockusBlocks.SANDSTONE_BRICKS.slab)
            .add(BlockusBlocks.SANDSTONE_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_SANDSTONE_BRICKS.block)
            .add(BlockusBlocks.SMALL_SANDSTONE_BRICKS.slab)
            .add(BlockusBlocks.SMALL_SANDSTONE_BRICKS.stairs)
            .add(BlockusBlocks.GOLD_DECORATED_SANDSTONE)
            .add(BlockusBlocks.LAPIS_DECORATED_SANDSTONE)
            .add(BlockusBlocks.SANDSTONE_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.SCULK_BLOCKS)
            .add(BlockusBlocks.POLISHED_SCULK.block)
            .add(BlockusBlocks.POLISHED_SCULK.stairs)
            .add(BlockusBlocks.POLISHED_SCULK.slab)
            .add(BlockusBlocks.SCULK_BRICKS.block)
            .add(BlockusBlocks.SCULK_BRICKS.stairs)
            .add(BlockusBlocks.SCULK_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_SCULK_BRICKS)
            .add(BlockusBlocks.SCULK_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.SHINGLES)
            .add(BlockusBlocks.SHINGLES.block)
            .add(BlockusBlocks.WHITE_SHINGLES.block)
            .add(BlockusBlocks.ORANGE_SHINGLES.block)
            .add(BlockusBlocks.MAGENTA_SHINGLES.block)
            .add(BlockusBlocks.LIGHT_BLUE_SHINGLES.block)
            .add(BlockusBlocks.YELLOW_SHINGLES.block)
            .add(BlockusBlocks.LIME_SHINGLES.block)
            .add(BlockusBlocks.PINK_SHINGLES.block)
            .add(BlockusBlocks.GRAY_SHINGLES.block)
            .add(BlockusBlocks.LIGHT_GRAY_SHINGLES.block)
            .add(BlockusBlocks.CYAN_SHINGLES.block)
            .add(BlockusBlocks.PURPLE_SHINGLES.block)
            .add(BlockusBlocks.BLUE_SHINGLES.block)
            .add(BlockusBlocks.BROWN_SHINGLES.block)
            .add(BlockusBlocks.GREEN_SHINGLES.block)
            .add(BlockusBlocks.RED_SHINGLES.block)
            .add(BlockusBlocks.BLACK_SHINGLES.block)
            .add(BlockusBlocks.SHINGLES.stairs)
            .add(BlockusBlocks.WHITE_SHINGLES.stairs)
            .add(BlockusBlocks.ORANGE_SHINGLES.stairs)
            .add(BlockusBlocks.MAGENTA_SHINGLES.stairs)
            .add(BlockusBlocks.LIGHT_BLUE_SHINGLES.stairs)
            .add(BlockusBlocks.YELLOW_SHINGLES.stairs)
            .add(BlockusBlocks.LIME_SHINGLES.stairs)
            .add(BlockusBlocks.PINK_SHINGLES.stairs)
            .add(BlockusBlocks.GRAY_SHINGLES.stairs)
            .add(BlockusBlocks.LIGHT_GRAY_SHINGLES.stairs)
            .add(BlockusBlocks.CYAN_SHINGLES.stairs)
            .add(BlockusBlocks.PURPLE_SHINGLES.stairs)
            .add(BlockusBlocks.BLUE_SHINGLES.stairs)
            .add(BlockusBlocks.BROWN_SHINGLES.stairs)
            .add(BlockusBlocks.GREEN_SHINGLES.stairs)
            .add(BlockusBlocks.RED_SHINGLES.stairs)
            .add(BlockusBlocks.BLACK_SHINGLES.stairs)
            .add(BlockusBlocks.SHINGLES.slab)
            .add(BlockusBlocks.WHITE_SHINGLES.slab)
            .add(BlockusBlocks.ORANGE_SHINGLES.slab)
            .add(BlockusBlocks.MAGENTA_SHINGLES.slab)
            .add(BlockusBlocks.LIGHT_BLUE_SHINGLES.slab)
            .add(BlockusBlocks.YELLOW_SHINGLES.slab)
            .add(BlockusBlocks.LIME_SHINGLES.slab)
            .add(BlockusBlocks.PINK_SHINGLES.slab)
            .add(BlockusBlocks.GRAY_SHINGLES.slab)
            .add(BlockusBlocks.LIGHT_GRAY_SHINGLES.slab)
            .add(BlockusBlocks.CYAN_SHINGLES.slab)
            .add(BlockusBlocks.PURPLE_SHINGLES.slab)
            .add(BlockusBlocks.BLUE_SHINGLES.slab)
            .add(BlockusBlocks.BROWN_SHINGLES.slab)
            .add(BlockusBlocks.GREEN_SHINGLES.slab)
            .add(BlockusBlocks.RED_SHINGLES.slab)
            .add(BlockusBlocks.BLACK_SHINGLES.slab);

        this.getOrCreateTagBuilder(BlockusBlockTags.SMALL_HEDGES)
            .add(BlockusBlocks.OAK_SMALL_HEDGE)
            .add(BlockusBlocks.SPRUCE_SMALL_HEDGE)
            .add(BlockusBlocks.BIRCH_SMALL_HEDGE)
            .add(BlockusBlocks.JUNGLE_SMALL_HEDGE)
            .add(BlockusBlocks.ACACIA_SMALL_HEDGE)
            .add(BlockusBlocks.DARK_OAK_SMALL_HEDGE)
            .add(BlockusBlocks.MANGROVE_SMALL_HEDGE)
            .add(BlockusBlocks.WHITE_OAK_SMALL_HEDGE)
            .add(BlockusBlocks.CRIMSON_SMALL_HEDGE)
            .add(BlockusBlocks.WARPED_SMALL_HEDGE)
            .add(BlockusBlocks.AZALEA_SMALL_HEDGE)
            .add(BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE)
            .add(BlockusBlocks.MOSS_SMALL_HEDGE)
            .addOptional(new Identifier(Blockus.MOD_ID, "sap_maple_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "vermilion_maple_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "fulvous_maple_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "mikado_maple_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "pink_cherry_oak_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "white_cherry_oak_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "palm_small_hedge"))
            .addOptional(new Identifier(Blockus.MOD_ID, "dark_amaranth_small_hedge"));

        this.getOrCreateTagBuilder(BlockusBlockTags.SNOW_BRICKS)
            .add(BlockusBlocks.SNOW_BRICKS.block)
            .add(BlockusBlocks.SNOW_BRICKS.stairs)
            .add(BlockusBlocks.SNOW_BRICKS.slab)
            .add(BlockusBlocks.SNOW_PILLAR);

        this.getOrCreateTagBuilder(BlockusBlockTags.SOUL_SANDSTONE)
            .add(BlockusBlocks.SOUL_SANDSTONE.block)
            .add(BlockusBlocks.SOUL_SANDSTONE.slab)
            .add(BlockusBlocks.SOUL_SANDSTONE.stairs)
            .add(BlockusBlocks.ROUGH_SOUL_SANDSTONE.block)
            .add(BlockusBlocks.ROUGH_SOUL_SANDSTONE.slab)
            .add(BlockusBlocks.ROUGH_SOUL_SANDSTONE.stairs)
            .add(BlockusBlocks.SMOOTH_SOUL_SANDSTONE.block)
            .add(BlockusBlocks.SMOOTH_SOUL_SANDSTONE.slab)
            .add(BlockusBlocks.SMOOTH_SOUL_SANDSTONE.stairs)
            .add(BlockusBlocks.SOUL_SANDSTONE_BRICKS.block)
            .add(BlockusBlocks.SOUL_SANDSTONE_BRICKS.slab)
            .add(BlockusBlocks.SOUL_SANDSTONE_BRICKS.stairs)
            .add(BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.block)
            .add(BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.slab)
            .add(BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.stairs)
            .add(BlockusBlocks.CUT_SOUL_SANDSTONE)
            .add(BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB)
            .add(BlockusBlocks.CHISELED_SOUL_SANDSTONE)
            .add(BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE)
            .add(BlockusBlocks.LAPIS_DECORATED_SOUL_SANDSTONE)
            .add(BlockusBlocks.SOUL_SANDSTONE_PILLAR)
            .addOptional(new Identifier(Blockus.MOD_ID, "soul_sandstone_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "soul_sandstone_brick_column"))
            .addOptional(new Identifier(Blockus.MOD_ID, "small_soul_sandstone_brick_column"));

        this.getOrCreateTagBuilder(BlockusBlockTags.SOUL_SOILS)
            .add(Blocks.SOUL_SAND)
            .add(Blocks.SOUL_SOIL);

        this.getOrCreateTagBuilder(BlockusBlockTags.STAINED_STONE_BRICKS)
            .add(BlockusBlocks.WHITE_STONE_BRICKS.block)
            .add(BlockusBlocks.ORANGE_STONE_BRICKS.block)
            .add(BlockusBlocks.MAGENTA_STONE_BRICKS.block)
            .add(BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.block)
            .add(BlockusBlocks.YELLOW_STONE_BRICKS.block)
            .add(BlockusBlocks.LIME_STONE_BRICKS.block)
            .add(BlockusBlocks.PINK_STONE_BRICKS.block)
            .add(BlockusBlocks.GRAY_STONE_BRICKS.block)
            .add(BlockusBlocks.CYAN_STONE_BRICKS.block)
            .add(BlockusBlocks.PURPLE_STONE_BRICKS.block)
            .add(BlockusBlocks.BLUE_STONE_BRICKS.block)
            .add(BlockusBlocks.BROWN_STONE_BRICKS.block)
            .add(BlockusBlocks.GREEN_STONE_BRICKS.block)
            .add(BlockusBlocks.RED_STONE_BRICKS.block)
            .add(BlockusBlocks.BLACK_STONE_BRICKS.block)
            .add(BlockusBlocks.WHITE_STONE_BRICKS.stairs)
            .add(BlockusBlocks.ORANGE_STONE_BRICKS.stairs)
            .add(BlockusBlocks.MAGENTA_STONE_BRICKS.stairs)
            .add(BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.stairs)
            .add(BlockusBlocks.YELLOW_STONE_BRICKS.stairs)
            .add(BlockusBlocks.LIME_STONE_BRICKS.stairs)
            .add(BlockusBlocks.PINK_STONE_BRICKS.stairs)
            .add(BlockusBlocks.GRAY_STONE_BRICKS.stairs)
            .add(BlockusBlocks.CYAN_STONE_BRICKS.stairs)
            .add(BlockusBlocks.PURPLE_STONE_BRICKS.stairs)
            .add(BlockusBlocks.BLUE_STONE_BRICKS.stairs)
            .add(BlockusBlocks.BROWN_STONE_BRICKS.stairs)
            .add(BlockusBlocks.GREEN_STONE_BRICKS.stairs)
            .add(BlockusBlocks.RED_STONE_BRICKS.stairs)
            .add(BlockusBlocks.BLACK_STONE_BRICKS.stairs)
            .add(BlockusBlocks.WHITE_STONE_BRICKS.slab)
            .add(BlockusBlocks.ORANGE_STONE_BRICKS.slab)
            .add(BlockusBlocks.MAGENTA_STONE_BRICKS.slab)
            .add(BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.slab)
            .add(BlockusBlocks.YELLOW_STONE_BRICKS.slab)
            .add(BlockusBlocks.LIME_STONE_BRICKS.slab)
            .add(BlockusBlocks.PINK_STONE_BRICKS.slab)
            .add(BlockusBlocks.GRAY_STONE_BRICKS.slab)
            .add(BlockusBlocks.CYAN_STONE_BRICKS.slab)
            .add(BlockusBlocks.PURPLE_STONE_BRICKS.slab)
            .add(BlockusBlocks.BLUE_STONE_BRICKS.slab)
            .add(BlockusBlocks.BROWN_STONE_BRICKS.slab)
            .add(BlockusBlocks.GREEN_STONE_BRICKS.slab)
            .add(BlockusBlocks.RED_STONE_BRICKS.slab)
            .add(BlockusBlocks.BLACK_STONE_BRICKS.slab);

        this.getOrCreateTagBuilder(BlockusBlockTags.STONE_BLOCKS)
            .add(BlockusBlocks.STONE_TILES.block)
            .add(BlockusBlocks.STONE_TILES.stairs)
            .add(BlockusBlocks.STONE_TILES.slab)
            .add(BlockusBlocks.STONE_BRICK_PILLAR)
            .add(BlockusBlocks.HERRINGBONE_STONE_BRICKS)
            .add(BlockusBlocks.STONE_CIRCULAR_PAVING)
            .add(BlockusBlocks.SMOOTH_STONE_STAIRS)
            .add(BlockusBlocks.STONE_DOOR)
            .add(BlockusBlocks.STONE_TRAPDOOR)
            .add(BlockusBlocks.STURDY_STONE);

        this.getOrCreateTagBuilder(BlockusBlockTags.STONE_BUTTONS)
            .add(BlockusBlocks.POLISHED_ANDESITE_BUTTON)
            .add(BlockusBlocks.POLISHED_DIORITE_BUTTON)
            .add(BlockusBlocks.POLISHED_GRANITE_BUTTON)
            .add(BlockusBlocks.LIMESTONE_BUTTON)
            .add(BlockusBlocks.MARBLE_BUTTON)
            .add(BlockusBlocks.BLUESTONE_BUTTON)
            .add(BlockusBlocks.POLISHED_NETHERRACK_BUTTON)
            .add(BlockusBlocks.POLISHED_END_STONE_BUTTON)
            .add(BlockusBlocks.POLISHED_BASALT_BUTTON)
            .add(BlockusBlocks.POLISHED_DEEPSLATE_BUTTON)
            .add(BlockusBlocks.POLISHED_TUFF_BUTTON)
            .add(BlockusBlocks.POLISHED_SCULK_BUTTON)
            .add(BlockusBlocks.VIRIDITE_BUTTON)
            .add(Blocks.POLISHED_BLACKSTONE_BUTTON);

        this.getOrCreateTagBuilder(BlockusBlockTags.THATCH)
            .add(BlockusBlocks.THATCH.block)
            .add(BlockusBlocks.THATCH.stairs)
            .add(BlockusBlocks.THATCH.slab);

        for (TimberFrameTypesF timberFrameType : TimberFrameTypesF.values()) {
            this.getOrCreateTagBuilder(BlockusBlockTags.TIMBER_FRAMES)
                .add(timberFrameType.block)
                .add(timberFrameType.diagonal)
                .add(timberFrameType.cross);
        }

        for (TimberFrameTypesFP timberFrameType : TimberFrameTypesFP.values()) {
            this.getOrCreateTagBuilder(BlockusBlockTags.TIMBER_FRAMES)
                .add(timberFrameType.block)
                .add(timberFrameType.diagonal)
                .add(timberFrameType.cross);
        }

        this.getOrCreateTagBuilder(BlockusBlockTags.TUFF_BLOCKS)
            .add(BlockusBlocks.POLISHED_TUFF.block)
            .add(BlockusBlocks.POLISHED_TUFF.stairs)
            .add(BlockusBlocks.POLISHED_TUFF.slab)
            .add(BlockusBlocks.TUFF_BRICKS.block)
            .add(BlockusBlocks.TUFF_BRICKS.stairs)
            .add(BlockusBlocks.TUFF_BRICKS.slab)
            .add(BlockusBlocks.CRACKED_TUFF_BRICKS)
            .add(BlockusBlocks.CHISELED_TUFF)
            .add(BlockusBlocks.HERRINGBONE_TUFF_BRICKS)
            .add(BlockusBlocks.TUFF_PILLAR)
            .add(BlockusBlocks.TUFF_CIRCULAR_PAVING);

        this.getOrCreateTagBuilder(BlockusBlockTags.WARPED_NETHER_GRASS)
            .add(Blocks.NETHER_SPROUTS)
            .add(Blocks.WARPED_ROOTS);

        this.getOrCreateTagBuilder(BlockusBlockTags.WATER_BRICKS)
            .add(BlockusBlocks.WATER_BRICKS.block)
            .add(BlockusBlocks.WATER_BRICKS.stairs)
            .add(BlockusBlocks.WATER_BRICKS.slab)
            .add(BlockusBlocks.CHISELED_WATER_BRICKS);

        this.getOrCreateTagBuilder(BlockusBlockTags.WHITE_OAK_LOGS)
            .add(BlockusBlocks.WHITE_OAK_LOG)
            .add(BlockusBlocks.WHITE_OAK_WOOD)
            .add(BlockusBlocks.STRIPPED_WHITE_OAK_LOG)
            .add(BlockusBlocks.STRIPPED_WHITE_OAK_WOOD)
            .add(BlockusBlocks.WHITE_OAK_SMALL_LOGS);

        this.getOrCreateTagBuilder(new Identifier("c", "planks_that_burn"))
            .add(Blocks.OAK_PLANKS)
            .add(Blocks.SPRUCE_PLANKS)
            .add(Blocks.BIRCH_PLANKS)
            .add(Blocks.JUNGLE_PLANKS)
            .add(Blocks.ACACIA_PLANKS)
            .add(Blocks.DARK_OAK_PLANKS)
            .add(BlockusBlocks.BAMBOO.planks)
            .add(BlockusBlocks.WHITE_OAK.planks)
            .add(BlockusBlocks.LEGACY_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_OAK_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_BIRCH_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_SPRUCE_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_JUNGLE_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_ACACIA_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_DARK_OAK_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_MANGROVE_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_WHITE_OAK_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_BAMBOO_PLANKS);

        this.getOrCreateTagBuilder(new Identifier("c", "wooden_barrels"))
            .addTag(BlockusBlockTags.BARRELS);

        this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(BlockusBlocks.WOODEN_FRAME)
            .add(BlockusBlocks.LEGACY_PLANKS)
            .add(BlockusBlocks.SOUL_O_LANTERN)
            .add(BlockusBlocks.REDSTONE_O_LANTERN)
            .addTag(BlockusBlockTags.FRAMED_PAPER_BLOCKS)
            .addTag(BlockusBlockTags.BARRELS)
            .addTag(BlockusBlockTags.TIMBER_FRAMES)
            .addTag(BlockusBlockTags.FOOD_CRATES);

        this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
            .add(BlockusBlocks.ROTTEN_FLESH_BLOCK)
            .add(BlockusBlocks.CHORUS_BLOCK)
            .add(BlockusBlocks.LEGACY_SPONGE)
            .add(BlockusBlocks.WHITE_OAK_LEAVES)
            .add(BlockusBlocks.LEGACY_LEAVES)
            .addTag(BlockusBlockTags.THATCH)
            .addTag(BlockusBlockTags.SMALL_HEDGES);

        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(BlockusBlocks.NETHERITE_STAIRS)
            .add(BlockusBlocks.NETHERITE_SLAB)
            .add(BlockusBlocks.CHARCOAL_BLOCK)
            .add(BlockusBlocks.ENDER_BLOCK)
            .add(BlockusBlocks.NETHER_STAR_BLOCK)
            .add(BlockusBlocks.LOVE_BLOCK)
            .add(BlockusBlocks.WEIGHT_STORAGE_CUBE)
            .add(BlockusBlocks.COMPANION_CUBE)
            .add(BlockusBlocks.CAUTION_BLOCK)
            .add(BlockusBlocks.STARS_BLOCK)
            .add(BlockusBlocks.LEGACY_BRICKS)
            .add(BlockusBlocks.LEGACY_FIRST_COBBLESTONE)
            .add(BlockusBlocks.LEGACY_COBBLESTONE)
            .add(BlockusBlocks.LEGACY_MOSSY_COBBLESTONE)
            .add(BlockusBlocks.LEGACY_IRON_BLOCK)
            .add(BlockusBlocks.LEGACY_GOLD_BLOCK)
            .add(BlockusBlocks.LEGACY_COAL_BLOCK)
            .add(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK)
            .add(BlockusBlocks.LEGACY_DIAMOND_BLOCK)
            .add(BlockusBlocks.LEGACY_LAPIS_BLOCK)
            .add(BlockusBlocks.LEGACY_STONECUTTER)
            .add(BlockusBlocks.LEGACY_NETHER_REACTOR_CORE)
            .add(BlockusBlocks.GOLDEN_BARS)
            .add(BlockusBlocks.GOLDEN_CHAIN)
            .add(BlockusBlocks.GOLDEN_GATE)
            .add(BlockusBlocks.IRON_GATE)
            .add(BlockusBlocks.LANTERN_BLOCK)
            .add(BlockusBlocks.SOUL_LANTERN_BLOCK)
            .add(BlockusBlocks.REDSTONE_LANTERN_BLOCK)
            .add(BlockusBlocks.REDSTONE_LANTERN)
            .add(BlockusBlocks.CRIMSON_WART_BRICKS.block)
            .add(BlockusBlocks.CRIMSON_WART_BRICKS.stairs)
            .add(BlockusBlocks.CRIMSON_WART_BRICKS.slab)
            .add(BlockusBlocks.WARPED_WART_BRICKS.block)
            .add(BlockusBlocks.WARPED_WART_BRICKS.stairs)
            .add(BlockusBlocks.WARPED_WART_BRICKS.slab)
            .add(BlockusBlocks.NETHER_TILES.block)
            .add(BlockusBlocks.NETHER_TILES.stairs)
            .add(BlockusBlocks.NETHER_TILES.slab)
            .add(BlockusBlocks.END_TILES.block)
            .add(BlockusBlocks.END_TILES.stairs)
            .add(BlockusBlocks.END_TILES.slab)
            .add(BlockusBlocks.CHISELED_MUD_BRICKS)
            .add(BlockusBlocks.MUD_BRICK_PILLAR)
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
            .addTag(BlockusBlockTags.STONE_BUTTONS)
            .addTag(BlockTags.STONE_PRESSURE_PLATES);

        this.getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
            .add(BlockusBlocks.PATH)
            .add(BlockusBlocks.SUGAR_BLOCK)
            .add(BlockusBlocks.REDSTONE_SAND)
            .add(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK)
            .add(BlockusBlocks.LEGACY_GRASS_BLOCK)
            .add(BlockusBlocks.LEGACY_GRAVEL)
            .add(BlockusBlocks.SUGAR_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.ACACIA_LOGS)
            .add(BlockusBlocks.ACACIA_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.BASE_STONE_OVERWORLD)
            .add(BlockusBlocks.LIMESTONE.block)
            .add(BlockusBlocks.MARBLE.block)
            .add(BlockusBlocks.BLUESTONE.block)
            .add(BlockusBlocks.VIRIDITE.block);

        this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
            .add(BlockusBlocks.LEGACY_GOLD_BLOCK)
            .add(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK)
            .add(BlockusBlocks.LEGACY_IRON_BLOCK)
            .add(BlockusBlocks.LEGACY_DIAMOND_BLOCK)
            .add(BlockusBlocks.NETHERITE_SLAB)
            .add(BlockusBlocks.NETHERITE_STAIRS)
            .add(BlockusBlocks.NETHER_STAR_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.BIRCH_LOGS)
            .add(BlockusBlocks.BIRCH_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.BUTTONS)
            .add(BlockusBlocks.POLISHED_ANDESITE_BUTTON)
            .add(BlockusBlocks.POLISHED_DIORITE_BUTTON)
            .add(BlockusBlocks.POLISHED_GRANITE_BUTTON)
            .add(BlockusBlocks.LIMESTONE_BUTTON)
            .add(BlockusBlocks.MARBLE_BUTTON)
            .add(BlockusBlocks.BLUESTONE_BUTTON)
            .add(BlockusBlocks.POLISHED_NETHERRACK_BUTTON)
            .add(BlockusBlocks.POLISHED_END_STONE_BUTTON)
            .add(BlockusBlocks.POLISHED_BASALT_BUTTON)
            .add(BlockusBlocks.POLISHED_DEEPSLATE_BUTTON)
            .add(BlockusBlocks.POLISHED_TUFF_BUTTON)
            .add(BlockusBlocks.POLISHED_SCULK_BUTTON)
            .add(BlockusBlocks.VIRIDITE_BUTTON);


        this.getOrCreateTagBuilder(BlockTags.CRIMSON_STEMS)
            .add(BlockusBlocks.CRIMSON_SMALL_STEMS);

        this.getOrCreateTagBuilder(BlockTags.DARK_OAK_LOGS)
            .add(BlockusBlocks.DARK_OAK_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
            .add(BlockusBlocks.BLUESTONE.block)
            .add(BlockusBlocks.VIRIDITE.block);

        this.getOrCreateTagBuilder(BlockTags.DOORS)
            .add(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR)
            .add(BlockusBlocks.STONE_DOOR)
            .add(BlockusBlocks.BLACKSTONE_DOOR)
            .add(BlockusBlocks.IRON_GATE)
            .add(BlockusBlocks.GOLDEN_GATE);

        this.getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .add(BlockusBlocks.NETHER_STAR_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.FENCE_GATES)
            .add(BlockusBlocks.BAMBOO.fence_gate)
            .add(BlockusBlocks.CHARRED.fence_gate)
            .add(BlockusBlocks.WHITE_OAK.fence_gate);

        this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
            .add(BlockusBlocks.POTTED_WHITE_OAK_SAPLING)
            .add(BlockusBlocks.POTTED_RAINBOW_ROSE);

        this.getOrCreateTagBuilder(BlockTags.FLOWERS)
            .add(BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE);

        this.getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
            .add(BlockusBlocks.LEGACY_GOLD_BLOCK)
            .add(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK)
            .add(BlockusBlocks.GOLDEN_CHAIN)
            .add(BlockusBlocks.GOLDEN_BARS)
            .add(BlockusBlocks.GOLDEN_GATE)
            .add(BlockusBlocks.GOLD_DECORATED_SANDSTONE)
            .add(BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE)
            .add(BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE)
            .add(BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE)
            .add(BlockusBlocks.GOLD_PLATING.block)
            .add(BlockusBlocks.GOLD_PLATING.stairs)
            .add(BlockusBlocks.GOLD_PLATING.slab)
            .add(BlockusBlocks.GOLDEN_APPLE_CRATE)
            .add(BlockusBlocks.GOLDEN_CARROT_CRATE)
            .addTag(BlockusBlockTags.BARRELS);

        this.getOrCreateTagBuilder(BlockTags.ICE)
            .addTag(BlockusBlockTags.ICE_BRICKS)
            .add(BlockusBlocks.ICE_BRICK_WALL);

        this.getOrCreateTagBuilder(BlockTags.IMPERMEABLE)
            .addTag(BlockusBlockTags.BEVELED_GLASS)
            .addTag(BlockusBlockTags.NEON);

        this.getOrCreateTagBuilder(ConventionalBlockTags.GLASS_BLOCKS)
            .addTag(BlockusBlockTags.BEVELED_GLASS);

        this.getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD)
            .addTag(BlockusBlockTags.NETHERRACK_BLOCKS)
            .addTag(BlockusBlockTags.MAGMA_BRICKS)
            .add(BlockusBlocks.CHARCOAL_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.JUNGLE_LOGS)
            .add(BlockusBlocks.JUNGLE_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.LEAVES)
            .add(BlockusBlocks.WHITE_OAK_LEAVES)
            .add(BlockusBlocks.LEGACY_LEAVES);

        this.getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
            .addTag(BlockusBlockTags.WHITE_OAK_LOGS)
            .add(BlockusBlocks.LEGACY_LOG);

        this.getOrCreateTagBuilder(BlockTags.MANGROVE_LOGS)
            .add(BlockusBlocks.MANGROVE_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .add(BlockusBlocks.NETHERITE_STAIRS)
            .add(BlockusBlocks.NETHERITE_SLAB);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(BlockusBlocks.NETHER_STAR_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(BlockusBlocks.ENDER_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.OAK_LOGS)
            .add(BlockusBlocks.OAK_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
            .add(BlockusBlocks.WHITE_OAK_LOG);

        this.getOrCreateTagBuilder(BlockTags.PIGLIN_REPELLENTS)
            .add(BlockusBlocks.SOUL_LANTERN_BLOCK)
            .add(BlockusBlocks.SOUL_O_LANTERN);

        this.getOrCreateTagBuilder(BlockTags.PLANKS)
            .add(BlockusBlocks.BAMBOO.planks)
            .add(BlockusBlocks.CHARRED.planks)
            .add(BlockusBlocks.WHITE_OAK.planks)
            .add(BlockusBlocks.LEGACY_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_OAK_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_BIRCH_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_SPRUCE_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_JUNGLE_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_ACACIA_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_DARK_OAK_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_MANGROVE_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_WHITE_OAK_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_BAMBOO_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_CRIMSON_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_WARPED_PLANKS)
            .add(BlockusBlocks.HERRINGBONE_CHARRED_PLANKS);


        this.getOrCreateTagBuilder(BlockTags.SAPLINGS)
            .add(BlockusBlocks.WHITE_OAK_SAPLING);

        this.getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
            .add(BlockusBlocks.RAINBOW_ROSE);

        this.getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
            .addTag(BlockusBlockTags.SOUL_SANDSTONE)
            .addTag(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS);

        this.getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS)
            .addTag(BlockusBlockTags.SOUL_SANDSTONE)
            .add(BlockusBlocks.SOUL_SANDSTONE.wall)
            .add(BlockusBlocks.SOUL_SANDSTONE_BRICKS.wall)
            .add(BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.wall);

        this.getOrCreateTagBuilder(BlockTags.SPRUCE_LOGS)
            .add(BlockusBlocks.SPRUCE_SMALL_LOGS);

        this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
            .add(BlockusBlocks.BAMBOO.standing_sign)
            .add(BlockusBlocks.CHARRED.standing_sign)
            .add(BlockusBlocks.WHITE_OAK.standing_sign);

        this.getOrCreateTagBuilder(BlockTags.STONE_ORE_REPLACEABLES)
            .add(BlockusBlocks.LIMESTONE.block)
            .add(BlockusBlocks.MARBLE.block);

        this.getOrCreateTagBuilder(BlockTags.STONE_PRESSURE_PLATES)
            .add(BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE)
            .add(BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE)
            .add(BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE)
            .add(BlockusBlocks.LIMESTONE_PRESSURE_PLATE)
            .add(BlockusBlocks.MARBLE_PRESSURE_PLATE)
            .add(BlockusBlocks.BLUESTONE_PRESSURE_PLATE)
            .add(BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE)
            .add(BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE)
            .add(BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE)
            .add(BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE)
            .add(BlockusBlocks.POLISHED_SCULK_PRESSURE_PLATE)
            .add(BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE)
            .add(BlockusBlocks.VIRIDITE_PRESSURE_PLATE);


        this.getOrCreateTagBuilder(BlockTags.TRAPDOORS)
            .add(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR)
            .add(BlockusBlocks.STONE_TRAPDOOR)
            .add(BlockusBlocks.BLACKSTONE_TRAPDOOR);

        this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
            .add(BlockusBlocks.BAMBOO.wall_sign)
            .add(BlockusBlocks.CHARRED.wall_sign)
            .add(BlockusBlocks.WHITE_OAK.wall_sign);

        for (BSSWTypes bsswTypes : BSSWTypes.values()) {
            this.getOrCreateTagBuilder(BlockTags.WALLS).add(bsswTypes.wall);
        }

        this.getOrCreateTagBuilder(BlockTags.WALLS)
            .addTag(BlockusBlockTags.BARRIERS);

        this.getOrCreateTagBuilder(BlockTags.WARPED_STEMS)
            .add(BlockusBlocks.WARPED_SMALL_STEMS);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
            .add(BlockusBlocks.BAMBOO.button)
            .add(BlockusBlocks.CHARRED.button)
            .add(BlockusBlocks.WHITE_OAK.button);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
            .add(BlockusBlocks.BAMBOO.door)
            .add(BlockusBlocks.CHARRED.door)
            .add(BlockusBlocks.WHITE_OAK.door)
            .add(BlockusBlocks.PAPER_DOOR);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
            .add(BlockusBlocks.BAMBOO.fence)
            .add(BlockusBlocks.CHARRED.fence)
            .add(BlockusBlocks.WHITE_OAK.fence);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
            .add(BlockusBlocks.BAMBOO.pressure_plate)
            .add(BlockusBlocks.CHARRED.pressure_plate)
            .add(BlockusBlocks.WHITE_OAK.pressure_plate);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
            .add(BlockusBlocks.BAMBOO.slab)
            .add(BlockusBlocks.CHARRED.slab)
            .add(BlockusBlocks.WHITE_OAK.slab);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
            .add(BlockusBlocks.BAMBOO.stairs)
            .add(BlockusBlocks.CHARRED.stairs)
            .add(BlockusBlocks.WHITE_OAK.stairs);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
            .add(BlockusBlocks.BAMBOO.trapdoor)
            .add(BlockusBlocks.CHARRED.trapdoor)
            .add(BlockusBlocks.WHITE_OAK.trapdoor)
            .add(BlockusBlocks.PAPER_TRAPDOOR);

        this.getOrCreateTagBuilder(BlockTags.WOOL)
            .addTag(BlockusBlockTags.PATTERNED_WOOL);

        this.getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
            .addTag(BlockusBlockTags.PATTERNED_CARPETS);

        this.getOrCreateTagBuilder(BlockTags.DAMPENS_VIBRATIONS)
            .addTag(BlockusBlockTags.ALL_PATTERNED_WOOLS);

        this.getOrCreateTagBuilder(BlockTags.ANIMALS_SPAWNABLE_ON)
            .add(BlockusBlocks.LEGACY_GRASS_BLOCK)
            .add(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.DIRT)
            .add(BlockusBlocks.LEGACY_GRASS_BLOCK)
            .add(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK);

        this.getOrCreateTagBuilder(new Identifier("promenade", "cherry_oak_logs"))
            .addOptional(new Identifier(Blockus.MOD_ID, "cherry_oak_small_logs"));

        this.getOrCreateTagBuilder(new Identifier("promenade", "dark_amaranth_stems"))
            .addOptional(new Identifier(Blockus.MOD_ID, "dark_amaranth_small_stems"));

        this.getOrCreateTagBuilder(new Identifier("promenade", "leaf_piles"))
            .addOptional(new Identifier(Blockus.MOD_ID, "white_oak_leaf_pile"));

        this.getOrCreateTagBuilder(new Identifier("promenade", "palm_logs"))
            .addOptional(new Identifier(Blockus.MOD_ID, "palm_small_logs"));

        this.getOrCreateTagBuilder(new Identifier("promenade", "maple_logs"))
            .addOptional(new Identifier(Blockus.MOD_ID, "maple_small_logs"));
    }
}
