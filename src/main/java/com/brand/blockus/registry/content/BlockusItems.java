package com.brand.blockus.registry.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.utils.helper.BoatTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BlockusItems {

    public static Item WHITE_OAK_BOAT = registerBoat(BoatTypes.WHITE_OAK.boat, BlockusEntities.WHITE_OAK_BOAT);
    public static Item WHITE_OAK_CHEST_BOAT = registerBoat(BoatTypes.WHITE_OAK.chestBoat, BlockusEntities.WHITE_OAK_CHEST_BOAT);
    public static Item CHARRED_BOAT = registerBoat(BoatTypes.CHARRED.boat, BlockusEntities.CHARRED_BOAT);
    public static Item CHARRED_CHEST_BOAT = registerBoat(BoatTypes.CHARRED.chestBoat, BlockusEntities.CHARRED_CHEST_BOAT);
    public static Item RAW_BAMBOO_RAFT = registerBoat(BoatTypes.RAW_BAMBOO.raft, BlockusEntities.RAW_BAMBOO_RAFT);
    public static Item RAW_BAMBOO_CHEST_RAFT = registerBoat(BoatTypes.RAW_BAMBOO.chestRaft, BlockusEntities.RAW_BAMBOO_CHEST_RAFT);

    public static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM, key, itemFactory.apply(properties.setId(key)));
    }

    public static Item register(Block block, BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties) {
        return register(blockIdToItemId(block.builtInRegistryHolder().key()), (p) -> itemFactory.apply(block, p), properties.useBlockDescriptionPrefix());
    }

    public static ResourceKey<Item> blockIdToItemId(ResourceKey<Block> blockName) {
        return ResourceKey.create(Registries.ITEM, blockName.identifier());
    }

    public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        return register(ResourceKey.create(Registries.ITEM, Blockus.id(name)), itemFactory, properties);
    }

    public static void registerBoatDispenseItemBehavior(ItemLike item, EntityType<? extends AbstractBoat> boatEntity) {
        DispenserBlock.registerBehavior(item, new BoatDispenseItemBehavior(boatEntity));
    }

    public static Item registerBoat(String name, EntityType<? extends @NotNull AbstractBoat> entityType) {
        Item item = register(name, (p) -> new BoatItem(entityType, p), new Item.Properties().stacksTo(1));
        registerBoatDispenseItemBehavior(item, entityType);

        return item;
    }

    public static Item register(String name) {
        return register(name, Item::new, new Item.Properties());
    }
}
