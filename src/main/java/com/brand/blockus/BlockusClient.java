package com.brand.blockus;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.types.TimberFrameTypes;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.render.RenderLayer;

public class BlockusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        registerBlockColor(BlockusBlocks.OAK_SMALL_HEDGE, Blocks.OAK_LEAVES);
        registerBlockColor(BlockusBlocks.SPRUCE_SMALL_HEDGE, Blocks.SPRUCE_LEAVES);
        registerBlockColor(BlockusBlocks.BIRCH_SMALL_HEDGE, Blocks.BIRCH_LEAVES);
        registerBlockColor(BlockusBlocks.JUNGLE_SMALL_HEDGE, Blocks.JUNGLE_LEAVES);
        registerBlockColor(BlockusBlocks.ACACIA_SMALL_HEDGE, Blocks.ACACIA_LEAVES);
        registerBlockColor(BlockusBlocks.DARK_OAK_SMALL_HEDGE, Blocks.DARK_OAK_LEAVES);
        registerBlockColor(BlockusBlocks.MANGROVE_SMALL_HEDGE, Blocks.MANGROVE_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_LARGE_FERN.block, Blocks.POTTED_FERN);
        registerBlockColor(BlockusBlocks.POTTED_OAK.block, Blocks.OAK_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_SPRUCE.block, Blocks.SPRUCE_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_BIRCH.block, Blocks.BIRCH_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_JUNGLE.block, Blocks.JUNGLE_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_ACACIA.block, Blocks.ACACIA_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_DARK_OAK.block, Blocks.DARK_OAK_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_MANGROVE.block, Blocks.MANGROVE_LEAVES);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
            BlockusBlocks.OAK_SMALL_HEDGE,
            BlockusBlocks.SPRUCE_SMALL_HEDGE,
            BlockusBlocks.BIRCH_SMALL_HEDGE,
            BlockusBlocks.JUNGLE_SMALL_HEDGE,
            BlockusBlocks.ACACIA_SMALL_HEDGE,
            BlockusBlocks.DARK_OAK_SMALL_HEDGE,
            BlockusBlocks.MANGROVE_SMALL_HEDGE,
            BlockusBlocks.CHERRY_SMALL_HEDGE,
            BlockusBlocks.WHITE_OAK_SMALL_HEDGE,
            BlockusBlocks.RAW_BAMBOO.door,
            BlockusBlocks.RAW_BAMBOO.trapdoor,
            BlockusBlocks.AZALEA_SMALL_HEDGE,
            BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE,
            BlockusBlocks.LEGACY_LEAVES,
            BlockusBlocks.WHITE_OAK_LEAVES,
            BlockusBlocks.LEGACY_SAPLING,
            BlockusBlocks.POTTED_LEGACY_SAPLING,
            BlockusBlocks.WHITE_OAK_SAPLING,
            BlockusBlocks.POTTED_WHITE_OAK_SAPLING,
            BlockusBlocks.OBSIDIAN_REINFORCED_DOOR,
            BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR,
            BlockusBlocks.WOODEN_FRAME,
            BlockusBlocks.IRON_GATE,
            BlockusBlocks.GOLDEN_GATE,
            BlockusBlocks.GOLDEN_CHAIN,
            BlockusBlocks.GOLDEN_BARS,
            BlockusBlocks.RAINBOW_ROSE,
            BlockusBlocks.POTTED_RAINBOW_ROSE,
            BlockusBlocks.POTTED_ROSE_BUSH.block,
            BlockusBlocks.POTTED_LILAC.block,
            BlockusBlocks.POTTED_PEONY.block,
            BlockusBlocks.POTTED_LARGE_FERN.block,
            BlockusBlocks.POTTED_OAK.block,
            BlockusBlocks.POTTED_SPRUCE.block,
            BlockusBlocks.POTTED_BIRCH.block,
            BlockusBlocks.POTTED_JUNGLE.block,
            BlockusBlocks.POTTED_ACACIA.block,
            BlockusBlocks.POTTED_DARK_OAK.block,
            BlockusBlocks.POTTED_MANGROVE.block,
            BlockusBlocks.POTTED_CHERRY_BLOSSOM.block,
            BlockusBlocks.POTTED_WHITE_OAK.block,
            BlockusBlocks.POTTED_CACTUS_LARGE.block,
            BlockusBlocks.POTTED_BAMBOO_LARGE.block,
            BlockusBlocks.POTTED_AZALEA_LARGE.block,
            BlockusBlocks.POTTED_FLOWERING_AZALEA_LARGE.block,
            BlockusBlocks.POTTED_LEGACY_TREE.block,
            BlockusBlocks.POTTED_PITCHER_PLANT.block,
            BlockusBlocks.BLACKSTONE_DOOR,
            BlockusBlocks.BLACKSTONE_TRAPDOOR,
            BlockusBlocks.REDSTONE_LANTERN
        );

        for (TimberFrameTypes timberFrameType : TimberFrameTypes.values()) {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),timberFrameType.lattice, timberFrameType.grate);
        }

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),

            BlockusBlocks.RAINBOW_GLASS,
            BlockusBlocks.RAINBOW_GLASS_PANE,

            BlockusBlocks.BEVELED_GLASS,
            BlockusBlocks.WHITE_BEVELED_GLASS,
            BlockusBlocks.ORANGE_BEVELED_GLASS,
            BlockusBlocks.MAGENTA_BEVELED_GLASS,
            BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS,
            BlockusBlocks.YELLOW_BEVELED_GLASS,
            BlockusBlocks.LIME_BEVELED_GLASS,
            BlockusBlocks.PINK_BEVELED_GLASS,
            BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS,
            BlockusBlocks.GRAY_BEVELED_GLASS,
            BlockusBlocks.CYAN_BEVELED_GLASS,
            BlockusBlocks.PURPLE_BEVELED_GLASS,
            BlockusBlocks.BLUE_BEVELED_GLASS,
            BlockusBlocks.BROWN_BEVELED_GLASS,
            BlockusBlocks.GREEN_BEVELED_GLASS,
            BlockusBlocks.RED_BEVELED_GLASS,
            BlockusBlocks.BLACK_BEVELED_GLASS,
            BlockusBlocks.RAINBOW_BEVELED_GLASS,

            BlockusBlocks.BEVELED_GLASS_PANE,
            BlockusBlocks.WHITE_BEVELED_GLASS_PANE,
            BlockusBlocks.ORANGE_BEVELED_GLASS_PANE,
            BlockusBlocks.MAGENTA_BEVELED_GLASS_PANE,
            BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS_PANE,
            BlockusBlocks.YELLOW_BEVELED_GLASS_PANE,
            BlockusBlocks.LIME_BEVELED_GLASS_PANE,
            BlockusBlocks.PINK_BEVELED_GLASS_PANE,
            BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS_PANE,
            BlockusBlocks.GRAY_BEVELED_GLASS_PANE,
            BlockusBlocks.CYAN_BEVELED_GLASS_PANE,
            BlockusBlocks.PURPLE_BEVELED_GLASS_PANE,
            BlockusBlocks.BLUE_BEVELED_GLASS_PANE,
            BlockusBlocks.BROWN_BEVELED_GLASS_PANE,
            BlockusBlocks.GREEN_BEVELED_GLASS_PANE,
            BlockusBlocks.RED_BEVELED_GLASS_PANE,
            BlockusBlocks.BLACK_BEVELED_GLASS_PANE,
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
