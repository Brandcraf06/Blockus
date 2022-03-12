package com.brand.blockus.blocks.blockitems;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class GlintBlockItem extends BlockItem {

    public GlintBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
