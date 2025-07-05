package com.brand.blockus;

import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.BlockChecker;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;

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
        FlammableBlockRegistry.getDefaultInstance().add(OAK_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ACACIA_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BIRCH_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(DARK_OAK_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(JUNGLE_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(SPRUCE_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(AZALEA_HEDGE, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(FLOWERING_AZALEA_HEDGE, 30, 60);

        // Paper
        FlammableBlockRegistry.getDefaultInstance().add(FRAMED_PAPER_BLOCK, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(PAPER_WALL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(PAPER_BLOCK, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BURNT_PAPER_BLOCK, 5, 60);

        // Thatch
        FlammableBlockRegistry.getDefaultInstance().add(THATCH.block(), 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(THATCH.slab(), 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(THATCH.stairs(), 60, 20);

        // Timber frames
        for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
            for (Block block : timberFrameBundle.all()) {
                if (timberFrameBundle.burnable()) {
                    FlammableBlockRegistry.getDefaultInstance().add(block, 5, 20);
                    FuelRegistryEvents.BUILD.register((builder, context) -> builder.add(block, 300));
                }
            }
        }

        // Patterned wools
        for (WoolBundle woolBundle : WoolBundle.values()) {
            FlammableBlockRegistry.getDefaultInstance().add(woolBundle.block(), 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(woolBundle.stairs(), 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(woolBundle.slab(), 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(woolBundle.carpet(), 60, 20);
            FuelRegistryEvents.BUILD.register((builder, context) -> {
                builder.add(woolBundle.stairs(), 100);
                builder.add(woolBundle.slab(), 50);
            });
        }

        // Wood set
        for (WoodBundle woodBundle : WoodBundle.values()) {
            if (woodBundle.burnable()) {
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.planks(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.stairs(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.slab(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.fence(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.fenceGate(), 5, 20);
                FuelRegistryEvents.BUILD.register((builder, context) -> {
                    builder.add(woodBundle.fence(), 300);
                    builder.add(woodBundle.fenceGate(), 300);
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
            if (BlockChecker.isWoodenMosaic(block.type(), BlockChecker.FLAMMABLE_WOODS) || BlockChecker.isMossyPlanks(block.type(), BlockChecker.FLAMMABLE_WOODS)) {
                FlammableBlockRegistry.getDefaultInstance().add(block.block(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(block.stairs(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(block.slab(), 5, 20);
                FuelRegistryEvents.BUILD.register((builder, context) -> {
                    builder.add(block.block(), 300);
                    builder.add(block.stairs(), 300);
                    builder.add(block.slab(), 150);
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
        FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_PALE_OAK_PLANKS, 5, 20);


        // Small logs
        FlammableBlockRegistry.getDefaultInstance().add(OAK_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BIRCH_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(SPRUCE_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(JUNGLE_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ACACIA_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(DARK_OAK_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_SMALL_LOGS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(PALE_OAK_SMALL_LOGS, 5, 5);

        // Posts
        for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
            if (woodenPost.burnable()) {
                FlammableBlockRegistry.getDefaultInstance().add(woodenPost.block(), 5, 5);
                FlammableBlockRegistry.getDefaultInstance().add(woodenPost.stripped(), 5, 5);
            }
        }

        // Legacy blocks
        FlammableBlockRegistry.getDefaultInstance().add(LEGACY_LOG, 5, 5);

// Composting
        CompostingChanceRegistry.INSTANCE.add(OAK_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(ACACIA_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(BIRCH_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(DARK_OAK_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(JUNGLE_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(SPRUCE_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(MANGROVE_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(CHERRY_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(PALE_OAK_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(AZALEA_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(WHITE_OAK_HEDGE, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(WHITE_OAK_LEAVES, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(WHITE_OAK_SAPLING, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(LEGACY_SAPLING, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(RAINBOW_PETALS, 0.30f);
        CompostingChanceRegistry.INSTANCE.add(Items.BAMBOO, 0.50f);
        CompostingChanceRegistry.INSTANCE.add(SWEET_BERRIES_CRATE, 0.50f);
        CompostingChanceRegistry.INSTANCE.add(FLOWERING_AZALEA_HEDGE, 0.50f);
        CompostingChanceRegistry.INSTANCE.add(MOSS_HEDGE, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(PALE_MOSS_HEDGE, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(RAINBOW_ROSE, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(THATCH.slab(), 0.65f);
        CompostingChanceRegistry.INSTANCE.add(THATCH.block(), 0.75f);
        CompostingChanceRegistry.INSTANCE.add(THATCH.stairs(), 0.75f);
        CompostingChanceRegistry.INSTANCE.add(WARPED_HEDGE, 0.85f);
        CompostingChanceRegistry.INSTANCE.add(CRIMSON_HEDGE, 0.85f);
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
            StrippableBlockRegistry.register(woodenPost.block(), woodenPost.stripped());
        }
    }

    public static void addOxidizable() {
        registerOxidizable(COPPER_BRICKS, EXPOSED_COPPER_BRICKS, WEATHERED_COPPER_BRICKS, OXIDIZED_COPPER_BRICKS);
        registerOxidizable(COPPER_TUFF_BRICKS, EXPOSED_COPPER_TUFF_BRICKS, WEATHERED_COPPER_TUFF_BRICKS, OXIDIZED_COPPER_TUFF_BRICKS);
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

    public static void registerOxidizable(CopperBundle block, CopperBundle exposed, CopperBundle weathered, CopperBundle oxidized) {
        registerOxidizable(block.block(), exposed.block(), weathered.block(), oxidized.block(), block.blockWaxed(), exposed.blockWaxed(), weathered.blockWaxed(), oxidized.blockWaxed());
        registerOxidizable(block.stairs(), exposed.stairs(), weathered.stairs(), oxidized.stairs(), block.stairsWaxed(), exposed.stairsWaxed(), weathered.stairsWaxed(), oxidized.stairsWaxed());
        registerOxidizable(block.slab(), exposed.slab(), weathered.slab(), oxidized.slab(), block.slabWaxed(), exposed.slabWaxed(), weathered.slabWaxed(), oxidized.slabWaxed());
        registerOxidizable(block.wall(), exposed.wall(), weathered.wall(), oxidized.wall(), block.wallWaxed(), exposed.wallWaxed(), weathered.wallWaxed(), oxidized.wallWaxed());
    }

    public static void addPathBlocks() {
        FlattenableBlockRegistry.register(Blocks.DIRT_PATH, PATH.getDefaultState());
        FlattenableBlockRegistry.register(PATH, Blocks.DIRT.getDefaultState());
    }

    public static void addTradeOffers() {
        TradeOfferHelper.registerWanderingTraderOffers(builder -> builder.addOffersToPool(
            TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
            new TradeOffers.SellItemFactory(LEGACY_SAPLING.asItem(), 5, 1, 8, 1),
            new TradeOffers.SellItemFactory(WHITE_OAK_SAPLING.asItem(), 5, 1, 8, 1),
            new TradeOffers.SellItemFactory(RAINBOW_PETALS.asItem(), 1, 3, 12, 1),
            new TradeOffers.SellItemFactory(RAINBOW_ROSE.asItem(), 1, 1, 12, 1)));

        TradeOfferHelper.registerWanderingTraderOffers(builder -> builder.addOffersToPool(
            TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL,
            new TradeOffers.SellItemFactory(WHITE_OAK_LOG.asItem(), 1, 8, 4, 1)));
    }
}
