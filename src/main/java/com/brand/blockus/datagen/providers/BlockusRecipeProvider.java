package com.brand.blockus.datagen.providers;

import com.brand.blockus.datagen.family.BlockusFamilies;
import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.registry.tag.BlockusItemTags;
import com.brand.blockus.utils.ColorCollectionUtils;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;

import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;


public class BlockusRecipeProvider extends FabricRecipeProvider {
    public BlockusRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registriesFuture, RecipeOutput exporter) {
        return new RecipeProvider(registriesFuture, exporter) {
            @Override
            public void buildRecipes() {

                for (BSSWBundle bundle : BSSWBundle.values()) {
                    offerBlockStairsSlabRecipe(bundle.block(), bundle.stairs(), bundle.slab());
                    if (bundle.wall() != null) {
                        wall(RecipeCategory.DECORATIONS, bundle.wall(), bundle.block());
                    }
                }

                for (ColoredTilesBundle bundle : ColoredTilesBundle.values()) {
                    offerColoredTilesRecipe(bundle.block(), bundle.tile1(), bundle.tile2());
                }

                generateForEnabledBlockFamilies(FeatureFlagSet.of(FeatureFlags.VANILLA));

                offerPillarRecipe(MUD_BRICK_PILLAR, Blocks.MUD_BRICKS);
                offerStonecuttingRecipe(CHISELED_MUD_BRICKS, Blocks.MUD_BRICKS);

                // Stone
                offerBSSWCuttingRecipe(COBBLESTONE_BRICKS, Blocks.COBBLESTONE, Blocks.STONE);
                offerBSSWCuttingRecipe(MOSSY_COBBLESTONE_BRICKS, Blocks.MOSSY_COBBLESTONE);
                offerMossyRecipe(MOSSY_COBBLESTONE_BRICKS.block(), COBBLESTONE_BRICKS.block());
                offerBSSWCuttingRecipe(STONE_TILES, Blocks.STONE, Blocks.STONE_BRICKS);
                offerPolishedStoneRecipe(STONE_TILES.block(), Blocks.STONE_BRICKS);
                offerStonecuttingRecipe(STONE_BRICK_PILLAR, Blocks.STONE, Blocks.STONE_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_STONE_BRICKS, Blocks.STONE, Blocks.STONE_BRICKS);
                offerStonecuttingRecipe(STONE_CIRCULAR_PAVING, Blocks.STONE, Blocks.STONE_BRICKS);
                offerStonecuttingRecipe(SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
                offerStairsRecipe(SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
                offerSturdyRecipe(STURDY_STONE, Blocks.STONE, Blocks.COBBLESTONE);
                offerStoneDoorTrapdoorRecipe(STONE_DOOR, STONE_TRAPDOOR, Blocks.STONE, Blocks.STONE_SLAB);

                // Andesite
                offerBSSWCuttingRecipe(ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
                offerPolishedStoneRecipe(ANDESITE_BRICKS.block(), Blocks.POLISHED_ANDESITE);
                smeltingResultFromBase(CRACKED_ANDESITE_BRICKS, ANDESITE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_ANDESITE_PILLAR, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
                offerStonecuttingRecipe(ANDESITE_CIRCULAR_PAVING, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ANDESITE_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_ANDESITE_PRESSURE_PLATE, POLISHED_ANDESITE_BUTTON, Blocks.POLISHED_ANDESITE);

                // Diorite
                offerBSSWCuttingRecipe(DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
                offerPolishedStoneRecipe(DIORITE_BRICKS.block(), Blocks.POLISHED_DIORITE);
                smeltingResultFromBase(CRACKED_DIORITE_BRICKS, DIORITE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_DIORITE_PILLAR, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
                offerStonecuttingRecipe(DIORITE_CIRCULAR_PAVING, Blocks.DIORITE, Blocks.POLISHED_DIORITE, DIORITE_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_DIORITE_PRESSURE_PLATE, POLISHED_DIORITE_BUTTON, Blocks.POLISHED_DIORITE);

                // Granite
                offerBSSWCuttingRecipe(GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE);
                offerPolishedStoneRecipe(GRANITE_BRICKS.block(), Blocks.POLISHED_GRANITE);
                smeltingResultFromBase(CRACKED_GRANITE_BRICKS, GRANITE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_GRANITE_PILLAR, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
                offerStonecuttingRecipe(GRANITE_CIRCULAR_PAVING, Blocks.GRANITE, Blocks.POLISHED_GRANITE, GRANITE_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_GRANITE_PRESSURE_PLATE, POLISHED_GRANITE_BUTTON, Blocks.POLISHED_GRANITE);

                // Dripstone
                offerBSSWCuttingRecipe(POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
                offerPolishedStoneRecipe(POLISHED_DRIPSTONE.block(), Blocks.DRIPSTONE_BLOCK);
                offerBSSWCuttingRecipe(DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block());
                offerPolishedStoneRecipe(DRIPSTONE_BRICKS.block(), POLISHED_DRIPSTONE.block());
                offerMossyRecipe(MOSSY_DRIPSTONE_BRICKS.block(), DRIPSTONE_BRICKS.block());
                offerBSSWCuttingRecipe(MOSSY_DRIPSTONE_BRICKS);
                smeltingResultFromBase(CRACKED_DRIPSTONE_BRICKS, DRIPSTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block(), DRIPSTONE_BRICKS.block());
                offerStonecuttingRecipe(DRIPSTONE_PILLAR, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block(), DRIPSTONE_BRICKS.block());

                // Tuff
                offerBSSWCuttingRecipe(TUFF_TILES, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerPolishedStoneRecipe(TUFF_TILES.block(), Blocks.TUFF_BRICKS);
                smeltingResultFromBase(CRACKED_TUFF_BRICKS, Blocks.TUFF_BRICKS);
                offerMossyRecipe(MOSSY_TUFF_BRICKS.block(), Blocks.TUFF_BRICKS);
                offerBSSWCuttingRecipe(MOSSY_TUFF_BRICKS);
                offerStonecuttingRecipe(CARVED_TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerStonecuttingRecipe(TUFF_PILLAR, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerStonecuttingRecipe(TUFF_CIRCULAR_PAVING, Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                offerPressurePlateButtonRecipe(POLISHED_TUFF_PRESSURE_PLATE, POLISHED_TUFF_BUTTON, Blocks.POLISHED_TUFF);

                // Amethyst
                offerBSSWCuttingRecipe(POLISHED_AMETHYST, Blocks.AMETHYST_BLOCK);
                offerPolishedStoneRecipe(POLISHED_AMETHYST.block(), Blocks.AMETHYST_BLOCK);
                offerBSSWCuttingRecipe(AMETHYST_BRICKS, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block());
                offerPolishedStoneRecipe(AMETHYST_BRICKS.block(), POLISHED_AMETHYST.block());
                offerStonecuttingRecipe(CHISELED_AMETHYST, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block(), AMETHYST_BRICKS.block());
                offerStonecuttingRecipe(AMETHYST_PILLAR, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block(), AMETHYST_BRICKS.block());
                shaped(RecipeCategory.BUILDING_BLOCKS, AMETHYST_LAMP).define('#', Items.AMETHYST_SHARD).define('X', Items.REDSTONE).pattern(" # ").pattern("#X#").pattern(" # ").unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(exporter);

                // Deepslate
                offerBSSWCuttingRecipe(COBBLED_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE);
                offerMossyRecipe(MOSSY_DEEPSLATE_BRICKS.block(), Blocks.DEEPSLATE_BRICKS);
                offerBSSWCuttingRecipe(MOSSY_DEEPSLATE_BRICKS);
                offerStonecuttingRecipe(DEEPSLATE_PILLAR, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
                offerStonecuttingRecipe(DEEPSLATE_CIRCULAR_PAVING, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
                offerSturdyRecipe(STURDY_DEEPSLATE, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
                offerPressurePlateButtonRecipe(POLISHED_DEEPSLATE_PRESSURE_PLATE, POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);

                // Sculk
                offerBSSWCuttingRecipe(POLISHED_SCULK, Blocks.SCULK);
                offerPolishedStoneRecipe(POLISHED_SCULK.block(), Blocks.SCULK);
                offerBSSWCuttingRecipe(SCULK_BRICKS, Blocks.SCULK, POLISHED_SCULK.block());
                offerStonecuttingRecipe(CHISELED_SCULK_BRICKS, Blocks.SCULK, POLISHED_SCULK.block(), SCULK_BRICKS.block());
                offerStonecuttingRecipe(SCULK_PILLAR, Blocks.SCULK, POLISHED_SCULK.block(), SCULK_BRICKS.block());
                offerPolishedStoneRecipe(SCULK_BRICKS.block(), POLISHED_SCULK.block());
                offerPressurePlateButtonRecipe(POLISHED_SCULK_PRESSURE_PLATE, POLISHED_SCULK_BUTTON, POLISHED_SCULK.block());

                // Blackstone
                offerBSSWCuttingRecipe(POLISHED_BLACKSTONE_TILES, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
                offerPolishedStoneRecipe(POLISHED_BLACKSTONE_TILES.block(), Blocks.POLISHED_BLACKSTONE_BRICKS);
                offerStonecuttingRecipe(POLISHED_BLACKSTONE_PILLAR, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
                offerStonecuttingRecipe(POLISHED_BLACKSTONE_CIRCULAR_PAVING, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
                shapeless(RecipeCategory.BUILDING_BLOCKS, CRIMSON_WARTY_BLACKSTONE_BRICKS.block()).requires(Blocks.POLISHED_BLACKSTONE_BRICKS).requires(Blocks.CRIMSON_ROOTS).unlockedBy("has_roots", has(Blocks.CRIMSON_ROOTS)).save(exporter);
                offerBSSWCuttingRecipe(CRIMSON_WARTY_BLACKSTONE_BRICKS);
                shapeless(RecipeCategory.BUILDING_BLOCKS, WARPED_WARTY_BLACKSTONE_BRICKS.block()).requires(Blocks.POLISHED_BLACKSTONE_BRICKS).requires(BlockusItemTags.WARPED_NETHER_GRASS).unlockedBy("has_roots", has(BlockusItemTags.WARPED_NETHER_GRASS)).save(exporter);
                offerBSSWCuttingRecipe(WARPED_WARTY_BLACKSTONE_BRICKS);
                offerSturdyRecipe(STURDY_BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
                offerDecoratedRecipe(GOLD_DECORATED_POLISHED_BLACKSTONE, Items.GOLD_INGOT, Blocks.POLISHED_BLACKSTONE);
                offerStoneDoorTrapdoorRecipe(BLACKSTONE_DOOR, BLACKSTONE_TRAPDOOR, Blocks.BLACKSTONE, Blocks.BLACKSTONE_SLAB);

                // Basalt
                offerBSSWCuttingRecipe(ROUGH_BASALT);
                shaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_BASALT.block(), 2).define('#', Blocks.BASALT).pattern("#").pattern("#").unlockedBy("has_basalt", has(Blocks.BASALT)).save(exporter);
                offerBSSWCuttingRecipe(POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT);
                offerPolishedStoneRecipe(POLISHED_BASALT_BRICKS.block(), Blocks.POLISHED_BASALT);
                smeltingResultFromBase(CRACKED_POLISHED_BASALT_BRICKS, POLISHED_BASALT_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_POLISHED_BASALT, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_BASALT_PILLAR, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
                offerStonecuttingRecipe(POLISHED_BASALT_CIRCULAR_PAVING, Blocks.BASALT, Blocks.POLISHED_BASALT, POLISHED_BASALT_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_BASALT_PRESSURE_PLATE, POLISHED_BASALT_BUTTON, Blocks.POLISHED_BASALT);

                // Wart Blocks
                offerBSSWCuttingRecipe(CRIMSON_WART_BRICKS, Blocks.NETHER_WART_BLOCK);
                offerPolishedStoneRecipe(CRIMSON_WART_BRICKS.block(), Blocks.NETHER_WART_BLOCK);
                offerBSSWCuttingRecipe(WARPED_WART_BRICKS, Blocks.WARPED_WART_BLOCK);
                offerPolishedStoneRecipe(WARPED_WART_BRICKS.block(), Blocks.WARPED_WART_BLOCK);

                // Limestone
                offerBSSWCuttingRecipe(LIMESTONE);
                shaped(RecipeCategory.BUILDING_BLOCKS, LIMESTONE.block()).define('#', Blocks.COBBLESTONE).define('X', Items.BONE_MEAL).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE)).save(exporter);
                offerBSSWCuttingRecipe(POLISHED_LIMESTONE, LIMESTONE.block());
                offerPolishedStoneRecipe(POLISHED_LIMESTONE.block(), LIMESTONE.block());
                offerBSSWCuttingRecipe(LIMESTONE_BRICKS, LIMESTONE.block(), POLISHED_LIMESTONE.block());
                offerPolishedStoneRecipe(LIMESTONE_BRICKS.block(), POLISHED_LIMESTONE.block());
                offerBSSWCuttingRecipe(SMALL_LIMESTONE_BRICKS, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
                offerBSSWCuttingRecipe(LIMESTONE_TILES, LIMESTONE.block(), POLISHED_LIMESTONE.block(), LIMESTONE_BRICKS.block());
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
                offerBSSWCuttingRecipe(MARBLE);
                shaped(RecipeCategory.BUILDING_BLOCKS, MARBLE.block()).define('#', LIMESTONE.block()).define('X', Items.BONE_MEAL).pattern("#X").pattern("X#").group("marble").unlockedBy(getHasName(LIMESTONE.block()), has(LIMESTONE.block())).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, MARBLE.block()).requires(Blocks.CALCITE).requires(LIMESTONE.block()).group("marble").unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(exporter, getConversionRecipeName(MARBLE.block(), Blocks.CALCITE));
                offerBSSWCuttingRecipe(POLISHED_MARBLE, MARBLE.block());
                offerPolishedStoneRecipe(POLISHED_MARBLE.block(), MARBLE.block());
                offerBSSWCuttingRecipe(MARBLE_BRICKS, MARBLE.block(), POLISHED_MARBLE.block());
                offerPolishedStoneRecipe(MARBLE_BRICKS.block(), POLISHED_MARBLE.block());
                offerBSSWCuttingRecipe(SMALL_MARBLE_BRICKS, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
                offerBSSWCuttingRecipe(MARBLE_TILES, MARBLE.block(), POLISHED_MARBLE.block(), MARBLE_BRICKS.block());
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
                offerBSSWCuttingRecipe(BLUESTONE);
                shaped(RecipeCategory.BUILDING_BLOCKS, BLUESTONE.block(), 4).define('S', Blocks.STONE).define('#', Items.DYE.blue()).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Items.DYE.blue()), has(Items.DYE.blue())).unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE)).save(exporter);
                offerBSSWCuttingRecipe(POLISHED_BLUESTONE, BLUESTONE.block());
                offerPolishedStoneRecipe(POLISHED_BLUESTONE.block(), BLUESTONE.block());
                offerBSSWCuttingRecipe(BLUESTONE_BRICKS, BLUESTONE.block(), POLISHED_BLUESTONE.block());
                offerPolishedStoneRecipe(BLUESTONE_BRICKS.block(), POLISHED_BLUESTONE.block());
                offerBSSWCuttingRecipe(SMALL_BLUESTONE_BRICKS, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
                offerBSSWCuttingRecipe(BLUESTONE_TILES, BLUESTONE.block(), POLISHED_BLUESTONE.block(), BLUESTONE_BRICKS.block());
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
                offerBSSWCuttingRecipe(VIRIDITE);
                shaped(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block(), 4).define('S', Blocks.DEEPSLATE).define('#', Blocks.SCULK).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Blocks.SCULK), has(Blocks.SCULK)).unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block(), 4).define('S', Blocks.DEEPSLATE).define('#', Items.DYE.green()).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Items.DYE.green()), has(Items.DYE.green())).unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE)).save(exporter, getConversionRecipeName(VIRIDITE.block(), Items.DYE.green()));
                offerBSSWCuttingRecipe(POLISHED_VIRIDITE, VIRIDITE.block());
                offerPolishedStoneRecipe(POLISHED_VIRIDITE.block(), VIRIDITE.block());
                offerBSSWCuttingRecipe(VIRIDITE_BRICKS, VIRIDITE.block(), POLISHED_VIRIDITE.block());
                offerPolishedStoneRecipe(VIRIDITE_BRICKS.block(), POLISHED_VIRIDITE.block());
                offerBSSWCuttingRecipe(SMALL_VIRIDITE_BRICKS, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
                offerBSSWCuttingRecipe(VIRIDITE_TILES, VIRIDITE.block(), POLISHED_VIRIDITE.block(), VIRIDITE_BRICKS.block());
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
                offerBSSWCuttingRecipe(LAVA_BRICKS);
                offerStonecuttingRecipe(CHISELED_LAVA_BRICKS, LAVA_BRICKS.block());
                createEnclosedRecipe(LAVA_BRICKS.block(), Ingredient.of(Blocks.STONE_BRICKS), Items.LAVA_BUCKET).unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET)).unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter);

                // Lava Blackstone Bricks
                offerBSSWCuttingRecipe(LAVA_POLISHED_BLACKSTONE_BRICKS);
                offerStonecuttingRecipe(CHISELED_LAVA_POLISHED_BLACKSTONE, LAVA_POLISHED_BLACKSTONE_BRICKS.block());
                createEnclosedRecipe(LAVA_POLISHED_BLACKSTONE_BRICKS.block(), Ingredient.of(Blocks.POLISHED_BLACKSTONE_BRICKS), Items.LAVA_BUCKET).unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET)).unlockedBy(getHasName(Blocks.POLISHED_BLACKSTONE_BRICKS), has(Blocks.POLISHED_BLACKSTONE_BRICKS)).save(exporter);

                // Water Bricks
                offerBSSWCuttingRecipe(WATER_BRICKS);
                offerStonecuttingRecipe(CHISELED_WATER_BRICKS, WATER_BRICKS.block());
                createEnclosedRecipe(WATER_BRICKS.block(), Ingredient.of(Blocks.STONE_BRICKS), Items.WATER_BUCKET).unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET)).unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter);

                // Snow Bricks
                offerBSSWCuttingRecipe(SNOW_BRICKS);
                offerStonecuttingRecipe(SNOW_PILLAR, SNOW_BRICKS.block());
                offerPolishedStoneRecipe(SNOW_BRICKS.block(), Blocks.SNOW_BLOCK);

                // Ice Bricks
                offerStonecuttingRecipe(ICE_BRICK_WALL, ICE_BRICKS);
                offerStonecuttingRecipe(ICE_PILLAR, ICE_BRICKS);
                shaped(RecipeCategory.BUILDING_BLOCKS, ICE_BRICKS, 4).define('#', BlockusItemTags.NATURAL_ICE).pattern("##").pattern("##").unlockedBy("has_ice", has(BlockusItemTags.NATURAL_ICE)).save(exporter);
                wall(RecipeCategory.BUILDING_BLOCKS, ICE_BRICK_WALL, ICE_BRICKS);

                // Magma Bricks
                offerBSSWCuttingRecipe(MAGMA_BRICKS, Blocks.MAGMA_BLOCK);
                offerPolishedStoneRecipe(MAGMA_BRICKS.block(), Blocks.MAGMA_BLOCK);
                offerBSSWCuttingRecipe(SMALL_MAGMA_BRICKS, Blocks.MAGMA_BLOCK, MAGMA_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_MAGMA_BRICKS, Blocks.MAGMA_BLOCK, MAGMA_BRICKS.block());

                // Blaze Bricks
                offerBSSWCuttingRecipe(BLAZE_BRICKS);
                offerStonecuttingRecipe(BLAZE_PILLAR, BLAZE_BRICKS.block());
                shaped(RecipeCategory.BUILDING_BLOCKS, BLAZE_BRICKS.block()).define('#', Items.BLAZE_POWDER).define('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").unlockedBy("has_blaze_rod", has(Items.BLAZE_ROD)).save(exporter);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.BLAZE_POWDER, RecipeCategory.BUILDING_BLOCKS, BLAZE_LANTERN);

                // Netherrack
                offerBSSWCuttingRecipe(POLISHED_NETHERRACK, Blocks.NETHERRACK);
                offerPolishedStoneRecipe(POLISHED_NETHERRACK.block(), Blocks.NETHERRACK);
                offerBSSWCuttingRecipe(NETHERRACK_BRICKS, Blocks.NETHERRACK, POLISHED_NETHERRACK.block());
                offerStonecuttingRecipe(NETHERRACK_CIRCULAR_PAVING, Blocks.NETHERRACK, POLISHED_NETHERRACK.block(), NETHERRACK_BRICKS.block());
                offerPressurePlateButtonRecipe(POLISHED_NETHERRACK_PRESSURE_PLATE, POLISHED_NETHERRACK_BUTTON, POLISHED_NETHERRACK.block());

                // Nether Bricks
                offerBSSWCuttingRecipe(POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
                offerPolishedStoneRecipe(POLISHED_NETHER_BRICKS.block(), Blocks.NETHER_BRICKS);
                offerStonecuttingRecipe(NETHER_BRICK_PILLAR, Blocks.NETHER_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_NETHER_BRICKS, Blocks.NETHER_BRICKS);

                offerBSSWCuttingRecipe(POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
                offerPolishedStoneRecipe(POLISHED_RED_NETHER_BRICKS.block(), Blocks.RED_NETHER_BRICKS);
                offerStonecuttingRecipe(RED_NETHER_BRICK_PILLAR, Blocks.RED_NETHER_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);

                offerBSSWCuttingRecipe(NETHER_TILES);
                shaped(RecipeCategory.BUILDING_BLOCKS, NETHER_TILES.block(), 4).define('#', Blocks.NETHERRACK).define('X', Blocks.NETHER_BRICKS).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.NETHER_BRICKS), has(Blocks.NETHER_BRICKS)).save(exporter);

                // Charred Nether Bricks
                offerBSSWCuttingRecipe(CHARRED_NETHER_BRICKS);
                offerBSSWCuttingRecipe(POLISHED_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block());
                offerPolishedStoneRecipe(POLISHED_CHARRED_NETHER_BRICKS.block(), CHARRED_NETHER_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block());
                offerStonecuttingRecipe(CHARRED_NETHER_BRICK_PILLAR, CHARRED_NETHER_BRICKS.block());
                createEnclosedRecipe(CHARRED_NETHER_BRICKS.block(), Ingredient.of(Blocks.NETHER_BRICKS), Items.FIRE_CHARGE).unlockedBy(getHasName(Items.FIRE_CHARGE), has(Items.FIRE_CHARGE)).unlockedBy(getHasName(Blocks.NETHER_BRICKS), has(Blocks.NETHER_BRICKS)).save(exporter);

                // Teal Nether Bricks
                offerBSSWCuttingRecipe(TEAL_NETHER_BRICKS);
                offerBSSWCuttingRecipe(POLISHED_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block());
                offerPolishedStoneRecipe(POLISHED_TEAL_NETHER_BRICKS.block(), TEAL_NETHER_BRICKS.block());
                offerStonecuttingRecipe(HERRINGBONE_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block());
                offerStonecuttingRecipe(TEAL_NETHER_BRICK_PILLAR, TEAL_NETHER_BRICKS.block());
                shaped(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block()).define('#', BlockusItemTags.WARPED_NETHER_GRASS).define('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").group("teal_nether_bricks").unlockedBy("has_warped_grass", has(BlockusItemTags.WARPED_NETHER_GRASS)).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block(), 2).requires(Blocks.WARPED_WART_BLOCK).requires(Items.NETHER_BRICKS).group("teal_nether_bricks").unlockedBy(getHasName(Blocks.WARPED_WART_BLOCK), has(Blocks.WARPED_WART_BLOCK)).save(exporter, getConversionRecipeName(TEAL_NETHER_BRICKS.block(), Blocks.WARPED_WART_BLOCK));

                // Obsidian
                offerBSSWCuttingRecipe(OBSIDIAN_BRICKS, Blocks.OBSIDIAN);
                offerPolishedStoneRecipe(OBSIDIAN_BRICKS.block(), Blocks.OBSIDIAN);
                smeltingResultFromBase(CRACKED_OBSIDIAN_BRICKS, OBSIDIAN_BRICKS.block());
                offerBSSWCuttingRecipe(SMALL_OBSIDIAN_BRICKS, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block());
                offerStonecuttingRecipe(OBSIDIAN_PILLAR, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block());
                offerStonecuttingRecipe(OBSIDIAN_CIRCULAR_PAVING, Blocks.OBSIDIAN, OBSIDIAN_BRICKS.block());
                offerDoorTrapdoorRecipe(OBSIDIAN_REINFORCED_DOOR, OBSIDIAN_REINFORCED_TRAPDOOR, Blocks.OBSIDIAN);
                pressurePlate(OBSIDIAN_PRESSURE_PLATE, Blocks.OBSIDIAN);
                shaped(RecipeCategory.BUILDING_BLOCKS, GLOWING_OBSIDIAN, 4).define('S', Blocks.OBSIDIAN).define('#', Blocks.SHROOMLIGHT).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Blocks.SHROOMLIGHT), has(Blocks.SHROOMLIGHT)).save(exporter);

                // Ore Bricks
                offerOreBricksRecipe(IRON_BRICKS, Blocks.IRON_BLOCK, Items.IRON_INGOT);
                offerOreBricksRecipe(GOLD_BRICKS, Blocks.GOLD_BLOCK, Items.GOLD_INGOT);
                offerOreBricksRecipe(LAPIS_BRICKS, Blocks.LAPIS_BLOCK, Items.LAPIS_LAZULI);
                offerOreBricksRecipe(REDSTONE_BRICKS, Blocks.REDSTONE_BLOCK, Items.REDSTONE);
                offerOreBricksRecipe(EMERALD_BRICKS, Blocks.EMERALD_BLOCK, Items.EMERALD);
                offerOreBricksRecipe(DIAMOND_BRICKS, Blocks.DIAMOND_BLOCK, Items.DIAMOND);
                offerOreBricksRecipe(NETHERITE_BRICKS, Blocks.NETHERITE_BLOCK, Items.NETHERITE_INGOT);

                // Copper
                offerCopperBricksRecipe();
                for (CopperBSSWBundle bundle : CopperBSSWBundle.values()) {
                    for (WeatheringCopper.WeatherState state : WeatheringCopper.WeatherState.values()) {
                        offerWaxingRecipes(bundle.block().pick(state, false), bundle.block().pick(state, true));
                        offerWaxingRecipes(bundle.slab().pick(state, false), bundle.slab().pick(state, true));
                        offerWaxingRecipes(bundle.stairs().pick(state, false), bundle.stairs().pick(state, true));
                        offerWaxingRecipes(bundle.wall().pick(state, false), bundle.wall().pick(state, true));
                    }
                }
                shaped(RecipeCategory.BUILDING_BLOCKS, COPPER_TUFF_BRICKS.block().unaffected(), 2).define('#', Items.COPPER_INGOT).define('X', Blocks.TUFF_BRICKS).pattern("#X").pattern("X#").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).unlockedBy(getHasName(Blocks.TUFF_BRICKS), has(Blocks.TUFF_BRICKS)).save(exporter);

                // Quartz Blocks
                offerBSSWCuttingRecipe(QUARTZ_TILES, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);
                offerPolishedStoneRecipe(QUARTZ_TILES.block(), Blocks.QUARTZ_BRICKS);
                offerStonecuttingRecipe(QUARTZ_CIRCULAR_PAVING, Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);

                // Prismarine
                offerStonecuttingRecipe(CHISELED_PRISMARINE, Blocks.PRISMARINE_BRICKS);
                offerStonecuttingRecipe(PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS);
                offerStonecuttingRecipe(PRISMARINE_CIRCULAR_PAVING, Blocks.PRISMARINE_BRICKS);
                offerStonecuttingRecipe(CHISELED_DARK_PRISMARINE, Blocks.DARK_PRISMARINE);
                offerStonecuttingRecipe(DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE);
                offerBSSWCuttingRecipe(PRISMARINE_TILES);
                shaped(RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILES.block(), 4).define('#', Blocks.DARK_PRISMARINE).define('X', Items.PRISMARINE_SHARD).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.DARK_PRISMARINE), has(Blocks.DARK_PRISMARINE)).save(exporter);

                // Bricks
                offerBSSWCuttingRecipe(LARGE_BRICKS, Blocks.BRICKS);
                offerPolishedStoneRecipe(LARGE_BRICKS.block(), Blocks.BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_BRICKS, Blocks.BRICKS);

                // Soaked Bricks
                offerBSSWCuttingRecipe(SOAKED_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_SOAKED_BRICKS, SOAKED_BRICKS.block());
                createEnclosedRecipe(SOAKED_BRICKS.block(), Ingredient.of(Blocks.BRICKS), Items.WATER_BUCKET).unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET)).unlockedBy(getHasName(Blocks.BRICKS), has(Blocks.BRICKS)).save(exporter);

                // Sandy Bricks
                offerBSSWCuttingRecipe(SANDY_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_SANDY_BRICKS, SANDY_BRICKS.block());
                shaped(RecipeCategory.BUILDING_BLOCKS, SANDY_BRICKS.block(), 2).define('S', Blocks.SAND).define('#', Blocks.BRICKS).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy("has_sand", has(Blocks.SAND)).unlockedBy("has_bricks", has(Blocks.BRICKS)).save(exporter);

                // Charred Bricks
                offerBSSWCuttingRecipe(CHARRED_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_CHARRED_BRICKS, CHARRED_BRICKS.block());
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, CHARRED_BRICKS.block().asItem(), 0.1F, 200).unlockedBy("has_bricks", has(Blocks.BRICKS)).save(exporter);

                // Resin Bricks
                offerBSSWCuttingRecipe(LARGE_RESIN_BRICKS, Blocks.RESIN_BRICKS);
                offerPolishedStoneRecipe(LARGE_RESIN_BRICKS.block(), Blocks.RESIN_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_RESIN_BRICKS, Blocks.RESIN_BRICKS);
                offerStonecuttingRecipe(RESIN_BRICK_PILLAR, Blocks.RESIN_BRICKS);

                // Sandstone
                offerBSSWCuttingRecipe(ROUGH_SANDSTONE);
                shaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_SANDSTONE.block(), 2).define('#', Blocks.SANDSTONE_SLAB).pattern("##").pattern("##").unlockedBy("has_sandstone", has(Blocks.SANDSTONE)).save(exporter);
                offerBSSWCuttingRecipe(SANDSTONE_BRICKS, Blocks.SANDSTONE);
                offerBSSWCuttingRecipe(SMALL_SANDSTONE_BRICKS, Blocks.SANDSTONE, SANDSTONE_BRICKS.block());
                offerStonecuttingRecipe(SANDSTONE_PILLAR, Blocks.SANDSTONE, SANDSTONE_BRICKS.block());
                offerDecoratedRecipe(GOLD_DECORATED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_SANDSTONE);
                offerDecoratedRecipe(LAPIS_DECORATED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_SANDSTONE);

                // Red Sandstone
                offerBSSWCuttingRecipe(ROUGH_RED_SANDSTONE);
                shaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_RED_SANDSTONE.block(), 2).define('#', Blocks.RED_SANDSTONE_SLAB).pattern("##").pattern("##").unlockedBy("has_red_sandstone", has(Blocks.RED_SANDSTONE)).save(exporter);
                offerBSSWCuttingRecipe(RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE);
                offerBSSWCuttingRecipe(SMALL_RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block());
                offerStonecuttingRecipe(RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block());
                offerDecoratedRecipe(GOLD_DECORATED_RED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_RED_SANDSTONE);
                offerDecoratedRecipe(LAPIS_DECORATED_RED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_RED_SANDSTONE);

                // Soul Sandstone
                offerBSSWCuttingRecipe(SOUL_SANDSTONE);
                shaped(RecipeCategory.BUILDING_BLOCKS, SOUL_SANDSTONE.block()).define('#', BlockusItemTags.SOUL_SOILS).pattern("##").pattern("##").unlockedBy("has_soul_sand", has(BlockusItemTags.SOUL_SOILS)).save(exporter);
                offerBSSWCuttingRecipe(SMOOTH_SOUL_SANDSTONE);
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(SOUL_SANDSTONE.block()), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, SMOOTH_SOUL_SANDSTONE.block().asItem(), 0.1F, 200).unlockedBy("has_soul_sandstone", has(SOUL_SANDSTONE.block())).save(exporter);
                offerPolishedStoneRecipe(CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
                offerStonecuttingRecipe(CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
                offerStonecuttingRecipe(CUT_SOUL_SANDSTONE_SLAB, 2, SOUL_SANDSTONE.block(), CUT_SOUL_SANDSTONE);
                slab(RecipeCategory.BUILDING_BLOCKS, CUT_SOUL_SANDSTONE_SLAB, CUT_SOUL_SANDSTONE);

                offerBSSWCuttingRecipe(ROUGH_SOUL_SANDSTONE);
                shaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_SOUL_SANDSTONE.block(), 2).define('#', SOUL_SANDSTONE.slab()).pattern("##").pattern("##").unlockedBy("has_soul_sandstone", has(SOUL_SANDSTONE.block())).save(exporter);
                offerBSSWCuttingRecipe(SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block());
                offerBSSWCuttingRecipe(SMALL_SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block(), SOUL_SANDSTONE_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
                offerPolishedStoneRecipe(CHISELED_SOUL_SANDSTONE, CUT_SOUL_SANDSTONE);
                offerStonecuttingRecipe(SOUL_SANDSTONE_PILLAR, SOUL_SANDSTONE.block(), SOUL_SANDSTONE_BRICKS.block());
                offerDecoratedRecipe(GOLD_DECORATED_SOUL_SANDSTONE, Items.GOLD_INGOT, CUT_SOUL_SANDSTONE);
                offerDecoratedRecipe(LAPIS_DECORATED_SOUL_SANDSTONE, Items.LAPIS_LAZULI, CUT_SOUL_SANDSTONE);

                // Honeycomb Bricks
                offerBSSWCuttingRecipe(HONEYCOMB_BRICKS, Blocks.HONEYCOMB_BLOCK);
                offerPolishedStoneRecipe(HONEYCOMB_BRICKS.block(), Blocks.HONEYCOMB_BLOCK);

                // Purpur Blocks
                offerBSSWCuttingRecipe(POLISHED_PURPUR, Blocks.PURPUR_BLOCK);
                offerPolishedStoneRecipe(POLISHED_PURPUR.block(), Blocks.PURPUR_BLOCK);
                offerBSSWCuttingRecipe(PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block());
                offerBSSWCuttingRecipe(SMALL_PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_PURPUR, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                offerStonecuttingRecipe(Blocks.PURPUR_PILLAR, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                offerStonecuttingRecipe(PURPUR_SQUARES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                offerStonecuttingRecipe(PURPUR_LINES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());

                // Phantom Purpur Blocks
                offerBSSWCuttingRecipe(PHANTOM_PURPUR_BLOCK);
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_BLOCK.block(), Blocks.PURPUR_BLOCK);
                offerPolishedStoneRecipe(POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BLOCK.block());
                offerBSSWCuttingRecipe(POLISHED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.block());
                offerPhantomPurpurRecipe(POLISHED_PHANTOM_PURPUR.block(), POLISHED_PURPUR.block());
                offerBSSWCuttingRecipe(PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block());
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_BRICKS.block(), PURPUR_BRICKS.block());
                offerPolishedStoneRecipe(PHANTOM_PURPUR_BRICKS.block(), POLISHED_PHANTOM_PURPUR.block());
                offerBSSWCuttingRecipe(SMALL_PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(SMALL_PHANTOM_PURPUR_BRICKS.block(), PHANTOM_PURPUR_BRICKS.block());
                offerStonecuttingRecipe(CHISELED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(CHISELED_PHANTOM_PURPUR, CHISELED_PURPUR);
                offerStonecuttingRecipe(PHANTOM_PURPUR_PILLAR, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_PILLAR, Blocks.PURPUR_PILLAR);
                shaped(RecipeCategory.BUILDING_BLOCKS, PHANTOM_PURPUR_PILLAR).define('#', PHANTOM_PURPUR_BLOCK.slab()).pattern("#").pattern("#").unlockedBy("has_phantom_purpur_block", has(PHANTOM_PURPUR_BLOCK.block())).save(exporter);
                offerStonecuttingRecipe(PHANTOM_PURPUR_SQUARES, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_SQUARES, PURPUR_SQUARES);
                offerStonecuttingRecipe(PHANTOM_PURPUR_LINES, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_LINES, PURPUR_LINES);

                // End Stone
                offerBSSWCuttingRecipe(POLISHED_END_STONE, Blocks.END_STONE);
                offerPolishedStoneRecipe(POLISHED_END_STONE.block(), Blocks.END_STONE);
                offerStonecuttingRecipe(Blocks.END_STONE_BRICKS, POLISHED_END_STONE.block());
                offerStonecuttingRecipe(Blocks.END_STONE_BRICK_STAIRS, POLISHED_END_STONE.block());
                offerStonecuttingRecipe(Blocks.END_STONE_BRICK_SLAB, 2, POLISHED_END_STONE.block());
                offerStonecuttingRecipe(Blocks.END_STONE_BRICK_WALL, POLISHED_END_STONE.block());
                smeltingResultFromBase(CRACKED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);
                offerBSSWCuttingRecipe(SMALL_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
                offerStonecuttingRecipe(CHISELED_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
                offerStonecuttingRecipe(END_STONE_PILLAR, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
                offerStonecuttingRecipe(HERRINGBONE_END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block(), Blocks.END_STONE_BRICKS);
                offerDecoratedRecipe(PURPUR_DECORATED_END_STONE, Items.POPPED_CHORUS_FRUIT, Blocks.END_STONE_BRICKS);
                offerPhantomPurpurRecipe(PHANTOM_PURPUR_DECORATED_END_STONE, PURPUR_DECORATED_END_STONE);
                offerBSSWCuttingRecipe(END_TILES);
                shaped(RecipeCategory.BUILDING_BLOCKS, END_TILES.block(), 4).define('#', Blocks.END_STONE).define('X', Blocks.PURPUR_BLOCK).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.PURPUR_BLOCK), has(Blocks.PURPUR_BLOCK)).save(exporter);
                offerPressurePlateButtonRecipe(POLISHED_END_STONE_PRESSURE_PLATE, POLISHED_END_STONE_BUTTON, POLISHED_END_STONE.block());

                // Wood
                hangingSign(WHITE_OAK.hangingSign(), STRIPPED_WHITE_OAK_LOG);
                shelf(WHITE_OAK.shelf(), STRIPPED_WHITE_OAK_LOG);
                woodFromLogs(WHITE_OAK_WOOD, WHITE_OAK_LOG);
                planksFromLogs(WHITE_OAK.planks(), BlockusItemTags.WHITE_OAK_LOGS, 4);

                hangingSign(RAW_BAMBOO.hangingSign(), Blocks.BAMBOO_BLOCK);
                shelf(RAW_BAMBOO.shelf(), Blocks.BAMBOO_BLOCK);

                shaped(RecipeCategory.DECORATIONS, CHARRED.hangingSign(), 2).group("hanging_sign").define('#', CHARRED.planks()).define('X', Items.IRON_CHAIN).pattern("X X").pattern("###").pattern("###").unlockedBy(getHasName(CHARRED.planks()), has(CHARRED.planks())).save(exporter);
                shaped(RecipeCategory.DECORATIONS, CHARRED.shelf(), 2).group("shelf").define('#', CHARRED.planks()).pattern("###").pattern("   ").pattern("###").unlockedBy(getHasName(CHARRED.planks()), has(CHARRED.planks())).save(exporter);
                offerCharredSmeltingRecipe(BlockusItemTags.SHELVES_THAT_BURN, RecipeCategory.DECORATIONS, CHARRED.shelf(), "shelves");

                shapeless(RecipeCategory.BUILDING_BLOCKS, RAW_BAMBOO.planks(), 2).requires(Blocks.BAMBOO_BLOCK).group("planks").unlockedBy("has_log", has(Blocks.BAMBOO_BLOCK)).save(exporter);
                offerBoatsRecipe(BlockusItems.WHITE_OAK_BOAT, BlockusItems.WHITE_OAK_CHEST_BOAT, WHITE_OAK.planks());
                offerBoatsRecipe(BlockusItems.RAW_BAMBOO_RAFT, BlockusItems.RAW_BAMBOO_CHEST_RAFT, RAW_BAMBOO.planks());
                offerBoatsRecipe(BlockusItems.CHARRED_BOAT, BlockusItems.CHARRED_CHEST_BOAT, CHARRED.planks());
                SimpleCookingRecipeBuilder.smelting(tag(BlockusItemTags.PLANKS_THAT_BURN), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, CHARRED.planks(), 0.1F, 200).unlockedBy("has_planks", has(BlockusItemTags.PLANKS_THAT_BURN)).save(exporter);

                for (var entry : SMALL_LOGS.bundle().entrySet()) {
                    offerSmallLogsRecipe(entry.getValue(), WoodMaps.LOG_MAP.get(entry.getKey()));
                }

                for (WoodenPostBundle bundle : WoodenPostBundle.values()) {
                    for (var entry : bundle.woodMap().entrySet()) {
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
                    mosaicBuilder(RecipeCategory.DECORATIONS, entry.getValue().block(), WoodMaps.SLAB_MAP.get(entry.getKey()));
                }
                offerCharredSmeltingRecipe(BlockusItemTags.WOODEN_MOSAIC_THAT_BURN, RecipeCategory.BUILDING_BLOCKS, WOODEN_MOSAIC.get(WoodMaps.CHARRED.getId()).block(), "mosaic");


                for (var entry : HERRINGBONE_PLANKS.bundle().entrySet()) {
                    offerHerringBoneRecipe(entry.getValue(), WoodMaps.PLANKS_MAP.get(entry.getKey()));
                }
                offerCharredSmeltingRecipe(BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN, RecipeCategory.BUILDING_BLOCKS, HERRINGBONE_PLANKS.get(WoodMaps.CHARRED.getId()), "herringbone_planks");

                for (TimberFrameBundle bundle : TimberFrameBundle.values()) {
                    for (var entry : bundle.woodMap().entrySet()) {
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
                shaped(RecipeCategory.BUILDING_BLOCKS, LARGE_FLOWER_POT).define('#', Items.BRICK).pattern("# #").pattern("###").pattern("###").unlockedBy("has_flower_pot", has(Items.FLOWER_POT)).save(exporter);

                // Chocolate
                shaped(RecipeCategory.BUILDING_BLOCKS, CHOCOLATE_BLOCK.block(), 2).define('#', Items.COCOA_BEANS).pattern("##").pattern("##").unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS)).save(exporter);
                offerBSSWCuttingRecipe(CHOCOLATE_BLOCK);
                offerBSSWCuttingRecipe(CHOCOLATE_BRICKS, CHOCOLATE_BLOCK.block());
                offerPolishedStoneRecipe(CHOCOLATE_BRICKS.block(), CHOCOLATE_BLOCK.block());
                offerPolishedStoneRecipe(CHOCOLATE_SQUARES, CHOCOLATE_BRICKS.block());
                offerStonecuttingRecipe(CHOCOLATE_SQUARES, CHOCOLATE_BLOCK.block(), CHOCOLATE_BRICKS.block());
                shaped(RecipeCategory.DECORATIONS, CHOCOLATE_TABLET, 3).define('#', CHOCOLATE_SQUARES).pattern("##").unlockedBy(getHasName(CHOCOLATE_SQUARES), has(CHOCOLATE_SQUARES)).save(exporter);
                offerStonecuttingRecipe(CHOCOLATE_TABLET, 2, CHOCOLATE_BLOCK.block(), CHOCOLATE_BRICKS.block(), CHOCOLATE_SQUARES);

                // Food Blocks
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.SWEET_BERRIES, RecipeCategory.BUILDING_BLOCKS, SWEET_BERRIES_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.GLOW_BERRIES, RecipeCategory.BUILDING_BLOCKS, GLOW_BERRIES_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.SALMON, RecipeCategory.BUILDING_BLOCKS, SALMON_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.PUFFERFISH, RecipeCategory.BUILDING_BLOCKS, PUFFERFISH_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.TROPICAL_FISH, RecipeCategory.BUILDING_BLOCKS, TROPICAL_FISH_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.COD, RecipeCategory.BUILDING_BLOCKS, COD_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.COOKIE, RecipeCategory.FOOD, COOKIE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.CHORUS_FRUIT, RecipeCategory.BUILDING_BLOCKS, CHORUS_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.POTATO, RecipeCategory.BUILDING_BLOCKS, POTATO_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.APPLE, RecipeCategory.BUILDING_BLOCKS, APPLE_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.GOLDEN_APPLE, RecipeCategory.BUILDING_BLOCKS, GOLDEN_APPLE_CRATE);
                createEnclosedRecipe2(GOLDEN_APPLE_CRATE, Ingredient.of(Blocks.GOLD_BLOCK), APPLE_CRATE).unlockedBy(getHasName(Items.GOLDEN_APPLE), has(Items.GOLDEN_APPLE)).save(exporter, getConversionRecipeName(GOLDEN_APPLE_CRATE, APPLE_CRATE));
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.BEETROOT, RecipeCategory.BUILDING_BLOCKS, BEETROOT_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.CARROT, RecipeCategory.BUILDING_BLOCKS, CARROT_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.GOLDEN_CARROT, RecipeCategory.BUILDING_BLOCKS, GOLDEN_CARROT_CRATE);
                createEnclosedRecipe2(GOLDEN_CARROT_CRATE, Ingredient.of(Items.GOLD_INGOT), CARROT_CRATE).unlockedBy(getHasName(Items.GOLDEN_CARROT), has(Items.GOLDEN_CARROT)).save(exporter, getConversionRecipeName(GOLDEN_CARROT_CRATE, CARROT_CRATE));
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.BREAD, RecipeCategory.BUILDING_BLOCKS, BREAD_BOX);

                // Rainbow
                oneToOneConversionRecipe(RAINBOW_PETALS, RAINBOW_ROSE, "rainbow_petal", 2);
                oneToOneConversionRecipe(RAINBOW_PETALS, RAINBOW_BLOCK, "rainbow_petal", 4);
                shaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_BLOCK).define('#', RAINBOW_PETALS).pattern("##").pattern("##").unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter);
                offerBSSWCuttingRecipe(RAINBOW_BRICKS, RAINBOW_BLOCK);
                offerPolishedStoneRecipe(RAINBOW_BRICKS.block(), RAINBOW_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE).requires(RAINBOW_PETALS).requires(Blocks.GLOWSTONE).group("rainbow_glowstone").unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE, 1).define('G', Items.GLOWSTONE_DUST).group("rainbow_glowstone").define('R', RAINBOW_PETALS).pattern(" G ").pattern("GRG").pattern(" G ").unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter, getSimpleRecipeName(RAINBOW_GLOWSTONE) + "_alt");

                // Dyed blocks
                offerBSSWCuttingRecipe(SHINGLES, Blocks.TERRACOTTA);
                offerPolishedStoneRecipe(SHINGLES.block(), Blocks.TERRACOTTA);
                for (DyeColor color : DyeColor.values()) {
                    DyedBSSWBundle dyedStoneBricks = DYED_STONE_BRICKS;
                    DyedBSSWBundle dyedShingles = DYED_SHINGLES;
                    ConcreteBundle concreteBricks = CONCRETE_BRICKS;
                    offerDyedStoneBricksRecipe(Items.DYE.pick(color), dyedStoneBricks.block().pick(color), dyedStoneBricks.stairs().pick(color), dyedStoneBricks.slab().pick(color), dyedStoneBricks.wall().pick(color));
                    offerDyedShinglesRecipe(Items.DYE.pick(color), Blocks.DYED_TERRACOTTA.pick(color), dyedShingles.block().pick(color), dyedShingles.stairs().pick(color), dyedShingles.slab().pick(color));
                    offerConcreteBricksRecipe(Blocks.CONCRETE.pick(color), concreteBricks.block().pick(color), concreteBricks.stairs().pick(color), concreteBricks.slab().pick(color), concreteBricks.wall().pick(color), concreteBricks.chiseled().pick(color), concreteBricks.pillar().pick(color));
                }

                // Redstone Lamps
                shapeless(RecipeCategory.BUILDING_BLOCKS, LIT_REDSTONE_LAMP).requires(Blocks.REDSTONE_LAMP).requires(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").unlockedBy(getHasName(Blocks.REDSTONE_LAMP), has(Blocks.REDSTONE_LAMP)).save(exporter);
                ColorCollectionUtils.zipApply(this::offerStainedRedstoneLampRecipe, DYED_REDSTONE_LAMP, Items.DYE, DYED_LIT_REDSTONE_LAMP);
                offerStainedRedstoneLampRecipe(RAINBOW_LAMP, RAINBOW_PETALS, LIT_RAINBOW_LAMP);

                // Neon Blocks
                ColorCollection.zipApply(this::offerNeonRecipe, NEON, Items.DYE);
                offerNeonRecipe(RAINBOW_NEON, RAINBOW_PETALS);

                // Futurneo Blocks
                ColorCollection.zipApply(this::offerFuturneoRecipe, FUTURNEO_BLOCK, Blocks.STAINED_GLASS);
                shaped(RecipeCategory.BUILDING_BLOCKS, GRAY_BRIGHT_FUTURNEO_BLOCK).define('A', Items.DYE.white()).define('B', Blocks.STAINED_GLASS.gray()).define('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").unlockedBy(getHasName(Blocks.STAINED_GLASS.gray()), has(Blocks.STAINED_GLASS.gray())).save(exporter);
                offerFuturneoRecipe(RAINBOW_FUTURNEO_BLOCK, RAINBOW_GLASS);

                // Asphalt
                for (DyeColor color : DyeColor.values()) {
                    AsphaltBundle block = ASPHALT;
                    offerBlockStairsSlabRecipe(block.block().pick(color), block.stairs().pick(color), block.slab().pick(color));
                    offerStonecuttingRecipe(block.stairs().pick(color), block.block().pick(color));
                    offerStonecuttingRecipe(block.slab().pick(color), 2, block.block().pick(color));
                    if (color != DyeColor.BLACK) {
                        offerAsphaltRecipe(Items.DYE.pick(color), block.block().pick(color), block.stairs().pick(color), block.slab().pick(color));
                    }
                }
                shaped(RecipeCategory.BUILDING_BLOCKS, ASPHALT.block().black(), 8).define('X', Blocks.GRAVEL).define('#', ItemTags.COALS).pattern("XXX").pattern("X#X").pattern("XXX").group("asphalt").unlockedBy(getHasName(Blocks.GRAVEL), has(Blocks.GRAVEL)).save(exporter);
                createEnclosedRecipe(RAINBOW_ASPHALT, Ingredient.of(ASPHALT.block().black()), RAINBOW_PETALS).unlockedBy(getHasName(ASPHALT.block().black()), has(ASPHALT.block().black())).save(exporter);

                // Wool
                for (DyeColor color : DyeColor.values()) {
                    offerPatternedWoolRecipe(PATTERNED_WOOL.block().pick(color), Blocks.WOOL.pick(color), PATTERNED_WOOL.carpet().pick(color), Blocks.CARPET.pick(color));
                    offerGinghamWoolRecipe(GINGHAM_WOOL.block().pick(color), Blocks.WOOL.pick(color));
                    for (WoolBundle block : WoolBundle.values()) {
                        offerBlockStairsSlabRecipe(block.block().pick(color), block.stairs().pick(color), block.slab().pick(color));
                        carpet(block.carpet().pick(color), block.block().pick(color));
                    }
                }

                // Glass - Beveled Glass
                offerPolishedStoneRecipe(TINTED_BEVELED_GLASS, Blocks.TINTED_GLASS);
                offerPolishedStoneRecipe(BEVELED_GLASS, Blocks.GLASS);
                shaped(RecipeCategory.BUILDING_BLOCKS, BEVELED_GLASS_PANE, 16).define('#', BEVELED_GLASS).pattern("###").pattern("###").group("beveled_glass_pane").unlockedBy("has_beveled_glass", has(BEVELED_GLASS_PANE)).save(exporter);
                ColorCollectionUtils.zipApply(this::offerStainedBeveledGlassRecipe, STAINED_BEVELED_GLASS, STAINED_BEVELED_GLASS_PANE, Blocks.STAINED_GLASS, Items.DYE);
                offerStainedBeveledGlassRecipe(RAINBOW_BEVELED_GLASS, RAINBOW_BEVELED_GLASS_PANE, RAINBOW_GLASS, RAINBOW_PETALS);
                createEnclosedRecipe(RAINBOW_GLASS, Ingredient.of(Blocks.GLASS), RAINBOW_PETALS).unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter);
                createEnclosedRecipe(RAINBOW_GLASS_PANE, Ingredient.of(Blocks.GLASS_PANE), RAINBOW_PETALS).unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(exporter, getSimpleRecipeName(RAINBOW_GLASS_PANE) + "_alt");
                shaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLASS_PANE, 16).define('#', RAINBOW_GLASS).pattern("###").pattern("###").unlockedBy(getHasName(RAINBOW_GLASS), has(RAINBOW_GLASS)).save(exporter);

                // Colored Tiles
                ColorCollection.zipApply(this::offerUnicolorColoredTilesRecipe, COLORED_TILES, Blocks.CONCRETE);
                offerUnicolorColoredTilesRecipe(RAINBOW_COLORED_TILES, RAINBOW_BLOCK);

                // Glazed Terracotta Pillars
                ColorCollection.zipApply(this::offerPillarRecipe, GLAZED_TERRACOTTA_PILLAR, Blocks.GLAZED_TERRACOTTA);

                // Thatch
                offerPolishedStoneRecipe(THATCH.block(), Items.WHEAT);

                // Paper
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, PAPER_BLOCK);
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(PAPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, BURNT_PAPER_BLOCK.asItem(), 0.1F, 200).unlockedBy("has_paper_block", has(PAPER_BLOCK)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, FRAMED_PAPER_BLOCK, 4).define('X', Items.PAPER).define('#', Items.STICK).pattern("###").pattern("XXX").pattern("###").unlockedBy(getHasName(Items.PAPER), has(Items.PAPER)).save(exporter);
                offerPolishedStoneRecipe(PAPER_WALL, FRAMED_PAPER_BLOCK);
                createEnclosedRecipe2(PAPER_LAMP, Ingredient.of(Items.PAPER), Items.TORCH).unlockedBy(getHasName(Items.PAPER), has(Items.PAPER)).save(exporter);
                offerShapelessRecipe2(Items.GUNPOWDER, BURNT_PAPER_BLOCK, 2);
                offerDoorTrapdoorRecipe(PAPER_DOOR, PAPER_TRAPDOOR, PAPER_WALL);

                // Plating
                offerBSSWCuttingRecipe(IRON_PLATING);
                shaped(RecipeCategory.BUILDING_BLOCKS, IRON_PLATING.block(), 24).define('X', Items.IRON_INGOT).pattern("XXX").pattern("X X").pattern("XXX").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(exporter);
                offerBSSWCuttingRecipe(GOLD_PLATING);
                shaped(RecipeCategory.BUILDING_BLOCKS, GOLD_PLATING.block(), 24).define('X', Items.GOLD_INGOT).pattern("XXX").pattern("X X").pattern("XXX").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(exporter);

                // Gates - chains - bars
                offerDoorRecipe(IRON_GATE, Blocks.IRON_BARS);
                offerDoorRecipe(GOLDEN_GATE, GOLDEN_BARS);
                shaped(RecipeCategory.BUILDING_BLOCKS, GOLDEN_BARS, 16).define('#', Items.GOLD_INGOT).pattern("###").pattern("###").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, GOLDEN_CHAIN).define('X', Items.GOLD_INGOT).define('#', Items.GOLD_NUGGET).pattern("#").pattern("X").pattern("#").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(exporter);
                offerDoorRecipe(COPPER_GATE.unaffected(), Blocks.COPPER_BARS.unaffected());
                offerDoorRecipe(COPPER_GATE.exposed(), Blocks.COPPER_BARS.exposed());
                offerDoorRecipe(COPPER_GATE.weathered(), Blocks.COPPER_BARS.weathered());
                offerDoorRecipe(COPPER_GATE.oxidized(), Blocks.COPPER_BARS.oxidized());
                offerDoorRecipe(COPPER_GATE.waxed(), Blocks.COPPER_BARS.waxed());
                offerDoorRecipe(COPPER_GATE.waxedExposed(), Blocks.COPPER_BARS.waxedExposed());
                offerDoorRecipe(COPPER_GATE.waxedWeathered(), Blocks.COPPER_BARS.waxedWeathered());
                offerDoorRecipe(COPPER_GATE.waxedOxidized(), Blocks.COPPER_BARS.waxedOxidized());

                // Lantern Blocks
                offerLanternBlockRecipe(LANTERN_BLOCK, Blocks.LANTERN, Items.IRON_NUGGET);
                offerLanternBlockRecipe(SOUL_LANTERN_BLOCK, Blocks.SOUL_LANTERN, Items.IRON_NUGGET);
                shaped(RecipeCategory.BUILDING_BLOCKS, AMETHYST_LANTERN).define('#', Items.TORCH).define('A', Items.AMETHYST_SHARD).define('X', Items.IRON_NUGGET).pattern("XXX").pattern("XAX").pattern("X#X").unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(exporter);
                offerLanternBlockRecipe(AMETHYST_LANTERN_BLOCK, AMETHYST_LANTERN, Items.IRON_NUGGET);
                shaped(RecipeCategory.BUILDING_BLOCKS, REDSTONE_LANTERN).define('#', Items.REDSTONE_TORCH).define('X', Items.IRON_NUGGET).pattern("XXX").pattern("X#X").pattern("XXX").unlockedBy(getHasName(Items.REDSTONE_TORCH), has(Items.REDSTONE_TORCH)).save(exporter);
                offerLanternBlockRecipe(REDSTONE_LANTERN_BLOCK, REDSTONE_LANTERN, Items.IRON_NUGGET);
                offerJackOLanternRecipe(SOUL_O_LANTERN, Blocks.SOUL_TORCH);
                offerJackOLanternRecipe(COPPER_JACK_O_LANTERN, Blocks.COPPER_TORCH);
                offerJackOLanternRecipe(REDSTONE_O_LANTERN, Blocks.REDSTONE_TORCH);
                offerLanternBlockRecipe(COPPER_LANTERN_BLOCK.unaffected(), Blocks.COPPER_LANTERN.unaffected(), Items.COPPER_NUGGET);
                offerLanternBlockRecipe(COPPER_LANTERN_BLOCK.exposed(), Blocks.COPPER_LANTERN.exposed(), Items.COPPER_NUGGET);
                offerLanternBlockRecipe(COPPER_LANTERN_BLOCK.weathered(), Blocks.COPPER_LANTERN.weathered(), Items.COPPER_NUGGET);
                offerLanternBlockRecipe(COPPER_LANTERN_BLOCK.oxidized(), Blocks.COPPER_LANTERN.oxidized(), Items.COPPER_NUGGET);
                offerLanternBlockRecipe(COPPER_LANTERN_BLOCK.waxed(), Blocks.COPPER_LANTERN.waxed(), Items.COPPER_NUGGET);
                offerLanternBlockRecipe(COPPER_LANTERN_BLOCK.waxedExposed(), Blocks.COPPER_LANTERN.waxedExposed(), Items.COPPER_NUGGET);
                offerLanternBlockRecipe(COPPER_LANTERN_BLOCK.waxedWeathered(), Blocks.COPPER_LANTERN.waxedWeathered(), Items.COPPER_NUGGET);
                offerLanternBlockRecipe(COPPER_LANTERN_BLOCK.waxedOxidized(), Blocks.COPPER_LANTERN.waxedOxidized(), Items.COPPER_NUGGET);


                // Barriers
                shaped(RecipeCategory.BUILDING_BLOCKS, ROAD_BARRIER, 5).define('#', Items.IRON_INGOT).define('X', Blocks.STONE).pattern("X#X").pattern("X#X").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, CAUTION_BARRIER).requires(CAUTION_BLOCK).requires(ROAD_BARRIER).unlockedBy(getHasName(CAUTION_BLOCK), has(CAUTION_BLOCK)).unlockedBy(getHasName(ROAD_BARRIER), has(ROAD_BARRIER)).save(exporter);

                // Netherite Blocks
                offerStairsRecipe(NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
                slab(RecipeCategory.BUILDING_BLOCKS, NETHERITE_SLAB, Blocks.NETHERITE_BLOCK);
                offerStonecuttingRecipe(NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
                offerStonecuttingRecipe(NETHERITE_SLAB, 2, Blocks.NETHERITE_BLOCK);

                // Other
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, CHARCOAL_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, SUGAR_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, ENDER_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, ROTTEN_FLESH_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.BUILDING_BLOCKS, MEMBRANE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.NETHER_STAR, RecipeCategory.BUILDING_BLOCKS, NETHER_STAR_BLOCK);
                offerPolishedStoneRecipe(WOODEN_FRAME, Items.STICK);
                createEnclosedRecipe2(REDSTONE_SAND, Ingredient.of(Items.REDSTONE), Items.SAND).unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE)).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, Items.REDSTONE, 8).requires(REDSTONE_SAND).unlockedBy(getHasName(REDSTONE_SAND), has(REDSTONE_SAND)).save(exporter, getConversionRecipeName(Items.REDSTONE, REDSTONE_SAND));
                shaped(RecipeCategory.BUILDING_BLOCKS, LOVE_BLOCK).define('M', Items.DYE.magenta()).define('R', Items.DYE.red()).pattern("RMR").pattern("RRR").pattern("MRM").unlockedBy(getHasName(Items.DYE.magenta()), has(Items.DYE.magenta())).unlockedBy(getHasName(Items.DYE.red()), has(Items.DYE.red())).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, WEIGHT_STORAGE_CUBE).requires(Blocks.STONE).requires(Items.IRON_NUGGET).unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE)).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, COMPANION_CUBE).requires(WEIGHT_STORAGE_CUBE).requires(Items.POPPY).unlockedBy(getHasName(WEIGHT_STORAGE_CUBE), has(WEIGHT_STORAGE_CUBE)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, CAUTION_BLOCK, 6).define('A', Blocks.STONE).define('B', Items.DYE.black()).define('C', Items.DYE.yellow()).pattern(" C ").pattern("BAB").pattern(" C ").unlockedBy(getHasName(Items.DYE.black()), has(Items.DYE.black())).unlockedBy(getHasName(Items.DYE.yellow()), has(Items.DYE.yellow())).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, STARS_BLOCK, 3).define('#', Items.ENDER_PEARL).define('X', Items.CHORUS_FRUIT).pattern("X#X").pattern("###").pattern("X#X").unlockedBy(getHasName(Items.CHORUS_FRUIT), has(Items.CHORUS_FRUIT)).save(exporter);

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
                oneToOneConversionRecipe(Items.IRON_INGOT, LEGACY_IRON_BLOCK, "iron_ingot", 9);
                oneToOneConversionRecipe(Items.GOLD_INGOT, LEGACY_GOLD_BLOCK, "gold_ingot", 9);
                oneToOneConversionRecipe(Items.GOLD_INGOT, LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, "gold_ingot", 9);
                oneToOneConversionRecipe(Items.COAL, LEGACY_COAL_BLOCK, "coal", 9);
                oneToOneConversionRecipe(Items.DIAMOND, LEGACY_DIAMOND_BLOCK, "diamond", 9);
                oneToOneConversionRecipe(Items.LAPIS_LAZULI, LEGACY_LAPIS_BLOCK, "lapis_lazuli", 9);
                oneToOneConversionRecipe(Items.DYE.red(), LEGACY_ROSE, "red_dye", 2);
                oneToOneConversionRecipe(Items.DYE.lightBlue(), LEGACY_BLUE_ROSE, "light_blue_dye", 2);
                shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_STONECUTTER).define('#', Blocks.COBBLESTONE).define('S', Blocks.STONECUTTER).pattern(" # ").pattern("#S#").pattern(" # ").unlockedBy(getHasName(Blocks.STONECUTTER), has(Blocks.STONECUTTER)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_NETHER_REACTOR_CORE).define('#', Items.DIAMOND).define('X', Items.IRON_INGOT).pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_SAPLING, 4).define('#', Blocks.OAK_SAPLING).pattern("##").pattern("##").unlockedBy(getHasName(Blocks.OAK_SAPLING), has(Blocks.OAK_SAPLING)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_ROSE, 2).define('#', Blocks.POPPY).pattern("##").pattern("##").unlockedBy(getHasName(Blocks.POPPY), has(Blocks.POPPY)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_BLUE_ROSE, 2).define('#', LEGACY_ROSE).pattern("##").unlockedBy(getHasName(LEGACY_ROSE), has(LEGACY_ROSE)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_FIRST_GRASS_BLOCK, 4).define('#', LEGACY_GRASS_BLOCK).pattern("##").pattern("##").unlockedBy(getHasName(LEGACY_GRASS_BLOCK), has(LEGACY_GRASS_BLOCK)).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, LEGACY_PLANKS, 4).requires(LEGACY_LOG).group("planks").unlockedBy("has_logs", has(LEGACY_LOG)).save(exporter);
            }

            private void offerLanternBlockRecipe(Block output, Block lantern, Item nugget) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output).define('X', lantern).define('#', nugget).pattern(" # ").pattern("#X#").pattern(" # ").unlockedBy(getHasName(lantern), has(lantern)).save(exporter);
            }

            public void offerWaxingRecipes(Block unwaxed, Block waxed) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, waxed).requires(unwaxed).requires(Items.HONEYCOMB).group(getItemName(waxed)).unlockedBy(getHasName(unwaxed), has(unwaxed)).save(exporter, getConversionRecipeName(waxed, Items.HONEYCOMB));
            }

            public void offerJackOLanternRecipe(Block output, Block input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output).define('X', Blocks.CARVED_PUMPKIN).define('#', input).pattern("X").pattern("#").unlockedBy(getHasName(Blocks.CARVED_PUMPKIN), has(Blocks.CARVED_PUMPKIN)).unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public void offerCharredSmeltingRecipe(TagKey<Item> input, RecipeCategory category, ItemLike output, String hasitem) {
                SimpleCookingRecipeBuilder.smelting(tag(input), category, CookingBookCategory.BLOCKS, output, 0.1F, 200).unlockedBy("has_" + hasitem, has(input)).save(exporter, getSimpleRecipeName(output) + "_from_smelting");
            }

            public void offerMossyRecipe(ItemLike output, ItemLike input) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, output).requires(input).requires(Blocks.VINE).group(BuiltInRegistries.BLOCK.getKey((Block) output).getPath()).unlockedBy("has_vine", has(Blocks.VINE)).save(exporter, getConversionRecipeName(output, Blocks.VINE));
                shapeless(RecipeCategory.BUILDING_BLOCKS, output).requires(input).requires(Blocks.MOSS_BLOCK).group(BuiltInRegistries.BLOCK.getKey((Block) output).getPath()).unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK)).save(exporter, getConversionRecipeName(output, Blocks.MOSS_BLOCK));
            }

            public void offerPolishedStoneRecipe(ItemLike output, ItemLike input) {
                polishedBuilder(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public RecipeBuilder createCondensingRecipe(RecipeCategory category, ItemLike output, int count, Ingredient input, String group) {
                return shaped(category, output, count).define('S', input).group(group).pattern("SS").pattern("SS");
            }

            public void offerShapelessRecipe2(ItemLike output, ItemLike input, int outputCount) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, output, outputCount).requires(input).unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public void offerSturdyRecipe(ItemLike output, ItemLike input1, ItemLike input2) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 2).define('#', input1).define('X', input2).pattern("X#X").pattern("# #").pattern("X#X").unlockedBy(getHasName(input1), has(input1)).unlockedBy(getHasName(input2), has(input2)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 2).define('#', input1).define('X', input2).pattern("#X#").pattern("X X").pattern("#X#").unlockedBy(getHasName(input1), has(input1)).unlockedBy(getHasName(input2), has(input2)).save(exporter, getSimpleRecipeName(output) + "_alt");

            }

            public void offerDecoratedRecipe(ItemLike output, ItemLike decoration, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', decoration).define('X', input).pattern("##").pattern("XX").unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public void offerPhantomPurpurRecipe(ItemLike output, ItemLike input) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, output).requires(input).requires(BlockusItemTags.SOUL_SOILS).unlockedBy("has_purpur", has(input)).save(exporter, getConversionRecipeName(output, Blocks.SOUL_SAND));

            }

            public void offerColoredTilesRecipe(ItemLike output, ItemLike color1, ItemLike color2) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, output, 2).requires(color1).requires(color2).group("colored_tiles").unlockedBy(getHasName(color1), has(color1)).unlockedBy(getHasName(color2), has(color2)).save(exporter);

            }

            public void offerUnicolorColoredTilesRecipe(ItemLike output, ItemLike color) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, output, 2).requires(color).requires(color).group("colored_tiles").unlockedBy(getHasName(color), has(color)).save(exporter);
                offerStonecuttingRecipe(output, color);

            }

            public void offerSmallLogsRecipe(ItemLike output, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', input).pattern(" # ").pattern("###").group("small_logs").unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public void offerWoodenPostRecipe(WoodenPostBundle.WoodenPostVariants post, ItemLike base, ItemLike base2, ItemLike planks) {
                shaped(RecipeCategory.BUILDING_BLOCKS, post.block(), 6).define('#', base).pattern("#").pattern("#").pattern("#").group("wooden_posts").unlockedBy("has_woods", has(base)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, post.stripped(), 6).define('#', base2).pattern("#").pattern("#").pattern("#").group("stripped_wooden_posts").unlockedBy("has_woods", has(base2)).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 2).requires(post.block()).group("planks").unlockedBy("has_wooden_post", has(post.block())).save(exporter, getConversionRecipeName(planks, post.block()));
                shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 2).requires(post.stripped()).group("planks").unlockedBy("has_stripped_wooden_post", has(post.stripped())).save(exporter, getConversionRecipeName(planks, post.stripped()));
            }

            public void offerSmallHedgesRecipe(ItemLike output, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 6).define('#', input).pattern("###").pattern("###").group("hedge").unlockedBy(getHasName(input), has(input)).save(exporter);
            }


            public void offerHerringBoneRecipe(ItemLike output, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 5).define('#', input).pattern("#  ").pattern("###").pattern("  #").group("herringbone_planks").unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public RecipeBuilder createEnclosedRecipe(ItemLike output, Ingredient input, ItemLike center) {
                return shaped(RecipeCategory.BUILDING_BLOCKS, output, 8).define('X', input).define('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
            }

            public RecipeBuilder createEnclosedRecipe2(ItemLike output, Ingredient input, ItemLike center) {
                return shaped(RecipeCategory.BUILDING_BLOCKS, output).define('X', input).define('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
            }

            public void offerDoorRecipe(ItemLike door, ItemLike input) {
                doorBuilder(door, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public void offerStoneDoorTrapdoorRecipe(ItemLike door, ItemLike trapdoor, ItemLike input, ItemLike slab) {
                offerDoorRecipe(door, input);
                shaped(RecipeCategory.REDSTONE, trapdoor, 4).define('#', slab).pattern("###").pattern("###").unlockedBy(getHasName(slab), has(slab)).save(exporter);
            }

            public void offerDoorTrapdoorRecipe(ItemLike door, ItemLike trapdoor, ItemLike input) {
                offerDoorRecipe(door, input);
                trapdoorBuilder(trapdoor, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public void offerPressurePlateButtonRecipe(ItemLike pressureplate, ItemLike button, ItemLike input) {
                pressurePlateBuilder(RecipeCategory.REDSTONE, pressureplate, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
                shapeless(RecipeCategory.REDSTONE, button).requires(input).unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public void offerDyedStoneBricksRecipe(ItemLike dye, ItemLike block, ItemLike stairs, ItemLike slab, ItemLike wall) {
                offerBlockStairsSlabWallRecipe(block, stairs, slab, wall);
                createEnclosedRecipe(block, Ingredient.of(Blocks.STONE_BRICKS), dye).group("dyed_stone_bricks").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter);
                createEnclosedRecipe(stairs, Ingredient.of(Blocks.STONE_BRICK_STAIRS), dye).group("dyed_stone_brick_stairs").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter, getConversionRecipeName(stairs, Blocks.STONE_BRICK_STAIRS));
                createEnclosedRecipe(slab, Ingredient.of(Blocks.STONE_BRICK_SLAB), dye).group("dyed_stone_brick_slab").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter, getConversionRecipeName(slab, Blocks.STONE_BRICK_SLAB));
                createEnclosedRecipe(wall, Ingredient.of(Blocks.STONE_BRICK_WALL), dye).group("dyed_stone_brick_wall").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(exporter, getConversionRecipeName(wall, Blocks.STONE_BRICK_WALL));
                offerStonecuttingRecipe(stairs, block);
                offerStonecuttingRecipe(slab, 2, block);
                offerStonecuttingRecipe(wall, block);
            }

            public void offerDyedShinglesRecipe(ItemLike dye, ItemLike terracotta, ItemLike block, ItemLike stairs, ItemLike slab) {
                offerBlockStairsSlabRecipe(block, stairs, slab);
                createEnclosedRecipe(block, Ingredient.of(SHINGLES.block()), dye).group("shingles").unlockedBy(getHasName(SHINGLES.block()), has(SHINGLES.block())).save(exporter, getConversionRecipeName(stairs, SHINGLES.block()));
                createEnclosedRecipe(stairs, Ingredient.of(SHINGLES.stairs()), dye).group("shingles_stairs").unlockedBy(getHasName(SHINGLES.block()), has(SHINGLES.block())).save(exporter, getConversionRecipeName(stairs, SHINGLES.stairs()));
                createEnclosedRecipe(slab, Ingredient.of(SHINGLES.slab()), dye).group("shingles_slab").unlockedBy(getHasName(SHINGLES.block()), has(SHINGLES.block())).save(exporter, getConversionRecipeName(slab, SHINGLES.slab()));
                offerPolishedStoneRecipe(block, terracotta);
                offerStonecuttingRecipe(block, terracotta);
                offerStonecuttingRecipe(stairs, terracotta, block);
                offerStonecuttingRecipe(slab, 2, terracotta, block);
            }

            public void offerConcreteBricksRecipe(ItemLike concrete, ItemLike block, ItemLike stairs, ItemLike slab, ItemLike wall, ItemLike chiseled, ItemLike pillar) {
                offerBlockStairsSlabWallRecipe(block, stairs, slab, wall);
                offerStonecuttingRecipe(block, concrete);
                offerStonecuttingRecipe(stairs, concrete, block);
                offerStonecuttingRecipe(slab, 2, concrete, block);
                offerStonecuttingRecipe(wall, concrete, block);
                offerStonecuttingRecipe(chiseled, concrete, block);
                offerStonecuttingRecipe(pillar, concrete, block);
                offerPolishedStoneRecipe(block, concrete);
            }

            public void offerOreBricksRecipe(BSSWBundle ore_bricks, ItemLike ore_block, ItemLike ore) {
                offerStonecuttingRecipe(ore_bricks.block(), ore_block);
                offerStonecuttingRecipe(ore_bricks.stairs(), ore_bricks.block(), ore_block);
                offerStonecuttingRecipe(ore_bricks.slab(), 2, ore_bricks.block(), ore_block);
                offerStonecuttingRecipe(ore_bricks.wall(), ore_bricks.block(), ore_block);
                offerPolishedStoneRecipe(ore_bricks.block(), ore_block);
                oneToOneConversionRecipe(ore, ore_bricks.block(), ore.toString(), 9);
                oneToOneConversionRecipe(ore, ore_bricks.stairs(), ore.toString(), 9);
                oneToOneConversionRecipe(ore, ore_bricks.slab(), ore.toString(), 4);
                oneToOneConversionRecipe(ore, ore_bricks.wall(), ore.toString(), 9);
            }

            public void offerCopperBricksRecipe() {
                WeatheringCopperCollection.zipApply((block, stairs, slab, base) -> {
                    this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, block, base, 4);
                    this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, stairs, base, 4);
                    this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, slab, base, 8);
                }, COPPER_BRICKS.block(), COPPER_BRICKS.stairs(), COPPER_BRICKS.slab(), Blocks.COPPER_BLOCK);
                WeatheringCopperCollection.zipApply((block, stairs, slab, cutBlock) -> {
                    this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, block, cutBlock);
                    this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, stairs, cutBlock);
                    this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, slab, cutBlock, 2);
                    offerPolishedStoneRecipe(block, cutBlock);
                }, COPPER_BRICKS.block(), COPPER_BRICKS.stairs(), COPPER_BRICKS.slab(), Blocks.CUT_COPPER);
                WeatheringCopperCollection.zipApply((base, cutBlock, wall) -> {
                    this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, wall, base, 4);
                    this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, wall, cutBlock);
                }, Blocks.COPPER_BLOCK, Blocks.CUT_COPPER, COPPER_BRICKS.wall());
            }

            public void createTimberFramesRecipes(ItemLike base, ItemLike block, ItemLike diagonal, ItemLike cross) {
                shaped(RecipeCategory.BUILDING_BLOCKS, block, 2).define('#', Items.PAPER).define('X', base).pattern("#X").pattern("X#").group("timber_frame").unlockedBy(getHasName(base), has(base)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, diagonal, 4).define('#', block).pattern("##").pattern("##").group("diagonal_timber_frame").unlockedBy(getHasName(block), has(block)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, cross, 4).define('#', diagonal).pattern("##").pattern("##").group("cross_timber_frame").unlockedBy(getHasName(diagonal), has(diagonal)).save(exporter);
            }

            public void createLatticeRecipes(ItemLike base, ItemLike lattice, ItemLike grate) {
                shaped(RecipeCategory.BUILDING_BLOCKS, grate, 3).define('#', Items.STICK).define('X', base).pattern(" # ").pattern("#X#").pattern(" # ").group("wooden_grates").unlockedBy(getHasName(base), has(base)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, lattice, 16).define('#', grate).pattern("###").pattern("###").group("wooden_lattices").unlockedBy(getHasName(lattice), has(lattice)).save(exporter);
            }

            public void offerAsphaltRecipe(ItemLike dye, ItemLike block, ItemLike stairs, ItemLike slab) {
                createEnclosedRecipe(block, Ingredient.of(ASPHALT.block().black()), dye).group("asphalt").unlockedBy(getHasName(ASPHALT.block().black()), has(ASPHALT.block().black())).save(exporter);
                createEnclosedRecipe(stairs, Ingredient.of(ASPHALT.stairs().black()), dye).group("asphalt_stairs").unlockedBy(getHasName(ASPHALT.stairs().black()), has(ASPHALT.stairs().black())).save(exporter, getConversionRecipeName(stairs, ASPHALT.stairs().black()));
                createEnclosedRecipe(slab, Ingredient.of(ASPHALT.slab().black()), dye).group("asphalt_slab").unlockedBy(getHasName(ASPHALT.slab().black()), has(ASPHALT.slab().black())).save(exporter, getConversionRecipeName(slab, ASPHALT.slab().black()));
            }

            public void offerPatternedWoolRecipe(ItemLike output, ItemLike wool, ItemLike output_carpet, ItemLike carpet) {
                offerPolishedStoneRecipe(output, wool);
                polishedBuilder(RecipeCategory.BUILDING_BLOCKS, output_carpet, Ingredient.of(carpet)).group("patterned_carpet").unlockedBy(getHasName(carpet), has(carpet)).save(exporter, getConversionRecipeName(output_carpet, carpet));
            }

            public void offerGinghamWoolRecipe(ItemLike output, ItemLike wool) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', wool).pattern(" # ").pattern("# #").pattern(" # ").group("gingham_wool").unlockedBy(getHasName(wool), has(wool)).save(exporter);
            }

            public void offerStairsRecipe(ItemLike output, ItemLike input) {
                stairBuilder(output, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(exporter);
            }

            public void offerStainedBeveledGlassRecipe(ItemLike output, ItemLike output_pane, ItemLike input, ItemLike dye) {
                polishedBuilder(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.of(input)).group("beveled_glass").unlockedBy(getHasName(input), has(input)).save(exporter);
                createEnclosedRecipe(output, Ingredient.of(BEVELED_GLASS), dye).group("beveled_glass_2").unlockedBy(getHasName(BEVELED_GLASS), has(BEVELED_GLASS)).save(exporter, getConversionRecipeName(output, BEVELED_GLASS));
                shaped(RecipeCategory.BUILDING_BLOCKS, output_pane, 16).define('#', output).pattern("###").pattern("###").group("beveled_glass_pane").unlockedBy(getHasName(BEVELED_GLASS_PANE), has(output)).save(exporter);
                createEnclosedRecipe(output_pane, Ingredient.of(BEVELED_GLASS_PANE), dye).group("beveled_glass_pane_2").unlockedBy(getHasName(BEVELED_GLASS_PANE), has(BEVELED_GLASS_PANE)).save(exporter, getConversionRecipeName(output, BEVELED_GLASS_PANE));
            }

            public void offerStainedRedstoneLampRecipe(ItemLike output, ItemLike dye, ItemLike output_lit) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output).define('S', dye).define('#', Blocks.REDSTONE_LAMP).pattern(" S ").pattern("S#S").pattern(" S ").group("redstone_lamps").unlockedBy(getHasName(Blocks.REDSTONE_LAMP), has(Blocks.REDSTONE_LAMP)).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, output_lit).requires(output).requires(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").unlockedBy(getHasName(output), has(output)).save(exporter);
                shaped(RecipeCategory.BUILDING_BLOCKS, output_lit).define('S', dye).define('#', LIT_REDSTONE_LAMP).pattern(" S ").pattern("S#S").pattern(" S ").group("lit_redstone_lamps").unlockedBy(getHasName(Blocks.REDSTONE_LAMP), has(Blocks.REDSTONE_LAMP)).save(exporter, getSimpleRecipeName(output) + "_alt");
            }

            public void offerNeonRecipe(ItemLike output, ItemLike dye) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 8).define('D', dye).define('S', Items.GLOW_INK_SAC).define('A', Items.AMETHYST_SHARD).pattern(" A ").pattern("SDS").pattern(" A ").group("neon_blocks").unlockedBy(getHasName(Items.GLOW_INK_SAC), has(Items.GLOW_INK_SAC)).save(exporter);
            }

            public void offerFuturneoRecipe(ItemLike output, ItemLike glass) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 6).define('A', Items.DYE.black()).define('B', glass).define('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").unlockedBy(getHasName(glass), has(glass)).save(exporter);

            }

            public void offerBoatsRecipe(ItemLike output1, ItemLike output2, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output1).define('#', input).pattern("# #").pattern("###").group("boat").unlockedBy("in_water", insideOf(Blocks.WATER)).save(exporter);
                shapeless(RecipeCategory.BUILDING_BLOCKS, output2).requires(Blocks.CHEST).requires(output1).group("chest_boat").unlockedBy("has_boat", has(ItemTags.BOATS)).save(exporter);

            }

            public void offerPillarRecipe(ItemLike output, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, output, 2).define('#', input).pattern("#").pattern("#").unlockedBy(getHasName(input), has(input)).save(exporter);
                offerStonecuttingRecipe(output, 1, input);
            }

            public void offerBlockStairsSlabRecipe(ItemLike block, ItemLike stairs, ItemLike slab) {
                // For block, stairs and slab.
                offerStairsRecipe(stairs, block);
                slab(RecipeCategory.BUILDING_BLOCKS, slab, block);
            }

            public void offerBlockStairsSlabWallRecipe(ItemLike block, ItemLike stairs, ItemLike slab, ItemLike wall) {
                // For block, stairs, slab and wall.
                offerBlockStairsSlabRecipe(block, stairs, slab);
                wall(RecipeCategory.DECORATIONS, wall, block);
            }

            public void offerBSSWCuttingRecipe(BSSWBundle bsswBundle, ItemLike... ingredients) {
                // For block, stairs, slab and wall (if exists) in BSSWBundle.
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

            public void offerStonecuttingRecipe(ItemLike output, ItemLike... ingredients) {
                offerStonecuttingRecipe(output, 1, ingredients);
            }

            public void offerStonecuttingRecipe(ItemLike output, int count, ItemLike... ingredients) {

                for (ItemLike itemConvertible : ingredients) {
                    SingleItemRecipeBuilder var10000 = SingleItemRecipeBuilder.stonecutting(Ingredient.of(itemConvertible), RecipeCategory.BUILDING_BLOCKS, output, count).unlockedBy(getHasName(itemConvertible), has(itemConvertible));
                    String var10002 = getConversionRecipeName(output, itemConvertible);
                    var10000.save(exporter, var10002 + "_stonecutting");
                }
            }

            public void generateForEnabledBlockFamilies(FeatureFlagSet flagSet) {
                BlockusFamilies.getAllFamilies().forEach((family) -> this.generateRecipes(family, flagSet));
            }
        };
    }

    @Override
    public String getName() {
        return "Blockus Recipes";
    }
}
