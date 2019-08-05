package com.brand.blockus.content;

import com.brand.blockus.blocks.Base.BaseGrassBlock;
import com.brand.blockus.blocks.FoodBlocks.Crate;
import com.brand.blockus.blocks.FoodBlocks.EatableBase;
import com.brand.blockus.blocks.FoodBlocks.MeatBlock;
import com.brand.blockus.blocks.FoodBlocks.OrientableCrate;
import com.brand.blockus.blocks.FoodBlocks.RareCrate;

public class FoodBlocks {

	public static Crate SWEET_BERRIES_CRATE;
	public static Crate SALMON_CRATE;
	public static Crate PUFFERFISH_CRATE;
	public static Crate TROPICAL_FISH_CRATE;
	public static Crate COD_CRATE;
	public static EatableBase COOKIE_BLOCK;
	public static BaseGrassBlock CHORUS_BLOCK;
	public static Crate POTATO_CRATE;
	public static Crate APPLE_CRATE;
	public static Crate BEETROOT_CRATE;
	public static Crate CARROT_CRATE;
	public static OrientableCrate BREAD_BOX;
	public static RareCrate GOLDEN_APPLE_CRATE;
	public static Crate GOLDEN_CARROT_CRATE;
	public static MeatBlock ROTTEN_FLESH_BLOCK;

	public static void init() {
		
    SWEET_BERRIES_CRATE = new Crate("sweet_berries_crate", 2.5f, 2.5f);
    SALMON_CRATE = new Crate("salmon_crate", 2.5f, 2.5f);
    PUFFERFISH_CRATE = new Crate("pufferfish_crate", 2.5f, 2.5f);
    TROPICAL_FISH_CRATE = new Crate("tropical_fish_crate", 2.5f, 2.5f);
    COD_CRATE = new Crate("cod_crate", 2.5f, 2.5f);
    COOKIE_BLOCK = new EatableBase("cookie_block", 1.5f, 1.5f);
    CHORUS_BLOCK = new BaseGrassBlock("chorus_block", 1.5f, 1.5f);
    POTATO_CRATE = new Crate("potato_crate", 2.5f, 2.5f);
    APPLE_CRATE = new Crate("apple_crate", 2.5f, 2.5f);
    BEETROOT_CRATE = new Crate("beetroot_crate", 2.5f, 2.5f);
    CARROT_CRATE = new Crate("carrot_crate", 2.5f, 2.5f);
    BREAD_BOX = new OrientableCrate("bread_box", 2.5f, 2.5f);
    GOLDEN_APPLE_CRATE = new RareCrate("golden_apple_crate", 2.5f, 2.5f);
    GOLDEN_CARROT_CRATE = new Crate("golden_carrot_crate", 2.5f, 2.5f);
	ROTTEN_FLESH_BLOCK = new MeatBlock("rotten_flesh_block", 1.5f, 1.5f);
    
   } 
}