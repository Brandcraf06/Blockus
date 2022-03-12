
package com.brand.blockus.data.provider;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.content.types.*;
import com.brand.blockus.data.family.BlockusBlockFamilies;
import com.brand.blockus.tag.BlockusItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipesProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.RecipesProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;

import java.util.function.Consumer;

public class BlockusRecipesProvider extends FabricRecipesProvider {
    public BlockusRecipesProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        for (BSSWTypes bsswType : BSSWTypes.values()) {
            BlockusRecipesProvider.offerStairsRecipe(exporter, bsswType.stairs, bsswType.block);
            RecipesProvider.offerSlabRecipe(exporter, bsswType.slab, bsswType.block);
            RecipesProvider.offerWallRecipe(exporter, bsswType.wall, bsswType.block);
        }

        for (BSSTypes bssType : BSSTypes.values()) {
            BlockusRecipesProvider.offerStairsRecipe(exporter, bssType.stairs, bssType.block);
            RecipesProvider.offerSlabRecipe(exporter, bssType.slab, bssType.block);
        }

        for (TimberFrameTypesB timberFrameType : TimberFrameTypesB.values()) {
            ShapedRecipeJsonFactory.create(timberFrameType.block).input('#',  Items.PAPER).input('X',  timberFrameType.base).pattern("#X").pattern("X#").group("timber_frame").criterion(hasItem(timberFrameType.base), conditionsFromItem(timberFrameType.base)).offerTo(exporter);
            ShapedRecipeJsonFactory.create(timberFrameType.diagonal).input('#', timberFrameType.block).pattern("##").pattern("##").group("diagonal_timber_frame").criterion(hasItem(timberFrameType.block), conditionsFromItem(timberFrameType.block)).offerTo(exporter);
            ShapedRecipeJsonFactory.create(timberFrameType.cross).input('#', timberFrameType.diagonal).pattern("##").pattern("##").group("cross_timber_frame").criterion(hasItem(timberFrameType.diagonal), conditionsFromItem(timberFrameType.diagonal)).offerTo(exporter);
        }

        for (TimberFrameTypesNB timberFrameType : TimberFrameTypesNB.values()) {
            ShapedRecipeJsonFactory.create(timberFrameType.block).input('#',  Items.PAPER).input('X',  timberFrameType.base).pattern("#X").pattern("X#").group("timber_frame").criterion(hasItem(timberFrameType.base), conditionsFromItem(timberFrameType.base)).offerTo(exporter);
            ShapedRecipeJsonFactory.create(timberFrameType.diagonal).input('#', timberFrameType.block).pattern("##").pattern("##").group("diagonal_timber_frame").criterion(hasItem(timberFrameType.block), conditionsFromItem(timberFrameType.block)).offerTo(exporter);
            ShapedRecipeJsonFactory.create(timberFrameType.cross).input('#', timberFrameType.diagonal).pattern("##").pattern("##").group("cross_timber_frame").criterion(hasItem(timberFrameType.diagonal), conditionsFromItem(timberFrameType.diagonal)).offerTo(exporter);
        }

