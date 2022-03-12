package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockusItems {

    public static final Item BAMBOO_SIGN = registerSign(BlockusBlocks.BAMBOO_SIGN, BlockusBlocks.BAMBOO_WALL_SIGN);
    public static final Item BAMBOO_BOAT = registerBoat("bamboo_boat", "bamboo");

    public static final Item CHARRED_SIGN = registerSign(BlockusBlocks.CHARRED_SIGN, BlockusBlocks.CHARRED_WALL_SIGN);
    public static final Item CHARRED_BOAT = registerBoat("charred_boat", "charred");

    public static final Item WHITE_OAK_SIGN = registerSign(BlockusBlocks.WHITE_OAK_SIGN, BlockusBlocks.WHITE_OAK_WALL_SIGN);
    public static final Item WHITE_OAK_BOAT = registerBoat("white_oak_boat", "white_oak");

    public static final Item RAINBOW_PETAL = register("rainbow_petal", new Item(new Item.Settings().maxCount(64).group(ItemGroup.MATERIALS)));


    public static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, Blockus.id(id), item);
    }

    public static Item registerBoat(String path, String boatPath) {
        Identifier id = Blockus.id(path);
        Identifier boatId = Blockus.id(boatPath);

        Item item = TerraformBoatItemHelper.registerBoatItem(id, () -> TerraformBoatTypeRegistry.INSTANCE.get(boatId));

        TerraformBoatType boatType = new TerraformBoatType.Builder().item(item).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, boatId, boatType);

        return item;
    }

    public static Item registerSign(Block standingBlock, Block wallBlock) {
        return Registry.register(Registry.ITEM, Registry.BLOCK.getId(standingBlock), new SignItem(new Item.Settings().maxCount(16).group(Blockus.BLOCKUS_DECORATIONS), standingBlock, wallBlock));
    }
}
