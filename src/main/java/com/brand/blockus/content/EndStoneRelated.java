package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BlockBase;


public class EndStoneRelated {

public static BlockBase CHISELED_END_STONE_BRICKS;
public static BlockBase ZIGZAGGED_END_STONE_BRICKS;
public static BlockBase POLISHED_END_STONE;

	public static void init() {
		
    CHISELED_END_STONE_BRICKS = new BlockBase("chiseled_end_stone_bricks", 3.0F, 9.0F);
    ZIGZAGGED_END_STONE_BRICKS = new BlockBase("zigzagged_end_stone_bricks", 3.0F, 9.0F);
    POLISHED_END_STONE = new BlockBase("polished_end_stone", 3.0F, 9.0F);
    
   } 
}
