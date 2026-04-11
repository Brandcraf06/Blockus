package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public record AsphaltBundle(
    ColorCollection<Block> block,
    ColorCollection<Block> stairs,
    ColorCollection<Block> slab
) {

    public static final List<AsphaltBundle> LIST = new ArrayList<>();

    public static List<AsphaltBundle> values() {
        return LIST;
    }

    public List<ColorCollection<Block>> all() {
        return List.of(block, stairs, slab);
    }

    public static <T extends Block> ColorCollection<Block> registerAsphaltBlocks(String id, final BiFunction<DyeColor, BlockBehaviour.Properties, Block> factory, Function<DyeColor, BlockBehaviour.Properties> properties) {
        return ColorCollection.make((color) -> BlockFactory.registerOf(color == DyeColor.BLACK ? id : color.getName() + "_" + id, (Function) (p) -> (Block) factory.apply(color, (BlockBehaviour.Properties) p), properties.apply(color)));
    }

    public static AsphaltBundle register(String id) {
        ColorCollection<Block> block = registerAsphaltBlocks(id, (var0, p) -> new AsphaltBlock(p), color -> BlockFactory.asphaltProperties().mapColor(color));
        AsphaltBundle bundle = new AsphaltBundle(block,
            registerAsphaltBlocks(id + "_stairs", (color, p) -> new AsphaltStairs(block.pick(color).defaultBlockState(), p), BlockFactory.copyDyedBlocks(block)),
            registerAsphaltBlocks(id + "_slab", (var0, p) -> new AsphaltSlab(p), BlockFactory.copyDyedBlocks(block))
        );

        LIST.add(bundle);
        return bundle;
    }
}
