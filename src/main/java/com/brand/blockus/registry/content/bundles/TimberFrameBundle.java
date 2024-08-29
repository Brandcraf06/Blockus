package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.OrientableBlockBase;
import com.brand.blockus.utils.BlockFactory;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.List;

public class TimberFrameBundle {

    private static final ArrayList<TimberFrameBundle> LIST = new ArrayList<>();

    public final Block block;
    public final Block diagonal;
    public final Block cross;
    public final Block lattice;
    public final Block grate;
    public final Block base;
    public final List<Block> all;
    public boolean burnable;

    public TimberFrameBundle(Block base) {
        this(base, true);
    }

    public TimberFrameBundle(Block base, boolean burnablee) {
        this.base = base;
        this.burnable = burnablee;
        String type = getWood(base);

        AbstractBlock.Settings blockSettings = AbstractBlock.Settings.copy(base);

        Item.Settings itemSettings = new Item.Settings();
        if (burnablee) {
            blockSettings = blockSettings.burnable();
        }

        this.block = register(type + "_timber_frame", new Block(blockSettings), itemSettings);
        this.diagonal = register(type + "_diagonal_timber_frame", new OrientableBlockBase(blockSettings), itemSettings);
        this.cross = register(type + "_cross_timber_frame", new Block(blockSettings), itemSettings);
        this.lattice = BlockFactory.register(type + "_lattice", new PaneBlock(AbstractBlock.Settings.copy(base)));
        this.grate = BlockFactory.register(type + "_grate", new GrateBlock(AbstractBlock.Settings.copy(base).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));
        this.all = List.of(block, diagonal, cross, lattice, grate);

        LIST.add(this);
    }

    public static Block register(String id, Block block, Item.Settings itemSettings) {
        return BlockFactory.register(id, block, new BlockItem(block, itemSettings));
    }

    public static String getWood(Block block) {
        return Registries.BLOCK.getId(block).getPath().replace("_planks", "");
    }

    public boolean isBurnable() {
        return this.burnable;
    }

    public static ArrayList<TimberFrameBundle> values() {
        return LIST;
    }
}
