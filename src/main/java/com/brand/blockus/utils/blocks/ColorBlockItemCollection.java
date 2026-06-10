package com.brand.blockus.utils.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;

public record ColorBlockItemCollection(ColorCollection<Block> blocks, ColorCollection<Item> items) {
}
