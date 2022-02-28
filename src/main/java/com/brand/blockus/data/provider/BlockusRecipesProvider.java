package com.brand.blockus.data.provider;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.data.family.BlockusBlockFamilies;
import com.brand.blockus.tag.BlockusItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;

import java.util.function.Consumer;

public class BlockusRecipesProvider extends FabricRecipeProvider {
    public BlockusRecipesProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        BlockusBlockFamilies.getFamilies().filter(BlockFamily::shouldGenerateRecipes).forEach((family) -> {
            generateFamily(exporter, family);
        });

        // Stone
        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_BRICK_PILLAR, Blocks.STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_BRICK_PILLAR, Blocks.STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_STONE_BRICKS, Blocks.STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_STONE_BRICKS, Blocks.STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_CIRCLE_PAVEMENT, Blocks.STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.STONE_CIRCLE_PAVEMENT, Blocks.STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
        offerStairsRecipe(exporter, BlockusBlocks.SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
        offerSturdyRecipe(exporter, BlockusBlocks.STURDY_STONE, Blocks.STONE, Blocks.COBBLESTONE);

        // Andesite
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICKS, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICK_STAIRS, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICK_STAIRS, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICK_STAIRS, BlockusBlocks.ANDESITE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICK_SLAB, Blocks.ANDESITE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICK_SLAB, Blocks.POLISHED_ANDESITE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICK_SLAB, BlockusBlocks.ANDESITE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICK_WALL, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICK_WALL, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_BRICK_WALL, BlockusBlocks.ANDESITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_ANDESITE, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_ANDESITE, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_ANDESITE, BlockusBlocks.ANDESITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ANDESITE_BRICKS, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ANDESITE_BRICKS, BlockusBlocks.ANDESITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_ANDESITE_PILLAR, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_ANDESITE_PILLAR, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_ANDESITE_PILLAR, BlockusBlocks.ANDESITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_CIRCLE_PAVEMENT, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_CIRCLE_PAVEMENT, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_CIRCLE_PAVEMENT, BlockusBlocks.ANDESITE_BRICKS);

