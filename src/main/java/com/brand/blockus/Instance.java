package com.brand.blockus;

import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.BlockChecker;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class Instance {

    public static void init() {


// Burning
        // Fuel
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(Items.DRIED_KELP, 200);
            builder.add(LEGACY_COAL_BLOCK, 16000);
            builder.add(CHARCOAL_BLOCK, 16000);
            builder.add(WOODEN_FRAME, 300);
            builder.add(Items.PAPER, 100);
            builder.add(PAPER_DOOR, 100);
            builder.add(PAPER_TRAPDOOR, 150);
            builder.add(FRAMED_PAPER_BLOCK, 300);
            builder.add(PAPER_WALL, 150);
            builder.add(PAPER_LAMP, 300);
            builder.add(PAPER_BLOCK, 400);
        });

        // General
        FlammableBlockRegistry.getDefaultInstance().add(WOODEN_FRAME, 30, 60);

        // Small hedges
        FlammableBlockRegistry.getDefaultInstance().add(OAK_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ACACIA_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BIRCH_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(DARK_OAK_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(JUNGLE_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(SPRUCE_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(AZALEA_SMALL_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(FLOWERING_AZALEA_SMALL_HEDGE, 30, 60);

        // Paper
        FlammableBlockRegistry.getDefaultInstance().add(FRAMED_PAPER_BLOCK, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(PAPER_WALL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(PAPER_BLOCK, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BURNT_PAPER_BLOCK, 5, 60);

        // Thatch
        FlammableBlockRegistry.getDefaultInstance().add(THATCH.block, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(THATCH.slab, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(THATCH.stairs, 60, 20);

        // Timber frames
        for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
            for (Block block : timberFrameBundle.all) {
                if (timberFrameBundle.isBurnable()) {
                    FlammableBlockRegistry.getDefaultInstance().add(block, 5, 20);
                    FuelRegistryEvents.BUILD.register((builder, context) -> builder.add(block, 300));
                }
            }
        }

        // Patterned wools
        for (WoolBundle woolBundle : WoolBundle.values()) {
            FlammableBlockRegistry.getDefaultInstance().add(woolBundle.block, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(woolBundle.stairs, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(woolBundle.slab, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(woolBundle.carpet, 60, 20);
            FuelRegistryEvents.BUILD.register((builder, context) -> {
                builder.add(woolBundle.stairs, 100);
                builder.add(woolBundle.slab, 50);
            });
        }

        // Wood set
        for (WoodBundle woodBundle : WoodBundle.values()) {
            if (woodBundle.isBurnable()) {
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.planks, 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.stairs, 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.slab, 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.fence, 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.fence_gate, 5, 20);
                FuelRegistryEvents.BUILD.register((builder, context) -> {
                    builder.add(woodBundle.fence, 300);
                    builder.add(woodBundle.fence_gate, 300);
                });
            }
        }

        // White oak
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_WHITE_OAK_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_WHITE_OAK_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_LEAVES, 30, 60);

        // Wooden mosaic
        for (BSSWBundle block : BSSWBundle.values()) {
            if (BlockChecker.isWoodenMosaic(block.type, BlockChecker.FLAMMABLE_WOODS) || BlockChecker.isMossyPlanks(block.type, BlockChecker.FLAMMABLE_WOODS)) {
                FlammableBlockRegistry.getDefaultInstance().add(block.block, 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(block.stairs, 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(block.slab, 5, 20);
                FuelRegistryEvents.BUILD.register((builder, context) -> {
                    builder.add(block.block, 300);
                    builder.add(block.stairs, 300);
                    builder.add(block.slab, 150);
                });
            }
        }

        // Herringbone planks
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_OAK_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_BIRCH_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_SPRUCE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_JUNGLE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_ACACIA_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_DARK_OAK_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_MANGROVE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_WHITE_OAK_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_BAMBOO_PLANKS, 5, 20);

        // Small logs
        FlammableBlockRegistry.getDefaultInstance().add(OAK_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BIRCH_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(SPRUCE_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(JUNGLE_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ACACIA_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(DARK_OAK_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_SMALL_LOGS, 5, 5);

        // Posts
        for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
            if (woodenPost.isBurnable()) {
                FlammableBlockRegistry.getDefaultInstance().add(woodenPost.block, 5, 5);
                FlammableBlockRegistry.getDefaultInstance().add(woodenPost.stripped, 5, 5);
            }
        }

        // Legacy blocks
        FlammableBlockRegistry.getDefaultInstance().add(LEGACY_LOG, 5, 5);

// Composting
        CompostingChanceRegistry.INSTANCE.add(OAK_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(ACACIA_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BIRCH_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(DARK_OAK_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(JUNGLE_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(SPRUCE_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(MANGROVE_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(AZALEA_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(WHITE_OAK_SMALL_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(WHITE_OAK_LEAVES, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(WHITE_OAK_SAPLING, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(LEGACY_SAPLING, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(RAINBOW_PETALS, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(Items.BAMBOO, 0.50f);
        CompostingChanceRegistry.INSTANCE.add(SWEET_BERRIES_CRATE, 0.50f);
        CompostingChanceRegistry.INSTANCE.add(FLOWERING_AZALEA_SMALL_HEDGE, 0.50f);
        CompostingChanceRegistry.INSTANCE.add(MOSS_SMALL_HEDGE, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(RAINBOW_ROSE, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(THATCH.slab, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(THATCH.block, 0.75f);
        CompostingChanceRegistry.INSTANCE.add(THATCH.stairs, 0.75f);
        CompostingChanceRegistry.INSTANCE.add(WARPED_SMALL_HEDGE, 0.85f);
        CompostingChanceRegistry.INSTANCE.add(CRIMSON_SMALL_HEDGE, 0.85f);
        CompostingChanceRegistry.INSTANCE.add(APPLE_CRATE, 0.95f);
        CompostingChanceRegistry.INSTANCE.add(BEETROOT_CRATE, 0.95f);
        CompostingChanceRegistry.INSTANCE.add(CARROT_CRATE, 0.95f);
        CompostingChanceRegistry.INSTANCE.add(POTATO_CRATE, 0.95f);
        CompostingChanceRegistry.INSTANCE.add(BREAD_BOX, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(COOKIE_BLOCK, 1.0f);

// Other

        addStrippables();
        addOxidizable();
        addPathBlocks();
        addTradeOffers();
    }

    public static void addStrippables() {
        StrippableBlockRegistry.register(WHITE_OAK_LOG, STRIPPED_WHITE_OAK_LOG);
        StrippableBlockRegistry.register(WHITE_OAK_WOOD, STRIPPED_WHITE_OAK_WOOD);
        for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
            StrippableBlockRegistry.register(woodenPost.block, woodenPost.stripped);
        }
    }

    public static void addOxidizable() {
        registerOxidizable(COPPER_BRICKS.block, EXPOSED_COPPER_BRICKS.block, WEATHERED_COPPER_BRICKS.block, OXIDIZED_COPPER_BRICKS.block,
                COPPER_BRICKS.blockWaxed, EXPOSED_COPPER_BRICKS.blockWaxed, WEATHERED_COPPER_BRICKS.blockWaxed, OXIDIZED_COPPER_BRICKS.blockWaxed);
        registerOxidizable(COPPER_BRICKS.stairs, EXPOSED_COPPER_BRICKS.stairs, WEATHERED_COPPER_BRICKS.stairs, OXIDIZED_COPPER_BRICKS.stairs,
                COPPER_BRICKS.stairsWaxed, EXPOSED_COPPER_BRICKS.stairsWaxed, WEATHERED_COPPER_BRICKS.stairsWaxed, OXIDIZED_COPPER_BRICKS.stairsWaxed);
        registerOxidizable(COPPER_BRICKS.slab, EXPOSED_COPPER_BRICKS.slab, WEATHERED_COPPER_BRICKS.slab, OXIDIZED_COPPER_BRICKS.slab,
                COPPER_BRICKS.slabWaxed, EXPOSED_COPPER_BRICKS.slabWaxed, WEATHERED_COPPER_BRICKS.slabWaxed, OXIDIZED_COPPER_BRICKS.slabWaxed);
        registerOxidizable(COPPER_BRICKS.wall, EXPOSED_COPPER_BRICKS.wall, WEATHERED_COPPER_BRICKS.wall, OXIDIZED_COPPER_BRICKS.wall,
                COPPER_BRICKS.wallWaxed, EXPOSED_COPPER_BRICKS.wallWaxed, WEATHERED_COPPER_BRICKS.wallWaxed, OXIDIZED_COPPER_BRICKS.wallWaxed);

        registerOxidizable(COPPER_TUFF_BRICKS.block, EXPOSED_COPPER_TUFF_BRICKS.block, WEATHERED_COPPER_TUFF_BRICKS.block, OXIDIZED_COPPER_TUFF_BRICKS.block,
                COPPER_TUFF_BRICKS.blockWaxed, EXPOSED_COPPER_TUFF_BRICKS.blockWaxed, WEATHERED_COPPER_TUFF_BRICKS.blockWaxed, OXIDIZED_COPPER_TUFF_BRICKS.blockWaxed);
        registerOxidizable(COPPER_TUFF_BRICKS.stairs, EXPOSED_COPPER_TUFF_BRICKS.stairs, WEATHERED_COPPER_TUFF_BRICKS.stairs, OXIDIZED_COPPER_TUFF_BRICKS.stairs,
                COPPER_TUFF_BRICKS.stairsWaxed, EXPOSED_COPPER_TUFF_BRICKS.stairsWaxed, WEATHERED_COPPER_TUFF_BRICKS.stairsWaxed, OXIDIZED_COPPER_TUFF_BRICKS.stairsWaxed);
        registerOxidizable(COPPER_TUFF_BRICKS.slab, EXPOSED_COPPER_TUFF_BRICKS.slab, WEATHERED_COPPER_TUFF_BRICKS.slab, OXIDIZED_COPPER_TUFF_BRICKS.slab,
                COPPER_TUFF_BRICKS.slabWaxed, EXPOSED_COPPER_TUFF_BRICKS.slabWaxed, WEATHERED_COPPER_TUFF_BRICKS.slabWaxed, OXIDIZED_COPPER_TUFF_BRICKS.slabWaxed);
        registerOxidizable(COPPER_TUFF_BRICKS.wall, EXPOSED_COPPER_TUFF_BRICKS.wall, WEATHERED_COPPER_TUFF_BRICKS.wall, OXIDIZED_COPPER_TUFF_BRICKS.wall,
                COPPER_TUFF_BRICKS.wallWaxed, EXPOSED_COPPER_TUFF_BRICKS.wallWaxed, WEATHERED_COPPER_TUFF_BRICKS.wallWaxed, OXIDIZED_COPPER_TUFF_BRICKS.wallWaxed);
    }

    public static void registerOxidizable(Block block, Block exposed, Block weathered, Block oxidized, Block waxed, Block exposedwaxed, Block weatheredwaxed, Block oxidizedwaxed) {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(block, exposed);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(exposed, weathered);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(weathered, oxidized);
        OxidizableBlocksRegistry.registerWaxableBlockPair(block, waxed);
        OxidizableBlocksRegistry.registerWaxableBlockPair(exposed, exposedwaxed);
        OxidizableBlocksRegistry.registerWaxableBlockPair(weathered, weatheredwaxed);
        OxidizableBlocksRegistry.registerWaxableBlockPair(oxidized, oxidizedwaxed);
    }

    public static void addPathBlocks() {
        FlattenableBlockRegistry.register(Blocks.DIRT_PATH, PATH.getDefaultState());
        FlattenableBlockRegistry.register(PATH, Blocks.DIRT.getDefaultState());
    }

    public static void addTradeOffers() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add(new SellItemFactory(LEGACY_SAPLING, 5, 1, 8));
            factories.add(new SellItemFactory(WHITE_OAK_SAPLING, 5, 1, 8));
            factories.add(new SellItemFactory(RAINBOW_PETALS, 1, 3, 12));
            factories.add(new SellItemFactory(RAINBOW_ROSE, 1, 1, 12));
        });
    }


    static class SellItemFactory implements TradeOffers.Factory {
        private final ItemStack sell;
        private final int price;
        private final int count;
        private final int maxUses;

        public SellItemFactory(ItemConvertible stack, int price, int count, int maxUses) {
            this.sell = new ItemStack(stack);
            this.price = price;
            this.count = count;
            this.maxUses = maxUses;
        }

        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new TradedItem(Items.EMERALD, this.price), new ItemStack(this.sell.getItem(), this.count), this.maxUses, 1, 0.05f);
        }
    }
}
