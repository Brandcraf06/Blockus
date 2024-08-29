package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.utils.BlockFactory;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class WoodBundle {

    public static final ArrayList<WoodBundle> LIST = new ArrayList<>();

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
    public boolean burnable;

    public WoodBundle(String type, Block base, MapColor color, BlockSoundGroup sound, net.minecraft.block.WoodType woodtype, BlockSetType blocksettype, boolean burnable) {

        this.base = base;
        this.burnable = burnable;

        AbstractBlock.Settings blockSettings = AbstractBlock.Settings.create().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(sound);
        AbstractBlock.Settings blockSettings2 = BlockFactory.createDoorTrapdoorBlockSettings(0.1f, 0.8f, sound, color, NoteBlockInstrument.BASS);
        AbstractBlock.Settings signSettings = AbstractBlock.Settings.create().mapColor(color).noCollision().strength(1.0F).sounds(sound);
        AbstractBlock.Settings hangingSignSettings = AbstractBlock.Settings.create().mapColor(color).noCollision().strength(1.0F).sounds(sound);

        if (burnable) {
            blockSettings = blockSettings.burnable();
            blockSettings2 = blockSettings2.burnable();
            signSettings = signSettings.burnable();
            hangingSignSettings = hangingSignSettings.burnable();
        }

        this.planks = BlockFactory.register(type + "_planks", new Block(blockSettings));
        this.stairs = BlockFactory.registerStairs(this.planks);
        this.slab = BlockFactory.registerSlab(this.planks);
        this.fence = BlockFactory.register(type + "_fence", new FenceBlock(AbstractBlock.Settings.copy(base)));
        this.fence_gate = BlockFactory.register(type + "_fence_gate", new FenceGateBlock(woodtype, AbstractBlock.Settings.copy(base)));
        this.door = BlockFactory.register(type + "_door", new DoorBlock(blocksettype, blockSettings2));
        this.trapdoor = BlockFactory.register(type + "_trapdoor", new TrapdoorBlock(blocksettype, blockSettings2));
        this.pressure_plate = BlockFactory.registerWoodenPressurePlate(this.planks);
        this.button = BlockFactory.register(type + "_button", new ButtonBlock(blocksettype, 30, AbstractBlock.Settings.copy(planks).noCollision()));

        // sign
        Identifier signPath = Blockus.id("entity/signs/" + type);
        this.standing_sign = BlockFactory.registerNoItem(type + "_sign", new TerraformSignBlock(signPath, signSettings));
        this.wall_sign = BlockFactory.registerNoItem(type + "_wall_sign", new TerraformWallSignBlock(signPath, signSettings.dropsLike(standing_sign)));
        this.sign = BlockusItems.registerSign(standing_sign, wall_sign);

        Identifier hangingSignPath = Blockus.id("entity/signs/hanging/" + type);
        Identifier hangingSignGuiPath = Blockus.id("textures/gui/hanging_signs/" + type);
        this.ceiling_hanging_sign = BlockFactory.registerNoItem(type + "_hanging_sign", new TerraformHangingSignBlock(hangingSignPath, hangingSignGuiPath, hangingSignSettings));
        this.wall_hanging_sign = BlockFactory.registerNoItem(type + "_wall_hanging_sign", new TerraformWallHangingSignBlock(hangingSignPath, hangingSignGuiPath, hangingSignSettings.dropsLike(ceiling_hanging_sign)));
        this.hanging_sign = BlockusItems.registerHangingSign(ceiling_hanging_sign, wall_hanging_sign);

        LIST.add(this);

    }

    public WoodBundle(String type, Block base, MapColor color, BlockSoundGroup sound, net.minecraft.block.WoodType woodtype, BlockSetType blocksettype) {
        this(type, base, color, sound, woodtype, blocksettype, true);
    }

    public WoodBundle(String type, Block base, MapColor color, BlockSoundGroup sound) {
        this(type, base, color, sound, net.minecraft.block.WoodType.OAK, BlockSetType.OAK, true);
    }

    public WoodBundle(String type, Block base, MapColor color, BlockSoundGroup sound, boolean burnable) {
        this(type, base, color, sound, net.minecraft.block.WoodType.OAK, BlockSetType.OAK, burnable);
    }

    public static ArrayList<WoodBundle> values() {
        return LIST;
    }

    public boolean isBurnable() {
        return this.burnable;
    }
}
