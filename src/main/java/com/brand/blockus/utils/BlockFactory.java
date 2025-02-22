package com.brand.blockus.utils;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.LargeFlowerPotBlock;
import com.brand.blockus.blocks.base.SmallHedgeBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystSlabBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystStairsBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystWallBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneSlabBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneStairsBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneWallBlock;
import com.brand.blockus.blocks.blockitems.LegacyBlockItem;
import com.brand.blockus.blocks.blockitems.NetherStarBlockItem;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.function.Function;

public class BlockFactory {

    public static String replaceId(String id) {
        return id.replace("bricks", "brick").replace("tiles", "tile").replace("_block", "").replace("_planks", "");
    }

    // Base
    public static AbstractBlock.Settings create() {
        return AbstractBlock.Settings.create();
    }

    public static AbstractBlock.Settings createCopy(Block base) {
        return AbstractBlock.Settings.copy(base);
    }

    public static AbstractBlock.Settings createCopy(Block base, PistonBehavior pistonBehavior) {
        return createCopy(base).pistonBehavior(pistonBehavior);
    }

    // Pillar
    public static Block registerPillar(String baseId, Block base) {
        return register(replaceId(baseId) + "_pillar", PillarBlock::new, createCopy(base));
    }

    public static Block registerPillar(Block base) {
        return registerPillar(Registries.BLOCK.getId(base).getPath(), base);
    }

    public static Block registerPillar2(String id, Block base) {
        return register(id, PillarBlock::new, createCopy(base));
    }

    // Slab
    public static Block createSlab(String baseId, Block base) {
        String slabId = replaceId(baseId) + "_slab";
        if (BlockChecker.isAmethyst(baseId)) {
            return register(slabId, AmethystSlabBlock::new, createCopy(base));
        } else if (BlockChecker.isRedstone(baseId)) {
            return register(slabId, RedstoneSlabBlock::new, createCopy(base));
        } else {
            return register(slabId, SlabBlock::new, createCopy(base));
        }
    }

    public static Block registerSlab(Block base) {
        return createSlab(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Stairs
    public static Block createStairs(String baseId, Block base) {
        String stairsId = replaceId(baseId) + "_stairs";
        if (BlockChecker.isAmethyst(baseId)) {
            return register(stairsId, (settings) -> new AmethystStairsBlock(base.getDefaultState(), settings), createCopy(base));
        } else if (BlockChecker.isRedstone(baseId)) {
            return register(stairsId, (settings) -> new RedstoneStairsBlock(base.getDefaultState(), settings), createCopy(base));
        } else {
            return register(stairsId, (settings) -> new StairsBlock(base.getDefaultState(), settings), createCopy(base));
        }
    }

    public static Block registerStairs(Block base) {
        return createStairs(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Wall
    public static Block createWall(String baseId, Block base) {
        String wallId = replaceId(baseId) + "_wall";
        if (BlockChecker.isAmethyst(baseId)) {
            return register(wallId, AmethystWallBlock::new, createCopy(base));
        } else if (BlockChecker.isRedstone(baseId)) {
            return register(wallId, RedstoneWallBlock::new, createCopy(base));
        } else {
            return register(wallId, WallBlock::new, createCopy(base));
        }
    }

    public static Block registerWall(Block base) {
        return createWall(Registries.BLOCK.getId(base).getPath(), base);
    }

    public static Block smallHedge(String id, Block base) {
        return register(id, SmallHedgeBlock::new, createCopy(base).allowsSpawning(BlockFactory::canSpawnOnLeaves).suffocates(BlockFactory::never).blockVision(BlockFactory::never));
    }


    // Pressure Plate & Button
    public static AbstractBlock.Settings createPressurePlateButtonSettings(Block base) {
        return create().mapColor(base.getDefaultMapColor()).strength(0.5f).instrument(base.getDefaultState().getInstrument()).noCollision().pistonBehavior(PistonBehavior.DESTROY);
    }

    public static Block createPressurePlate(String baseId, Block base, BlockSetType blockSetType) {
        return register(replaceId(baseId) + "_pressure_plate", (settings) -> new PressurePlateBlock(blockSetType, settings), createPressurePlateButtonSettings(base).solid());
    }

    public static Block pressurePlate(Block base, BlockSetType blockSetType) {
        return createPressurePlate(Registries.BLOCK.getId(base).getPath(), base, blockSetType);
    }

    public static Block stonePressurePlate(Block base) {
        return pressurePlate(base, BlockSetType.STONE);
    }

    public static Block createButton(String baseId, Block base, BlockSetType blockSetType, int pressTicks) {
        return register(replaceId(baseId) + "_button", (settings) -> new ButtonBlock(blockSetType, pressTicks, settings), createPressurePlateButtonSettings(base));
    }

    public static Block button(Block base, BlockSetType blockSetType, int pressTicks) {
        return createButton(Registries.BLOCK.getId(base).getPath(), base, blockSetType, pressTicks);
    }

    public static Block stoneButton(Block base) {
        return button(base, BlockSetType.STONE, 20);
    }

    // Plants
    public static Block pottedPlant(String id, Block content) {
        return registerNoItem(id, (settings) -> new FlowerPotBlock(content, settings), create().instrument(NoteBlockInstrument.BASEDRUM).breakInstantly().pistonBehavior(PistonBehavior.DESTROY).nonOpaque());
    }

    public static Block largePottedPlant(String id, Block content) {
        return registerNoItem(id, (settings) -> new LargeFlowerPotBlock(content, settings), create().instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F, 1.0F).pistonBehavior(PistonBehavior.BLOCK).nonOpaque());
    }

    public static Block largeFlowerPot(String id) {
        return register(id, (settings) -> new LargeFlowerPotBlock(Blocks.AIR, settings), create().instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F, 1.0F).pistonBehavior(PistonBehavior.BLOCK).nonOpaque());
    }

    // Door & Trapdoor
    public static AbstractBlock.Settings createDoorTrapdoorBlockSettings(float hardness, float resistance, BlockSoundGroup sound, MapColor color, NoteBlockInstrument instrument) {
        return create().mapColor(color).instrument(instrument).strength(hardness, resistance).sounds(sound).nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    }

    public static Block woodenDoor(String id, float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return register(id, (settings) -> new DoorBlock(blockSetType, settings), createDoorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASS).burnable());
    }

    public static Block stoneDoor(String id, float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return register(id, (settings) -> new DoorBlock(blockSetType, settings), createDoorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM));
    }

