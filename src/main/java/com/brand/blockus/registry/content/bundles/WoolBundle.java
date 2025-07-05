package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.Block;
import net.minecraft.block.DyedCarpetBlock;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;
import java.util.List;

public record WoolBundle(
    String typeSuffix,
    Block basewool,
    Block basecarpet,
    Block block,
    Block stairs,
    Block slab,
    Block carpet
) {

    public static final List<WoolBundle> LIST = new ArrayList<>();
    public static final String PATTERNED = "_patterned_wool";
    public static final String GINGHAM = "_gingham_wool";

    public static List<WoolBundle> values() {
        return LIST;
    }

    public static Builder of(Block base, Block base2, DyeColor color, String typeSuffix) {
        return new Builder(base, base2, color, typeSuffix);
    }

    public static Builder of(Block base, Block base2, DyeColor color) {
        return new Builder(base, base2, color, PATTERNED);
    }

    public List<Block> all() {
        return List.of(block, stairs, slab, carpet);
    }

    public static class Builder {
        public final Block baseWool;
        public final Block baseCarpet;
        public final DyeColor color;
        public String typeSuffix;

        public Builder(Block base, Block base2, DyeColor color, String typeSuffix) {
            this.baseWool = base;
            this.baseCarpet = base2;
            this.typeSuffix = typeSuffix;
            this.color = color;
        }

        public WoolBundle register() {
            String type = color.getId() + typeSuffix;
            Block block = BlockFactory.registerCopy(type, baseWool);
            WoolBundle bundle = new WoolBundle(typeSuffix, baseWool, baseCarpet,
                block,
                BlockFactory.stairs(block),
                BlockFactory.slab(block),
                BlockFactory.registerCopy(type.replace("wool", "carpet"), (settings) -> new DyedCarpetBlock(color, settings), baseCarpet)
            );
            LIST.add(bundle);
            return bundle;
        }
    }
}
