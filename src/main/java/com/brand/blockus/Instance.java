package com.brand.blockus;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

import java.util.HashMap;
import java.util.Random;

public class Instance {

    public static void init() {


// Flammable

        // general		
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WOODEN_FRAME, 30, 60);

        // small hedges
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.OAK_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.ACACIA_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BIRCH_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.DARK_OAK_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.JUNGLE_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.SPRUCE_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.AZALEA_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE, 30, 60);

        // paper
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.PAPER_WALL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.PAPER_DOOR, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.PAPER_BLOCK, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BURNED_PAPER_BLOCK, 5, 60);

        // thatch
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.THATCH, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.THATCH_SLAB, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.THATCH_STAIRS, 60, 20);

        // timber frames
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.ACACIA_CROSS_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.ACACIA_DIAGONAL_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.ACACIA_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BAMBOO_CROSS_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BAMBOO_DIAGONAL_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BAMBOO_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BIRCH_CROSS_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BIRCH_DIAGONAL_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BIRCH_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.DARK_OAK_CROSS_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.DARK_OAK_DIAGONAL_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.DARK_OAK_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.JUNGLE_CROSS_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.JUNGLE_DIAGONAL_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.JUNGLE_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.OAK_CROSS_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.OAK_DIAGONAL_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.OAK_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.SPRUCE_CROSS_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.SPRUCE_DIAGONAL_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.SPRUCE_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_CROSS_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_DIAGONAL_TIMBER_FRAME, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_TIMBER_FRAME, 5, 20);


        // patterned wools
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.ORANGE_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.MAGENTA_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.LIGHT_BLUE_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.YELLOW_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.LIME_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.PINK_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.GRAY_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.LIGHT_GRAY_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.CYAN_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.PURPLE_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BLUE_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BROWN_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.GREEN_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.RED_PATTERNED_WOOL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BLACK_PATTERNED_WOOL, 30, 60);

        // bamboo
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BAMBOO_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BAMBOO_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BAMBOO_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BAMBOO_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BAMBOO_FENCE_GATE, 5, 20);

        // white oak
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.STRIPPED_WHITE_OAK_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.STRIPPED_WHITE_OAK_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_LEAVES, 30, 60);

        // small logs		
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.OAK_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.BIRCH_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.SPRUCE_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.JUNGLE_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.ACACIA_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.DARK_OAK_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusBlocks.WHITE_OAK_SMALL_LOGS, 5, 5);


// Fuel
        // general
        FuelRegistry.INSTANCE.add(Items.DRIED_KELP, 200);
        FuelRegistry.INSTANCE.add(BlockusItems.LEGACY_COAL_BLOCK, 16000);
        FuelRegistry.INSTANCE.add(BlockusItems.CHARCOAL_BLOCK, 16000);
        FuelRegistry.INSTANCE.add(BlockusItems.WOODEN_FRAME, 300);

        // paper
        FuelRegistry.INSTANCE.add(Items.PAPER, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.PAPER_TRAPDOOR, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.PAPER_DOOR, 67);
        FuelRegistry.INSTANCE.add(BlockusItems.PAPER_WALL, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.PAPER_LAMP, 400);
        FuelRegistry.INSTANCE.add(BlockusItems.PAPER_BLOCK, 500);

        // timber frames
        FuelRegistry.INSTANCE.add(BlockusItems.ACACIA_CROSS_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.ACACIA_DIAGONAL_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.ACACIA_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_CROSS_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_DIAGONAL_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BIRCH_CROSS_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BIRCH_DIAGONAL_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BIRCH_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.DARK_OAK_CROSS_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.DARK_OAK_DIAGONAL_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.DARK_OAK_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.JUNGLE_CROSS_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.JUNGLE_DIAGONAL_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.JUNGLE_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.OAK_CROSS_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.OAK_DIAGONAL_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.OAK_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.SPRUCE_CROSS_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.SPRUCE_DIAGONAL_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.SPRUCE_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_CROSS_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_DIAGONAL_TIMBER_FRAME, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_TIMBER_FRAME, 300);


        // patterned wools
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.ORANGE_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.MAGENTA_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.LIGHT_BLUE_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.YELLOW_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.LIME_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.PINK_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.GRAY_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.LIGHT_GRAY_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.CYAN_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.PURPLE_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.BLUE_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.BROWN_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.GREEN_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.RED_PATTERNED_WOOL, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.BLACK_PATTERNED_WOOL, 100);

        // bamboo
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_PLANKS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_SLAB, 150);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_STAIRS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_FENCE, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_FENCE_GATE, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_DOOR, 200);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_TRAPDOOR, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_PRESSURE_PLATE, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_BUTTON, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_BOAT, 1200);
        FuelRegistry.INSTANCE.add(BlockusItems.BAMBOO_SIGN, 200);

        // white oak
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_LOG, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.STRIPPED_WHITE_OAK_LOG, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_WOOD, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.STRIPPED_WHITE_OAK_LOG, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_PLANKS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_SLAB, 150);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_STAIRS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_FENCE, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_FENCE_GATE, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_DOOR, 200);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_TRAPDOOR, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_PRESSURE_PLATE, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_BUTTON, 100);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_BOAT, 1200);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_SIGN, 200);

        // small logs
        FuelRegistry.INSTANCE.add(BlockusItems.OAK_SMALL_LOGS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.BIRCH_SMALL_LOGS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.SPRUCE_SMALL_LOGS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.JUNGLE_SMALL_LOGS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.ACACIA_SMALL_LOGS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.DARK_OAK_SMALL_LOGS, 300);
        FuelRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_SMALL_LOGS, 300);

        // barrels
        FuelRegistry.INSTANCE.add(BlockusBlocks.OAK_BARREL, 300);
        FuelRegistry.INSTANCE.add(BlockusBlocks.BIRCH_BARREL, 300);
        FuelRegistry.INSTANCE.add(BlockusBlocks.JUNGLE_BARREL, 300);
        FuelRegistry.INSTANCE.add(BlockusBlocks.ACACIA_BARREL, 300);
        FuelRegistry.INSTANCE.add(BlockusBlocks.DARK_OAK_BARREL, 300);
        FuelRegistry.INSTANCE.add(BlockusBlocks.WHITE_OAK_BARREL, 300);
        FuelRegistry.INSTANCE.add(BlockusBlocks.BAMBOO_BARREL, 300);

