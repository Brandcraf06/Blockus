package com.brand.blockus.utils.helper;

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
import com.brand.blockus.utils.BlockChecker;
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

    public static BlockBuilder of(Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return new BlockBuilder(factory, settings);
    }

    public static BlockBuilder of(AbstractBlock.Settings settings) {
        return new BlockBuilder(settings);
    }

    public static Block registerOf(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return of(factory, settings).register(id);
    }

    public static Block registerOf(String id, AbstractBlock.Settings settings) {
        return of(settings).register(id);
    }

    public static BlockBuilder copy(Block block) {
        return new BlockBuilder(block);
    }

    public static BlockBuilder copy(Block base, Function<AbstractBlock.Settings, AbstractBlock.Settings> settings) {
        return copy(base).settings(settings.apply(AbstractBlock.Settings.copy(base)));
    }

    public static Block registerCopy(String id, Block base, Function<AbstractBlock.Settings, AbstractBlock.Settings> settings) {
        return copy(base, settings).register(id);
    }

    public static Block registerCopy(String id, Function<AbstractBlock.Settings, Block> factory, Block base, Function<AbstractBlock.Settings, AbstractBlock.Settings> settings) {
        return copy(base, settings).factory(factory).register(id);
    }

    public static Block registerCopy(String id, Block base) {
        return copy(base).register(id);
    }

    public static Block registerCopy(String id, Function<AbstractBlock.Settings, Block> factory, Block base) {
        return copy(base).factory(factory).register(id);
    }

    public static Block pistonProof(String id, Block base) {
        return copy(base, settings -> settings.pistonBehavior(PistonBehavior.BLOCK)).register(id);
    }

    // Pillar
    public static BlockBuilder basePillar(Block base) {
        return copy(base).factory(PillarBlock::new);
    }

    public static Block pillar(String baseId, Block base) {
        return basePillar(base).register(replaceId(baseId) + "_pillar");
    }

    public static Block pillar2(String id, Block base) {
        return basePillar(base).register(id);
    }

    public static Block pillar(Block base) {
        return pillar(Registries.BLOCK.getId(base).getPath(), base);
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
        return slab(Registries.BLOCK.getId(base).getPath(), base);
    }

    // Stairs
    public static Block stairs(String baseId, Block base) {
        String stairsId = replaceId(baseId) + "_stairs";
        if (BlockChecker.isAmethyst(baseId)) {
            return copy(base).factory(settings -> new AmethystStairsBlock(base.getDefaultState(), settings)).register(stairsId);
        } else if (BlockChecker.isRedstone(baseId)) {
            return copy(base).factory(settings -> new RedstoneStairsBlock(base.getDefaultState(), settings)).register(stairsId);
        } else {
            return copy(base).factory(settings -> new StairsBlock(base.getDefaultState(), settings)).register(stairsId);
        }
    }

    public static Block stairs(Block base) {
        return stairs(Registries.BLOCK.getId(base).getPath(), base);
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
        return wall(Registries.BLOCK.getId(base).getPath(), base);
    }

    public static Block hedge(String id, Block base) {
        return copy(base).factory(SmallHedgeBlock::new).register(id);
    }

    // Pressure Plate & Button
    public static AbstractBlock.Settings pressurePlateButtonSettings(Block base) {
        return create().mapColor(base.getDefaultMapColor()).strength(0.5f).instrument(base.getDefaultState().getInstrument()).noCollision().pistonBehavior(PistonBehavior.DESTROY);
    }

    public static Block pressurePlate(String baseId, Block base, BlockSetType blockSetType) {
        return of(pressurePlateButtonSettings(base).solid()).factory(settings -> new PressurePlateBlock(blockSetType, settings)).register(replaceId(baseId) + "_pressure_plate");
    }

    public static Block pressurePlate(Block base, BlockSetType blockSetType) {
        return pressurePlate(Registries.BLOCK.getId(base).getPath(), base, blockSetType);
    }

    public static Block stonePressurePlate(Block base) {
        return pressurePlate(base, BlockSetType.STONE);
    }

    public static Block button(String baseId, Block base, BlockSetType blockSetType, int pressTicks) {
        return of(pressurePlateButtonSettings(base)).factory(settings -> new ButtonBlock(blockSetType, pressTicks, settings)).register(replaceId(baseId) + "_button");
    }

    public static Block button(Block base, BlockSetType blockSetType, int pressTicks) {
        return button(Registries.BLOCK.getId(base).getPath(), base, blockSetType, pressTicks);
    }

    public static Block stoneButton(Block base) {
        return button(base, BlockSetType.STONE, 20);
    }

    // Plants
    public static AbstractBlock.Settings largeFlowerPotSettings() {
        return create().instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F, 1.0F).pistonBehavior(PistonBehavior.BLOCK).nonOpaque();
    }

    public static Block pottedPlant(String id, Block content) {
        return of(create().instrument(NoteBlockInstrument.BASEDRUM).breakInstantly().pistonBehavior(PistonBehavior.DESTROY).nonOpaque()).factory(settings -> new FlowerPotBlock(content, settings)).noItem().register(id);
    }

    public static Block largePottedPlant(String id, Block content) {
        return of(largeFlowerPotSettings()).factory(settings -> new LargeFlowerPotBlock(content, settings)).noItem().register(id);
    }

    public static Block largeFlowerPot(String id) {
        return of(largeFlowerPotSettings()).factory(settings -> new LargeFlowerPotBlock(Blocks.AIR, settings)).register(id);
    }

    // Door & Trapdoor
    public static AbstractBlock.Settings doorTrapdoorBlockSettings(float hardness, float resistance, BlockSoundGroup sound, MapColor color, NoteBlockInstrument instrument) {
        return create().mapColor(color).instrument(instrument).strength(hardness, resistance).sounds(sound).nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    }

    public static Block woodenDoor(String id, float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASS).burnable()).factory(settings -> new DoorBlock(blockSetType, settings)).register(id);
    }

    public static Block stoneDoor(String id, float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM).requiresTool()).factory(settings -> new DoorBlock(blockSetType, settings)).register(id);
    }

    public static Block woodenTrapdoor(String id, float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASS).burnable()).factory(settings -> new TrapdoorBlock(blockSetType, settings)).register(id);
    }

    public static Block stoneTrapdoor(String id, float hardness, float resistance, BlockSoundGroup sound, MapColor color, BlockSetType blockSetType) {
        return of(doorTrapdoorBlockSettings(hardness, resistance, sound, color, NoteBlockInstrument.BASEDRUM).requiresTool()).factory(settings -> new TrapdoorBlock(blockSetType, settings)).register(id);
    }

    // Light
    public static Block lampBlock(String id, float hardness, float resistance, BlockSoundGroup sound, int luminance, MapColor color) {
        return of(create().mapColor(color).strength(hardness, resistance).sounds(sound).luminance((state) -> luminance)).register(id);
    }

    public static Block neonBlock(String id, DyeColor color) {
        return of(create().mapColor(color).luminance((state) -> 2).sounds(BlockSoundGroup.GLASS).strength(0.5f, 0.5f).emissiveLighting(BlockFactory::always).allowsSpawning(BlockFactory::never)).register(id);
    }

    public static Block neonBlock(DyeColor color) {
        return of(create().mapColor(color).luminance((state) -> 2).sounds(BlockSoundGroup.GLASS).strength(0.5f, 0.5f).emissiveLighting(BlockFactory::always).allowsSpawning(BlockFactory::never)).getBase();
    }

    public static Block redstoneLamp(String id, MapColor mapColor) {
        return registerCopy(id, RedstoneLampBlock::new, Blocks.REDSTONE_LAMP, settings -> settings.mapColor(mapColor).allowsSpawning(BlockFactory::always));
    }

    public static Block litRedstoneLamp(String id, Block base) {
        return registerCopy(id, base, settings -> settings.luminance(state -> 15).allowsSpawning(BlockFactory::always));
    }

    public static Block futurneoBlock(String id, MapColor color) {
        return of(create().mapColor(color).luminance((state) -> 15).strength(0.5f, 0.5f).sounds(BlockSoundGroup.GLASS).allowsSpawning(BlockFactory::always)).register(id);
    }

    // Glass
    public static Block stainedGlass(String id, DyeColor color, Block base) {
        return copy(base, settings -> settings.allowsSpawning(BlockFactory::never).solidBlock(BlockFactory::never).suffocates(BlockFactory::never).blockVision(BlockFactory::never)).factory(settings -> new StainedGlassBlock(color, settings)).register(id);
    }

    public static Block stainedGlassPane(String id, DyeColor color, Block base) {
        return copy(base).factory(settings -> new StainedGlassPaneBlock(color, settings)).register(id);
    }

    // Other
    public static Block woodenPane(String id) {
        return registerOf(id, PaneBlock::new, create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD).burnable());
    }

    public static AbstractBlock.Settings crateSettings() {
        return create().mapColor(Blocks.OAK_PLANKS.getDefaultMapColor()).strength(2.5f).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.WOOD);
    }

    public static Block crate(String id) {
        return registerOf(id, crateSettings());
    }

    public static Block crate(String id, int luminance) {
        return registerOf(id, crateSettings().luminance((state) -> luminance));
    }

    // Register
    public static Block registerNetherStarBlock(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return new BlockBuilder(factory, settings).registerNetherStarBlock(id);
    }

    public static Block registerLegacy(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, String version) {
        BlockBuilder builder = (factory == null) ? new BlockBuilder(settings) : new BlockBuilder(factory, settings);
        return builder.registerLegacy(id, version);
    }

    public static Block registerLegacy(String id, AbstractBlock.Settings settings, String version) {
        return registerLegacy(id, null, settings, version);
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
