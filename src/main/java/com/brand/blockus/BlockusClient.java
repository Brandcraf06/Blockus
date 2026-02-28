package com.brand.blockus;

import net.fabricmc.api.ClientModInitializer;

public class BlockusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

//        registerBlockColor(BlockusBlocks.OAK_HEDGE, Blocks.OAK_LEAVES);
//        registerBlockColor(BlockusBlocks.SPRUCE_HEDGE, Blocks.SPRUCE_LEAVES);
//        registerBlockColor(BlockusBlocks.BIRCH_HEDGE, Blocks.BIRCH_LEAVES);
//        registerBlockColor(BlockusBlocks.JUNGLE_HEDGE, Blocks.JUNGLE_LEAVES);
//        registerBlockColor(BlockusBlocks.ACACIA_HEDGE, Blocks.ACACIA_LEAVES);
//        registerBlockColor(BlockusBlocks.DARK_OAK_HEDGE, Blocks.DARK_OAK_LEAVES);
//        registerBlockColor(BlockusBlocks.MANGROVE_HEDGE, Blocks.MANGROVE_LEAVES);
//        registerBlockColor(BlockusBlocks.POTTED_LARGE_FERN.block(), Blocks.POTTED_FERN);
//        registerBlockColor(BlockusBlocks.POTTED_OAK.block(), Blocks.OAK_LEAVES);
//        registerBlockColor(BlockusBlocks.POTTED_SPRUCE.block(), Blocks.SPRUCE_LEAVES);
//        registerBlockColor(BlockusBlocks.POTTED_BIRCH.block(), Blocks.BIRCH_LEAVES);
//        registerBlockColor(BlockusBlocks.POTTED_JUNGLE.block(), Blocks.JUNGLE_LEAVES);
//        registerBlockColor(BlockusBlocks.POTTED_ACACIA.block(), Blocks.ACACIA_LEAVES);
//        registerBlockColor(BlockusBlocks.POTTED_DARK_OAK.block(), Blocks.DARK_OAK_LEAVES);
//        registerBlockColor(BlockusBlocks.POTTED_MANGROVE.block(), Blocks.MANGROVE_LEAVES);
//        registerBlockColor(BlockusBlocks.RAINBOW_PETALS, Blocks.PINK_PETALS);


//        TerraformBoatClientHelper.registerModelLayers(BlockusEntities.WHITE_OAK_BOATS_ID);
//        TerraformBoatClientHelper.registerModelLayers(BlockusEntities.CHARRED_BOATS_ID);
//        TerraformBoatClientHelper.registerModelLayers(BlockusEntities.RAW_BAMBOO_RAFTS_ID);


        /*if (FabricLoader.getInstance().isModLoaded("promenade")) {
            BlockusPromenadeBlocks.initClient();
        }*/
    }

//    public void registerBlockColor(Block block, Block templateBlock) {
//        BlockColorRegistry.register((block1, pos, world, layer) -> {
//            BlockColor provider = BlockColorRegistry.get(templateBlock);
//            return provider == null ? -1 : provider.getColor(block1, pos, world, layer);
//        }, block);
//    }
}

