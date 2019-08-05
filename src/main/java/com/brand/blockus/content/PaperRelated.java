package com.brand.blockus.content;

import com.brand.blockus.blocks.Paper.BlockPaper;
import com.brand.blockus.blocks.Paper.PaperDoor;
import com.brand.blockus.blocks.Paper.PaperLight;
import com.brand.blockus.blocks.Paper.PaperTrapdoor;
import com.brand.blockus.blocks.Paper.PaperWall;

public class PaperRelated {
	
	public static BlockPaper PAPER_BLOCK;
	public static BlockPaper BURNED_PAPER_BLOCK;
	public static PaperWall PAPER_WALL;
	public static PaperDoor PAPER_DOOR;
	public static PaperTrapdoor PAPER_TRAPDOOR;
	public static PaperLight PAPER_LAMP;
	
	public static void init() {
		
		PAPER_BLOCK = new BlockPaper("paper_block", 0.1f, 0.8f);
		BURNED_PAPER_BLOCK = new BlockPaper("burned_paper_block", 0.1f, 0.8f);
		PAPER_WALL = new PaperWall("paper_wall", 0.1f, 0.8f);
		PAPER_DOOR = new PaperDoor("paper_door", 0.1f, 0.8f);
		PAPER_TRAPDOOR = new PaperTrapdoor("paper_trapdoor", 0.1f, 0.8f);
		PAPER_LAMP = new PaperLight("paper_lamp", 0.1f, 0.8f);
			
	}

}
