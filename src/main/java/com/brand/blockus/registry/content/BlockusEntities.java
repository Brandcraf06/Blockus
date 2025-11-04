package com.brand.blockus.registry.content;

import com.brand.blockus.Blockus;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BoatItem;

public class BlockusEntities {

    public static final Identifier WHITE_OAK_BOATS_ID = Blockus.id("white_oak");
    public static final Identifier CHARRED_BOATS_ID = Blockus.id("charred");
    public static final Identifier RAW_BAMBOO_RAFTS_ID = Blockus.id("raw_bamboo");

    public static BoatItem WHITE_OAK_BOAT = TerraformBoatItemHelper.registerBoatItem(WHITE_OAK_BOATS_ID, false);
    public static BoatItem WHITE_OAK_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(WHITE_OAK_BOATS_ID, true);
    public static BoatItem CHARRED_BOAT = TerraformBoatItemHelper.registerBoatItem(CHARRED_BOATS_ID, false);
    public static BoatItem CHARRED_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CHARRED_BOATS_ID, true);
    public static BoatItem RAW_BAMBOO_RAFT = TerraformBoatItemHelper.registerBoatItem(RAW_BAMBOO_RAFTS_ID, false, true);
    public static BoatItem RAW_BAMBOO_CHEST_RAFT = TerraformBoatItemHelper.registerBoatItem(RAW_BAMBOO_RAFTS_ID, true, true);
}
