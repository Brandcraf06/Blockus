package com.brand.blockus;

import com.brand.blockus.content.BambooPlanks;
import com.brand.blockus.content.BlazeBricks;
import com.brand.blockus.content.Bluestone;
import com.brand.blockus.content.ColoredTiles;
import com.brand.blockus.content.LavaBricks;
import com.brand.blockus.content.Other;
import com.brand.blockus.content.PaperRelated;
import com.brand.blockus.content.PatternedWools;
import com.brand.blockus.content.PolishedNetherrack;
import com.brand.blockus.content.PurpurRelated;
import com.brand.blockus.content.SandstoneBricks;
import com.brand.blockus.content.StainedStoneBricks;

import net.fabricmc.api.ModInitializer;

public class Blockus implements ModInitializer {
	
	public static final String MOD_ID = "blockus";
	public static final String VERSION = "1.0.7";
	public static final String NAME = "Blockus";
	
	@Override
	public void onInitialize() {
		StainedStoneBricks.init();
		PatternedWools.init();
		ColoredTiles.init();
		LavaBricks.init();
		BlazeBricks.init();
		Bluestone.init();
		PurpurRelated.init();
		SandstoneBricks.init();
		PaperRelated.init();
		PolishedNetherrack.init();
		BambooPlanks.init();
		Other.init();
		instance.init();
		
	}
}
