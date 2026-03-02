package com.brand.blockus.registry.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.utils.helper.BoatTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.*;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class BlockusEntities {

    public static final EntityType<Boat> WHITE_OAK_BOAT = register(BoatTypes.WHITE_OAK.boat, builder(boatFactory(() -> BlockusItems.WHITE_OAK_BOAT)));
    public static final EntityType<ChestBoat> WHITE_OAK_CHEST_BOAT = register(BoatTypes.WHITE_OAK.chestBoat, builder(chestBoatFactory(() -> BlockusItems.WHITE_OAK_CHEST_BOAT)));
    public static final EntityType<Boat> CHARRED_BOAT = register(BoatTypes.CHARRED.boat, builder(boatFactory(() -> BlockusItems.CHARRED_BOAT)));
    public static final EntityType<ChestBoat> CHARRED_CHEST_BOAT = register(BoatTypes.CHARRED.chestBoat, builder(chestBoatFactory(() -> BlockusItems.CHARRED_CHEST_BOAT)));
    public static final EntityType<Raft> RAW_BAMBOO_RAFT = register(BoatTypes.RAW_BAMBOO.raft, builder(raftFactory(() -> BlockusItems.RAW_BAMBOO_RAFT)));
    public static final EntityType<ChestRaft> RAW_BAMBOO_CHEST_RAFT = register(BoatTypes.RAW_BAMBOO.chestRaft, builder(chestRaftFactory(() -> BlockusItems.RAW_BAMBOO_CHEST_RAFT)));

    public static <T extends Entity> EntityType.Builder<T> builder(EntityType.EntityFactory<T> factory) {
        return EntityType.Builder.of(factory, MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10);
    }

    public static EntityType.EntityFactory<Boat> boatFactory(Supplier<Item> boatItem) {
        return (entityType, level) -> new Boat(entityType, level, boatItem);
    }

    public static EntityType.EntityFactory<ChestBoat> chestBoatFactory(Supplier<Item> dropItem) {
        return (entityType, level) -> new ChestBoat(entityType, level, dropItem);
    }

    public static EntityType.EntityFactory<Raft> raftFactory(Supplier<Item> dropItem) {
        return (entityType, level) -> new Raft(entityType, level, dropItem);
    }

    public static EntityType.EntityFactory<ChestRaft> chestRaftFactory(Supplier<Item> dropItem) {
        return (entityType, level) -> new ChestRaft(entityType, level, dropItem);
    }

    public static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> id, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, builder.build(id));
    }

    public static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        return register(ResourceKey.create(Registries.ENTITY_TYPE, Blockus.id(name)), builder);
    }
}
