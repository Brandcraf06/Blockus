package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.utils.helper.BlockFactory;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;

public record WoodBundle(
    String type,
    boolean burnable,
    Block base,
    Block planks,
    Block stairs,
    Block slab,
    Block fence,
    Block fenceGate,
    Block door,
    Block trapdoor,
    Block pressurePlate,
    Block button,
    Block standingSign,
    Block wallSign,
    Item sign,
    Block ceilingHangingSign,
    Block wallHangingSign,
    Item hangingSign
) {

    public static final List<WoodBundle> LIST = new ArrayList<>();

    public static List<WoodBundle> values() {
        return LIST;
    }

    public static Builder of(String type, Block base, MapColor color, SoundType sound, WoodType woodType, BlockSetType blockSetType, boolean burnable) {
        return new Builder(type, base, color, sound, woodType, blockSetType, burnable);
    }

    public static class Builder {
        public final String type;
        public final Block base;
        public final MapColor color;
        public final SoundType sound;
        public final WoodType woodType;
        public final BlockSetType blockSetType;
        public final boolean burnable;

        public Builder(String type, Block base, MapColor color, SoundType sound, WoodType woodType, BlockSetType blockSetType, boolean burnable) {
            this.type = type;
            this.base = base;
            this.color = color;
            this.sound = sound;
            this.woodType = woodType;
            this.blockSetType = blockSetType;
            this.burnable = burnable;
        }

        public WoodBundle register() {
            BlockBehaviour.Properties blockSettings = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(sound);
            BlockBehaviour.Properties doorTrapdoorSettings = BlockFactory.doorTrapdoorBlockSettings(0.1f, 0.8f, sound, color, NoteBlockInstrument.BASS);
            BlockBehaviour.Properties signSettings = BlockFactory.create().mapColor(color).noCollission().strength(1.0F);

            if (burnable) {
                blockSettings = blockSettings.ignitedByLava();
                doorTrapdoorSettings = doorTrapdoorSettings.ignitedByLava();
                signSettings = signSettings.ignitedByLava();
            }

            Block planks = BlockFactory.registerOf(type + "_planks", blockSettings);
            Block stairs = BlockFactory.stairs(planks);
            Block slab = BlockFactory.slab(planks);
            Block fence = BlockFactory.registerCopy(type + "_fence", FenceBlock::new, base);
            Block fenceGate = BlockFactory.registerCopy(type + "_fence_gate", (settings) -> new FenceGateBlock(woodType, settings), base);
            Block door = BlockFactory.registerOf(type + "_door", (settings) -> new DoorBlock(blockSetType, settings), doorTrapdoorSettings);
            Block trapdoor = BlockFactory.registerOf(type + "_trapdoor", (settings) -> new TrapDoorBlock(blockSetType, settings), doorTrapdoorSettings);
            Block pressurePlate = BlockFactory.pressurePlate(planks, blockSetType);
            Block button = BlockFactory.button(planks, blockSetType, 30);


            ResourceLocation signPath = Blockus.id("entity/signs/" + type);
            Block standingSign = BlockFactory.registerNoItem(type + "_sign", (settings) -> new TerraformSignBlock(signPath, settings), signSettings);
            Block wallSign = BlockFactory.registerNoItem(type + "_wall_sign", (settings) -> new TerraformWallSignBlock(signPath, settings), signSettings.dropsLike(standingSign));
            Item sign = BlockusItems.registerSign(standingSign, wallSign);

            ResourceLocation hangingSignPath = Blockus.id("entity/signs/hanging/" + type);
            ResourceLocation hangingSignGuiPath = Blockus.id("textures/gui/hanging_signs/" + type);
            Block ceilingHangingSign = BlockFactory.registerNoItem(type + "_hanging_sign", (settings) -> new TerraformHangingSignBlock(hangingSignPath, hangingSignGuiPath, settings), signSettings);
            Block wallHangingSign = BlockFactory.registerNoItem(type + "_wall_hanging_sign", (settings) -> new TerraformWallHangingSignBlock(hangingSignPath, hangingSignGuiPath, settings), signSettings.dropsLike(ceilingHangingSign));
            Item hangingSign = BlockusItems.registerHangingSign(ceilingHangingSign, wallHangingSign);

            WoodBundle bundle = new WoodBundle(type, burnable, base, planks, stairs, slab, fence, fenceGate, door, trapdoor, pressurePlate, button, standingSign, wallSign, sign, ceilingHangingSign, wallHangingSign, hangingSign);

            LIST.add(bundle);
            return bundle;
        }
    }
}



