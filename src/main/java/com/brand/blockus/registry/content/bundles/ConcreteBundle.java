package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.blocks.ColorBlockItemCollection;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.function.TriFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public record ConcreteBundle(
    ColorBlockItemCollection block,
    ColorBlockItemCollection stairs,
    ColorBlockItemCollection slab,
    ColorBlockItemCollection wall,
    ColorBlockItemCollection chiseled,
    ColorBlockItemCollection pillar,
    ColorCollection<BlockItemId> blockId,
    ColorCollection<BlockItemId> stairsId,
    ColorCollection<BlockItemId> slabId,
    ColorCollection<BlockItemId> wallId,
    ColorCollection<BlockItemId> chiseledId,
    ColorCollection<BlockItemId> pillarId
) {

    public static final List<ConcreteBundle> LIST = new ArrayList<>();

    public static List<ConcreteBundle> values() {
        return LIST;
    }

    public List<ColorBlockItemCollection> all() {
        return List.of(block, stairs, slab, wall, chiseled, pillar);
    }

    public static <Id> ConcreteBundle register(ColorCollection<Id> ids, ColorCollection<Id> idsStairs, ColorCollection<Id> idsSlab, ColorCollection<Id> idsWall, ColorCollection<Id> idsChiseled, ColorCollection<Id> idsPillar, TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register) {
        ColorBlockItemCollection block = BlockFactory.registerDyedBlocks(ids, register, Blocks.CONCRETE);
        ConcreteBundle bundle = new ConcreteBundle(block,
            BlockFactory.registerDyedBlocks(idsStairs, register, (color, p) -> new StairBlock(block.blocks().pick(color).defaultBlockState(), p), BlockFactory.copyDyedBlocks(block.blocks())),
            BlockFactory.registerDyedBlocks(idsSlab, register, (var0, p) -> new SlabBlock(p), BlockFactory.copyDyedBlocks(block.blocks())),
            BlockFactory.registerDyedBlocks(idsWall, register, (var0, p) -> new WallBlock(p), BlockFactory.copyDyedBlocks(block.blocks())),
            BlockFactory.registerDyedBlocks(idsChiseled, register, block.blocks()),
            BlockFactory.registerDyedBlocks(idsPillar, register, (var0, p) -> new RotatedPillarBlock(p), BlockFactory.copyDyedBlocks(block.blocks())),
            (ColorCollection<BlockItemId>) ids, (ColorCollection<BlockItemId>) idsStairs, (ColorCollection<BlockItemId>) idsSlab, (ColorCollection<BlockItemId>) idsWall, (ColorCollection<BlockItemId>) idsChiseled, (ColorCollection<BlockItemId>) idsPillar

        );
        LIST.add(bundle);
        return bundle;
    }
}
