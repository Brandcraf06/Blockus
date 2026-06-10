package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
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

    public static BlockBehaviour.Properties copyLootTable(Block block, MapColor color, boolean burnable) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().overrideLootTable(block.getLootTable()).overrideDescription(block.getDescriptionId()).mapColor(color).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F);
        if (burnable) {
            properties = properties.ignitedByLava();
        }
        return properties;
    }

    public static WoodBundle register(String type, Block base, MapColor color, SoundType sound, WoodType woodType, BlockSetType blockSetType, boolean burnable) {
        BlockBehaviour.Properties blockProperties = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(sound);
        BlockBehaviour.Properties doorTrapdoorProperties = BlockFactory.doorTrapdoorBlockProperties(0.1f, 0.8f, sound, color, NoteBlockInstrument.BASS);
        BlockBehaviour.Properties signProperties = BlockFactory.create().mapColor(color).noCollision().strength(1.0F);
        BlockBehaviour.Properties shelfProperties = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASS).sound(SoundType.SHELF).strength(2.0F, 3.0F);

        if (burnable) {
            blockProperties = blockProperties.ignitedByLava();
            doorTrapdoorProperties = doorTrapdoorProperties.ignitedByLava();
            signProperties = signProperties.ignitedByLava();
            shelfProperties = shelfProperties.ignitedByLava();
        }

        Block planks = BlockFactory.registerOf(type + "_planks", blockProperties);
        Block stairs = BlockFactory.stairs(planks);
        Block slab = BlockFactory.slab(planks);
        Block fence = BlockFactory.registerCopy(type + "_fence", FenceBlock::new, base);
        Block fenceGate = BlockFactory.registerCopy(type + "_fence_gate", (properties) -> new FenceGateBlock(woodType, properties), base);
        Block door = BlockFactory.registerOf(type + "_door", (properties) -> new DoorBlock(blockSetType, properties), doorTrapdoorProperties);
        Block trapdoor = BlockFactory.registerOf(type + "_trapdoor", (properties) -> new TrapDoorBlock(blockSetType, properties), doorTrapdoorProperties);
        Block pressurePlate = BlockFactory.pressurePlate(planks, blockSetType);
        Block button = BlockFactory.button(planks, blockSetType, 30);
        Block shelf = BlockFactory.registerOf(type + "_shelf", ShelfBlock::new, shelfProperties);

        Block standingSign = BlockFactory.registerNoItem(type + "_sign", (properties) -> new StandingSignBlock(woodType, properties), signProperties);
        Block wallSign = BlockFactory.registerNoItem(type + "_wall_sign", (properties) -> new WallSignBlock(woodType, properties), WoodBundle.copyLootTable(standingSign, color, burnable));
        Item sign = BlockusItems.registerSign(type + "_sign", standingSign, (block, properties) -> new SignItem(block, wallSign, properties), new Item.Properties().stacksTo(16));

        Block ceilingHangingSign = BlockFactory.registerNoItem(type + "_hanging_sign", (properties) -> new CeilingHangingSignBlock(woodType, properties), signProperties);
        Block wallHangingSign = BlockFactory.registerNoItem(type + "_wall_hanging_sign", (properties) -> new WallHangingSignBlock(woodType, properties), WoodBundle.copyLootTable(ceilingHangingSign, color, burnable));
        Item hangingSign = BlockusItems.registerSign(type + "_hanging_sign", ceilingHangingSign, (block, properties) -> new HangingSignItem(block, wallHangingSign, properties), new Item.Properties().stacksTo(16));

        WoodBundle bundle = new WoodBundle(type, burnable, base, planks, stairs, slab, fence, fenceGate, door, trapdoor, pressurePlate, button, shelf, standingSign, wallSign, sign, ceilingHangingSign, wallHangingSign, hangingSign);

        LIST.add(bundle);
        return bundle;
    }
}




