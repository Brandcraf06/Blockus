package com.brand.blockus;

import com.brand.blockus.content.MBlocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

public class Blockus implements ModInitializer {
	
	public static final String MOD_ID = "blockus";
	public static final String VERSION = "1.0.4";
	public static final String NAME = "Blockus";
	
	@Override
	public void onInitialize() {
		MBlocks.init();
		
		FuelRegistry.INSTANCE.add(Items.DRIED_KELP, 200);
		FuelRegistry.INSTANCE.add(Blocks.SUGAR_CANE, 50);
		FuelRegistry.INSTANCE.add(Items.PAPER, 100);
		FuelRegistry.INSTANCE.add(MBlocks.PAPER_BLOCK, 500);
		FuelRegistry.INSTANCE.add(MBlocks.BURNED_PAPER_BLOCK, 50);
		CompostingChanceRegistry.INSTANCE.add(Items.ROTTEN_FLESH, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(MBlocks.ROTTEN_FLESH_BLOCK, 1.0f);
	}
}
