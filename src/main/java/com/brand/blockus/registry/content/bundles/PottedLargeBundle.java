package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class PottedLargeBundle {
    private static final ArrayList<PottedLargeBundle> LIST = new ArrayList<>();

    public final Block block;

    public PottedLargeBundle(String type, Block plant) {

        this.block = BlockFactory.largePottedPlant(type, plant);

        LIST.add(this);
    }

    public static ArrayList<PottedLargeBundle> values() {
        return LIST;
    }
}
