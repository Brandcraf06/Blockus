package com.brand.blockus.utils.helper;

import net.minecraft.world.item.DyeColor;

import java.util.List;

public class BlockOrder {
    public static final List<DyeColor> COLOR = List.of(
        DyeColor.WHITE, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.BLACK,
        DyeColor.BROWN, DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW,
        DyeColor.LIME, DyeColor.GREEN, DyeColor.CYAN, DyeColor.LIGHT_BLUE,
        DyeColor.BLUE, DyeColor.PURPLE, DyeColor.MAGENTA, DyeColor.PINK
    );

    public static final WoodMaps[] WOOD = {
        WoodMaps.OAK, WoodMaps.SPRUCE, WoodMaps.BIRCH, WoodMaps.JUNGLE,
        WoodMaps.ACACIA, WoodMaps.DARK_OAK, WoodMaps.MANGROVE, WoodMaps.CHERRY,
        WoodMaps.PALE_OAK, WoodMaps.BAMBOO, WoodMaps.RAW_BAMBOO, WoodMaps.POPLAR, WoodMaps.WHITE_OAK,
        WoodMaps.CRIMSON, WoodMaps.WARPED, WoodMaps.CHARRED
    };
}
