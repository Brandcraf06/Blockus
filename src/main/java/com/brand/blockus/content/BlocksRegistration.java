package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.HorizontalAxisBlockBase;
import com.brand.blockus.blocks.base.OrientableBlockBase;
import com.brand.blockus.blocks.base.PaneBlockBase;
import com.brand.blockus.blocks.base.StairsBase;
import com.brand.blockus.blocks.base.redstone.*;
import com.brand.blockus.blocks.special.Barrier;
import com.brand.blockus.blocks.special.LargeFlowerPotBlock;
import com.brand.blockus.blocks.special.SmallHedgeBlock;
import com.brand.blockus.blocks.special.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.special.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.special.asphalt.AsphaltStairs;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class BlocksRegistration {

    // General
    public static Block registerBlockCopy(String id, Block base) {
        return register(id, new Block(FabricBlockSettings.copy(base)));
    }

    public static Block registerBlockCopy(String id, Block base, Tag<Item> tag, int mininglevel) {
        return register(id, new Block(FabricBlockSettings.copyOf(base).breakByTool(tag, mininglevel)));
    }

    public static Block registerBlockCopy(String id, Block base, MapColor color) {
        return register(id, new Block(FabricBlockSettings.copyOf(base).mapColor(color)));
    }

    public static Block registerFallingBlock(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return register(id, new FallingBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel)));
    }

    public static Block registerCirclePavement(String id, Block base) {
        return register(id + "_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerPane(String id, Block base) {
        return register(id, new PaneBlockBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerWoodenPane(String id) {
        return register(id, new PaneBlockBase(FabricBlockSettings.of(Material.WOOD).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD)));
    }

    // Pillar
    public static Block registerPillar(String id, Block base) {
        return register(id + "_pillar", new PillarBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerPillar(Block base) {
        return registerPillar(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Block registerPillar(String id, Block base, Tag<Item> tag, int mininglevel) {
        return register(id + "_pillar", new PillarBlock(FabricBlockSettings.copyOf(base).breakByTool(tag, mininglevel)));
    }

    public static Block registerPillar2(String id, Block base) {
        return register(id, new PillarBlock(FabricBlockSettings.copy(base)));
    }

    // Slab
    public static Block registerSlab(String id, Block base) {
        return register(id + "_slab", new SlabBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerSlab(Block base) {
        return registerSlab(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Block registerSlab(String id, Block base, Tag<Item> tag, int mininglevel) {
        return register(id + "_slab", new SlabBlock(FabricBlockSettings.copyOf(base).breakByTool(tag, mininglevel)));
    }

    public static Block registerFireproofSlab(String id, Block base) {
        return register(id + "_slab", new SlabBlock(FabricBlockSettings.copy(base)));
    }

    // Stairs
    public static Block registerStairs(String id, Block base) {
        return register(id + "_stairs", new StairsBase(base.getDefaultState(), FabricBlockSettings.copy(base)));
    }

    public static Block registerStairs(Block base) {
        return registerStairs(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Block registerStairs(String id, Block base, Tag<Item> tag, int mininglevel) {
        return register(id + "_stairs", new StairsBase(base.getDefaultState(), FabricBlockSettings.copyOf(base).breakByTool(tag, mininglevel)));
    }

    public static Block registerFireproofStairs(String id, Block base) {
        return register(id + "_stairs", new StairsBase(base.getDefaultState(), FabricBlockSettings.copy(base)));
    }

    // Wall
    public static Block registerWall(String id, Block base) {
        return register(id + "_wall", new WallBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerWall(Block base) {
        return registerWall(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Block registerWall(String id, Block base, Tag<Item> tag, int mininglevel) {
        return register(id + "_wall", new WallBlock(FabricBlockSettings.copyOf(base).breakByTool(tag, mininglevel)));
    }

    public static Block registerBarrier(String id, float hardness, float resistance) {
        return register(id + "_barrier", new Barrier(FabricBlockSettings.of(Material.STONE).strength(hardness, resistance).requiresTool()));
    }

    public static Block registerSmallHedge(String id, Block base) {
        return register(id, new SmallHedgeBlock(FabricBlockSettings.copyOf(base).breakByTool(FabricToolTags.HOES).allowsSpawning(BlocksRegistration::canSpawnOnLeaves).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never)));
    }

    // Fence
    public static Block registerFence(String id, Block base) {
        return register(id + "_fence", new FenceBlock(FabricBlockSettings.copy(base)));
    }

    // Fence Gate
    public static Block registerFenceGate(String id, Block base) {
        return register(id + "_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(base)));
    }

    // Pressure Plate
    public static Block registerPressurePlate(String id, PressurePlateBlock.ActivationRule type, Block base) {
        return register(id + "_pressure_plate", new PressurePlateBase(type, FabricBlockSettings.copy(base)));
    }

    // Button
    public static Block registerWoodenButton(String id, Block base) {
        return register(id + "_button", new WoodenButtonBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerStoneButton(String id, Block base) {
        return register(id + "_button", new StoneButtonBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerStoneButton(Block base) {
        return registerStoneButton(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Plants
    public static Block registerPottedPlant(Block content, String id) {
        return register("potted_" + id, new FlowerPotBlock(content, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()));
    }

    public static Block registerLargeFlowerPot(Block content, String id) {
        return register(id, new LargeFlowerPotBlock(content, FabricBlockSettings.of(Material.DECORATION).strength(0.5F, 1.0F).nonOpaque()));
    }

    public static Block registerPottedDoublePlant(Block content, String id) {
        return register("potted_" + id, new LargeFlowerPotBlock(content, FabricBlockSettings.of(Material.DECORATION).strength(0.5F, 1.0F).nonOpaque()));
    }

    // Door & Trapdoor
    public static Block registerDoor(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return register(id + "_door", new DoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel).nonOpaque()));
    }

    public static Block registerDoor2(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return register(id + "_door", new DoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel).nonOpaque().requiresTool()));
    }

    public static Block registerTrapdoor(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return register(id + "_trapdoor", new TrapdoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel).nonOpaque()));
    }

    public static Block registerTrapdoor2(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return register(id + "_trapdoor", new TrapdoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel).nonOpaque().requiresTool()));
    }

    public static Block registerGate(String id, Block base) {
        return register(id + "_gate", new DoorBase(FabricBlockSettings.copy(base)));
    }

    // Timber Frames

    public static Block registerTimberFrame(String id, Block base) {
        return register(id + "_timber_frame", new Block(FabricBlockSettings.copy(base)));
    }

    public static Block registerOrientableTimberFrame(String id, Block base) {
        return register(id + "_timber_frame", new OrientableBlockBase(FabricBlockSettings.copy(base)));
    }


    // Light
    public static Block registerLightBlock(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, int luminance, MapColor color) {
        return register(id, new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).luminance(luminance).requiresTool()));
    }

    public static Block registerLampBlock(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, int luminance, MapColor color) {
        return register(id, new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).luminance(luminance)));
    }

    public static Block registerLanternBlock(String id, Block base) {
        return register(id, new Block(FabricBlockSettings.copy(base)));
    }

    public static Block registerRedstoneLamp(String id) {
        return register(id, new RedstoneLampBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).allowsSpawning(BlocksRegistration::always)));
    }

    public static Block registerLitRedstoneLamp(String id) {
        return register(id + "_lit", new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).allowsSpawning(BlocksRegistration::always)));
    }

    public static Block registerFuturneoBlock(String id, MapColor color) {
        return register(id + "_futurneo_block", new Block(FabricBlockSettings.of(Material.REDSTONE_LAMP, color).luminance(15).strength(0.5f, 0.5f).sounds(BlockSoundGroup.GLASS).allowsSpawning(BlocksRegistration::always)));
    }

    // Colors

    public static Block registerColoredTiles(String id, Block base) {
        return register(id + "_colored_tiles", new Block(FabricBlockSettings.copy(base)));
    }

    public static Block registerColoredTiles2(String id, Block base) {
        return register(id + "_colored_tiles", new HorizontalAxisBlockBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerPatternedWool(String id, Block base) {
        return register(id + "_patterned_wool", new OrientableBlockBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerColoredStoneBricks(String id, MapColor color) {
        return register(id + "_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE, color).strength(1.5F, 6.0F).requiresTool()));
    }

    // Glass
    public static Block registerGlass(String id, Block base) {
        return register(id, new GlassBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerStainedGlass(String id, DyeColor color, Block base) {
        return register(id, new StainedGlassBlock(color, FabricBlockSettings.copyOf(base).allowsSpawning(BlocksRegistration::never).solidBlock(BlocksRegistration::never).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never)));
    }

    public static Block registerStainedGlassPane(String id, DyeColor color, Block base) {
        return register(id, new StainedGlassPaneBlock(color, FabricBlockSettings.copy(base)));
    }

    // Asphalt
    public static Block register(String id, DyeColor color) {
        return register(id, new AsphaltBlock(FabricBlockSettings.of(Material.STONE, color).strength(1.5f, 6.0f).requiresTool()));
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

    public static Block registerCrates(String id) {
        return register(id + "_crate", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)));
    }

    public static Block registerChain(String id, Block base) {
        return register(id + "_chain", new ChainBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerShingles(String id, Block base) {
        return register(id, new Block(FabricBlockSettings.copyOf(base).sounds(BlockSoundGroup.NETHER_BRICKS)));
    }

    // Register

    public static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, id), block);

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