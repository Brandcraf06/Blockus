package com.brand.blockus;

import com.brand.blockus.content.MBlocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

public class Blockus implements ModInitializer {
	
	public static final String MOD_ID = "blockus";
	public static final String VERSION = "1.0.6";
	public static final String NAME = "Blockus";
	
	@Override
	public void onInitialize() {
		MBlocks.init();
		
		FuelRegistry.INSTANCE.add(Items.DRIED_KELP, 200);
		FuelRegistry.INSTANCE.add(Blocks.SUGAR_CANE, 50);
		FuelRegistry.INSTANCE.add(Items.PAPER, 100);
		FuelRegistry.INSTANCE.add(MBlocks.PAPER_BLOCK, 500);
		FuelRegistry.INSTANCE.add(MBlocks.BURNED_PAPER_BLOCK, 50);
		FuelRegistry.INSTANCE.add(MBlocks.WHITE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.ORANGE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.MAGENTA_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.LIGHT_BLUE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.YELLOW_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.LIME_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.PINK_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.GRAY_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.LIGHT_GRAY_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.CYAN_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.PURPLE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.BLUE_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.BROWN_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.GREEN_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.RED_PATTERNED_WOOL, 100);
		FuelRegistry.INSTANCE.add(MBlocks.BLACK_PATTERNED_WOOL, 100);
		CompostingChanceRegistry.INSTANCE.add(Items.ROTTEN_FLESH, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(MBlocks.ROTTEN_FLESH_BLOCK, 1.0f);
	}
}
