package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.BlockFactory;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class PottedLargeBundle {
    private static final ArrayList<PottedLargeBundle> LIST = new ArrayList<>();

    public final Block block;

    public PottedLargeBundle(String type, Block plant) {

        this.block = BlockFactory.registerNoItem(type, BlockFactory.createLargeFlowerPot(plant));

        LIST.add(this);
    }

    public static ArrayList<PottedLargeBundle> values() {
        return LIST;
    }
}
