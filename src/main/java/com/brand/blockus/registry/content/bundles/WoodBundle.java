package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

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

    public static UnaryOperator<Item.Properties> itemProperties(ResourceKey<ContextIntProvider> burnTime, boolean isBurnable) {
        return isBurnable ? p -> p.cookingFuel(burnTime) : UnaryOperator.identity();
    }

    public static BlockBehaviour.Properties copyLootTable(Block block, MapColor color, boolean isBurnable) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().overrideLootTable(block.getLootTable()).overrideDescription(block.getDescriptionId()).mapColor(color).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F);
        if (isBurnable) {
            properties = properties.ignitedByLava();
        }
        return properties;
    }

    public static WoodBundle register(String type, Block base, MapColor color, SoundType sound, WoodType woodType, BlockSetType blockSetType, boolean isBurnable) {
        BlockBehaviour.Properties blockProperties = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(sound);
        BlockBehaviour.Properties doorTrapdoorBlockProperties = BlockFactory.doorTrapdoorBlockProperties(0.1f, 0.8f, sound, color, NoteBlockInstrument.BASS);
        BlockBehaviour.Properties signBlockProperties = BlockFactory.create().mapColor(color).noCollision().strength(1.0F);
        BlockBehaviour.Properties shelfBlockProperties = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASS).sound(SoundType.SHELF).strength(2.0F, 3.0F);

        if (isBurnable) {
            blockProperties = blockProperties.ignitedByLava();
            doorTrapdoorBlockProperties = doorTrapdoorBlockProperties.ignitedByLava();
            signBlockProperties = signBlockProperties.ignitedByLava();
            shelfBlockProperties = shelfBlockProperties.ignitedByLava();
        }

        Block planks = BlockFactory.registerOf(type + "_planks", blockProperties, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS, isBurnable));
        Block stairs = BlockFactory.stairs(planks, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS, isBurnable));
        Block slab = BlockFactory.slab(planks, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_SLABS, isBurnable));
        Block fence = BlockFactory.registerCopyWithItemProperties(type + "_fence", FenceBlock::new, base, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS, isBurnable));
        Block fenceGate = BlockFactory.registerCopyWithItemProperties(type + "_fence_gate", (properties) -> new FenceGateBlock(woodType, properties), base, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS, isBurnable));
        Block door = BlockFactory.registerOf(type + "_door", (properties) -> new DoorBlock(blockSetType, properties), doorTrapdoorBlockProperties, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE, isBurnable));
        Block trapdoor = BlockFactory.registerOf(type + "_trapdoor", (properties) -> new TrapDoorBlock(blockSetType, properties), doorTrapdoorBlockProperties, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS, isBurnable));
        Block pressurePlate = BlockFactory.pressurePlate(planks, blockSetType, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS, isBurnable));
        Block button = BlockFactory.button(planks, blockSetType, 30, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_EXTRA_SMALL, isBurnable));
        Block shelf = BlockFactory.registerOf(type + "_shelf", ShelfBlock::new, shelfBlockProperties, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS, isBurnable));

        Block standingSign = BlockFactory.registerNoItem(type + "_sign", (properties) -> new StandingSignBlock(woodType, properties), signBlockProperties);
        Block wallSign = BlockFactory.registerNoItem(type + "_wall_sign", (properties) -> new WallSignBlock(woodType, properties), WoodBundle.copyLootTable(standingSign, color, isBurnable));
        Item sign = BlockusItems.registerSign(type + "_sign", standingSign, (block, properties) -> new StandingAndWallBlockItem(block, wallSign, Direction.DOWN, properties), new Item.Properties().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE).stacksTo(16).signText());

        Block ceilingHangingSign = BlockFactory.registerNoItem(type + "_hanging_sign", (properties) -> new CeilingHangingSignBlock(woodType, properties), signBlockProperties);
        Block wallHangingSign = BlockFactory.registerNoItem(type + "_wall_hanging_sign", (properties) -> new WallHangingSignBlock(woodType, properties), WoodBundle.copyLootTable(ceilingHangingSign, color, isBurnable));
        Item hangingSign = BlockusItems.registerSign(type + "_hanging_sign", ceilingHangingSign, (block, properties) -> new HangingSignItem(block, wallHangingSign, properties), new Item.Properties().cookingFuel(ContextIntProviders.COOKING_TIME_HANGING_SIGNS).stacksTo(16).signText());

        WoodBundle bundle = new WoodBundle(type, isBurnable, base, planks, stairs, slab, fence, fenceGate, door, trapdoor, pressurePlate, button, shelf, standingSign, wallSign, sign, ceilingHangingSign, wallHangingSign, hangingSign);

        LIST.add(bundle);
        return bundle;
    }
}




