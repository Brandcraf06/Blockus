package com.brand.blockus.datagen.providers;

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
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BlockusBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        this.valueLookupBuilder(BlockusBlockTags.AMETHYST_BLOCKS)
            .add(bsswBundle(POLISHED_AMETHYST))
            .add(bsswBundle(AMETHYST_BRICKS))
            .add(CHISELED_AMETHYST)
            .add(AMETHYST_PILLAR)
            .add(AMETHYST_LAMP);

        this.valueLookupBuilder(BlockusBlockTags.ANDESITE_BLOCKS)
            .add(bsswBundle(ANDESITE_BRICKS))
            .add(HERRINGBONE_ANDESITE_BRICKS)
            .add(CHISELED_ANDESITE_BRICKS)
            .add(CRACKED_ANDESITE_BRICKS)
            .add(POLISHED_ANDESITE_PILLAR)
            .add(ANDESITE_CIRCULAR_PAVING);

        this.valueLookupBuilder(BlockTags.VIBRATION_RESONATORS)
            .addTag(BlockusBlockTags.AMETHYST_BLOCKS);

        for (Block block : ASPHALT.all()) {
            valueLookupBuilder(BlockusBlockTags.ASPHALT).add(block);
        }
        this.valueLookupBuilder(BlockusBlockTags.ASPHALT)
            .add(RAINBOW_ASPHALT);

        this.valueLookupBuilder(BlockusBlockTags.BARRIERS)
            .add(CAUTION_BARRIER)
            .add(ROAD_BARRIER);

        this.valueLookupBuilder(BlockusBlockTags.BASALT_BLOCKS)
            .add(bsswBundle(ROUGH_BASALT))
            .add(bsswBundle(POLISHED_BASALT_BRICKS))
            .add(CHISELED_POLISHED_BASALT)
            .add(CRACKED_POLISHED_BASALT_BRICKS)
            .add(POLISHED_BASALT_PILLAR)
            .add(HERRINGBONE_POLISHED_BASALT_BRICKS)
            .add(POLISHED_BASALT_CIRCULAR_PAVING);

        this.valueLookupBuilder(BlockusBlockTags.BEVELED_GLASS)
            .add(BEVELED_GLASS)
            .add(RAINBOW_BEVELED_GLASS);
        for (DyeColor color : DyeColor.values()) {
            valueLookupBuilder(BlockusBlockTags.BEVELED_GLASS).add(STAINED_BEVELED_GLASS.colorMap().get(color));
        }

        this.valueLookupBuilder(BlockusBlockTags.BLACKSTONE_BLOCKS)
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

        this.valueLookupBuilder(BlockusBlockTags.BLAZE_BRICKS)
            .add(bsswBundle(BLAZE_BRICKS))
            .add(BLAZE_PILLAR);

        this.valueLookupBuilder(BlockusBlockTags.BLUESTONE)
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
            .add(CHISELED_BLUESTONE_BRICKS)
            .add(BLUESTONE_LINES);

        this.valueLookupBuilder(BlockusBlockTags.BRICKS_BLOCKS)
            .add(bsswBundle(LARGE_BRICKS))
            .add(HERRINGBONE_BRICKS)
            .add(bsswBundle(SOAKED_BRICKS))
            .add(HERRINGBONE_SOAKED_BRICKS)
            .add(bsswBundle(SANDY_BRICKS))
            .add(HERRINGBONE_SANDY_BRICKS)
            .add(bsswBundle(CHARRED_BRICKS))
            .add(HERRINGBONE_CHARRED_BRICKS);

        this.valueLookupBuilder(BlockusBlockTags.CHOCOLATE_BLOCKS)
            .add(bsswBundle(CHOCOLATE_BLOCK))
            .add(bsswBundle(CHOCOLATE_BRICKS))
            .add(CHOCOLATE_SQUARES)
            .add(CHOCOLATE_TABLET);

        for (DyeColor color : DyeColor.values()) {
            valueLookupBuilder(BlockusBlockTags.COLORED_TILES).add(COLORED_TILES.colorMap().get(color));
        }
        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            this.valueLookupBuilder(BlockusBlockTags.COLORED_TILES).add(coloredTilesVariants.block());
        }
        this.valueLookupBuilder(BlockusBlockTags.COLORED_TILES)
            .add(RAINBOW_COLORED_TILES);

        for (ConcreteBundle concreteType : ConcreteBundle.values()) {
            this.valueLookupBuilder(BlockusBlockTags.CONCRETE_BLOCKS)
                .add(concreteType.all());
        }

        this.valueLookupBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS)
            .addTag(BlockusBlockTags.AMETHYST_BLOCKS);

        this.valueLookupBuilder(BlockusBlockTags.DEEPSLATE_BLOCKS)
            .add(bsswBundle(MOSSY_DEEPSLATE_BRICKS))
            .add(HERRINGBONE_DEEPSLATE_BRICKS)
            .add(DEEPSLATE_PILLAR)
            .add(DEEPSLATE_CIRCULAR_PAVING)
            .add(STURDY_DEEPSLATE);

        this.valueLookupBuilder(BlockusBlockTags.DIORITE_BLOCKS)
            .add(bsswBundle(DIORITE_BRICKS))
            .add(HERRINGBONE_DIORITE_BRICKS)
            .add(CHISELED_DIORITE_BRICKS)
            .add(CRACKED_DIORITE_BRICKS)
            .add(POLISHED_DIORITE_PILLAR)
            .add(DIORITE_CIRCULAR_PAVING);

        this.valueLookupBuilder(BlockusBlockTags.DRIPSTONE_BLOCKS)
            .add(bsswBundle(POLISHED_DRIPSTONE))
            .add(bsswBundle(DRIPSTONE_BRICKS))
            .add(bsswBundle(MOSSY_DRIPSTONE_BRICKS))
            .add(CRACKED_DRIPSTONE_BRICKS)
            .add(CHISELED_DRIPSTONE)
            .add(DRIPSTONE_PILLAR);

        this.valueLookupBuilder(BlockusBlockTags.END_STONE_BLOCKS)
            .add(CHISELED_END_STONE_BRICKS)
            .add(HERRINGBONE_END_STONE_BRICKS)
            .add(bsswBundle(POLISHED_END_STONE))
            .add(CRACKED_END_STONE_BRICKS)
            .add(END_STONE_PILLAR)
            .add(bsswBundle(SMALL_END_STONE_BRICKS))
            .add(PURPUR_DECORATED_END_STONE)
            .add(PHANTOM_PURPUR_DECORATED_END_STONE);

        this.valueLookupBuilder(BlockusBlockTags.FOOD_CRATES)
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
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("blueberries_crate")))
        ;

        this.valueLookupBuilder(BlockusBlockTags.FRAMED_PAPER_BLOCKS)
            .add(FRAMED_PAPER_BLOCK)
            .add(PAPER_WALL)
            .add(PAPER_DOOR)
            .add(PAPER_TRAPDOOR);

        for (DyeColor color : DyeColor.values()) {
            valueLookupBuilder(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS).add(GLAZED_TERRACOTTA_PILLAR.colorMap().get(color));
        }

        this.valueLookupBuilder(BlockusBlockTags.GRANITE_BLOCKS)
            .add(bsswBundle(GRANITE_BRICKS))
            .add(HERRINGBONE_GRANITE_BRICKS)
            .add(CHISELED_GRANITE_BRICKS)
            .add(CRACKED_GRANITE_BRICKS)
            .add(POLISHED_GRANITE_PILLAR)
            .add(GRANITE_CIRCULAR_PAVING);

        this.valueLookupBuilder(BlockusBlockTags.HONEYCOMB_BLOCKS)
            .add(bsswBundle(HONEYCOMB_BRICKS));

        this.valueLookupBuilder(BlockusBlockTags.ICE_BRICKS)
            .add(ICE_BRICKS)
            .add(ICE_PILLAR);

        this.valueLookupBuilder(BlockusBlockTags.LARGE_FLOWER_POTS)
            .add(LARGE_FLOWER_POT)
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("potted_autumn_birch")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("potted_autumn_oak")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("potted_palm")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("potted_pink_cherry_oak")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("potted_white_cherry_oak")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("potted_huge_dark_amaranth_fungus")))
        ;

        for (PottedLargeBundle pottedLargeType : PottedLargeBundle.values()) {
            this.valueLookupBuilder(BlockusBlockTags.LARGE_FLOWER_POTS)
                .add(pottedLargeType.block());
        }

        this.valueLookupBuilder(BlockusBlockTags.LAVA_BRICKS)
            .add(bsswBundle(LAVA_BRICKS))
            .add(CHISELED_LAVA_BRICKS);

        this.valueLookupBuilder(BlockusBlockTags.LAVA_POLISHED_BLACKSTONE_BRICKS)
            .add(bsswBundle(LAVA_POLISHED_BLACKSTONE_BRICKS))
            .add(CHISELED_LAVA_POLISHED_BLACKSTONE);

        this.valueLookupBuilder(BlockusBlockTags.LIMESTONE)
            .add(bsswBundle(LIMESTONE))
            .add(bsswBundle(POLISHED_LIMESTONE))
            .add(bsswBundle(LIMESTONE_BRICKS))
            .add(bsswBundle(LIMESTONE_TILES))
            .add(LIMESTONE_PILLAR)
            .add(LIMESTONE_SQUARES)
            .add(bsswBundle(SMALL_LIMESTONE_BRICKS))
            .add(CHISELED_LIMESTONE)
            .add(CHISELED_LIMESTONE_PILLAR)
            .add(CHISELED_LIMESTONE_BRICKS)
            .add(LIMESTONE_LINES)
            .add(LIMESTONE_CIRCULAR_PAVING);

        this.valueLookupBuilder(BlockusBlockTags.VIRIDITE)
            .add(bsswBundle(VIRIDITE))
            .add(bsswBundle(POLISHED_VIRIDITE))
            .add(bsswBundle(VIRIDITE_BRICKS))
            .add(bsswBundle(VIRIDITE_TILES))
            .add(VIRIDITE_PILLAR)
            .add(VIRIDITE_SQUARES)
            .add(bsswBundle(SMALL_VIRIDITE_BRICKS))
            .add(CHISELED_VIRIDITE)
            .add(CHISELED_VIRIDITE_PILLAR)
            .add(CHISELED_VIRIDITE_BRICKS)
            .add(VIRIDITE_CIRCULAR_PAVING)
            .add(VIRIDITE_LINES);

        this.valueLookupBuilder(BlockusBlockTags.MAGMA_BRICKS)
            .add(bsswBundle(MAGMA_BRICKS))
            .add(bsswBundle(SMALL_MAGMA_BRICKS))
            .add(CHISELED_MAGMA_BRICKS);

        this.valueLookupBuilder(BlockusBlockTags.MARBLE)
            .add(bsswBundle(MARBLE))
            .add(bsswBundle(POLISHED_MARBLE))
            .add(bsswBundle(MARBLE_BRICKS))
            .add(bsswBundle(MARBLE_TILES))
            .add(MARBLE_PILLAR)
            .add(MARBLE_SQUARES)
            .add(bsswBundle(SMALL_MARBLE_BRICKS))
            .add(CHISELED_MARBLE_PILLAR)
            .add(CHISELED_MARBLE_BRICKS)
            .add(CHISELED_MARBLE)
            .add(MARBLE_LINES)
            .add(MARBLE_CIRCULAR_PAVING);

        for (DyeColor color : DyeColor.values()) {
            valueLookupBuilder(BlockusBlockTags.NEON).add(NEON_BLOCK.colorMap().get(color));
        }
        this.valueLookupBuilder(BlockusBlockTags.NEON)
            .add(RAINBOW_NEON);

        this.valueLookupBuilder(BlockusBlockTags.NETHER_BRICKS)
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

        this.valueLookupBuilder(BlockusBlockTags.NETHERRACK_BLOCKS)
            .add(bsswBundle(POLISHED_NETHERRACK))
            .add(bsswBundle(NETHERRACK_BRICKS))
            .add(NETHERRACK_CIRCULAR_PAVING);

        this.valueLookupBuilder(BlockusBlockTags.OBSIDIAN)
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

        this.valueLookupBuilder(BlockusBlockTags.NETHER_PORTAL_FRAME_BLOCKS)
            .add(Blocks.OBSIDIAN)
            .add(OBSIDIAN_BRICKS.block())
            .add(CRACKED_OBSIDIAN_BRICKS)
            .add(SMALL_OBSIDIAN_BRICKS.block())
            .add(OBSIDIAN_PILLAR)
            .add(OBSIDIAN_CIRCULAR_PAVING)
            .add(GLOWING_OBSIDIAN)
            .add(LEGACY_GLOWING_OBSIDIAN);

        this.valueLookupBuilder(BlockusBlockTags.ALL_PATTERNED_WOOLS)
            .addTag(BlockusBlockTags.PATTERNED_WOOL);

        for (WoolBundle woolBundle : WoolBundle.values()) {
            for (WoolBundle.WoolVariants variants : woolBundle.colorMap().values()) {
                this.valueLookupBuilder(BlockusBlockTags.PATTERNED_WOOL)
                    .add(variants.block());
                this.valueLookupBuilder(BlockusBlockTags.PATTERNED_CARPETS)
                    .add(variants.carpet());
                this.valueLookupBuilder(BlockusBlockTags.ALL_PATTERNED_WOOLS)
                    .add(variants.stairs())
                    .add(variants.slab());
            }
        }

        this.valueLookupBuilder(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS)
            .add(bsswBundle(PHANTOM_PURPUR_BLOCK))
            .add(PHANTOM_PURPUR_PILLAR)
            .add(bsswBundle(PHANTOM_PURPUR_BRICKS))
            .add(bsswBundle(POLISHED_PHANTOM_PURPUR))
            .add(PHANTOM_PURPUR_SQUARES)
            .add(bsswBundle(SMALL_PHANTOM_PURPUR_BRICKS))
            .add(CHISELED_PHANTOM_PURPUR)
            .add(PHANTOM_PURPUR_LINES);

        this.valueLookupBuilder(BlockusBlockTags.PLATINGS)
            .add(bsswBundle(IRON_PLATING))
            .add(bsswBundle(GOLD_PLATING));

        this.valueLookupBuilder(BlockusBlockTags.PRISMARINE_BLOCKS)
            .add(PRISMARINE_CIRCULAR_PAVING)
            .add(CHISELED_DARK_PRISMARINE)
            .add(DARK_PRISMARINE_PILLAR)
            .add(CHISELED_PRISMARINE)
            .add(PRISMARINE_PILLAR)
            .add(bsswBundle(PRISMARINE_TILES));

        this.valueLookupBuilder(BlockusBlockTags.PURPUR_BLOCKS)
            .add(bsswBundle(PURPUR_BRICKS))
            .add(bsswBundle(POLISHED_PURPUR))
            .add(PURPUR_SQUARES)
            .add(bsswBundle(SMALL_PURPUR_BRICKS))
            .add(CHISELED_PURPUR)
            .add(PURPUR_LINES)
            .addTag(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS);

        this.valueLookupBuilder(BlockusBlockTags.QUARTZ_BLOCKS)
            .add(bsswBundle(QUARTZ_TILES))
            .add(QUARTZ_CIRCULAR_PAVING);

        this.valueLookupBuilder(BlockusBlockTags.RAINBOW_BLOCKS)
            .add(RAINBOW_BLOCK)
            .add(bsswBundle(RAINBOW_BRICKS));

        this.valueLookupBuilder(BlockusBlockTags.RED_SANDSTONE)
            .add(bsswBundle(ROUGH_RED_SANDSTONE))
            .add(bsswBundle(RED_SANDSTONE_BRICKS))
            .add(bsswBundle(SMALL_RED_SANDSTONE_BRICKS))
            .add(GOLD_DECORATED_RED_SANDSTONE)
            .add(LAPIS_DECORATED_RED_SANDSTONE)
            .add(RED_SANDSTONE_PILLAR);

        this.valueLookupBuilder(BlockusBlockTags.RESIN_BLOCKS)
            .add(bsswBundle(LARGE_RESIN_BRICKS))
            .add(HERRINGBONE_RESIN_BRICKS)
            .add(RESIN_BRICK_PILLAR);

        this.valueLookupBuilder(BlockusBlockTags.SANDSTONE)
            .add(bsswBundle(ROUGH_SANDSTONE))
            .add(bsswBundle(SANDSTONE_BRICKS))
            .add(bsswBundle(SMALL_SANDSTONE_BRICKS))
            .add(GOLD_DECORATED_SANDSTONE)
            .add(LAPIS_DECORATED_SANDSTONE)
            .add(SANDSTONE_PILLAR);

        this.valueLookupBuilder(BlockusBlockTags.SCULK_BLOCKS)
            .add(bsswBundle(POLISHED_SCULK))
            .add(bsswBundle(SCULK_BRICKS))
            .add(CHISELED_SCULK_BRICKS)
            .add(SCULK_PILLAR);

        this.valueLookupBuilder(BlockusBlockTags.SHINGLES)
            .add(bsswBundle(SHINGLES));

        for (DyeColor color : DyeColor.values()) {
            for (Block block : STAINED_SHINGLES.colorMap().get(color).all()) {
                valueLookupBuilder(BlockusBlockTags.SHINGLES).add(block);
            }
        }

        for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
            this.valueLookupBuilder(BlockusBlockTags.WOODEN_POSTS)
                .add(woodenPost.all());
        }

        this.valueLookupBuilder(BlockusBlockTags.HEDGES)
            .add(OAK_HEDGE)
            .add(SPRUCE_HEDGE)
            .add(BIRCH_HEDGE)
            .add(JUNGLE_HEDGE)
            .add(ACACIA_HEDGE)
            .add(DARK_OAK_HEDGE)
            .add(MANGROVE_HEDGE)
            .add(CHERRY_HEDGE)
            .add(PALE_OAK_HEDGE)
            .add(WHITE_OAK_HEDGE)
            .add(CRIMSON_HEDGE)
            .add(WARPED_HEDGE)
            .add(AZALEA_HEDGE)
            .add(FLOWERING_AZALEA_HEDGE)
            .add(MOSS_HEDGE)
            .add(PALE_MOSS_HEDGE)
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("sap_maple_hedge")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("vermilion_maple_hedge")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("fulvous_maple_hedge")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("mikado_maple_hedge")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("pink_cherry_oak_hedge")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("white_cherry_oak_hedge")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("palm_hedge")))
//            .addOptionalTag(TagKey.of(RegistryKeys.BLOCK, Blockus.id("dark_amaranth_hedge")))
        ;

        this.valueLookupBuilder(BlockusBlockTags.SNOW_BRICKS)
            .add(bsswBundle(SNOW_BRICKS))
            .add(SNOW_PILLAR);

        this.valueLookupBuilder(BlockusBlockTags.SOUL_SANDSTONE)
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

        this.valueLookupBuilder(BlockusBlockTags.SOUL_SOILS)
            .add(Blocks.SOUL_SAND)
            .add(Blocks.SOUL_SOIL);

        for (DyeColor color : DyeColor.values()) {
            for (Block block : STAINED_STONE_BRICKS.colorMap().get(color).all()) {
                valueLookupBuilder(BlockusBlockTags.STAINED_STONE_BRICKS).add(block);
            }
        }

        this.valueLookupBuilder(BlockusBlockTags.STONE_BLOCKS)
            .add(bsswBundle(STONE_TILES))
            .add(STONE_BRICK_PILLAR)
            .add(HERRINGBONE_STONE_BRICKS)
            .add(STONE_CIRCULAR_PAVING)
            .add(SMOOTH_STONE_STAIRS)
            .add(STONE_DOOR)
            .add(STONE_TRAPDOOR)
            .add(STURDY_STONE);

        this.valueLookupBuilder(BlockTags.STONE_BUTTONS)
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

        this.valueLookupBuilder(BlockusBlockTags.THATCH)
            .add(bsswBundle(THATCH));


        for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
            this.valueLookupBuilder(BlockusBlockTags.TIMBER_FRAMES)
                .add(timberFrameBundle.timberFrames());

            this.valueLookupBuilder(BlockusBlockTags.WOODEN_LATTICES)
                .add(timberFrameBundle.lattice());

            this.valueLookupBuilder(BlockusBlockTags.WOODEN_GRATES)
                .add(timberFrameBundle.grate());
        }

        this.valueLookupBuilder(BlockusBlockTags.TUFF_BLOCKS)
            .add(bsswBundle(MOSSY_TUFF_BRICKS))
            .add(bsswBundle(TUFF_TILES))
            .add(CRACKED_TUFF_BRICKS)
            .add(CARVED_TUFF_BRICKS)
            .add(HERRINGBONE_TUFF_BRICKS)
            .add(TUFF_PILLAR)
            .add(TUFF_CIRCULAR_PAVING);

        this.valueLookupBuilder(BlockusBlockTags.WARPED_NETHER_GRASS)
            .add(Blocks.NETHER_SPROUTS)
            .add(Blocks.WARPED_ROOTS);

        this.valueLookupBuilder(BlockusBlockTags.WATER_BRICKS)
            .add(bsswBundle(WATER_BRICKS))
            .add(CHISELED_WATER_BRICKS);

        this.valueLookupBuilder(BlockusBlockTags.WHITE_OAK_LOGS)
            .add(WHITE_OAK_LOG)
            .add(WHITE_OAK_WOOD)
            .add(STRIPPED_WHITE_OAK_LOG)
            .add(STRIPPED_WHITE_OAK_WOOD)
            .add(WHITE_OAK_SMALL_LOGS);

        for (BSSWBundle block : BSSWBundle.values()) {
            if (BlockChecker.isWoodenMosaic(block.type(), BlockChecker.WOODS)) {
                this.valueLookupBuilder(BlockusBlockTags.ALL_WOODEN_MOSAICS)
                    .add(block.all());
            }
            if (BlockChecker.isMossyPlanks(block.type(), BlockChecker.WOODS)) {
                this.valueLookupBuilder(BlockusBlockTags.ALL_MOSSY_PLANKS)
                    .add(block.all());
            }
        }

        this.valueLookupBuilder(BlockusBlockTags.ALL_WOODEN_MOSAICS)
            .add(Blocks.BAMBOO_MOSAIC)
            .add(Blocks.BAMBOO_MOSAIC_STAIRS)
            .add(Blocks.BAMBOO_MOSAIC_SLAB);

        for (BSSWBundle block : BSSWBundle.values()) {
            if (BlockChecker.isWoodenMosaic(block.type(), BlockChecker.FLAMMABLE_WOODS) || BlockChecker.isMossyPlanks(block.type(), BlockChecker.FLAMMABLE_WOODS)) {
                this.valueLookupBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "planks_that_burn")))
                    .add(block.block());
            }
        }

        for (CopperBundle copperBundle : CopperBundle.values()) {
            for (Block block : copperBundle.all()) {
                if (block.toString().contains("tuff")) {
                    this.valueLookupBuilder(BlockusBlockTags.TUFF_BLOCKS)
                        .add(block);
                } else {
                    this.valueLookupBuilder(BlockusBlockTags.COPPER_BLOCKS)
                        .add(block);
                }
            }

            this.valueLookupBuilder(BlockTags.WALLS)
                .add(copperBundle.allWalls());
        }

        this.valueLookupBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "planks_that_burn")))
            .add(Blocks.OAK_PLANKS)
            .add(Blocks.SPRUCE_PLANKS)
            .add(Blocks.BIRCH_PLANKS)
            .add(Blocks.JUNGLE_PLANKS)
            .add(Blocks.ACACIA_PLANKS)
            .add(Blocks.DARK_OAK_PLANKS)
            .add(Blocks.MANGROVE_PLANKS)
            .add(Blocks.CHERRY_PLANKS)
            .add(Blocks.PALE_OAK_PLANKS)
            .add(Blocks.BAMBOO_PLANKS)
            .add(RAW_BAMBOO.planks())
            .add(WHITE_OAK.planks())
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
            .add(HERRINGBONE_RAW_BAMBOO_PLANKS)
            .add(HERRINGBONE_PALE_OAK_PLANKS);

        this.valueLookupBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "bars")))
            .add(GOLDEN_BARS);

        // Vanilla Block Tags
        this.valueLookupBuilder(BlockTags.AXE_MINEABLE)
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

        this.valueLookupBuilder(BlockTags.HOE_MINEABLE)
            .add(ROTTEN_FLESH_BLOCK)
            .add(CHORUS_BLOCK)
            .add(LEGACY_SPONGE)
            .add(WHITE_OAK_LEAVES)
            .add(LEGACY_LEAVES)
            .addTag(BlockusBlockTags.THATCH)
            .addTag(BlockusBlockTags.HEDGES);

        this.valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
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
            .addTag(BlockusBlockTags.RESIN_BLOCKS)
            .addTag(BlockTags.STONE_PRESSURE_PLATES)
            .add(OBSIDIAN_PRESSURE_PLATE);

        this.valueLookupBuilder(BlockTags.SHOVEL_MINEABLE)
            .add(PATH)
            .add(SUGAR_BLOCK)
            .add(REDSTONE_SAND)
            .add(LEGACY_FIRST_GRASS_BLOCK)
            .add(LEGACY_GRASS_BLOCK)
            .add(LEGACY_GRAVEL)
            .add(SUGAR_BLOCK);

        this.valueLookupBuilder(BlockTags.ACACIA_LOGS)
            .add(ACACIA_SMALL_LOGS);

        this.valueLookupBuilder(BlockTags.BASE_STONE_OVERWORLD)
            .add(LIMESTONE.block())
            .add(MARBLE.block())
            .add(BLUESTONE.block())
            .add(VIRIDITE.block());

        this.valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
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

        this.valueLookupBuilder(BlockTags.BIRCH_LOGS)
            .add(BIRCH_SMALL_LOGS);

        this.valueLookupBuilder(BlockTags.BUTTONS)
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

        this.valueLookupBuilder(BlockTags.PALE_OAK_LOGS)
            .add(PALE_OAK_SMALL_LOGS);

        this.valueLookupBuilder(BlockTags.CHERRY_LOGS)
            .add(CHERRY_SMALL_LOGS);

        this.valueLookupBuilder(BlockTags.CRIMSON_STEMS)
            .add(CRIMSON_SMALL_STEMS);

        this.valueLookupBuilder(BlockTags.DARK_OAK_LOGS)
            .add(DARK_OAK_SMALL_LOGS);

        this.valueLookupBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
            .add(BLUESTONE.block())
            .add(VIRIDITE.block());

        this.valueLookupBuilder(BlockTags.DOORS)
            .add(OBSIDIAN_REINFORCED_DOOR)
            .add(STONE_DOOR)
            .add(BLACKSTONE_DOOR)
            .add(IRON_GATE)
            .add(GOLDEN_GATE);

        this.valueLookupBuilder(BlockTags.DRAGON_IMMUNE)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .add(NETHER_STAR_BLOCK);

        this.valueLookupBuilder(BlockTags.FENCE_GATES)
            .add(RAW_BAMBOO.fenceGate())
            .add(CHARRED.fenceGate())
            .add(WHITE_OAK.fenceGate());

        this.valueLookupBuilder(BlockTags.FLOWER_POTS)
            .add(POTTED_WHITE_OAK_SAPLING)
            .add(POTTED_RAINBOW_ROSE)
            .add(POTTED_LEGACY_ROSE)
            .add(POTTED_LEGACY_BLUE_ROSE);

        this.valueLookupBuilder(BlockTags.GUARDED_BY_PIGLINS)
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

        this.valueLookupBuilder(BlockTags.ICE)
            .addTag(BlockusBlockTags.ICE_BRICKS)
            .add(ICE_BRICK_WALL);

        this.valueLookupBuilder(BlockTags.IMPERMEABLE)
            .addTag(BlockusBlockTags.BEVELED_GLASS)
            .addTag(BlockusBlockTags.NEON);

        this.valueLookupBuilder(BlockTags.INFINIBURN_OVERWORLD)
            .addTag(BlockusBlockTags.NETHERRACK_BLOCKS)
            .addTag(BlockusBlockTags.MAGMA_BRICKS)
            .add(CHARCOAL_BLOCK);

        this.valueLookupBuilder(BlockTags.JUNGLE_LOGS)
            .add(JUNGLE_SMALL_LOGS);

        this.valueLookupBuilder(BlockTags.LEAVES)
            .add(WHITE_OAK_LEAVES)
            .add(LEGACY_LEAVES);

        this.valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
            .addTag(BlockusBlockTags.WHITE_OAK_LOGS)
            .add(LEGACY_LOG);

        this.valueLookupBuilder(BlockTags.MANGROVE_LOGS)
            .add(MANGROVE_SMALL_LOGS);

        this.valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .add(NETHERITE_STAIRS)
            .add(NETHERITE_SLAB)
            .add(bsswBundle(NETHERITE_BRICKS));

        this.valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(bsswBundle(GOLD_BRICKS))
            .add(bsswBundle(DIAMOND_BRICKS))
            .add(bsswBundle(EMERALD_BRICKS))
            .add(NETHER_STAR_BLOCK);

        this.valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(ENDER_BLOCK)
            .add(bsswBundle(IRON_BRICKS))
            .add(bsswBundle(LAPIS_BRICKS));

        this.valueLookupBuilder(BlockTags.OAK_LOGS)
            .add(OAK_SMALL_LOGS);

        this.valueLookupBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
            .add(WHITE_OAK_LOG);

        this.valueLookupBuilder(BlockTags.PIGLIN_REPELLENTS)
            .add(SOUL_LANTERN_BLOCK)
            .add(SOUL_O_LANTERN);

        this.valueLookupBuilder(BlockTags.PLANKS)
            .add(RAW_BAMBOO.planks())
            .add(CHARRED.planks())
            .add(WHITE_OAK.planks())
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
            .add(HERRINGBONE_CHARRED_PLANKS)
            .add(HERRINGBONE_PALE_OAK_PLANKS);

        this.valueLookupBuilder(BlockTags.SAPLINGS)
            .add(WHITE_OAK_SAPLING);

        this.valueLookupBuilder(BlockTags.FLOWERS)
            .add(FLOWERING_AZALEA_HEDGE);

        this.valueLookupBuilder(BlockTags.SMALL_FLOWERS)
            .add(RAINBOW_ROSE)
            .add(LEGACY_ROSE)
            .add(LEGACY_BLUE_ROSE);

        this.valueLookupBuilder(BlockTags.BEE_ATTRACTIVE)
            .add(RAINBOW_ROSE)
            .add(LEGACY_ROSE)
            .add(LEGACY_BLUE_ROSE)
            .add(FLOWERING_AZALEA_HEDGE);


        this.valueLookupBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
            .addTag(BlockusBlockTags.SOUL_SANDSTONE)
            .addTag(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS);

        this.valueLookupBuilder(BlockTags.SOUL_SPEED_BLOCKS)
            .addTag(BlockusBlockTags.SOUL_SANDSTONE)
            .add(SOUL_SANDSTONE.wall())
            .add(SOUL_SANDSTONE_BRICKS.wall())
            .add(SMALL_SOUL_SANDSTONE_BRICKS.wall());

        this.valueLookupBuilder(BlockTags.SPRUCE_LOGS)
            .add(SPRUCE_SMALL_LOGS);

        this.valueLookupBuilder(BlockTags.STANDING_SIGNS)
            .add(RAW_BAMBOO.standingSign())
            .add(CHARRED.standingSign())
            .add(WHITE_OAK.standingSign());

        this.valueLookupBuilder(BlockTags.WALL_SIGNS)
            .add(RAW_BAMBOO.wallSign())
            .add(CHARRED.wallSign())
            .add(WHITE_OAK.wallSign());

        this.valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
            .add(RAW_BAMBOO.ceilingHangingSign())
            .add(CHARRED.ceilingHangingSign())
            .add(WHITE_OAK.ceilingHangingSign());

        this.valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
            .add(RAW_BAMBOO.wallHangingSign())
            .add(CHARRED.wallHangingSign())
            .add(WHITE_OAK.wallHangingSign());

        this.valueLookupBuilder(BlockTags.STONE_ORE_REPLACEABLES)
            .add(LIMESTONE.block())
            .add(MARBLE.block());

        this.valueLookupBuilder(BlockTags.STONE_PRESSURE_PLATES)
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

        this.valueLookupBuilder(BlockTags.PRESSURE_PLATES)
            .add(OBSIDIAN_PRESSURE_PLATE);

        this.valueLookupBuilder(BlockTags.TRAPDOORS)
            .add(OBSIDIAN_REINFORCED_TRAPDOOR)
            .add(STONE_TRAPDOOR)
            .add(BLACKSTONE_TRAPDOOR);


        for (BSSWBundle bsswBundle : BSSWBundle.values()) {
            this.valueLookupBuilder(BlockTags.STAIRS).add(bsswBundle.stairs());
            this.valueLookupBuilder(BlockTags.SLABS).add(bsswBundle.slab());
            if (bsswBundle.wall() != null) {
                this.valueLookupBuilder(BlockTags.WALLS).add(bsswBundle.wall());
            }
        }

        for (ConcreteBundle concrete : ConcreteBundle.values()) {
            for (ConcreteBundle.ConcreteVariants variants : concrete.colorMap().values()) {
                this.valueLookupBuilder(BlockTags.STAIRS).add(variants.stairs());
                this.valueLookupBuilder(BlockTags.SLABS).add(variants.slab());
                this.valueLookupBuilder(BlockTags.WALLS).add(variants.wall());
            }
        }

        this.valueLookupBuilder(BlockTags.WALLS)
            .addTag(BlockusBlockTags.BARRIERS);

        this.valueLookupBuilder(BlockTags.WARPED_STEMS)
            .add(WARPED_SMALL_STEMS);

        this.valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
            .add(RAW_BAMBOO.button())
            .add(CHARRED.button())
            .add(WHITE_OAK.button());

        this.valueLookupBuilder(BlockTags.WOODEN_DOORS)
            .add(RAW_BAMBOO.door())
            .add(CHARRED.door())
            .add(WHITE_OAK.door())
            .add(PAPER_DOOR);

        this.valueLookupBuilder(BlockTags.WOODEN_FENCES)
            .add(RAW_BAMBOO.fence())
            .add(CHARRED.fence())
            .add(WHITE_OAK.fence());

        this.valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
            .add(RAW_BAMBOO.pressurePlate())
            .add(CHARRED.pressurePlate())
            .add(WHITE_OAK.pressurePlate());

        this.valueLookupBuilder(BlockTags.WOODEN_SLABS)
            .add(RAW_BAMBOO.slab())
            .add(CHARRED.slab())
            .add(WHITE_OAK.slab());

        this.valueLookupBuilder(BlockTags.WOODEN_STAIRS)
            .add(RAW_BAMBOO.stairs())
            .add(CHARRED.stairs())
            .add(WHITE_OAK.stairs());

        this.valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
            .add(RAW_BAMBOO.trapdoor())
            .add(CHARRED.trapdoor())
            .add(WHITE_OAK.trapdoor())
            .add(PAPER_TRAPDOOR);

        this.valueLookupBuilder(BlockTags.WOOL)
            .addTag(BlockusBlockTags.ALL_PATTERNED_WOOLS);

        this.valueLookupBuilder(BlockTags.WOOL_CARPETS)
            .addTag(BlockusBlockTags.PATTERNED_CARPETS);

        this.valueLookupBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
            .add(RAINBOW_PETALS);

        this.valueLookupBuilder(BlockTags.ANIMALS_SPAWNABLE_ON)
            .add(LEGACY_GRASS_BLOCK)
            .add(LEGACY_FIRST_GRASS_BLOCK);

        this.valueLookupBuilder(BlockTags.DIRT)
            .add(LEGACY_GRASS_BLOCK)
            .add(LEGACY_FIRST_GRASS_BLOCK);

