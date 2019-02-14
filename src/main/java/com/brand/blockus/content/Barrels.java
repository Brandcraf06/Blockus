package com.brand.blockus.content;

import com.brand.blockus.blocks.WoodenBarrels;

public class Barrels {
	
	public static WoodenBarrels OAK_BARREL;
	public static WoodenBarrels BIRCH_BARREL;
	public static WoodenBarrels JUNGLE_BARREL;
	public static WoodenBarrels ACACIA_BARREL;
	public static WoodenBarrels DARK_OAK_BARREL;
	public static WoodenBarrels BAMBOO_BARREL;
	
	public static void init() {
		
		OAK_BARREL = new WoodenBarrels("oak_barrel", 2.0f, 15.0f);
		BIRCH_BARREL = new WoodenBarrels("birch_barrel", 2.0f, 15.0f);
		JUNGLE_BARREL = new WoodenBarrels("jungle_barrel", 2.0f, 15.0f);
		ACACIA_BARREL = new WoodenBarrels("acacia_barrel", 2.0f, 15.0f);
		DARK_OAK_BARREL = new WoodenBarrels("dark_oak_barrel", 2.0f, 15.0f);
		BAMBOO_BARREL = new WoodenBarrels("bamboo_barrel", 2.0f, 15.0f);
			
	}

}
