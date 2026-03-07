package com.brand.blockus.blocks.base;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

public class ColoredTilesBlock extends HorizontalAxisBlock {

    public final Block tile1;
    public final Block tile2;

    public ColoredTilesBlock(Block tile1, Block tile2, Properties properties) {
        super(properties);
        this.tile1 = tile1;
        this.tile2 = tile2;
    }

    public static String getColor(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath().replace("_concrete", "");
    }
}

