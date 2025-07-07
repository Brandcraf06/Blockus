package com.brand.blockus.registry.content.bundles;

import net.minecraft.block.Block;
import net.minecraft.util.DyeColor;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public record StainedBlockBundle(Map<DyeColor, Block> colorMap) {

    public static StainedBlockBundle of(String id, BiFunction<String, DyeColor, Block> blockProvider) {
        Map<DyeColor, Block> map = new EnumMap<>(DyeColor.class);
        for (DyeColor color : DyeColor.values()) {
            map.put(color, blockProvider.apply(color.getId() + "_" + id, color));
        }
        return new StainedBlockBundle(Map.copyOf(map));
    }

    public static StainedBlockBundle of(Map<DyeColor, Block> baseBlockMap, Function<Block, Block> blockFactory) {
        Map<DyeColor, Block> map = new EnumMap<>(DyeColor.class);
        for (DyeColor color : DyeColor.values()) {
            map.put(color, blockFactory.apply(baseBlockMap.get(color)));
        }
        return new StainedBlockBundle(Map.copyOf(map));
    }

    public static StainedBlockBundle of(String id, Map<DyeColor, Block> baseBlockMap, BiFunction<String, Block, Block> blockFactory) {
        Map<DyeColor, Block> map = new EnumMap<>(DyeColor.class);
        for (DyeColor color : DyeColor.values()) {
            Block base = baseBlockMap.get(color);
            map.put(color, blockFactory.apply(color.getId() + "_" + id, base));
        }
        return new StainedBlockBundle(Map.copyOf(map));
    }

    public Block[] all() {
        return colorMap.values().toArray(Block[]::new);
    }

    public Block get(DyeColor color) {
        return colorMap.get(color);
    }
}
