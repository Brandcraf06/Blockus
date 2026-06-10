package com.brand.blockus.utils.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopperCollection;

public record CopperBlockItemCollection(WeatheringCopperCollection<Block> blocks,
                                        WeatheringCopperCollection<Item> items) {
}