    public static Block woodenTrapdoor(String id, float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return register(id, (settings) -> new TrapdoorBlock(blockSetType, settings), createDoorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASS).burnable());
    }

    public static Block stoneTrapdoor(String id, float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return register(id, (settings) -> new TrapdoorBlock(blockSetType, settings), createDoorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM).requiresTool());
    }

    // Light
    public static AbstractBlock.Settings createLampBlock(float hardness, float resistance, BlockSoundGroup sound, int luminance, MapColor color) {
        return create().mapColor(color).strength(hardness, resistance).sounds(sound).luminance((state) -> luminance);
    }

    public static Block neonBlock(String id, DyeColor color) {
        return register(id, create().mapColor(color).luminance((state) -> 2).sounds(BlockSoundGroup.GLASS).strength(0.5f, 0.5f).emissiveLighting(BlockFactory::always).allowsSpawning(BlockFactory::never));
    }

    public static Block redstoneLamp(String id, MapColor mapColor) {
        return register(id, RedstoneLampBlock::new, createCopy(Blocks.REDSTONE_LAMP).mapColor(mapColor).allowsSpawning(BlockFactory::always));
    }

    public static Block litRedstoneLamp(String id, Block base) {
        return register(id, createCopy(base).luminance((state) -> 15).allowsSpawning(BlockFactory::always));
    }

    public static Block futurneoBlock(String id, MapColor color) {
        return register(id, create().mapColor(color).luminance((state) -> 15).strength(0.5f, 0.5f).sounds(BlockSoundGroup.GLASS).allowsSpawning(BlockFactory::always));
    }

    // Glass
    public static Block stainedGlass(String id, DyeColor color, Block base) {
        return register(id, (settings) -> new StainedGlassBlock(color, settings), createCopy(base).allowsSpawning(BlockFactory::never).solidBlock(BlockFactory::never).suffocates(BlockFactory::never).blockVision(BlockFactory::never));
    }

    public static Block stainedGlassPane(String id, DyeColor color, Block base) {
        return register(id, (settings) -> new StainedGlassPaneBlock(color, settings), createCopy(base));
    }

    // Other
    public static Block woodenPane(String id) {
        return register(id, PaneBlock::new, create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD).burnable());
    }

    public static AbstractBlock.Settings createCrate() {
        return create().mapColor(Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.WOOD);
    }

    public static Block crate(String id) {
        return register(id, createCrate());
    }

    public static Block crate(String id, int luminance) {
        return register(id, createCrate().luminance((state) -> luminance));
    }

    // Register
    public static Block registerNoItem(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings) {
        var key = RegistryKey.of(RegistryKeys.BLOCK, Blockus.id(id));
        Block block = factory.apply(blockSettings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    public static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Blockus.id(id));
        Block block = registerNoItem(id, factory, blockSettings);
        var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, key.getValue());
        Registry.register(Registries.ITEM, itemRegistryKey, new BlockItem(block, itemSettings.registryKey(itemRegistryKey).useBlockPrefixedTranslationKey()));
        return block;
    }

    public static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Item.Settings itemSettings = new Item.Settings();
        if (BlockChecker.isNetherite(id)) {
            itemSettings = itemSettings.fireproof();
        }
        return register(id, factory, settings, itemSettings);
    }

    public static Block registerNetherStarBlock(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Blockus.id(id));
        Block block = registerNoItem(id, factory, blockSettings);
        var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, key.getValue());
        Registry.register(Registries.ITEM, itemRegistryKey, new NetherStarBlockItem(block, new Item.Settings().registryKey(itemRegistryKey).useBlockPrefixedTranslationKey().rarity(Rarity.UNCOMMON)));
        return block;
    }

    public static Block registerLegacy(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings, String version) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Blockus.id(id));
        Block block = registerNoItem(id, factory, blockSettings);
        var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, key.getValue());
        Registry.register(Registries.ITEM, itemRegistryKey, new LegacyBlockItem(block, new Item.Settings().registryKey(itemRegistryKey).useBlockPrefixedTranslationKey(), version));
        return block;
    }

    public static Block register(String id, AbstractBlock.Settings settings) {
        return register(id, Block::new, settings);
    }

    public static Block registerLegacy(String id, AbstractBlock.Settings settings, String version) {
        return registerLegacy(id, Block::new, settings, version);
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
