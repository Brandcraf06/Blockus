package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.*;
import com.brand.blockus.blocks.base.redstone.DoorBase;
import com.brand.blockus.blocks.base.redstone.PressurePlateBase;
import com.brand.blockus.blocks.base.redstone.StoneButtonBase;
import com.brand.blockus.blocks.base.redstone.TrapdoorBase;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class BlocksRegistration {



    // Pillar
    public static Block createPillar(String baseid, Block base) {
        String id = baseid.replace("bricks", "brick");
        return register(id + "_pillar", new PillarBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerPillar(Block base) {
        return createPillar(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Block createGTPillar(String baseid, Block base) {
        String id = baseid.replace("bricks", "brick");
        return registerDecoration(id + "_pillar", new PillarBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerGTPillar(Block base) {
        return createGTPillar(Registry.BLOCK.getId(base).getPath(), base);
    }


    // Slab
    public static Block createSlab(String baseid, Block base) {
        String id = baseid.replace("bricks", "brick").replace("tiles", "tile");
        return register(id + "_slab", new SlabBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerSlab(Block base) {
        return createSlab(Registry.BLOCK.getId(base).getPath(), base);
    }


    // Stairs
    public static Block createStairs(String baseid, Block base) {
        String id = baseid.replace("bricks", "brick").replace("tiles", "tile");
        return register(id + "_stairs", new StairsBase(base.getDefaultState(), FabricBlockSettings.copy(base)));
    }

    public static Block registerStairs(Block base) {
        return createStairs(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Wall
    public static Block createWall(String baseid, Block base) {
        String id = baseid.replace("bricks", "brick").replace("tiles", "tile");
        return registerDecoration(id + "_wall", new WallBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerWall(Block base) {
        return createWall(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Barrier createBarrier(float hardness, float resistance) {
        return new Barrier(FabricBlockSettings.of(Material.STONE).strength(hardness, resistance).requiresTool());
    }

    public static Block registerSmallHedge(String id, Block base) {
        return registerDecoration(id, new SmallHedgeBlock(FabricBlockSettings.copyOf(base).allowsSpawning(BlocksRegistration::canSpawnOnLeaves).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never)));
    }



    // Pressure Plate

    public static Block createPressurePlate(String baseid, PressurePlateBlock.ActivationRule type, Block base) {
        String id = baseid.replace("_planks", "");
        return registerRedstone(id + "_pressure_plate", new PressurePlateBase(type, FabricBlockSettings.copy(base).noCollision()));
    }

    public static Block registerPressurePlate(PressurePlateBlock.ActivationRule type, Block base) {
        return createPressurePlate(Registry.BLOCK.getId(base).getPath(), type, base);
    }

    // Button

    public static Block createStoneButton(String id, Block base) {
        return registerRedstone(id + "_button", new StoneButtonBase(FabricBlockSettings.copy(base).noCollision()));
    }

    public static Block registerStoneButton(Block base) {
        return createStoneButton(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Plants

    public static FlowerPotBlock createPottedPlant(Block content) {
        return new FlowerPotBlock(content, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque());
    }

    public static LargeFlowerPotBlock createLargeFlowerPot(Block content) {
        return new LargeFlowerPotBlock(content, FabricBlockSettings.of(Material.DECORATION).strength(0.5F, 1.0F).nonOpaque());
    }

    public static LargeFlowerPotBlock createPottedDoublePlant(Block content) {
        return new LargeFlowerPotBlock(content, FabricBlockSettings.of(Material.DECORATION).strength(0.5F, 1.0F).nonOpaque());
    }

    // Door & Trapdoor

    public static DoorBase createDoor(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new DoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).nonOpaque());
    }

    public static DoorBase createStoneDoor(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new DoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).nonOpaque().requiresTool());
    }

    public static TrapdoorBase createTrapdoor(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new TrapdoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).nonOpaque());
    }

    public static TrapdoorBase createStoneTrapdoor(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new TrapdoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).nonOpaque().requiresTool());
    }

    // Light

    public static Block createLightBlock(float hardness, float resistance, Material material, BlockSoundGroup sound, int luminance, MapColor color) {
        return new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).luminance(luminance).requiresTool());
    }

    public static Block createLampBlock(float hardness, float resistance, Material material, BlockSoundGroup sound, int luminance, MapColor color) {
        return new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).luminance(luminance));
    }

    public static Block createNeonBlock(DyeColor color) {
        return new Block(FabricBlockSettings.of(Material.GLASS, color).luminance(3).sounds(BlockSoundGroup.GLASS).strength(0.5f, 0.5f).emissiveLighting(BlocksRegistration::always).allowsSpawning(BlocksRegistration::never));
    }

    public static RedstoneLampBlock createRedstoneLamp() {
        return new RedstoneLampBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).allowsSpawning(BlocksRegistration::always));
    }

    public static Block createLitRedstoneLamp() {
        return new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).allowsSpawning(BlocksRegistration::always));
    }

    public static Block createFuturneoBlock(MapColor color) {
        return new Block(FabricBlockSettings.of(Material.REDSTONE_LAMP, color).luminance(15).strength(0.5f, 0.5f).sounds(BlockSoundGroup.GLASS).allowsSpawning(BlocksRegistration::always));
    }


    // Glass
    public static StainedGlassBlock createStainedGlass(DyeColor color, Block base) {
        return new StainedGlassBlock(color, FabricBlockSettings.copy(base).allowsSpawning(BlocksRegistration::never).solidBlock(BlocksRegistration::never).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never));
    }

    public static StainedGlassPaneBlock createstainedGlassPane(DyeColor color, Block base) {
        return new StainedGlassPaneBlock(color, FabricBlockSettings.copy(base));
    }

    // Asphalt

    // Other

    public static FallingBlock createFallingBlock(float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return new FallingBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound));
    }

    public static PaneBlockBase createWoodenPane() {
        return new PaneBlockBase(FabricBlockSettings.of(Material.WOOD).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD));
    }

    public static Block createStainedStoneBricks(MapColor color) {
        return new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).mapColor(color));
    }

    public static Block createCrates() {
        return new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).sounds(BlockSoundGroup.WOOD));
    }

    public static Block createLightCrates() {
        return new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).luminance(14).sounds(BlockSoundGroup.WOOD));
    }

    public static Block createShingles(Block base) {
        return new Block(FabricBlockSettings.copy(base).sounds(BlockSoundGroup.NETHER_BRICKS));
    }

    // Register


    public static Block register(String id, Block block) {
        Registry.register(Registry.BLOCK, Blockus.id(id), block);
        Registry.register(Registry.ITEM, Blockus.id(id), new BlockItem(block, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));

        return block;
    }

    public static Block registerDecoration(String id, Block block) {
        Registry.register(Registry.BLOCK, Blockus.id(id), block);
        Registry.register(Registry.ITEM, Blockus.id(id), new BlockItem(block, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_DECORATIONS)));

        return block;
    }

    public static Block registerRedstone(String id, Block block) {
        Registry.register(Registry.BLOCK, Blockus.id(id), block);
        Registry.register(Registry.ITEM, Blockus.id(id), new BlockItem(block, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_REDSTONE)));

        return block;
    }

    public static Block registerLegacy(String id, Block block) {
        Registry.register(Registry.BLOCK, Blockus.id(id), block);
        Registry.register(Registry.ITEM, Blockus.id(id), new BlockItem(block, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_LEGACY)));

        return block;
    }

    public static Block registerNoItem(String id, Block block) {
        return Registry.register(Registry.BLOCK, Blockus.id(id), block);
    }

    public static Block registerFireproof(String id, Block block) {
        Registry.register(Registry.BLOCK, Blockus.id(id), block);
        Registry.register(Registry.ITEM, Blockus.id(id), new BlockItem(block, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS).fireproof()));

        return block;
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
