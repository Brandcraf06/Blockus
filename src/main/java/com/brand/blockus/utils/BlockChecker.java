package com.brand.blockus.utils;

import java.util.List;
import java.util.stream.Stream;

public class BlockChecker {

    public static final List<String> FLAMMABLE_WOODS = List.of("oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "cherry", "mangrove", "bamboo", "raw_bamboo", "white_oak");
    public static final List<String> NON_FLAMMABLE_WOODS = List.of("warped", "crimson", "charred");
    public static final List<String> WOODS = Stream.concat(FLAMMABLE_WOODS.stream(), NON_FLAMMABLE_WOODS.stream()).toList();

    public static boolean isWoodenMosaic(String type, List<String> types) {
        return types.stream().anyMatch(t -> type.equals(t + "_mosaic"));
    }

    public static boolean isMossyPlanks(String type, List<String> types) {
        return types.stream().anyMatch(t -> type.equals("mossy_" + t + "_planks"));
    }

    public static boolean isUnwaxedCopper(String baseid) {
        return baseid.contains("copper") && !baseid.contains("waxed");
    }

    public static boolean isAmethyst(String baseid) {
        return baseid.contains("amethyst");
    }

    public static boolean isRedstone(String baseid) {
        return baseid.contains("redstone");
    }

    public static boolean isNetherite(String baseid) {
        return baseid.contains("netherite");
    }
}
