package com.brand.blockus.content;

import com.brand.blockus.blocks.BlockPaper;
import com.brand.blockus.blocks.PaperDoor;
import com.brand.blockus.blocks.PaperTrapdoor;
import com.brand.blockus.blocks.PaperWall;

public class PaperRelated {
	
	public static BlockPaper PAPER_BLOCK;
	public static BlockPaper BURNED_PAPER_BLOCK;
	public static PaperWall PAPER_WALL;
	public static PaperDoor PAPER_DOOR;
	public static PaperTrapdoor PAPER_TRAPDOOR;
	
	public static void init() {
		
		PAPER_BLOCK = new BlockPaper("paper_block", 0.1f, 4.0f);
		BURNED_PAPER_BLOCK = new BlockPaper("burned_paper_block", 0.1f, 4.0f);
		PAPER_WALL = new PaperWall("paper_wall", 0.1f, 4.0f);
		PAPER_DOOR = new PaperDoor("paper_door", 0.1f, 4.0f);
		PAPER_TRAPDOOR = new PaperTrapdoor("paper_trapdoor", 0.1f, 4.0f);
			
	}

}
