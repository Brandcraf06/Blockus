package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlocksRegistration;
import com.brand.blockus.content.BlockusItems;
import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
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
    public final Block ceiling_hanging_sign;
    public final Block wall_hanging_sign;
    public final Item hanging_sign;

    public WoodTypesFP(String type, Block base, MapColor color) {

        this.base = base;

        FabricBlockSettings blockSettings = FabricBlockSettings.of().mapColor(color).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);
        Block.Settings blockSettings2 = blockSettings.nonOpaque().pistonBehavior(PistonBehavior.DESTROY);

        this.planks = BlocksRegistration.register(type + "_planks", new Block(blockSettings));
        this.stairs = BlocksRegistration.registerStairs(this.planks);
        this.slab = BlocksRegistration.registerSlab(this.planks);
        this.fence = BlocksRegistration.register(type + "_fence", new FenceBlock(FabricBlockSettings.copyOf(base)));
        this.fence_gate = BlocksRegistration.register(type + "_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(base), WoodType.OAK));
        this.door = BlocksRegistration.register(type + "_door", new DoorBlock(blockSettings2, BlockSetType.OAK));
        this.trapdoor = BlocksRegistration.register(type + "_trapdoor", new TrapdoorBlock(blockSettings2, BlockSetType.OAK));
        this.pressure_plate = BlocksRegistration.registerWoodenPressurePlate(this.planks);
        this.button = BlocksRegistration.register(type + "_button", new ButtonBlock(FabricBlockSettings.copyOf(planks).noCollision(), BlockSetType.OAK, 30, true));

        // sign
        FabricBlockSettings signSettings = FabricBlockSettings.of().mapColor(color).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD);

        Identifier signPath = new Identifier(Blockus.MOD_ID, "entity/signs/" + type);
        this.standing_sign = BlocksRegistration.registerNoItem(type + "_sign", new TerraformSignBlock(signPath, signSettings));
        this.wall_sign = BlocksRegistration.registerNoItem(type + "_wall_sign", new TerraformWallSignBlock(signPath, signSettings.dropsLike(standing_sign)));
        this.sign = BlockusItems.registerSign(standing_sign, wall_sign);

        Identifier hangingSignPath = new Identifier(Blockus.MOD_ID, "entity/signs/hanging/" + type);
        Identifier hangingSignGuiPath = new Identifier(Blockus.MOD_ID, "textures/gui/hanging_signs/" + type);
        this.ceiling_hanging_sign = BlocksRegistration.registerNoItem(type + "_hanging_sign", new TerraformHangingSignBlock(hangingSignPath, hangingSignGuiPath, signSettings));
        this.wall_hanging_sign = BlocksRegistration.registerNoItem(type + "_wall_hanging_sign", new TerraformWallHangingSignBlock(hangingSignPath, hangingSignGuiPath, signSettings.dropsLike(ceiling_hanging_sign)));
        this.hanging_sign = BlockusItems.registerHangingSign(ceiling_hanging_sign, wall_hanging_sign);

        LIST.add(this);

    }

    public static ArrayList<WoodTypesFP> values() {
        return LIST;
    }
}
