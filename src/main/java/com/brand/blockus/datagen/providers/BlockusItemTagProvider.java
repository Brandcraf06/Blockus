package com.brand.blockus.datagen.providers;

import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.registry.content.bundles.WoodBundle;
import com.brand.blockus.registry.tag.BlockusBlockTags;
import com.brand.blockus.registry.tag.BlockusItemTags;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

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
        this.copy(BlockusBlockTags.LIT_REDSTONE_LAMPS, BlockusItemTags.LIT_REDSTONE_LAMPS);
        this.copy(BlockusBlockTags.NEON, BlockusItemTags.NEON);
        this.copy(BlockusBlockTags.FUTURNEO_BLOCKS, BlockusItemTags.FUTURNEO_BLOCKS);
        this.copy(BlockusBlockTags.GLAZED_TERRACOTTA_PILLARS, BlockusItemTags.GLAZED_TERRACOTTA_PILLARS);
        this.copy(BlockusBlockTags.WARPED_NETHER_GRASS, BlockusItemTags.WARPED_NETHER_GRASS);
        this.copy(BlockusBlockTags.WHITE_OAK_LOGS, BlockusItemTags.WHITE_OAK_LOGS);

        this.valueLookupBuilder(BlockusItemTags.PLANKS_THAT_BURN)
            .add(Items.OAK_PLANKS)
            .add(Items.SPRUCE_PLANKS)
            .add(Items.BIRCH_PLANKS)
            .add(Items.JUNGLE_PLANKS)
            .add(Items.ACACIA_PLANKS)
            .add(Items.DARK_OAK_PLANKS)
            .add(Items.MANGROVE_PLANKS)
            .add(Items.CHERRY_PLANKS)
            .add(Items.PALE_OAK_PLANKS)
            .add(Items.BAMBOO_PLANKS)
            .add(RAW_BAMBOO.planks().asItem())
            .add(WHITE_OAK.planks().asItem())
            .add(LEGACY_PLANKS.asItem());

        this.valueLookupBuilder(BlockusItemTags.SHELVES_THAT_BURN)
            .add(Items.OAK_SHELF)
            .add(Items.SPRUCE_SHELF)
            .add(Items.BIRCH_SHELF)
            .add(Items.JUNGLE_SHELF)
            .add(Items.ACACIA_SHELF)
            .add(Items.DARK_OAK_SHELF)
            .add(Items.MANGROVE_SHELF)
            .add(Items.CHERRY_SHELF)
            .add(Items.PALE_OAK_SHELF)
            .add(Items.BAMBOO_SHELF)
            .add(RAW_BAMBOO.shelf().asItem())
            .add(WHITE_OAK.shelf().asItem());

        this.valueLookupBuilder(BlockusItemTags.WOODEN_MOSAIC_THAT_BURN)
            .add(Blocks.BAMBOO_MOSAIC.asItem());
        for (var wood : WoodMaps.values()) {
            if (!wood.data().isBurnable()) continue;
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                this.valueLookupBuilder(BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN).add(herringbonePlanks.asItem());
            }
            var woodMosaic = WOODEN_MOSAIC.bundle().get(wood.getId());
            if (woodMosaic != null) {
                this.valueLookupBuilder(BlockusItemTags.WOODEN_MOSAIC_THAT_BURN).add(woodMosaic.block().asItem());
            }
        }

        this.copy(Identifier.fromNamespaceAndPath("c", "planks_that_burn"));

        // Conventional Item Tags
        this.valueLookupBuilder(ConventionalItemTags.CHAINS).add(GOLDEN_CHAIN.asItem());
        this.copy(ConventionalBlockTags.SMALL_FLOWERS, ConventionalItemTags.SMALL_FLOWERS);

        // Vanilla Tags
        this.copy(BlockTags.OAK_LOGS, ItemTags.OAK_LOGS);
        this.copy(BlockTags.SPRUCE_LOGS, ItemTags.SPRUCE_LOGS);
        this.copy(BlockTags.BIRCH_LOGS, ItemTags.BIRCH_LOGS);
        this.copy(BlockTags.JUNGLE_LOGS, ItemTags.JUNGLE_LOGS);
        this.copy(BlockTags.ACACIA_LOGS, ItemTags.ACACIA_LOGS);
        this.copy(BlockTags.DARK_OAK_LOGS, ItemTags.DARK_OAK_LOGS);
        this.copy(BlockTags.MANGROVE_LOGS, ItemTags.MANGROVE_LOGS);
        this.copy(BlockTags.CHERRY_LOGS, ItemTags.CHERRY_LOGS);
        this.copy(BlockTags.PALE_OAK_LOGS, ItemTags.PALE_OAK_LOGS);
        this.copy(BlockTags.CRIMSON_STEMS, ItemTags.CRIMSON_STEMS);
        this.copy(BlockTags.WARPED_STEMS, ItemTags.WARPED_STEMS);
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);

        this.valueLookupBuilder(ItemTags.BOATS)
            .add(BlockusItems.RAW_BAMBOO_RAFT)
            .add(BlockusItems.CHARRED_BOAT)
            .add(BlockusItems.WHITE_OAK_BOAT);

        this.valueLookupBuilder(ItemTags.CHEST_BOATS)
            .add(BlockusItems.RAW_BAMBOO_CHEST_RAFT)
            .add(BlockusItems.CHARRED_CHEST_BOAT)
            .add(BlockusItems.WHITE_OAK_CHEST_BOAT);

        for (WoodBundle woodBundle : WoodBundle.values()) {
            this.valueLookupBuilder(ItemTags.WOODEN_DOORS).add(woodBundle.door().asItem());
            this.valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS).add(woodBundle.trapdoor().asItem());
            this.valueLookupBuilder(ItemTags.SIGNS).add(woodBundle.sign().asItem());
            this.valueLookupBuilder(ItemTags.HANGING_SIGNS).add(woodBundle.hangingSign().asItem());
        }

        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);

        var nonFlammableWood = this.valueLookupBuilder(ItemTags.NON_FLAMMABLE_WOOD);
        nonFlammableWood
            .add(CHARRED.planks().asItem())
            .add(CHARRED.slab().asItem())
            .add(CHARRED.pressurePlate().asItem())
            .add(CHARRED.fence().asItem())
            .add(CHARRED.trapdoor().asItem())
            .add(CHARRED.fenceGate().asItem())
            .add(CHARRED.stairs().asItem())
            .add(CHARRED.button().asItem())
            .add(CHARRED.door().asItem())
            .add(BlockusItems.CHARRED_BOAT)
            .add(BlockusItems.CHARRED_CHEST_BOAT)
            .add(CHARRED.sign())
            .add(CHARRED.hangingSign())
            .add(SMALL_LOGS.get(WoodMaps.WARPED.getId()).asItem())
            .add(SMALL_LOGS.get(WoodMaps.CRIMSON.getId()).asItem());
        for (var wood : WoodMaps.values()) {
            if (wood.data().isBurnable()) continue;
            var woodMosaic = WOODEN_MOSAIC.bundle().get(wood.getId());
            if (woodMosaic != null) {
                nonFlammableWood.add(woodMosaic.block().asItem());
            }
            var mossyPlanks = MOSSY_PLANKS.bundle().get(wood.getId());
            if (mossyPlanks != null) {
                nonFlammableWood.add(mossyPlanks.block().asItem());
            }
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                nonFlammableWood.add(herringbonePlanks.asItem());
            }
        }

        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
        this.copy(BlockTags.DIRT, ItemTags.DIRT);
        this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
        this.copy(BlockTags.SLABS, ItemTags.SLABS);
        this.copy(BlockTags.WALLS, ItemTags.WALLS);
        this.valueLookupBuilder(ItemTags.BUTTONS)
            .add(POLISHED_ANDESITE_BUTTON.asItem())
            .add(POLISHED_DIORITE_BUTTON.asItem())
            .add(POLISHED_GRANITE_BUTTON.asItem())
            .add(LIMESTONE_BUTTON.asItem())
            .add(MARBLE_BUTTON.asItem())
            .add(BLUESTONE_BUTTON.asItem())
            .add(POLISHED_NETHERRACK_BUTTON.asItem())
            .add(POLISHED_END_STONE_BUTTON.asItem())
            .add(VIRIDITE_BUTTON.asItem());

        this.copy(BlockTags.STONE_BUTTONS, ItemTags.STONE_BUTTONS);

        this.valueLookupBuilder(ItemTags.DOORS)
            .add(PAPER_DOOR.asItem())
            .add(OBSIDIAN_REINFORCED_DOOR.asItem())
            .add(STONE_DOOR.asItem())
            .add(BLACKSTONE_DOOR.asItem());

        this.valueLookupBuilder(ItemTags.TRAPDOORS)
            .add(PAPER_TRAPDOOR.asItem())
            .add(OBSIDIAN_REINFORCED_TRAPDOOR.asItem())
            .add(STONE_TRAPDOOR.asItem())
            .add(BLACKSTONE_TRAPDOOR.asItem());

        this.valueLookupBuilder(ItemTags.WOOL).addTag(BlockusItemTags.PATTERNED_WOOL);
        this.copy(BlockTags.WOOL_CARPETS, ItemTags.WOOL_CARPETS);
        this.copy(BlockTags.CONCRETE, ItemTags.CONCRETE);
        this.copy(BlockTags.GLAZED_TERRACOTTA, ItemTags.GLAZED_TERRACOTTA);
        this.copy(BlockTags.BARS, ItemTags.BARS);
        this.copy(BlockTags.CHAINS, ItemTags.CHAINS);
        this.copy(BlockTags.LANTERNS, ItemTags.LANTERNS);

        this.valueLookupBuilder(BlockusItemTags.NATURAL_ICE)
            .add(Items.ICE)
            .add(Items.PACKED_ICE)
            .add(Items.BLUE_ICE);

        this.copy(BlockTags.BEE_ATTRACTIVE, ItemTags.BEE_FOOD);

        this.valueLookupBuilder(ItemTags.PIGLIN_LOVED)
            .add(LEGACY_GOLD_BLOCK.asItem())
            .add(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK.asItem())
            .add(GOLDEN_CHAIN.asItem())
            .add(GOLDEN_BARS.asItem())
            .add(GOLDEN_GATE.asItem())
            .add(GOLD_DECORATED_SANDSTONE.asItem())
            .add(GOLD_DECORATED_RED_SANDSTONE.asItem())
            .add(GOLD_DECORATED_SOUL_SANDSTONE.asItem())
            .add(GOLD_DECORATED_POLISHED_BLACKSTONE.asItem())
            .add(GOLD_PLATING.block().asItem())
            .add(GOLD_PLATING.stairs().asItem())
            .add(GOLD_PLATING.slab().asItem())
            .add(GOLD_BRICKS.block().asItem())
            .add(GOLD_BRICKS.stairs().asItem())
            .add(GOLD_BRICKS.slab().asItem())
            .add(GOLD_BRICKS.wall().asItem())
            .add(GOLDEN_APPLE_CRATE.asItem())
            .add(GOLDEN_CARROT_CRATE.asItem());

        this.copy(BlockTags.PIGLIN_REPELLENTS, ItemTags.PIGLIN_REPELLENTS);

        // Sulfur Cube
        this.valueLookupBuilder(ItemTags.SULFUR_CUBE_ARCHETYPE_REGULAR)
            .add(COBBLESTONE_BRICKS.block().asItem())
            .add(MOSSY_COBBLESTONE_BRICKS.block().asItem())
            .add(STONE_TILES.block().asItem())
            .add(STONE_BRICK_PILLAR.asItem())
            .add(HERRINGBONE_STONE_BRICKS.asItem())
            .add(STONE_CIRCULAR_PAVING.asItem())
            .add(STURDY_STONE.asItem())

            .add(POLISHED_AMETHYST.block().asItem())
            .add(AMETHYST_BRICKS.block().asItem())
            .add(CHISELED_AMETHYST.asItem())
            .add(AMETHYST_PILLAR.asItem())

            .add(ANDESITE_BRICKS.block().asItem())
            .add(HERRINGBONE_ANDESITE_BRICKS.asItem())
            .add(CHISELED_ANDESITE_BRICKS.asItem())
            .add(CRACKED_ANDESITE_BRICKS.asItem())
            .add(POLISHED_ANDESITE_PILLAR.asItem())
            .add(ANDESITE_CIRCULAR_PAVING.asItem())

            .add(DIORITE_BRICKS.block().asItem())
            .add(HERRINGBONE_DIORITE_BRICKS.asItem())
            .add(CHISELED_DIORITE_BRICKS.asItem())
            .add(CRACKED_DIORITE_BRICKS.asItem())
            .add(POLISHED_DIORITE_PILLAR.asItem())
            .add(DIORITE_CIRCULAR_PAVING.asItem())

            .add(GRANITE_BRICKS.block().asItem())
            .add(HERRINGBONE_GRANITE_BRICKS.asItem())
            .add(CHISELED_GRANITE_BRICKS.asItem())
            .add(CRACKED_GRANITE_BRICKS.asItem())
            .add(POLISHED_GRANITE_PILLAR.asItem())
            .add(GRANITE_CIRCULAR_PAVING.asItem())

            .add(ROUGH_BASALT.block().asItem())
            .add(POLISHED_BASALT_BRICKS.block().asItem())
            .add(CHISELED_POLISHED_BASALT.asItem())
            .add(CRACKED_POLISHED_BASALT_BRICKS.asItem())
            .add(POLISHED_BASALT_PILLAR.asItem())
            .add(HERRINGBONE_POLISHED_BASALT_BRICKS.asItem())
            .add(POLISHED_BASALT_CIRCULAR_PAVING.asItem())

            .add(POLISHED_BLACKSTONE_TILES.block().asItem())
            .add(POLISHED_BLACKSTONE_PILLAR.asItem())
            .add(HERRINGBONE_POLISHED_BLACKSTONE_BRICKS.asItem())
            .add(POLISHED_BLACKSTONE_CIRCULAR_PAVING.asItem())
            .add(CRIMSON_WARTY_BLACKSTONE_BRICKS.block().asItem())
            .add(WARPED_WARTY_BLACKSTONE_BRICKS.block().asItem())
            .add(GOLD_DECORATED_POLISHED_BLACKSTONE.asItem())

            .add(LARGE_BRICKS.block().asItem())
            .add(HERRINGBONE_BRICKS.asItem())
            .add(SOAKED_BRICKS.block().asItem())
            .add(HERRINGBONE_SOAKED_BRICKS.asItem())
            .add(SANDY_BRICKS.block().asItem())
            .add(HERRINGBONE_SANDY_BRICKS.asItem())
            .add(CHARRED_BRICKS.block().asItem())
            .add(HERRINGBONE_CHARRED_BRICKS.asItem())

            .add(CHISELED_MUD_BRICKS.asItem())
            .add(MUD_BRICK_PILLAR.asItem())
            .add(WATER_BRICKS.block().asItem())
            .add(CHISELED_WATER_BRICKS.asItem())
            .add(LAVA_BRICKS.block().asItem())
            .add(CHISELED_LAVA_BRICKS.asItem())
            .add(LAVA_POLISHED_BLACKSTONE_BRICKS.block().asItem())
            .add(CHISELED_LAVA_POLISHED_BLACKSTONE.asItem())
            .add(MAGMA_BRICKS.block().asItem())
            .add(SMALL_MAGMA_BRICKS.block().asItem())
            .add(CHISELED_MAGMA_BRICKS.asItem())
            .add(BLAZE_BRICKS.block().asItem())
            .add(BLAZE_PILLAR.asItem())

            .add(RAINBOW_BLOCK.asItem())
            .add(RAINBOW_BRICKS.block().asItem())

            .add(CHOCOLATE_BLOCK.block().asItem())
            .add(CHOCOLATE_BRICKS.block().asItem())
            .add(CHOCOLATE_SQUARES.asItem())

            .add(COBBLED_DEEPSLATE_BRICKS.block().asItem())
            .add(MOSSY_DEEPSLATE_BRICKS.block().asItem())

            .add(HERRINGBONE_DEEPSLATE_BRICKS.asItem())
            .add(DEEPSLATE_PILLAR.asItem())
            .add(DEEPSLATE_CIRCULAR_PAVING.asItem())
            .add(STURDY_DEEPSLATE.asItem())

            .add(MOSSY_TUFF_BRICKS.block().asItem())
            .add(TUFF_TILES.block().asItem())
            .add(CRACKED_TUFF_BRICKS.asItem())
            .add(CARVED_TUFF_BRICKS.asItem())
            .add(HERRINGBONE_TUFF_BRICKS.asItem())
            .add(TUFF_PILLAR.asItem())
            .add(TUFF_CIRCULAR_PAVING.asItem())
            .addAll(COPPER_TUFF_BRICKS.asItem())

            .add(POLISHED_DRIPSTONE.block().asItem())
            .add(DRIPSTONE_BRICKS.block().asItem())
            .add(MOSSY_DRIPSTONE_BRICKS.block().asItem())
            .add(CRACKED_DRIPSTONE_BRICKS.asItem())
            .add(CHISELED_DRIPSTONE.asItem())
            .add(DRIPSTONE_PILLAR.asItem())

            .add(CHISELED_END_STONE_BRICKS.asItem())
            .add(HERRINGBONE_END_STONE_BRICKS.asItem())
            .add(POLISHED_END_STONE.block().asItem())
            .add(CRACKED_END_STONE_BRICKS.asItem())
            .add(END_STONE_PILLAR.asItem())
            .add(SMALL_END_STONE_BRICKS.block().asItem())
            .add(PURPUR_DECORATED_END_STONE.asItem())
            .add(PHANTOM_PURPUR_DECORATED_END_STONE.asItem())

            .add(LIMESTONE.block().asItem())
            .add(POLISHED_LIMESTONE.block().asItem())
            .add(LIMESTONE_BRICKS.block().asItem())
            .add(LIMESTONE_TILES.block().asItem())
            .add(LIMESTONE_PILLAR.asItem())
            .add(LIMESTONE_SQUARES.asItem())
            .add(SMALL_LIMESTONE_BRICKS.block().asItem())
            .add(CHISELED_LIMESTONE.asItem())
            .add(CHISELED_LIMESTONE_PILLAR.asItem())
            .add(CHISELED_LIMESTONE_BRICKS.asItem())
            .add(LIMESTONE_LINES.asItem())
            .add(LIMESTONE_CIRCULAR_PAVING.asItem())

            .add(MARBLE.block().asItem())
            .add(POLISHED_MARBLE.block().asItem())
            .add(MARBLE_BRICKS.block().asItem())
            .add(MARBLE_TILES.block().asItem())
            .add(MARBLE_PILLAR.asItem())
            .add(MARBLE_SQUARES.asItem())
            .add(SMALL_MARBLE_BRICKS.block().asItem())
            .add(CHISELED_MARBLE_PILLAR.asItem())
            .add(CHISELED_MARBLE_BRICKS.asItem())
            .add(CHISELED_MARBLE.asItem())
            .add(MARBLE_LINES.asItem())
            .add(MARBLE_CIRCULAR_PAVING.asItem())

            .add(BLUESTONE.block().asItem())
            .add(BLUESTONE_PILLAR.asItem())
            .add(BLUESTONE_BRICKS.block().asItem())
            .add(BLUESTONE_TILES.block().asItem())
            .add(POLISHED_BLUESTONE.block().asItem())
            .add(BLUESTONE_SQUARES.asItem())
            .add(SMALL_BLUESTONE_BRICKS.block().asItem())
            .add(CHISELED_BLUESTONE.asItem())
            .add(BLUESTONE_CIRCULAR_PAVING.asItem())
            .add(CHISELED_BLUESTONE_PILLAR.asItem())
            .add(CHISELED_BLUESTONE_BRICKS.asItem())
            .add(BLUESTONE_LINES.asItem())

            .add(VIRIDITE.block().asItem())
            .add(POLISHED_VIRIDITE.block().asItem())
            .add(VIRIDITE_BRICKS.block().asItem())
            .add(VIRIDITE_TILES.block().asItem())
            .add(VIRIDITE_PILLAR.asItem())
            .add(VIRIDITE_SQUARES.asItem())
            .add(SMALL_VIRIDITE_BRICKS.block().asItem())
            .add(CHISELED_VIRIDITE.asItem())
            .add(CHISELED_VIRIDITE_PILLAR.asItem())
            .add(CHISELED_VIRIDITE_BRICKS.asItem())
            .add(VIRIDITE_CIRCULAR_PAVING.asItem())
            .add(VIRIDITE_LINES.asItem())

            .add(ROUGH_SANDSTONE.block().asItem())
            .add(SANDSTONE_BRICKS.block().asItem())
            .add(SMALL_SANDSTONE_BRICKS.block().asItem())
            .add(GOLD_DECORATED_SANDSTONE.asItem())
            .add(LAPIS_DECORATED_SANDSTONE.asItem())
            .add(SANDSTONE_PILLAR.asItem())

            .add(ROUGH_RED_SANDSTONE.block().asItem())
            .add(RED_SANDSTONE_BRICKS.block().asItem())
            .add(SMALL_RED_SANDSTONE_BRICKS.block().asItem())
            .add(GOLD_DECORATED_RED_SANDSTONE.asItem())
            .add(LAPIS_DECORATED_RED_SANDSTONE.asItem())
            .add(RED_SANDSTONE_PILLAR.asItem())

            .add(POLISHED_NETHER_BRICKS.block().asItem())
            .add(POLISHED_RED_NETHER_BRICKS.block().asItem())
            .add(HERRINGBONE_NETHER_BRICKS.asItem())
            .add(HERRINGBONE_RED_NETHER_BRICKS.asItem())
            .add(NETHER_BRICK_PILLAR.asItem())
            .add(RED_NETHER_BRICK_PILLAR.asItem())
            .add(CHARRED_NETHER_BRICKS.block().asItem())
            .add(POLISHED_CHARRED_NETHER_BRICKS.block().asItem())
            .add(HERRINGBONE_CHARRED_NETHER_BRICKS.asItem())
            .add(CHARRED_NETHER_BRICK_PILLAR.asItem())
            .add(TEAL_NETHER_BRICKS.block().asItem())
            .add(POLISHED_TEAL_NETHER_BRICKS.block().asItem())
            .add(HERRINGBONE_TEAL_NETHER_BRICKS.asItem())
            .add(TEAL_NETHER_BRICK_PILLAR.asItem())

            .add(POLISHED_NETHERRACK.block().asItem())
            .add(NETHERRACK_BRICKS.block().asItem())
            .add(NETHERRACK_CIRCULAR_PAVING.asItem())
            .add(NETHER_TILES.block().asItem())
            .add(END_TILES.block().asItem())

            .add(QUARTZ_TILES.block().asItem())
            .add(QUARTZ_CIRCULAR_PAVING.asItem())

            .add(OBSIDIAN_BRICKS.block().asItem())
            .add(CRACKED_OBSIDIAN_BRICKS.asItem())
            .add(SMALL_OBSIDIAN_BRICKS.block().asItem())
            .add(OBSIDIAN_PILLAR.asItem())
            .add(OBSIDIAN_CIRCULAR_PAVING.asItem())
            .add(GLOWING_OBSIDIAN.asItem())
            .add(LEGACY_CRYING_OBSIDIAN.asItem())
            .add(LEGACY_GLOWING_OBSIDIAN.asItem())

            .add(PRISMARINE_CIRCULAR_PAVING.asItem())
            .add(CHISELED_DARK_PRISMARINE.asItem())
            .add(DARK_PRISMARINE_PILLAR.asItem())
            .add(CHISELED_PRISMARINE.asItem())
            .add(PRISMARINE_PILLAR.asItem())
            .add(PRISMARINE_TILES.block().asItem())

            .add(PURPUR_BRICKS.block().asItem())
            .add(POLISHED_PURPUR.block().asItem())
            .add(PURPUR_SQUARES.asItem())
            .add(SMALL_PURPUR_BRICKS.block().asItem())
            .add(CHISELED_PURPUR.asItem())
            .add(PURPUR_LINES.asItem())

            .add(PHANTOM_PURPUR_BLOCK.block().asItem())
            .add(PHANTOM_PURPUR_PILLAR.asItem())
            .add(PHANTOM_PURPUR_BRICKS.block().asItem())
            .add(POLISHED_PHANTOM_PURPUR.block().asItem())
            .add(PHANTOM_PURPUR_SQUARES.asItem())
            .add(SMALL_PHANTOM_PURPUR_BRICKS.block().asItem())
            .add(CHISELED_PHANTOM_PURPUR.asItem())
            .add(PHANTOM_PURPUR_LINES.asItem())

            .add(LAPIS_BRICKS.block().asItem())
            .add(REDSTONE_BRICKS.block().asItem())
            .add(EMERALD_BRICKS.block().asItem())
            .add(DIAMOND_BRICKS.block().asItem())
            .add(CHARCOAL_BLOCK.asItem())
            .add(ENDER_BLOCK.asItem())
            .add(NETHER_STAR_BLOCK.asItem())
            .add(LOVE_BLOCK.asItem())
            .add(WEIGHT_STORAGE_CUBE.asItem())
            .add(COMPANION_CUBE.asItem())
            .add(CAUTION_BLOCK.asItem())
            .add(STARS_BLOCK.asItem())
            .add(SUGAR_BLOCK.asItem())
            .add(REDSTONE_SAND.asItem())
            .add(SUGAR_BLOCK.asItem())
            .add(LEGACY_FIRST_GRASS_BLOCK.asItem())
            .add(LEGACY_GRASS_BLOCK.asItem())
            .add(LEGACY_GRAVEL.asItem())
            .add(LEGACY_BRICKS.asItem())
            .add(LEGACY_FIRST_COBBLESTONE.asItem())
            .add(LEGACY_COBBLESTONE.asItem())
            .add(LEGACY_MOSSY_COBBLESTONE.asItem())
            .add(LEGACY_COAL_BLOCK.asItem())
            .add(LEGACY_DIAMOND_BLOCK.asItem())
            .add(LEGACY_LAPIS_BLOCK.asItem())
            .addTag(BlockusItemTags.DYED_STONE_BRICKS)
            .addTag(BlockusItemTags.ASPHALT)
            .addTag(BlockusItemTags.LIT_REDSTONE_LAMPS)
            .addTag(BlockusItemTags.NEON)
            .addTag(BlockusItemTags.FUTURNEO_BLOCKS)
            .addTag(BlockusItemTags.COLORED_TILES);

        var bouncy = this.valueLookupBuilder(ItemTags.SULFUR_CUBE_ARCHETYPE_BOUNCY);
        WOODEN_MOSAIC.forEach(block -> bouncy.add(block.block().asItem()));
        MOSSY_PLANKS.forEach(block -> bouncy.add(block.block().asItem()));
        HERRINGBONE_PLANKS.forEach(block -> bouncy.add(block.asItem()));
        bouncy.add(FRAMED_PAPER_BLOCK.asItem())
            .add(SALMON_CRATE.asItem())
            .add(PUFFERFISH_CRATE.asItem())
            .add(TROPICAL_FISH_CRATE.asItem())
            .add(COD_CRATE.asItem())
            .add(BREAD_BOX.asItem())
            .addTag(BlockusItemTags.TIMBER_FRAMES);

        this.valueLookupBuilder(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_SLIDING)
            .add(ICE_BRICKS.asItem())
            .add(ICE_PILLAR.asItem())
            .add(SNOW_BRICKS.block().asItem())
            .add(SNOW_PILLAR.asItem());

        this.valueLookupBuilder(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_SLIDING)
            .add(CRIMSON_WART_BRICKS.block().asItem())
            .add(WARPED_WART_BRICKS.block().asItem());

        this.valueLookupBuilder(ItemTags.SULFUR_CUBE_ARCHETYPE_HIGH_RESISTANCE)
            .add(SOUL_SANDSTONE.block().asItem())
            .add(ROUGH_SOUL_SANDSTONE.block().asItem())
            .add(SMOOTH_SOUL_SANDSTONE.block().asItem())
            .add(SOUL_SANDSTONE_BRICKS.block().asItem())
            .add(SMALL_SOUL_SANDSTONE_BRICKS.block().asItem())
            .add(CUT_SOUL_SANDSTONE.asItem())
            .add(CUT_SOUL_SANDSTONE_SLAB.asItem())
            .add(CHISELED_SOUL_SANDSTONE.asItem())
            .add(GOLD_DECORATED_SOUL_SANDSTONE.asItem())
            .add(LAPIS_DECORATED_SOUL_SANDSTONE.asItem())
            .add(SOUL_SANDSTONE_PILLAR.asItem());

        this.valueLookupBuilder(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_FLAT)
            .add(LARGE_RESIN_BRICKS.block().asItem())
            .add(HERRINGBONE_RESIN_BRICKS.asItem())
            .add(RESIN_BRICK_PILLAR.asItem())
