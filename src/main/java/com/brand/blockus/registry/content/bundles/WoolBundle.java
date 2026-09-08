package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.utils.blocks.ColorBlockItemCollection;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import org.apache.commons.lang3.function.TriFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
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

    public static <B extends Block, Id> ColorBlockItemCollection register(ColorCollection<Id> ids, TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register, BiFunction<DyeColor, BlockBehaviour.Properties, B> factory, Function<DyeColor, BlockBehaviour.Properties> properties, ResourceKey<ContextIntProvider> cookingTime) {
        return BlockFactory.registerDyedBlocks(ids, register, factory, properties, (id, block, var2) -> BlockusItems.registerBlock((BlockItemId) id, block, (p) -> p.cookingFuel(cookingTime)));
    }

    public static <Id> WoolBundle register(ColorCollection<Id> ids, ColorCollection<Id> idsStairs, ColorCollection<Id> idsSlab, ColorCollection<Id> idsCarpet, TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register) {
        ColorBlockItemCollection block = register(ids, register, (var0, p) -> new Block(p), BlockFactory.copyDyedBlocks(Blocks.WOOL), ContextIntProviders.COOKING_TIME_WOOL);
        WoolBundle bundle = new WoolBundle(block,
            register(idsStairs, register, (color, p) -> new StairBlock(block.blocks().pick(color).defaultBlockState(), p), BlockFactory.copyDyedBlocks(block.blocks()), ContextIntProviders.COOKING_TIME_WOOL),
            register(idsSlab, register, (var0, p) -> new SlabBlock(p), BlockFactory.copyDyedBlocks(block.blocks()), ContextIntProviders.COOKING_TIME_WOOL_SLABS),
            register(idsCarpet, register, WoolCarpetBlock::new, BlockFactory.copyDyedBlocks(Blocks.CARPET), ContextIntProviders.COOKING_TIME_WOOL_CARPETS)
        );
        LIST.add(bundle);
        return bundle;
    }
}
