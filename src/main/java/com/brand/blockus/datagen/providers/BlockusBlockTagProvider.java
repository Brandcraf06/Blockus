package com.brand.blockus.datagen.providers;

import com.brand.blockus.registry.content.bundles.BSSWBundle;
import com.brand.blockus.registry.content.bundles.ColoredTilesBundle;
import com.brand.blockus.registry.content.bundles.PottedLargeBundle;
import com.brand.blockus.registry.content.bundles.WoodBundle;
import com.brand.blockus.registry.tag.BlockusBlockTags;
import com.brand.blockus.utils.helper.BlockBuilder;
import com.brand.blockus.utils.helper.WoodMaps;
import com.brand.blockus.utils.references.BlockusIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.BlockItemIds;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.WeatheringCopperCollection;

import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public BlockusBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.builder(BlockusBlockTags.AMETHYST_BLOCKS)
            .add(bsswBundle(POLISHED_AMETHYST))
            .add(bsswBundle(AMETHYST_BRICKS))
            .add(toId(CHISELED_AMETHYST))
            .add(toId(AMETHYST_PILLAR))
            .add(toId(AMETHYST_LAMP));

        this.builder(BlockusBlockTags.ANDESITE_BLOCKS)
            .add(bsswBundle(ANDESITE_BRICKS))
            .add(toId(HERRINGBONE_ANDESITE_BRICKS))
            .add(toId(CHISELED_ANDESITE_BRICKS))
            .add(toId(CRACKED_ANDESITE_BRICKS))
            .add(toId(POLISHED_ANDESITE_PILLAR))
            .add(toId(ANDESITE_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.ASPHALT)
            .addAll(toIds(BlockusIds.ASPHALT))
            .add(toId(RAINBOW_ASPHALT));

        this.builder(BlockusBlockTags.ALL_ASPHALT)
            .addTag(BlockusBlockTags.ASPHALT)
            .addAll(toIds(BlockusIds.ASPHALT_STAIRS))
            .addAll(toIds(BlockusIds.ASPHALT_SLAB));

        this.builder(BlockusBlockTags.BARRIERS)
            .add(toId(CAUTION_BARRIER))
            .add(toId(ROAD_BARRIER));

        this.builder(BlockusBlockTags.BASALT_BLOCKS)
            .add(bsswBundle(ROUGH_BASALT))
            .add(bsswBundle(POLISHED_BASALT_BRICKS))
            .add(toId(CHISELED_POLISHED_BASALT))
            .add(toId(CRACKED_POLISHED_BASALT_BRICKS))
            .add(toId(POLISHED_BASALT_PILLAR))
            .add(toId(HERRINGBONE_POLISHED_BASALT_BRICKS))
            .add(toId(POLISHED_BASALT_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.BEVELED_GLASS)
            .add(toId(BEVELED_GLASS))
            .addAll(toIds(BlockusIds.STAINED_BEVELED_GLASS))
            .add(toId(RAINBOW_BEVELED_GLASS));

        this.builder(BlockusBlockTags.BLACKSTONE_BLOCKS)
            .add(bsswBundle(POLISHED_BLACKSTONE_TILES))
            .add(toId(POLISHED_BLACKSTONE_PILLAR))
            .add(toId(HERRINGBONE_POLISHED_BLACKSTONE_BRICKS))
            .add(toId(POLISHED_BLACKSTONE_CIRCULAR_PAVING))
            .add(bsswBundle(CRIMSON_WARTY_BLACKSTONE_BRICKS))
            .add(bsswBundle(WARPED_WARTY_BLACKSTONE_BRICKS))
            .add(toId(GOLD_DECORATED_POLISHED_BLACKSTONE))
            .add(toId(BLACKSTONE_DOOR))
            .add(toId(BLACKSTONE_TRAPDOOR))
            .add(toId(STURDY_BLACKSTONE));

        this.builder(BlockusBlockTags.BLAZE_BRICKS)
            .add(bsswBundle(BLAZE_BRICKS))
            .add(toId(BLAZE_PILLAR));

        this.builder(BlockusBlockTags.BLUESTONE)
            .add(bsswBundle(BLUESTONE))
            .add(toId(BLUESTONE_PILLAR))
            .add(bsswBundle(BLUESTONE_BRICKS))
            .add(bsswBundle(BLUESTONE_TILES))
            .add(bsswBundle(POLISHED_BLUESTONE))
            .add(toId(BLUESTONE_SQUARES))
            .add(bsswBundle(SMALL_BLUESTONE_BRICKS))
            .add(toId(CHISELED_BLUESTONE))
            .add(toId(BLUESTONE_CIRCULAR_PAVING))
            .add(toId(CHISELED_BLUESTONE_PILLAR))
            .add(toId(CHISELED_BLUESTONE_BRICKS))
            .add(toId(BLUESTONE_LINES));

        this.builder(BlockusBlockTags.BRICKS_BLOCKS)
            .add(bsswBundle(LARGE_BRICKS))
            .add(toId(HERRINGBONE_BRICKS))
            .add(bsswBundle(SOAKED_BRICKS))
            .add(toId(HERRINGBONE_SOAKED_BRICKS))
            .add(bsswBundle(SANDY_BRICKS))
            .add(toId(HERRINGBONE_SANDY_BRICKS))
            .add(bsswBundle(CHARRED_BRICKS))
            .add(toId(HERRINGBONE_CHARRED_BRICKS));

        this.builder(BlockusBlockTags.CHOCOLATE_BLOCKS)
            .add(bsswBundle(CHOCOLATE_BLOCK))
            .add(bsswBundle(CHOCOLATE_BRICKS))
            .add(toId(CHOCOLATE_SQUARES))
            .add(toId(CHOCOLATE_TABLET));

        this.builder(BlockusBlockTags.COLORED_TILES)
            .addAll(toIds(BlockusIds.COLORED_TILES))
            .add(toId(RAINBOW_COLORED_TILES));
        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            this.builder(BlockusBlockTags.COLORED_TILES).add(toId(coloredTilesVariants.block()));
        }

        this.builder(BlockusBlockTags.CONCRETE_BRICKS)
            .addAll(toIds(BlockusIds.CONCRETE_BRICKS))
            .addAll(toIds(BlockusIds.CHISELED_CONCRETE))
            .addAll(toIds(BlockusIds.CONCRETE_PILLAR));
        this.builder(BlockusBlockTags.ALL_CONCRETE_BRICKS)
            .addTag(BlockusBlockTags.CONCRETE_BRICKS)
            .addAll(toIds(BlockusIds.CONCRETE_BRICK_STAIRS))
            .addAll(toIds(BlockusIds.CONCRETE_BRICK_SLAB))
            .addAll(toIds(BlockusIds.CONCRETE_BRICK_WALL));

        this.builder(BlockusBlockTags.LIT_REDSTONE_LAMPS)
            .add(toId(LIT_REDSTONE_LAMP))
            .addAll(toIds(BlockusIds.DYED_LIT_REDSTONE_LAMP))
            .add(toId(LIT_RAINBOW_LAMP));


        this.builder(BlockusBlockTags.DEEPSLATE_BLOCKS)
            .add(bsswBundle(COBBLED_DEEPSLATE_BRICKS))
            .add(bsswBundle(MOSSY_DEEPSLATE_BRICKS))
            .add(toId(HERRINGBONE_DEEPSLATE_BRICKS))
            .add(toId(DEEPSLATE_PILLAR))
            .add(toId(DEEPSLATE_CIRCULAR_PAVING))
            .add(toId(STURDY_DEEPSLATE));

        this.builder(BlockusBlockTags.DIORITE_BLOCKS)
            .add(bsswBundle(DIORITE_BRICKS))
            .add(toId(HERRINGBONE_DIORITE_BRICKS))
            .add(toId(CHISELED_DIORITE_BRICKS))
            .add(toId(CRACKED_DIORITE_BRICKS))
            .add(toId(POLISHED_DIORITE_PILLAR))
            .add(toId(DIORITE_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.DRIPSTONE_BLOCKS)
            .add(bsswBundle(POLISHED_DRIPSTONE))
            .add(bsswBundle(DRIPSTONE_BRICKS))
            .add(bsswBundle(MOSSY_DRIPSTONE_BRICKS))
            .add(toId(CRACKED_DRIPSTONE_BRICKS))
            .add(toId(CHISELED_DRIPSTONE))
            .add(toId(DRIPSTONE_PILLAR));

        this.builder(BlockusBlockTags.END_STONE_BLOCKS)
            .add(toId(CHISELED_END_STONE_BRICKS))
            .add(toId(HERRINGBONE_END_STONE_BRICKS))
            .add(bsswBundle(POLISHED_END_STONE))
            .add(toId(CRACKED_END_STONE_BRICKS))
            .add(toId(END_STONE_PILLAR))
            .add(bsswBundle(SMALL_END_STONE_BRICKS))
            .add(toId(PURPUR_DECORATED_END_STONE))
            .add(toId(PHANTOM_PURPUR_DECORATED_END_STONE));

        this.builder(BlockusBlockTags.FOOD_CRATES)
            .add(toId(SWEET_BERRIES_CRATE))
            .add(toId(SALMON_CRATE))
            .add(toId(PUFFERFISH_CRATE))
            .add(toId(TROPICAL_FISH_CRATE))
            .add(toId(COD_CRATE))
            .add(toId(POTATO_CRATE))
            .add(toId(APPLE_CRATE))
            .add(toId(BEETROOT_CRATE))
            .add(toId(CARROT_CRATE))
            .add(toId(BREAD_BOX))
            .add(toId(GOLDEN_APPLE_CRATE))
            .add(toId(GOLDEN_CARROT_CRATE))
            .add(toId(GLOW_BERRIES_CRATE));

        this.builder(BlockusBlockTags.FRAMED_PAPER_BLOCKS)
            .add(toId(FRAMED_PAPER_BLOCK))
            .add(toId(PAPER_WALL))
            .add(toId(PAPER_DOOR))
            .add(toId(PAPER_TRAPDOOR));

        this.builder(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS).addAll(toIds(BlockusIds.GLAZED_TERRACOTTA_PILLAR));
        this.builder(BlockusBlockTags.GATES)
            .add(toId(GOLDEN_GATE))
            .add(toId(IRON_GATE))
            .addAll(toIds(BlockusIds.COPPER_GATE));

        this.builder(BlockusBlockTags.GRANITE_BLOCKS)
            .add(bsswBundle(GRANITE_BRICKS))
            .add(toId(HERRINGBONE_GRANITE_BRICKS))
            .add(toId(CHISELED_GRANITE_BRICKS))
            .add(toId(CRACKED_GRANITE_BRICKS))
            .add(toId(POLISHED_GRANITE_PILLAR))
            .add(toId(GRANITE_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.HONEYCOMB_BLOCKS).add(bsswBundle(HONEYCOMB_BRICKS));
        this.builder(BlockusBlockTags.ICE_BRICKS)
            .add(toId(ICE_BRICKS))
            .add(toId(ICE_PILLAR));

        this.builder(BlockusBlockTags.LARGE_FLOWER_POTS).add(toId(LARGE_FLOWER_POT));
        for (PottedLargeBundle pottedLargeType : PottedLargeBundle.values()) {
            this.builder(BlockusBlockTags.LARGE_FLOWER_POTS)
                .add(toId(pottedLargeType.block()));
        }

        this.builder(BlockusBlockTags.LANTERN_BLOCKS)
            .add(toId(LANTERN_BLOCK))
            .add(toId(SOUL_LANTERN_BLOCK))
            .add(toId(REDSTONE_LANTERN_BLOCK))
            .add(toId(AMETHYST_LANTERN_BLOCK))
            .addAll(toIds(BlockusIds.COPPER_LANTERN_BLOCK));

        this.builder(BlockusBlockTags.LAVA_BRICKS)
            .add(bsswBundle(LAVA_BRICKS))
            .add(toId(CHISELED_LAVA_BRICKS));

        this.builder(BlockusBlockTags.LAVA_POLISHED_BLACKSTONE_BRICKS)
            .add(bsswBundle(LAVA_POLISHED_BLACKSTONE_BRICKS))
            .add(toId(CHISELED_LAVA_POLISHED_BLACKSTONE));

        this.builder(BlockusBlockTags.LIMESTONE)
            .add(bsswBundle(LIMESTONE))
            .add(bsswBundle(POLISHED_LIMESTONE))
            .add(bsswBundle(LIMESTONE_BRICKS))
            .add(bsswBundle(LIMESTONE_TILES))
            .add(toId(LIMESTONE_PILLAR))
            .add(toId(LIMESTONE_SQUARES))
            .add(bsswBundle(SMALL_LIMESTONE_BRICKS))
            .add(toId(CHISELED_LIMESTONE))
            .add(toId(CHISELED_LIMESTONE_PILLAR))
            .add(toId(CHISELED_LIMESTONE_BRICKS))
            .add(toId(LIMESTONE_LINES))
            .add(toId(LIMESTONE_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.VIRIDITE)
            .add(bsswBundle(VIRIDITE))
            .add(bsswBundle(POLISHED_VIRIDITE))
            .add(bsswBundle(VIRIDITE_BRICKS))
            .add(bsswBundle(VIRIDITE_TILES))
            .add(toId(VIRIDITE_PILLAR))
            .add(toId(VIRIDITE_SQUARES))
            .add(bsswBundle(SMALL_VIRIDITE_BRICKS))
            .add(toId(CHISELED_VIRIDITE))
            .add(toId(CHISELED_VIRIDITE_PILLAR))
            .add(toId(CHISELED_VIRIDITE_BRICKS))
            .add(toId(VIRIDITE_CIRCULAR_PAVING))
            .add(toId(VIRIDITE_LINES));

        this.builder(BlockusBlockTags.MAGMA_BRICKS)
            .add(bsswBundle(MAGMA_BRICKS))
            .add(bsswBundle(SMALL_MAGMA_BRICKS))
            .add(toId(CHISELED_MAGMA_BRICKS));

        this.builder(BlockusBlockTags.MARBLE)
            .add(bsswBundle(MARBLE))
            .add(bsswBundle(POLISHED_MARBLE))
            .add(bsswBundle(MARBLE_BRICKS))
            .add(bsswBundle(MARBLE_TILES))
            .add(toId(MARBLE_PILLAR))
            .add(toId(MARBLE_SQUARES))
            .add(bsswBundle(SMALL_MARBLE_BRICKS))
            .add(toId(CHISELED_MARBLE_PILLAR))
            .add(toId(CHISELED_MARBLE_BRICKS))
            .add(toId(CHISELED_MARBLE))
            .add(toId(MARBLE_LINES))
            .add(toId(MARBLE_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.NEON)
            .addAll(toIds(BlockusIds.NEON))
            .add(toId(RAINBOW_NEON));

        this.builder(BlockusBlockTags.FUTURNEO_BLOCKS)
            .addAll(toIds(BlockusIds.FUTURNEO_BLOCK))
            .add(toId(GRAY_BRIGHT_FUTURNEO_BLOCK))
            .add(toId(RAINBOW_FUTURNEO_BLOCK));

        this.builder(BlockusBlockTags.NETHER_BRICKS)
            .add(bsswBundle(POLISHED_NETHER_BRICKS))
            .add(bsswBundle(POLISHED_RED_NETHER_BRICKS))
            .add(toId(HERRINGBONE_NETHER_BRICKS))
            .add(toId(HERRINGBONE_RED_NETHER_BRICKS))
            .add(toId(NETHER_BRICK_PILLAR))
            .add(toId(RED_NETHER_BRICK_PILLAR))
            .add(bsswBundle(CHARRED_NETHER_BRICKS))
            .add(bsswBundle(POLISHED_CHARRED_NETHER_BRICKS))
            .add(toId(HERRINGBONE_CHARRED_NETHER_BRICKS))
            .add(toId(CHARRED_NETHER_BRICK_PILLAR))
            .add(bsswBundle(TEAL_NETHER_BRICKS))
            .add(bsswBundle(POLISHED_TEAL_NETHER_BRICKS))
            .add(toId(HERRINGBONE_TEAL_NETHER_BRICKS))
            .add(toId(TEAL_NETHER_BRICK_PILLAR));

        this.builder(BlockusBlockTags.NETHERRACK_BLOCKS)
            .add(bsswBundle(POLISHED_NETHERRACK))
            .add(bsswBundle(NETHERRACK_BRICKS))
            .add(toId(NETHERRACK_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.OBSIDIAN)
            .add(bsswBundle(OBSIDIAN_BRICKS))
            .add(toId(CRACKED_OBSIDIAN_BRICKS))
            .add(bsswBundle(SMALL_OBSIDIAN_BRICKS))
            .add(toId(OBSIDIAN_PILLAR))
            .add(toId(OBSIDIAN_CIRCULAR_PAVING))
            .add(toId(OBSIDIAN_REINFORCED_DOOR))
            .add(toId(OBSIDIAN_REINFORCED_TRAPDOOR))
            .add(toId(GLOWING_OBSIDIAN))
            .add(toId(LEGACY_CRYING_OBSIDIAN))
            .add(toId(LEGACY_GLOWING_OBSIDIAN));

        this.builder(BlockusBlockTags.NETHER_PORTAL_FRAME_BLOCKS)
            .add(BlockItemIds.OBSIDIAN)
            .add(toId(OBSIDIAN_BRICKS.block()))
            .add(toId(CRACKED_OBSIDIAN_BRICKS))
            .add(toId(SMALL_OBSIDIAN_BRICKS.block()))
            .add(toId(OBSIDIAN_PILLAR))
            .add(toId(OBSIDIAN_CIRCULAR_PAVING))
            .add(toId(GLOWING_OBSIDIAN))
            .add(toId(LEGACY_GLOWING_OBSIDIAN));

        this.builder(BlockusBlockTags.PATTERNED_WOOL)
            .addAll(toIds(BlockusIds.PATTERNED_WOOL))
            .addAll(toIds(BlockusIds.GINGHAM_WOOL));
        this.builder(BlockusBlockTags.PATTERNED_CARPETS)
            .addAll(toIds(BlockusIds.PATTERNED_CARPET))
            .addAll(toIds(BlockusIds.GINGHAM_CARPET));
        this.builder(BlockusBlockTags.ALL_PATTERNED_WOOLS)
            .addTag(BlockusBlockTags.PATTERNED_WOOL)
            .addAll(toIds(BlockusIds.PATTERNED_WOOL_STAIRS))
            .addAll(toIds(BlockusIds.PATTERNED_WOOL_SLAB))
            .addAll(toIds(BlockusIds.GINGHAM_WOOL_STAIRS))
            .addAll(toIds(BlockusIds.GINGHAM_WOOL_SLAB))
            .addTag(BlockusBlockTags.PATTERNED_CARPETS);

        this.builder(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS)
            .add(bsswBundle(PHANTOM_PURPUR_BLOCK))
            .add(toId(PHANTOM_PURPUR_PILLAR))
            .add(bsswBundle(PHANTOM_PURPUR_BRICKS))
            .add(bsswBundle(POLISHED_PHANTOM_PURPUR))
            .add(toId(PHANTOM_PURPUR_SQUARES))
            .add(bsswBundle(SMALL_PHANTOM_PURPUR_BRICKS))
            .add(toId(CHISELED_PHANTOM_PURPUR))
            .add(toId(PHANTOM_PURPUR_LINES));

        this.builder(BlockusBlockTags.PLATINGS)
            .add(bsswBundle(IRON_PLATING))
            .add(bsswBundle(GOLD_PLATING));

        this.builder(BlockusBlockTags.PRISMARINE_BLOCKS)
            .add(toId(PRISMARINE_CIRCULAR_PAVING))
            .add(toId(CHISELED_DARK_PRISMARINE))
            .add(toId(DARK_PRISMARINE_PILLAR))
            .add(toId(CHISELED_PRISMARINE))
            .add(toId(PRISMARINE_PILLAR))
            .add(bsswBundle(PRISMARINE_TILES));

        this.builder(BlockusBlockTags.PURPUR_BLOCKS)
            .add(bsswBundle(PURPUR_BRICKS))
            .add(bsswBundle(POLISHED_PURPUR))
            .add(toId(PURPUR_SQUARES))
            .add(bsswBundle(SMALL_PURPUR_BRICKS))
            .add(toId(CHISELED_PURPUR))
            .add(toId(PURPUR_LINES))
            .addTag(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS);

        this.builder(BlockusBlockTags.QUARTZ_BLOCKS)
            .add(bsswBundle(QUARTZ_TILES))
            .add(toId(QUARTZ_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.RAINBOW_BLOCKS)
            .add(toId(RAINBOW_BLOCK))
            .add(bsswBundle(RAINBOW_BRICKS));

        this.builder(BlockusBlockTags.RED_SANDSTONE)
            .add(bsswBundle(ROUGH_RED_SANDSTONE))
            .add(bsswBundle(RED_SANDSTONE_BRICKS))
            .add(bsswBundle(SMALL_RED_SANDSTONE_BRICKS))
            .add(toId(GOLD_DECORATED_RED_SANDSTONE))
            .add(toId(LAPIS_DECORATED_RED_SANDSTONE))
            .add(toId(RED_SANDSTONE_PILLAR));

        this.builder(BlockusBlockTags.RESIN_BLOCKS)
            .add(bsswBundle(LARGE_RESIN_BRICKS))
            .add(toId(HERRINGBONE_RESIN_BRICKS))
            .add(toId(RESIN_BRICK_PILLAR));

        this.builder(BlockusBlockTags.SANDSTONE)
            .add(bsswBundle(ROUGH_SANDSTONE))
            .add(bsswBundle(SANDSTONE_BRICKS))
            .add(bsswBundle(SMALL_SANDSTONE_BRICKS))
            .add(toId(GOLD_DECORATED_SANDSTONE))
            .add(toId(LAPIS_DECORATED_SANDSTONE))
            .add(toId(SANDSTONE_PILLAR));

        this.builder(BlockusBlockTags.SCULK_BLOCKS)
            .add(bsswBundle(POLISHED_SCULK))
            .add(bsswBundle(SCULK_BRICKS))
            .add(toId(CHISELED_SCULK_BRICKS))
            .add(toId(SCULK_PILLAR));

        this.builder(BlockusBlockTags.SHINGLES)
            .add(toId(SHINGLES.block()))
            .addAll(toIds(BlockusIds.DYED_SHINGLES));
        this.builder(BlockusBlockTags.ALL_SHINGLES)
            .addTag(BlockusBlockTags.SHINGLES)
            .add(toId(SHINGLES.stairs()))
            .add(toId(SHINGLES.slab()))
            .addAll(toIds(BlockusIds.DYED_SHINGLES_STAIRS))
            .addAll(toIds(BlockusIds.DYED_SHINGLES_SLAB));

        for (Block block : WOODEN_POST.all()) {
            builder(BlockusBlockTags.WOODEN_POSTS).add(toId(block));
        }

        this.builder(BlockusBlockTags.HEDGES)
            .add(toId(OAK_HEDGE))
            .add(toId(SPRUCE_HEDGE))
            .add(toId(BIRCH_HEDGE))
            .add(toId(JUNGLE_HEDGE))
            .add(toId(ACACIA_HEDGE))
            .add(toId(DARK_OAK_HEDGE))
            .add(toId(MANGROVE_HEDGE))
            .add(toId(CHERRY_HEDGE))
            .add(toId(PALE_OAK_HEDGE))
            .add(toId(WHITE_OAK_HEDGE))
            .add(toId(CRIMSON_HEDGE))
            .add(toId(WARPED_HEDGE))
            .add(toId(AZALEA_HEDGE))
            .add(toId(FLOWERING_AZALEA_HEDGE))
            .add(toId(MOSS_HEDGE))
            .add(toId(PALE_MOSS_HEDGE));

        this.builder(BlockusBlockTags.SNOW_BRICKS)
            .add(bsswBundle(SNOW_BRICKS))
            .add(toId(SNOW_PILLAR));

        this.builder(BlockusBlockTags.SOUL_SANDSTONE)
            .add(bsswBundle(SOUL_SANDSTONE))
            .add(bsswBundle(ROUGH_SOUL_SANDSTONE))
            .add(bsswBundle(SMOOTH_SOUL_SANDSTONE))
            .add(bsswBundle(SOUL_SANDSTONE_BRICKS))
            .add(bsswBundle(SMALL_SOUL_SANDSTONE_BRICKS))
            .add(toId(CUT_SOUL_SANDSTONE))
            .add(toId(CUT_SOUL_SANDSTONE_SLAB))
            .add(toId(CHISELED_SOUL_SANDSTONE))
            .add(toId(GOLD_DECORATED_SOUL_SANDSTONE))
            .add(toId(LAPIS_DECORATED_SOUL_SANDSTONE))
            .add(toId(SOUL_SANDSTONE_PILLAR));

        this.builder(BlockusBlockTags.SOUL_SOILS)
            .add(BlockItemIds.SOUL_SAND)
            .add(BlockItemIds.SOUL_SOIL);

        this.builder(BlockusBlockTags.DYED_STONE_BRICKS).addAll(toIds(BlockusIds.DYED_STONE_BRICKS));
        this.builder(BlockusBlockTags.ALL_DYED_STONE_BRICKS)
            .addTag(BlockusBlockTags.DYED_STONE_BRICKS)
            .addAll(toIds(BlockusIds.DYED_STONE_BRICK_STAIRS))
            .addAll(toIds(BlockusIds.DYED_STONE_BRICK_SLAB))
            .addAll(toIds(BlockusIds.DYED_STONE_BRICK_WALL));

        this.builder(BlockusBlockTags.STONE_BLOCKS)
            .add(bsswBundle(COBBLESTONE_BRICKS))
            .add(bsswBundle(MOSSY_COBBLESTONE_BRICKS))
            .add(bsswBundle(STONE_TILES))
            .add(toId(STONE_BRICK_PILLAR))
            .add(toId(HERRINGBONE_STONE_BRICKS))
            .add(toId(STONE_CIRCULAR_PAVING))
            .add(toId(SMOOTH_STONE_STAIRS))
            .add(toId(STONE_DOOR))
            .add(toId(STONE_TRAPDOOR))
            .add(toId(STURDY_STONE));

        this.builder(BlockusBlockTags.THATCH).add(bsswBundle(THATCH));

        for (var wood : WoodMaps.values()) {
            var variants = TIMBER_FRAME.woodMap().get(wood);
            this.builder(BlockusBlockTags.TIMBER_FRAMES).add(toId(variants.block())).add(toId(variants.diagonal())).add(toId(variants.cross()));
            this.builder(BlockusBlockTags.WOODEN_LATTICES).add(toId(variants.lattice()));
            this.builder(BlockusBlockTags.WOODEN_GRATES).add(toId(variants.grate()));
        }

        this.builder(BlockusBlockTags.SULFUR_BLOCKS)
            .add(bsswBundle(SULFUR_TILES))
            .add(toId(HERRINGBONE_SULFUR_BRICKS))
            .add(toId(SULFUR_PILLAR))
            .add(toId(SULFUR_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.CINNABAR_BLOCKS)
            .add(bsswBundle(CINNABAR_TILES))
            .add(toId(HERRINGBONE_CINNABAR_BRICKS))
            .add(toId(CINNABAR_PILLAR))
            .add(toId(CINNABAR_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.TUFF_BLOCKS)
            .add(bsswBundle(MOSSY_TUFF_BRICKS))
            .add(bsswBundle(TUFF_TILES))
            .add(toId(CRACKED_TUFF_BRICKS))
            .add(toId(CARVED_TUFF_BRICKS))
            .add(toId(HERRINGBONE_TUFF_BRICKS))
            .add(toId(TUFF_PILLAR))
            .add(toId(TUFF_CIRCULAR_PAVING));

        this.builder(BlockusBlockTags.WARPED_NETHER_GRASS)
            .add(BlockItemIds.NETHER_SPROUTS)
            .add(BlockItemIds.WARPED_ROOTS);

        this.builder(BlockusBlockTags.WATER_BRICKS)
            .add(bsswBundle(WATER_BRICKS))
            .add(toId(CHISELED_WATER_BRICKS));

        this.builder(BlockusBlockTags.WHITE_OAK_LOGS)
            .add(toId(WHITE_OAK_LOG))
            .add(toId(WHITE_OAK_WOOD))
            .add(toId(STRIPPED_WHITE_OAK_LOG))
            .add(toId(STRIPPED_WHITE_OAK_WOOD))
            .add(toId(SMALL_LOGS.get(WoodMaps.WHITE_OAK.getId())));

        WOODEN_MOSAIC.forEach(block -> this.builder(BlockusBlockTags.ALL_WOODEN_MOSAICS).add(block.allIds()));
        MOSSY_PLANKS.forEach(block -> this.builder(BlockusBlockTags.ALL_MOSSY_PLANKS).add(block.allIds()));

        this.builder(BlockusBlockTags.ALL_WOODEN_MOSAICS)
            .add(BlockItemIds.BAMBOO_MOSAIC)
            .add(BlockItemIds.BAMBOO_MOSAIC_STAIRS)
            .add(BlockItemIds.BAMBOO_MOSAIC_SLAB);

        var planksThatBurn = this.builder(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "planks_that_burn")));
        planksThatBurn
            .add(BlockItemIds.OAK_PLANKS)
            .add(BlockItemIds.SPRUCE_PLANKS)
            .add(BlockItemIds.BIRCH_PLANKS)
            .add(BlockItemIds.JUNGLE_PLANKS)
            .add(BlockItemIds.ACACIA_PLANKS)
            .add(BlockItemIds.DARK_OAK_PLANKS)
            .add(BlockItemIds.MANGROVE_PLANKS)
            .add(BlockItemIds.CHERRY_PLANKS)
            .add(BlockItemIds.PALE_OAK_PLANKS)
            .add(BlockItemIds.BAMBOO_PLANKS)
            .add(toId(RAW_BAMBOO.planks()))
            .add(toId(WHITE_OAK.planks()))
            .add(toId(LEGACY_PLANKS));
        for (var wood : WoodMaps.values()) {
            if (!wood.data().isBurnable()) continue;
            var woodMosaic = WOODEN_MOSAIC.bundle().get(wood.getId());
            if (woodMosaic != null) {
                planksThatBurn.add(toId(woodMosaic.block()));
            }
            var mossyPlanks = MOSSY_PLANKS.bundle().get(wood.getId());
            if (mossyPlanks != null) {
                planksThatBurn.add(toId(mossyPlanks.block()));
            }
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                planksThatBurn.add(toId(herringbonePlanks));
            }
        }

        this.builder(BlockusBlockTags.TUFF_BLOCKS)
            .addAll(toIds(BlockusIds.COPPER_TUFF_BRICKS))
            .addAll(toIds(BlockusIds.COPPER_TUFF_BRICK_STAIRS))
            .addAll(toIds(BlockusIds.COPPER_TUFF_BRICK_SLAB))
            .addAll(toIds(BlockusIds.COPPER_TUFF_BRICK_WALL));

        this.builder(BlockusBlockTags.COPPER_BLOCKS)
            .addAll(toIds(BlockusIds.COPPER_BRICKS))
            .addAll(toIds(BlockusIds.COPPER_BRICK_STAIRS))
            .addAll(toIds(BlockusIds.COPPER_BRICK_SLAB))
            .addAll(toIds(BlockusIds.COPPER_BRICK_WALL));

        // Conventional Block Tags
        this.builder(ConventionalBlockTags.GLASS_BLOCKS).addTag(BlockusBlockTags.BEVELED_GLASS);
        this.builder(ConventionalBlockTags.SMALL_FLOWERS).add(toId(RAINBOW_ROSE));

        // Mining Block Tags
        this.builder(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(toId(NETHERITE_STAIRS))
            .add(toId(NETHERITE_SLAB))
            .add(toId(CHARCOAL_BLOCK))
            .add(toId(ENDER_BLOCK))
            .add(toId(NETHER_STAR_BLOCK))
            .add(toId(LOVE_BLOCK))
            .add(toId(WEIGHT_STORAGE_CUBE))
            .add(toId(COMPANION_CUBE))
            .add(toId(CAUTION_BLOCK))
            .add(toId(STARS_BLOCK))
            .add(toId(LEGACY_BRICKS))
            .add(toId(LEGACY_FIRST_COBBLESTONE))
            .add(toId(LEGACY_COBBLESTONE))
            .add(toId(LEGACY_MOSSY_COBBLESTONE))
            .add(toId(LEGACY_IRON_BLOCK))
            .add(toId(LEGACY_GOLD_BLOCK))
            .add(toId(LEGACY_COAL_BLOCK))
            .add(toId(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK))
            .add(toId(LEGACY_DIAMOND_BLOCK))
            .add(toId(LEGACY_LAPIS_BLOCK))
            .add(toId(LEGACY_STONECUTTER))
            .add(toId(LEGACY_NETHER_REACTOR_CORE))
            .add(bsswBundle(CRIMSON_WART_BRICKS))
            .add(bsswBundle(WARPED_WART_BRICKS))
            .add(bsswBundle(NETHER_TILES))
            .add(bsswBundle(END_TILES))
            .add(toId(CHISELED_MUD_BRICKS))
            .add(toId(MUD_BRICK_PILLAR))
            .add(bsswBundle(IRON_BRICKS))
            .add(bsswBundle(GOLD_BRICKS))
            .add(bsswBundle(LAPIS_BRICKS))
            .add(bsswBundle(REDSTONE_BRICKS))
            .add(bsswBundle(EMERALD_BRICKS))
            .add(bsswBundle(DIAMOND_BRICKS))
            .add(bsswBundle(NETHERITE_BRICKS))
            .addTag(BlockusBlockTags.AMETHYST_BLOCKS)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .addTag(BlockusBlockTags.ALL_DYED_STONE_BRICKS)
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
            .addTag(BlockusBlockTags.ALL_CONCRETE_BRICKS)
            .addTag(BlockusBlockTags.DEEPSLATE_BLOCKS)
            .addTag(BlockusBlockTags.SCULK_BLOCKS)
            .addTag(BlockusBlockTags.TUFF_BLOCKS)
            .addTag(BlockusBlockTags.SULFUR_BLOCKS)
            .addTag(BlockusBlockTags.CINNABAR_BLOCKS)
            .addTag(BlockusBlockTags.DRIPSTONE_BLOCKS)
            .addTag(BlockusBlockTags.CHOCOLATE_BLOCKS)
            .addTag(BlockusBlockTags.ALL_ASPHALT)
            .addTag(BlockusBlockTags.ALL_SHINGLES)
            .addTag(BlockusBlockTags.COLORED_TILES)
            .addTag(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS)
            .addTag(BlockusBlockTags.PLATINGS)
            .addTag(BlockusBlockTags.LARGE_FLOWER_POTS)
            .addTag(BlockusBlockTags.COPPER_BLOCKS)
            .addTag(BlockusBlockTags.RESIN_BLOCKS)
            .addTag(BlockusBlockTags.LANTERN_BLOCKS)
            .addTag(BlockusBlockTags.GATES)
            .addTag(BlockTags.STONE_PRESSURE_PLATES)
            .add(toId(OBSIDIAN_PRESSURE_PLATE));

        this.builder(BlockTags.MINEABLE_WITH_AXE)
            .add(toId(LEGACY_PLANKS))
            .add(toId(SOUL_O_LANTERN))
            .add(toId(COPPER_JACK_O_LANTERN))
            .add(toId(REDSTONE_O_LANTERN))
            .add(toId(WOODEN_FRAME))
            .addTag(BlockusBlockTags.FRAMED_PAPER_BLOCKS)
            .addTag(BlockusBlockTags.TIMBER_FRAMES)
            .addTag(BlockusBlockTags.WOODEN_LATTICES)
            .addTag(BlockusBlockTags.WOODEN_GRATES)
            .addTag(BlockusBlockTags.FOOD_CRATES)
            .addTag(BlockusBlockTags.ALL_WOODEN_MOSAICS)
            .addTag(BlockusBlockTags.ALL_MOSSY_PLANKS)
            .addTag(BlockusBlockTags.WOODEN_POSTS);

        this.builder(BlockTags.MINEABLE_WITH_HOE)
            .add(toId(ROTTEN_FLESH_BLOCK))
            .add(toId(CHORUS_BLOCK))
            .add(toId(LEGACY_SPONGE))
            .add(toId(WHITE_OAK_LEAVES))
            .add(toId(LEGACY_LEAVES))
            .addTag(BlockusBlockTags.THATCH)
            .addTag(BlockusBlockTags.HEDGES);

        this.builder(BlockTags.MINEABLE_WITH_SHOVEL)
            .add(toId(PATH))
            .add(toId(SUGAR_BLOCK))
            .add(toId(REDSTONE_SAND))
            .add(toId(LEGACY_FIRST_GRASS_BLOCK))
            .add(toId(LEGACY_GRASS_BLOCK))
            .add(toId(LEGACY_GRAVEL))
            .add(toId(SUGAR_BLOCK));

        this.builder(BlockTags.SWORD_EFFICIENT)
            .add(toId(SOUL_O_LANTERN))
            .add(toId(COPPER_JACK_O_LANTERN))
            .add(toId(REDSTONE_O_LANTERN))
            .add(toId(CHORUS_BLOCK));

        this.builder(BlockTags.NEEDS_DIAMOND_TOOL)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .add(toId(NETHERITE_STAIRS))
            .add(toId(NETHERITE_SLAB))
            .add(bsswBundle(NETHERITE_BRICKS));

        this.builder(BlockTags.NEEDS_IRON_TOOL)
            .add(bsswBundle(GOLD_BRICKS))
            .add(bsswBundle(DIAMOND_BRICKS))
            .add(bsswBundle(EMERALD_BRICKS))
            .add(toId(NETHER_STAR_BLOCK));

        this.builder(BlockTags.NEEDS_STONE_TOOL)
            .add(toId(ENDER_BLOCK))
            .add(bsswBundle(IRON_BRICKS))
            .add(bsswBundle(LAPIS_BRICKS));

        // Vanilla Block Tags
        this.builder(BlockItemTags.OAK_LOGS.block()).add(toId(SMALL_LOGS.get(WoodMaps.OAK.getId())));
        this.builder(BlockItemTags.SPRUCE_LOGS.block()).add(toId(SMALL_LOGS.get(WoodMaps.SPRUCE.getId())));
        this.builder(BlockItemTags.BIRCH_LOGS.block()).add(toId(SMALL_LOGS.get(WoodMaps.BIRCH.getId())));
        this.builder(BlockTags.JUNGLE_LOGS).add(toId(SMALL_LOGS.get(WoodMaps.JUNGLE.getId())));
        this.builder(BlockItemTags.ACACIA_LOGS.block()).add(toId(SMALL_LOGS.get(WoodMaps.ACACIA.getId())));
        this.builder(BlockItemTags.DARK_OAK_LOGS.block()).add(toId(SMALL_LOGS.get(WoodMaps.DARK_OAK.getId())));
        this.builder(BlockItemTags.MANGROVE_LOGS.block()).add(toId(SMALL_LOGS.get(WoodMaps.MANGROVE.getId())));
        this.builder(BlockItemTags.CHERRY_LOGS.block()).add(toId(SMALL_LOGS.get(WoodMaps.CHERRY.getId())));
        this.builder(BlockTags.PALE_OAK_LOGS).add(toId(SMALL_LOGS.get(WoodMaps.PALE_OAK.getId())));
        this.builder(BlockItemTags.CRIMSON_STEMS.block()).add(toId(SMALL_LOGS.get(WoodMaps.CRIMSON.getId())));
        this.builder(BlockItemTags.WARPED_STEMS.block()).add(toId(SMALL_LOGS.get(WoodMaps.WARPED.getId())));
        this.builder(BlockItemTags.LOGS_THAT_BURN.block())
            .addTag(BlockusBlockTags.WHITE_OAK_LOGS)
            .add(toId(LEGACY_LOG));
        this.builder(BlockTags.OVERWORLD_NATURAL_LOGS).add(toId(WHITE_OAK_LOG));
        this.builder(BlockTags.LEAVES)
            .add(toId(WHITE_OAK_LEAVES))
            .add(toId(LEGACY_LEAVES));


        for (WoodBundle woodBundle : WoodBundle.values()) {
            this.builder(BlockTags.PLANKS).add(toId(woodBundle.planks()));
            this.builder(BlockTags.WOODEN_STAIRS).add(toId(woodBundle.stairs()));
            this.builder(BlockTags.WOODEN_SLABS).add(toId(woodBundle.slab()));
            this.builder(BlockTags.WOODEN_FENCES).add(toId(woodBundle.fence()));
            this.builder(BlockTags.FENCE_GATES).add(toId(woodBundle.fenceGate()));
            this.builder(BlockTags.WOODEN_DOORS).add(toId(woodBundle.door()));
            this.builder(BlockTags.WOODEN_TRAPDOORS).add(toId(woodBundle.trapdoor()));
            this.builder(BlockTags.WOODEN_PRESSURE_PLATES).add(toId(woodBundle.pressurePlate()));
            this.builder(BlockTags.WOODEN_BUTTONS).add(toId(woodBundle.button()));
            this.builder(BlockTags.WOODEN_SHELVES).add(toId(woodBundle.shelf()));
            this.builder(BlockTags.STANDING_SIGNS).add(toId(woodBundle.standingSign()));
            this.builder(BlockTags.WALL_SIGNS).add(toId(woodBundle.wallSign()));
            this.builder(BlockTags.CEILING_HANGING_SIGNS).add(toId(woodBundle.ceilingHangingSign()));
            this.builder(BlockTags.WALL_HANGING_SIGNS).add(toId(woodBundle.wallHangingSign()));
        }

        this.builder(BlockTags.PLANKS).add(toId(LEGACY_PLANKS));
        HERRINGBONE_PLANKS.forEach(block -> this.builder(BlockTags.PLANKS).add(toId(block)));

        for (BSSWBundle bsswBundle : BSSWBundle.values()) {
            this.builder(BlockTags.STAIRS).add(toId(bsswBundle.stairs()));
            this.builder(BlockTags.SLABS).add(toId(bsswBundle.slab()));
            if (bsswBundle.wall() != null) {
                this.builder(BlockTags.WALLS).add(toId(bsswBundle.wall()));
            }
        }

        this.builder(BlockTags.STAIRS)
            .addAll(toIds(BlockusIds.DYED_STONE_BRICK_STAIRS))
            .addAll(toIds(BlockusIds.DYED_SHINGLES_STAIRS))
            .addAll(toIds(BlockusIds.CONCRETE_BRICK_STAIRS))
            .addAll(toIds(BlockusIds.COPPER_BRICK_STAIRS))
            .addAll(toIds(BlockusIds.COPPER_TUFF_BRICK_STAIRS));
        this.builder(BlockTags.SLABS)
            .addAll(toIds(BlockusIds.DYED_STONE_BRICK_SLAB))
            .addAll(toIds(BlockusIds.DYED_SHINGLES_SLAB))
            .addAll(toIds(BlockusIds.CONCRETE_BRICK_SLAB))
            .addAll(toIds(BlockusIds.COPPER_BRICK_SLAB))
            .addAll(toIds(BlockusIds.COPPER_TUFF_BRICK_SLAB));
        this.builder(BlockTags.WALLS)
            .addAll(toIds(BlockusIds.DYED_STONE_BRICK_WALL))
            .addAll(toIds(BlockusIds.CONCRETE_BRICK_WALL))
            .addAll(toIds(BlockusIds.COPPER_BRICK_WALL))
            .addAll(toIds(BlockusIds.COPPER_TUFF_BRICK_WALL))
            .addTag(BlockusBlockTags.BARRIERS);

        this.builder(BlockTags.PRESSURE_PLATES).add(toId(OBSIDIAN_PRESSURE_PLATE));
        this.builder(BlockTags.STONE_PRESSURE_PLATES)
            .add(toId(POLISHED_ANDESITE_PRESSURE_PLATE))
            .add(toId(POLISHED_DIORITE_PRESSURE_PLATE))
            .add(toId(POLISHED_GRANITE_PRESSURE_PLATE))
            .add(toId(LIMESTONE_PRESSURE_PLATE))
            .add(toId(MARBLE_PRESSURE_PLATE))
            .add(toId(BLUESTONE_PRESSURE_PLATE))
            .add(toId(VIRIDITE_PRESSURE_PLATE))
            .add(toId(POLISHED_NETHERRACK_PRESSURE_PLATE))
            .add(toId(POLISHED_END_STONE_PRESSURE_PLATE))
            .add(toId(POLISHED_BASALT_PRESSURE_PLATE))
            .add(toId(POLISHED_DEEPSLATE_PRESSURE_PLATE))
            .add(toId(POLISHED_SULFUR_PRESSURE_PLATE))
            .add(toId(POLISHED_CINNABAR_PRESSURE_PLATE))
            .add(toId(POLISHED_TUFF_PRESSURE_PLATE))
            .add(toId(POLISHED_SCULK_PRESSURE_PLATE));

        this.builder(BlockTags.STONE_BUTTONS)
            .add(toId(POLISHED_ANDESITE_BUTTON))
            .add(toId(POLISHED_DIORITE_BUTTON))
            .add(toId(POLISHED_GRANITE_BUTTON))
            .add(toId(LIMESTONE_BUTTON))
            .add(toId(MARBLE_BUTTON))
            .add(toId(BLUESTONE_BUTTON))
            .add(toId(VIRIDITE_BUTTON))
            .add(toId(POLISHED_NETHERRACK_BUTTON))
            .add(toId(POLISHED_END_STONE_BUTTON))
            .add(toId(POLISHED_BASALT_BUTTON))
            .add(toId(POLISHED_DEEPSLATE_BUTTON))
            .add(toId(POLISHED_SULFUR_BUTTON))
            .add(toId(POLISHED_CINNABAR_BUTTON))
            .add(toId(POLISHED_TUFF_BUTTON))
            .add(toId(POLISHED_SCULK_BUTTON));


        this.builder(BlockTags.DOORS)
            .add(toId(OBSIDIAN_REINFORCED_DOOR))
            .add(toId(STONE_DOOR))
            .add(toId(BLACKSTONE_DOOR))
            .addTag(BlockusBlockTags.GATES);
        this.builder(BlockTags.WOODEN_DOORS).add(toId(PAPER_DOOR));


        this.builder(BlockTags.TRAPDOORS)
            .add(toId(OBSIDIAN_REINFORCED_TRAPDOOR))
            .add(toId(STONE_TRAPDOOR))
            .add(toId(BLACKSTONE_TRAPDOOR));
        this.builder(BlockTags.WOODEN_TRAPDOORS).add(toId(PAPER_TRAPDOOR));

        this.builder(BlockItemTags.SAPLINGS.block()).add(toId(WHITE_OAK_SAPLING));
        this.builder(BlockTags.FLOWERS).add(toId(FLOWERING_AZALEA_HEDGE));
        this.builder(BlockTags.SMALL_FLOWERS)
            .add(toId(RAINBOW_ROSE))
            .add(toId(LEGACY_ROSE))
            .add(toId(LEGACY_BLUE_ROSE));

        this.builder(BlockTags.DIRT)
            .add(toId(LEGACY_GRASS_BLOCK))
            .add(toId(LEGACY_FIRST_GRASS_BLOCK));

        this.builder(BlockTags.WOOL).addTag(BlockusBlockTags.ALL_PATTERNED_WOOLS).add(toId(RAINBOW_WOOL));
        this.builder(BlockTags.WOOL_CARPETS).addTag(BlockusBlockTags.PATTERNED_CARPETS).add(toId(RAINBOW_CARPET));
        this.builder(BlockTags.BEDS).add(toId(RAINBOW_BED));
        this.builder(BlockTags.CONCRETE).addTag(BlockusBlockTags.CONCRETE_BRICKS);
        this.builder(BlockTags.GLAZED_TERRACOTTA).addTag(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS);
        this.builder(BlockTags.TERRACOTTA).addTag(BlockusBlockTags.SHINGLES);
        this.builder(BlockTags.BARS).add(toId(GOLDEN_BARS));
        this.builder(BlockTags.CHAINS).add(toId(GOLDEN_CHAIN));
        this.builder(BlockTags.LANTERNS)
            .add(toId(REDSTONE_LANTERN))
            .add(toId(AMETHYST_LANTERN));

        this.builder(BlockTags.STONE_ORE_REPLACEABLES)
            .add(toId(LIMESTONE.block()))
            .add(toId(MARBLE.block()));

        this.builder(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
            .add(toId(BLUESTONE.block()))
            .add(toId(VIRIDITE.block()));

        this.builder(BlockTags.BASE_STONE_OVERWORLD)
            .add(toId(LIMESTONE.block()))
            .add(toId(MARBLE.block()))
            .add(toId(BLUESTONE.block()))
            .add(toId(VIRIDITE.block()));

        this.builder(BlockTags.IMPERMEABLE)
            .addTag(BlockusBlockTags.BEVELED_GLASS)
            .addTag(BlockusBlockTags.NEON);

        this.builder(BlockTags.DRAGON_IMMUNE)
            .addTag(BlockusBlockTags.OBSIDIAN)
            .add(toId(NETHER_STAR_BLOCK));

        this.builder(BlockTags.INFINIBURN_OVERWORLD)
            .addTag(BlockusBlockTags.NETHERRACK_BLOCKS)
            .addTag(BlockusBlockTags.MAGMA_BRICKS)
            .add(toId(CHARCOAL_BLOCK));

        this.builder(BlockTags.VIBRATION_RESONATORS).addTag(BlockusBlockTags.AMETHYST_BLOCKS);
        this.builder(BlockTags.CRYSTAL_SOUND_BLOCKS).addTag(BlockusBlockTags.AMETHYST_BLOCKS);

        this.builder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
            .addTag(BlockusBlockTags.SOUL_SANDSTONE)
            .addTag(BlockusBlockTags.PHANTOM_PURPUR_BLOCKS);

        this.builder(BlockTags.SOUL_SPEED_BLOCKS)
            .addTag(BlockusBlockTags.SOUL_SANDSTONE)
            .add(toId(SOUL_SANDSTONE.wall()))
            .add(toId(SOUL_SANDSTONE_BRICKS.wall()))
            .add(toId(SMALL_SOUL_SANDSTONE_BRICKS.wall()));

        this.builder(BlockTags.FLOWER_POTS)
            .add(toId(POTTED_WHITE_OAK_SAPLING))
            .add(toId(POTTED_RAINBOW_ROSE))
            .add(toId(POTTED_LEGACY_ROSE))
            .add(toId(POTTED_LEGACY_BLUE_ROSE));

        this.builder(BlockTags.ICE)
            .addTag(BlockusBlockTags.ICE_BRICKS)
            .add(toId(ICE_BRICK_WALL));

        this.builder(BlockTags.BEACON_BASE_BLOCKS)
            .add(toId(LEGACY_GOLD_BLOCK))
            .add(toId(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK))
            .add(toId(LEGACY_IRON_BLOCK))
            .add(toId(LEGACY_DIAMOND_BLOCK))
            .add(toId(NETHERITE_SLAB))
            .add(toId(NETHERITE_STAIRS))
            .add(toId(NETHER_STAR_BLOCK))
            .add(bssBundle(IRON_BRICKS))
            .add(bssBundle(GOLD_BRICKS))
            .add(bssBundle(EMERALD_BRICKS))
            .add(bssBundle(DIAMOND_BRICKS))
            .add(bssBundle(NETHERITE_BRICKS));

        this.builder(BlockTags.ANIMALS_SPAWNABLE_ON)
            .add(toId(LEGACY_GRASS_BLOCK))
            .add(toId(LEGACY_FIRST_GRASS_BLOCK));

        this.builder(BlockTags.BEE_ATTRACTIVE)
            .add(toId(RAINBOW_ROSE))
            .add(toId(LEGACY_ROSE))
            .add(toId(LEGACY_BLUE_ROSE))
            .add(toId(FLOWERING_AZALEA_HEDGE));

        this.builder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(toId(RAINBOW_PETALS));
        this.builder(BlockTags.GUARDED_BY_PIGLINS)
            .add(toId(LEGACY_GOLD_BLOCK))
            .add(toId(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK))
            .add(toId(GOLDEN_CHAIN))
            .add(toId(GOLDEN_BARS))
            .add(toId(GOLDEN_GATE))
            .add(toId(GOLD_DECORATED_SANDSTONE))
            .add(toId(GOLD_DECORATED_RED_SANDSTONE))
            .add(toId(GOLD_DECORATED_SOUL_SANDSTONE))
            .add(toId(GOLD_DECORATED_POLISHED_BLACKSTONE))
            .add(bsswBundle(GOLD_PLATING))
            .add(bsswBundle(GOLD_BRICKS))
            .add(toId(GOLDEN_APPLE_CRATE))
            .add(toId(GOLDEN_CARROT_CRATE));

        this.builder(BlockTags.PIGLIN_REPELLENTS)
            .add(toId(SOUL_LANTERN_BLOCK))
            .add(toId(SOUL_O_LANTERN));
    }

    public BlockItemId toId(Block block) {
        return BlockBuilder.getId(block);
    }

    private static ColorCollection<ResourceKey<Block>> toIds(ColorCollection<BlockItemId> ids) {
        return ids.map(BlockItemId::block);
    }

    private static WeatheringCopperCollection<ResourceKey<Block>> toIds(WeatheringCopperCollection<BlockItemId> ids) {
        return ids.map(BlockItemId::block);
    }

    public static BlockItemId[] bsswBundle(BSSWBundle block) {
        return block.allIds();
    }

    public static BlockItemId[] bssBundle(BSSWBundle block) {
        return block.idsNoWall();
    }
}