// Composting
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.OAK_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.ACACIA_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.BIRCH_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.DARK_OAK_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.JUNGLE_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.SPRUCE_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.AZALEA_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_LEAVES, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.WHITE_OAK_SAPLING, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.RAINBOW_PETAL, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(Items.BAMBOO, 0.50f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.SWEET_BERRIES_CRATE, 0.50f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.FLOWERING_AZALEA_SMALL_HEDGE, 0.50f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.MOSS_SMALL_HEDGE, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.RAINBOW_ROSE, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.THATCH_SLAB, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.THATCH, 0.75f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.THATCH_STAIRS, 0.75f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.WARPED_SMALL_HEDGE, 0.85f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.CRIMSON_SMALL_HEDGE, 0.85f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.APPLE_CRATE, 0.95f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.BEETROOT_CRATE, 0.95f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.CARROT_CRATE, 0.95f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.POTATO_CRATE, 0.95f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.BREAD_BOX, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(BlockusItems.COOKIE_BLOCK, 1.0f);


// Instance

        addTradeOffers();
        addStrippables();
        addPathBlocks();
    }

    public static void addTradeOffers() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add(new SellSaplingFactory(BlockusItems.WHITE_OAK_SAPLING));
        });
    }

    public static void addStrippables() {
        AxeItem.STRIPPED_BLOCKS = new HashMap<>(AxeItem.STRIPPED_BLOCKS);
        AxeItem.STRIPPED_BLOCKS.put(BlockusBlocks.WHITE_OAK_LOG, BlockusBlocks.STRIPPED_WHITE_OAK_LOG);
        AxeItem.STRIPPED_BLOCKS.put(BlockusBlocks.WHITE_OAK_WOOD, BlockusBlocks.STRIPPED_WHITE_OAK_WOOD);
    }

    public static void addPathBlocks() {
        ShovelItem.PATH_STATES = new HashMap<>(ShovelItem.PATH_STATES);
        ShovelItem.PATH_STATES.put(Blocks.DIRT_PATH, BlockusBlocks.PATH.getDefaultState());
        ShovelItem.PATH_STATES.put(BlockusBlocks.PATH, Blocks.DIRT.getDefaultState());

    }

    private static class SellSaplingFactory implements TradeOffers.Factory {
        private final ItemStack sapling;

        public SellSaplingFactory(ItemConvertible sapling) {
            this.sapling = new ItemStack(sapling);
        }

        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new ItemStack(Items.EMERALD, 5), this.sapling, 8, 1, 0.05f);
        }
    }
}
