package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import com.brand.blockus.utils.helper.BlockMaps;
import com.brand.blockus.utils.helper.BlockOrder;
import net.minecraft.block.Block;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public record ConcreteBundle(Map<DyeColor, ConcreteVariants> colorMap) {

    public static final List<ConcreteBundle> LIST = new ArrayList<>();

    public static List<ConcreteBundle> values() {
        return LIST;
    }

    public static Builder of(String id) {
        return new Builder(id);
    }

    public List<Block> all() {
        List<Block> list = new ArrayList<>();
        for (DyeColor color : BlockOrder.COLOR) {
            ConcreteVariants variants = colorMap.get(color);
            list.add(variants.block());
            list.add(variants.stairs());
            list.add(variants.slab());
            list.add(variants.wall());
            list.add(variants.chiseled());
            list.add(variants.pillar());
        }
        return list;
    }

    public record ConcreteVariants(Block block, Block stairs, Block slab, Block wall, Block chiseled, Block pillar) {
    }

    public static class Builder {
        public final String id;
        public DyeColor color;

        public Builder(String id) {
            this.id = id;
        }

        public ConcreteBundle register() {
            Map<DyeColor, ConcreteVariants> colorMap = new EnumMap<>(DyeColor.class);

            for (DyeColor color : BlockOrder.COLOR) {
                String type = color.getId() + "_" + id;
                String removeBricks = type.replace("_bricks", "");
                Block base = BlockMaps.CONCRETE_MAP.get(color);

                Block block = BlockFactory.registerCopy(type, base);
                Block stairs = BlockFactory.stairs(block);
                Block slab = BlockFactory.slab(block);
                Block wall = BlockFactory.wall(block);
                Block chiseled = BlockFactory.registerCopy("chiseled_" + removeBricks, base);
                Block pillar = BlockFactory.pillar2(removeBricks + "_pillar", base);

                colorMap.put(color, new ConcreteVariants(block, stairs, slab, wall, chiseled, pillar));
            }

            ConcreteBundle bundle = new ConcreteBundle(colorMap);
            LIST.add(bundle);
            return bundle;
        }
    }
}
