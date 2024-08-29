package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.ColoredTilesBlock;
import com.brand.blockus.utils.BlockFactory;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;

import java.util.ArrayList;

public class ColoredTilesBundle {
    private static final ArrayList<ColoredTilesBundle> LIST = new ArrayList<>();
    public final Block block;
    public final Block tile1;
    public final Block tile2;

    public ColoredTilesBundle(Block tile1, Block tile2) {

        String type = getColor(tile1) + "_" + getColor(tile2) + "_colored_tiles";

        this.block = BlockFactory.register(type, new ColoredTilesBlock(tile1, tile2, FabricBlockSettings.copyOf(tile2)));
        this.tile1 = tile1;
        this.tile2 = tile2;

        LIST.add(this);
    }

    public static String getColor(Block block) {
        return Registries.BLOCK.getId(block).getPath().replace("_concrete", "");
    }

    public static ArrayList<ColoredTilesBundle> values() {
        return LIST;
    }

    // Colored Tiles (WHITE)
    public static final ColoredTilesBundle WHITE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle WHITE_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle WHITE_BLACK_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.BLACK_CONCRETE);
    public static final ColoredTilesBundle WHITE_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle WHITE_RED_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.RED_CONCRETE);
    public static final ColoredTilesBundle WHITE_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle WHITE_YELLOW_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesBundle WHITE_LIME_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesBundle WHITE_GREEN_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesBundle WHITE_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle WHITE_LIGHT_BLUE_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
    public static final ColoredTilesBundle WHITE_BLUE_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.BLUE_CONCRETE);
    public static final ColoredTilesBundle WHITE_PURPLE_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesBundle WHITE_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesBundle WHITE_PINK_COLORED_TILES = new ColoredTilesBundle(Blocks.WHITE_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (BLACK)
    public static final ColoredTilesBundle BLACK_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle BLACK_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle BLACK_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle BLACK_RED_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.RED_CONCRETE);
    public static final ColoredTilesBundle BLACK_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle BLACK_YELLOW_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesBundle BLACK_LIME_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesBundle BLACK_GREEN_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesBundle BLACK_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle BLACK_LIGHT_BLUE_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
    public static final ColoredTilesBundle BLACK_BLUE_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.BLUE_CONCRETE);
    public static final ColoredTilesBundle BLACK_PURPLE_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesBundle BLACK_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesBundle BLACK_PINK_COLORED_TILES = new ColoredTilesBundle(Blocks.BLACK_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (RED)
    public static final ColoredTilesBundle RED_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle RED_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle RED_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle RED_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle RED_YELLOW_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesBundle RED_LIME_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesBundle RED_GREEN_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesBundle RED_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle RED_LIGHT_BLUE_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
    public static final ColoredTilesBundle RED_BLUE_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.BLUE_CONCRETE);
    public static final ColoredTilesBundle RED_PURPLE_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesBundle RED_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesBundle RED_PINK_COLORED_TILES = new ColoredTilesBundle(Blocks.RED_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (BLUE)
    public static final ColoredTilesBundle BLUE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle BLUE_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle BLUE_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle BLUE_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle BLUE_YELLOW_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesBundle BLUE_LIME_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesBundle BLUE_GREEN_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesBundle BLUE_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle BLUE_LIGHT_BLUE_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE);
    public static final ColoredTilesBundle BLUE_PURPLE_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesBundle BLUE_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesBundle BLUE_PINK_COLORED_TILES = new ColoredTilesBundle(Blocks.BLUE_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (LIGHT_BLUE)
    public static final ColoredTilesBundle LIGHT_BLUE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_YELLOW_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_LIME_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_GREEN_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.GREEN_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_PURPLE_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesBundle LIGHT_BLUE_PINK_COLORED_TILES = new ColoredTilesBundle(Blocks.LIGHT_BLUE_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (GREEN)
    public static final ColoredTilesBundle GREEN_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle GREEN_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle GREEN_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle GREEN_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle GREEN_YELLOW_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesBundle GREEN_LIME_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.LIME_CONCRETE);
    public static final ColoredTilesBundle GREEN_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle GREEN_PURPLE_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesBundle GREEN_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesBundle GREEN_PINK_COLORED_TILES = new ColoredTilesBundle(Blocks.GREEN_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (LIME)
    public static final ColoredTilesBundle LIME_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.LIME_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle LIME_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.LIME_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle LIME_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.LIME_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle LIME_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.LIME_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle LIME_YELLOW_COLORED_TILES = new ColoredTilesBundle(Blocks.LIME_CONCRETE, Blocks.YELLOW_CONCRETE);
    public static final ColoredTilesBundle LIME_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.LIME_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle LIME_PURPLE_COLORED_TILES = new ColoredTilesBundle(Blocks.LIME_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesBundle LIME_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.LIME_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesBundle LIME_PINK_COLORED_TILES = new ColoredTilesBundle(Blocks.LIME_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (YELLOW)
    public static final ColoredTilesBundle YELLOW_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.YELLOW_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle YELLOW_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.YELLOW_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle YELLOW_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.YELLOW_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle YELLOW_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.YELLOW_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle YELLOW_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.YELLOW_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle YELLOW_PURPLE_COLORED_TILES = new ColoredTilesBundle(Blocks.YELLOW_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesBundle YELLOW_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.YELLOW_CONCRETE, Blocks.MAGENTA_CONCRETE);
    public static final ColoredTilesBundle YELLOW_PINK_COLORED_TILES = new ColoredTilesBundle(Blocks.YELLOW_CONCRETE, Blocks.PINK_CONCRETE);

    // Colored Tiles (PINK)
    public static final ColoredTilesBundle PINK_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.PINK_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle PINK_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.PINK_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle PINK_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.PINK_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle PINK_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.PINK_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle PINK_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.PINK_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle PINK_PURPLE_COLORED_TILES = new ColoredTilesBundle(Blocks.PINK_CONCRETE, Blocks.PURPLE_CONCRETE);
    public static final ColoredTilesBundle PINK_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.PINK_CONCRETE, Blocks.MAGENTA_CONCRETE);

    // Colored Tiles (PURPLE)
    public static final ColoredTilesBundle PURPLE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.PURPLE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle PURPLE_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.PURPLE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle PURPLE_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.PURPLE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle PURPLE_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.PURPLE_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle PURPLE_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.PURPLE_CONCRETE, Blocks.CYAN_CONCRETE);
    public static final ColoredTilesBundle PURPLE_MAGENTA_COLORED_TILES = new ColoredTilesBundle(Blocks.PURPLE_CONCRETE, Blocks.MAGENTA_CONCRETE);

    // Colored Tiles (MAGENTA)
    public static final ColoredTilesBundle MAGENTA_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.MAGENTA_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle MAGENTA_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.MAGENTA_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle MAGENTA_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.MAGENTA_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle MAGENTA_ORANGE_COLORED_TILES = new ColoredTilesBundle(Blocks.MAGENTA_CONCRETE, Blocks.ORANGE_CONCRETE);
    public static final ColoredTilesBundle MAGENTA_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.MAGENTA_CONCRETE, Blocks.CYAN_CONCRETE);

    // Colored Tiles (ORANGE)
    public static final ColoredTilesBundle ORANGE_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.ORANGE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle ORANGE_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.ORANGE_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle ORANGE_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.ORANGE_CONCRETE, Blocks.BROWN_CONCRETE);
    public static final ColoredTilesBundle ORANGE_CYAN_COLORED_TILES = new ColoredTilesBundle(Blocks.ORANGE_CONCRETE, Blocks.CYAN_CONCRETE);

    // Colored Tiles (CYAN)
    public static final ColoredTilesBundle CYAN_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.CYAN_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle CYAN_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.CYAN_CONCRETE, Blocks.GRAY_CONCRETE);
    public static final ColoredTilesBundle CYAN_BROWN_COLORED_TILES = new ColoredTilesBundle(Blocks.CYAN_CONCRETE, Blocks.BROWN_CONCRETE);

    // Colored Tiles (BROWN)
    public static final ColoredTilesBundle BROWN_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.BROWN_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);
    public static final ColoredTilesBundle BROWN_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.BROWN_CONCRETE, Blocks.GRAY_CONCRETE);

    // Colored Tiles (GRAY)
    public static final ColoredTilesBundle GRAY_LIGHT_GRAY_COLORED_TILES = new ColoredTilesBundle(Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE);


}
