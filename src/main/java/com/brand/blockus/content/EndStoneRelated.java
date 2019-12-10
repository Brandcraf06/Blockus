package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;

public class EndStoneRelated {

public static BlockBase CHISELED_END_STONE_BRICKS;
public static BlockBase ZIGZAGGED_END_STONE_BRICKS;

	public static void init() {
		
    CHISELED_END_STONE_BRICKS = new BlockBase("chiseled_end_stone_bricks", 0.8f, 9.0f);
    ZIGZAGGED_END_STONE_BRICKS = new BlockBase("zigzagged_end_stone_bricks", 0.8f, 9.0f);
    
   } 
}
