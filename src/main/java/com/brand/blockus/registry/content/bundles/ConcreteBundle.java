package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.level.block.*;

import java.util.ArrayList;
import java.util.List;

public record ConcreteBundle(
    String type,
    ColorCollection<Block> block,
    ColorCollection<Block> stairs,
    ColorCollection<Block> slab,
    ColorCollection<Block> wall,
    ColorCollection<Block> chiseled,
    ColorCollection<Block> pillar
) {

    public static final List<ConcreteBundle> LIST = new ArrayList<>();

    public static List<ConcreteBundle> values() {
        return LIST;
    }

    public List<ColorCollection<Block>> all() {
        return List.of(block, stairs, slab, wall, chiseled, pillar);
    }

    public static ConcreteBundle register(String id) {
        String type = BlockFactory.replaceId(id);
        String removeBricks = type.replace("_brick", "");
        ColorCollection<Block> block = BlockFactory.dyedBlocks(id, Blocks.CONCRETE);
        ConcreteBundle bundle = new ConcreteBundle(type,
            block,
            BlockFactory.dyedBlocks(type + "_stairs", (color, p) -> new StairBlock(block.pick(color).defaultBlockState(), p), BlockFactory.copyDyedBlocks(block)),
            BlockFactory.dyedBlocks(type + "_slab", (var0, p) -> new SlabBlock(p), BlockFactory.copyDyedBlocks(block)),
            BlockFactory.dyedBlocks(type + "_wall", (var0, p) -> new WallBlock(p), BlockFactory.copyDyedBlocks(block)),
            BlockFactory.chiseledConcrete(block),
            BlockFactory.dyedBlocks(removeBricks + "_pillar", (var0, p) -> new RotatedPillarBlock(p), BlockFactory.copyDyedBlocks(block))
        );

        LIST.add(bundle);
        return bundle;
    }
}
