package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Asphalt.AsphaltBlock;
import com.brand.blockus.blocks.Asphalt.AsphaltSlab;
import com.brand.blockus.blocks.Asphalt.AsphaltStairs;
import com.brand.blockus.blocks.*;
import com.brand.blockus.blocks.Base.*;
import com.brand.blockus.blocks.BlockItem.SpeedBlockItem;
import com.brand.blockus.blocks.FlowerPot.LargeFlowerPotBlock;
import com.brand.blockus.blocks.FlowerPot.SaplingBlockBase;
import com.brand.blockus.blocks.FoodBlocks.CookieBlock;
import com.brand.blockus.blocks.Glass.PaneBlockBase;
import com.brand.blockus.blocks.Switches.PressurePlateBase;
import com.brand.blockus.blocks.Switches.StoneButtonBase;
import com.brand.blockus.blocks.Switches.WoodenButtonBase;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.Tag;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

public class BlocksRegistration {

    // Normal
    public static Block registerBlockCopy(String id, Block base) {
        return register(id, new Block(FabricBlockSettings.copy(base)));
    }

    public static Block registerBlock(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return register(id, new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).requiresTool()));
    }

    public static Block registerBlock2(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return register(id, new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound)));
    }

    public static Block registerBlockBetterTool(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return register(id, new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel)));
    }

    public static Block registerOrientableBlock(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return register(id, new OrientableBlockBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel)));
    }

    public static Block registerPane(String id, Block base) {
        return register(id, new PaneBlockBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerFallingBlock(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return register(id, new FallingBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).requiresTool().breakByTool(tag, mininglevel)));
    }

    public static Block registerGravel(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return register(id, new GravelBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).requiresTool().breakByTool(tag, mininglevel)));
    }

    // Pillar
    public static Block registerPillar(String id, Block base) {
        return register(id + "_pillar", new PillarBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerPillar(Block base) {
        return registerPillar(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Block registerPillar2(String id, Block base) {
        return register(id, new PillarBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerPillar3(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, MapColor color) {
        return register(id, new PillarBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).requiresTool()));
    }

    // Slab
    public static Block registerSlab(String id, Block base) {
        return register(id + "_slab", new SlabBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerSlab(Block base) {
        return registerSlab(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Stairs
    public static Block registerStairs(String id, Block base) {
        return register(id + "_stairs", new StairsBase(base.getDefaultState(), FabricBlockSettings.copy(base)));
    }

    public static Block registerStairs(Block base) {
        return registerStairs(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Wall
    public static Block registerWall(String id, Block base) {
        return registerDecoration(id + "_wall", new WallBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerWall(Block base) {
        return registerWall(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Block registerBarrier(String id, float hardness, float resistance) {
        return registerDecoration(id + "_barrier", new Barrier(FabricBlockSettings.of(Material.STONE).strength(hardness, resistance).requiresTool()));
    }

    public static Block registerSmallHedge(String id, Block base) {
        return registerDecoration(id, new SmallHedgeBlock(FabricBlockSettings.copy(base)));
    }

    // Fence
    public static Block registerFence(String id, Block base) {
        return register(id + "_fence", new FenceBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerFence(Block base) {
        return registerFence(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Fence Gate
    public static Block registerFenceGate(String id, Block base) {
        return registerRedstone(id + "_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(base)));
    }

    // Pressure Plate
    public static Block registerPressurePlate(String id, PressurePlateBlock.ActivationRule type, Block base) {
        return registerRedstone(id + "_pressure_plate", new PressurePlateBase(type, FabricBlockSettings.copy(base)));
    }

    // Button
    public static Block registerWoodenButton(String id, Block base) {
        return registerRedstone(id + "_button", new WoodenButtonBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerStoneButton(String id, Block base) {
        return registerRedstone(id + "_button", new StoneButtonBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerStoneButton(Block base) {
        return registerStoneButton(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Plants
    public static Block registerPottedPlant(Block content, String id) {
        return registerNoitem("potted_" + id, new FlowerPotBlock(content, FabricBlockSettings.of(Material.SUPPORTED).breakInstantly().nonOpaque()));
    }

    public static Block registerLargeFlowerPot(Block content, String id) {
        return registerDecoration(id, new LargeFlowerPotBlock(content, FabricBlockSettings.of(Material.SUPPORTED).strength(0.5F, 1.0F).nonOpaque()));
    }

    public static Block registerPottedDoublePlant(Block content, String id) {
        return registerNoitem("potted_" + id, new LargeFlowerPotBlock(content, FabricBlockSettings.of(Material.SUPPORTED).strength(0.5F, 1.0F).nonOpaque()));
    }

    public static Block registerLeaves(String id, Block base) {
        return register(id, new LeavesBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerSapling(SaplingGenerator generator, String id) {
        return register(id, new SaplingBlockBase(generator, FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    }

    // Door & Trapdoor
    public static Block registerDoor(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return registerRedstone(id + "_door", new DoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel).nonOpaque()));
    }

    public static Block registerDoor2(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return registerRedstone(id + "_door", new DoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel).nonOpaque().requiresTool()));
    }

    public static Block registerTrapdoor(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return registerRedstone(id + "_trapdoor", new TrapdoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel).nonOpaque()));
    }

    public static Block registerTrapdoor2(String id, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MapColor color) {
        return registerRedstone(id + "_trapdoor", new TrapdoorBase(FabricBlockSettings.of(material, color).strength(hardness, resistance).sounds(sound).breakByTool(tag, mininglevel).nonOpaque().requiresTool()));
    }

    public static Block registerGate(String id, Block base) {
        return registerRedstone(id + "_gate", new DoorBase(FabricBlockSettings.copy(base)));
    }

    // Types
    public static Block registerColoredTiles(String id, MapColor color) {
        return register(id + "_colored_tiles", new Block(FabricBlockSettings.of(Material.STONE, color).strength(1.8f).sounds(BlockSoundGroup.STONE).requiresTool()));
    }

    public static Block registerPatternedWool(String id, Block base) {
        return register(id + "_patterned_wool", new OrientableBlockBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerCirclePavement(String id, Block base) {
        return register(id + "_circle_pavement", new OrientableBlockBase(FabricBlockSettings.copy(base)));
    }

    public static Block registerColoredStoneBricks(String id, MapColor color) {
        return register(id + "_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE, color).strength(1.5F, 6.0F).requiresTool()));
    }

    public static Block registerLogs(String id, Block base) {
        return register(id, new PillarBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerLogs2(String id, MapColor color) {
        return register(id, new PillarBlock(FabricBlockSettings.of(Material.WOOD, color).strength(2.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0)));
    }

    public static Block registerChain(String id, Block base) {
        return register(id + "_chain", new ChainBlock(FabricBlockSettings.copy(base)));
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
        return registerRedstone(id, new RedstoneLampBlock(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(createLightLevelFromBlockState(15)).strength(0.3F).sounds(BlockSoundGroup.GLASS).allowsSpawning(BlocksRegistration::always)));
    }

    public static Block registerLitRedstoneLamp(String id) {
        return registerRedstone(id + "_lit", new Block(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(15).strength(0.3F).sounds(BlockSoundGroup.GLASS).allowsSpawning(BlocksRegistration::always)));
    }

    private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
        return (blockState) -> (Boolean) blockState.get(Properties.LIT) ? litLevel : 0;
    }

    // Glass
    public static Block registerGlass(String id, Block base) {
        return register(id, new GlassBlock(FabricBlockSettings.copy(base)));
    }

    public static Block registerStainedGlass(String id, DyeColor color, Block base) {
        return register(id, new StainedGlassBlock(color, FabricBlockSettings.copy(base)));
    }

    public static Block registerStainedGlassPane(String id, DyeColor color, Block base) {
        return register(id, new StainedGlassPaneBlock(color, FabricBlockSettings.copy(base)));
    }

    // Asphalt
    public static Block registerAsphalt(String id, DyeColor color) {
        return registerAsphalt(id, new AsphaltBlock(FabricBlockSettings.of(Material.STONE, color).strength(1.5f, 6.0f).requiresTool()));
    }

    public static Block registerAsphaltSlab(String id, Block base) {
        return registerAsphalt(id + "_slab", new AsphaltSlab(FabricBlockSettings.copy(base)));
    }

    public static Block registerAsphaltSlab(Block base) {
        return registerAsphaltSlab(Registry.BLOCK.getId(base).getPath(), base);
    }

    public static Block registerAsphaltStairs(String id, Block base) {
        return registerAsphalt(id + "_stairs", new AsphaltStairs(base.getDefaultState(), FabricBlockSettings.copy(base)));
    }

    public static Block registerAsphaltStairs(Block base) {
        return registerAsphaltStairs(Registry.BLOCK.getId(base).getPath(), base);
    }

    // Other
    public static Block registerRedstoneSand(String id) {
        return registerRedstone(id, new FallingRedstoneBase(FabricBlockSettings.of(Material.AGGREGATE, MapColor.LAVA).strength(2.0f, 6.0f).sounds(BlockSoundGroup.SAND).breakByTool(FabricToolTags.SHOVELS, 0)));
    }

    public static Block registerCookieBlock(String id) {
        return register(id, new CookieBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.ORANGE).strength(0.5F).sounds(BlockSoundGroup.GRASS)));
    }

    public static Block registerWoodenPane(String id) {
        return registerDecoration(id, new PaneBlockBase(FabricBlockSettings.of(Material.WOOD).strength(0.1f, 0.8f).sounds(BlockSoundGroup.WOOD)));
    }

    public static Block registerPaperLamp(String id) {
        return registerDecoration(id, new PaperLampBlock(FabricBlockSettings.of(Material.WOOL, MapColor.QUARTZ).strength(0.1f, 0.8f).sounds(BlockSoundGroup.GRASS).luminance(15)));
    }

    public static Block registerSturdyStone(String id) {
        return register(id, new SturdyStoneBlock(FabricBlockSettings.copy(Blocks.STONE)));
    }

    public static Block registerNetherStarsBlock(String id) {
        return registerDecoration(id, new NetherStarsBlock(FabricBlockSettings.of(Material.STONE, MapColor.QUARTZ).strength(5.0f, 6.0f).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool()));
    }

    public static Block registerLoveBlock(String id) {
        return registerDecoration(id, new LoveBlock(FabricBlockSettings.of(Material.STONE, MapColor.PINK).strength(2, 6.0f).requiresTool()));
    }

    public static Block registerPath(String id) {
        return registerDecoration(id, new PathBlock(FabricBlockSettings.copy(Blocks.DIRT_PATH)));
    }

    public static Block registerSoulolantern(String id) {
        return register(id, new CarvedPumpkinBlockBase(FabricBlockSettings.of(Material.GOURD, MapColor.ORANGE).strength(1).sounds(BlockSoundGroup.WOOD).luminance(10).breakByTool(FabricToolTags.AXES, 0)));
    }

    public static Block registerSpongeBlock(String id, Block base) {
        return registerDecoration(id, new SpongeBlockBase(FabricBlockSettings.copy(base)));
    }

    public static Block register(String id, Block block, boolean registerItem) {
        Identifier identifier = new Identifier(Blockus.MOD_ID, id);
        Block registeredBlock = Registry.register(Registry.BLOCK, identifier, block);
        if (registerItem) {
            Registry.register(Registry.ITEM, identifier, new BlockItem(registeredBlock, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
        }
        return registeredBlock;
    }

    public static Block registerDecoration(String id, Block block, boolean registerItem) {
        Identifier identifier = new Identifier(Blockus.MOD_ID, id);
        Block registeredBlock = Registry.register(Registry.BLOCK, identifier, block);
        if (registerItem) {
            Registry.register(Registry.ITEM, identifier, new BlockItem(registeredBlock, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_DECORATIONS)));
        }
        return registeredBlock;
    }

    public static Block registerRedstone(String id, Block block, boolean registerItem) {
        Identifier identifier = new Identifier(Blockus.MOD_ID, id);
        Block registeredBlock = Registry.register(Registry.BLOCK, identifier, block);
        if (registerItem) {
            Registry.register(Registry.ITEM, identifier, new BlockItem(registeredBlock, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_REDSTONE)));
        }
        return registeredBlock;
    }

    public static Block registerAsphalt(String id, Block block, boolean registerItem) {
        Identifier identifier = new Identifier(Blockus.MOD_ID, id);
        Block registeredBlock = Registry.register(Registry.BLOCK, identifier, block);
        if (registerItem) {
            Registry.register(Registry.ITEM, identifier, new SpeedBlockItem(registeredBlock, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
        }
        return registeredBlock;
    }

    public static Block registerNoitem(String id, Block block) {
        Identifier identifier = new Identifier(Blockus.MOD_ID, id);
        return Registry.register(Registry.BLOCK, identifier, block);
    }

    public static Block register(String id, Block block) {
        return register(id, block, true);
    }

    public static Block registerDecoration(String id, Block block) {
        return registerDecoration(id, block, true);
    }

    public static Block registerRedstone(String id, Block block) {
        return registerRedstone(id, block, true);
    }

    public static Block registerAsphalt(String id, Block block) {
        return registerAsphalt(id, block, true);
    }

    private static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }
}