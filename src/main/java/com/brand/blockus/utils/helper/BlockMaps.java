package com.brand.blockus.utils.helper;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BlockMaps {

    public static final Map<DyeColor, ColorData> COLOR_DATA;

    static {
        Map<DyeColor, ColorData> map = new EnumMap<>(DyeColor.class);
        for (DyeColor color : BlockOrder.COLOR) {
            map.put(color, new ColorData(
                getBlock(color, "_terracotta"),
                getBlock(color, "_glazed_terracotta"),
                getBlock(color, "_stained_glass"),
                getBlock(color, "_stained_glass_pane"),
                getBlock(color, "_concrete"),
                getBlock(color, "_wool"),
                getBlock(color, "_carpet")
            ));
        }
        COLOR_DATA = Map.copyOf(map);
    }

    public static final Map<DyeColor, Block> TERRACOTTA_MAP = extract(ColorData::terracotta);
    public static final Map<DyeColor, Block> GLAZED_TERRACOTTA_MAP = extract(ColorData::glazedTerracotta);
    public static final Map<DyeColor, Block> STAINED_GLASS_MAP = extract(ColorData::stainedGlass);
    public static final Map<DyeColor, Block> STAINED_GLASS_PANE_MAP = extract(ColorData::stainedGlassPane);
    public static final Map<DyeColor, Block> CONCRETE_MAP = extract(ColorData::concrete);
    public static final Map<DyeColor, Block> WOOL_MAP = extract(ColorData::wool);
    public static final Map<DyeColor, Block> CARPET_MAP = extract(ColorData::carpet);
    public static final Map<DyeColor, MapColor> COLOR_MAP = ImmutableMap.<DyeColor, MapColor>builder()
        .put(DyeColor.WHITE, MapColor.SNOW)
        .put(DyeColor.LIGHT_GRAY, MapColor.COLOR_LIGHT_GRAY)
        .put(DyeColor.GRAY, MapColor.COLOR_GRAY)
        .put(DyeColor.BLACK, MapColor.COLOR_BLACK)
        .put(DyeColor.BROWN, MapColor.COLOR_BROWN)
        .put(DyeColor.RED, MapColor.COLOR_RED)
        .put(DyeColor.ORANGE, MapColor.COLOR_ORANGE)
        .put(DyeColor.YELLOW, MapColor.COLOR_YELLOW)
        .put(DyeColor.LIME, MapColor.COLOR_LIGHT_GREEN)
        .put(DyeColor.GREEN, MapColor.COLOR_GREEN)
        .put(DyeColor.CYAN, MapColor.COLOR_CYAN)
        .put(DyeColor.LIGHT_BLUE, MapColor.COLOR_LIGHT_BLUE)
        .put(DyeColor.BLUE, MapColor.COLOR_BLUE)
        .put(DyeColor.PURPLE, MapColor.COLOR_PURPLE)
        .put(DyeColor.MAGENTA, MapColor.COLOR_MAGENTA)
        .put(DyeColor.PINK, MapColor.COLOR_PINK)
        .build();

    public static Block getBlock(DyeColor color, String suffix) {
        return BuiltInRegistries.BLOCK.getValue(ResourceLocation.withDefaultNamespace(color.name().toLowerCase() + suffix));
    }

    public static <T> Map<DyeColor, T> extract(Function<ColorData, T> mapper) {
        return COLOR_DATA.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> mapper.apply(entry.getValue())));
    }

    public record ColorData(
        Block terracotta,
        Block glazedTerracotta,
        Block stainedGlass,
        Block stainedGlassPane,
        Block concrete,
        Block wool,
        Block carpet
    ) {
    }
}
