package com.brand.blockus.content.types;

import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.DyedCarpetBlock;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;

public class PatternWoolTypes {
    private static final ArrayList<PatternWoolTypes> LIST = new ArrayList<>();

    public final Block basewool;
    public final Block basecarpet;
    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block carpet;

    public PatternWoolTypes(Block base, Block base2, DyeColor dyecolor) {
        this.basewool = base;
        this.basecarpet = base2;

        String type = dyecolor.getName() + "_patterned_wool";
        this.block = BlocksRegistration.register(type, new Block(FabricBlockSettings.copyOf(base)));
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);
        this.carpet = BlocksRegistration.register(type.replace("wool", "carpet"), new DyedCarpetBlock(dyecolor, FabricBlockSettings.copyOf(base2)));


        LIST.add(this);
    }

    public static ArrayList<PatternWoolTypes> values() {
        return LIST;
    }
}
