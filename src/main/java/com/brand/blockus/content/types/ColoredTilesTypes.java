package com.brand.blockus.content.types;

import com.brand.blockus.blocks.base.ColoredTilesBlock;
import com.brand.blockus.blocks.blockitems.ColoredTilesBlockItem;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

import java.util.ArrayList;

public class ColoredTilesTypes {
    private static final ArrayList<ColoredTilesTypes> LIST = new ArrayList<>();
    public final Block block;
    public final Block tile1;
    public final Block tile2;

    public ColoredTilesTypes(Block tile1, Block tile2) {

        String type = getColor(tile1) + "_" + getColor(tile2) + "_colored_tiles";

        this.block = register(type, new ColoredTilesBlock(tile1, tile2, FabricBlockSettings.copyOf(tile2)), tile1, tile2);
        this.tile1 = tile1;
        this.tile2 = tile2;

        LIST.add(this);
    }

    public static String getColor(Block block) {
        return Registries.BLOCK.getId(block).getPath().replace("_concrete", "");
    }

    public static Block register(String id, Block block, Block tile1, Block tile2) {
        return BlocksRegistration.register(id, block, new ColoredTilesBlockItem(block, tile1, tile2, new Item.Settings()));
    }

    public static ArrayList<ColoredTilesTypes> values() {
        return LIST;
    }

