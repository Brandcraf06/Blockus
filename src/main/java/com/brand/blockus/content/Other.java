package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.ChainBlockBase;
import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.BarrierBase;
import com.brand.blockus.blocks.Base.FallingRedstoneBase;
import com.brand.blockus.blocks.Base.SpecificTool.BlockBase2;
import com.brand.blockus.blocks.Base.SpecificTool.BlockBaseHand;
import com.brand.blockus.blocks.LoveBlock;
import com.brand.blockus.blocks.NetherStarsBlock;
import com.brand.blockus.blocks.Paper.PaperWall;
import com.brand.blockus.blocks.PortalCubeBlock;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

import com.brand.blockus.blocks.IronGate.IronGateBase;
import com.brand.blockus.blocks.Light.LightBlockBase;

public class Other {
	
	public static final NetherStarsBlock NETHER_STARS_BLOCK = new NetherStarsBlock("nether_stars_block", 5.0f, 6.0f);
	public static final BlockBase2 STARS_BLOCK = new BlockBase2("stars_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 1);
	public static final BlockBase2 ENDER_BLOCK = new BlockBase2("ender_block", 5.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 1);
	public static final BlockBase LARGE_BRICKS = new BlockBase("large_bricks", 2f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final BlockBase ZIGZAGGED_BRICKS = new BlockBase("zigzagged_bricks", 2f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final LoveBlock LOVE_BLOCK = new LoveBlock("love_block", 2f, 6.0f);
	public static final PaperWall WOODEN_FRAME = new PaperWall("wooden_frame", 0.1f, 0.8f);
	public static final BlockBaseHand MEMBRANE_BLOCK = new BlockBaseHand("membrane_block", 1.5f, 1.5f, Material.SOLID_ORGANIC, BlockSoundGroup.SLIME, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final LightBlockBase BLAZE_BLOCK = new LightBlockBase("blaze_block", 2f, 6.0f, Material.GLASS, BlockSoundGroup.GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS, 15);
	public static final BlockBase CAUTION_BLOCK = new BlockBase("caution_block", 1.5f, 1200.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final BarrierBase CAUTION_BARRIER = new BarrierBase("caution_barrier", 1.5f, 1200.0f);
    public static final BarrierBase ROAD_BARRIER = new BarrierBase("road_barrier", 2f, 6.0f);	
    public static final FallingRedstoneBase REDSTONE_SAND = new FallingRedstoneBase("redstone_sand", 2.0f, 6.0f);
    public static final IronGateBase IRON_GATE = new IronGateBase("iron_gate", 5.0f, 5.0f);
    public static final LightBlockBase LANTERN_BLOCK = new LightBlockBase("lantern_block", 0.3f, 0.3f, Material.GLASS, BlockSoundGroup.GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS, 15);
    public static final PortalCubeBlock WEIGHT_STORAGE_CUBE= new PortalCubeBlock("weight_storage_cube", 0.1f, 6.0f);
    public static final PortalCubeBlock COMPANION_CUBE = new PortalCubeBlock("companion_cube", 0.1f, 6.0f);
    public static final LightBlockBase SOUL_LANTERN_BLOCK = new LightBlockBase("soul_lantern_block", 0.3f, 0.3f, Material.GLASS, BlockSoundGroup.GLASS, Blockus.BLOCKUS_BUILDING_BLOCKS, 10);
    public static final ChainBlockBase GOLDEN_CHAIN = new ChainBlockBase("golden_chain", 5.0F, 6.0F);

}
