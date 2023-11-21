package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.FallingBlock;

public class SimpleFallingBlock extends FallingBlock {
    public static final MapCodec<SimpleFallingBlock> CODEC = createCodec(SimpleFallingBlock::new);

    public MapCodec<SimpleFallingBlock> getCodec() {
        return CODEC;
    }

    public SimpleFallingBlock(Settings settings) {
        super(settings);
    }

}
