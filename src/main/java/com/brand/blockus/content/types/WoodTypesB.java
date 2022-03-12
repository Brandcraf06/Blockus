package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.redstone.WoodenButtonBase;
import com.brand.blockus.content.BlocksRegistration;
import com.brand.blockus.content.BlockusItems;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class WoodTypesB {

    private static final ArrayList<WoodTypesB> LIST = new ArrayList<>();

    public static final WoodTypesB BAMBOO = new WoodTypesB("bamboo", Blocks.OAK_PLANKS, MapColor.PALE_YELLOW);
    public static final WoodTypesB WHITE_OAK = new WoodTypesB("white_oak", Blocks.SPRUCE_PLANKS, MapColor.OFF_WHITE);

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

    public WoodTypesB(String type, Block base, MapColor mapcolor) {

        this.base = base;

        Block.Settings blockSettings = FabricBlockSettings.of(Material.STONE, mapcolor).strength(1.5f, 6.0f).requiresTool();
        ItemGroup group = Blockus.BLOCKUS_REDSTONE;

        this.planks =  BlocksRegistration.register(type+ "_planks", new Block(blockSettings), Blockus.BLOCKUS_BUILDING_BLOCKS);
        this.stairs =  BlocksRegistration.registerStairs(this.planks);
        this.slab =  BlocksRegistration.registerSlab(this.planks);
        this.fence =  BlocksRegistration.register(type + "_fence", new FenceBlock(FabricBlockSettings.copyOf(base)), Blockus.BLOCKUS_DECORATIONS);
        this.fence_gate =  BlocksRegistration.register(type + "_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(base)), group);
        this.door =  BlocksRegistration.register(type + "_door", BlocksRegistration.createDoor(0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, mapcolor), group);
        this.trapdoor =  BlocksRegistration.register(type + "_trapdoor", BlocksRegistration.createTrapdoor(0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, mapcolor), group);
        this.pressure_plate =  BlocksRegistration.registerPressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING, this.planks);
        this.button =  BlocksRegistration.register(type + "_button", new WoodenButtonBase(FabricBlockSettings.copyOf(planks).noCollision()), group);
        this.standing_sign =  BlocksRegistration.registerNoItem(type + "_sign", new TerraformSignBlock(new Identifier(Blockus.MOD_ID, "entity/signs/" + type), FabricBlockSettings.of(Material.WOOD).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD)));
        this.wall_sign =  BlocksRegistration.registerNoItem(type + "_wall_sign", new TerraformWallSignBlock(new Identifier(Blockus.MOD_ID, "entity/signs" + type), FabricBlockSettings.of(Material.WOOD).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD).dropsLike(standing_sign)));
        this.sign =  BlockusItems.registerSign(standing_sign, wall_sign);
        this.boat =  BlockusItems.registerBoat(type + "_boat", type);

        LIST.add(this);

    }

	public static ArrayList<WoodTypesB> values() {
        return LIST;
    }
}
