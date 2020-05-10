package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.DoorBase;
import com.brand.blockus.blocks.Base.GlazedLikeBlockBase;
import com.brand.blockus.blocks.Base.TrapdoorBase;
import com.brand.blockus.blocks.Base.SpecificTool.BlockBase2;
import com.brand.blockus.blocks.Base.SpecificTool.PillarBase2;
import com.brand.blockus.blocks.Base.SpecificTool.SlabBase2;
import com.brand.blockus.blocks.Base.SpecificTool.StairsBase2;
import com.brand.blockus.blocks.Base.SpecificTool.WallBase2;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ObsidianRelated {
	
	public static final BlockBase2 OBSIDIAN_BRICKS = new BlockBase2("obsidian_bricks", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 3);
	public static final StairsBase2 OBSIDIAN_BRICKS_STAIRS = new StairsBase2(OBSIDIAN_BRICKS.getDefaultState(), "obsidian_bricks_stairs", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3);
	public static final SlabBase2 OBSIDIAN_BRICKS_SLAB = new SlabBase2("obsidian_bricks_slab", 4.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3);
	public static final WallBase2 OBSIDIAN_BRICKS_WALL = new WallBase2("obsidian_bricks_wall", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3);
	public static final PillarBase2 OBSIDIAN_PILLAR = new PillarBase2("obsidian_pillar", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3);
	public static final GlazedLikeBlockBase OBSIDIAN_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("obsidian_circle_pavement", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3);
	public static final DoorBase OBSIDIAN_REINFORCED_DOOR = new DoorBase("obsidian_reinforced_door", 50.0F, 1200.0F, Material.METAL, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3);
	public static final TrapdoorBase OBSIDIAN_REINFORCED_TRAPDOOR = new TrapdoorBase("obsidian_reinforced_trapdoor", 50.0F, 1200.0F, Material.METAL, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3);

}
