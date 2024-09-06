package com.brand.blockus.datagen.providers;

import com.brand.blockus.datagen.family.BlockusFamilies;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.registry.tag.BlockusItemTags;
import com.brand.blockus.utils.BlockChecker;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.brand.blockus.registry.content.BlockusBlocks.*;


public class BlockusRecipeProvider extends FabricRecipeProvider {
    public BlockusRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        for (BSSWBundle BSSWBundle : BSSWBundle.values()) {
            BlockusRecipeProvider.offerStairsRecipe(exporter, BSSWBundle.stairs, BSSWBundle.block);
            RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BSSWBundle.slab, BSSWBundle.block);
            if (BSSWBundle.wall != null) {
                RecipeProvider.offerWallRecipe(exporter, RecipeCategory.DECORATIONS, BSSWBundle.wall, BSSWBundle.block);
            }
        }

        for (ConcreteBundle concreteType : ConcreteBundle.values()) {
            offerStonecuttingRecipe(exporter, concreteType.block, concreteType.base);
            offerStonecuttingRecipe(exporter, concreteType.stairs, concreteType.base, concreteType.block);
            offerStonecuttingRecipe(exporter, concreteType.slab, 2, concreteType.base, concreteType.block);
            offerStonecuttingRecipe(exporter, concreteType.wall, concreteType.base, concreteType.block);
            offerStonecuttingRecipe(exporter, concreteType.chiseled, concreteType.base, concreteType.block);
            offerStonecuttingRecipe(exporter, concreteType.pillar, concreteType.base, concreteType.block);
            offerPolishedStoneRecipe(exporter, concreteType.block, concreteType.base);
        }

        for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
            createTimberFramesRecipes(exporter, timberFrameBundle.base, timberFrameBundle.block, timberFrameBundle.diagonal, timberFrameBundle.cross);
            createLatticeRecipes(exporter, timberFrameBundle.base, timberFrameBundle.lattice, timberFrameBundle.grate);
        }

        for (AsphaltBundle asphaltBundle : AsphaltBundle.values()) {
            BlockusRecipeProvider.offerStairsRecipe(exporter, asphaltBundle.stairs, asphaltBundle.block);
            RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, asphaltBundle.slab, asphaltBundle.block);
            offerStonecuttingRecipe(exporter, asphaltBundle.stairs, asphaltBundle.block);
            offerStonecuttingRecipe(exporter, asphaltBundle.slab, 2, asphaltBundle.block);
        }

        for (WoolBundle woolBundle : WoolBundle.values()) {
            if (woolBundle.typeSuffix.equals(WoolBundle.PATTERNED)) {
                offerPatternedWoolRecipe(exporter, woolBundle.block, woolBundle.basewool, woolBundle.carpet, woolBundle.basecarpet);
            } else if (woolBundle.typeSuffix.equals(WoolBundle.GINGHAM)) {
                offerGinghamWoolRecipe(exporter, woolBundle.block, woolBundle.basewool);
            }
            BlockusRecipeProvider.offerStairsRecipe(exporter, woolBundle.stairs, woolBundle.block);
            RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, woolBundle.slab, woolBundle.block);
            RecipeProvider.offerCarpetRecipe(exporter, woolBundle.carpet, woolBundle.block);

        }

        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            offerColoredTilesRecipe(exporter, coloredTilesVariants.block, coloredTilesVariants.tile1, coloredTilesVariants.tile2);
        }

        generateFamilies(exporter, FeatureSet.of(FeatureFlags.VANILLA));

        offerPillarRecipe(exporter, MUD_BRICK_PILLAR, Blocks.MUD_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_MUD_BRICKS, Blocks.MUD_BRICKS);

        // Stone
        offerBsswCuttingRecipe(exporter, STONE_TILES, Blocks.STONE, Blocks.STONE_BRICKS);
        offerPolishedStoneRecipe(exporter, STONE_TILES.block, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, STONE_BRICK_PILLAR, Blocks.STONE, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_STONE_BRICKS, Blocks.STONE, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, STONE_CIRCULAR_PAVING, Blocks.STONE, Blocks.STONE_BRICKS);
        offerStonecuttingRecipe(exporter, SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
        offerStairsRecipe(exporter, SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
        offerSturdyRecipe(exporter, STURDY_STONE, Blocks.STONE, Blocks.COBBLESTONE);
        offerStoneDoorTrapdoorRecipe(exporter, STONE_DOOR, STONE_TRAPDOOR, Blocks.STONE, Blocks.STONE_SLAB);

        // Andesite
        offerBsswCuttingRecipe(exporter, ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
        offerPolishedStoneRecipe(exporter, ANDESITE_BRICKS.block, Blocks.POLISHED_ANDESITE);
        offerCrackingRecipe(exporter, CRACKED_ANDESITE_BRICKS, ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, POLISHED_ANDESITE_PILLAR, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, HERRINGBONE_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, ANDESITE_CIRCULAR_PAVING, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, POLISHED_ANDESITE_PRESSURE_PLATE, POLISHED_ANDESITE_BUTTON, Blocks.POLISHED_ANDESITE);

        // Diorite
        offerBsswCuttingRecipe(exporter, DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
        offerPolishedStoneRecipe(exporter, DIORITE_BRICKS.block, Blocks.POLISHED_DIORITE);
        offerCrackingRecipe(exporter, CRACKED_DIORITE_BRICKS, DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, POLISHED_DIORITE_PILLAR, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, HERRINGBONE_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, DIORITE_CIRCULAR_PAVING, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, POLISHED_DIORITE_PRESSURE_PLATE, POLISHED_DIORITE_BUTTON, Blocks.POLISHED_DIORITE);

        // Granite
        offerBsswCuttingRecipe(exporter, GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE);
        offerPolishedStoneRecipe(exporter, GRANITE_BRICKS.block, Blocks.POLISHED_GRANITE);
        offerCrackingRecipe(exporter, CRACKED_GRANITE_BRICKS, GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, POLISHED_GRANITE_PILLAR, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, HERRINGBONE_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, GRANITE_CIRCULAR_PAVING, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, POLISHED_GRANITE_PRESSURE_PLATE, POLISHED_GRANITE_BUTTON, Blocks.POLISHED_GRANITE);

        // Dripstone
        offerBsswCuttingRecipe(exporter, POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
        offerPolishedStoneRecipe(exporter, POLISHED_DRIPSTONE.block, Blocks.DRIPSTONE_BLOCK);
        offerBsswCuttingRecipe(exporter, DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block);
        offerPolishedStoneRecipe(exporter, DRIPSTONE_BRICKS.block, POLISHED_DRIPSTONE.block);
        offerMossyRecipe(exporter, MOSSY_DRIPSTONE_BRICKS.block, DRIPSTONE_BRICKS.block);
        offerBsswCuttingRecipe(exporter, MOSSY_DRIPSTONE_BRICKS);
        offerCrackingRecipe(exporter, CRACKED_DRIPSTONE_BRICKS, DRIPSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block, DRIPSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, DRIPSTONE_PILLAR, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block, DRIPSTONE_BRICKS.block);

        // Tuff
        offerBsswCuttingRecipe(exporter, POLISHED_TUFF, Blocks.TUFF);
        offerPolishedStoneRecipe(exporter, POLISHED_TUFF.block, Blocks.TUFF);
        offerBsswCuttingRecipe(exporter, TUFF_BRICKS, Blocks.TUFF, POLISHED_TUFF.block);
        offerPolishedStoneRecipe(exporter, TUFF_BRICKS.block, POLISHED_TUFF.block);
        offerBsswCuttingRecipe(exporter, TUFF_TILES, Blocks.TUFF, POLISHED_TUFF.block, TUFF_BRICKS.block);
        offerPolishedStoneRecipe(exporter, TUFF_TILES.block, TUFF_BRICKS.block);
        offerCrackingRecipe(exporter, CRACKED_TUFF_BRICKS, TUFF_BRICKS.block);
        offerMossyRecipe(exporter, MOSSY_TUFF_BRICKS.block, TUFF_BRICKS.block);
        offerBsswCuttingRecipe(exporter, MOSSY_TUFF_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_TUFF, Blocks.TUFF, POLISHED_TUFF.block, TUFF_BRICKS.block);
        offerStonecuttingRecipe(exporter, TUFF_PILLAR, Blocks.TUFF, POLISHED_TUFF.block, TUFF_BRICKS.block);
        offerStonecuttingRecipe(exporter, HERRINGBONE_TUFF_BRICKS, Blocks.TUFF, POLISHED_TUFF.block, TUFF_BRICKS.block);
        offerStonecuttingRecipe(exporter, TUFF_CIRCULAR_PAVING, Blocks.TUFF, POLISHED_TUFF.block, TUFF_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, POLISHED_TUFF_PRESSURE_PLATE, POLISHED_TUFF_BUTTON, POLISHED_TUFF.block);

        // Amethyst
        offerBsswCuttingRecipe(exporter, POLISHED_AMETHYST, Blocks.AMETHYST_BLOCK);
        offerPolishedStoneRecipe(exporter, POLISHED_AMETHYST.block, Blocks.AMETHYST_BLOCK);
        offerBsswCuttingRecipe(exporter, AMETHYST_BRICKS, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block);
        offerPolishedStoneRecipe(exporter, AMETHYST_BRICKS.block, POLISHED_AMETHYST.block);
        offerStonecuttingRecipe(exporter, CHISELED_AMETHYST, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block, AMETHYST_BRICKS.block);
        offerStonecuttingRecipe(exporter, AMETHYST_PILLAR, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block, AMETHYST_BRICKS.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AMETHYST_LAMP).input('#', Items.AMETHYST_SHARD).input('X', Items.REDSTONE).pattern(" # ").pattern("#X#").pattern(" # ").criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD)).offerTo(exporter);

        // Deepslate
        offerMossyRecipe(exporter, MOSSY_DEEPSLATE_BRICKS.block, Blocks.DEEPSLATE_BRICKS);
        offerBsswCuttingRecipe(exporter, MOSSY_DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, DEEPSLATE_PILLAR, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, DEEPSLATE_CIRCULAR_PAVING, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        offerSturdyRecipe(exporter, STURDY_DEEPSLATE, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
        offerPressurePlateButtonRecipe(exporter, POLISHED_DEEPSLATE_PRESSURE_PLATE, POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);

        // Sculk
        offerBsswCuttingRecipe(exporter, POLISHED_SCULK, Blocks.SCULK);
        offerPolishedStoneRecipe(exporter, POLISHED_SCULK.block, Blocks.SCULK);
        offerBsswCuttingRecipe(exporter, SCULK_BRICKS, Blocks.SCULK, POLISHED_SCULK.block);
        offerStonecuttingRecipe(exporter, CHISELED_SCULK_BRICKS, Blocks.SCULK, POLISHED_SCULK.block, SCULK_BRICKS.block);
        offerStonecuttingRecipe(exporter, SCULK_PILLAR, Blocks.SCULK, POLISHED_SCULK.block, SCULK_BRICKS.block);
        offerPolishedStoneRecipe(exporter, SCULK_BRICKS.block, POLISHED_SCULK.block);
        offerPressurePlateButtonRecipe(exporter, POLISHED_SCULK_PRESSURE_PLATE, POLISHED_SCULK_BUTTON, POLISHED_SCULK.block);

        // Blackstone
        offerBsswCuttingRecipe(exporter, POLISHED_BLACKSTONE_TILES, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerPolishedStoneRecipe(exporter, POLISHED_BLACKSTONE_TILES.block, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, POLISHED_BLACKSTONE_PILLAR, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, POLISHED_BLACKSTONE_CIRCULAR_PAVING, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_WARTY_BLACKSTONE_BRICKS.block).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(Blocks.CRIMSON_ROOTS).criterion("has_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, CRIMSON_WARTY_BLACKSTONE_BRICKS);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_WARTY_BLACKSTONE_BRICKS.block).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(BlockusItemTags.WARPED_NETHER_GRASS).criterion("has_roots", conditionsFromTag(BlockusItemTags.WARPED_NETHER_GRASS)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, WARPED_WARTY_BLACKSTONE_BRICKS);
        offerSturdyRecipe(exporter, STURDY_BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
        offerDecoratedRecipe(exporter, GOLD_DECORATED_POLISHED_BLACKSTONE, Items.GOLD_INGOT, Blocks.POLISHED_BLACKSTONE);
        offerStoneDoorTrapdoorRecipe(exporter, BLACKSTONE_DOOR, BLACKSTONE_TRAPDOOR, Blocks.BLACKSTONE, Blocks.BLACKSTONE_SLAB);

        // Basalt
        offerBsswCuttingRecipe(exporter, ROUGH_BASALT);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ROUGH_BASALT.block, 2).input('#', Blocks.BASALT).pattern("#").pattern("#").criterion("has_basalt", conditionsFromItem(Blocks.BASALT)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT);
        offerPolishedStoneRecipe(exporter, POLISHED_BASALT_BRICKS.block, Blocks.POLISHED_BASALT);
        offerCrackingRecipe(exporter, CRACKED_POLISHED_BASALT_BRICKS, POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_POLISHED_BASALT, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, POLISHED_BASALT_PILLAR, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, HERRINGBONE_POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block);
        offerStonecuttingRecipe(exporter, POLISHED_BASALT_CIRCULAR_PAVING, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, POLISHED_BASALT_PRESSURE_PLATE, POLISHED_BASALT_BUTTON, Blocks.POLISHED_BASALT);

        // Wart Blocks
        offerBsswCuttingRecipe(exporter, CRIMSON_WART_BRICKS, Blocks.NETHER_WART_BLOCK);
        offerPolishedStoneRecipe(exporter, CRIMSON_WART_BRICKS.block, Blocks.NETHER_WART_BLOCK);
        offerBsswCuttingRecipe(exporter, WARPED_WART_BRICKS, Blocks.WARPED_WART_BLOCK);
        offerPolishedStoneRecipe(exporter, WARPED_WART_BRICKS.block, Blocks.WARPED_WART_BLOCK);

        // Limestone
        offerBsswCuttingRecipe(exporter, LIMESTONE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LIMESTONE.block).input('#', Blocks.COBBLESTONE).input('X', Items.BONE_MEAL).pattern("#X").pattern("X#").criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, POLISHED_LIMESTONE, LIMESTONE.block);
        offerPolishedStoneRecipe(exporter, POLISHED_LIMESTONE.block, LIMESTONE.block);
        offerBsswCuttingRecipe(exporter, LIMESTONE_BRICKS, LIMESTONE.block, POLISHED_LIMESTONE.block);
        offerPolishedStoneRecipe(exporter, LIMESTONE_BRICKS.block, POLISHED_LIMESTONE.block);
        offerBsswCuttingRecipe(exporter, SMALL_LIMESTONE_BRICKS, LIMESTONE.block, POLISHED_LIMESTONE.block, LIMESTONE_BRICKS.block);
        offerBsswCuttingRecipe(exporter, LIMESTONE_TILES, LIMESTONE.block, POLISHED_LIMESTONE.block, LIMESTONE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, LIMESTONE_TILES.block, LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_LIMESTONE, LIMESTONE.block, POLISHED_LIMESTONE.block, LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_LIMESTONE_PILLAR, LIMESTONE.block, POLISHED_LIMESTONE.block, LIMESTONE_BRICKS.block, LIMESTONE_PILLAR);
        offerStonecuttingRecipe(exporter, LIMESTONE_PILLAR, LIMESTONE.block, POLISHED_LIMESTONE.block, LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, LIMESTONE_SQUARES, LIMESTONE.block, POLISHED_LIMESTONE.block, LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, LIMESTONE_CIRCULAR_PAVING, LIMESTONE.block, POLISHED_LIMESTONE.block, LIMESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, LIMESTONE_LINES, LIMESTONE.block, POLISHED_LIMESTONE.block, LIMESTONE_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, LIMESTONE_PRESSURE_PLATE, LIMESTONE_BUTTON, LIMESTONE.block);

        // Marble
        offerBsswCuttingRecipe(exporter, MARBLE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MARBLE.block).input('#', LIMESTONE.block).input('X', Items.BONE_MEAL).pattern("#X").pattern("X#").group("marble").criterion(hasItem(LIMESTONE.block), conditionsFromItem(LIMESTONE.block)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MARBLE.block).input(Blocks.CALCITE).input(LIMESTONE.block).group("marble").criterion(hasItem(Blocks.CALCITE), conditionsFromItem(Blocks.CALCITE)).offerTo(exporter, convertBetween(MARBLE.block, Blocks.CALCITE));
        offerBsswCuttingRecipe(exporter, POLISHED_MARBLE, MARBLE.block);
        offerPolishedStoneRecipe(exporter, POLISHED_MARBLE.block, MARBLE.block);
        offerBsswCuttingRecipe(exporter, MARBLE_BRICKS, MARBLE.block, POLISHED_MARBLE.block);
        offerPolishedStoneRecipe(exporter, MARBLE_BRICKS.block, POLISHED_MARBLE.block);
        offerBsswCuttingRecipe(exporter, SMALL_MARBLE_BRICKS, MARBLE.block, POLISHED_MARBLE.block, MARBLE_BRICKS.block);
        offerBsswCuttingRecipe(exporter, MARBLE_TILES, MARBLE.block, POLISHED_MARBLE.block, MARBLE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, MARBLE_TILES.block, MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_MARBLE, MARBLE.block, POLISHED_MARBLE.block, MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_MARBLE_PILLAR, MARBLE.block, POLISHED_MARBLE.block, MARBLE_BRICKS.block, MARBLE_PILLAR);
        offerStonecuttingRecipe(exporter, MARBLE_PILLAR, MARBLE.block, POLISHED_MARBLE.block, MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, MARBLE_SQUARES, MARBLE.block, POLISHED_MARBLE.block, MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, MARBLE_CIRCULAR_PAVING, MARBLE.block, POLISHED_MARBLE.block, MARBLE_BRICKS.block);
        offerStonecuttingRecipe(exporter, MARBLE_LINES, MARBLE.block, POLISHED_MARBLE.block, MARBLE_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, MARBLE_PRESSURE_PLATE, MARBLE_BUTTON, MARBLE.block);

        // Bluestone
        offerBsswCuttingRecipe(exporter, BLUESTONE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLUESTONE.block, 4).input('S', Blocks.STONE).input('#', Items.BLUE_DYE).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE)).criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, POLISHED_BLUESTONE, BLUESTONE.block);
        offerPolishedStoneRecipe(exporter, POLISHED_BLUESTONE.block, BLUESTONE.block);
        offerBsswCuttingRecipe(exporter, BLUESTONE_BRICKS, BLUESTONE.block, POLISHED_BLUESTONE.block);
        offerPolishedStoneRecipe(exporter, BLUESTONE_BRICKS.block, POLISHED_BLUESTONE.block);
        offerBsswCuttingRecipe(exporter, SMALL_BLUESTONE_BRICKS, BLUESTONE.block, POLISHED_BLUESTONE.block, BLUESTONE_BRICKS.block);
        offerBsswCuttingRecipe(exporter, BLUESTONE_TILES, BLUESTONE.block, POLISHED_BLUESTONE.block, BLUESTONE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, BLUESTONE_TILES.block, BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_BLUESTONE, BLUESTONE.block, POLISHED_BLUESTONE.block, BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_BLUESTONE_PILLAR, BLUESTONE.block, POLISHED_BLUESTONE.block, BLUESTONE_BRICKS.block, BLUESTONE_PILLAR);
        offerStonecuttingRecipe(exporter, BLUESTONE_PILLAR, BLUESTONE.block, POLISHED_BLUESTONE.block, BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BLUESTONE_SQUARES, BLUESTONE.block, POLISHED_BLUESTONE.block, BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BLUESTONE_CIRCULAR_PAVING, BLUESTONE.block, POLISHED_BLUESTONE.block, BLUESTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, BLUESTONE_LINES, BLUESTONE.block, POLISHED_BLUESTONE.block, BLUESTONE_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, BLUESTONE_PRESSURE_PLATE, BLUESTONE_BUTTON, BLUESTONE.block);

        // Viridite
        offerBsswCuttingRecipe(exporter, VIRIDITE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block, 4).input('S', Blocks.DEEPSLATE).input('#', Blocks.SCULK).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Blocks.SCULK), conditionsFromItem(Blocks.SCULK)).criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block, 4).input('S', Blocks.DEEPSLATE).input('#', Items.GREEN_DYE).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Items.GREEN_DYE), conditionsFromItem(Items.GREEN_DYE)).criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE)).offerTo(exporter, convertBetween(VIRIDITE.block, Items.GREEN_DYE));
        offerBsswCuttingRecipe(exporter, POLISHED_VIRIDITE, VIRIDITE.block);
        offerPolishedStoneRecipe(exporter, POLISHED_VIRIDITE.block, VIRIDITE.block);
        offerBsswCuttingRecipe(exporter, VIRIDITE_BRICKS, VIRIDITE.block, POLISHED_VIRIDITE.block);
        offerPolishedStoneRecipe(exporter, VIRIDITE_BRICKS.block, POLISHED_VIRIDITE.block);
        offerBsswCuttingRecipe(exporter, SMALL_VIRIDITE_BRICKS, VIRIDITE.block, POLISHED_VIRIDITE.block, VIRIDITE_BRICKS.block);
        offerBsswCuttingRecipe(exporter, VIRIDITE_TILES, VIRIDITE.block, POLISHED_VIRIDITE.block, VIRIDITE_BRICKS.block);
        offerPolishedStoneRecipe(exporter, VIRIDITE_TILES.block, VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_VIRIDITE, VIRIDITE.block, POLISHED_VIRIDITE.block, VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_VIRIDITE_PILLAR, VIRIDITE.block, POLISHED_VIRIDITE.block, VIRIDITE_BRICKS.block, VIRIDITE_PILLAR);
        offerStonecuttingRecipe(exporter, VIRIDITE_PILLAR, VIRIDITE.block, POLISHED_VIRIDITE.block, VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, VIRIDITE_SQUARES, VIRIDITE.block, POLISHED_VIRIDITE.block, VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, VIRIDITE_CIRCULAR_PAVING, VIRIDITE.block, POLISHED_VIRIDITE.block, VIRIDITE_BRICKS.block);
        offerStonecuttingRecipe(exporter, VIRIDITE_LINES, VIRIDITE.block, POLISHED_VIRIDITE.block, VIRIDITE_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, VIRIDITE_PRESSURE_PLATE, VIRIDITE_BUTTON, VIRIDITE.block);

        // Lava	Bricks
        offerBsswCuttingRecipe(exporter, LAVA_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_LAVA_BRICKS, LAVA_BRICKS.block);
        createEnclosedRecipe(LAVA_BRICKS.block, Ingredient.ofItems(Blocks.STONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

        // Lava Blackstone Bricks
        offerBsswCuttingRecipe(exporter, LAVA_POLISHED_BLACKSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_LAVA_POLISHED_BLACKSTONE, LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        createEnclosedRecipe(LAVA_POLISHED_BLACKSTONE_BRICKS.block, Ingredient.ofItems(Blocks.POLISHED_BLACKSTONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.POLISHED_BLACKSTONE_BRICKS), conditionsFromItem(Blocks.POLISHED_BLACKSTONE_BRICKS)).offerTo(exporter);

        // Water Bricks
        offerBsswCuttingRecipe(exporter, WATER_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_WATER_BRICKS, WATER_BRICKS.block);
        createEnclosedRecipe(WATER_BRICKS.block, Ingredient.ofItems(Blocks.STONE_BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

        // Snow Bricks
        offerBsswCuttingRecipe(exporter, SNOW_BRICKS);
        offerStonecuttingRecipe(exporter, SNOW_PILLAR, SNOW_BRICKS.block);
        offerPolishedStoneRecipe(exporter, SNOW_BRICKS.block, Blocks.SNOW_BLOCK);

        // Ice Bricks
        offerStonecuttingRecipe(exporter, ICE_BRICK_WALL, ICE_BRICKS);
        offerStonecuttingRecipe(exporter, ICE_PILLAR, ICE_BRICKS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ICE_BRICKS, 4).input('#', BlockusItemTags.NATURAL_ICE).pattern("##").pattern("##").criterion("has_ice", conditionsFromTag(BlockusItemTags.NATURAL_ICE)).offerTo(exporter);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ICE_BRICK_WALL, ICE_BRICKS);

        // Magma Bricks
        offerBsswCuttingRecipe(exporter, MAGMA_BRICKS, Blocks.MAGMA_BLOCK);
        offerPolishedStoneRecipe(exporter, MAGMA_BRICKS.block, Blocks.MAGMA_BLOCK);
        offerBsswCuttingRecipe(exporter, SMALL_MAGMA_BRICKS, Blocks.MAGMA_BLOCK, MAGMA_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_MAGMA_BRICKS, Blocks.MAGMA_BLOCK, MAGMA_BRICKS.block);

        // Blaze Bricks
        offerBsswCuttingRecipe(exporter, BLAZE_BRICKS);
        offerStonecuttingRecipe(exporter, BLAZE_PILLAR, BLAZE_BRICKS.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLAZE_BRICKS.block).input('#', Items.BLAZE_POWDER).input('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").criterion("has_blaze_rod", conditionsFromItem(Items.BLAZE_ROD)).offerTo(exporter);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.BLAZE_POWDER, RecipeCategory.BUILDING_BLOCKS, BLAZE_LANTERN);

        // Netherrack
        offerBsswCuttingRecipe(exporter, POLISHED_NETHERRACK, Blocks.NETHERRACK);
        offerPolishedStoneRecipe(exporter, POLISHED_NETHERRACK.block, Blocks.NETHERRACK);
        offerBsswCuttingRecipe(exporter, NETHERRACK_BRICKS, Blocks.NETHERRACK, POLISHED_NETHERRACK.block);
        offerStonecuttingRecipe(exporter, NETHERRACK_CIRCULAR_PAVING, Blocks.NETHERRACK, POLISHED_NETHERRACK.block, NETHERRACK_BRICKS.block);
        offerPressurePlateButtonRecipe(exporter, POLISHED_NETHERRACK_PRESSURE_PLATE, POLISHED_NETHERRACK_BUTTON, POLISHED_NETHERRACK.block);

        // Nether Bricks
        offerBsswCuttingRecipe(exporter, POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, POLISHED_NETHER_BRICKS.block, Blocks.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, NETHER_BRICK_PILLAR, Blocks.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_NETHER_BRICKS, Blocks.NETHER_BRICKS);

        offerBsswCuttingRecipe(exporter, POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, POLISHED_RED_NETHER_BRICKS.block, Blocks.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, RED_NETHER_BRICK_PILLAR, Blocks.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);

        offerBsswCuttingRecipe(exporter, NETHER_TILES);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, NETHER_TILES.block, 4).input('#', Blocks.NETHERRACK).input('X', Blocks.NETHER_BRICKS).pattern("#X").pattern("X#").criterion(hasItem(Blocks.NETHER_BRICKS), conditionsFromItem(Blocks.NETHER_BRICKS)).offerTo(exporter);

        // Charred Nether Bricks
        offerBsswCuttingRecipe(exporter, CHARRED_NETHER_BRICKS);
        offerBsswCuttingRecipe(exporter, POLISHED_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block);
        offerPolishedStoneRecipe(exporter, POLISHED_CHARRED_NETHER_BRICKS.block, CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, HERRINGBONE_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHARRED_NETHER_BRICK_PILLAR, CHARRED_NETHER_BRICKS.block);
        createEnclosedRecipe(CHARRED_NETHER_BRICKS.block, Ingredient.ofItems(Blocks.NETHER_BRICKS), Items.FIRE_CHARGE).criterion(hasItem(Items.FIRE_CHARGE), conditionsFromItem(Items.FIRE_CHARGE)).criterion(hasItem(Blocks.NETHER_BRICKS), conditionsFromItem(Blocks.NETHER_BRICKS)).offerTo(exporter);

        // Teal Nether Bricks
        offerBsswCuttingRecipe(exporter, TEAL_NETHER_BRICKS);
        offerBsswCuttingRecipe(exporter, POLISHED_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block);
        offerPolishedStoneRecipe(exporter, POLISHED_TEAL_NETHER_BRICKS.block, TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, HERRINGBONE_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block);
        offerStonecuttingRecipe(exporter, TEAL_NETHER_BRICK_PILLAR, TEAL_NETHER_BRICKS.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block).input('#', BlockusItemTags.WARPED_NETHER_GRASS).input('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").group("teal_nether_bricks").criterion("has_warped_grass", conditionsFromTag(BlockusItemTags.WARPED_NETHER_GRASS)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block, 2).input(Blocks.WARPED_WART_BLOCK).input(Items.NETHER_BRICKS).group("teal_nether_bricks").criterion(hasItem(Blocks.WARPED_WART_BLOCK), conditionsFromItem(Blocks.WARPED_WART_BLOCK)).offerTo(exporter, convertBetween(TEAL_NETHER_BRICKS.block, Blocks.WARPED_WART_BLOCK));

        // Obsidian
        offerBsswCuttingRecipe(exporter, OBSIDIAN_BRICKS, Blocks.OBSIDIAN );
        offerPolishedStoneRecipe(exporter, OBSIDIAN_BRICKS.block, Blocks.OBSIDIAN);
        offerCrackingRecipe(exporter, CRACKED_OBSIDIAN_BRICKS, OBSIDIAN_BRICKS.block);
        offerBsswCuttingRecipe(exporter, SMALL_OBSIDIAN_BRICKS, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, OBSIDIAN_PILLAR, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block);
        offerStonecuttingRecipe(exporter, OBSIDIAN_CIRCULAR_PAVING, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block);
        offerDoorTrapdoorRecipe(exporter, OBSIDIAN_REINFORCED_DOOR, OBSIDIAN_REINFORCED_TRAPDOOR, Blocks.OBSIDIAN);
        offerPressurePlateRecipe(exporter, OBSIDIAN_PRESSURE_PLATE, Blocks.OBSIDIAN);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, GLOWING_OBSIDIAN, 4).input('S', Blocks.OBSIDIAN).input('#', Blocks.SHROOMLIGHT).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Blocks.SHROOMLIGHT), conditionsFromItem(Blocks.SHROOMLIGHT)).offerTo(exporter);

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
            offerWaxingRecipes(exporter, copperBundle.block, copperBundle.blockWaxed);
            offerWaxingRecipes(exporter, copperBundle.slab, copperBundle.slabWaxed);
            offerWaxingRecipes(exporter, copperBundle.stairs, copperBundle.stairsWaxed);
            offerWaxingRecipes(exporter, copperBundle.wall, copperBundle.wallWaxed);
            if (copperBundle.type.contains("copper_tuff_bricks")) {
                offerStonecuttingRecipe(exporter, copperBundle.stairs, copperBundle.block);
                offerStonecuttingRecipe(exporter, copperBundle.slab, 2, copperBundle.block);
                offerStonecuttingRecipe(exporter, copperBundle.wall, copperBundle.block);
                offerStonecuttingRecipe(exporter, copperBundle.stairsWaxed, copperBundle.blockWaxed);
                offerStonecuttingRecipe(exporter, copperBundle.slabWaxed, 2, copperBundle.blockWaxed);
                offerStonecuttingRecipe(exporter, copperBundle.wallWaxed, copperBundle.blockWaxed);
            }
        }
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COPPER_TUFF_BRICKS.block, 2).input('#', Items.COPPER_INGOT).input('X', TUFF_BRICKS.block).pattern("#X").pattern("X#").criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).criterion(hasItem(TUFF_BRICKS.block), conditionsFromItem(TUFF_BRICKS.block)).offerTo(exporter);

        // Quartz Blocks
        offerBsswCuttingRecipe(exporter, QUARTZ_TILES, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);
        offerPolishedStoneRecipe(exporter, QUARTZ_TILES.block, Blocks.QUARTZ_BRICKS);
        offerStonecuttingRecipe(exporter, QUARTZ_CIRCULAR_PAVING, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);

        // Prismarine
        offerStonecuttingRecipe(exporter, CHISELED_PRISMARINE, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, PRISMARINE_CIRCULAR_PAVING, Blocks.PRISMARINE_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_DARK_PRISMARINE, Blocks.DARK_PRISMARINE);
        offerStonecuttingRecipe(exporter, DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE);
        offerBsswCuttingRecipe(exporter, PRISMARINE_TILES);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILES.block, 4).input('#', Blocks.DARK_PRISMARINE).input('X', Items.PRISMARINE_SHARD).pattern("#X").pattern("X#").criterion(hasItem(Blocks.DARK_PRISMARINE), conditionsFromItem(Blocks.DARK_PRISMARINE)).offerTo(exporter);

        // Bricks
        offerBsswCuttingRecipe(exporter, LARGE_BRICKS, Blocks.BRICKS);
        offerPolishedStoneRecipe(exporter, LARGE_BRICKS.block, Blocks.BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_BRICKS, Blocks.BRICKS);

        // Soaked Bricks
        offerBsswCuttingRecipe(exporter, SOAKED_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_SOAKED_BRICKS, SOAKED_BRICKS.block);
        createEnclosedRecipe(SOAKED_BRICKS.block, Ingredient.ofItems(Blocks.BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Sandy Bricks
        offerBsswCuttingRecipe(exporter, SANDY_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_SANDY_BRICKS, SANDY_BRICKS.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, SANDY_BRICKS.block, 2).input('S', Blocks.SAND).input('#', Blocks.BRICKS).pattern(" S ").pattern("S#S").pattern(" S ").criterion("has_sand", conditionsFromItem(Blocks.SAND)).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Charred Bricks
        offerBsswCuttingRecipe(exporter, CHARRED_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_CHARRED_BRICKS, CHARRED_BRICKS.block);
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, CHARRED_BRICKS.block.asItem(), 0.1F, 200).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

        // Sandstone
        offerBsswCuttingRecipe(exporter, ROUGH_SANDSTONE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ROUGH_SANDSTONE.block, 2).input('#', Blocks.SANDSTONE_SLAB).pattern("##").pattern("##").criterion("has_sandstone", conditionsFromItem(Blocks.SANDSTONE)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, SANDSTONE_BRICKS, Blocks.SANDSTONE);
        offerBsswCuttingRecipe(exporter, SMALL_SANDSTONE_BRICKS, Blocks.SANDSTONE, SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, SANDSTONE_PILLAR, Blocks.SANDSTONE, SANDSTONE_BRICKS.block);
        offerDecoratedRecipe(exporter, GOLD_DECORATED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_SANDSTONE);
        offerDecoratedRecipe(exporter, LAPIS_DECORATED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_SANDSTONE);

        // Red Sandstone
        offerBsswCuttingRecipe(exporter, ROUGH_RED_SANDSTONE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ROUGH_RED_SANDSTONE.block, 2).input('#', Blocks.RED_SANDSTONE_SLAB).pattern("##").pattern("##").criterion("has_red_sandstone", conditionsFromItem(Blocks.RED_SANDSTONE)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE);
        offerBsswCuttingRecipe(exporter, SMALL_RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block);
        offerDecoratedRecipe(exporter, GOLD_DECORATED_RED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_RED_SANDSTONE);
        offerDecoratedRecipe(exporter, LAPIS_DECORATED_RED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_RED_SANDSTONE);

        // Soul Sandstone
        offerBsswCuttingRecipe(exporter, SOUL_SANDSTONE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, SOUL_SANDSTONE.block).input('#', BlockusItemTags.SOUL_SOILS).pattern("##").pattern("##").criterion("has_soul_sand", conditionsFromTag(BlockusItemTags.SOUL_SOILS)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, SMOOTH_SOUL_SANDSTONE);
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(SOUL_SANDSTONE.block), RecipeCategory.BUILDING_BLOCKS, SMOOTH_SOUL_SANDSTONE.block.asItem(), 0.1F, 200).criterion("has_soul_sandstone", conditionsFromItem(SOUL_SANDSTONE.block)).offerTo(exporter);
        offerPolishedStoneRecipe(exporter, CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block);
        offerStonecuttingRecipe(exporter, CUT_SOUL_SANDSTONE_SLAB, 2, SOUL_SANDSTONE.block, CUT_SOUL_SANDSTONE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_SOUL_SANDSTONE_SLAB, CUT_SOUL_SANDSTONE);

        offerBsswCuttingRecipe(exporter, ROUGH_SOUL_SANDSTONE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ROUGH_SOUL_SANDSTONE.block, 2).input('#', SOUL_SANDSTONE.slab).pattern("##").pattern("##").criterion("has_soul_sandstone", conditionsFromItem(SOUL_SANDSTONE.block)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block);
        offerBsswCuttingRecipe(exporter, SMALL_SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block, SOUL_SANDSTONE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_SOUL_SANDSTONE, SOUL_SANDSTONE.block);
        offerPolishedStoneRecipe(exporter, CHISELED_SOUL_SANDSTONE, CUT_SOUL_SANDSTONE);
        offerStonecuttingRecipe(exporter, SOUL_SANDSTONE_PILLAR, SOUL_SANDSTONE.block, SOUL_SANDSTONE_BRICKS.block);
        offerDecoratedRecipe(exporter, GOLD_DECORATED_SOUL_SANDSTONE, Items.GOLD_INGOT, CUT_SOUL_SANDSTONE);
        offerDecoratedRecipe(exporter, LAPIS_DECORATED_SOUL_SANDSTONE, Items.LAPIS_LAZULI, CUT_SOUL_SANDSTONE);

        // Honeycomb Bricks
        offerBsswCuttingRecipe(exporter, HONEYCOMB_BRICKS, Blocks.HONEYCOMB_BLOCK);
        offerPolishedStoneRecipe(exporter, HONEYCOMB_BRICKS.block, Blocks.HONEYCOMB_BLOCK);

        // Purpur Blocks
        offerBsswCuttingRecipe(exporter, POLISHED_PURPUR, Blocks.PURPUR_BLOCK);
        offerPolishedStoneRecipe(exporter, POLISHED_PURPUR.block, Blocks.PURPUR_BLOCK);
        offerBsswCuttingRecipe(exporter, PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block);
        offerBsswCuttingRecipe(exporter, SMALL_PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block, PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_PURPUR, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block, PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, Blocks.PURPUR_PILLAR, POLISHED_PURPUR.block, PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, PURPUR_SQUARES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block, PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, PURPUR_LINES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block, PURPUR_BRICKS.block);

        // Phantom Purpur Blocks
        offerBsswCuttingRecipe(exporter, PHANTOM_PURPUR_BLOCK);
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_BLOCK.block, Blocks.PURPUR_BLOCK);
        offerPolishedStoneRecipe(exporter, POLISHED_PHANTOM_PURPUR.block, PHANTOM_PURPUR_BLOCK.block);
        offerBsswCuttingRecipe(exporter, POLISHED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.block);
        offerPhantomPurpurRecipe(exporter, POLISHED_PHANTOM_PURPUR.block, POLISHED_PURPUR.block);
        offerBsswCuttingRecipe(exporter, PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block, POLISHED_PHANTOM_PURPUR.block);
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_BRICKS.block, PURPUR_BRICKS.block);
        offerPolishedStoneRecipe(exporter, PHANTOM_PURPUR_BRICKS.block, POLISHED_PHANTOM_PURPUR.block);
        offerBsswCuttingRecipe(exporter, SMALL_PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block, POLISHED_PHANTOM_PURPUR.block, PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, SMALL_PHANTOM_PURPUR_BRICKS.block, PHANTOM_PURPUR_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHISELED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.block, POLISHED_PHANTOM_PURPUR.block, PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, CHISELED_PHANTOM_PURPUR, CHISELED_PURPUR);
        offerStonecuttingRecipe(exporter, PHANTOM_PURPUR_PILLAR, PHANTOM_PURPUR_BLOCK.block, POLISHED_PHANTOM_PURPUR.block, PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_PILLAR, Blocks.PURPUR_PILLAR);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, PHANTOM_PURPUR_PILLAR).input('#', PHANTOM_PURPUR_BLOCK.slab).pattern("#").pattern("#").criterion("has_phantom_purpur_block", conditionsFromItem(PHANTOM_PURPUR_BLOCK.block)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, PHANTOM_PURPUR_SQUARES, PHANTOM_PURPUR_BLOCK.block, POLISHED_PHANTOM_PURPUR.block, PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_SQUARES, PURPUR_SQUARES);
        offerStonecuttingRecipe(exporter, PHANTOM_PURPUR_LINES, PHANTOM_PURPUR_BLOCK.block, POLISHED_PHANTOM_PURPUR.block, PHANTOM_PURPUR_BRICKS.block);
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_LINES, PURPUR_LINES);

        // End Stone
        offerBsswCuttingRecipe(exporter, POLISHED_END_STONE, Blocks.END_STONE);
        offerPolishedStoneRecipe(exporter, POLISHED_END_STONE.block, Blocks.END_STONE);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICKS, POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_STAIRS, POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_SLAB, 2, POLISHED_END_STONE.block);
        offerStonecuttingRecipe(exporter, Blocks.END_STONE_BRICK_WALL, POLISHED_END_STONE.block);
        offerCrackingRecipe(exporter, CRACKED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);
        offerBsswCuttingRecipe(exporter, SMALL_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, CHISELED_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, END_STONE_PILLAR, Blocks.END_STONE, POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, HERRINGBONE_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block, Blocks.END_STONE_BRICKS);
        offerDecoratedRecipe(exporter, PURPUR_DECORATED_END_STONE, Items.POPPED_CHORUS_FRUIT, Blocks.END_STONE_BRICKS);
        offerPhantomPurpurRecipe(exporter, PHANTOM_PURPUR_DECORATED_END_STONE, PURPUR_DECORATED_END_STONE);
        offerBsswCuttingRecipe(exporter, END_TILES);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, END_TILES.block, 4).input('#', Blocks.END_STONE).input('X', Blocks.PURPUR_BLOCK).pattern("#X").pattern("X#").criterion(hasItem(Blocks.PURPUR_BLOCK), conditionsFromItem(Blocks.PURPUR_BLOCK)).offerTo(exporter);
        offerPressurePlateButtonRecipe(exporter, POLISHED_END_STONE_PRESSURE_PLATE, POLISHED_END_STONE_BUTTON, POLISHED_END_STONE.block);

        // Wood
        offerHangingSignRecipe(exporter, WHITE_OAK.hanging_sign, STRIPPED_WHITE_OAK_LOG);
        offerBarkBlockRecipe(exporter, WHITE_OAK_WOOD, WHITE_OAK_LOG);
        offerPlanksRecipe(exporter, WHITE_OAK.planks, BlockusItemTags.WHITE_OAK_LOGS, 4);
        offerHangingSignRecipe(exporter, RAW_BAMBOO.hanging_sign, Blocks.BAMBOO_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, CHARRED.hanging_sign, 2).group("hanging_sign").input('#', CHARRED.planks).input('X', Items.CHAIN).pattern("X X").pattern("###").pattern("###").criterion("has_charred_planks", conditionsFromItem(CHARRED.planks)).offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RAW_BAMBOO.planks, 2).input(Blocks.BAMBOO_BLOCK).group("planks").criterion("has_log", conditionsFromItem(Blocks.BAMBOO_BLOCK)).offerTo(exporter);
        offerBoatsRecipe(exporter, BlockusEntities.WHITE_OAK_BOAT.getItem(), BlockusEntities.WHITE_OAK_BOAT.getChestItem(), WHITE_OAK.planks);
        offerBoatsRecipe(exporter, BlockusEntities.RAW_BAMBOO_RAFT.getItem(), BlockusEntities.RAW_BAMBOO_RAFT.getChestItem(), RAW_BAMBOO.planks);
        offerBoatsRecipe(exporter, BlockusEntities.CHARRED_BOAT.getItem(), BlockusEntities.CHARRED_BOAT.getChestItem(), CHARRED.planks);
        CookingRecipeJsonBuilder.createSmelting(Ingredient.fromTag(BlockusItemTags.PLANKS_THAT_BURN), RecipeCategory.BUILDING_BLOCKS, CHARRED.planks, 0.1F, 200).criterion("has_planks", conditionsFromTag(BlockusItemTags.PLANKS_THAT_BURN)).offerTo(exporter);

        offerSmallLogsRecipe(exporter, OAK_SMALL_LOGS, Blocks.OAK_LOG);
        offerSmallLogsRecipe(exporter, SPRUCE_SMALL_LOGS, Blocks.SPRUCE_LOG);
        offerSmallLogsRecipe(exporter, BIRCH_SMALL_LOGS, Blocks.BIRCH_LOG);
        offerSmallLogsRecipe(exporter, JUNGLE_SMALL_LOGS, Blocks.JUNGLE_LOG);
        offerSmallLogsRecipe(exporter, ACACIA_SMALL_LOGS, Blocks.ACACIA_LOG);
        offerSmallLogsRecipe(exporter, DARK_OAK_SMALL_LOGS, Blocks.DARK_OAK_LOG);
        offerSmallLogsRecipe(exporter, MANGROVE_SMALL_LOGS, Blocks.MANGROVE_LOG);
        offerSmallLogsRecipe(exporter, CHERRY_SMALL_LOGS, Blocks.CHERRY_LOG);
        offerSmallLogsRecipe(exporter, WARPED_SMALL_STEMS, Blocks.WARPED_STEM);
        offerSmallLogsRecipe(exporter, CRIMSON_SMALL_STEMS, Blocks.CRIMSON_STEM);
        offerSmallLogsRecipe(exporter, WHITE_OAK_SMALL_LOGS, WHITE_OAK_LOG);

        offerWoodenPostRecipe(exporter, OAK_POST, Blocks.OAK_PLANKS);
        offerWoodenPostRecipe(exporter, SPRUCE_POST, Blocks.SPRUCE_PLANKS);
        offerWoodenPostRecipe(exporter, BIRCH_POST, Blocks.BIRCH_PLANKS);
        offerWoodenPostRecipe(exporter, JUNGLE_POST, Blocks.JUNGLE_PLANKS);
        offerWoodenPostRecipe(exporter, ACACIA_POST, Blocks.ACACIA_PLANKS);
        offerWoodenPostRecipe(exporter, DARK_OAK_POST, Blocks.DARK_OAK_PLANKS);
        offerWoodenPostRecipe(exporter, MANGROVE_POST, Blocks.MANGROVE_PLANKS);
        offerWoodenPostRecipe(exporter, CHERRY_POST, Blocks.CHERRY_PLANKS);
        offerWoodenPostRecipe(exporter, WARPED_POST, Blocks.WARPED_PLANKS);
        offerWoodenPostRecipe(exporter, CRIMSON_POST, Blocks.CRIMSON_PLANKS);
        offerWoodenPostRecipe(exporter, WHITE_OAK_POST, WHITE_OAK.planks);

        for (BSSWBundle block : BSSWBundle.values()) {
            if (BlockChecker.isMossyPlanks(block.type, BlockChecker.WOODS)) {
                offerMossyRecipe(exporter, block.block, block.base);
            }
        }

        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, OAK_MOSAIC.block, Blocks.OAK_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, BIRCH_MOSAIC.block, Blocks.BIRCH_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, SPRUCE_MOSAIC.block, Blocks.SPRUCE_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, JUNGLE_MOSAIC.block, Blocks.JUNGLE_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, ACACIA_MOSAIC.block, Blocks.ACACIA_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, DARK_OAK_MOSAIC.block, Blocks.DARK_OAK_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, MANGROVE_MOSAIC.block, Blocks.MANGROVE_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, CHERRY_MOSAIC.block, Blocks.CHERRY_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, WHITE_OAK_MOSAIC.block, WHITE_OAK.slab);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, RAW_BAMBOO_MOSAIC.block, RAW_BAMBOO.slab);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, CRIMSON_MOSAIC.block, Blocks.CRIMSON_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, WARPED_MOSAIC.block, Blocks.WARPED_SLAB);
        offerMosaicRecipe(exporter, RecipeCategory.DECORATIONS, CHARRED_MOSAIC.block, CHARRED.slab);
        offerCharredSmeltingRecipe(exporter, BlockusItemTags.WOODEN_MOSAIC_THAT_BURN, CHARRED_MOSAIC.block, "mosaic");

        offerHerringBoneRecipe(exporter, HERRINGBONE_OAK_PLANKS, Blocks.OAK_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_BIRCH_PLANKS, Blocks.BIRCH_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_SPRUCE_PLANKS, Blocks.SPRUCE_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_JUNGLE_PLANKS, Blocks.JUNGLE_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_ACACIA_PLANKS, Blocks.ACACIA_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_DARK_OAK_PLANKS, Blocks.DARK_OAK_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_MANGROVE_PLANKS, Blocks.MANGROVE_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_CHERRY_PLANKS, Blocks.CHERRY_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_WHITE_OAK_PLANKS, WHITE_OAK.planks);
        offerHerringBoneRecipe(exporter, HERRINGBONE_BAMBOO_PLANKS, Blocks.BAMBOO_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_RAW_BAMBOO_PLANKS, RAW_BAMBOO.planks);
        offerHerringBoneRecipe(exporter, HERRINGBONE_CRIMSON_PLANKS, Blocks.CRIMSON_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_WARPED_PLANKS, Blocks.WARPED_PLANKS);
        offerHerringBoneRecipe(exporter, HERRINGBONE_CHARRED_PLANKS, CHARRED.planks);
        offerCharredSmeltingRecipe(exporter, BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN, HERRINGBONE_CHARRED_PLANKS, "herringbone_planks");

        // Small Hedges
        offerSmallHedgesRecipe(exporter, OAK_SMALL_HEDGE, Blocks.OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, SPRUCE_SMALL_HEDGE, Blocks.SPRUCE_LEAVES);
        offerSmallHedgesRecipe(exporter, BIRCH_SMALL_HEDGE, Blocks.BIRCH_LEAVES);
        offerSmallHedgesRecipe(exporter, JUNGLE_SMALL_HEDGE, Blocks.JUNGLE_LEAVES);
        offerSmallHedgesRecipe(exporter, ACACIA_SMALL_HEDGE, Blocks.ACACIA_LEAVES);
        offerSmallHedgesRecipe(exporter, DARK_OAK_SMALL_HEDGE, Blocks.DARK_OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, MANGROVE_SMALL_HEDGE, Blocks.MANGROVE_LEAVES);
        offerSmallHedgesRecipe(exporter, CHERRY_SMALL_HEDGE, Blocks.CHERRY_LEAVES);
        offerSmallHedgesRecipe(exporter, WARPED_SMALL_HEDGE, Blocks.WARPED_WART_BLOCK);
        offerSmallHedgesRecipe(exporter, CRIMSON_SMALL_HEDGE, Blocks.NETHER_WART_BLOCK);
        offerSmallHedgesRecipe(exporter, WHITE_OAK_SMALL_HEDGE, WHITE_OAK_LEAVES);
        offerSmallHedgesRecipe(exporter, AZALEA_SMALL_HEDGE, Blocks.AZALEA_LEAVES);
        offerSmallHedgesRecipe(exporter, FLOWERING_AZALEA_SMALL_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES);
        offerSmallHedgesRecipe(exporter, MOSS_SMALL_HEDGE, Blocks.MOSS_BLOCK);

        // Large Flower Pots
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LARGE_FLOWER_POT).input('#', Items.BRICK).pattern("# #").pattern("###").pattern("###").criterion("has_flower_pot", conditionsFromItem(Items.FLOWER_POT)).offerTo(exporter);

        // Chocolate
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CHOCOLATE_BLOCK.block, 2).input('#', Items.COCOA_BEANS).pattern("##").pattern("##").criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, CHOCOLATE_BLOCK);
        offerBsswCuttingRecipe(exporter, CHOCOLATE_BRICKS, CHOCOLATE_BLOCK.block);
        offerPolishedStoneRecipe(exporter, CHOCOLATE_BRICKS.block, CHOCOLATE_BLOCK.block);
        offerPolishedStoneRecipe(exporter, CHOCOLATE_SQUARES, CHOCOLATE_BRICKS.block);
        offerStonecuttingRecipe(exporter, CHOCOLATE_SQUARES, CHOCOLATE_BLOCK.block, CHOCOLATE_BRICKS.block);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, CHOCOLATE_TABLET, 3).input('#', CHOCOLATE_SQUARES).pattern("##").criterion(hasItem(CHOCOLATE_SQUARES), conditionsFromItem(CHOCOLATE_SQUARES)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, CHOCOLATE_TABLET, 2, CHOCOLATE_BLOCK.block, CHOCOLATE_BRICKS.block, CHOCOLATE_SQUARES);

        // Food Blocks
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.SWEET_BERRIES, RecipeCategory.BUILDING_BLOCKS, SWEET_BERRIES_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.GLOW_BERRIES, RecipeCategory.BUILDING_BLOCKS, GLOW_BERRIES_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.SALMON, RecipeCategory.BUILDING_BLOCKS, SALMON_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.PUFFERFISH, RecipeCategory.BUILDING_BLOCKS, PUFFERFISH_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.TROPICAL_FISH, RecipeCategory.BUILDING_BLOCKS, TROPICAL_FISH_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.COD, RecipeCategory.BUILDING_BLOCKS, COD_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.COOKIE, RecipeCategory.FOOD, COOKIE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.CHORUS_FRUIT, RecipeCategory.BUILDING_BLOCKS, CHORUS_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.POTATO, RecipeCategory.BUILDING_BLOCKS, POTATO_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.APPLE, RecipeCategory.BUILDING_BLOCKS, APPLE_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.GOLDEN_APPLE, RecipeCategory.BUILDING_BLOCKS, GOLDEN_APPLE_CRATE);
        createEnclosedRecipe2(GOLDEN_APPLE_CRATE, Ingredient.ofItems(Blocks.GOLD_BLOCK), APPLE_CRATE).criterion(hasItem(Items.GOLDEN_APPLE), conditionsFromItem(Items.GOLDEN_APPLE)).offerTo(exporter, convertBetween(GOLDEN_APPLE_CRATE, APPLE_CRATE));
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.BEETROOT, RecipeCategory.BUILDING_BLOCKS, BEETROOT_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.CARROT, RecipeCategory.BUILDING_BLOCKS, CARROT_CRATE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.GOLDEN_CARROT, RecipeCategory.BUILDING_BLOCKS, GOLDEN_CARROT_CRATE);
        createEnclosedRecipe2(GOLDEN_CARROT_CRATE, Ingredient.ofItems(Items.GOLD_INGOT), CARROT_CRATE).criterion(hasItem(Items.GOLDEN_CARROT), conditionsFromItem(Items.GOLDEN_CARROT)).offerTo(exporter, convertBetween(GOLDEN_CARROT_CRATE, CARROT_CRATE));
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.BREAD, RecipeCategory.BUILDING_BLOCKS, BREAD_BOX);

        // Rainbow
        offerShapelessRecipe(exporter, RAINBOW_PETALS, RAINBOW_ROSE, "rainbow_petal", 2);
        offerShapelessRecipe(exporter, RAINBOW_PETALS, RAINBOW_BLOCK, "rainbow_petal", 4);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RAINBOW_BLOCK).input('#', RAINBOW_PETALS).pattern("##").pattern("##").criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, RAINBOW_BRICKS, RAINBOW_BLOCK);
        offerPolishedStoneRecipe(exporter, RAINBOW_BRICKS.block, RAINBOW_BLOCK);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE).input(RAINBOW_PETALS).input(Blocks.GLOWSTONE).group("rainbow_glowstone").criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE, 1).input('G', Items.GLOWSTONE_DUST).group("rainbow_glowstone").input('R', RAINBOW_PETALS).pattern(" G ").pattern("GRG").pattern(" G ").criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter, getRecipeName(RAINBOW_GLOWSTONE) + "_alt");

        // Colored Stone Bricks
        offerStainedStoneBricksRecipe(exporter, Items.WHITE_DYE, WHITE_STONE_BRICKS.block, WHITE_STONE_BRICKS.stairs, WHITE_STONE_BRICKS.slab, WHITE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.ORANGE_DYE, ORANGE_STONE_BRICKS.block, ORANGE_STONE_BRICKS.stairs, ORANGE_STONE_BRICKS.slab, ORANGE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.MAGENTA_DYE, MAGENTA_STONE_BRICKS.block, MAGENTA_STONE_BRICKS.stairs, MAGENTA_STONE_BRICKS.slab, MAGENTA_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.LIGHT_BLUE_DYE, LIGHT_BLUE_STONE_BRICKS.block, LIGHT_BLUE_STONE_BRICKS.stairs, LIGHT_BLUE_STONE_BRICKS.slab, LIGHT_BLUE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.YELLOW_DYE, YELLOW_STONE_BRICKS.block, YELLOW_STONE_BRICKS.stairs, YELLOW_STONE_BRICKS.slab, YELLOW_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.LIME_DYE, LIME_STONE_BRICKS.block, LIME_STONE_BRICKS.stairs, LIME_STONE_BRICKS.slab, LIME_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.PINK_DYE, PINK_STONE_BRICKS.block, PINK_STONE_BRICKS.stairs, PINK_STONE_BRICKS.slab, PINK_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.GRAY_DYE, GRAY_STONE_BRICKS.block, GRAY_STONE_BRICKS.stairs, GRAY_STONE_BRICKS.slab, GRAY_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.CYAN_DYE, CYAN_STONE_BRICKS.block, CYAN_STONE_BRICKS.stairs, CYAN_STONE_BRICKS.slab, CYAN_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.PURPLE_DYE, PURPLE_STONE_BRICKS.block, PURPLE_STONE_BRICKS.stairs, PURPLE_STONE_BRICKS.slab, PURPLE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.BLUE_DYE, BLUE_STONE_BRICKS.block, BLUE_STONE_BRICKS.stairs, BLUE_STONE_BRICKS.slab, BLUE_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.BROWN_DYE, BROWN_STONE_BRICKS.block, BROWN_STONE_BRICKS.stairs, BROWN_STONE_BRICKS.slab, BROWN_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.GREEN_DYE, GREEN_STONE_BRICKS.block, GREEN_STONE_BRICKS.stairs, GREEN_STONE_BRICKS.slab, GREEN_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.RED_DYE, RED_STONE_BRICKS.block, RED_STONE_BRICKS.stairs, RED_STONE_BRICKS.slab, RED_STONE_BRICKS.wall);
        offerStainedStoneBricksRecipe(exporter, Items.BLACK_DYE, BLACK_STONE_BRICKS.block, BLACK_STONE_BRICKS.stairs, BLACK_STONE_BRICKS.slab, BLACK_STONE_BRICKS.wall);

        // Concrete

        // Redstone Lamps
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, REDSTONE_LAMP_LIT).input(Blocks.REDSTONE_LAMP).input(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter);
        offerStainedRedstoneLampRecipe(exporter, WHITE_REDSTONE_LAMP, Items.WHITE_DYE, WHITE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, ORANGE_REDSTONE_LAMP, Items.ORANGE_DYE, ORANGE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, MAGENTA_REDSTONE_LAMP, Items.MAGENTA_DYE, MAGENTA_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, LIGHT_BLUE_REDSTONE_LAMP, Items.LIGHT_BLUE_DYE, LIGHT_BLUE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, YELLOW_REDSTONE_LAMP, Items.YELLOW_DYE, YELLOW_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, LIME_REDSTONE_LAMP, Items.LIME_DYE, LIME_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, PINK_REDSTONE_LAMP, Items.PINK_DYE, PINK_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, LIGHT_GRAY_REDSTONE_LAMP, Items.LIGHT_GRAY_DYE, LIGHT_GRAY_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, GRAY_REDSTONE_LAMP, Items.GRAY_DYE, GRAY_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, CYAN_REDSTONE_LAMP, Items.CYAN_DYE, CYAN_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, PURPLE_REDSTONE_LAMP, Items.PURPLE_DYE, PURPLE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BLUE_REDSTONE_LAMP, Items.BLUE_DYE, BLUE_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, BROWN_REDSTONE_LAMP, Items.BROWN_DYE, BROWN_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, GREEN_REDSTONE_LAMP, Items.GREEN_DYE, GREEN_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, RED_REDSTONE_LAMP, Items.RED_DYE, RED_REDSTONE_LAMP_LIT);
        offerStainedRedstoneLampRecipe(exporter, RAINBOW_LAMP, RAINBOW_PETALS, RAINBOW_LAMP_LIT);

        // Neon Blocks
        offerNeonRecipe(exporter, WHITE_NEON, Items.WHITE_DYE);
        offerNeonRecipe(exporter, ORANGE_NEON, Items.ORANGE_DYE);
        offerNeonRecipe(exporter, MAGENTA_NEON, Items.MAGENTA_DYE);
        offerNeonRecipe(exporter, LIGHT_BLUE_NEON, Items.LIGHT_BLUE_DYE);
        offerNeonRecipe(exporter, YELLOW_NEON, Items.YELLOW_DYE);
        offerNeonRecipe(exporter, LIME_NEON, Items.LIME_DYE);
        offerNeonRecipe(exporter, PINK_NEON, Items.PINK_DYE);
        offerNeonRecipe(exporter, LIGHT_GRAY_NEON, Items.LIGHT_GRAY_DYE);
        offerNeonRecipe(exporter, GRAY_NEON, Items.GRAY_DYE);
        offerNeonRecipe(exporter, CYAN_NEON, Items.CYAN_DYE);
        offerNeonRecipe(exporter, PURPLE_NEON, Items.PURPLE_DYE);
        offerNeonRecipe(exporter, BLUE_NEON, Items.BLUE_DYE);
        offerNeonRecipe(exporter, BROWN_NEON, Items.BROWN_DYE);
        offerNeonRecipe(exporter, GREEN_NEON, Items.GREEN_DYE);
        offerNeonRecipe(exporter, RED_NEON, Items.RED_DYE);
        offerNeonRecipe(exporter, BLACK_NEON, Items.BLACK_DYE);

        // Futurneo Blocks
        offerFuturneoRecipe(exporter, WHITE_FUTURNEO_BLOCK, Blocks.WHITE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, ORANGE_FUTURNEO_BLOCK, Blocks.ORANGE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, MAGENTA_FUTURNEO_BLOCK, Blocks.MAGENTA_STAINED_GLASS);
        offerFuturneoRecipe(exporter, LIGHT_BLUE_FUTURNEO_BLOCK, Blocks.LIGHT_BLUE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, YELLOW_FUTURNEO_BLOCK, Blocks.YELLOW_STAINED_GLASS);
        offerFuturneoRecipe(exporter, LIME_FUTURNEO_BLOCK, Blocks.LIME_STAINED_GLASS);
        offerFuturneoRecipe(exporter, PINK_FUTURNEO_BLOCK, Blocks.PINK_STAINED_GLASS);
        offerFuturneoRecipe(exporter, LIGHT_GRAY_FUTURNEO_BLOCK, Blocks.LIGHT_GRAY_STAINED_GLASS);
        offerFuturneoRecipe(exporter, GRAY_FUTURNEO_BLOCK, Blocks.GRAY_STAINED_GLASS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, GRAY_BRIGHT_FUTURNEO_BLOCK).input('A', Items.WHITE_DYE).input('B', Blocks.GRAY_STAINED_GLASS).input('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").criterion(hasItem(Blocks.GRAY_STAINED_GLASS), conditionsFromItem(Blocks.GRAY_STAINED_GLASS)).offerTo(exporter);
        offerFuturneoRecipe(exporter, CYAN_FUTURNEO_BLOCK, Blocks.CYAN_STAINED_GLASS);
        offerFuturneoRecipe(exporter, PURPLE_FUTURNEO_BLOCK, Blocks.PURPLE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BLUE_FUTURNEO_BLOCK, Blocks.BLUE_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BROWN_FUTURNEO_BLOCK, Blocks.BROWN_STAINED_GLASS);
        offerFuturneoRecipe(exporter, GREEN_FUTURNEO_BLOCK, Blocks.GREEN_STAINED_GLASS);
        offerFuturneoRecipe(exporter, RED_FUTURNEO_BLOCK, Blocks.RED_STAINED_GLASS);
        offerFuturneoRecipe(exporter, BLACK_FUTURNEO_BLOCK, Blocks.BLACK_STAINED_GLASS);
        offerFuturneoRecipe(exporter, RAINBOW_FUTURNEO_BLOCK, RAINBOW_GLASS);

        // Asphalt
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ASPHALT.block, 8).input('X', Blocks.GRAVEL).input('#', ItemTags.COALS).pattern("XXX").pattern("X#X").pattern("XXX").group("asphalt").criterion(hasItem(Blocks.GRAVEL), conditionsFromItem(Blocks.GRAVEL)).offerTo(exporter);
        createEnclosedRecipe(RAINBOW_ASPHALT, Ingredient.ofItems(ASPHALT.block), RAINBOW_PETALS).criterion(hasItem(ASPHALT.block), conditionsFromItem(ASPHALT.block)).offerTo(exporter);
        offerAsphaltRecipe(exporter, Items.WHITE_DYE, WHITE_ASPHALT.block, WHITE_ASPHALT.stairs, WHITE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.ORANGE_DYE, ORANGE_ASPHALT.block, ORANGE_ASPHALT.stairs, ORANGE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.MAGENTA_DYE, MAGENTA_ASPHALT.block, MAGENTA_ASPHALT.stairs, MAGENTA_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.LIGHT_BLUE_DYE, LIGHT_BLUE_ASPHALT.block, LIGHT_BLUE_ASPHALT.stairs, LIGHT_BLUE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.YELLOW_DYE, YELLOW_ASPHALT.block, YELLOW_ASPHALT.stairs, YELLOW_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.LIME_DYE, LIME_ASPHALT.block, LIME_ASPHALT.stairs, LIME_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.PINK_DYE, PINK_ASPHALT.block, PINK_ASPHALT.stairs, PINK_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.LIGHT_GRAY_DYE, LIGHT_GRAY_ASPHALT.block, LIGHT_GRAY_ASPHALT.stairs, LIGHT_GRAY_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.GRAY_DYE, GRAY_ASPHALT.block, GRAY_ASPHALT.stairs, GRAY_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.CYAN_DYE, CYAN_ASPHALT.block, CYAN_ASPHALT.stairs, CYAN_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.PURPLE_DYE, PURPLE_ASPHALT.block, PURPLE_ASPHALT.stairs, PURPLE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.BLUE_DYE, BLUE_ASPHALT.block, BLUE_ASPHALT.stairs, BLUE_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.BROWN_DYE, BROWN_ASPHALT.block, BROWN_ASPHALT.stairs, BROWN_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.GREEN_DYE, GREEN_ASPHALT.block, GREEN_ASPHALT.stairs, GREEN_ASPHALT.slab);
        offerAsphaltRecipe(exporter, Items.RED_DYE, RED_ASPHALT.block, RED_ASPHALT.stairs, RED_ASPHALT.slab);

        // Shingles
        offerBsswCuttingRecipe(exporter, SHINGLES, Blocks.TERRACOTTA);
        offerPolishedStoneRecipe(exporter, SHINGLES.block, Blocks.TERRACOTTA);
        offerShinglesRecipe(exporter, Items.WHITE_DYE, WHITE_SHINGLES.block, WHITE_SHINGLES.stairs, WHITE_SHINGLES.slab, Blocks.WHITE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.ORANGE_DYE, ORANGE_SHINGLES.block, ORANGE_SHINGLES.stairs, ORANGE_SHINGLES.slab, Blocks.ORANGE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.MAGENTA_DYE, MAGENTA_SHINGLES.block, MAGENTA_SHINGLES.stairs, MAGENTA_SHINGLES.slab, Blocks.MAGENTA_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIGHT_BLUE_DYE, LIGHT_BLUE_SHINGLES.block, LIGHT_BLUE_SHINGLES.stairs, LIGHT_BLUE_SHINGLES.slab, Blocks.LIGHT_BLUE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.YELLOW_DYE, YELLOW_SHINGLES.block, YELLOW_SHINGLES.stairs, YELLOW_SHINGLES.slab, Blocks.YELLOW_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIME_DYE, LIME_SHINGLES.block, LIME_SHINGLES.stairs, LIME_SHINGLES.slab, Blocks.LIME_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.PINK_DYE, PINK_SHINGLES.block, PINK_SHINGLES.stairs, PINK_SHINGLES.slab, Blocks.PINK_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.LIGHT_GRAY_DYE, LIGHT_GRAY_SHINGLES.block, LIGHT_GRAY_SHINGLES.stairs, LIGHT_GRAY_SHINGLES.slab, Blocks.LIGHT_GRAY_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.GRAY_DYE, GRAY_SHINGLES.block, GRAY_SHINGLES.stairs, GRAY_SHINGLES.slab, Blocks.GRAY_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.CYAN_DYE, CYAN_SHINGLES.block, CYAN_SHINGLES.stairs, CYAN_SHINGLES.slab, Blocks.CYAN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.PURPLE_DYE, PURPLE_SHINGLES.block, PURPLE_SHINGLES.stairs, PURPLE_SHINGLES.slab, Blocks.PURPLE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BLUE_DYE, BLUE_SHINGLES.block, BLUE_SHINGLES.stairs, BLUE_SHINGLES.slab, Blocks.BLUE_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BROWN_DYE, BROWN_SHINGLES.block, BROWN_SHINGLES.stairs, BROWN_SHINGLES.slab, Blocks.BROWN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.GREEN_DYE, GREEN_SHINGLES.block, GREEN_SHINGLES.stairs, GREEN_SHINGLES.slab, Blocks.GREEN_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.RED_DYE, RED_SHINGLES.block, RED_SHINGLES.stairs, RED_SHINGLES.slab, Blocks.RED_TERRACOTTA);
        offerShinglesRecipe(exporter, Items.BLACK_DYE, BLACK_SHINGLES.block, BLACK_SHINGLES.stairs, BLACK_SHINGLES.slab, Blocks.BLACK_TERRACOTTA);

        // Glass - Beveled Glass
        offerPolishedStoneRecipe(exporter, TINTED_BEVELED_GLASS, Blocks.TINTED_GLASS);
        offerPolishedStoneRecipe(exporter, BEVELED_GLASS, Blocks.GLASS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BEVELED_GLASS_PANE, 16).input('#', BEVELED_GLASS).pattern("###").pattern("###").group("beveled_glass_pane").criterion("has_beveled_glass", conditionsFromItem(BEVELED_GLASS_PANE)).offerTo(exporter);
        offerStainedBeveledGlassRecipe(exporter, WHITE_BEVELED_GLASS, WHITE_BEVELED_GLASS_PANE, Blocks.WHITE_STAINED_GLASS, Items.WHITE_DYE);
        offerStainedBeveledGlassRecipe(exporter, ORANGE_BEVELED_GLASS, ORANGE_BEVELED_GLASS_PANE, Blocks.ORANGE_STAINED_GLASS, Items.ORANGE_DYE);
        offerStainedBeveledGlassRecipe(exporter, MAGENTA_BEVELED_GLASS, MAGENTA_BEVELED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS, Items.MAGENTA_DYE);
        offerStainedBeveledGlassRecipe(exporter, LIGHT_BLUE_BEVELED_GLASS, LIGHT_BLUE_BEVELED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS, Items.LIGHT_BLUE_DYE);
        offerStainedBeveledGlassRecipe(exporter, YELLOW_BEVELED_GLASS, YELLOW_BEVELED_GLASS_PANE, Blocks.YELLOW_STAINED_GLASS, Items.YELLOW_DYE);
        offerStainedBeveledGlassRecipe(exporter, LIME_BEVELED_GLASS, LIME_BEVELED_GLASS_PANE, Blocks.LIME_STAINED_GLASS, Items.LIME_DYE);
        offerStainedBeveledGlassRecipe(exporter, PINK_BEVELED_GLASS, PINK_BEVELED_GLASS_PANE, Blocks.PINK_STAINED_GLASS, Items.PINK_DYE);
        offerStainedBeveledGlassRecipe(exporter, LIGHT_GRAY_BEVELED_GLASS, LIGHT_GRAY_BEVELED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS, Items.LIGHT_GRAY_DYE);
        offerStainedBeveledGlassRecipe(exporter, GRAY_BEVELED_GLASS, GRAY_BEVELED_GLASS_PANE, Blocks.GRAY_STAINED_GLASS, Items.GRAY_DYE);
        offerStainedBeveledGlassRecipe(exporter, CYAN_BEVELED_GLASS, CYAN_BEVELED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS, Items.CYAN_DYE);
        offerStainedBeveledGlassRecipe(exporter, PURPLE_BEVELED_GLASS, PURPLE_BEVELED_GLASS_PANE, Blocks.PURPLE_STAINED_GLASS, Items.PURPLE_DYE);
        offerStainedBeveledGlassRecipe(exporter, BLUE_BEVELED_GLASS, BLUE_BEVELED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS, Items.BLUE_DYE);
        offerStainedBeveledGlassRecipe(exporter, BROWN_BEVELED_GLASS, BROWN_BEVELED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS, Items.BROWN_DYE);
        offerStainedBeveledGlassRecipe(exporter, GREEN_BEVELED_GLASS, GREEN_BEVELED_GLASS_PANE, Blocks.GREEN_STAINED_GLASS, Items.GREEN_DYE);
        offerStainedBeveledGlassRecipe(exporter, RED_BEVELED_GLASS, RED_BEVELED_GLASS_PANE, Blocks.RED_STAINED_GLASS, Items.RED_DYE);
        offerStainedBeveledGlassRecipe(exporter, BLACK_BEVELED_GLASS, BLACK_BEVELED_GLASS_PANE, Blocks.BLACK_STAINED_GLASS, Items.BLACK_DYE);
        offerStainedBeveledGlassRecipe(exporter, RAINBOW_BEVELED_GLASS, RAINBOW_BEVELED_GLASS_PANE, RAINBOW_GLASS, RAINBOW_PETALS);
        createEnclosedRecipe(RAINBOW_GLASS, Ingredient.ofItems(Blocks.GLASS), RAINBOW_PETALS).criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter);
        createEnclosedRecipe(RAINBOW_GLASS_PANE, Ingredient.ofItems(Blocks.GLASS_PANE), RAINBOW_PETALS).criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter, getRecipeName(RAINBOW_GLASS_PANE) + "_alt");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLASS_PANE, 16).input('#', RAINBOW_GLASS).pattern("###").pattern("###").criterion(hasItem(RAINBOW_GLASS), conditionsFromItem(RAINBOW_GLASS)).offerTo(exporter);

        // Colored Tiles
        offerUnicolorColoredTilesRecipe(exporter, WHITE_COLORED_TILES, Blocks.WHITE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, ORANGE_COLORED_TILES, Blocks.ORANGE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, MAGENTA_COLORED_TILES, Blocks.MAGENTA_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, LIGHT_BLUE_COLORED_TILES, Blocks.LIGHT_BLUE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, YELLOW_COLORED_TILES, Blocks.YELLOW_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, LIME_COLORED_TILES, Blocks.LIME_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, PINK_COLORED_TILES, Blocks.PINK_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, LIGHT_GRAY_COLORED_TILES, Blocks.LIGHT_GRAY_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, GRAY_COLORED_TILES, Blocks.GRAY_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, CYAN_COLORED_TILES, Blocks.CYAN_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, PURPLE_COLORED_TILES, Blocks.PURPLE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BLUE_COLORED_TILES, Blocks.BLUE_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BROWN_COLORED_TILES, Blocks.BROWN_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, GREEN_COLORED_TILES, Blocks.GREEN_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, RED_COLORED_TILES, Blocks.RED_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, BLACK_COLORED_TILES, Blocks.BLACK_CONCRETE);
        offerUnicolorColoredTilesRecipe(exporter, RAINBOW_COLORED_TILES, RAINBOW_BLOCK);

        // Glazed Terracotta Pillars
        offerPillarRecipe(exporter, WHITE_GLAZED_TERRACOTTA_PILLAR, Blocks.WHITE_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, ORANGE_GLAZED_TERRACOTTA_PILLAR, Blocks.ORANGE_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, MAGENTA_GLAZED_TERRACOTTA_PILLAR, Blocks.MAGENTA_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, YELLOW_GLAZED_TERRACOTTA_PILLAR, Blocks.YELLOW_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, LIME_GLAZED_TERRACOTTA_PILLAR, Blocks.LIME_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, PINK_GLAZED_TERRACOTTA_PILLAR, Blocks.PINK_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, GRAY_GLAZED_TERRACOTTA_PILLAR, Blocks.GRAY_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, CYAN_GLAZED_TERRACOTTA_PILLAR, Blocks.CYAN_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, PURPLE_GLAZED_TERRACOTTA_PILLAR, Blocks.PURPLE_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, BLUE_GLAZED_TERRACOTTA_PILLAR, Blocks.BLUE_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, BROWN_GLAZED_TERRACOTTA_PILLAR, Blocks.BROWN_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, GREEN_GLAZED_TERRACOTTA_PILLAR, Blocks.GREEN_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, RED_GLAZED_TERRACOTTA_PILLAR, Blocks.RED_GLAZED_TERRACOTTA);
        offerPillarRecipe(exporter, BLACK_GLAZED_TERRACOTTA_PILLAR, Blocks.BLACK_GLAZED_TERRACOTTA);

        // Thatch
        offerPolishedStoneRecipe(exporter, THATCH.block, Items.WHEAT);

        // Paper
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, PAPER_BLOCK);
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(PAPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, BURNT_PAPER_BLOCK.asItem(), 0.1F, 200).criterion("has_paper_block", conditionsFromItem(PAPER_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, FRAMED_PAPER_BLOCK, 4).input('X', Items.PAPER).input('#', Items.STICK).pattern("###").pattern("XXX").pattern("###").criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER)).offerTo(exporter);
        offerPolishedStoneRecipe(exporter, PAPER_WALL, FRAMED_PAPER_BLOCK);
        createEnclosedRecipe2(PAPER_LAMP, Ingredient.ofItems(Items.PAPER), Items.TORCH).criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER)).offerTo(exporter);
        offerShapelessRecipe2(exporter, Items.GUNPOWDER, BURNT_PAPER_BLOCK, 2);
        offerDoorTrapdoorRecipe(exporter, PAPER_DOOR, PAPER_TRAPDOOR, PAPER_WALL);

        // Plating
        offerBsswCuttingRecipe(exporter, IRON_PLATING);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, IRON_PLATING.block, 24).input('X', Items.IRON_INGOT).pattern("XXX").pattern("X X").pattern("XXX").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
        offerBsswCuttingRecipe(exporter, GOLD_PLATING);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, GOLD_PLATING.block, 24).input('X', Items.GOLD_INGOT).pattern("XXX").pattern("X X").pattern("XXX").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);

        // Gates - chains - bars
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, IRON_GATE, 3).input('X', Blocks.IRON_BARS).input('#', Items.IRON_NUGGET).pattern("##").pattern("XX").pattern("XX").criterion(hasItem(Blocks.IRON_BARS), conditionsFromItem(Blocks.IRON_BARS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, GOLDEN_GATE, 3).input('X', GOLDEN_BARS).input('#', Items.GOLD_NUGGET).pattern("##").pattern("XX").pattern("XX").criterion(hasItem(GOLDEN_BARS), conditionsFromItem(GOLDEN_BARS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, GOLDEN_BARS, 16).input('#', Items.GOLD_INGOT).pattern("###").pattern("###").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, GOLDEN_CHAIN).input('X', Items.GOLD_INGOT).input('#', Items.GOLD_NUGGET).pattern("#").pattern("X").pattern("#").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);

        // Lantern Blocks

        offerLanternBlockRecipe(exporter, LANTERN_BLOCK, Blocks.LANTERN);
        offerLanternBlockRecipe(exporter, SOUL_LANTERN_BLOCK, Blocks.SOUL_LANTERN);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AMETHYST_LANTERN).input('#', Items.TORCH).input('A', Items.AMETHYST_SHARD).input('X', Items.IRON_NUGGET).pattern("XXX").pattern("XAX").pattern("X#X").criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD)).offerTo(exporter);
        offerLanternBlockRecipe(exporter, AMETHYST_LANTERN_BLOCK, AMETHYST_LANTERN);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, REDSTONE_LANTERN).input('#', Items.REDSTONE_TORCH).input('X', Items.IRON_NUGGET).pattern("XXX").pattern("X#X").pattern("XXX").criterion(hasItem(Items.REDSTONE_TORCH), conditionsFromItem(Items.REDSTONE_TORCH)).offerTo(exporter);
        offerLanternBlockRecipe(exporter, REDSTONE_LANTERN_BLOCK, REDSTONE_LANTERN);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, SOUL_O_LANTERN).input('X', Blocks.CARVED_PUMPKIN).input('#', Blocks.SOUL_TORCH).pattern("X").pattern("#").criterion(hasItem(Blocks.CARVED_PUMPKIN), conditionsFromItem(Blocks.CARVED_PUMPKIN)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, REDSTONE_O_LANTERN).input('X', Blocks.CARVED_PUMPKIN).input('#', Blocks.REDSTONE_TORCH).pattern("X").pattern("#").criterion(hasItem(Blocks.CARVED_PUMPKIN), conditionsFromItem(Blocks.CARVED_PUMPKIN)).criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH)).offerTo(exporter);

        // Barriers
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ROAD_BARRIER, 5).input('#', Items.IRON_INGOT).input('X', Blocks.STONE).pattern("X#X").pattern("X#X").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CAUTION_BARRIER).input(CAUTION_BLOCK).input(ROAD_BARRIER).criterion(hasItem(CAUTION_BLOCK), conditionsFromItem(CAUTION_BLOCK)).criterion(hasItem(ROAD_BARRIER), conditionsFromItem(ROAD_BARRIER)).offerTo(exporter);

        // Netherite Blocks
        BlockusRecipeProvider.offerStairsRecipe(exporter, NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
        RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHERITE_SLAB, Blocks.NETHERITE_BLOCK);
        offerStonecuttingRecipe(exporter, NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
        offerStonecuttingRecipe(exporter, NETHERITE_SLAB, 2, Blocks.NETHERITE_BLOCK);

        // Other
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, CHARCOAL_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, SUGAR_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, ENDER_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, ROTTEN_FLESH_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.BUILDING_BLOCKS, MEMBRANE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.NETHER_STAR, RecipeCategory.BUILDING_BLOCKS, NETHER_STAR_BLOCK);
        offerPolishedStoneRecipe(exporter, WOODEN_FRAME, Items.STICK);
        createEnclosedRecipe2(REDSTONE_SAND, Ingredient.ofItems(Items.REDSTONE), Items.SAND).criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.REDSTONE, 8).input(REDSTONE_SAND).criterion(hasItem(REDSTONE_SAND), conditionsFromItem(REDSTONE_SAND)).offerTo(exporter, convertBetween(Items.REDSTONE, REDSTONE_SAND));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LOVE_BLOCK).input('M', Items.MAGENTA_DYE).input('R', Items.RED_DYE).pattern("RMR").pattern("RRR").pattern("MRM").criterion(hasItem(Items.MAGENTA_DYE), conditionsFromItem(Items.MAGENTA_DYE)).criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WEIGHT_STORAGE_CUBE).input(Blocks.STONE).input(Items.IRON_NUGGET).criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COMPANION_CUBE).input(WEIGHT_STORAGE_CUBE).input(Items.POPPY).criterion(hasItem(WEIGHT_STORAGE_CUBE), conditionsFromItem(WEIGHT_STORAGE_CUBE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CAUTION_BLOCK, 6).input('A', Blocks.STONE).input('B', Items.BLACK_DYE).input('C', Items.YELLOW_DYE).pattern(" C ").pattern("BAB").pattern(" C ").criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE)).criterion(hasItem(Items.YELLOW_DYE), conditionsFromItem(Items.YELLOW_DYE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, STARS_BLOCK, 3).input('#', Items.ENDER_PEARL).input('X', Items.CHORUS_FRUIT).pattern("X#X").pattern("###").pattern("X#X").criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT)).offerTo(exporter);

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
        offerShapelessRecipe(exporter, Items.IRON_INGOT, LEGACY_IRON_BLOCK, "iron_ingot", 9);
        offerShapelessRecipe(exporter, Items.GOLD_INGOT, LEGACY_GOLD_BLOCK, "gold_ingot", 9);
        offerShapelessRecipe(exporter, Items.GOLD_INGOT, LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, "gold_ingot", 9);
        offerShapelessRecipe(exporter, Items.COAL, LEGACY_COAL_BLOCK, "coal", 9);
        offerShapelessRecipe(exporter, Items.DIAMOND, LEGACY_DIAMOND_BLOCK, "diamond", 9);
        offerShapelessRecipe(exporter, Items.LAPIS_LAZULI, LEGACY_LAPIS_BLOCK, "lapis_lazuli", 9);
        offerShapelessRecipe(exporter, Items.RED_DYE, LEGACY_ROSE, "red_dye", 2);
        offerShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, LEGACY_BLUE_ROSE, "light_blue_dye", 2);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LEGACY_STONECUTTER).input('#', Blocks.COBBLESTONE).input('S', Blocks.STONECUTTER).pattern(" # ").pattern("#S#").pattern(" # ").criterion(hasItem(Blocks.STONECUTTER), conditionsFromItem(Blocks.STONECUTTER)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LEGACY_NETHER_REACTOR_CORE).input('#', Items.DIAMOND).input('X', Items.IRON_INGOT).pattern("X#X").pattern("X#X").pattern("X#X").criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LEGACY_SAPLING, 4).input('#', Blocks.OAK_SAPLING).pattern("##").pattern("##").criterion(hasItem(Blocks.OAK_SAPLING), conditionsFromItem(Blocks.OAK_SAPLING)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LEGACY_ROSE, 2).input('#', Blocks.POPPY).pattern("##").pattern("##").criterion(hasItem(Blocks.POPPY), conditionsFromItem(Blocks.POPPY)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LEGACY_BLUE_ROSE, 2).input('#', LEGACY_ROSE).pattern("##").criterion(hasItem(LEGACY_ROSE), conditionsFromItem(LEGACY_ROSE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LEGACY_FIRST_GRASS_BLOCK, 4).input('#', LEGACY_GRASS_BLOCK).pattern("##").pattern("##").criterion(hasItem(LEGACY_GRASS_BLOCK), conditionsFromItem(LEGACY_GRASS_BLOCK)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LEGACY_PLANKS, 4).input(LEGACY_LOG).group("planks").criterion("has_logs", conditionsFromItem(LEGACY_LOG)).offerTo(exporter);
    }

    private void offerLanternBlockRecipe(Consumer<RecipeJsonProvider> exporter, Block output, Block lantern) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output).input('X', lantern).input('#', Items.IRON_NUGGET).pattern(" # ").pattern("#X#").pattern(" # ").criterion(hasItem(lantern), conditionsFromItem(lantern)).offerTo(exporter);
    }

    public static void offerWaxingRecipes(Consumer<RecipeJsonProvider> exporter, Block unwaxed, Block waxed) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, waxed).input(unwaxed).input(Items.HONEYCOMB).group(getItemPath(waxed)).criterion(hasItem(unwaxed), conditionsFromItem(unwaxed)).offerTo(exporter, convertBetween(waxed, Items.HONEYCOMB));
    }

    public static void offerCharredSmeltingRecipe(Consumer<RecipeJsonProvider> exporter, TagKey<Item> input, ItemConvertible output, String hasitem) {
        CookingRecipeJsonBuilder.createSmelting(Ingredient.fromTag(input), RecipeCategory.BUILDING_BLOCKS, output, 0.1F, 200).criterion("has_" + hasitem, conditionsFromTag(input)).offerTo(exporter, getRecipeName(output) + "_from_smelting");
    }

    public static void offerMossyRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output).input(input).input(Blocks.VINE).group(Registries.BLOCK.getId((Block) output).getPath()).criterion("has_vine", conditionsFromItem(Blocks.VINE)).offerTo(exporter, convertBetween(output, Blocks.VINE));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output).input(input).input(Blocks.MOSS_BLOCK).group(Registries.BLOCK.getId((Block) output).getPath()).criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK)).offerTo(exporter, convertBetween(output, Blocks.MOSS_BLOCK));
    }

    public static void offerPolishedStoneRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static CraftingRecipeJsonBuilder createCondensingRecipe(RecipeCategory category, ItemConvertible output, int count, Ingredient input, String group) {
        return ShapedRecipeJsonBuilder.create(category, output, count).input('S', input).group(group).pattern("SS").pattern("SS");
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', input).pattern(" # ").pattern("###").group("small_logs").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerWoodenPostRecipe(Consumer<RecipeJsonProvider> exporter, WoodenPostBundle post, ItemConvertible planks) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, post.block, 6).input('#', post.base).pattern("#").pattern("#").pattern("#").group("wooden_posts").criterion("has_woods", conditionsFromItem(post.base)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, post.stripped, 6).input('#', post.baseStripped).pattern("#").pattern("#").pattern("#").group("wooden_posts").criterion("has_woods", conditionsFromItem(post.baseStripped)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, planks, 2).input(post.block).group("planks").criterion("has_wooden_post", conditionsFromItem(post.block)).offerTo(exporter, convertBetween(planks, post.block));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, planks, 2).input(post.stripped).group("planks").criterion("has_wooden_post", conditionsFromItem(post.stripped)).offerTo(exporter, convertBetween(planks, post.stripped));
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

    public static void offerOreBricksRecipe(Consumer<RecipeJsonProvider> exporter, BSSWBundle ore_bricks, ItemConvertible ore_block, ItemConvertible ore) {
        offerStonecuttingRecipe(exporter, ore_bricks.block, ore_block);
        offerStonecuttingRecipe(exporter, ore_bricks.stairs, ore_bricks.block, ore_block);
        offerStonecuttingRecipe(exporter, ore_bricks.slab, 2, ore_bricks.block, ore_block);
        offerStonecuttingRecipe(exporter, ore_bricks.wall, ore_bricks.block, ore_block);
        offerPolishedStoneRecipe(exporter, ore_bricks.block, ore_block);
        offerShapelessRecipe(exporter, ore, ore_bricks.block, ore.toString(), 9);
        offerShapelessRecipe(exporter, ore, ore_bricks.stairs, ore.toString(), 9);
        offerShapelessRecipe(exporter, ore, ore_bricks.slab, ore.toString(), 4);
        offerShapelessRecipe(exporter, ore, ore_bricks.wall, ore.toString(), 9);
    }

    public static void offerCopperBricksRecipe(Consumer<RecipeJsonProvider> exporter, CopperBundle block, ItemConvertible baseWaxed, ItemConvertible cutCopper, ItemConvertible cutCopperWaxed) {
        offerStonecuttingRecipe(exporter, block.block, cutCopper);
        offerStonecuttingRecipe(exporter, block.stairs, block.block, cutCopper);
        offerStonecuttingRecipe(exporter, block.slab, 2, block.block, cutCopper);
        offerStonecuttingRecipe(exporter, block.wall, block.block, cutCopper);
        offerStonecuttingRecipe(exporter, block.blockWaxed, cutCopperWaxed);
        offerStonecuttingRecipe(exporter, block.stairsWaxed, block.blockWaxed, cutCopperWaxed);
        offerStonecuttingRecipe(exporter, block.slabWaxed, 2, block.blockWaxed, cutCopperWaxed);
        offerStonecuttingRecipe(exporter, block.wallWaxed, block.blockWaxed, cutCopperWaxed);
        offerStonecuttingRecipe(exporter, block.block, 4, block.base);
        offerStonecuttingRecipe(exporter, block.stairs, 4, block.base);
        offerStonecuttingRecipe(exporter, block.slab, 8, block.base);
        offerStonecuttingRecipe(exporter, block.wall, 4, block.base);
        offerStonecuttingRecipe(exporter, block.blockWaxed, 4, baseWaxed);
        offerStonecuttingRecipe(exporter, block.stairsWaxed, 4, baseWaxed);
        offerStonecuttingRecipe(exporter, block.slabWaxed, 8, baseWaxed);
        offerStonecuttingRecipe(exporter, block.wallWaxed, 4, baseWaxed);
        offerPolishedStoneRecipe(exporter, block.block, cutCopper);
        offerPolishedStoneRecipe(exporter, block.blockWaxed, cutCopperWaxed);
    }

    public static void createTimberFramesRecipes(Consumer<RecipeJsonProvider> exporter, ItemConvertible base, ItemConvertible block, ItemConvertible diagonal, ItemConvertible cross) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, block, 2).input('#', Items.PAPER).input('X', base).pattern("#X").pattern("X#").group("timber_frame").criterion(hasItem(base), conditionsFromItem(base)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, diagonal, 4).input('#', block).pattern("##").pattern("##").group("diagonal_timber_frame").criterion(hasItem(block), conditionsFromItem(block)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, cross, 4).input('#', diagonal).pattern("##").pattern("##").group("cross_timber_frame").criterion(hasItem(diagonal), conditionsFromItem(diagonal)).offerTo(exporter);
    }

    public static void createLatticeRecipes(Consumer<RecipeJsonProvider> exporter, ItemConvertible base, ItemConvertible lattice, ItemConvertible grate) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, grate, 3).input('#', Items.STICK).input('X', base).pattern(" # ").pattern("#X#").pattern(" # ").group("wooden_grates").criterion(hasItem(base), conditionsFromItem(base)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, lattice, 16).input('#', grate).pattern("###").pattern("###").group("wooden_lattices").criterion(hasItem(lattice), conditionsFromItem(lattice)).offerTo(exporter);
    }

    public static void offerAsphaltRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab) {
        createEnclosedRecipe(output, Ingredient.ofItems(ASPHALT.block), center).group("asphalt").criterion(hasItem(ASPHALT.block), conditionsFromItem(ASPHALT.block)).offerTo(exporter);
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(ASPHALT.stairs), center).group("asphalt_stairs").criterion(hasItem(ASPHALT.block), conditionsFromItem(ASPHALT.block)).offerTo(exporter, convertBetween(output_stairs, ASPHALT.stairs));
        createEnclosedRecipe(output_slab, Ingredient.ofItems(ASPHALT.slab), center).group("asphalt_slab").criterion(hasItem(ASPHALT.block), conditionsFromItem(ASPHALT.block)).offerTo(exporter, convertBetween(output_slab, ASPHALT.slab));
    }

    public static void offerPatternedWoolRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible wool, ItemConvertible output_carpet, ItemConvertible carpet) {
        offerPolishedStoneRecipe(exporter, output, wool);
        createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, output_carpet, Ingredient.ofItems(carpet)).group("patterned_carpet").criterion(hasItem(carpet), conditionsFromItem(carpet)).offerTo(exporter, convertBetween(output_carpet, carpet));
    }

    public static void offerGinghamWoolRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible wool) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', wool).pattern(" # ").pattern("# #").pattern(" # ").group("gingham_wool").criterion(hasItem(wool), conditionsFromItem(wool)).offerTo(exporter);
    }

    public static void offerShinglesRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab, ItemConvertible terracotta) {
        createEnclosedRecipe(output, Ingredient.ofItems(SHINGLES.block), center).group("shingles").criterion(hasItem(SHINGLES.block), conditionsFromItem(SHINGLES.block)).offerTo(exporter, convertBetween(output_stairs, SHINGLES.block));
        createEnclosedRecipe(output_stairs, Ingredient.ofItems(SHINGLES.stairs), center).group("shingles_stairs").criterion(hasItem(SHINGLES.block), conditionsFromItem(SHINGLES.block)).offerTo(exporter, convertBetween(output_stairs, SHINGLES.stairs));
        createEnclosedRecipe(output_slab, Ingredient.ofItems(SHINGLES.slab), center).group("shingles_slab").criterion(hasItem(SHINGLES.block), conditionsFromItem(SHINGLES.block)).offerTo(exporter, convertBetween(output_slab, SHINGLES.slab));
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
        createEnclosedRecipe(output, Ingredient.ofItems(BEVELED_GLASS), dye).group("beveled_glass_2").criterion(hasItem(BEVELED_GLASS), conditionsFromItem(BEVELED_GLASS)).offerTo(exporter, convertBetween(output, BEVELED_GLASS));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output_pane, 16).input('#', output).pattern("###").pattern("###").group("beveled_glass_pane").criterion(hasItem(BEVELED_GLASS_PANE), conditionsFromItem(output)).offerTo(exporter);
        createEnclosedRecipe(output_pane, Ingredient.ofItems(BEVELED_GLASS_PANE), dye).group("beveled_glass_pane_2").criterion(hasItem(BEVELED_GLASS_PANE), conditionsFromItem(BEVELED_GLASS_PANE)).offerTo(exporter, convertBetween(output, BEVELED_GLASS_PANE));
    }

    public static void offerStainedRedstoneLampRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible dye, ItemConvertible output_lit) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output).input('S', dye).input('#', Blocks.REDSTONE_LAMP).pattern(" S ").pattern("S#S").pattern(" S ").group("redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output_lit).input(output).input(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").criterion(hasItem(output), conditionsFromItem(output)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output_lit).input('S', dye).input('#', REDSTONE_LAMP_LIT).pattern(" S ").pattern("S#S").pattern(" S ").group("lit_redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter, getRecipeName(output) + "_alt");
    }

    public static void offerNeonRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible dye) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 8).input('D', dye).input('S', Items.GLOW_INK_SAC).input('A', Items.AMETHYST_SHARD).pattern(" A ").pattern("SDS").pattern(" A ").group("neon_blocks").criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC)).offerTo(exporter);
    }

    public static void offerFuturneoRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible glass) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6).input('A', Items.BLACK_DYE).input('B', glass).input('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").criterion(hasItem(glass), conditionsFromItem(glass)).offerTo(exporter);

    }

    public static void offerBoatsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output1, ItemConvertible output2, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output1).input('#', input).pattern("# #").pattern("###").group("boat").criterion("in_water", requireEnteringFluid(Blocks.WATER)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output2).input(Blocks.CHEST).input(output1).group("chest_boat").criterion("has_boat", conditionsFromTag(ItemTags.BOATS)).offerTo(exporter);

    }

    public static void offerPillarRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 2).input('#', input).pattern("#").pattern("#").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
        offerStonecuttingRecipe(exporter, output, 1, input);
    }

    public static void offerBsswCuttingRecipe(Consumer<RecipeJsonProvider> exporter, BSSWBundle bsswBundle, ItemConvertible... ingredients) {
        // For block, stairs, slab and wall (if exists) in BsswBundle.
        if (ingredients != null) {
            offerStonecuttingRecipe(exporter, bsswBundle.block, ingredients);
            offerStonecuttingRecipe(exporter, bsswBundle.stairs, ingredients);
            offerStonecuttingRecipe(exporter, bsswBundle.slab, 2, ingredients);
            if (bsswBundle.wall != null) {
                offerStonecuttingRecipe(exporter, bsswBundle.wall, ingredients);
            }
        }
        offerStonecuttingRecipe(exporter, bsswBundle.stairs, bsswBundle.block);
        offerStonecuttingRecipe(exporter, bsswBundle.slab, 2, bsswBundle.block);
        if (bsswBundle.wall != null) {
            offerStonecuttingRecipe(exporter, bsswBundle.wall, bsswBundle.block);
        }
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
        BlockusFamilies.getFamilies().filter((family) -> {
            return family.shouldGenerateRecipes(enabledFeatures);
        }).forEach((family) -> {
            generateFamily(exporter, family);
        });
    }
}
