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

import java.util.function.BiFunction;
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

    public static BlockBuilder of(Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        return new BlockBuilder(factory, properties);
    }

    public static BlockBuilder of(BlockBehaviour.Properties properties) {
        return new BlockBuilder(properties);
    }

    public static Block registerNoItem(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        return of(factory, properties).noItem().register(id);
    }

    public static Block registerOf(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        return of(factory, properties).register(id);
    }

    public static Block registerOf(String id, BlockBehaviour.Properties properties) {
        return of(properties).register(id);
    }

    public static BlockBuilder copy(Block block) {
        return new BlockBuilder(block);
    }

    public static BlockBuilder copy(Block base, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> properties) {
        return copy(base).properties(properties.apply(BlockBehaviour.Properties.ofFullCopy(base)));
    }

    public static Block registerCopy(String id, Block base, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> properties) {
        return copy(base, properties).register(id);
    }

    public static Block registerCopy(String id, Function<BlockBehaviour.Properties, Block> factory, Block base, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> properties) {
        return copy(base, properties).factory(factory).register(id);
    }

    public static Block registerCopy(String id, Block base) {
        return copy(base).register(id);
    }

    public static Block registerCopy(String id, Function<BlockBehaviour.Properties, Block> factory, Block base) {
        return copy(base).factory(factory).register(id);
    }

    public static Block pistonProof(String id, Block base) {
        return copy(base, properties -> properties.pushReaction(PushReaction.BLOCK)).register(id);
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
            return copy(base).factory(properties -> new AmethystStairsBlock(base.defaultBlockState(), properties)).register(stairsId);
        } else if (BlockChecker.isRedstone(baseId)) {
            return copy(base).factory(properties -> new RedstoneStairsBlock(base.defaultBlockState(), properties)).register(stairsId);
        } else {
            return copy(base).factory(properties -> new StairBlock(base.defaultBlockState(), properties)).register(stairsId);
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
    public static BlockBehaviour.Properties pressurePlateButtonProperties(Block base) {
        return create().mapColor(base.defaultMapColor()).strength(0.5f).instrument(base.defaultBlockState().instrument()).noCollision().pushReaction(PushReaction.DESTROY);
    }

    public static Block pressurePlate(String baseId, Block base, BlockSetType blockSetType) {
        return of(pressurePlateButtonProperties(base).forceSolidOn()).factory(properties -> new PressurePlateBlock(blockSetType, properties)).register(replaceId(baseId) + "_pressure_plate");
    }

    public static Block pressurePlate(Block base, BlockSetType blockSetType) {
        return pressurePlate(BuiltInRegistries.BLOCK.getKey(base).getPath(), base, blockSetType);
    }

    public static Block stonePressurePlate(Block base) {
        return pressurePlate(base, BlockSetType.STONE);
    }

    public static Block button(String baseId, Block base, BlockSetType blockSetType, int pressTicks) {
        return of(pressurePlateButtonProperties(base)).factory(properties -> new ButtonBlock(blockSetType, pressTicks, properties)).register(replaceId(baseId) + "_button");
    }

    public static Block button(Block base, BlockSetType blockSetType, int pressTicks) {
        return button(BuiltInRegistries.BLOCK.getKey(base).getPath(), base, blockSetType, pressTicks);
    }

    public static Block stoneButton(Block base) {
        return button(base, BlockSetType.STONE, 20);
    }

    // Plants
    public static BlockBehaviour.Properties largeFlowerPotProperties() {
        return create().instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F, 1.0F).pushReaction(PushReaction.BLOCK).noOcclusion();
    }

    public static Block pottedPlant(String id, Block content) {
        return of(create().instrument(NoteBlockInstrument.BASEDRUM).instabreak().pushReaction(PushReaction.DESTROY).noOcclusion()).factory(properties -> new FlowerPotBlock(content, properties)).noItem().register(id);
    }

    public static Block largePottedPlant(String id, Block content) {
        return of(largeFlowerPotProperties()).factory(properties -> new LargeFlowerPotBlock(content, properties)).noItem().register(id);
    }

    public static Block largeFlowerPot(String id) {
        return of(largeFlowerPotProperties()).factory(properties -> new LargeFlowerPotBlock(Blocks.AIR, properties)).register(id);
    }

    // Door & Trapdoor
    public static BlockBehaviour.Properties doorTrapdoorBlockProperties(float hardness, float resistance, SoundType sound, MapColor color, NoteBlockInstrument instrument) {
        return create().mapColor(color).instrument(instrument).strength(hardness, resistance).sound(sound).noOcclusion().pushReaction(PushReaction.DESTROY);
    }

    public static Block woodenDoor(String id, float hardness, float resistance, SoundType sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockProperties(hardness, resistance, sound, color, NoteBlockInstrument.BASS).ignitedByLava()).factory(properties -> new DoorBlock(blockSetType, properties)).register(id);
    }

    public static Block stoneDoor(String id, float hardness, float resistance, SoundType sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockProperties(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()).factory(properties -> new DoorBlock(blockSetType, properties)).register(id);
    }

    public static Block woodenTrapdoor(String id, float hardness, float resistance, SoundType sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockProperties(hardness, resistance, sound, color, NoteBlockInstrument.BASS).ignitedByLava()).factory(properties -> new TrapDoorBlock(blockSetType, properties)).register(id);
    }

    public static Block stoneTrapdoor(String id, float hardness, float resistance, SoundType sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockProperties(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()).factory(properties -> new TrapDoorBlock(blockSetType, properties)).register(id);
    }

    // Light
    public static Block lampBlock(String id, float hardness, float resistance, SoundType sound, int luminance, MapColor color) {
        return of(create().mapColor(color).strength(hardness, resistance).sound(sound).lightLevel((state) -> luminance)).register(id);
    }

    public static Block lampBlock(String id, Block base) {
        return registerCopy(id, base, properties -> properties.lightLevel(state -> 15));
    }

    public static BlockBehaviour.Properties neonProperties() {
        return create().lightLevel((state) -> 2).sound(SoundType.GLASS).strength(0.5f, 0.5f).emissiveRendering(Blocks::always).isValidSpawn(Blocks::never);
    }

    public static BlockBehaviour.Properties futurneoblockProperties() {
        return create().lightLevel((state) -> 15).strength(0.5f, 0.5f).sound(SoundType.GLASS).isValidSpawn(Blocks::always);
    }

    public static BlockBehaviour.Properties asphaltProperties() {
        return create().instrument(NoteBlockInstrument.BASEDRUM).strength(1.5f, 6.0f).requiresCorrectToolForDrops();
    }

    // Dyed Blocks
    public static Block dyedBlock(String id, DyeColor color, BiFunction<DyeColor, BlockBehaviour.Properties, Block> factory, Block base) {
        return copy(base).factory(properties -> factory.apply(color, properties)).register(id);
    }

    public static Block dyedBlock(String id, DyeColor color, BlockBehaviour.Properties properties) {
        return registerOf(id, Block::new, properties.mapColor(color));
    }

    public static Function<DyeColor, BlockBehaviour.Properties> copyDyedBlocks(ColorCollection<Block> block) {
        return color -> BlockFactory.createCopy(block.pick(color));
    }

    public static <T extends Block> ColorCollection<Block> dyedBlocksWithFixedId(String start, String end, Function<DyeColor, BlockBehaviour.Properties> properties) {
        return ColorCollection.make((color) -> registerOf(start + color.getName() + end, Block::new, properties.apply(color)));
    }

    public static ColorCollection<Block> chiseledConcrete(ColorCollection<Block> base) {
        return dyedBlocksWithFixedId("chiseled_", "_concrete", color -> createCopy(base.pick(color)));
    }

    public static ColorCollection<Block> dyedBlocks(String id, BiFunction<DyeColor, BlockBehaviour.Properties, Block> factory, Function<DyeColor, BlockBehaviour.Properties> properties) {
        return ColorCollection.registerBlocks(id, BlockFactory::registerOf, factory, properties);
    }

    public static ColorCollection<Block> dyedBlocks(String id, ColorCollection<Block> base) {
        return dyedBlocks(id, (var0, p) -> new Block(p), copyDyedBlocks(base));
    }

    public static ColorCollection<Block> dyedBlocks(String id, Function<DyeColor, BlockBehaviour.Properties> properties) {
        return dyedBlocks(id, (var0, p) -> new Block(p), properties);
    }

    public static ColorCollection<Block> dyedBlocks(String id, BiFunction<DyeColor, BlockBehaviour.Properties, Block> factory, ColorCollection<Block> base) {
        return dyedBlocks(id, factory, color -> createCopy(base.pick(color)));
    }


    // Other
    public static Block woodenPane(String id) {
        return registerOf(id, IronBarsBlock::new, create().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(0.1f, 0.8f).sound(SoundType.WOOD).ignitedByLava());
    }

    public static BlockBehaviour.Properties crateProperties() {
        return create().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).strength(2.5f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD);
    }

    public static Block crate(String id) {
        return registerOf(id, crateProperties());
    }

    public static Block crate(String id, int luminance) {
        return registerOf(id, crateProperties().lightLevel((state) -> luminance));
    }

    // Register
    public static Block registerNetherStarBlock(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        return new BlockBuilder(factory, properties).registerNetherStarBlock(id);
    }

    public static Block registerLegacy(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties, String version) {
        BlockBuilder builder = (factory == null) ? new BlockBuilder(properties) : new BlockBuilder(factory, properties);
        return builder.registerLegacy(id, version);
    }

    public static Block registerLegacy(String id, BlockBehaviour.Properties properties, String version) {
        return registerLegacy(id, null, properties, version);
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
