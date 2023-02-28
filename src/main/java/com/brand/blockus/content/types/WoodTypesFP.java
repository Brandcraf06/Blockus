package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlocksRegistration;
import com.brand.blockus.content.BlockusItems;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class WoodTypesFP {

    private static final ArrayList<WoodTypesFP> LIST = new ArrayList<>();

    public final Block planks;
    public final Block stairs;
    public final Block slab;
    public final Block fence;
    public final Block fence_gate;
    public final Block door;
    public final Block trapdoor;
    public final Block base;
    public final Block pressure_plate;
    public final Block button;
    public final Block standing_sign;
    public final Block wall_sign;
    public final Item sign;
    public final Item boat;
    public final Item chest_boat;


    public WoodTypesFP(String type, Block base, MapColor mapcolor) {

        this.base = base;

        Block.Settings blockSettings = FabricBlockSettings.of(Material.WOOD, mapcolor).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);

        this.planks = BlocksRegistration.register(type + "_planks", new Block(blockSettings));
        this.stairs = BlocksRegistration.registerStairs(this.planks);
        this.slab = BlocksRegistration.registerSlab(this.planks);
        this.fence = BlocksRegistration.register(type + "_fence", new FenceBlock(FabricBlockSettings.copyOf(base)));
        this.fence_gate = BlocksRegistration.register(type + "_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(base), WoodType.OAK));
        this.door = BlocksRegistration.register(type + "_door", BlocksRegistration.createDoor(0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, mapcolor, BlockSetType.OAK));
        this.trapdoor = BlocksRegistration.register(type + "_trapdoor", BlocksRegistration.createTrapdoor(0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, mapcolor, BlockSetType.OAK));
        this.pressure_plate = BlocksRegistration.registerWoodenPressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING, this.planks);
        this.button = BlocksRegistration.register(type + "_button", new ButtonBlock(FabricBlockSettings.copyOf(planks).noCollision(), BlockSetType.OAK, 30, true));
        this.standing_sign = BlocksRegistration.registerNoItem(type + "_sign", new TerraformSignBlock(new Identifier(Blockus.MOD_ID, "entity/signs/" + type), FabricBlockSettings.of(Material.WOOD).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD)));
        this.wall_sign = BlocksRegistration.registerNoItem(type + "_wall_sign", new TerraformWallSignBlock(new Identifier(Blockus.MOD_ID, "entity/signs/" + type), FabricBlockSettings.of(Material.WOOD).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD).dropsLike(standing_sign)));
        this.sign = BlockusItems.registerSign(standing_sign, wall_sign);
        TerraformBoatType boatType = BlockusItems.registerBoat(type + "_boat", type + "_chest_boat", type);
        this.boat = boatType.getItem();
        this.chest_boat = boatType.getChestItem();

        LIST.add(this);

    }

    public static ArrayList<WoodTypesFP> values() {
        return LIST;
    }
}
