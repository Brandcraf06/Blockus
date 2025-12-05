package com.brand.blockus.utils.helper;

import com.brand.blockus.blocks.base.LargeFlowerPotBlock;
import com.brand.blockus.blocks.base.SmallHedgeBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystSlabBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystStairsBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystWallBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneSlabBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneStairsBlock;
import com.brand.blockus.blocks.base.redstone.RedstoneWallBlock;
import com.brand.blockus.utils.BlockChecker;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class BlockFactory {

    public static String replaceId(String id) {
        return id.replace("bricks", "brick").replace("tiles", "tile").replace("_block", "").replace("_planks", "");
    }

    // Base
    public static BlockBehaviour.Properties create() {
        return BlockBehaviour.Properties.of();
    }

    public static BlockBehaviour.Properties createCopy(Block base) {
        return BlockBehaviour.Properties.ofFullCopy(base);
    }

    public static BlockBuilder of(Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return new BlockBuilder(factory, settings);
    }

    public static BlockBuilder of(BlockBehaviour.Properties settings) {
        return new BlockBuilder(settings);
    }

    public static Block registerOf(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return of(factory, settings).register(id);
    }

    public static Block registerNoItem(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return of(factory, settings).noItem().register(id);
    }

    public static Block registerOf(String id, BlockBehaviour.Properties settings) {
        return of(settings).register(id);
    }

    public static BlockBuilder copy(Block block) {
        return new BlockBuilder(block);
    }

    public static BlockBuilder copy(Block base, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> settings) {
        return copy(base).settings(settings.apply(BlockBehaviour.Properties.ofFullCopy(base)));
    }

    public static Block registerCopy(String id, Block base, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> settings) {
        return copy(base, settings).register(id);
    }

    public static Block registerCopy(String id, Function<BlockBehaviour.Properties, Block> factory, Block base, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> settings) {
        return copy(base, settings).factory(factory).register(id);
    }

    public static Block registerCopy(String id, Block base) {
        return copy(base).register(id);
    }

    public static Block registerCopy(String id, Function<BlockBehaviour.Properties, Block> factory, Block base) {
        return copy(base).factory(factory).register(id);
    }

    public static Block pistonProof(String id, Block base) {
        return copy(base, settings -> settings.pushReaction(PushReaction.BLOCK)).register(id);
    }

    // Pillar
    public static BlockBuilder basePillar(Block base) {
        return copy(base).factory(RotatedPillarBlock::new);
    }

    public static Block pillar(String baseId, Block base) {
        return basePillar(base).register(replaceId(baseId) + "_pillar");
    }

    public static Block pillar2(String id, Block base) {
        return basePillar(base).register(id);
    }

    public static Block pillar(Block base) {
        return pillar(BuiltInRegistries.BLOCK.getKey(base).getPath(), base);
    }

    // Slab
    public static Block slab(String baseId, Block base) {
        String slabId = replaceId(baseId) + "_slab";
        if (BlockChecker.isAmethyst(baseId)) {
            return copy(base).factory(AmethystSlabBlock::new).register(slabId);
        } else if (BlockChecker.isRedstone(baseId)) {
            return copy(base).factory(RedstoneSlabBlock::new).register(slabId);
        } else {
            return copy(base).factory(SlabBlock::new).register(slabId);
        }
    }

    public static Block slab(Block base) {
        return slab(BuiltInRegistries.BLOCK.getKey(base).getPath(), base);
    }

    // Stairs
    public static Block stairs(String baseId, Block base) {
        String stairsId = replaceId(baseId) + "_stairs";
        if (BlockChecker.isAmethyst(baseId)) {
            return copy(base).factory(settings -> new AmethystStairsBlock(base.defaultBlockState(), settings)).register(stairsId);
        } else if (BlockChecker.isRedstone(baseId)) {
            return copy(base).factory(settings -> new RedstoneStairsBlock(base.defaultBlockState(), settings)).register(stairsId);
        } else {
            return copy(base).factory(settings -> new StairBlock(base.defaultBlockState(), settings)).register(stairsId);
        }
    }

    public static Block stairs(Block base) {
        return stairs(BuiltInRegistries.BLOCK.getKey(base).getPath(), base);
    }

    // Wall
    public static Block wall(String baseId, Block base) {
        String wallId = replaceId(baseId) + "_wall";
        if (BlockChecker.isAmethyst(baseId)) {
            return copy(base).factory(AmethystWallBlock::new).register(wallId);
        } else if (BlockChecker.isRedstone(baseId)) {
            return copy(base).factory(RedstoneWallBlock::new).register(wallId);
        } else {
            return copy(base).factory(WallBlock::new).register(wallId);
        }
    }

    public static Block wall(Block base) {
        return wall(BuiltInRegistries.BLOCK.getKey(base).getPath(), base);
    }

    public static Block hedge(String id, Block base) {
        return copy(base).factory(SmallHedgeBlock::new).register(id);
    }

    // Pressure Plate & Button
    public static BlockBehaviour.Properties pressurePlateButtonSettings(Block base) {
        return create().mapColor(base.defaultMapColor()).strength(0.5f).instrument(base.defaultBlockState().instrument()).noCollission().pushReaction(PushReaction.DESTROY);
    }

    public static Block pressurePlate(String baseId, Block base, BlockSetType blockSetType) {
        return of(pressurePlateButtonSettings(base).forceSolidOn()).factory(settings -> new PressurePlateBlock(blockSetType, settings)).register(replaceId(baseId) + "_pressure_plate");
    }

    public static Block pressurePlate(Block base, BlockSetType blockSetType) {
        return pressurePlate(BuiltInRegistries.BLOCK.getKey(base).getPath(), base, blockSetType);
    }

    public static Block stonePressurePlate(Block base) {
        return pressurePlate(base, BlockSetType.STONE);
    }

    public static Block button(String baseId, Block base, BlockSetType blockSetType, int pressTicks) {
        return of(pressurePlateButtonSettings(base)).factory(settings -> new ButtonBlock(blockSetType, pressTicks, settings)).register(replaceId(baseId) + "_button");
    }

    public static Block button(Block base, BlockSetType blockSetType, int pressTicks) {
        return button(BuiltInRegistries.BLOCK.getKey(base).getPath(), base, blockSetType, pressTicks);
    }

    public static Block stoneButton(Block base) {
        return button(base, BlockSetType.STONE, 20);
    }

    // Plants
    public static BlockBehaviour.Properties largeFlowerPotSettings() {
        return create().instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F, 1.0F).pushReaction(PushReaction.BLOCK).noOcclusion();
    }

    public static Block pottedPlant(String id, Block content) {
        return of(create().instrument(NoteBlockInstrument.BASEDRUM).instabreak().pushReaction(PushReaction.DESTROY).noOcclusion()).factory(settings -> new FlowerPotBlock(content, settings)).noItem().register(id);
    }

    public static Block largePottedPlant(String id, Block content) {
        return of(largeFlowerPotSettings()).factory(settings -> new LargeFlowerPotBlock(content, settings)).noItem().register(id);
    }

    public static Block largeFlowerPot(String id) {
        return of(largeFlowerPotSettings()).factory(settings -> new LargeFlowerPotBlock(Blocks.AIR, settings)).register(id);
    }

    // Door & Trapdoor
    public static BlockBehaviour.Properties doorTrapdoorBlockSettings(float hardness, float resistance, SoundType sound, MapColor color, NoteBlockInstrument instrument) {
        return create().mapColor(color).instrument(instrument).strength(hardness, resistance).sound(sound).noOcclusion().pushReaction(PushReaction.DESTROY);
    }

    public static Block woodenDoor(String id, float hardness, float resistance, SoundType sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASS).ignitedByLava()).factory(settings -> new DoorBlock(blockSetType, settings)).register(id);
    }

    public static Block stoneDoor(String id, float hardness, float resistance, SoundType sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()).factory(settings -> new DoorBlock(blockSetType, settings)).register(id);
    }

    public static Block woodenTrapdoor(String id, float hardness, float resistance, SoundType sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASS).ignitedByLava()).factory(settings -> new TrapDoorBlock(blockSetType, settings)).register(id);
    }

    public static Block stoneTrapdoor(String id, float hardness, float resistance, SoundType sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()).factory(settings -> new TrapDoorBlock(blockSetType, settings)).register(id);
    }

    // Light
    public static Block lampBlock(String id, float hardness, float resistance, SoundType sound, int luminance, MapColor color) {
        return of(create().mapColor(color).strength(hardness, resistance).sound(sound).lightLevel((state) -> luminance)).register(id);
    }

    public static Block neonBlock(String id, DyeColor color) {
        return of(create().mapColor(color).lightLevel((state) -> 2).sound(SoundType.GLASS).strength(0.5f, 0.5f).emissiveRendering(BlockFactory::always).isValidSpawn(BlockFactory::never)).register(id);
    }

    public static Block neonBlock(DyeColor color) {
        return of(create().mapColor(color).lightLevel((state) -> 2).sound(SoundType.GLASS).strength(0.5f, 0.5f).emissiveRendering(BlockFactory::always).isValidSpawn(BlockFactory::never)).getBase();
    }

    public static Block redstoneLamp(String id, MapColor mapColor) {
        return registerCopy(id, RedstoneLampBlock::new, Blocks.REDSTONE_LAMP, settings -> settings.mapColor(mapColor).isValidSpawn(BlockFactory::always));
    }

    public static Block litRedstoneLamp(String id, Block base) {
        return registerCopy(id, base, settings -> settings.lightLevel(state -> 15).isValidSpawn(BlockFactory::always));
    }

    public static Block futurneoBlock(String id, MapColor color) {
        return of(create().mapColor(color).lightLevel((state) -> 15).strength(0.5f, 0.5f).sound(SoundType.GLASS).isValidSpawn(BlockFactory::always)).register(id);
    }

    // Glass
    public static Block stainedGlass(String id, DyeColor color, Block base) {
        return copy(base, settings -> settings.isValidSpawn(BlockFactory::never).isRedstoneConductor(BlockFactory::never).isSuffocating(BlockFactory::never).isViewBlocking(BlockFactory::never)).factory(settings -> new StainedGlassBlock(color, settings)).register(id);
    }

    public static Block stainedGlassPane(String id, DyeColor color, Block base) {
        return copy(base).factory(settings -> new StainedGlassPaneBlock(color, settings)).register(id);
    }

    // Other
    public static Block woodenPane(String id) {
        return registerOf(id, IronBarsBlock::new, create().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(0.1f, 0.8f).sound(SoundType.WOOD).ignitedByLava());
    }

    public static BlockBehaviour.Properties crateSettings() {
        return create().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).strength(2.5f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD);
    }

    public static Block crate(String id) {
        return registerOf(id, crateSettings());
    }

    public static Block crate(String id, int luminance) {
        return registerOf(id, crateSettings().lightLevel((state) -> luminance));
    }

    // Register
    public static Block registerNetherStarBlock(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return new BlockBuilder(factory, settings).registerNetherStarBlock(id);
    }

    public static Block registerLegacy(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings, String version) {
        BlockBuilder builder = (factory == null) ? new BlockBuilder(settings) : new BlockBuilder(factory, settings);
        return builder.registerLegacy(id, version);
    }

    public static Block registerLegacy(String id, BlockBehaviour.Properties settings, String version) {
        return registerLegacy(id, null, settings, version);
    }

    public static boolean always(BlockState state, BlockGetter world, BlockPos pos) {
        return true;
    }

    public static Boolean always(BlockState state, BlockGetter world, BlockPos pos, EntityType<?> type) {
        return true;
    }

    public static boolean never(BlockState state, BlockGetter world, BlockPos pos) {
        return false;
    }

    public static Boolean never(BlockState state, BlockGetter world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    public static Boolean canSpawnOnLeaves(BlockState state, BlockGetter world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }
}