        // Diorite
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICKS, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICKS, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICK_STAIRS, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICK_STAIRS, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICK_STAIRS, BlockusBlocks.DIORITE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICK_SLAB, Blocks.DIORITE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICK_SLAB, Blocks.POLISHED_DIORITE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICK_SLAB, BlockusBlocks.DIORITE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICK_WALL, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICK_WALL, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_BRICK_WALL, BlockusBlocks.DIORITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_DIORITE, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_DIORITE, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_DIORITE, BlockusBlocks.DIORITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DIORITE_BRICKS, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DIORITE_BRICKS, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DIORITE_BRICKS, BlockusBlocks.DIORITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DIORITE_PILLAR, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DIORITE_PILLAR, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DIORITE_PILLAR, BlockusBlocks.DIORITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_CIRCLE_PAVEMENT, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_CIRCLE_PAVEMENT, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_CIRCLE_PAVEMENT, BlockusBlocks.DIORITE_BRICKS);

        // Granite
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICKS, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICK_STAIRS, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICK_STAIRS, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICK_STAIRS, BlockusBlocks.GRANITE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICK_SLAB, Blocks.GRANITE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICK_SLAB, Blocks.POLISHED_GRANITE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICK_SLAB, BlockusBlocks.GRANITE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICK_WALL, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICK_WALL, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_BRICK_WALL, BlockusBlocks.GRANITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_GRANITE, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_GRANITE, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_GRANITE, BlockusBlocks.GRANITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRANITE_BRICKS, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRANITE_BRICKS, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRANITE_BRICKS, BlockusBlocks.GRANITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_GRANITE_PILLAR, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_GRANITE_PILLAR, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_GRANITE_PILLAR, BlockusBlocks.GRANITE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_CIRCLE_PAVEMENT, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_CIRCLE_PAVEMENT, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_CIRCLE_PAVEMENT, BlockusBlocks.GRANITE_BRICKS);

        // Dripstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DRIPSTONE_STAIRS, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DRIPSTONE_STAIRS, BlockusBlocks.POLISHED_DRIPSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DRIPSTONE_SLAB, Blocks.DRIPSTONE_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DRIPSTONE_SLAB, BlockusBlocks.POLISHED_DRIPSTONE, 2);

        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICKS, BlockusBlocks.POLISHED_DRIPSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICK_STAIRS, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICK_STAIRS, BlockusBlocks.POLISHED_DRIPSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICK_STAIRS, BlockusBlocks.DRIPSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICK_SLAB, Blocks.DRIPSTONE_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICK_SLAB, BlockusBlocks.POLISHED_DRIPSTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICK_SLAB, BlockusBlocks.DRIPSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICK_WALL, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICK_WALL, BlockusBlocks.POLISHED_DRIPSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_BRICK_WALL, BlockusBlocks.DRIPSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DRIPSTONE, BlockusBlocks.POLISHED_DRIPSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DRIPSTONE, BlockusBlocks.DRIPSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_PILLAR, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_PILLAR, BlockusBlocks.POLISHED_DRIPSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_PILLAR, BlockusBlocks.DRIPSTONE_BRICKS);

        // Tuff
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TUFF, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TUFF_STAIRS, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TUFF_STAIRS, BlockusBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TUFF_SLAB, Blocks.TUFF, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TUFF_SLAB, BlockusBlocks.POLISHED_TUFF, 2);

        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICKS, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICKS, BlockusBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICK_STAIRS, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICK_STAIRS, BlockusBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICK_STAIRS, BlockusBlocks.TUFF_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICK_SLAB, Blocks.TUFF, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICK_SLAB, BlockusBlocks.POLISHED_TUFF, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICK_SLAB, BlockusBlocks.TUFF_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICK_WALL, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICK_WALL, BlockusBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_BRICK_WALL, BlockusBlocks.TUFF_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_TUFF, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_TUFF, BlockusBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_TUFF, BlockusBlocks.TUFF_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_PILLAR, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_PILLAR, BlockusBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_PILLAR, BlockusBlocks.TUFF_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_TUFF, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_TUFF, BlockusBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_TUFF, BlockusBlocks.TUFF_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_CIRCLE_PAVEMENT, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_CIRCLE_PAVEMENT, BlockusBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_CIRCLE_PAVEMENT, BlockusBlocks.TUFF_BRICKS);

        // Deepslate
        ShapelessRecipeJsonFactory.create(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS).input(Blocks.DEEPSLATE_BRICKS).input(Blocks.VINE).group("mossy_deepslate_bricks").criterion("has_vine", conditionsFromItem(Blocks.VINE)).offerTo(exporter, convertBetween(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS, Blocks.VINE));
        ShapelessRecipeJsonFactory.create(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS).input(Blocks.DEEPSLATE_BRICKS).input(Blocks.MOSS_BLOCK).group("mossy_deepslate_bricks").criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK)).offerTo(exporter, convertBetween(BlockusBlocks.MOSSY_DEEPSLATE_BRICKS, Blocks.MOSS_BLOCK));
        offerStonecuttingRecipe(exporter, BlockusBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MOSSY_DEEPSLATE_BRICK_SLAB, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MOSSY_DEEPSLATE_BRICK_WALL, BlockusBlocks.MOSSY_DEEPSLATE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.DEEPSLATE_PILLAR, Blocks.COBBLED_DEEPSLATE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DEEPSLATE_PILLAR, Blocks.POLISHED_DEEPSLATE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DEEPSLATE_PILLAR, Blocks.DEEPSLATE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.DEEPSLATE_CIRCLE_PAVEMENT, Blocks.COBBLED_DEEPSLATE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DEEPSLATE_CIRCLE_PAVEMENT, Blocks.POLISHED_DEEPSLATE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DEEPSLATE_CIRCLE_PAVEMENT, Blocks.DEEPSLATE_BRICKS);

        offerSturdyRecipe(exporter, BlockusBlocks.STURDY_DEEPSLATE, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);


        // Blackstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_PILLAR, Blocks.BLACKSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_PILLAR, Blocks.POLISHED_BLACKSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_PILLAR, Blocks.POLISHED_BLACKSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_CIRCLE_PAVEMENT, Blocks.BLACKSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_CIRCLE_PAVEMENT, Blocks.POLISHED_BLACKSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLACKSTONE_CIRCLE_PAVEMENT, Blocks.POLISHED_BLACKSTONE_BRICKS);

        ShapelessRecipeJsonFactory.create(BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(Blocks.CRIMSON_ROOTS).criterion("has_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICK_STAIRS, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICK_SLAB, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICK_WALL, BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS);

        ShapelessRecipeJsonFactory.create(BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(BlockusItemTags.WARPED_NETHER_GRASS).criterion("has_roots", conditionsFromTag(BlockusItemTags.WARPED_NETHER_GRASS)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICK_STAIRS, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICK_SLAB, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICK_WALL, BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS);

        offerSturdyRecipe(exporter, BlockusBlocks.STURDY_BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE, Items.GOLD_INGOT, Blocks.POLISHED_BLACKSTONE);


        // Basalt
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_BASALT_STAIRS, BlockusBlocks.ROUGH_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_BASALT_SLAB, BlockusBlocks.ROUGH_BASALT, 2);
        ShapedRecipeJsonFactory.create(BlockusBlocks.ROUGH_BASALT, 2).input('#', Blocks.BASALT).pattern("#").pattern("#").criterion("has_basalt", conditionsFromItem(Blocks.BASALT)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICKS, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICKS, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICK_STAIRS, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICK_STAIRS, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICK_STAIRS, BlockusBlocks.POLISHED_BASALT_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICK_SLAB, Blocks.BASALT, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICK_SLAB, Blocks.POLISHED_BASALT, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICK_SLAB, BlockusBlocks.POLISHED_BASALT_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICK_WALL, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICK_WALL, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_BRICK_WALL, BlockusBlocks.POLISHED_BASALT_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_PILLAR, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_PILLAR, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_PILLAR, BlockusBlocks.POLISHED_BASALT_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_POLISHED_BASALT, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_POLISHED_BASALT, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_POLISHED_BASALT, BlockusBlocks.POLISHED_BASALT_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_POLISHED_BASALT, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_POLISHED_BASALT, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_POLISHED_BASALT, BlockusBlocks.POLISHED_BASALT_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_CIRCLE_PAVEMENT, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_CIRCLE_PAVEMENT, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_CIRCLE_PAVEMENT, BlockusBlocks.POLISHED_BASALT_BRICKS);

        // Limestone
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_STAIRS, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_SLAB, BlockusBlocks.LIMESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_WALL, BlockusBlocks.LIMESTONE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_LIMESTONE, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_LIMESTONE_STAIRS, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_LIMESTONE_STAIRS, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_LIMESTONE_SLAB, BlockusBlocks.LIMESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_LIMESTONE_SLAB, BlockusBlocks.POLISHED_LIMESTONE, 2);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICKS, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICKS, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICK_STAIRS, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICK_STAIRS, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICK_STAIRS, BlockusBlocks.LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICK_SLAB, BlockusBlocks.LIMESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICK_SLAB, BlockusBlocks.POLISHED_LIMESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICK_SLAB, BlockusBlocks.LIMESTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICK_WALL, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICK_WALL, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_BRICK_WALL, BlockusBlocks.LIMESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICKS, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICKS, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICKS, BlockusBlocks.LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_STAIRS, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_STAIRS, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_STAIRS, BlockusBlocks.LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_STAIRS, BlockusBlocks.SMALL_LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_SLAB, BlockusBlocks.LIMESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_SLAB, BlockusBlocks.POLISHED_LIMESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_SLAB, BlockusBlocks.LIMESTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_SLAB, BlockusBlocks.SMALL_LIMESTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_WALL, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_WALL, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_WALL, BlockusBlocks.LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_LIMESTONE_BRICK_WALL, BlockusBlocks.SMALL_LIMESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILES, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILES, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILES, BlockusBlocks.LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_STAIRS, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_STAIRS, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_STAIRS, BlockusBlocks.LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_STAIRS, BlockusBlocks.LIMESTONE_TILES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_SLAB, BlockusBlocks.LIMESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_SLAB, BlockusBlocks.POLISHED_LIMESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_SLAB, BlockusBlocks.LIMESTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_SLAB, BlockusBlocks.LIMESTONE_TILES, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_WALL, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_WALL, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_WALL, BlockusBlocks.LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_TILE_WALL, BlockusBlocks.LIMESTONE_TILES);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIMESTONE_TILES, BlockusBlocks.LIMESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIMESTONE, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIMESTONE, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIMESTONE, BlockusBlocks.LIMESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_PILLAR, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_PILLAR, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_PILLAR, BlockusBlocks.LIMESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_SQUARES, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_SQUARES, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_SQUARES, BlockusBlocks.LIMESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_CIRCLE_PAVEMENT, BlockusBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_CIRCLE_PAVEMENT, BlockusBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_CIRCLE_PAVEMENT, BlockusBlocks.LIMESTONE_BRICKS);

        // Marble
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_STAIRS, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_SLAB, BlockusBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_WALL, BlockusBlocks.MARBLE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_MARBLE, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_MARBLE_STAIRS, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_MARBLE_STAIRS, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_MARBLE_SLAB, BlockusBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_MARBLE_SLAB, BlockusBlocks.POLISHED_MARBLE, 2);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICKS, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICKS, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICK_STAIRS, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICK_STAIRS, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICK_STAIRS, BlockusBlocks.MARBLE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICK_SLAB, BlockusBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICK_SLAB, BlockusBlocks.POLISHED_MARBLE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICK_SLAB, BlockusBlocks.MARBLE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICK_WALL, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICK_WALL, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_BRICK_WALL, BlockusBlocks.MARBLE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICKS, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICKS, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICKS, BlockusBlocks.MARBLE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_STAIRS, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_STAIRS, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_STAIRS, BlockusBlocks.MARBLE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_STAIRS, BlockusBlocks.SMALL_MARBLE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_SLAB, BlockusBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_SLAB, BlockusBlocks.POLISHED_MARBLE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_SLAB, BlockusBlocks.MARBLE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_SLAB, BlockusBlocks.SMALL_MARBLE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_WALL, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_WALL, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_WALL, BlockusBlocks.MARBLE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MARBLE_BRICK_WALL, BlockusBlocks.SMALL_MARBLE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILES, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILES, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILES, BlockusBlocks.MARBLE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_STAIRS, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_STAIRS, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_STAIRS, BlockusBlocks.MARBLE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_STAIRS, BlockusBlocks.MARBLE_TILES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_SLAB, BlockusBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_SLAB, BlockusBlocks.POLISHED_MARBLE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_SLAB, BlockusBlocks.MARBLE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_SLAB, BlockusBlocks.MARBLE_TILES, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_WALL, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_WALL, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_WALL, BlockusBlocks.MARBLE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_TILE_WALL, BlockusBlocks.MARBLE_TILES);
        offerCutCopperRecipe(exporter, BlockusBlocks.MARBLE_TILES, BlockusBlocks.MARBLE_BRICKS);


        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE, BlockusBlocks.MARBLE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_PILLAR, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_PILLAR, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_PILLAR, BlockusBlocks.MARBLE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE_PILLAR, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE_PILLAR, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE_PILLAR, BlockusBlocks.MARBLE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE_PILLAR, BlockusBlocks.MARBLE_PILLAR);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_SQUARES, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_SQUARES, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_SQUARES, BlockusBlocks.MARBLE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_CIRCLE_PAVEMENT, BlockusBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_CIRCLE_PAVEMENT, BlockusBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_CIRCLE_PAVEMENT, BlockusBlocks.MARBLE_BRICKS);

        // Bluestone
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_STAIRS, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_SLAB, BlockusBlocks.BLUESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_WALL, BlockusBlocks.BLUESTONE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLUESTONE, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLUESTONE_STAIRS, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLUESTONE_STAIRS, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLUESTONE_SLAB, BlockusBlocks.BLUESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BLUESTONE_SLAB, BlockusBlocks.POLISHED_BLUESTONE, 2);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICKS, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICKS, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICK_STAIRS, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICK_STAIRS, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICK_STAIRS, BlockusBlocks.BLUESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICK_SLAB, BlockusBlocks.BLUESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICK_SLAB, BlockusBlocks.POLISHED_BLUESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICK_SLAB, BlockusBlocks.BLUESTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICK_WALL, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICK_WALL, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_BRICK_WALL, BlockusBlocks.BLUESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICKS, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICKS, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICKS, BlockusBlocks.BLUESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_STAIRS, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_STAIRS, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_STAIRS, BlockusBlocks.BLUESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_STAIRS, BlockusBlocks.SMALL_BLUESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_SLAB, BlockusBlocks.BLUESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_SLAB, BlockusBlocks.POLISHED_BLUESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_SLAB, BlockusBlocks.BLUESTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_SLAB, BlockusBlocks.SMALL_BLUESTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_WALL, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_WALL, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_WALL, BlockusBlocks.BLUESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_BLUESTONE_BRICK_WALL, BlockusBlocks.SMALL_BLUESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILES, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILES, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILES, BlockusBlocks.BLUESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_STAIRS, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_STAIRS, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_STAIRS, BlockusBlocks.BLUESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_STAIRS, BlockusBlocks.BLUESTONE_TILES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_SLAB, BlockusBlocks.BLUESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_SLAB, BlockusBlocks.POLISHED_BLUESTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_SLAB, BlockusBlocks.BLUESTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_SLAB, BlockusBlocks.BLUESTONE_TILES, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_WALL, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_WALL, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_WALL, BlockusBlocks.BLUESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_TILE_WALL, BlockusBlocks.BLUESTONE_TILES);
        offerCutCopperRecipe(exporter, BlockusBlocks.BLUESTONE_TILES, BlockusBlocks.BLUESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUESTONE, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUESTONE, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUESTONE, BlockusBlocks.BLUESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_PILLAR, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_PILLAR, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_PILLAR, BlockusBlocks.BLUESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_SQUARES, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_SQUARES, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_SQUARES, BlockusBlocks.BLUESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_CIRCLE_PAVEMENT, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_CIRCLE_PAVEMENT, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_CIRCLE_PAVEMENT, BlockusBlocks.BLUESTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_LINES, BlockusBlocks.BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_LINES, BlockusBlocks.POLISHED_BLUESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_LINES, BlockusBlocks.BLUESTONE_BRICKS);

        // Lava	Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_BRICK_STAIRS, BlockusBlocks.LAVA_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_BRICK_SLAB, BlockusBlocks.LAVA_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_BRICK_WALL, BlockusBlocks.LAVA_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LAVA_BRICKS, BlockusBlocks.LAVA_BRICKS);
        createEnclosedRecipe(BlockusBlocks.LAVA_BRICKS, Ingredient.ofItems(Blocks.STONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

        // Lava Blackstone Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_STAIRS, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_SLAB, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_WALL, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LAVA_POLISHED_BLACKSTONE, BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS);
        createEnclosedRecipe(BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS, Ingredient.ofItems(Blocks.POLISHED_BLACKSTONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.POLISHED_BLACKSTONE_BRICKS), conditionsFromItem(Blocks.POLISHED_BLACKSTONE_BRICKS)).offerTo(exporter);

        // Water Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.WATER_BRICK_STAIRS, BlockusBlocks.WATER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WATER_BRICK_SLAB, BlockusBlocks.WATER_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WATER_BRICK_WALL, BlockusBlocks.WATER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_WATER_BRICKS, BlockusBlocks.WATER_BRICKS);
        createEnclosedRecipe(BlockusBlocks.WATER_BRICKS, Ingredient.ofItems(Blocks.STONE_BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

        // Snow Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.SNOW_BRICK_STAIRS, BlockusBlocks.SNOW_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SNOW_BRICK_SLAB, BlockusBlocks.SNOW_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SNOW_BRICK_WALL, BlockusBlocks.SNOW_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SNOW_PILLAR, BlockusBlocks.SNOW_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.SNOW_BRICKS, Blocks.SNOW_BLOCK);


        // Ice Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.ICE_BRICK_WALL, BlockusBlocks.ICE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ICE_PILLAR, BlockusBlocks.ICE_BRICKS);
        ShapedRecipeJsonFactory.create(BlockusBlocks.ICE_BRICKS, 4).input('#',  BlockusItemTags.NATURAL_ICE).pattern("##").pattern("##").criterion("has_ice", conditionsFromTag(BlockusItemTags.NATURAL_ICE)).offerTo(exporter);


        // Magma Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICK_STAIRS, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICK_STAIRS, BlockusBlocks.MAGMA_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICK_SLAB, Blocks.MAGMA_BLOCK,2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICK_SLAB, BlockusBlocks.MAGMA_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICK_WALL, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGMA_BRICK_WALL, BlockusBlocks.MAGMA_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.MAGMA_BRICKS, Blocks.MAGMA_BLOCK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICKS, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICKS, BlockusBlocks.MAGMA_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICK_STAIRS, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICK_STAIRS, BlockusBlocks.MAGMA_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICK_STAIRS, BlockusBlocks.SMALL_MAGMA_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICK_SLAB, Blocks.MAGMA_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICK_SLAB, BlockusBlocks.MAGMA_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICK_SLAB, BlockusBlocks.SMALL_MAGMA_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICK_WALL, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICK_WALL, BlockusBlocks.MAGMA_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_MAGMA_BRICK_WALL, BlockusBlocks.SMALL_MAGMA_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MAGMA_BRICKS, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MAGMA_BRICKS, BlockusBlocks.MAGMA_BRICKS);

        // Blaze Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLAZE_BRICK_STAIRS, BlockusBlocks.BLAZE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLAZE_BRICK_SLAB, BlockusBlocks.BLAZE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLAZE_BRICK_WALL, BlockusBlocks.BLAZE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLAZE_PILLAR, BlockusBlocks.BLAZE_BRICKS);
        ShapedRecipeJsonFactory.create(BlockusBlocks.BLAZE_BRICKS).input('#',  Items.BLAZE_POWDER).input('X',  Items.NETHER_BRICK).pattern("#X").pattern("X#").criterion("has_blaze_rod", conditionsFromItem(Items.BLAZE_ROD)).offerTo(exporter);

        // Netherrack
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK_STAIRS, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK_STAIRS, BlockusBlocks.POLISHED_NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK_SLAB, Blocks.NETHERRACK,2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK_SLAB, BlockusBlocks.POLISHED_NETHERRACK, 2);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_NETHERRACK, Blocks.NETHERRACK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICKS, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICKS, BlockusBlocks.POLISHED_NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICK_STAIRS, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICK_STAIRS, BlockusBlocks.POLISHED_NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICK_STAIRS, BlockusBlocks.NETHERRACK_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICK_SLAB, Blocks.NETHERRACK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICK_SLAB, BlockusBlocks.POLISHED_NETHERRACK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICK_SLAB, BlockusBlocks.NETHERRACK_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICK_WALL, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICK_WALL, BlockusBlocks.POLISHED_NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_BRICK_WALL, BlockusBlocks.NETHERRACK_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_CIRCLE_PAVEMENT, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_CIRCLE_PAVEMENT, BlockusBlocks.POLISHED_NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_CIRCLE_PAVEMENT, BlockusBlocks.NETHERRACK_BRICKS);

        // Nether Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHER_BRICK_PILLAR, Blocks.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_NETHER_BRICK_PILLAR, Blocks.RED_NETHER_BRICKS);

        // Charred Nether Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_NETHER_BRICK_STAIRS, BlockusBlocks.CHARRED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_NETHER_BRICK_SLAB, BlockusBlocks.CHARRED_NETHER_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_NETHER_BRICK_WALL, BlockusBlocks.CHARRED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_CHARRED_NETHER_BRICKS, BlockusBlocks.CHARRED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_CHARRED_NETHER_BRICKS, BlockusBlocks.CHARRED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_NETHER_BRICK_PILLAR, BlockusBlocks.CHARRED_NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_CHARRED_NETHER_BRICKS, BlockusBlocks.CHARRED_NETHER_BRICKS);

        // Teal Nether Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.TEAL_NETHER_BRICK_STAIRS, BlockusBlocks.TEAL_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TEAL_NETHER_BRICK_SLAB, BlockusBlocks.TEAL_NETHER_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TEAL_NETHER_BRICK_WALL, BlockusBlocks.TEAL_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TEAL_NETHER_BRICKS, BlockusBlocks.TEAL_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_TEAL_NETHER_BRICKS, BlockusBlocks.TEAL_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TEAL_NETHER_BRICK_PILLAR, BlockusBlocks.TEAL_NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_TEAL_NETHER_BRICKS, BlockusBlocks.TEAL_NETHER_BRICKS);

        // Obsidian
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICKS, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICK_STAIRS, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICK_STAIRS, BlockusBlocks.OBSIDIAN_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICK_SLAB, Blocks.OBSIDIAN, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICK_SLAB, BlockusBlocks.OBSIDIAN_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICK_WALL, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICK_WALL, BlockusBlocks.OBSIDIAN_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.OBSIDIAN_BRICKS, Blocks.OBSIDIAN);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICKS, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICKS, BlockusBlocks.OBSIDIAN_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICK_STAIRS, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICK_STAIRS, BlockusBlocks.OBSIDIAN_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICK_STAIRS, BlockusBlocks.SMALL_OBSIDIAN_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICK_SLAB, Blocks.OBSIDIAN, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICK_SLAB, BlockusBlocks.OBSIDIAN_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICK_SLAB, BlockusBlocks.SMALL_OBSIDIAN_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICK_WALL, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICK_WALL, BlockusBlocks.OBSIDIAN_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_OBSIDIAN_BRICK_WALL, BlockusBlocks.SMALL_OBSIDIAN_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_PILLAR, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_PILLAR, BlockusBlocks.OBSIDIAN_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_CIRCLE_PAVEMENT, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_CIRCLE_PAVEMENT, BlockusBlocks.OBSIDIAN_BRICKS);

        // Quartz Blocks
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILES, Blocks.QUARTZ_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILES, Blocks.QUARTZ_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILE_STAIRS, Blocks.QUARTZ_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILE_STAIRS, Blocks.QUARTZ_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILE_STAIRS, BlockusBlocks.QUARTZ_TILES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILE_SLAB, Blocks.QUARTZ_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILE_SLAB, Blocks.QUARTZ_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILE_SLAB, BlockusBlocks.QUARTZ_TILES, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILE_WALL, Blocks.QUARTZ_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILE_WALL, Blocks.QUARTZ_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_TILE_WALL, BlockusBlocks.QUARTZ_TILES);
        offerCutCopperRecipe(exporter, BlockusBlocks.QUARTZ_TILES, Blocks.QUARTZ_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_CIRCLE_PAVEMENT, Blocks.QUARTZ_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_CIRCLE_PAVEMENT, Blocks.QUARTZ_BRICKS);

        // Prismarine
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PRISMARINE, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PRISMARINE_CIRCLE_PAVEMENT, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DARK_PRISMARINE, Blocks.DARK_PRISMARINE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE);

        // Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICKS, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICK_STAIRS, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICK_STAIRS, BlockusBlocks.LARGE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICK_SLAB, Blocks.BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICK_SLAB, BlockusBlocks.LARGE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICK_WALL, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LARGE_BRICK_WALL, BlockusBlocks.LARGE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.LARGE_BRICKS, Blocks.BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_BRICKS, Blocks.BRICKS);

        // Soaked Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOAKED_BRICK_STAIRS, BlockusBlocks.SOAKED_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOAKED_BRICK_SLAB, BlockusBlocks.SOAKED_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOAKED_BRICK_WALL, BlockusBlocks.SOAKED_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_SOAKED_BRICKS, BlockusBlocks.SOAKED_BRICKS);
        createEnclosedRecipe(BlockusBlocks.SOAKED_BRICKS, Ingredient.ofItems(Blocks.BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Sandy Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDY_BRICK_STAIRS, BlockusBlocks.SANDY_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDY_BRICK_SLAB, BlockusBlocks.SANDY_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDY_BRICK_WALL, BlockusBlocks.SANDY_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_SANDY_BRICKS, BlockusBlocks.SANDY_BRICKS);
        ShapedRecipeJsonFactory.create(BlockusBlocks.SANDY_BRICKS, 2).input('S', Blocks.SAND).input('#', Blocks.BRICKS).pattern(" S ").pattern("S#S").pattern(" S ").criterion("has_sand", conditionsFromItem(Blocks.SAND)).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Charred Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_BRICK_STAIRS, BlockusBlocks.CHARRED_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_BRICK_SLAB, BlockusBlocks.CHARRED_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_BRICK_WALL, BlockusBlocks.CHARRED_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_CHARRED_BRICKS, BlockusBlocks.CHARRED_BRICKS);
        CookingRecipeJsonFactory.createSmelting(Ingredient.ofItems(Blocks.BRICKS), BlockusBlocks.CHARRED_BRICKS.asItem(), 0.1F, 200).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Sandstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_SANDSTONE_STAIRS, BlockusBlocks.ROUGH_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_SANDSTONE_SLAB, BlockusBlocks.ROUGH_SANDSTONE, 2);
        ShapedRecipeJsonFactory.create(BlockusBlocks.ROUGH_SANDSTONE, 2).input('#', Blocks.SANDSTONE_SLAB).pattern("#").pattern("#").criterion("has_sandstone", conditionsFromItem(Blocks.SANDSTONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICKS, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICK_STAIRS, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICK_STAIRS, BlockusBlocks.SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICK_SLAB, Blocks.SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICK_SLAB, BlockusBlocks.SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICK_WALL, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_BRICK_WALL, BlockusBlocks.SANDSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICKS, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICKS, BlockusBlocks.SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICK_STAIRS, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICK_STAIRS, BlockusBlocks.SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICK_STAIRS, BlockusBlocks.SMALL_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICK_SLAB, Blocks.SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICK_SLAB, BlockusBlocks.SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICK_SLAB, BlockusBlocks.SMALL_SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICK_WALL, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICK_WALL, BlockusBlocks.SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SANDSTONE_BRICK_WALL, BlockusBlocks.SMALL_SANDSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_PILLAR, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_PILLAR, BlockusBlocks.SANDSTONE_BRICKS);

        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_SANDSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.LAPIS_DECORATED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_SANDSTONE);

        // Red Sandstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_RED_SANDSTONE_STAIRS, BlockusBlocks.ROUGH_RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_RED_SANDSTONE_SLAB, BlockusBlocks.ROUGH_RED_SANDSTONE, 2);
        ShapedRecipeJsonFactory.create(BlockusBlocks.ROUGH_RED_SANDSTONE, 2).input('#', Blocks.RED_SANDSTONE_SLAB).pattern("#").pattern("#").criterion("has_red_sandstone", conditionsFromItem(Blocks.RED_SANDSTONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICK_STAIRS, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICK_STAIRS, BlockusBlocks.RED_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICK_SLAB, Blocks.RED_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICK_SLAB, BlockusBlocks.RED_SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICK_WALL, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_BRICK_WALL, BlockusBlocks.RED_SANDSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS, BlockusBlocks.RED_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_STAIRS, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_STAIRS, BlockusBlocks.RED_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_STAIRS, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_SLAB, Blocks.RED_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_SLAB, BlockusBlocks.RED_SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_SLAB, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_WALL, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_WALL, BlockusBlocks.RED_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_RED_SANDSTONE_BRICK_WALL, BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_PILLAR, BlockusBlocks.RED_SANDSTONE_BRICKS);

        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_RED_SANDSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.LAPIS_DECORATED_RED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_RED_SANDSTONE);

        // Soul Sandstone
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_STAIRS, BlockusBlocks.SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_SLAB, BlockusBlocks.SOUL_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_WALL, BlockusBlocks.SOUL_SANDSTONE, 2);
        ShapedRecipeJsonFactory.create(BlockusBlocks.SOUL_SANDSTONE).input('#',  BlockusItemTags.SOUL_SOILS).pattern("##").pattern("##").criterion("has_soul_sand", conditionsFromTag(BlockusItemTags.SOUL_SOILS)).offerTo(exporter);


        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_SOUL_SANDSTONE_STAIRS, BlockusBlocks.ROUGH_SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ROUGH_SOUL_SANDSTONE_SLAB, BlockusBlocks.ROUGH_SOUL_SANDSTONE, 2);
        ShapedRecipeJsonFactory.create(BlockusBlocks.ROUGH_SOUL_SANDSTONE, 2).input('#', BlockusBlocks.SOUL_SANDSTONE_SLAB).pattern("#").pattern("#").criterion("has_soul_sandstone", conditionsFromItem(BlockusBlocks.SOUL_SANDSTONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICKS, BlockusBlocks.SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICK_STAIRS, BlockusBlocks.SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICK_STAIRS, BlockusBlocks.SOUL_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICK_SLAB, BlockusBlocks.SOUL_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICK_SLAB, BlockusBlocks.SOUL_SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICK_WALL, BlockusBlocks.SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_BRICK_WALL, BlockusBlocks.SOUL_SANDSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS, BlockusBlocks.SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS, BlockusBlocks.SOUL_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_STAIRS, BlockusBlocks.SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_STAIRS, BlockusBlocks.SOUL_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_STAIRS, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_SLAB, BlockusBlocks.SOUL_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_SLAB, BlockusBlocks.SOUL_SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_SLAB, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_WALL, BlockusBlocks.SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_WALL, BlockusBlocks.SOUL_SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICK_WALL, BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, BlockusBlocks.SMOOTH_SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, BlockusBlocks.SMOOTH_SOUL_SANDSTONE, 2);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, BlockusBlocks.SOUL_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, BlockusBlocks.CUT_SOUL_SANDSTONE, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE);
        offerCutCopperRecipe(exporter, BlockusBlocks.CHISELED_SOUL_SANDSTONE, BlockusBlocks.CUT_SOUL_SANDSTONE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_PILLAR, BlockusBlocks.SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_PILLAR, BlockusBlocks.SOUL_SANDSTONE_BRICKS);

        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE, Items.GOLD_INGOT, BlockusBlocks.CUT_SOUL_SANDSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.LAPIS_DECORATED_SOUL_SANDSTONE, Items.LAPIS_LAZULI, BlockusBlocks.CUT_SOUL_SANDSTONE);

        // Honeycomb Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICKS, Blocks.HONEYCOMB_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICK_STAIRS, Blocks.HONEYCOMB_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICK_STAIRS, BlockusBlocks.HONEYCOMB_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICK_SLAB, Blocks.HONEYCOMB_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICK_SLAB, BlockusBlocks.HONEYCOMB_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICK_WALL, Blocks.HONEYCOMB_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICK_WALL, BlockusBlocks.HONEYCOMB_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.HONEYCOMB_BRICKS, Blocks.HONEYCOMB_BLOCK);


        // Purpur Blocks
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PURPUR, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PURPUR_STAIRS, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PURPUR_STAIRS, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PURPUR_SLAB, Blocks.PURPUR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PURPUR_SLAB, BlockusBlocks.POLISHED_PURPUR, 2);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICKS, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICKS, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICK_STAIRS, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICK_STAIRS, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICK_STAIRS, BlockusBlocks.PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICK_SLAB, Blocks.PURPUR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICK_SLAB, BlockusBlocks.POLISHED_PURPUR, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICK_SLAB, BlockusBlocks.PURPUR_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICK_WALL, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICK_WALL, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_BRICK_WALL, BlockusBlocks.PURPUR_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICKS, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICKS, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICKS, BlockusBlocks.PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_STAIRS, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_STAIRS, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_STAIRS, BlockusBlocks.PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_STAIRS, BlockusBlocks.SMALL_PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_SLAB, Blocks.PURPUR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_SLAB, BlockusBlocks.POLISHED_PURPUR, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_SLAB, BlockusBlocks.PURPUR_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_SLAB, BlockusBlocks.SMALL_PURPUR_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_WALL, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_WALL, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_WALL, BlockusBlocks.PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PURPUR_BRICK_WALL, BlockusBlocks.SMALL_PURPUR_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPUR, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPUR, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPUR, BlockusBlocks.PURPUR_BRICKS);

        offerStonecuttingRecipe(exporter, Blocks.PURPUR_PILLAR, BlockusBlocks.POLISHED_PURPUR);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_SQUARES, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_SQUARES, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_SQUARES, BlockusBlocks.PURPUR_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_LINES, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_LINES, BlockusBlocks.POLISHED_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_LINES, BlockusBlocks.PURPUR_BRICKS);



        // Phantom Purpur Blocks
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_STAIRS, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SLAB, BlockusBlocks.PHANTOM_PURPUR_BLOCK, 2);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BLOCK, Blocks.PURPUR_BLOCK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR_STAIRS, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR_STAIRS, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR_SLAB, BlockusBlocks.PHANTOM_PURPUR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR_SLAB, BlockusBlocks.POLISHED_PHANTOM_PURPUR, 2);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.POLISHED_PHANTOM_PURPUR, BlockusBlocks.POLISHED_PURPUR);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICKS, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICKS, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICK_STAIRS, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICK_STAIRS, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICK_STAIRS, BlockusBlocks.PHANTOM_PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICK_SLAB, BlockusBlocks.PHANTOM_PURPUR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICK_SLAB, BlockusBlocks.POLISHED_PHANTOM_PURPUR, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICK_SLAB, BlockusBlocks.PHANTOM_PURPUR_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICK_WALL, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICK_WALL, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICK_WALL, BlockusBlocks.PHANTOM_PURPUR_BRICKS);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_BRICKS, BlockusBlocks.PURPUR_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS, BlockusBlocks.PHANTOM_PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_STAIRS, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_STAIRS, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_STAIRS, BlockusBlocks.PHANTOM_PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_STAIRS, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_SLAB, BlockusBlocks.PHANTOM_PURPUR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_SLAB, BlockusBlocks.POLISHED_PHANTOM_PURPUR, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_SLAB, BlockusBlocks.PHANTOM_PURPUR_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_SLAB, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_WALL, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_WALL, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_WALL, BlockusBlocks.PHANTOM_PURPUR_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICK_WALL, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS, BlockusBlocks.PHANTOM_PURPUR_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BlockusBlocks.PHANTOM_PURPUR_BRICKS);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BlockusBlocks.CHISELED_PURPUR);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_PILLAR, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_PILLAR, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_PILLAR, Blocks.PURPUR_PILLAR);
        ShapedRecipeJsonFactory.create(BlockusBlocks.PHANTOM_PURPUR_PILLAR).input('#', BlockusBlocks.PHANTOM_PURPUR_SLAB).pattern("#").pattern("#").criterion("has_phantom_purpur_block", conditionsFromItem(BlockusBlocks.PHANTOM_PURPUR_BLOCK)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BlockusBlocks.PHANTOM_PURPUR_BRICKS);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BlockusBlocks.PURPUR_SQUARES);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BlockusBlocks.PHANTOM_PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BlockusBlocks.POLISHED_PHANTOM_PURPUR);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BlockusBlocks.PHANTOM_PURPUR_BRICKS);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BlockusBlocks.PURPUR_LINES);

        // End Stone
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_END_STONE, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_END_STONE_STAIRS, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_END_STONE_STAIRS, BlockusBlocks.POLISHED_END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_END_STONE_SLAB, Blocks.END_STONE,2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_END_STONE_SLAB, BlockusBlocks.POLISHED_END_STONE, 2);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_END_STONE, Blocks.END_STONE);

        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICKS, BlockusBlocks.POLISHED_END_STONE);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_STAIRS, BlockusBlocks.POLISHED_END_STONE);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_SLAB, BlockusBlocks.POLISHED_END_STONE, 2);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_WALL, BlockusBlocks.POLISHED_END_STONE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICKS, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICKS, BlockusBlocks.POLISHED_END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_STAIRS, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_STAIRS, BlockusBlocks.POLISHED_END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_STAIRS, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_STAIRS, BlockusBlocks.SMALL_END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_SLAB, Blocks.END_STONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_SLAB, BlockusBlocks.POLISHED_END_STONE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_SLAB, Blocks.END_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_SLAB, BlockusBlocks.SMALL_END_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_WALL, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_WALL, BlockusBlocks.POLISHED_END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_WALL, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SMALL_END_STONE_BRICK_WALL, BlockusBlocks.SMALL_END_STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_END_STONE_BRICKS, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_END_STONE_BRICKS, BlockusBlocks.POLISHED_END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_END_STONE_BRICKS, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_END_STONE_BRICKS, BlockusBlocks.POLISHED_END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.END_STONE_PILLAR, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.END_STONE_PILLAR, BlockusBlocks.POLISHED_END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.END_STONE_PILLAR, Blocks.END_STONE_BRICKS);

        offerDecoratedRecipe(exporter, BlockusBlocks.PURPUR_DECORATED_END_STONE, Items.POPPED_CHORUS_FRUIT, Blocks.END_STONE_BRICKS);
        offerDecoratedRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_DECORATED_END_STONE, Items.POPPED_CHORUS_FRUIT, Blocks.END_STONE_BRICKS);

        // Rainbow
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICKS, BlockusBlocks.RAINBOW_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICK_STAIRS, BlockusBlocks.RAINBOW_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICK_STAIRS, BlockusBlocks.RAINBOW_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICK_SLAB, BlockusBlocks.RAINBOW_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICK_SLAB, BlockusBlocks.RAINBOW_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICK_WALL, BlockusBlocks.RAINBOW_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RAINBOW_BRICK_WALL, BlockusBlocks.RAINBOW_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.RAINBOW_BRICKS, BlockusBlocks.RAINBOW_BLOCK);

        // Colored Stone Bricks
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_STONE_BRICK_STAIRS, BlockusBlocks.WHITE_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_STONE_BRICK_SLAB, BlockusBlocks.WHITE_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_STONE_BRICK_WALL, BlockusBlocks.WHITE_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.WHITE_DYE, BlockusBlocks.WHITE_STONE_BRICKS, BlockusBlocks.WHITE_STONE_BRICK_STAIRS, BlockusBlocks.WHITE_STONE_BRICK_SLAB, BlockusBlocks.WHITE_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_STONE_BRICK_STAIRS, BlockusBlocks.ORANGE_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_STONE_BRICK_SLAB, BlockusBlocks.ORANGE_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_STONE_BRICK_WALL, BlockusBlocks.ORANGE_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.ORANGE_DYE, BlockusBlocks.ORANGE_STONE_BRICKS, BlockusBlocks.ORANGE_STONE_BRICK_STAIRS, BlockusBlocks.ORANGE_STONE_BRICK_SLAB, BlockusBlocks.ORANGE_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_STONE_BRICK_STAIRS, BlockusBlocks.MAGENTA_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_STONE_BRICK_SLAB, BlockusBlocks.MAGENTA_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_STONE_BRICK_WALL, BlockusBlocks.MAGENTA_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.MAGENTA_DYE, BlockusBlocks.MAGENTA_STONE_BRICKS, BlockusBlocks.MAGENTA_STONE_BRICK_STAIRS, BlockusBlocks.MAGENTA_STONE_BRICK_SLAB, BlockusBlocks.MAGENTA_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_STONE_BRICK_STAIRS, BlockusBlocks.LIGHT_BLUE_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_STONE_BRICK_SLAB, BlockusBlocks.LIGHT_BLUE_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_STONE_BRICK_WALL, BlockusBlocks.LIGHT_BLUE_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.LIGHT_BLUE_DYE, BlockusBlocks.LIGHT_BLUE_STONE_BRICKS, BlockusBlocks.LIGHT_BLUE_STONE_BRICK_STAIRS, BlockusBlocks.LIGHT_BLUE_STONE_BRICK_SLAB, BlockusBlocks.LIGHT_BLUE_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_STONE_BRICK_STAIRS, BlockusBlocks.YELLOW_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_STONE_BRICK_SLAB, BlockusBlocks.YELLOW_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_STONE_BRICK_WALL, BlockusBlocks.YELLOW_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.YELLOW_DYE, BlockusBlocks.YELLOW_STONE_BRICKS, BlockusBlocks.YELLOW_STONE_BRICK_STAIRS, BlockusBlocks.YELLOW_STONE_BRICK_SLAB, BlockusBlocks.YELLOW_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_STONE_BRICK_STAIRS, BlockusBlocks.LIME_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_STONE_BRICK_SLAB, BlockusBlocks.LIME_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_STONE_BRICK_WALL, BlockusBlocks.LIME_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.LIME_DYE, BlockusBlocks.LIME_STONE_BRICKS, BlockusBlocks.LIME_STONE_BRICK_STAIRS, BlockusBlocks.LIME_STONE_BRICK_SLAB, BlockusBlocks.LIME_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_STONE_BRICK_STAIRS, BlockusBlocks.PINK_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_STONE_BRICK_SLAB, BlockusBlocks.PINK_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_STONE_BRICK_WALL, BlockusBlocks.PINK_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.PINK_DYE, BlockusBlocks.PINK_STONE_BRICKS, BlockusBlocks.PINK_STONE_BRICK_STAIRS, BlockusBlocks.PINK_STONE_BRICK_SLAB, BlockusBlocks.PINK_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_STONE_BRICK_STAIRS, BlockusBlocks.GRAY_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_STONE_BRICK_SLAB, BlockusBlocks.GRAY_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_STONE_BRICK_WALL, BlockusBlocks.GRAY_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.GRAY_DYE, BlockusBlocks.GRAY_STONE_BRICKS, BlockusBlocks.GRAY_STONE_BRICK_STAIRS, BlockusBlocks.GRAY_STONE_BRICK_SLAB, BlockusBlocks.GRAY_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_STONE_BRICK_STAIRS, BlockusBlocks.CYAN_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_STONE_BRICK_SLAB, BlockusBlocks.CYAN_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_STONE_BRICK_WALL, BlockusBlocks.CYAN_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.CYAN_DYE, BlockusBlocks.CYAN_STONE_BRICKS, BlockusBlocks.CYAN_STONE_BRICK_STAIRS, BlockusBlocks.CYAN_STONE_BRICK_SLAB, BlockusBlocks.CYAN_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_STONE_BRICK_STAIRS, BlockusBlocks.PURPLE_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_STONE_BRICK_SLAB, BlockusBlocks.PURPLE_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_STONE_BRICK_WALL, BlockusBlocks.PURPLE_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.PURPLE_DYE, BlockusBlocks.PURPLE_STONE_BRICKS, BlockusBlocks.PURPLE_STONE_BRICK_STAIRS, BlockusBlocks.PURPLE_STONE_BRICK_SLAB, BlockusBlocks.PURPLE_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_STONE_BRICK_STAIRS, BlockusBlocks.BLUE_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_STONE_BRICK_SLAB, BlockusBlocks.BLUE_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_STONE_BRICK_WALL, BlockusBlocks.BLUE_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.BLUE_DYE, BlockusBlocks.BLUE_STONE_BRICKS, BlockusBlocks.BLUE_STONE_BRICK_STAIRS, BlockusBlocks.BLUE_STONE_BRICK_SLAB, BlockusBlocks.BLUE_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_STONE_BRICK_STAIRS, BlockusBlocks.BROWN_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_STONE_BRICK_SLAB, BlockusBlocks.BROWN_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_STONE_BRICK_WALL, BlockusBlocks.BROWN_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.BROWN_DYE, BlockusBlocks.BROWN_STONE_BRICKS, BlockusBlocks.BROWN_STONE_BRICK_STAIRS, BlockusBlocks.BROWN_STONE_BRICK_SLAB, BlockusBlocks.BROWN_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_STONE_BRICK_STAIRS, BlockusBlocks.GREEN_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_STONE_BRICK_SLAB, BlockusBlocks.GREEN_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_STONE_BRICK_WALL, BlockusBlocks.GREEN_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.GREEN_DYE, BlockusBlocks.GREEN_STONE_BRICKS, BlockusBlocks.GREEN_STONE_BRICK_STAIRS, BlockusBlocks.GREEN_STONE_BRICK_SLAB, BlockusBlocks.GREEN_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_STONE_BRICK_STAIRS, BlockusBlocks.RED_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_STONE_BRICK_SLAB, BlockusBlocks.RED_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_STONE_BRICK_WALL, BlockusBlocks.RED_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.RED_DYE, BlockusBlocks.RED_STONE_BRICKS, BlockusBlocks.RED_STONE_BRICK_STAIRS, BlockusBlocks.RED_STONE_BRICK_SLAB, BlockusBlocks.RED_STONE_BRICK_WALL);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_STONE_BRICK_STAIRS, BlockusBlocks.BLACK_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_STONE_BRICK_SLAB, BlockusBlocks.BLACK_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_STONE_BRICK_WALL, BlockusBlocks.BLACK_STONE_BRICKS);
        offerStainedStoneBricksRecipe(exporter, Items.BLACK_DYE, BlockusBlocks.BLACK_STONE_BRICKS, BlockusBlocks.BLACK_STONE_BRICK_STAIRS, BlockusBlocks.BLACK_STONE_BRICK_SLAB, BlockusBlocks.BLACK_STONE_BRICK_WALL);


        // Concrete
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_BRICKS, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_BRICK_STAIRS, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_BRICK_STAIRS, BlockusBlocks.WHITE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_BRICK_SLAB, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_BRICK_SLAB, BlockusBlocks.WHITE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_BRICK_WALL, Blocks.WHITE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_BRICK_WALL, BlockusBlocks.WHITE_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_WHITE_CONCRETE, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_WHITE_CONCRETE, BlockusBlocks.WHITE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_PILLAR, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_PILLAR, BlockusBlocks.WHITE_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_BRICKS, Blocks.WHITE_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_BRICKS, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_BRICK_STAIRS, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_BRICK_STAIRS, BlockusBlocks.ORANGE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_BRICK_SLAB, Blocks.ORANGE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_BRICK_SLAB, BlockusBlocks.ORANGE_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_BRICK_WALL, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_BRICK_WALL, BlockusBlocks.ORANGE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ORANGE_CONCRETE, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ORANGE_CONCRETE, BlockusBlocks.ORANGE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_PILLAR, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_PILLAR, BlockusBlocks.ORANGE_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_BRICKS, Blocks.ORANGE_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_BRICKS, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_BRICK_STAIRS, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_BRICK_STAIRS, BlockusBlocks.MAGENTA_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_BRICK_SLAB, Blocks.MAGENTA_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_BRICK_SLAB, BlockusBlocks.MAGENTA_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_BRICK_WALL, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_BRICK_WALL, BlockusBlocks.MAGENTA_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MAGENTA_CONCRETE, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MAGENTA_CONCRETE, BlockusBlocks.MAGENTA_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_PILLAR, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_PILLAR, BlockusBlocks.MAGENTA_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_BRICKS, Blocks.MAGENTA_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICK_STAIRS, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICK_STAIRS, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICK_SLAB, Blocks.LIGHT_BLUE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICK_SLAB, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICK_WALL, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICK_WALL, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIGHT_BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIGHT_BLUE_CONCRETE, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_PILLAR, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_PILLAR, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS, Blocks.LIGHT_BLUE_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_BRICKS, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_BRICK_STAIRS, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_BRICK_STAIRS, BlockusBlocks.YELLOW_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_BRICK_SLAB, Blocks.YELLOW_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_BRICK_SLAB, BlockusBlocks.YELLOW_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_BRICK_WALL, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_BRICK_WALL, BlockusBlocks.YELLOW_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_YELLOW_CONCRETE, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_YELLOW_CONCRETE, BlockusBlocks.YELLOW_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_PILLAR, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_PILLAR, BlockusBlocks.YELLOW_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_BRICKS, Blocks.YELLOW_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_BRICKS, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_BRICK_STAIRS, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_BRICK_STAIRS, BlockusBlocks.LIME_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_BRICK_SLAB, Blocks.LIME_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_BRICK_SLAB, BlockusBlocks.LIME_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_BRICK_WALL, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_BRICK_WALL, BlockusBlocks.LIME_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIME_CONCRETE, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIME_CONCRETE, BlockusBlocks.LIME_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_PILLAR, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_PILLAR, BlockusBlocks.LIME_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIME_CONCRETE_BRICKS, Blocks.LIME_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_BRICKS, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_BRICK_STAIRS, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_BRICK_STAIRS, BlockusBlocks.PINK_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_BRICK_SLAB, Blocks.PINK_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_BRICK_SLAB, BlockusBlocks.PINK_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PINK_CONCRETE, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PINK_CONCRETE, BlockusBlocks.PINK_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_PILLAR, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_PILLAR, BlockusBlocks.PINK_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_BRICK_WALL, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_BRICK_WALL, BlockusBlocks.PINK_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.PINK_CONCRETE_BRICKS, Blocks.PINK_CONCRETE);


        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_BRICKS, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_BRICK_STAIRS, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_BRICK_STAIRS, BlockusBlocks.GRAY_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_BRICK_SLAB, Blocks.GRAY_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_BRICK_SLAB, BlockusBlocks.GRAY_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_BRICK_WALL, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_BRICK_WALL, BlockusBlocks.GRAY_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRAY_CONCRETE, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRAY_CONCRETE, BlockusBlocks.GRAY_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_PILLAR, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_PILLAR, BlockusBlocks.GRAY_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_BRICKS, Blocks.GRAY_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICK_STAIRS, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICK_STAIRS, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICK_SLAB, Blocks.LIGHT_GRAY_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICK_SLAB, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICK_WALL, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICK_WALL, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIGHT_GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIGHT_GRAY_CONCRETE, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_PILLAR, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_PILLAR, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS, Blocks.LIGHT_GRAY_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_BRICKS, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_BRICK_STAIRS, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_BRICK_STAIRS, BlockusBlocks.CYAN_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_BRICK_SLAB, Blocks.CYAN_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_BRICK_SLAB, BlockusBlocks.CYAN_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_BRICK_WALL, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_BRICK_WALL, BlockusBlocks.CYAN_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_CYAN_CONCRETE, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_CYAN_CONCRETE, BlockusBlocks.CYAN_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_PILLAR, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_PILLAR, BlockusBlocks.CYAN_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_BRICKS, Blocks.CYAN_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_BRICKS, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_BRICK_STAIRS, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_BRICK_STAIRS, BlockusBlocks.PURPLE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_BRICK_SLAB, Blocks.PURPLE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_BRICK_SLAB, BlockusBlocks.PURPLE_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_BRICK_WALL, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_BRICK_WALL, BlockusBlocks.PURPLE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPLE_CONCRETE, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPLE_CONCRETE, BlockusBlocks.PURPLE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_PILLAR, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_PILLAR, BlockusBlocks.PURPLE_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_BRICKS, Blocks.PURPLE_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_BRICKS, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_BRICK_STAIRS, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_BRICK_STAIRS, BlockusBlocks.BLUE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_BRICK_SLAB, Blocks.BLUE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_BRICK_SLAB, BlockusBlocks.BLUE_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_BRICK_WALL, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_BRICK_WALL, BlockusBlocks.BLUE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUE_CONCRETE, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUE_CONCRETE, BlockusBlocks.BLUE_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_PILLAR, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_PILLAR, BlockusBlocks.BLUE_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_BRICKS, Blocks.BLUE_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_BRICKS, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_BRICK_STAIRS, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_BRICK_STAIRS, BlockusBlocks.BROWN_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_BRICK_SLAB, Blocks.BROWN_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_BRICK_SLAB, BlockusBlocks.BROWN_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_BRICK_WALL, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_BRICK_WALL, BlockusBlocks.BROWN_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BROWN_CONCRETE, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BROWN_CONCRETE, BlockusBlocks.BROWN_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_PILLAR, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_PILLAR, BlockusBlocks.BROWN_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_BRICKS, Blocks.BROWN_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_BRICKS, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_BRICK_STAIRS, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_BRICK_STAIRS, BlockusBlocks.GREEN_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_BRICK_SLAB, Blocks.GREEN_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_BRICK_SLAB, BlockusBlocks.GREEN_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_BRICK_WALL, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_BRICK_WALL, BlockusBlocks.GREEN_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GREEN_CONCRETE, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GREEN_CONCRETE, BlockusBlocks.GREEN_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_PILLAR, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_PILLAR, BlockusBlocks.GREEN_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_BRICKS, Blocks.GREEN_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_BRICKS, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_BRICK_STAIRS, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_BRICK_STAIRS, BlockusBlocks.RED_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_BRICK_SLAB, Blocks.RED_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_BRICK_SLAB, BlockusBlocks.RED_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_BRICK_WALL, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_BRICK_WALL, BlockusBlocks.RED_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_RED_CONCRETE, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_RED_CONCRETE, BlockusBlocks.RED_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_PILLAR, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_PILLAR, BlockusBlocks.RED_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.RED_CONCRETE_BRICKS, Blocks.RED_CONCRETE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_BRICKS, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_BRICK_STAIRS, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_BRICK_STAIRS, BlockusBlocks.BLACK_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_BRICK_SLAB, Blocks.BLACK_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_BRICK_SLAB, BlockusBlocks.BLACK_CONCRETE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_BRICK_WALL, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_BRICK_WALL, BlockusBlocks.BLACK_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLACK_CONCRETE, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLACK_CONCRETE, BlockusBlocks.BLACK_CONCRETE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_PILLAR, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_PILLAR, BlockusBlocks.BLACK_CONCRETE_BRICKS);
        offerCutCopperRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_BRICKS, Blocks.BLACK_CONCRETE);

        // Asphalt
        offerStonecuttingRecipe(exporter, BlockusBlocks.ASPHALT_STAIRS, BlockusBlocks.ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ASPHALT_SLAB, BlockusBlocks.ASPHALT, 2);
        ShapedRecipeJsonFactory.create(BlockusBlocks.ASPHALT, 8).input('X', Blocks.GRAVEL).input('#', ItemTags.COALS).pattern("XXX").pattern("X#X").pattern("XXX").group("asphalt").criterion(hasItem(Blocks.GRAVEL), conditionsFromItem(Blocks.GRAVEL)).offerTo(exporter);


        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_ASPHALT_STAIRS, BlockusBlocks.WHITE_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_ASPHALT_SLAB, BlockusBlocks.WHITE_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.WHITE_DYE, BlockusBlocks.WHITE_ASPHALT, BlockusBlocks.WHITE_ASPHALT_STAIRS, BlockusBlocks.WHITE_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_ASPHALT_STAIRS, BlockusBlocks.ORANGE_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_ASPHALT_SLAB, BlockusBlocks.ORANGE_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.ORANGE_DYE, BlockusBlocks.ORANGE_ASPHALT, BlockusBlocks.ORANGE_ASPHALT_STAIRS, BlockusBlocks.ORANGE_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_ASPHALT_STAIRS, BlockusBlocks.MAGENTA_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_ASPHALT_SLAB, BlockusBlocks.MAGENTA_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.MAGENTA_DYE, BlockusBlocks.MAGENTA_ASPHALT, BlockusBlocks.MAGENTA_ASPHALT_STAIRS, BlockusBlocks.MAGENTA_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_ASPHALT_STAIRS, BlockusBlocks.LIGHT_BLUE_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_ASPHALT_SLAB, BlockusBlocks.LIGHT_BLUE_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.LIGHT_BLUE_DYE, BlockusBlocks.LIGHT_BLUE_ASPHALT, BlockusBlocks.LIGHT_BLUE_ASPHALT_STAIRS, BlockusBlocks.LIGHT_BLUE_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_ASPHALT_STAIRS, BlockusBlocks.YELLOW_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_ASPHALT_SLAB, BlockusBlocks.YELLOW_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.YELLOW_DYE, BlockusBlocks.YELLOW_ASPHALT, BlockusBlocks.YELLOW_ASPHALT_STAIRS, BlockusBlocks.YELLOW_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_ASPHALT_STAIRS, BlockusBlocks.LIME_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_ASPHALT_SLAB, BlockusBlocks.LIME_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.LIME_DYE, BlockusBlocks.LIME_ASPHALT, BlockusBlocks.LIME_ASPHALT_STAIRS, BlockusBlocks.LIME_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_ASPHALT_STAIRS, BlockusBlocks.PINK_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_ASPHALT_SLAB, BlockusBlocks.PINK_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.PINK_DYE, BlockusBlocks.PINK_ASPHALT, BlockusBlocks.PINK_ASPHALT_STAIRS, BlockusBlocks.PINK_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_ASPHALT_STAIRS, BlockusBlocks.LIGHT_GRAY_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_ASPHALT_SLAB, BlockusBlocks.LIGHT_GRAY_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.LIGHT_GRAY_DYE, BlockusBlocks.LIGHT_GRAY_ASPHALT, BlockusBlocks.LIGHT_GRAY_ASPHALT_STAIRS, BlockusBlocks.LIGHT_GRAY_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_ASPHALT_STAIRS, BlockusBlocks.GRAY_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_ASPHALT_SLAB, BlockusBlocks.GRAY_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.GRAY_DYE, BlockusBlocks.GRAY_ASPHALT, BlockusBlocks.GRAY_ASPHALT_STAIRS, BlockusBlocks.GRAY_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_ASPHALT_STAIRS, BlockusBlocks.CYAN_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_ASPHALT_SLAB, BlockusBlocks.CYAN_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.CYAN_DYE, BlockusBlocks.CYAN_ASPHALT, BlockusBlocks.CYAN_ASPHALT_STAIRS, BlockusBlocks.CYAN_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_ASPHALT_STAIRS, BlockusBlocks.PURPLE_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_ASPHALT_SLAB, BlockusBlocks.PURPLE_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.PURPLE_DYE, BlockusBlocks.PURPLE_ASPHALT, BlockusBlocks.PURPLE_ASPHALT_STAIRS, BlockusBlocks.PURPLE_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_ASPHALT_STAIRS, BlockusBlocks.BLUE_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_ASPHALT_SLAB, BlockusBlocks.BLUE_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.BLUE_DYE, BlockusBlocks.BLUE_ASPHALT, BlockusBlocks.BLUE_ASPHALT_STAIRS, BlockusBlocks.BLUE_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_ASPHALT_STAIRS, BlockusBlocks.BROWN_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_ASPHALT_SLAB, BlockusBlocks.BROWN_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.BROWN_DYE, BlockusBlocks.BROWN_ASPHALT, BlockusBlocks.BROWN_ASPHALT_STAIRS, BlockusBlocks.BROWN_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_ASPHALT_STAIRS, BlockusBlocks.GREEN_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_ASPHALT_SLAB, BlockusBlocks.GREEN_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.GREEN_DYE, BlockusBlocks.GREEN_ASPHALT, BlockusBlocks.GREEN_ASPHALT_STAIRS, BlockusBlocks.GREEN_ASPHALT_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_ASPHALT_STAIRS, BlockusBlocks.RED_ASPHALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_ASPHALT_SLAB, BlockusBlocks.RED_ASPHALT, 2);
        offerAsphaltRecipe(exporter, Items.RED_DYE, BlockusBlocks.RED_ASPHALT, BlockusBlocks.RED_ASPHALT_STAIRS, BlockusBlocks.RED_ASPHALT_SLAB);

        // Shingles
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_SHINGLES, Blocks.WHITE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_SHINGLES_STAIRS, Blocks.WHITE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_SHINGLES_STAIRS, BlockusBlocks.WHITE_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_SHINGLES_SLAB, Blocks.WHITE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_SHINGLES_SLAB, BlockusBlocks.WHITE_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.WHITE_SHINGLES, Blocks.WHITE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.WHITE_DYE, BlockusBlocks.WHITE_SHINGLES, BlockusBlocks.WHITE_SHINGLES_STAIRS, BlockusBlocks.WHITE_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_SHINGLES, Blocks.ORANGE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_SHINGLES_STAIRS, Blocks.ORANGE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_SHINGLES_STAIRS, BlockusBlocks.ORANGE_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_SHINGLES_SLAB, Blocks.ORANGE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_SHINGLES_SLAB, BlockusBlocks.ORANGE_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.ORANGE_SHINGLES, Blocks.ORANGE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.ORANGE_DYE, BlockusBlocks.ORANGE_SHINGLES, BlockusBlocks.ORANGE_SHINGLES_STAIRS, BlockusBlocks.ORANGE_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_SHINGLES, Blocks.MAGENTA_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_SHINGLES_STAIRS, Blocks.MAGENTA_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_SHINGLES_STAIRS, BlockusBlocks.MAGENTA_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_SHINGLES_SLAB, Blocks.MAGENTA_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_SHINGLES_SLAB, BlockusBlocks.MAGENTA_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.MAGENTA_SHINGLES, Blocks.MAGENTA_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.MAGENTA_DYE, BlockusBlocks.MAGENTA_SHINGLES, BlockusBlocks.MAGENTA_SHINGLES_STAIRS, BlockusBlocks.MAGENTA_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_SHINGLES, Blocks.LIGHT_BLUE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_SHINGLES_STAIRS, Blocks.LIGHT_BLUE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_SHINGLES_STAIRS, BlockusBlocks.LIGHT_BLUE_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_SHINGLES_SLAB, Blocks.LIGHT_BLUE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_SHINGLES_SLAB, BlockusBlocks.LIGHT_BLUE_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIGHT_BLUE_SHINGLES, Blocks.LIGHT_BLUE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIGHT_BLUE_DYE, BlockusBlocks.LIGHT_BLUE_SHINGLES, BlockusBlocks.LIGHT_BLUE_SHINGLES_STAIRS, BlockusBlocks.LIGHT_BLUE_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_SHINGLES, Blocks.YELLOW_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_SHINGLES_STAIRS, Blocks.YELLOW_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_SHINGLES_STAIRS, BlockusBlocks.YELLOW_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_SHINGLES_SLAB, Blocks.YELLOW_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_SHINGLES_SLAB, BlockusBlocks.YELLOW_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.YELLOW_SHINGLES, Blocks.YELLOW_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.YELLOW_DYE, BlockusBlocks.YELLOW_SHINGLES, BlockusBlocks.YELLOW_SHINGLES_STAIRS, BlockusBlocks.YELLOW_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_SHINGLES, Blocks.LIME_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_SHINGLES_STAIRS, Blocks.LIME_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_SHINGLES_STAIRS, BlockusBlocks.LIME_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_SHINGLES_SLAB, Blocks.LIME_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_SHINGLES_SLAB, BlockusBlocks.LIME_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIME_SHINGLES, Blocks.LIME_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIME_DYE, BlockusBlocks.LIME_SHINGLES, BlockusBlocks.LIME_SHINGLES_STAIRS, BlockusBlocks.LIME_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_SHINGLES, Blocks.PINK_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_SHINGLES_STAIRS, Blocks.PINK_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_SHINGLES_STAIRS, BlockusBlocks.PINK_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_SHINGLES_SLAB, Blocks.PINK_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_SHINGLES_SLAB, BlockusBlocks.PINK_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.PINK_SHINGLES, Blocks.PINK_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.PINK_DYE, BlockusBlocks.PINK_SHINGLES, BlockusBlocks.PINK_SHINGLES_STAIRS, BlockusBlocks.PINK_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_SHINGLES, Blocks.LIGHT_GRAY_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_SHINGLES_STAIRS, Blocks.LIGHT_GRAY_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_SHINGLES_STAIRS, BlockusBlocks.LIGHT_GRAY_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_SHINGLES_SLAB, Blocks.LIGHT_GRAY_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_SHINGLES_SLAB, BlockusBlocks.LIGHT_GRAY_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIGHT_GRAY_SHINGLES, Blocks.LIGHT_GRAY_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIGHT_GRAY_DYE, BlockusBlocks.LIGHT_GRAY_SHINGLES, BlockusBlocks.LIGHT_GRAY_SHINGLES_STAIRS, BlockusBlocks.LIGHT_GRAY_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_SHINGLES, Blocks.GRAY_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_SHINGLES_STAIRS, Blocks.GRAY_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_SHINGLES_STAIRS, BlockusBlocks.GRAY_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_SHINGLES_SLAB, Blocks.GRAY_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_SHINGLES_SLAB, BlockusBlocks.GRAY_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.GRAY_SHINGLES, Blocks.GRAY_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.GRAY_DYE, BlockusBlocks.GRAY_SHINGLES, BlockusBlocks.GRAY_SHINGLES_STAIRS, BlockusBlocks.GRAY_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_SHINGLES, Blocks.CYAN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_SHINGLES_STAIRS, Blocks.CYAN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_SHINGLES_STAIRS, BlockusBlocks.CYAN_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_SHINGLES_SLAB, Blocks.CYAN_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_SHINGLES_SLAB, BlockusBlocks.CYAN_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.CYAN_SHINGLES, Blocks.CYAN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.CYAN_DYE, BlockusBlocks.CYAN_SHINGLES, BlockusBlocks.CYAN_SHINGLES_STAIRS, BlockusBlocks.CYAN_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_SHINGLES, Blocks.PURPLE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_SHINGLES_STAIRS, Blocks.PURPLE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_SHINGLES_STAIRS, BlockusBlocks.PURPLE_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_SHINGLES_SLAB, Blocks.PURPLE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_SHINGLES_SLAB, BlockusBlocks.PURPLE_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.PURPLE_SHINGLES, Blocks.PURPLE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.PURPLE_DYE, BlockusBlocks.PURPLE_SHINGLES, BlockusBlocks.PURPLE_SHINGLES_STAIRS, BlockusBlocks.PURPLE_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_SHINGLES, Blocks.BLUE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_SHINGLES_STAIRS, Blocks.BLUE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_SHINGLES_STAIRS, BlockusBlocks.BLUE_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_SHINGLES_SLAB, Blocks.BLUE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_SHINGLES_SLAB, BlockusBlocks.BLUE_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.BLUE_SHINGLES, Blocks.BLUE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BLUE_DYE, BlockusBlocks.BLUE_SHINGLES, BlockusBlocks.BLUE_SHINGLES_STAIRS, BlockusBlocks.BLUE_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_SHINGLES, Blocks.BROWN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_SHINGLES_STAIRS, Blocks.BROWN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_SHINGLES_STAIRS, BlockusBlocks.BROWN_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_SHINGLES_SLAB, Blocks.BROWN_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_SHINGLES_SLAB, BlockusBlocks.BROWN_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.BROWN_SHINGLES, Blocks.BROWN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BROWN_DYE, BlockusBlocks.BROWN_SHINGLES, BlockusBlocks.BROWN_SHINGLES_STAIRS, BlockusBlocks.BROWN_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_SHINGLES, Blocks.GREEN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_SHINGLES_STAIRS, Blocks.GREEN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_SHINGLES_STAIRS, BlockusBlocks.GREEN_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_SHINGLES_SLAB, Blocks.GREEN_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_SHINGLES_SLAB, BlockusBlocks.GREEN_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.GREEN_SHINGLES, Blocks.GREEN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.GREEN_DYE, BlockusBlocks.GREEN_SHINGLES, BlockusBlocks.GREEN_SHINGLES_STAIRS, BlockusBlocks.GREEN_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SHINGLES, Blocks.RED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SHINGLES_STAIRS, Blocks.RED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SHINGLES_STAIRS, BlockusBlocks.RED_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SHINGLES_SLAB, Blocks.RED_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SHINGLES_SLAB, BlockusBlocks.RED_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.RED_SHINGLES, Blocks.RED_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.RED_DYE, BlockusBlocks.RED_SHINGLES, BlockusBlocks.RED_SHINGLES_STAIRS, BlockusBlocks.RED_SHINGLES_SLAB);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_SHINGLES, Blocks.BLACK_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_SHINGLES_STAIRS, Blocks.BLACK_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_SHINGLES_STAIRS, BlockusBlocks.BLACK_SHINGLES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_SHINGLES_SLAB, Blocks.BLACK_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_SHINGLES_SLAB, BlockusBlocks.BLACK_SHINGLES, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.BLACK_SHINGLES, Blocks.BLACK_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BLACK_DYE, BlockusBlocks.BLACK_SHINGLES, BlockusBlocks.BLACK_SHINGLES_STAIRS, BlockusBlocks.BLACK_SHINGLES_SLAB);

        // Colored Tiles
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_COLORED_TILES, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_COLORED_TILES, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_COLORED_TILES, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_COLORED_TILES, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_COLORED_TILES, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_COLORED_TILES, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_COLORED_TILES, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_COLORED_TILES, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_COLORED_TILES, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_COLORED_TILES, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_COLORED_TILES, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_COLORED_TILES, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_COLORED_TILES, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_COLORED_TILES, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_COLORED_TILES, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_COLORED_TILES, Blocks.BLACK_CONCRETE);

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

        // Plating
        offerStonecuttingRecipe(exporter, BlockusBlocks.IRON_PLATING_STAIRS, BlockusBlocks.IRON_PLATING);
        offerStonecuttingRecipe(exporter, BlockusBlocks.IRON_PLATING_SLAB, BlockusBlocks.IRON_PLATING, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GOLD_PLATING_STAIRS, BlockusBlocks.GOLD_PLATING);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GOLD_PLATING_SLAB, BlockusBlocks.GOLD_PLATING, 2);

        // Netherite Blocks
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERITE_SLAB, Blocks.NETHERITE_BLOCK, 2);

        // Legacy
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK, Blocks.GRASS_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_GRASS_BLOCK, Blocks.GRASS_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_LEAVES, Blocks.OAK_LEAVES);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_BRICKS, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_PLANKS, Blocks.OAK_PLANKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_FIRST_COBBLESTONE, Blocks.COBBLESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_COBBLESTONE, Blocks.COBBLESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_GRAVEL, Blocks.GRAVEL);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_IRON_BLOCK, Blocks.IRON_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_GOLD_BLOCK, Blocks.GOLD_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.EXPLOSION_PROOF_LEGACY_GOLD_BLOCK, Blocks.GOLD_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.EXPLOSION_PROOF_LEGACY_GOLD_BLOCK, BlockusBlocks.LEGACY_GOLD_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_COAL_BLOCK, Blocks.COAL_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_DIAMOND_BLOCK, Blocks.DIAMOND_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_LAPIS_BLOCK, Blocks.LAPIS_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_SPONGE, Blocks.SPONGE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_CRYING_OBSIDIAN, Blocks.CRYING_OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_GLOWSTONE, Blocks.GLOWSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LEGACY_GLOWING_OBSIDIAN, BlockusBlocks.GLOWING_OBSIDIAN);
    }

    public static void offerSturdyRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input1, ItemConvertible input2) {
        ShapedRecipeJsonFactory.create(output, 2).input('#', input1).input('X', input2).pattern("X#X").pattern("# #").pattern("X#X").criterion(hasItem(input1), conditionsFromItem(input1)).criterion(hasItem(input2), conditionsFromItem(input2)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(output, 2).input('#', input1).input('X', input2).pattern("#X#").pattern("X X").pattern("#X#").criterion(hasItem(input1), conditionsFromItem(input1)).criterion(hasItem(input2), conditionsFromItem(input2)).offerTo(exporter, getRecipeName(output) + "_alt");

    }

    public static void offerDecoratedRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible decoration, ItemConvertible input) {
        ShapedRecipeJsonFactory.create(output, 4).input('#', decoration).input('X', input).pattern("##").pattern("XX").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerPhantomPurpurRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonFactory.create(output).input(input).input(BlockusItemTags.SOUL_SOILS).criterion("has_purpur", conditionsFromItem(input)).offerTo(exporter, convertBetween(output, Blocks.SOUL_SAND));;

    }

    public static CraftingRecipeJsonFactory createEnclosedRecipe(ItemConvertible output, Ingredient input, ItemConvertible center) {
        return ShapedRecipeJsonFactory.create(output, 8).input('X', input).input('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
    }

    public static void offerStainedStoneBricksRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab, ItemConvertible output_wall) {
        createEnclosedRecipe(output, Ingredient.ofItems(Blocks.STONE_BRICKS), center).group("stained_stone_bricks").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(Blocks.STONE_BRICK_STAIRS), center).group("stained_stone_brick_stairs").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_stairs, Blocks.STONE_BRICK_STAIRS));;
        createEnclosedRecipe(output_slab, Ingredient.ofItems(Blocks.STONE_BRICK_SLAB), center).group("stained_stone_brick_slab").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_slab, Blocks.STONE_BRICK_SLAB));;
        createEnclosedRecipe(output_wall, Ingredient.ofItems(Blocks.STONE_BRICK_WALL), center).group("stained_stone_brick_wall").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_wall, Blocks.STONE_BRICK_WALL));;
    }

    public static void offerAsphaltRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab) {
        createEnclosedRecipe(output, Ingredient.ofItems(BlockusBlocks.ASPHALT), center).group("asphalt").criterion(hasItem(BlockusBlocks.ASPHALT), conditionsFromItem(BlockusBlocks.ASPHALT)).offerTo(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(BlockusBlocks.ASPHALT_STAIRS), center).group("asphalt_stairs").criterion(hasItem(BlockusBlocks.ASPHALT), conditionsFromItem(BlockusBlocks.ASPHALT)).offerTo(exporter, convertBetween(output_stairs, BlockusBlocks.ASPHALT_STAIRS));;
        createEnclosedRecipe(output_slab, Ingredient.ofItems(BlockusBlocks.ASPHALT_SLAB), center).group("asphalt_slab").criterion(hasItem(BlockusBlocks.ASPHALT), conditionsFromItem(BlockusBlocks.ASPHALT)).offerTo(exporter, convertBetween(output_slab, BlockusBlocks.ASPHALT_SLAB));;
    }

    public static void offerShinglesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab) {
        createEnclosedRecipe(output, Ingredient.ofItems(BlockusBlocks.SHINGLES), center).group("shingles").criterion(hasItem(BlockusBlocks.SHINGLES), conditionsFromItem(BlockusBlocks.SHINGLES)).offerTo(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(BlockusBlocks.SHINGLES_STAIRS), center).group("shingles_stairs").criterion(hasItem(BlockusBlocks.SHINGLES), conditionsFromItem(BlockusBlocks.SHINGLES)).offerTo(exporter, convertBetween(output_stairs, BlockusBlocks.SHINGLES_STAIRS));;
        createEnclosedRecipe(output_slab, Ingredient.ofItems(BlockusBlocks.SHINGLES_SLAB), center).group("shingles_slab").criterion(hasItem(BlockusBlocks.SHINGLES), conditionsFromItem(BlockusBlocks.SHINGLES)).offerTo(exporter, convertBetween(output_slab, BlockusBlocks.SHINGLES_SLAB));;
    }

    public static void offerStairsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
}
