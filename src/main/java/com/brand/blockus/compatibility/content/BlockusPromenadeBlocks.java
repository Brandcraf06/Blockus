package com.brand.blockus.compatibility.content;

import com.brand.blockus.content.BlocksRegistration;
import com.hugman.promenade.init.AutumnBundle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class BlockusPromenadeBlocks {
    private static Block POTTED_AUTUMN_OAK;
    private static Block POTTED_AUTUMN_BIRCH;

    public static void init() {
        POTTED_AUTUMN_OAK = BlocksRegistration.registerPottedDoublePlant(AutumnBundle.AUTUMN_OAK_SAPLING.getPlant(), "autumn_oak");
        POTTED_AUTUMN_BIRCH = BlocksRegistration.registerPottedDoublePlant(AutumnBundle.AUTUMN_BIRCH_SAPLING.getPlant(), "autumn_birch");
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xE86D30, POTTED_AUTUMN_OAK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xFFBA42, POTTED_AUTUMN_BIRCH);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
                POTTED_AUTUMN_OAK,
                POTTED_AUTUMN_BIRCH
        );
    }
}
