package com.brand.blockus.registry.content;

import net.minecraft.world.item.Item;

public class BlockusEntities {

//    public static final Identifier WHITE_OAK_BOATS_ID = Blockus.id("white_oak");
//    public static final Identifier CHARRED_BOATS_ID = Blockus.id("charred");
//    public static final Identifier RAW_BAMBOO_RAFTS_ID = Blockus.id("raw_bamboo");

//    public static BoatItem WHITE_OAK_BOAT = TerraformBoatItemHelper.registerBoatItem(WHITE_OAK_BOATS_ID, false);
//    public static BoatItem WHITE_OAK_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(WHITE_OAK_BOATS_ID, true);
//    public static BoatItem CHARRED_BOAT = TerraformBoatItemHelper.registerBoatItem(CHARRED_BOATS_ID, false);
//    public static BoatItem CHARRED_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CHARRED_BOATS_ID, true);
//    public static BoatItem RAW_BAMBOO_RAFT = TerraformBoatItemHelper.registerBoatItem(RAW_BAMBOO_RAFTS_ID, false, true);
//    public static BoatItem RAW_BAMBOO_CHEST_RAFT = TerraformBoatItemHelper.registerBoatItem(RAW_BAMBOO_RAFTS_ID, true, true);

    // Temporary
    public static final String WHITE_OAK_BOATS_ID = "white_oak";
    public static final String CHARRED_BOATS_ID = "charred";
    public static final String RAW_BAMBOO_RAFTS_ID = "raw_bamboo";

    public static Item WHITE_OAK_BOAT = BlockusItems.register(WHITE_OAK_BOATS_ID + "_boat");
    public static Item WHITE_OAK_CHEST_BOAT = BlockusItems.register(WHITE_OAK_BOATS_ID + "_chest_boat");
    public static Item CHARRED_BOAT = BlockusItems.register(CHARRED_BOATS_ID + "_boat");
    public static Item CHARRED_CHEST_BOAT = BlockusItems.register(CHARRED_BOATS_ID + "_chest_boat");
    public static Item RAW_BAMBOO_RAFT = BlockusItems.register(RAW_BAMBOO_RAFTS_ID + "_raft");
    public static Item RAW_BAMBOO_CHEST_RAFT = BlockusItems.register(RAW_BAMBOO_RAFTS_ID + "_chest_raft");
}
