package com.brand.blockus.datagen.providers;

import com.brand.blockus.datagen.family.BlockusFamilies;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.registry.tag.BlockusItemTags;
import com.brand.blockus.utils.helper.BlockMaps;
import com.brand.blockus.utils.helper.BlockOrder;
import com.brand.blockus.utils.helper.WoodMaps;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;


public class BlockusRecipeProvider extends FabricRecipeProvider {
    public BlockusRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final Map<DyeColor, ItemLike> DYE_MAP = ImmutableMap.<DyeColor, ItemLike>builder()
        .put(DyeColor.WHITE, Items.WHITE_DYE)
        .put(DyeColor.LIGHT_GRAY, Items.LIGHT_GRAY_DYE)
        .put(DyeColor.GRAY, Items.GRAY_DYE)
        .put(DyeColor.BLACK, Items.BLACK_DYE)
        .put(DyeColor.BROWN, Items.BROWN_DYE)
        .put(DyeColor.RED, Items.RED_DYE)
        .put(DyeColor.ORANGE, Items.ORANGE_DYE)
        .put(DyeColor.YELLOW, Items.YELLOW_DYE)
        .put(DyeColor.LIME, Items.LIME_DYE)
        .put(DyeColor.GREEN, Items.GREEN_DYE)
        .put(DyeColor.CYAN, Items.CYAN_DYE)
        .put(DyeColor.LIGHT_BLUE, Items.LIGHT_BLUE_DYE)
        .put(DyeColor.BLUE, Items.BLUE_DYE)
        .put(DyeColor.PURPLE, Items.PURPLE_DYE)
        .put(DyeColor.MAGENTA, Items.MAGENTA_DYE)
        .put(DyeColor.PINK, Items.PINK_DYE)
        .build();

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        for (BSSWBundle BSSWBundle : BSSWBundle.values()) {
            offerStairsRecipe(exporter, BSSWBundle.stairs(), BSSWBundle.block());
            slab(exporter, RecipeCategory.BUILDING_BLOCKS, BSSWBundle.slab(), BSSWBundle.block());
            if (BSSWBundle.wall() != null) {
                wall(exporter, RecipeCategory.DECORATIONS, BSSWBundle.wall(), BSSWBundle.block());
            }
        }

        for (ConcreteBundle concreteType : ConcreteBundle.values()) {
            for (Map.Entry<DyeColor, ConcreteBundle.ConcreteVariants> entry : concreteType.colorMap().entrySet()) {
                ConcreteBundle.ConcreteVariants variants = entry.getValue();
                Block base = BlockMaps.CONCRETE_MAP.get(entry.getKey());
                offerStonecuttingRecipe(exporter, variants.block(), base);
                offerStonecuttingRecipe(exporter, variants.stairs(), base, variants.block());
                offerStonecuttingRecipe(exporter, variants.slab(), 2, base, variants.block());
                offerStonecuttingRecipe(exporter, variants.wall(), base, variants.block());
                offerStonecuttingRecipe(exporter, variants.chiseled(), base, variants.block());
                offerStonecuttingRecipe(exporter, variants.pillar(), base, variants.block());
                offerPolishedStoneRecipe(exporter, variants.block(), base);
            }
        }

        for (AsphaltBundle.AsphaltVariants asphaltBundle : ASPHALT.colorMap().values()) {
            offerStairsRecipe(exporter, asphaltBundle.stairs(), asphaltBundle.block());
            slab(exporter, RecipeCategory.BUILDING_BLOCKS, asphaltBundle.slab(), asphaltBundle.block());
            offerStonecuttingRecipe(exporter, asphaltBundle.stairs(), asphaltBundle.block());
            offerStonecuttingRecipe(exporter, asphaltBundle.slab(), 2, asphaltBundle.block());
        }

