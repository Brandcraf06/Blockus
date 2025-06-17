package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.utils.BlockFactory;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlockHelper;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
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

    public WoodBundle(String type, Block base, MapColor color, BlockSoundGroup sound, WoodType woodType, BlockSetType blockSetType, boolean burnable) {

        this.base = base;
        this.burnable = burnable;

        AbstractBlock.Settings blockSettings = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(sound);
        AbstractBlock.Settings doorTrapdoorSettings = BlockFactory.createDoorTrapdoorBlockSettings(0.1f, 0.8f, sound, color, NoteBlockInstrument.BASS);
        AbstractBlock.Settings signSettings = BlockFactory.create().mapColor(color).noCollision().strength(1.0F);

        if (burnable) {
            blockSettings = blockSettings.burnable();
            doorTrapdoorSettings = doorTrapdoorSettings.burnable();
            signSettings = signSettings.burnable();
        }

        this.planks = BlockFactory.register(type + "_planks", blockSettings);
        this.stairs = BlockFactory.registerStairs(this.planks);
        this.slab = BlockFactory.registerSlab(this.planks);
        this.fence = BlockFactory.register(type + "_fence", FenceBlock::new, BlockFactory.createCopy(base));
        this.fence_gate = BlockFactory.register(type + "_fence_gate", (settings) -> new FenceGateBlock(woodType, settings), BlockFactory.createCopy(base));
        this.door = BlockFactory.register(type + "_door", (settings) -> new DoorBlock(blockSetType, settings), doorTrapdoorSettings);
        this.trapdoor = BlockFactory.register(type + "_trapdoor", (settings) -> new TrapdoorBlock(blockSetType, settings), doorTrapdoorSettings);
        this.pressure_plate = BlockFactory.pressurePlate(this.planks, blockSetType);
        this.button = BlockFactory.button(this.planks, blockSetType, 30);

        // sign
        Identifier signPath = Blockus.id("entity/signs/" + type);
        this.standing_sign = TerraformSignBlockHelper.registerSignBlock(Blockus.id(type + "_sign"), (settings) -> new SignBlock(woodType, settings), signSettings);
        this.wall_sign = TerraformSignBlockHelper.registerSignBlock(Blockus.id(type + "_wall_sign"), (settings) -> new WallSignBlock(woodType, settings), copyLootTable(standing_sign, color, burnable));
        this.sign = BlockusItems.register(this.standing_sign, (block, settings) -> new SignItem(block, this.wall_sign, settings), (new Item.Settings()).maxCount(16));

        Identifier hangingSignPath = Blockus.id("entity/signs/hanging/" + type);
        Identifier hangingSignGuiPath = Blockus.id("textures/gui/hanging_signs/" + type);
        this.ceiling_hanging_sign = TerraformSignBlockHelper.registerSignBlock(Blockus.id(type + "_hanging_sign"), (settings) -> new HangingSignBlock(woodType, settings), signSettings);
        this.wall_hanging_sign = TerraformSignBlockHelper.registerSignBlock(Blockus.id(type + "_wall_hanging_sign"), (settings) -> new WallHangingSignBlock(woodType, settings), copyLootTable(ceiling_hanging_sign, color, burnable));
        this.hanging_sign = BlockusItems.register(this.ceiling_hanging_sign, (block, settings) -> new HangingSignItem(block, this.wall_hanging_sign, settings), (new Item.Settings()).maxCount(16));

        LIST.add(this);

    }

    public WoodBundle(String type, Block base, MapColor color, BlockSoundGroup sound, net.minecraft.block.WoodType woodtype, BlockSetType blockSetType) {
        this(type, base, color, sound, woodtype, blockSetType, true);
    }

    public WoodBundle(String type, Block base, MapColor color, WoodType woodType, BlockSoundGroup sound) {
        this(type, base, color, sound, woodType, BlockSetType.OAK, true);
    }

    public WoodBundle(String type, Block base, MapColor color, WoodType woodType, BlockSoundGroup sound, boolean burnable) {
        this(type, base, color, sound, woodType, BlockSetType.OAK, burnable);
    }

    public static AbstractBlock.Settings copyLootTable(Block block, MapColor color, boolean burnable) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().lootTable(block.getLootTableKey()).overrideTranslationKey(block.getTranslationKey()).mapColor(color).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F);
        if (burnable) {
            settings = settings.burnable();
        }
        return settings;
    }

    public static ArrayList<WoodBundle> values() {
        return LIST;
    }

    public boolean isBurnable() {
        return this.burnable;
    }
}
