package com.brand.blockus;

import com.brand.blockus.compatibility.content.promenade.BlockusPromenadeBlocks;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.types.BSSWTypes;
import com.brand.blockus.content.types.WoodTypesNB;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class BlockusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        registerBlockColor(BlockusBlocks.OAK_SMALL_HEDGE, Blocks.OAK_LEAVES);
        registerBlockColor(BlockusBlocks.SPRUCE_SMALL_HEDGE, Blocks.SPRUCE_LEAVES);
        registerBlockColor(BlockusBlocks.BIRCH_SMALL_HEDGE, Blocks.BIRCH_LEAVES);
        registerBlockColor(BlockusBlocks.JUNGLE_SMALL_HEDGE, Blocks.JUNGLE_LEAVES);
        registerBlockColor(BlockusBlocks.ACACIA_SMALL_HEDGE, Blocks.ACACIA_LEAVES);
        registerBlockColor(BlockusBlocks.DARK_OAK_SMALL_HEDGE, Blocks.DARK_OAK_LEAVES);
        registerBlockColor(BSSWTypes.WATER_BRICKS.block, Blocks.WATER);
        registerBlockColor(BSSWTypes.WATER_BRICKS.stairs, Blocks.WATER);
        registerBlockColor(BSSWTypes.WATER_BRICKS.slab, Blocks.WATER);
        registerBlockColor(BSSWTypes.WATER_BRICKS.wall, Blocks.WATER);
        registerBlockColor(BlockusBlocks.CHISELED_WATER_BRICKS, Blocks.WATER);
        registerBlockColor(BlockusBlocks.POTTED_LARGE_FERN, Blocks.POTTED_FERN);
        registerBlockColor(BlockusBlocks.POTTED_OAK, Blocks.OAK_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_SPRUCE, Blocks.SPRUCE_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_BIRCH, Blocks.BIRCH_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_JUNGLE, Blocks.JUNGLE_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_ACACIA, Blocks.ACACIA_LEAVES);
        registerBlockColor(BlockusBlocks.POTTED_DARK_OAK, Blocks.DARK_OAK_LEAVES);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xebb359, BlockusBlocks.WHITE_OAK_LEAVES, BlockusBlocks.WHITE_OAK_SMALL_HEDGE, BlockusBlocks.POTTED_WHITE_OAK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xebb359, BlockusBlocks.WHITE_OAK_LEAVES, BlockusBlocks.WHITE_OAK_SMALL_HEDGE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0x62ff42, BlockusBlocks.LEGACY_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x62ff42, BlockusBlocks.LEGACY_LEAVES);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
            BlockusBlocks.OAK_SMALL_HEDGE,
            BlockusBlocks.SPRUCE_SMALL_HEDGE,
            BlockusBlocks.BIRCH_SMALL_HEDGE,
            BlockusBlocks.JUNGLE_SMALL_HEDGE,
            BlockusBlocks.ACACIA_SMALL_HEDGE,
            BlockusBlocks.DARK_OAK_SMALL_HEDGE,
            BlockusBlocks.WHITE_OAK_SMALL_HEDGE,
            BlockusBlocks.AZALEA_SMALL_HEDGE,
            BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE,
            BlockusBlocks.LEGACY_LEAVES,
            BlockusBlocks.WHITE_OAK_LEAVES,
            BlockusBlocks.WHITE_OAK_SAPLING,
            BlockusBlocks.POTTED_WHITE_OAK_SAPLING,
            BlockusBlocks.OBSIDIAN_REINFORCED_DOOR,
            BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR,
            WoodTypesNB.CHARRED.door,
            WoodTypesNB.CHARRED.trapdoor,
            BlockusBlocks.WOODEN_FRAME,
            BlockusBlocks.IRON_GATE,
            BlockusBlocks.GOLDEN_GATE,
            BlockusBlocks.GOLDEN_CHAIN,
            BlockusBlocks.GOLDEN_BARS,
            BlockusBlocks.RAINBOW_ROSE,
            BlockusBlocks.POTTED_RAINBOW_ROSE,
            BlockusBlocks.POTTED_ROSE_BUSH,
            BlockusBlocks.POTTED_LILAC,
            BlockusBlocks.POTTED_PEONY,
            BlockusBlocks.POTTED_LARGE_FERN,
            BlockusBlocks.POTTED_OAK,
            BlockusBlocks.POTTED_SPRUCE,
            BlockusBlocks.POTTED_BIRCH,
            BlockusBlocks.POTTED_JUNGLE,
            BlockusBlocks.POTTED_ACACIA,
            BlockusBlocks.POTTED_DARK_OAK,
            BlockusBlocks.POTTED_WHITE_OAK,
            BlockusBlocks.POTTED_CACTUS_LARGE,
            BlockusBlocks.POTTED_BAMBOO_LARGE,
            BlockusBlocks.POTTED_AZALEA_LARGE,
            BlockusBlocks.POTTED_FLOWERING_AZALEA_LARGE,
            BlockusBlocks.BLACKSTONE_DOOR,
            BlockusBlocks.BLACKSTONE_TRAPDOOR

        );
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
            BSSWTypes.WATER_BRICKS.block,
            BSSWTypes.WATER_BRICKS.stairs,
            BSSWTypes.WATER_BRICKS.slab,
            BSSWTypes.WATER_BRICKS.wall,
            BlockusBlocks.CHISELED_WATER_BRICKS,

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

        TerraformBoatClientHelper.registerModelLayer(Blockus.id("bamboo"));
        TerraformBoatClientHelper.registerModelLayer(Blockus.id( "charred"));
        TerraformBoatClientHelper.registerModelLayer(Blockus.id( "white_oak"));

        registerSignSprite("bamboo");
        registerSignSprite("charred");
        registerSignSprite("white_oak");

        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            BlockusPromenadeBlocks.initClient();
        }
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

    private void registerSignSprite(String path) {
        Identifier id = Blockus.id( "entity/signs/" + path);
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, id));
    }

}
