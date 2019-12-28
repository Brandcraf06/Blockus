package com.brand.blockus;

import com.brand.blockus.content.BambooPlanks;
import com.brand.blockus.content.FoodBlocks;
import com.brand.blockus.content.Hedge;
import com.brand.blockus.content.Other;
import com.brand.blockus.content.PaperRelated;
import com.brand.blockus.content.PatternedWools;

import com.brand.blockus.world.BlockusGen;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.world.biome.Biome;

public class instance {

	public static void init() {
		for (Biome biome : Biome.BIOMES)
		{
			BlockusGen.addBluestone(biome);
			BlockusGen.addLimestone(biome);
			BlockusGen.addMarble(biome);
		}
		FuelRegistry.INSTANCE.add(Items.DRIED_KELP, 200);
		FuelRegistry.INSTANCE.add(Blocks.SUGAR_CANE, 50);
		FuelRegistry.INSTANCE.add(Items.PAPER, 100);
		FuelRegistry.INSTANCE.add(PaperRelated.PAPER_WALL, 300);
		FuelRegistry.INSTANCE.add(PaperRelated.PAPER_BLOCK, 500);
		FuelRegistry.INSTANCE.add(PaperRelated.BURNED_PAPER_BLOCK, 50);
		FuelRegistry.INSTANCE.add(PatternedWools.WHITE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.ORANGE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.MAGENTA_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.LIGHT_BLUE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.YELLOW_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.LIME_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.PINK_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.GRAY_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.LIGHT_GRAY_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.CYAN_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.PURPLE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.BLUE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.BROWN_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.GREEN_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.RED_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(PatternedWools.BLACK_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(BambooPlanks.BAMBOO_PLANKS, 300);
		FuelRegistry.INSTANCE.add(BambooPlanks.BAMBOO_SLAB, 150);
		FuelRegistry.INSTANCE.add(BambooPlanks.BAMBOO_STAIRS, 300);
		FuelRegistry.INSTANCE.add(BambooPlanks.BAMBOO_FENCE, 300);
		FuelRegistry.INSTANCE.add(BambooPlanks.BAMBOO_FENCE_GATE, 300);
		FuelRegistry.INSTANCE.add(BambooPlanks.BAMBOO_DOOR, 200);
		FuelRegistry.INSTANCE.add(BambooPlanks.BAMBOO_TRAPDOOR, 300);
		FuelRegistry.INSTANCE.add(BambooPlanks.BAMBOO_PRESSURE_PLATE, 300);
		FuelRegistry.INSTANCE.add(BambooPlanks.BAMBOO_BUTTON, 100);
		
		FlammableBlockRegistry.getDefaultInstance().add(PaperRelated.PAPER_WALL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PaperRelated.PAPER_DOOR, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PaperRelated.PAPER_BLOCK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PaperRelated.BURNED_PAPER_BLOCK, 5, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.WHITE_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.ORANGE_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.MAGENTA_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.LIGHT_BLUE_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.YELLOW_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.LIME_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.PINK_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.GRAY_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.LIGHT_GRAY_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.CYAN_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.PURPLE_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.BLUE_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.BROWN_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.GREEN_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.RED_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PatternedWools.BLACK_PATTERNED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(BambooPlanks.BAMBOO_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(BambooPlanks.BAMBOO_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(BambooPlanks.BAMBOO_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(BambooPlanks.BAMBOO_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(BambooPlanks.BAMBOO_FENCE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(Other.WOODEN_FRAME, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(Hedge.SMALL_HEDGE, 30, 60);
		
		CompostingChanceRegistry.INSTANCE.add(Items.ROTTEN_FLESH, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.ROTTEN_FLESH_BLOCK, 0.85f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.ACACIA_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.BIRCH_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.DARK_OAK_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.JUNGLE_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.SPRUCE_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Items.BAMBOO, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(Items.GRASS_BLOCK, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Items.PODZOL, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Items.MYCELIUM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Items.DIRT, 0.15f);
		CompostingChanceRegistry.INSTANCE.add(Items.COARSE_DIRT, 0.15f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.APPLE_CRATE, 0.95f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.BEETROOT_CRATE, 0.95f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.BREAD_BOX, 1.0f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.CARROT_CRATE, 0.95f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.COOKIE_BLOCK, 1.0f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.POTATO_CRATE, 0.95f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.SWEET_BERRIES_CRATE, 0.50f);
	}
}
