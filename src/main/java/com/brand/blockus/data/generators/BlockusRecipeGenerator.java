package com.brand.blockus.data.generators;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusEntities;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.content.types.*;
import com.brand.blockus.data.family.BlockusBlockFamilies;
import com.brand.blockus.tags.BlockusItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;

import java.util.function.Consumer;

public class BlockusRecipeGenerator extends FabricRecipeProvider {
    public BlockusRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        for (BSSWTypes bsswType : BSSWTypes.values()) {
            BlockusRecipeGenerator.offerStairsRecipe(exporter, bsswType.stairs, bsswType.block);
            RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, bsswType.slab, bsswType.block);
            RecipeProvider.offerWallRecipe(exporter, RecipeCategory.DECORATIONS, bsswType.wall, bsswType.block);
        }

        for (BSSTypes bssType : BSSTypes.values()) {
            BlockusRecipeGenerator.offerStairsRecipe(exporter, bssType.stairs, bssType.block);
            RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, bssType.slab, bssType.block);
        }

        for (ConcreteTypes concreteType : ConcreteTypes.values()) {
            offerStonecuttingRecipe(exporter, concreteType.block, concreteType.base);
            offerStonecuttingRecipe(exporter, concreteType.stairs, concreteType.base, concreteType.block);
            offerStonecuttingRecipe(exporter, concreteType.slab, 2, concreteType.base, concreteType.block);
            offerStonecuttingRecipe(exporter, concreteType.wall, concreteType.base, concreteType.block);
            offerStonecuttingRecipe(exporter, concreteType.chiseled, concreteType.base, concreteType.block);
            offerStonecuttingRecipe(exporter, concreteType.pillar, concreteType.base, concreteType.block);
            offerPolishedStoneRecipe(exporter, concreteType.block, concreteType.base);
        }

        for (TimberFrameTypesF timberFrameType : TimberFrameTypesF.values()) {
            createTimberFramesRecipes(exporter, timberFrameType.base, timberFrameType.block, timberFrameType.diagonal, timberFrameType.cross);
        }

        for (TimberFrameTypesFP timberFrameType : TimberFrameTypesFP.values()) {
            createTimberFramesRecipes(exporter, timberFrameType.base, timberFrameType.block, timberFrameType.diagonal, timberFrameType.cross);

        }

        for (AsphaltTypes asphaltTypes : AsphaltTypes.values()) {
            BlockusRecipeGenerator.offerStairsRecipe(exporter, asphaltTypes.stairs, asphaltTypes.block);
            RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, asphaltTypes.slab, asphaltTypes.block);
            offerStonecuttingRecipe(exporter, asphaltTypes.stairs, asphaltTypes.block);
            offerStonecuttingRecipe(exporter, asphaltTypes.slab, 2, asphaltTypes.block);
        }

        for (PatternWoolTypes patternWoolTypes : PatternWoolTypes.values()) {
            offerPatternWoolRecipe(exporter, patternWoolTypes.block, patternWoolTypes.basewool, patternWoolTypes.carpet, patternWoolTypes.basecarpet);
            BlockusRecipeGenerator.offerStairsRecipe(exporter, patternWoolTypes.stairs, patternWoolTypes.block);
            RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, patternWoolTypes.slab, patternWoolTypes.block);
            RecipeProvider.offerCarpetRecipe(exporter, patternWoolTypes.carpet, patternWoolTypes.block);

        }

        for (ColoredTilesTypes coloredTilesTypes : ColoredTilesTypes.values()) {
            offerColoredTilesRecipe(exporter, coloredTilesTypes.block, coloredTilesTypes.tile1, coloredTilesTypes.tile2);
        }

        generateFamilies(exporter, FeatureSet.of(FeatureFlags.VANILLA));

        offerStonecuttingRecipe(exporter, BlockusBlocks.MUD_BRICK_PILLAR, Blocks.MUD_BRICKS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.MUD_BRICK_PILLAR, 2).input('#', Blocks.MUD_BRICKS).pattern("#").pattern("#").criterion(hasItem(Blocks.MUD_BRICKS), conditionsFromItem(Blocks.MUD_BRICKS)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MUD_BRICKS, Blocks.MUD_BRICKS);

        // Stone
        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_TILES.block, Blocks.STONE, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_TILES.stairs, Blocks.STONE, Blocks.STONE_BRICKS, BlockusBlocks.STONE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_TILES.slab, 2, Blocks.STONE, Blocks.STONE_BRICKS, BlockusBlocks.STONE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_TILES.wall, Blocks.STONE, Blocks.STONE_BRICKS, BlockusBlocks.STONE_TILES.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.STONE_TILES.block, Blocks.STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_BRICK_PILLAR, Blocks.STONE, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_STONE_BRICKS, Blocks.STONE, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_CIRCULAR_PAVING, Blocks.STONE, Blocks.STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
        offerStairsRecipe(exporter, BlockusBlocks.SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
        offerSturdyRecipe(exporter, BlockusBlocks.STURDY_STONE, Blocks.STONE, Blocks.COBBLESTONE);

        offerStoneDoorTrapdoorRecipe(exporter, BlockusBlocks.STONE_DOOR, BlockusBlocks.STONE_TRAPDOOR, Blocks.STONE, Blocks.STONE_SLAB);


        // Andesite
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICKS.block, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICKS.stairs, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, BlockusBlocks.ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICKS.slab, 2, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, BlockusBlocks.ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICKS.wall, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, BlockusBlocks.ANDESITE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.ANDESITE_BRICKS.block, Blocks.POLISHED_ANDESITE);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(BlockusBlocks.ANDESITE_BRICKS.block), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CRACKED_ANDESITE_BRICKS.asItem(), 0.1F, 200).criterion(hasItem(BlockusBlocks.ANDESITE_BRICKS.block), conditionsFromItem(BlockusBlocks.ANDESITE_BRICKS.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, BlockusBlocks.ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_ANDESITE_PILLAR, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, BlockusBlocks.ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, BlockusBlocks.ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_CIRCULAR_PAVING, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, BlockusBlocks.ANDESITE_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_ANDESITE_BUTTON, Blocks.POLISHED_ANDESITE);


        // Diorite
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICKS.block, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICKS.stairs, Blocks.DIORITE, Blocks.POLISHED_DIORITE, BlockusBlocks.DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICKS.slab, 2, Blocks.DIORITE, Blocks.POLISHED_DIORITE, BlockusBlocks.DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICKS.wall, Blocks.DIORITE, Blocks.POLISHED_DIORITE, BlockusBlocks.DIORITE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.DIORITE_BRICKS.block, Blocks.POLISHED_DIORITE);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(BlockusBlocks.DIORITE_BRICKS.block), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CRACKED_DIORITE_BRICKS.asItem(), 0.1F, 200).criterion(hasItem(BlockusBlocks.DIORITE_BRICKS.block), conditionsFromItem(BlockusBlocks.DIORITE_BRICKS.block)).offerTo(exporter);


        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, BlockusBlocks.DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DIORITE_PILLAR, Blocks.DIORITE, Blocks.POLISHED_DIORITE, BlockusBlocks.DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, BlockusBlocks.DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_CIRCULAR_PAVING, Blocks.DIORITE, Blocks.POLISHED_DIORITE, BlockusBlocks.DIORITE_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_DIORITE_BUTTON, Blocks.POLISHED_DIORITE);

        // Granite
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICKS.block, Blocks.GRANITE, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICKS.stairs, Blocks.GRANITE, Blocks.POLISHED_GRANITE, BlockusBlocks.GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICKS.slab, 2, Blocks.GRANITE, Blocks.POLISHED_GRANITE, BlockusBlocks.GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICKS.wall, Blocks.GRANITE, Blocks.POLISHED_GRANITE, BlockusBlocks.GRANITE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.GRANITE_BRICKS.block, Blocks.POLISHED_GRANITE);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(BlockusBlocks.GRANITE_BRICKS.block), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CRACKED_GRANITE_BRICKS.asItem(), 0.1F, 200).criterion(hasItem(BlockusBlocks.GRANITE_BRICKS.block), conditionsFromItem(BlockusBlocks.GRANITE_BRICKS.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, BlockusBlocks.GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_GRANITE_PILLAR, Blocks.GRANITE, Blocks.POLISHED_GRANITE, BlockusBlocks.GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, BlockusBlocks.GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_CIRCULAR_PAVING, Blocks.GRANITE, Blocks.POLISHED_GRANITE, BlockusBlocks.GRANITE_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_GRANITE_BUTTON, Blocks.POLISHED_GRANITE);

        // Dripstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DRIPSTONE.block, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DRIPSTONE.stairs, Blocks.DRIPSTONE_BLOCK, BlockusBlocks.POLISHED_DRIPSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DRIPSTONE.slab, 2, Blocks.DRIPSTONE_BLOCK, BlockusBlocks.POLISHED_DRIPSTONE.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_DRIPSTONE.block, Blocks.DRIPSTONE_BLOCK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICKS.block, Blocks.DRIPSTONE_BLOCK, BlockusBlocks.POLISHED_DRIPSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICKS.stairs, Blocks.DRIPSTONE_BLOCK, BlockusBlocks.POLISHED_DRIPSTONE.block, BlockusBlocks.DRIPSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICKS.slab, 2, Blocks.DRIPSTONE_BLOCK, BlockusBlocks.POLISHED_DRIPSTONE.block, BlockusBlocks.DRIPSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICKS.wall, Blocks.DRIPSTONE_BLOCK, BlockusBlocks.POLISHED_DRIPSTONE.block, BlockusBlocks.DRIPSTONE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICKS.block, BlockusBlocks.POLISHED_DRIPSTONE.block);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(BlockusBlocks.DRIPSTONE_BRICKS.block), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CRACKED_DRIPSTONE_BRICKS.asItem(), 0.1F, 200).criterion(hasItem(BlockusBlocks.DRIPSTONE_BRICKS.block), conditionsFromItem(BlockusBlocks.DRIPSTONE_BRICKS.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK, BlockusBlocks.POLISHED_DRIPSTONE.block, BlockusBlocks.DRIPSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_PILLAR, Blocks.DRIPSTONE_BLOCK, BlockusBlocks.POLISHED_DRIPSTONE.block, BlockusBlocks.DRIPSTONE_BRICKS.block);


        // Tuff
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TUFF.block, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TUFF.stairs, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TUFF.slab, 2, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_TUFF.block, Blocks.TUFF);

        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICKS.block, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICKS.stairs, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block, BlockusBlocks.TUFF_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICKS.slab, 2, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block, BlockusBlocks.TUFF_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICKS.wall, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block, BlockusBlocks.TUFF_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.TUFF_BRICKS.block, BlockusBlocks.POLISHED_TUFF.block);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(BlockusBlocks.TUFF_BRICKS.block), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CRACKED_TUFF_BRICKS.asItem(), 0.1F, 200).criterion(hasItem(BlockusBlocks.TUFF_BRICKS.block), conditionsFromItem(BlockusBlocks.TUFF_BRICKS.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_TUFF, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block, BlockusBlocks.TUFF_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_PILLAR, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block, BlockusBlocks.TUFF_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_TUFF_BRICKS, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block, BlockusBlocks.TUFF_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_CIRCULAR_PAVING, Blocks.TUFF, BlockusBlocks.POLISHED_TUFF.block, BlockusBlocks.TUFF_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE, BlockusBlocks.POLISHED_TUFF_BUTTON, BlockusBlocks.POLISHED_TUFF.block);

        // Amethyst
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST.block, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST.stairs, Blocks.AMETHYST_BLOCK, BlockusBlocks.POLISHED_AMETHYST.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST.slab, 2, Blocks.AMETHYST_BLOCK, BlockusBlocks.POLISHED_AMETHYST.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST.block, Blocks.AMETHYST_BLOCK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICKS.block, Blocks.AMETHYST_BLOCK, BlockusBlocks.POLISHED_AMETHYST.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICKS.stairs, Blocks.AMETHYST_BLOCK, BlockusBlocks.POLISHED_AMETHYST.block, BlockusBlocks.AMETHYST_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICKS.slab, 2, Blocks.AMETHYST_BLOCK, BlockusBlocks.POLISHED_AMETHYST.block, BlockusBlocks.AMETHYST_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICKS.wall, Blocks.AMETHYST_BLOCK, BlockusBlocks.POLISHED_AMETHYST.block, BlockusBlocks.AMETHYST_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.AMETHYST_BRICKS.block, BlockusBlocks.POLISHED_AMETHYST.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_AMETHYST, Blocks.AMETHYST_BLOCK, BlockusBlocks.POLISHED_AMETHYST.block, BlockusBlocks.AMETHYST_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_PILLAR, Blocks.AMETHYST_BLOCK, BlockusBlocks.POLISHED_AMETHYST.block, BlockusBlocks.AMETHYST_BRICKS.block);

        // Deepslate
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block).input(Blocks.DEEPSLATE_BRICKS).input(Blocks.VINE).group("mossy_deepslate_bricks").criterion("has_vine", conditionsFromItem(Blocks.VINE)).offerTo(exporter, convertBetween(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block, Blocks.VINE));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block).input(Blocks.DEEPSLATE_BRICKS).input(Blocks.MOSS_BLOCK).group("mossy_deepslate_bricks").criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK)).offerTo(exporter, convertBetween(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block, Blocks.MOSS_BLOCK));
        offerStonecuttingRecipe(exporter, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.stairs, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.slab, 2, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.wall, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.DEEPSLATE_PILLAR, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DEEPSLATE_CIRCULAR_PAVING, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);

        offerSturdyRecipe(exporter, BlockusBlocks.STURDY_DEEPSLATE, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE, BlockusBlocks.POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);


        // Sculk
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_SCULK.block, Blocks.SCULK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_SCULK.stairs, Blocks.SCULK, BlockusBlocks.POLISHED_SCULK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_SCULK.slab, 2, Blocks.SCULK, BlockusBlocks.POLISHED_SCULK.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_SCULK.block, Blocks.SCULK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SCULK_BRICKS.block, Blocks.SCULK, BlockusBlocks.POLISHED_SCULK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SCULK_BRICKS.stairs, Blocks.SCULK, BlockusBlocks.POLISHED_SCULK.block, BlockusBlocks.SCULK_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SCULK_BRICKS.slab, 2, Blocks.SCULK, BlockusBlocks.POLISHED_SCULK.block, BlockusBlocks.SCULK_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SCULK_BRICKS.wall, Blocks.SCULK, BlockusBlocks.POLISHED_SCULK.block, BlockusBlocks.SCULK_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_SCULK_BRICKS, Blocks.SCULK, BlockusBlocks.POLISHED_SCULK.block, BlockusBlocks.SCULK_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SCULK_PILLAR, Blocks.SCULK, BlockusBlocks.POLISHED_SCULK.block, BlockusBlocks.SCULK_BRICKS.block);

        offerPolishedStoneRecipe(exporter, BlockusBlocks.SCULK_BRICKS.block, BlockusBlocks.POLISHED_SCULK.block);
        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.POLISHED_SCULK_PRESSURE_PLATE, BlockusBlocks.POLISHED_SCULK_BUTTON, BlockusBlocks.POLISHED_SCULK.block);

        // Blackstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_TILES.block, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_TILES.stairs, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, BlockusBlocks.POLISHED_BLACKSTONE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_TILES.slab, 2, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, BlockusBlocks.POLISHED_BLACKSTONE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_TILES.wall, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, BlockusBlocks.POLISHED_BLACKSTONE_TILES.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_TILES.block, Blocks.POLISHED_BLACKSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_PILLAR, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_CIRCULAR_PAVING, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.block).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(Blocks.CRIMSON_ROOTS).criterion("has_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.stairs, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.slab, 2, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.wall, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.block);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.block).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(BlockusItemTags.WARPED_NETHER_GRASS).criterion("has_roots", conditionsFromTag(BlockusItemTags.WARPED_NETHER_GRASS)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.stairs, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.slab, 2, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.wall, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.block);

        offerSturdyRecipe(exporter, BlockusBlocks.STURDY_BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE, Items.GOLD_INGOT, Blocks.POLISHED_BLACKSTONE);

        offerStoneDoorTrapdoorRecipe(exporter, BlockusBlocks.BLACKSTONE_DOOR, BlockusBlocks.BLACKSTONE_TRAPDOOR, Blocks.BLACKSTONE, Blocks.BLACKSTONE_SLAB);


        // Basalt
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_BASALT.stairs, BlockusBlocks.ROUGH_BASALT.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_BASALT.slab, 2, BlockusBlocks.ROUGH_BASALT.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ROUGH_BASALT.block, 2).input('#', Blocks.BASALT).pattern("#").pattern("#").criterion("has_basalt", conditionsFromItem(Blocks.BASALT)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICKS.block, Blocks.BASALT, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICKS.stairs, Blocks.BASALT, Blocks.POLISHED_BASALT, BlockusBlocks.POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICKS.slab, 2, Blocks.BASALT, Blocks.POLISHED_BASALT, BlockusBlocks.POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICKS.wall, Blocks.BASALT, Blocks.POLISHED_BASALT, BlockusBlocks.POLISHED_BASALT_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICKS.block, Blocks.POLISHED_BASALT);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(BlockusBlocks.POLISHED_BASALT_BRICKS.block), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS.asItem(), 0.1F, 200).criterion(hasItem(BlockusBlocks.POLISHED_BASALT_BRICKS.block), conditionsFromItem(BlockusBlocks.POLISHED_BASALT_BRICKS.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_POLISHED_BASALT, Blocks.BASALT, Blocks.POLISHED_BASALT, BlockusBlocks.POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_PILLAR, Blocks.BASALT, Blocks.POLISHED_BASALT, BlockusBlocks.POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT, BlockusBlocks.POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_CIRCULAR_PAVING, Blocks.BASALT, Blocks.POLISHED_BASALT, BlockusBlocks.POLISHED_BASALT_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE, BlockusBlocks.POLISHED_BASALT_BUTTON, Blocks.POLISHED_BASALT);


        // Wart Blocks
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WART_BRICKS.block, Blocks.NETHER_WART_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WART_BRICKS.stairs, Blocks.NETHER_WART_BLOCK, BlockusBlocks.CRIMSON_WART_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WART_BRICKS.slab, 2, Blocks.NETHER_WART_BLOCK, BlockusBlocks.CRIMSON_WART_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WART_BRICKS.wall, Blocks.NETHER_WART_BLOCK, BlockusBlocks.CRIMSON_WART_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.CRIMSON_WART_BRICKS.block, Blocks.NETHER_WART_BLOCK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WART_BRICKS.block, Blocks.WARPED_WART_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WART_BRICKS.stairs, Blocks.WARPED_WART_BLOCK, BlockusBlocks.WARPED_WART_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WART_BRICKS.slab, 2, Blocks.WARPED_WART_BLOCK, BlockusBlocks.WARPED_WART_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WART_BRICKS.wall, Blocks.WARPED_WART_BLOCK, BlockusBlocks.WARPED_WART_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.WARPED_WART_BRICKS.block, Blocks.WARPED_WART_BLOCK);

        // Limestone
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE.stairs, BlockusBlocks.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE.slab, BlockusBlocks.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE.wall, BlockusBlocks.LIMESTONE.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.LIMESTONE.block).input('#', Blocks.COBBLESTONE).input('X', Items.BONE_MEAL).pattern("#X").pattern("X#").criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_LIMESTONE.stairs, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_LIMESTONE.slab, 2, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICKS.block, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICKS.stairs, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICKS.slab, 2, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICKS.wall, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.LIMESTONE_BRICKS.block, BlockusBlocks.POLISHED_LIMESTONE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICKS.block, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICKS.stairs, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block, BlockusBlocks.SMALL_LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICKS.slab, 2, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block, BlockusBlocks.SMALL_LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICKS.wall, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block, BlockusBlocks.SMALL_LIMESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILES.block, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILES.stairs, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block, BlockusBlocks.LIMESTONE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILES.slab, 2, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block, BlockusBlocks.LIMESTONE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILES.wall, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block, BlockusBlocks.LIMESTONE_TILES.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.LIMESTONE_TILES.block, BlockusBlocks.LIMESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIMESTONE, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIMESTONE_PILLAR, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block, BlockusBlocks.LIMESTONE_PILLAR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_PILLAR, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_SQUARES, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_CIRCULAR_PAVING, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_LINES, BlockusBlocks.LIMESTONE.block, BlockusBlocks.POLISHED_LIMESTONE.block, BlockusBlocks.LIMESTONE_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.LIMESTONE_PRESSURE_PLATE, BlockusBlocks.LIMESTONE_BUTTON, BlockusBlocks.LIMESTONE.block);

        // Marble
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE.stairs, BlockusBlocks.MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE.slab, 2, BlockusBlocks.MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE.wall, BlockusBlocks.MARBLE.block);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.MARBLE.block).input('#', BlockusBlocks.LIMESTONE.block).input('X', Items.BONE_MEAL).pattern("#X").pattern("X#").group("marble").criterion(hasItem(BlockusBlocks.LIMESTONE.block), conditionsFromItem(BlockusBlocks.LIMESTONE.block)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.MARBLE.block).input(Blocks.CALCITE).input(BlockusBlocks.LIMESTONE.block).group("marble").criterion(hasItem(Blocks.CALCITE), conditionsFromItem(Blocks.CALCITE)).offerTo(exporter, convertBetween(BlockusBlocks.MARBLE.block, Blocks.CALCITE));
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_MARBLE.stairs, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_MARBLE.slab, 2, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICKS.block, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICKS.stairs, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICKS.slab, 2, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICKS.wall, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.MARBLE_BRICKS.block, BlockusBlocks.POLISHED_MARBLE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICKS.block, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICKS.stairs, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block, BlockusBlocks.SMALL_MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICKS.slab, 2, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block, BlockusBlocks.SMALL_MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICKS.wall, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block, BlockusBlocks.SMALL_MARBLE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILES.block, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILES.stairs, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block, BlockusBlocks.MARBLE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILES.slab, 2, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block, BlockusBlocks.MARBLE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILES.wall, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block, BlockusBlocks.MARBLE_TILES.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.MARBLE_TILES.block, BlockusBlocks.MARBLE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE_PILLAR, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block, BlockusBlocks.MARBLE_PILLAR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_PILLAR, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_SQUARES, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_CIRCULAR_PAVING, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_LINES, BlockusBlocks.MARBLE.block, BlockusBlocks.POLISHED_MARBLE.block, BlockusBlocks.MARBLE_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.MARBLE_PRESSURE_PLATE, BlockusBlocks.MARBLE_BUTTON, BlockusBlocks.MARBLE.block);

        // Bluestone
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE.stairs, BlockusBlocks.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE.slab, 2, BlockusBlocks.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE.wall, BlockusBlocks.BLUESTONE.block);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.BLUESTONE.block, 4).input('S', Blocks.STONE).input('#', Items.BLUE_DYE).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE)).criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE)).offerTo(exporter);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLUESTONE.stairs, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLUESTONE.slab, 2, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICKS.block, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICKS.stairs, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICKS.slab, 2, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICKS.wall, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.BLUESTONE_BRICKS.block, BlockusBlocks.POLISHED_BLUESTONE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICKS.block, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICKS.stairs, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block, BlockusBlocks.SMALL_BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICKS.slab, 2, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block, BlockusBlocks.SMALL_BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICKS.wall, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block, BlockusBlocks.SMALL_BLUESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILES.block, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILES.stairs, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block, BlockusBlocks.BLUESTONE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILES.slab, 2, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block, BlockusBlocks.BLUESTONE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILES.wall, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block, BlockusBlocks.BLUESTONE_TILES.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.BLUESTONE_TILES.block, BlockusBlocks.BLUESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUESTONE, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_PILLAR, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUESTONE_PILLAR, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block, BlockusBlocks.BLUESTONE_PILLAR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_SQUARES, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_CIRCULAR_PAVING, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_LINES, BlockusBlocks.BLUESTONE.block, BlockusBlocks.POLISHED_BLUESTONE.block, BlockusBlocks.BLUESTONE_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.BLUESTONE_PRESSURE_PLATE, BlockusBlocks.BLUESTONE_BUTTON, BlockusBlocks.BLUESTONE.block);

        // Viridite
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE.stairs, BlockusBlocks.VIRIDITE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE.slab, 2, BlockusBlocks.VIRIDITE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE.wall, BlockusBlocks.VIRIDITE.block);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.VIRIDITE.block, 4).input('S', Blocks.DEEPSLATE).input('#', Blocks.SCULK).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Blocks.SCULK), conditionsFromItem(Blocks.SCULK)).criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.VIRIDITE.block, 4).input('S', Blocks.DEEPSLATE).input('#', Items.GREEN_DYE).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Items.GREEN_DYE), conditionsFromItem(Items.GREEN_DYE)).criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE)).offerTo(exporter, convertBetween(BlockusBlocks.VIRIDITE.block, Items.GREEN_DYE));
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_VIRIDITE.stairs, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_VIRIDITE.slab, 2, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_BRICKS.block, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_BRICKS.stairs, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_BRICKS.slab, 2, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_BRICKS.wall, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.VIRIDITE_BRICKS.block, BlockusBlocks.POLISHED_VIRIDITE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_VIRIDITE_BRICKS.block, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_VIRIDITE_BRICKS.stairs, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block, BlockusBlocks.SMALL_VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_VIRIDITE_BRICKS.slab, 2, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block, BlockusBlocks.SMALL_VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_VIRIDITE_BRICKS.wall, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block, BlockusBlocks.SMALL_VIRIDITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_TILES.block, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_TILES.stairs, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block, BlockusBlocks.VIRIDITE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_TILES.slab, 2, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block, BlockusBlocks.VIRIDITE_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_TILES.wall, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block, BlockusBlocks.VIRIDITE_TILES.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.VIRIDITE_TILES.block, BlockusBlocks.VIRIDITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_VIRIDITE, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_PILLAR, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_VIRIDITE_PILLAR, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block, BlockusBlocks.VIRIDITE_PILLAR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_SQUARES, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_CIRCULAR_PAVING, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.VIRIDITE_LINES, BlockusBlocks.VIRIDITE.block, BlockusBlocks.POLISHED_VIRIDITE.block, BlockusBlocks.VIRIDITE_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.VIRIDITE_PRESSURE_PLATE, BlockusBlocks.VIRIDITE_BUTTON, BlockusBlocks.VIRIDITE.block);

        // Lava	Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_BRICKS.stairs, BlockusBlocks.LAVA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_BRICKS.slab, 2, BlockusBlocks.LAVA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_BRICKS.wall, BlockusBlocks.LAVA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LAVA_BRICKS, BlockusBlocks.LAVA_BRICKS.block);
        createEnclosedRecipe(BlockusBlocks.LAVA_BRICKS.block, Ingredient.ofItems(Blocks.STONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

        // Lava Blackstone Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.stairs, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.slab, 2, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.wall, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LAVA_POLISHED_BLACKSTONE, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        createEnclosedRecipe(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.block, Ingredient.ofItems(Blocks.POLISHED_BLACKSTONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.POLISHED_BLACKSTONE_BRICKS), conditionsFromItem(Blocks.POLISHED_BLACKSTONE_BRICKS)).offerTo(exporter);

        // Water Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.WATER_BRICKS.stairs, BlockusBlocks.WATER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WATER_BRICKS.slab, 2, BlockusBlocks.WATER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WATER_BRICKS.wall, BlockusBlocks.WATER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_WATER_BRICKS, BlockusBlocks.WATER_BRICKS.block);
        createEnclosedRecipe(BlockusBlocks.WATER_BRICKS.block, Ingredient.ofItems(Blocks.STONE_BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

        // Snow Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.SNOW_BRICKS.stairs, BlockusBlocks.SNOW_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SNOW_BRICKS.slab, 2, BlockusBlocks.SNOW_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SNOW_BRICKS.wall, BlockusBlocks.SNOW_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SNOW_PILLAR, BlockusBlocks.SNOW_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.SNOW_BRICKS.block, Blocks.SNOW_BLOCK);

        // Ice Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.ICE_BRICK_WALL, BlockusBlocks.ICE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ICE_PILLAR, BlockusBlocks.ICE_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ICE_BRICKS, 4).input('#', BlockusItemTags.NATURAL_ICE).pattern("##").pattern("##").criterion("has_ice", conditionsFromTag(BlockusItemTags.NATURAL_ICE)).offerTo(exporter);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ICE_BRICK_WALL, BlockusBlocks.ICE_BRICKS);

        // Magma Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICKS.block, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICKS.stairs, Blocks.MAGMA_BLOCK, BlockusBlocks.MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICKS.slab, 2, Blocks.MAGMA_BLOCK, BlockusBlocks.MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICKS.wall, Blocks.MAGMA_BLOCK, BlockusBlocks.MAGMA_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.MAGMA_BRICKS.block, Blocks.MAGMA_BLOCK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICKS.block, Blocks.MAGMA_BLOCK, BlockusBlocks.MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICKS.stairs, Blocks.MAGMA_BLOCK, BlockusBlocks.MAGMA_BRICKS.block, BlockusBlocks.SMALL_MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICKS.slab, 2, Blocks.MAGMA_BLOCK, BlockusBlocks.MAGMA_BRICKS.block, BlockusBlocks.SMALL_MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICKS.wall, Blocks.MAGMA_BLOCK, BlockusBlocks.MAGMA_BRICKS.block, BlockusBlocks.SMALL_MAGMA_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MAGMA_BRICKS, Blocks.MAGMA_BLOCK, BlockusBlocks.MAGMA_BRICKS.block);

        // Blaze Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLAZE_BRICKS.stairs, BlockusBlocks.BLAZE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLAZE_BRICKS.slab, 2, BlockusBlocks.BLAZE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLAZE_BRICKS.wall, BlockusBlocks.BLAZE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLAZE_PILLAR, BlockusBlocks.BLAZE_BRICKS.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.BLAZE_BRICKS.block).input('#', Items.BLAZE_POWDER).input('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").criterion("has_blaze_rod", conditionsFromItem(Items.BLAZE_ROD)).offerTo(exporter);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.BLAZE_POWDER, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.BLAZE_LANTERN);

        // Netherrack

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK.block, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK.stairs, Blocks.NETHERRACK, BlockusBlocks.POLISHED_NETHERRACK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK.slab, 2, Blocks.NETHERRACK, BlockusBlocks.POLISHED_NETHERRACK.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK.block, Blocks.NETHERRACK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICKS.block, Blocks.NETHERRACK, BlockusBlocks.POLISHED_NETHERRACK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICKS.stairs, Blocks.NETHERRACK, BlockusBlocks.POLISHED_NETHERRACK.block, BlockusBlocks.NETHERRACK_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICKS.slab, 2, Blocks.NETHERRACK, BlockusBlocks.POLISHED_NETHERRACK.block, BlockusBlocks.NETHERRACK_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICKS.wall, Blocks.NETHERRACK, BlockusBlocks.POLISHED_NETHERRACK.block, BlockusBlocks.NETHERRACK_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_CIRCULAR_PAVING, Blocks.NETHERRACK, BlockusBlocks.POLISHED_NETHERRACK.block, BlockusBlocks.NETHERRACK_BRICKS.block);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE, BlockusBlocks.POLISHED_NETHERRACK_BUTTON, BlockusBlocks.POLISHED_NETHERRACK.block);

        // Nether Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHER_BRICK_PILLAR, Blocks.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_NETHER_BRICKS, Blocks.NETHER_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_NETHER_BRICK_PILLAR, Blocks.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHER_TILES.stairs, BlockusBlocks.NETHER_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHER_TILES.slab, 2, BlockusBlocks.NETHER_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHER_TILES.wall, BlockusBlocks.NETHER_TILES.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.NETHER_TILES.block, 4).input('#', Blocks.NETHERRACK).input('X', Blocks.NETHER_BRICKS).pattern("#X").pattern("X#").criterion(hasItem(Blocks.NETHER_BRICKS), conditionsFromItem(Blocks.NETHER_BRICKS)).offerTo(exporter);

        // Charred Nether Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_NETHER_BRICKS.stairs, BlockusBlocks.CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_NETHER_BRICKS.slab, 2, BlockusBlocks.CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_NETHER_BRICKS.wall, BlockusBlocks.CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_CHARRED_NETHER_BRICKS, BlockusBlocks.CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_CHARRED_NETHER_BRICKS, BlockusBlocks.CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_NETHER_BRICK_PILLAR, BlockusBlocks.CHARRED_NETHER_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_CHARRED_NETHER_BRICKS, BlockusBlocks.CHARRED_NETHER_BRICKS.block);
        createEnclosedRecipe(BlockusBlocks.CHARRED_NETHER_BRICKS.block, Ingredient.ofItems(Blocks.NETHER_BRICKS), Items.FIRE_CHARGE).criterion(hasItem(Items.FIRE_CHARGE), conditionsFromItem(Items.FIRE_CHARGE)).criterion(hasItem(Blocks.NETHER_BRICKS), conditionsFromItem(Blocks.NETHER_BRICKS)).offerTo(exporter);

        // Teal Nether Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.TEAL_NETHER_BRICKS.stairs, BlockusBlocks.TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TEAL_NETHER_BRICKS.slab, 2, BlockusBlocks.TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TEAL_NETHER_BRICKS.wall, BlockusBlocks.TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TEAL_NETHER_BRICKS, BlockusBlocks.TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_TEAL_NETHER_BRICKS, BlockusBlocks.TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TEAL_NETHER_BRICK_PILLAR, BlockusBlocks.TEAL_NETHER_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_TEAL_NETHER_BRICKS, BlockusBlocks.TEAL_NETHER_BRICKS.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.TEAL_NETHER_BRICKS.block).input('#', BlockusItemTags.WARPED_NETHER_GRASS).input('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").group("teal_nether_bricks").criterion("has_warped_grass", conditionsFromTag(BlockusItemTags.WARPED_NETHER_GRASS)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.TEAL_NETHER_BRICKS.block, 2).input(Blocks.WARPED_WART_BLOCK).input(Items.NETHER_BRICKS).group("teal_nether_bricks").criterion(hasItem(Blocks.WARPED_WART_BLOCK), conditionsFromItem(Blocks.WARPED_WART_BLOCK)).offerTo(exporter, convertBetween(BlockusBlocks.TEAL_NETHER_BRICKS.block, Blocks.WARPED_WART_BLOCK));


        // Obsidian
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICKS.block, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICKS.stairs, Blocks.OBSIDIAN, BlockusBlocks.OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICKS.slab, 2, Blocks.OBSIDIAN, BlockusBlocks.OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICKS.wall, Blocks.OBSIDIAN, BlockusBlocks.OBSIDIAN_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICKS.block, Blocks.OBSIDIAN);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(BlockusBlocks.OBSIDIAN_BRICKS.block), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CRACKED_OBSIDIAN_BRICKS.asItem(), 0.1F, 200).criterion(hasItem(BlockusBlocks.OBSIDIAN_BRICKS.block), conditionsFromItem(BlockusBlocks.OBSIDIAN_BRICKS.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICKS.block, Blocks.OBSIDIAN, BlockusBlocks.OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICKS.stairs, Blocks.OBSIDIAN, BlockusBlocks.OBSIDIAN_BRICKS.block, BlockusBlocks.SMALL_OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICKS.slab, 2, Blocks.OBSIDIAN, BlockusBlocks.OBSIDIAN_BRICKS.block, BlockusBlocks.SMALL_OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICKS.wall, Blocks.OBSIDIAN, BlockusBlocks.OBSIDIAN_BRICKS.block, BlockusBlocks.SMALL_OBSIDIAN_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_PILLAR, Blocks.OBSIDIAN, BlockusBlocks.OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_CIRCULAR_PAVING, Blocks.OBSIDIAN, BlockusBlocks.OBSIDIAN_BRICKS.block);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.GLOWING_OBSIDIAN, 4).input('S', Blocks.OBSIDIAN).input('#', Blocks.SHROOMLIGHT).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Blocks.SHROOMLIGHT), conditionsFromItem(Blocks.SHROOMLIGHT)).offerTo(exporter);

        offerDoorTrapdoorRecipe(exporter, BlockusBlocks.OBSIDIAN_REINFORCED_DOOR, BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR, Blocks.OBSIDIAN);


        // Quartz Blocks

        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILES.block, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILES.stairs, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS, BlockusBlocks.QUARTZ_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILES.slab, 2, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS, BlockusBlocks.QUARTZ_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILES.wall, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS, BlockusBlocks.QUARTZ_TILES.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.QUARTZ_TILES.block, Blocks.QUARTZ_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_CIRCULAR_PAVING, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);

        // Prismarine
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PRISMARINE, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PRISMARINE_CIRCULAR_PAVING, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DARK_PRISMARINE, Blocks.DARK_PRISMARINE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE);

        // Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICKS.block, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICKS.stairs, Blocks.BRICKS, BlockusBlocks.LARGE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICKS.slab, 2, Blocks.BRICKS, BlockusBlocks.LARGE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICKS.wall, Blocks.BRICKS, BlockusBlocks.LARGE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.LARGE_BRICKS.block, Blocks.BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_BRICKS, Blocks.BRICKS);

        // Soaked Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOAKED_BRICKS.stairs, BlockusBlocks.SOAKED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOAKED_BRICKS.slab, 2, BlockusBlocks.SOAKED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOAKED_BRICKS.wall, BlockusBlocks.SOAKED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_SOAKED_BRICKS, BlockusBlocks.SOAKED_BRICKS.block);
        createEnclosedRecipe(BlockusBlocks.SOAKED_BRICKS.block, Ingredient.ofItems(Blocks.BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Sandy Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDY_BRICKS.stairs, BlockusBlocks.SANDY_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDY_BRICKS.slab, 2, BlockusBlocks.SANDY_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDY_BRICKS.wall, BlockusBlocks.SANDY_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_SANDY_BRICKS, BlockusBlocks.SANDY_BRICKS.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.SANDY_BRICKS.block, 2).input('S', Blocks.SAND).input('#', Blocks.BRICKS).pattern(" S ").pattern("S#S").pattern(" S ").criterion("has_sand", conditionsFromItem(Blocks.SAND)).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Charred Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_BRICKS.stairs, BlockusBlocks.CHARRED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_BRICKS.slab, 2, BlockusBlocks.CHARRED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_BRICKS.wall, BlockusBlocks.CHARRED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_CHARRED_BRICKS, BlockusBlocks.CHARRED_BRICKS.block);
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CHARRED_BRICKS.block.asItem(), 0.1F, 200).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Sandstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_SANDSTONE.stairs, BlockusBlocks.ROUGH_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_SANDSTONE.slab, 2, BlockusBlocks.ROUGH_SANDSTONE.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ROUGH_SANDSTONE.block, 2).input('#', Blocks.SANDSTONE_SLAB).pattern("##").pattern("##").criterion("has_sandstone", conditionsFromItem(Blocks.SANDSTONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICKS.block, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICKS.stairs, Blocks.SANDSTONE, BlockusBlocks.SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICKS.slab, 2, Blocks.SANDSTONE, BlockusBlocks.SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICKS.wall, Blocks.SANDSTONE, BlockusBlocks.SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICKS.block, Blocks.SANDSTONE, BlockusBlocks.SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICKS.stairs, Blocks.SANDSTONE, BlockusBlocks.SANDSTONE_BRICKS.block, BlockusBlocks.SMALL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICKS.slab, 2, Blocks.SANDSTONE, BlockusBlocks.SANDSTONE_BRICKS.block, BlockusBlocks.SMALL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICKS.wall, Blocks.SANDSTONE, BlockusBlocks.SANDSTONE_BRICKS.block, BlockusBlocks.SMALL_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_PILLAR, Blocks.SANDSTONE, BlockusBlocks.SANDSTONE_BRICKS.block);

        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_SANDSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.LAPIS_DECORATED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_SANDSTONE);

        // Red Sandstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_RED_SANDSTONE.stairs, BlockusBlocks.ROUGH_RED_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_RED_SANDSTONE.slab, 2, BlockusBlocks.ROUGH_RED_SANDSTONE.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ROUGH_RED_SANDSTONE.block, 2).input('#', Blocks.RED_SANDSTONE_SLAB).pattern("##").pattern("##").criterion("has_red_sandstone", conditionsFromItem(Blocks.RED_SANDSTONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICKS.block, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICKS.stairs, Blocks.RED_SANDSTONE, BlockusBlocks.RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICKS.slab, 2, Blocks.RED_SANDSTONE, BlockusBlocks.RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICKS.wall, Blocks.RED_SANDSTONE, BlockusBlocks.RED_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.block, Blocks.RED_SANDSTONE, BlockusBlocks.RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.stairs, Blocks.RED_SANDSTONE, BlockusBlocks.RED_SANDSTONE_BRICKS.block, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.slab, 2, Blocks.RED_SANDSTONE, BlockusBlocks.RED_SANDSTONE_BRICKS.block, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.wall, Blocks.RED_SANDSTONE, BlockusBlocks.RED_SANDSTONE_BRICKS.block, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE, BlockusBlocks.RED_SANDSTONE_BRICKS.block);

        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_RED_SANDSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.LAPIS_DECORATED_RED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_RED_SANDSTONE);

        // Soul Sandstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE.stairs, BlockusBlocks.SOUL_SANDSTONE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE.slab, 2, BlockusBlocks.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE.wall, 2, BlockusBlocks.SOUL_SANDSTONE.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.SOUL_SANDSTONE.block).input('#', BlockusItemTags.SOUL_SOILS).pattern("##").pattern("##").criterion("has_soul_sand", conditionsFromTag(BlockusItemTags.SOUL_SOILS)).offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, BlockusBlocks.CUT_SOUL_SANDSTONE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_SOUL_SANDSTONE.stairs, BlockusBlocks.ROUGH_SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_SOUL_SANDSTONE.slab, 2, BlockusBlocks.ROUGH_SOUL_SANDSTONE.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ROUGH_SOUL_SANDSTONE.block, 2).input('#', BlockusBlocks.SOUL_SANDSTONE.slab).pattern("##").pattern("##").criterion("has_soul_sandstone", conditionsFromItem(BlockusBlocks.SOUL_SANDSTONE.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICKS.block, BlockusBlocks.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICKS.stairs, BlockusBlocks.SOUL_SANDSTONE.block, BlockusBlocks.SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICKS.slab, 2, BlockusBlocks.SOUL_SANDSTONE.block, BlockusBlocks.SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICKS.wall, BlockusBlocks.SOUL_SANDSTONE.block, BlockusBlocks.SOUL_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.block, BlockusBlocks.SOUL_SANDSTONE.block, BlockusBlocks.SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.stairs, BlockusBlocks.SOUL_SANDSTONE.block, BlockusBlocks.SOUL_SANDSTONE_BRICKS.block, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.slab, 2, BlockusBlocks.SOUL_SANDSTONE.block, BlockusBlocks.SOUL_SANDSTONE_BRICKS.block, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.wall, BlockusBlocks.SOUL_SANDSTONE.block, BlockusBlocks.SOUL_SANDSTONE_BRICKS.block, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMOOTH_SOUL_SANDSTONE.stairs, BlockusBlocks.SMOOTH_SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMOOTH_SOUL_SANDSTONE.slab, 2, BlockusBlocks.SMOOTH_SOUL_SANDSTONE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, 2, BlockusBlocks.SOUL_SANDSTONE.block, BlockusBlocks.CUT_SOUL_SANDSTONE);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.CHISELED_SOUL_SANDSTONE, BlockusBlocks.CUT_SOUL_SANDSTONE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_PILLAR, BlockusBlocks.SOUL_SANDSTONE.block, BlockusBlocks.SOUL_SANDSTONE_BRICKS.block);

        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE, Items.GOLD_INGOT, BlockusBlocks.CUT_SOUL_SANDSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.LAPIS_DECORATED_SOUL_SANDSTONE, Items.LAPIS_LAZULI, BlockusBlocks.CUT_SOUL_SANDSTONE);

        // Honeycomb Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICKS.block, Blocks.HONEYCOMB_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICKS.stairs, Blocks.HONEYCOMB_BLOCK, BlockusBlocks.HONEYCOMB_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICKS.slab, 2, Blocks.HONEYCOMB_BLOCK, BlockusBlocks.HONEYCOMB_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICKS.wall, Blocks.HONEYCOMB_BLOCK, BlockusBlocks.HONEYCOMB_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICKS.block, Blocks.HONEYCOMB_BLOCK);

        // Purpur Blocks
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PURPUR.block, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PURPUR.stairs, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PURPUR.slab, 2, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_PURPUR.block, Blocks.PURPUR_BLOCK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICKS.block, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICKS.stairs, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICKS.slab, 2, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICKS.wall, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICKS.block, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICKS.stairs, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block, BlockusBlocks.SMALL_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICKS.slab, 2, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block, BlockusBlocks.SMALL_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICKS.wall, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block, BlockusBlocks.SMALL_PURPUR_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPUR, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, Blocks.PURPUR_PILLAR, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_SQUARES, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_LINES, Blocks.PURPUR_BLOCK, BlockusBlocks.POLISHED_PURPUR.block, BlockusBlocks.PURPUR_BRICKS.block);

        // Phantom Purpur Blocks

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BLOCK.stairs, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BLOCK.slab, 2, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, Blocks.PURPUR_BLOCK);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR.stairs, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR.slab, 2, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.POLISHED_PURPUR.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICKS.stairs, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICKS.slab, 2, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICKS.wall, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block, BlockusBlocks.PURPUR_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.block, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.stairs, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.slab, 2, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.wall, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BlockusBlocks.CHISELED_PURPUR);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_PILLAR, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_PILLAR, Blocks.PURPUR_PILLAR);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.PHANTOM_PURPUR_PILLAR).input('#', BlockusBlocks.PHANTOM_PURPUR_BLOCK.slab).pattern("#").pattern("#").criterion("has_phantom_purpur_block", conditionsFromItem(BlockusBlocks.PHANTOM_PURPUR_BLOCK.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BlockusBlocks.PURPUR_SQUARES);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BlockusBlocks.PHANTOM_PURPUR_BLOCK.block, BlockusBlocks.POLISHED_PHANTOM_PURPUR.block, BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BlockusBlocks.PURPUR_LINES);

        // End Stone
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_END_STONE.block, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_END_STONE.stairs, Blocks.END_STONE, BlockusBlocks.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_END_STONE.slab, 2, Blocks.END_STONE, BlockusBlocks.POLISHED_END_STONE.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_END_STONE.block, Blocks.END_STONE);

        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICKS, BlockusBlocks.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_STAIRS, BlockusBlocks.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_SLAB, 2, BlockusBlocks.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_WALL, BlockusBlocks.POLISHED_END_STONE.block);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Blocks.END_STONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CRACKED_END_STONE_BRICKS.asItem(), 0.1F, 200).criterion("has_end_stone_bricks", conditionsFromItem(Blocks.END_STONE_BRICKS)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICKS.block, Blocks.END_STONE, BlockusBlocks.POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICKS.stairs, Blocks.END_STONE, BlockusBlocks.POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS, BlockusBlocks.SMALL_END_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICKS.slab, 2, Blocks.END_STONE, BlockusBlocks.POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS, BlockusBlocks.SMALL_END_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICKS.wall, Blocks.END_STONE, BlockusBlocks.POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS, BlockusBlocks.SMALL_END_STONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_END_STONE_BRICKS, Blocks.END_STONE, BlockusBlocks.POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.END_STONE_PILLAR, Blocks.END_STONE, BlockusBlocks.POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HERRINGBONE_END_STONE_BRICKS, Blocks.END_STONE, BlockusBlocks.POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS);

        offerDecoratedRecipe(exporter, BlockusBlocks.PURPUR_DECORATED_END_STONE, Items.POPPED_CHORUS_FRUIT, Blocks.END_STONE_BRICKS);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_DECORATED_END_STONE, BlockusBlocks.PURPUR_DECORATED_END_STONE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.END_TILES.stairs, BlockusBlocks.END_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.END_TILES.slab, 2, BlockusBlocks.END_TILES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.END_TILES.wall, BlockusBlocks.END_TILES.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.END_TILES.block, 4).input('#', Blocks.END_STONE).input('X', Blocks.PURPUR_BLOCK).pattern("#X").pattern("X#").criterion(hasItem(Blocks.PURPUR_BLOCK), conditionsFromItem(Blocks.PURPUR_BLOCK)).offerTo(exporter);

        offerPressurePlateButtonRecipe(exporter, BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE, BlockusBlocks.POLISHED_END_STONE_BUTTON, BlockusBlocks.POLISHED_END_STONE.block);

        // Wood
        offerHangingSignRecipe(exporter, BlockusBlocks.WHITE_OAK.hanging_sign, BlockusBlocks.STRIPPED_WHITE_OAK_LOG);
        offerHangingSignRecipe(exporter, BlockusBlocks.RAW_BAMBOO.hanging_sign, Blocks.BAMBOO_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockusBlocks.CHARRED.hanging_sign, 2).group("hanging_sign").input('#', BlockusBlocks.CHARRED.planks).input('X', Items.CHAIN).pattern("X X").pattern("###").pattern("###").criterion("has_charred_planks", conditionsFromItem(BlockusBlocks.CHARRED.planks)).offerTo(exporter);

        offerPlanksRecipe(exporter, BlockusBlocks.WHITE_OAK.planks, BlockusItemTags.WHITE_OAK_LOGS, 4);

        offerBarkBlockRecipe(exporter, BlockusBlocks.WHITE_OAK_WOOD, BlockusBlocks.WHITE_OAK_LOG);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.RAW_BAMBOO.planks, 2).input(Blocks.BAMBOO_BLOCK).group("planks").criterion("has_log", conditionsFromItem(Blocks.BAMBOO_BLOCK)).offerTo(exporter);
        offerBoatsRecipe(exporter, BlockusEntities.WHITE_OAK_BOAT.getItem(), BlockusEntities.WHITE_OAK_BOAT.getChestItem(), BlockusBlocks.WHITE_OAK.planks);
        offerBoatsRecipe(exporter, BlockusEntities.RAW_BAMBOO_RAFT.getItem(), BlockusEntities.RAW_BAMBOO_RAFT.getChestItem(), BlockusBlocks.RAW_BAMBOO.planks);
        offerBoatsRecipe(exporter, BlockusEntities.CHARRED_BOAT.getItem(), BlockusEntities.CHARRED_BOAT.getChestItem(), BlockusBlocks.CHARRED.planks);
        CookingRecipeJsonBuilder.createSmelting(Ingredient.fromTag(BlockusItemTags.PLANKS_THAT_BURN), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CHARRED.planks, 0.1F, 200).criterion("has_planks", conditionsFromTag(BlockusItemTags.PLANKS_THAT_BURN)).offerTo(exporter);

        offerSmallLogsRecipe(exporter, BlockusBlocks.OAK_SMALL_LOGS, Blocks.OAK_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.SPRUCE_SMALL_LOGS, Blocks.SPRUCE_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.BIRCH_SMALL_LOGS, Blocks.BIRCH_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.JUNGLE_SMALL_LOGS, Blocks.JUNGLE_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.ACACIA_SMALL_LOGS, Blocks.ACACIA_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.DARK_OAK_SMALL_LOGS, Blocks.DARK_OAK_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.MANGROVE_SMALL_LOGS, Blocks.MANGROVE_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.CHERRY_SMALL_LOGS, Blocks.CHERRY_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.WARPED_SMALL_STEMS, Blocks.WARPED_STEM);
        offerSmallLogsRecipe(exporter, BlockusBlocks.CRIMSON_SMALL_STEMS, Blocks.CRIMSON_STEM);
        offerSmallLogsRecipe(exporter, BlockusBlocks.WHITE_OAK_SMALL_LOGS, BlockusBlocks.WHITE_OAK_LOG);

        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_OAK_PLANKS, Blocks.OAK_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_BIRCH_PLANKS, Blocks.BIRCH_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_SPRUCE_PLANKS, Blocks.SPRUCE_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_JUNGLE_PLANKS, Blocks.JUNGLE_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_ACACIA_PLANKS, Blocks.ACACIA_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_DARK_OAK_PLANKS, Blocks.DARK_OAK_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_MANGROVE_PLANKS, Blocks.MANGROVE_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_CHERRY_PLANKS, Blocks.CHERRY_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_WHITE_OAK_PLANKS, BlockusBlocks.WHITE_OAK.planks);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_BAMBOO_PLANKS, Blocks.BAMBOO_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_RAW_BAMBOO_PLANKS, BlockusBlocks.RAW_BAMBOO.planks);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_CRIMSON_PLANKS, Blocks.CRIMSON_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_WARPED_PLANKS, Blocks.WARPED_PLANKS);
        offerHerringBoneRecipe(exporter, BlockusBlocks.HERRINGBONE_CHARRED_PLANKS, BlockusBlocks.CHARRED.planks);
        CookingRecipeJsonBuilder.createSmelting(Ingredient.fromTag(BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.HERRINGBONE_CHARRED_PLANKS, 0.1F, 200).criterion("has_herringbone_planks", conditionsFromTag(BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN)).offerTo(exporter, getRecipeName(BlockusBlocks.HERRINGBONE_CHARRED_PLANKS) + "_from_smelting");

        // Small Hedges
        offerSmallHedgesRecipe(exporter, BlockusBlocks.OAK_SMALL_HEDGE, Blocks.OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.SPRUCE_SMALL_HEDGE, Blocks.SPRUCE_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.BIRCH_SMALL_HEDGE, Blocks.BIRCH_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.JUNGLE_SMALL_HEDGE, Blocks.JUNGLE_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.ACACIA_SMALL_HEDGE, Blocks.ACACIA_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.DARK_OAK_SMALL_HEDGE, Blocks.DARK_OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.MANGROVE_SMALL_HEDGE, Blocks.MANGROVE_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.CHERRY_SMALL_HEDGE, Blocks.CHERRY_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.WARPED_SMALL_HEDGE, Blocks.WARPED_WART_BLOCK);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.CRIMSON_SMALL_HEDGE, Blocks.NETHER_WART_BLOCK);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.WHITE_OAK_SMALL_HEDGE, BlockusBlocks.WHITE_OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.AZALEA_SMALL_HEDGE, Blocks.AZALEA_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.MOSS_SMALL_HEDGE, Blocks.MOSS_BLOCK);

        // Large Flower Pots
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.LARGE_FLOWER_POT).input('#', Items.BRICK).pattern("# #").pattern("###").pattern("###").criterion("has_flower_pot", conditionsFromItem(Items.FLOWER_POT)).offerTo(exporter);

        // Chocolate
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CHOCOLATE_BLOCK.block, 2).input('#', Items.COCOA_BEANS).pattern("##").pattern("##").criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHOCOLATE_BLOCK.stairs, BlockusBlocks.CHOCOLATE_BLOCK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHOCOLATE_BLOCK.slab, 2, BlockusBlocks.CHOCOLATE_BLOCK.block);

        offerPolishedStoneRecipe(exporter, BlockusBlocks.CHOCOLATE_BRICKS.block, BlockusBlocks.CHOCOLATE_BLOCK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHOCOLATE_BRICKS.block, BlockusBlocks.CHOCOLATE_BLOCK.block, BlockusBlocks.CHOCOLATE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHOCOLATE_BRICKS.stairs, BlockusBlocks.CHOCOLATE_BLOCK.block, BlockusBlocks.CHOCOLATE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHOCOLATE_BRICKS.slab, 2, BlockusBlocks.CHOCOLATE_BLOCK.block, BlockusBlocks.CHOCOLATE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHOCOLATE_BRICKS.wall, BlockusBlocks.CHOCOLATE_BLOCK.block, BlockusBlocks.CHOCOLATE_BRICKS.block);

        offerPolishedStoneRecipe(exporter, BlockusBlocks.CHOCOLATE_SQUARES, BlockusBlocks.CHOCOLATE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHOCOLATE_SQUARES, BlockusBlocks.CHOCOLATE_BLOCK.block, BlockusBlocks.CHOCOLATE_BRICKS.block);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockusBlocks.CHOCOLATE_TABLET, 3).input('#', BlockusBlocks.CHOCOLATE_SQUARES).pattern("##").criterion(hasItem(BlockusBlocks.CHOCOLATE_SQUARES), conditionsFromItem(BlockusBlocks.CHOCOLATE_SQUARES)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHOCOLATE_TABLET, 2, BlockusBlocks.CHOCOLATE_BLOCK.block, BlockusBlocks.CHOCOLATE_BRICKS.block, BlockusBlocks.CHOCOLATE_SQUARES);

        // Food Blocks
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.SWEET_BERRIES, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.SWEET_BERRIES_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.GLOW_BERRIES, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.GLOW_BERRIES_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.SALMON, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.SALMON_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.PUFFERFISH, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.PUFFERFISH_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.TROPICAL_FISH, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.TROPICAL_FISH_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.COD, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.COD_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.COOKIE, RecipeCategory.FOOD, BlockusBlocks.COOKIE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.CHORUS_FRUIT, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CHORUS_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.POTATO, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.POTATO_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.APPLE, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.APPLE_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.GOLDEN_APPLE, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.GOLDEN_APPLE_CRATE);
        createEnclosedRecipe2(BlockusBlocks.GOLDEN_APPLE_CRATE, Ingredient.ofItems(Blocks.GOLD_BLOCK), BlockusBlocks.APPLE_CRATE).criterion(hasItem(Items.GOLDEN_APPLE), conditionsFromItem(Items.GOLDEN_APPLE)).offerTo(exporter, convertBetween(BlockusBlocks.GOLDEN_APPLE_CRATE, BlockusBlocks.APPLE_CRATE));
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.BEETROOT, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.BEETROOT_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.CARROT, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CARROT_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.GOLDEN_CARROT, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.GOLDEN_CARROT_CRATE);
        createEnclosedRecipe2(BlockusBlocks.GOLDEN_CARROT_CRATE, Ingredient.ofItems(Items.GOLD_INGOT), BlockusBlocks.CARROT_CRATE).criterion(hasItem(Items.GOLDEN_CARROT), conditionsFromItem(Items.GOLDEN_CARROT)).offerTo(exporter, convertBetween(BlockusBlocks.GOLDEN_CARROT_CRATE, BlockusBlocks.CARROT_CRATE));
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.BREAD, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.BREAD_BOX);


        // Rainbow
        offerShapelessRecipe(exporter, BlockusItems.RAINBOW_PETAL, BlockusBlocks.RAINBOW_ROSE, "rainbow_petal", 2);
        offerShapelessRecipe(exporter, BlockusItems.RAINBOW_PETAL, BlockusBlocks.RAINBOW_BLOCK, "rainbow_petal", 4);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.RAINBOW_BLOCK).input('#', BlockusItems.RAINBOW_PETAL).pattern("##").pattern("##").criterion(hasItem(BlockusItems.RAINBOW_PETAL), conditionsFromItem(BlockusItems.RAINBOW_PETAL)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICKS.block, BlockusBlocks.RAINBOW_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICKS.stairs, BlockusBlocks.RAINBOW_BLOCK, BlockusBlocks.RAINBOW_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICKS.slab, 2, BlockusBlocks.RAINBOW_BLOCK, BlockusBlocks.RAINBOW_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICKS.wall, BlockusBlocks.RAINBOW_BLOCK, BlockusBlocks.RAINBOW_BRICKS.block);

        offerPolishedStoneRecipe(exporter, BlockusBlocks.RAINBOW_BRICKS.block, BlockusBlocks.RAINBOW_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.RAINBOW_GLOWSTONE, 4).input('S', BlockusItems.RAINBOW_PETAL).input('#', Blocks.GLOWSTONE).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(BlockusItems.RAINBOW_PETAL), conditionsFromItem(BlockusItems.RAINBOW_PETAL)).offerTo(exporter);


        // Colored Stone Bricks
        offerStainedStoneBricksRecipe(exporter, Items.WHITE_DYE, BlockusBlocks.WHITE_STONE_BRICKS.block, BlockusBlocks.WHITE_STONE_BRICKS.stairs, BlockusBlocks.WHITE_STONE_BRICKS.slab, BlockusBlocks.WHITE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.ORANGE_DYE, BlockusBlocks.ORANGE_STONE_BRICKS.block, BlockusBlocks.ORANGE_STONE_BRICKS.stairs, BlockusBlocks.ORANGE_STONE_BRICKS.slab, BlockusBlocks.ORANGE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.MAGENTA_DYE, BlockusBlocks.MAGENTA_STONE_BRICKS.block, BlockusBlocks.MAGENTA_STONE_BRICKS.stairs, BlockusBlocks.MAGENTA_STONE_BRICKS.slab, BlockusBlocks.MAGENTA_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.LIGHT_BLUE_DYE, BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.block, BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.stairs, BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.slab, BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.YELLOW_DYE, BlockusBlocks.YELLOW_STONE_BRICKS.block, BlockusBlocks.YELLOW_STONE_BRICKS.stairs, BlockusBlocks.YELLOW_STONE_BRICKS.slab, BlockusBlocks.YELLOW_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.LIME_DYE, BlockusBlocks.LIME_STONE_BRICKS.block, BlockusBlocks.LIME_STONE_BRICKS.stairs, BlockusBlocks.LIME_STONE_BRICKS.slab, BlockusBlocks.LIME_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.PINK_DYE, BlockusBlocks.PINK_STONE_BRICKS.block, BlockusBlocks.PINK_STONE_BRICKS.stairs, BlockusBlocks.PINK_STONE_BRICKS.slab, BlockusBlocks.PINK_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.GRAY_DYE, BlockusBlocks.GRAY_STONE_BRICKS.block, BlockusBlocks.GRAY_STONE_BRICKS.stairs, BlockusBlocks.GRAY_STONE_BRICKS.slab, BlockusBlocks.GRAY_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.CYAN_DYE, BlockusBlocks.CYAN_STONE_BRICKS.block, BlockusBlocks.CYAN_STONE_BRICKS.stairs, BlockusBlocks.CYAN_STONE_BRICKS.slab, BlockusBlocks.CYAN_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.PURPLE_DYE, BlockusBlocks.PURPLE_STONE_BRICKS.block, BlockusBlocks.PURPLE_STONE_BRICKS.stairs, BlockusBlocks.PURPLE_STONE_BRICKS.slab, BlockusBlocks.PURPLE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.BLUE_DYE, BlockusBlocks.BLUE_STONE_BRICKS.block, BlockusBlocks.BLUE_STONE_BRICKS.stairs, BlockusBlocks.BLUE_STONE_BRICKS.slab, BlockusBlocks.BLUE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.BROWN_DYE, BlockusBlocks.BROWN_STONE_BRICKS.block, BlockusBlocks.BROWN_STONE_BRICKS.stairs, BlockusBlocks.BROWN_STONE_BRICKS.slab, BlockusBlocks.BROWN_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.GREEN_DYE, BlockusBlocks.GREEN_STONE_BRICKS.block, BlockusBlocks.GREEN_STONE_BRICKS.stairs, BlockusBlocks.GREEN_STONE_BRICKS.slab, BlockusBlocks.GREEN_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.RED_DYE, BlockusBlocks.RED_STONE_BRICKS.block, BlockusBlocks.RED_STONE_BRICKS.stairs, BlockusBlocks.RED_STONE_BRICKS.slab, BlockusBlocks.RED_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.BLACK_DYE, BlockusBlocks.BLACK_STONE_BRICKS.block, BlockusBlocks.BLACK_STONE_BRICKS.stairs, BlockusBlocks.BLACK_STONE_BRICKS.slab, BlockusBlocks.BLACK_STONE_BRICKS.wall);

        // Concrete

        // Redstone Lamps
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.REDSTONE_LAMP_LIT).input(Blocks.REDSTONE_LAMP).input(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.WHITE_REDSTONE_LAMP, Items.WHITE_DYE, BlockusBlocks.WHITE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.ORANGE_REDSTONE_LAMP, Items.ORANGE_DYE, BlockusBlocks.ORANGE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.MAGENTA_REDSTONE_LAMP, Items.MAGENTA_DYE, BlockusBlocks.MAGENTA_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP, Items.LIGHT_BLUE_DYE, BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.YELLOW_REDSTONE_LAMP, Items.YELLOW_DYE, BlockusBlocks.YELLOW_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.LIME_REDSTONE_LAMP, Items.LIME_DYE, BlockusBlocks.LIME_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.PINK_REDSTONE_LAMP, Items.PINK_DYE, BlockusBlocks.PINK_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP, Items.LIGHT_GRAY_DYE, BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.GRAY_REDSTONE_LAMP, Items.GRAY_DYE, BlockusBlocks.GRAY_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.CYAN_REDSTONE_LAMP, Items.CYAN_DYE, BlockusBlocks.CYAN_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.PURPLE_REDSTONE_LAMP, Items.PURPLE_DYE, BlockusBlocks.PURPLE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.BLUE_REDSTONE_LAMP, Items.BLUE_DYE, BlockusBlocks.BLUE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.BROWN_REDSTONE_LAMP, Items.BROWN_DYE, BlockusBlocks.BROWN_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.GREEN_REDSTONE_LAMP, Items.GREEN_DYE, BlockusBlocks.GREEN_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.RED_REDSTONE_LAMP, Items.RED_DYE, BlockusBlocks.RED_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BlockusBlocks.RAINBOW_LAMP, BlockusItems.RAINBOW_PETAL, BlockusBlocks.RAINBOW_LAMP_LIT);

        // Neon Blocks
        offerNeonRecipe(exporter, BlockusBlocks.WHITE_NEON, Items.WHITE_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.ORANGE_NEON, Items.ORANGE_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.MAGENTA_NEON, Items.MAGENTA_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.LIGHT_BLUE_NEON, Items.LIGHT_BLUE_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.YELLOW_NEON, Items.YELLOW_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.LIME_NEON, Items.LIME_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.PINK_NEON, Items.PINK_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.LIGHT_GRAY_NEON, Items.LIGHT_GRAY_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.GRAY_NEON, Items.GRAY_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.CYAN_NEON, Items.CYAN_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.PURPLE_NEON, Items.PURPLE_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.BLUE_NEON, Items.BLUE_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.BROWN_NEON, Items.BROWN_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.GREEN_NEON, Items.GREEN_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.RED_NEON, Items.RED_DYE);
        offerNeonRecipe(exporter, BlockusBlocks.BLACK_NEON, Items.BLACK_DYE);

        // Futurneo Blocks
        offerFuturneoRecipe(exporter, BlockusBlocks.WHITE_FUTURNEO_BLOCK, Blocks.WHITE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.ORANGE_FUTURNEO_BLOCK, Blocks.ORANGE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.MAGENTA_FUTURNEO_BLOCK, Blocks.MAGENTA_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.LIGHT_BLUE_FUTURNEO_BLOCK, Blocks.LIGHT_BLUE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.YELLOW_FUTURNEO_BLOCK, Blocks.YELLOW_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.LIME_FUTURNEO_BLOCK, Blocks.LIME_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.PINK_FUTURNEO_BLOCK, Blocks.PINK_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.LIGHT_GRAY_FUTURNEO_BLOCK, Blocks.LIGHT_GRAY_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.GRAY_FUTURNEO_BLOCK, Blocks.GRAY_STAINED_GLASS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK).input('A', Items.WHITE_DYE).input('B', Blocks.GRAY_STAINED_GLASS).input('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").criterion(hasItem(Blocks.GRAY_STAINED_GLASS), conditionsFromItem(Blocks.GRAY_STAINED_GLASS)).offerTo(exporter);
        offerFuturneoRecipe(exporter, BlockusBlocks.CYAN_FUTURNEO_BLOCK, Blocks.CYAN_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.PURPLE_FUTURNEO_BLOCK, Blocks.PURPLE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.BLUE_FUTURNEO_BLOCK, Blocks.BLUE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.BROWN_FUTURNEO_BLOCK, Blocks.BROWN_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.GREEN_FUTURNEO_BLOCK, Blocks.GREEN_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.RED_FUTURNEO_BLOCK, Blocks.RED_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.BLACK_FUTURNEO_BLOCK, Blocks.BLACK_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.RAINBOW_FUTURNEO_BLOCK, BlockusBlocks.RAINBOW_GLASS);

        // Asphalt
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ASPHALT.block, 8).input('X', Blocks.GRAVEL).input('#', ItemTags.COALS).pattern("XXX").pattern("X#X").pattern("XXX").group("asphalt").criterion(hasItem(Blocks.GRAVEL), conditionsFromItem(Blocks.GRAVEL)).offerTo(exporter);
        createEnclosedRecipe(BlockusBlocks.RAINBOW_ASPHALT, Ingredient.ofItems(BlockusBlocks.ASPHALT.block), BlockusItems.RAINBOW_PETAL).criterion(hasItem(BlockusBlocks.ASPHALT.block), conditionsFromItem(BlockusBlocks.ASPHALT.block)).offerTo(exporter);

        offerAsphaltRecipe(exporter, Items.WHITE_DYE, BlockusBlocks.WHITE_ASPHALT.block, BlockusBlocks.WHITE_ASPHALT.stairs, BlockusBlocks.WHITE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.ORANGE_DYE, BlockusBlocks.ORANGE_ASPHALT.block, BlockusBlocks.ORANGE_ASPHALT.stairs, BlockusBlocks.ORANGE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.MAGENTA_DYE, BlockusBlocks.MAGENTA_ASPHALT.block, BlockusBlocks.MAGENTA_ASPHALT.stairs, BlockusBlocks.MAGENTA_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.LIGHT_BLUE_DYE, BlockusBlocks.LIGHT_BLUE_ASPHALT.block, BlockusBlocks.LIGHT_BLUE_ASPHALT.stairs, BlockusBlocks.LIGHT_BLUE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.YELLOW_DYE, BlockusBlocks.YELLOW_ASPHALT.block, BlockusBlocks.YELLOW_ASPHALT.stairs, BlockusBlocks.YELLOW_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.LIME_DYE, BlockusBlocks.LIME_ASPHALT.block, BlockusBlocks.LIME_ASPHALT.stairs, BlockusBlocks.LIME_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.PINK_DYE, BlockusBlocks.PINK_ASPHALT.block, BlockusBlocks.PINK_ASPHALT.stairs, BlockusBlocks.PINK_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.LIGHT_GRAY_DYE, BlockusBlocks.LIGHT_GRAY_ASPHALT.block, BlockusBlocks.LIGHT_GRAY_ASPHALT.stairs, BlockusBlocks.LIGHT_GRAY_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.GRAY_DYE, BlockusBlocks.GRAY_ASPHALT.block, BlockusBlocks.GRAY_ASPHALT.stairs, BlockusBlocks.GRAY_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.CYAN_DYE, BlockusBlocks.CYAN_ASPHALT.block, BlockusBlocks.CYAN_ASPHALT.stairs, BlockusBlocks.CYAN_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.PURPLE_DYE, BlockusBlocks.PURPLE_ASPHALT.block, BlockusBlocks.PURPLE_ASPHALT.stairs, BlockusBlocks.PURPLE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.BLUE_DYE, BlockusBlocks.BLUE_ASPHALT.block, BlockusBlocks.BLUE_ASPHALT.stairs, BlockusBlocks.BLUE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.BROWN_DYE, BlockusBlocks.BROWN_ASPHALT.block, BlockusBlocks.BROWN_ASPHALT.stairs, BlockusBlocks.BROWN_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.GREEN_DYE, BlockusBlocks.GREEN_ASPHALT.block, BlockusBlocks.GREEN_ASPHALT.stairs, BlockusBlocks.GREEN_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.RED_DYE, BlockusBlocks.RED_ASPHALT.block, BlockusBlocks.RED_ASPHALT.stairs, BlockusBlocks.RED_ASPHALT.slab);

        // Shingles
        offerStonecuttingRecipe(exporter, BlockusBlocks.SHINGLES.block, Blocks.TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SHINGLES.stairs, Blocks.TERRACOTTA, BlockusBlocks.SHINGLES.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SHINGLES.slab, 2, Blocks.TERRACOTTA, BlockusBlocks.SHINGLES.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.SHINGLES.block, Blocks.TERRACOTTA);

        offerShinglesRecipe(exporter, Items.WHITE_DYE, BlockusBlocks.WHITE_SHINGLES.block, BlockusBlocks.WHITE_SHINGLES.stairs, BlockusBlocks.WHITE_SHINGLES.slab, Blocks.WHITE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.ORANGE_DYE, BlockusBlocks.ORANGE_SHINGLES.block, BlockusBlocks.ORANGE_SHINGLES.stairs, BlockusBlocks.ORANGE_SHINGLES.slab, Blocks.ORANGE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.MAGENTA_DYE, BlockusBlocks.MAGENTA_SHINGLES.block, BlockusBlocks.MAGENTA_SHINGLES.stairs, BlockusBlocks.MAGENTA_SHINGLES.slab, Blocks.MAGENTA_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIGHT_BLUE_DYE, BlockusBlocks.LIGHT_BLUE_SHINGLES.block, BlockusBlocks.LIGHT_BLUE_SHINGLES.stairs, BlockusBlocks.LIGHT_BLUE_SHINGLES.slab, Blocks.LIGHT_BLUE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.YELLOW_DYE, BlockusBlocks.YELLOW_SHINGLES.block, BlockusBlocks.YELLOW_SHINGLES.stairs, BlockusBlocks.YELLOW_SHINGLES.slab, Blocks.YELLOW_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIME_DYE, BlockusBlocks.LIME_SHINGLES.block, BlockusBlocks.LIME_SHINGLES.stairs, BlockusBlocks.LIME_SHINGLES.slab, Blocks.LIME_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.PINK_DYE, BlockusBlocks.PINK_SHINGLES.block, BlockusBlocks.PINK_SHINGLES.stairs, BlockusBlocks.PINK_SHINGLES.slab, Blocks.PINK_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIGHT_GRAY_DYE, BlockusBlocks.LIGHT_GRAY_SHINGLES.block, BlockusBlocks.LIGHT_GRAY_SHINGLES.stairs, BlockusBlocks.LIGHT_GRAY_SHINGLES.slab, Blocks.LIGHT_GRAY_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.GRAY_DYE, BlockusBlocks.GRAY_SHINGLES.block, BlockusBlocks.GRAY_SHINGLES.stairs, BlockusBlocks.GRAY_SHINGLES.slab, Blocks.GRAY_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.CYAN_DYE, BlockusBlocks.CYAN_SHINGLES.block, BlockusBlocks.CYAN_SHINGLES.stairs, BlockusBlocks.CYAN_SHINGLES.slab, Blocks.CYAN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.PURPLE_DYE, BlockusBlocks.PURPLE_SHINGLES.block, BlockusBlocks.PURPLE_SHINGLES.stairs, BlockusBlocks.PURPLE_SHINGLES.slab, Blocks.PURPLE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BLUE_DYE, BlockusBlocks.BLUE_SHINGLES.block, BlockusBlocks.BLUE_SHINGLES.stairs, BlockusBlocks.BLUE_SHINGLES.slab, Blocks.BLUE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BROWN_DYE, BlockusBlocks.BROWN_SHINGLES.block, BlockusBlocks.BROWN_SHINGLES.stairs, BlockusBlocks.BROWN_SHINGLES.slab, Blocks.BROWN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.GREEN_DYE, BlockusBlocks.GREEN_SHINGLES.block, BlockusBlocks.GREEN_SHINGLES.stairs, BlockusBlocks.GREEN_SHINGLES.slab, Blocks.GREEN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.RED_DYE, BlockusBlocks.RED_SHINGLES.block, BlockusBlocks.RED_SHINGLES.stairs, BlockusBlocks.RED_SHINGLES.slab, Blocks.RED_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BLACK_DYE, BlockusBlocks.BLACK_SHINGLES.block, BlockusBlocks.BLACK_SHINGLES.stairs, BlockusBlocks.BLACK_SHINGLES.slab, Blocks.BLACK_TERRACOTTA);

        // Glass - Beveled Glass
        offerPolishedStoneRecipe(exporter, BlockusBlocks.TINTED_BEVELED_GLASS, Blocks.TINTED_GLASS);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.BEVELED_GLASS, Blocks.GLASS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.BEVELED_GLASS_PANE, 16).input('#', BlockusBlocks.BEVELED_GLASS).pattern("###").pattern("###").group("beveled_glass_pane").criterion("has_beveled_glass", conditionsFromItem(BlockusBlocks.BEVELED_GLASS_PANE)).offerTo(exporter);

        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.WHITE_BEVELED_GLASS, BlockusBlocks.WHITE_BEVELED_GLASS_PANE, Blocks.WHITE_STAINED_GLASS, Items.WHITE_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.ORANGE_BEVELED_GLASS, BlockusBlocks.ORANGE_BEVELED_GLASS_PANE, Blocks.ORANGE_STAINED_GLASS, Items.ORANGE_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.MAGENTA_BEVELED_GLASS, BlockusBlocks.MAGENTA_BEVELED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS, Items.MAGENTA_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS, BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS, Items.LIGHT_BLUE_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.YELLOW_BEVELED_GLASS, BlockusBlocks.YELLOW_BEVELED_GLASS_PANE, Blocks.YELLOW_STAINED_GLASS, Items.YELLOW_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.LIME_BEVELED_GLASS, BlockusBlocks.LIME_BEVELED_GLASS_PANE, Blocks.LIME_STAINED_GLASS, Items.LIME_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.PINK_BEVELED_GLASS, BlockusBlocks.PINK_BEVELED_GLASS_PANE, Blocks.PINK_STAINED_GLASS, Items.PINK_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS, BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS, Items.LIGHT_GRAY_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.GRAY_BEVELED_GLASS, BlockusBlocks.GRAY_BEVELED_GLASS_PANE, Blocks.GRAY_STAINED_GLASS, Items.GRAY_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.CYAN_BEVELED_GLASS, BlockusBlocks.CYAN_BEVELED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS, Items.CYAN_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.PURPLE_BEVELED_GLASS, BlockusBlocks.PURPLE_BEVELED_GLASS_PANE, Blocks.PURPLE_STAINED_GLASS, Items.PURPLE_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.BLUE_BEVELED_GLASS, BlockusBlocks.BLUE_BEVELED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS, Items.BLUE_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.BROWN_BEVELED_GLASS, BlockusBlocks.BROWN_BEVELED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS, Items.BROWN_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.GREEN_BEVELED_GLASS, BlockusBlocks.GREEN_BEVELED_GLASS_PANE, Blocks.GREEN_STAINED_GLASS, Items.GREEN_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.RED_BEVELED_GLASS, BlockusBlocks.RED_BEVELED_GLASS_PANE, Blocks.RED_STAINED_GLASS, Items.RED_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.BLACK_BEVELED_GLASS, BlockusBlocks.BLACK_BEVELED_GLASS_PANE, Blocks.BLACK_STAINED_GLASS, Items.BLACK_DYE);
        offerStainedBeveledGlassRecipe(exporter, BlockusBlocks.RAINBOW_BEVELED_GLASS, BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE, BlockusBlocks.RAINBOW_GLASS, BlockusItems.RAINBOW_PETAL);
        createEnclosedRecipe(BlockusBlocks.RAINBOW_GLASS, Ingredient.ofItems(Blocks.GLASS), BlockusItems.RAINBOW_PETAL).criterion(hasItem(BlockusItems.RAINBOW_PETAL), conditionsFromItem(BlockusItems.RAINBOW_PETAL)).offerTo(exporter);
        createEnclosedRecipe(BlockusBlocks.RAINBOW_GLASS_PANE, Ingredient.ofItems(Blocks.GLASS_PANE), BlockusItems.RAINBOW_PETAL).criterion(hasItem(BlockusItems.RAINBOW_PETAL), conditionsFromItem(BlockusItems.RAINBOW_PETAL)).offerTo(exporter, getRecipeName(BlockusBlocks.RAINBOW_GLASS_PANE) + "_alt");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.RAINBOW_GLASS_PANE, 16).input('#', BlockusBlocks.RAINBOW_GLASS).pattern("###").pattern("###").criterion(hasItem(BlockusBlocks.RAINBOW_GLASS), conditionsFromItem(BlockusBlocks.RAINBOW_GLASS)).offerTo(exporter);

        // Colored Tiles
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.WHITE_COLORED_TILES, Blocks.WHITE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.ORANGE_COLORED_TILES, Blocks.ORANGE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.MAGENTA_COLORED_TILES, Blocks.MAGENTA_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.LIGHT_BLUE_COLORED_TILES, Blocks.LIGHT_BLUE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.YELLOW_COLORED_TILES, Blocks.YELLOW_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.LIME_COLORED_TILES, Blocks.LIME_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.PINK_COLORED_TILES, Blocks.PINK_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.LIGHT_GRAY_COLORED_TILES, Blocks.LIGHT_GRAY_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.GRAY_COLORED_TILES, Blocks.GRAY_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.CYAN_COLORED_TILES, Blocks.CYAN_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.PURPLE_COLORED_TILES, Blocks.PURPLE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.BLUE_COLORED_TILES, Blocks.BLUE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.BROWN_COLORED_TILES, Blocks.BROWN_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.GREEN_COLORED_TILES, Blocks.GREEN_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.RED_COLORED_TILES, Blocks.RED_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.BLACK_COLORED_TILES, Blocks.BLACK_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.RAINBOW_COLORED_TILES, BlockusBlocks.RAINBOW_BLOCK);

        // Glazed Terracotta Pillars
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_GLAZED_TERRACOTTA_PILLAR, Blocks.WHITE_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_GLAZED_TERRACOTTA_PILLAR, Blocks.ORANGE_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_GLAZED_TERRACOTTA_PILLAR, Blocks.MAGENTA_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_GLAZED_TERRACOTTA_PILLAR, Blocks.YELLOW_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_GLAZED_TERRACOTTA_PILLAR, Blocks.LIME_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_GLAZED_TERRACOTTA_PILLAR, Blocks.PINK_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_GLAZED_TERRACOTTA_PILLAR, Blocks.GRAY_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_GLAZED_TERRACOTTA_PILLAR, Blocks.CYAN_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_GLAZED_TERRACOTTA_PILLAR, Blocks.PURPLE_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_GLAZED_TERRACOTTA_PILLAR, Blocks.BLUE_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_GLAZED_TERRACOTTA_PILLAR, Blocks.BROWN_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_GLAZED_TERRACOTTA_PILLAR, Blocks.GREEN_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_GLAZED_TERRACOTTA_PILLAR, Blocks.RED_GLAZED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_GLAZED_TERRACOTTA_PILLAR, Blocks.BLACK_GLAZED_TERRACOTTA);

        // Thatch
        offerPolishedStoneRecipe(exporter, BlockusBlocks.THATCH.block, Items.WHEAT);

        // Paper

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.PAPER_BLOCK);
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(BlockusBlocks.PAPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.BURNT_PAPER_BLOCK.asItem(), 0.1F, 200).criterion("has_paper_block", conditionsFromItem(BlockusBlocks.PAPER_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.FRAMED_PAPER_BLOCK, 4).input('X', Items.PAPER).input('#', Items.STICK).pattern("###").pattern("XXX").pattern("###").criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER)).offerTo(exporter);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.PAPER_WALL, BlockusBlocks.FRAMED_PAPER_BLOCK);

        createEnclosedRecipe2(BlockusBlocks.PAPER_LAMP, Ingredient.ofItems(Items.PAPER), Items.TORCH).criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER)).offerTo(exporter);
        offerShapelessRecipe2(exporter, Items.GUNPOWDER, BlockusBlocks.BURNT_PAPER_BLOCK, 2);
        offerDoorTrapdoorRecipe(exporter, BlockusBlocks.PAPER_DOOR, BlockusBlocks.PAPER_TRAPDOOR, BlockusBlocks.PAPER_WALL);


        // Plating
        offerStonecuttingRecipe(exporter, BlockusBlocks.IRON_PLATING.stairs, BlockusBlocks.IRON_PLATING.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.IRON_PLATING.slab, 2, BlockusBlocks.IRON_PLATING.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.IRON_PLATING.block, 24).input('X', Items.IRON_INGOT).pattern("XXX").pattern("X X").pattern("XXX").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GOLD_PLATING.stairs, BlockusBlocks.GOLD_PLATING.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GOLD_PLATING.slab, 2, BlockusBlocks.GOLD_PLATING.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.GOLD_PLATING.block, 24).input('X', Items.GOLD_INGOT).pattern("XXX").pattern("X X").pattern("XXX").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);

        // Gates - chains - bars
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.IRON_GATE, 3).input('X', Blocks.IRON_BARS).input('#', Items.IRON_NUGGET).pattern("##").pattern("XX").pattern("XX").criterion(hasItem(Blocks.IRON_BARS), conditionsFromItem(Blocks.IRON_BARS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.GOLDEN_GATE, 3).input('X', BlockusBlocks.GOLDEN_BARS).input('#', Items.GOLD_NUGGET).pattern("##").pattern("XX").pattern("XX").criterion(hasItem(BlockusBlocks.GOLDEN_BARS), conditionsFromItem(BlockusBlocks.GOLDEN_BARS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.GOLDEN_BARS, 16).input('#', Items.GOLD_INGOT).pattern("###").pattern("###").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.GOLDEN_CHAIN).input('X', Items.GOLD_INGOT).input('#', Items.GOLD_NUGGET).pattern("#").pattern("X").pattern("#").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);

        // Lantern Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.LANTERN_BLOCK).input('X', Blocks.LANTERN).input('#', Items.IRON_NUGGET).pattern(" # ").pattern("#X#").pattern(" # ").criterion(hasItem(Blocks.LANTERN), conditionsFromItem(Blocks.LANTERN)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.SOUL_LANTERN_BLOCK).input('X', Blocks.SOUL_LANTERN).input('#', Items.IRON_NUGGET).pattern(" # ").pattern("#X#").pattern(" # ").criterion(hasItem(Blocks.SOUL_LANTERN), conditionsFromItem(Blocks.SOUL_LANTERN)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.REDSTONE_LANTERN_BLOCK).input('X', BlockusBlocks.REDSTONE_LANTERN).input('#', Items.IRON_NUGGET).pattern(" # ").pattern("#X#").pattern(" # ").criterion(hasItem(BlockusBlocks.REDSTONE_LANTERN), conditionsFromItem(BlockusBlocks.REDSTONE_LANTERN)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.REDSTONE_LANTERN).input('#', Items.REDSTONE_TORCH).input('X', Items.IRON_NUGGET).pattern("XXX").pattern("X#X").pattern("XXX").criterion("has_redstone_torch", conditionsFromItem(Items.REDSTONE_TORCH)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.SOUL_O_LANTERN).input('X', Blocks.CARVED_PUMPKIN).input('#', Blocks.SOUL_TORCH).pattern("X").pattern("#").criterion(hasItem(Blocks.CARVED_PUMPKIN), conditionsFromItem(Blocks.CARVED_PUMPKIN)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.REDSTONE_O_LANTERN).input('X', Blocks.CARVED_PUMPKIN).input('#', Blocks.REDSTONE_TORCH).pattern("X").pattern("#").criterion(hasItem(Blocks.CARVED_PUMPKIN), conditionsFromItem(Blocks.CARVED_PUMPKIN)).criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH)).offerTo(exporter);

        // Barriers
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ROAD_BARRIER, 5).input('#', Items.IRON_INGOT).input('X', Blocks.STONE).pattern("X#X").pattern("X#X").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CAUTION_BARRIER).input(BlockusBlocks.CAUTION_BLOCK).input(BlockusBlocks.ROAD_BARRIER).criterion(hasItem(BlockusBlocks.CAUTION_BLOCK), conditionsFromItem(BlockusBlocks.CAUTION_BLOCK)).criterion(hasItem(BlockusBlocks.ROAD_BARRIER), conditionsFromItem(BlockusBlocks.ROAD_BARRIER)).offerTo(exporter);

        // Netherite Blocks
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERITE_SLAB, 2, Blocks.NETHERITE_BLOCK);

        // Other

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CHARCOAL_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.SUGAR_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ENDER_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.ROTTEN_FLESH_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.MEMBRANE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.NETHER_STAR, RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.NETHER_STAR_BLOCK);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.WOODEN_FRAME, Items.STICK);

        createEnclosedRecipe2(BlockusBlocks.REDSTONE_SAND, Ingredient.ofItems(Items.REDSTONE), Items.SAND).criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.REDSTONE, 8).input(BlockusBlocks.REDSTONE_SAND).criterion(hasItem(BlockusBlocks.REDSTONE_SAND), conditionsFromItem(BlockusBlocks.REDSTONE_SAND)).offerTo(exporter, convertBetween(Items.REDSTONE, BlockusBlocks.REDSTONE_SAND));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.LOVE_BLOCK).input('M', Items.MAGENTA_DYE).input('R', Items.RED_DYE).pattern("RMR").pattern("RRR").pattern("MRM").criterion(hasItem(Items.MAGENTA_DYE), conditionsFromItem(Items.MAGENTA_DYE)).criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.WEIGHT_STORAGE_CUBE).input(Blocks.STONE).input(Items.IRON_NUGGET).criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.COMPANION_CUBE).input(BlockusBlocks.WEIGHT_STORAGE_CUBE).input(Items.POPPY).criterion(hasItem(BlockusBlocks.WEIGHT_STORAGE_CUBE), conditionsFromItem(BlockusBlocks.WEIGHT_STORAGE_CUBE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.CAUTION_BLOCK, 6).input('A', Blocks.STONE).input('B', Items.BLACK_DYE).input('C', Items.YELLOW_DYE).pattern(" C ").pattern("BAB").pattern(" C ").criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE)).criterion(hasItem(Items.YELLOW_DYE), conditionsFromItem(Items.YELLOW_DYE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.STARS_BLOCK, 3).input('#', Items.ENDER_PEARL).input('X', Items.CHORUS_FRUIT).pattern("X#X").pattern("###").pattern("X#X").criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT)).offerTo(exporter);

        // Legacy
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_BRICKS, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_FIRST_COBBLESTONE, Blocks.COBBLESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_COBBLESTONE, Blocks.COBBLESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_GRAVEL, Blocks.GRAVEL);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_IRON_BLOCK, Blocks.IRON_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_GOLD_BLOCK, Blocks.GOLD_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, Blocks.GOLD_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, BlockusBlocks.LEGACY_GOLD_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_COAL_BLOCK, Blocks.COAL_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_DIAMOND_BLOCK, Blocks.DIAMOND_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_LAPIS_BLOCK, Blocks.LAPIS_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_SPONGE, Blocks.SPONGE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_CRYING_OBSIDIAN, Blocks.CRYING_OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_GLOWSTONE, Blocks.GLOWSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_GLOWING_OBSIDIAN, BlockusBlocks.GLOWING_OBSIDIAN);
        offerShapelessRecipe(exporter, Items.IRON_INGOT, BlockusBlocks.LEGACY_IRON_BLOCK, "iron_ingot", 9);
        offerShapelessRecipe(exporter, Items.GOLD_INGOT, BlockusBlocks.LEGACY_GOLD_BLOCK, "gold_ingot", 9);
        offerShapelessRecipe(exporter, Items.GOLD_INGOT, BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, "gold_ingot", 9);
        offerShapelessRecipe(exporter, Items.COAL, BlockusBlocks.LEGACY_COAL_BLOCK, "coal", 9);
        offerShapelessRecipe(exporter, Items.DIAMOND, BlockusBlocks.LEGACY_DIAMOND_BLOCK, "diamond", 9);
        offerShapelessRecipe(exporter, Items.LAPIS_LAZULI, BlockusBlocks.LEGACY_LAPIS_BLOCK, "lapis_lazuli", 9);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.LEGACY_STONECUTTER).input('#', Blocks.COBBLESTONE).pattern("##").pattern("##").criterion(hasItem(Blocks.STONECUTTER), conditionsFromItem(Blocks.STONECUTTER)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.LEGACY_NETHER_REACTOR_CORE).input('#', Items.DIAMOND).input('X', Items.IRON_INGOT).pattern("X#X").pattern("X#X").pattern("X#X").criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.LEGACY_SAPLING).input('#', Blocks.OAK_SAPLING).pattern("##").pattern("##").criterion(hasItem(Blocks.OAK_SAPLING), conditionsFromItem(Blocks.OAK_SAPLING)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK, 4).input('#', BlockusBlocks.LEGACY_GRASS_BLOCK).pattern("##").pattern("##").criterion(hasItem(BlockusBlocks.LEGACY_GRASS_BLOCK), conditionsFromItem(BlockusBlocks.LEGACY_GRASS_BLOCK)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockusBlocks.LEGACY_PLANKS, 4).input(BlockusBlocks.LEGACY_LOG).group("planks").criterion("has_logs", conditionsFromItem(BlockusBlocks.LEGACY_LOG)).offerTo(exporter);

    }

    public static void offerPolishedStoneRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static CraftingRecipeJsonBuilder createCondensingRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(category, output, 4).input('S', input).pattern("SS").pattern("SS");
    }

    public static void offerShapelessRecipe2(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input, int outputCount) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, outputCount).input(input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerSturdyRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input1, ItemConvertible input2) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 2).input('#', input1).input('X', input2).pattern("X#X").pattern("# #").pattern("X#X").criterion(hasItem(input1), conditionsFromItem(input1)).criterion(hasItem(input2), conditionsFromItem(input2)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 2).input('#', input1).input('X', input2).pattern("#X#").pattern("X X").pattern("#X#").criterion(hasItem(input1), conditionsFromItem(input1)).criterion(hasItem(input2), conditionsFromItem(input2)).offerTo(exporter, getRecipeName(output) + "_alt");

    }

    public static void offerDecoratedRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible decoration, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', decoration).input('X', input).pattern("##").pattern("XX").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerPhantomPurpurRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output).input(input).input(BlockusItemTags.SOUL_SOILS).criterion("has_purpur", conditionsFromItem(input)).offerTo(exporter, convertBetween(output, Blocks.SOUL_SAND));

    }

    public static void offerColoredTilesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible color1, ItemConvertible color2) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 2).input(color1).input(color2).group("colored_tiles").criterion(hasItem(color1), conditionsFromItem(color1)).criterion(hasItem(color2), conditionsFromItem(color2)).offerTo(exporter);

    }

    public static void offerUnicolorColoredTilesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible color) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 2).input(color).input(color).group("colored_tiles").criterion(hasItem(color), conditionsFromItem(color)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, output, color);

    }

    public static void offerSmallLogsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 3).input(input).input(input).input(input).group("small_logs").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);

    }

    public static void offerSmallHedgesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6).input('#', input).pattern("###").pattern("###").group("small_hedge").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }


    public static void offerHerringBoneRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 5).input('#', input).pattern("#  ").pattern("###").pattern("  #").group("herringbone_planks").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static CraftingRecipeJsonBuilder createEnclosedRecipe(ItemConvertible output, Ingredient input, ItemConvertible center) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 8).input('X', input).input('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
    }

    public static CraftingRecipeJsonBuilder createEnclosedRecipe2(ItemConvertible output, Ingredient input, ItemConvertible center) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output).input('X', input).input('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
    }

    public static void offerStoneDoorTrapdoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible door, ItemConvertible trapdoor, ItemConvertible input, ItemConvertible slab) {
        createDoorRecipe(door, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, trapdoor, 4).input('#', slab).pattern("###").pattern("###").criterion(hasItem(slab), conditionsFromItem(slab)).offerTo(exporter);
    }

    public static void offerDoorTrapdoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible door, ItemConvertible trapdoor, ItemConvertible input) {
        createDoorRecipe(door, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
        createTrapdoorRecipe(trapdoor, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerPressurePlateButtonRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible pressureplate, ItemConvertible button, ItemConvertible input) {
        createPressurePlateRecipe(RecipeCategory.REDSTONE, pressureplate, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, button).input(input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerStainedStoneBricksRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab, ItemConvertible output_wall) {
        createEnclosedRecipe(output, Ingredient.ofItems(Blocks.STONE_BRICKS), center).group("stained_stone_bricks").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(Blocks.STONE_BRICK_STAIRS), center).group("stained_stone_brick_stairs").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_stairs, Blocks.STONE_BRICK_STAIRS));
        createEnclosedRecipe(output_slab, Ingredient.ofItems(Blocks.STONE_BRICK_SLAB), center).group("stained_stone_brick_slab").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_slab, Blocks.STONE_BRICK_SLAB));
        createEnclosedRecipe(output_wall, Ingredient.ofItems(Blocks.STONE_BRICK_WALL), center).group("stained_stone_brick_wall").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_wall, Blocks.STONE_BRICK_WALL));
        offerStonecuttingRecipe(exporter, output_stairs, output);
        offerStonecuttingRecipe(exporter, output_slab, 2, output);
        offerStonecuttingRecipe(exporter, output_wall, output);
    }

    public static void createTimberFramesRecipes(Consumer<RecipeJsonProvider> exporter, ItemConvertible base, ItemConvertible block, ItemConvertible diagonal, ItemConvertible cross) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, block, 2).input('#', Items.PAPER).input('X', base).pattern("#X").pattern("X#").group("timber_frame").criterion(hasItem(base), conditionsFromItem(base)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, diagonal, 4).input('#', block).pattern("##").pattern("##").group("diagonal_timber_frame").criterion(hasItem(block), conditionsFromItem(block)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, cross, 4).input('#', diagonal).pattern("##").pattern("##").group("cross_timber_frame").criterion(hasItem(diagonal), conditionsFromItem(diagonal)).offerTo(exporter);
    }

    public static void offerAsphaltRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab) {
        createEnclosedRecipe(output, Ingredient.ofItems(BlockusBlocks.ASPHALT.block), center).group("asphalt").criterion(hasItem(BlockusBlocks.ASPHALT.block), conditionsFromItem(BlockusBlocks.ASPHALT.block)).offerTo(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(BlockusBlocks.ASPHALT.stairs), center).group("asphalt_stairs").criterion(hasItem(BlockusBlocks.ASPHALT.block), conditionsFromItem(BlockusBlocks.ASPHALT.block)).offerTo(exporter, convertBetween(output_stairs, BlockusBlocks.ASPHALT.stairs));
        createEnclosedRecipe(output_slab, Ingredient.ofItems(BlockusBlocks.ASPHALT.slab), center).group("asphalt_slab").criterion(hasItem(BlockusBlocks.ASPHALT.block), conditionsFromItem(BlockusBlocks.ASPHALT.block)).offerTo(exporter, convertBetween(output_slab, BlockusBlocks.ASPHALT.slab));
    }

    public static void offerPatternWoolRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible wool, ItemConvertible output_carpet, ItemConvertible carpet) {
        offerPolishedStoneRecipe(exporter, output, wool);
        createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, output_carpet, Ingredient.ofItems(carpet)).group("patterned_carpet").criterion(hasItem(carpet), conditionsFromItem(carpet)).offerTo(exporter, convertBetween(output_carpet, carpet));

    }


    public static void offerShinglesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab, ItemConvertible terracotta) {
        createEnclosedRecipe(output, Ingredient.ofItems(BlockusBlocks.SHINGLES.block), center).group("shingles").criterion(hasItem(BlockusBlocks.SHINGLES.block), conditionsFromItem(BlockusBlocks.SHINGLES.block)).offerTo(exporter, convertBetween(output_stairs, BlockusBlocks.SHINGLES.block));
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(BlockusBlocks.SHINGLES.stairs), center).group("shingles_stairs").criterion(hasItem(BlockusBlocks.SHINGLES.block), conditionsFromItem(BlockusBlocks.SHINGLES.block)).offerTo(exporter, convertBetween(output_stairs, BlockusBlocks.SHINGLES.stairs));
        createEnclosedRecipe(output_slab, Ingredient.ofItems(BlockusBlocks.SHINGLES.slab), center).group("shingles_slab").criterion(hasItem(BlockusBlocks.SHINGLES.block), conditionsFromItem(BlockusBlocks.SHINGLES.block)).offerTo(exporter, convertBetween(output_slab, BlockusBlocks.SHINGLES.slab));
        offerPolishedStoneRecipe(exporter, output, terracotta);
        offerStonecuttingRecipe(exporter, output, terracotta);
        offerStonecuttingRecipe(exporter, output_stairs, terracotta, output);
        offerStonecuttingRecipe(exporter, output_slab, 2, terracotta, output);
    }

    public static void offerStairsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);

    }

    public static void offerStainedBeveledGlassRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible output_pane, ItemConvertible input, ItemConvertible dye) {
        createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItems(input)).group("beveled_glass").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
        createEnclosedRecipe(output, Ingredient.ofItems(BlockusBlocks.BEVELED_GLASS), dye).group("beveled_glass_2").criterion(hasItem(BlockusBlocks.BEVELED_GLASS), conditionsFromItem(BlockusBlocks.BEVELED_GLASS)).offerTo(exporter, convertBetween(output, BlockusBlocks.BEVELED_GLASS));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output_pane, 16).input('#', output).pattern("###").pattern("###").group("beveled_glass_pane").criterion(hasItem(BlockusBlocks.BEVELED_GLASS_PANE), conditionsFromItem(output)).offerTo(exporter);
        createEnclosedRecipe(output_pane, Ingredient.ofItems(BlockusBlocks.BEVELED_GLASS_PANE), dye).group("beveled_glass_pane_2").criterion(hasItem(BlockusBlocks.BEVELED_GLASS_PANE), conditionsFromItem(BlockusBlocks.BEVELED_GLASS_PANE)).offerTo(exporter, convertBetween(output, BlockusBlocks.BEVELED_GLASS_PANE));
    }

    public static void offerStainedRedstoneLampRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible dye, ItemConvertible output_lit) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output).input('S', dye).input('#', Blocks.REDSTONE_LAMP).pattern(" S ").pattern("S#S").pattern(" S ").group("redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output_lit).input(output).input(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").criterion(hasItem(output), conditionsFromItem(output)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output_lit).input('S', dye).input('#', BlockusBlocks.REDSTONE_LAMP_LIT).pattern(" S ").pattern("S#S").pattern(" S ").group("lit_redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter, getRecipeName(output) + "_alt");
    }

    public static void offerNeonRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible dye) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 8).input('A', dye).input('B', Items.GLOW_INK_SAC).input('C', Items.AMETHYST_SHARD).pattern("CAC").pattern("ABA").pattern("CAC").group("neon_blocks").criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC)).offerTo(exporter);
    }

    public static void offerFuturneoRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible glass) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6).input('A', Items.BLACK_DYE).input('B', glass).input('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").criterion(hasItem(glass), conditionsFromItem(glass)).offerTo(exporter);

    }

    public static void offerBoatsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output1, ItemConvertible output2, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output1).input('#', input).pattern("# #").pattern("###").group("boat").criterion("in_water", requireEnteringFluid(Blocks.WATER)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output2).input(Blocks.CHEST).input(output1).group("chest_boat").criterion("has_boat", conditionsFromTag(ItemTags.BOATS)).offerTo(exporter);

    }

    public static void offerStonecuttingRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible... ingredients) {
        offerStonecuttingRecipe(exporter, output, 1, ingredients);
    }

    public static void offerStonecuttingRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, int count, ItemConvertible... ingredients) {

        for (ItemConvertible itemConvertible : ingredients) {
            SingleItemRecipeJsonBuilder var10000 = SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(itemConvertible), RecipeCategory.BUILDING_BLOCKS, output, count).criterion(hasItem(itemConvertible), conditionsFromItem(itemConvertible));
            String var10002 = convertBetween(output, itemConvertible);
            var10000.offerTo(exporter, var10002 + "_stonecutting");
        }
    }

    public static void generateFamilies(Consumer<RecipeJsonProvider> exporter, FeatureSet enabledFeatures) {
        BlockusBlockFamilies.getFamilies().filter((family) -> {
            return family.shouldGenerateRecipes(enabledFeatures);
        }).forEach((family) -> {
            generateFamily(exporter, family);
        });
    }
}
