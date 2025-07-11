package com.brand.blockus.utils;

public class BlockChecker {
    public static boolean isAmethyst(String baseId) {
        return baseId.contains("amethyst");
    }

    public static boolean isRedstone(String baseId) {
        return baseId.contains("redstone");
    }

    public static boolean isNetherite(String baseId) {
        return baseId.contains("netherite");
    }
}
