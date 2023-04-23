package com.brand.blockus.content.types;

import com.brand.blockus.blocks.base.ColoredTilesBlock;
import com.brand.blockus.blocks.blockitems.ColoredTilesBlockItem;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
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
}
