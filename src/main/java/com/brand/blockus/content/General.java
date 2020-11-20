package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.*;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseBT;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseHand;
import com.brand.blockus.blocks.Base.*;
import com.brand.blockus.blocks.Light.LampBlockBase;
import com.brand.blockus.blocks.Light.LanternBlockBase;
import com.brand.blockus.blocks.Wood.WoodenPaneBase;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class General {

    public static final FallingBlockBase SUGAR_BLOCK = new FallingBlockBase("sugar_block", 0.5f, 0.5f, Material.AGGREGATE, BlockSoundGroup.SAND, FabricToolTags.SHOVELS, 0, MapColor.QUARTZ);
    public static final BlockBaseBT STARS_BLOCK = new BlockBaseBT("stars_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 1, MapColor.BLACK);
    public static final BlockBaseBT ENDER_BLOCK = new BlockBaseBT("ender_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 1, MapColor.GREEN_TERRACOTTA);
    public static final BlockBaseHand MEMBRANE_BLOCK = new BlockBaseHand("membrane_block", 1.5f, 1.5f, Material.SOLID_ORGANIC, BlockSoundGroup.SLIME, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.WHITE_TERRACOTTA);
    public static final NetherStarsBlock NETHER_STARS_BLOCK = new NetherStarsBlock("nether_stars_block", 5.0f, 6.0f);
    public static final BlockBase IRON_PLATING = new BlockBase("iron_plating", 5.0F, 6.0F, Material.METAL, BlockSoundGroup.METAL, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.IRON);
    public static final LoveBlock LOVE_BLOCK = new LoveBlock("love_block", 2f, 6.0f);
    public static final BlockBase CAUTION_BLOCK = new BlockBase("caution_block", 1.5f, 1200.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.ORANGE);
    public static final PathBase PATH = new PathBase("path", 0.65F, 0.65F, Material.SOIL, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 0, MapColor.DIRT);
    public static final WoodenPaneBase WOODEN_FRAME = new WoodenPaneBase("wooden_frame", 0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD);
    public static final FallingRedstoneBase REDSTONE_SAND = new FallingRedstoneBase("redstone_sand", 2.0f, 6.0f);
    public static final FallingBlockBase WEIGHT_STORAGE_CUBE = new FallingBlockBase("weight_storage_cube", 0.1f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MapColor.IRON);
    public static final FallingBlockBase COMPANION_CUBE = new FallingBlockBase("companion_cube", 0.1f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MapColor.IRON);

    // Lantern Blocks
    public static final LanternBlockBase LANTERN_BLOCK = new LanternBlockBase("lantern_block", 3.5f, 5.0f, Material.METAL, BlockSoundGroup.LANTERN, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MapColor.IRON);
    public static final LanternBlockBase SOUL_LANTERN_BLOCK = new LanternBlockBase("soul_lantern_block", 3.5f, 5.0f, Material.METAL, BlockSoundGroup.LANTERN, Blockus.BLOCKUS_BUILDING_BLOCKS, 10, MapColor.IRON);
    public static final LampBlockBase BLAZE_LANTERN = new LampBlockBase("blaze_lantern", 0.3F, 0.3F, Material.GLASS, BlockSoundGroup.GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MapColor.ORANGE);
    public static final CarvedPumpkinBlockBase SOUL_O_LANTERN = new CarvedPumpkinBlockBase("soul_o_lantern", 1.0f, 1.0f);

    // Gates - chains - bars
    public static final GateBlock IRON_GATE = new GateBlock("iron_gate", 5.0f, 5.0f);
    public static final GateBlock GOLDEN_GATE = new GateBlock("golden_gate", 5.0f, 5.0f);
    public static final ChainBlockBase GOLDEN_CHAIN = new ChainBlockBase("golden_chain", 5.0F, 6.0F);
    public static final PaneBase GOLDEN_BARS = new PaneBase("golden_bars", 5.0F, 6.0f, Material.METAL, BlockSoundGroup.METAL);

    // Barriers
    public static final Barrier CAUTION_BARRIER_BLOCK = new Barrier("caution_barrier", 1.5f, 1200.0f);
    public static final Barrier ROAD_BARRIER_BLOCK = new Barrier("road_barrier", 2f, 6.0f);

    // Netherite Blocks
    public static final StairsBase NETHERITE_STAIRS = new StairsBase(Blocks.NETHERITE_BLOCK.getDefaultState(), "netherite_stairs", Blocks.NETHERITE_BLOCK);
    public static final SlabBase NETHERITE_SLAB = new SlabBase("netherite_slab", Blocks.NETHERITE_BLOCK);

    // Thatch
    public static final BlockBaseBT THATCH = new BlockBaseBT("thatch", 0.5F, 0.5F, Material.SOLID_ORGANIC, BlockSoundGroup.GRASS, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.HOES, 0, MapColor.YELLOW);
    public static final StairsBase THATCH_STAIRS = new StairsBase(General.THATCH.getDefaultState(), "thatch_stairs", THATCH);
    public static final SlabBase THATCH_SLAB = new SlabBase("thatch_slab", THATCH);

    // Quartz Blocks
    public static final BlockBase QUARTZ_TILES = new BlockBase("quartz_tiles", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.QUARTZ);
    public static final GlazedLikeBlockBase QUARTZ_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("quartz_circle_pavement", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MapColor.QUARTZ);

}
