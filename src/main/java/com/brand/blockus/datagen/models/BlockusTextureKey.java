package com.brand.blockus.datagen.models;

import net.minecraft.data.models.model.TextureSlot;

public final class BlockusTextureKey {

    public static final TextureSlot TILE_1;
    public static final TextureSlot TILE_2;

    static {
        TILE_1 = TextureSlot.create("tile_1");
        TILE_2 = TextureSlot.create("tile_2");
    }
}
