package com.brand.blockus.content.types;

import com.brand.blockus.blocks.base.OrientableBlockBase;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class TimberFrameTypes {

    private static final ArrayList<TimberFrameTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block diagonal;
    public final Block cross;
    public final Block base;

    public TimberFrameTypes(String type, Block base) {
        this(type, base, false);
    }

    public TimberFrameTypes(String type, Block base, boolean fireproof) {

        this.base = base;

        AbstractBlock.Settings blockSettings = AbstractBlock.Settings.copy(base);

        Item.Settings itemSettings = new Item.Settings();
        if (fireproof) {
            itemSettings = itemSettings.fireproof();
        }

        this.block = register(type + "_timber_frame", new Block(blockSettings), itemSettings);
        this.diagonal = register(type + "_diagonal_timber_frame", new OrientableBlockBase(blockSettings), itemSettings);
        this.cross = register(type + "_cross_timber_frame", new Block(blockSettings), itemSettings);

        LIST.add(this);
    }

    public static Block register(String id, Block block, Item.Settings itemSettings) {
        return BlocksRegistration.register(id, block, new BlockItem(block, itemSettings));
    }

    public static ArrayList<TimberFrameTypes> values() {
        return LIST;
    }
}
