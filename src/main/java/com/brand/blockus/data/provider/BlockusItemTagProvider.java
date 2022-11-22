package com.brand.blockus.data.provider;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.tag.BlockusBlockTags;
import com.brand.blockus.tag.BlockusItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class BlockusItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public BlockusItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, BlockTagProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    private FabricTagBuilder getOrCreateTagBuilder(Identifier id) {
        TagKey<Item> tag = TagKey.of(RegistryKeys.ITEM, id);
        return this.getOrCreateTagBuilder(tag);
    }

    private void copy(Identifier id) {
        TagKey<Block> blockTag = TagKey.of(RegistryKeys.BLOCK, id);
        TagKey<Item> itemTag = TagKey.of(RegistryKeys.ITEM, id);

        this.copy(blockTag, itemTag);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        this.copy(BlockusBlockTags.BARRELS, BlockusItemTags.BARRELS);

        this.copy(BlockusBlockTags.BARRIERS, BlockusItemTags.BARRIERS);

        this.getOrCreateTagBuilder(BlockusItemTags.BLOCKUS_BARRELS)
            .add(BlockusBlocks.OAK_BARREL.asItem())
            .add(BlockusBlocks.BIRCH_BARREL.asItem())
            .add(BlockusBlocks.JUNGLE_BARREL.asItem())
            .add(BlockusBlocks.ACACIA_BARREL.asItem())
            .add(BlockusBlocks.DARK_OAK_BARREL.asItem())
            .add(BlockusBlocks.CRIMSON_BARREL.asItem())
            .add(BlockusBlocks.WARPED_BARREL.asItem())
            .add(BlockusBlocks.BAMBOO_BARREL.asItem())
            .add(BlockusBlocks.CHARRED_BARREL.asItem())
            .add(BlockusBlocks.WHITE_OAK_BARREL.asItem());

//        this.getOrCreateTagBuilder(ItemTags.BOATS)
//            .add(BlockusBlocks.BAMBOO.boat)
//            .add(BlockusBlocks.CHARRED.boat)
//            .add(BlockusBlocks.WHITE_OAK.boat);
//
//        this.getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
//            .add(BlockusBlocks.BAMBOO.chest_boat)
//            .add(BlockusBlocks.CHARRED.chest_boat)
//            .add(BlockusBlocks.WHITE_OAK.chest_boat);
//
//        this.getOrCreateTagBuilder(ItemTags.SIGNS)
//            .add(BlockusBlocks.BAMBOO.sign)
//            .add(BlockusBlocks.CHARRED.sign)
//            .add(BlockusBlocks.WHITE_OAK.sign);

        this.copy(BlockusBlockTags.PATTERNED_WOOL, BlockusItemTags.PATTERNED_WOOL);

        this.copy(BlockusBlockTags.SMALL_HEDGES, BlockusItemTags.SMALL_HEDGES);

        this.copy(BlockusBlockTags.SOUL_SOILS, BlockusItemTags.SOUL_SOILS);

        this.getOrCreateTagBuilder(BlockusItemTags.STAINED_STONE_BRICKS)
            .add(BlockusBlocks.WHITE_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.ORANGE_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.MAGENTA_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.YELLOW_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.LIME_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.PINK_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.GRAY_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.GRAY_STONE_BRICKS.block.asItem())
            .add(Items.STONE_BRICKS)
            .add(BlockusBlocks.CYAN_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.PURPLE_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.BLUE_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.BROWN_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.GREEN_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.RED_STONE_BRICKS.block.asItem())
            .add(BlockusBlocks.BLACK_STONE_BRICKS.block.asItem());

        this.copy(BlockusBlockTags.WARPED_NETHER_GRASS, BlockusItemTags.WARPED_NETHER_GRASS);

        this.copy(BlockusBlockTags.WHITE_OAK_LOGS, BlockusItemTags.WHITE_OAK_LOGS);

        this.getOrCreateTagBuilder(BlockusItemTags.PLANKS_THAT_BURN)
            .add(Items.OAK_PLANKS)
            .add(Items.SPRUCE_PLANKS)
            .add(Items.BIRCH_PLANKS)
            .add(Items.JUNGLE_PLANKS)
            .add(Items.ACACIA_PLANKS)
            .add(Items.DARK_OAK_PLANKS)
            .add(BlockusBlocks.BAMBOO.planks.asItem())
            .add(BlockusBlocks.WHITE_OAK.planks.asItem())
            .add(BlockusBlocks.LEGACY_PLANKS.asItem());

        this.getOrCreateTagBuilder(BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN)
            .add(BlockusBlocks.HERRINGBONE_OAK_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_BIRCH_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_SPRUCE_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_JUNGLE_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_ACACIA_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_DARK_OAK_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_MANGROVE_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_WHITE_OAK_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_BAMBOO_PLANKS.asItem());

        this.copy(new Identifier("c", "planks_that_burn"));

        this.copy(new Identifier("c", "wooden_barrels"));

        this.copy(new Identifier("columns", "columns"));

        this.copy(BlockTags.ACACIA_LOGS, ItemTags.ACACIA_LOGS);

        this.copy(BlockTags.BIRCH_LOGS, ItemTags.BIRCH_LOGS);

        this.getOrCreateTagBuilder(ItemTags.BUTTONS)
            .add(BlockusBlocks.POLISHED_ANDESITE_BUTTON.asItem())
            .add(BlockusBlocks.POLISHED_DIORITE_BUTTON.asItem())
            .add(BlockusBlocks.POLISHED_GRANITE_BUTTON.asItem())
            .add(BlockusBlocks.LIMESTONE_BUTTON.asItem())
            .add(BlockusBlocks.MARBLE_BUTTON.asItem())
            .add(BlockusBlocks.BLUESTONE_BUTTON.asItem())
            .add(BlockusBlocks.POLISHED_NETHERRACK_BUTTON.asItem())
            .add(BlockusBlocks.POLISHED_END_STONE_BUTTON.asItem())
            .add(BlockusBlocks.VIRIDITE_BUTTON.asItem());

        this.copy(BlockTags.CRIMSON_STEMS, ItemTags.CRIMSON_STEMS);

        this.copy(BlockTags.DARK_OAK_LOGS, ItemTags.DARK_OAK_LOGS);

        this.getOrCreateTagBuilder(ItemTags.DOORS)
            .add(BlockusBlocks.PAPER_DOOR.asItem())
            .add(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR.asItem())
            .add(BlockusBlocks.STONE_DOOR.asItem())
            .add(BlockusBlocks.BLACKSTONE_DOOR.asItem());

        this.copy(BlockTags.FLOWERS, ItemTags.FLOWERS);

        this.getOrCreateTagBuilder(BlockusItemTags.NATURAL_ICE)
            .add(Items.ICE)
            .add(Items.PACKED_ICE)
            .add(Items.BLUE_ICE);

        this.copy(BlockTags.JUNGLE_LOGS, ItemTags.JUNGLE_LOGS);

        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);

        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

        this.copy(BlockTags.MANGROVE_LOGS, ItemTags.MANGROVE_LOGS);

        this.getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
            .add(BlockusBlocks.CHARRED.planks.asItem())
            .add(BlockusBlocks.CHARRED.slab.asItem())
            .add(BlockusBlocks.CHARRED.pressure_plate.asItem())
            .add(BlockusBlocks.CHARRED.fence.asItem())
            .add(BlockusBlocks.CHARRED.trapdoor.asItem())
            .add(BlockusBlocks.CHARRED.fence_gate.asItem())
            .add(BlockusBlocks.CHARRED.stairs.asItem())
            .add(BlockusBlocks.CHARRED.button.asItem())
            .add(BlockusBlocks.CHARRED.door.asItem())
            .add(BlockusBlocks.WARPED_SMALL_STEMS.asItem())
            .add(BlockusBlocks.CRIMSON_SMALL_STEMS.asItem())
            .add(BlockusBlocks.HERRINGBONE_CRIMSON_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_WARPED_PLANKS.asItem())
            .add(BlockusBlocks.HERRINGBONE_CHARRED_PLANKS.asItem());
