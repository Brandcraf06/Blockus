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
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class Other {

    public static final NetherStarsBlock NETHER_STARS_BLOCK = new NetherStarsBlock("nether_stars_block", 5.0f, 6.0f);
    public static final BlockBaseBT STARS_BLOCK = new BlockBaseBT("stars_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 1, MaterialColor.BLACK);
    public static final BlockBaseBT ENDER_BLOCK = new BlockBaseBT("ender_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 1, MaterialColor.GREEN_TERRACOTTA);
    public static final LoveBlock LOVE_BLOCK = new LoveBlock("love_block", 2f, 6.0f);
    public static final WoodenPaneBase WOODEN_FRAME = new WoodenPaneBase("wooden_frame", 0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD);
    public static final BlockBaseHand MEMBRANE_BLOCK = new BlockBaseHand("membrane_block", 1.5f, 1.5f, Material.SOLID_ORGANIC, BlockSoundGroup.SLIME, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.WHITE_TERRACOTTA);
    public static final LampBlockBase BLAZE_BLOCK = new LampBlockBase("blaze_block", 0.3F, 0.3F, Material.GLASS, BlockSoundGroup.GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.ORANGE);
    public static final BlockBase CAUTION_BLOCK = new BlockBase("caution_block", 1.5f, 1200.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.ORANGE);
    public static final Barrier CAUTION_BARRIER = new Barrier("caution_barrier", 1.5f, 1200.0f);
    public static final Barrier ROAD_BARRIER = new Barrier("road_barrier", 2f, 6.0f);
    public static final FallingRedstoneBase REDSTONE_SAND = new FallingRedstoneBase("redstone_sand", 2.0f, 6.0f);
    public static final IronGateBase IRON_GATE = new IronGateBase("iron_gate", 5.0f, 5.0f);
    public static final IronGateBase GOLDEN_GATE = new IronGateBase("golden_gate", 5.0f, 5.0f);
    public static final LanternBlockBase LANTERN_BLOCK = new LanternBlockBase("lantern_block", 3.5f, 5.0f, Material.METAL, BlockSoundGroup.LANTERN, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.IRON);
    public static final LanternBlockBase SOUL_LANTERN_BLOCK = new LanternBlockBase("soul_lantern_block", 3.5f, 5.0f, Material.METAL, BlockSoundGroup.LANTERN, Blockus.BLOCKUS_BUILDING_BLOCKS, 10, MaterialColor.IRON);
    public static final FallingBlockBase WEIGHT_STORAGE_CUBE = new FallingBlockBase("weight_storage_cube", 0.1f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.IRON);
    public static final FallingBlockBase COMPANION_CUBE = new FallingBlockBase("companion_cube", 0.1f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.IRON);
    public static final FallingBlockBase SUGAR_BLOCK = new FallingBlockBase("sugar_block", 0.5f, 0.5f, Material.AGGREGATE, BlockSoundGroup.SAND, FabricToolTags.SHOVELS, 0, MaterialColor.QUARTZ);
    public static final CarvedPumpkinBlockBase SOUL_O_LANTERN = new CarvedPumpkinBlockBase("soul_o_lantern", 1.0f, 1.0f);
    public static final ChainBlockBase GOLDEN_CHAIN = new ChainBlockBase("golden_chain", 5.0F, 6.0F);
    public static final PaneBase GOLDEN_BARS = new PaneBase("golden_bars", 5.0F, 6.0f, Material.METAL, BlockSoundGroup.METAL);

    public static final BlockBase IRON_PLATING = new BlockBase("iron_plating", 5.0F, 6.0F, Material.METAL, BlockSoundGroup.METAL, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.IRON);
    public static final PathBase DIRT_PATH = new PathBase("dirt_path", 0.65F, 0.65F, Material.SOIL, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 0, MaterialColor.DIRT);

    public static final StairsBase NETHERITE_STAIRS = new StairsBase(Blocks.NETHERITE_BLOCK.getDefaultState(), "netherite_stairs", Blocks.NETHERITE_BLOCK);
    public static final SlabBase NETHERITE_SLAB = new SlabBase("netherite_slab", Blocks.NETHERITE_BLOCK);

    // Thatch
    public static final BlockBaseBT THATCH = new BlockBaseBT("thatch", 0.5F, 0.5F, Material.SOLID_ORGANIC, BlockSoundGroup.GRASS, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.HOES, 0, MaterialColor.YELLOW);
    public static final StairsBase THATCH_STAIRS = new StairsBase(Other.THATCH.getDefaultState(), "thatch_stairs", THATCH);
    public static final SlabBase THATCH_SLAB = new SlabBase("thatch_slab", THATCH);

}
