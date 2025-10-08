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
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.recipe.*;
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
import net.minecraft.util.DyeColor;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;


public class BlockusRecipeProvider extends FabricRecipeProvider {
    public BlockusRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final Map<DyeColor, ItemConvertible> DYE_MAP = ImmutableMap.<DyeColor, ItemConvertible>builder()
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
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {

                for (BSSWBundle BSSWBundle : BSSWBundle.values()) {
                    offerStairsRecipe(BSSWBundle.stairs(), BSSWBundle.block());
                    offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, BSSWBundle.slab(), BSSWBundle.block());
                    if (BSSWBundle.wall() != null) {
                        offerWallRecipe(RecipeCategory.DECORATIONS, BSSWBundle.wall(), BSSWBundle.block());
                    }
                }

                for (ConcreteBundle concreteType : ConcreteBundle.values()) {
                    for (Map.Entry<DyeColor, ConcreteBundle.ConcreteVariants> entry : concreteType.colorMap().entrySet()) {
                        ConcreteBundle.ConcreteVariants variants = entry.getValue();
                        Block base = BlockMaps.CONCRETE_MAP.get(entry.getKey());
                        offerStonecuttingRecipe(variants.block(), base);
                        offerStonecuttingRecipe(variants.stairs(), base, variants.block());
                        offerStonecuttingRecipe(variants.slab(), 2, base, variants.block());
                        offerStonecuttingRecipe(variants.wall(), base, variants.block());
                        offerStonecuttingRecipe(variants.chiseled(), base, variants.block());
                        offerStonecuttingRecipe(variants.pillar(), base, variants.block());
                        offerPolishedStoneRecipe(variants.block(), base);
                    }
                }

