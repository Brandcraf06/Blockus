package com.brand.blockus.datagen.models;

import com.brand.blockus.Blockus;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class BlockusModels {

    public static final Model CUBE_TILES;
    public static final Model CUBE_TILES_2;
    public static final Model TEMPLATE_POST;
    public static final Model TEMPLATE_POST_CONNECT;
    public static final Model TEMPLATE_POST_CONNECT_TOP;
    public static final Model CHAIN_CONNECT;
    public static final Model TEMPLATE_SMALL_HEDGE_END;
    public static final Model TEMPLATE_SMALL_HEDGE_SIDE;
    public static final Model TEMPLATE_SMALL_HEDGE_SIDE_TALL;
    public static final Model TEMPLATE_SMALL_HEDGE_INVENTORY;
    public static final Model CRATE_TEMPLATE;
    public static final Model NEON_BLOCK_TEMPLATE;


    public static Identifier getBlockId(String id) {
        return Blockus.id("block/" + id);
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
        TEMPLATE_POST = createModel("template_post", TextureKey.END, TextureKey.SIDE);
        TEMPLATE_POST_CONNECT = createModel("template_post_connect", "_connect", TextureKey.END, TextureKey.SIDE);
        TEMPLATE_POST_CONNECT_TOP = createModel("template_post_connect_top", "_connect_top", TextureKey.END, TextureKey.SIDE);
        CHAIN_CONNECT = createModel("chain_connect", "_connect", TextureKey.ALL);
        TEMPLATE_SMALL_HEDGE_END = createModel("template_small_hedge_end", "_end", BlockusTextureKey.HEDGE);
        TEMPLATE_SMALL_HEDGE_SIDE = createModel("template_small_hedge_side", "_side", BlockusTextureKey.HEDGE);
        TEMPLATE_SMALL_HEDGE_SIDE_TALL = createModel("template_small_hedge_side_tall", "_side_tall", BlockusTextureKey.HEDGE);
        TEMPLATE_SMALL_HEDGE_INVENTORY = createModel("template_small_hedge_inventory", "_inventory", BlockusTextureKey.HEDGE);
        CRATE_TEMPLATE = createModel("crate_template", TextureKey.TOP, TextureKey.SIDE);
        NEON_BLOCK_TEMPLATE = createModel("neon_block_template", TextureKey.ALL);
    }
}
