package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import com.brand.blockus.utils.helper.BlockMaps;
import com.brand.blockus.utils.helper.BlockOrder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WoolCarpetBlock;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public record WoolBundle(Map<DyeColor, WoolVariants> colorMap) {

    public static final List<WoolBundle> LIST = new ArrayList<>();

    public static List<WoolBundle> values() {
        return LIST;
    }

    public static Builder of(String id) {
        return new Builder(id);
    }

    public List<Block> all() {
        List<Block> list = new ArrayList<>();
        for (DyeColor color : BlockOrder.COLOR) {
            WoolVariants variants = colorMap.get(color);
            list.add(variants.block());
            list.add(variants.stairs());
            list.add(variants.slab());
            list.add(variants.carpet());
        }
        return list;
    }

    public record WoolVariants(Block block, Block stairs, Block slab, Block carpet) {
    }

    public static class Builder {
        private final String id;
        public DyeColor color;

        public Builder(String id) {
            this.id = id;
        }

        public Builder(String id, DyeColor color) {
            this.id = id;
            this.color = color;
        }

        public WoolBundle register() {
            Map<DyeColor, WoolVariants> colorMap = new EnumMap<>(DyeColor.class);

            for (DyeColor color : BlockOrder.COLOR) {
                String type = color.getName() + "_" + id;

                Block block = BlockFactory.registerCopy(type, BlockMaps.WOOL_MAP.get(color));
                Block stairs = BlockFactory.stairs(block);
                Block slab = BlockFactory.slab(block);
                Block carpet = BlockFactory.registerCopy(type.replace("wool", "carpet"), (settings) -> new WoolCarpetBlock(color, settings), BlockMaps.CARPET_MAP.get(color));

                colorMap.put(color, new WoolVariants(block, stairs, slab, carpet));
            }

            WoolBundle bundle = new WoolBundle(colorMap);
            LIST.add(bundle);
            return bundle;
        }
    }
}
