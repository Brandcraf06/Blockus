package com.brand.blockus.data.models;

import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class BlockusModels {

    public static final Model CUBE_TILES;
    public static final Model CUBE_TILES_2;
    public static final Model TEMPLATE_SMALL_HEDGE_END;
    public static final Model TEMPLATE_SMALL_HEDGE_SIDE;
    public static final Model TEMPLATE_SMALL_HEDGE_SIDE_TALL;
    public static final Model TEMPLATE_SMALL_HEDGE_INVENTORY;

    public static Identifier getBlockId(String id) {
        return new Identifier("blockus", "block/" + id);
    }

    public static Model createModel(String parent, TextureKey... requiredTextures) {
        return new Model(Optional.of(getBlockId(parent)), Optional.empty(), requiredTextures);
    }

    public static Model createModel(String parent, String variant, TextureKey... requiredTextures) {
        return new Model(Optional.of(getBlockId(parent)), Optional.of(variant), requiredTextures);
    }

    static {
        CUBE_TILES = createModel("cube_tiles", "", BlockusTextureKey.TILE_1, BlockusTextureKey.TILE_2);
        CUBE_TILES_2 = createModel("cube_tiles_2", "_2", BlockusTextureKey.TILE_1, BlockusTextureKey.TILE_2);
        TEMPLATE_SMALL_HEDGE_END = createModel("template_small_hedge_end", "_end", BlockusTextureKey.HEDGE);
        TEMPLATE_SMALL_HEDGE_SIDE = createModel("template_small_hedge_side", "_side", BlockusTextureKey.HEDGE);
        TEMPLATE_SMALL_HEDGE_SIDE_TALL = createModel("template_small_hedge_side_tall", "_side_tall", BlockusTextureKey.HEDGE);
        TEMPLATE_SMALL_HEDGE_INVENTORY = createModel("template_small_hedge_inventory", "_inventory", BlockusTextureKey.HEDGE);
    }
}