//            .add(BlockusBlocks.CHARRED.boat)
//            .add(BlockusBlocks.CHARRED.chest_boat)
//            .add(BlockusBlocks.CHARRED.sign);

        this.copy(BlockTags.OAK_LOGS, ItemTags.OAK_LOGS);

        this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
            .add(BlockusBlocks.LEGACY_GOLD_BLOCK.asItem())
            .add(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK.asItem())
            .add(BlockusBlocks.GOLDEN_CHAIN.asItem())
            .add(BlockusBlocks.GOLDEN_BARS.asItem())
            .add(BlockusBlocks.GOLDEN_GATE.asItem())
            .add(BlockusBlocks.GOLD_DECORATED_SANDSTONE.asItem())
            .add(BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE.asItem())
            .add(BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE.asItem())
            .add(BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE.asItem())
            .add(BlockusBlocks.GOLD_PLATING.block.asItem())
            .add(BlockusBlocks.GOLD_PLATING.stairs.asItem())
            .add(BlockusBlocks.GOLD_PLATING.slab.asItem())
            .add(BlockusBlocks.GOLDEN_APPLE_CRATE.asItem())
            .add(BlockusBlocks.GOLDEN_CARROT_CRATE.asItem());

        this.copy(BlockTags.PIGLIN_REPELLENTS, ItemTags.PIGLIN_REPELLENTS);

        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);

        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

        this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

        this.copy(BlockTags.SPRUCE_LOGS, ItemTags.SPRUCE_LOGS);

        this.getOrCreateTagBuilder(ItemTags.TRAPDOORS)
            .add(BlockusBlocks.PAPER_TRAPDOOR.asItem())
            .add(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR.asItem())
            .add(BlockusBlocks.STONE_TRAPDOOR.asItem())
            .add(BlockusBlocks.BLACKSTONE_TRAPDOOR.asItem());

        this.copy(BlockTags.WALLS, ItemTags.WALLS);

        this.copy(BlockTags.WARPED_STEMS, ItemTags.WARPED_STEMS);

        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
            .add(BlockusBlocks.BAMBOO.door.asItem())
            .add(BlockusBlocks.CHARRED.door.asItem())
            .add(BlockusBlocks.WHITE_OAK.door.asItem());

        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
            .add(BlockusBlocks.BAMBOO.trapdoor.asItem())
            .add(BlockusBlocks.CHARRED.trapdoor.asItem())
            .add(BlockusBlocks.WHITE_OAK.trapdoor.asItem());

        this.copy(BlockTags.WOOL, ItemTags.WOOL);
        this.copy(BlockTags.DIRT, ItemTags.DIRT);


        this.copy(new Identifier("promenade", "cherry_oak_logs"));

        this.copy(new Identifier("promenade", "dark_amaranth_stems"));

        this.copy(new Identifier("promenade", "palm_logs"));
    }
}
