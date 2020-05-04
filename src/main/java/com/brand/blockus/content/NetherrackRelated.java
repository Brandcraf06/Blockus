package com.brand.blockus.content;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.CirclePavementBlock;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;


public class NetherrackRelated {
	
	public static final BlockBase POLISHED_NETHERRACK = new BlockBase("polished_netherrack", 0.4f, 0.4f, Material.STONE, BlockSoundGroup.NETHERRACK, Blockus.BLOCKUS_BUILDING_BLOCKS);
	public static final StairsBase POLISHED_NETHERRACK_STAIRS = new StairsBase(POLISHED_NETHERRACK.getDefaultState(),"polished_netherrack_stairs", 0.4f, 0.4f, Material.STONE, BlockSoundGroup.NETHERRACK);
	public static final SlabBase POLISHED_NETHERRACK_SLAB = new SlabBase("polished_netherrack_slab", 1.0f, 0.4f, Material.STONE, BlockSoundGroup.NETHERRACK);
	public static final CirclePavementBlock NETHERRACK_CIRCLE_PAVEMENT = new CirclePavementBlock("netherrack_circle_pavement", 1.0f, 0.4f, Material.STONE, BlockSoundGroup.NETHERRACK);

}