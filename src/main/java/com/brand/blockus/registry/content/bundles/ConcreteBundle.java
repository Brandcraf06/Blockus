package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.BlockFactory;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.PillarBlock;

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

        this.block = BlockFactory.register(type, new Block(FabricBlockSettings.copyOf(base)));
        this.slab = BlockFactory.registerSlab(this.block);
        this.stairs = BlockFactory.registerStairs(this.block);
        this.wall = BlockFactory.registerWall(this.block);
        String replace = type.replace("_bricks", "");
        this.chiseled = BlockFactory.register("chiseled_" + replace, new Block(FabricBlockSettings.copyOf(base)));
        this.pillar = BlockFactory.register(replace + "_pillar", new PillarBlock(FabricBlockSettings.copyOf(base)));

        LIST.add(this);
    }


    public static ArrayList<ConcreteBundle> values() {
        return LIST;
    }
}
