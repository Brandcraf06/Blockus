package com.brand.blockus.data.provider;

import com.brand.blockus.content.types.ColoredTilesTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.Optional;

public class BlockusModelProvider extends FabricModelProvider {
    public static final Model CUBE_TILES;
    public static final Model CUBE_TILES_2;
    public static final TextureKey TILE_1 = TextureKey.of("tile_1");
    public static final TextureKey TILE_2 = TextureKey.of("tile_2");

    public BlockusModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {
        ArrayList<ColoredTilesTypes> var2 = ColoredTilesTypes.values();
        int var3 = var2.size();

        for(int var4 = 0; var4 < var3; ++var4) {
            ColoredTilesTypes coloredTilesTypes = var2.get(var4);
            registerColoredTiles(modelGenerator, coloredTilesTypes.block, coloredTilesTypes.tile1, coloredTilesTypes.tile2);
        }

    }

    public void generateItemModels(ItemModelGenerator modelGenerator) {
    }

    public static void registerColoredTiles(BlockStateModelGenerator modelGenerator, Block block, Block tile1, Block tile2) {
        TextureMap textures = getTextures(tile1, tile2);
        TextureMap textures2 = getTextures(tile1, tile2);
        CUBE_TILES.upload(block, textures, modelGenerator.modelCollector);
        CUBE_TILES_2.upload(block, textures2, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_AXIS).register(Direction.Axis.X, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(block))).register(Direction.Axis.Z, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_2")))));
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
