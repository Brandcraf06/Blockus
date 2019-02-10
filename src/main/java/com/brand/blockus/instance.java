package com.brand.blockus;

import com.brand.blockus.content.BambooPlanks;
import com.brand.blockus.content.Other;
import com.brand.blockus.content.PaperRelated;
import com.brand.blockus.content.PatternedWools;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

public class instance {

	public static void init() {
		
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
		
		CompostingChanceRegistry.INSTANCE.add(Items.ROTTEN_FLESH, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(Other.ROTTEN_FLESH_BLOCK, 1.0f);
	}
}
