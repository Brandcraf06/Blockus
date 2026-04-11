package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;

public record DyedBSSWBundle(
    String type,
    ColorCollection<Block> block,
    ColorCollection<Block> stairs,
    ColorCollection<Block> slab,
    ColorCollection<Block> wall
) {

    public static final List<DyedBSSWBundle> LIST = new ArrayList<>();

    public static List<DyedBSSWBundle> values() {
        return LIST;
    }

    public List<ColorCollection<Block>> all() {
        return wall != null
            ? List.of(block, stairs, slab, wall)
            : List.of(block, stairs, slab);
    }

    public interface Provider {
        BlockBehaviour.Properties properties(DyeColor color);
    }

    public static DyedBSSWBundle register(String id, Provider provider, boolean includeWall) {
        String type = BlockFactory.replaceId(id);
        ColorCollection<Block> block = BlockFactory.dyedBlocks(id, provider::properties);
        DyedBSSWBundle bundle = new DyedBSSWBundle(type,
            block,
            BlockFactory.dyedBlocks(type + "_stairs", (color, p) -> new StairBlock(block.pick(color).defaultBlockState(), p), BlockFactory.copyDyedBlocks(block)),
            BlockFactory.dyedBlocks(type + "_slab", (var0, p) -> new SlabBlock(p), BlockFactory.copyDyedBlocks(block)),
            includeWall ? BlockFactory.dyedBlocks(type + "_wall", (var0, p) -> new WallBlock(p), BlockFactory.copyDyedBlocks(block)) : null
        );

        LIST.add(bundle);
        return bundle;
    }

    public static DyedBSSWBundle register(String id, Provider provider) {
        return register(id, provider, true);
    }
}
