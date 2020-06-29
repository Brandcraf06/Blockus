package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.ChainBlockBase;
import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.BarrierBase;
import com.brand.blockus.blocks.CarvedPumpkinBlockBase;
import com.brand.blockus.blocks.IronGateBase;
import com.brand.blockus.blocks.Base.FallingRedstoneBase;
import com.brand.blockus.blocks.Base.PaneBase;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseBT;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseHand;
import com.brand.blockus.blocks.LoveBlock;
import com.brand.blockus.blocks.NetherStarsBlock;
import com.brand.blockus.blocks.PortalCubeBlock;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

import com.brand.blockus.blocks.Light.LanternBlockBase;
import com.brand.blockus.blocks.Light.LightBlockBase;
import com.brand.blockus.blocks.Wood.WoodenPaneBase;

public class Other {
	
	public static final NetherStarsBlock NETHER_STARS_BLOCK = new NetherStarsBlock("nether_stars_block", 5.0f, 6.0f);
	public static final BlockBaseBT STARS_BLOCK = new BlockBaseBT("stars_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 1, MaterialColor.BLACK);
	public static final BlockBaseBT ENDER_BLOCK = new BlockBaseBT("ender_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 1, MaterialColor.GREEN_TERRACOTTA);
	public static final BlockBase LARGE_BRICKS = new BlockBase("large_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.RED);
	public static final BlockBase ZIGZAGGED_BRICKS = new BlockBase("zigzagged_bricks", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.RED);
	public static final LoveBlock LOVE_BLOCK = new LoveBlock("love_block", 2f, 6.0f);
	public static final WoodenPaneBase WOODEN_FRAME = new WoodenPaneBase("wooden_frame", 0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD);
	public static final BlockBaseHand MEMBRANE_BLOCK = new BlockBaseHand("membrane_block", 1.5f, 1.5f, Material.SOLID_ORGANIC, BlockSoundGroup.SLIME, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.WHITE_TERRACOTTA);
	public static final LightBlockBase BLAZE_BLOCK = new LightBlockBase("blaze_block", 2f, 6.0f, Material.GLASS, BlockSoundGroup.GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.ORANGE);
	public static final BlockBase CAUTION_BLOCK = new BlockBase("caution_block", 1.5f, 1200.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.ORANGE);
	public static final BarrierBase CAUTION_BARRIER = new BarrierBase("caution_barrier", 1.5f, 1200.0f);
    public static final BarrierBase ROAD_BARRIER = new BarrierBase("road_barrier", 2f, 6.0f);	
    public static final FallingRedstoneBase REDSTONE_SAND = new FallingRedstoneBase("redstone_sand", 2.0f, 6.0f);
    public static final IronGateBase IRON_GATE = new IronGateBase("iron_gate", 5.0f, 5.0f);
    public static final IronGateBase GOLDEN_GATE = new IronGateBase("golden_gate", 5.0f, 5.0f);
    public static final LanternBlockBase LANTERN_BLOCK = new LanternBlockBase("lantern_block", 3.5f, 5.0f, Material.METAL, BlockSoundGroup.LANTERN, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.IRON);
    public static final LanternBlockBase SOUL_LANTERN_BLOCK = new LanternBlockBase("soul_lantern_block", 3.5f, 5.0f, Material.METAL,BlockSoundGroup.LANTERN, Blockus.BLOCKUS_BUILDING_BLOCKS, 10, MaterialColor.IRON);
    public static final PortalCubeBlock WEIGHT_STORAGE_CUBE= new PortalCubeBlock("weight_storage_cube", 0.1f, 6.0f);
    public static final PortalCubeBlock COMPANION_CUBE = new PortalCubeBlock("companion_cube", 0.1f, 6.0f);
    public static final CarvedPumpkinBlockBase SOUL_O_LANTERN = new CarvedPumpkinBlockBase("soul_o_lantern", 1.0f, 1.0f);
    public static final ChainBlockBase GOLDEN_CHAIN = new ChainBlockBase("golden_chain", 5.0F, 6.0F);
	public static final PaneBase GOLDEN_BARS = new PaneBase("golden_bars", 5.0F, 6.0f, Material.METAL, BlockSoundGroup.METAL);

}
