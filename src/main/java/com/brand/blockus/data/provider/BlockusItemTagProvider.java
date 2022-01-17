package com.brand.blockus.data.provider;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.tag.BlockusBlockTags;
import com.brand.blockus.tag.BlockusItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BlockusItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public BlockusItemTagProvider(FabricDataGenerator dataGenerator, FabricTagProvider.BlockTagProvider blockTags) {
        super(dataGenerator, blockTags);
    }

    private FabricTagBuilder<Item> getOrCreateTagBuilder(Identifier id) {
        Tag.Identified<Item> tag = TagFactory.ITEM.create(id);
        return this.getOrCreateTagBuilder(tag);
    }

    private void copy(Identifier id) {
        Tag.Identified<Block> blockTag = TagFactory.BLOCK.create(id);
        Tag.Identified<Item> itemTag = TagFactory.ITEM.create(id);

        this.copy(blockTag, itemTag);
    }

    @Override
    protected void generateTags() {
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

        this.copy(BlockusBlockTags.PATTERNED_WOOL, BlockusItemTags.PATTERNED_WOOL);

        this.copy(BlockusBlockTags.SMALL_HEDGES, BlockusItemTags.SMALL_HEDGES);

        this.copy(BlockusBlockTags.SOUL_SOILS, BlockusItemTags.SOUL_SOILS);

        this.getOrCreateTagBuilder(BlockusItemTags.STAINED_STONE_BRICKS)
            .add(BlockusItems.WHITE_STONE_BRICKS)
            .add(BlockusItems.ORANGE_STONE_BRICKS)
            .add(BlockusItems.MAGENTA_STONE_BRICKS)
            .add(BlockusItems.LIGHT_BLUE_STONE_BRICKS)
            .add(BlockusItems.YELLOW_STONE_BRICKS)
            .add(BlockusItems.LIME_STONE_BRICKS)
            .add(BlockusItems.PINK_STONE_BRICKS)
            .add(BlockusItems.GRAY_STONE_BRICKS)
            .add(Items.STONE_BRICKS)
            .add(BlockusItems.CYAN_STONE_BRICKS)
            .add(BlockusItems.PURPLE_STONE_BRICKS)
            .add(BlockusItems.BLUE_STONE_BRICKS)
            .add(BlockusItems.BROWN_STONE_BRICKS)
            .add(BlockusItems.GREEN_STONE_BRICKS)
            .add(BlockusItems.RED_STONE_BRICKS)
            .add(BlockusItems.BLACK_STONE_BRICKS);

        this.copy(BlockusBlockTags.WARPED_NETHER_GRASS, BlockusItemTags.WARPED_NETHER_GRASS);

        this.copy(BlockusBlockTags.WHITE_OAK_LOGS, BlockusItemTags.WHITE_OAK_LOGS);

        this.copy(new Identifier("c", "planks_that_burn"));

        this.getOrCreateTagBuilder(new Identifier("c", "purpur_blocks"))
            .add(BlockusItems.PURPUR_BRICKS)
            .add(BlockusItems.POLISHED_PURPUR)
            .add(BlockusItems.PURPUR_SQUARES)
            .add(BlockusItems.SMALL_PURPUR_BRICKS)
            .add(BlockusItems.CHISELED_PURPUR)
            .add(BlockusItems.PURPUR_LINES)
            .add(BlockusItems.PHANTOM_PURPUR_BLOCK)
            .add(BlockusItems.PHANTOM_PURPUR_PILLAR)
            .add(BlockusItems.PHANTOM_PURPUR_BRICKS)
            .add(BlockusItems.POLISHED_PHANTOM_PURPUR)
            .add(BlockusItems.PHANTOM_PURPUR_SQUARES)
            .add(BlockusItems.SMALL_PHANTOM_PURPUR_BRICKS)
            .add(BlockusItems.CHISELED_PHANTOM_PURPUR)
            .add(BlockusItems.PHANTOM_PURPUR_LINES);

        this.getOrCreateTagBuilder(new Identifier("c", "quartz_blocks"))
            .add(BlockusItems.QUARTZ_TILES)
            .add(BlockusItems.QUARTZ_CIRCLE_PAVEMENT);

        this.getOrCreateTagBuilder(new Identifier("c", "red_sandstones"))
            .add(BlockusItems.RED_SANDSTONE_BRICKS)
            .add(BlockusItems.SMALL_RED_SANDSTONE_BRICKS)
            .add(BlockusItems.ROUGH_RED_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_RED_SANDSTONE)
            .add(BlockusItems.RED_SANDSTONE_PILLAR);

        this.copy(new Identifier("c", "wooden_barrels"));

        this.getOrCreateTagBuilder(new Identifier("c", "yellow_sandstones"))
            .add(BlockusItems.SANDSTONE_BRICKS)
            .add(BlockusItems.SMALL_SANDSTONE_BRICKS)
            .add(BlockusItems.ROUGH_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_SANDSTONE)
            .add(BlockusItems.LAPIS_DECORATED_SANDSTONE)
            .add(BlockusItems.SANDSTONE_PILLAR);

        this.copy(new Identifier("columns", "columns"));

        this.copy(BlockTags.ACACIA_LOGS, ItemTags.ACACIA_LOGS);

        this.copy(BlockTags.BIRCH_LOGS, ItemTags.BIRCH_LOGS);

        this.getOrCreateTagBuilder(ItemTags.BUTTONS)
            .add(BlockusItems.POLISHED_ANDESITE_BUTTON)
            .add(BlockusItems.POLISHED_DIORITE_BUTTON)
            .add(BlockusItems.POLISHED_GRANITE_BUTTON)
            .add(BlockusItems.LIMESTONE_BUTTON)
            .add(BlockusItems.MARBLE_BUTTON)
            .add(BlockusItems.BLUESTONE_BUTTON)
            .add(BlockusItems.POLISHED_NETHERRACK_BUTTON)
            .add(BlockusItems.POLISHED_END_STONE_BUTTON);

        this.copy(BlockTags.CRIMSON_STEMS, ItemTags.CRIMSON_STEMS);

        this.copy(BlockTags.DARK_OAK_LOGS, ItemTags.DARK_OAK_LOGS);

        this.getOrCreateTagBuilder(ItemTags.DOORS)
            .add(BlockusItems.PAPER_DOOR)
            .add(BlockusItems.OBSIDIAN_REINFORCED_DOOR)
            .add(BlockusItems.STONE_DOOR)
            .add(BlockusItems.BLACKSTONE_DOOR);

        this.copy(BlockTags.FLOWERS, ItemTags.FLOWERS);

        this.getOrCreateTagBuilder(new Identifier("minecraft", "ice"))
            .add(Items.ICE)
            .add(Items.PACKED_ICE)
            .add(Items.BLUE_ICE);

        this.copy(BlockTags.JUNGLE_LOGS, ItemTags.JUNGLE_LOGS);

        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);

        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

        this.copy(BlockTags.NON_FLAMMABLE_WOOD, ItemTags.NON_FLAMMABLE_WOOD);

        this.copy(BlockTags.OAK_LOGS, ItemTags.OAK_LOGS);

        this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
            .add(BlockusItems.LEGACY_GOLD_BLOCK)
            .add(BlockusItems.EXPLOSION_PROOF_LEGACY_GOLD_BLOCK)
            .add(BlockusItems.GOLDEN_CHAIN)
            .add(BlockusItems.GOLDEN_BARS)
            .add(BlockusItems.GOLDEN_GATE)
            .add(BlockusItems.GOLD_DECORATED_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_RED_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_SOUL_SANDSTONE)
            .add(BlockusItems.GOLD_DECORATED_POLISHED_BLACKSTONE)
            .add(BlockusItems.GOLD_PLATING)
            .add(BlockusItems.GOLD_PLATING_STAIRS)
            .add(BlockusItems.GOLD_PLATING_SLAB)
            .add(BlockusItems.GOLDEN_APPLE_CRATE)
            .add(BlockusItems.GOLDEN_CARROT_CRATE);

        this.copy(BlockTags.PIGLIN_REPELLENTS, ItemTags.PIGLIN_REPELLENTS);

        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);

        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

        this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

        this.copy(BlockTags.SPRUCE_LOGS, ItemTags.SPRUCE_LOGS);

        this.getOrCreateTagBuilder(ItemTags.TRAPDOORS)
            .add(BlockusItems.PAPER_TRAPDOOR)
            .add(BlockusItems.OBSIDIAN_REINFORCED_TRAPDOOR)
            .add(BlockusItems.STONE_TRAPDOOR)
            .add(BlockusItems.BLACKSTONE_TRAPDOOR);

        this.copy(BlockTags.WALLS, ItemTags.WALLS);

        this.copy(BlockTags.WARPED_STEMS, ItemTags.WARPED_STEMS);

        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
            .add(BlockusItems.BAMBOO_DOOR)
            .add(BlockusItems.CHARRED_DOOR)
            .add(BlockusItems.WHITE_OAK_DOOR);

        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
            .add(BlockusItems.BAMBOO_TRAPDOOR)
            .add(BlockusItems.CHARRED_TRAPDOOR)
            .add(BlockusItems.WHITE_OAK_TRAPDOOR);

        this.copy(BlockTags.WOOL, ItemTags.WOOL);

        this.copy(new Identifier("promenade", "cherry_oak_logs"));

        this.copy(new Identifier("promenade", "dark_amaranth_stems"));

        this.copy(new Identifier("promenade", "palm_logs"));
    }
}
