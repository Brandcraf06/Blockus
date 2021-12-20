package com.brand.blockus.compatibility.content;

import com.brand.blockus.content.BlocksRegistration;
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
    private static Block POTTED_AUTUMN_OAK;
    private static Block POTTED_AUTUMN_BIRCH;
    private static Block POTTED_PINK_CHERRY_OAK;
    private static Block POTTED_WHITE_CHERRY_OAK;
    private static Block POTTED_PALM;

    public static void init() {
        POTTED_AUTUMN_OAK = BlocksRegistration.registerPottedDoublePlant(AutumnBundle.AUTUMN_OAK_SAPLING.getPlant(), "autumn_oak");
        POTTED_AUTUMN_BIRCH = BlocksRegistration.registerPottedDoublePlant(AutumnBundle.AUTUMN_BIRCH_SAPLING.getPlant(), "autumn_birch");
        POTTED_PINK_CHERRY_OAK = BlocksRegistration.registerPottedDoublePlant(CherryBundle.PINK_CHERRY_OAK_SAPLING.getPlant(), "pink_cherry_oak");
        POTTED_WHITE_CHERRY_OAK = BlocksRegistration.registerPottedDoublePlant(CherryBundle.WHITE_CHERRY_OAK_SAPLING.getPlant(), "white_cherry_oak");
        POTTED_PALM = BlocksRegistration.registerPottedDoublePlant(PalmBundle.PALM_WOOD.getSapling(), "palm");
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xE86D30, POTTED_AUTUMN_OAK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xFFBA42, POTTED_AUTUMN_BIRCH);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xF09AC3, POTTED_PINK_CHERRY_OAK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xF0E2E9, POTTED_WHITE_CHERRY_OAK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColors.getDefaultColor();
            } else {
                return BiomeColors.getFoliageColor(world, pos);
            }
        }, POTTED_PALM);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
                POTTED_AUTUMN_OAK,
                POTTED_AUTUMN_BIRCH,
                POTTED_PINK_CHERRY_OAK,
                POTTED_WHITE_CHERRY_OAK,
                POTTED_PALM
        );
    }
}
