package com.brand.blockus.data.providers;

import com.brand.blockus.content.types.ColoredTilesTypes;
import com.brand.blockus.content.types.TimberFrameTypesF;
import com.brand.blockus.content.types.TimberFrameTypesFP;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class BlockusModelProvider extends FabricModelProvider {
    public static final Model CUBE_TILES;
    public static final Model CUBE_TILES_2;
    public static final TextureKey TILE_1 = TextureKey.of("tile_1");
    public static final TextureKey TILE_2 = TextureKey.of("tile_2");

    public BlockusModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {

        for (TimberFrameTypesF timberFrameType : TimberFrameTypesF.values()) {
            modelGenerator.registerSimpleCubeAll(timberFrameType.block);
            modelGenerator.registerSimpleCubeAll(timberFrameType.cross);
            this.registerDiagonalTimberFrame(modelGenerator, timberFrameType.diagonal);
        }

        for (TimberFrameTypesFP timberFrameType : TimberFrameTypesFP.values()) {
            modelGenerator.registerSimpleCubeAll(timberFrameType.block);
            modelGenerator.registerSimpleCubeAll(timberFrameType.cross);
            this.registerDiagonalTimberFrame(modelGenerator, timberFrameType.diagonal);
        }

        for (ColoredTilesTypes coloredTilesTypes : ColoredTilesTypes.values()) {
            registerColoredTiles(modelGenerator, coloredTilesTypes.block, coloredTilesTypes.tile1, coloredTilesTypes.tile2);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator modelGenerator) {
    }

    private void registerDiagonalTimberFrame(BlockStateModelGenerator modelGenerator, Block block) {
        Identifier identifier = ModelIds.getBlockModelId(block);
        Identifier identifier2 = TextureMap.getSubId(block, "_right");
        Identifier identifier3 = TextureMap.getSubId(block, "_left");
        TextureMap textureMap = (new TextureMap()).put(TextureKey.PARTICLE, identifier2).put(TextureKey.NORTH, identifier2).put(TextureKey.SOUTH, identifier2).put(TextureKey.EAST, identifier2).put(TextureKey.WEST, identifier3).put(TextureKey.DOWN, identifier3).put(TextureKey.UP, identifier3);
        Models.CUBE.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
            .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
            .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R180))
            .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R270))
            .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R90))));
    }


    public static void registerColoredTiles(BlockStateModelGenerator modelGenerator, Block block, Block tile1, Block tile2) {
        TextureMap textures = getTextures(tile1, tile2);
        CUBE_TILES.upload(block, textures, modelGenerator.modelCollector);
        CUBE_TILES_2.upload(block, textures, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_AXIS)
            .register(Direction.Axis.X, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(block)))
            .register(Direction.Axis.Z, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_2")))));
    }

    private static TextureMap getTextures(Block tile1, Block tile2) {
        return (new TextureMap()).put(TILE_1, getId(tile1)).put(TILE_2, getId(tile2));
    }


    public static Identifier getId(Block block) {
        Identifier identifier = Registries.BLOCK.getId(block);
        return new Identifier("blockus", "block/" + identifier.getPath().replace("_concrete", "_tiles"));
    }

    private static Model createModel(String parent, String variant, TextureKey... requiredTextures) {
        return new Model(Optional.of(new Identifier("blockus", "block/" + parent)), Optional.of(variant), requiredTextures);
    }

    static {
        CUBE_TILES = createModel("cube_tiles", "", TILE_1, TILE_2);
        CUBE_TILES_2 = createModel("cube_tiles_2", "_2", TILE_1, TILE_2);
    }
}
