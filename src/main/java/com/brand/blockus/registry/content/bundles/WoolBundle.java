package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.BlockFactory;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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


        String type = dyecolor.getName() + typeSuffix;
        this.block = BlockFactory.register(type, new Block(FabricBlockSettings.copyOf(base)));
        this.slab = BlockFactory.registerSlab(this.block);
        this.stairs = BlockFactory.registerStairs(this.block);
        this.carpet = BlockFactory.register(type.replace("wool", "carpet"), new DyedCarpetBlock(dyecolor, FabricBlockSettings.copyOf(base2)));


        LIST.add(this);
    }

    public WoolBundle(Block base, Block base2, DyeColor dyecolor) {
        this(base, base2, dyecolor, PATTERNED);
    }

    public static ArrayList<WoolBundle> values() {
        return LIST;
    }

}
