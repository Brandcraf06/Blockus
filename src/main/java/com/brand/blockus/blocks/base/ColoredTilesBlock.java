package com.brand.blockus.blocks.base;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Util;

public class ColoredTilesBlock extends HorizontalAxisBlock {

    public final Block tile1;
    public final Block tile2;

    public ColoredTilesBlock(Block tile1, Block tile2, Settings settings) {
        super(settings.overrideTranslationKey(Util.createTranslationKey("block", Blockus.id("colored_tiles"))));
        this.tile1 = tile1;
        this.tile2 = tile2;
    }

    public static String getColor(Block block) {
        return Registries.BLOCK.getId(block).getPath().replace("_concrete", "");
    }
}

