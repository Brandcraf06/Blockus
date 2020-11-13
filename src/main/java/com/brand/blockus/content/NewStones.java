package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.*;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class NewStones {
	
// limestone
	public static final BlockBase LIMESTONE = new BlockBase("limestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.WOOD);
	public static final StairsBase LIMESTONE_STAIRS = new StairsBase(LIMESTONE.getDefaultState(), "limestone_stairs", LIMESTONE);
	public static final SlabBase LIMESTONE_SLAB = new SlabBase("limestone_slab", LIMESTONE);
	public static final BlockBase LIMESTONE_BRICKS = new BlockBase("limestone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.WOOD);
	public static final StairsBase LIMESTONE_BRICKS_STAIRS = new StairsBase(LIMESTONE_BRICKS.getDefaultState(), "limestone_bricks_stairs", LIMESTONE_BRICKS);
	public static final SlabBase LIMESTONE_BRICKS_SLAB = new SlabBase("limestone_bricks_slab", LIMESTONE_BRICKS);
	public static final WallBase LIMESTONE_BRICKS_WALL = new WallBase("limestone_bricks_wall", LIMESTONE_BRICKS);
	public static final PillarBase LIMESTONE_PILLAR = new PillarBase("limestone_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.WOOD);
	public static final BlockBase CHISELED_LIMESTONE = new BlockBase("chiseled_limestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.WOOD);
	public static final GlazedLikeBlockBase LIMESTONE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("limestone_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MapColor.WOOD);
	
// marble	
	public static final BlockBase MARBLE = new BlockBase("marble", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.QUARTZ);
	public static final StairsBase MARBLE_STAIRS = new StairsBase(MARBLE.getDefaultState(), "marble_stairs", MARBLE);
	public static final SlabBase MARBLE_SLAB = new SlabBase("marble_slab", MARBLE);
	public static final BlockBase MARBLE_BRICKS = new BlockBase("marble_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.QUARTZ);
	public static final StairsBase MARBLE_BRICKS_STAIRS = new StairsBase(MARBLE_BRICKS.getDefaultState(), "marble_bricks_stairs", MARBLE_BRICKS);
	public static final SlabBase MARBLE_BRICKS_SLAB = new SlabBase("marble_bricks_slab", MARBLE_BRICKS);
	public static final WallBase MARBLE_BRICKS_WALL = new WallBase("marble_bricks_wall", MARBLE_BRICKS);
	public static final PillarBase MARBLE_PILLAR = new PillarBase("marble_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.QUARTZ);
	public static final PillarBase CHISELED_MARBLE_PILLAR = new PillarBase("chiseled_marble_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.QUARTZ);
	public static final BlockBase CHISELED_MARBLE = new BlockBase("chiseled_marble", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.QUARTZ);
	public static final GlazedLikeBlockBase MARBLE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("marble_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MapColor.QUARTZ);
	
// bluestone	
	public static final BlockBase BLUESTONE = new BlockBase("bluestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);
	public static final StairsBase BLUESTONE_STAIRS = new StairsBase(BLUESTONE.getDefaultState(), "bluestone_stairs", BLUESTONE);
	public static final SlabBase BLUESTONE_SLAB = new SlabBase("bluestone_slab", BLUESTONE);
	public static final BlockBase BLUESTONE_TILES = new BlockBase("bluestone_tiles", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);
	public static final StairsBase BLUESTONE_TILES_STAIRS = new StairsBase(BLUESTONE_TILES.getDefaultState(), "bluestone_tiles_stairs", BLUESTONE_TILES);
	public static final SlabBase BLUESTONE_TILES_SLAB = new SlabBase("bluestone_tiles_slab", BLUESTONE_TILES);
	public static final PillarBase BLUESTONE_PILLAR = new PillarBase("bluestone_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.CYAN);
	public static final BlockBase BLUESTONE_BRICKS = new BlockBase("bluestone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);
	public static final BlockBase SMOOTH_BLUESTONE = new BlockBase("smooth_bluestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);
	public static final StairsBase SMOOTH_BLUESTONE_STAIRS = new StairsBase(SMOOTH_BLUESTONE.getDefaultState(), "smooth_bluestone_stairs", SMOOTH_BLUESTONE);
	public static final SlabBase SMOOTH_BLUESTONE_SLAB = new SlabBase("smooth_bluestone_slab", SMOOTH_BLUESTONE);
	public static final BlockBase BLUESTONE_SQUARES = new BlockBase("bluestone_squares", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);
	public static final BlockBase BLUESTONE_LITTLE_BRICKS = new BlockBase("bluestone_little_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);
	public static final BlockBase CHISELED_BLUESTONE = new BlockBase("chiseled_bluestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.CYAN);
	public static final PillarBase BLUESTONE_LINES = new PillarBase("bluestone_lines", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MapColor.CYAN);

}
