package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.blocks.ColorBlockItemCollection;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.function.TriFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public record WoolBundle(
    ColorBlockItemCollection block,
    ColorBlockItemCollection stairs,
    ColorBlockItemCollection slab,
    ColorBlockItemCollection carpet
) {

    public static final List<WoolBundle> LIST = new ArrayList<>();

    public static List<WoolBundle> values() {
        return LIST;
    }

    public List<ColorBlockItemCollection> all() {
        return List.of(block, stairs, slab, carpet);
    }

    public static <Id> WoolBundle register(ColorCollection<Id> ids, ColorCollection<Id> idsStairs, ColorCollection<Id> idsSlab, ColorCollection<Id> idsCarpet, TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register) {
        ColorBlockItemCollection block = BlockFactory.registerDyedBlocks(ids, register, Blocks.WOOL);
        WoolBundle bundle = new WoolBundle(block,
            BlockFactory.registerDyedBlocks(idsStairs, register, (color, p) -> new StairBlock(block.blocks().pick(color).defaultBlockState(), p), BlockFactory.copyDyedBlocks(block.blocks())),
            BlockFactory.registerDyedBlocks(idsSlab, register, (var0, p) -> new SlabBlock(p), BlockFactory.copyDyedBlocks(block.blocks())),
            BlockFactory.registerDyedBlocks(idsCarpet, register, WoolCarpetBlock::new, BlockFactory.copyDyedBlocks(Blocks.CARPET))
        );
        LIST.add(bundle);
        return bundle;
    }
}
