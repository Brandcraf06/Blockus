package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.CirclePavementBlock;
import com.brand.blockus.blocks.Base.DoorBase;
import com.brand.blockus.blocks.Base.PillarBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.TrapdoorBase;
import com.brand.blockus.blocks.Base.WallBase;
import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class StoneRelated {
	
	public static final StairsBase SMOOTH_STONE_STAIRS = new StairsBase(Blocks.SMOOTH_STONE.getDefaultState(), "smooth_stone_stairs", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final PillarBase STONE_BRICKS_PILLAR = new PillarBase("stone_bricks_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final DoorBase STONE_DOOR = new DoorBase("stone_door", 1.5f, 20.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0);
	public static final TrapdoorBase STONE_TRAPDOOR = new TrapdoorBase("stone_trapdoor", 1.5f, 20.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0);
	public static final BlockBase ZIGZAGGED_STONE_BRICKS = new BlockBase("zigzagged_stone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final CirclePavementBlock STONE_CIRCLE_PAVEMENT = new CirclePavementBlock("stone_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	
	// blackstone		
	public static final PillarBase POLISHED_BLACKSTONE_PILLAR = new PillarBase("polished_blackstone_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final BlockBase ZIGZAGGED_POLISHED_BLACKSTONE = new BlockBase("zigzagged_polished_blackstone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final CirclePavementBlock POLISHED_BLACKSTONE_CIRCLE_PAVEMENT = new CirclePavementBlock("polished_blackstone_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	
	public static final BlockBase CRIMSON_WARTY_BLACKSTONE_BRICKS = new BlockBase("crimson_warty_blackstone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final WallBase CRIMSON_WARTY_BLACKSTONE_BRICKS_WALL = new WallBase("crimson_warty_blackstone_bricks_wall", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final StairsBase CRIMSON_WARTY_BLACKSTONE_BRICKS_STAIRS = new StairsBase(CRIMSON_WARTY_BLACKSTONE_BRICKS.getDefaultState(), "crimson_warty_blackstone_bricks_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase CRIMSON_WARTY_BLACKSTONE_BRICKS_SLAB = new SlabBase("crimson_warty_blackstone_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	
	public static final BlockBase WARPED_WARTY_BLACKSTONE_BRICKS = new BlockBase("warped_warty_blackstone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final WallBase WARPED_WARTY_BLACKSTONE_BRICKS_WALL = new WallBase("warped_warty_blackstone_bricks_wall", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final StairsBase WARPED_WARTY_BLACKSTONE_BRICKS_STAIRS = new StairsBase(WARPED_WARTY_BLACKSTONE_BRICKS.getDefaultState(), "warped_warty_blackstone_bricks_stairs", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	public static final SlabBase WARPED_WARTY_BLACKSTONE_BRICKS_SLAB = new SlabBase("warped_warty_blackstone_bricks_slab", 2.0f, 6.0f, Material.STONE, BlockSoundGroup.STONE);
	

}
