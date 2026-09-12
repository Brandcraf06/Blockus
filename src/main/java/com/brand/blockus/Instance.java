package com.brand.blockus;

import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopperCollection;

import java.util.List;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class Instance {
    public static void init() {


// Burning
        // General
        FlammableBlockRegistry.getDefaultInstance().add(WOODEN_FRAME, 30, 60);

        // Hedges
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
        for (TimberFrameBundle bundle : TimberFrameBundle.values()) {
            for (Block block : bundle.all()) {
                for (var entry : bundle.woodMap().entrySet()) {
                    if (!entry.getKey().data().isBurnable()) continue;
                    FlammableBlockRegistry.getDefaultInstance().add(block, 5, 20);
                }
            }
        }

        // Patterned wools
        for (WoolBundle bundle : WoolBundle.values()) {
            for (DyeColor color : DyeColor.values()) {
                FlammableBlockRegistry.getDefaultInstance().add(bundle.block().blocks().pick(color), 30, 60);
                FlammableBlockRegistry.getDefaultInstance().add(bundle.stairs().blocks().pick(color), 30, 60);
                FlammableBlockRegistry.getDefaultInstance().add(bundle.slab().blocks().pick(color), 30, 60);
                FlammableBlockRegistry.getDefaultInstance().add(bundle.carpet().blocks().pick(color), 60, 20);
            }
        }
        FlammableBlockRegistry.getDefaultInstance().add(RAINBOW_WOOL.block(), 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(RAINBOW_WOOL.stairs(), 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(RAINBOW_WOOL.slab(), 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(RAINBOW_CARPET, 60, 20);

        // Wood set
        for (WoodBundle bundle : WoodBundle.values()) {
            if (bundle.burnable()) {
                FlammableBlockRegistry.getDefaultInstance().add(bundle.planks(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(bundle.stairs(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(bundle.slab(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(bundle.fence(), 5, 20);
                FlammableBlockRegistry.getDefaultInstance().add(bundle.fenceGate(), 5, 20);
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
            var smallLogs = SMALL_LOGS.bundle().get(wood.getId());
            if (smallLogs != null) {
                FlammableBlockRegistry.getDefaultInstance().add(smallLogs, 5, 5);
            }
        }

        // Posts
        for (WoodenPostBundle bundle : WoodenPostBundle.values()) {
            for (var entry : bundle.woodMap().entrySet()) {
                if (entry == null) continue;
                if (!entry.getKey().data().isBurnable()) continue;
                WoodenPostBundle.WoodenPostVariants variants = entry.getValue();
                FlammableBlockRegistry.getDefaultInstance().add(variants.block(), 5, 5);
                FlammableBlockRegistry.getDefaultInstance().add(variants.stripped(), 5, 5);
            }
        }

        // Legacy blocks
        FlammableBlockRegistry.getDefaultInstance().add(LEGACY_LOG, 5, 5);

// Other

        addStrippables();
        addFlattenables();
        addOxidizables();
    }


    public static void addStrippables() {
        BlockTransformerHelper.registerStripping(WHITE_OAK_LOG, STRIPPED_WHITE_OAK_LOG);
        BlockTransformerHelper.registerStripping(WHITE_OAK_WOOD, STRIPPED_WHITE_OAK_WOOD);
        for (WoodenPostBundle bundle : WoodenPostBundle.values()) {
            for (WoodenPostBundle.WoodenPostVariants variants : bundle.woodMap().values()) {
                BlockTransformerHelper.registerStripping(variants.block(), variants.stripped());
            }
        }
    }

    public static void addFlattenables() {
        BlockTransformerHelper.registerFlattening(Blocks.DIRT_PATH, PATH.defaultBlockState());
        BlockTransformerHelper.registerFlattening(PATH, Blocks.DIRT.defaultBlockState());
    }

    public static void addOxidizables() {
        registerOxidizable(COPPER_BRICKS);
        registerOxidizable(COPPER_TUFF_BRICKS);
        registerOxidizable(COPPER_LANTERN_BLOCK.blocks());
        registerOxidizable(COPPER_GATE.blocks());
    }

    public static void registerOxidizable(WeatheringCopperCollection<Block> block) {
        block.weathering().progressMapping(OxidizableBlocksRegistry::registerNextStage);
        block.zipUnwaxedWaxed(OxidizableBlocksRegistry::registerWaxable);
    }

    public static void registerOxidizable(CopperBSSWBundle block) {
        registerOxidizable(block.block().blocks());
        registerOxidizable(block.stairs().blocks());
        registerOxidizable(block.slab().blocks());
        registerOxidizable(block.wall().blocks());
    }

}
