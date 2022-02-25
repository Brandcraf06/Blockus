package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.*;
import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.blocks.base.redstone.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class BlocksRegistration {

    // General

    public static FallingBlock registerFallingBlock(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new FallingBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound));
    }


    public static PaneBlockBase registerWoodenPane() {
        return new PaneBlockBase(FabricBlockSettings.of(Material.WOOD).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD));
    }



    // Pillar
    public static Block registerPillar(String baseid, Block base) {
        String id = baseid.replace("bricks", "brick");
        return register(id + "_pillar", new PillarBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerPillar(Block base) {
        return registerPillar(Registry.BLOCK.getId(base).getPath(), base);
    }


    // Slab
    public static Block registerSlab(String baseid, Block base) {
        String id = baseid.replace("bricks", "brick").replace("tiles", "tile");
        return register(id + "_slab", new SlabBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerSlab(Block base) {
        return registerSlab(Registry.BLOCK.getId(base).getPath(), base);
    }


    // Stairs
    public static Block registerStairs(String baseid, Block base) {
        String id = baseid.replace("bricks", "brick").replace("tiles", "tile");
        return register(id + "_stairs", new StairsBase(base.getDefaultState(), FabricBlockSettings.copy(base)));
    }

    public static Block registerStairs(Block base) {
        return registerStairs(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Wall
    public static Block registerWall(String baseid, Block base) {
        String id = baseid.replace("bricks", "brick").replace("tiles", "tile");
        return register(id + "_wall", new WallBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerWall(Block base) {
        return registerWall(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Barrier registerBarrier(float hardness, float resistance) {
        return new Barrier(FabricBlockSettings.of(Material.STONE).strength(hardness, resistance).requiresTool());
    }

    public static Block registerSmallHedge(String id, Block base) {
        return register(id, new SmallHedgeBlock(FabricBlockSettings.copyOf(base).allowsSpawning(BlocksRegistration::canSpawnOnLeaves).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never)));
    }

    // Fence Gate

    // Pressure Plate

    public static PressurePlateBase registerPressurePlate(PressurePlateBlock.ActivationRule type, Block base) {
        return new PressurePlateBase(type, FabricBlockSettings.copy(base).noCollision());
    }

    // Button

    public static Block registerStoneButton(String id, Block base) {
        return register(id + "_button", new StoneButtonBase(FabricBlockSettings.copy(base).noCollision()));
    }

    public static Block registerStoneButton(Block base) {
        return registerStoneButton(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Plants

    public static FlowerPotBlock registerPottedPlant(Block content) {
        return new FlowerPotBlock(content, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque());
    }

    public static LargeFlowerPotBlock registerLargeFlowerPot(Block content) {
        return new LargeFlowerPotBlock(content, FabricBlockSettings.of(Material.DECORATION).strength(0.5F, 1.0F).nonOpaque());
    }

    public static LargeFlowerPotBlock registerPottedDoublePlant(Block content) {
        return new LargeFlowerPotBlock(content, FabricBlockSettings.of(Material.DECORATION).strength(0.5F, 1.0F).nonOpaque());
    }

    // Door & Trapdoor

    public static DoorBase registerDoor(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new DoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).nonOpaque());
    }

    public static DoorBase registerStoneDoor(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new DoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).nonOpaque().requiresTool());
    }

    public static TrapdoorBase registerTrapdoor(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new TrapdoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).nonOpaque());
    }

    public static TrapdoorBase registerStoneTrapdoor(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new TrapdoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).nonOpaque().requiresTool());
    }

    // Light

    public static Block registerLightBlock(float hardness, float resistance, Material material, BlockSoundGroup sound, int luminance, MapColor color) {
        return new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).luminance(luminance).requiresTool());
    }

    public static Block registerNeonBlock(DyeColor color) {
        return new Block(FabricBlockSettings.of(Material.GLASS, color).luminance(3).sounds(BlockSoundGroup.GLASS).strength(0.5f, 0.5f).emissiveLighting(BlocksRegistration::always).allowsSpawning(BlocksRegistration::never));
    }

    public static Block registerLampBlock(float hardness, float resistance, Material material, BlockSoundGroup sound, int luminance, MapColor color) {
        return new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).luminance(luminance));
    }

    public static RedstoneLampBlock registerRedstoneLamp() {
        return new RedstoneLampBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).allowsSpawning(BlocksRegistration::always));
    }

    public static Block registerLitRedstoneLamp() {
        return new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).allowsSpawning(BlocksRegistration::always));
    }

    public static Block registerFuturneoBlock(MapColor color) {
        return new Block(FabricBlockSettings.of(Material.REDSTONE_LAMP, color).luminance(15).strength(0.5f, 0.5f).sounds(BlockSoundGroup.GLASS).allowsSpawning(BlocksRegistration::always));
    }

    // Colors

    public static Block registerColoredStoneBricks(MapColor color) {
        return new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).mapColor(color));
    }

    // Glass


    public static StainedGlassBlock registerStainedGlass(DyeColor color, Block base) {
        return new StainedGlassBlock(color, FabricBlockSettings.copy(base).allowsSpawning(BlocksRegistration::never).solidBlock(BlocksRegistration::never).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never));
    }

    public static StainedGlassPaneBlock registerStainedGlassPane(DyeColor color, Block base) {
        return new StainedGlassPaneBlock(color, FabricBlockSettings.copy(base));
    }

    // Asphalt

    public static AsphaltBlock registerAsphaltBlock(DyeColor color) {
        return new AsphaltBlock(FabricBlockSettings.of(Material.STONE, color).strength(1.5f, 6.0f).requiresTool());
    }

    public static Block registerAsphaltSlab(String id, Block base) {
        return register(id + "_slab", new AsphaltSlab(FabricBlockSettings.copy(base)));
    }

    public static Block registerAsphaltSlab(Block base) {
        return registerAsphaltSlab(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Block registerAsphaltStairs(String id, Block base) {
        return register(id + "_stairs", new AsphaltStairs(base.getDefaultState(), FabricBlockSettings.copy(base)));
    }

    public static Block registerAsphaltStairs(Block base) {
        return registerAsphaltStairs(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Other

    public static Block registerCrates() {
        return new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).sounds(BlockSoundGroup.WOOD));
    }

    public static Block registerLightCrates() {
        return new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).luminance(14).sounds(BlockSoundGroup.WOOD));
    }


    public static Block registerShingles(Block base) {
        return new Block(FabricBlockSettings.copy(base).sounds(BlockSoundGroup.NETHER_BRICKS));
    }

    // Register

    public static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, id), block);

    }

    public static boolean always(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    public static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

}
