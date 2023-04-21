package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry.createKey;

public class BlockusEntities {
    public static final TerraformBoatType WHITE_OAK_BOAT = registerBoat("white_oak");
    public static final TerraformBoatType CHARRED_BOAT = registerBoat("charred");
    public static final TerraformBoatType RAW_BAMBOO_RAFT = registerRaft("raw_bamboo");

    public static TerraformBoatType registerBoat(String boatPath) {
        Identifier id = Blockus.id(boatPath + "_boat");
        Identifier chestId = Blockus.id(boatPath + "_chest_boat");
        RegistryKey<TerraformBoatType> boatId = createKey(Blockus.id(boatPath));

        Item item = TerraformBoatItemHelper.registerBoatItem(id, boatId, false);
        Item chestItem = TerraformBoatItemHelper.registerBoatItem(chestId, boatId, true);

        TerraformBoatType boatType = new TerraformBoatType.Builder().item(item).chestItem(chestItem).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, boatId, boatType);

        return boatType;

    }

    public static TerraformBoatType registerRaft(String raftPath) {
        Identifier raftId = Blockus.id(raftPath + "_raft");
        Identifier chestRaftId = Blockus.id(raftPath + "_chest_raft");
        RegistryKey<TerraformBoatType> raftKey = createKey(Blockus.id(raftPath));

        Item raftItem = TerraformBoatItemHelper.registerBoatItem(raftId, raftKey, false);
        Item chestRaftItem = TerraformBoatItemHelper.registerBoatItem(chestRaftId, raftKey, true);

        TerraformBoatType raftType = new TerraformBoatType.Builder().raft().item(raftItem).chestItem(chestRaftItem).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, raftKey, raftType);

        return raftType;

    }
}
