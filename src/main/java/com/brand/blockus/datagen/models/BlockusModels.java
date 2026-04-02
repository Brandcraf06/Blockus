package com.brand.blockus.datagen.models;

import com.brand.blockus.Blockus;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class BlockusModels {

    public static final ModelTemplate CUBE_TILES;
    public static final ModelTemplate CUBE_TILES_2;
    public static final ModelTemplate TEMPLATE_POST;
    public static final ModelTemplate TEMPLATE_POST_CONNECT;
    public static final ModelTemplate TEMPLATE_POST_CONNECT_TOP;
    public static final ModelTemplate CHAIN_CONNECT;
    public static final ModelTemplate TEMPLATE_HEDGE_NOSIDE;
    public static final ModelTemplate TEMPLATE_HEDGE_NOSIDE_ALT;
    public static final ModelTemplate TEMPLATE_HEDGE_POST;
    public static final ModelTemplate TEMPLATE_HEDGE_SIDE;
    public static final ModelTemplate TEMPLATE_HEDGE_SIDE_ALT;
    public static final ModelTemplate TEMPLATE_HEDGE_INVENTORY;
    public static final ModelTemplate GATE_BOTTOM;
    public static final ModelTemplate GATE_BOTTOM_HINGE;
    public static final ModelTemplate GATE_TOP;
    public static final ModelTemplate GATE_TOP_HINGE;
    public static final ModelTemplate CRATE_TEMPLATE;
    public static final ModelTemplate NEON_BLOCK_TEMPLATE;


    public static Identifier getBlockId(String id) {
        return Blockus.id("block/" + id);
    }


    public static ModelTemplate createModel(String parent, TextureSlot... requiredTextures) {
        return new ModelTemplate(Optional.of(getBlockId(parent)), Optional.empty(), requiredTextures);
    }

    public static ModelTemplate createModel(String parent, String variant, TextureSlot... requiredTextures) {
        return new ModelTemplate(Optional.of(getBlockId(parent)), Optional.of(variant), requiredTextures);
    }


    static {
        CUBE_TILES = createModel("cube_tiles", "", BlockusTextureKey.TILE_1, BlockusTextureKey.TILE_2);
        CUBE_TILES_2 = createModel("cube_tiles_2", "_2", BlockusTextureKey.TILE_1, BlockusTextureKey.TILE_2);
        TEMPLATE_POST = createModel("template_post", TextureSlot.END, TextureSlot.SIDE);
        TEMPLATE_POST_CONNECT = createModel("template_post_connect", "_connect", TextureSlot.END, TextureSlot.SIDE);
        TEMPLATE_POST_CONNECT_TOP = createModel("template_post_connect_top", "_connect_top", TextureSlot.END, TextureSlot.SIDE);
        CHAIN_CONNECT = createModel("chain_connect", "_connect", TextureSlot.ALL);
        TEMPLATE_HEDGE_NOSIDE = createModel("template_hedge_noside", "_noside", TextureSlot.TEXTURE);
        TEMPLATE_HEDGE_NOSIDE_ALT = createModel("template_hedge_noside_alt", "_noside_alt", TextureSlot.TEXTURE);
        TEMPLATE_HEDGE_POST = createModel("template_hedge_post", "_post", TextureSlot.TEXTURE);
        TEMPLATE_HEDGE_SIDE = createModel("template_hedge_side", "_side", TextureSlot.TEXTURE);
        TEMPLATE_HEDGE_SIDE_ALT = createModel("template_hedge_side_alt", "_side_alt", TextureSlot.TEXTURE);
        TEMPLATE_HEDGE_INVENTORY = createModel("template_hedge_inventory", "_inventory", TextureSlot.TEXTURE);
        GATE_BOTTOM = createModel("gate_bottom", "_bottom", TextureSlot.BOTTOM);
        GATE_BOTTOM_HINGE = createModel("gate_bottom_hinge", "_bottom_hinge", TextureSlot.BOTTOM);
        GATE_TOP = createModel("gate_top", "_top", TextureSlot.TOP);
        GATE_TOP_HINGE = createModel("gate_top_hinge", "_top_hinge", TextureSlot.TOP);
        CRATE_TEMPLATE = createModel("crate_template", TextureSlot.TOP, TextureSlot.SIDE);
        NEON_BLOCK_TEMPLATE = createModel("neon_block_template", TextureSlot.ALL);
    }
}
