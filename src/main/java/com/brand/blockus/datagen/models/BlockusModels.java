package com.brand.blockus.datagen.models;

import com.brand.blockus.Blockus;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class BlockusModels {

    public static final ModelTemplate CUBE_TILES;
    public static final ModelTemplate CUBE_TILES_2;
    public static final ModelTemplate POST;
    public static final ModelTemplate POST_CONNECT;
    public static final ModelTemplate POST_CONNECT_TOP;
    public static final ModelTemplate CHAIN_CONNECT;
    public static final ModelTemplate HEDGE_NOSIDE;
    public static final ModelTemplate HEDGE_NOSIDE_ALT;
    public static final ModelTemplate HEDGE_POST;
    public static final ModelTemplate HEDGE_SIDE;
    public static final ModelTemplate HEDGE_SIDE_ALT;
    public static final ModelTemplate HEDGE_INVENTORY;
    public static final ModelTemplate BARRIER_POST;
    public static final ModelTemplate BARRIER_SIDE;
    public static final ModelTemplate BARRIER_INVENTORY;
    public static final ModelTemplate GATE_BOTTOM;
    public static final ModelTemplate GATE_BOTTOM_HINGE;
    public static final ModelTemplate GATE_TOP;
    public static final ModelTemplate GATE_TOP_HINGE;
    public static final ModelTemplate CRATE_TEMPLATE;
    public static final ModelTemplate NEON_BLOCK_TEMPLATE;


    public static Identifier getBlockId(String id) {
        return Blockus.id("block/" + id);
    }


    public static ModelTemplate create(String parent, TextureSlot... requiredTextures) {
        return new ModelTemplate(Optional.of(getBlockId(parent)), Optional.empty(), requiredTextures);
    }

    public static ModelTemplate create(String parent, String variant, TextureSlot... requiredTextures) {
        return new ModelTemplate(Optional.of(getBlockId(parent)), Optional.of(variant), requiredTextures);
    }

    static {
        CUBE_TILES = create("cube_tiles", "", BlockusTextureSlot.TILE_1, BlockusTextureSlot.TILE_2);
        CUBE_TILES_2 = create("cube_tiles_2", "_2", BlockusTextureSlot.TILE_1, BlockusTextureSlot.TILE_2);
        POST = create("template_post", TextureSlot.END, TextureSlot.SIDE);
        POST_CONNECT = create("template_post_connect", "_connect", TextureSlot.END, TextureSlot.SIDE);
        POST_CONNECT_TOP = create("template_post_connect_top", "_connect_top", TextureSlot.END, TextureSlot.SIDE);
        CHAIN_CONNECT = create("chain_connect", "_connect", TextureSlot.ALL);
        HEDGE_NOSIDE = create("template_hedge_noside", "_noside", TextureSlot.TEXTURE);
        HEDGE_NOSIDE_ALT = create("template_hedge_noside_alt", "_noside_alt", TextureSlot.TEXTURE);
        HEDGE_POST = create("template_hedge_post", "_post", TextureSlot.TEXTURE);
        HEDGE_SIDE = create("template_hedge_side", "_side", TextureSlot.TEXTURE);
        HEDGE_SIDE_ALT = create("template_hedge_side_alt", "_side_alt", TextureSlot.TEXTURE);
        HEDGE_INVENTORY = create("template_hedge_inventory", "_inventory", TextureSlot.TEXTURE);
        BARRIER_POST = create("template_barrier_post", "_post", TextureSlot.TEXTURE);
        BARRIER_SIDE = create("template_barrier_side", "_side", TextureSlot.TEXTURE);
        BARRIER_INVENTORY = create("template_barrier_inventory", "_inventory", TextureSlot.TEXTURE);
        GATE_BOTTOM = create("gate_bottom", "_bottom", TextureSlot.BOTTOM);
        GATE_BOTTOM_HINGE = create("gate_bottom_hinge", "_bottom_hinge", TextureSlot.BOTTOM);
        GATE_TOP = create("gate_top", "_top", TextureSlot.TOP);
        GATE_TOP_HINGE = create("gate_top_hinge", "_top_hinge", TextureSlot.TOP);
        CRATE_TEMPLATE = create("crate_template", TextureSlot.TOP, TextureSlot.SIDE);
        NEON_BLOCK_TEMPLATE = create("neon_block_template", TextureSlot.ALL);
    }
}
