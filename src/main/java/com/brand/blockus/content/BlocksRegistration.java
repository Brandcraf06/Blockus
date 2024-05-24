package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.Barrier;
import com.brand.blockus.blocks.base.LargeFlowerPotBlock;
import com.brand.blockus.blocks.base.SimpleFallingBlock;
import com.brand.blockus.blocks.base.SmallHedgeBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystSlabBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystStairsBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystWallBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneSlabBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneStairsBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneWallBlock;
import com.brand.blockus.blocks.blockitems.GlintBlockItem;
import com.brand.blockus.blocks.blockitems.LegacyBlockItem;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
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

    public static boolean isAmethyst(String baseid) {
        return baseid.contains("amethyst");
    }

    public static boolean isRedstone(String baseid) {
        return baseid.contains("redstone");
    }

    public static boolean isNetherite(String baseid) {
        return baseid.contains("netherite");
    }

    // Copy
    public static Block createCopy(Block base) {
        return new Block(AbstractBlock.Settings.copy(base));
    }

    public static Block createCopy(Block base, PistonBehavior pistonBehavior) {
        return new Block(AbstractBlock.Settings.copy(base).pistonBehavior(pistonBehavior));
    }

    public static Block createPillarCopy(Block base) {
        return new PillarBlock(AbstractBlock.Settings.copy(base));
    }

    // Pillar
    public static Block createPillar(String baseid, Block base) {
        return register(replaceId(baseid) + "_pillar", new PillarBlock(AbstractBlock.Settings.copy(base)));
    }

    public static Block registerPillar(Block base) {
        return createPillar(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Slab
    public static Block createSlab(String baseid, Block base) {
        String slabId = replaceId(baseid) + "_slab";
        if (isAmethyst(baseid)) {
            return register(slabId, new AmethystSlabBlock(AbstractBlock.Settings.copy(base)));
        } else if (isRedstone(baseid)) {
            return register(slabId, new RedstoneSlabBlock(AbstractBlock.Settings.copy(base)));
        } else {
            return register(slabId, new SlabBlock(AbstractBlock.Settings.copy(base)));
        }
    }

    public static Block registerSlab(Block base) {
        return createSlab(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Stairs
    public static Block createStairs(String baseid, Block base) {
        String slabId = replaceId(baseid) + "_stairs";
        if (isAmethyst(baseid)) {
            return register(slabId, new AmethystStairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base)));
        } else if (isRedstone(baseid)) {
            return register(slabId, new RedstoneStairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base)));
        } else {
            return register(slabId, new StairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base)));
        }
    }

    public static Block registerStairs(Block base) {
        return createStairs(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Wall
    public static Block createWall(String baseid, Block base) {
        String slabId = replaceId(baseid) + "_wall";
        if (isAmethyst(baseid)) {
            return register(slabId, new AmethystWallBlock(AbstractBlock.Settings.copy(base)));
        } else if (isRedstone(baseid)) {
            return register(slabId, new RedstoneWallBlock(AbstractBlock.Settings.copy(base)));
        } else {
            return register(slabId, new WallBlock(AbstractBlock.Settings.copy(base)));
        }
    }

    public static Block registerWall(Block base) {
        return createWall(Registries.BLOCK.getId(base).getPath(), base);
    }

    public static Barrier createBarrier(float hardness, float resistance, MapColor color) {
        return new Barrier(AbstractBlock.Settings.create().mapColor(color).strength(hardness, resistance).instrument(NoteBlockInstrument.BASEDRUM).requiresTool());
    }

    public static Block registerSmallHedge(String id, Block base) {
        return register(id, new SmallHedgeBlock(AbstractBlock.Settings.copy(base).allowsSpawning(BlocksRegistration::canSpawnOnLeaves).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never)));
    }


    // Pressure Plate
    public static Block createPressurePlate(String baseid, Block base, BlockSetType blockSetType) {
        return register(replaceId(baseid) + "_pressure_plate", new PressurePlateBlock(blockSetType, AbstractBlock.Settings.copy(base).solid().noCollision().pistonBehavior(PistonBehavior.DESTROY)));
    }

    public static Block registerStonePressurePlate(Block base) {
        return createPressurePlate(Registries.BLOCK.getId(base).getPath(), base, BlockSetType.STONE);
    }

    public static Block registerWoodenPressurePlate(Block base) {
        return createPressurePlate(Registries.BLOCK.getId(base).getPath(), base, BlockSetType.OAK);
    }

    // Button
    public static Block createStoneButton(String id, Block base) {
        return register(id + "_button", new ButtonBlock(BlockSetType.STONE, 20, AbstractBlock.Settings.copy(base).noCollision().pistonBehavior(PistonBehavior.DESTROY)));
    }

    public static Block registerStoneButton(Block base) {
        return createStoneButton(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Plants
    public static FlowerPotBlock createPottedPlant(Block content) {
        return new FlowerPotBlock(content, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).breakInstantly().pistonBehavior(PistonBehavior.DESTROY).nonOpaque());
    }

    public static LargeFlowerPotBlock createLargeFlowerPot(Block content) {
        return new LargeFlowerPotBlock(content, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F, 1.0F).pistonBehavior(PistonBehavior.BLOCK).nonOpaque());
    }

    // Door & Trapdoor
    public static AbstractBlock.Settings createDoorTrapdoorBlockSettings(float hardness, float resistance, BlockSoundGroup sound, MapColor color, NoteBlockInstrument instrument) {
        return AbstractBlock.Settings.create().mapColor(color).instrument(instrument).strength(hardness, resistance).sounds(sound).nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    }

    public static DoorBlock createWoodenDoor(float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return new DoorBlock(blockSetType, createDoorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASS).burnable());
    }

    public static DoorBlock createStoneDoor(float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return new DoorBlock(blockSetType, createDoorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM).requiresTool());
    }

    public static TrapdoorBlock createWoodenTrapdoor(float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return new TrapdoorBlock(blockSetType, createDoorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASS).burnable());
    }

    public static TrapdoorBlock createStoneTrapdoor(float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return new TrapdoorBlock(blockSetType, createDoorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM).requiresTool());
    }

    // Light

    public static Block createLampBlock(float hardness, float resistance, BlockSoundGroup sound, int luminance, MapColor color) {
        return new Block(AbstractBlock.Settings.create().mapColor(color).strength(hardness, resistance).sounds(sound).luminance((state) -> luminance));
    }

    public static Block createGlowingObsidian(Block base, int luminance, PistonBehavior pistonBehavior) {
        return new Block(AbstractBlock.Settings.copy(base).luminance((state) -> luminance).pistonBehavior(pistonBehavior));
    }

    public static Block createNeonBlock(DyeColor color) {
        return new Block(AbstractBlock.Settings.create().mapColor(color).luminance((state) -> 3).sounds(BlockSoundGroup.GLASS).strength(0.5f, 0.5f).emissiveLighting(BlocksRegistration::always).allowsSpawning(BlocksRegistration::never));
    }

    public static RedstoneLampBlock createRedstoneLamp() {
        return new RedstoneLampBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_LAMP).allowsSpawning(BlocksRegistration::always));
    }

    public static Block createLitRedstoneLamp() {
        return new Block(AbstractBlock.Settings.copy(Blocks.REDSTONE_LAMP).luminance((state) -> 15).allowsSpawning(BlocksRegistration::always));
    }

    public static Block createFuturneoBlock(MapColor color) {
        return new Block(AbstractBlock.Settings.create().mapColor(color).luminance((state) -> 15).strength(0.5f, 0.5f).sounds(BlockSoundGroup.GLASS).allowsSpawning(BlocksRegistration::always));
    }


    // Glass
    public static StainedGlassBlock createStainedGlass(DyeColor color, Block base) {
        return new StainedGlassBlock(color, AbstractBlock.Settings.copy(base).allowsSpawning(BlocksRegistration::never).solidBlock(BlocksRegistration::never).suffocates(BlocksRegistration::never).blockVision(BlocksRegistration::never));
    }

    public static StainedGlassPaneBlock createstainedGlassPane(DyeColor color, Block base) {
        return new StainedGlassPaneBlock(color, AbstractBlock.Settings.copy(base));
    }

    // Other
    public static SimpleFallingBlock createFallingBlock(float hardness, float resistance, BlockSoundGroup sound, MapColor color) {
        return new SimpleFallingBlock(AbstractBlock.Settings.create().mapColor(color).strength(hardness, resistance).sounds(sound));
    }

    public static PaneBlock createWoodenPane() {
        return new PaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD).burnable());
    }

    public static Block createCrates() {
        return new Block(AbstractBlock.Settings.create().mapColor(Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.WOOD));
    }

    public static Block createLightCrate() {
        return new Block(AbstractBlock.Settings.create().mapColor(Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).luminance((state) -> 14).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.WOOD));
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
        Item.Settings itemSettings = new Item.Settings();
        if (isNetherite(id)) {
            itemSettings = itemSettings.fireproof();
        }
        return register(id, block, new BlockItem(block, itemSettings));
    }

    public static Block registerGlint(String id, Block block) {
        return register(id, block, new GlintBlockItem(block, new Item.Settings().rarity(Rarity.UNCOMMON)));
    }

    public static Block registerLegacy(String id, Block block) {
        return register(id, block, new LegacyBlockItem(block, new Item.Settings()));
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
