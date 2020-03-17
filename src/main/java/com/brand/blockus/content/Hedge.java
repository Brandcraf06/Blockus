package com.brand.blockus.content;

import com.brand.blockus.blocks.Leaves.SmallHedge;

public class Hedge {
	
	public static SmallHedge SMALL_HEDGE;
	public static SmallHedge SPRUCE_SMALL_HEDGE;
	public static SmallHedge BIRCH_SMALL_HEDGE;
	public static SmallHedge JUNGLE_SMALL_HEDGE;
	public static SmallHedge ACACIA_SMALL_HEDGE;
	public static SmallHedge DARK_OAK_SMALL_HEDGE;
	public static SmallHedge WHITE_OAK_SMALL_HEDGE;
	
	public static void init() {
		
		SMALL_HEDGE = new SmallHedge("small_hedge", 0.2f, 1.0f);
		SPRUCE_SMALL_HEDGE = new SmallHedge("spruce_small_hedge", 0.2f, 1.0f);
		BIRCH_SMALL_HEDGE = new SmallHedge("birch_small_hedge", 0.2f, 1.0f);
		JUNGLE_SMALL_HEDGE = new SmallHedge("jungle_small_hedge", 0.2f, 1.0f);
		ACACIA_SMALL_HEDGE = new SmallHedge("acacia_small_hedge", 0.2f, 1.0f);
		DARK_OAK_SMALL_HEDGE = new SmallHedge("dark_oak_small_hedge", 0.2f, 1.0f);
		WHITE_OAK_SMALL_HEDGE = new SmallHedge("white_oak_small_hedge", 0.2f, 1.0f);
	    
	}
}
