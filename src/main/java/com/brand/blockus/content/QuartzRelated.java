package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.CirclePavementBlock;

import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class QuartzRelated {
	
public static final BlockBase QUARTZ_BRICKS = new BlockBase("quartz_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS);
public static final CirclePavementBlock QUARTZ_CIRCLE_PAVEMENT = new CirclePavementBlock("quartz_circle_pavement", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE);
	
}
