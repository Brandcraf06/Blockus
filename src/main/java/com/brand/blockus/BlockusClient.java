package com.brand.blockus;

import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.utils.helper.BoatTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.object.boat.RaftModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.RaftRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BlockusClient implements ClientModInitializer {

    public static <T extends Entity> void register(EntityType<? extends @NotNull T> entityType, ModelLayerLocation modelLayer, ModelLayerRegistry.TexturedLayerDefinitionProvider provider, EntityRendererProvider<T> renderer) {
        ModelLayerRegistry.registerModelLayer(modelLayer, provider);
        EntityRenderers.register(entityType, renderer);
    }

    @Override
    public void onInitializeClient() {
        BlockColorRegistry.register(List.of(BlockTintSources.constant(-10380959)), BlockusBlocks.SPRUCE_HEDGE, BlockusBlocks.POTTED_SPRUCE.block());
        BlockColorRegistry.register(List.of(BlockTintSources.constant(-8345771)), BlockusBlocks.BIRCH_HEDGE, BlockusBlocks.POTTED_BIRCH.block());
        BlockColorRegistry.register(List.of(BlockTintSources.foliage()),
            BlockusBlocks.OAK_HEDGE, BlockusBlocks.JUNGLE_HEDGE, BlockusBlocks.ACACIA_HEDGE, BlockusBlocks.DARK_OAK_HEDGE, BlockusBlocks.MANGROVE_HEDGE,
            BlockusBlocks.POTTED_OAK.block(), BlockusBlocks.POTTED_JUNGLE.block(), BlockusBlocks.POTTED_ACACIA.block(), BlockusBlocks.POTTED_DARK_OAK.block(), BlockusBlocks.POTTED_MANGROVE.block());
        BlockColorRegistry.register(List.of(BlockTintSources.grass()), BlockusBlocks.POTTED_LARGE_FERN.block());
        BlockColorRegistry.register(List.of(BlockTintSources.constant(-1), BlockTintSources.grass()), BlockusBlocks.RAINBOW_PETALS);

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
}

