package com.brand.blockus;

import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class Instance {
    public static void init() {


// Burning
        // Fuel
        FuelRegistry.INSTANCE.add(Items.DRIED_KELP, 200);
        FuelRegistry.INSTANCE.add(LEGACY_COAL_BLOCK, 16000);
        FuelRegistry.INSTANCE.add(CHARCOAL_BLOCK, 16000);
        FuelRegistry.INSTANCE.add(WOODEN_FRAME, 300);
        FuelRegistry.INSTANCE.add(Items.PAPER, 100);
        FuelRegistry.INSTANCE.add(PAPER_DOOR, 100);
        FuelRegistry.INSTANCE.add(PAPER_TRAPDOOR, 150);
        FuelRegistry.INSTANCE.add(FRAMED_PAPER_BLOCK, 300);
        FuelRegistry.INSTANCE.add(PAPER_WALL, 150);
        FuelRegistry.INSTANCE.add(PAPER_LAMP, 300);
        FuelRegistry.INSTANCE.add(PAPER_BLOCK, 400);

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
                for (var entry : timberFrameBundle.woodMap().entrySet()) {
                    if (!entry.getKey().data().isBurnable()) continue;
                    FlammableBlockRegistry.getDefaultInstance().add(block, 5, 20);
                    FuelRegistry.INSTANCE.add(block, 300);
                }
            }
        }

        // Patterned wools
        for (WoolBundle woolBundle : WoolBundle.values()) {
            for (WoolBundle.WoolVariants blocks : woolBundle.colorMap().values()) {
                FlammableBlockRegistry.getDefaultInstance().add(blocks.block(), 30, 60);
                FlammableBlockRegistry.getDefaultInstance().add(blocks.stairs(), 30, 60);
                FlammableBlockRegistry.getDefaultInstance().add(blocks.slab(), 30, 60);
                FlammableBlockRegistry.getDefaultInstance().add(blocks.carpet(), 60, 20);
                FuelRegistry.INSTANCE.add(blocks.stairs(), 100);
                FuelRegistry.INSTANCE.add(blocks.slab(), 50);
            }
        }

        // Wood set
        for (WoodBundle woodBundle : WoodBundle.values()) {
            if (woodBundle.burnable()) {
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.planks(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.stairs(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.slab(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.fence(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(woodBundle.fenceGate(), 5, 20);
                FuelRegistry.INSTANCE.add(woodBundle.fence(), 300);
                FuelRegistry.INSTANCE.add(woodBundle.fenceGate(), 300);
            }
        }

        // White oak
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_WHITE_OAK_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_WHITE_OAK_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_OAK_LEAVES, 30, 60);

        // Wooden mosaic
        for (var wood : WoodMaps.values()) {
            if (!wood.data().isBurnable()) continue;
            for (var woodMap : List.of(WOODEN_MOSAIC, MOSSY_PLANKS)) {
                var bundle = woodMap.get(wood.getId());
                if (bundle == null) continue;
                FlammableBlockRegistry.getDefaultInstance().add(bundle.block(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(bundle.stairs(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(bundle.slab(), 5, 20);
                FuelRegistry.INSTANCE.add(bundle.block(), 300);
                FuelRegistry.INSTANCE.add(bundle.stairs(), 300);
                FuelRegistry.INSTANCE.add(bundle.slab(), 150);
            }
        }

        // Herringbone planks
        for (var wood : WoodMaps.values()) {
            if (!wood.data().isBurnable()) continue;
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                FlammableBlockRegistry.getDefaultInstance().add(HERRINGBONE_PLANKS.bundle().get(wood.getId()), 5, 20);
            }
        }

        // Small log
        for (var wood : WoodMaps.values()) {
            if (!wood.data().isBurnable()) continue;
            FlammableBlockRegistry.getDefaultInstance().add(SMALL_LOGS.bundle().get(wood.getId()), 5, 5);
        }

        // Posts
        for (WoodenPostBundle woodenPostBundle : WoodenPostBundle.values()) {
            for (var entry : woodenPostBundle.woodMap().entrySet()) {
                if (entry == null) continue;
                if (!entry.getKey().data().isBurnable()) continue;
                WoodenPostBundle.WoodenPostVariants variants = entry.getValue();
                FlammableBlockRegistry.getDefaultInstance().add(variants.block(), 5, 5);
                FlammableBlockRegistry.getDefaultInstance().add(variants.stripped(), 5, 5);
                FuelRegistry.INSTANCE.add(variants.block(), 150);
                FuelRegistry.INSTANCE.add(variants.stripped(), 150);
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
        for (WoodenPostBundle woodenPostBundle : WoodenPostBundle.values()) {
            for (WoodenPostBundle.WoodenPostVariants variants : woodenPostBundle.woodMap().values()) {
                StrippableBlockRegistry.register(variants.block(), variants.stripped());
            }
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
        FlattenableBlockRegistry.register(Blocks.DIRT_PATH, PATH.defaultBlockState());
        FlattenableBlockRegistry.register(PATH, Blocks.DIRT.defaultBlockState());
    }

    public static void addTradeOffers() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add(new SellItemFactory(LEGACY_SAPLING, 5, 1, 8));
            factories.add(new SellItemFactory(WHITE_OAK_SAPLING, 5, 1, 8));
            factories.add(new SellItemFactory(RAINBOW_PETALS, 1, 3, 12));
            factories.add(new SellItemFactory(RAINBOW_ROSE, 1, 1, 12));
        });
    }


    static class SellItemFactory implements VillagerTrades.ItemListing {
        private final ItemStack sell;
        private final int price;
        private final int count;
        private final int maxUses;

        public SellItemFactory(ItemLike stack, int price, int count, int maxUses) {
            this.sell = new ItemStack(stack);
            this.price = price;
            this.count = count;
            this.maxUses = maxUses;
        }

        public MerchantOffer getOffer(Entity entity, RandomSource random) {
            return new MerchantOffer(new ItemCost(Items.EMERALD, this.price), new ItemStack(this.sell.getItem(), this.count), this.maxUses, 1, 0.05f);
        }
    }
}
