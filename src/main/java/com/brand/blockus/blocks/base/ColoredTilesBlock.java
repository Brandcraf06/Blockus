package com.brand.blockus.blocks.base;

import net.minecraft.block.Block;

public class ColoredTilesBlock extends HorizontalAxisBlockBase {

    public final Block tile1;
    public final Block tile2;

    public ColoredTilesBlock(Block tile1, Block tile2, Settings settings) {
        super(settings);
        this.tile1 = tile1;
        this.tile2 = tile2;
    }
}

