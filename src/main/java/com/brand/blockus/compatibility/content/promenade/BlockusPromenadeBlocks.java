package com.brand.blockus.compatibility.content.promenade;

import com.brand.blockus.content.BlocksRegistration;
import com.hugman.promenade.init.AmaranthBundle;
import com.hugman.promenade.init.AutumnBundle;
import com.hugman.promenade.init.CherryBundle;
import com.hugman.promenade.init.PalmBundle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;

public class BlockusPromenadeBlocks {
    public static Block POTTED_AUTUMN_OAK;
    public static Block POTTED_AUTUMN_BIRCH;
    public static Block POTTED_PINK_CHERRY_OAK;
    public static Block POTTED_WHITE_CHERRY_OAK;
    public static Block POTTED_PALM;
    public static Block POTTED_DARK_AMARANTH;
    public static Block CHERRY_OAK_SMALL_LOGS;
    public static Block PALM_SMALL_LOGS;
    public static Block DARK_AMARANTH_SMALL_STEMS;
    public static Block AUTUMN_OAK_SMALL_HEDGE;
    public static Block AUTUMN_BIRCH_SMALL_HEDGE;
    public static Block PINK_CHERRY_OAK_SMALL_HEDGE;
    public static Block WHITE_CHERRY_OAK_SMALL_HEDGE;
    public static Block PALM_SMALL_HEDGE;
    public static Block DARK_AMARANTH_SMALL_HEDGE;

    public static void init() {

        // Large Flower Pots
        POTTED_AUTUMN_OAK = BlocksRegistration.registerPottedDoublePlant(AutumnBundle.AUTUMN_OAK_SAPLING.getPlant(), "autumn_oak");
        POTTED_AUTUMN_BIRCH = BlocksRegistration.registerPottedDoublePlant(AutumnBundle.AUTUMN_BIRCH_SAPLING.getPlant(), "autumn_birch");
        POTTED_PINK_CHERRY_OAK = BlocksRegistration.registerPottedDoublePlant(CherryBundle.PINK_CHERRY_OAK_SAPLING.getPlant(), "pink_cherry_oak");
        POTTED_WHITE_CHERRY_OAK = BlocksRegistration.registerPottedDoublePlant(CherryBundle.WHITE_CHERRY_OAK_SAPLING.getPlant(), "white_cherry_oak");
        POTTED_PALM = BlocksRegistration.registerPottedDoublePlant(PalmBundle.PALM_WOOD.getSapling(), "palm");
        POTTED_DARK_AMARANTH = BlocksRegistration.registerPottedDoublePlant(AmaranthBundle.DARK_AMARANTH_WOOD.getFungus(), "huge_dark_amaranth_fungus");

        // Small Logs
        CHERRY_OAK_SMALL_LOGS = BlocksRegistration.registerPillar2("cherry_oak_small_logs", CherryBundle.CHERRY_OAK_WOOD.getLog());
        PALM_SMALL_LOGS = BlocksRegistration.registerPillar2("palm_small_logs", PalmBundle.PALM_WOOD.getLog());
        DARK_AMARANTH_SMALL_STEMS = BlocksRegistration.registerPillar2("dark_amaranth_small_stems", AmaranthBundle.DARK_AMARANTH_WOOD.getLog());

        // Small Hedges
        AUTUMN_OAK_SMALL_HEDGE = BlocksRegistration.registerSmallHedge("autumn_oak_small_hedge", AutumnBundle.AUTUMN_OAK_LEAVES);
        AUTUMN_BIRCH_SMALL_HEDGE = BlocksRegistration.registerSmallHedge("autumn_birch_small_hedge", AutumnBundle.AUTUMN_BIRCH_LEAVES);
        PINK_CHERRY_OAK_SMALL_HEDGE = BlocksRegistration.registerSmallHedge("pink_cherry_oak_small_hedge", CherryBundle.PINK_CHERRY_OAK_LEAVES);
        WHITE_CHERRY_OAK_SMALL_HEDGE = BlocksRegistration.registerSmallHedge("white_cherry_oak_small_hedge", CherryBundle.WHITE_CHERRY_OAK_LEAVES);
        PALM_SMALL_HEDGE = BlocksRegistration.registerSmallHedge("palm_small_hedge", PalmBundle.PALM_WOOD.getLeaves());
        DARK_AMARANTH_SMALL_HEDGE = BlocksRegistration.registerSmallHedge("dark_amaranth_small_hedge", AmaranthBundle.DARK_AMARANTH_WART_BLOCK);
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xE86D30, POTTED_AUTUMN_OAK, AUTUMN_OAK_SMALL_HEDGE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xE86D30, AUTUMN_OAK_SMALL_HEDGE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xFFBA42, POTTED_AUTUMN_BIRCH, AUTUMN_BIRCH_SMALL_HEDGE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xFFBA42, AUTUMN_BIRCH_SMALL_HEDGE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xF09AC3, POTTED_PINK_CHERRY_OAK, PINK_CHERRY_OAK_SMALL_HEDGE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xF09AC3, PINK_CHERRY_OAK_SMALL_HEDGE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xF0E2E9, POTTED_WHITE_CHERRY_OAK, WHITE_CHERRY_OAK_SMALL_HEDGE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xF0E2E9, WHITE_CHERRY_OAK_SMALL_HEDGE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColors.getDefaultColor();
            } else {
                return BiomeColors.getFoliageColor(world, pos);
            }
        }, POTTED_PALM, PALM_SMALL_HEDGE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getDefaultColor(), PALM_SMALL_HEDGE);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
                POTTED_AUTUMN_OAK,
                POTTED_AUTUMN_BIRCH,
                POTTED_PINK_CHERRY_OAK,
                POTTED_WHITE_CHERRY_OAK,
                POTTED_PALM,
                AUTUMN_OAK_SMALL_HEDGE,
                AUTUMN_BIRCH_SMALL_HEDGE,
                PINK_CHERRY_OAK_SMALL_HEDGE,
                WHITE_CHERRY_OAK_SMALL_HEDGE,
                PALM_SMALL_HEDGE
        );
    }
}