        for (WoolBundle woolBundle : WoolBundle.values()) {
            for (Map.Entry<DyeColor, WoolBundle.WoolVariants> entry : woolBundle.colorMap().entrySet()) {
                WoolBundle.WoolVariants variants = entry.getValue();
                if (woolBundle == PATTERNED_WOOL) {
                    offerPatternedWoolRecipe(exporter, variants.block(), BlockMaps.WOOL_MAP.get(entry.getKey()), variants.carpet(), BlockMaps.CARPET_MAP.get(entry.getKey()));
                } else if (woolBundle == GINGHAM_WOOL) {
                    offerGinghamWoolRecipe(exporter, variants.block(), BlockMaps.WOOL_MAP.get(entry.getKey()));
                }

                offerStairsRecipe(exporter, variants.stairs(), variants.block());
                slab(exporter, RecipeCategory.BUILDING_BLOCKS, variants.slab(), variants.block());
                carpet(exporter, variants.carpet(), variants.block());
            }
        }

        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            offerColoredTilesRecipe(exporter, coloredTilesVariants.block(), coloredTilesVariants.tile1(), coloredTilesVariants.tile2());
        }

        generateForEnabledBlockFamilies(exporter, FeatureFlagSet.of(FeatureFlags.VANILLA));

        offerPillarRecipe(exporter, MUD_BRICK_PILLAR, Blocks.MUD_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_MUD_BRICKS, Blocks.MUD_BRICKS);

        // Stone
        offerBsswCuttingRecipe(exporter, STONE_TILES, Blocks.STONE, Blocks.STONE_BRICKS);
        offerPolishedStoneRecipe(exporter, STONE_TILES.block(), Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, STONE_BRICK_PILLAR, Blocks.STONE, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_STONE_BRICKS, Blocks.STONE, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, STONE_CIRCULAR_PAVING, Blocks.STONE, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
        offerStairsRecipe(exporter, SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
        offerSturdyRecipe(exporter, STURDY_STONE, Blocks.STONE, Blocks.COBBLESTONE);
        offerStoneDoorTrapdoorRecipe(exporter, STONE_DOOR, STONE_TRAPDOOR, Blocks.STONE, Blocks.STONE_SLAB);

        // Andesite
        offerBsswCuttingRecipe(exporter, ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
        offerPolishedStoneRecipe(exporter, ANDESITE_BRICKS.block(), Blocks.POLISHED_ANDESITE);
        smeltingResultFromBase(exporter, CRACKED_ANDESITE_BRICKS, ANDESITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, POLISHED_ANDESITE_PILLAR, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, HERRINGBONE_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, ANDESITE_CIRCULAR_PAVING, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
        offerPressurePlateButtonRecipe(exporter, POLISHED_ANDESITE_PRESSURE_PLATE, POLISHED_ANDESITE_BUTTON, Blocks.POLISHED_ANDESITE);

        // Diorite
        offerBsswCuttingRecipe(exporter, DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
        offerPolishedStoneRecipe(exporter, DIORITE_BRICKS.block(), Blocks.POLISHED_DIORITE);
        smeltingResultFromBase(exporter, CRACKED_DIORITE_BRICKS, DIORITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, POLISHED_DIORITE_PILLAR, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, HERRINGBONE_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, DIORITE_CIRCULAR_PAVING, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
        offerPressurePlateButtonRecipe(exporter, POLISHED_DIORITE_PRESSURE_PLATE, POLISHED_DIORITE_BUTTON, Blocks.POLISHED_DIORITE);

        // Granite
        offerBsswCuttingRecipe(exporter, GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE);
        offerPolishedStoneRecipe(exporter, GRANITE_BRICKS.block(), Blocks.POLISHED_GRANITE);
        smeltingResultFromBase(exporter, CRACKED_GRANITE_BRICKS, GRANITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, POLISHED_GRANITE_PILLAR, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, HERRINGBONE_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, GRANITE_CIRCULAR_PAVING, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
        offerPressurePlateButtonRecipe(exporter, POLISHED_GRANITE_PRESSURE_PLATE, POLISHED_GRANITE_BUTTON, Blocks.POLISHED_GRANITE);

        // Dripstone
        offerBsswCuttingRecipe(exporter, POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
        offerPolishedStoneRecipe(exporter, POLISHED_DRIPSTONE.block(), Blocks.DRIPSTONE_BLOCK);
        offerBsswCuttingRecipe(exporter, DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block());
        offerPolishedStoneRecipe(exporter, DRIPSTONE_BRICKS.block(), POLISHED_DRIPSTONE.block());
        offerMossyRecipe(exporter, MOSSY_DRIPSTONE_BRICKS.block(), DRIPSTONE_BRICKS.block());
        offerBsswCuttingRecipe(exporter, MOSSY_DRIPSTONE_BRICKS);
        smeltingResultFromBase(exporter, CRACKED_DRIPSTONE_BRICKS, DRIPSTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block(), DRIPSTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, DRIPSTONE_PILLAR, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block(), DRIPSTONE_BRICKS.block());

        // Tuff
        offerBsswCuttingRecipe(exporter, TUFF_TILES, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
        offerPolishedStoneRecipe(exporter, TUFF_TILES.block(), Blocks.TUFF_BRICKS);
        smeltingResultFromBase(exporter, CRACKED_TUFF_BRICKS, Blocks.TUFF_BRICKS);
        offerMossyRecipe(exporter, MOSSY_TUFF_BRICKS.block(), Blocks.TUFF_BRICKS);
        offerBsswCuttingRecipe(exporter, MOSSY_TUFF_BRICKS);
        offerStonecuttingRecipe(exporter, CARVED_TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
        offerStonecuttingRecipe(exporter, TUFF_PILLAR, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
        offerStonecuttingRecipe(exporter, TUFF_CIRCULAR_PAVING, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
        offerPressurePlateButtonRecipe(exporter, POLISHED_TUFF_PRESSURE_PLATE, POLISHED_TUFF_BUTTON, Blocks.POLISHED_TUFF);

        // Amethyst
        offerBsswCuttingRecipe(exporter, POLISHED_AMETHYST, Blocks.AMETHYST_BLOCK);
        offerPolishedStoneRecipe(exporter, POLISHED_AMETHYST.block(), Blocks.AMETHYST_BLOCK);
        offerBsswCuttingRecipe(exporter, AMETHYST_BRICKS, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block());
        offerPolishedStoneRecipe(exporter, AMETHYST_BRICKS.block(), POLISHED_AMETHYST.block());
        offerStonecuttingRecipe(exporter, CHISELED_AMETHYST, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block(), AMETHYST_BRICKS.block());
        offerStonecuttingRecipe(exporter, AMETHYST_PILLAR, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block(), AMETHYST_BRICKS.block());
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AMETHYST_LAMP).define('#', Items.AMETHYST_SHARD).define('X', Items.REDSTONE).pattern(" # ").pattern("#X#").pattern(" # ").unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(exporter);

        // Deepslate
        offerMossyRecipe(exporter, MOSSY_DEEPSLATE_BRICKS.block(), Blocks.DEEPSLATE_BRICKS);
        offerBsswCuttingRecipe(exporter, MOSSY_DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, DEEPSLATE_PILLAR, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, DEEPSLATE_CIRCULAR_PAVING, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        offerSturdyRecipe(exporter, STURDY_DEEPSLATE, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
        offerPressurePlateButtonRecipe(exporter, POLISHED_DEEPSLATE_PRESSURE_PLATE, POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);

        // Sculk
        offerBsswCuttingRecipe(exporter, POLISHED_SCULK, Blocks.SCULK);
        offerPolishedStoneRecipe(exporter, POLISHED_SCULK.block(), Blocks.SCULK);
        offerBsswCuttingRecipe(exporter, SCULK_BRICKS, Blocks.SCULK, POLISHED_SCULK.block());
        offerStonecuttingRecipe(exporter, CHISELED_SCULK_BRICKS, Blocks.SCULK, POLISHED_SCULK.block(), SCULK_BRICKS.block());
        offerStonecuttingRecipe(exporter, SCULK_PILLAR, Blocks.SCULK, POLISHED_SCULK.block(), SCULK_BRICKS.block());
        offerPolishedStoneRecipe(exporter, SCULK_BRICKS.block(), POLISHED_SCULK.block());
        offerPressurePlateButtonRecipe(exporter, POLISHED_SCULK_PRESSURE_PLATE, POLISHED_SCULK_BUTTON, POLISHED_SCULK.block());

        // Blackstone
        offerBsswCuttingRecipe(exporter, POLISHED_BLACKSTONE_TILES, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerPolishedStoneRecipe(exporter, POLISHED_BLACKSTONE_TILES.block(), Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, POLISHED_BLACKSTONE_PILLAR, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, POLISHED_BLACKSTONE_CIRCULAR_PAVING, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, CRIMSON_WARTY_BLACKSTONE_BRICKS.block()).requires(Blocks.POLISHED_BLACKSTONE_BRICKS).requires(Blocks.CRIMSON_ROOTS).unlockedBy("has_roots", has(Blocks.CRIMSON_ROOTS)).save(exporter);
        offerBsswCuttingRecipe(exporter, CRIMSON_WARTY_BLACKSTONE_BRICKS);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WARPED_WARTY_BLACKSTONE_BRICKS.block()).requires(Blocks.POLISHED_BLACKSTONE_BRICKS).requires(BlockusItemTags.WARPED_NETHER_GRASS).unlockedBy("has_roots", has(BlockusItemTags.WARPED_NETHER_GRASS)).save(exporter);
        offerBsswCuttingRecipe(exporter, WARPED_WARTY_BLACKSTONE_BRICKS);
        offerSturdyRecipe(exporter, STURDY_BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
        offerDecoratedRecipe(exporter, GOLD_DECORATED_POLISHED_BLACKSTONE, Items.GOLD_INGOT, Blocks.POLISHED_BLACKSTONE);
        offerStoneDoorTrapdoorRecipe(exporter, BLACKSTONE_DOOR, BLACKSTONE_TRAPDOOR, Blocks.BLACKSTONE, Blocks.BLACKSTONE_SLAB);

        // Basalt
        offerBsswCuttingRecipe(exporter, ROUGH_BASALT);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_BASALT.block(), 2).define('#', Blocks.BASALT).pattern("#").pattern("#").unlockedBy("has_basalt", has(Blocks.BASALT)).save(exporter);
        offerBsswCuttingRecipe(exporter, POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT);
        offerPolishedStoneRecipe(exporter, POLISHED_BASALT_BRICKS.block(), Blocks.POLISHED_BASALT);
        smeltingResultFromBase(exporter, CRACKED_POLISHED_BASALT_BRICKS, POLISHED_BASALT_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_POLISHED_BASALT, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
        offerStonecuttingRecipe(exporter, POLISHED_BASALT_PILLAR, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
        offerStonecuttingRecipe(exporter, HERRINGBONE_POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
        offerStonecuttingRecipe(exporter, POLISHED_BASALT_CIRCULAR_PAVING, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
        offerPressurePlateButtonRecipe(exporter, POLISHED_BASALT_PRESSURE_PLATE, POLISHED_BASALT_BUTTON, Blocks.POLISHED_BASALT);

        // Wart Blocks
        offerBsswCuttingRecipe(exporter, CRIMSON_WART_BRICKS, Blocks.NETHER_WART_BLOCK);
        offerPolishedStoneRecipe(exporter, CRIMSON_WART_BRICKS.block(), Blocks.NETHER_WART_BLOCK);
        offerBsswCuttingRecipe(exporter, WARPED_WART_BRICKS, Blocks.WARPED_WART_BLOCK);
        offerPolishedStoneRecipe(exporter, WARPED_WART_BRICKS.block(), Blocks.WARPED_WART_BLOCK);

        // Limestone
        offerBsswCuttingRecipe(exporter, LIMESTONE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LIMESTONE.block()).define('#', Blocks.COBBLESTONE).define('X', Items.BONE_MEAL).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE)).save(exporter);
        offerBsswCuttingRecipe(exporter, POLISHED_LIMESTONE, LIMESTONE.block());
        offerPolishedStoneRecipe(exporter, POLISHED_LIMESTONE.block(), LIMESTONE.block());
        offerBsswCuttingRecipe(exporter, LIMESTONE_BRICKS, LIMESTONE.block(), POLISHED_LIMESTONE.block());
        offerPolishedStoneRecipe(exporter, LIMESTONE_BRICKS.block(), POLISHED_LIMESTONE.block());
        offerBsswCuttingRecipe(exporter, SMALL_LIMESTONE_BRICKS, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
        offerBsswCuttingRecipe(exporter, LIMESTONE_TILES, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
        offerPolishedStoneRecipe(exporter, LIMESTONE_TILES.block(), LIMESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_LIMESTONE, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_LIMESTONE_BRICKS, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_LIMESTONE_PILLAR, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block(), LIMESTONE_PILLAR);
        offerStonecuttingRecipe(exporter, LIMESTONE_PILLAR, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, LIMESTONE_SQUARES, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, LIMESTONE_CIRCULAR_PAVING, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, LIMESTONE_LINES, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
        offerPressurePlateButtonRecipe(exporter, LIMESTONE_PRESSURE_PLATE, LIMESTONE_BUTTON, LIMESTONE.block());

        // Marble
        offerBsswCuttingRecipe(exporter, MARBLE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MARBLE.block()).define('#', LIMESTONE.block()).define('X', Items.BONE_MEAL).pattern("#X").pattern("X#").group("marble").unlockedBy(getHasName(LIMESTONE.block()), has(LIMESTONE.block())).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, MARBLE.block()).requires(Blocks.CALCITE).requires(LIMESTONE.block()).group("marble").unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(exporter, getConversionRecipeName(MARBLE.block(), Blocks.CALCITE));
        offerBsswCuttingRecipe(exporter, POLISHED_MARBLE, MARBLE.block());
        offerPolishedStoneRecipe(exporter, POLISHED_MARBLE.block(), MARBLE.block());
        offerBsswCuttingRecipe(exporter, MARBLE_BRICKS, MARBLE.block(), POLISHED_MARBLE.block());
        offerPolishedStoneRecipe(exporter, MARBLE_BRICKS.block(), POLISHED_MARBLE.block());
        offerBsswCuttingRecipe(exporter, SMALL_MARBLE_BRICKS, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
        offerBsswCuttingRecipe(exporter, MARBLE_TILES, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
        offerPolishedStoneRecipe(exporter, MARBLE_TILES.block(), MARBLE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_MARBLE, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_MARBLE_BRICKS, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_MARBLE_PILLAR, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block(), MARBLE_PILLAR);
        offerStonecuttingRecipe(exporter, MARBLE_PILLAR, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
        offerStonecuttingRecipe(exporter, MARBLE_SQUARES, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
        offerStonecuttingRecipe(exporter, MARBLE_CIRCULAR_PAVING, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
        offerStonecuttingRecipe(exporter, MARBLE_LINES, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
        offerPressurePlateButtonRecipe(exporter, MARBLE_PRESSURE_PLATE, MARBLE_BUTTON, MARBLE.block());

        // Bluestone
        offerBsswCuttingRecipe(exporter, BLUESTONE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BLUESTONE.block(), 4).define('S', Blocks.STONE).define('#', Items.BLUE_DYE).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Items.BLUE_DYE), has(Items.BLUE_DYE)).unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE)).save(exporter);
        offerBsswCuttingRecipe(exporter, POLISHED_BLUESTONE, BLUESTONE.block());
        offerPolishedStoneRecipe(exporter, POLISHED_BLUESTONE.block(), BLUESTONE.block());
        offerBsswCuttingRecipe(exporter, BLUESTONE_BRICKS, BLUESTONE.block(), POLISHED_BLUESTONE.block());
        offerPolishedStoneRecipe(exporter, BLUESTONE_BRICKS.block(), POLISHED_BLUESTONE.block());
        offerBsswCuttingRecipe(exporter, SMALL_BLUESTONE_BRICKS, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
        offerBsswCuttingRecipe(exporter, BLUESTONE_TILES, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
        offerPolishedStoneRecipe(exporter, BLUESTONE_TILES.block(), BLUESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_BLUESTONE, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_BLUESTONE_BRICKS, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_BLUESTONE_PILLAR, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block(), BLUESTONE_PILLAR);
        offerStonecuttingRecipe(exporter, BLUESTONE_PILLAR, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, BLUESTONE_SQUARES, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, BLUESTONE_CIRCULAR_PAVING, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, BLUESTONE_LINES, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
        offerPressurePlateButtonRecipe(exporter, BLUESTONE_PRESSURE_PLATE, BLUESTONE_BUTTON, BLUESTONE.block());

        // Viridite
        offerBsswCuttingRecipe(exporter, VIRIDITE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block(), 4).define('S', Blocks.DEEPSLATE).define('#', Blocks.SCULK).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Blocks.SCULK), has(Blocks.SCULK)).unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block(), 4).define('S', Blocks.DEEPSLATE).define('#', Items.GREEN_DYE).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE)).unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE)).save(exporter, getConversionRecipeName(VIRIDITE.block(), Items.GREEN_DYE));
        offerBsswCuttingRecipe(exporter, POLISHED_VIRIDITE, VIRIDITE.block());
        offerPolishedStoneRecipe(exporter, POLISHED_VIRIDITE.block(), VIRIDITE.block());
        offerBsswCuttingRecipe(exporter, VIRIDITE_BRICKS, VIRIDITE.block(), POLISHED_VIRIDITE.block());
        offerPolishedStoneRecipe(exporter, VIRIDITE_BRICKS.block(), POLISHED_VIRIDITE.block());
        offerBsswCuttingRecipe(exporter, SMALL_VIRIDITE_BRICKS, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
        offerBsswCuttingRecipe(exporter, VIRIDITE_TILES, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
        offerPolishedStoneRecipe(exporter, VIRIDITE_TILES.block(), VIRIDITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_VIRIDITE, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_VIRIDITE_BRICKS, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_VIRIDITE_PILLAR, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block(), VIRIDITE_PILLAR);
        offerStonecuttingRecipe(exporter, VIRIDITE_PILLAR, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, VIRIDITE_SQUARES, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, VIRIDITE_CIRCULAR_PAVING, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
        offerStonecuttingRecipe(exporter, VIRIDITE_LINES, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
        offerPressurePlateButtonRecipe(exporter, VIRIDITE_PRESSURE_PLATE, VIRIDITE_BUTTON, VIRIDITE.block());

        // Lava	Bricks
        offerBsswCuttingRecipe(exporter, LAVA_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_LAVA_BRICKS, LAVA_BRICKS.block());
        createEnclosedRecipe(LAVA_BRICKS.block(), Ingredient.of(Blocks.STONE_BRICKS), Items.LAVA_BUCKET).unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET)).unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter);

        // Lava Blackstone Bricks
        offerBsswCuttingRecipe(exporter, LAVA_POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_LAVA_POLISHED_BLACKSTONE, LAVA_POLISHED_BLACKSTONE_BRICKS.block());
        createEnclosedRecipe(LAVA_POLISHED_BLACKSTONE_BRICKS.block(), Ingredient.of(Blocks.POLISHED_BLACKSTONE_BRICKS), Items.LAVA_BUCKET).unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET)).unlockedBy(getHasName(Blocks.POLISHED_BLACKSTONE_BRICKS), has(Blocks.POLISHED_BLACKSTONE_BRICKS)).save(exporter);

        // Water Bricks
        offerBsswCuttingRecipe(exporter, WATER_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_WATER_BRICKS, WATER_BRICKS.block());
        createEnclosedRecipe(WATER_BRICKS.block(), Ingredient.of(Blocks.STONE_BRICKS), Items.WATER_BUCKET).unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET)).unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter);

        // Snow Bricks
        offerBsswCuttingRecipe(exporter, SNOW_BRICKS);
        offerStonecuttingRecipe(exporter, SNOW_PILLAR, SNOW_BRICKS.block());
        offerPolishedStoneRecipe(exporter, SNOW_BRICKS.block(), Blocks.SNOW_BLOCK);

        // Ice Bricks
        offerStonecuttingRecipe(exporter, ICE_BRICK_WALL, ICE_BRICKS);
        offerStonecuttingRecipe(exporter, ICE_PILLAR, ICE_BRICKS);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ICE_BRICKS, 4).define('#', BlockusItemTags.NATURAL_ICE).pattern("##").pattern("##").unlockedBy("has_ice", has(BlockusItemTags.NATURAL_ICE)).save(exporter);
        wall(exporter, RecipeCategory.BUILDING_BLOCKS, ICE_BRICK_WALL, ICE_BRICKS);

        // Magma Bricks
        offerBsswCuttingRecipe(exporter, MAGMA_BRICKS, Blocks.MAGMA_BLOCK);
        offerPolishedStoneRecipe(exporter, MAGMA_BRICKS.block(), Blocks.MAGMA_BLOCK);
        offerBsswCuttingRecipe(exporter, SMALL_MAGMA_BRICKS, Blocks.MAGMA_BLOCK, MAGMA_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_MAGMA_BRICKS, Blocks.MAGMA_BLOCK, MAGMA_BRICKS.block());

        // Blaze Bricks
        offerBsswCuttingRecipe(exporter, BLAZE_BRICKS);
        offerStonecuttingRecipe(exporter, BLAZE_PILLAR, BLAZE_BRICKS.block());
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BLAZE_BRICKS.block()).define('#', Items.BLAZE_POWDER).define('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").unlockedBy("has_blaze_rod", has(Items.BLAZE_ROD)).save(exporter);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.BLAZE_POWDER, RecipeCategory.BUILDING_BLOCKS, BLAZE_LANTERN);

        // Netherrack
        offerBsswCuttingRecipe(exporter, POLISHED_NETHERRACK, Blocks.NETHERRACK);
        offerPolishedStoneRecipe(exporter, POLISHED_NETHERRACK.block(), Blocks.NETHERRACK);
        offerBsswCuttingRecipe(exporter, NETHERRACK_BRICKS, Blocks.NETHERRACK, POLISHED_NETHERRACK.block());
        offerStonecuttingRecipe(exporter, NETHERRACK_CIRCULAR_PAVING, Blocks.NETHERRACK, POLISHED_NETHERRACK.block(), NETHERRACK_BRICKS.block());
        offerPressurePlateButtonRecipe(exporter, POLISHED_NETHERRACK_PRESSURE_PLATE, POLISHED_NETHERRACK_BUTTON, POLISHED_NETHERRACK.block());

        // Nether Bricks
        offerBsswCuttingRecipe(exporter, POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, POLISHED_NETHER_BRICKS.block(), Blocks.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, NETHER_BRICK_PILLAR, Blocks.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_NETHER_BRICKS, Blocks.NETHER_BRICKS);

        offerBsswCuttingRecipe(exporter, POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, POLISHED_RED_NETHER_BRICKS.block(), Blocks.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, RED_NETHER_BRICK_PILLAR, Blocks.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);

        offerBsswCuttingRecipe(exporter, NETHER_TILES);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, NETHER_TILES.block(), 4).define('#', Blocks.NETHERRACK).define('X', Blocks.NETHER_BRICKS).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.NETHER_BRICKS), has(Blocks.NETHER_BRICKS)).save(exporter);

        // Charred Nether Bricks
        offerBsswCuttingRecipe(exporter, CHARRED_NETHER_BRICKS);
        offerBsswCuttingRecipe(exporter, POLISHED_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block());
        offerPolishedStoneRecipe(exporter, POLISHED_CHARRED_NETHER_BRICKS.block(), CHARRED_NETHER_BRICKS.block());
        offerStonecuttingRecipe(exporter, HERRINGBONE_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHARRED_NETHER_BRICK_PILLAR, CHARRED_NETHER_BRICKS.block());
        createEnclosedRecipe(CHARRED_NETHER_BRICKS.block(), Ingredient.of(Blocks.NETHER_BRICKS), Items.FIRE_CHARGE).unlockedBy(getHasName(Items.FIRE_CHARGE), has(Items.FIRE_CHARGE)).unlockedBy(getHasName(Blocks.NETHER_BRICKS), has(Blocks.NETHER_BRICKS)).save(exporter);

        // Teal Nether Bricks
        offerBsswCuttingRecipe(exporter, TEAL_NETHER_BRICKS);
        offerBsswCuttingRecipe(exporter, POLISHED_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block());
        offerPolishedStoneRecipe(exporter, POLISHED_TEAL_NETHER_BRICKS.block(), TEAL_NETHER_BRICKS.block());
        offerStonecuttingRecipe(exporter, HERRINGBONE_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block());
        offerStonecuttingRecipe(exporter, TEAL_NETHER_BRICK_PILLAR, TEAL_NETHER_BRICKS.block());
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block()).define('#', BlockusItemTags.WARPED_NETHER_GRASS).define('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").group("teal_nether_bricks").unlockedBy("has_warped_grass", has(BlockusItemTags.WARPED_NETHER_GRASS)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block(), 2).requires(Blocks.WARPED_WART_BLOCK).requires(Items.NETHER_BRICKS).group("teal_nether_bricks").unlockedBy(getHasName(Blocks.WARPED_WART_BLOCK), has(Blocks.WARPED_WART_BLOCK)).save(exporter, getConversionRecipeName(TEAL_NETHER_BRICKS.block(), Blocks.WARPED_WART_BLOCK));

        // Obsidian
        offerBsswCuttingRecipe(exporter, OBSIDIAN_BRICKS, Blocks.OBSIDIAN);
        offerPolishedStoneRecipe(exporter, OBSIDIAN_BRICKS.block(), Blocks.OBSIDIAN);
        smeltingResultFromBase(exporter, CRACKED_OBSIDIAN_BRICKS, OBSIDIAN_BRICKS.block());
        offerBsswCuttingRecipe(exporter, SMALL_OBSIDIAN_BRICKS, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block());
        offerStonecuttingRecipe(exporter, OBSIDIAN_PILLAR, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block());
        offerStonecuttingRecipe(exporter, OBSIDIAN_CIRCULAR_PAVING, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block());
        offerDoorTrapdoorRecipe(exporter, OBSIDIAN_REINFORCED_DOOR, OBSIDIAN_REINFORCED_TRAPDOOR, Blocks.OBSIDIAN);
        pressurePlate(exporter, OBSIDIAN_PRESSURE_PLATE, Blocks.OBSIDIAN);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GLOWING_OBSIDIAN, 4).define('S', Blocks.OBSIDIAN).define('#', Blocks.SHROOMLIGHT).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Blocks.SHROOMLIGHT), has(Blocks.SHROOMLIGHT)).save(exporter);

        // Ore Bricks
        offerOreBricksRecipe(exporter, IRON_BRICKS, Blocks.IRON_BLOCK, Items.IRON_INGOT);
        offerOreBricksRecipe(exporter, GOLD_BRICKS, Blocks.GOLD_BLOCK, Items.GOLD_INGOT);
        offerOreBricksRecipe(exporter, LAPIS_BRICKS, Blocks.LAPIS_BLOCK, Items.LAPIS_LAZULI);
        offerOreBricksRecipe(exporter, REDSTONE_BRICKS, Blocks.REDSTONE_BLOCK, Items.REDSTONE);
        offerOreBricksRecipe(exporter, EMERALD_BRICKS, Blocks.EMERALD_BLOCK, Items.EMERALD);
        offerOreBricksRecipe(exporter, DIAMOND_BRICKS, Blocks.DIAMOND_BLOCK, Items.DIAMOND);
        offerOreBricksRecipe(exporter, NETHERITE_BRICKS, Blocks.NETHERITE_BLOCK, Items.NETHERITE_INGOT);

        // Copper
        offerCopperBricksRecipe(exporter, COPPER_BRICKS, Blocks.WAXED_COPPER_BLOCK, Blocks.CUT_COPPER, Blocks.WAXED_CUT_COPPER);
        offerCopperBricksRecipe(exporter, EXPOSED_COPPER_BRICKS, Blocks.WAXED_EXPOSED_COPPER, Blocks.EXPOSED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER);
        offerCopperBricksRecipe(exporter, WEATHERED_COPPER_BRICKS, Blocks.WAXED_WEATHERED_COPPER, Blocks.WEATHERED_CUT_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER);
        offerCopperBricksRecipe(exporter, OXIDIZED_COPPER_BRICKS, Blocks.WAXED_OXIDIZED_COPPER, Blocks.OXIDIZED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER);

        for (CopperBundle copperBundle : CopperBundle.values()) {
            offerWaxingRecipes(exporter, copperBundle.block(), copperBundle.blockWaxed());
            offerWaxingRecipes(exporter, copperBundle.slab(), copperBundle.slabWaxed());
            offerWaxingRecipes(exporter, copperBundle.stairs(), copperBundle.stairsWaxed());
            offerWaxingRecipes(exporter, copperBundle.wall(), copperBundle.wallWaxed());
            if (copperBundle.type().contains("copper_tuff_bricks")) {
                offerStonecuttingRecipe(exporter, copperBundle.stairs(), copperBundle.block());
                offerStonecuttingRecipe(exporter, copperBundle.slab(), 2, copperBundle.block());
                offerStonecuttingRecipe(exporter, copperBundle.wall(), copperBundle.block());
                offerStonecuttingRecipe(exporter, copperBundle.stairsWaxed(), copperBundle.blockWaxed());
                offerStonecuttingRecipe(exporter, copperBundle.slabWaxed(), 2, copperBundle.blockWaxed());
                offerStonecuttingRecipe(exporter, copperBundle.wallWaxed(), copperBundle.blockWaxed());
            }
        }
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, COPPER_TUFF_BRICKS.block(), 2).define('#', Items.COPPER_INGOT).define('X', Blocks.TUFF_BRICKS).pattern("#X").pattern("X#").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).unlockedBy(getHasName(Blocks.TUFF_BRICKS), has(Blocks.TUFF_BRICKS)).save(exporter);

        // Quartz Blocks
        offerBsswCuttingRecipe(exporter, QUARTZ_TILES, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);
        offerPolishedStoneRecipe(exporter, QUARTZ_TILES.block(), Blocks.QUARTZ_BRICKS);
        offerStonecuttingRecipe(exporter, QUARTZ_CIRCULAR_PAVING, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);

        // Prismarine
        offerStonecuttingRecipe(exporter, CHISELED_PRISMARINE, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, PRISMARINE_CIRCULAR_PAVING, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_DARK_PRISMARINE, Blocks.DARK_PRISMARINE);
        offerStonecuttingRecipe(exporter, DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE);
        offerBsswCuttingRecipe(exporter, PRISMARINE_TILES);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILES.block(), 4).define('#', Blocks.DARK_PRISMARINE).define('X', Items.PRISMARINE_SHARD).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.DARK_PRISMARINE), has(Blocks.DARK_PRISMARINE)).save(exporter);

        // Bricks
        offerBsswCuttingRecipe(exporter, LARGE_BRICKS, Blocks.BRICKS);
        offerPolishedStoneRecipe(exporter, LARGE_BRICKS.block(), Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_BRICKS, Blocks.BRICKS);

        // Soaked Bricks
        offerBsswCuttingRecipe(exporter, SOAKED_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_SOAKED_BRICKS, SOAKED_BRICKS.block());
        createEnclosedRecipe(SOAKED_BRICKS.block(), Ingredient.of(Blocks.BRICKS), Items.WATER_BUCKET).unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET)).unlockedBy(getHasName(Blocks.BRICKS), has(Blocks.BRICKS)).save(exporter);

        // Sandy Bricks
        offerBsswCuttingRecipe(exporter, SANDY_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_SANDY_BRICKS, SANDY_BRICKS.block());
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SANDY_BRICKS.block(), 2).define('S', Blocks.SAND).define('#', Blocks.BRICKS).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy("has_sand", has(Blocks.SAND)).unlockedBy("has_bricks", has(Blocks.BRICKS)).save(exporter);

        // Charred Bricks
        offerBsswCuttingRecipe(exporter, CHARRED_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_CHARRED_BRICKS, CHARRED_BRICKS.block());
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, CHARRED_BRICKS.block().asItem(), 0.1F, 200).unlockedBy("has_bricks", has(Blocks.BRICKS)).save(exporter);

        // Sandstone
        offerBsswCuttingRecipe(exporter, ROUGH_SANDSTONE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_SANDSTONE.block(), 2).define('#', Blocks.SANDSTONE_SLAB).pattern("##").pattern("##").unlockedBy("has_sandstone", has(Blocks.SANDSTONE)).save(exporter);
        offerBsswCuttingRecipe(exporter, SANDSTONE_BRICKS, Blocks.SANDSTONE);
        offerBsswCuttingRecipe(exporter, SMALL_SANDSTONE_BRICKS, Blocks.SANDSTONE, SANDSTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, SANDSTONE_PILLAR, Blocks.SANDSTONE, SANDSTONE_BRICKS.block());
        offerDecoratedRecipe(exporter, GOLD_DECORATED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_SANDSTONE);
        offerDecoratedRecipe(exporter, LAPIS_DECORATED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_SANDSTONE);

        // Red Sandstone
        offerBsswCuttingRecipe(exporter, ROUGH_RED_SANDSTONE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_RED_SANDSTONE.block(), 2).define('#', Blocks.RED_SANDSTONE_SLAB).pattern("##").pattern("##").unlockedBy("has_red_sandstone", has(Blocks.RED_SANDSTONE)).save(exporter);
        offerBsswCuttingRecipe(exporter, RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE);
        offerBsswCuttingRecipe(exporter, SMALL_RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block());
        offerDecoratedRecipe(exporter, GOLD_DECORATED_RED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_RED_SANDSTONE);
        offerDecoratedRecipe(exporter, LAPIS_DECORATED_RED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_RED_SANDSTONE);

        // Soul Sandstone
        offerBsswCuttingRecipe(exporter, SOUL_SANDSTONE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SOUL_SANDSTONE.block()).define('#', BlockusItemTags.SOUL_SOILS).pattern("##").pattern("##").unlockedBy("has_soul_sand", has(BlockusItemTags.SOUL_SOILS)).save(exporter);
        offerBsswCuttingRecipe(exporter, SMOOTH_SOUL_SANDSTONE);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(SOUL_SANDSTONE.block()), RecipeCategory.BUILDING_BLOCKS, SMOOTH_SOUL_SANDSTONE.block().asItem(), 0.1F, 200).unlockedBy("has_soul_sandstone", has(SOUL_SANDSTONE.block())).save(exporter);
        offerPolishedStoneRecipe(exporter, CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
        offerStonecuttingRecipe(exporter, CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
        offerStonecuttingRecipe(exporter, CUT_SOUL_SANDSTONE_SLAB, 2, SOUL_SANDSTONE.block(), CUT_SOUL_SANDSTONE);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_SOUL_SANDSTONE_SLAB, CUT_SOUL_SANDSTONE);

        offerBsswCuttingRecipe(exporter, ROUGH_SOUL_SANDSTONE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_SOUL_SANDSTONE.block(), 2).define('#', SOUL_SANDSTONE.slab()).pattern("##").pattern("##").unlockedBy("has_soul_sandstone", has(SOUL_SANDSTONE.block())).save(exporter);
        offerBsswCuttingRecipe(exporter, SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block());
        offerBsswCuttingRecipe(exporter, SMALL_SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block(), SOUL_SANDSTONE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
        offerPolishedStoneRecipe(exporter, CHISELED_SOUL_SANDSTONE, CUT_SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, SOUL_SANDSTONE_PILLAR, SOUL_SANDSTONE.block(), SOUL_SANDSTONE_BRICKS.block());
        offerDecoratedRecipe(exporter, GOLD_DECORATED_SOUL_SANDSTONE, Items.GOLD_INGOT, CUT_SOUL_SANDSTONE);
        offerDecoratedRecipe(exporter, LAPIS_DECORATED_SOUL_SANDSTONE, Items.LAPIS_LAZULI, CUT_SOUL_SANDSTONE);

        // Honeycomb Bricks
        offerBsswCuttingRecipe(exporter, HONEYCOMB_BRICKS, Blocks.HONEYCOMB_BLOCK);
        offerPolishedStoneRecipe(exporter, HONEYCOMB_BRICKS.block(), Blocks.HONEYCOMB_BLOCK);

        // Purpur Blocks
        offerBsswCuttingRecipe(exporter, POLISHED_PURPUR, Blocks.PURPUR_BLOCK);
        offerPolishedStoneRecipe(exporter, POLISHED_PURPUR.block(), Blocks.PURPUR_BLOCK);
        offerBsswCuttingRecipe(exporter, PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block());
        offerBsswCuttingRecipe(exporter, SMALL_PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_PURPUR, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
        offerStonecuttingRecipe(exporter, Blocks.PURPUR_PILLAR, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
        offerStonecuttingRecipe(exporter, PURPUR_SQUARES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
        offerStonecuttingRecipe(exporter, PURPUR_LINES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());

        // Phantom Purpur Blocks
        offerBsswCuttingRecipe(exporter, PHANTOM_PURPUR_BLOCK);
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_BLOCK.block(), Blocks.PURPUR_BLOCK);
        offerPolishedStoneRecipe(exporter, POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BLOCK.block());
        offerBsswCuttingRecipe(exporter, POLISHED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.block());
        offerPhantomPurpurRecipe(exporter, POLISHED_PHANTOM_PURPUR.block(), POLISHED_PURPUR.block());
        offerBsswCuttingRecipe(exporter, PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block());
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_BRICKS.block(), PURPUR_BRICKS.block());
        offerPolishedStoneRecipe(exporter, PHANTOM_PURPUR_BRICKS.block(), POLISHED_PHANTOM_PURPUR.block());
        offerBsswCuttingRecipe(exporter, SMALL_PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
        offerPhantomPurpurRecipe(exporter, SMALL_PHANTOM_PURPUR_BRICKS.block(), PHANTOM_PURPUR_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHISELED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
        offerPhantomPurpurRecipe(exporter, CHISELED_PHANTOM_PURPUR, CHISELED_PURPUR);
        offerStonecuttingRecipe(exporter, PHANTOM_PURPUR_PILLAR, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_PILLAR, Blocks.PURPUR_PILLAR);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, PHANTOM_PURPUR_PILLAR).define('#', PHANTOM_PURPUR_BLOCK.slab()).pattern("#").pattern("#").unlockedBy("has_phantom_purpur_block", has(PHANTOM_PURPUR_BLOCK.block())).save(exporter);
        offerStonecuttingRecipe(exporter, PHANTOM_PURPUR_SQUARES, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_SQUARES, PURPUR_SQUARES);
        offerStonecuttingRecipe(exporter, PHANTOM_PURPUR_LINES, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_LINES, PURPUR_LINES);

        // End Stone
        offerBsswCuttingRecipe(exporter, POLISHED_END_STONE, Blocks.END_STONE);
        offerPolishedStoneRecipe(exporter, POLISHED_END_STONE.block(), Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICKS, POLISHED_END_STONE.block());
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_STAIRS, POLISHED_END_STONE.block());
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_SLAB, 2, POLISHED_END_STONE.block());
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_WALL, POLISHED_END_STONE.block());
        smeltingResultFromBase(exporter, CRACKED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);
        offerBsswCuttingRecipe(exporter, SMALL_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, END_STONE_PILLAR, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
        offerDecoratedRecipe(exporter, PURPUR_DECORATED_END_STONE, Items.POPPED_CHORUS_FRUIT, Blocks.END_STONE_BRICKS);
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_DECORATED_END_STONE, PURPUR_DECORATED_END_STONE);
        offerBsswCuttingRecipe(exporter, END_TILES);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, END_TILES.block(), 4).define('#', Blocks.END_STONE).define('X', Blocks.PURPUR_BLOCK).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.PURPUR_BLOCK), has(Blocks.PURPUR_BLOCK)).save(exporter);
        offerPressurePlateButtonRecipe(exporter, POLISHED_END_STONE_PRESSURE_PLATE, POLISHED_END_STONE_BUTTON, POLISHED_END_STONE.block());

        // Wood
        hangingSign(exporter, WHITE_OAK.hangingSign(), STRIPPED_WHITE_OAK_LOG);
        woodFromLogs(exporter, WHITE_OAK_WOOD, WHITE_OAK_LOG);
        planksFromLogs(exporter, WHITE_OAK.planks(), BlockusItemTags.WHITE_OAK_LOGS, 4);
        hangingSign(exporter, RAW_BAMBOO.hangingSign(), Blocks.BAMBOO_BLOCK);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CHARRED.hangingSign(), 2).group("hanging_sign").define('#', CHARRED.planks()).define('X', Items.CHAIN).pattern("X X").pattern("###").pattern("###").unlockedBy("has_charred_planks", has(CHARRED.planks())).save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RAW_BAMBOO.planks(), 2).requires(Blocks.BAMBOO_BLOCK).group("planks").unlockedBy("has_log", has(Blocks.BAMBOO_BLOCK)).save(exporter);
        offerBoatsRecipe(exporter, BlockusEntities.WHITE_OAK_BOAT.getItem(), BlockusEntities.WHITE_OAK_BOAT.getChestItem(), WHITE_OAK.planks());
        offerBoatsRecipe(exporter, BlockusEntities.RAW_BAMBOO_RAFT.getItem(), BlockusEntities.RAW_BAMBOO_RAFT.getChestItem(), RAW_BAMBOO.planks());
        offerBoatsRecipe(exporter, BlockusEntities.CHARRED_BOAT.getItem(), BlockusEntities.CHARRED_BOAT.getChestItem(), CHARRED.planks());
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockusItemTags.PLANKS_THAT_BURN), RecipeCategory.BUILDING_BLOCKS, CHARRED.planks(), 0.1F, 200).unlockedBy("has_planks", has(BlockusItemTags.PLANKS_THAT_BURN)).save(exporter);

        for (var entry : SMALL_LOGS.bundle().entrySet()) {
            offerSmallLogsRecipe(exporter, entry.getValue(), WoodMaps.LOG_MAP.get(entry.getKey()));
        }

        for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
            for (var entry : woodenPost.woodMap().entrySet()) {
                Block log = WoodMaps.LOG_MAP.get(entry.getKey().getId());
                Block strippedLog = WoodMaps.STRIPPED_LOG_MAP.get(entry.getKey().getId());
                if (log == null || strippedLog == null) {
                    continue;
                }
                offerWoodenPostRecipe(exporter, entry.getValue(), log, strippedLog, WoodMaps.PLANKS_MAP.get(entry.getKey().getId()));
            }
        }

        for (var entry : MOSSY_PLANKS.bundle().entrySet()) {
            offerMossyRecipe(exporter, entry.getValue().block(), entry.getValue().base());
        }

        for (var entry : WOODEN_MOSAIC.bundle().entrySet()) {
            mosaicBuilder(exporter, RecipeCategory.DECORATIONS, entry.getValue().block(), WoodMaps.SLAB_MAP.get(entry.getKey()));
        }
        offerCharredSmeltingRecipe(exporter, BlockusItemTags.WOODEN_MOSAIC_THAT_BURN, WOODEN_MOSAIC.get(WoodMaps.CHARRED.getId()).block(), "mosaic");


        for (var entry : HERRINGBONE_PLANKS.bundle().entrySet()) {
            offerHerringBoneRecipe(exporter, entry.getValue(), WoodMaps.PLANKS_MAP.get(entry.getKey()));
        }
        offerCharredSmeltingRecipe(exporter, BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN, HERRINGBONE_PLANKS.get(WoodMaps.CHARRED.getId()), "herringbone_planks");

        for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
            for (var entry : timberFrameBundle.woodMap().entrySet()) {
                var variants = entry.getValue();
                Block planks = WoodMaps.PLANKS_MAP.get(entry.getKey().getId());
                createTimberFramesRecipes(exporter, planks, variants.block(), variants.diagonal(), variants.cross());
                createLatticeRecipes(exporter, WoodMaps.PLANKS_MAP.get(entry.getKey().getId()), variants.lattice(), variants.grate());
            }
        }

        // Small Hedges
        offerSmallHedgesRecipe(exporter, OAK_HEDGE, Blocks.OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, SPRUCE_HEDGE, Blocks.SPRUCE_LEAVES);
        offerSmallHedgesRecipe(exporter, BIRCH_HEDGE, Blocks.BIRCH_LEAVES);
        offerSmallHedgesRecipe(exporter, JUNGLE_HEDGE, Blocks.JUNGLE_LEAVES);
        offerSmallHedgesRecipe(exporter, ACACIA_HEDGE, Blocks.ACACIA_LEAVES);
        offerSmallHedgesRecipe(exporter, DARK_OAK_HEDGE, Blocks.DARK_OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, MANGROVE_HEDGE, Blocks.MANGROVE_LEAVES);
        offerSmallHedgesRecipe(exporter, CHERRY_HEDGE, Blocks.CHERRY_LEAVES);
        offerSmallHedgesRecipe(exporter, WARPED_HEDGE, Blocks.WARPED_WART_BLOCK);
        offerSmallHedgesRecipe(exporter, CRIMSON_HEDGE, Blocks.NETHER_WART_BLOCK);
        offerSmallHedgesRecipe(exporter, WHITE_OAK_HEDGE, WHITE_OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, AZALEA_HEDGE, Blocks.AZALEA_LEAVES);
        offerSmallHedgesRecipe(exporter, FLOWERING_AZALEA_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES);
        offerSmallHedgesRecipe(exporter, MOSS_HEDGE, Blocks.MOSS_BLOCK);

        // Large Flower Pots
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LARGE_FLOWER_POT).define('#', Items.BRICK).pattern("# #").pattern("###").pattern("###").unlockedBy("has_flower_pot", has(Items.FLOWER_POT)).save(exporter);

        // Chocolate
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CHOCOLATE_BLOCK.block(), 2).define('#', Items.COCOA_BEANS).pattern("##").pattern("##").unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS)).save(exporter);
        offerBsswCuttingRecipe(exporter, CHOCOLATE_BLOCK);
        offerBsswCuttingRecipe(exporter, CHOCOLATE_BRICKS, CHOCOLATE_BLOCK.block());
        offerPolishedStoneRecipe(exporter, CHOCOLATE_BRICKS.block(), CHOCOLATE_BLOCK.block());
        offerPolishedStoneRecipe(exporter, CHOCOLATE_SQUARES, CHOCOLATE_BRICKS.block());
        offerStonecuttingRecipe(exporter, CHOCOLATE_SQUARES, CHOCOLATE_BLOCK.block(), CHOCOLATE_BRICKS.block());
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CHOCOLATE_TABLET, 3).define('#', CHOCOLATE_SQUARES).pattern("##").unlockedBy(getHasName(CHOCOLATE_SQUARES), has(CHOCOLATE_SQUARES)).save(exporter);
        offerStonecuttingRecipe(exporter, CHOCOLATE_TABLET, 2, CHOCOLATE_BLOCK.block(), CHOCOLATE_BRICKS.block(), CHOCOLATE_SQUARES);

        // Food Blocks
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.SWEET_BERRIES, RecipeCategory.BUILDING_BLOCKS, SWEET_BERRIES_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.GLOW_BERRIES, RecipeCategory.BUILDING_BLOCKS, GLOW_BERRIES_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.SALMON, RecipeCategory.BUILDING_BLOCKS, SALMON_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.PUFFERFISH, RecipeCategory.BUILDING_BLOCKS, PUFFERFISH_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.TROPICAL_FISH, RecipeCategory.BUILDING_BLOCKS, TROPICAL_FISH_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.COD, RecipeCategory.BUILDING_BLOCKS, COD_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.COOKIE, RecipeCategory.FOOD, COOKIE_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.CHORUS_FRUIT, RecipeCategory.BUILDING_BLOCKS, CHORUS_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.POTATO, RecipeCategory.BUILDING_BLOCKS, POTATO_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.APPLE, RecipeCategory.BUILDING_BLOCKS, APPLE_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.GOLDEN_APPLE, RecipeCategory.BUILDING_BLOCKS, GOLDEN_APPLE_CRATE);
        createEnclosedRecipe2(GOLDEN_APPLE_CRATE, Ingredient.of(Blocks.GOLD_BLOCK), APPLE_CRATE).unlockedBy(getHasName(Items.GOLDEN_APPLE), has(Items.GOLDEN_APPLE)).save(exporter, getConversionRecipeName(GOLDEN_APPLE_CRATE, APPLE_CRATE));
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.BEETROOT, RecipeCategory.BUILDING_BLOCKS, BEETROOT_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.CARROT, RecipeCategory.BUILDING_BLOCKS, CARROT_CRATE);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.GOLDEN_CARROT, RecipeCategory.BUILDING_BLOCKS, GOLDEN_CARROT_CRATE);
        createEnclosedRecipe2(GOLDEN_CARROT_CRATE, Ingredient.of(Items.GOLD_INGOT), CARROT_CRATE).unlockedBy(getHasName(Items.GOLDEN_CARROT), has(Items.GOLDEN_CARROT)).save(exporter, getConversionRecipeName(GOLDEN_CARROT_CRATE, CARROT_CRATE));
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.BREAD, RecipeCategory.BUILDING_BLOCKS, BREAD_BOX);

        // Rainbow
        oneToOneConversionRecipe(exporter, RAINBOW_PETALS, RAINBOW_ROSE, "rainbow_petal", 2);
        oneToOneConversionRecipe(exporter, RAINBOW_PETALS, RAINBOW_BLOCK, "rainbow_petal", 4);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_BLOCK).define('#', RAINBOW_PETALS).pattern("##").pattern("##").unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter);
        offerBsswCuttingRecipe(exporter, RAINBOW_BRICKS, RAINBOW_BLOCK);
        offerPolishedStoneRecipe(exporter, RAINBOW_BRICKS.block(), RAINBOW_BLOCK);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE).requires(RAINBOW_PETALS).requires(Blocks.GLOWSTONE).group("rainbow_glowstone").unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE, 1).define('G', Items.GLOWSTONE_DUST).group("rainbow_glowstone").define('R', RAINBOW_PETALS).pattern(" G ").pattern("GRG").pattern(" G ").unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter, getSimpleRecipeName(RAINBOW_GLOWSTONE) + "_alt");

        // Colored Stone Bricks
        for (DyeColor color : BlockOrder.COLOR) {
            BSSWBundle bundle = STAINED_STONE_BRICKS.colorMap().get(color);
            offerStainedStoneBricksRecipe(exporter, DYE_MAP.get(color), bundle.block(), bundle.stairs(), bundle.slab(), bundle.wall());
        }

        // Redstone Lamps
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, REDSTONE_LAMP_LIT).requires(Blocks.REDSTONE_LAMP).requires(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").unlockedBy(getHasName(Blocks.REDSTONE_LAMP), has(Blocks.REDSTONE_LAMP)).save(exporter);
        for (DyeColor color : BlockOrder.COLOR) {
            offerStainedRedstoneLampRecipe(exporter, STAINED_REDSTONE_LAMP.colorMap().get(color), DYE_MAP.get(color), STAINED_REDSTONE_LAMP_LIT.colorMap().get(color));
        }
        offerStainedRedstoneLampRecipe(exporter, RAINBOW_LAMP, RAINBOW_PETALS, RAINBOW_LAMP_LIT);

        // Neon Blocks
        for (DyeColor color : BlockOrder.COLOR) {
            Block block = NEON_BLOCK.colorMap().get(color);
            offerNeonRecipe(exporter, block, DYE_MAP.get(color));
        }
        offerNeonRecipe(exporter, RAINBOW_NEON, RAINBOW_PETALS);

        // Futurneo Blocks
        for (DyeColor color : BlockOrder.COLOR) {
            Block block = FUTURNEO_BLOCK.colorMap().get(color);
            offerFuturneoRecipe(exporter, block, BlockMaps.STAINED_GLASS_MAP.get(color));
        }
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GRAY_BRIGHT_FUTURNEO_BLOCK).define('A', Items.WHITE_DYE).define('B', Blocks.GRAY_STAINED_GLASS).define('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").unlockedBy(getHasName(Blocks.GRAY_STAINED_GLASS), has(Blocks.GRAY_STAINED_GLASS)).save(exporter);
        offerFuturneoRecipe(exporter, RAINBOW_FUTURNEO_BLOCK, RAINBOW_GLASS);

        // Asphalt
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ASPHALT.baseColor().block(), 8).define('X', Blocks.GRAVEL).define('#', ItemTags.COALS).pattern("XXX").pattern("X#X").pattern("XXX").group("asphalt").unlockedBy(getHasName(Blocks.GRAVEL), has(Blocks.GRAVEL)).save(exporter);
        createEnclosedRecipe(RAINBOW_ASPHALT, Ingredient.of(ASPHALT.baseColor().block()), RAINBOW_PETALS).unlockedBy(getHasName(ASPHALT.baseColor().block()), has(ASPHALT.baseColor().block())).save(exporter);

        for (DyeColor color : BlockOrder.COLOR) {
            if (color == DyeColor.BLACK) continue;
            AsphaltBundle.AsphaltVariants bundle = ASPHALT.colorMap().get(color);
            offerAsphaltRecipe(exporter, DYE_MAP.get(color), bundle.block(), bundle.stairs(), bundle.slab());
        }

        // Shingles
        offerBsswCuttingRecipe(exporter, SHINGLES, Blocks.TERRACOTTA);
        offerPolishedStoneRecipe(exporter, SHINGLES.block(), Blocks.TERRACOTTA);

        for (DyeColor color : BlockOrder.COLOR) {
            BSSWBundle bundle = STAINED_SHINGLES.colorMap().get(color);
            offerShinglesRecipe(exporter, DYE_MAP.get(color), bundle.block(), bundle.stairs(), bundle.slab(), BlockMaps.TERRACOTTA_MAP.get(color));
        }

        // Glass - Beveled Glass
        offerPolishedStoneRecipe(exporter, TINTED_BEVELED_GLASS, Blocks.TINTED_GLASS);
        offerPolishedStoneRecipe(exporter, BEVELED_GLASS, Blocks.GLASS);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BEVELED_GLASS_PANE, 16).define('#', BEVELED_GLASS).pattern("###").pattern("###").group("beveled_glass_pane").unlockedBy("has_beveled_glass", has(BEVELED_GLASS_PANE)).save(exporter);
        for (DyeColor color : BlockOrder.COLOR) {
            offerStainedBeveledGlassRecipe(exporter, STAINED_BEVELED_GLASS.colorMap().get(color), STAINED_BEVELED_GLASS_PANE.colorMap().get(color), BlockMaps.STAINED_GLASS_MAP.get(color), DYE_MAP.get(color));
        }
        offerStainedBeveledGlassRecipe(exporter, RAINBOW_BEVELED_GLASS, RAINBOW_BEVELED_GLASS_PANE, RAINBOW_GLASS, RAINBOW_PETALS);
        createEnclosedRecipe(RAINBOW_GLASS, Ingredient.of(Blocks.GLASS), RAINBOW_PETALS).unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter);
        createEnclosedRecipe(RAINBOW_GLASS_PANE, Ingredient.of(Blocks.GLASS_PANE), RAINBOW_PETALS).unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter, getSimpleRecipeName(RAINBOW_GLASS_PANE) + "_alt");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLASS_PANE, 16).define('#', RAINBOW_GLASS).pattern("###").pattern("###").unlockedBy(getHasName(RAINBOW_GLASS), has(RAINBOW_GLASS)).save(exporter);

        // Colored Tiles
        for (DyeColor color : BlockOrder.COLOR) {
            offerUnicolorColoredTilesRecipe(exporter, COLORED_TILES.colorMap().get(color), BlockMaps.CONCRETE_MAP.get(color));
        }
        offerUnicolorColoredTilesRecipe(exporter, RAINBOW_COLORED_TILES, RAINBOW_BLOCK);

        // Glazed Terracotta Pillars
        for (DyeColor color : BlockOrder.COLOR) {
            offerPillarRecipe(exporter, GLAZED_TERRACOTTA_PILLAR.colorMap().get(color), BlockMaps.GLAZED_TERRACOTTA_MAP.get(color));
        }

        // Thatch
        offerPolishedStoneRecipe(exporter, THATCH.block(), Items.WHEAT);

        // Paper
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, PAPER_BLOCK);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(PAPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, BURNT_PAPER_BLOCK.asItem(), 0.1F, 200).unlockedBy("has_paper_block", has(PAPER_BLOCK)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FRAMED_PAPER_BLOCK, 4).define('X', Items.PAPER).define('#', Items.STICK).pattern("###").pattern("XXX").pattern("###").unlockedBy(getHasName(Items.PAPER), has(Items.PAPER)).save(exporter);
        offerPolishedStoneRecipe(exporter, PAPER_WALL, FRAMED_PAPER_BLOCK);
        createEnclosedRecipe2(PAPER_LAMP, Ingredient.of(Items.PAPER), Items.TORCH).unlockedBy(getHasName(Items.PAPER), has(Items.PAPER)).save(exporter);
        offerShapelessRecipe2(exporter, Items.GUNPOWDER, BURNT_PAPER_BLOCK, 2);
        offerDoorTrapdoorRecipe(exporter, PAPER_DOOR, PAPER_TRAPDOOR, PAPER_WALL);

        // Plating
        offerBsswCuttingRecipe(exporter, IRON_PLATING);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, IRON_PLATING.block(), 24).define('X', Items.IRON_INGOT).pattern("XXX").pattern("X X").pattern("XXX").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(exporter);
        offerBsswCuttingRecipe(exporter, GOLD_PLATING);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GOLD_PLATING.block(), 24).define('X', Items.GOLD_INGOT).pattern("XXX").pattern("X X").pattern("XXX").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(exporter);

        // Gates - chains - bars
        offerDoorRecipe(exporter, IRON_GATE, Blocks.IRON_BARS);
        offerDoorRecipe(exporter, GOLDEN_GATE, GOLDEN_BARS);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GOLDEN_BARS, 16).define('#', Items.GOLD_INGOT).pattern("###").pattern("###").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GOLDEN_CHAIN).define('X', Items.GOLD_INGOT).define('#', Items.GOLD_NUGGET).pattern("#").pattern("X").pattern("#").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(exporter);

        // Lantern Blocks

        offerLanternBlockRecipe(exporter, LANTERN_BLOCK, Blocks.LANTERN);
        offerLanternBlockRecipe(exporter, SOUL_LANTERN_BLOCK, Blocks.SOUL_LANTERN);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AMETHYST_LANTERN).define('#', Items.TORCH).define('A', Items.AMETHYST_SHARD).define('X', Items.IRON_NUGGET).pattern("XXX").pattern("XAX").pattern("X#X").unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(exporter);
        offerLanternBlockRecipe(exporter, AMETHYST_LANTERN_BLOCK, AMETHYST_LANTERN);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, REDSTONE_LANTERN).define('#', Items.REDSTONE_TORCH).define('X', Items.IRON_NUGGET).pattern("XXX").pattern("X#X").pattern("XXX").unlockedBy(getHasName(Items.REDSTONE_TORCH), has(Items.REDSTONE_TORCH)).save(exporter);
        offerLanternBlockRecipe(exporter, REDSTONE_LANTERN_BLOCK, REDSTONE_LANTERN);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SOUL_O_LANTERN).define('X', Blocks.CARVED_PUMPKIN).define('#', Blocks.SOUL_TORCH).pattern("X").pattern("#").unlockedBy(getHasName(Blocks.CARVED_PUMPKIN), has(Blocks.CARVED_PUMPKIN)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, REDSTONE_O_LANTERN).define('X', Blocks.CARVED_PUMPKIN).define('#', Blocks.REDSTONE_TORCH).pattern("X").pattern("#").unlockedBy(getHasName(Blocks.CARVED_PUMPKIN), has(Blocks.CARVED_PUMPKIN)).unlockedBy(getHasName(Blocks.REDSTONE_TORCH), has(Blocks.REDSTONE_TORCH)).save(exporter);

        // Barriers
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ROAD_BARRIER, 5).define('#', Items.IRON_INGOT).define('X', Blocks.STONE).pattern("X#X").pattern("X#X").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, CAUTION_BARRIER).requires(CAUTION_BLOCK).requires(ROAD_BARRIER).unlockedBy(getHasName(CAUTION_BLOCK), has(CAUTION_BLOCK)).unlockedBy(getHasName(ROAD_BARRIER), has(ROAD_BARRIER)).save(exporter);

        // Netherite Blocks
        offerStairsRecipe(exporter, NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, NETHERITE_SLAB, Blocks.NETHERITE_BLOCK);
        offerStonecuttingRecipe(exporter, NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
        offerStonecuttingRecipe(exporter, NETHERITE_SLAB, 2, Blocks.NETHERITE_BLOCK);

        // Other
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, CHARCOAL_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, SUGAR_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, ENDER_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, ROTTEN_FLESH_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.BUILDING_BLOCKS, MEMBRANE_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.NETHER_STAR, RecipeCategory.BUILDING_BLOCKS, NETHER_STAR_BLOCK);
        offerPolishedStoneRecipe(exporter, WOODEN_FRAME, Items.STICK);
        createEnclosedRecipe2(REDSTONE_SAND, Ingredient.of(Items.REDSTONE), Items.SAND).unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.REDSTONE, 8).requires(REDSTONE_SAND).unlockedBy(getHasName(REDSTONE_SAND), has(REDSTONE_SAND)).save(exporter, getConversionRecipeName(Items.REDSTONE, REDSTONE_SAND));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LOVE_BLOCK).define('M', Items.MAGENTA_DYE).define('R', Items.RED_DYE).pattern("RMR").pattern("RRR").pattern("MRM").unlockedBy(getHasName(Items.MAGENTA_DYE), has(Items.MAGENTA_DYE)).unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WEIGHT_STORAGE_CUBE).requires(Blocks.STONE).requires(Items.IRON_NUGGET).unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, COMPANION_CUBE).requires(WEIGHT_STORAGE_CUBE).requires(Items.POPPY).unlockedBy(getHasName(WEIGHT_STORAGE_CUBE), has(WEIGHT_STORAGE_CUBE)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CAUTION_BLOCK, 6).define('A', Blocks.STONE).define('B', Items.BLACK_DYE).define('C', Items.YELLOW_DYE).pattern(" C ").pattern("BAB").pattern(" C ").unlockedBy(getHasName(Items.BLACK_DYE), has(Items.BLACK_DYE)).unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, STARS_BLOCK, 3).define('#', Items.ENDER_PEARL).define('X', Items.CHORUS_FRUIT).pattern("X#X").pattern("###").pattern("X#X").unlockedBy(getHasName(Items.CHORUS_FRUIT), has(Items.CHORUS_FRUIT)).save(exporter);

        // Legacy
        offerStonecuttingRecipe(exporter, LEGACY_BRICKS, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, LEGACY_FIRST_COBBLESTONE, Blocks.COBBLESTONE);
        offerStonecuttingRecipe(exporter, LEGACY_COBBLESTONE, Blocks.COBBLESTONE);
        offerStonecuttingRecipe(exporter, LEGACY_MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE);
        offerStonecuttingRecipe(exporter, LEGACY_GRAVEL, Blocks.GRAVEL);
        offerStonecuttingRecipe(exporter, LEGACY_IRON_BLOCK, Blocks.IRON_BLOCK);
        offerStonecuttingRecipe(exporter, LEGACY_GOLD_BLOCK, Blocks.GOLD_BLOCK);
        offerStonecuttingRecipe(exporter, LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, Blocks.GOLD_BLOCK);
        offerStonecuttingRecipe(exporter, LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, LEGACY_GOLD_BLOCK);
        offerStonecuttingRecipe(exporter, LEGACY_COAL_BLOCK, Blocks.COAL_BLOCK);
        offerStonecuttingRecipe(exporter, LEGACY_DIAMOND_BLOCK, Blocks.DIAMOND_BLOCK);
        offerStonecuttingRecipe(exporter, LEGACY_LAPIS_BLOCK, Blocks.LAPIS_BLOCK);
        offerStonecuttingRecipe(exporter, LEGACY_SPONGE, Blocks.SPONGE);
        offerStonecuttingRecipe(exporter, LEGACY_CRYING_OBSIDIAN, Blocks.CRYING_OBSIDIAN);
        offerStonecuttingRecipe(exporter, LEGACY_GLOWSTONE, Blocks.GLOWSTONE);
        offerStonecuttingRecipe(exporter, LEGACY_GLOWING_OBSIDIAN, GLOWING_OBSIDIAN);
        oneToOneConversionRecipe(exporter, Items.IRON_INGOT, LEGACY_IRON_BLOCK, "iron_ingot", 9);
        oneToOneConversionRecipe(exporter, Items.GOLD_INGOT, LEGACY_GOLD_BLOCK, "gold_ingot", 9);
        oneToOneConversionRecipe(exporter, Items.GOLD_INGOT, LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, "gold_ingot", 9);
        oneToOneConversionRecipe(exporter, Items.COAL, LEGACY_COAL_BLOCK, "coal", 9);
        oneToOneConversionRecipe(exporter, Items.DIAMOND, LEGACY_DIAMOND_BLOCK, "diamond", 9);
        oneToOneConversionRecipe(exporter, Items.LAPIS_LAZULI, LEGACY_LAPIS_BLOCK, "lapis_lazuli", 9);
        oneToOneConversionRecipe(exporter, Items.RED_DYE, LEGACY_ROSE, "red_dye", 2);
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, LEGACY_BLUE_ROSE, "light_blue_dye", 2);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_STONECUTTER).define('#', Blocks.COBBLESTONE).define('S', Blocks.STONECUTTER).pattern(" # ").pattern("#S#").pattern(" # ").unlockedBy(getHasName(Blocks.STONECUTTER), has(Blocks.STONECUTTER)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_NETHER_REACTOR_CORE).define('#', Items.DIAMOND).define('X', Items.IRON_INGOT).pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_SAPLING, 4).define('#', Blocks.OAK_SAPLING).pattern("##").pattern("##").unlockedBy(getHasName(Blocks.OAK_SAPLING), has(Blocks.OAK_SAPLING)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_ROSE, 2).define('#', Blocks.POPPY).pattern("##").pattern("##").unlockedBy(getHasName(Blocks.POPPY), has(Blocks.POPPY)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_BLUE_ROSE, 2).define('#', LEGACY_ROSE).pattern("##").unlockedBy(getHasName(LEGACY_ROSE), has(LEGACY_ROSE)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_FIRST_GRASS_BLOCK, 4).define('#', LEGACY_GRASS_BLOCK).pattern("##").pattern("##").unlockedBy(getHasName(LEGACY_GRASS_BLOCK), has(LEGACY_GRASS_BLOCK)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, LEGACY_PLANKS, 4).requires(LEGACY_LOG).group("planks").unlockedBy("has_logs", has(LEGACY_LOG)).save(exporter);
    }

    private void offerLanternBlockRecipe(RecipeOutput exporter, Block output, Block lantern) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output).define('X', lantern).define('#', Items.IRON_NUGGET).pattern(" # ").pattern("#X#").pattern(" # ").unlockedBy(getHasName(lantern), has(lantern)).save(exporter);
    }

    public static void offerWaxingRecipes(RecipeOutput exporter, Block unwaxed, Block waxed) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, waxed).requires(unwaxed).requires(Items.HONEYCOMB).group(getItemName(waxed)).unlockedBy(getHasName(unwaxed), has(unwaxed)).save(exporter, getConversionRecipeName(waxed, Items.HONEYCOMB));
    }

    public static void offerCharredSmeltingRecipe(RecipeOutput exporter, TagKey<Item> input, ItemLike output, String hasitem) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output, 0.1F, 200).unlockedBy("has_" + hasitem, has(input)).save(exporter, getSimpleRecipeName(output) + "_from_smelting");
    }

    public static void offerMossyRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output).requires(input).requires(Blocks.VINE).group(BuiltInRegistries.BLOCK.getKey((Block) output).getPath()).unlockedBy("has_vine", has(Blocks.VINE)).save(exporter, getConversionRecipeName(output, Blocks.VINE));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output).requires(input).requires(Blocks.MOSS_BLOCK).group(BuiltInRegistries.BLOCK.getKey((Block) output).getPath()).unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK)).save(exporter, getConversionRecipeName(output, Blocks.MOSS_BLOCK));
    }

    public static void offerPolishedStoneRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public static RecipeBuilder createCondensingRecipe(RecipeCategory category, ItemLike output, int count, Ingredient input, String group) {
        return ShapedRecipeBuilder.shaped(category, output, count).define('S', input).group(group).pattern("SS").pattern("SS");
    }

    public static void offerShapelessRecipe2(RecipeOutput exporter, ItemLike output, ItemLike input, int outputCount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, outputCount).requires(input).unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public static void offerSturdyRecipe(RecipeOutput exporter, ItemLike output, ItemLike input1, ItemLike input2) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 2).define('#', input1).define('X', input2).pattern("X#X").pattern("# #").pattern("X#X").unlockedBy(getHasName(input1), has(input1)).unlockedBy(getHasName(input2), has(input2)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 2).define('#', input1).define('X', input2).pattern("#X#").pattern("X X").pattern("#X#").unlockedBy(getHasName(input1), has(input1)).unlockedBy(getHasName(input2), has(input2)).save(exporter, getSimpleRecipeName(output) + "_alt");

    }

    public static void offerDecoratedRecipe(RecipeOutput exporter, ItemLike output, ItemLike decoration, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', decoration).define('X', input).pattern("##").pattern("XX").unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public static void offerPhantomPurpurRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output).requires(input).requires(BlockusItemTags.SOUL_SOILS).unlockedBy("has_purpur", has(input)).save(exporter, getConversionRecipeName(output, Blocks.SOUL_SAND));

    }

    public static void offerColoredTilesRecipe(RecipeOutput exporter, ItemLike output, ItemLike color1, ItemLike color2) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 2).requires(color1).requires(color2).group("colored_tiles").unlockedBy(getHasName(color1), has(color1)).unlockedBy(getHasName(color2), has(color2)).save(exporter);

    }

    public static void offerUnicolorColoredTilesRecipe(RecipeOutput exporter, ItemLike output, ItemLike color) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 2).requires(color).requires(color).group("colored_tiles").unlockedBy(getHasName(color), has(color)).save(exporter);
        offerStonecuttingRecipe(exporter, output, color);

    }

    public static void offerSmallLogsRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', input).pattern(" # ").pattern("###").group("small_logs").unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public void offerWoodenPostRecipe(RecipeOutput exporter, WoodenPostBundle.WoodenPostVariants post, ItemLike base, ItemLike base2, ItemLike planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, post.block(), 6).define('#', base).pattern("#").pattern("#").pattern("#").group("wooden_posts").unlockedBy("has_woods", has(base)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, post.stripped(), 6).define('#', base2).pattern("#").pattern("#").pattern("#").group("stripped_wooden_posts").unlockedBy("has_woods", has(base2)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 2).requires(post.block()).group("planks").unlockedBy("has_wooden_post", has(post.block())).save(exporter, getConversionRecipeName(planks, post.block()));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 2).requires(post.stripped()).group("planks").unlockedBy("has_stripped_wooden_post", has(post.stripped())).save(exporter, getConversionRecipeName(planks, post.stripped()));
    }

    public static void offerSmallHedgesRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 6).define('#', input).pattern("###").pattern("###").group("small_hedge").unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public static void offerHerringBoneRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 5).define('#', input).pattern("#  ").pattern("###").pattern("  #").group("herringbone_planks").unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public static RecipeBuilder createEnclosedRecipe(ItemLike output, Ingredient input, ItemLike center) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 8).define('X', input).define('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
    }

    public static RecipeBuilder createEnclosedRecipe2(ItemLike output, Ingredient input, ItemLike center) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output).define('X', input).define('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
    }

    public static void offerDoorRecipe(RecipeOutput exporter, ItemLike door, ItemLike input) {
        doorBuilder(door, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public static void offerStoneDoorTrapdoorRecipe(RecipeOutput exporter, ItemLike door, ItemLike trapdoor, ItemLike input, ItemLike slab) {
        offerDoorRecipe(exporter, door, input);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, trapdoor, 4).define('#', slab).pattern("###").pattern("###").unlockedBy(getHasName(slab), has(slab)).save(exporter);
    }

    public static void offerDoorTrapdoorRecipe(RecipeOutput exporter, ItemLike door, ItemLike trapdoor, ItemLike input) {
        offerDoorRecipe(exporter, door, input);
        trapdoorBuilder(trapdoor, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public static void offerPressurePlateButtonRecipe(RecipeOutput exporter, ItemLike pressureplate, ItemLike button, ItemLike input) {
        pressurePlateBuilder(RecipeCategory.REDSTONE, pressureplate, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, button).requires(input).unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public void offerStainedStoneBricksRecipe(RecipeOutput exporter, ItemLike center, ItemLike output, ItemLike output_stairs, ItemLike output_slab, ItemLike output_wall) {
        createEnclosedRecipe(output, Ingredient.of(Blocks.STONE_BRICKS), center).group("stained_stone_bricks").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.of(Blocks.STONE_BRICK_STAIRS), center).group("stained_stone_brick_stairs").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter, getConversionRecipeName(output_stairs, Blocks.STONE_BRICK_STAIRS));
        createEnclosedRecipe(output_slab, Ingredient.of(Blocks.STONE_BRICK_SLAB), center).group("stained_stone_brick_slab").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter, getConversionRecipeName(output_slab, Blocks.STONE_BRICK_SLAB));
        createEnclosedRecipe(output_wall, Ingredient.of(Blocks.STONE_BRICK_WALL), center).group("stained_stone_brick_wall").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter, getConversionRecipeName(output_wall, Blocks.STONE_BRICK_WALL));
        offerStonecuttingRecipe(exporter, output_stairs, output);
        offerStonecuttingRecipe(exporter, output_slab, 2, output);
        offerStonecuttingRecipe(exporter, output_wall, output);
    }

    public void offerOreBricksRecipe(RecipeOutput exporter, BSSWBundle ore_bricks, ItemLike ore_block, ItemLike ore) {
        offerStonecuttingRecipe(exporter, ore_bricks.block(), ore_block);
        offerStonecuttingRecipe(exporter, ore_bricks.stairs(), ore_bricks.block(), ore_block);
        offerStonecuttingRecipe(exporter, ore_bricks.slab(), 2, ore_bricks.block(), ore_block);
        offerStonecuttingRecipe(exporter, ore_bricks.wall(), ore_bricks.block(), ore_block);
        offerPolishedStoneRecipe(exporter, ore_bricks.block(), ore_block);
        oneToOneConversionRecipe(exporter, ore, ore_bricks.block(), ore.toString(), 9);
        oneToOneConversionRecipe(exporter, ore, ore_bricks.stairs(), ore.toString(), 9);
        oneToOneConversionRecipe(exporter, ore, ore_bricks.slab(), ore.toString(), 4);
        oneToOneConversionRecipe(exporter, ore, ore_bricks.wall(), ore.toString(), 9);
    }

    public void offerCopperBricksRecipe(RecipeOutput exporter, CopperBundle block, ItemLike baseWaxed, ItemLike cutCopper, ItemLike cutCopperWaxed) {
        offerStonecuttingRecipe(exporter, block.block(), cutCopper);
        offerStonecuttingRecipe(exporter, block.stairs(), block.block(), cutCopper);
        offerStonecuttingRecipe(exporter, block.slab(), 2, block.block(), cutCopper);
        offerStonecuttingRecipe(exporter, block.wall(), block.block(), cutCopper);
        offerStonecuttingRecipe(exporter, block.blockWaxed(), cutCopperWaxed);
        offerStonecuttingRecipe(exporter, block.stairsWaxed(), block.blockWaxed(), cutCopperWaxed);
        offerStonecuttingRecipe(exporter, block.slabWaxed(), 2, block.blockWaxed(), cutCopperWaxed);
        offerStonecuttingRecipe(exporter, block.wallWaxed(), block.blockWaxed(), cutCopperWaxed);
        offerStonecuttingRecipe(exporter, block.block(), 4, block.base());
        offerStonecuttingRecipe(exporter, block.stairs(), 4, block.base());
        offerStonecuttingRecipe(exporter, block.slab(), 8, block.base());
        offerStonecuttingRecipe(exporter, block.wall(), 4, block.base());
        offerStonecuttingRecipe(exporter, block.blockWaxed(), 4, baseWaxed);
        offerStonecuttingRecipe(exporter, block.stairsWaxed(), 4, baseWaxed);
        offerStonecuttingRecipe(exporter, block.slabWaxed(), 8, baseWaxed);
        offerStonecuttingRecipe(exporter, block.wallWaxed(), 4, baseWaxed);
        offerPolishedStoneRecipe(exporter, block.block(), cutCopper);
        offerPolishedStoneRecipe(exporter, block.blockWaxed(), cutCopperWaxed);
    }

    public void createTimberFramesRecipes(RecipeOutput exporter, ItemLike base, ItemLike block, ItemLike diagonal, ItemLike cross) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block, 2).define('#', Items.PAPER).define('X', base).pattern("#X").pattern("X#").group("timber_frame").unlockedBy(getHasName(base), has(base)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, diagonal, 4).define('#', block).pattern("##").pattern("##").group("diagonal_timber_frame").unlockedBy(getHasName(block), has(block)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cross, 4).define('#', diagonal).pattern("##").pattern("##").group("cross_timber_frame").unlockedBy(getHasName(diagonal), has(diagonal)).save(exporter);
    }

    public void createLatticeRecipes(RecipeOutput exporter, ItemLike base, ItemLike lattice, ItemLike grate) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, grate, 3).define('#', Items.STICK).define('X', base).pattern(" # ").pattern("#X#").pattern(" # ").group("wooden_grates").unlockedBy(getHasName(base), has(base)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, lattice, 16).define('#', grate).pattern("###").pattern("###").group("wooden_lattices").unlockedBy(getHasName(lattice), has(lattice)).save(exporter);
    }

    public void offerAsphaltRecipe(RecipeOutput exporter, ItemLike center, ItemLike output, ItemLike output_stairs, ItemLike output_slab) {
        createEnclosedRecipe(output, Ingredient.of(ASPHALT.baseColor().block()), center).group("asphalt").unlockedBy(getHasName(ASPHALT.baseColor().block()), has(ASPHALT.baseColor().block())).save(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.of(ASPHALT.baseColor().stairs()), center).group("asphalt_stairs").unlockedBy(getHasName(ASPHALT.baseColor().stairs()), has(ASPHALT.baseColor().stairs())).save(exporter, getConversionRecipeName(output_stairs, ASPHALT.baseColor().stairs()));
        createEnclosedRecipe(output_slab, Ingredient.of(ASPHALT.baseColor().slab()), center).group("asphalt_slab").unlockedBy(getHasName(ASPHALT.baseColor().slab()), has(ASPHALT.baseColor().slab())).save(exporter, getConversionRecipeName(output_slab, ASPHALT.baseColor().slab()));
    }

    public void offerPatternedWoolRecipe(RecipeOutput exporter, ItemLike output, ItemLike wool, ItemLike output_carpet, ItemLike carpet) {
        offerPolishedStoneRecipe(exporter, output, wool);
        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, output_carpet, Ingredient.of(carpet)).group("patterned_carpet").unlockedBy(getHasName(carpet), has(carpet)).save(exporter, getConversionRecipeName(output_carpet, carpet));
    }

    public void offerGinghamWoolRecipe(RecipeOutput exporter, ItemLike output, ItemLike wool) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', wool).pattern(" # ").pattern("# #").pattern(" # ").group("gingham_wool").unlockedBy(getHasName(wool), has(wool)).save(exporter);
    }

    public void offerShinglesRecipe(RecipeOutput exporter, ItemLike center, ItemLike output, ItemLike output_stairs, ItemLike output_slab, ItemLike terracotta) {
        createEnclosedRecipe(output, Ingredient.of(SHINGLES.block()), center).group("shingles").unlockedBy(getHasName(SHINGLES.block()), has(SHINGLES.block())).save(exporter, getConversionRecipeName(output_stairs, SHINGLES.block()));
        createEnclosedRecipe(output_stairs, Ingredient.of(SHINGLES.stairs()), center).group("shingles_stairs").unlockedBy(getHasName(SHINGLES.block()), has(SHINGLES.block())).save(exporter, getConversionRecipeName(output_stairs, SHINGLES.stairs()));
        createEnclosedRecipe(output_slab, Ingredient.of(SHINGLES.slab()), center).group("shingles_slab").unlockedBy(getHasName(SHINGLES.block()), has(SHINGLES.block())).save(exporter, getConversionRecipeName(output_slab, SHINGLES.slab()));
        offerPolishedStoneRecipe(exporter, output, terracotta);
        offerStonecuttingRecipe(exporter, output, terracotta);
        offerStonecuttingRecipe(exporter, output_stairs, terracotta, output);
        offerStonecuttingRecipe(exporter, output_slab, 2, terracotta, output);
    }

    public void offerStairsRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        stairBuilder(output, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
    }

    public void offerStainedBeveledGlassRecipe(RecipeOutput exporter, ItemLike output, ItemLike output_pane, ItemLike input, ItemLike dye) {
        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.of(input)).group("beveled_glass").unlockedBy(getHasName(input), has(input)).save(exporter);
        createEnclosedRecipe(output, Ingredient.of(BEVELED_GLASS), dye).group("beveled_glass_2").unlockedBy(getHasName(BEVELED_GLASS), has(BEVELED_GLASS)).save(exporter, getConversionRecipeName(output, BEVELED_GLASS));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output_pane, 16).define('#', output).pattern("###").pattern("###").group("beveled_glass_pane").unlockedBy(getHasName(BEVELED_GLASS_PANE), has(output)).save(exporter);
        createEnclosedRecipe(output_pane, Ingredient.of(BEVELED_GLASS_PANE), dye).group("beveled_glass_pane_2").unlockedBy(getHasName(BEVELED_GLASS_PANE), has(BEVELED_GLASS_PANE)).save(exporter, getConversionRecipeName(output, BEVELED_GLASS_PANE));
    }

    public void offerStainedRedstoneLampRecipe(RecipeOutput exporter, ItemLike output, ItemLike dye, ItemLike output_lit) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output).define('S', dye).define('#', Blocks.REDSTONE_LAMP).pattern(" S ").pattern("S#S").pattern(" S ").group("redstone_lamps").unlockedBy(getHasName(Blocks.REDSTONE_LAMP), has(Blocks.REDSTONE_LAMP)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output_lit).requires(output).requires(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").unlockedBy(getHasName(output), has(output)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output_lit).define('S', dye).define('#', REDSTONE_LAMP_LIT).pattern(" S ").pattern("S#S").pattern(" S ").group("lit_redstone_lamps").unlockedBy(getHasName(Blocks.REDSTONE_LAMP), has(Blocks.REDSTONE_LAMP)).save(exporter, getSimpleRecipeName(output) + "_alt");
    }

    public void offerNeonRecipe(RecipeOutput exporter, ItemLike output, ItemLike dye) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 8).define('D', dye).define('S', Items.GLOW_INK_SAC).define('A', Items.AMETHYST_SHARD).pattern(" A ").pattern("SDS").pattern(" A ").group("neon_blocks").unlockedBy(getHasName(Items.GLOW_INK_SAC), has(Items.GLOW_INK_SAC)).save(exporter);
    }

    public void offerFuturneoRecipe(RecipeOutput exporter, ItemLike output, ItemLike glass) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 6).define('A', Items.BLACK_DYE).define('B', glass).define('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").unlockedBy(getHasName(glass), has(glass)).save(exporter);

    }

    public void offerBoatsRecipe(RecipeOutput exporter, ItemLike output1, ItemLike output2, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output1).define('#', input).pattern("# #").pattern("###").group("boat").unlockedBy("in_water", insideOf(Blocks.WATER)).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output2).requires(Blocks.CHEST).requires(output1).group("chest_boat").unlockedBy("has_boat", has(ItemTags.BOATS)).save(exporter);

    }

    public void offerPillarRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 2).define('#', input).pattern("#").pattern("#").unlockedBy(getHasName(input), has(input)).save(exporter);
        offerStonecuttingRecipe(exporter, output, 1, input);
    }

    public void offerBsswCuttingRecipe(RecipeOutput exporter, BSSWBundle bsswBundle, ItemLike... ingredients) {
        // For block, stairs, slab and wall (if exists) in BsswBundle.
        if (ingredients != null) {
            offerStonecuttingRecipe(exporter, bsswBundle.block(), ingredients);
            offerStonecuttingRecipe(exporter, bsswBundle.stairs(), ingredients);
            offerStonecuttingRecipe(exporter, bsswBundle.slab(), 2, ingredients);
            if (bsswBundle.wall() != null) {
                offerStonecuttingRecipe(exporter, bsswBundle.wall(), ingredients);
            }
        }
        offerStonecuttingRecipe(exporter, bsswBundle.stairs(), bsswBundle.block());
        offerStonecuttingRecipe(exporter, bsswBundle.slab(), 2, bsswBundle.block());
        if (bsswBundle.wall() != null) {
            offerStonecuttingRecipe(exporter, bsswBundle.wall(), bsswBundle.block());
        }
    }

    public static void offerStonecuttingRecipe(RecipeOutput exporter, ItemLike output, ItemLike... ingredients) {
        offerStonecuttingRecipe(exporter, output, 1, ingredients);
    }

    public static void offerStonecuttingRecipe(RecipeOutput exporter, ItemLike output, int count, ItemLike... ingredients) {

        for (ItemLike itemConvertible : ingredients) {
            SingleItemRecipeBuilder var10000 = SingleItemRecipeBuilder.stonecutting(Ingredient.of(itemConvertible), RecipeCategory.BUILDING_BLOCKS, output, count).unlockedBy(getHasName(itemConvertible), has(itemConvertible));
            String var10002 = getConversionRecipeName(output, itemConvertible);
            var10000.save(exporter, var10002 + "_stonecutting");
        }
    }

    public static void generateForEnabledBlockFamilies(RecipeOutput exporter, FeatureFlagSet enabledFeatures) {
        BlockusFamilies.getFamilies().filter(BlockFamily::shouldGenerateRecipe).forEach((family) -> {
            generateRecipes(exporter, family, enabledFeatures);
        });
    }
}
