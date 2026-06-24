package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.utils.blocks.ColorBlockItemCollection;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.function.TriFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public record AsphaltBundle(
    ColorBlockItemCollection block,
    ColorBlockItemCollection stairs,
    ColorBlockItemCollection slab,
    ColorCollection<BlockItemId> blockId,
    ColorCollection<BlockItemId> stairsId,
    ColorCollection<BlockItemId> slabId
) {

    public static final List<AsphaltBundle> LIST = new ArrayList<>();

    public static List<AsphaltBundle> values() {
        return LIST;
    }

    public List<ColorBlockItemCollection> all() {
        return List.of(block, stairs, slab);
    }

    public static <Id> AsphaltBundle register(ColorCollection<Id> ids, ColorCollection<Id> idsStairs, ColorCollection<Id> idsSlab, TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register) {
        ColorBlockItemCollection block = BlockFactory.registerDyedBlocks(ids, register, (var0, p) -> new AsphaltBlock(p), color -> BlockFactory.asphaltProperties().mapColor(color));
        AsphaltBundle bundle = new AsphaltBundle(block,
            BlockFactory.registerDyedBlocks(idsStairs, register, (color, p) -> new AsphaltStairs(block.blocks().pick(color).defaultBlockState(), p), BlockFactory.copyDyedBlocks(block.blocks())),
            BlockFactory.registerDyedBlocks(idsSlab, register, (var0, p) -> new AsphaltSlab(p), BlockFactory.copyDyedBlocks(block.blocks())),
            (ColorCollection<BlockItemId>) ids, (ColorCollection<BlockItemId>) idsStairs, (ColorCollection<BlockItemId>) idsSlab
        );
        LIST.add(bundle);
        return bundle;
    }
}
