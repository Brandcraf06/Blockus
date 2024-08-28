package com.brand.blockus.registry.content;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockusItems {

    // public static final Item RAINBOW_PETAL = register("rainbow_petal", new Item(new Item.Settings().maxCount(64)));


    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Blockus.id(id), item);
    }

    public static Item registerSign(Block standingBlock, Block wallBlock) {
        return Registry.register(Registries.ITEM, Registries.BLOCK.getId(standingBlock), new SignItem(new Item.Settings().maxCount(16), standingBlock, wallBlock));
    }

    public static Item registerHangingSign(Block hangingSign, Block wallHangingSign) {
        return Registry.register(Registries.ITEM, Registries.BLOCK.getId(hangingSign), new HangingSignItem(hangingSign, wallHangingSign, new Item.Settings().maxCount(16)));
    }
}
