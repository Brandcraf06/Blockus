package com.brand.blockus.registry.content;

import com.brand.blockus.Blockus;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;

public class BlockusItems {

    public static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Blockus.id(id), item);
    }

    public static Item registerSign(Block standingBlock, Block wallBlock) {
        return Registry.register(BuiltInRegistries.ITEM, BuiltInRegistries.BLOCK.getKey(standingBlock), new SignItem(new Item.Properties().stacksTo(16), standingBlock, wallBlock));
    }

    public static Item registerHangingSign(Block hangingSign, Block wallHangingSign) {
        return Registry.register(BuiltInRegistries.ITEM, BuiltInRegistries.BLOCK.getKey(hangingSign), new HangingSignItem(hangingSign, wallHangingSign, new Item.Properties().stacksTo(16)));
    }
}
