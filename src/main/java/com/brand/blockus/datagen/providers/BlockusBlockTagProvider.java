package com.brand.blockus.datagen.providers;

import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.registry.tag.BlockusBlockTags;
import com.brand.blockus.utils.helper.BlockOrder;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public BlockusBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
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

        this.valueLookupBuilder(BlockTags.BARS)
            .add(GOLDEN_BARS);

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
        for (DyeColor color : BlockOrder.COLOR) {
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

        this.valueLookupBuilder(BlockTags.CHAINS)
            .add(GOLDEN_CHAIN);

        this.valueLookupBuilder(BlockusBlockTags.CHOCOLATE_BLOCKS)
            .add(bsswBundle(CHOCOLATE_BLOCK))
            .add(bsswBundle(CHOCOLATE_BRICKS))
            .add(CHOCOLATE_SQUARES)
            .add(CHOCOLATE_TABLET);

        for (DyeColor color : BlockOrder.COLOR) {
            valueLookupBuilder(BlockusBlockTags.COLORED_TILES).add(COLORED_TILES.colorMap().get(color));
        }
        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            this.valueLookupBuilder(BlockusBlockTags.COLORED_TILES).add(coloredTilesVariants.block());
        }
        this.valueLookupBuilder(BlockusBlockTags.COLORED_TILES)
            .add(RAINBOW_COLORED_TILES);

        for (ConcreteBundle concreteType : ConcreteBundle.values()) {
            this.valueLookupBuilder(BlockusBlockTags.CONCRETE_BLOCKS)
                .addAll(concreteType.all());
        }

        this.valueLookupBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS)
            .addTag(BlockusBlockTags.AMETHYST_BLOCKS);

        this.valueLookupBuilder(BlockusBlockTags.DEEPSLATE_BLOCKS)
            .add(bsswBundle(COBBLED_DEEPSLATE_BRICKS))
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

        for (DyeColor color : BlockOrder.COLOR) {
            valueLookupBuilder(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS).add(GLAZED_TERRACOTTA_PILLAR.colorMap().get(color));
        }

        this.valueLookupBuilder(BlockusBlockTags.GATES)
            .add(GOLDEN_GATE)
            .add(IRON_GATE)
            .addAll(COPPER_GATE.getAll());

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

        this.valueLookupBuilder(BlockTags.LANTERNS)
            .add(REDSTONE_LANTERN)
            .add(AMETHYST_LANTERN);

        this.valueLookupBuilder(BlockusBlockTags.LANTERN_BLOCKS)
            .add(LANTERN_BLOCK)
            .add(SOUL_LANTERN_BLOCK)
            .add(REDSTONE_LANTERN_BLOCK)
            .add(AMETHYST_LANTERN_BLOCK)
            .addAll(COPPER_LANTERN_BLOCK.getAll());

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

        for (DyeColor color : BlockOrder.COLOR) {
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
            for (var variants : woolBundle.colorMap().values()) {
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

        for (DyeColor color : BlockOrder.COLOR) {
            for (Block block : STAINED_SHINGLES.colorMap().get(color).all()) {
                valueLookupBuilder(BlockusBlockTags.SHINGLES).add(block);
            }
        }

        for (Block block : WOODEN_POST.all()) {
            valueLookupBuilder(BlockusBlockTags.WOODEN_POSTS).add(block);
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

        for (DyeColor color : BlockOrder.COLOR) {
            for (Block block : STAINED_STONE_BRICKS.colorMap().get(color).all()) {
                valueLookupBuilder(BlockusBlockTags.STAINED_STONE_BRICKS).add(block);
            }
        }

        this.valueLookupBuilder(BlockusBlockTags.STONE_BLOCKS)
            .add(bsswBundle(COBBLESTONE_BRICKS))
            .add(bsswBundle(MOSSY_COBBLESTONE_BRICKS))
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

        for (var wood : WoodMaps.values()) {
            var variants = TIMBER_FRAME.woodMap().get(wood);
            this.valueLookupBuilder(BlockusBlockTags.TIMBER_FRAMES).add(variants.block()).add(variants.diagonal()).add(variants.cross());
            this.valueLookupBuilder(BlockusBlockTags.WOODEN_LATTICES).add(variants.lattice());
            this.valueLookupBuilder(BlockusBlockTags.WOODEN_GRATES).add(variants.grate());
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
            .add(SMALL_LOGS.get(WoodMaps.WHITE_OAK.getId()));

        for (var wood : WoodMaps.values()) {
            var bundle = WOODEN_MOSAIC.bundle().get(wood.getId());
            if (bundle != null) {
                this.valueLookupBuilder(BlockusBlockTags.ALL_WOODEN_MOSAICS).add(bundle.all());
            }
        }

        for (var wood : WoodMaps.values()) {
            var bundle = MOSSY_PLANKS.bundle().get(wood.getId());
            if (bundle != null) {
                this.valueLookupBuilder(BlockusBlockTags.ALL_MOSSY_PLANKS).add(bundle.all());
            }
        }

        this.valueLookupBuilder(BlockusBlockTags.ALL_WOODEN_MOSAICS)
            .add(Blocks.BAMBOO_MOSAIC)
            .add(Blocks.BAMBOO_MOSAIC_STAIRS)
            .add(Blocks.BAMBOO_MOSAIC_SLAB);

        var planksThatBurn = this.valueLookupBuilder(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "planks_that_burn")));
        planksThatBurn
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
            .add(LEGACY_PLANKS);
        for (var wood : WoodMaps.values()) {
            if (!wood.data().isBurnable()) continue;
            var woodMosaic = WOODEN_MOSAIC.bundle().get(wood.getId());
            if (woodMosaic != null) {
                planksThatBurn.add(woodMosaic.block());
            }
            var mossyPlanks = MOSSY_PLANKS.bundle().get(wood.getId());
            if (mossyPlanks != null) {
                planksThatBurn.add(mossyPlanks.block());
            }
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                planksThatBurn.add(herringbonePlanks);
            }
        }

        for (CopperBSSWBundle bundle : CopperBSSWBundle.values()) {
            for (Block block : bundle.all()) {
                if (block.toString().contains("tuff")) {
                    this.valueLookupBuilder(BlockusBlockTags.TUFF_BLOCKS)
                        .add(block);
                } else {
                    this.valueLookupBuilder(BlockusBlockTags.COPPER_BLOCKS)
                        .add(block);
                }
            }

            this.valueLookupBuilder(BlockTags.WALLS)
                .addAll(bundle.allWalls());
        }

        // Vanilla Block Tags
        this.valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
            .add(LEGACY_PLANKS)
            .add(SOUL_O_LANTERN)
            .add(COPPER_JACK_O_LANTERN)
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

        this.valueLookupBuilder(BlockTags.MINEABLE_WITH_HOE)
            .add(ROTTEN_FLESH_BLOCK)
            .add(CHORUS_BLOCK)
            .add(LEGACY_SPONGE)
            .add(WHITE_OAK_LEAVES)
            .add(LEGACY_LEAVES)
            .addTag(BlockusBlockTags.THATCH)
            .addTag(BlockusBlockTags.HEDGES);

        this.valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
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
            .addTag(BlockusBlockTags.LANTERN_BLOCKS)
            .addTag(BlockusBlockTags.GATES)
            .addTag(BlockTags.STONE_PRESSURE_PLATES)
            .add(OBSIDIAN_PRESSURE_PLATE);

        this.valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
            .add(PATH)
            .add(SUGAR_BLOCK)
            .add(REDSTONE_SAND)
            .add(LEGACY_FIRST_GRASS_BLOCK)
            .add(LEGACY_GRASS_BLOCK)
            .add(LEGACY_GRAVEL)
            .add(SUGAR_BLOCK);

        this.valueLookupBuilder(BlockTags.SWORD_EFFICIENT)
            .add(SOUL_O_LANTERN)
            .add(COPPER_JACK_O_LANTERN)
            .add(REDSTONE_O_LANTERN)
            .add(CHORUS_BLOCK);

        this.valueLookupBuilder(BlockTags.ACACIA_LOGS)
            .add(SMALL_LOGS.get(WoodMaps.ACACIA.getId()));

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
            .addAll(bssBundle(IRON_BRICKS))
            .addAll(bssBundle(GOLD_BRICKS))
            .addAll(bssBundle(EMERALD_BRICKS))
            .addAll(bssBundle(DIAMOND_BRICKS))
            .addAll(bssBundle(NETHERITE_BRICKS));

        this.valueLookupBuilder(BlockTags.BIRCH_LOGS)
            .add(SMALL_LOGS.get(WoodMaps.BIRCH.getId()));

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
            .add(SMALL_LOGS.get(WoodMaps.PALE_OAK.getId()));

        this.valueLookupBuilder(BlockTags.CHERRY_LOGS)
            .add(SMALL_LOGS.get(WoodMaps.CHERRY.getId()));

        this.valueLookupBuilder(BlockTags.CRIMSON_STEMS)
            .add(SMALL_LOGS.get(WoodMaps.CRIMSON.getId()));

        this.valueLookupBuilder(BlockTags.DARK_OAK_LOGS)
            .add(SMALL_LOGS.get(WoodMaps.DARK_OAK.getId()));

        this.valueLookupBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
            .add(BLUESTONE.block())
            .add(VIRIDITE.block());

        this.valueLookupBuilder(BlockTags.DOORS)
            .add(OBSIDIAN_REINFORCED_DOOR)
            .add(STONE_DOOR)
            .add(BLACKSTONE_DOOR)
            .addTag(BlockusBlockTags.GATES);

        this.valueLookupBuilder(BlockTags.DRAGON_IMMUNE)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .add(NETHER_STAR_BLOCK);

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
            .add(SMALL_LOGS.get(WoodMaps.JUNGLE.getId()));

        this.valueLookupBuilder(BlockTags.LEAVES)
            .add(WHITE_OAK_LEAVES)
            .add(LEGACY_LEAVES);

        this.valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
            .addTag(BlockusBlockTags.WHITE_OAK_LOGS)
            .add(LEGACY_LOG);

        this.valueLookupBuilder(BlockTags.MANGROVE_LOGS)
            .add(SMALL_LOGS.get(WoodMaps.MANGROVE.getId()));

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
            .add(SMALL_LOGS.get(WoodMaps.OAK.getId()));

        this.valueLookupBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
            .add(WHITE_OAK_LOG);

        this.valueLookupBuilder(BlockTags.PIGLIN_REPELLENTS)
            .add(SOUL_LANTERN_BLOCK)
            .add(SOUL_O_LANTERN);

        this.valueLookupBuilder(BlockTags.PLANKS)
            .add(LEGACY_PLANKS);
        for (var wood : WoodMaps.values()) {
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                this.valueLookupBuilder(BlockTags.PLANKS).add(herringbonePlanks);
            }
        }

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
            .add(SMALL_LOGS.get(WoodMaps.SPRUCE.getId()));

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
            for (var variants : concrete.colorMap().values()) {
                this.valueLookupBuilder(BlockTags.STAIRS).add(variants.stairs());
                this.valueLookupBuilder(BlockTags.SLABS).add(variants.slab());
                this.valueLookupBuilder(BlockTags.WALLS).add(variants.wall());
            }
        }

        this.valueLookupBuilder(BlockTags.WALLS)
            .addTag(BlockusBlockTags.BARRIERS);

        this.valueLookupBuilder(BlockTags.WARPED_STEMS)
            .add(SMALL_LOGS.get(WoodMaps.WARPED.getId()));

        for (WoodBundle woodBundle : WoodBundle.values()) {
            this.valueLookupBuilder(BlockTags.PLANKS).add(woodBundle.planks());
            this.valueLookupBuilder(BlockTags.WOODEN_STAIRS).add(woodBundle.stairs());
            this.valueLookupBuilder(BlockTags.WOODEN_SLABS).add(woodBundle.slab());
            this.valueLookupBuilder(BlockTags.WOODEN_FENCES).add(woodBundle.fence());
            this.valueLookupBuilder(BlockTags.FENCE_GATES).add(woodBundle.fenceGate());
            this.valueLookupBuilder(BlockTags.WOODEN_DOORS).add(woodBundle.door());
            this.valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS).add(woodBundle.trapdoor());
            this.valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(woodBundle.pressurePlate());
            this.valueLookupBuilder(BlockTags.WOODEN_BUTTONS).add(woodBundle.button());
            this.valueLookupBuilder(BlockTags.WOODEN_SHELVES).add(woodBundle.shelf());
            this.valueLookupBuilder(BlockTags.STANDING_SIGNS).add(woodBundle.standingSign());
            this.valueLookupBuilder(BlockTags.WALL_SIGNS).add(woodBundle.wallSign());
            this.valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS).add(woodBundle.ceilingHangingSign());
            this.valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS).add(woodBundle.wallHangingSign());
        }

        this.valueLookupBuilder(BlockTags.WOODEN_DOORS)
            .add(PAPER_DOOR);

        this.valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
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
