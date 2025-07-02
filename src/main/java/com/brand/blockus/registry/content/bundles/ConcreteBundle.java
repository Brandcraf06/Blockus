package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class ConcreteBundle {
    private static final ArrayList<ConcreteBundle> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block wall;
    public final Block base;
    public final Block chiseled;
    public final Block pillar;

    public ConcreteBundle(String type, Block base) {

        this.base = base;

        this.block = BlockFactory.registerCopy(type, base);
        this.slab = BlockFactory.slab(this.block);
        this.stairs = BlockFactory.stairs(this.block);
        this.wall = BlockFactory.wall(this.block);
        String replace = type.replace("_bricks", "");
        this.chiseled = BlockFactory.registerCopy("chiseled_" + replace, base);
        this.pillar = BlockFactory.pillar2(replace + "_pillar", base);

        LIST.add(this);
    }


    public static ArrayList<ConcreteBundle> values() {
        return LIST;
    }
}
