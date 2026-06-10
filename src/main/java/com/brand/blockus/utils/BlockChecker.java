package com.brand.blockus.utils;

import com.brand.blockus.utils.references.BlockusIds;

public class BlockChecker {

    public static <T> boolean isAmethyst(String id) {
        return BlockusIds.create(id).toString().contains("amethyst");
    }

    public static <T> boolean isRedstone(String id) {
        return BlockusIds.create(id).toString().contains("redstone");
    }

    public static <T> boolean isNetherite(String id) {
        return BlockusIds.create(id).toString().contains("netherite");
    }
}
