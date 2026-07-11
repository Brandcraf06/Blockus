package com.brand.blockus.datagen.providers;

import com.brand.blockus.datagen.family.BlockusFamilies;
import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.registry.tag.BlockusItemTags;
import com.brand.blockus.utils.helper.BlockMaps;
import com.brand.blockus.utils.helper.BlockOrder;
import com.brand.blockus.utils.helper.WoodMaps;
import com.google.common.collect.ImmutableMap;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;


public class BlockusRecipeProvider extends FabricRecipeProvider {
    public BlockusRecipeProvider(FabricPackOutput result, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(result, registriesFuture);
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
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registriesFuture, RecipeOutput output) {
        return new RecipeProvider(registriesFuture, output) {
            @Override
            public void buildRecipes() {

                for (BSSWBundle bundle : BSSWBundle.values()) {
                    blockStairsSlab(bundle.block(), bundle.stairs(), bundle.slab());
                    if (bundle.wall() != null) {
                        wall(RecipeCategory.DECORATIONS, bundle.wall(), bundle.block());
                    }
                }

                for (ConcreteBundle bundle : ConcreteBundle.values()) {
                    for (Map.Entry<DyeColor, ConcreteBundle.ConcreteVariants> entry : bundle.colorMap().entrySet()) {
                        ConcreteBundle.ConcreteVariants variants = entry.getValue();
                        Block base = BlockMaps.CONCRETE_MAP.get(entry.getKey());
                        stairs(variants.stairs(), variants.block());
                        slab(RecipeCategory.BUILDING_BLOCKS, variants.slab(), variants.block());
                        wall(RecipeCategory.DECORATIONS, variants.wall(), variants.block());
                        stonecuttingRecipe(variants.block(), base);
                        stonecuttingRecipe(variants.stairs(), base, variants.block());
                        stonecuttingRecipe(variants.slab(), 2, base, variants.block());
                        stonecuttingRecipe(RecipeCategory.DECORATIONS, variants.wall(), base, variants.block());
                        stonecuttingRecipe(variants.chiseled(), base, variants.block());
                        stonecuttingRecipe(variants.pillar(), base, variants.block());
                        twoByTwoToFour(variants.block(), base);
                    }
                }

                for (AsphaltBundle.AsphaltVariants variants : ASPHALT.colorMap().values()) {
                    stairs(variants.stairs(), variants.block());
                    slab(RecipeCategory.BUILDING_BLOCKS, variants.slab(), variants.block());
                    stonecuttingRecipe(variants.stairs(), variants.block());
                    stonecuttingRecipe(variants.slab(), 2, variants.block());
                }

                for (WoolBundle bundle : WoolBundle.values()) {
                    for (Map.Entry<DyeColor, WoolBundle.WoolVariants> entry : bundle.colorMap().entrySet()) {
                        WoolBundle.WoolVariants variants = entry.getValue();
                        if (bundle == PATTERNED_WOOL) {
                            patternedWool(variants.block(), BlockMaps.WOOL_MAP.get(entry.getKey()), variants.carpet(), BlockMaps.CARPET_MAP.get(entry.getKey()));
                        } else if (bundle == GINGHAM_WOOL) {
                            ginghamWool(variants.block(), BlockMaps.WOOL_MAP.get(entry.getKey()));
                        }

                        stairs(variants.stairs(), variants.block());
                        slab(RecipeCategory.BUILDING_BLOCKS, variants.slab(), variants.block());
                        carpet(variants.carpet(), variants.block());
                    }
                }

                for (ColoredTilesBundle bundle : ColoredTilesBundle.values()) {
                    coloredTiles(bundle.block(), bundle.tile1(), bundle.tile2());
                }

                generateForEnabledBlockFamilies(FeatureFlagSet.of(FeatureFlags.VANILLA));

                pillar(MUD_BRICK_PILLAR, Blocks.MUD_BRICKS);
                chiseled(CHISELED_MUD_BRICKS, Blocks.MUD_BRICK_SLAB);
                stonecuttingRecipe(CHISELED_MUD_BRICKS, Blocks.MUD_BRICKS);

                // Stone
                blockStairsSlabWallCuttingRecipe(COBBLESTONE_BRICKS, Blocks.COBBLESTONE, Blocks.STONE);
                blockStairsSlabWallCuttingRecipe(MOSSY_COBBLESTONE_BRICKS, Blocks.MOSSY_COBBLESTONE);
                mossyBlocks(MOSSY_COBBLESTONE_BRICKS.block(), COBBLESTONE_BRICKS.block());
                blockStairsSlabWallCuttingRecipe(STONE_TILES, Blocks.STONE, Blocks.STONE_BRICKS);
                twoByTwoToFour(STONE_TILES.block(), Blocks.STONE_BRICKS);
                pillar(STONE_BRICK_PILLAR, Blocks.STONE_BRICKS, Blocks.STONE);
                herringbone(HERRINGBONE_STONE_BRICKS, Blocks.STONE_BRICKS, Blocks.STONE);
                stonecuttingRecipe(STONE_CIRCULAR_PAVING, Blocks.STONE, Blocks.STONE_BRICKS);
                stonecuttingRecipe(SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
                stairs(SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
                sturdyBlocks(STURDY_STONE, Blocks.STONE, Blocks.COBBLESTONE);
                stoneDoorTrapdoor(STONE_DOOR, STONE_TRAPDOOR, Blocks.STONE, Blocks.STONE_SLAB);

                // Andesite
                blockStairsSlabWallCuttingRecipe(ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
                twoByTwoToFour(ANDESITE_BRICKS.block(), Blocks.POLISHED_ANDESITE);
                smeltingResultFromBase(CRACKED_ANDESITE_BRICKS, ANDESITE_BRICKS.block());
                chiseled(CHISELED_ANDESITE_BRICKS, ANDESITE_BRICKS.slab(), ANDESITE_BRICKS.block(), Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
                pillar(POLISHED_ANDESITE_PILLAR, ANDESITE_BRICKS.block(), Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
                herringbone(HERRINGBONE_ANDESITE_BRICKS, ANDESITE_BRICKS.block(), Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
                stonecuttingRecipe(ANDESITE_CIRCULAR_PAVING, ANDESITE_BRICKS.block(), Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
                pressurePlateButton(POLISHED_ANDESITE_PRESSURE_PLATE, POLISHED_ANDESITE_BUTTON, Blocks.POLISHED_ANDESITE);

                // Diorite
                blockStairsSlabWallCuttingRecipe(DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
                twoByTwoToFour(DIORITE_BRICKS.block(), Blocks.POLISHED_DIORITE);
                smeltingResultFromBase(CRACKED_DIORITE_BRICKS, DIORITE_BRICKS.block());
                chiseled(CHISELED_DIORITE_BRICKS, DIORITE_BRICKS.slab(), DIORITE_BRICKS.block(), Blocks.DIORITE, Blocks.POLISHED_DIORITE);
                pillar(POLISHED_DIORITE_PILLAR, DIORITE_BRICKS.block(), Blocks.DIORITE, Blocks.POLISHED_DIORITE);
                herringbone(HERRINGBONE_DIORITE_BRICKS, DIORITE_BRICKS.block(), Blocks.DIORITE, Blocks.POLISHED_DIORITE);
                stonecuttingRecipe(DIORITE_CIRCULAR_PAVING, DIORITE_BRICKS.block(), Blocks.DIORITE, Blocks.POLISHED_DIORITE);
                pressurePlateButton(POLISHED_DIORITE_PRESSURE_PLATE, POLISHED_DIORITE_BUTTON, Blocks.POLISHED_DIORITE);

                // Granite
                blockStairsSlabWallCuttingRecipe(GRANITE_BRICKS, Blocks.GRANITE, Blocks.POLISHED_GRANITE);
                twoByTwoToFour(GRANITE_BRICKS.block(), Blocks.POLISHED_GRANITE);
                smeltingResultFromBase(CRACKED_GRANITE_BRICKS, GRANITE_BRICKS.block());
                chiseled(CHISELED_GRANITE_BRICKS, GRANITE_BRICKS.slab(), GRANITE_BRICKS.block(), Blocks.GRANITE, Blocks.POLISHED_GRANITE);
                pillar(POLISHED_GRANITE_PILLAR, GRANITE_BRICKS.block(), Blocks.GRANITE, Blocks.POLISHED_GRANITE);
                herringbone(HERRINGBONE_GRANITE_BRICKS, GRANITE_BRICKS.block(), Blocks.GRANITE, Blocks.POLISHED_GRANITE);
                stonecuttingRecipe(GRANITE_CIRCULAR_PAVING, GRANITE_BRICKS.block(), Blocks.GRANITE, Blocks.POLISHED_GRANITE);
                pressurePlateButton(POLISHED_GRANITE_PRESSURE_PLATE, POLISHED_GRANITE_BUTTON, Blocks.POLISHED_GRANITE);

                // Dripstone
                blockStairsSlabWallCuttingRecipe(POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
                twoByTwoToFour(POLISHED_DRIPSTONE.block(), Blocks.DRIPSTONE_BLOCK);
                blockStairsSlabWallCuttingRecipe(DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block());
                twoByTwoToFour(DRIPSTONE_BRICKS.block(), POLISHED_DRIPSTONE.block());
                mossyBlocks(MOSSY_DRIPSTONE_BRICKS.block(), DRIPSTONE_BRICKS.block());
                blockStairsSlabWallCuttingRecipe(MOSSY_DRIPSTONE_BRICKS);
                smeltingResultFromBase(CRACKED_DRIPSTONE_BRICKS, DRIPSTONE_BRICKS.block());
                chiseled(CHISELED_DRIPSTONE, DRIPSTONE_BRICKS.slab(), DRIPSTONE_BRICKS.block(), Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block());
                pillar(DRIPSTONE_PILLAR, DRIPSTONE_BRICKS.block(), Blocks.DRIPSTONE_BLOCK, POLISHED_DRIPSTONE.block());

                // Tuff
                blockStairsSlabWallCuttingRecipe(TUFF_TILES, Blocks.TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF);
                twoByTwoToFour(TUFF_TILES.block(), Blocks.TUFF_BRICKS);
                smeltingResultFromBase(CRACKED_TUFF_BRICKS, Blocks.TUFF_BRICKS);
                mossyBlocks(MOSSY_TUFF_BRICKS.block(), Blocks.TUFF_BRICKS);
                blockStairsSlabWallCuttingRecipe(MOSSY_TUFF_BRICKS);
                stonecuttingRecipe(CARVED_TUFF_BRICKS, Blocks.TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF);
                pillar(TUFF_PILLAR, Blocks.TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF);
                herringbone(HERRINGBONE_TUFF_BRICKS, Blocks.TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF);
                stonecuttingRecipe(TUFF_CIRCULAR_PAVING, Blocks.TUFF_BRICKS, Blocks.TUFF, Blocks.POLISHED_TUFF);
                pressurePlateButton(POLISHED_TUFF_PRESSURE_PLATE, POLISHED_TUFF_BUTTON, Blocks.POLISHED_TUFF);

                // Amethyst
                blockStairsSlabWallCuttingRecipe(POLISHED_AMETHYST, Blocks.AMETHYST_BLOCK);
                twoByTwoToFour(POLISHED_AMETHYST.block(), Blocks.AMETHYST_BLOCK);
                blockStairsSlabWallCuttingRecipe(AMETHYST_BRICKS, Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block());
                twoByTwoToFour(AMETHYST_BRICKS.block(), POLISHED_AMETHYST.block());
                chiseled(CHISELED_AMETHYST, AMETHYST_BRICKS.slab(), AMETHYST_BRICKS.block(), Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block());
                pillar(AMETHYST_PILLAR, AMETHYST_BRICKS.block(), Blocks.AMETHYST_BLOCK, POLISHED_AMETHYST.block());
                shaped(RecipeCategory.REDSTONE, AMETHYST_LAMP).define('#', Items.AMETHYST_SHARD).define('X', Items.REDSTONE).pattern(" # ").pattern("#X#").pattern(" # ").unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(output);

                // Deepslate
                blockStairsSlabWallCuttingRecipe(COBBLED_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE);
                mossyBlocks(MOSSY_DEEPSLATE_BRICKS.block(), Blocks.DEEPSLATE_BRICKS);
                blockStairsSlabWallCuttingRecipe(MOSSY_DEEPSLATE_BRICKS);
                pillar(DEEPSLATE_PILLAR, Blocks.DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE);
                herringbone(HERRINGBONE_DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE);
                stonecuttingRecipe(DEEPSLATE_CIRCULAR_PAVING, Blocks.DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE);
                sturdyBlocks(STURDY_DEEPSLATE, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
                pressurePlateButton(POLISHED_DEEPSLATE_PRESSURE_PLATE, POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);

                // Sculk
                blockStairsSlabWallCuttingRecipe(POLISHED_SCULK, Blocks.SCULK);
                twoByTwoToFour(POLISHED_SCULK.block(), Blocks.SCULK);
                blockStairsSlabWallCuttingRecipe(SCULK_BRICKS, Blocks.SCULK, POLISHED_SCULK.block());
                chiseled(CHISELED_SCULK_BRICKS, SCULK_BRICKS.slab(), SCULK_BRICKS.block(), Blocks.SCULK, POLISHED_SCULK.block());
                pillar(SCULK_PILLAR, SCULK_BRICKS.block(), Blocks.SCULK, POLISHED_SCULK.block());
                twoByTwoToFour(SCULK_BRICKS.block(), POLISHED_SCULK.block());
                pressurePlateButton(POLISHED_SCULK_PRESSURE_PLATE, POLISHED_SCULK_BUTTON, POLISHED_SCULK.block());

                // Blackstone
                blockStairsSlabWallCuttingRecipe(POLISHED_BLACKSTONE_TILES, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
                twoByTwoToFour(POLISHED_BLACKSTONE_TILES.block(), Blocks.POLISHED_BLACKSTONE_BRICKS);
                pillar(POLISHED_BLACKSTONE_PILLAR, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
                herringbone(HERRINGBONE_POLISHED_BLACKSTONE_BRICKS, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
                stonecuttingRecipe(POLISHED_BLACKSTONE_CIRCULAR_PAVING, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
                shapeless(RecipeCategory.BUILDING_BLOCKS, CRIMSON_WARTY_BLACKSTONE_BRICKS.block()).requires(Blocks.POLISHED_BLACKSTONE_BRICKS).requires(Blocks.CRIMSON_ROOTS).unlockedBy("has_roots", has(Blocks.CRIMSON_ROOTS)).save(output);
                blockStairsSlabWallCuttingRecipe(CRIMSON_WARTY_BLACKSTONE_BRICKS);
                shapeless(RecipeCategory.BUILDING_BLOCKS, WARPED_WARTY_BLACKSTONE_BRICKS.block()).requires(Blocks.POLISHED_BLACKSTONE_BRICKS).requires(BlockusItemTags.WARPED_NETHER_GRASS).unlockedBy("has_roots", has(BlockusItemTags.WARPED_NETHER_GRASS)).save(output);
                blockStairsSlabWallCuttingRecipe(WARPED_WARTY_BLACKSTONE_BRICKS);
                sturdyBlocks(STURDY_BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
                decoratedBlocks(GOLD_DECORATED_POLISHED_BLACKSTONE, Items.GOLD_INGOT, Blocks.POLISHED_BLACKSTONE);
                stoneDoorTrapdoor(BLACKSTONE_DOOR, BLACKSTONE_TRAPDOOR, Blocks.BLACKSTONE, Blocks.BLACKSTONE_SLAB);

                // Basalt
                blockStairsSlabWallCuttingRecipe(ROUGH_BASALT);
                shaped(RecipeCategory.BUILDING_BLOCKS, ROUGH_BASALT.block(), 2).define('#', Blocks.BASALT).pattern("#").pattern("#").unlockedBy("has_basalt", has(Blocks.BASALT)).save(output);
                blockStairsSlabWallCuttingRecipe(POLISHED_BASALT_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT);
                twoByTwoToFour(POLISHED_BASALT_BRICKS.block(), Blocks.POLISHED_BASALT);
                smeltingResultFromBase(CRACKED_POLISHED_BASALT_BRICKS, POLISHED_BASALT_BRICKS.block());
                chiseled(CHISELED_POLISHED_BASALT, POLISHED_BASALT_BRICKS.slab(), POLISHED_BASALT_BRICKS.block(), Blocks.BASALT, Blocks.POLISHED_BASALT);
                pillar(POLISHED_BASALT_PILLAR, POLISHED_BASALT_BRICKS.block(), Blocks.BASALT, Blocks.POLISHED_BASALT);
                herringbone(HERRINGBONE_POLISHED_BASALT_BRICKS, POLISHED_BASALT_BRICKS.block(), Blocks.BASALT, Blocks.POLISHED_BASALT);
                stonecuttingRecipe(POLISHED_BASALT_CIRCULAR_PAVING, POLISHED_BASALT_BRICKS.block(), Blocks.BASALT, Blocks.POLISHED_BASALT);
                pressurePlateButton(POLISHED_BASALT_PRESSURE_PLATE, POLISHED_BASALT_BUTTON, Blocks.POLISHED_BASALT);

                // Wart Blocks
                blockStairsSlabWallCuttingRecipe(CRIMSON_WART_BRICKS, Blocks.NETHER_WART_BLOCK);
                twoByTwoToFour(CRIMSON_WART_BRICKS.block(), Blocks.NETHER_WART_BLOCK);
                blockStairsSlabWallCuttingRecipe(WARPED_WART_BRICKS, Blocks.WARPED_WART_BLOCK);
                twoByTwoToFour(WARPED_WART_BRICKS.block(), Blocks.WARPED_WART_BLOCK);
                threeByThreePacker(RecipeCategory.BUILDING_BLOCKS, Blocks.NETHER_WART_BLOCK, Items.CRIMSON_ROOTS);

                // Limestone
                blockStairsSlabWallCuttingRecipe(LIMESTONE);
                shaped(RecipeCategory.BUILDING_BLOCKS, LIMESTONE.block()).define('#', Blocks.COBBLESTONE).define('X', Items.BONE_MEAL).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE)).save(output);
                blockStairsSlabWallCuttingRecipe(POLISHED_LIMESTONE, LIMESTONE.block());
                twoByTwoToFour(POLISHED_LIMESTONE.block(), LIMESTONE.block());
                blockStairsSlabWallCuttingRecipe(LIMESTONE_BRICKS, LIMESTONE.block(), POLISHED_LIMESTONE.block());
                twoByTwoToFour(LIMESTONE_BRICKS.block(), POLISHED_LIMESTONE.block());
                blockStairsSlabWallCuttingRecipe(SMALL_LIMESTONE_BRICKS, LIMESTONE_BRICKS.block(), LIMESTONE.block(), POLISHED_LIMESTONE.block());
                blockStairsSlabWallCuttingRecipe(LIMESTONE_TILES, LIMESTONE_BRICKS.block(), LIMESTONE.block(), POLISHED_LIMESTONE.block());
                twoByTwoToFour(LIMESTONE_TILES.block(), LIMESTONE_BRICKS.block());
                chiseled(CHISELED_LIMESTONE, LIMESTONE.slab(), LIMESTONE_BRICKS.block(), LIMESTONE.block(), POLISHED_LIMESTONE.block());
                chiseled(CHISELED_LIMESTONE_BRICKS, LIMESTONE_BRICKS.slab(), LIMESTONE_BRICKS.block(), LIMESTONE.block(), POLISHED_LIMESTONE.block());
                pillar(CHISELED_LIMESTONE_PILLAR, LIMESTONE_PILLAR, LIMESTONE_BRICKS.block(), LIMESTONE.block(), POLISHED_LIMESTONE.block());
                pillar(LIMESTONE_PILLAR, LIMESTONE_BRICKS.block(), LIMESTONE.block(), POLISHED_LIMESTONE.block());
                blockStairsSlabWallCuttingRecipe(LIMESTONE_SQUARES, LIMESTONE_BRICKS.block(), LIMESTONE.block(), POLISHED_LIMESTONE.block());
                stonecuttingRecipe(LIMESTONE_CIRCULAR_PAVING, LIMESTONE_BRICKS.block(), LIMESTONE.block(), POLISHED_LIMESTONE.block());
                stonecuttingRecipe(LIMESTONE_LINES, LIMESTONE_BRICKS.block(), LIMESTONE.block(), POLISHED_LIMESTONE.block());
                pressurePlateButton(LIMESTONE_PRESSURE_PLATE, LIMESTONE_BUTTON, LIMESTONE.block());

                // Marble
                blockStairsSlabWallCuttingRecipe(MARBLE);
                shaped(RecipeCategory.BUILDING_BLOCKS, MARBLE.block()).define('#', LIMESTONE.block()).define('X', Items.BONE_MEAL).pattern("#X").pattern("X#").group("marble").unlockedBy(getHasName(LIMESTONE.block()), has(LIMESTONE.block())).save(output);
                shapeless(RecipeCategory.BUILDING_BLOCKS, MARBLE.block()).requires(Blocks.CALCITE).requires(LIMESTONE.block()).group("marble").unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(output, getConversionRecipeName(MARBLE.block(), Blocks.CALCITE));
                blockStairsSlabWallCuttingRecipe(POLISHED_MARBLE, MARBLE.block());
                twoByTwoToFour(POLISHED_MARBLE.block(), MARBLE.block());
                blockStairsSlabWallCuttingRecipe(MARBLE_BRICKS, MARBLE.block(), POLISHED_MARBLE.block());
                twoByTwoToFour(MARBLE_BRICKS.block(), POLISHED_MARBLE.block());
                blockStairsSlabWallCuttingRecipe(SMALL_MARBLE_BRICKS, MARBLE_BRICKS.block(), MARBLE.block(), POLISHED_MARBLE.block());
                blockStairsSlabWallCuttingRecipe(MARBLE_TILES, MARBLE_BRICKS.block(), MARBLE.block(), POLISHED_MARBLE.block());
                twoByTwoToFour(MARBLE_TILES.block(), MARBLE_BRICKS.block());
                chiseled(CHISELED_MARBLE, MARBLE.slab(), MARBLE_BRICKS.block(), MARBLE.block(), POLISHED_MARBLE.block());
                chiseled(CHISELED_MARBLE_BRICKS, MARBLE_BRICKS.slab(), MARBLE_BRICKS.block(), MARBLE.block(), POLISHED_MARBLE.block());
                pillar(CHISELED_MARBLE_PILLAR, MARBLE_PILLAR, MARBLE_BRICKS.block(), MARBLE.block(), POLISHED_MARBLE.block());
                pillar(MARBLE_PILLAR, MARBLE_BRICKS.block(), MARBLE.block(), POLISHED_MARBLE.block());
                blockStairsSlabWallCuttingRecipe(MARBLE_SQUARES, MARBLE_BRICKS.block(), MARBLE.block(), POLISHED_MARBLE.block());
                stonecuttingRecipe(MARBLE_CIRCULAR_PAVING, MARBLE_BRICKS.block(), MARBLE.block(), POLISHED_MARBLE.block());
                stonecuttingRecipe(MARBLE_LINES, MARBLE_BRICKS.block(), MARBLE.block(), POLISHED_MARBLE.block());
                pressurePlateButton(MARBLE_PRESSURE_PLATE, MARBLE_BUTTON, MARBLE.block());

                // Bluestone
                blockStairsSlabWallCuttingRecipe(BLUESTONE);
                shaped(RecipeCategory.BUILDING_BLOCKS, BLUESTONE.block(), 4).define('S', Blocks.STONE).define('#', Items.BLUE_DYE).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Items.BLUE_DYE), has(Items.BLUE_DYE)).unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE)).save(output);
                blockStairsSlabWallCuttingRecipe(POLISHED_BLUESTONE, BLUESTONE.block());
                twoByTwoToFour(POLISHED_BLUESTONE.block(), BLUESTONE.block());
                blockStairsSlabWallCuttingRecipe(BLUESTONE_BRICKS, BLUESTONE.block(), POLISHED_BLUESTONE.block());
                twoByTwoToFour(BLUESTONE_BRICKS.block(), POLISHED_BLUESTONE.block());
                blockStairsSlabWallCuttingRecipe(SMALL_BLUESTONE_BRICKS, BLUESTONE_BRICKS.block(), BLUESTONE.block(), POLISHED_BLUESTONE.block());
                blockStairsSlabWallCuttingRecipe(BLUESTONE_TILES, BLUESTONE_BRICKS.block(), BLUESTONE.block(), POLISHED_BLUESTONE.block());
                twoByTwoToFour(BLUESTONE_TILES.block(), BLUESTONE_BRICKS.block());
                chiseled(CHISELED_BLUESTONE, BLUESTONE.slab(), BLUESTONE_BRICKS.block(), BLUESTONE.block(), POLISHED_BLUESTONE.block());
                chiseled(CHISELED_BLUESTONE_BRICKS, BLUESTONE_BRICKS.slab(), BLUESTONE_BRICKS.block(), BLUESTONE.block(), POLISHED_BLUESTONE.block());
                pillar(CHISELED_BLUESTONE_PILLAR, BLUESTONE_PILLAR, BLUESTONE_BRICKS.block(), BLUESTONE.block(), POLISHED_BLUESTONE.block());
                pillar(BLUESTONE_PILLAR, BLUESTONE_BRICKS.block(), BLUESTONE.block(), POLISHED_BLUESTONE.block());
                blockStairsSlabWallCuttingRecipe(BLUESTONE_SQUARES, BLUESTONE_BRICKS.block(), BLUESTONE.block(), POLISHED_BLUESTONE.block());
                stonecuttingRecipe(BLUESTONE_CIRCULAR_PAVING, BLUESTONE_BRICKS.block(), BLUESTONE.block(), POLISHED_BLUESTONE.block());
                stonecuttingRecipe(BLUESTONE_LINES, BLUESTONE_BRICKS.block(), BLUESTONE.block(), POLISHED_BLUESTONE.block());
                pressurePlateButton(BLUESTONE_PRESSURE_PLATE, BLUESTONE_BUTTON, BLUESTONE.block());

                // Viridite
                blockStairsSlabWallCuttingRecipe(VIRIDITE);
                shaped(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block(), 4).define('S', Blocks.DEEPSLATE).define('#', Blocks.SCULK).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Blocks.SCULK), has(Blocks.SCULK)).unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, VIRIDITE.block(), 4).define('S', Blocks.DEEPSLATE).define('#', Items.GREEN_DYE).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE)).unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE)).save(output, getConversionRecipeName(VIRIDITE.block(), Items.GREEN_DYE));
                blockStairsSlabWallCuttingRecipe(POLISHED_VIRIDITE, VIRIDITE.block());
                twoByTwoToFour(POLISHED_VIRIDITE.block(), VIRIDITE.block());
                blockStairsSlabWallCuttingRecipe(VIRIDITE_BRICKS, VIRIDITE.block(), POLISHED_VIRIDITE.block());
                twoByTwoToFour(VIRIDITE_BRICKS.block(), POLISHED_VIRIDITE.block());
                blockStairsSlabWallCuttingRecipe(SMALL_VIRIDITE_BRICKS, VIRIDITE_BRICKS.block(), VIRIDITE.block(), POLISHED_VIRIDITE.block());
                blockStairsSlabWallCuttingRecipe(VIRIDITE_TILES, VIRIDITE_BRICKS.block(), VIRIDITE.block(), POLISHED_VIRIDITE.block());
                twoByTwoToFour(VIRIDITE_TILES.block(), VIRIDITE_BRICKS.block());
                chiseled(CHISELED_VIRIDITE, VIRIDITE.slab(), VIRIDITE_BRICKS.block(), VIRIDITE.block(), POLISHED_VIRIDITE.block());
                chiseled(CHISELED_VIRIDITE_BRICKS, VIRIDITE_BRICKS.slab(), VIRIDITE_BRICKS.block(), VIRIDITE.block(), POLISHED_VIRIDITE.block());
                pillar(CHISELED_VIRIDITE_PILLAR, VIRIDITE_PILLAR, VIRIDITE_BRICKS.block(), VIRIDITE.block(), POLISHED_VIRIDITE.block());
                pillar(VIRIDITE_PILLAR, VIRIDITE_BRICKS.block(), VIRIDITE.block(), POLISHED_VIRIDITE.block());
                blockStairsSlabWallCuttingRecipe(VIRIDITE_SQUARES, VIRIDITE_BRICKS.block(), VIRIDITE.block(), POLISHED_VIRIDITE.block());
                stonecuttingRecipe(VIRIDITE_CIRCULAR_PAVING, VIRIDITE_BRICKS.block(), VIRIDITE.block(), POLISHED_VIRIDITE.block());
                stonecuttingRecipe(VIRIDITE_LINES, VIRIDITE_BRICKS.block(), VIRIDITE.block(), POLISHED_VIRIDITE.block());
                pressurePlateButton(VIRIDITE_PRESSURE_PLATE, VIRIDITE_BUTTON, VIRIDITE.block());

                // Lava	Bricks
                blockStairsSlabWallCuttingRecipe(LAVA_BRICKS);
                chiseled(CHISELED_LAVA_BRICKS, LAVA_BRICKS.slab(), LAVA_BRICKS.block());
                enclosedRecipeToEight(LAVA_BRICKS.block(), Ingredient.of(Blocks.STONE_BRICKS), Items.LAVA_BUCKET).unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET)).unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(output);

                // Lava Blackstone Bricks
                blockStairsSlabWallCuttingRecipe(LAVA_POLISHED_BLACKSTONE_BRICKS);
                chiseled(CHISELED_LAVA_POLISHED_BLACKSTONE, LAVA_POLISHED_BLACKSTONE_BRICKS.slab(), LAVA_POLISHED_BLACKSTONE_BRICKS.block());
                enclosedRecipeToEight(LAVA_POLISHED_BLACKSTONE_BRICKS.block(), Ingredient.of(Blocks.POLISHED_BLACKSTONE_BRICKS), Items.LAVA_BUCKET).unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET)).unlockedBy(getHasName(Blocks.POLISHED_BLACKSTONE_BRICKS), has(Blocks.POLISHED_BLACKSTONE_BRICKS)).save(output);

                // Water Bricks
                blockStairsSlabWallCuttingRecipe(WATER_BRICKS);
                chiseled(CHISELED_WATER_BRICKS, WATER_BRICKS.slab(), WATER_BRICKS.block());
                enclosedRecipeToEight(WATER_BRICKS.block(), Ingredient.of(Blocks.STONE_BRICKS), Items.WATER_BUCKET).unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET)).unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(output);

                // Snow Bricks
                blockStairsSlabWallCuttingRecipe(SNOW_BRICKS);
                pillar(SNOW_PILLAR, SNOW_BRICKS.block());
                twoByTwoToFour(SNOW_BRICKS.block(), Blocks.SNOW_BLOCK);

                // Ice Bricks
                stonecuttingRecipe(ICE_BRICK_WALL, ICE_BRICKS);
                pillar(ICE_PILLAR, ICE_BRICKS);
                twoByTwoRecipe(RecipeCategory.BUILDING_BLOCKS, ICE_BRICKS, BlockusItemTags.NATURAL_ICE, 4, "has_ice");
                wall(RecipeCategory.BUILDING_BLOCKS, ICE_BRICK_WALL, ICE_BRICKS);

                // Magma Bricks
                blockStairsSlabWallCuttingRecipe(MAGMA_BRICKS, Blocks.MAGMA_BLOCK);
                twoByTwoToFour(MAGMA_BRICKS.block(), Blocks.MAGMA_BLOCK);
                blockStairsSlabWallCuttingRecipe(SMALL_MAGMA_BRICKS, MAGMA_BRICKS.block(), Blocks.MAGMA_BLOCK);
                chiseled(CHISELED_MAGMA_BRICKS, MAGMA_BRICKS.slab(), MAGMA_BRICKS.block(), Blocks.MAGMA_BLOCK);

                // Blaze Bricks
                blockStairsSlabWallCuttingRecipe(BLAZE_BRICKS);
                pillar(BLAZE_PILLAR, BLAZE_BRICKS.block());
                shaped(RecipeCategory.BUILDING_BLOCKS, BLAZE_BRICKS.block()).define('#', Items.BLAZE_POWDER).define('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").unlockedBy("has_blaze_rod", has(Items.BLAZE_ROD)).save(output);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.BLAZE_POWDER, RecipeCategory.BUILDING_BLOCKS, BLAZE_LANTERN);

                // Netherrack
                blockStairsSlabWallCuttingRecipe(POLISHED_NETHERRACK, Blocks.NETHERRACK);
                twoByTwoToFour(POLISHED_NETHERRACK.block(), Blocks.NETHERRACK);
                blockStairsSlabWallCuttingRecipe(NETHERRACK_BRICKS, Blocks.NETHERRACK, POLISHED_NETHERRACK.block());
                stonecuttingRecipe(NETHERRACK_CIRCULAR_PAVING, NETHERRACK_BRICKS.block(), Blocks.NETHERRACK, POLISHED_NETHERRACK.block());
                pressurePlateButton(POLISHED_NETHERRACK_PRESSURE_PLATE, POLISHED_NETHERRACK_BUTTON, POLISHED_NETHERRACK.block());

                // Nether Bricks
                blockStairsSlabWallCuttingRecipe(POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
                twoByTwoToFour(POLISHED_NETHER_BRICKS.block(), Blocks.NETHER_BRICKS);
                pillar(NETHER_BRICK_PILLAR, Blocks.NETHER_BRICKS);
                herringbone(HERRINGBONE_NETHER_BRICKS, Blocks.NETHER_BRICKS);

                blockStairsSlabWallCuttingRecipe(POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
                twoByTwoToFour(POLISHED_RED_NETHER_BRICKS.block(), Blocks.RED_NETHER_BRICKS);
                pillar(RED_NETHER_BRICK_PILLAR, Blocks.RED_NETHER_BRICKS);
                herringbone(HERRINGBONE_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);

                blockStairsSlabWallCuttingRecipe(NETHER_TILES);
                shaped(RecipeCategory.BUILDING_BLOCKS, NETHER_TILES.block(), 4).define('#', Blocks.NETHERRACK).define('X', Blocks.NETHER_BRICKS).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.NETHER_BRICKS), has(Blocks.NETHER_BRICKS)).save(output);

                // Charred Nether Bricks
                blockStairsSlabWallCuttingRecipe(CHARRED_NETHER_BRICKS);
                blockStairsSlabWallCuttingRecipe(POLISHED_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block());
                twoByTwoToFour(POLISHED_CHARRED_NETHER_BRICKS.block(), CHARRED_NETHER_BRICKS.block());
                herringbone(HERRINGBONE_CHARRED_NETHER_BRICKS, CHARRED_NETHER_BRICKS.block());
                pillar(CHARRED_NETHER_BRICK_PILLAR, CHARRED_NETHER_BRICKS.block());
                enclosedRecipeToEight(CHARRED_NETHER_BRICKS.block(), Ingredient.of(Blocks.NETHER_BRICKS), Items.FIRE_CHARGE).unlockedBy(getHasName(Items.FIRE_CHARGE), has(Items.FIRE_CHARGE)).unlockedBy(getHasName(Blocks.NETHER_BRICKS), has(Blocks.NETHER_BRICKS)).save(output);

                // Teal Nether Bricks
                blockStairsSlabWallCuttingRecipe(TEAL_NETHER_BRICKS);
                blockStairsSlabWallCuttingRecipe(POLISHED_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block());
                twoByTwoToFour(POLISHED_TEAL_NETHER_BRICKS.block(), TEAL_NETHER_BRICKS.block());
                herringbone(HERRINGBONE_TEAL_NETHER_BRICKS, TEAL_NETHER_BRICKS.block());
                pillar(TEAL_NETHER_BRICK_PILLAR, TEAL_NETHER_BRICKS.block());
                shaped(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block()).define('#', BlockusItemTags.WARPED_NETHER_GRASS).define('X', Items.NETHER_BRICK).pattern("#X").pattern("X#").group("teal_nether_bricks").unlockedBy("has_warped_grass", has(BlockusItemTags.WARPED_NETHER_GRASS)).save(output);
                shapeless(RecipeCategory.BUILDING_BLOCKS, TEAL_NETHER_BRICKS.block(), 2).requires(Blocks.WARPED_WART_BLOCK).requires(Items.NETHER_BRICKS).group("teal_nether_bricks").unlockedBy(getHasName(Blocks.WARPED_WART_BLOCK), has(Blocks.WARPED_WART_BLOCK)).save(output, getConversionRecipeName(TEAL_NETHER_BRICKS.block(), Blocks.WARPED_WART_BLOCK));

                // Obsidian
                blockStairsSlabWallCuttingRecipe(OBSIDIAN_BRICKS, Blocks.OBSIDIAN);
                twoByTwoToFour(OBSIDIAN_BRICKS.block(), Blocks.OBSIDIAN);
                smeltingResultFromBase(CRACKED_OBSIDIAN_BRICKS, OBSIDIAN_BRICKS.block());
                blockStairsSlabWallCuttingRecipe(SMALL_OBSIDIAN_BRICKS, OBSIDIAN_BRICKS.block(), Blocks.OBSIDIAN);
                pillar(OBSIDIAN_PILLAR, OBSIDIAN_BRICKS.block(), Blocks.OBSIDIAN);
                stonecuttingRecipe(OBSIDIAN_CIRCULAR_PAVING, OBSIDIAN_BRICKS.block(), Blocks.OBSIDIAN);
                doorTrapdoor(OBSIDIAN_REINFORCED_DOOR, OBSIDIAN_REINFORCED_TRAPDOOR, Blocks.OBSIDIAN);
                pressurePlate(OBSIDIAN_PRESSURE_PLATE, Blocks.OBSIDIAN);
                shaped(RecipeCategory.BUILDING_BLOCKS, GLOWING_OBSIDIAN, 4).define('S', Blocks.OBSIDIAN).define('#', Blocks.SHROOMLIGHT).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy(getHasName(Blocks.SHROOMLIGHT), has(Blocks.SHROOMLIGHT)).save(output);

                // Ore Bricks
                oreBricks(IRON_BRICKS, Blocks.IRON_BLOCK, Items.IRON_INGOT);
                oreBricks(GOLD_BRICKS, Blocks.GOLD_BLOCK, Items.GOLD_INGOT);
                oreBricks(LAPIS_BRICKS, Blocks.LAPIS_BLOCK, Items.LAPIS_LAZULI);
                redstoneBricks(REDSTONE_BRICKS, Blocks.REDSTONE_BLOCK, Items.REDSTONE);
                oreBricks(EMERALD_BRICKS, Blocks.EMERALD_BLOCK, Items.EMERALD);
                oreBricks(DIAMOND_BRICKS, Blocks.DIAMOND_BLOCK, Items.DIAMOND);
                oreBricks(NETHERITE_BRICKS, Blocks.NETHERITE_BLOCK, Items.NETHERITE_INGOT);

                // Copper
                copperBricks(COPPER_BRICKS, Blocks.WAXED_COPPER_BLOCK, Blocks.CUT_COPPER, Blocks.WAXED_CUT_COPPER);
                copperBricks(EXPOSED_COPPER_BRICKS, Blocks.WAXED_EXPOSED_COPPER, Blocks.EXPOSED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER);
                copperBricks(WEATHERED_COPPER_BRICKS, Blocks.WAXED_WEATHERED_COPPER, Blocks.WEATHERED_CUT_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER);
                copperBricks(OXIDIZED_COPPER_BRICKS, Blocks.WAXED_OXIDIZED_COPPER, Blocks.OXIDIZED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER);

                for (CopperBSSWBundle bundle : CopperBSSWBundle.values()) {
                    waxingRecipes(bundle.block(), bundle.blockWaxed());
                    waxingRecipes(bundle.slab(), bundle.slabWaxed());
                    waxingRecipes(bundle.stairs(), bundle.stairsWaxed());
                    waxingRecipes(RecipeCategory.DECORATIONS, bundle.wall(), bundle.wallWaxed());
                    if (bundle.type().contains("copper_tuff_bricks")) {
                        stonecuttingRecipe(bundle.stairs(), bundle.block());
                        stonecuttingRecipe(bundle.slab(), 2, bundle.block());
                        stonecuttingRecipe(RecipeCategory.DECORATIONS, bundle.wall(), bundle.block());
                        stonecuttingRecipe(bundle.stairsWaxed(), bundle.blockWaxed());
                        stonecuttingRecipe(bundle.slabWaxed(), 2, bundle.blockWaxed());
                        stonecuttingRecipe(RecipeCategory.DECORATIONS, bundle.wallWaxed(), bundle.blockWaxed());
                    }
                }
                shaped(RecipeCategory.BUILDING_BLOCKS, COPPER_TUFF_BRICKS.block(), 2).define('#', Items.COPPER_INGOT).define('X', Blocks.TUFF_BRICKS).pattern("#X").pattern("X#").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).unlockedBy(getHasName(Blocks.TUFF_BRICKS), has(Blocks.TUFF_BRICKS)).save(output);

                // Quartz Blocks
                blockStairsSlabWallCuttingRecipe(QUARTZ_TILES, Blocks.QUARTZ_BRICKS, Blocks.QUARTZ_BLOCK);
                twoByTwoToFour(QUARTZ_TILES.block(), Blocks.QUARTZ_BRICKS);
                stonecuttingRecipe(QUARTZ_CIRCULAR_PAVING, Blocks.QUARTZ_BRICKS, Blocks.QUARTZ_BLOCK);

                // Prismarine
                chiseled(CHISELED_PRISMARINE, Blocks.PRISMARINE_BRICK_SLAB, Blocks.PRISMARINE_BRICKS);
                pillar(PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS);
                stonecuttingRecipe(PRISMARINE_CIRCULAR_PAVING, Blocks.PRISMARINE_BRICKS);
                chiseled(CHISELED_DARK_PRISMARINE, Blocks.DARK_PRISMARINE_SLAB, Blocks.DARK_PRISMARINE);
                pillar(DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE);
                blockStairsSlabWallCuttingRecipe(PRISMARINE_TILES);
                shaped(RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILES.block(), 4).define('#', Blocks.DARK_PRISMARINE).define('X', Items.PRISMARINE_SHARD).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.DARK_PRISMARINE), has(Blocks.DARK_PRISMARINE)).save(output);

                // Bricks
                blockStairsSlabWallCuttingRecipe(LARGE_BRICKS, Blocks.BRICKS);
                twoByTwoToFour(LARGE_BRICKS.block(), Blocks.BRICKS);
                herringbone(HERRINGBONE_BRICKS, Blocks.BRICKS);

                // Soaked Bricks
                blockStairsSlabWallCuttingRecipe(SOAKED_BRICKS);
                herringbone(HERRINGBONE_SOAKED_BRICKS, SOAKED_BRICKS.block());
                enclosedRecipeToEight(SOAKED_BRICKS.block(), Ingredient.of(Blocks.BRICKS), Items.WATER_BUCKET).unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET)).unlockedBy(getHasName(Blocks.BRICKS), has(Blocks.BRICKS)).save(output);

                // Sandy Bricks
                blockStairsSlabWallCuttingRecipe(SANDY_BRICKS);
                herringbone(HERRINGBONE_SANDY_BRICKS, SANDY_BRICKS.block());
                shaped(RecipeCategory.BUILDING_BLOCKS, SANDY_BRICKS.block(), 2).define('S', Blocks.SAND).define('#', Blocks.BRICKS).pattern(" S ").pattern("S#S").pattern(" S ").unlockedBy("has_sand", has(Blocks.SAND)).unlockedBy("has_bricks", has(Blocks.BRICKS)).save(output);

                // Charred Bricks
                blockStairsSlabWallCuttingRecipe(CHARRED_BRICKS);
                herringbone(HERRINGBONE_CHARRED_BRICKS, CHARRED_BRICKS.block());
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, CHARRED_BRICKS.block().asItem(), 0.1F, 200).unlockedBy("has_bricks", has(Blocks.BRICKS)).save(output);

                // Resin Bricks
                blockStairsSlabWallCuttingRecipe(LARGE_RESIN_BRICKS, Blocks.RESIN_BRICKS);
                twoByTwoToFour(LARGE_RESIN_BRICKS.block(), Blocks.RESIN_BRICKS);
                herringbone(HERRINGBONE_RESIN_BRICKS, Blocks.RESIN_BRICKS);
                pillar(RESIN_BRICK_PILLAR, Blocks.RESIN_BRICKS);

                // Sandstone
                blockStairsSlabWallCuttingRecipe(ROUGH_SANDSTONE);
                twoByTwoRecipe(RecipeCategory.BUILDING_BLOCKS, ROUGH_SANDSTONE.block(), Blocks.SANDSTONE_SLAB, 2);
                blockStairsSlabWallCuttingRecipe(SANDSTONE_BRICKS, Blocks.SANDSTONE);
                blockStairsSlabWallCuttingRecipe(SMALL_SANDSTONE_BRICKS, Blocks.SANDSTONE, SANDSTONE_BRICKS.block());
                pillar(SANDSTONE_PILLAR, Blocks.SANDSTONE, SANDSTONE_BRICKS.block());
                decoratedBlocks(GOLD_DECORATED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_SANDSTONE);
                decoratedBlocks(LAPIS_DECORATED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_SANDSTONE);

                // Red Sandstone
                blockStairsSlabWallCuttingRecipe(ROUGH_RED_SANDSTONE);
                twoByTwoRecipe(RecipeCategory.BUILDING_BLOCKS, ROUGH_RED_SANDSTONE.block(), Blocks.RED_SANDSTONE_SLAB, 2);
                blockStairsSlabWallCuttingRecipe(RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE);
                blockStairsSlabWallCuttingRecipe(SMALL_RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block());
                pillar(RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE, RED_SANDSTONE_BRICKS.block());
                decoratedBlocks(GOLD_DECORATED_RED_SANDSTONE, Items.GOLD_INGOT, Blocks.CUT_RED_SANDSTONE);
                decoratedBlocks(LAPIS_DECORATED_RED_SANDSTONE, Items.LAPIS_LAZULI, Blocks.CUT_RED_SANDSTONE);

                // Soul Sandstone
                blockStairsSlabWallCuttingRecipe(SOUL_SANDSTONE);
                twoByTwoRecipe(RecipeCategory.BUILDING_BLOCKS, SOUL_SANDSTONE.block(), BlockusItemTags.SOUL_SOILS, 1, "has_soul_sand");
                blockStairsSlabWallCuttingRecipe(SMOOTH_SOUL_SANDSTONE);
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(SOUL_SANDSTONE.block()), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, SMOOTH_SOUL_SANDSTONE.block().asItem(), 0.1F, 200).unlockedBy("has_soul_sandstone", has(SOUL_SANDSTONE.block())).save(output);
                twoByTwoToFour(CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
                stonecuttingRecipe(CUT_SOUL_SANDSTONE, SOUL_SANDSTONE.block());
                stonecuttingRecipe(CUT_SOUL_SANDSTONE_SLAB, 2, SOUL_SANDSTONE.block(), CUT_SOUL_SANDSTONE);
                slab(RecipeCategory.BUILDING_BLOCKS, CUT_SOUL_SANDSTONE_SLAB, CUT_SOUL_SANDSTONE);

                blockStairsSlabWallCuttingRecipe(ROUGH_SOUL_SANDSTONE);
                twoByTwoRecipe(RecipeCategory.BUILDING_BLOCKS, ROUGH_SOUL_SANDSTONE.block(), SOUL_SANDSTONE.slab(), 2);
                blockStairsSlabWallCuttingRecipe(SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block());
                blockStairsSlabWallCuttingRecipe(SMALL_SOUL_SANDSTONE_BRICKS, SOUL_SANDSTONE.block(), SOUL_SANDSTONE_BRICKS.block());
                chiseled(CHISELED_SOUL_SANDSTONE, SOUL_SANDSTONE.slab(), SOUL_SANDSTONE.block());
                pillar(SOUL_SANDSTONE_PILLAR, SOUL_SANDSTONE.block(), SOUL_SANDSTONE_BRICKS.block());
                decoratedBlocks(GOLD_DECORATED_SOUL_SANDSTONE, Items.GOLD_INGOT, CUT_SOUL_SANDSTONE);
                decoratedBlocks(LAPIS_DECORATED_SOUL_SANDSTONE, Items.LAPIS_LAZULI, CUT_SOUL_SANDSTONE);

                // Honeycomb Bricks
                blockStairsSlabWallCuttingRecipe(HONEYCOMB_BRICKS, Blocks.HONEYCOMB_BLOCK);
                twoByTwoToFour(HONEYCOMB_BRICKS.block(), Blocks.HONEYCOMB_BLOCK);

                // Purpur Blocks
                blockStairsSlabWallCuttingRecipe(POLISHED_PURPUR, Blocks.PURPUR_BLOCK);
                twoByTwoToFour(POLISHED_PURPUR.block(), Blocks.PURPUR_BLOCK);
                blockStairsSlabWallCuttingRecipe(PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block());
                blockStairsSlabWallCuttingRecipe(SMALL_PURPUR_BRICKS, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                chiseled(CHISELED_PURPUR, Blocks.PURPUR_SLAB, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                stonecuttingRecipe(Blocks.PURPUR_PILLAR, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                blockStairsSlabWallCuttingRecipe(PURPUR_SQUARES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());
                stonecuttingRecipe(PURPUR_LINES, Blocks.PURPUR_BLOCK, POLISHED_PURPUR.block(), PURPUR_BRICKS.block());

                // Phantom Purpur Blocks
                blockStairsSlabWallCuttingRecipe(PHANTOM_PURPUR_BLOCK);
                phantomPurpur(PHANTOM_PURPUR_BLOCK.block(), Blocks.PURPUR_BLOCK);
                twoByTwoToFour(POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BLOCK.block());
                blockStairsSlabWallCuttingRecipe(POLISHED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.block());
                phantomPurpur(POLISHED_PHANTOM_PURPUR.block(), POLISHED_PURPUR.block());
                blockStairsSlabWallCuttingRecipe(PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block());
                phantomPurpur(PHANTOM_PURPUR_BRICKS.block(), PURPUR_BRICKS.block());
                twoByTwoToFour(PHANTOM_PURPUR_BRICKS.block(), POLISHED_PHANTOM_PURPUR.block());
                blockStairsSlabWallCuttingRecipe(SMALL_PHANTOM_PURPUR_BRICKS, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                phantomPurpur(SMALL_PHANTOM_PURPUR_BRICKS.block(), PHANTOM_PURPUR_BRICKS.block());
                chiseled(CHISELED_PHANTOM_PURPUR, PHANTOM_PURPUR_BLOCK.slab(), PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                phantomPurpur(CHISELED_PHANTOM_PURPUR, CHISELED_PURPUR);
                pillar(PHANTOM_PURPUR_PILLAR, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                phantomPurpur(PHANTOM_PURPUR_PILLAR, Blocks.PURPUR_PILLAR);
                blockStairsSlabWallCuttingRecipe(PHANTOM_PURPUR_SQUARES, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                phantomPurpur(PHANTOM_PURPUR_SQUARES.block(), PURPUR_SQUARES.block());
                stonecuttingRecipe(PHANTOM_PURPUR_LINES, PHANTOM_PURPUR_BLOCK.block(), POLISHED_PHANTOM_PURPUR.block(), PHANTOM_PURPUR_BRICKS.block());
                phantomPurpur(PHANTOM_PURPUR_LINES, PURPUR_LINES);

                // End Stone
                blockStairsSlabWallCuttingRecipe(POLISHED_END_STONE, Blocks.END_STONE);
                twoByTwoToFour(POLISHED_END_STONE.block(), Blocks.END_STONE);
                stonecuttingRecipe(Blocks.END_STONE_BRICKS, POLISHED_END_STONE.block());
                stonecuttingRecipe(Blocks.END_STONE_BRICK_STAIRS, POLISHED_END_STONE.block());
                stonecuttingRecipe(Blocks.END_STONE_BRICK_SLAB, 2, POLISHED_END_STONE.block());
                stonecuttingRecipe(Blocks.END_STONE_BRICK_WALL, POLISHED_END_STONE.block());
                smeltingResultFromBase(CRACKED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS);
                blockStairsSlabWallCuttingRecipe(SMALL_END_STONE_BRICKS, Blocks.END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block());
                chiseled(CHISELED_END_STONE_BRICKS, Blocks.END_STONE_BRICK_SLAB, Blocks.END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block());
                pillar(END_STONE_PILLAR, Blocks.END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block());
                herringbone(HERRINGBONE_END_STONE_BRICKS, Blocks.END_STONE_BRICKS, Blocks.END_STONE, POLISHED_END_STONE.block());
                decoratedBlocks(PURPUR_DECORATED_END_STONE, Items.POPPED_CHORUS_FRUIT, Blocks.END_STONE_BRICKS);
                phantomPurpur(PHANTOM_PURPUR_DECORATED_END_STONE, PURPUR_DECORATED_END_STONE);
                blockStairsSlabWallCuttingRecipe(END_TILES);
                shaped(RecipeCategory.BUILDING_BLOCKS, END_TILES.block(), 4).define('#', Blocks.END_STONE).define('X', Blocks.PURPUR_BLOCK).pattern("#X").pattern("X#").unlockedBy(getHasName(Blocks.PURPUR_BLOCK), has(Blocks.PURPUR_BLOCK)).save(output);
                pressurePlateButton(POLISHED_END_STONE_PRESSURE_PLATE, POLISHED_END_STONE_BUTTON, POLISHED_END_STONE.block());

                // Wood
                hangingSign(WHITE_OAK.hangingSign(), STRIPPED_WHITE_OAK_LOG);
                shelf(WHITE_OAK.shelf(), STRIPPED_WHITE_OAK_LOG);
                woodFromLogs(WHITE_OAK_WOOD, WHITE_OAK_LOG);
                planksFromLogs(WHITE_OAK.planks(), BlockusItemTags.WHITE_OAK_LOGS, 4);

                hangingSign(RAW_BAMBOO.hangingSign(), Blocks.BAMBOO_BLOCK);
                shelf(RAW_BAMBOO.shelf(), Blocks.BAMBOO_BLOCK);

                shaped(RecipeCategory.DECORATIONS, CHARRED.hangingSign(), 2).group("hanging_sign").define('#', CHARRED.planks()).define('X', Items.IRON_CHAIN).pattern("X X").pattern("###").pattern("###").unlockedBy(getHasName(CHARRED.planks()), has(CHARRED.planks())).save(output);
                shaped(RecipeCategory.DECORATIONS, CHARRED.shelf(), 2).group("shelf").define('#', CHARRED.planks()).pattern("###").pattern("   ").pattern("###").unlockedBy(getHasName(CHARRED.planks()), has(CHARRED.planks())).save(output);

                shapeless(RecipeCategory.BUILDING_BLOCKS, RAW_BAMBOO.planks(), 2).requires(Blocks.BAMBOO_BLOCK).group("planks").unlockedBy("has_log", has(Blocks.BAMBOO_BLOCK)).save(output);
                boats(BlockusItems.WHITE_OAK_BOAT, BlockusItems.WHITE_OAK_CHEST_BOAT, WHITE_OAK.planks());
                boats(BlockusItems.RAW_BAMBOO_RAFT, BlockusItems.RAW_BAMBOO_CHEST_RAFT, RAW_BAMBOO.planks());
                boats(BlockusItems.CHARRED_BOAT, BlockusItems.CHARRED_CHEST_BOAT, CHARRED.planks());
                SimpleCookingRecipeBuilder.smelting(tag(BlockusItemTags.PLANKS_THAT_CAN_BE_CHARRED), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, CHARRED.planks(), 0.1F, 200).unlockedBy("has_planks", has(BlockusItemTags.PLANKS_THAT_CAN_BE_CHARRED)).save(output);

                for (var entry : SMALL_LOGS.bundle().entrySet()) {
                    smallLogs(entry.getValue(), WoodMaps.LOG_MAP.get(entry.getKey()));
                }

                for (WoodenPostBundle bundle : WoodenPostBundle.values()) {
                    for (var entry : bundle.woodMap().entrySet()) {
                        Block log = WoodMaps.LOG_MAP.get(entry.getKey().getId());
                        Block strippedLog = WoodMaps.STRIPPED_LOG_MAP.get(entry.getKey().getId());
                        if (log == null || strippedLog == null) {
                            continue;
                        }
                        post(entry.getValue(), log, strippedLog, WoodMaps.PLANKS_MAP.get(entry.getKey().getId()));
                    }
                }

                for (var entry : MOSSY_PLANKS.bundle().entrySet()) {
                    mossyBlocks(entry.getValue().block(), entry.getValue().base());
                }

                for (var entry : WOODEN_MOSAIC.bundle().entrySet()) {
                    mosaicBuilder(RecipeCategory.DECORATIONS, entry.getValue().block(), WoodMaps.SLAB_MAP.get(entry.getKey()));
                }

                charredSmeltingRecipe(BlockusItemTags.WOODEN_MOSAICS_THAT_CAN_BE_CHARRED, RecipeCategory.BUILDING_BLOCKS, WOODEN_MOSAIC.get(WoodMaps.CHARRED.getId()).block(), "mosaic");


                for (var entry : HERRINGBONE_PLANKS.bundle().entrySet()) {
                    herringbonePlanks(entry.getValue(), WoodMaps.PLANKS_MAP.get(entry.getKey()));
                }

                charredSmeltingRecipe(BlockusItemTags.HERRINGBONE_PLANKS_THAT_CAN_BE_CHARRED, RecipeCategory.BUILDING_BLOCKS, HERRINGBONE_PLANKS.get(WoodMaps.CHARRED.getId()), "herringbone_planks");

                for (TimberFrameBundle bundle : TimberFrameBundle.values()) {
                    for (var entry : bundle.woodMap().entrySet()) {
                        var variants = entry.getValue();
                        Block planks = WoodMaps.PLANKS_MAP.get(entry.getKey().getId());
                        timberFrames(planks, variants.block(), variants.diagonal(), variants.cross());
                        lattices(WoodMaps.PLANKS_MAP.get(entry.getKey().getId()), variants.lattice(), variants.grate());
                    }
                }

                // Hedges
                hedge(OAK_HEDGE, Blocks.OAK_LEAVES);
                hedge(SPRUCE_HEDGE, Blocks.SPRUCE_LEAVES);
                hedge(BIRCH_HEDGE, Blocks.BIRCH_LEAVES);
                hedge(JUNGLE_HEDGE, Blocks.JUNGLE_LEAVES);
                hedge(ACACIA_HEDGE, Blocks.ACACIA_LEAVES);
                hedge(DARK_OAK_HEDGE, Blocks.DARK_OAK_LEAVES);
                hedge(MANGROVE_HEDGE, Blocks.MANGROVE_LEAVES);
                hedge(CHERRY_HEDGE, Blocks.CHERRY_LEAVES);
                hedge(PALE_OAK_HEDGE, Blocks.PALE_OAK_LEAVES);
                hedge(WARPED_HEDGE, Blocks.WARPED_WART_BLOCK);
                hedge(CRIMSON_HEDGE, Blocks.NETHER_WART_BLOCK);
                hedge(WHITE_OAK_HEDGE, WHITE_OAK_LEAVES);
                hedge(AZALEA_HEDGE, Blocks.AZALEA_LEAVES);
                hedge(FLOWERING_AZALEA_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES);
                hedge(MOSS_HEDGE, Blocks.MOSS_BLOCK);
                hedge(PALE_MOSS_HEDGE, Blocks.PALE_MOSS_BLOCK);

                // Large Flower Pots
                shaped(RecipeCategory.BUILDING_BLOCKS, LARGE_FLOWER_POT).define('#', Items.BRICK).pattern("# #").pattern("###").pattern("###").unlockedBy("has_flower_pot", has(Items.FLOWER_POT)).save(output);

                // Chocolate
                twoByTwoRecipe(RecipeCategory.BUILDING_BLOCKS, CHOCOLATE_BLOCK.block(), Items.COCOA_BEANS, 2);
                blockStairsSlabWallCuttingRecipe(CHOCOLATE_BLOCK);
                blockStairsSlabWallCuttingRecipe(CHOCOLATE_BRICKS, CHOCOLATE_BLOCK.block());
                twoByTwoToFour(CHOCOLATE_BRICKS.block(), CHOCOLATE_BLOCK.block());
                twoByTwoToFour(CHOCOLATE_SQUARES.block(), CHOCOLATE_BRICKS.block());
                blockStairsSlabWallCuttingRecipe(CHOCOLATE_SQUARES, CHOCOLATE_BLOCK.block(), CHOCOLATE_BRICKS.block());
                shaped(RecipeCategory.DECORATIONS, CHOCOLATE_TABLET, 3).define('#', CHOCOLATE_SQUARES.block()).pattern("##").unlockedBy(getHasName(CHOCOLATE_SQUARES.block()), has(CHOCOLATE_SQUARES.block())).save(output);
                stonecuttingRecipe(CHOCOLATE_TABLET, 2, CHOCOLATE_BLOCK.block(), CHOCOLATE_BRICKS.block(), CHOCOLATE_SQUARES.block());

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
                enclosedRecipeToOne(GOLDEN_APPLE_CRATE, Ingredient.of(Blocks.GOLD_BLOCK), APPLE_CRATE).unlockedBy(getHasName(Items.GOLDEN_APPLE), has(Items.GOLDEN_APPLE)).save(output, getConversionRecipeName(GOLDEN_APPLE_CRATE, APPLE_CRATE));
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.BEETROOT, RecipeCategory.BUILDING_BLOCKS, BEETROOT_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.CARROT, RecipeCategory.BUILDING_BLOCKS, CARROT_CRATE);
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.GOLDEN_CARROT, RecipeCategory.BUILDING_BLOCKS, GOLDEN_CARROT_CRATE);
                enclosedRecipeToOne(GOLDEN_CARROT_CRATE, Ingredient.of(Items.GOLD_INGOT), CARROT_CRATE).unlockedBy(getHasName(Items.GOLDEN_CARROT), has(Items.GOLDEN_CARROT)).save(output, getConversionRecipeName(GOLDEN_CARROT_CRATE, CARROT_CRATE));
                nineBlockStorageRecipes(RecipeCategory.FOOD, Items.BREAD, RecipeCategory.BUILDING_BLOCKS, BREAD_BOX);

                // Rainbow
                oneToOneConversionRecipe(RAINBOW_PETALS, RAINBOW_ROSE, "rainbow_petal", 2);
                oneToOneConversionRecipe(RAINBOW_PETALS, RAINBOW_BLOCK, "rainbow_petal", 4);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, RAINBOW_BLOCK, RAINBOW_PETALS);
                blockStairsSlabWallCuttingRecipe(RAINBOW_BRICKS, RAINBOW_BLOCK);
                twoByTwoToFour(RAINBOW_BRICKS.block(), RAINBOW_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE).requires(RAINBOW_PETALS).requires(Blocks.GLOWSTONE).group("rainbow_glowstone").unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, RAINBOW_GLOWSTONE, 1).define('G', Items.GLOWSTONE_DUST).group("rainbow_glowstone").define('R', RAINBOW_PETALS).pattern(" G ").pattern("GRG").pattern(" G ").unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(output, getSimpleRecipeName(RAINBOW_GLOWSTONE) + "_alt");

                // Dyed blocks
                blockStairsSlabWallCuttingRecipe(SHINGLES, Blocks.TERRACOTTA);
                twoByTwoToFour(SHINGLES.block(), Blocks.TERRACOTTA);
                for (DyeColor color : BlockOrder.COLOR) {
                    BSSWBundle dyedStoneBricks = STAINED_STONE_BRICKS.colorMap().get(color);
                    BSSWBundle dyedShingles = STAINED_SHINGLES.colorMap().get(color);
                    dyedStoneBricks(DYE_MAP.get(color), dyedStoneBricks.block(), dyedStoneBricks.stairs(), dyedStoneBricks.slab(), dyedStoneBricks.wall());
                    dyedShingles(DYE_MAP.get(color), BlockMaps.TERRACOTTA_MAP.get(color), dyedShingles.block(), dyedShingles.stairs(), dyedShingles.slab());
                }

                // Redstone Lamps
                shapeless(RecipeCategory.BUILDING_BLOCKS, LIT_REDSTONE_LAMP).requires(Blocks.REDSTONE_LAMP).requires(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").unlockedBy(getHasName(Blocks.REDSTONE_LAMP), has(Blocks.REDSTONE_LAMP)).save(output);
                for (DyeColor color : BlockOrder.COLOR) {
                    stainedRedstoneLamp(STAINED_REDSTONE_LAMP.colorMap().get(color), DYE_MAP.get(color), STAINED_REDSTONE_LAMP_LIT.colorMap().get(color));
                }
                stainedRedstoneLamp(RAINBOW_LAMP, RAINBOW_PETALS, LIT_RAINBOW_LAMP);

                // Neon Blocks
                for (DyeColor color : BlockOrder.COLOR) {
                    Block block = NEON_BLOCK.colorMap().get(color);
                    neon(block, DYE_MAP.get(color));
                }
                neon(RAINBOW_NEON, RAINBOW_PETALS);

                // Futurneo Blocks
                for (DyeColor color : BlockOrder.COLOR) {
                    Block block = FUTURNEO_BLOCK.colorMap().get(color);
                    futurneo(block, BlockMaps.STAINED_GLASS_MAP.get(color));
                }
                shaped(RecipeCategory.BUILDING_BLOCKS, GRAY_BRIGHT_FUTURNEO_BLOCK).define('A', Items.WHITE_DYE).define('B', Blocks.GRAY_STAINED_GLASS).define('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").unlockedBy(getHasName(Blocks.GRAY_STAINED_GLASS), has(Blocks.GRAY_STAINED_GLASS)).save(output);
                futurneo(RAINBOW_FUTURNEO_BLOCK, RAINBOW_GLASS);

                // Asphalt
                shaped(RecipeCategory.BUILDING_BLOCKS, ASPHALT.baseColor().block(), 8).define('X', Blocks.GRAVEL).define('#', ItemTags.COALS).pattern("XXX").pattern("X#X").pattern("XXX").group("asphalt").unlockedBy(getHasName(Blocks.GRAVEL), has(Blocks.GRAVEL)).save(output);
                enclosedRecipeToEight(RAINBOW_ASPHALT, Ingredient.of(ASPHALT.baseColor().block()), RAINBOW_PETALS).unlockedBy(getHasName(ASPHALT.baseColor().block()), has(ASPHALT.baseColor().block())).save(output);

                for (DyeColor color : BlockOrder.COLOR) {
                    if (color == DyeColor.BLACK) continue;
                    AsphaltBundle.AsphaltVariants bundle = ASPHALT.colorMap().get(color);
                    asphalt(DYE_MAP.get(color), bundle.block(), bundle.stairs(), bundle.slab());
                }

                // Glass - Beveled Glass
                twoByTwoToFour(TINTED_BEVELED_GLASS, Blocks.TINTED_GLASS);
                twoByTwoToFour(BEVELED_GLASS, Blocks.GLASS);
                shaped(RecipeCategory.DECORATIONS, BEVELED_GLASS_PANE, 16).define('#', BEVELED_GLASS).pattern("###").pattern("###").group("beveled_glass_pane").unlockedBy("has_beveled_glass", has(BEVELED_GLASS)).save(output);
                for (DyeColor color : BlockOrder.COLOR) {
                    stainedBeveledGlass(STAINED_BEVELED_GLASS.colorMap().get(color), STAINED_BEVELED_GLASS_PANE.colorMap().get(color), BlockMaps.STAINED_GLASS_MAP.get(color), DYE_MAP.get(color));
                }
                stainedBeveledGlass(RAINBOW_BEVELED_GLASS, RAINBOW_BEVELED_GLASS_PANE, RAINBOW_GLASS, RAINBOW_PETALS);
                enclosedRecipeToEight(RAINBOW_GLASS, Ingredient.of(Blocks.GLASS), RAINBOW_PETALS).unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(output);
                enclosedRecipe(RecipeCategory.DECORATIONS, RAINBOW_GLASS_PANE, Ingredient.of(Blocks.GLASS_PANE), RAINBOW_PETALS, 8).unlockedBy(getHasName(RAINBOW_PETALS), has(RAINBOW_PETALS)).save(output, getSimpleRecipeName(RAINBOW_GLASS_PANE) + "_alt");
                shaped(RecipeCategory.DECORATIONS, RAINBOW_GLASS_PANE, 16).define('#', RAINBOW_GLASS).pattern("###").pattern("###").unlockedBy(getHasName(RAINBOW_GLASS), has(RAINBOW_GLASS)).save(output);

                // Colored Tiles
                for (DyeColor color : BlockOrder.COLOR) {
                    unicolorColoredTiles(COLORED_TILES.colorMap().get(color), BlockMaps.CONCRETE_MAP.get(color));
                }
                unicolorColoredTiles(RAINBOW_COLORED_TILES, RAINBOW_BLOCK);

                // Glazed Terracotta Pillars
                for (DyeColor color : BlockOrder.COLOR) {
                    pillar(GLAZED_TERRACOTTA_PILLAR.colorMap().get(color), BlockMaps.GLAZED_TERRACOTTA_MAP.get(color));
                }

                // Thatch
                twoByTwoToFour(THATCH.block(), Items.WHEAT);

                // Paper
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, PAPER_BLOCK);
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(PAPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, BURNT_PAPER_BLOCK.asItem(), 0.1F, 200).unlockedBy("has_paper_block", has(PAPER_BLOCK)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, FRAMED_PAPER_BLOCK, 4).define('X', Items.PAPER).define('#', Items.STICK).pattern("###").pattern("XXX").pattern("###").unlockedBy(getHasName(Items.PAPER), has(Items.PAPER)).save(output);
                twoByTwoToFour(PAPER_WALL, FRAMED_PAPER_BLOCK);
                enclosedRecipeToOne(PAPER_LAMP, Ingredient.of(Items.PAPER), Items.TORCH).unlockedBy(getHasName(Items.PAPER), has(Items.PAPER)).save(output);
                shapeless(RecipeCategory.BUILDING_BLOCKS, Items.GUNPOWDER, 2).requires(BURNT_PAPER_BLOCK).unlockedBy(getHasName(BURNT_PAPER_BLOCK), has(BURNT_PAPER_BLOCK)).save(output);
                doorTrapdoor(PAPER_DOOR, PAPER_TRAPDOOR, PAPER_WALL);

                // Plating
                blockStairsSlabWallCuttingRecipe(IRON_PLATING);
                shaped(RecipeCategory.BUILDING_BLOCKS, IRON_PLATING.block(), 24).define('X', Items.IRON_INGOT).pattern("XXX").pattern("X X").pattern("XXX").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(output);
                blockStairsSlabWallCuttingRecipe(GOLD_PLATING);
                shaped(RecipeCategory.BUILDING_BLOCKS, GOLD_PLATING.block(), 24).define('X', Items.GOLD_INGOT).pattern("XXX").pattern("X X").pattern("XXX").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(output);

                // Gates - chains - bars
                door(IRON_GATE, Blocks.IRON_BARS);
                door(GOLDEN_GATE, GOLDEN_BARS);
                shaped(RecipeCategory.BUILDING_BLOCKS, GOLDEN_BARS, 16).define('#', Items.GOLD_INGOT).pattern("###").pattern("###").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, GOLDEN_CHAIN).define('X', Items.GOLD_INGOT).define('#', Items.GOLD_NUGGET).pattern("#").pattern("X").pattern("#").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(output);
                door(COPPER_GATE.unaffected(), Blocks.COPPER_BARS.unaffected());
                door(COPPER_GATE.exposed(), Blocks.COPPER_BARS.exposed());
                door(COPPER_GATE.weathered(), Blocks.COPPER_BARS.weathered());
                door(COPPER_GATE.oxidized(), Blocks.COPPER_BARS.oxidized());
                door(COPPER_GATE.waxed(), Blocks.COPPER_BARS.waxed());
                door(COPPER_GATE.waxedExposed(), Blocks.COPPER_BARS.waxedExposed());
                door(COPPER_GATE.waxedWeathered(), Blocks.COPPER_BARS.waxedWeathered());
                door(COPPER_GATE.waxedOxidized(), Blocks.COPPER_BARS.waxedOxidized());

                // Lantern Blocks
                lanternBlockRecipe(LANTERN_BLOCK, Blocks.LANTERN, Items.IRON_NUGGET);
                lanternBlockRecipe(SOUL_LANTERN_BLOCK, Blocks.SOUL_LANTERN, Items.IRON_NUGGET);
                shaped(RecipeCategory.BUILDING_BLOCKS, AMETHYST_LANTERN).define('#', Items.TORCH).define('A', Items.AMETHYST_SHARD).define('X', Items.IRON_NUGGET).pattern("XXX").pattern("XAX").pattern("X#X").unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(output);
                lanternBlockRecipe(AMETHYST_LANTERN_BLOCK, AMETHYST_LANTERN, Items.IRON_NUGGET);
                shaped(RecipeCategory.REDSTONE, REDSTONE_LANTERN).define('#', Items.REDSTONE_TORCH).define('X', Items.IRON_NUGGET).pattern("XXX").pattern("X#X").pattern("XXX").unlockedBy(getHasName(Items.REDSTONE_TORCH), has(Items.REDSTONE_TORCH)).save(output);
                lanternBlockRecipe(RecipeCategory.REDSTONE, REDSTONE_LANTERN_BLOCK, REDSTONE_LANTERN, Items.IRON_NUGGET);
                jackOLanternRecipe(SOUL_O_LANTERN, Blocks.SOUL_TORCH);
                jackOLanternRecipe(COPPER_JACK_O_LANTERN, Blocks.COPPER_TORCH);
                jackOLanternRecipe(RecipeCategory.REDSTONE, REDSTONE_O_LANTERN, Blocks.REDSTONE_TORCH);
                lanternBlockRecipe(COPPER_LANTERN_BLOCK.unaffected(), Blocks.COPPER_LANTERN.unaffected(), Items.COPPER_NUGGET);
                lanternBlockRecipe(COPPER_LANTERN_BLOCK.exposed(), Blocks.COPPER_LANTERN.exposed(), Items.COPPER_NUGGET);
                lanternBlockRecipe(COPPER_LANTERN_BLOCK.weathered(), Blocks.COPPER_LANTERN.weathered(), Items.COPPER_NUGGET);
                lanternBlockRecipe(COPPER_LANTERN_BLOCK.oxidized(), Blocks.COPPER_LANTERN.oxidized(), Items.COPPER_NUGGET);
                lanternBlockRecipe(COPPER_LANTERN_BLOCK.waxed(), Blocks.COPPER_LANTERN.waxed(), Items.COPPER_NUGGET);
                lanternBlockRecipe(COPPER_LANTERN_BLOCK.waxedExposed(), Blocks.COPPER_LANTERN.waxedExposed(), Items.COPPER_NUGGET);
                lanternBlockRecipe(COPPER_LANTERN_BLOCK.waxedWeathered(), Blocks.COPPER_LANTERN.waxedWeathered(), Items.COPPER_NUGGET);
                lanternBlockRecipe(COPPER_LANTERN_BLOCK.waxedOxidized(), Blocks.COPPER_LANTERN.waxedOxidized(), Items.COPPER_NUGGET);

                // Barriers
                shaped(RecipeCategory.DECORATIONS, ROAD_BARRIER, 5).define('#', Items.IRON_INGOT).define('X', Blocks.STONE).pattern("X#X").pattern("X#X").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(output);
                shapeless(RecipeCategory.DECORATIONS, CAUTION_BARRIER).requires(CAUTION_BLOCK).requires(ROAD_BARRIER).unlockedBy(getHasName(CAUTION_BLOCK), has(CAUTION_BLOCK)).unlockedBy(getHasName(ROAD_BARRIER), has(ROAD_BARRIER)).save(output);

                // Netherite Blocks
                stairs(NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
                slab(RecipeCategory.BUILDING_BLOCKS, NETHERITE_SLAB, Blocks.NETHERITE_BLOCK);
                stonecuttingRecipe(NETHERITE_STAIRS, Blocks.NETHERITE_BLOCK);
                stonecuttingRecipe(NETHERITE_SLAB, 2, Blocks.NETHERITE_BLOCK);

                // Other
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, CHARCOAL_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, SUGAR_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, ENDER_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, ROTTEN_FLESH_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.BUILDING_BLOCKS, MEMBRANE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, Items.NETHER_STAR, RecipeCategory.BUILDING_BLOCKS, NETHER_STAR_BLOCK);
                twoByTwoToFour(WOODEN_FRAME, Items.STICK);
                enclosedRecipe(RecipeCategory.REDSTONE, REDSTONE_SAND, Ingredient.of(Items.REDSTONE), Items.SAND, 1).unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE)).save(output);
                shapeless(RecipeCategory.REDSTONE, Items.REDSTONE, 8).requires(REDSTONE_SAND).unlockedBy(getHasName(REDSTONE_SAND), has(REDSTONE_SAND)).save(output, getConversionRecipeName(Items.REDSTONE, REDSTONE_SAND));
                shaped(RecipeCategory.BUILDING_BLOCKS, LOVE_BLOCK).define('M', Items.MAGENTA_DYE).define('R', Items.RED_DYE).pattern("RMR").pattern("RRR").pattern("MRM").unlockedBy(getHasName(Items.MAGENTA_DYE), has(Items.MAGENTA_DYE)).unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE)).save(output);
                shapeless(RecipeCategory.BUILDING_BLOCKS, WEIGHT_STORAGE_CUBE).requires(Blocks.STONE).requires(Items.IRON_NUGGET).unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE)).save(output);
                shapeless(RecipeCategory.BUILDING_BLOCKS, COMPANION_CUBE).requires(WEIGHT_STORAGE_CUBE).requires(Items.POPPY).unlockedBy(getHasName(WEIGHT_STORAGE_CUBE), has(WEIGHT_STORAGE_CUBE)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, CAUTION_BLOCK, 6).define('A', Blocks.STONE).define('B', Items.BLACK_DYE).define('C', Items.YELLOW_DYE).pattern(" C ").pattern("BAB").pattern(" C ").unlockedBy(getHasName(Items.BLACK_DYE), has(Items.BLACK_DYE)).unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, STARS_BLOCK, 3).define('#', Items.ENDER_PEARL).define('X', Items.CHORUS_FRUIT).pattern("X#X").pattern("###").pattern("X#X").unlockedBy(getHasName(Items.CHORUS_FRUIT), has(Items.CHORUS_FRUIT)).save(output);

                // Legacy
                stonecuttingRecipe(LEGACY_BRICKS, Blocks.BRICKS);
                stonecuttingRecipe(LEGACY_FIRST_COBBLESTONE, Blocks.COBBLESTONE);
                stonecuttingRecipe(LEGACY_COBBLESTONE, Blocks.COBBLESTONE);
                stonecuttingRecipe(LEGACY_MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE);
                stonecuttingRecipe(LEGACY_GRAVEL, Blocks.GRAVEL);
                stonecuttingRecipe(LEGACY_IRON_BLOCK, Blocks.IRON_BLOCK);
                stonecuttingRecipe(LEGACY_GOLD_BLOCK, Blocks.GOLD_BLOCK);
                stonecuttingRecipe(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, Blocks.GOLD_BLOCK);
                stonecuttingRecipe(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, LEGACY_GOLD_BLOCK);
                stonecuttingRecipe(LEGACY_COAL_BLOCK, Blocks.COAL_BLOCK);
                stonecuttingRecipe(LEGACY_DIAMOND_BLOCK, Blocks.DIAMOND_BLOCK);
                stonecuttingRecipe(LEGACY_LAPIS_BLOCK, Blocks.LAPIS_BLOCK);
                stonecuttingRecipe(LEGACY_SPONGE, Blocks.SPONGE);
                stonecuttingRecipe(LEGACY_CRYING_OBSIDIAN, Blocks.CRYING_OBSIDIAN);
                stonecuttingRecipe(LEGACY_GLOWSTONE, Blocks.GLOWSTONE);
                stonecuttingRecipe(LEGACY_GLOWING_OBSIDIAN, GLOWING_OBSIDIAN);
                oneToOneConversionRecipe(Items.IRON_INGOT, LEGACY_IRON_BLOCK, "iron_ingot", 9);
                oneToOneConversionRecipe(Items.GOLD_INGOT, LEGACY_GOLD_BLOCK, "gold_ingot", 9);
                oneToOneConversionRecipe(Items.GOLD_INGOT, LEGACY_EXPLOSION_PROOF_GOLD_BLOCK, "gold_ingot", 9);
                oneToOneConversionRecipe(Items.COAL, LEGACY_COAL_BLOCK, "coal", 9);
                oneToOneConversionRecipe(Items.DIAMOND, LEGACY_DIAMOND_BLOCK, "diamond", 9);
                oneToOneConversionRecipe(Items.LAPIS_LAZULI, LEGACY_LAPIS_BLOCK, "lapis_lazuli", 9);
                oneToOneConversionRecipe(Items.RED_DYE, LEGACY_ROSE, "red_dye", 2);
                oneToOneConversionRecipe(Items.LIGHT_BLUE_DYE, LEGACY_BLUE_ROSE, "light_blue_dye", 2);
                shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_STONECUTTER).define('#', Blocks.COBBLESTONE).define('S', Blocks.STONECUTTER).pattern(" # ").pattern("#S#").pattern(" # ").unlockedBy(getHasName(Blocks.STONECUTTER), has(Blocks.STONECUTTER)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_NETHER_REACTOR_CORE).define('#', Items.DIAMOND).define('X', Items.IRON_INGOT).pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(output);
                twoByTwoRecipe(RecipeCategory.BUILDING_BLOCKS, LEGACY_SAPLING, Blocks.OAK_SAPLING, 4);
                twoByTwoRecipe(RecipeCategory.BUILDING_BLOCKS, LEGACY_ROSE, Blocks.POPPY, 2);
                shaped(RecipeCategory.BUILDING_BLOCKS, LEGACY_BLUE_ROSE, 2).define('#', LEGACY_ROSE).pattern("##").unlockedBy(getHasName(LEGACY_ROSE), has(LEGACY_ROSE)).save(output);
                twoByTwoRecipe(RecipeCategory.BUILDING_BLOCKS, LEGACY_FIRST_GRASS_BLOCK, LEGACY_GRASS_BLOCK, 4);
                shapeless(RecipeCategory.BUILDING_BLOCKS, LEGACY_PLANKS, 4).requires(LEGACY_LOG).group("planks").unlockedBy("has_logs", has(LEGACY_LOG)).save(output);
            }

            public void oneToOneConversionRecipeWithCategory(RecipeCategory category, ItemLike product, ItemLike resource, int productCount) {
                shapeless(category, product, productCount).requires(resource).group(getItemName(product)).unlockedBy(getHasName(resource), has(resource)).save(output, getConversionRecipeName(product, resource));
            }

            public void twoByTwoRecipe(RecipeCategory category, ItemLike result, ItemLike input, int count) {
                twoByTwoBuilder(category, result, Ingredient.of(input), count).unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void twoByTwoRecipe(RecipeCategory category, ItemLike result, TagKey<Item> input, int count, String hasName) {
                twoByTwoBuilder(category, result, tag(input), count).unlockedBy(hasName, has(input)).save(output);
            }

            public void twoByTwoRecipeWithGroup(RecipeCategory category, ItemLike result, ItemLike input, int count, String group) {
                twoByTwoBuilder(category, result, Ingredient.of(input), count).group(group).unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void twoByTwoToFour(RecipeCategory category, ItemLike result, ItemLike input) {
                twoByTwoRecipe(category, result, input, 4);
            }

            public void twoByTwoToFour(ItemLike result, ItemLike input) {
                twoByTwoToFour(RecipeCategory.BUILDING_BLOCKS, result, input);
            }

            public RecipeBuilder twoByTwoBuilder(RecipeCategory category, ItemLike result, Ingredient input, int count) {
                return shaped(category, result, count).define('#', input).pattern("##").pattern("##");
            }

            public void lanternBlockRecipe(RecipeCategory category, Block result, Block lantern, Item nugget) {
                shaped(category, result).define('X', lantern).define('#', nugget).pattern(" # ").pattern("#X#").pattern(" # ").unlockedBy(getHasName(lantern), has(lantern)).save(output);
            }

            public void lanternBlockRecipe(Block result, Block lantern, Item nugget) {
                lanternBlockRecipe(RecipeCategory.BUILDING_BLOCKS, result, lantern, nugget);
            }

            public void waxingRecipes(RecipeCategory category, Block unwaxed, Block waxed) {
                shapeless(category, waxed).requires(unwaxed).requires(Items.HONEYCOMB).group(getItemName(waxed)).unlockedBy(getHasName(unwaxed), has(unwaxed)).save(output, getConversionRecipeName(waxed, Items.HONEYCOMB));
            }

            public void waxingRecipes(Block unwaxed, Block waxed) {
                waxingRecipes(RecipeCategory.BUILDING_BLOCKS, unwaxed, waxed);
            }

            public void jackOLanternRecipe(RecipeCategory category, Block result, Block input) {
                shaped(category, result).define('X', Blocks.CARVED_PUMPKIN).define('#', input).pattern("X").pattern("#").unlockedBy(getHasName(Blocks.CARVED_PUMPKIN), has(Blocks.CARVED_PUMPKIN)).unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void jackOLanternRecipe(Block result, Block input) {
                jackOLanternRecipe(RecipeCategory.BUILDING_BLOCKS, result, input);
            }

            public void charredSmeltingRecipe(TagKey<Item> input, RecipeCategory category, ItemLike result, String hasitem) {
                SimpleCookingRecipeBuilder.smelting(tag(input), category, CookingBookCategory.BLOCKS, result, 0.1F, 200).unlockedBy("has_" + hasitem, has(input)).save(output, getSimpleRecipeName(result) + "_from_smelting");
            }

            public void mossyBlocks(ItemLike result, ItemLike input) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, result).requires(input).requires(Blocks.VINE).group(BuiltInRegistries.BLOCK.getKey((Block) result).getPath()).unlockedBy("has_vine", has(Blocks.VINE)).save(output, getConversionRecipeName(result, Blocks.VINE));
                shapeless(RecipeCategory.BUILDING_BLOCKS, result).requires(input).requires(Blocks.MOSS_BLOCK).group(BuiltInRegistries.BLOCK.getKey((Block) result).getPath()).unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK)).save(output, getConversionRecipeName(result, Blocks.MOSS_BLOCK));
            }

            public void sturdyBlocks(ItemLike result, ItemLike input1, ItemLike input2) {
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 2).define('#', input1).define('X', input2).pattern("X#X").pattern("# #").pattern("X#X").unlockedBy(getHasName(input1), has(input1)).unlockedBy(getHasName(input2), has(input2)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 2).define('#', input1).define('X', input2).pattern("#X#").pattern("X X").pattern("#X#").unlockedBy(getHasName(input1), has(input1)).unlockedBy(getHasName(input2), has(input2)).save(output, getSimpleRecipeName(result) + "_alt");
            }

            public void decoratedBlocks(ItemLike result, ItemLike decoration, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 4).define('#', decoration).define('X', input).pattern("##").pattern("XX").unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void phantomPurpur(ItemLike result, ItemLike input) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, result).requires(input).requires(BlockusItemTags.SOUL_SOILS).unlockedBy("has_purpur", has(input)).save(output, getConversionRecipeName(result, Blocks.SOUL_SAND));
            }

            public void coloredTiles(ItemLike result, ItemLike color1, ItemLike color2) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, result, 2).requires(color1).requires(color2).group("colored_tiles").unlockedBy(getHasName(color1), has(color1)).unlockedBy(getHasName(color2), has(color2)).save(output);
            }

            public void unicolorColoredTiles(ItemLike result, ItemLike color) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, result, 2).requires(color).requires(color).group("colored_tiles").unlockedBy(getHasName(color), has(color)).save(output);
                stonecuttingRecipe(result, color);
            }

            public void smallLogs(ItemLike result, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 4).define('#', input).pattern(" # ").pattern("###").group("small_logs").unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void post(WoodenPostBundle.WoodenPostVariants post, ItemLike base, ItemLike base2, ItemLike planks) {
                shaped(RecipeCategory.BUILDING_BLOCKS, post.block(), 6).define('#', base).pattern("#").pattern("#").pattern("#").group("wooden_posts").unlockedBy("has_woods", has(base)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, post.stripped(), 6).define('#', base2).pattern("#").pattern("#").pattern("#").group("stripped_wooden_posts").unlockedBy("has_woods", has(base2)).save(output);
                shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 2).requires(post.block()).group("planks").unlockedBy("has_wooden_post", has(post.block())).save(output, getConversionRecipeName(planks, post.block()));
                shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 2).requires(post.stripped()).group("planks").unlockedBy("has_stripped_wooden_post", has(post.stripped())).save(output, getConversionRecipeName(planks, post.stripped()));
            }

            public void hedge(ItemLike result, ItemLike input) {
                shaped(RecipeCategory.DECORATIONS, result, 6).define('#', input).pattern("###").pattern("###").group("hedge").unlockedBy(getHasName(input), has(input)).save(output);
            }

            public RecipeBuilder enclosedRecipe(RecipeCategory category, ItemLike result, Ingredient input, ItemLike center, int count) {
                return shaped(category, result, count).define('X', input).define('#', center).pattern("XXX").pattern("X#X").pattern("XXX");
            }

            public RecipeBuilder enclosedRecipeToEight(ItemLike result, Ingredient input, ItemLike center) {
                return enclosedRecipe(RecipeCategory.BUILDING_BLOCKS, result, input, center, 8);
            }

            public RecipeBuilder enclosedRecipeToOne(ItemLike result, Ingredient input, ItemLike center) {
                return enclosedRecipe(RecipeCategory.BUILDING_BLOCKS, result, input, center, 1);
            }

            public void door(ItemLike door, ItemLike input) {
                doorBuilder(door, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void stoneDoorTrapdoor(ItemLike door, ItemLike trapdoor, ItemLike input, ItemLike slab) {
                door(door, input);
                shaped(RecipeCategory.REDSTONE, trapdoor, 4).define('#', slab).pattern("###").pattern("###").unlockedBy(getHasName(slab), has(slab)).save(output);
            }

            public void doorTrapdoor(ItemLike door, ItemLike trapdoor, ItemLike input) {
                door(door, input);
                trapdoorBuilder(trapdoor, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void pressurePlateButton(ItemLike pressureplate, ItemLike button, ItemLike input) {
                pressurePlateBuilder(RecipeCategory.REDSTONE, pressureplate, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(output);
                buttonBuilder(button, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void dyedStoneBricks(ItemLike dye, ItemLike bricks, ItemLike stairs, ItemLike slab, ItemLike wall) {
                enclosedRecipeToEight(bricks, Ingredient.of(Blocks.STONE_BRICKS), dye).group("stained_stone_bricks").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(output);
                enclosedRecipeToEight(stairs, Ingredient.of(Blocks.STONE_BRICK_STAIRS), dye).group("stained_stone_brick_stairs").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(output, getConversionRecipeName(stairs, Blocks.STONE_BRICK_STAIRS));
                enclosedRecipeToEight(slab, Ingredient.of(Blocks.STONE_BRICK_SLAB), dye).group("stained_stone_brick_slab").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(output, getConversionRecipeName(slab, Blocks.STONE_BRICK_SLAB));
                enclosedRecipe(RecipeCategory.DECORATIONS, wall, Ingredient.of(Blocks.STONE_BRICK_WALL), dye, 8).group("dyed_stone_brick_wall").unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS)).save(output, getConversionRecipeName(wall, Blocks.STONE_BRICK_WALL));
                stonecuttingRecipe(stairs, bricks);
                stonecuttingRecipe(slab, 2, bricks);
                stonecuttingRecipe(RecipeCategory.DECORATIONS, wall, bricks);
            }

            public void dyedShingles(ItemLike dye, ItemLike terracotta, ItemLike block, ItemLike stairs, ItemLike slab) {
                enclosedRecipeToEight(block, Ingredient.of(SHINGLES.block()), dye).group("shingles").unlockedBy(getHasName(SHINGLES.block()), has(SHINGLES.block())).save(output, getConversionRecipeName(stairs, SHINGLES.block()));
                enclosedRecipeToEight(stairs, Ingredient.of(SHINGLES.stairs()), dye).group("shingles_stairs").unlockedBy(getHasName(SHINGLES.block()), has(SHINGLES.block())).save(output, getConversionRecipeName(stairs, SHINGLES.stairs()));
                enclosedRecipeToEight(slab, Ingredient.of(SHINGLES.slab()), dye).group("shingles_slab").unlockedBy(getHasName(SHINGLES.block()), has(SHINGLES.block())).save(output, getConversionRecipeName(slab, SHINGLES.slab()));
                twoByTwoToFour(block, terracotta);
                stonecuttingRecipe(block, terracotta);
                stonecuttingRecipe(stairs, terracotta, block);
                stonecuttingRecipe(slab, 2, terracotta, block);
            }

            public void oreBricks(RecipeCategory category, RecipeCategory unpackedCategory, BSSWBundle bricks, ItemLike block, ItemLike ore) {
                stonecuttingRecipe(category, bricks.block(), block);
                stonecuttingRecipe(category, bricks.stairs(), bricks.block(), block);
                stonecuttingRecipe(category, bricks.slab(), 2, bricks.block(), block);
                stonecuttingRecipe(RecipeCategory.DECORATIONS, bricks.wall(), bricks.block(), block);
                twoByTwoToFour(category, bricks.block(), block);
                oneToOneConversionRecipeWithCategory(unpackedCategory, ore, bricks.block(), 9);
                oneToOneConversionRecipeWithCategory(unpackedCategory, ore, bricks.stairs(),9);
                oneToOneConversionRecipeWithCategory(unpackedCategory, ore, bricks.slab(), 4);
                oneToOneConversionRecipeWithCategory(unpackedCategory, ore, bricks.wall(), 9);
            }

            public void oreBricks(BSSWBundle bricks, ItemLike block, ItemLike ore) {
                oreBricks(RecipeCategory.BUILDING_BLOCKS, RecipeCategory.MISC, bricks, block, ore);
            }

            public void redstoneBricks(BSSWBundle bricks, ItemLike block, ItemLike ore) {
                oreBricks(RecipeCategory.REDSTONE, RecipeCategory.REDSTONE, bricks, block, ore);
            }

            public void copperBricks(CopperBSSWBundle block, ItemLike baseWaxed, ItemLike cutCopper, ItemLike cutCopperWaxed) {
                stonecuttingRecipe(block.block(), cutCopper);
                stonecuttingRecipe(block.stairs(), block.block(), cutCopper);
                stonecuttingRecipe(block.slab(), 2, block.block(), cutCopper);
                stonecuttingRecipe(RecipeCategory.DECORATIONS, block.wall(), block.block(), cutCopper);
                stonecuttingRecipe(block.blockWaxed(), cutCopperWaxed);
                stonecuttingRecipe(block.stairsWaxed(), block.blockWaxed(), cutCopperWaxed);
                stonecuttingRecipe(block.slabWaxed(), 2, block.blockWaxed(), cutCopperWaxed);
                stonecuttingRecipe(RecipeCategory.DECORATIONS, block.wallWaxed(), block.blockWaxed(), cutCopperWaxed);
                stonecuttingRecipe(block.block(), 4, block.base());
                stonecuttingRecipe(block.stairs(), 4, block.base());
                stonecuttingRecipe(block.slab(), 8, block.base());
                stonecuttingRecipe(RecipeCategory.DECORATIONS, block.wall(), 4, block.base());
                stonecuttingRecipe(block.blockWaxed(), 4, baseWaxed);
                stonecuttingRecipe(block.stairsWaxed(), 4, baseWaxed);
                stonecuttingRecipe(block.slabWaxed(), 8, baseWaxed);
                stonecuttingRecipe(RecipeCategory.DECORATIONS, block.wallWaxed(), 4, baseWaxed);
                twoByTwoToFour(block.block(), cutCopper);
                twoByTwoToFour(block.blockWaxed(), cutCopperWaxed);
            }

            public void timberFrames(ItemLike base, ItemLike block, ItemLike diagonal, ItemLike cross) {
                shaped(RecipeCategory.BUILDING_BLOCKS, block, 2).define('#', Items.PAPER).define('X', base).pattern("#X").pattern("X#").group("timber_frame").unlockedBy(getHasName(base), has(base)).save(output);
                twoByTwoRecipeWithGroup(RecipeCategory.BUILDING_BLOCKS, diagonal, block, 4, "diagonal_timber_frame");
                twoByTwoRecipeWithGroup(RecipeCategory.BUILDING_BLOCKS, cross, diagonal, 4, "cross_timber_frame");
            }

            public void lattices(ItemLike base, ItemLike lattice, ItemLike grate) {
                shaped(RecipeCategory.BUILDING_BLOCKS, grate, 3).define('#', Items.STICK).define('X', base).pattern(" # ").pattern("#X#").pattern(" # ").group("wooden_grates").unlockedBy(getHasName(base), has(base)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, lattice, 16).define('#', grate).pattern("###").pattern("###").group("wooden_lattices").unlockedBy(getHasName(lattice), has(lattice)).save(output);
            }

            public void asphalt(ItemLike center, ItemLike block, ItemLike stairs, ItemLike slab) {
                enclosedRecipeToEight(block, Ingredient.of(ASPHALT.baseColor().block()), center).group("asphalt").unlockedBy(getHasName(ASPHALT.baseColor().block()), has(ASPHALT.baseColor().block())).save(output);
                enclosedRecipeToEight(stairs, Ingredient.of(ASPHALT.baseColor().stairs()), center).group("asphalt_stairs").unlockedBy(getHasName(ASPHALT.baseColor().stairs()), has(ASPHALT.baseColor().stairs())).save(output, getConversionRecipeName(stairs, ASPHALT.baseColor().stairs()));
                enclosedRecipeToEight(slab, Ingredient.of(ASPHALT.baseColor().slab()), center).group("asphalt_slab").unlockedBy(getHasName(ASPHALT.baseColor().slab()), has(ASPHALT.baseColor().slab())).save(output, getConversionRecipeName(slab, ASPHALT.baseColor().slab()));
            }

            public void patternedWool(ItemLike result, ItemLike wool, ItemLike resultCarpet, ItemLike carpet) {
                twoByTwoToFour(result, wool);
                twoByTwoBuilder(RecipeCategory.DECORATIONS, resultCarpet, Ingredient.of(carpet), 4).group("patterned_carpet").unlockedBy(getHasName(carpet), has(carpet)).save(output, getConversionRecipeName(resultCarpet, carpet));
            }

            public void ginghamWool(ItemLike result, ItemLike wool) {
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 4).define('#', wool).pattern(" # ").pattern("# #").pattern(" # ").group("gingham_wool").unlockedBy(getHasName(wool), has(wool)).save(output);
            }

            public void stairs(ItemLike result, ItemLike input) {
                stairBuilder(result, Ingredient.of(input)).unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void stainedBeveledGlass(ItemLike beveledGlass, ItemLike beveledGlassPane, ItemLike glass, ItemLike dye) {
                twoByTwoRecipeWithGroup(RecipeCategory.BUILDING_BLOCKS, beveledGlass, glass, 4, "beveled_glass");
                enclosedRecipeToEight(beveledGlass, Ingredient.of(BEVELED_GLASS), dye).group("beveled_glass_2").unlockedBy(getHasName(BEVELED_GLASS), has(BEVELED_GLASS)).save(output, getConversionRecipeName(beveledGlass, BEVELED_GLASS));
                shaped(RecipeCategory.DECORATIONS, beveledGlassPane, 16).define('#', beveledGlass).pattern("###").pattern("###").group("beveled_glass_pane").unlockedBy("has_beveled_glass", has(beveledGlass)).save(output);
                enclosedRecipe(RecipeCategory.DECORATIONS, beveledGlassPane, Ingredient.of(BEVELED_GLASS_PANE), dye, 8).group("beveled_glass_pane_2").unlockedBy(getHasName(BEVELED_GLASS_PANE), has(BEVELED_GLASS_PANE)).save(output, getConversionRecipeName(beveledGlass, BEVELED_GLASS_PANE));
            }

            public void stainedRedstoneLamp(ItemLike redstoneLamp, ItemLike dye, ItemLike litRedstoneLamp) {
                shaped(RecipeCategory.REDSTONE, redstoneLamp).define('S', dye).define('#', Blocks.REDSTONE_LAMP).pattern(" S ").pattern("S#S").pattern(" S ").group("redstone_lamps").unlockedBy(getHasName(Blocks.REDSTONE_LAMP), has(Blocks.REDSTONE_LAMP)).save(output);
                shapeless(RecipeCategory.BUILDING_BLOCKS, litRedstoneLamp).requires(redstoneLamp).requires(Blocks.REDSTONE_TORCH).group("lit_redstone_lamps").unlockedBy(getHasName(redstoneLamp), has(redstoneLamp)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, litRedstoneLamp).define('S', dye).define('#', LIT_REDSTONE_LAMP).pattern(" S ").pattern("S#S").pattern(" S ").group("lit_redstone_lamps").unlockedBy(getHasName(LIT_REDSTONE_LAMP), has(LIT_REDSTONE_LAMP)).save(output, getSimpleRecipeName(litRedstoneLamp) + "_alt");
            }

            public void neon(ItemLike result, ItemLike dye) {
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 8).define('D', dye).define('S', Items.GLOW_INK_SAC).define('A', Items.AMETHYST_SHARD).pattern(" A ").pattern("SDS").pattern(" A ").group("neon_blocks").unlockedBy(getHasName(Items.GLOW_INK_SAC), has(Items.GLOW_INK_SAC)).save(output);
            }

            public void futurneo(ItemLike result, ItemLike glass) {
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 6).define('A', Items.BLACK_DYE).define('B', glass).define('C', Blocks.TORCH).pattern("ABA").pattern("BCB").pattern("ABA").group("futurneo_blocks").unlockedBy(getHasName(glass), has(glass)).save(output);
            }

            public void boats(ItemLike boat, ItemLike chestBoat, ItemLike planks) {
                woodenBoat(boat, planks);
                chestBoat(chestBoat, boat);
            }

            public void twoInVertical(ItemLike result, ItemLike input, int count) {
                shaped(RecipeCategory.BUILDING_BLOCKS, result, count).define('#', input).pattern("#").pattern("#").unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void chiseled(ItemLike result, ItemLike input, ItemLike... ingredients) {
                twoInVertical(result, input, 1);
                stonecuttingRecipe(result, ingredients);
            }

            public void pillar(ItemLike result, ItemLike input, ItemLike... ingredients) {
                twoInVertical(result, input, 2);
                stonecuttingRecipe(result, ingredients);
                stonecuttingRecipe(result, input);
            }

            public void herringbone(ItemLike result, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 5).define('#', input).pattern("#  ").pattern("###").pattern("  #").unlockedBy(getHasName(input), has(input)).save(output);
                stonecuttingRecipe(result, input);
            }

            public void herringbone(ItemLike result, ItemLike input, ItemLike... ingredients) {
                herringbone(result, input);
                stonecuttingRecipe(result, ingredients);
            }

            public void herringbonePlanks(ItemLike result, ItemLike input) {
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 5).define('#', input).pattern("#  ").pattern("###").pattern("  #").group("herringbone_planks").unlockedBy(getHasName(input), has(input)).save(output);
            }

            public void blockStairsSlab(ItemLike block, ItemLike stairs, ItemLike slab) {
                // For block, stairs and slab.
                stairs(stairs, block);
                slab(RecipeCategory.BUILDING_BLOCKS, slab, block);
            }

            public void blockStairsSlabWall(ItemLike block, ItemLike stairs, ItemLike slab, ItemLike wall) {
                // For block, stairs, slab and wall.
                blockStairsSlab(block, stairs, slab);
                wall(RecipeCategory.DECORATIONS, wall, block);
            }

            public void blockStairsSlabWallCuttingRecipe(BSSWBundle bsswBundle, ItemLike... ingredients) {
                // For block, stairs, slab and wall (if exists) in BSSWBundle.
                if (ingredients != null) {
                    stonecuttingRecipe(bsswBundle.block(), ingredients);
                    stonecuttingRecipe(bsswBundle.stairs(), ingredients);
                    stonecuttingRecipe(bsswBundle.slab(), 2, ingredients);
                    if (bsswBundle.wall() != null) {
                        stonecuttingRecipe(RecipeCategory.DECORATIONS, bsswBundle.wall(), ingredients);
                    }
                }
                stonecuttingRecipe(bsswBundle.stairs(), bsswBundle.block());
                stonecuttingRecipe(bsswBundle.slab(), 2, bsswBundle.block());
                if (bsswBundle.wall() != null) {
                    stonecuttingRecipe(RecipeCategory.DECORATIONS, bsswBundle.wall(), bsswBundle.block());
                }
            }

            public void stonecuttingRecipe(ItemLike result, ItemLike... ingredients) {
                stonecuttingRecipe(result, 1, ingredients);
            }

            public void stonecuttingRecipe(ItemLike result, int count, ItemLike... ingredients) {
                stonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, result, count, ingredients);
            }

            public void stonecuttingRecipe(RecipeCategory category, ItemLike result, ItemLike... ingredients) {
                stonecuttingRecipe(category, result, 1, ingredients);
            }

            public void stonecuttingRecipe(RecipeCategory category, ItemLike result, int count, ItemLike... ingredients) {

                for (ItemLike itemConvertible : ingredients) {
                    SingleItemRecipeBuilder var10000 = SingleItemRecipeBuilder.stonecutting(Ingredient.of(itemConvertible), category, result, count).unlockedBy(getHasName(itemConvertible), has(itemConvertible));
                    String var10002 = getConversionRecipeName(result, itemConvertible);
                    var10000.save(output, var10002 + "_stonecutting");
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
