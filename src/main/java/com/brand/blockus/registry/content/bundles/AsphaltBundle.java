package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.utils.helper.BlockFactory;
import com.brand.blockus.utils.helper.BlockOrder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


public record AsphaltBundle(Map<DyeColor, AsphaltVariants> colorMap) {

    public static Builder of() {
        return new Builder("asphalt");
    }

    public List<Block> all() {
        List<Block> list = new ArrayList<>();
        for (DyeColor color : BlockOrder.COLOR) {
            AsphaltVariants variants = colorMap.get(color);
            list.add(variants.block());
            list.add(variants.stairs());
            list.add(variants.slab());
        }
        return list;
    }

    public AsphaltVariants baseColor() {
        return colorMap.get(DyeColor.BLACK);
    }

    public record AsphaltVariants(Block block, Block stairs, Block slab) {
    }

    public static class Builder {
        private final String id;
        private Function<BlockBehaviour.Properties, BlockBehaviour.Properties> settings = Function.identity();

        public Builder(String id) {
            this.id = id;
        }

        public Builder settings(Function<BlockBehaviour.Properties, BlockBehaviour.Properties> settings) {
            this.settings = settings;
            return this;
        }

        public AsphaltBundle register() {
            Map<DyeColor, AsphaltVariants> colorMap = new EnumMap<>(DyeColor.class);

            for (DyeColor color : BlockOrder.COLOR) {
                String type = color.getName() + "_" + id;
                String type2 = type.replace("black_" + id, id);

                Block.Properties blockSettings = settings.apply(BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASEDRUM).strength(1.5f, 6.0f).requiresCorrectToolForDrops());

                Block block = BlockFactory.registerOf(type2, AsphaltBlock::new, blockSettings);
                Block stairs = BlockFactory.registerOf(type2 + "_stairs", s -> new AsphaltStairs(block.defaultBlockState(), s), BlockBehaviour.Properties.ofFullCopy(block));
                Block slab = BlockFactory.registerOf(type2 + "_slab", AsphaltSlab::new, BlockBehaviour.Properties.ofFullCopy(block));

                colorMap.put(color, new AsphaltVariants(block, stairs, slab));
            }

            return new AsphaltBundle(colorMap);
        }
    }
}
