package com.brand.blockus.registry.content;

import com.brand.blockus.utils.helper.BoatTypes;
import com.brand.blockus.utils.references.BlockusIds;
import net.minecraft.core.Registry;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BlockusItems {

    public static final Map<Item, ResourceKey<Item>> IDS = new HashMap<>();
    public static Item WHITE_OAK_BOAT = registerBoat(BoatTypes.WHITE_OAK.boat, BlockusEntities.WHITE_OAK_BOAT);
    public static Item WHITE_OAK_CHEST_BOAT = registerBoat(BoatTypes.WHITE_OAK.chestBoat, BlockusEntities.WHITE_OAK_CHEST_BOAT);
    public static Item CHARRED_BOAT = registerBoat(BoatTypes.CHARRED.boat, BlockusEntities.CHARRED_BOAT);
    public static Item CHARRED_CHEST_BOAT = registerBoat(BoatTypes.CHARRED.chestBoat, BlockusEntities.CHARRED_CHEST_BOAT);
    public static Item RAW_BAMBOO_RAFT = registerBoat(BoatTypes.RAW_BAMBOO.raft, BlockusEntities.RAW_BAMBOO_RAFT);
    public static Item RAW_BAMBOO_CHEST_RAFT = registerBoat(BoatTypes.RAW_BAMBOO.chestRaft, BlockusEntities.RAW_BAMBOO_CHEST_RAFT);


    public static Item registerItem(ResourceKey<Item> id, Item item) {
        IDS.put(item, id);
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static Item registerBlock(BlockItemId id, Block block, BiFunction<Block, Item.Properties, Item> itemFactory, Item.Properties properties) {
        return registerItem(id.item(), (p) -> itemFactory.apply(block, p), properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()));
    }

    public static Item registerBlock(BlockItemId id, Block block) {
        return registerBlock(id, block, BlockItem::new, new Item.Properties());
    }

    public static Item registerBlock(BlockItemId id, Block block, UnaryOperator<Item.Properties> propertiesFunction) {
        return registerBlock(id, block, (BiFunction)((b, p) -> new BlockItem((Block) b, propertiesFunction.apply((Item.Properties) p))), new Item.Properties());
    }

    public static Item registerItem(ResourceKey<Item> id, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(id));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }
        return registerItem(id, item);
    }

    public static Item registerItem(ResourceKey<Item> id, Block block, BiFunction<Block, Item.Properties, Item> itemFactory, Item.Properties properties) {
        return registerItem(id, itemFactory.apply(block, properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()).setId(id)));
    }

    public static Item registerSign(String name, Block block, BiFunction<Block, Item.Properties, Item> itemFactory, Item.Properties properties) {
        return registerItem(BlockusIds.create(name).item(), block, itemFactory, properties);
    }

    public static Item registerBoat(String name, EntityType<? extends AbstractBoat> boatEntity) {
        Item item = registerItem(BlockusIds.create(name).item(), (p) -> new BoatItem(boatEntity, p), new Item.Properties().stacksTo(1));
        DispenserBlock.registerBehavior(item, new BoatDispenseItemBehavior(boatEntity));
        return item;
    }

    public static ResourceKey<Item> getId(Item item) {
        return IDS.get(item);
    }
}
