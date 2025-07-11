package com.brand.blockus.registry.content.bundles;

import net.minecraft.block.Block;
import net.minecraft.util.DyeColor;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public record StainedBlockBundle(Map<DyeColor, Block> colorMap) {

    public static StainedBlockBundle of(String id, BiFunction<String, DyeColor, Block> blockProvider) {
        Map<DyeColor, Block> colorMap = new EnumMap<>(DyeColor.class);
        for (DyeColor color : DyeColor.values()) {
            colorMap.put(color, blockProvider.apply(color.getName() + "_" + id, color));
        }
        return new StainedBlockBundle(Map.copyOf(colorMap));
    }

    public static StainedBlockBundle of(Map<DyeColor, Block> baseBlockColorMap, Function<Block, Block> blockFactory) {
        Map<DyeColor, Block> colorMap = new EnumMap<>(DyeColor.class);
        for (DyeColor color : DyeColor.values()) {
            colorMap.put(color, blockFactory.apply(baseBlockColorMap.get(color)));
        }
        return new StainedBlockBundle(Map.copyOf(colorMap));
    }

    public static StainedBlockBundle of(String id, Map<DyeColor, Block> baseBlockColorMap, BiFunction<String, Block, Block> blockFactory) {
        Map<DyeColor, Block> colorMap = new EnumMap<>(DyeColor.class);
        for (DyeColor color : DyeColor.values()) {
            colorMap.put(color, blockFactory.apply(color.getName() + "_" + id, baseBlockColorMap.get(color)));
        }
        return new StainedBlockBundle(Map.copyOf(colorMap));
    }

    public Block[] all() {
        return colorMap.values().toArray(Block[]::new);
    }

    public Block get(DyeColor color) {
        return colorMap.get(color);
    }
}
