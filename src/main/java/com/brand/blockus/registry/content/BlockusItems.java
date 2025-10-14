package com.brand.blockus.registry.content;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BlockusItems {

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, Blockus.id(id))));
        return Registry.register(Registries.ITEM, id, item);
    }

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        return register(keyOf(block.getRegistryEntry().registryKey()), (itemSettings) -> factory.apply(block, itemSettings), settings.useBlockPrefixedTranslationKey());
    }

    private static RegistryKey<Item> keyOf(RegistryKey<Block> blockKey) {
        return RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
    }

    public static Item register(String id) {
        return register(id, Item::new, new Item.Settings());
    }
}