    // Colored Tiles (WHITE)
    public static final ColoredTilesTypes WHITE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes WHITE_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes WHITE_BLACK_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.BLACK_CONCRETE);
    public static final ColoredTilesTypes WHITE_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes WHITE_RED_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.RED_CONCRETE);
    public static final ColoredTilesTypes WHITE_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes WHITE_YELLOW_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesTypes WHITE_LIME_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesTypes WHITE_GREEN_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesTypes WHITE_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes WHITE_LIGHT_BLUE_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
    public static final ColoredTilesTypes WHITE_BLUE_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.BLUE_CONCRETE);
    public static final ColoredTilesTypes WHITE_PURPLE_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesTypes WHITE_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesTypes WHITE_PINK_COLORED_TILES = new ColoredTilesTypes(Blocks.WHITE_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (BLACK)
    public static final ColoredTilesTypes BLACK_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes BLACK_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes BLACK_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes BLACK_RED_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.RED_CONCRETE);
    public static final ColoredTilesTypes BLACK_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes BLACK_YELLOW_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesTypes BLACK_LIME_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesTypes BLACK_GREEN_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesTypes BLACK_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes BLACK_LIGHT_BLUE_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
    public static final ColoredTilesTypes BLACK_BLUE_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.BLUE_CONCRETE);
    public static final ColoredTilesTypes BLACK_PURPLE_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesTypes BLACK_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesTypes BLACK_PINK_COLORED_TILES = new ColoredTilesTypes(Blocks.BLACK_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (RED)
    public static final ColoredTilesTypes RED_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes RED_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes RED_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes RED_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes RED_YELLOW_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesTypes RED_LIME_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesTypes RED_GREEN_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesTypes RED_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes RED_LIGHT_BLUE_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
    public static final ColoredTilesTypes RED_BLUE_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.BLUE_CONCRETE);
    public static final ColoredTilesTypes RED_PURPLE_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesTypes RED_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesTypes RED_PINK_COLORED_TILES = new ColoredTilesTypes(Blocks.RED_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (BLUE)
    public static final ColoredTilesTypes BLUE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes BLUE_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes BLUE_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes BLUE_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes BLUE_YELLOW_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesTypes BLUE_LIME_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesTypes BLUE_GREEN_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesTypes BLUE_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes BLUE_LIGHT_BLUE_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
    public static final ColoredTilesTypes BLUE_PURPLE_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesTypes BLUE_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesTypes BLUE_PINK_COLORED_TILES = new ColoredTilesTypes(Blocks.BLUE_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (LIGHT_BLUE)
    public static final ColoredTilesTypes LIGHT_BLUE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_YELLOW_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_LIME_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_GREEN_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_PURPLE_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesTypes LIGHT_BLUE_PINK_COLORED_TILES = new ColoredTilesTypes(Blocks.LIGHT_BLUE_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (GREEN)
    public static final ColoredTilesTypes GREEN_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes GREEN_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes GREEN_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes GREEN_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes GREEN_YELLOW_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesTypes GREEN_LIME_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesTypes GREEN_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes GREEN_PURPLE_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesTypes GREEN_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesTypes GREEN_PINK_COLORED_TILES = new ColoredTilesTypes(Blocks.GREEN_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (LIME)
    public static final ColoredTilesTypes LIME_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.LIME_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes LIME_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.LIME_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes LIME_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.LIME_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes LIME_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.LIME_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes LIME_YELLOW_COLORED_TILES = new ColoredTilesTypes(Blocks.LIME_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesTypes LIME_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.LIME_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes LIME_PURPLE_COLORED_TILES = new ColoredTilesTypes(Blocks.LIME_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesTypes LIME_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.LIME_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesTypes LIME_PINK_COLORED_TILES = new ColoredTilesTypes(Blocks.LIME_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (YELLOW)
    public static final ColoredTilesTypes YELLOW_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.YELLOW_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes YELLOW_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.YELLOW_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes YELLOW_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.YELLOW_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes YELLOW_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.YELLOW_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes YELLOW_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.YELLOW_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes YELLOW_PURPLE_COLORED_TILES = new ColoredTilesTypes(Blocks.YELLOW_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesTypes YELLOW_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.YELLOW_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesTypes YELLOW_PINK_COLORED_TILES = new ColoredTilesTypes(Blocks.YELLOW_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (PINK)
    public static final ColoredTilesTypes PINK_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.PINK_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes PINK_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.PINK_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes PINK_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.PINK_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes PINK_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.PINK_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes PINK_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.PINK_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes PINK_PURPLE_COLORED_TILES = new ColoredTilesTypes(Blocks.PINK_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesTypes PINK_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.PINK_CONCRETE, Blocks.MAGENTA_CONCRETE);

    // Colored Tiles (PURPLE)
    public static final ColoredTilesTypes PURPLE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.PURPLE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes PURPLE_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.PURPLE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes PURPLE_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.PURPLE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes PURPLE_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.PURPLE_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes PURPLE_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.PURPLE_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesTypes PURPLE_MAGENTA_COLORED_TILES = new ColoredTilesTypes(Blocks.PURPLE_CONCRETE, Blocks.MAGENTA_CONCRETE);

    // Colored Tiles (MAGENTA)
    public static final ColoredTilesTypes MAGENTA_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.MAGENTA_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes MAGENTA_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.MAGENTA_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes MAGENTA_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.MAGENTA_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes MAGENTA_ORANGE_COLORED_TILES = new ColoredTilesTypes(Blocks.MAGENTA_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesTypes MAGENTA_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.MAGENTA_CONCRETE, Blocks.CYAN_CONCRETE);

    // Colored Tiles (ORANGE)
    public static final ColoredTilesTypes ORANGE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.ORANGE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes ORANGE_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.ORANGE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes ORANGE_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.ORANGE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesTypes ORANGE_CYAN_COLORED_TILES = new ColoredTilesTypes(Blocks.ORANGE_CONCRETE, Blocks.CYAN_CONCRETE);

    // Colored Tiles (CYAN)
    public static final ColoredTilesTypes CYAN_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.CYAN_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes CYAN_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.CYAN_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesTypes CYAN_BROWN_COLORED_TILES = new ColoredTilesTypes(Blocks.CYAN_CONCRETE, Blocks.BROWN_CONCRETE);

    // Colored Tiles (BROWN)
    public static final ColoredTilesTypes BROWN_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.BROWN_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesTypes BROWN_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.BROWN_CONCRETE, Blocks.GRAY_CONCRETE);

    // Colored Tiles (GRAY)
    public static final ColoredTilesTypes GRAY_LIGHT_GRAY_COLORED_TILES = new ColoredTilesTypes(Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);









}
