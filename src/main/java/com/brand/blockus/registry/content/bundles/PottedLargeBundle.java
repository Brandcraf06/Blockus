package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public record PottedLargeBundle(Block block) {

    public static final List<PottedLargeBundle> LIST = new ArrayList<>();

    public static List<PottedLargeBundle> values() {
        return LIST;
    }

    public static PottedLargeBundle register(String type, Block plant) {
        PottedLargeBundle bundle = new PottedLargeBundle(BlockFactory.largePottedPlant(type, plant));
        LIST.add(bundle);
        return bundle;
    }
}
