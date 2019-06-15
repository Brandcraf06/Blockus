package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockBase;
import com.brand.blockus.blocks.CirclePavementBlock;

public class QuartzRelated {
	
public static BlockBase QUARTZ_BRICKS;
public static CirclePavementBlock QUARTZ_CIRCLE_PAVEMENT;
	
	public static void init() {
	
	QUARTZ_BRICKS= new BlockBase("quartz_bricks", 0.8f, 0.8f);
	QUARTZ_CIRCLE_PAVEMENT = new CirclePavementBlock("quartz_circle_pavement", 0.8f, 0.8f);
	
	}
}
