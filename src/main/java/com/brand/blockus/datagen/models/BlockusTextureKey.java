package com.brand.blockus.datagen.models;

import net.minecraft.data.client.TextureKey;

public final class BlockusTextureKey {

    public static final TextureKey TILE_1;
    public static final TextureKey TILE_2;
    public static final TextureKey HEDGE;

    static {
        TILE_1 = TextureKey.of("tile_1");
        TILE_2 = TextureKey.of("tile_2");
        HEDGE = TextureKey.of("hedge");
    }
}
