package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.PostBlock;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public record WoodenPostBundle(
    String type,
    Block base,
    Block baseStripped,
    boolean burnable,
    Block block,
    Block stripped
) {

    public static final List<WoodenPostBundle> LIST = new ArrayList<>();

    public static List<WoodenPostBundle> values() {
        return LIST;
    }

    public static Builder of(String type, Block base, Block base2, boolean burnable) {
        return new Builder(type, base, base2, burnable);
    }

    public static Builder of(String type, Block base, Block base2) {
        return new Builder(type, base, base2, true);
    }

    public List<Block> all() {
        return List.of(block, stripped);
    }

    public static class Builder {
        public final Block base;
        public final Block baseStripped;
        public final String type;
        public boolean burnable;

        public Builder(String type, Block base, Block base2, boolean burnable) {
            this.type = type;
            this.base = base;
            this.baseStripped = base2;
            this.burnable = burnable;
        }

        public WoodenPostBundle register() {
            AbstractBlock.Settings blockSettings = BlockFactory.createCopy(base).solid();

            if (burnable) {
                blockSettings = blockSettings.burnable();
            }
            WoodenPostBundle bundle = new WoodenPostBundle(type, base, baseStripped, burnable,
                BlockFactory.registerOf(type, PostBlock::new, blockSettings),
                BlockFactory.registerOf("stripped_" + type, PostBlock::new, blockSettings)
            );
            LIST.add(bundle);
            return bundle;
        }
    }
}