        for (AsphaltTypes asphaltType : AsphaltTypes.values()) {
            BlockusRecipesProvider.offerStairsRecipe(exporter, asphaltType.stairs, asphaltType.block);
            RecipesProvider.offerSlabRecipe(exporter, asphaltType.slab, asphaltType.block);

        }

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
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.block, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.block, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.stairs, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.stairs, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.stairs, BSSWTypes.ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.slab, Blocks.ANDESITE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.slab, Blocks.POLISHED_ANDESITE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.slab, BSSWTypes.ANDESITE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.wall, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.wall, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.ANDESITE_BRICKS.wall, BSSWTypes.ANDESITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_ANDESITE, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_ANDESITE, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_ANDESITE, BSSWTypes.ANDESITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ANDESITE_BRICKS, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ANDESITE_BRICKS, BSSWTypes.ANDESITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_ANDESITE_PILLAR, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_ANDESITE_PILLAR, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_ANDESITE_PILLAR, BSSWTypes.ANDESITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_CIRCLE_PAVEMENT, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_CIRCLE_PAVEMENT, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ANDESITE_CIRCLE_PAVEMENT, BSSWTypes.ANDESITE_BRICKS.block);

        // Diorite
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.block, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.block, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.stairs, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.stairs, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.stairs, BSSWTypes.DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.slab, Blocks.DIORITE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.slab, Blocks.POLISHED_DIORITE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.slab, BSSWTypes.DIORITE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.wall, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.wall, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.DIORITE_BRICKS.wall, BSSWTypes.DIORITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_DIORITE, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_DIORITE, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_DIORITE, BSSWTypes.DIORITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DIORITE_BRICKS, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DIORITE_BRICKS, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DIORITE_BRICKS, BSSWTypes.DIORITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DIORITE_PILLAR, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DIORITE_PILLAR, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_DIORITE_PILLAR, BSSWTypes.DIORITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_CIRCLE_PAVEMENT, Blocks.DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_CIRCLE_PAVEMENT, Blocks.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DIORITE_CIRCLE_PAVEMENT, BSSWTypes.DIORITE_BRICKS.block);

        // Granite
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.block, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.block, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.stairs, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.stairs, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.stairs, BSSWTypes.GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.slab, Blocks.GRANITE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.slab, Blocks.POLISHED_GRANITE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.slab, BSSWTypes.GRANITE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.wall, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.wall, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRANITE_BRICKS.wall, BSSWTypes.GRANITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_GRANITE, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_GRANITE, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_GRANITE, BSSWTypes.GRANITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRANITE_BRICKS, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRANITE_BRICKS, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRANITE_BRICKS, BSSWTypes.GRANITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_GRANITE_PILLAR, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_GRANITE_PILLAR, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_GRANITE_PILLAR, BSSWTypes.GRANITE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_CIRCLE_PAVEMENT, Blocks.GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_CIRCLE_PAVEMENT, Blocks.POLISHED_GRANITE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRANITE_CIRCLE_PAVEMENT, BSSWTypes.GRANITE_BRICKS.block);

        // Dripstone
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_DRIPSTONE.block, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_DRIPSTONE.stairs, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_DRIPSTONE.stairs, BSSTypes.POLISHED_DRIPSTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_DRIPSTONE.slab, Blocks.DRIPSTONE_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_DRIPSTONE.slab, BSSTypes.POLISHED_DRIPSTONE.block, 2);
        offerPolishedStoneRecipe(exporter, BSSTypes.POLISHED_DRIPSTONE.block, Blocks.DRIPSTONE_BLOCK);


        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.block, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.block, BSSTypes.POLISHED_DRIPSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.stairs, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.stairs, BSSTypes.POLISHED_DRIPSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.stairs, BSSWTypes.DRIPSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.slab, Blocks.DRIPSTONE_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.slab, BSSTypes.POLISHED_DRIPSTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.slab, BSSWTypes.DRIPSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.wall, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.wall, BSSTypes.POLISHED_DRIPSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.DRIPSTONE_BRICKS.wall, BSSWTypes.DRIPSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DRIPSTONE, BSSTypes.POLISHED_DRIPSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DRIPSTONE, BSSWTypes.DRIPSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_PILLAR, Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_PILLAR, BSSTypes.POLISHED_DRIPSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DRIPSTONE_PILLAR, BSSWTypes.DRIPSTONE_BRICKS.block);

        // Tuff
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_TUFF.block, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_TUFF.stairs, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_TUFF.stairs, BSSTypes.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_TUFF.slab, Blocks.TUFF, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_TUFF.slab, BSSTypes.POLISHED_TUFF.block, 2);
        offerPolishedStoneRecipe(exporter, BSSTypes.POLISHED_TUFF.block, Blocks.TUFF);


        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.block, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.block, BSSTypes.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.stairs, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.stairs, BSSTypes.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.stairs, BSSWTypes.TUFF_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.slab, Blocks.TUFF, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.slab, BSSTypes.POLISHED_TUFF.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.slab, BSSWTypes.TUFF_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.wall, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.wall, BSSTypes.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.TUFF_BRICKS.wall, BSSWTypes.TUFF_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_TUFF, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_TUFF, BSSTypes.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_TUFF, BSSWTypes.TUFF_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_PILLAR, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_PILLAR, BSSTypes.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_PILLAR, BSSWTypes.TUFF_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_TUFF, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_TUFF, BSSTypes.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_TUFF, BSSWTypes.TUFF_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_CIRCLE_PAVEMENT, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_CIRCLE_PAVEMENT, BSSTypes.POLISHED_TUFF.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TUFF_CIRCLE_PAVEMENT, BSSWTypes.TUFF_BRICKS.block);


        // Amethyst
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST_STAIRS, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST_STAIRS, BlockusBlocks.POLISHED_AMETHYST);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST_SLAB, Blocks.AMETHYST_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST_SLAB, BlockusBlocks.POLISHED_AMETHYST, 2);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_AMETHYST, Blocks.AMETHYST_BLOCK);

        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICKS, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICKS, BlockusBlocks.POLISHED_AMETHYST);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICK_STAIRS, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICK_STAIRS, BlockusBlocks.POLISHED_AMETHYST);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICK_STAIRS, BlockusBlocks.AMETHYST_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICK_SLAB, Blocks.AMETHYST_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICK_SLAB, BlockusBlocks.POLISHED_AMETHYST, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICK_SLAB, BlockusBlocks.AMETHYST_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICK_WALL, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICK_WALL, BlockusBlocks.POLISHED_AMETHYST);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_BRICK_WALL, BlockusBlocks.AMETHYST_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_AMETHYST, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_AMETHYST, BlockusBlocks.POLISHED_AMETHYST);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_AMETHYST, BlockusBlocks.AMETHYST_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_PILLAR, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_PILLAR, BlockusBlocks.POLISHED_AMETHYST);
        offerStonecuttingRecipe(exporter, BlockusBlocks.AMETHYST_PILLAR, BlockusBlocks.AMETHYST_BRICKS);


        // Deepslate
        ShapelessRecipeJsonFactory.create(BSSWTypes.MOSSY_DEEPSLATE_BRICKS.block).input(Blocks.DEEPSLATE_BRICKS).input(Blocks.VINE).group("mossy_deepslate_bricks").criterion("has_vine", conditionsFromItem(Blocks.VINE)).offerTo(exporter, convertBetween(BSSWTypes.MOSSY_DEEPSLATE_BRICKS.block, Blocks.VINE));
        ShapelessRecipeJsonFactory.create(BSSWTypes.MOSSY_DEEPSLATE_BRICKS.block).input(Blocks.DEEPSLATE_BRICKS).input(Blocks.MOSS_BLOCK).group("mossy_deepslate_bricks").criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK)).offerTo(exporter, convertBetween(BSSWTypes.MOSSY_DEEPSLATE_BRICKS.block, Blocks.MOSS_BLOCK));
        offerStonecuttingRecipe(exporter, BSSWTypes.MOSSY_DEEPSLATE_BRICKS.stairs, BSSWTypes.MOSSY_DEEPSLATE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MOSSY_DEEPSLATE_BRICKS.slab, BSSWTypes.MOSSY_DEEPSLATE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MOSSY_DEEPSLATE_BRICKS.wall, BSSWTypes.MOSSY_DEEPSLATE_BRICKS.block);

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

        ShapelessRecipeJsonFactory.create(BSSWTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.block).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(Blocks.CRIMSON_ROOTS).criterion("has_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BSSWTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.stairs, BSSWTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.slab, BSSWTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.wall, BSSWTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.block);

        ShapelessRecipeJsonFactory.create(BSSWTypes.WARPED_WARTY_BLACKSTONE_BRICKS.block).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(BlockusItemTags.WARPED_NETHER_GRASS).criterion("has_roots", conditionsFromTag(BlockusItemTags.WARPED_NETHER_GRASS)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BSSWTypes.WARPED_WARTY_BLACKSTONE_BRICKS.stairs, BSSWTypes.WARPED_WARTY_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.WARPED_WARTY_BLACKSTONE_BRICKS.slab, BSSWTypes.WARPED_WARTY_BLACKSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.WARPED_WARTY_BLACKSTONE_BRICKS.wall, BSSWTypes.WARPED_WARTY_BLACKSTONE_BRICKS.block);

        offerSturdyRecipe(exporter, BlockusBlocks.STURDY_BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE, Items.GOLD_INGOT, Blocks.POLISHED_BLACKSTONE);


        // Basalt
        offerStonecuttingRecipe(exporter, BSSTypes.ROUGH_BASALT.stairs, BSSTypes.ROUGH_BASALT.block);
        offerStonecuttingRecipe(exporter, BSSTypes.ROUGH_BASALT.slab, BSSTypes.ROUGH_BASALT.block, 2);
        ShapedRecipeJsonFactory.create(BSSTypes.ROUGH_BASALT.block, 2).input('#', Blocks.BASALT).pattern("#").pattern("#").criterion("has_basalt", conditionsFromItem(Blocks.BASALT)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.block, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.block, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.stairs, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.stairs, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.stairs, BSSWTypes.POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.slab, Blocks.BASALT, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.slab, Blocks.POLISHED_BASALT, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.slab, BSSWTypes.POLISHED_BASALT_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.wall, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.wall, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BSSWTypes.POLISHED_BASALT_BRICKS.wall, BSSWTypes.POLISHED_BASALT_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_PILLAR, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_PILLAR, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_PILLAR, BSSWTypes.POLISHED_BASALT_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_POLISHED_BASALT, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_POLISHED_BASALT, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_POLISHED_BASALT, BSSWTypes.POLISHED_BASALT_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_POLISHED_BASALT, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_POLISHED_BASALT, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_POLISHED_BASALT, BSSWTypes.POLISHED_BASALT_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_CIRCLE_PAVEMENT, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_CIRCLE_PAVEMENT, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_BASALT_CIRCLE_PAVEMENT, BSSWTypes.POLISHED_BASALT_BRICKS.block);

        // Limestone
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE.stairs, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE.slab, BSSWTypes.LIMESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE.wall, BSSWTypes.LIMESTONE.block);
        ShapedRecipeJsonFactory.create(BSSWTypes.LIMESTONE.block).input('#',  Blocks.COBBLESTONE).input('X',  Items.BONE_MEAL).pattern("#X").pattern("X#").criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_LIMESTONE.block, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_LIMESTONE.stairs, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_LIMESTONE.stairs, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_LIMESTONE.slab, BSSWTypes.LIMESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_LIMESTONE.slab, BSSTypes.POLISHED_LIMESTONE.block, 2);

        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.block, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.block, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.stairs, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.stairs, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.stairs, BSSWTypes.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.slab, BSSWTypes.LIMESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.slab, BSSTypes.POLISHED_LIMESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.slab, BSSWTypes.LIMESTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.wall, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.wall, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_BRICKS.wall, BSSWTypes.LIMESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.block, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.block, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.block, BSSWTypes.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.stairs, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.stairs, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.stairs, BSSWTypes.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.stairs, BSSWTypes.SMALL_LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.slab, BSSWTypes.LIMESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.slab, BSSTypes.POLISHED_LIMESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.slab, BSSWTypes.LIMESTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.slab, BSSWTypes.SMALL_LIMESTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.wall, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.wall, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.wall, BSSWTypes.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_LIMESTONE_BRICKS.wall, BSSWTypes.SMALL_LIMESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.block, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.block, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.block, BSSWTypes.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.stairs, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.stairs, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.stairs, BSSWTypes.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.stairs, BSSWTypes.LIMESTONE_TILES.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.slab, BSSWTypes.LIMESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.slab, BSSTypes.POLISHED_LIMESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.slab, BSSWTypes.LIMESTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.slab, BSSWTypes.LIMESTONE_TILES.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.wall, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.wall, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.wall, BSSWTypes.LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIMESTONE_TILES.wall, BSSWTypes.LIMESTONE_TILES.block);
        offerCutCopperRecipe(exporter, BSSWTypes.LIMESTONE_TILES.block, BSSWTypes.LIMESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIMESTONE, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIMESTONE, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIMESTONE, BSSWTypes.LIMESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_PILLAR, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_PILLAR, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_PILLAR, BSSWTypes.LIMESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_SQUARES, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_SQUARES, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_SQUARES, BSSWTypes.LIMESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_CIRCLE_PAVEMENT, BSSWTypes.LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_CIRCLE_PAVEMENT, BSSTypes.POLISHED_LIMESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIMESTONE_CIRCLE_PAVEMENT, BSSWTypes.LIMESTONE_BRICKS.block);

        // Marble
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE.stairs, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE.slab, BSSWTypes.MARBLE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE.wall, BSSWTypes.MARBLE.block);
        ShapedRecipeJsonFactory.create(BSSWTypes.MARBLE.block).input('#',  BSSWTypes.LIMESTONE.block).input('X',  Items.BONE_MEAL).pattern("#X").pattern("X#").group("marble").criterion(hasItem(BSSWTypes.LIMESTONE.block), conditionsFromItem(BSSWTypes.LIMESTONE.block)).offerTo(exporter);
        ShapelessRecipeJsonFactory.create(BSSWTypes.MARBLE.block).input(Blocks.CALCITE).input(BSSWTypes.LIMESTONE.block).group("marble").criterion(hasItem(Blocks.CALCITE), conditionsFromItem(Blocks.CALCITE)).offerTo(exporter, convertBetween(BSSWTypes.MARBLE.block, Blocks.CALCITE));

        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_MARBLE.block, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_MARBLE.stairs, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_MARBLE.stairs, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_MARBLE.slab, BSSWTypes.MARBLE.block, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_MARBLE.slab, BSSTypes.POLISHED_MARBLE.block, 2);

        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.block, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.block, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.stairs, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.stairs, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.stairs, BSSWTypes.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.slab, BSSWTypes.MARBLE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.slab, BSSTypes.POLISHED_MARBLE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.slab, BSSWTypes.MARBLE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.wall, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.wall, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_BRICKS.wall, BSSWTypes.MARBLE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.block, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.block, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.block, BSSWTypes.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.stairs, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.stairs, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.stairs, BSSWTypes.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.stairs, BSSWTypes.SMALL_MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.slab, BSSWTypes.MARBLE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.slab, BSSTypes.POLISHED_MARBLE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.slab, BSSWTypes.MARBLE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.slab, BSSWTypes.SMALL_MARBLE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.wall, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.wall, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.wall, BSSWTypes.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MARBLE_BRICKS.wall, BSSWTypes.SMALL_MARBLE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.block, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.block, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.block, BSSWTypes.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.stairs, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.stairs, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.stairs, BSSWTypes.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.stairs, BSSWTypes.MARBLE_TILES.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.slab, BSSWTypes.MARBLE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.slab, BSSTypes.POLISHED_MARBLE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.slab, BSSWTypes.MARBLE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.slab, BSSWTypes.MARBLE_TILES.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.wall, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.wall, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.wall, BSSWTypes.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MARBLE_TILES.wall, BSSWTypes.MARBLE_TILES.block);
        offerCutCopperRecipe(exporter, BSSWTypes.MARBLE_TILES.block, BSSWTypes.MARBLE_BRICKS.block);


        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE, BSSWTypes.MARBLE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_PILLAR, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_PILLAR, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_PILLAR, BSSWTypes.MARBLE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE_PILLAR, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE_PILLAR, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE_PILLAR, BSSWTypes.MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MARBLE_PILLAR, BlockusBlocks.MARBLE_PILLAR);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_SQUARES, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_SQUARES, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_SQUARES, BSSWTypes.MARBLE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_CIRCLE_PAVEMENT, BSSWTypes.MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_CIRCLE_PAVEMENT, BSSTypes.POLISHED_MARBLE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MARBLE_CIRCLE_PAVEMENT, BSSWTypes.MARBLE_BRICKS.block);

        // Bluestone
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE.stairs, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE.slab, BSSWTypes.BLUESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE.wall, BSSWTypes.BLUESTONE.block);
        ShapedRecipeJsonFactory.create(BSSWTypes.BLUESTONE.block, 4).input('S', Blocks.STONE).input('#', Items.BLUE_DYE).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE)).criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_BLUESTONE.block, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_BLUESTONE.stairs, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_BLUESTONE.stairs, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_BLUESTONE.slab, BSSWTypes.BLUESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_BLUESTONE.slab, BSSTypes.POLISHED_BLUESTONE.block, 2);

        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.block, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.block, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.stairs, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.stairs, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.stairs, BSSWTypes.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.slab, BSSWTypes.BLUESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.slab, BSSTypes.POLISHED_BLUESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.slab, BSSWTypes.BLUESTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.wall, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.wall, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_BRICKS.wall, BSSWTypes.BLUESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.block, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.block, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.block, BSSWTypes.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.stairs, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.stairs, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.stairs, BSSWTypes.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.stairs, BSSWTypes.SMALL_BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.slab, BSSWTypes.BLUESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.slab, BSSTypes.POLISHED_BLUESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.slab, BSSWTypes.BLUESTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.slab, BSSWTypes.SMALL_BLUESTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.wall, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.wall, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.wall, BSSWTypes.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_BLUESTONE_BRICKS.wall, BSSWTypes.SMALL_BLUESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.block, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.block, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.block, BSSWTypes.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.stairs, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.stairs, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.stairs, BSSWTypes.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.stairs, BSSWTypes.BLUESTONE_TILES.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.slab, BSSWTypes.BLUESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.slab, BSSTypes.POLISHED_BLUESTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.slab, BSSWTypes.BLUESTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.slab, BSSWTypes.BLUESTONE_TILES.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.wall, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.wall, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.wall, BSSWTypes.BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUESTONE_TILES.wall, BSSWTypes.BLUESTONE_TILES.block);
        offerCutCopperRecipe(exporter, BSSWTypes.BLUESTONE_TILES.block, BSSWTypes.BLUESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUESTONE, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUESTONE, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUESTONE, BSSWTypes.BLUESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_PILLAR, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_PILLAR, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_PILLAR, BSSWTypes.BLUESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_SQUARES, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_SQUARES, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_SQUARES, BSSWTypes.BLUESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_CIRCLE_PAVEMENT, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_CIRCLE_PAVEMENT, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_CIRCLE_PAVEMENT, BSSWTypes.BLUESTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_LINES, BSSWTypes.BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_LINES, BSSTypes.POLISHED_BLUESTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUESTONE_LINES, BSSWTypes.BLUESTONE_BRICKS.block);

        // Lava	Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.LAVA_BRICKS.stairs, BSSWTypes.LAVA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LAVA_BRICKS.slab, BSSWTypes.LAVA_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LAVA_BRICKS.wall, BSSWTypes.LAVA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LAVA_BRICKS, BSSWTypes.LAVA_BRICKS.block);
        createEnclosedRecipe(BSSWTypes.LAVA_BRICKS.block, Ingredient.ofItems(Blocks.STONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

        // Lava Blackstone Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.stairs, BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.slab, BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.wall, BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LAVA_POLISHED_BLACKSTONE, BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        createEnclosedRecipe(BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.block, Ingredient.ofItems(Blocks.POLISHED_BLACKSTONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.POLISHED_BLACKSTONE_BRICKS), conditionsFromItem(Blocks.POLISHED_BLACKSTONE_BRICKS)).offerTo(exporter);

        // Water Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.WATER_BRICKS.stairs, BSSWTypes.WATER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.WATER_BRICKS.slab, BSSWTypes.WATER_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.WATER_BRICKS.wall, BSSWTypes.WATER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_WATER_BRICKS, BSSWTypes.WATER_BRICKS.block);
        createEnclosedRecipe(BSSWTypes.WATER_BRICKS.block, Ingredient.ofItems(Blocks.STONE_BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

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
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGMA_BRICKS.stairs, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGMA_BRICKS.stairs, BSSWTypes.MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGMA_BRICKS.slab, Blocks.MAGMA_BLOCK,2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGMA_BRICKS.slab, BSSWTypes.MAGMA_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGMA_BRICKS.wall, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGMA_BRICKS.wall, BSSWTypes.MAGMA_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.MAGMA_BRICKS.block, Blocks.MAGMA_BLOCK);

        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.block, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.block, BSSWTypes.MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.stairs, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.stairs, BSSWTypes.MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.stairs, BSSWTypes.SMALL_MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.slab, Blocks.MAGMA_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.slab, BSSWTypes.MAGMA_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.slab, BSSWTypes.SMALL_MAGMA_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.wall, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.wall, BSSWTypes.MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_MAGMA_BRICKS.wall, BSSWTypes.SMALL_MAGMA_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MAGMA_BRICKS, Blocks.MAGMA_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MAGMA_BRICKS, BSSWTypes.MAGMA_BRICKS.block);

        // Blaze Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.BLAZE_BRICKS.stairs, BSSWTypes.BLAZE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLAZE_BRICKS.slab, BSSWTypes.BLAZE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLAZE_BRICKS.wall, BSSWTypes.BLAZE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLAZE_PILLAR, BSSWTypes.BLAZE_BRICKS.block);
        ShapedRecipeJsonFactory.create(BSSWTypes.BLAZE_BRICKS.block).input('#',  Items.BLAZE_POWDER).input('X',  Items.NETHER_BRICK).pattern("#X").pattern("X#").criterion("has_blaze_rod", conditionsFromItem(Items.BLAZE_ROD)).offerTo(exporter);
        offerReversibleCompactingRecipes(exporter, Items.BLAZE_POWDER, BlockusBlocks.BLAZE_LANTERN);

        // Netherrack
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_NETHERRACK.block, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_NETHERRACK.stairs, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_NETHERRACK.stairs, BSSTypes.POLISHED_NETHERRACK.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_NETHERRACK.slab, Blocks.NETHERRACK,2);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_NETHERRACK.slab, BSSTypes.POLISHED_NETHERRACK.block, 2);
        offerPolishedStoneRecipe(exporter, BSSTypes.POLISHED_NETHERRACK.block, Blocks.NETHERRACK);

        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.block, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.block, BSSTypes.POLISHED_NETHERRACK.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.stairs, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.stairs, BSSTypes.POLISHED_NETHERRACK.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.stairs, BSSWTypes.NETHERRACK_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.slab, Blocks.NETHERRACK, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.slab, BSSTypes.POLISHED_NETHERRACK.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.slab, BSSWTypes.NETHERRACK_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.wall, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.wall, BSSTypes.POLISHED_NETHERRACK.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.wall, BSSWTypes.NETHERRACK_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.NETHERRACK_BRICKS.block, BSSTypes.POLISHED_NETHERRACK.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_CIRCLE_PAVEMENT, Blocks.NETHERRACK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_CIRCLE_PAVEMENT, BSSTypes.POLISHED_NETHERRACK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERRACK_CIRCLE_PAVEMENT, BSSWTypes.NETHERRACK_BRICKS.block);

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
        offerStonecuttingRecipe(exporter, BSSWTypes.CHARRED_NETHER_BRICKS.stairs, BSSWTypes.CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.CHARRED_NETHER_BRICKS.slab, BSSWTypes.CHARRED_NETHER_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.CHARRED_NETHER_BRICKS.wall, BSSWTypes.CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_CHARRED_NETHER_BRICKS, BSSWTypes.CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_CHARRED_NETHER_BRICKS, BSSWTypes.CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHARRED_NETHER_BRICK_PILLAR, BSSWTypes.CHARRED_NETHER_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_CHARRED_NETHER_BRICKS, BSSWTypes.CHARRED_NETHER_BRICKS.block);
        createEnclosedRecipe(BSSWTypes.CHARRED_NETHER_BRICKS.block, Ingredient.ofItems(Blocks.NETHER_BRICKS), Items.FIRE_CHARGE).criterion(hasItem(Items.FIRE_CHARGE), conditionsFromItem(Items.FIRE_CHARGE)).criterion(hasItem(Blocks.NETHER_BRICKS), conditionsFromItem(Blocks.NETHER_BRICKS)).offerTo(exporter);


        // Teal Nether Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.TEAL_NETHER_BRICKS.stairs, BSSWTypes.TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.TEAL_NETHER_BRICKS.slab, BSSWTypes.TEAL_NETHER_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.TEAL_NETHER_BRICKS.wall, BSSWTypes.TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.POLISHED_TEAL_NETHER_BRICKS, BSSWTypes.TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_TEAL_NETHER_BRICKS, BSSWTypes.TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.TEAL_NETHER_BRICK_PILLAR, BSSWTypes.TEAL_NETHER_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BlockusBlocks.POLISHED_TEAL_NETHER_BRICKS, BSSWTypes.TEAL_NETHER_BRICKS.block);
        ShapedRecipeJsonFactory.create(BSSWTypes.TEAL_NETHER_BRICKS.block).input('#',  BlockusItemTags.WARPED_NETHER_GRASS).input('X',  Items.NETHER_BRICK).pattern("#X").pattern("X#").criterion("has_warped_grass", conditionsFromTag(BlockusItemTags.WARPED_NETHER_GRASS)).offerTo(exporter);


        // Obsidian
        offerStonecuttingRecipe(exporter, BSSWTypes.OBSIDIAN_BRICKS.block, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BSSWTypes.OBSIDIAN_BRICKS.stairs, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BSSWTypes.OBSIDIAN_BRICKS.stairs, BSSWTypes.OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.OBSIDIAN_BRICKS.slab, Blocks.OBSIDIAN, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.OBSIDIAN_BRICKS.slab, BSSWTypes.OBSIDIAN_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.OBSIDIAN_BRICKS.wall, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BSSWTypes.OBSIDIAN_BRICKS.wall, BSSWTypes.OBSIDIAN_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.OBSIDIAN_BRICKS.block, Blocks.OBSIDIAN);

        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.block, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.block, BSSWTypes.OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.stairs, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.stairs, BSSWTypes.OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.stairs, BSSWTypes.SMALL_OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.slab, Blocks.OBSIDIAN, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.slab, BSSWTypes.OBSIDIAN_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.slab, BSSWTypes.SMALL_OBSIDIAN_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.wall, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.wall, BSSWTypes.OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_OBSIDIAN_BRICKS.wall, BSSWTypes.SMALL_OBSIDIAN_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_PILLAR, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_PILLAR, BSSWTypes.OBSIDIAN_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_CIRCLE_PAVEMENT, Blocks.OBSIDIAN);
        offerStonecuttingRecipe(exporter, BlockusBlocks.OBSIDIAN_CIRCLE_PAVEMENT, BSSWTypes.OBSIDIAN_BRICKS.block);

        ShapedRecipeJsonFactory.create(BlockusBlocks.GLOWING_OBSIDIAN, 4).input('S', Blocks.OBSIDIAN).input('#', Blocks.SHROOMLIGHT).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Blocks.SHROOMLIGHT), conditionsFromItem(Blocks.SHROOMLIGHT)).offerTo(exporter);


        // Quartz Blocks
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.block, Blocks.QUARTZ_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.block, Blocks.QUARTZ_BRICKS);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.stairs, Blocks.QUARTZ_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.stairs, Blocks.QUARTZ_BRICKS);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.stairs, BSSWTypes.QUARTZ_TILES.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.slab, Blocks.QUARTZ_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.slab, Blocks.QUARTZ_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.slab, BSSWTypes.QUARTZ_TILES.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.wall, Blocks.QUARTZ_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.wall, Blocks.QUARTZ_BRICKS);
        offerStonecuttingRecipe(exporter, BSSWTypes.QUARTZ_TILES.wall, BSSWTypes.QUARTZ_TILES.block);
        offerCutCopperRecipe(exporter, BSSWTypes.QUARTZ_TILES.block, Blocks.QUARTZ_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_CIRCLE_PAVEMENT, Blocks.QUARTZ_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.QUARTZ_CIRCLE_PAVEMENT, Blocks.QUARTZ_BRICKS);

        // Prismarine
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PRISMARINE, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PRISMARINE_CIRCLE_PAVEMENT, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_DARK_PRISMARINE, Blocks.DARK_PRISMARINE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE);

        // Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.LARGE_BRICKS.block, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, BSSWTypes.LARGE_BRICKS.stairs, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, BSSWTypes.LARGE_BRICKS.stairs, BSSWTypes.LARGE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LARGE_BRICKS.slab, Blocks.BRICKS, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LARGE_BRICKS.slab, BSSWTypes.LARGE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LARGE_BRICKS.wall, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, BSSWTypes.LARGE_BRICKS.wall, BSSWTypes.LARGE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.LARGE_BRICKS.block, Blocks.BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_BRICKS, Blocks.BRICKS);

        // Soaked Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.SOAKED_BRICKS.stairs, BSSWTypes.SOAKED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOAKED_BRICKS.slab, BSSWTypes.SOAKED_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOAKED_BRICKS.wall, BSSWTypes.SOAKED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_SOAKED_BRICKS, BSSWTypes.SOAKED_BRICKS.block);
        createEnclosedRecipe(BSSWTypes.SOAKED_BRICKS.block, Ingredient.ofItems(Blocks.BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Sandy Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.SANDY_BRICKS.stairs, BSSWTypes.SANDY_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SANDY_BRICKS.slab, BSSWTypes.SANDY_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SANDY_BRICKS.wall, BSSWTypes.SANDY_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_SANDY_BRICKS, BSSWTypes.SANDY_BRICKS.block);
        ShapedRecipeJsonFactory.create(BSSWTypes.SANDY_BRICKS.block, 2).input('S', Blocks.SAND).input('#', Blocks.BRICKS).pattern(" S ").pattern("S#S").pattern(" S ").criterion("has_sand", conditionsFromItem(Blocks.SAND)).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Charred Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.CHARRED_BRICKS.stairs, BSSWTypes.CHARRED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.CHARRED_BRICKS.slab, BSSWTypes.CHARRED_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.CHARRED_BRICKS.wall, BSSWTypes.CHARRED_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_CHARRED_BRICKS, BSSWTypes.CHARRED_BRICKS.block);
        CookingRecipeJsonFactory.createSmelting(Ingredient.ofItems(Blocks.BRICKS), BSSWTypes.CHARRED_BRICKS.block.asItem(), 0.1F, 200).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Sandstone
        offerStonecuttingRecipe(exporter, BSSTypes.ROUGH_SANDSTONE.stairs, BSSTypes.ROUGH_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.ROUGH_SANDSTONE.slab, BSSTypes.ROUGH_SANDSTONE.block, 2);
        ShapedRecipeJsonFactory.create(BSSTypes.ROUGH_SANDSTONE.block, 2).input('#', Blocks.SANDSTONE_SLAB).pattern("##").pattern("##").criterion("has_sandstone", conditionsFromItem(Blocks.SANDSTONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BSSWTypes.SANDSTONE_BRICKS.block, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SANDSTONE_BRICKS.stairs, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SANDSTONE_BRICKS.stairs, BSSWTypes.SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SANDSTONE_BRICKS.slab, Blocks.SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SANDSTONE_BRICKS.slab, BSSWTypes.SANDSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SANDSTONE_BRICKS.wall, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SANDSTONE_BRICKS.wall, BSSWTypes.SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.block, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.block, BSSWTypes.SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.stairs, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.stairs, BSSWTypes.SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.stairs, BSSWTypes.SMALL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.slab, Blocks.SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.slab, BSSWTypes.SANDSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.slab, BSSWTypes.SMALL_SANDSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.wall, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.wall, BSSWTypes.SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SANDSTONE_BRICKS.wall, BSSWTypes.SMALL_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_PILLAR, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SANDSTONE_PILLAR, BSSWTypes.SANDSTONE_BRICKS.block);

        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_SANDSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.LAPIS_DECORATED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_SANDSTONE);

        // Red Sandstone
        offerStonecuttingRecipe(exporter, BSSTypes.ROUGH_RED_SANDSTONE.stairs, BSSTypes.ROUGH_RED_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.ROUGH_RED_SANDSTONE.slab, BSSTypes.ROUGH_RED_SANDSTONE.block, 2);
        ShapedRecipeJsonFactory.create(BSSTypes.ROUGH_RED_SANDSTONE.block, 2).input('#', Blocks.RED_SANDSTONE_SLAB).pattern("##").pattern("##").criterion("has_red_sandstone", conditionsFromItem(Blocks.RED_SANDSTONE)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BSSWTypes.RED_SANDSTONE_BRICKS.block, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_SANDSTONE_BRICKS.stairs, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_SANDSTONE_BRICKS.stairs, BSSWTypes.RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_SANDSTONE_BRICKS.slab, Blocks.RED_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_SANDSTONE_BRICKS.slab, BSSWTypes.RED_SANDSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_SANDSTONE_BRICKS.wall, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_SANDSTONE_BRICKS.wall, BSSWTypes.RED_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.block, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.block, BSSWTypes.RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.stairs, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.stairs, BSSWTypes.RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.stairs, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.slab, Blocks.RED_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.slab, BSSWTypes.RED_SANDSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.slab, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.wall, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.wall, BSSWTypes.RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.wall, BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_SANDSTONE_PILLAR, BSSWTypes.RED_SANDSTONE_BRICKS.block);

        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_RED_SANDSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.LAPIS_DECORATED_RED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_RED_SANDSTONE);

        // Soul Sandstone
        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE.stairs, BSSWTypes.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE.slab, BSSWTypes.SOUL_SANDSTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE.wall, BSSWTypes.SOUL_SANDSTONE.block, 2);
        ShapedRecipeJsonFactory.create(BSSWTypes.SOUL_SANDSTONE.block).input('#',  BlockusItemTags.SOUL_SOILS).pattern("##").pattern("##").criterion("has_soul_sand", conditionsFromTag(BlockusItemTags.SOUL_SOILS)).offerTo(exporter);


        offerStonecuttingRecipe(exporter, BSSTypes.ROUGH_SOUL_SANDSTONE.stairs, BSSTypes.ROUGH_SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.ROUGH_SOUL_SANDSTONE.slab, BSSTypes.ROUGH_SOUL_SANDSTONE.block, 2);
        ShapedRecipeJsonFactory.create(BSSTypes.ROUGH_SOUL_SANDSTONE.block, 2).input('#', BSSWTypes.SOUL_SANDSTONE.slab).pattern("##").pattern("##").criterion("has_soul_sandstone", conditionsFromItem(BSSWTypes.SOUL_SANDSTONE.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE_BRICKS.block, BSSWTypes.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE_BRICKS.stairs, BSSWTypes.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE_BRICKS.stairs, BSSWTypes.SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE_BRICKS.slab, BSSWTypes.SOUL_SANDSTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE_BRICKS.slab, BSSWTypes.SOUL_SANDSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE_BRICKS.wall, BSSWTypes.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SOUL_SANDSTONE_BRICKS.wall, BSSWTypes.SOUL_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.block, BSSWTypes.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.block, BSSWTypes.SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.stairs, BSSWTypes.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.stairs, BSSWTypes.SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.stairs, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.slab, BSSWTypes.SOUL_SANDSTONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.slab, BSSWTypes.SOUL_SANDSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.slab, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.wall, BSSWTypes.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.wall, BSSWTypes.SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.wall, BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BSSTypes.SMOOTH_SOUL_SANDSTONE.stairs, BSSTypes.SMOOTH_SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.SMOOTH_SOUL_SANDSTONE.slab, BSSTypes.SMOOTH_SOUL_SANDSTONE.block, 2);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE, BSSWTypes.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, BSSWTypes.SOUL_SANDSTONE.block, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, BlockusBlocks.CUT_SOUL_SANDSTONE, 2);
        offerCutCopperRecipe(exporter, BlockusBlocks.CUT_SOUL_SANDSTONE, BSSWTypes.SOUL_SANDSTONE.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_SOUL_SANDSTONE, BSSWTypes.SOUL_SANDSTONE.block);
        offerCutCopperRecipe(exporter, BlockusBlocks.CHISELED_SOUL_SANDSTONE, BlockusBlocks.CUT_SOUL_SANDSTONE);

        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_PILLAR, BSSWTypes.SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.SOUL_SANDSTONE_PILLAR, BSSWTypes.SOUL_SANDSTONE_BRICKS.block);

        offerDecoratedRecipe(exporter, BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE, Items.GOLD_INGOT, BlockusBlocks.CUT_SOUL_SANDSTONE);
        offerDecoratedRecipe(exporter, BlockusBlocks.LAPIS_DECORATED_SOUL_SANDSTONE, Items.LAPIS_LAZULI, BlockusBlocks.CUT_SOUL_SANDSTONE);

        // Honeycomb Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.HONEYCOMB_BRICKS.block, Blocks.HONEYCOMB_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.HONEYCOMB_BRICKS.stairs, Blocks.HONEYCOMB_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.HONEYCOMB_BRICKS.stairs, BSSWTypes.HONEYCOMB_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.HONEYCOMB_BRICKS.slab, Blocks.HONEYCOMB_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.HONEYCOMB_BRICKS.slab, BSSWTypes.HONEYCOMB_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.HONEYCOMB_BRICKS.wall, Blocks.HONEYCOMB_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.HONEYCOMB_BRICKS.wall, BSSWTypes.HONEYCOMB_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.HONEYCOMB_BRICKS.block, Blocks.HONEYCOMB_BLOCK);


        // Purpur Blocks
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PURPUR.block, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PURPUR.stairs, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PURPUR.stairs, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PURPUR.slab, Blocks.PURPUR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PURPUR.slab, BSSTypes.POLISHED_PURPUR.block, 2);
        offerPolishedStoneRecipe(exporter, BSSTypes.POLISHED_PURPUR.block, Blocks.PURPUR_BLOCK);

        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.block, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.block, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.stairs, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.stairs, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.stairs, BSSWTypes.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.slab, Blocks.PURPUR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.slab, BSSTypes.POLISHED_PURPUR.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.slab, BSSWTypes.PURPUR_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.wall, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.wall, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPUR_BRICKS.wall, BSSWTypes.PURPUR_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.PURPUR_BRICKS.block, BSSTypes.POLISHED_PURPUR.block);


        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.block, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.block, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.block, BSSWTypes.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.stairs, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.stairs, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.stairs, BSSWTypes.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.stairs, BSSWTypes.SMALL_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.slab, Blocks.PURPUR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.slab, BSSTypes.POLISHED_PURPUR.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.slab, BSSWTypes.PURPUR_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.slab, BSSWTypes.SMALL_PURPUR_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.wall, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.wall, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.wall, BSSWTypes.PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PURPUR_BRICKS.wall, BSSWTypes.SMALL_PURPUR_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPUR, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPUR, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPUR, BSSWTypes.PURPUR_BRICKS.block);

        offerStonecuttingRecipe(exporter, Blocks.PURPUR_PILLAR, BSSTypes.POLISHED_PURPUR.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_SQUARES, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_SQUARES, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_SQUARES, BSSWTypes.PURPUR_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_LINES, Blocks.PURPUR_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_LINES, BSSTypes.POLISHED_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPUR_LINES, BSSWTypes.PURPUR_BRICKS.block);



        // Phantom Purpur Blocks
        offerStonecuttingRecipe(exporter, BSSTypes.PHANTOM_PURPUR_BLOCK.stairs, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BSSTypes.PHANTOM_PURPUR_BLOCK.slab, BSSTypes.PHANTOM_PURPUR_BLOCK.block, 2);
        offerPhantomPurpurRecipe(exporter, BSSTypes.PHANTOM_PURPUR_BLOCK.block, Blocks.PURPUR_BLOCK);

        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PHANTOM_PURPUR.block, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PHANTOM_PURPUR.stairs, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PHANTOM_PURPUR.stairs, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PHANTOM_PURPUR.slab, BSSTypes.PHANTOM_PURPUR_BLOCK.block, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_PHANTOM_PURPUR.slab, BSSTypes.POLISHED_PHANTOM_PURPUR.block, 2);
        offerPhantomPurpurRecipe(exporter, BSSTypes.POLISHED_PHANTOM_PURPUR.block, BSSTypes.POLISHED_PURPUR.block);

        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.block, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.block, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.stairs, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.stairs, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.stairs, BSSWTypes.PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.slab, BSSTypes.PHANTOM_PURPUR_BLOCK.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.slab, BSSTypes.POLISHED_PHANTOM_PURPUR.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.slab, BSSWTypes.PHANTOM_PURPUR_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.wall, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.wall, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.wall, BSSWTypes.PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.block, BSSWTypes.PURPUR_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.PHANTOM_PURPUR_BRICKS.block, BSSTypes.POLISHED_PHANTOM_PURPUR.block);


        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.block, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.block, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.block, BSSWTypes.PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.stairs, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.stairs, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.stairs, BSSWTypes.PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.stairs, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.slab, BSSTypes.PHANTOM_PURPUR_BLOCK.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.slab, BSSTypes.POLISHED_PHANTOM_PURPUR.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.slab, BSSWTypes.PHANTOM_PURPUR_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.slab, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.wall, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.wall, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.wall, BSSWTypes.PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.wall, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.block, BSSWTypes.PHANTOM_PURPUR_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BSSWTypes.PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.CHISELED_PHANTOM_PURPUR, BlockusBlocks.CHISELED_PURPUR);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_PILLAR, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_PILLAR, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_PILLAR, Blocks.PURPUR_PILLAR);
        ShapedRecipeJsonFactory.create(BlockusBlocks.PHANTOM_PURPUR_PILLAR).input('#', BSSTypes.PHANTOM_PURPUR_BLOCK.slab).pattern("#").pattern("#").criterion("has_phantom_purpur_block", conditionsFromItem(BSSTypes.PHANTOM_PURPUR_BLOCK.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BSSWTypes.PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_SQUARES, BlockusBlocks.PURPUR_SQUARES);

        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BSSTypes.PHANTOM_PURPUR_BLOCK.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BSSTypes.POLISHED_PHANTOM_PURPUR.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BSSWTypes.PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_LINES, BlockusBlocks.PURPUR_LINES);

        // End Stone
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_END_STONE.block, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_END_STONE.stairs, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_END_STONE.stairs, BSSTypes.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_END_STONE.slab, Blocks.END_STONE,2);
        offerStonecuttingRecipe(exporter, BSSTypes.POLISHED_END_STONE.slab, BSSTypes.POLISHED_END_STONE.block, 2);
        offerPolishedStoneRecipe(exporter, BSSTypes.POLISHED_END_STONE.block, Blocks.END_STONE);

        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICKS, BSSTypes.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_STAIRS, BSSTypes.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_SLAB, BSSTypes.POLISHED_END_STONE.block, 2);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_WALL, BSSTypes.POLISHED_END_STONE.block);
        CookingRecipeJsonFactory.createSmelting(Ingredient.ofItems(Blocks.END_STONE_BRICKS),  BlockusBlocks.CRACKED_END_STONE_BRICKS.asItem(), 0.1F, 200).criterion("has_end_stone_bricks", conditionsFromItem(Blocks.END_STONE_BRICKS)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.block, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.block, BSSTypes.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.block, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.stairs, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.stairs, BSSTypes.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.stairs, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.stairs, BSSWTypes.SMALL_END_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.slab, Blocks.END_STONE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.slab, BSSTypes.POLISHED_END_STONE.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.slab, Blocks.END_STONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.slab, BSSWTypes.SMALL_END_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.wall, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.wall, BSSTypes.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.wall, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, BSSWTypes.SMALL_END_STONE_BRICKS.wall, BSSWTypes.SMALL_END_STONE_BRICKS.block);

        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_END_STONE_BRICKS, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_END_STONE_BRICKS, BSSTypes.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_END_STONE_BRICKS, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_END_STONE_BRICKS, BSSTypes.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ZIGZAGGED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);

        offerStonecuttingRecipe(exporter, BlockusBlocks.END_STONE_PILLAR, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.END_STONE_PILLAR, BSSTypes.POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.END_STONE_PILLAR, Blocks.END_STONE_BRICKS);

        offerDecoratedRecipe(exporter, BlockusBlocks.PURPUR_DECORATED_END_STONE, Items.POPPED_CHORUS_FRUIT, Blocks.END_STONE_BRICKS);
        offerPhantomPurpurRecipe(exporter, BlockusBlocks.PHANTOM_PURPUR_DECORATED_END_STONE, BlockusBlocks.PURPUR_DECORATED_END_STONE);

        // Wood
        offerPlanksRecipe(exporter, WoodTypesB.WHITE_OAK.planks, BlockusItemTags.WHITE_OAK_LOGS);
        offerBarkBlockRecipe(exporter, BlockusBlocks.WHITE_OAK_WOOD, BlockusBlocks.WHITE_OAK_LOG);
        ShapedRecipeJsonFactory.create(WoodTypesB.BAMBOO.planks).input('#', Items.BAMBOO).pattern("##").pattern("##").criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.BAMBOO)).offerTo(exporter);
        offerBoatRecipe(exporter, WoodTypesB.WHITE_OAK.boat, WoodTypesB.WHITE_OAK.planks);
        offerBoatRecipe(exporter, WoodTypesB.BAMBOO.boat, WoodTypesB.BAMBOO.planks);
        offerBoatRecipe(exporter, WoodTypesNB.CHARRED.boat, WoodTypesNB.CHARRED.planks);
        CookingRecipeJsonFactory.createSmelting(Ingredient.fromTag(BlockusItemTags.PLANKS_THAT_BURN), WoodTypesNB.CHARRED.planks, 0.1F, 200).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        offerSmallLogsRecipe(exporter, BlockusBlocks.OAK_SMALL_LOGS, Blocks.OAK_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.SPRUCE_SMALL_LOGS, Blocks.SPRUCE_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.BIRCH_SMALL_LOGS, Blocks.BIRCH_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.JUNGLE_SMALL_LOGS, Blocks.JUNGLE_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.ACACIA_SMALL_LOGS, Blocks.ACACIA_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.DARK_OAK_SMALL_LOGS, Blocks.DARK_OAK_LOG);
        offerSmallLogsRecipe(exporter, BlockusBlocks.WARPED_SMALL_STEMS, Blocks.WARPED_STEM);
        offerSmallLogsRecipe(exporter, BlockusBlocks.CRIMSON_SMALL_STEMS, Blocks.CRIMSON_STEM);
        offerSmallLogsRecipe(exporter, BlockusBlocks.WHITE_OAK_SMALL_LOGS, BlockusBlocks.WHITE_OAK_LOG);

        // Small Hedges
        offerSmallHedgesRecipe(exporter, BlockusBlocks.OAK_SMALL_HEDGE, Blocks.OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.SPRUCE_SMALL_HEDGE, Blocks.SPRUCE_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.BIRCH_SMALL_HEDGE, Blocks.BIRCH_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.JUNGLE_SMALL_HEDGE, Blocks.JUNGLE_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.ACACIA_SMALL_HEDGE, Blocks.ACACIA_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.DARK_OAK_SMALL_HEDGE, Blocks.DARK_OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.WARPED_SMALL_HEDGE, Blocks.WARPED_WART_BLOCK);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.CRIMSON_SMALL_HEDGE, Blocks.NETHER_WART_BLOCK);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.WHITE_OAK_SMALL_HEDGE, BlockusBlocks.WHITE_OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.AZALEA_SMALL_HEDGE, Blocks.AZALEA_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES);
        offerSmallHedgesRecipe(exporter, BlockusBlocks.MOSS_SMALL_HEDGE, Blocks.MOSS_BLOCK);

        // Large Flower Pots
        ShapedRecipeJsonFactory.create(BlockusBlocks.LARGE_FLOWER_POT).input('#', Items.BRICK).pattern("# #").pattern("###").pattern("###").criterion("has_flower_pot", conditionsFromItem(Items.FLOWER_POT)).offerTo(exporter);

        // Food Blocks
        offerReversibleCompactingRecipes(exporter, Items.SWEET_BERRIES, BlockusBlocks.SWEET_BERRIES_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.GLOW_BERRIES, BlockusBlocks.GLOW_BERRIES_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.SALMON, BlockusBlocks.SALMON_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.PUFFERFISH, BlockusBlocks.PUFFERFISH_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.TROPICAL_FISH, BlockusBlocks.TROPICAL_FISH_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.COD, BlockusBlocks.COD_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.COOKIE, BlockusBlocks.COOKIE_BLOCK);
        offerReversibleCompactingRecipes(exporter, Items.CHORUS_FRUIT, BlockusBlocks.CHORUS_BLOCK);
        offerReversibleCompactingRecipes(exporter, Items.POTATO, BlockusBlocks.POTATO_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.APPLE, BlockusBlocks.APPLE_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.GOLDEN_APPLE, BlockusBlocks.GOLDEN_APPLE_CRATE);
        createEnclosedRecipe(BlockusBlocks.GOLDEN_APPLE_CRATE, Ingredient.ofItems(Blocks.GOLD_BLOCK), BlockusBlocks.APPLE_CRATE).criterion(hasItem(Items.GOLDEN_APPLE), conditionsFromItem(Items.GOLDEN_APPLE)).offerTo(exporter, convertBetween(BlockusBlocks.GOLDEN_APPLE_CRATE, BlockusBlocks.APPLE_CRATE));
        offerReversibleCompactingRecipes(exporter, Items.BEETROOT, BlockusBlocks.BEETROOT_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.CARROT, BlockusBlocks.CARROT_CRATE);
        offerReversibleCompactingRecipes(exporter, Items.GOLDEN_CARROT, BlockusBlocks.GOLDEN_CARROT_CRATE);
        createEnclosedRecipe(BlockusBlocks.GOLDEN_CARROT_CRATE, Ingredient.ofItems(Items.GOLD_INGOT), BlockusBlocks.CARROT_CRATE).criterion(hasItem(Items.GOLDEN_CARROT), conditionsFromItem(Items.GOLDEN_CARROT)).offerTo(exporter, convertBetween(BlockusBlocks.GOLDEN_CARROT_CRATE, BlockusBlocks.CARROT_CRATE));
        offerReversibleCompactingRecipes(exporter, Items.BREAD, BlockusBlocks.BREAD_BOX);


        // Rainbow
        offerShapelessRecipe(exporter, BlockusItems.RAINBOW_PETAL, BlockusBlocks.RAINBOW_ROSE, "rainbow_petal", 2);
        offerShapelessRecipe(exporter, BlockusItems.RAINBOW_PETAL, BlockusBlocks.RAINBOW_BLOCK, "rainbow_petal", 4);
        ShapedRecipeJsonFactory.create(BlockusBlocks.RAINBOW_BLOCK).input('#', BlockusItems.RAINBOW_PETAL).pattern("##").pattern("##").criterion(hasItem(BlockusItems.RAINBOW_PETAL), conditionsFromItem(BlockusItems.RAINBOW_PETAL)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BSSWTypes.RAINBOW_BRICKS.block, BlockusBlocks.RAINBOW_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.RAINBOW_BRICKS.stairs, BlockusBlocks.RAINBOW_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.RAINBOW_BRICKS.stairs, BSSWTypes.RAINBOW_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.RAINBOW_BRICKS.slab, BlockusBlocks.RAINBOW_BLOCK, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.RAINBOW_BRICKS.slab, BSSWTypes.RAINBOW_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.RAINBOW_BRICKS.wall, BlockusBlocks.RAINBOW_BLOCK);
        offerStonecuttingRecipe(exporter, BSSWTypes.RAINBOW_BRICKS.wall, BSSWTypes.RAINBOW_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.RAINBOW_BRICKS.block, BlockusBlocks.RAINBOW_BLOCK);
        ShapedRecipeJsonFactory.create(BlockusBlocks.RAINBOW_GLOWSTONE, 4).input('S', BlockusItems.RAINBOW_PETAL).input('#', Blocks.GLOWSTONE).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(BlockusItems.RAINBOW_PETAL), conditionsFromItem(BlockusItems.RAINBOW_PETAL)).offerTo(exporter);

        // Colored Stone Bricks
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_STONE_BRICKS.stairs, BSSWTypes.WHITE_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_STONE_BRICKS.slab, BSSWTypes.WHITE_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_STONE_BRICKS.wall, BSSWTypes.WHITE_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.WHITE_DYE, BSSWTypes.WHITE_STONE_BRICKS.block, BSSWTypes.WHITE_STONE_BRICKS.stairs, BSSWTypes.WHITE_STONE_BRICKS.slab, BSSWTypes.WHITE_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_STONE_BRICKS.stairs, BSSWTypes.ORANGE_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_STONE_BRICKS.slab, BSSWTypes.ORANGE_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_STONE_BRICKS.wall, BSSWTypes.ORANGE_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.ORANGE_DYE, BSSWTypes.ORANGE_STONE_BRICKS.block, BSSWTypes.ORANGE_STONE_BRICKS.stairs, BSSWTypes.ORANGE_STONE_BRICKS.slab, BSSWTypes.ORANGE_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_STONE_BRICKS.stairs, BSSWTypes.MAGENTA_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_STONE_BRICKS.slab, BSSWTypes.MAGENTA_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_STONE_BRICKS.wall, BSSWTypes.MAGENTA_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.MAGENTA_DYE, BSSWTypes.MAGENTA_STONE_BRICKS.block, BSSWTypes.MAGENTA_STONE_BRICKS.stairs, BSSWTypes.MAGENTA_STONE_BRICKS.slab, BSSWTypes.MAGENTA_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.stairs, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.slab, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.wall, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.LIGHT_BLUE_DYE, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.block, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.stairs, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.slab, BSSWTypes.LIGHT_BLUE_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_STONE_BRICKS.stairs, BSSWTypes.YELLOW_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_STONE_BRICKS.slab, BSSWTypes.YELLOW_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_STONE_BRICKS.wall, BSSWTypes.YELLOW_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.YELLOW_DYE, BSSWTypes.YELLOW_STONE_BRICKS.block, BSSWTypes.YELLOW_STONE_BRICKS.stairs, BSSWTypes.YELLOW_STONE_BRICKS.slab, BSSWTypes.YELLOW_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_STONE_BRICKS.stairs, BSSWTypes.LIME_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_STONE_BRICKS.slab, BSSWTypes.LIME_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_STONE_BRICKS.wall, BSSWTypes.LIME_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.LIME_DYE, BSSWTypes.LIME_STONE_BRICKS.block, BSSWTypes.LIME_STONE_BRICKS.stairs, BSSWTypes.LIME_STONE_BRICKS.slab, BSSWTypes.LIME_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_STONE_BRICKS.stairs, BSSWTypes.PINK_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_STONE_BRICKS.slab, BSSWTypes.PINK_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_STONE_BRICKS.wall, BSSWTypes.PINK_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.PINK_DYE, BSSWTypes.PINK_STONE_BRICKS.block, BSSWTypes.PINK_STONE_BRICKS.stairs, BSSWTypes.PINK_STONE_BRICKS.slab, BSSWTypes.PINK_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_STONE_BRICKS.stairs, BSSWTypes.GRAY_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_STONE_BRICKS.slab, BSSWTypes.GRAY_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_STONE_BRICKS.wall, BSSWTypes.GRAY_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.GRAY_DYE, BSSWTypes.GRAY_STONE_BRICKS.block, BSSWTypes.GRAY_STONE_BRICKS.stairs, BSSWTypes.GRAY_STONE_BRICKS.slab, BSSWTypes.GRAY_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_STONE_BRICKS.stairs, BSSWTypes.CYAN_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_STONE_BRICKS.slab, BSSWTypes.CYAN_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_STONE_BRICKS.wall, BSSWTypes.CYAN_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.CYAN_DYE, BSSWTypes.CYAN_STONE_BRICKS.block, BSSWTypes.CYAN_STONE_BRICKS.stairs, BSSWTypes.CYAN_STONE_BRICKS.slab, BSSWTypes.CYAN_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_STONE_BRICKS.stairs, BSSWTypes.PURPLE_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_STONE_BRICKS.slab, BSSWTypes.PURPLE_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_STONE_BRICKS.wall, BSSWTypes.PURPLE_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.PURPLE_DYE, BSSWTypes.PURPLE_STONE_BRICKS.block, BSSWTypes.PURPLE_STONE_BRICKS.stairs, BSSWTypes.PURPLE_STONE_BRICKS.slab, BSSWTypes.PURPLE_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_STONE_BRICKS.stairs, BSSWTypes.BLUE_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_STONE_BRICKS.slab, BSSWTypes.BLUE_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_STONE_BRICKS.wall, BSSWTypes.BLUE_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.BLUE_DYE, BSSWTypes.BLUE_STONE_BRICKS.block, BSSWTypes.BLUE_STONE_BRICKS.stairs, BSSWTypes.BLUE_STONE_BRICKS.slab, BSSWTypes.BLUE_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_STONE_BRICKS.stairs, BSSWTypes.BROWN_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_STONE_BRICKS.slab, BSSWTypes.BROWN_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_STONE_BRICKS.wall, BSSWTypes.BROWN_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.BROWN_DYE, BSSWTypes.BROWN_STONE_BRICKS.block, BSSWTypes.BROWN_STONE_BRICKS.stairs, BSSWTypes.BROWN_STONE_BRICKS.slab, BSSWTypes.BROWN_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_STONE_BRICKS.stairs, BSSWTypes.GREEN_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_STONE_BRICKS.slab, BSSWTypes.GREEN_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_STONE_BRICKS.wall, BSSWTypes.GREEN_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.GREEN_DYE, BSSWTypes.GREEN_STONE_BRICKS.block, BSSWTypes.GREEN_STONE_BRICKS.stairs, BSSWTypes.GREEN_STONE_BRICKS.slab, BSSWTypes.GREEN_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.RED_STONE_BRICKS.stairs, BSSWTypes.RED_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_STONE_BRICKS.slab, BSSWTypes.RED_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_STONE_BRICKS.wall, BSSWTypes.RED_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.RED_DYE, BSSWTypes.RED_STONE_BRICKS.block, BSSWTypes.RED_STONE_BRICKS.stairs, BSSWTypes.RED_STONE_BRICKS.slab, BSSWTypes.RED_STONE_BRICKS.wall);

        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_STONE_BRICKS.stairs, BSSWTypes.BLACK_STONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_STONE_BRICKS.slab, BSSWTypes.BLACK_STONE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_STONE_BRICKS.wall, BSSWTypes.BLACK_STONE_BRICKS.block);
        offerStainedStoneBricksRecipe(exporter, Items.BLACK_DYE, BSSWTypes.BLACK_STONE_BRICKS.block, BSSWTypes.BLACK_STONE_BRICKS.stairs, BSSWTypes.BLACK_STONE_BRICKS.slab, BSSWTypes.BLACK_STONE_BRICKS.wall);


        // Concrete
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_CONCRETE_BRICKS.block, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_CONCRETE_BRICKS.stairs, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_CONCRETE_BRICKS.stairs, BSSWTypes.WHITE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_CONCRETE_BRICKS.slab, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_CONCRETE_BRICKS.slab, BSSWTypes.WHITE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_CONCRETE_BRICKS.wall, Blocks.WHITE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.WHITE_CONCRETE_BRICKS.wall, BSSWTypes.WHITE_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_WHITE_CONCRETE, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_WHITE_CONCRETE, BSSWTypes.WHITE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_PILLAR, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_CONCRETE_PILLAR, BSSWTypes.WHITE_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.WHITE_CONCRETE_BRICKS.block, Blocks.WHITE_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_CONCRETE_BRICKS.block, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_CONCRETE_BRICKS.stairs, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_CONCRETE_BRICKS.stairs, BSSWTypes.ORANGE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_CONCRETE_BRICKS.slab, Blocks.ORANGE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_CONCRETE_BRICKS.slab, BSSWTypes.ORANGE_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_CONCRETE_BRICKS.wall, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.ORANGE_CONCRETE_BRICKS.wall, BSSWTypes.ORANGE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ORANGE_CONCRETE, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_ORANGE_CONCRETE, BSSWTypes.ORANGE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_PILLAR, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_CONCRETE_PILLAR, BSSWTypes.ORANGE_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.ORANGE_CONCRETE_BRICKS.block, Blocks.ORANGE_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_CONCRETE_BRICKS.block, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_CONCRETE_BRICKS.stairs, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_CONCRETE_BRICKS.stairs, BSSWTypes.MAGENTA_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_CONCRETE_BRICKS.slab, Blocks.MAGENTA_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_CONCRETE_BRICKS.slab, BSSWTypes.MAGENTA_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_CONCRETE_BRICKS.wall, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.MAGENTA_CONCRETE_BRICKS.wall, BSSWTypes.MAGENTA_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MAGENTA_CONCRETE, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_MAGENTA_CONCRETE, BSSWTypes.MAGENTA_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_PILLAR, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_CONCRETE_PILLAR, BSSWTypes.MAGENTA_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.MAGENTA_CONCRETE_BRICKS.block, Blocks.MAGENTA_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.block, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.stairs, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.stairs, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.slab, Blocks.LIGHT_BLUE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.slab, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.wall, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.wall, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIGHT_BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIGHT_BLUE_CONCRETE, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_PILLAR, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_CONCRETE_PILLAR, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.LIGHT_BLUE_CONCRETE_BRICKS.block, Blocks.LIGHT_BLUE_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_CONCRETE_BRICKS.block, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_CONCRETE_BRICKS.stairs, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_CONCRETE_BRICKS.stairs, BSSWTypes.YELLOW_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_CONCRETE_BRICKS.slab, Blocks.YELLOW_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_CONCRETE_BRICKS.slab, BSSWTypes.YELLOW_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_CONCRETE_BRICKS.wall, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.YELLOW_CONCRETE_BRICKS.wall, BSSWTypes.YELLOW_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_YELLOW_CONCRETE, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_YELLOW_CONCRETE, BSSWTypes.YELLOW_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_PILLAR, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_CONCRETE_PILLAR, BSSWTypes.YELLOW_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.YELLOW_CONCRETE_BRICKS.block, Blocks.YELLOW_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_CONCRETE_BRICKS.block, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_CONCRETE_BRICKS.stairs, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_CONCRETE_BRICKS.stairs, BSSWTypes.LIME_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_CONCRETE_BRICKS.slab, Blocks.LIME_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_CONCRETE_BRICKS.slab, BSSWTypes.LIME_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_CONCRETE_BRICKS.wall, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIME_CONCRETE_BRICKS.wall, BSSWTypes.LIME_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIME_CONCRETE, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIME_CONCRETE, BSSWTypes.LIME_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_PILLAR, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_CONCRETE_PILLAR, BSSWTypes.LIME_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.LIME_CONCRETE_BRICKS.block, Blocks.LIME_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_CONCRETE_BRICKS.block, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_CONCRETE_BRICKS.stairs, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_CONCRETE_BRICKS.stairs, BSSWTypes.PINK_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_CONCRETE_BRICKS.slab, Blocks.PINK_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_CONCRETE_BRICKS.slab, BSSWTypes.PINK_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_CONCRETE_BRICKS.wall, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.PINK_CONCRETE_BRICKS.wall, BSSWTypes.PINK_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PINK_CONCRETE, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PINK_CONCRETE, BSSWTypes.PINK_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_PILLAR, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_CONCRETE_PILLAR, BSSWTypes.PINK_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.PINK_CONCRETE_BRICKS.block, Blocks.PINK_CONCRETE);


        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_CONCRETE_BRICKS.block, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_CONCRETE_BRICKS.stairs, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_CONCRETE_BRICKS.stairs, BSSWTypes.GRAY_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_CONCRETE_BRICKS.slab, Blocks.GRAY_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_CONCRETE_BRICKS.slab, BSSWTypes.GRAY_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_CONCRETE_BRICKS.wall, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GRAY_CONCRETE_BRICKS.wall, BSSWTypes.GRAY_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRAY_CONCRETE, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GRAY_CONCRETE, BSSWTypes.GRAY_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_PILLAR, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_CONCRETE_PILLAR, BSSWTypes.GRAY_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.GRAY_CONCRETE_BRICKS.block, Blocks.GRAY_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.block, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.stairs, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.stairs, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.slab, Blocks.LIGHT_GRAY_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.slab, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.wall, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.wall, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIGHT_GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_LIGHT_GRAY_CONCRETE, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_PILLAR, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_CONCRETE_PILLAR, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.LIGHT_GRAY_CONCRETE_BRICKS.block, Blocks.LIGHT_GRAY_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_CONCRETE_BRICKS.block, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_CONCRETE_BRICKS.stairs, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_CONCRETE_BRICKS.stairs, BSSWTypes.CYAN_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_CONCRETE_BRICKS.slab, Blocks.CYAN_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_CONCRETE_BRICKS.slab, BSSWTypes.CYAN_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_CONCRETE_BRICKS.wall, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.CYAN_CONCRETE_BRICKS.wall, BSSWTypes.CYAN_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_CYAN_CONCRETE, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_CYAN_CONCRETE, BSSWTypes.CYAN_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_PILLAR, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_CONCRETE_PILLAR, BSSWTypes.CYAN_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.CYAN_CONCRETE_BRICKS.block, Blocks.CYAN_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_CONCRETE_BRICKS.block, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_CONCRETE_BRICKS.stairs, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_CONCRETE_BRICKS.stairs, BSSWTypes.PURPLE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_CONCRETE_BRICKS.slab, Blocks.PURPLE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_CONCRETE_BRICKS.slab, BSSWTypes.PURPLE_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_CONCRETE_BRICKS.wall, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.PURPLE_CONCRETE_BRICKS.wall, BSSWTypes.PURPLE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPLE_CONCRETE, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_PURPLE_CONCRETE, BSSWTypes.PURPLE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_PILLAR, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_CONCRETE_PILLAR, BSSWTypes.PURPLE_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.PURPLE_CONCRETE_BRICKS.block, Blocks.PURPLE_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_CONCRETE_BRICKS.block, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_CONCRETE_BRICKS.stairs, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_CONCRETE_BRICKS.stairs, BSSWTypes.BLUE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_CONCRETE_BRICKS.slab, Blocks.BLUE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_CONCRETE_BRICKS.slab, BSSWTypes.BLUE_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_CONCRETE_BRICKS.wall, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLUE_CONCRETE_BRICKS.wall, BSSWTypes.BLUE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUE_CONCRETE, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLUE_CONCRETE, BSSWTypes.BLUE_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_PILLAR, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_CONCRETE_PILLAR, BSSWTypes.BLUE_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.BLUE_CONCRETE_BRICKS.block, Blocks.BLUE_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_CONCRETE_BRICKS.block, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_CONCRETE_BRICKS.stairs, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_CONCRETE_BRICKS.stairs, BSSWTypes.BROWN_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_CONCRETE_BRICKS.slab, Blocks.BROWN_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_CONCRETE_BRICKS.slab, BSSWTypes.BROWN_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_CONCRETE_BRICKS.wall, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.BROWN_CONCRETE_BRICKS.wall, BSSWTypes.BROWN_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BROWN_CONCRETE, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BROWN_CONCRETE, BSSWTypes.BROWN_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_PILLAR, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_CONCRETE_PILLAR, BSSWTypes.BROWN_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.BROWN_CONCRETE_BRICKS.block, Blocks.BROWN_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_CONCRETE_BRICKS.block, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_CONCRETE_BRICKS.stairs, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_CONCRETE_BRICKS.stairs, BSSWTypes.GREEN_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_CONCRETE_BRICKS.slab, Blocks.GREEN_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_CONCRETE_BRICKS.slab, BSSWTypes.GREEN_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_CONCRETE_BRICKS.wall, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.GREEN_CONCRETE_BRICKS.wall, BSSWTypes.GREEN_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GREEN_CONCRETE, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_GREEN_CONCRETE, BSSWTypes.GREEN_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_PILLAR, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_CONCRETE_PILLAR, BSSWTypes.GREEN_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.GREEN_CONCRETE_BRICKS.block, Blocks.GREEN_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.RED_CONCRETE_BRICKS.block, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_CONCRETE_BRICKS.stairs, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_CONCRETE_BRICKS.stairs, BSSWTypes.RED_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_CONCRETE_BRICKS.slab, Blocks.RED_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_CONCRETE_BRICKS.slab, BSSWTypes.RED_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_CONCRETE_BRICKS.wall, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.RED_CONCRETE_BRICKS.wall, BSSWTypes.RED_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_RED_CONCRETE, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_RED_CONCRETE, BSSWTypes.RED_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_PILLAR, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_CONCRETE_PILLAR, BSSWTypes.RED_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.RED_CONCRETE_BRICKS.block, Blocks.RED_CONCRETE);

        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_CONCRETE_BRICKS.block, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_CONCRETE_BRICKS.stairs, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_CONCRETE_BRICKS.stairs, BSSWTypes.BLACK_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_CONCRETE_BRICKS.slab, Blocks.BLACK_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_CONCRETE_BRICKS.slab, BSSWTypes.BLACK_CONCRETE_BRICKS.block, 2);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_CONCRETE_BRICKS.wall, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BSSWTypes.BLACK_CONCRETE_BRICKS.wall, BSSWTypes.BLACK_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLACK_CONCRETE, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CHISELED_BLACK_CONCRETE, BSSWTypes.BLACK_CONCRETE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_PILLAR, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_CONCRETE_PILLAR, BSSWTypes.BLACK_CONCRETE_BRICKS.block);
        offerCutCopperRecipe(exporter, BSSWTypes.BLACK_CONCRETE_BRICKS.block, Blocks.BLACK_CONCRETE);

        // Redstone Lamps
        ShapelessRecipeJsonFactory.create(BlockusBlocks.REDSTONE_LAMP_LIT).input(Blocks.REDSTONE_LAMP).input(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter);
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
        ShapedRecipeJsonFactory.create(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK).input('A', Items.WHITE_DYE).input('B', Blocks.GRAY_STAINED_GLASS).input('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").criterion(hasItem(Blocks.GRAY_STAINED_GLASS), conditionsFromItem(Blocks.GRAY_STAINED_GLASS)).offerTo(exporter);
        offerFuturneoRecipe(exporter, BlockusBlocks.CYAN_FUTURNEO_BLOCK, Blocks.CYAN_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.PURPLE_FUTURNEO_BLOCK, Blocks.PURPLE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.BLUE_FUTURNEO_BLOCK, Blocks.BLUE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.BROWN_FUTURNEO_BLOCK, Blocks.BROWN_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.GREEN_FUTURNEO_BLOCK, Blocks.GREEN_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.RED_FUTURNEO_BLOCK, Blocks.RED_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.BLACK_FUTURNEO_BLOCK, Blocks.BLACK_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BlockusBlocks.RAINBOW_FUTURNEO_BLOCK, BlockusBlocks.RAINBOW_GLASS);

        // Asphalt
        offerStonecuttingRecipe(exporter, AsphaltTypes.ASPHALT.stairs, AsphaltTypes.ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.ASPHALT.slab, AsphaltTypes.ASPHALT.block, 2);
        ShapedRecipeJsonFactory.create(AsphaltTypes.ASPHALT.block, 8).input('X', Blocks.GRAVEL).input('#', ItemTags.COALS).pattern("XXX").pattern("X#X").pattern("XXX").group("asphalt").criterion(hasItem(Blocks.GRAVEL), conditionsFromItem(Blocks.GRAVEL)).offerTo(exporter);
        createEnclosedRecipe(BlockusBlocks.RAINBOW_ASPHALT, Ingredient.ofItems(AsphaltTypes.ASPHALT.block), BlockusItems.RAINBOW_PETAL).criterion(hasItem(AsphaltTypes.ASPHALT.block), conditionsFromItem(AsphaltTypes.ASPHALT.block)).offerTo(exporter);

        offerStonecuttingRecipe(exporter, AsphaltTypes.WHITE_ASPHALT.stairs, AsphaltTypes.WHITE_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.WHITE_ASPHALT.slab, AsphaltTypes.WHITE_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.WHITE_DYE, AsphaltTypes.WHITE_ASPHALT.block, AsphaltTypes.WHITE_ASPHALT.stairs, AsphaltTypes.WHITE_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.ORANGE_ASPHALT.stairs, AsphaltTypes.ORANGE_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.ORANGE_ASPHALT.slab, AsphaltTypes.ORANGE_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.ORANGE_DYE, AsphaltTypes.ORANGE_ASPHALT.block, AsphaltTypes.ORANGE_ASPHALT.stairs, AsphaltTypes.ORANGE_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.MAGENTA_ASPHALT.stairs, AsphaltTypes.MAGENTA_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.MAGENTA_ASPHALT.slab, AsphaltTypes.MAGENTA_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.MAGENTA_DYE, AsphaltTypes.MAGENTA_ASPHALT.block, AsphaltTypes.MAGENTA_ASPHALT.stairs, AsphaltTypes.MAGENTA_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.LIGHT_BLUE_ASPHALT.stairs, AsphaltTypes.LIGHT_BLUE_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.LIGHT_BLUE_ASPHALT.slab, AsphaltTypes.LIGHT_BLUE_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.LIGHT_BLUE_DYE, AsphaltTypes.LIGHT_BLUE_ASPHALT.block, AsphaltTypes.LIGHT_BLUE_ASPHALT.stairs, AsphaltTypes.LIGHT_BLUE_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.YELLOW_ASPHALT.stairs, AsphaltTypes.YELLOW_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.YELLOW_ASPHALT.slab, AsphaltTypes.YELLOW_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.YELLOW_DYE, AsphaltTypes.YELLOW_ASPHALT.block, AsphaltTypes.YELLOW_ASPHALT.stairs, AsphaltTypes.YELLOW_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.LIME_ASPHALT.stairs, AsphaltTypes.LIME_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.LIME_ASPHALT.slab, AsphaltTypes.LIME_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.LIME_DYE, AsphaltTypes.LIME_ASPHALT.block, AsphaltTypes.LIME_ASPHALT.stairs, AsphaltTypes.LIME_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.PINK_ASPHALT.stairs, AsphaltTypes.PINK_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.PINK_ASPHALT.slab, AsphaltTypes.PINK_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.PINK_DYE, AsphaltTypes.PINK_ASPHALT.block, AsphaltTypes.PINK_ASPHALT.stairs, AsphaltTypes.PINK_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.LIGHT_GRAY_ASPHALT.stairs, AsphaltTypes.LIGHT_GRAY_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.LIGHT_GRAY_ASPHALT.slab, AsphaltTypes.LIGHT_GRAY_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.LIGHT_GRAY_DYE, AsphaltTypes.LIGHT_GRAY_ASPHALT.block, AsphaltTypes.LIGHT_GRAY_ASPHALT.stairs, AsphaltTypes.LIGHT_GRAY_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.GRAY_ASPHALT.stairs, AsphaltTypes.GRAY_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.GRAY_ASPHALT.slab, AsphaltTypes.GRAY_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.GRAY_DYE, AsphaltTypes.GRAY_ASPHALT.block, AsphaltTypes.GRAY_ASPHALT.stairs, AsphaltTypes.GRAY_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.CYAN_ASPHALT.stairs, AsphaltTypes.CYAN_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.CYAN_ASPHALT.slab, AsphaltTypes.CYAN_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.CYAN_DYE, AsphaltTypes.CYAN_ASPHALT.block, AsphaltTypes.CYAN_ASPHALT.stairs, AsphaltTypes.CYAN_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.PURPLE_ASPHALT.stairs, AsphaltTypes.PURPLE_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.PURPLE_ASPHALT.slab, AsphaltTypes.PURPLE_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.PURPLE_DYE, AsphaltTypes.PURPLE_ASPHALT.block, AsphaltTypes.PURPLE_ASPHALT.stairs, AsphaltTypes.PURPLE_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.BLUE_ASPHALT.stairs, AsphaltTypes.BLUE_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.BLUE_ASPHALT.slab, AsphaltTypes.BLUE_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.BLUE_DYE, AsphaltTypes.BLUE_ASPHALT.block, AsphaltTypes.BLUE_ASPHALT.stairs, AsphaltTypes.BLUE_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.BROWN_ASPHALT.stairs, AsphaltTypes.BROWN_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.BROWN_ASPHALT.slab, AsphaltTypes.BROWN_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.BROWN_DYE, AsphaltTypes.BROWN_ASPHALT.block, AsphaltTypes.BROWN_ASPHALT.stairs, AsphaltTypes.BROWN_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.GREEN_ASPHALT.stairs, AsphaltTypes.GREEN_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.GREEN_ASPHALT.slab, AsphaltTypes.GREEN_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.GREEN_DYE, AsphaltTypes.GREEN_ASPHALT.block, AsphaltTypes.GREEN_ASPHALT.stairs, AsphaltTypes.GREEN_ASPHALT.slab);

        offerStonecuttingRecipe(exporter, AsphaltTypes.RED_ASPHALT.stairs, AsphaltTypes.RED_ASPHALT.block);
        offerStonecuttingRecipe(exporter, AsphaltTypes.RED_ASPHALT.slab, AsphaltTypes.RED_ASPHALT.block, 2);
        offerAsphaltRecipe(exporter, Items.RED_DYE, AsphaltTypes.RED_ASPHALT.block, AsphaltTypes.RED_ASPHALT.stairs, AsphaltTypes.RED_ASPHALT.slab);


        // Shingles
        offerStonecuttingRecipe(exporter, BSSTypes.WHITE_SHINGLES.block, Blocks.WHITE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.WHITE_SHINGLES.stairs, Blocks.WHITE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.WHITE_SHINGLES.stairs, BSSTypes.WHITE_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.WHITE_SHINGLES.slab, Blocks.WHITE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.WHITE_SHINGLES.slab, BSSTypes.WHITE_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.WHITE_SHINGLES.block, Blocks.WHITE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.WHITE_DYE, BSSTypes.WHITE_SHINGLES.block, BSSTypes.WHITE_SHINGLES.stairs, BSSTypes.WHITE_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.ORANGE_SHINGLES.block, Blocks.ORANGE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.ORANGE_SHINGLES.stairs, Blocks.ORANGE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.ORANGE_SHINGLES.stairs, BSSTypes.ORANGE_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.ORANGE_SHINGLES.slab, Blocks.ORANGE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.ORANGE_SHINGLES.slab, BSSTypes.ORANGE_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.ORANGE_SHINGLES.block, Blocks.ORANGE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.ORANGE_DYE, BSSTypes.ORANGE_SHINGLES.block, BSSTypes.ORANGE_SHINGLES.stairs, BSSTypes.ORANGE_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.MAGENTA_SHINGLES.block, Blocks.MAGENTA_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.MAGENTA_SHINGLES.stairs, Blocks.MAGENTA_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.MAGENTA_SHINGLES.stairs, BSSTypes.MAGENTA_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.MAGENTA_SHINGLES.slab, Blocks.MAGENTA_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.MAGENTA_SHINGLES.slab, BSSTypes.MAGENTA_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.MAGENTA_SHINGLES.block, Blocks.MAGENTA_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.MAGENTA_DYE, BSSTypes.MAGENTA_SHINGLES.block, BSSTypes.MAGENTA_SHINGLES.stairs, BSSTypes.MAGENTA_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_BLUE_SHINGLES.block, Blocks.LIGHT_BLUE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_BLUE_SHINGLES.stairs, Blocks.LIGHT_BLUE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_BLUE_SHINGLES.stairs, BSSTypes.LIGHT_BLUE_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_BLUE_SHINGLES.slab, Blocks.LIGHT_BLUE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_BLUE_SHINGLES.slab, BSSTypes.LIGHT_BLUE_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.LIGHT_BLUE_SHINGLES.block, Blocks.LIGHT_BLUE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIGHT_BLUE_DYE, BSSTypes.LIGHT_BLUE_SHINGLES.block, BSSTypes.LIGHT_BLUE_SHINGLES.stairs, BSSTypes.LIGHT_BLUE_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.YELLOW_SHINGLES.block, Blocks.YELLOW_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.YELLOW_SHINGLES.stairs, Blocks.YELLOW_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.YELLOW_SHINGLES.stairs, BSSTypes.YELLOW_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.YELLOW_SHINGLES.slab, Blocks.YELLOW_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.YELLOW_SHINGLES.slab, BSSTypes.YELLOW_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.YELLOW_SHINGLES.block, Blocks.YELLOW_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.YELLOW_DYE, BSSTypes.YELLOW_SHINGLES.block, BSSTypes.YELLOW_SHINGLES.stairs, BSSTypes.YELLOW_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.LIME_SHINGLES.block, Blocks.LIME_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.LIME_SHINGLES.stairs, Blocks.LIME_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.LIME_SHINGLES.stairs, BSSTypes.LIME_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.LIME_SHINGLES.slab, Blocks.LIME_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.LIME_SHINGLES.slab, BSSTypes.LIME_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.LIME_SHINGLES.block, Blocks.LIME_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIME_DYE, BSSTypes.LIME_SHINGLES.block, BSSTypes.LIME_SHINGLES.stairs, BSSTypes.LIME_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.PINK_SHINGLES.block, Blocks.PINK_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.PINK_SHINGLES.stairs, Blocks.PINK_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.PINK_SHINGLES.stairs, BSSTypes.PINK_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.PINK_SHINGLES.slab, Blocks.PINK_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.PINK_SHINGLES.slab, BSSTypes.PINK_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.PINK_SHINGLES.block, Blocks.PINK_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.PINK_DYE, BSSTypes.PINK_SHINGLES.block, BSSTypes.PINK_SHINGLES.stairs, BSSTypes.PINK_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_GRAY_SHINGLES.block, Blocks.LIGHT_GRAY_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_GRAY_SHINGLES.stairs, Blocks.LIGHT_GRAY_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_GRAY_SHINGLES.stairs, BSSTypes.LIGHT_GRAY_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_GRAY_SHINGLES.slab, Blocks.LIGHT_GRAY_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.LIGHT_GRAY_SHINGLES.slab, BSSTypes.LIGHT_GRAY_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.LIGHT_GRAY_SHINGLES.block, Blocks.LIGHT_GRAY_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIGHT_GRAY_DYE, BSSTypes.LIGHT_GRAY_SHINGLES.block, BSSTypes.LIGHT_GRAY_SHINGLES.stairs, BSSTypes.LIGHT_GRAY_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.GRAY_SHINGLES.block, Blocks.GRAY_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.GRAY_SHINGLES.stairs, Blocks.GRAY_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.GRAY_SHINGLES.stairs, BSSTypes.GRAY_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.GRAY_SHINGLES.slab, Blocks.GRAY_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.GRAY_SHINGLES.slab, BSSTypes.GRAY_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.GRAY_SHINGLES.block, Blocks.GRAY_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.GRAY_DYE, BSSTypes.GRAY_SHINGLES.block, BSSTypes.GRAY_SHINGLES.stairs, BSSTypes.GRAY_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.CYAN_SHINGLES.block, Blocks.CYAN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.CYAN_SHINGLES.stairs, Blocks.CYAN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.CYAN_SHINGLES.stairs, BSSTypes.CYAN_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.CYAN_SHINGLES.slab, Blocks.CYAN_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.CYAN_SHINGLES.slab, BSSTypes.CYAN_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.CYAN_SHINGLES.block, Blocks.CYAN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.CYAN_DYE, BSSTypes.CYAN_SHINGLES.block, BSSTypes.CYAN_SHINGLES.stairs, BSSTypes.CYAN_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.PURPLE_SHINGLES.block, Blocks.PURPLE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.PURPLE_SHINGLES.stairs, Blocks.PURPLE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.PURPLE_SHINGLES.stairs, BSSTypes.PURPLE_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.PURPLE_SHINGLES.slab, Blocks.PURPLE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.PURPLE_SHINGLES.slab, BSSTypes.PURPLE_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.PURPLE_SHINGLES.block, Blocks.PURPLE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.PURPLE_DYE, BSSTypes.PURPLE_SHINGLES.block, BSSTypes.PURPLE_SHINGLES.stairs, BSSTypes.PURPLE_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.BLUE_SHINGLES.block, Blocks.BLUE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.BLUE_SHINGLES.stairs, Blocks.BLUE_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.BLUE_SHINGLES.stairs, BSSTypes.BLUE_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.BLUE_SHINGLES.slab, Blocks.BLUE_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.BLUE_SHINGLES.slab, BSSTypes.BLUE_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.BLUE_SHINGLES.block, Blocks.BLUE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BLUE_DYE, BSSTypes.BLUE_SHINGLES.block, BSSTypes.BLUE_SHINGLES.stairs, BSSTypes.BLUE_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.BROWN_SHINGLES.block, Blocks.BROWN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.BROWN_SHINGLES.stairs, Blocks.BROWN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.BROWN_SHINGLES.stairs, BSSTypes.BROWN_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.BROWN_SHINGLES.slab, Blocks.BROWN_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.BROWN_SHINGLES.slab, BSSTypes.BROWN_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.BROWN_SHINGLES.block, Blocks.BROWN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BROWN_DYE, BSSTypes.BROWN_SHINGLES.block, BSSTypes.BROWN_SHINGLES.stairs, BSSTypes.BROWN_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.GREEN_SHINGLES.block, Blocks.GREEN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.GREEN_SHINGLES.stairs, Blocks.GREEN_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.GREEN_SHINGLES.stairs, BSSTypes.GREEN_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.GREEN_SHINGLES.slab, Blocks.GREEN_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.GREEN_SHINGLES.slab, BSSTypes.GREEN_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.GREEN_SHINGLES.block, Blocks.GREEN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.GREEN_DYE, BSSTypes.GREEN_SHINGLES.block, BSSTypes.GREEN_SHINGLES.stairs, BSSTypes.GREEN_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.RED_SHINGLES.block, Blocks.RED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.RED_SHINGLES.stairs, Blocks.RED_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.RED_SHINGLES.stairs, BSSTypes.RED_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.RED_SHINGLES.slab, Blocks.RED_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.RED_SHINGLES.slab, BSSTypes.RED_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.RED_SHINGLES.block, Blocks.RED_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.RED_DYE, BSSTypes.RED_SHINGLES.block, BSSTypes.RED_SHINGLES.stairs, BSSTypes.RED_SHINGLES.slab);

        offerStonecuttingRecipe(exporter, BSSTypes.BLACK_SHINGLES.block, Blocks.BLACK_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.BLACK_SHINGLES.stairs, Blocks.BLACK_TERRACOTTA);
        offerStonecuttingRecipe(exporter, BSSTypes.BLACK_SHINGLES.stairs, BSSTypes.BLACK_SHINGLES.block);
        offerStonecuttingRecipe(exporter, BSSTypes.BLACK_SHINGLES.slab, Blocks.BLACK_TERRACOTTA, 2);
        offerStonecuttingRecipe(exporter, BSSTypes.BLACK_SHINGLES.slab, BSSTypes.BLACK_SHINGLES.block, 2);
        offerCutCopperRecipe(exporter, BSSTypes.BLACK_SHINGLES.block, Blocks.BLACK_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BLACK_DYE, BSSTypes.BLACK_SHINGLES.block, BSSTypes.BLACK_SHINGLES.stairs, BSSTypes.BLACK_SHINGLES.slab);

        // Glass - Beveled Glass
        offerCutCopperRecipe(exporter, BlockusBlocks.BEVELED_GLASS, Blocks.GLASS);
        ShapedRecipeJsonFactory.create(BlockusBlocks.BEVELED_GLASS_PANE, 16).input('#', BlockusBlocks.BEVELED_GLASS).pattern("###").pattern("###").group("beveled_glass_pane").criterion("has_beveled_glass", conditionsFromItem(BlockusBlocks.BEVELED_GLASS_PANE)).offerTo(exporter);
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
        ShapedRecipeJsonFactory.create(BlockusBlocks.RAINBOW_GLASS_PANE, 16).input('#', BlockusBlocks.RAINBOW_GLASS).pattern("###").pattern("###").criterion(hasItem(BlockusBlocks.RAINBOW_GLASS), conditionsFromItem(BlockusBlocks.RAINBOW_GLASS)).offerTo(exporter);

        // Patterned Wools
        offerCutCopperRecipe(exporter, BlockusBlocks.WHITE_PATTERNED_WOOL, Blocks.WHITE_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.ORANGE_PATTERNED_WOOL, Blocks.ORANGE_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.MAGENTA_PATTERNED_WOOL, Blocks.MAGENTA_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIGHT_BLUE_PATTERNED_WOOL, Blocks.LIGHT_BLUE_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.YELLOW_PATTERNED_WOOL, Blocks.YELLOW_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIME_PATTERNED_WOOL, Blocks.LIME_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.PINK_PATTERNED_WOOL, Blocks.PINK_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.LIGHT_GRAY_PATTERNED_WOOL, Blocks.LIGHT_GRAY_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.GRAY_PATTERNED_WOOL, Blocks.GRAY_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.CYAN_PATTERNED_WOOL, Blocks.CYAN_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.PURPLE_PATTERNED_WOOL, Blocks.PURPLE_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.BLUE_PATTERNED_WOOL, Blocks.BLUE_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.BROWN_PATTERNED_WOOL, Blocks.BROWN_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.GREEN_PATTERNED_WOOL, Blocks.GREEN_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.RED_PATTERNED_WOOL, Blocks.RED_WOOL);
        offerCutCopperRecipe(exporter, BlockusBlocks.BLACK_PATTERNED_WOOL, Blocks.BLACK_WOOL);

        // Colored Tiles
        offerStonecuttingRecipe(exporter, BlockusBlocks.WHITE_COLORED_TILES, Blocks.WHITE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.WHITE_COLORED_TILES, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.ORANGE_COLORED_TILES, Blocks.ORANGE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.ORANGE_COLORED_TILES, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.MAGENTA_COLORED_TILES, Blocks.MAGENTA_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.MAGENTA_COLORED_TILES, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_BLUE_COLORED_TILES, Blocks.LIGHT_BLUE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.LIGHT_BLUE_COLORED_TILES, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.YELLOW_COLORED_TILES, Blocks.YELLOW_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.YELLOW_COLORED_TILES, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIME_COLORED_TILES, Blocks.LIME_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.LIME_COLORED_TILES, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PINK_COLORED_TILES, Blocks.PINK_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.PINK_COLORED_TILES, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.LIGHT_GRAY_COLORED_TILES, Blocks.LIGHT_GRAY_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.LIGHT_GRAY_COLORED_TILES, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GRAY_COLORED_TILES, Blocks.GRAY_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.GRAY_COLORED_TILES, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.CYAN_COLORED_TILES, Blocks.CYAN_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.CYAN_COLORED_TILES, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.PURPLE_COLORED_TILES, Blocks.PURPLE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.PURPLE_COLORED_TILES, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLUE_COLORED_TILES, Blocks.BLUE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.BLUE_COLORED_TILES, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BROWN_COLORED_TILES, Blocks.BROWN_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.BROWN_COLORED_TILES, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.GREEN_COLORED_TILES, Blocks.GREEN_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.GREEN_COLORED_TILES, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.RED_COLORED_TILES, Blocks.RED_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.RED_COLORED_TILES, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, BlockusBlocks.BLACK_COLORED_TILES, Blocks.BLACK_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BlockusBlocks.BLACK_COLORED_TILES, Blocks.BLACK_CONCRETE);

        // Colored Tiles (With white)
        offerColoredTilesRecipe(exporter, BlockusBlocks.ORANGE_WHITE_COLORED_TILES, Blocks.ORANGE_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.MAGENTA_WHITE_COLORED_TILES, Blocks.MAGENTA_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.LIGHT_BLUE_WHITE_COLORED_TILES, Blocks.LIGHT_BLUE_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.YELLOW_WHITE_COLORED_TILES, Blocks.YELLOW_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.LIME_WHITE_COLORED_TILES, Blocks.LIME_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.PINK_WHITE_COLORED_TILES, Blocks.PINK_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.GRAY_WHITE_COLORED_TILES, Blocks.GRAY_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.LIGHT_GRAY_WHITE_COLORED_TILES, Blocks.LIGHT_GRAY_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.CYAN_WHITE_COLORED_TILES, Blocks.CYAN_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.PURPLE_WHITE_COLORED_TILES, Blocks.PURPLE_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.BLUE_WHITE_COLORED_TILES, Blocks.BLUE_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.BROWN_WHITE_COLORED_TILES, Blocks.BROWN_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.GREEN_WHITE_COLORED_TILES, Blocks.GREEN_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.RED_WHITE_COLORED_TILES, Blocks.RED_CONCRETE, Blocks.WHITE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.BLACK_WHITE_COLORED_TILES, Blocks.BLACK_CONCRETE, Blocks.WHITE_CONCRETE);

        // Other colored Tiles
        offerColoredTilesRecipe(exporter, BlockusBlocks.GRAY_LIGHT_GRAY_COLORED_TILES, Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.BLACK_GRAY_COLORED_TILES, Blocks.BLACK_CONCRETE, Blocks.GRAY_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.BLACK_RED_COLORED_TILES, Blocks.BLACK_CONCRETE, Blocks.RED_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.BLACK_BLUE_COLORED_TILES, Blocks.BLACK_CONCRETE, Blocks.BLUE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.MAGENTA_BLACK_COLORED_TILES, Blocks.MAGENTA_CONCRETE, Blocks.BLACK_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.PINK_MAGENTA_COLORED_TILES, Blocks.PINK_CONCRETE, Blocks.MAGENTA_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.PURPLE_ORANGE_COLORED_TILES, Blocks.PURPLE_CONCRETE, Blocks.ORANGE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.PURPLE_BLUE_COLORED_TILES, Blocks.PURPLE_CONCRETE, Blocks.BLUE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.GREEN_ORANGE_COLORED_TILES, Blocks.GREEN_CONCRETE, Blocks.ORANGE_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.GREEN_BROWN_COLORED_TILES, Blocks.GREEN_CONCRETE, Blocks.BROWN_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.LIME_YELLOW_COLORED_TILES, Blocks.LIME_CONCRETE, Blocks.YELLOW_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.LIGHT_BLUE_YELLOW_COLORED_TILES, Blocks.LIGHT_BLUE_CONCRETE, Blocks.YELLOW_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.BLUE_CYAN_COLORED_TILES, Blocks.BLUE_CONCRETE, Blocks.CYAN_CONCRETE);
        offerColoredTilesRecipe(exporter, BlockusBlocks.RED_BLUE_COLORED_TILES, Blocks.RED_CONCRETE, Blocks.BLUE_CONCRETE);
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
        offerCutCopperRecipe(exporter, BSSTypes.THATCH.block, Items.WHEAT);

        // Paper
        offerReversibleCompactingRecipes(exporter, Items.PAPER, BlockusBlocks.PAPER_BLOCK);
        CookingRecipeJsonFactory.createSmelting(Ingredient.ofItems(BlockusBlocks.PAPER_BLOCK), BlockusBlocks.BURNT_PAPER_BLOCK.asItem(), 0.1F, 200).criterion("has_paper_block", conditionsFromItem(BlockusBlocks.PAPER_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(BlockusBlocks.FRAMED_PAPER_BLOCK, 4).input('X', Items.PAPER).input('#', Items.STICK).pattern("###").pattern("XXX").pattern("###").criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER)).offerTo(exporter);
        offerCutCopperRecipe(exporter, BlockusBlocks.PAPER_WALL, BlockusBlocks.FRAMED_PAPER_BLOCK);
        createEnclosedRecipe(BlockusBlocks.PAPER_LAMP, Ingredient.ofItems(Items.PAPER), Items.TORCH).criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER)).offerTo(exporter);
        offerShapelessRecipe2(exporter, Items.GUNPOWDER, BlockusBlocks.BURNT_PAPER_BLOCK,  2);

        // Plating
        offerStonecuttingRecipe(exporter, BSSTypes.IRON_PLATING.stairs, BSSTypes.IRON_PLATING.block);
        offerStonecuttingRecipe(exporter, BSSTypes.IRON_PLATING.slab, BSSTypes.IRON_PLATING.block, 2);
        ShapedRecipeJsonFactory.create(BSSTypes.IRON_PLATING.block, 24).input('X', Items.IRON_INGOT).pattern("XXX").pattern("X X").pattern("XXX").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, BSSTypes.GOLD_PLATING.stairs, BSSTypes.GOLD_PLATING.block);
        offerStonecuttingRecipe(exporter, BSSTypes.GOLD_PLATING.slab, BSSTypes.GOLD_PLATING.block, 2);
        ShapedRecipeJsonFactory.create(BSSTypes.GOLD_PLATING.block, 24).input('X', Items.GOLD_INGOT).pattern("XXX").pattern("X X").pattern("XXX").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);

        // Gates - chains - bars
        ShapedRecipeJsonFactory.create(BlockusBlocks.IRON_GATE, 3).input('X', Blocks.IRON_BARS).input('#', Items.IRON_NUGGET).pattern("##").pattern("XX").pattern("XX").criterion(hasItem(Blocks.IRON_BARS), conditionsFromItem(Blocks.IRON_BARS)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(BlockusBlocks.GOLDEN_GATE, 3).input('X', BlockusBlocks.GOLDEN_BARS).input('#', Items.GOLD_NUGGET).pattern("##").pattern("XX").pattern("XX").criterion(hasItem(BlockusBlocks.GOLDEN_BARS), conditionsFromItem(BlockusBlocks.GOLDEN_BARS)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(BlockusBlocks.GOLDEN_BARS, 16).input('#', Items.GOLD_INGOT).pattern("###").pattern("###").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(BlockusBlocks.GOLDEN_CHAIN).input('X', Items.GOLD_INGOT).input('#', Items.GOLD_NUGGET).pattern("#").pattern("X").pattern("#").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);

        // Lantern Blocks
        ShapedRecipeJsonFactory.create(BlockusBlocks.LANTERN_BLOCK, 3).input('X', Blocks.LANTERN).input('#', Items.IRON_NUGGET).pattern(" # ").pattern("#X#").pattern(" # ").criterion(hasItem(Blocks.LANTERN), conditionsFromItem(Blocks.LANTERN)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(BlockusBlocks.SOUL_LANTERN_BLOCK, 3).input('X', Blocks.SOUL_LANTERN).input('#', Items.IRON_NUGGET).pattern(" # ").pattern("#X#").pattern(" # ").criterion(hasItem(Blocks.SOUL_LANTERN), conditionsFromItem(Blocks.SOUL_LANTERN)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(BlockusBlocks.SOUL_O_LANTERN, 3).input('X', Blocks.CARVED_PUMPKIN).input('#', Blocks.SOUL_TORCH).pattern("X").pattern("#").criterion(hasItem(Blocks.CARVED_PUMPKIN), conditionsFromItem(Blocks.CARVED_PUMPKIN)).offerTo(exporter);

        // Barriers
        ShapedRecipeJsonFactory.create(BlockusBlocks.ROAD_BARRIER, 5).input('#', Items.IRON_INGOT).input('X', Blocks.STONE).pattern("X#X").pattern("X#X").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
        ShapelessRecipeJsonFactory.create(BlockusBlocks.CAUTION_BARRIER).input(BlockusBlocks.CAUTION_BLOCK).input(BlockusBlocks.ROAD_BARRIER).criterion(hasItem(BlockusBlocks.CAUTION_BLOCK), conditionsFromItem(BlockusBlocks.CAUTION_BLOCK)).criterion(hasItem(BlockusBlocks.ROAD_BARRIER), conditionsFromItem(BlockusBlocks.ROAD_BARRIER)).offerTo(exporter);

        // Netherite Blocks
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
        offerStonecuttingRecipe(exporter, BlockusBlocks.NETHERITE_SLAB, Blocks.NETHERITE_BLOCK, 2);

        // Other
        offerReversibleCompactingRecipes(exporter, Items.CHARCOAL, BlockusBlocks.CHARCOAL_BLOCK);
        offerReversibleCompactingRecipes(exporter, Items.SUGAR, BlockusBlocks.SUGAR_BLOCK);
        offerReversibleCompactingRecipes(exporter, Items.ENDER_PEARL, BlockusBlocks.ENDER_BLOCK);
        offerReversibleCompactingRecipes(exporter, Items.ROTTEN_FLESH, BlockusBlocks.ROTTEN_FLESH_BLOCK);
        offerReversibleCompactingRecipes(exporter, Items.PHANTOM_MEMBRANE, BlockusBlocks.MEMBRANE_BLOCK);
        offerReversibleCompactingRecipes(exporter, Items.NETHER_STAR, BlockusBlocks.NETHER_STAR_BLOCK);
        offerCutCopperRecipe(exporter, BlockusBlocks.WOODEN_FRAME, Items.STICK);
        createEnclosedRecipe(BlockusBlocks.REDSTONE_SAND, Ingredient.ofItems(Items.REDSTONE), Items.SAND).criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE)).offerTo(exporter);
        ShapelessRecipeJsonFactory.create(Items.REDSTONE, 8).input(BlockusBlocks.REDSTONE_SAND).criterion(hasItem(BlockusBlocks.REDSTONE_SAND), conditionsFromItem(BlockusBlocks.REDSTONE_SAND)).offerTo(exporter, convertBetween(Items.REDSTONE, BlockusBlocks.REDSTONE_SAND));
        ShapedRecipeJsonFactory.create(BlockusBlocks.LOVE_BLOCK).input('M', Items.MAGENTA_DYE).input('R', Items.RED_DYE).pattern("RMR").pattern("RRR").pattern("MRM").criterion(hasItem(Items.MAGENTA_DYE), conditionsFromItem(Items.MAGENTA_DYE)).criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE)).offerTo(exporter);
        ShapelessRecipeJsonFactory.create(BlockusBlocks.WEIGHT_STORAGE_CUBE).input(Blocks.STONE).input(Items.IRON_NUGGET).criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE)).offerTo(exporter);
        ShapelessRecipeJsonFactory.create(BlockusBlocks.COMPANION_CUBE).input(BlockusBlocks.WEIGHT_STORAGE_CUBE).input(Items.POPPY).criterion(hasItem(BlockusBlocks.WEIGHT_STORAGE_CUBE), conditionsFromItem(BlockusBlocks.WEIGHT_STORAGE_CUBE)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(BlockusBlocks.CAUTION_BLOCK, 6).input('A', Blocks.STONE).input('B', Items.BLACK_DYE).input('C', Items.YELLOW_DYE).pattern(" C ").pattern("BAB").pattern(" C ").criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE)).criterion(hasItem(Items.YELLOW_DYE), conditionsFromItem(Items.YELLOW_DYE)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(BlockusBlocks.STARS_BLOCK, 3).input('#', Items.ENDER_PEARL).input('X', Items.CHORUS_FRUIT).pattern("X#X").pattern("###").pattern("X#X").criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT)).offerTo(exporter);

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
        offerShapelessRecipe(exporter, Items.IRON_INGOT, BlockusBlocks.LEGACY_IRON_BLOCK, "iron_ingot",9);
        offerShapelessRecipe(exporter, Items.GOLD_INGOT, BlockusBlocks.LEGACY_GOLD_BLOCK, "gold_ingot", 9);
        offerShapelessRecipe(exporter, Items.GOLD_INGOT, BlockusBlocks.EXPLOSION_PROOF_LEGACY_GOLD_BLOCK, "gold_ingot", 9);
        offerShapelessRecipe(exporter, Items.COAL, BlockusBlocks.LEGACY_COAL_BLOCK, "coal", 9);
        offerShapelessRecipe(exporter, Items.DIAMOND, BlockusBlocks.LEGACY_DIAMOND_BLOCK, "diamond", 9);
        offerShapelessRecipe(exporter, Items.LAPIS_LAZULI, BlockusBlocks.LEGACY_LAPIS_BLOCK, "lapis_lazuli", 9);
        ShapedRecipeJsonFactory.create(BlockusBlocks.LEGACY_STONECUTTER).input('#', Blocks.COBBLESTONE).pattern("##").pattern("##").criterion(hasItem(Blocks.STONECUTTER), conditionsFromItem(Blocks.STONECUTTER)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(BlockusBlocks.NETHER_REACTOR_CORE).input('#', Items.DIAMOND).input('X', Items.IRON_INGOT).pattern("X#X").pattern("X#X").pattern("X#X").criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).offerTo(exporter);

    }

    public static void offerShapelessRecipe2(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input, int outputCount) {
        ShapelessRecipeJsonFactory.create(output, outputCount).input(input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerSturdyRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input1, ItemConvertible input2) {
        ShapedRecipeJsonFactory.create(output, 2).input('#', input1).input('X', input2).pattern("X#X").pattern("# #").pattern("X#X").criterion(hasItem(input1), conditionsFromItem(input1)).criterion(hasItem(input2), conditionsFromItem(input2)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(output, 2).input('#', input1).input('X', input2).pattern("#X#").pattern("X X").pattern("#X#").criterion(hasItem(input1), conditionsFromItem(input1)).criterion(hasItem(input2), conditionsFromItem(input2)).offerTo(exporter, getRecipeName(output) + "_alt");

    }

    public static void offerDecoratedRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible decoration, ItemConvertible input) {
        ShapedRecipeJsonFactory.create(output, 4).input('#', decoration).input('X', input).pattern("##").pattern("XX").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerPhantomPurpurRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonFactory.create(output).input(input).input(BlockusItemTags.SOUL_SOILS).criterion("has_purpur", conditionsFromItem(input)).offerTo(exporter, convertBetween(output, Blocks.SOUL_SAND));

    }

    public static void offerColoredTilesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible color1, ItemConvertible color2) {
        ShapelessRecipeJsonFactory.create(output).input(color1).input(color2).group("colored_tiles").criterion(hasItem(color1), conditionsFromItem(color1)).criterion(hasItem(color2), conditionsFromItem(color2)).offerTo(exporter);

    }

    public static void offerUnicolorColoredTilesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible color) {
        ShapelessRecipeJsonFactory.create(output).input(color).input(color).group("colored_tiles").criterion(hasItem(color), conditionsFromItem(color)).offerTo(exporter);

    }

    public static void offerSmallLogsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonFactory.create(output).input(input).input(input).input(input).group("small_logs").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);

    }

    public static void offerSmallHedgesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonFactory.create(output).input('#',  input).pattern("###").pattern("###").group("small_hedge").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static CraftingRecipeJsonFactory createEnclosedRecipe(ItemConvertible output, Ingredient input, ItemConvertible center) {
        return ShapedRecipeJsonFactory.create(output, 8).input('X', input).input('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
    }

    public static void offerStainedStoneBricksRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab, ItemConvertible output_wall) {
        createEnclosedRecipe(output, Ingredient.ofItems(Blocks.STONE_BRICKS), center).group("stained_stone_bricks").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(Blocks.STONE_BRICK_STAIRS), center).group("stained_stone_brick_stairs").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_stairs, Blocks.STONE_BRICK_STAIRS));
        createEnclosedRecipe(output_slab, Ingredient.ofItems(Blocks.STONE_BRICK_SLAB), center).group("stained_stone_brick_slab").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_slab, Blocks.STONE_BRICK_SLAB));
        createEnclosedRecipe(output_wall, Ingredient.ofItems(Blocks.STONE_BRICK_WALL), center).group("stained_stone_brick_wall").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_wall, Blocks.STONE_BRICK_WALL));
    }

    public static void offerAsphaltRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab) {
        createEnclosedRecipe(output, Ingredient.ofItems(AsphaltTypes.ASPHALT.block), center).group("asphalt").criterion(hasItem(AsphaltTypes.ASPHALT.block), conditionsFromItem(AsphaltTypes.ASPHALT.block)).offerTo(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(AsphaltTypes.ASPHALT.stairs), center).group("asphalt_stairs").criterion(hasItem(AsphaltTypes.ASPHALT.block), conditionsFromItem(AsphaltTypes.ASPHALT.block)).offerTo(exporter, convertBetween(output_stairs, AsphaltTypes.ASPHALT.stairs));
        createEnclosedRecipe(output_slab, Ingredient.ofItems(AsphaltTypes.ASPHALT.slab), center).group("asphalt_slab").criterion(hasItem(AsphaltTypes.ASPHALT.block), conditionsFromItem(AsphaltTypes.ASPHALT.block)).offerTo(exporter, convertBetween(output_slab, AsphaltTypes.ASPHALT.slab));
    }

    public static void offerShinglesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab) {
        createEnclosedRecipe(output, Ingredient.ofItems(BSSTypes.SHINGLES.block), center).group("shingles").criterion(hasItem(BSSTypes.SHINGLES.block), conditionsFromItem(BSSTypes.SHINGLES.block)).offerTo(exporter, convertBetween(output_stairs, BSSTypes.SHINGLES.block));
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(BSSTypes.SHINGLES.stairs), center).group("shingles_stairs").criterion(hasItem(BSSTypes.SHINGLES.block), conditionsFromItem(BSSTypes.SHINGLES.block)).offerTo(exporter, convertBetween(output_stairs, BSSTypes.SHINGLES.stairs));
        createEnclosedRecipe(output_slab, Ingredient.ofItems(BSSTypes.SHINGLES.slab), center).group("shingles_slab").criterion(hasItem(BSSTypes.SHINGLES.block), conditionsFromItem(BSSTypes.SHINGLES.block)).offerTo(exporter, convertBetween(output_slab, BSSTypes.SHINGLES.slab));
    }

    public static void offerStairsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);

    }

    public static void offerStainedBeveledGlassRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible output_pane, ItemConvertible input, ItemConvertible dye) {
        createCondensingRecipe(output, Ingredient.ofItems(input)).group("beveled_glass").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
        createEnclosedRecipe(output, Ingredient.ofItems(BlockusBlocks.BEVELED_GLASS), dye).group("beveled_glass_2").criterion(hasItem(BlockusBlocks.BEVELED_GLASS), conditionsFromItem(BlockusBlocks.BEVELED_GLASS)).offerTo(exporter, convertBetween(output, BlockusBlocks.BEVELED_GLASS));
        ShapedRecipeJsonFactory.create(output_pane, 16).input('#', output).pattern("###").pattern("###").group("beveled_glass_pane").criterion(hasItem(BlockusBlocks.BEVELED_GLASS_PANE), conditionsFromItem(output)).offerTo(exporter);
        createEnclosedRecipe(output_pane, Ingredient.ofItems(BlockusBlocks.BEVELED_GLASS_PANE), dye).group("beveled_glass_pane_2").criterion(hasItem(BlockusBlocks.BEVELED_GLASS_PANE), conditionsFromItem(BlockusBlocks.BEVELED_GLASS_PANE)).offerTo(exporter, convertBetween(output, BlockusBlocks.BEVELED_GLASS_PANE));
    }

    public static void offerStainedRedstoneLampRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible dye, ItemConvertible output_lit) {
        ShapedRecipeJsonFactory.create(output).input('S', dye).input('#', Blocks.REDSTONE_LAMP).pattern(" S ").pattern("S#S").pattern(" S ").group("redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter);
        ShapelessRecipeJsonFactory.create(output_lit).input(output).input(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").criterion(hasItem(output), conditionsFromItem(output)).offerTo(exporter);
        ShapedRecipeJsonFactory.create(output_lit).input('S', dye).input('#', BlockusBlocks.REDSTONE_LAMP_LIT).pattern(" S ").pattern("S#S").pattern(" S ").group("lit_redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter, getRecipeName(output) + "_alt");
    }

    public static void offerNeonRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible dye) {
        ShapedRecipeJsonFactory.create(output, 8).input('A', dye).input('B', Items.GLOW_INK_SAC).input('C', Items.AMETHYST_SHARD).pattern("CAC").pattern("ABA").pattern("CAC").group("neon_blocks").criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC)).offerTo(exporter);
    }

    public static void offerFuturneoRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible glass) {
        ShapedRecipeJsonFactory.create(output, 6).input('A', Items.BLACK_DYE).input('B', glass).input('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").criterion(hasItem(glass), conditionsFromItem(glass)).offerTo(exporter);

    }

}
