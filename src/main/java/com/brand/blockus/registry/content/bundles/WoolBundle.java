package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.Block;
import net.minecraft.block.DyedCarpetBlock;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;

public class WoolBundle {
    private static final ArrayList<WoolBundle> LIST = new ArrayList<>();
    public static final String PATTERNED = "_patterned_wool";
    public static final String GINGHAM = "_gingham_wool";
    public final Block basewool;
    public final Block basecarpet;
    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block carpet;
    public String typeSuffix;

    public WoolBundle(Block base, Block base2, DyeColor dyecolor, String typeSuffix) {
        this.basewool = base;
        this.basecarpet = base2;
        this.typeSuffix = typeSuffix;


        String type = dyecolor.getId() + typeSuffix;
        this.block = BlockFactory.registerCopy(type, base);
        this.slab = BlockFactory.slab(this.block);
        this.stairs = BlockFactory.stairs(this.block);
        this.carpet = BlockFactory.registerCopy(type.replace("wool", "carpet"), (settings) -> new DyedCarpetBlock(dyecolor, settings), base2);


        LIST.add(this);
    }

    public WoolBundle(Block base, Block base2, DyeColor dyecolor) {
        this(base, base2, dyecolor, PATTERNED);
    }

    public static ArrayList<WoolBundle> values() {
        return LIST;
    }

}
