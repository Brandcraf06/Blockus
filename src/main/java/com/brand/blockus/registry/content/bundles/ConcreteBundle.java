package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockBuilder;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public record ConcreteBundle(
    Block base,
    Block block,
    Block stairs,
    Block slab,
    Block wall,
    Block chiseled,
    Block pillar
) {

    public static final List<ConcreteBundle> LIST = new ArrayList<>();

    public static List<ConcreteBundle> values() {
        return LIST;
    }

    public static Builder of(String type, BlockBuilder blockBuilder) {
        return new Builder(type, blockBuilder);
    }

    public static Builder of(String type, Block base) {
        return new Builder(type, new BlockBuilder(base));
    }

    public List<Block> all() {
        return List.of(block, stairs, slab, wall, chiseled, pillar);
    }

    public static class Builder {
        public final String type;
        public final BlockBuilder blockBuilder;

        public Builder(String type, BlockBuilder blockBuilder) {
            this.type = type;
            this.blockBuilder = blockBuilder;
        }

        public ConcreteBundle register() {
            String removeBricks = type.replace("_bricks", "");
            Block base = blockBuilder.getBase();
            Block block = BlockFactory.registerCopy(type, base);
            ConcreteBundle bundle = new ConcreteBundle(
                base,
                block,
                BlockFactory.stairs(block),
                BlockFactory.slab(block),
                BlockFactory.wall(block),
                BlockFactory.registerCopy("chiseled_" + removeBricks, base),
                BlockFactory.pillar2(removeBricks + "_pillar", base)
            );
            LIST.add(bundle);
            return bundle;
        }
    }
}
