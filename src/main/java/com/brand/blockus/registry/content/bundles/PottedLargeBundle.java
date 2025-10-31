package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public record PottedLargeBundle(
    Block block
) {

    public static final List<PottedLargeBundle> LIST = new ArrayList<>();

    public static List<PottedLargeBundle> values() {
        return LIST;
    }

    public static Builder of(String type, Block plant) {
        return new Builder(type, plant);
    }

    public static class Builder {
        public final String type;
        public final Block plant;


        public Builder(String type, Block plant) {
            this.type = type;
            this.plant = plant;
        }

        public PottedLargeBundle register() {
            PottedLargeBundle bundle = new PottedLargeBundle(
                BlockFactory.largePottedPlant(type, plant)
            );
            LIST.add(bundle);
            return bundle;
        }
    }
}
