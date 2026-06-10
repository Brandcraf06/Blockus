package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.blocks.ColorBlockItemCollection;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.function.TriFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public record DyedBSSWBundle(
    ColorBlockItemCollection block,
    ColorBlockItemCollection stairs,
    ColorBlockItemCollection slab,
    ColorBlockItemCollection wall
) {

    public static final List<DyedBSSWBundle> LIST = new ArrayList<>();

    public static List<DyedBSSWBundle> values() {
        return LIST;
    }

    public List<ColorBlockItemCollection> all() {
        return wall != null
            ? List.of(block, stairs, slab, wall)
            : List.of(block, stairs, slab);
    }

    public interface Provider {
        BlockBehaviour.Properties properties(DyeColor color);
    }

    public static <Id> DyedBSSWBundle register(ColorCollection<Id> ids, ColorCollection<Id> idsStairs, ColorCollection<Id> idsSlab, ColorCollection<Id> idsWall, TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register, Provider provider, boolean includeWall) {
        ColorBlockItemCollection block = BlockFactory.registerDyedBlocks(ids, register, provider::properties);
        DyedBSSWBundle bundle = new DyedBSSWBundle(
            block,
            BlockFactory.registerDyedBlocks(idsStairs, register, (color, p) -> new StairBlock(block.blocks().pick(color).defaultBlockState(), p), BlockFactory.copyDyedBlocks(block.blocks())),
            BlockFactory.registerDyedBlocks(idsSlab, register, (var0, p) -> new SlabBlock(p), BlockFactory.copyDyedBlocks(block.blocks())),
            includeWall ? BlockFactory.registerDyedBlocks(idsWall, register, (var0, p) -> new WallBlock(p), BlockFactory.copyDyedBlocks(block.blocks())) : null
        );
        LIST.add(bundle);
        return bundle;
    }

    public static <Id> DyedBSSWBundle register(ColorCollection<Id> ids, ColorCollection<Id> idsStairs, ColorCollection<Id> idsSlab, ColorCollection<Id> idsWall, TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register, Provider provider) {
        return register(ids, idsStairs, idsSlab, idsWall, register, provider, true);
    }
}
