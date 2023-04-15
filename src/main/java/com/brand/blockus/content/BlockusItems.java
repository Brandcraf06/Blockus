package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.block.Block;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry.createKey;

public class BlockusItems {

    public static final Item RAINBOW_PETAL = register("rainbow_petal", new Item(new Item.Settings().maxCount(64)));


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
