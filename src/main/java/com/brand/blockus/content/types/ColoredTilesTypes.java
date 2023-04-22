package com.brand.blockus.content.types;

import com.brand.blockus.blocks.base.ColoredTilesBlock;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;

import java.util.ArrayList;

public class ColoredTilesTypes {
    private static final ArrayList<ColoredTilesTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block tile1;
    public final Block tile2;
    public final String color1;
    public final String color2;

    public ColoredTilesTypes(Block tile1, Block tile2) {
        String color1 = Registries.BLOCK.getId(tile1).getPath().replace("_concrete", "");
        String color2 = Registries.BLOCK.getId(tile2).getPath().replace("_concrete", "");

        String type = color1 + "_" + color2 + "_colored_tiles";

        this.block = BlocksRegistration.register(type, new ColoredTilesBlock(tile1, tile2, FabricBlockSettings.copyOf(tile2)));
        this.tile1 = tile1;
        this.tile2 = tile2;
        this.color1 = color1;
        this.color2 = color2;

        LIST.add(this);
    }

    public static ArrayList<ColoredTilesTypes> values() {
        return LIST;
    }
}
