package com.brand.blockus.content.types;

import net.minecraft.block.*;
import com.brand.blockus.blocks.base.GrateBlock;
import com.brand.blockus.blocks.base.OrientableBlockBase;
import com.brand.blockus.content.BlocksRegistration;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.List;

public class TimberFrameTypes {

    private static final ArrayList<TimberFrameTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block diagonal;
    public final Block cross;
    public final Block lattice;
    public final Block grate;
    public final Block base;
    public final List<Block> all;

    public TimberFrameTypes(Block base) {
        this(base, false);
    }

    public TimberFrameTypes(Block base, boolean fireproof) {

        this.base = base;
        String type = getWood(base);

        AbstractBlock.Settings blockSettings = AbstractBlock.Settings.copy(base);

        Item.Settings itemSettings = new Item.Settings();
        if (fireproof) {
            itemSettings = itemSettings.fireproof();
        }

        this.block = register(type + "_timber_frame", new Block(blockSettings), itemSettings);
        this.diagonal = register(type + "_diagonal_timber_frame", new OrientableBlockBase(blockSettings), itemSettings);
        this.cross = register(type + "_cross_timber_frame", new Block(blockSettings), itemSettings);
        this.lattice = BlocksRegistration.register(type + "_lattice", new PaneBlock(AbstractBlock.Settings.copy(base)));
        this.grate = BlocksRegistration.register(type + "_grate", new GrateBlock(AbstractBlock.Settings.copy(base).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));
        this.all = List.of(block, diagonal, cross, lattice, grate);

        LIST.add(this);
    }

    public static Block register(String id, Block block, Item.Settings itemSettings) {
        return BlocksRegistration.register(id, block, new BlockItem(block, itemSettings));
    }

    public static String getWood(Block block) {
        return Registries.BLOCK.getId(block).getPath().replace("_planks", "");
    }

    public static ArrayList<TimberFrameTypes> values() {
        return LIST;
    }
}
