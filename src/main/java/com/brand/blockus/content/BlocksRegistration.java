package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.Barrier;
import com.brand.blockus.blocks.base.LargeFlowerPotBlock;
import com.brand.blockus.blocks.base.SmallHedgeBlock;
import com.brand.blockus.blocks.blockitems.GlintBlockItem;
import com.brand.blockus.blocks.blockitems.LegacyBlockItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BlocksRegistration {

    public static String replaceId(String id) {
        return id.replace("bricks", "brick").replace("tiles", "tile").replace("_block", "").replace("_planks", "");
    }

    // Copy

    public static Block createCopy(Block base) {
        return new Block(FabricBlockSettings.copy(base));
    }

    public static Block createPillarCopy(Block base) {
        return new PillarBlock(FabricBlockSettings.copy(base));
    }

    // Pillar
    public static Block createPillar(String baseid, Block base) {
        return register(replaceId(baseid) + "_pillar", new PillarBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerPillar(Block base) {
        return createPillar(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Slab
    public static Block createSlab(String baseid, Block base) {
        return register(replaceId(baseid) + "_slab", new SlabBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerSlab(Block base) {
        return createSlab(Registries.BLOCK.getId(base).getPath(), base);
    }


    // Stairs
    public static Block createStairs(String baseid, Block base) {
        return register(replaceId(baseid) + "_stairs", new StairsBlock(base.getDefaultState(), FabricBlockSettings.copy(base)));
    }

    public static Block registerStairs(Block base) {
        return createStairs(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Wall
    public static Block createWall(String baseid, Block base) {
        return register(replaceId(baseid) + "_wall", new WallBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerWall(Block base) {
        return createWall(Registries.BLOCK.getId(base).getPath(), base);
    }


    public static Barrier createBarrier(float hardness, float resistance, MapColor color) {
        return new Barrier(FabricBlockSettings.create().mapColor(color).strength(hardness, resistance).instrument(Instrument.BASEDRUM).requiresTool());
    }

    public static Block registerSmallHedge(String id, Block base) {
        return register(id, new SmallHedgeBlock(FabricBlockSettings.copyOf(base).allowsSpawning(BlocksRegistration::canSpawnOnLeaves).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never)));
    }


    // Pressure Plate
    public static Block createPressurePlate(String baseid, PressurePlateBlock.ActivationRule type, Block base, BlockSetType blockSetType) {
        return register(replaceId(baseid) + "_pressure_plate", new PressurePlateBlock(type, FabricBlockSettings.copy(base).noCollision().pistonBehavior(PistonBehavior.DESTROY), blockSetType));
    }

    public static Block registerStonePressurePlate(Block base) {
        return createPressurePlate(Registries.BLOCK.getId(base).getPath(), PressurePlateBlock.ActivationRule.MOBS, base, BlockSetType.STONE);
    }

    public static Block registerWoodenPressurePlate(Block base) {
        return createPressurePlate(Registries.BLOCK.getId(base).getPath(), PressurePlateBlock.ActivationRule.EVERYTHING, base, BlockSetType.OAK);
    }

    // Button
    public static Block createStoneButton(String id, Block base) {
        return register(id + "_button", new ButtonBlock(FabricBlockSettings.copyOf(base).noCollision().pistonBehavior(PistonBehavior.DESTROY), BlockSetType.STONE, 20, false));
    }

    public static Block registerStoneButton(Block base) {
        return createStoneButton(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Plants
    public static FlowerPotBlock createPottedPlant(Block content) {
        return new FlowerPotBlock(content, FabricBlockSettings.create().instrument(Instrument.BASEDRUM).breakInstantly().pistonBehavior(PistonBehavior.DESTROY).nonOpaque());
    }

    public static LargeFlowerPotBlock createLargeFlowerPot(Block content) {
        return new LargeFlowerPotBlock(content, FabricBlockSettings.create().instrument(Instrument.BASEDRUM).strength(0.5F, 1.0F).pistonBehavior(PistonBehavior.BLOCK).nonOpaque());
    }

    // Door & Trapdoor
    public static DoorBlock createWoodenDoor(float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return new DoorBlock(FabricBlockSettings.create().mapColor(color).instrument(Instrument.BASS).strength(hardness, resistance).sounds(sound).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).burnable(), blockSetType);
    }

    public static DoorBlock createStoneDoor(float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return new DoorBlock(FabricBlockSettings.create().mapColor(color).instrument(Instrument.BASEDRUM).strength(hardness, resistance).sounds(sound).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).requiresTool(), blockSetType);
    }

    public static TrapdoorBlock createWoodenTrapdoor(float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return new TrapdoorBlock(FabricBlockSettings.create().mapColor(color).instrument(Instrument.BASS).strength(hardness, resistance).sounds(sound).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).burnable(), blockSetType);
    }

    public static TrapdoorBlock createStoneTrapdoor(float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return new TrapdoorBlock(FabricBlockSettings.create().mapColor(color).instrument(Instrument.BASEDRUM).strength(hardness, resistance).sounds(sound).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).requiresTool(), blockSetType);
    }

    // Light

    public static Block createLampBlock(float hardness, float resistance, BlockSoundGroup sound, int luminance, MapColor color) {
        return new Block(FabricBlockSettings.create().mapColor(color).strength(hardness, resistance).sounds(sound).luminance(luminance));
    }

    public static Block createLightBlock(float hardness, float resistance, BlockSoundGroup sound, int luminance, MapColor color) {
        return new Block(FabricBlockSettings.create().mapColor(color).strength(hardness, resistance).sounds(sound).luminance(luminance).instrument(Instrument.BASEDRUM).requiresTool());
    }

    public static Block createNeonBlock(DyeColor color) {
        return new Block(FabricBlockSettings.create().mapColor(color).luminance(3).sounds(BlockSoundGroup.GLASS).strength(0.5f, 0.5f).emissiveLighting(BlocksRegistration::always).allowsSpawning(BlocksRegistration::never));
    }

    public static RedstoneLampBlock createRedstoneLamp() {
        return new RedstoneLampBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).allowsSpawning(BlocksRegistration::always));
    }

    public static Block createLitRedstoneLamp() {
        return new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).allowsSpawning(BlocksRegistration::always));
    }

    public static Block createFuturneoBlock(MapColor color) {
        return new Block(FabricBlockSettings.create().mapColor(color).luminance(15).strength(0.5f, 0.5f).sounds(BlockSoundGroup.GLASS).allowsSpawning(BlocksRegistration::always));
    }


    // Glass
    public static StainedGlassBlock createStainedGlass(DyeColor color, Block base) {
        return new StainedGlassBlock(color, FabricBlockSettings.copy(base).allowsSpawning(BlocksRegistration::never).solidBlock(BlocksRegistration::never).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never));
    }

    public static StainedGlassPaneBlock createstainedGlassPane(DyeColor color, Block base) {
        return new StainedGlassPaneBlock(color, FabricBlockSettings.copy(base));
    }

    // Other
    public static FallingBlock createFallingBlock(float hardness, float resistance, BlockSoundGroup sound, MapColor color) {
        return new FallingBlock(FabricBlockSettings.create().mapColor(color).strength(hardness, resistance).sounds(sound));
    }

    public static PaneBlock createWoodenPane() {
        return new PaneBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD).burnable());
    }

    public static Block createCrates() {
        return new Block(FabricBlockSettings.create().mapColor(Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).instrument(Instrument.BASS).sounds(BlockSoundGroup.WOOD));
    }

    public static Block createLightCrate() {
        return new Block(FabricBlockSettings.create().mapColor(Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).luminance(14).instrument(Instrument.BASS).sounds(BlockSoundGroup.WOOD));
    }

    // Register
    public static Block register(String id, Block block, BlockItem item) {
        Registry.register(Registries.BLOCK, Blockus.id(id), block);
        Registry.register(Registries.ITEM, Blockus.id(id), item);

        return block;
    }

    public static Block registerNoItem(String id, Block block) {
        return Registry.register(Registries.BLOCK, Blockus.id(id), block);
    }

    public static Block register(String id, Block block) {
        return register(id, block, new BlockItem(block, new Item.Settings()));
    }

    public static Block registerGlint(String id, Block block) {
        return register(id, block, new GlintBlockItem(block, new Item.Settings().rarity(Rarity.UNCOMMON)));
    }

    public static Block registerLegacy(String id, Block block) {
        return register(id, block, new LegacyBlockItem(block, new Item.Settings()));
    }

    public static Block registerFireproof(String id, Block block) {
        return register(id, block, new BlockItem(block, new Item.Settings().fireproof()));
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
