package com.brand.blockus.datagen.providers;

import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.registry.content.bundles.WoodBundle;
import com.brand.blockus.registry.tag.BlockusBlockTags;
import com.brand.blockus.registry.tag.BlockusItemTags;
import com.brand.blockus.utils.helper.BlockBuilder;
import com.brand.blockus.utils.helper.WoodMaps;
import com.brand.blockus.utils.references.BlockusIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.BlockItemIds;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopperCollection;

import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public BlockusItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, BlockTagsProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    private void copy(Identifier id) {
        TagKey<Block> blockTag = TagKey.create(Registries.BLOCK, id);
        TagKey<Item> itemTag = TagKey.create(Registries.ITEM, id);

        this.copy(blockTag, itemTag);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        this.copy(BlockusBlockTags.BARRIERS, BlockusItemTags.BARRIERS);
        this.copy(BlockusBlockTags.LANTERN_BLOCKS, BlockusItemTags.LANTERN_BLOCKS);
        this.copy(BlockusBlockTags.PATTERNED_WOOL, BlockusItemTags.PATTERNED_WOOL);
        this.copy(BlockusBlockTags.PATTERNED_CARPETS, BlockusItemTags.PATTERNED_CARPETS);
        this.copy(BlockusBlockTags.ALL_PATTERNED_WOOLS, BlockusItemTags.ALL_PATTERNED_WOOLS);
        this.copy(BlockusBlockTags.HEDGES, BlockusItemTags.HEDGES);
        this.copy(BlockusBlockTags.SOUL_SOILS, BlockusItemTags.SOUL_SOILS);
        this.copy(BlockusBlockTags.ASPHALT, BlockusItemTags.ASPHALT);
        this.copy(BlockusBlockTags.TIMBER_FRAMES, BlockusItemTags.TIMBER_FRAMES);
        this.copy(BlockusBlockTags.DYED_STONE_BRICKS, BlockusItemTags.DYED_STONE_BRICKS);
        this.copy(BlockusBlockTags.CONCRETE_BRICKS, BlockusItemTags.CONCRETE_BRICKS);
        this.copy(BlockusBlockTags.SHINGLES, BlockusItemTags.SHINGLES);
        this.copy(BlockusBlockTags.COLORED_TILES, BlockusItemTags.COLORED_TILES);
        this.copy(BlockusBlockTags.REDSTONE_LAMPS, BlockusItemTags.REDSTONE_LAMPS);
        this.copy(BlockusBlockTags.LIT_REDSTONE_LAMPS, BlockusItemTags.LIT_REDSTONE_LAMPS);
        this.copy(BlockusBlockTags.NEON, BlockusItemTags.NEON);
        this.copy(BlockusBlockTags.FUTURNEO_BLOCKS, BlockusItemTags.FUTURNEO_BLOCKS);
        this.copy(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS, BlockusItemTags.GLAZED_TERRACOTTA_PILLARS);
        this.copy(BlockusBlockTags.WARPED_NETHER_GRASS, BlockusItemTags.WARPED_NETHER_GRASS);
        this.copy(BlockusBlockTags.WHITE_OAK_LOGS, BlockusItemTags.WHITE_OAK_LOGS);

        this.builder(BlockusItemTags.PLANKS_THAT_BURN)
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

        this.builder(BlockusItemTags.SHELVES_THAT_BURN)
            .add(BlockItemIds.OAK_SHELF)
            .add(BlockItemIds.SPRUCE_SHELF)
            .add(BlockItemIds.BIRCH_SHELF)
            .add(BlockItemIds.JUNGLE_SHELF)
            .add(BlockItemIds.ACACIA_SHELF)
            .add(BlockItemIds.DARK_OAK_SHELF)
            .add(BlockItemIds.MANGROVE_SHELF)
            .add(BlockItemIds.CHERRY_SHELF)
            .add(BlockItemIds.PALE_OAK_SHELF)
            .add(BlockItemIds.BAMBOO_SHELF)
            .add(toId(RAW_BAMBOO.shelf()))
            .add(toId(WHITE_OAK.shelf()));

        this.builder(BlockusItemTags.WOODEN_MOSAIC_THAT_BURN)
            .add(BlockItemIds.BAMBOO_MOSAIC);
        for (var wood : WoodMaps.values()) {
            if (!wood.data().isBurnable()) continue;
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                this.builder(BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN).add(toId(herringbonePlanks));
            }
            var woodMosaic = WOODEN_MOSAIC.bundle().get(wood.getId());
            if (woodMosaic != null) {
                this.builder(BlockusItemTags.WOODEN_MOSAIC_THAT_BURN).add(toId(woodMosaic.block()));
            }
        }

        this.copy(Identifier.fromNamespaceAndPath("c", "planks_that_burn"));

        // Conventional Item Tags
        this.builder(ConventionalItemTags.CHAINS).add(toId(GOLDEN_CHAIN));
        this.copy(ConventionalBlockTags.SMALL_FLOWERS, ConventionalItemTags.SMALL_FLOWERS);

        // Vanilla Tags
        this.copy(BlockItemTags.OAK_LOGS.block(), ItemTags.OAK_LOGS);
        this.copy(BlockItemTags.SPRUCE_LOGS.block(), ItemTags.SPRUCE_LOGS);
        this.copy(BlockItemTags.BIRCH_LOGS.block(), ItemTags.BIRCH_LOGS);
        this.copy(BlockTags.JUNGLE_LOGS, ItemTags.JUNGLE_LOGS);
        this.copy(BlockItemTags.ACACIA_LOGS.block(), ItemTags.ACACIA_LOGS);
        this.copy(BlockItemTags.DARK_OAK_LOGS.block(), ItemTags.DARK_OAK_LOGS);
        this.copy(BlockItemTags.MANGROVE_LOGS.block(), ItemTags.MANGROVE_LOGS);
        this.copy(BlockItemTags.CHERRY_LOGS.block(), ItemTags.CHERRY_LOGS);
        this.copy(BlockTags.PALE_OAK_LOGS, ItemTags.PALE_OAK_LOGS);
        this.copy(BlockItemTags.CRIMSON_STEMS.block(), ItemTags.CRIMSON_STEMS);
        this.copy(BlockItemTags.WARPED_STEMS.block(), ItemTags.WARPED_STEMS);
        this.copy(BlockItemTags.LOGS_THAT_BURN.block(), ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);

        this.builder(ItemTags.BOATS)
            .add(toId(BlockusItems.RAW_BAMBOO_RAFT))
            .add(toId(BlockusItems.CHARRED_BOAT))
            .add(toId(BlockusItems.WHITE_OAK_BOAT));

        this.builder(ItemTags.CHEST_BOATS)
            .add(toId(BlockusItems.RAW_BAMBOO_CHEST_RAFT))
            .add(toId(BlockusItems.CHARRED_CHEST_BOAT))
            .add(toId(BlockusItems.WHITE_OAK_CHEST_BOAT));

        for (WoodBundle woodBundle : WoodBundle.values()) {
            this.builder(ItemTags.WOODEN_DOORS).add(toId(woodBundle.door()));
            this.builder(ItemTags.WOODEN_TRAPDOORS).add(toId(woodBundle.trapdoor()));
            this.builder(ItemTags.SIGNS).add(toId(woodBundle.sign()));
            this.builder(ItemTags.HANGING_SIGNS).add(toId(woodBundle.hangingSign()));
        }

        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);

        var nonFlammableWood = this.builder(ItemTags.NON_FLAMMABLE_WOOD);
        nonFlammableWood
            .add(toId(CHARRED.planks()))
            .add(toId(CHARRED.slab()))
            .add(toId(CHARRED.pressurePlate()))
            .add(toId(CHARRED.fence()))
            .add(toId(CHARRED.trapdoor()))
            .add(toId(CHARRED.fenceGate()))
            .add(toId(CHARRED.stairs()))
            .add(toId(CHARRED.button()))
            .add(toId(CHARRED.door()))
            .add(toId(BlockusItems.CHARRED_BOAT))
            .add(toId(BlockusItems.CHARRED_CHEST_BOAT))
            .add(toId(CHARRED.sign()))
            .add(toId(CHARRED.hangingSign()))
            .add(toId(SMALL_LOGS.get(WoodMaps.WARPED.getId())))
            .add(toId(SMALL_LOGS.get(WoodMaps.CRIMSON.getId())));
        for (var wood : WoodMaps.values()) {
            if (wood.data().isBurnable()) continue;
            var woodMosaic = WOODEN_MOSAIC.bundle().get(wood.getId());
            if (woodMosaic != null) {
                nonFlammableWood.add(toId(woodMosaic.block()));
            }
            var mossyPlanks = MOSSY_PLANKS.bundle().get(wood.getId());
            if (mossyPlanks != null) {
                nonFlammableWood.add(toId(mossyPlanks.block()));
            }
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                nonFlammableWood.add(toId(herringbonePlanks));
            }
        }

        this.copy(BlockItemTags.SAPLINGS.block(), ItemTags.SAPLINGS);
        this.copy(BlockTags.SMALL_FLOWERS, BlockItemTags.SMALL_FLOWERS.item());
        this.copy(BlockTags.DIRT, ItemTags.DIRT);
        this.copy(BlockTags.STAIRS, BlockItemTags.STAIRS.item());
        this.copy(BlockTags.SLABS, BlockItemTags.SLABS.item());
        this.copy(BlockTags.WALLS, ItemTags.WALLS);
        this.builder(BlockItemTags.BUTTONS.item())
            .add(toId(POLISHED_ANDESITE_BUTTON))
            .add(toId(POLISHED_DIORITE_BUTTON))
            .add(toId(POLISHED_GRANITE_BUTTON))
            .add(toId(LIMESTONE_BUTTON))
            .add(toId(MARBLE_BUTTON))
            .add(toId(BLUESTONE_BUTTON))
            .add(toId(POLISHED_NETHERRACK_BUTTON))
            .add(toId(POLISHED_END_STONE_BUTTON))
            .add(toId(VIRIDITE_BUTTON));

        this.copy(BlockTags.STONE_BUTTONS, BlockItemTags.STONE_BUTTONS.item());

        this.builder(BlockItemTags.DOORS.item())
            .add(toId(PAPER_DOOR))
            .add(toId(OBSIDIAN_REINFORCED_DOOR))
            .add(toId(STONE_DOOR))
            .add(toId(BLACKSTONE_DOOR));

        this.builder(BlockItemTags.TRAPDOORS.item())
            .add(toId(PAPER_TRAPDOOR))
            .add(toId(OBSIDIAN_REINFORCED_TRAPDOOR))
            .add(toId(STONE_TRAPDOOR))
            .add(toId(BLACKSTONE_TRAPDOOR));

        this.builder(ItemTags.WOOL).addTag(BlockusItemTags.PATTERNED_WOOL).add(toId(RAINBOW_WOOL));
        this.copy(BlockTags.WOOL_CARPETS, ItemTags.WOOL_CARPETS);
        this.copy(BlockTags.BEDS, ItemTags.BEDS);
        this.copy(BlockTags.CONCRETE, ItemTags.CONCRETE);
        this.copy(BlockTags.GLAZED_TERRACOTTA, ItemTags.GLAZED_TERRACOTTA);
        this.copy(BlockTags.BARS, BlockItemTags.BARS.item());
        this.copy(BlockTags.CHAINS, BlockItemTags.CHAINS.item());
        this.copy(BlockTags.LANTERNS, BlockItemTags.LANTERNS.item());

        this.builder(BlockusItemTags.NATURAL_ICE)
            .add(BlockItemIds.ICE)
            .add(BlockItemIds.PACKED_ICE)
            .add(BlockItemIds.BLUE_ICE);

        this.copy(BlockTags.BEE_ATTRACTIVE, ItemTags.BEE_FOOD);

        this.builder(ItemTags.PIGLIN_LOVED)
            .add(toId(LEGACY_GOLD_BLOCK))
            .add(toId(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK))
            .add(toId(GOLDEN_CHAIN))
            .add(toId(GOLDEN_BARS))
            .add(toId(GOLDEN_GATE))
            .add(toId(GOLD_DECORATED_SANDSTONE))
            .add(toId(GOLD_DECORATED_RED_SANDSTONE))
            .add(toId(GOLD_DECORATED_SOUL_SANDSTONE))
            .add(toId(GOLD_DECORATED_POLISHED_BLACKSTONE))
            .add(toId(GOLD_PLATING.block()))
            .add(toId(GOLD_PLATING.stairs()))
            .add(toId(GOLD_PLATING.slab()))
            .add(toId(GOLD_BRICKS.block()))
            .add(toId(GOLD_BRICKS.stairs()))
            .add(toId(GOLD_BRICKS.slab()))
            .add(toId(GOLD_BRICKS.wall()))
            .add(toId(GOLDEN_APPLE_CRATE))
            .add(toId(GOLDEN_CARROT_CRATE));

        this.copy(BlockTags.PIGLIN_REPELLENTS, ItemTags.PIGLIN_REPELLENTS);

        // Sulfur Cube
        this.builder(ItemTags.SULFUR_CUBE_ARCHETYPE_REGULAR)
            .add(toId(CHOCOLATE_BLOCK.block()))
            .add(toId(CHOCOLATE_BRICKS.block()))
            .add(toId(CHOCOLATE_SQUARES))
            .add(toId(CHARCOAL_BLOCK))
            .add(toId(SUGAR_BLOCK))
            .add(toId(LEGACY_FIRST_GRASS_BLOCK))
            .add(toId(LEGACY_GRASS_BLOCK))
            .add(toId(LEGACY_COAL_BLOCK));

        this.builder(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_BOUNCY)
            .add(toId(COBBLESTONE_BRICKS.block()))
            .add(toId(MOSSY_COBBLESTONE_BRICKS.block()))
            .add(toId(STONE_TILES.block()))
            .add(toId(BlockusBlocks.STONE_BRICK_PILLAR))
            .add(toId(HERRINGBONE_STONE_BRICKS))
            .add(toId(STONE_CIRCULAR_PAVING))
            .add(toId(STURDY_STONE))

            .add(toId(POLISHED_AMETHYST.block()))
            .add(toId(AMETHYST_BRICKS.block()))
            .add(toId(CHISELED_AMETHYST))
            .add(toId(AMETHYST_PILLAR))

            .add(toId(ANDESITE_BRICKS.block()))
            .add(toId(HERRINGBONE_ANDESITE_BRICKS))
            .add(toId(CHISELED_ANDESITE_BRICKS))
            .add(toId(CRACKED_ANDESITE_BRICKS))
            .add(toId(POLISHED_ANDESITE_PILLAR))
            .add(toId(ANDESITE_CIRCULAR_PAVING))

            .add(toId(DIORITE_BRICKS.block()))
            .add(toId(HERRINGBONE_DIORITE_BRICKS))
            .add(toId(CHISELED_DIORITE_BRICKS))
            .add(toId(CRACKED_DIORITE_BRICKS))
            .add(toId(POLISHED_DIORITE_PILLAR))
            .add(toId(DIORITE_CIRCULAR_PAVING))

            .add(toId(GRANITE_BRICKS.block()))
            .add(toId(HERRINGBONE_GRANITE_BRICKS))
            .add(toId(CHISELED_GRANITE_BRICKS))
            .add(toId(CRACKED_GRANITE_BRICKS))
            .add(toId(POLISHED_GRANITE_PILLAR))
            .add(toId(GRANITE_CIRCULAR_PAVING))

            .add(toId(ROUGH_BASALT.block()))
            .add(toId(POLISHED_BASALT_BRICKS.block()))
            .add(toId(CHISELED_POLISHED_BASALT))
            .add(toId(CRACKED_POLISHED_BASALT_BRICKS))
            .add(toId(POLISHED_BASALT_PILLAR))
            .add(toId(HERRINGBONE_POLISHED_BASALT_BRICKS))
            .add(toId(POLISHED_BASALT_CIRCULAR_PAVING))

            .add(toId(POLISHED_BLACKSTONE_TILES.block()))
            .add(toId(POLISHED_BLACKSTONE_PILLAR))
            .add(toId(HERRINGBONE_POLISHED_BLACKSTONE_BRICKS))
            .add(toId(POLISHED_BLACKSTONE_CIRCULAR_PAVING))
            .add(toId(CRIMSON_WARTY_BLACKSTONE_BRICKS.block()))
            .add(toId(WARPED_WARTY_BLACKSTONE_BRICKS.block()))
            .add(toId(GOLD_DECORATED_POLISHED_BLACKSTONE))

            .add(toId(LARGE_BRICKS.block()))
            .add(toId(HERRINGBONE_BRICKS))
            .add(toId(SOAKED_BRICKS.block()))
            .add(toId(HERRINGBONE_SOAKED_BRICKS))
            .add(toId(SANDY_BRICKS.block()))
            .add(toId(HERRINGBONE_SANDY_BRICKS))
            .add(toId(CHARRED_BRICKS.block()))
            .add(toId(HERRINGBONE_CHARRED_BRICKS))

            .add(toId(CHISELED_MUD_BRICKS))
            .add(toId(MUD_BRICK_PILLAR))
            .add(toId(WATER_BRICKS.block()))
            .add(toId(CHISELED_WATER_BRICKS))
            .add(toId(LAVA_BRICKS.block()))
            .add(toId(CHISELED_LAVA_BRICKS))
            .add(toId(LAVA_POLISHED_BLACKSTONE_BRICKS.block()))
            .add(toId(CHISELED_LAVA_POLISHED_BLACKSTONE))
            .add(toId(MAGMA_BRICKS.block()))
            .add(toId(SMALL_MAGMA_BRICKS.block()))
            .add(toId(CHISELED_MAGMA_BRICKS))
            .add(toId(BLAZE_BRICKS.block()))
            .add(toId(BLAZE_PILLAR))

            .add(toId(RAINBOW_BLOCK))
            .add(toId(RAINBOW_BRICKS.block()))

            .add(toId(COBBLED_DEEPSLATE_BRICKS.block()))
            .add(toId(MOSSY_DEEPSLATE_BRICKS.block()))

            .add(toId(HERRINGBONE_DEEPSLATE_BRICKS))
            .add(toId(DEEPSLATE_PILLAR))
            .add(toId(DEEPSLATE_CIRCULAR_PAVING))
            .add(toId(STURDY_DEEPSLATE))

            .add(toId(SULFUR_TILES.block()))
            .add(toId(HERRINGBONE_SULFUR_BRICKS))
            .add(toId(SULFUR_PILLAR))
            .add(toId(SULFUR_CIRCULAR_PAVING))

            .add(toId(CINNABAR_TILES.block()))
            .add(toId(HERRINGBONE_CINNABAR_BRICKS))
            .add(toId(CINNABAR_PILLAR))
            .add(toId(CINNABAR_CIRCULAR_PAVING))

            .add(toId(MOSSY_TUFF_BRICKS.block()))
            .add(toId(TUFF_TILES.block()))
            .add(toId(CRACKED_TUFF_BRICKS))
            .add(toId(CARVED_TUFF_BRICKS))
            .add(toId(HERRINGBONE_TUFF_BRICKS))
            .add(toId(TUFF_PILLAR))
            .add(toId(TUFF_CIRCULAR_PAVING))
            .addAll(toIds(BlockusIds.COPPER_TUFF_BRICKS))

            .add(toId(POLISHED_DRIPSTONE.block()))
            .add(toId(DRIPSTONE_BRICKS.block()))
            .add(toId(MOSSY_DRIPSTONE_BRICKS.block()))
            .add(toId(CRACKED_DRIPSTONE_BRICKS))
            .add(toId(CHISELED_DRIPSTONE))
            .add(toId(DRIPSTONE_PILLAR))

            .add(toId(CHISELED_END_STONE_BRICKS))
            .add(toId(HERRINGBONE_END_STONE_BRICKS))
            .add(toId(POLISHED_END_STONE.block()))
            .add(toId(CRACKED_END_STONE_BRICKS))
            .add(toId(END_STONE_PILLAR))
            .add(toId(SMALL_END_STONE_BRICKS.block()))
            .add(toId(PURPUR_DECORATED_END_STONE))
            .add(toId(PHANTOM_PURPUR_DECORATED_END_STONE))

            .add(toId(LIMESTONE.block()))
            .add(toId(POLISHED_LIMESTONE.block()))
            .add(toId(LIMESTONE_BRICKS.block()))
            .add(toId(LIMESTONE_TILES.block()))
            .add(toId(LIMESTONE_PILLAR))
            .add(toId(LIMESTONE_SQUARES))
            .add(toId(SMALL_LIMESTONE_BRICKS.block()))
            .add(toId(CHISELED_LIMESTONE))
            .add(toId(CHISELED_LIMESTONE_PILLAR))
            .add(toId(CHISELED_LIMESTONE_BRICKS))
            .add(toId(LIMESTONE_LINES))
            .add(toId(LIMESTONE_CIRCULAR_PAVING))

            .add(toId(MARBLE.block()))
            .add(toId(POLISHED_MARBLE.block()))
            .add(toId(MARBLE_BRICKS.block()))
            .add(toId(MARBLE_TILES.block()))
            .add(toId(MARBLE_PILLAR))
            .add(toId(MARBLE_SQUARES))
            .add(toId(SMALL_MARBLE_BRICKS.block()))
            .add(toId(CHISELED_MARBLE_PILLAR))
            .add(toId(CHISELED_MARBLE_BRICKS))
            .add(toId(CHISELED_MARBLE))
            .add(toId(MARBLE_LINES))
            .add(toId(MARBLE_CIRCULAR_PAVING))

            .add(toId(BLUESTONE.block()))
            .add(toId(BLUESTONE_PILLAR))
            .add(toId(BLUESTONE_BRICKS.block()))
            .add(toId(BLUESTONE_TILES.block()))
            .add(toId(POLISHED_BLUESTONE.block()))
            .add(toId(BLUESTONE_SQUARES))
            .add(toId(SMALL_BLUESTONE_BRICKS.block()))
            .add(toId(CHISELED_BLUESTONE))
            .add(toId(BLUESTONE_CIRCULAR_PAVING))
            .add(toId(CHISELED_BLUESTONE_PILLAR))
            .add(toId(CHISELED_BLUESTONE_BRICKS))
            .add(toId(BLUESTONE_LINES))

            .add(toId(VIRIDITE.block()))
            .add(toId(POLISHED_VIRIDITE.block()))
            .add(toId(VIRIDITE_BRICKS.block()))
            .add(toId(VIRIDITE_TILES.block()))
            .add(toId(VIRIDITE_PILLAR))
            .add(toId(VIRIDITE_SQUARES))
            .add(toId(SMALL_VIRIDITE_BRICKS.block()))
            .add(toId(CHISELED_VIRIDITE))
            .add(toId(CHISELED_VIRIDITE_PILLAR))
            .add(toId(CHISELED_VIRIDITE_BRICKS))
            .add(toId(VIRIDITE_CIRCULAR_PAVING))
            .add(toId(VIRIDITE_LINES))

            .add(toId(ROUGH_SANDSTONE.block()))
            .add(toId(SANDSTONE_BRICKS.block()))
            .add(toId(SMALL_SANDSTONE_BRICKS.block()))
            .add(toId(GOLD_DECORATED_SANDSTONE))
            .add(toId(LAPIS_DECORATED_SANDSTONE))
            .add(toId(SANDSTONE_PILLAR))

            .add(toId(ROUGH_RED_SANDSTONE.block()))
            .add(toId(RED_SANDSTONE_BRICKS.block()))
            .add(toId(SMALL_RED_SANDSTONE_BRICKS.block()))
            .add(toId(GOLD_DECORATED_RED_SANDSTONE))
            .add(toId(LAPIS_DECORATED_RED_SANDSTONE))
            .add(toId(RED_SANDSTONE_PILLAR))

            .add(toId(POLISHED_NETHER_BRICKS.block()))
            .add(toId(POLISHED_RED_NETHER_BRICKS.block()))
            .add(toId(HERRINGBONE_NETHER_BRICKS))
            .add(toId(HERRINGBONE_RED_NETHER_BRICKS))
            .add(toId(NETHER_BRICK_PILLAR))
            .add(toId(RED_NETHER_BRICK_PILLAR))
            .add(toId(CHARRED_NETHER_BRICKS.block()))
            .add(toId(POLISHED_CHARRED_NETHER_BRICKS.block()))
            .add(toId(HERRINGBONE_CHARRED_NETHER_BRICKS))
            .add(toId(CHARRED_NETHER_BRICK_PILLAR))
            .add(toId(TEAL_NETHER_BRICKS.block()))
            .add(toId(POLISHED_TEAL_NETHER_BRICKS.block()))
            .add(toId(HERRINGBONE_TEAL_NETHER_BRICKS))
            .add(toId(TEAL_NETHER_BRICK_PILLAR))

            .add(toId(POLISHED_NETHERRACK.block()))
            .add(toId(NETHERRACK_BRICKS.block()))
            .add(toId(NETHERRACK_CIRCULAR_PAVING))
            .add(toId(NETHER_TILES.block()))
            .add(toId(END_TILES.block()))

            .add(toId(QUARTZ_TILES.block()))
            .add(toId(QUARTZ_CIRCULAR_PAVING))

            .add(toId(OBSIDIAN_BRICKS.block()))
            .add(toId(CRACKED_OBSIDIAN_BRICKS))
            .add(toId(SMALL_OBSIDIAN_BRICKS.block()))
            .add(toId(OBSIDIAN_PILLAR))
            .add(toId(OBSIDIAN_CIRCULAR_PAVING))
            .add(toId(GLOWING_OBSIDIAN))
            .add(toId(LEGACY_CRYING_OBSIDIAN))
            .add(toId(LEGACY_GLOWING_OBSIDIAN))

            .add(toId(PRISMARINE_CIRCULAR_PAVING))
            .add(toId(CHISELED_DARK_PRISMARINE))
            .add(toId(DARK_PRISMARINE_PILLAR))
            .add(toId(CHISELED_PRISMARINE))
            .add(toId(PRISMARINE_PILLAR))
            .add(toId(PRISMARINE_TILES.block()))

            .add(toId(PURPUR_BRICKS.block()))
            .add(toId(POLISHED_PURPUR.block()))
            .add(toId(PURPUR_SQUARES))
            .add(toId(SMALL_PURPUR_BRICKS.block()))
            .add(toId(CHISELED_PURPUR))
            .add(toId(PURPUR_LINES))

            .add(toId(PHANTOM_PURPUR_BLOCK.block()))
            .add(toId(PHANTOM_PURPUR_PILLAR))
            .add(toId(PHANTOM_PURPUR_BRICKS.block()))
            .add(toId(POLISHED_PHANTOM_PURPUR.block()))
            .add(toId(PHANTOM_PURPUR_SQUARES))
            .add(toId(SMALL_PHANTOM_PURPUR_BRICKS.block()))
            .add(toId(CHISELED_PHANTOM_PURPUR))
            .add(toId(PHANTOM_PURPUR_LINES))

            .add(toId(LAPIS_BRICKS.block()))
            .add(toId(EMERALD_BRICKS.block()))
            .add(toId(DIAMOND_BRICKS.block()))
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
            .add(toId(LEGACY_DIAMOND_BLOCK))
            .add(toId(LEGACY_LAPIS_BLOCK))
            .addTag(BlockusItemTags.DYED_STONE_BRICKS)
            .addTag(BlockusItemTags.ASPHALT)
            .addTag(BlockusItemTags.REDSTONE_LAMPS)
            .addTag(BlockusItemTags.NEON)
            .addTag(BlockusItemTags.FUTURNEO_BLOCKS)
            .addTag(BlockusItemTags.COLORED_TILES);

        var bouncy = this.builder(ItemTags.SULFUR_CUBE_ARCHETYPE_BOUNCY);
        WOODEN_MOSAIC.forEach(block -> bouncy.add(toId(block.block())));
        MOSSY_PLANKS.forEach(block -> bouncy.add(toId(block.block())));
        bouncy.add(toId(FRAMED_PAPER_BLOCK))
            .add(toId(SALMON_CRATE))
            .add(toId(PUFFERFISH_CRATE))
            .add(toId(TROPICAL_FISH_CRATE))
            .add(toId(COD_CRATE))
            .add(toId(BREAD_BOX))
            .addTag(BlockusItemTags.TIMBER_FRAMES);

        this.builder(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_SLIDING)
            .add(toId(ICE_BRICKS))
            .add(toId(ICE_PILLAR))
            .add(toId(SNOW_BRICKS.block()))
            .add(toId(SNOW_PILLAR));

        this.builder(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_SLIDING)
            .add(toId(CRIMSON_WART_BRICKS.block()))
            .add(toId(WARPED_WART_BRICKS.block()));

        this.builder(ItemTags.SULFUR_CUBE_ARCHETYPE_HIGH_RESISTANCE)
            .add(toId(SOUL_SANDSTONE.block()))
            .add(toId(ROUGH_SOUL_SANDSTONE.block()))
            .add(toId(SMOOTH_SOUL_SANDSTONE.block()))
            .add(toId(SOUL_SANDSTONE_BRICKS.block()))
            .add(toId(SMALL_SOUL_SANDSTONE_BRICKS.block()))
            .add(toId(CUT_SOUL_SANDSTONE))
            .add(toId(CUT_SOUL_SANDSTONE_SLAB))
            .add(toId(CHISELED_SOUL_SANDSTONE))
            .add(toId(GOLD_DECORATED_SOUL_SANDSTONE))
            .add(toId(LAPIS_DECORATED_SOUL_SANDSTONE))
            .add(toId(SOUL_SANDSTONE_PILLAR));

        this.builder(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_FLAT)
            .add(toId(LARGE_RESIN_BRICKS.block()))
            .add(toId(HERRINGBONE_RESIN_BRICKS))
            .add(toId(RESIN_BRICK_PILLAR))
