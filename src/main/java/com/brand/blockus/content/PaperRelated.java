package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockPaper;
import com.brand.blockus.blocks.PaperWall;

public class PaperRelated {
	
	public static BlockPaper PAPER_BLOCK;
	public static BlockPaper BURNED_PAPER_BLOCK;
	public static PaperWall PAPER_WALL;
	
	public static void init() {
		
		PAPER_BLOCK = new BlockPaper("paper_block", 0.1f, 4.0f);
		BURNED_PAPER_BLOCK = new BlockPaper("burned_paper_block", 0.1f, 4.0f);
		PAPER_WALL = new PaperWall("paper_wall", 0.1f, 4.0f);
			
	}

}
