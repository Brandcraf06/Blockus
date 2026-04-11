package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.level.block.*;

import java.util.ArrayList;
import java.util.List;

public record WoolBundle(
    ColorCollection<Block> block,
    ColorCollection<Block> stairs,
    ColorCollection<Block> slab,
    ColorCollection<Block> carpet
) {

    public static final List<WoolBundle> LIST = new ArrayList<>();

    public static List<WoolBundle> values() {
        return LIST;
    }

    public List<ColorCollection<Block>> all() {
        return List.of(block, stairs, slab, carpet);
    }

    public static WoolBundle register(String id) {
        ColorCollection<Block> block = BlockFactory.dyedBlocks(id, Blocks.WOOL);
        WoolBundle bundle = new WoolBundle(block,
            BlockFactory.dyedBlocks(id + "_stairs", (color, p) -> new StairBlock(block.pick(color).defaultBlockState(), p), BlockFactory.copyDyedBlocks(block)),
            BlockFactory.dyedBlocks(id + "_slab", (var0, p) -> new SlabBlock(p), BlockFactory.copyDyedBlocks(block)),
            BlockFactory.dyedBlocks(id.replace("wool", "carpet"), WoolCarpetBlock::new, BlockFactory.copyDyedBlocks(Blocks.CARPET))
        );

        LIST.add(bundle);
        return bundle;
    }
}
