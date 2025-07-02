package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.OrientableBlockBase;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.*;
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

    public TimberFrameBundle(Block base, boolean burnable) {
        this.base = base;
        this.burnable = burnable;
        String type = getWood(base);

        AbstractBlock.Settings blockSettings = BlockFactory.createCopy(base);

        if (burnable) {
            blockSettings = blockSettings.burnable();
        }

        this.block = BlockFactory.registerOf(type + "_timber_frame", blockSettings);
        this.diagonal = BlockFactory.registerOf(type + "_diagonal_timber_frame", OrientableBlockBase::new, blockSettings);
        this.cross = BlockFactory.registerOf(type + "_cross_timber_frame", blockSettings);
        this.lattice = BlockFactory.registerCopy(type + "_lattice", PaneBlock::new, base);
        this.grate = BlockFactory.registerCopy(type + "_grate", GrateBlock::new, base, settings -> settings.nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never));
        this.all = List.of(block, diagonal, cross, lattice, grate);

        LIST.add(this);
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
