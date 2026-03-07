package com.brand.blockus.datagen.models;

import net.minecraft.client.data.models.model.TextureSlot;

public final class BlockusTextureSlot {

    public static final TextureSlot TILE_1;
    public static final TextureSlot TILE_2;
    public static final TextureSlot LEAVES;
    public static final TextureSlot LOG;
    public static final TextureSlot LOG_TOP;
    public static final TextureSlot SOIL;

    static {
        TILE_1 = TextureSlot.create("tile_1");
        TILE_2 = TextureSlot.create("tile_2");
        LEAVES = TextureSlot.create("leaves");
        LOG = TextureSlot.create("log");
        LOG_TOP = TextureSlot.create("log_top");
        SOIL = TextureSlot.create("soil");
    }
}
