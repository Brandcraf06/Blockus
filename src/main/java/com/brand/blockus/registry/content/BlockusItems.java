package com.brand.blockus.registry.content;

import com.brand.blockus.Blockus;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BlockusItems {

    public static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static Item register(String id, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(ResourceKey.create(Registries.ITEM, Blockus.id(id))));
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static Item register(Block block, BiFunction<Block, Item.Properties, Item> factory, Item.Properties settings) {
        return register(keyOf(block.builtInRegistryHolder().key()), (itemSettings) -> factory.apply(block, itemSettings), settings.useBlockDescriptionPrefix());
    }

    private static ResourceKey<Item> keyOf(ResourceKey<Block> blockKey) {
        return ResourceKey.create(Registries.ITEM, blockKey.identifier());
    }

    public static Item register(String id) {
        return register(id, Item::new, new Item.Properties());
    }
}