                for (AsphaltBundle.AsphaltVariants asphaltBundle : ASPHALT.colorMap().values()) {
                    offerStairsRecipe(asphaltBundle.stairs(), asphaltBundle.block());
                    offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, asphaltBundle.slab(), asphaltBundle.block());
                    offerStonecuttingRecipe(asphaltBundle.stairs(), asphaltBundle.block());
                    offerStonecuttingRecipe(asphaltBundle.slab(), 2, asphaltBundle.block());
                }

                for (WoolBundle woolBundle : WoolBundle.values()) {
                    for (Map.Entry<DyeColor, WoolBundle.WoolVariants> entry : woolBundle.colorMap().entrySet()) {
                        WoolBundle.WoolVariants variants = entry.getValue();
                        if (woolBundle == PATTERNED_WOOL) {
                            offerPatternedWoolRecipe(variants.block(), BlockMaps.WOOL_MAP.get(entry.getKey()), variants.carpet(), BlockMaps.CARPET_MAP.get(entry.getKey()));
                        } else if (woolBundle == GINGHAM_WOOL) {
                            offerGinghamWoolRecipe(variants.block(), BlockMaps.WOOL_MAP.get(entry.getKey()));
                        }

                        offerStairsRecipe(variants.stairs(), variants.block());
                        offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, variants.slab(), variants.block());
                        offerCarpetRecipe(variants.carpet(), variants.block());
                    }
                }

                for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
                    offerColoredTilesRecipe(coloredTilesVariants.block(), coloredTilesVariants.tile1(), coloredTilesVariants.tile2());
                }

                generateFamilies(FeatureSet.of(FeatureFlags.VANILLA));

                offerPillarRecipe(MUD_BRICK_PILLAR, Blocks.MUD_BRICKS);
                offerStonecuttingRecipe(CHISELED_MUD_BRICKS, Blocks.MUD_BRICKS);

                // Stone
                offerBsswCuttingRecipe(STONE_TILES, Blocks.STONE, Blocks.STONE_BRICKS);
                offerPolishedStoneRecipe(STONE_TILES.block(), Blocks.STONE_BRICKS);
                offerStonecuttingRecipe(STONE_BRICK_PILLAR, Blocks.STONE, Blocks.STONE_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_STONE_BRICKS, Blocks.STONE, Blocks.STONE_BRICKS);
                offerStonecuttingRecipe(STONE_CIRCULAR_PAVING, Blocks.STONE, Blocks.STONE_BRICKS);
                offerStonecuttingRecipe(SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
                offerStairsRecipe(SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
                offerSturdyRecipe(STURDY_STONE, Blocks.STONE, Blocks.COBBLESTONE);
                offerStoneDoorTrapdoorRecipe(STONE_DOOR, STONE_TRAPDOOR, Blocks.STONE, Blocks.STONE_SLAB);

                // Andesite
                offerBsswCuttingRecipe(ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
                offerPolishedStoneRecipe(ANDESITE_BRICKS.block(), Blocks.POLISHED_ANDESITE);
                offerCrackingRecipe(CRACKED_ANDESITE_BRICKS, ANDESITE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_ANDESITE_PILLAR, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
                offerStonecuttingRecipe(ANDESITE_CIRCULAR_PAVING, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_ANDESITE_PRESSURE_PLATE, POLISHED_ANDESITE_BUTTON, Blocks.POLISHED_ANDESITE);

                // Diorite
                offerBsswCuttingRecipe(DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
                offerPolishedStoneRecipe(DIORITE_BRICKS.block(), Blocks.POLISHED_DIORITE);
                offerCrackingRecipe(CRACKED_DIORITE_BRICKS, DIORITE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_DIORITE_PILLAR, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
                offerStonecuttingRecipe(DIORITE_CIRCULAR_PAVING, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_DIORITE_PRESSURE_PLATE, POLISHED_DIORITE_BUTTON, Blocks.POLISHED_DIORITE);

                // Granite
                offerBsswCuttingRecipe(GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE);
                offerPolishedStoneRecipe(GRANITE_BRICKS.block(), Blocks.POLISHED_GRANITE);
                offerCrackingRecipe(CRACKED_GRANITE_BRICKS, GRANITE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_GRANITE_PILLAR, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
                offerStonecuttingRecipe(GRANITE_CIRCULAR_PAVING, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_GRANITE_PRESSURE_PLATE, POLISHED_GRANITE_BUTTON, Blocks.POLISHED_GRANITE);

                // Dripstone
                offerBsswCuttingRecipe(POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
                offerPolishedStoneRecipe(POLISHED_DRIPSTONE.block(), Blocks.DRIPSTONE_BLOCK);
                offerBsswCuttingRecipe(DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block());
                offerPolishedStoneRecipe(DRIPSTONE_BRICKS.block(), POLISHED_DRIPSTONE.block());
                offerMossyRecipe(MOSSY_DRIPSTONE_BRICKS.block(), DRIPSTONE_BRICKS.block());
                offerBsswCuttingRecipe(MOSSY_DRIPSTONE_BRICKS);
                offerCrackingRecipe(CRACKED_DRIPSTONE_BRICKS, DRIPSTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block(), DRIPSTONE_BRICKS.block());
                offerStonecuttingRecipe(DRIPSTONE_PILLAR, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block(), DRIPSTONE_BRICKS.block());

                // Tuff
                offerBsswCuttingRecipe(TUFF_TILES, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerPolishedStoneRecipe(TUFF_TILES.block(), Blocks.TUFF_BRICKS);
                offerCrackingRecipe(CRACKED_TUFF_BRICKS, Blocks.TUFF_BRICKS);
                offerMossyRecipe(MOSSY_TUFF_BRICKS.block(), Blocks.TUFF_BRICKS);
                offerBsswCuttingRecipe(MOSSY_TUFF_BRICKS);
                offerStonecuttingRecipe(CARVED_TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerStonecuttingRecipe(TUFF_PILLAR, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerStonecuttingRecipe(TUFF_CIRCULAR_PAVING, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerPressurePlateButtonRecipe(POLISHED_TUFF_PRESSURE_PLATE, POLISHED_TUFF_BUTTON, Blocks.POLISHED_TUFF);

                // Amethyst
                offerBsswCuttingRecipe(POLISHED_AMETHYST, Blocks.AMETHYST_BLOCK);
                offerPolishedStoneRecipe(POLISHED_AMETHYST.block(), Blocks.AMETHYST_BLOCK);
                offerBsswCuttingRecipe(AMETHYST_BRICKS, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block());
                offerPolishedStoneRecipe(AMETHYST_BRICKS.block(), POLISHED_AMETHYST.block());
                offerStonecuttingRecipe(CHISELED_AMETHYST, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block(), AMETHYST_BRICKS.block());
                offerStonecuttingRecipe(AMETHYST_PILLAR, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block(), AMETHYST_BRICKS.block());
                createShaped(RecipeCategory.BUILDING_BLOCKS, AMETHYST_LAMP).input('#', Items.AMETHYST_SHARD).input('X', Items.REDSTONE).pattern(" # ").pattern("#X#").pattern(" # ").criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD)).offerTo(exporter);

                // Deepslate
                offerMossyRecipe(MOSSY_DEEPSLATE_BRICKS.block(), Blocks.DEEPSLATE_BRICKS);
                offerBsswCuttingRecipe(MOSSY_DEEPSLATE_BRICKS);
                offerStonecuttingRecipe(DEEPSLATE_PILLAR, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
                offerStonecuttingRecipe(DEEPSLATE_CIRCULAR_PAVING, Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
                offerSturdyRecipe(STURDY_DEEPSLATE, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
                offerPressurePlateButtonRecipe(POLISHED_DEEPSLATE_PRESSURE_PLATE, POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);

                // Sculk
                offerBsswCuttingRecipe(POLISHED_SCULK, Blocks.SCULK);
                offerPolishedStoneRecipe(POLISHED_SCULK.block(), Blocks.SCULK);
                offerBsswCuttingRecipe(SCULK_BRICKS, Blocks.SCULK, POLISHED_SCULK.block());
                offerStonecuttingRecipe(CHISELED_SCULK_BRICKS, Blocks.SCULK, POLISHED_SCULK.block(), SCULK_BRICKS.block());
                offerStonecuttingRecipe(SCULK_PILLAR, Blocks.SCULK, POLISHED_SCULK.block(), SCULK_BRICKS.block());
                offerPolishedStoneRecipe(SCULK_BRICKS.block(), POLISHED_SCULK.block());
                offerPressurePlateButtonRecipe(POLISHED_SCULK_PRESSURE_PLATE, POLISHED_SCULK_BUTTON, POLISHED_SCULK.block());

                // Blackstone
                offerBsswCuttingRecipe(POLISHED_BLACKSTONE_TILES, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
                offerPolishedStoneRecipe(POLISHED_BLACKSTONE_TILES.block(), Blocks.POLISHED_BLACKSTONE_BRICKS);
                offerStonecuttingRecipe(POLISHED_BLACKSTONE_PILLAR, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
                offerStonecuttingRecipe(POLISHED_BLACKSTONE_CIRCULAR_PAVING, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, CRIMSON_WARTY_BLACKSTONE_BRICKS.block()).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(Blocks.CRIMSON_ROOTS).criterion("has_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS)).offerTo(exporter);
                offerBsswCuttingRecipe(CRIMSON_WARTY_BLACKSTONE_BRICKS);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, WARPED_WARTY_BLACKSTONE_BRICKS.block()).input(Blocks.POLISHED_BLACKSTONE_BRICKS).input(BlockusItemTags.WARPED_NETHER_GRASS).criterion("has_roots", conditionsFromTag(BlockusItemTags.WARPED_NETHER_GRASS)).offerTo(exporter);
                offerBsswCuttingRecipe(WARPED_WARTY_BLACKSTONE_BRICKS);
                offerSturdyRecipe(STURDY_BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
                offerDecoratedRecipe(GOLD_DECORATED_POLISHED_BLACKSTONE, Items.GOLD_INGOT, Blocks.POLISHED_BLACKSTONE);
                offerStoneDoorTrapdoorRecipe(BLACKSTONE_DOOR, BLACKSTONE_TRAPDOOR, Blocks.BLACKSTONE, Blocks.BLACKSTONE_SLAB);

                // Basalt
                offerBsswCuttingRecipe(ROUGH_BASALT);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_BASALT.block(), 2).input('#', Blocks.BASALT).pattern("#").pattern("#").criterion("has_basalt", conditionsFromItem(Blocks.BASALT)).offerTo(exporter);
                offerBsswCuttingRecipe(POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT);
                offerPolishedStoneRecipe(POLISHED_BASALT_BRICKS.block(), Blocks.POLISHED_BASALT);
                offerCrackingRecipe(CRACKED_POLISHED_BASALT_BRICKS, POLISHED_BASALT_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_POLISHED_BASALT, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_BASALT_PILLAR, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_BASALT_CIRCULAR_PAVING, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_BASALT_PRESSURE_PLATE, POLISHED_BASALT_BUTTON, Blocks.POLISHED_BASALT);

                // Wart Blocks
                offerBsswCuttingRecipe(CRIMSON_WART_BRICKS, Blocks.NETHER_WART_BLOCK);
                offerPolishedStoneRecipe(CRIMSON_WART_BRICKS.block(), Blocks.NETHER_WART_BLOCK);
                offerBsswCuttingRecipe(WARPED_WART_BRICKS, Blocks.WARPED_WART_BLOCK);
                offerPolishedStoneRecipe(WARPED_WART_BRICKS.block(), Blocks.WARPED_WART_BLOCK);

                // Limestone
                offerBsswCuttingRecipe(LIMESTONE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, LIMESTONE.block()).input('#', Blocks.COBBLESTONE).input('X', Items.BONE_MEAL).pattern("#X").pattern("X#").criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE)).offerTo(exporter);
                offerBsswCuttingRecipe(POLISHED_LIMESTONE, LIMESTONE.block());
                offerPolishedStoneRecipe(POLISHED_LIMESTONE.block(), LIMESTONE.block());
                offerBsswCuttingRecipe(LIMESTONE_BRICKS, LIMESTONE.block(), POLISHED_LIMESTONE.block());
                offerPolishedStoneRecipe(LIMESTONE_BRICKS.block(), POLISHED_LIMESTONE.block());
                offerBsswCuttingRecipe(SMALL_LIMESTONE_BRICKS, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
                offerBsswCuttingRecipe(LIMESTONE_TILES, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
                offerPolishedStoneRecipe(LIMESTONE_TILES.block(), LIMESTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_LIMESTONE, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_LIMESTONE_BRICKS, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_LIMESTONE_PILLAR, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block(), LIMESTONE_PILLAR);
                offerStonecuttingRecipe(LIMESTONE_PILLAR, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
                offerStonecuttingRecipe(LIMESTONE_SQUARES, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
                offerStonecuttingRecipe(LIMESTONE_CIRCULAR_PAVING, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
                offerStonecuttingRecipe(LIMESTONE_LINES, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
                offerPressurePlateButtonRecipe(LIMESTONE_PRESSURE_PLATE, LIMESTONE_BUTTON, LIMESTONE.block());

                // Marble
                offerBsswCuttingRecipe(MARBLE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, MARBLE.block()).input('#', LIMESTONE.block()).input('X', Items.BONE_MEAL).pattern("#X").pattern("X#").group("marble").criterion(hasItem(LIMESTONE.block()), conditionsFromItem(LIMESTONE.block())).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, MARBLE.block()).input(Blocks.CALCITE).input(LIMESTONE.block()).group("marble").criterion(hasItem(Blocks.CALCITE), conditionsFromItem(Blocks.CALCITE)).offerTo(exporter, convertBetween(MARBLE.block(), Blocks.CALCITE));
                offerBsswCuttingRecipe(POLISHED_MARBLE, MARBLE.block());
                offerPolishedStoneRecipe(POLISHED_MARBLE.block(), MARBLE.block());
                offerBsswCuttingRecipe(MARBLE_BRICKS, MARBLE.block(), POLISHED_MARBLE.block());
                offerPolishedStoneRecipe(MARBLE_BRICKS.block(), POLISHED_MARBLE.block());
                offerBsswCuttingRecipe(SMALL_MARBLE_BRICKS, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
                offerBsswCuttingRecipe(MARBLE_TILES, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
                offerPolishedStoneRecipe(MARBLE_TILES.block(), MARBLE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_MARBLE, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_MARBLE_BRICKS, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_MARBLE_PILLAR, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block(), MARBLE_PILLAR);
                offerStonecuttingRecipe(MARBLE_PILLAR, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
                offerStonecuttingRecipe(MARBLE_SQUARES, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
                offerStonecuttingRecipe(MARBLE_CIRCULAR_PAVING, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
                offerStonecuttingRecipe(MARBLE_LINES, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
                offerPressurePlateButtonRecipe(MARBLE_PRESSURE_PLATE, MARBLE_BUTTON, MARBLE.block());

                // Bluestone
                offerBsswCuttingRecipe(BLUESTONE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, BLUESTONE.block(), 4).input('S', Blocks.STONE).input('#', Items.BLUE_DYE).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE)).criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE)).offerTo(exporter);
                offerBsswCuttingRecipe(POLISHED_BLUESTONE, BLUESTONE.block());
                offerPolishedStoneRecipe(POLISHED_BLUESTONE.block(), BLUESTONE.block());
                offerBsswCuttingRecipe(BLUESTONE_BRICKS, BLUESTONE.block(), POLISHED_BLUESTONE.block());
                offerPolishedStoneRecipe(BLUESTONE_BRICKS.block(), POLISHED_BLUESTONE.block());
                offerBsswCuttingRecipe(SMALL_BLUESTONE_BRICKS, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
                offerBsswCuttingRecipe(BLUESTONE_TILES, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
                offerPolishedStoneRecipe(BLUESTONE_TILES.block(), BLUESTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_BLUESTONE, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_BLUESTONE_BRICKS, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_BLUESTONE_PILLAR, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block(), BLUESTONE_PILLAR);
                offerStonecuttingRecipe(BLUESTONE_PILLAR, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
                offerStonecuttingRecipe(BLUESTONE_SQUARES, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
                offerStonecuttingRecipe(BLUESTONE_CIRCULAR_PAVING, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
                offerStonecuttingRecipe(BLUESTONE_LINES, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
                offerPressurePlateButtonRecipe(BLUESTONE_PRESSURE_PLATE, BLUESTONE_BUTTON, BLUESTONE.block());

                // Viridite
                offerBsswCuttingRecipe(VIRIDITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block(), 4).input('S', Blocks.DEEPSLATE).input('#', Blocks.SCULK).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Blocks.SCULK), conditionsFromItem(Blocks.SCULK)).criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block(), 4).input('S', Blocks.DEEPSLATE).input('#', Items.GREEN_DYE).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Items.GREEN_DYE), conditionsFromItem(Items.GREEN_DYE)).criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE)).offerTo(exporter, convertBetween(VIRIDITE.block(), Items.GREEN_DYE));
                offerBsswCuttingRecipe(POLISHED_VIRIDITE, VIRIDITE.block());
                offerPolishedStoneRecipe(POLISHED_VIRIDITE.block(), VIRIDITE.block());
                offerBsswCuttingRecipe(VIRIDITE_BRICKS, VIRIDITE.block(), POLISHED_VIRIDITE.block());
                offerPolishedStoneRecipe(VIRIDITE_BRICKS.block(), POLISHED_VIRIDITE.block());
                offerBsswCuttingRecipe(SMALL_VIRIDITE_BRICKS, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
                offerBsswCuttingRecipe(VIRIDITE_TILES, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
                offerPolishedStoneRecipe(VIRIDITE_TILES.block(), VIRIDITE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_VIRIDITE, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_VIRIDITE_BRICKS, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_VIRIDITE_PILLAR, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block(), VIRIDITE_PILLAR);
                offerStonecuttingRecipe(VIRIDITE_PILLAR, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
                offerStonecuttingRecipe(VIRIDITE_SQUARES, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
                offerStonecuttingRecipe(VIRIDITE_CIRCULAR_PAVING, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
                offerStonecuttingRecipe(VIRIDITE_LINES, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
                offerPressurePlateButtonRecipe(VIRIDITE_PRESSURE_PLATE, VIRIDITE_BUTTON, VIRIDITE.block());

                // Lava	Bricks
                offerBsswCuttingRecipe(LAVA_BRICKS);
                offerStonecuttingRecipe(CHISELED_LAVA_BRICKS, LAVA_BRICKS.block());
                createEnclosedRecipe(LAVA_BRICKS.block(), Ingredient.ofItems(Blocks.STONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

                // Lava Blackstone Bricks
                offerBsswCuttingRecipe(LAVA_POLISHED_BLACKSTONE_BRICKS);
                offerStonecuttingRecipe(CHISELED_LAVA_POLISHED_BLACKSTONE, LAVA_POLISHED_BLACKSTONE_BRICKS.block());
                createEnclosedRecipe(LAVA_POLISHED_BLACKSTONE_BRICKS.block(), Ingredient.ofItems(Blocks.POLISHED_BLACKSTONE_BRICKS), Items.LAVA_BUCKET).criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET)).criterion(hasItem(Blocks.POLISHED_BLACKSTONE_BRICKS), conditionsFromItem(Blocks.POLISHED_BLACKSTONE_BRICKS)).offerTo(exporter);

                // Water Bricks
                offerBsswCuttingRecipe(WATER_BRICKS);
                offerStonecuttingRecipe(CHISELED_WATER_BRICKS, WATER_BRICKS.block());
                createEnclosedRecipe(WATER_BRICKS.block(), Ingredient.ofItems(Blocks.STONE_BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);

                // Snow Bricks
                offerBsswCuttingRecipe(SNOW_BRICKS);
                offerStonecuttingRecipe(SNOW_PILLAR, SNOW_BRICKS.block());
                offerPolishedStoneRecipe(SNOW_BRICKS.block(), Blocks.SNOW_BLOCK);

                // Ice Bricks
                offerStonecuttingRecipe(ICE_BRICK_WALL, ICE_BRICKS);
                offerStonecuttingRecipe(ICE_PILLAR, ICE_BRICKS);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ICE_BRICKS, 4).input('#', BlockusItemTags.NATURAL_ICE).pattern("##").pattern("##").criterion("has_ice", conditionsFromTag(BlockusItemTags.NATURAL_ICE)).offerTo(exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ICE_BRICK_WALL, ICE_BRICKS);

                // Magma Bricks
                offerBsswCuttingRecipe(MAGMA_BRICKS, Blocks.MAGMA_BLOCK);
                offerPolishedStoneRecipe(MAGMA_BRICKS.block(), Blocks.MAGMA_BLOCK);
                offerBsswCuttingRecipe(SMALL_MAGMA_BRICKS, Blocks.MAGMA_BLOCK, MAGMA_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_MAGMA_BRICKS, Blocks.MAGMA_BLOCK, MAGMA_BRICKS.block());

                // Blaze Bricks
                offerBsswCuttingRecipe(BLAZE_BRICKS);
                offerStonecuttingRecipe(BLAZE_PILLAR, BLAZE_BRICKS.block());
                createShaped(RecipeCategory.BUILDING_BLOCKS, BLAZE_BRICKS.block()).input('#', Items.BLAZE_POWDER).input('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").criterion("has_blaze_rod", conditionsFromItem(Items.BLAZE_ROD)).offerTo(exporter);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.BLAZE_POWDER, RecipeCategory.BUILDING_BLOCKS, BLAZE_LANTERN);

                // Netherrack
                offerBsswCuttingRecipe(POLISHED_NETHERRACK, Blocks.NETHERRACK);
                offerPolishedStoneRecipe(POLISHED_NETHERRACK.block(), Blocks.NETHERRACK);
                offerBsswCuttingRecipe(NETHERRACK_BRICKS, Blocks.NETHERRACK, POLISHED_NETHERRACK.block());
                offerStonecuttingRecipe(NETHERRACK_CIRCULAR_PAVING, Blocks.NETHERRACK, POLISHED_NETHERRACK.block(), NETHERRACK_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_NETHERRACK_PRESSURE_PLATE, POLISHED_NETHERRACK_BUTTON, POLISHED_NETHERRACK.block());

                // Nether Bricks
                offerBsswCuttingRecipe(POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
                offerPolishedStoneRecipe(POLISHED_NETHER_BRICKS.block(), Blocks.NETHER_BRICKS);
                offerStonecuttingRecipe(NETHER_BRICK_PILLAR, Blocks.NETHER_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_NETHER_BRICKS, Blocks.NETHER_BRICKS);

                offerBsswCuttingRecipe(POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
                offerPolishedStoneRecipe(POLISHED_RED_NETHER_BRICKS.block(), Blocks.RED_NETHER_BRICKS);
                offerStonecuttingRecipe(RED_NETHER_BRICK_PILLAR, Blocks.RED_NETHER_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);

                offerBsswCuttingRecipe(NETHER_TILES);
                createShaped(RecipeCategory.BUILDING_BLOCKS, NETHER_TILES.block(), 4).input('#', Blocks.NETHERRACK).input('X', Blocks.NETHER_BRICKS).pattern("#X").pattern("X#").criterion(hasItem(Blocks.NETHER_BRICKS), conditionsFromItem(Blocks.NETHER_BRICKS)).offerTo(exporter);

                // Charred Nether Bricks
                offerBsswCuttingRecipe(CHARRED_NETHER_BRICKS);
                offerBsswCuttingRecipe(POLISHED_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block());
                offerPolishedStoneRecipe(POLISHED_CHARRED_NETHER_BRICKS.block(), CHARRED_NETHER_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block());
                offerStonecuttingRecipe(CHARRED_NETHER_BRICK_PILLAR, CHARRED_NETHER_BRICKS.block());
                createEnclosedRecipe(CHARRED_NETHER_BRICKS.block(), Ingredient.ofItems(Blocks.NETHER_BRICKS), Items.FIRE_CHARGE).criterion(hasItem(Items.FIRE_CHARGE), conditionsFromItem(Items.FIRE_CHARGE)).criterion(hasItem(Blocks.NETHER_BRICKS), conditionsFromItem(Blocks.NETHER_BRICKS)).offerTo(exporter);

                // Teal Nether Bricks
                offerBsswCuttingRecipe(TEAL_NETHER_BRICKS);
                offerBsswCuttingRecipe(POLISHED_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block());
                offerPolishedStoneRecipe(POLISHED_TEAL_NETHER_BRICKS.block(), TEAL_NETHER_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block());
                offerStonecuttingRecipe(TEAL_NETHER_BRICK_PILLAR, TEAL_NETHER_BRICKS.block());
                createShaped(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block()).input('#', BlockusItemTags.WARPED_NETHER_GRASS).input('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").group("teal_nether_bricks").criterion("has_warped_grass", conditionsFromTag(BlockusItemTags.WARPED_NETHER_GRASS)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block(), 2).input(Blocks.WARPED_WART_BLOCK).input(Items.NETHER_BRICKS).group("teal_nether_bricks").criterion(hasItem(Blocks.WARPED_WART_BLOCK), conditionsFromItem(Blocks.WARPED_WART_BLOCK)).offerTo(exporter, convertBetween(TEAL_NETHER_BRICKS.block(), Blocks.WARPED_WART_BLOCK));

                // Obsidian
                offerBsswCuttingRecipe(OBSIDIAN_BRICKS, Blocks.OBSIDIAN);
                offerPolishedStoneRecipe(OBSIDIAN_BRICKS.block(), Blocks.OBSIDIAN);
                offerCrackingRecipe(CRACKED_OBSIDIAN_BRICKS, OBSIDIAN_BRICKS.block());
                offerBsswCuttingRecipe(SMALL_OBSIDIAN_BRICKS, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block());
                offerStonecuttingRecipe(OBSIDIAN_PILLAR, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block());
                offerStonecuttingRecipe(OBSIDIAN_CIRCULAR_PAVING, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block());
                offerDoorTrapdoorRecipe(OBSIDIAN_REINFORCED_DOOR, OBSIDIAN_REINFORCED_TRAPDOOR, Blocks.OBSIDIAN);
                offerPressurePlateRecipe(OBSIDIAN_PRESSURE_PLATE, Blocks.OBSIDIAN);
                createShaped(RecipeCategory.BUILDING_BLOCKS, GLOWING_OBSIDIAN, 4).input('S', Blocks.OBSIDIAN).input('#', Blocks.SHROOMLIGHT).pattern(" S ").pattern("S#S").pattern(" S ").criterion(hasItem(Blocks.SHROOMLIGHT), conditionsFromItem(Blocks.SHROOMLIGHT)).offerTo(exporter);

                // Ore Bricks
                offerOreBricksRecipe(IRON_BRICKS, Blocks.IRON_BLOCK, Items.IRON_INGOT);
                offerOreBricksRecipe(GOLD_BRICKS, Blocks.GOLD_BLOCK, Items.GOLD_INGOT);
                offerOreBricksRecipe(LAPIS_BRICKS, Blocks.LAPIS_BLOCK, Items.LAPIS_LAZULI);
                offerOreBricksRecipe(REDSTONE_BRICKS, Blocks.REDSTONE_BLOCK, Items.REDSTONE);
                offerOreBricksRecipe(EMERALD_BRICKS, Blocks.EMERALD_BLOCK, Items.EMERALD);
                offerOreBricksRecipe(DIAMOND_BRICKS, Blocks.DIAMOND_BLOCK, Items.DIAMOND);
                offerOreBricksRecipe(NETHERITE_BRICKS, Blocks.NETHERITE_BLOCK, Items.NETHERITE_INGOT);

                // Copper
                offerCopperBricksRecipe(COPPER_BRICKS, Blocks.WAXED_COPPER_BLOCK, Blocks.CUT_COPPER, Blocks.WAXED_CUT_COPPER);
                offerCopperBricksRecipe(EXPOSED_COPPER_BRICKS, Blocks.WAXED_EXPOSED_COPPER, Blocks.EXPOSED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER);
                offerCopperBricksRecipe(WEATHERED_COPPER_BRICKS, Blocks.WAXED_WEATHERED_COPPER, Blocks.WEATHERED_CUT_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER);
                offerCopperBricksRecipe(OXIDIZED_COPPER_BRICKS, Blocks.WAXED_OXIDIZED_COPPER, Blocks.OXIDIZED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER);

                for (CopperBundle copperBundle : CopperBundle.values()) {
                    offerWaxingRecipes(copperBundle.block(), copperBundle.blockWaxed());
                    offerWaxingRecipes(copperBundle.slab(), copperBundle.slabWaxed());
                    offerWaxingRecipes(copperBundle.stairs(), copperBundle.stairsWaxed());
                    offerWaxingRecipes(copperBundle.wall(), copperBundle.wallWaxed());
                    if (copperBundle.type().contains("copper_tuff_bricks")) {
                        offerStonecuttingRecipe(copperBundle.stairs(), copperBundle.block());
                        offerStonecuttingRecipe(copperBundle.slab(), 2, copperBundle.block());
                        offerStonecuttingRecipe(copperBundle.wall(), copperBundle.block());
                        offerStonecuttingRecipe(copperBundle.stairsWaxed(), copperBundle.blockWaxed());
                        offerStonecuttingRecipe(copperBundle.slabWaxed(), 2, copperBundle.blockWaxed());
                        offerStonecuttingRecipe(copperBundle.wallWaxed(), copperBundle.blockWaxed());
                    }
                }
                createShaped(RecipeCategory.BUILDING_BLOCKS, COPPER_TUFF_BRICKS.block(), 2).input('#', Items.COPPER_INGOT).input('X', Blocks.TUFF_BRICKS).pattern("#X").pattern("X#").criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).criterion(hasItem(Blocks.TUFF_BRICKS), conditionsFromItem(Blocks.TUFF_BRICKS)).offerTo(exporter);

                // Quartz Blocks
                offerBsswCuttingRecipe(QUARTZ_TILES, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);
                offerPolishedStoneRecipe(QUARTZ_TILES.block(), Blocks.QUARTZ_BRICKS);
                offerStonecuttingRecipe(QUARTZ_CIRCULAR_PAVING, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);

                // Prismarine
                offerStonecuttingRecipe(CHISELED_PRISMARINE, Blocks.PRISMARINE_BRICKS);
                offerStonecuttingRecipe(PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS);
                offerStonecuttingRecipe(PRISMARINE_CIRCULAR_PAVING, Blocks.PRISMARINE_BRICKS);
                offerStonecuttingRecipe(CHISELED_DARK_PRISMARINE, Blocks.DARK_PRISMARINE);
                offerStonecuttingRecipe(DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE);
                offerBsswCuttingRecipe(PRISMARINE_TILES);
                createShaped(RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILES.block(), 4).input('#', Blocks.DARK_PRISMARINE).input('X', Items.PRISMARINE_SHARD).pattern("#X").pattern("X#").criterion(hasItem(Blocks.DARK_PRISMARINE), conditionsFromItem(Blocks.DARK_PRISMARINE)).offerTo(exporter);

                // Bricks
                offerBsswCuttingRecipe(LARGE_BRICKS, Blocks.BRICKS);
                offerPolishedStoneRecipe(LARGE_BRICKS.block(), Blocks.BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_BRICKS, Blocks.BRICKS);

                // Soaked Bricks
                offerBsswCuttingRecipe(SOAKED_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_SOAKED_BRICKS, SOAKED_BRICKS.block());
                createEnclosedRecipe(SOAKED_BRICKS.block(), Ingredient.ofItems(Blocks.BRICKS), Items.WATER_BUCKET).criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET)).criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

                // Sandy Bricks
                offerBsswCuttingRecipe(SANDY_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_SANDY_BRICKS, SANDY_BRICKS.block());
                createShaped(RecipeCategory.BUILDING_BLOCKS, SANDY_BRICKS.block(), 2).input('S', Blocks.SAND).input('#', Blocks.BRICKS).pattern(" S ").pattern("S#S").pattern(" S ").criterion("has_sand", conditionsFromItem(Blocks.SAND)).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

                // Charred Bricks
                offerBsswCuttingRecipe(CHARRED_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_CHARRED_BRICKS, CHARRED_BRICKS.block());
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, CHARRED_BRICKS.block().asItem(), 0.1F, 200).criterion("has_bricks", conditionsFromItem(Blocks.BRICKS)).offerTo(exporter);

                // Resin Bricks
                offerBsswCuttingRecipe(LARGE_RESIN_BRICKS, Blocks.RESIN_BRICKS);
                offerPolishedStoneRecipe(LARGE_RESIN_BRICKS.block(), Blocks.RESIN_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_RESIN_BRICKS, Blocks.RESIN_BRICKS);
                offerStonecuttingRecipe(RESIN_BRICK_PILLAR, Blocks.RESIN_BRICKS);

                // Sandstone
                offerBsswCuttingRecipe(ROUGH_SANDSTONE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_SANDSTONE.block(), 2).input('#', Blocks.SANDSTONE_SLAB).pattern("##").pattern("##").criterion("has_sandstone", conditionsFromItem(Blocks.SANDSTONE)).offerTo(exporter);
                offerBsswCuttingRecipe(SANDSTONE_BRICKS, Blocks.SANDSTONE);
                offerBsswCuttingRecipe(SMALL_SANDSTONE_BRICKS, Blocks.SANDSTONE, SANDSTONE_BRICKS.block());
                offerStonecuttingRecipe(SANDSTONE_PILLAR, Blocks.SANDSTONE, SANDSTONE_BRICKS.block());
                offerDecoratedRecipe(GOLD_DECORATED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_SANDSTONE);
                offerDecoratedRecipe(LAPIS_DECORATED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_SANDSTONE);

                // Red Sandstone
                offerBsswCuttingRecipe(ROUGH_RED_SANDSTONE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_RED_SANDSTONE.block(), 2).input('#', Blocks.RED_SANDSTONE_SLAB).pattern("##").pattern("##").criterion("has_red_sandstone", conditionsFromItem(Blocks.RED_SANDSTONE)).offerTo(exporter);
                offerBsswCuttingRecipe(RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE);
                offerBsswCuttingRecipe(SMALL_RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block());
                offerStonecuttingRecipe(RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block());
                offerDecoratedRecipe(GOLD_DECORATED_RED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_RED_SANDSTONE);
                offerDecoratedRecipe(LAPIS_DECORATED_RED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_RED_SANDSTONE);

                // Soul Sandstone
                offerBsswCuttingRecipe(SOUL_SANDSTONE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, SOUL_SANDSTONE.block()).input('#', BlockusItemTags.SOUL_SOILS).pattern("##").pattern("##").criterion("has_soul_sand", conditionsFromTag(BlockusItemTags.SOUL_SOILS)).offerTo(exporter);
                offerBsswCuttingRecipe(SMOOTH_SOUL_SANDSTONE);
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(SOUL_SANDSTONE.block()), RecipeCategory.BUILDING_BLOCKS, SMOOTH_SOUL_SANDSTONE.block().asItem(), 0.1F, 200).criterion("has_soul_sandstone", conditionsFromItem(SOUL_SANDSTONE.block())).offerTo(exporter);
                offerPolishedStoneRecipe(CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
                offerStonecuttingRecipe(CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
                offerStonecuttingRecipe(CUT_SOUL_SANDSTONE_SLAB, 2, SOUL_SANDSTONE.block(), CUT_SOUL_SANDSTONE);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CUT_SOUL_SANDSTONE_SLAB, CUT_SOUL_SANDSTONE);

                offerBsswCuttingRecipe(ROUGH_SOUL_SANDSTONE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_SOUL_SANDSTONE.block(), 2).input('#', SOUL_SANDSTONE.slab()).pattern("##").pattern("##").criterion("has_soul_sandstone", conditionsFromItem(SOUL_SANDSTONE.block())).offerTo(exporter);
                offerBsswCuttingRecipe(SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block());
                offerBsswCuttingRecipe(SMALL_SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block(), SOUL_SANDSTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
                offerPolishedStoneRecipe(CHISELED_SOUL_SANDSTONE, CUT_SOUL_SANDSTONE);
                offerStonecuttingRecipe(SOUL_SANDSTONE_PILLAR, SOUL_SANDSTONE.block(), SOUL_SANDSTONE_BRICKS.block());
                offerDecoratedRecipe(GOLD_DECORATED_SOUL_SANDSTONE, Items.GOLD_INGOT, CUT_SOUL_SANDSTONE);
                offerDecoratedRecipe(LAPIS_DECORATED_SOUL_SANDSTONE, Items.LAPIS_LAZULI, CUT_SOUL_SANDSTONE);

                // Honeycomb Bricks
                offerBsswCuttingRecipe(HONEYCOMB_BRICKS, Blocks.HONEYCOMB_BLOCK);
                offerPolishedStoneRecipe(HONEYCOMB_BRICKS.block(), Blocks.HONEYCOMB_BLOCK);

                // Purpur Blocks
                offerBsswCuttingRecipe(POLISHED_PURPUR, Blocks.PURPUR_BLOCK);
                offerPolishedStoneRecipe(POLISHED_PURPUR.block(), Blocks.PURPUR_BLOCK);
                offerBsswCuttingRecipe(PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block());
                offerBsswCuttingRecipe(SMALL_PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_PURPUR, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                offerStonecuttingRecipe(Blocks.PURPUR_PILLAR, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                offerStonecuttingRecipe(PURPUR_SQUARES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                offerStonecuttingRecipe(PURPUR_LINES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());

                // Phantom Purpur Blocks
                offerBsswCuttingRecipe(PHANTOM_PURPUR_BLOCK);
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_BLOCK.block(), Blocks.PURPUR_BLOCK);
                offerPolishedStoneRecipe(POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BLOCK.block());
                offerBsswCuttingRecipe(POLISHED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.block());
                offerPhantomPurpurRecipe(POLISHED_PHANTOM_PURPUR.block(), POLISHED_PURPUR.block());
                offerBsswCuttingRecipe(PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block());
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_BRICKS.block(), PURPUR_BRICKS.block());
                offerPolishedStoneRecipe(PHANTOM_PURPUR_BRICKS.block(), POLISHED_PHANTOM_PURPUR.block());
                offerBsswCuttingRecipe(SMALL_PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(SMALL_PHANTOM_PURPUR_BRICKS.block(), PHANTOM_PURPUR_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(CHISELED_PHANTOM_PURPUR, CHISELED_PURPUR);
                offerStonecuttingRecipe(PHANTOM_PURPUR_PILLAR, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_PILLAR, Blocks.PURPUR_PILLAR);
                createShaped(RecipeCategory.BUILDING_BLOCKS, PHANTOM_PURPUR_PILLAR).input('#', PHANTOM_PURPUR_BLOCK.slab()).pattern("#").pattern("#").criterion("has_phantom_purpur_block", conditionsFromItem(PHANTOM_PURPUR_BLOCK.block())).offerTo(exporter);
                offerStonecuttingRecipe(PHANTOM_PURPUR_SQUARES, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_SQUARES, PURPUR_SQUARES);
                offerStonecuttingRecipe(PHANTOM_PURPUR_LINES, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_LINES, PURPUR_LINES);

                // End Stone
                offerBsswCuttingRecipe(POLISHED_END_STONE, Blocks.END_STONE);
                offerPolishedStoneRecipe(POLISHED_END_STONE.block(), Blocks.END_STONE);
                offerStonecuttingRecipe(Blocks.END_STONE_BRICKS, POLISHED_END_STONE.block());
                offerStonecuttingRecipe(Blocks.END_STONE_BRICK_STAIRS, POLISHED_END_STONE.block());
                offerStonecuttingRecipe(Blocks.END_STONE_BRICK_SLAB, 2, POLISHED_END_STONE.block());
                offerStonecuttingRecipe(Blocks.END_STONE_BRICK_WALL, POLISHED_END_STONE.block());
                offerCrackingRecipe(CRACKED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);
                offerBsswCuttingRecipe(SMALL_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
                offerStonecuttingRecipe(CHISELED_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
                offerStonecuttingRecipe(END_STONE_PILLAR, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
                offerDecoratedRecipe(PURPUR_DECORATED_END_STONE, Items.POPPED_CHORUS_FRUIT, Blocks.END_STONE_BRICKS);
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_DECORATED_END_STONE, PURPUR_DECORATED_END_STONE);
                offerBsswCuttingRecipe(END_TILES);
                createShaped(RecipeCategory.BUILDING_BLOCKS, END_TILES.block(), 4).input('#', Blocks.END_STONE).input('X', Blocks.PURPUR_BLOCK).pattern("#X").pattern("X#").criterion(hasItem(Blocks.PURPUR_BLOCK), conditionsFromItem(Blocks.PURPUR_BLOCK)).offerTo(exporter);
                offerPressurePlateButtonRecipe(POLISHED_END_STONE_PRESSURE_PLATE, POLISHED_END_STONE_BUTTON, POLISHED_END_STONE.block());

                // Wood
                offerHangingSignRecipe(WHITE_OAK.hangingSign(), STRIPPED_WHITE_OAK_LOG);
                offerShelfRecipe(WHITE_OAK.shelf(), STRIPPED_WHITE_OAK_LOG);
                offerBarkBlockRecipe(WHITE_OAK_WOOD, WHITE_OAK_LOG);
                offerPlanksRecipe(WHITE_OAK.planks(), BlockusItemTags.WHITE_OAK_LOGS, 4);

                offerHangingSignRecipe(RAW_BAMBOO.hangingSign(), Blocks.BAMBOO_BLOCK);
                offerShelfRecipe(RAW_BAMBOO.shelf(), Blocks.BAMBOO_BLOCK);

                createShaped(RecipeCategory.DECORATIONS, CHARRED.hangingSign(), 2).group("hanging_sign").input('#', CHARRED.planks()).input('X', Items.IRON_CHAIN).pattern("X X").pattern("###").pattern("###").criterion(hasItem(CHARRED.planks()), conditionsFromItem(CHARRED.planks())).offerTo(exporter);
                createShaped(RecipeCategory.DECORATIONS, CHARRED.shelf(), 2).group("shelf").input('#', CHARRED.planks()).pattern("###").pattern("   ").pattern("###").criterion(hasItem(CHARRED.planks()), conditionsFromItem(CHARRED.planks())).offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, RAW_BAMBOO.planks(), 2).input(Blocks.BAMBOO_BLOCK).group("planks").criterion("has_log", conditionsFromItem(Blocks.BAMBOO_BLOCK)).offerTo(exporter);
                offerBoatsRecipe(BlockusEntities.WHITE_OAK_BOAT, BlockusEntities.WHITE_OAK_CHEST_BOAT, WHITE_OAK.planks());
                offerBoatsRecipe(BlockusEntities.RAW_BAMBOO_RAFT, BlockusEntities.RAW_BAMBOO_CHEST_RAFT, RAW_BAMBOO.planks());
                offerBoatsRecipe(BlockusEntities.CHARRED_BOAT, BlockusEntities.CHARRED_CHEST_BOAT, CHARRED.planks());
                CookingRecipeJsonBuilder.createSmelting(ingredientFromTag(BlockusItemTags.PLANKS_THAT_BURN), RecipeCategory.BUILDING_BLOCKS, CHARRED.planks(), 0.1F, 200).criterion("has_planks", conditionsFromTag(BlockusItemTags.PLANKS_THAT_BURN)).offerTo(exporter);

                for (var entry : SMALL_LOGS.bundle().entrySet()) {
                    offerSmallLogsRecipe(entry.getValue(), WoodMaps.LOG_MAP.get(entry.getKey()));
                }

                for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
                    for (var entry : woodenPost.woodMap().entrySet()) {
                        Block log = WoodMaps.LOG_MAP.get(entry.getKey().getId());
                        Block strippedLog = WoodMaps.STRIPPED_LOG_MAP.get(entry.getKey().getId());
                        if (log == null || strippedLog == null) {
                            continue;
                        }
                        offerWoodenPostRecipe(entry.getValue(), log, strippedLog, WoodMaps.PLANKS_MAP.get(entry.getKey().getId()));
                    }
                }

                for (var entry : MOSSY_PLANKS.bundle().entrySet()) {
                    offerMossyRecipe(entry.getValue().block(), entry.getValue().base());
                }

                for (var entry : WOODEN_MOSAIC.bundle().entrySet()) {
                    offerMosaicRecipe(RecipeCategory.DECORATIONS, entry.getValue().block(), WoodMaps.SLAB_MAP.get(entry.getKey()));
                }
                offerCharredSmeltingRecipe(BlockusItemTags.WOODEN_MOSAIC_THAT_BURN, WOODEN_MOSAIC.get(WoodMaps.CHARRED.getId()).block(), "mosaic");


                for (var entry : HERRINGBONE_PLANKS.bundle().entrySet()) {
                    offerHerringBoneRecipe(entry.getValue(), WoodMaps.PLANKS_MAP.get(entry.getKey()));
                }
                offerCharredSmeltingRecipe(BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN, HERRINGBONE_PLANKS.get(WoodMaps.CHARRED.getId()), "herringbone_planks");

                for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
                    for (var entry : timberFrameBundle.woodMap().entrySet()) {
                        var variants = entry.getValue();
                        Block planks = WoodMaps.PLANKS_MAP.get(entry.getKey().getId());
                        createTimberFramesRecipes(planks, variants.block(), variants.diagonal(), variants.cross());
                        createLatticeRecipes(WoodMaps.PLANKS_MAP.get(entry.getKey().getId()), variants.lattice(), variants.grate());
                    }
                }

                // Small Hedges
                offerSmallHedgesRecipe(OAK_HEDGE, Blocks.OAK_LEAVES);
                offerSmallHedgesRecipe(SPRUCE_HEDGE, Blocks.SPRUCE_LEAVES);
                offerSmallHedgesRecipe(BIRCH_HEDGE, Blocks.BIRCH_LEAVES);
                offerSmallHedgesRecipe(JUNGLE_HEDGE, Blocks.JUNGLE_LEAVES);
                offerSmallHedgesRecipe(ACACIA_HEDGE, Blocks.ACACIA_LEAVES);
                offerSmallHedgesRecipe(DARK_OAK_HEDGE, Blocks.DARK_OAK_LEAVES);
                offerSmallHedgesRecipe(MANGROVE_HEDGE, Blocks.MANGROVE_LEAVES);
                offerSmallHedgesRecipe(CHERRY_HEDGE, Blocks.CHERRY_LEAVES);
                offerSmallHedgesRecipe(PALE_OAK_HEDGE, Blocks.PALE_OAK_LEAVES);
                offerSmallHedgesRecipe(WARPED_HEDGE, Blocks.WARPED_WART_BLOCK);
                offerSmallHedgesRecipe(CRIMSON_HEDGE, Blocks.NETHER_WART_BLOCK);
                offerSmallHedgesRecipe(WHITE_OAK_HEDGE, WHITE_OAK_LEAVES);
                offerSmallHedgesRecipe(AZALEA_HEDGE, Blocks.AZALEA_LEAVES);
                offerSmallHedgesRecipe(FLOWERING_AZALEA_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES);
                offerSmallHedgesRecipe(MOSS_HEDGE, Blocks.MOSS_BLOCK);
                offerSmallHedgesRecipe(PALE_MOSS_HEDGE, Blocks.PALE_MOSS_BLOCK);

                // Large Flower Pots
                createShaped(RecipeCategory.BUILDING_BLOCKS, LARGE_FLOWER_POT).input('#', Items.BRICK).pattern("# #").pattern("###").pattern("###").criterion("has_flower_pot", conditionsFromItem(Items.FLOWER_POT)).offerTo(exporter);

                // Chocolate
                createShaped(RecipeCategory.BUILDING_BLOCKS, CHOCOLATE_BLOCK.block(), 2).input('#', Items.COCOA_BEANS).pattern("##").pattern("##").criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS)).offerTo(exporter);
                offerBsswCuttingRecipe(CHOCOLATE_BLOCK);
                offerBsswCuttingRecipe(CHOCOLATE_BRICKS, CHOCOLATE_BLOCK.block());
                offerPolishedStoneRecipe(CHOCOLATE_BRICKS.block(), CHOCOLATE_BLOCK.block());
                offerPolishedStoneRecipe(CHOCOLATE_SQUARES, CHOCOLATE_BRICKS.block());
                offerStonecuttingRecipe(CHOCOLATE_SQUARES, CHOCOLATE_BLOCK.block(), CHOCOLATE_BRICKS.block());
                createShaped(RecipeCategory.DECORATIONS, CHOCOLATE_TABLET, 3).input('#', CHOCOLATE_SQUARES).pattern("##").criterion(hasItem(CHOCOLATE_SQUARES), conditionsFromItem(CHOCOLATE_SQUARES)).offerTo(exporter);
                offerStonecuttingRecipe(CHOCOLATE_TABLET, 2, CHOCOLATE_BLOCK.block(), CHOCOLATE_BRICKS.block(), CHOCOLATE_SQUARES);

                // Food Blocks
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.SWEET_BERRIES, RecipeCategory.BUILDING_BLOCKS, SWEET_BERRIES_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.GLOW_BERRIES, RecipeCategory.BUILDING_BLOCKS, GLOW_BERRIES_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.SALMON, RecipeCategory.BUILDING_BLOCKS, SALMON_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.PUFFERFISH, RecipeCategory.BUILDING_BLOCKS, PUFFERFISH_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.TROPICAL_FISH, RecipeCategory.BUILDING_BLOCKS, TROPICAL_FISH_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.COD, RecipeCategory.BUILDING_BLOCKS, COD_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.COOKIE, RecipeCategory.FOOD, COOKIE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.CHORUS_FRUIT, RecipeCategory.BUILDING_BLOCKS, CHORUS_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.POTATO, RecipeCategory.BUILDING_BLOCKS, POTATO_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.APPLE, RecipeCategory.BUILDING_BLOCKS, APPLE_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.GOLDEN_APPLE, RecipeCategory.BUILDING_BLOCKS, GOLDEN_APPLE_CRATE);
                createEnclosedRecipe2(GOLDEN_APPLE_CRATE, Ingredient.ofItems(Blocks.GOLD_BLOCK), APPLE_CRATE).criterion(hasItem(Items.GOLDEN_APPLE), conditionsFromItem(Items.GOLDEN_APPLE)).offerTo(exporter, convertBetween(GOLDEN_APPLE_CRATE, APPLE_CRATE));
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.BEETROOT, RecipeCategory.BUILDING_BLOCKS, BEETROOT_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.CARROT, RecipeCategory.BUILDING_BLOCKS, CARROT_CRATE);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.GOLDEN_CARROT, RecipeCategory.BUILDING_BLOCKS, GOLDEN_CARROT_CRATE);
                createEnclosedRecipe2(GOLDEN_CARROT_CRATE, Ingredient.ofItems(Items.GOLD_INGOT), CARROT_CRATE).criterion(hasItem(Items.GOLDEN_CARROT), conditionsFromItem(Items.GOLDEN_CARROT)).offerTo(exporter, convertBetween(GOLDEN_CARROT_CRATE, CARROT_CRATE));
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.BREAD, RecipeCategory.BUILDING_BLOCKS, BREAD_BOX);

                // Rainbow
                offerShapelessRecipe(RAINBOW_PETALS, RAINBOW_ROSE, "rainbow_petal", 2);
                offerShapelessRecipe(RAINBOW_PETALS, RAINBOW_BLOCK, "rainbow_petal", 4);
                createShaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_BLOCK).input('#', RAINBOW_PETALS).pattern("##").pattern("##").criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter);
                offerBsswCuttingRecipe(RAINBOW_BRICKS, RAINBOW_BLOCK);
                offerPolishedStoneRecipe(RAINBOW_BRICKS.block(), RAINBOW_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE).input(RAINBOW_PETALS).input(Blocks.GLOWSTONE).group("rainbow_glowstone").criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE, 1).input('G', Items.GLOWSTONE_DUST).group("rainbow_glowstone").input('R', RAINBOW_PETALS).pattern(" G ").pattern("GRG").pattern(" G ").criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter, getRecipeName(RAINBOW_GLOWSTONE) + "_alt");

                // Colored Stone Bricks
                for (DyeColor color : BlockOrder.COLOR) {
                    BSSWBundle bundle = STAINED_STONE_BRICKS.colorMap().get(color);
                    offerStainedStoneBricksRecipe(DYE_MAP.get(color), bundle.block(), bundle.stairs(), bundle.slab(), bundle.wall());
                }

                // Redstone Lamps
                createShapeless(RecipeCategory.BUILDING_BLOCKS, REDSTONE_LAMP_LIT).input(Blocks.REDSTONE_LAMP).input(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter);
                for (DyeColor color : BlockOrder.COLOR) {
                    offerStainedRedstoneLampRecipe(STAINED_REDSTONE_LAMP.colorMap().get(color), DYE_MAP.get(color), STAINED_REDSTONE_LAMP_LIT.colorMap().get(color));
                }
                offerStainedRedstoneLampRecipe(RAINBOW_LAMP, RAINBOW_PETALS, RAINBOW_LAMP_LIT);

                // Neon Blocks
                for (DyeColor color : BlockOrder.COLOR) {
                    Block block = NEON_BLOCK.colorMap().get(color);
                    offerNeonRecipe(block, DYE_MAP.get(color));
                }
                offerNeonRecipe(RAINBOW_NEON, RAINBOW_PETALS);

                // Futurneo Blocks
                for (DyeColor color : BlockOrder.COLOR) {
                    Block block = FUTURNEO_BLOCK.colorMap().get(color);
                    offerFuturneoRecipe(block, BlockMaps.STAINED_GLASS_MAP.get(color));
                }
                createShaped(RecipeCategory.BUILDING_BLOCKS, GRAY_BRIGHT_FUTURNEO_BLOCK).input('A', Items.WHITE_DYE).input('B', Blocks.GRAY_STAINED_GLASS).input('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").criterion(hasItem(Blocks.GRAY_STAINED_GLASS), conditionsFromItem(Blocks.GRAY_STAINED_GLASS)).offerTo(exporter);
                offerFuturneoRecipe(RAINBOW_FUTURNEO_BLOCK, RAINBOW_GLASS);

                // Asphalt
                createShaped(RecipeCategory.BUILDING_BLOCKS, ASPHALT.baseColor().block(), 8).input('X', Blocks.GRAVEL).input('#', ItemTags.COALS).pattern("XXX").pattern("X#X").pattern("XXX").group("asphalt").criterion(hasItem(Blocks.GRAVEL), conditionsFromItem(Blocks.GRAVEL)).offerTo(exporter);
                createEnclosedRecipe(RAINBOW_ASPHALT, Ingredient.ofItems(ASPHALT.baseColor().block()), RAINBOW_PETALS).criterion(hasItem(ASPHALT.baseColor().block()), conditionsFromItem(ASPHALT.baseColor().block())).offerTo(exporter);

                for (DyeColor color : BlockOrder.COLOR) {
                    if (color == DyeColor.BLACK) continue;
                    AsphaltBundle.AsphaltVariants bundle = ASPHALT.colorMap().get(color);
                    offerAsphaltRecipe(DYE_MAP.get(color), bundle.block(), bundle.stairs(), bundle.slab());
                }

                // Shingles
                offerBsswCuttingRecipe(SHINGLES, Blocks.TERRACOTTA);
                offerPolishedStoneRecipe(SHINGLES.block(), Blocks.TERRACOTTA);

                for (DyeColor color : BlockOrder.COLOR) {
                    BSSWBundle bundle = STAINED_SHINGLES.colorMap().get(color);
                    offerShinglesRecipe(DYE_MAP.get(color), bundle.block(), bundle.stairs(), bundle.slab(), BlockMaps.TERRACOTTA_MAP.get(color));
                }

                // Glass - Beveled Glass
                offerPolishedStoneRecipe(TINTED_BEVELED_GLASS, Blocks.TINTED_GLASS);
                offerPolishedStoneRecipe(BEVELED_GLASS, Blocks.GLASS);
                createShaped(RecipeCategory.BUILDING_BLOCKS, BEVELED_GLASS_PANE, 16).input('#', BEVELED_GLASS).pattern("###").pattern("###").group("beveled_glass_pane").criterion("has_beveled_glass", conditionsFromItem(BEVELED_GLASS_PANE)).offerTo(exporter);
                for (DyeColor color : BlockOrder.COLOR) {
                    offerStainedBeveledGlassRecipe(STAINED_BEVELED_GLASS.colorMap().get(color), STAINED_BEVELED_GLASS_PANE.colorMap().get(color), BlockMaps.STAINED_GLASS_MAP.get(color), DYE_MAP.get(color));
                }
                offerStainedBeveledGlassRecipe(RAINBOW_BEVELED_GLASS, RAINBOW_BEVELED_GLASS_PANE, RAINBOW_GLASS, RAINBOW_PETALS);
                createEnclosedRecipe(RAINBOW_GLASS, Ingredient.ofItems(Blocks.GLASS), RAINBOW_PETALS).criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter);
                createEnclosedRecipe(RAINBOW_GLASS_PANE, Ingredient.ofItems(Blocks.GLASS_PANE), RAINBOW_PETALS).criterion(hasItem(RAINBOW_PETALS), conditionsFromItem(RAINBOW_PETALS)).offerTo(exporter, getRecipeName(RAINBOW_GLASS_PANE) + "_alt");
                createShaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLASS_PANE, 16).input('#', RAINBOW_GLASS).pattern("###").pattern("###").criterion(hasItem(RAINBOW_GLASS), conditionsFromItem(RAINBOW_GLASS)).offerTo(exporter);

                // Colored Tiles
                for (DyeColor color : BlockOrder.COLOR) {
                    offerUnicolorColoredTilesRecipe(COLORED_TILES.colorMap().get(color), BlockMaps.CONCRETE_MAP.get(color));
                }
                offerUnicolorColoredTilesRecipe(RAINBOW_COLORED_TILES, RAINBOW_BLOCK);

                // Glazed Terracotta Pillars
                for (DyeColor color : BlockOrder.COLOR) {
                    offerPillarRecipe(GLAZED_TERRACOTTA_PILLAR.colorMap().get(color), BlockMaps.GLAZED_TERRACOTTA_MAP.get(color));
                }

                // Thatch
                offerPolishedStoneRecipe(THATCH.block(), Items.WHEAT);

                // Paper
                offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, PAPER_BLOCK);
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(PAPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, BURNT_PAPER_BLOCK.asItem(), 0.1F, 200).criterion("has_paper_block", conditionsFromItem(PAPER_BLOCK)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, FRAMED_PAPER_BLOCK, 4).input('X', Items.PAPER).input('#', Items.STICK).pattern("###").pattern("XXX").pattern("###").criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER)).offerTo(exporter);
                offerPolishedStoneRecipe(PAPER_WALL, FRAMED_PAPER_BLOCK);
                createEnclosedRecipe2(PAPER_LAMP, Ingredient.ofItems(Items.PAPER), Items.TORCH).criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER)).offerTo(exporter);
                offerShapelessRecipe2(Items.GUNPOWDER, BURNT_PAPER_BLOCK, 2);
                offerDoorTrapdoorRecipe(PAPER_DOOR, PAPER_TRAPDOOR, PAPER_WALL);

                // Plating
                offerBsswCuttingRecipe(IRON_PLATING);
                createShaped(RecipeCategory.BUILDING_BLOCKS, IRON_PLATING.block(), 24).input('X', Items.IRON_INGOT).pattern("XXX").pattern("X X").pattern("XXX").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
                offerBsswCuttingRecipe(GOLD_PLATING);
                createShaped(RecipeCategory.BUILDING_BLOCKS, GOLD_PLATING.block(), 24).input('X', Items.GOLD_INGOT).pattern("XXX").pattern("X X").pattern("XXX").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);

                // Gates - chains - bars
                createShaped(RecipeCategory.BUILDING_BLOCKS, IRON_GATE, 3).input('X', Blocks.IRON_BARS).input('#', Items.IRON_NUGGET).pattern("##").pattern("XX").pattern("XX").criterion(hasItem(Blocks.IRON_BARS), conditionsFromItem(Blocks.IRON_BARS)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, GOLDEN_GATE, 3).input('X', GOLDEN_BARS).input('#', Items.GOLD_NUGGET).pattern("##").pattern("XX").pattern("XX").criterion(hasItem(GOLDEN_BARS), conditionsFromItem(GOLDEN_BARS)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, GOLDEN_BARS, 16).input('#', Items.GOLD_INGOT).pattern("###").pattern("###").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, GOLDEN_CHAIN).input('X', Items.GOLD_INGOT).input('#', Items.GOLD_NUGGET).pattern("#").pattern("X").pattern("#").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);

                // Lantern Blocks

                offerLanternBlockRecipe(LANTERN_BLOCK, Blocks.LANTERN);
                offerLanternBlockRecipe(SOUL_LANTERN_BLOCK, Blocks.SOUL_LANTERN);
                createShaped(RecipeCategory.BUILDING_BLOCKS, AMETHYST_LANTERN).input('#', Items.TORCH).input('A', Items.AMETHYST_SHARD).input('X', Items.IRON_NUGGET).pattern("XXX").pattern("XAX").pattern("X#X").criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD)).offerTo(exporter);
                offerLanternBlockRecipe(AMETHYST_LANTERN_BLOCK, AMETHYST_LANTERN);
                createShaped(RecipeCategory.BUILDING_BLOCKS, REDSTONE_LANTERN).input('#', Items.REDSTONE_TORCH).input('X', Items.IRON_NUGGET).pattern("XXX").pattern("X#X").pattern("XXX").criterion(hasItem(Items.REDSTONE_TORCH), conditionsFromItem(Items.REDSTONE_TORCH)).offerTo(exporter);
                offerLanternBlockRecipe(REDSTONE_LANTERN_BLOCK, REDSTONE_LANTERN);
                createShaped(RecipeCategory.BUILDING_BLOCKS, SOUL_O_LANTERN).input('X', Blocks.CARVED_PUMPKIN).input('#', Blocks.SOUL_TORCH).pattern("X").pattern("#").criterion(hasItem(Blocks.CARVED_PUMPKIN), conditionsFromItem(Blocks.CARVED_PUMPKIN)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, REDSTONE_O_LANTERN).input('X', Blocks.CARVED_PUMPKIN).input('#', Blocks.REDSTONE_TORCH).pattern("X").pattern("#").criterion(hasItem(Blocks.CARVED_PUMPKIN), conditionsFromItem(Blocks.CARVED_PUMPKIN)).criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH)).offerTo(exporter);

                // Barriers
                createShaped(RecipeCategory.BUILDING_BLOCKS, ROAD_BARRIER, 5).input('#', Items.IRON_INGOT).input('X', Blocks.STONE).pattern("X#X").pattern("X#X").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, CAUTION_BARRIER).input(CAUTION_BLOCK).input(ROAD_BARRIER).criterion(hasItem(CAUTION_BLOCK), conditionsFromItem(CAUTION_BLOCK)).criterion(hasItem(ROAD_BARRIER), conditionsFromItem(ROAD_BARRIER)).offerTo(exporter);

                // Netherite Blocks
                offerStairsRecipe(NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, NETHERITE_SLAB, Blocks.NETHERITE_BLOCK);
                offerStonecuttingRecipe(NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
                offerStonecuttingRecipe(NETHERITE_SLAB, 2, Blocks.NETHERITE_BLOCK);

                // Other
                offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, CHARCOAL_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, SUGAR_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, ENDER_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, ROTTEN_FLESH_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.BUILDING_BLOCKS, MEMBRANE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.NETHER_STAR, RecipeCategory.BUILDING_BLOCKS, NETHER_STAR_BLOCK);
                offerPolishedStoneRecipe(WOODEN_FRAME, Items.STICK);
                createEnclosedRecipe2(REDSTONE_SAND, Ingredient.ofItems(Items.REDSTONE), Items.SAND).criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.REDSTONE, 8).input(REDSTONE_SAND).criterion(hasItem(REDSTONE_SAND), conditionsFromItem(REDSTONE_SAND)).offerTo(exporter, convertBetween(Items.REDSTONE, REDSTONE_SAND));
                createShaped(RecipeCategory.BUILDING_BLOCKS, LOVE_BLOCK).input('M', Items.MAGENTA_DYE).input('R', Items.RED_DYE).pattern("RMR").pattern("RRR").pattern("MRM").criterion(hasItem(Items.MAGENTA_DYE), conditionsFromItem(Items.MAGENTA_DYE)).criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, WEIGHT_STORAGE_CUBE).input(Blocks.STONE).input(Items.IRON_NUGGET).criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, COMPANION_CUBE).input(WEIGHT_STORAGE_CUBE).input(Items.POPPY).criterion(hasItem(WEIGHT_STORAGE_CUBE), conditionsFromItem(WEIGHT_STORAGE_CUBE)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, CAUTION_BLOCK, 6).input('A', Blocks.STONE).input('B', Items.BLACK_DYE).input('C', Items.YELLOW_DYE).pattern(" C ").pattern("BAB").pattern(" C ").criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE)).criterion(hasItem(Items.YELLOW_DYE), conditionsFromItem(Items.YELLOW_DYE)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, STARS_BLOCK, 3).input('#', Items.ENDER_PEARL).input('X', Items.CHORUS_FRUIT).pattern("X#X").pattern("###").pattern("X#X").criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT)).offerTo(exporter);

                // Legacy
                offerStonecuttingRecipe(LEGACY_BRICKS, Blocks.BRICKS);
                offerStonecuttingRecipe(LEGACY_FIRST_COBBLESTONE, Blocks.COBBLESTONE);
                offerStonecuttingRecipe(LEGACY_COBBLESTONE, Blocks.COBBLESTONE);
                offerStonecuttingRecipe(LEGACY_MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE);
                offerStonecuttingRecipe(LEGACY_GRAVEL, Blocks.GRAVEL);
                offerStonecuttingRecipe(LEGACY_IRON_BLOCK, Blocks.IRON_BLOCK);
                offerStonecuttingRecipe(LEGACY_GOLD_BLOCK, Blocks.GOLD_BLOCK);
                offerStonecuttingRecipe(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, Blocks.GOLD_BLOCK);
                offerStonecuttingRecipe(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, LEGACY_GOLD_BLOCK);
                offerStonecuttingRecipe(LEGACY_COAL_BLOCK, Blocks.COAL_BLOCK);
                offerStonecuttingRecipe(LEGACY_DIAMOND_BLOCK, Blocks.DIAMOND_BLOCK);
                offerStonecuttingRecipe(LEGACY_LAPIS_BLOCK, Blocks.LAPIS_BLOCK);
                offerStonecuttingRecipe(LEGACY_SPONGE, Blocks.SPONGE);
                offerStonecuttingRecipe(LEGACY_CRYING_OBSIDIAN, Blocks.CRYING_OBSIDIAN);
                offerStonecuttingRecipe(LEGACY_GLOWSTONE, Blocks.GLOWSTONE);
                offerStonecuttingRecipe(LEGACY_GLOWING_OBSIDIAN, GLOWING_OBSIDIAN);
                offerShapelessRecipe(Items.IRON_INGOT, LEGACY_IRON_BLOCK, "iron_ingot", 9);
                offerShapelessRecipe(Items.GOLD_INGOT, LEGACY_GOLD_BLOCK, "gold_ingot", 9);
                offerShapelessRecipe(Items.GOLD_INGOT, LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, "gold_ingot", 9);
                offerShapelessRecipe(Items.COAL, LEGACY_COAL_BLOCK, "coal", 9);
                offerShapelessRecipe(Items.DIAMOND, LEGACY_DIAMOND_BLOCK, "diamond", 9);
                offerShapelessRecipe(Items.LAPIS_LAZULI, LEGACY_LAPIS_BLOCK, "lapis_lazuli", 9);
                offerShapelessRecipe(Items.RED_DYE, LEGACY_ROSE, "red_dye", 2);
                offerShapelessRecipe(Items.LIGHT_BLUE_DYE, LEGACY_BLUE_ROSE, "light_blue_dye", 2);
                createShaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_STONECUTTER).input('#', Blocks.COBBLESTONE).input('S', Blocks.STONECUTTER).pattern(" # ").pattern("#S#").pattern(" # ").criterion(hasItem(Blocks.STONECUTTER), conditionsFromItem(Blocks.STONECUTTER)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_NETHER_REACTOR_CORE).input('#', Items.DIAMOND).input('X', Items.IRON_INGOT).pattern("X#X").pattern("X#X").pattern("X#X").criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_SAPLING, 4).input('#', Blocks.OAK_SAPLING).pattern("##").pattern("##").criterion(hasItem(Blocks.OAK_SAPLING), conditionsFromItem(Blocks.OAK_SAPLING)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_ROSE, 2).input('#', Blocks.POPPY).pattern("##").pattern("##").criterion(hasItem(Blocks.POPPY), conditionsFromItem(Blocks.POPPY)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_BLUE_ROSE, 2).input('#', LEGACY_ROSE).pattern("##").criterion(hasItem(LEGACY_ROSE), conditionsFromItem(LEGACY_ROSE)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_FIRST_GRASS_BLOCK, 4).input('#', LEGACY_GRASS_BLOCK).pattern("##").pattern("##").criterion(hasItem(LEGACY_GRASS_BLOCK), conditionsFromItem(LEGACY_GRASS_BLOCK)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, LEGACY_PLANKS, 4).input(LEGACY_LOG).group("planks").criterion("has_logs", conditionsFromItem(LEGACY_LOG)).offerTo(exporter);
            }

            private void offerLanternBlockRecipe(Block output, Block lantern) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output).input('X', lantern).input('#', Items.IRON_NUGGET).pattern(" # ").pattern("#X#").pattern(" # ").criterion(hasItem(lantern), conditionsFromItem(lantern)).offerTo(exporter);
            }

            public void offerWaxingRecipes(Block unwaxed, Block waxed) {
                createShapeless(RecipeCategory.BUILDING_BLOCKS, waxed).input(unwaxed).input(Items.HONEYCOMB).group(getItemPath(waxed)).criterion(hasItem(unwaxed), conditionsFromItem(unwaxed)).offerTo(exporter, convertBetween(waxed, Items.HONEYCOMB));
            }

            public void offerCharredSmeltingRecipe(TagKey<Item> input, ItemConvertible output, String hasitem) {
                CookingRecipeJsonBuilder.createSmelting(ingredientFromTag(input), RecipeCategory.BUILDING_BLOCKS, output, 0.1F, 200).criterion("has_" + hasitem, conditionsFromTag(input)).offerTo(exporter, getRecipeName(output) + "_from_smelting");
            }

            public void offerMossyRecipe(ItemConvertible output, ItemConvertible input) {
                createShapeless(RecipeCategory.BUILDING_BLOCKS, output).input(input).input(Blocks.VINE).group(Registries.BLOCK.getId((Block) output).getPath()).criterion("has_vine", conditionsFromItem(Blocks.VINE)).offerTo(exporter, convertBetween(output, Blocks.VINE));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, output).input(input).input(Blocks.MOSS_BLOCK).group(Registries.BLOCK.getId((Block) output).getPath()).criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK)).offerTo(exporter, convertBetween(output, Blocks.MOSS_BLOCK));
            }

            public void offerPolishedStoneRecipe(ItemConvertible output, ItemConvertible input) {
                createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }

            public CraftingRecipeJsonBuilder createCondensingRecipe(RecipeCategory category, ItemConvertible output, int count, Ingredient input, String group) {
                return createShaped(category, output, count).input('S', input).group(group).pattern("SS").pattern("SS");
            }

            public void offerShapelessRecipe2(ItemConvertible output, ItemConvertible input, int outputCount) {
                createShapeless(RecipeCategory.BUILDING_BLOCKS, output, outputCount).input(input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }

            public void offerSturdyRecipe(ItemConvertible output, ItemConvertible input1, ItemConvertible input2) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 2).input('#', input1).input('X', input2).pattern("X#X").pattern("# #").pattern("X#X").criterion(hasItem(input1), conditionsFromItem(input1)).criterion(hasItem(input2), conditionsFromItem(input2)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 2).input('#', input1).input('X', input2).pattern("#X#").pattern("X X").pattern("#X#").criterion(hasItem(input1), conditionsFromItem(input1)).criterion(hasItem(input2), conditionsFromItem(input2)).offerTo(exporter, getRecipeName(output) + "_alt");

            }

            public void offerDecoratedRecipe(ItemConvertible output, ItemConvertible decoration, ItemConvertible input) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', decoration).input('X', input).pattern("##").pattern("XX").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }

            public void offerPhantomPurpurRecipe(ItemConvertible output, ItemConvertible input) {
                createShapeless(RecipeCategory.BUILDING_BLOCKS, output).input(input).input(BlockusItemTags.SOUL_SOILS).criterion("has_purpur", conditionsFromItem(input)).offerTo(exporter, convertBetween(output, Blocks.SOUL_SAND));

            }

            public void offerColoredTilesRecipe(ItemConvertible output, ItemConvertible color1, ItemConvertible color2) {
                createShapeless(RecipeCategory.BUILDING_BLOCKS, output, 2).input(color1).input(color2).group("colored_tiles").criterion(hasItem(color1), conditionsFromItem(color1)).criterion(hasItem(color2), conditionsFromItem(color2)).offerTo(exporter);

            }

            public void offerUnicolorColoredTilesRecipe(ItemConvertible output, ItemConvertible color) {
                createShapeless(RecipeCategory.BUILDING_BLOCKS, output, 2).input(color).input(color).group("colored_tiles").criterion(hasItem(color), conditionsFromItem(color)).offerTo(exporter);
                offerStonecuttingRecipe(output, color);

            }

            public void offerSmallLogsRecipe(ItemConvertible output, ItemConvertible input) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', input).pattern(" # ").pattern("###").group("small_logs").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }

            public void offerWoodenPostRecipe(WoodenPostBundle.WoodenPostVariants post, ItemConvertible base, ItemConvertible base2, ItemConvertible planks) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, post.block(), 6).input('#', base).pattern("#").pattern("#").pattern("#").group("wooden_posts").criterion("has_woods", conditionsFromItem(base)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, post.stripped(), 6).input('#', base2).pattern("#").pattern("#").pattern("#").group("stripped_wooden_posts").criterion("has_woods", conditionsFromItem(base2)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, planks, 2).input(post.block()).group("planks").criterion("has_wooden_post", conditionsFromItem(post.block())).offerTo(exporter, convertBetween(planks, post.block()));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, planks, 2).input(post.stripped()).group("planks").criterion("has_stripped_wooden_post", conditionsFromItem(post.stripped())).offerTo(exporter, convertBetween(planks, post.stripped()));
            }

            public void offerSmallHedgesRecipe(ItemConvertible output, ItemConvertible input) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 6).input('#', input).pattern("###").pattern("###").group("hedge").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }


            public void offerHerringBoneRecipe(ItemConvertible output, ItemConvertible input) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 5).input('#', input).pattern("#  ").pattern("###").pattern("  #").group("herringbone_planks").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }

            public CraftingRecipeJsonBuilder createEnclosedRecipe(ItemConvertible output, Ingredient input, ItemConvertible center) {
                return createShaped(RecipeCategory.BUILDING_BLOCKS, output, 8).input('X', input).input('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
            }

            public CraftingRecipeJsonBuilder createEnclosedRecipe2(ItemConvertible output, Ingredient input, ItemConvertible center) {
                return createShaped(RecipeCategory.BUILDING_BLOCKS, output).input('X', input).input('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
            }

            public void offerStoneDoorTrapdoorRecipe(ItemConvertible door, ItemConvertible trapdoor, ItemConvertible input, ItemConvertible slab) {
                createDoorRecipe(door, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, trapdoor, 4).input('#', slab).pattern("###").pattern("###").criterion(hasItem(slab), conditionsFromItem(slab)).offerTo(exporter);
            }

            public void offerDoorTrapdoorRecipe(ItemConvertible door, ItemConvertible trapdoor, ItemConvertible input) {
                createDoorRecipe(door, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
                createTrapdoorRecipe(trapdoor, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }

            public void offerPressurePlateButtonRecipe(ItemConvertible pressureplate, ItemConvertible button, ItemConvertible input) {
                createPressurePlateRecipe(RecipeCategory.REDSTONE, pressureplate, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
                createShapeless(RecipeCategory.REDSTONE, button).input(input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }

            public void offerStainedStoneBricksRecipe(ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab, ItemConvertible output_wall) {
                createEnclosedRecipe(output, Ingredient.ofItems(Blocks.STONE_BRICKS), center).group("stained_stone_bricks").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter);
                createEnclosedRecipe(output_stairs, Ingredient.ofItems(Blocks.STONE_BRICK_STAIRS), center).group("stained_stone_brick_stairs").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_stairs, Blocks.STONE_BRICK_STAIRS));
                createEnclosedRecipe(output_slab, Ingredient.ofItems(Blocks.STONE_BRICK_SLAB), center).group("stained_stone_brick_slab").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_slab, Blocks.STONE_BRICK_SLAB));
                createEnclosedRecipe(output_wall, Ingredient.ofItems(Blocks.STONE_BRICK_WALL), center).group("stained_stone_brick_wall").criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS)).offerTo(exporter, convertBetween(output_wall, Blocks.STONE_BRICK_WALL));
                offerStonecuttingRecipe(output_stairs, output);
                offerStonecuttingRecipe(output_slab, 2, output);
                offerStonecuttingRecipe(output_wall, output);
            }

            public void offerOreBricksRecipe(BSSWBundle ore_bricks, ItemConvertible ore_block, ItemConvertible ore) {
                offerStonecuttingRecipe(ore_bricks.block(), ore_block);
                offerStonecuttingRecipe(ore_bricks.stairs(), ore_bricks.block(), ore_block);
                offerStonecuttingRecipe(ore_bricks.slab(), 2, ore_bricks.block(), ore_block);
                offerStonecuttingRecipe(ore_bricks.wall(), ore_bricks.block(), ore_block);
                offerPolishedStoneRecipe(ore_bricks.block(), ore_block);
                offerShapelessRecipe(ore, ore_bricks.block(), ore.toString(), 9);
                offerShapelessRecipe(ore, ore_bricks.stairs(), ore.toString(), 9);
                offerShapelessRecipe(ore, ore_bricks.slab(), ore.toString(), 4);
                offerShapelessRecipe(ore, ore_bricks.wall(), ore.toString(), 9);
            }

            public void offerCopperBricksRecipe(CopperBundle block, ItemConvertible baseWaxed, ItemConvertible cutCopper, ItemConvertible cutCopperWaxed) {
                offerStonecuttingRecipe(block.block(), cutCopper);
                offerStonecuttingRecipe(block.stairs(), block.block(), cutCopper);
                offerStonecuttingRecipe(block.slab(), 2, block.block(), cutCopper);
                offerStonecuttingRecipe(block.wall(), block.block(), cutCopper);
                offerStonecuttingRecipe(block.blockWaxed(), cutCopperWaxed);
                offerStonecuttingRecipe(block.stairsWaxed(), block.blockWaxed(), cutCopperWaxed);
                offerStonecuttingRecipe(block.slabWaxed(), 2, block.blockWaxed(), cutCopperWaxed);
                offerStonecuttingRecipe(block.wallWaxed(), block.blockWaxed(), cutCopperWaxed);
                offerStonecuttingRecipe(block.block(), 4, block.base());
                offerStonecuttingRecipe(block.stairs(), 4, block.base());
                offerStonecuttingRecipe(block.slab(), 8, block.base());
                offerStonecuttingRecipe(block.wall(), 4, block.base());
                offerStonecuttingRecipe(block.blockWaxed(), 4, baseWaxed);
                offerStonecuttingRecipe(block.stairsWaxed(), 4, baseWaxed);
                offerStonecuttingRecipe(block.slabWaxed(), 8, baseWaxed);
                offerStonecuttingRecipe(block.wallWaxed(), 4, baseWaxed);
                offerPolishedStoneRecipe(block.block(), cutCopper);
                offerPolishedStoneRecipe(block.blockWaxed(), cutCopperWaxed);
            }

            public void createTimberFramesRecipes(ItemConvertible base, ItemConvertible block, ItemConvertible diagonal, ItemConvertible cross) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, block, 2).input('#', Items.PAPER).input('X', base).pattern("#X").pattern("X#").group("timber_frame").criterion(hasItem(base), conditionsFromItem(base)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, diagonal, 4).input('#', block).pattern("##").pattern("##").group("diagonal_timber_frame").criterion(hasItem(block), conditionsFromItem(block)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, cross, 4).input('#', diagonal).pattern("##").pattern("##").group("cross_timber_frame").criterion(hasItem(diagonal), conditionsFromItem(diagonal)).offerTo(exporter);
            }

            public void createLatticeRecipes(ItemConvertible base, ItemConvertible lattice, ItemConvertible grate) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, grate, 3).input('#', Items.STICK).input('X', base).pattern(" # ").pattern("#X#").pattern(" # ").group("wooden_grates").criterion(hasItem(base), conditionsFromItem(base)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, lattice, 16).input('#', grate).pattern("###").pattern("###").group("wooden_lattices").criterion(hasItem(lattice), conditionsFromItem(lattice)).offerTo(exporter);
            }

            public void offerAsphaltRecipe(ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab) {
                createEnclosedRecipe(output, Ingredient.ofItems(ASPHALT.baseColor().block()), center).group("asphalt").criterion(hasItem(ASPHALT.baseColor().block()), conditionsFromItem(ASPHALT.baseColor().block())).offerTo(exporter);
                createEnclosedRecipe(output_stairs, Ingredient.ofItems(ASPHALT.baseColor().stairs()), center).group("asphalt_stairs").criterion(hasItem(ASPHALT.baseColor().stairs()), conditionsFromItem(ASPHALT.baseColor().stairs())).offerTo(exporter, convertBetween(output_stairs, ASPHALT.baseColor().stairs()));
                createEnclosedRecipe(output_slab, Ingredient.ofItems(ASPHALT.baseColor().slab()), center).group("asphalt_slab").criterion(hasItem(ASPHALT.baseColor().slab()), conditionsFromItem(ASPHALT.baseColor().slab())).offerTo(exporter, convertBetween(output_slab, ASPHALT.baseColor().slab()));
            }

            public void offerPatternedWoolRecipe(ItemConvertible output, ItemConvertible wool, ItemConvertible output_carpet, ItemConvertible carpet) {
                offerPolishedStoneRecipe(output, wool);
                createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, output_carpet, Ingredient.ofItems(carpet)).group("patterned_carpet").criterion(hasItem(carpet), conditionsFromItem(carpet)).offerTo(exporter, convertBetween(output_carpet, carpet));
            }

            public void offerGinghamWoolRecipe(ItemConvertible output, ItemConvertible wool) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', wool).pattern(" # ").pattern("# #").pattern(" # ").group("gingham_wool").criterion(hasItem(wool), conditionsFromItem(wool)).offerTo(exporter);
            }

            public void offerShinglesRecipe(ItemConvertible center, ItemConvertible output, ItemConvertible output_stairs, ItemConvertible output_slab, ItemConvertible terracotta) {
                createEnclosedRecipe(output, Ingredient.ofItems(SHINGLES.block()), center).group("shingles").criterion(hasItem(SHINGLES.block()), conditionsFromItem(SHINGLES.block())).offerTo(exporter, convertBetween(output_stairs, SHINGLES.block()));
                createEnclosedRecipe(output_stairs, Ingredient.ofItems(SHINGLES.stairs()), center).group("shingles_stairs").criterion(hasItem(SHINGLES.block()), conditionsFromItem(SHINGLES.block())).offerTo(exporter, convertBetween(output_stairs, SHINGLES.stairs()));
                createEnclosedRecipe(output_slab, Ingredient.ofItems(SHINGLES.slab()), center).group("shingles_slab").criterion(hasItem(SHINGLES.block()), conditionsFromItem(SHINGLES.block())).offerTo(exporter, convertBetween(output_slab, SHINGLES.slab()));
                offerPolishedStoneRecipe(output, terracotta);
                offerStonecuttingRecipe(output, terracotta);
                offerStonecuttingRecipe(output_stairs, terracotta, output);
                offerStonecuttingRecipe(output_slab, 2, terracotta, output);
            }

            public void offerStairsRecipe(ItemConvertible output, ItemConvertible input) {
                createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }

            public void offerStainedBeveledGlassRecipe(ItemConvertible output, ItemConvertible output_pane, ItemConvertible input, ItemConvertible dye) {
                createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItems(input)).group("beveled_glass").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
                createEnclosedRecipe(output, Ingredient.ofItems(BEVELED_GLASS), dye).group("beveled_glass_2").criterion(hasItem(BEVELED_GLASS), conditionsFromItem(BEVELED_GLASS)).offerTo(exporter, convertBetween(output, BEVELED_GLASS));
                createShaped(RecipeCategory.BUILDING_BLOCKS, output_pane, 16).input('#', output).pattern("###").pattern("###").group("beveled_glass_pane").criterion(hasItem(BEVELED_GLASS_PANE), conditionsFromItem(output)).offerTo(exporter);
                createEnclosedRecipe(output_pane, Ingredient.ofItems(BEVELED_GLASS_PANE), dye).group("beveled_glass_pane_2").criterion(hasItem(BEVELED_GLASS_PANE), conditionsFromItem(BEVELED_GLASS_PANE)).offerTo(exporter, convertBetween(output, BEVELED_GLASS_PANE));
            }

            public void offerStainedRedstoneLampRecipe(ItemConvertible output, ItemConvertible dye, ItemConvertible output_lit) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output).input('S', dye).input('#', Blocks.REDSTONE_LAMP).pattern(" S ").pattern("S#S").pattern(" S ").group("redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, output_lit).input(output).input(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").criterion(hasItem(output), conditionsFromItem(output)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, output_lit).input('S', dye).input('#', REDSTONE_LAMP_LIT).pattern(" S ").pattern("S#S").pattern(" S ").group("lit_redstone_lamps").criterion(hasItem(Blocks.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP)).offerTo(exporter, getRecipeName(output) + "_alt");
            }

            public void offerNeonRecipe(ItemConvertible output, ItemConvertible dye) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 8).input('D', dye).input('S', Items.GLOW_INK_SAC).input('A', Items.AMETHYST_SHARD).pattern(" A ").pattern("SDS").pattern(" A ").group("neon_blocks").criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC)).offerTo(exporter);
            }

            public void offerFuturneoRecipe(ItemConvertible output, ItemConvertible glass) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 6).input('A', Items.BLACK_DYE).input('B', glass).input('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").criterion(hasItem(glass), conditionsFromItem(glass)).offerTo(exporter);

            }

            public void offerBoatsRecipe(ItemConvertible output1, ItemConvertible output2, ItemConvertible input) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output1).input('#', input).pattern("# #").pattern("###").group("boat").criterion("in_water", requireEnteringFluid(Blocks.WATER)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, output2).input(Blocks.CHEST).input(output1).group("chest_boat").criterion("has_boat", conditionsFromTag(ItemTags.BOATS)).offerTo(exporter);

            }

            public void offerPillarRecipe(ItemConvertible output, ItemConvertible input) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 2).input('#', input).pattern("#").pattern("#").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
                offerStonecuttingRecipe(output, 1, input);
            }

            public void offerBsswCuttingRecipe(BSSWBundle bsswBundle, ItemConvertible... ingredients) {
                // For block, stairs, slab and wall (if exists) in BsswBundle.
                if (ingredients != null) {
                    offerStonecuttingRecipe(bsswBundle.block(), ingredients);
                    offerStonecuttingRecipe(bsswBundle.stairs(), ingredients);
                    offerStonecuttingRecipe(bsswBundle.slab(), 2, ingredients);
                    if (bsswBundle.wall() != null) {
                        offerStonecuttingRecipe(bsswBundle.wall(), ingredients);
                    }
                }
                offerStonecuttingRecipe(bsswBundle.stairs(), bsswBundle.block());
                offerStonecuttingRecipe(bsswBundle.slab(), 2, bsswBundle.block());
                if (bsswBundle.wall() != null) {
                    offerStonecuttingRecipe(bsswBundle.wall(), bsswBundle.block());
                }
            }

            public void offerStonecuttingRecipe(ItemConvertible output, ItemConvertible... ingredients) {
                offerStonecuttingRecipe(output, 1, ingredients);
            }

            public void offerStonecuttingRecipe(ItemConvertible output, int count, ItemConvertible... ingredients) {

                for (ItemConvertible itemConvertible : ingredients) {
                    StonecuttingRecipeJsonBuilder var10000 = StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(itemConvertible), RecipeCategory.BUILDING_BLOCKS, output, count).criterion(hasItem(itemConvertible), conditionsFromItem(itemConvertible));
                    String var10002 = convertBetween(output, itemConvertible);
                    var10000.offerTo(exporter, var10002 + "_stonecutting");
                }
            }

            public void generateFamilies(FeatureSet enabledFeatures) {
                BlockusFamilies.getFamilies().filter(BlockFamily::shouldGenerateRecipes).forEach((family) -> {
                    generateFamily(family, enabledFeatures);
                });
            }
        };
    }

    @Override
    public String getName() {
        return "Blockus Recipes";
    }
}
