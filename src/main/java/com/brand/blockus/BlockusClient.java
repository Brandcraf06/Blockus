package com.brand.blockus;

import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.registry.content.bundles.TimberFrameBundle;
import com.brand.blockus.registry.content.bundles.WoodenPostBundle;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.*;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.DyeColor;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        registerBlockColor(BlockusBlocks.OAK_HEDGE, Blocks.OAK_LEAVES);
        registerBlockColor(BlockusBlocks.SPRUCE_HEDGE, Blocks.SPRUCE_LEAVES);
        registerBlockColor(BlockusBlocks.BIRCH_HEDGE, Blocks.BIRCH_LEAVES);
        registerBlockColor(BlockusBlocks.JUNGLE_HEDGE, Blocks.JUNGLE_LEAVES);
        registerBlockColor(BlockusBlocks.ACACIA_HEDGE, Blocks.ACACIA_LEAVES);
        registerBlockColor(BlockusBlocks.DARK_OAK_HEDGE, Blocks.DARK_OAK_LEAVES);
        registerBlockColor(BlockusBlocks.MANGROVE_HEDGE, Blocks.MANGROVE_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_LARGE_FERN.block(), Blocks.POTTED_FERN);
        registerBlockColor(BlockusBlocks.POTTED_OAK.block(), Blocks.OAK_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_SPRUCE.block(), Blocks.SPRUCE_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_BIRCH.block(), Blocks.BIRCH_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_JUNGLE.block(), Blocks.JUNGLE_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_ACACIA.block(), Blocks.ACACIA_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_DARK_OAK.block(), Blocks.DARK_OAK_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_MANGROVE.block(), Blocks.MANGROVE_LEAVES);
        registerBlockColor(BlockusBlocks.RAINBOW_PETALS, Blocks.PINK_PETALS);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
            BlockusBlocks.RAW_BAMBOO.door(),
            BlockusBlocks.RAW_BAMBOO.trapdoor(),
            BlockusBlocks.LEGACY_SAPLING,
            BlockusBlocks.POTTED_LEGACY_SAPLING,
            BlockusBlocks.WHITE_OAK_SAPLING,
            BlockusBlocks.POTTED_WHITE_OAK_SAPLING,
            BlockusBlocks.OBSIDIAN_REINFORCED_DOOR,
            BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR,
            BlockusBlocks.RAINBOW_ROSE,
            BlockusBlocks.POTTED_RAINBOW_ROSE,
            BlockusBlocks.RAINBOW_PETALS,
            BlockusBlocks.POTTED_ROSE_BUSH.block(),
            BlockusBlocks.POTTED_LILAC.block(),
            BlockusBlocks.POTTED_PEONY.block(),
            BlockusBlocks.POTTED_LARGE_FERN.block(),
            BlockusBlocks.POTTED_OAK.block(),
            BlockusBlocks.POTTED_SPRUCE.block(),
            BlockusBlocks.POTTED_BIRCH.block(),
            BlockusBlocks.POTTED_JUNGLE.block(),
            BlockusBlocks.POTTED_ACACIA.block(),
            BlockusBlocks.POTTED_DARK_OAK.block(),
            BlockusBlocks.POTTED_MANGROVE.block(),
            BlockusBlocks.POTTED_CHERRY_BLOSSOM.block(),
            BlockusBlocks.POTTED_WHITE_OAK.block(),
            BlockusBlocks.POTTED_CACTUS_LARGE.block(),
            BlockusBlocks.POTTED_BAMBOO_LARGE.block(),
            BlockusBlocks.POTTED_AZALEA_LARGE.block(),
            BlockusBlocks.POTTED_FLOWERING_AZALEA_LARGE.block(),
            BlockusBlocks.POTTED_LEGACY_TREE.block(),
            BlockusBlocks.POTTED_PITCHER_PLANT.block(),
            BlockusBlocks.BLACKSTONE_DOOR,
            BlockusBlocks.BLACKSTONE_TRAPDOOR,
            BlockusBlocks.AMETHYST_LANTERN,
            BlockusBlocks.REDSTONE_LANTERN,
            BlockusBlocks.LEGACY_ROSE,
            BlockusBlocks.POTTED_LEGACY_ROSE,
            BlockusBlocks.LEGACY_BLUE_ROSE,
            BlockusBlocks.POTTED_LEGACY_BLUE_ROSE
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
            BlockusBlocks.OAK_HEDGE,
            BlockusBlocks.SPRUCE_HEDGE,
            BlockusBlocks.BIRCH_HEDGE,
            BlockusBlocks.JUNGLE_HEDGE,
            BlockusBlocks.ACACIA_HEDGE,
            BlockusBlocks.DARK_OAK_HEDGE,
            BlockusBlocks.MANGROVE_HEDGE,
            BlockusBlocks.CHERRY_HEDGE,
            BlockusBlocks.WHITE_OAK_HEDGE,
            BlockusBlocks.AZALEA_HEDGE,
            BlockusBlocks.FLOWERING_AZALEA_HEDGE,
            BlockusBlocks.LEGACY_LEAVES,
            BlockusBlocks.WHITE_OAK_LEAVES,
            BlockusBlocks.WOODEN_FRAME,
            BlockusBlocks.IRON_GATE,
            BlockusBlocks.GOLDEN_GATE,
            BlockusBlocks.GOLDEN_CHAIN,
            BlockusBlocks.GOLDEN_BARS,
            BlockusBlocks.BEVELED_GLASS,
            BlockusBlocks.BEVELED_GLASS_PANE
        );

        for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
            for (var variants : timberFrameBundle.woodMap().values()) {
                BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(), variants.lattice(), variants.grate());
            }
        }

        for (WoodenPostBundle woodenPostBundle : WoodenPostBundle.values()) {
            for (var variants : woodenPostBundle.woodMap().values()) {
                BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), variants.block(), variants.stripped());
            }
        }

        for (DyeColor color : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), STAINED_BEVELED_GLASS.colorMap().get(color), STAINED_BEVELED_GLASS_PANE.colorMap().get(color));
        }

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
            BlockusBlocks.RAINBOW_GLASS,
            BlockusBlocks.RAINBOW_GLASS_PANE,
            BlockusBlocks.RAINBOW_BEVELED_GLASS,
            BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE,
            BlockusBlocks.TINTED_BEVELED_GLASS
        );

        TerraformBoatClientHelper.registerModelLayers(Blockus.id("raw_bamboo"), true);
        TerraformBoatClientHelper.registerModelLayers(Blockus.id("charred"), false);
        TerraformBoatClientHelper.registerModelLayers(Blockus.id("white_oak"), false);


        /*if (FabricLoader.getInstance().isModLoaded("promenade")) {
            BlockusPromenadeBlocks.initClient();
        }*/
    }

    public void registerBlockColor(Block block, Block templateBlock) {
        ColorProviderRegistry.BLOCK.register((block1, pos, world, layer) -> {
            BlockColorProvider provider = ColorProviderRegistry.BLOCK.get(templateBlock);
            return provider == null ? -1 : provider.getColor(block1, pos, world, layer);
        }, block);

        ColorProviderRegistry.ITEM.register((item, layer) -> {
            ItemColorProvider provider = ColorProviderRegistry.ITEM.get(templateBlock);
            return provider == null ? -1 : provider.getColor(item, layer);
        }, block.asItem());
    }
}

