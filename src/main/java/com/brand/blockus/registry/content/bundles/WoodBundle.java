package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.utils.helper.BlockFactory;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlockHelper;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.sound.BlockSoundGroup;

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
    Block shelf,
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

    public static Builder of(String type, Block base, MapColor color, BlockSoundGroup sound, WoodType woodType, BlockSetType blockSetType, boolean burnable) {
        return new Builder(type, base, color, sound, woodType, blockSetType, burnable);
    }

    public static AbstractBlock.Settings copyLootTable(Block block, MapColor color, boolean burnable) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().lootTable(block.getLootTableKey()).overrideTranslationKey(block.getTranslationKey()).mapColor(color).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F);
        if (burnable) {
            settings = settings.burnable();
        }
        return settings;
    }

    public static class Builder {
        public final String type;
        public final Block base;
        public final MapColor color;
        public final BlockSoundGroup sound;
        public final WoodType woodType;
        public final BlockSetType blockSetType;
        public final boolean burnable;

        public Builder(String type, Block base, MapColor color, BlockSoundGroup sound, WoodType woodType, BlockSetType blockSetType, boolean burnable) {
            this.type = type;
            this.base = base;
            this.color = color;
            this.sound = sound;
            this.woodType = woodType;
            this.blockSetType = blockSetType;
            this.burnable = burnable;
        }

        public WoodBundle register() {
            AbstractBlock.Settings blockSettings = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(sound);
            AbstractBlock.Settings doorTrapdoorSettings = BlockFactory.doorTrapdoorBlockSettings(0.1f, 0.8f, sound, color, NoteBlockInstrument.BASS);
            AbstractBlock.Settings signSettings = BlockFactory.create().mapColor(color).noCollision().strength(1.0F);
            AbstractBlock.Settings shelfSettings = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).strength(2.0F, 3.0F);

            if (burnable) {
                blockSettings = blockSettings.burnable();
                doorTrapdoorSettings = doorTrapdoorSettings.burnable();
                signSettings = signSettings.burnable();
                shelfSettings = signSettings.burnable();
            }

            Block planks = BlockFactory.registerOf(type + "_planks", blockSettings);
            Block stairs = BlockFactory.stairs(planks);
            Block slab = BlockFactory.slab(planks);
            Block fence = BlockFactory.registerCopy(type + "_fence", FenceBlock::new, base);
            Block fenceGate = BlockFactory.registerCopy(type + "_fence_gate", (settings) -> new FenceGateBlock(woodType, settings), base);
            Block door = BlockFactory.registerOf(type + "_door", (settings) -> new DoorBlock(blockSetType, settings), doorTrapdoorSettings);
            Block trapdoor = BlockFactory.registerOf(type + "_trapdoor", (settings) -> new TrapdoorBlock(blockSetType, settings), doorTrapdoorSettings);
            Block pressurePlate = BlockFactory.pressurePlate(planks, blockSetType);
            Block button = BlockFactory.button(planks, blockSetType, 30);
            Block shelf = BlockFactory.registerOf(type + "_shelf", ShelfBlock::new, shelfSettings);

            Block standingSign = BlockFactory.registerNoItem(type + "_sign", (settings) -> new SignBlock(woodType, settings), signSettings);
            Block wallSign = BlockFactory.registerNoItem(type + "_wall_sign", (settings) -> new WallSignBlock(woodType, settings), WoodBundle.copyLootTable(standingSign, color, burnable));
            Item sign = BlockusItems.register(standingSign, (block, settings) -> new SignItem(block, wallSign, settings), new Item.Settings().maxCount(16));

            Block ceilingHangingSign = BlockFactory.registerNoItem(type + "_hanging_sign", (settings) -> new HangingSignBlock(woodType, settings), signSettings);
            Block wallHangingSign = BlockFactory.registerNoItem(type + "_wall_hanging_sign", (settings) -> new WallHangingSignBlock(woodType, settings), WoodBundle.copyLootTable(ceilingHangingSign, color, burnable));
            Item hangingSign = BlockusItems.register(ceilingHangingSign, (block, settings) -> new HangingSignItem(block, wallHangingSign, settings), new Item.Settings().maxCount(16));

            WoodBundle bundle = new WoodBundle(type, burnable, base, planks, stairs, slab, fence, fenceGate, door, trapdoor, pressurePlate, button, shelf, standingSign, wallSign, sign, ceilingHangingSign, wallHangingSign, hangingSign);

            LIST.add(bundle);
            return bundle;
        }
    }
}



