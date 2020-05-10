package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.GlazedLikeBlockBase;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class Marble {
	
	public static final BlockBase MARBLE = new BlockBase("marble", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase MARBLE_STAIRS = new StairsBase(MARBLE.getDefaultState(), "marble_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase MARBLE_SLAB = new SlabBase("marble_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase MARBLE_BRICKS = new BlockBase("marble_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase MARBLE_BRICKS_STAIRS = new StairsBase(MARBLE_BRICKS.getDefaultState(), "marble_bricks_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase MARBLE_BRICKS_SLAB = new SlabBase("marble_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final WallBase MARBLE_BRICKS_WALL = new WallBase("marble_bricks_wall", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final PillarBase MARBLE_PILLAR = new PillarBase("marble_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final PillarBase CHISELED_MARBLE_PILLAR = new PillarBase("chiseled_marble_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase CHISELED_MARBLE = new BlockBase("chiseled_marble", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final GlazedLikeBlockBase MARBLE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("marble_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0);

}
