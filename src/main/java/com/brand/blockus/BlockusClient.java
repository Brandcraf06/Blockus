package com.brand.blockus;

import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.utils.helper.BoatTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.object.boat.RaftModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.RaftRenderer;
import net.minecraft.core.IdMapper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.GrassColor;
import org.jetbrains.annotations.NotNull;

public class BlockusClient implements ClientModInitializer {

    private final IdMapper<BlockColor> blockColors = new IdMapper(32);

    public static <T extends Entity> void register(EntityType<? extends @NotNull T> entityType, ModelLayerLocation modelLayer, ModelLayerRegistry.TexturedLayerDefinitionProvider provider, EntityRendererProvider<T> renderer) {
        ModelLayerRegistry.registerModelLayer(modelLayer, provider);
        EntityRenderers.register(entityType, renderer);
    }

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

        BlockColorRegistry.register((state, level, pos, tintIndex) -> -10380959, BlockusBlocks.SPRUCE_HEDGE, BlockusBlocks.POTTED_SPRUCE.block());
        BlockColorRegistry.register((state, level, pos, tintIndex) -> -8345771, BlockusBlocks.BIRCH_HEDGE, BlockusBlocks.POTTED_BIRCH.block());
        BlockColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : -12012264,
            BlockusBlocks.OAK_HEDGE, BlockusBlocks.JUNGLE_HEDGE, BlockusBlocks.ACACIA_HEDGE, BlockusBlocks.DARK_OAK_HEDGE, BlockusBlocks.MANGROVE_HEDGE,
            BlockusBlocks.POTTED_OAK.block(), BlockusBlocks.POTTED_JUNGLE.block(), BlockusBlocks.POTTED_ACACIA.block(), BlockusBlocks.POTTED_DARK_OAK.block(), BlockusBlocks.POTTED_MANGROVE.block());
        BlockColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.getDefaultColor(), BlockusBlocks.POTTED_LARGE_FERN.block());
        BlockColorRegistry.register((state, level, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.getDefaultColor();
            } else {
                return -1;
            }
        }, BlockusBlocks.RAINBOW_PETALS);

        register(BlockusEntities.WHITE_OAK_BOAT, modelLayers(BoatTypes.WHITE_OAK.boatLayer), BoatModel::createBoatModel, (context) -> new BoatRenderer(context, modelLayers(BoatTypes.WHITE_OAK.boatLayer)));
        register(BlockusEntities.WHITE_OAK_CHEST_BOAT, modelLayers(BoatTypes.WHITE_OAK.chestBoatLayer), BoatModel::createChestBoatModel, (context) -> new BoatRenderer(context, modelLayers(BoatTypes.WHITE_OAK.chestBoatLayer)));
        register(BlockusEntities.CHARRED_BOAT, modelLayers(BoatTypes.CHARRED.boatLayer), BoatModel::createBoatModel, (context) -> new BoatRenderer(context, modelLayers(BoatTypes.CHARRED.boatLayer)));
        register(BlockusEntities.CHARRED_CHEST_BOAT, modelLayers(BoatTypes.CHARRED.chestBoatLayer), BoatModel::createChestBoatModel, (context) -> new BoatRenderer(context, modelLayers(BoatTypes.CHARRED.chestBoatLayer)));
        register(BlockusEntities.RAW_BAMBOO_RAFT, modelLayers(BoatTypes.RAW_BAMBOO.raftLayer), RaftModel::createRaftModel, (context) -> new RaftRenderer(context, modelLayers(BoatTypes.RAW_BAMBOO.raftLayer)));
        register(BlockusEntities.RAW_BAMBOO_CHEST_RAFT, modelLayers(BoatTypes.RAW_BAMBOO.chestRaftLayer), RaftModel::createChestRaftModel, (context) -> new RaftRenderer(context, modelLayers(BoatTypes.RAW_BAMBOO.chestRaftLayer)));

    }

    public ModelLayerLocation modelLayers(String name) {
        return new ModelLayerLocation(Blockus.id(name), "main");
    }

//    public void registerBlockColor(Block block, Block templateBlock) {
//        BlockColorRegistry.register((block1, pos, world, layer) -> {
//            BlockColor provider = BlockColorRegistry.get(templateBlock);
//            return provider == null ? -1 : provider.getColor(block1, pos, world, layer);
//        }, block);
//    }
}

