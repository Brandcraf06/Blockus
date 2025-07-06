package com.brand.blockus.utils.helper;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.util.DyeColor;

import java.util.Map;

public class BlockMaps {
    public static final Map<DyeColor, Block> TERRACOTTA_MAP = ImmutableMap.<DyeColor, Block>builder()
        .put(DyeColor.WHITE, Blocks.WHITE_TERRACOTTA)
        .put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_TERRACOTTA)
        .put(DyeColor.GRAY, Blocks.GRAY_TERRACOTTA)
        .put(DyeColor.BLACK, Blocks.BLACK_TERRACOTTA)
        .put(DyeColor.BROWN, Blocks.BROWN_TERRACOTTA)
        .put(DyeColor.RED, Blocks.RED_TERRACOTTA)
        .put(DyeColor.ORANGE, Blocks.ORANGE_TERRACOTTA)
        .put(DyeColor.YELLOW, Blocks.YELLOW_TERRACOTTA)
        .put(DyeColor.LIME, Blocks.LIME_TERRACOTTA)
        .put(DyeColor.GREEN, Blocks.GREEN_TERRACOTTA)
        .put(DyeColor.CYAN, Blocks.CYAN_TERRACOTTA)
        .put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_TERRACOTTA)
        .put(DyeColor.BLUE, Blocks.BLUE_TERRACOTTA)
        .put(DyeColor.PURPLE, Blocks.PURPLE_TERRACOTTA)
        .put(DyeColor.MAGENTA, Blocks.MAGENTA_TERRACOTTA)
        .put(DyeColor.PINK, Blocks.PINK_TERRACOTTA)
        .build();

    public static final Map<DyeColor, MapColor> COLOR_MAP = ImmutableMap.<DyeColor, MapColor>builder()
        .put(DyeColor.WHITE, MapColor.WHITE)
        .put(DyeColor.LIGHT_GRAY, MapColor.LIGHT_GRAY)
        .put(DyeColor.GRAY, MapColor.GRAY)
        .put(DyeColor.BLACK, MapColor.BLACK)
        .put(DyeColor.BROWN, MapColor.BROWN)
        .put(DyeColor.RED, MapColor.RED)
        .put(DyeColor.ORANGE, MapColor.ORANGE)
        .put(DyeColor.YELLOW, MapColor.YELLOW)
        .put(DyeColor.LIME, MapColor.LIME)
        .put(DyeColor.GREEN, MapColor.GREEN)
        .put(DyeColor.CYAN, MapColor.CYAN)
        .put(DyeColor.LIGHT_BLUE, MapColor.LIGHT_BLUE)
        .put(DyeColor.BLUE, MapColor.BLUE)
        .put(DyeColor.PURPLE, MapColor.PURPLE)
        .put(DyeColor.MAGENTA, MapColor.MAGENTA)
        .put(DyeColor.PINK, MapColor.PINK)
        .build();
}