//            .add(id(POLISHED_SCULK.block()))
//            .add(id(SCULK_BRICKS.block()))
//            .add(id(CHISELED_SCULK_BRICKS))
//            .add(id(SCULK_PILLAR))
            .add(toId(PAPER_BLOCK))
            .add(toId(BURNT_PAPER_BLOCK))
            .add(toId(SOUL_O_LANTERN))
            .add(toId(COPPER_JACK_O_LANTERN))
            .add(toId(REDSTONE_O_LANTERN))
            .add(toId(THATCH.block()))
            .add(toId(ROTTEN_FLESH_BLOCK))
            .add(toId(CHORUS_BLOCK))
            .add(toId(LEGACY_SPONGE));

        this.builder(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_FLAT)
            .add(toId(IRON_PLATING.block()))
            .add(toId(GOLD_PLATING.block()))
            .add(toId(IRON_BRICKS.block()))
            .add(toId(GOLD_BRICKS.block()))
            .addAll(toIds(BlockusIds.COPPER_BRICKS))
            .add(toId(NETHERITE_BRICKS.block()))
            .add(toId(LEGACY_IRON_BLOCK))
            .add(toId(LEGACY_GOLD_BLOCK))
            .add(toId(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK))
            .addTag(BlockusItemTags.LANTERN_BLOCKS);

        this.builder(ItemTags.SULFUR_CUBE_ARCHETYPE_STICKY).add(toId(HONEYCOMB_BRICKS.block()));
    }

    public BlockItemId toId(Block block) {
        return BlockBuilder.getId(Block.byItem(block.asItem()));
    }

    public ResourceKey<Item> toId(Item item) {
        return BlockusItems.getId(item);
    }

    private static WeatheringCopperCollection<ResourceKey<Item>> toIds(final WeatheringCopperCollection<BlockItemId> ids) {
        return ids.map(BlockItemId::item);
    }
}