//            .add(POLISHED_SCULK.block().asItem())
//            .add(SCULK_BRICKS.block().asItem())
//            .add(CHISELED_SCULK_BRICKS.asItem())
//            .add(SCULK_PILLAR.asItem())
            .add(PAPER_BLOCK.asItem())
            .add(BURNT_PAPER_BLOCK.asItem())
            .add(SOUL_O_LANTERN.asItem())
            .add(COPPER_JACK_O_LANTERN.asItem())
            .add(REDSTONE_O_LANTERN.asItem())
            .add(THATCH.block().asItem())
            .add(ROTTEN_FLESH_BLOCK.asItem())
            .add(CHORUS_BLOCK.asItem())
            .add(LEGACY_SPONGE.asItem());

        this.valueLookupBuilder(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_FLAT)
            .add(IRON_PLATING.block().asItem())
            .add(GOLD_PLATING.block().asItem())
            .add(IRON_BRICKS.block().asItem())
            .add(GOLD_BRICKS.block().asItem())
            .addAll(COPPER_BRICKS.asItem())
            .add(NETHERITE_BRICKS.block().asItem())
            .add(LEGACY_IRON_BLOCK.asItem())
            .add(LEGACY_GOLD_BLOCK.asItem())
            .add(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK.asItem())
            .addTag(BlockusItemTags.LANTERN_BLOCKS);

        this.valueLookupBuilder(ItemTags.SULFUR_CUBE_ARCHETYPE_STICKY).add(HONEYCOMB_BRICKS.block().asItem());
    }

}