//        this.valueLookupBuilder(new Identifier("promenade", "cherry_oak_logs"))
//            .addOptional(Blockus.id("cherry_oak_small_logs"));
//
//        this.valueLookupBuilder(new Identifier("promenade", "dark_amaranth_stems"))
//            .addOptional(Blockus.id("dark_amaranth_small_stems"));
//
//        this.valueLookupBuilder(new Identifier("promenade", "leaf_piles"))
//            .addOptional(Blockus.id("white_oak_leaf_pile"));
//
//        this.valueLookupBuilder(new Identifier("promenade", "palm_logs"))
//            .addOptional(Blockus.id("palm_small_logs"));
//
//        this.valueLookupBuilder(new Identifier("promenade", "maple_logs"))
//            .addOptional(Blockus.id("maple_small_logs"));

        // Conventional Block Tags
        this.valueLookupBuilder(ConventionalBlockTags.GLASS_BLOCKS)
            .addTag(BlockusBlockTags.BEVELED_GLASS);

        this.valueLookupBuilder(ConventionalBlockTags.SMALL_FLOWERS)
            .add(RAINBOW_ROSE);
    }

    public static Block[] bsswBundle(BSSWBundle block) {
        return block.all();
    }

    public static List<Block> bssBundle(BSSWBundle block) {
        return block.noWall();
    }

}
