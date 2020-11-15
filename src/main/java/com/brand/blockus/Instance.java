package com.brand.blockus;

import java.util.HashMap;

import com.brand.blockus.content.*;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;

public class Instance {

	public static void init() {

			
// Flammable
		
        // general		
		FlammableBlockRegistry.getDefaultInstance().add(General.WOODEN_FRAME, 30, 60);
		
        // small hedges
		FlammableBlockRegistry.getDefaultInstance().add(Hedge.SMALL_HEDGE, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(Hedge.ACACIA_SMALL_HEDGE, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(Hedge.BIRCH_SMALL_HEDGE, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(Hedge.DARK_OAK_SMALL_HEDGE, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(Hedge.JUNGLE_SMALL_HEDGE, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(Hedge.SPRUCE_SMALL_HEDGE, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(Hedge.WHITE_OAK_SMALL_HEDGE, 30, 60);
		
		// paper		
		FlammableBlockRegistry.getDefaultInstance().add(PaperRelated.PAPER_WALL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PaperRelated.PAPER_DOOR, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PaperRelated.PAPER_BLOCK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PaperRelated.BURNED_PAPER_BLOCK, 5, 60);
		
        // timber frames
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.ACACIA_CROSS_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.ACACIA_DIAGONAL_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.ACACIA_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.BAMBOO_CROSS_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.BAMBOO_DIAGONAL_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.BAMBOO_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.BIRCH_CROSS_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.BIRCH_DIAGONAL_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.BIRCH_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.DARK_OAK_CROSS_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.DARK_OAK_DIAGONAL_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.DARK_OAK_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.JUNGLE_CROSS_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.JUNGLE_DIAGONAL_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.JUNGLE_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.OAK_CROSS_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.OAK_DIAGONAL_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.OAK_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.SPRUCE_CROSS_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.SPRUCE_DIAGONAL_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.SPRUCE_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.WHITE_OAK_CROSS_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.WHITE_OAK_DIAGONAL_TIMBER_FRAME, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(TimberFrame.WHITE_OAK_TIMBER_FRAME, 5, 20);

		
        // patterned wools
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
		
        // bamboo
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.BAMBOO_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.BAMBOO_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.BAMBOO_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.BAMBOO_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.BAMBOO_FENCE_GATE, 5, 20);
		
        // white oak
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.WHITE_OAK_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.WHITE_OAK_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.WHITE_OAK_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.WHITE_OAK_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.WHITE_OAK_FENCE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.WHITE_OAK_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.STRIPPED_WHITE_OAK_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.WHITE_OAK_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.STRIPPED_WHITE_OAK_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(NewWoods.WHITE_OAK_LEAVES, 30, 60);
		
        // small logs		
		FlammableBlockRegistry.getDefaultInstance().add(SmallLogs.OAK_SMALL_LOGS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(SmallLogs.BIRCH_SMALL_LOGS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(SmallLogs.SPRUCE_SMALL_LOGS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(SmallLogs.JUNGLE_SMALL_LOGS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(SmallLogs.ACACIA_SMALL_LOGS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(SmallLogs.DARK_OAK_SMALL_LOGS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(SmallLogs.WHITE_OAK_SMALL_LOGS, 5, 5);

		
// Fuel
        // general
		FuelRegistry.INSTANCE.add(Items.DRIED_KELP, 200);
		FuelRegistry.INSTANCE.add(Blocks.SUGAR_CANE, 50);
		
        // small hedges
		FuelRegistry.INSTANCE.add(Hedge.SMALL_HEDGE, 100);
		FuelRegistry.INSTANCE.add(Hedge.ACACIA_SMALL_HEDGE, 100);
		FuelRegistry.INSTANCE.add(Hedge.BIRCH_SMALL_HEDGE, 100);
		FuelRegistry.INSTANCE.add(Hedge.DARK_OAK_SMALL_HEDGE, 100);
		FuelRegistry.INSTANCE.add(Hedge.JUNGLE_SMALL_HEDGE, 100);
		FuelRegistry.INSTANCE.add(Hedge.SPRUCE_SMALL_HEDGE, 100);
		FuelRegistry.INSTANCE.add(Hedge.WHITE_OAK_SMALL_HEDGE, 100);
		
        // paper
		FuelRegistry.INSTANCE.add(Items.PAPER, 100);
		FuelRegistry.INSTANCE.add(PaperRelated.PAPER_WALL, 300);
		FuelRegistry.INSTANCE.add(PaperRelated.PAPER_BLOCK, 500);
		
        // timber frames
		FuelRegistry.INSTANCE.add(TimberFrame.ACACIA_CROSS_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.ACACIA_DIAGONAL_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.ACACIA_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.BAMBOO_CROSS_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.BAMBOO_DIAGONAL_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.BAMBOO_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.BIRCH_CROSS_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.BIRCH_DIAGONAL_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.BIRCH_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.DARK_OAK_CROSS_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.DARK_OAK_DIAGONAL_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.DARK_OAK_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.JUNGLE_CROSS_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.JUNGLE_DIAGONAL_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.JUNGLE_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.OAK_CROSS_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.OAK_DIAGONAL_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.OAK_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.SPRUCE_CROSS_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.SPRUCE_DIAGONAL_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.SPRUCE_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.WHITE_OAK_CROSS_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.WHITE_OAK_DIAGONAL_TIMBER_FRAME, 300);
		FuelRegistry.INSTANCE.add(TimberFrame.WHITE_OAK_TIMBER_FRAME, 300);

		
        // patterned wools
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
		
        // bamboo
		FuelRegistry.INSTANCE.add(NewWoods.BAMBOO_PLANKS, 300);
		FuelRegistry.INSTANCE.add(NewWoods.BAMBOO_SLAB, 150);
		FuelRegistry.INSTANCE.add(NewWoods.BAMBOO_STAIRS, 300);
		FuelRegistry.INSTANCE.add(NewWoods.BAMBOO_FENCE, 300);
		FuelRegistry.INSTANCE.add(NewWoods.BAMBOO_FENCE_GATE, 300);
		FuelRegistry.INSTANCE.add(NewWoods.BAMBOO_DOOR, 200);
		FuelRegistry.INSTANCE.add(NewWoods.BAMBOO_TRAPDOOR, 300);
		FuelRegistry.INSTANCE.add(NewWoods.BAMBOO_PRESSURE_PLATE, 300);
		FuelRegistry.INSTANCE.add(NewWoods.BAMBOO_BUTTON, 100);
		
        // white oak
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_LOG, 300);
		FuelRegistry.INSTANCE.add(NewWoods.STRIPPED_WHITE_OAK_LOG, 300);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_WOOD, 300);
		FuelRegistry.INSTANCE.add(NewWoods.STRIPPED_WHITE_OAK_LOG, 300);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_PLANKS, 300);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_SLAB, 150);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_STAIRS, 300);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_FENCE, 300);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_FENCE_GATE, 300);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_DOOR, 200);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_TRAPDOOR, 300);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_PRESSURE_PLATE, 300);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_BUTTON, 100);
		FuelRegistry.INSTANCE.add(NewWoods.WHITE_OAK_LEAVES, 100);
		
        // small logs
		FuelRegistry.INSTANCE.add(SmallLogs.OAK_SMALL_LOGS, 300);
		FuelRegistry.INSTANCE.add(SmallLogs.BIRCH_SMALL_LOGS, 300);
		FuelRegistry.INSTANCE.add(SmallLogs.SPRUCE_SMALL_LOGS, 300);
		FuelRegistry.INSTANCE.add(SmallLogs.JUNGLE_SMALL_LOGS, 300);
		FuelRegistry.INSTANCE.add(SmallLogs.ACACIA_SMALL_LOGS, 300);
		FuelRegistry.INSTANCE.add(SmallLogs.DARK_OAK_SMALL_LOGS, 300);
		FuelRegistry.INSTANCE.add(SmallLogs.WHITE_OAK_SMALL_LOGS, 300);
		
// Composting
		
		CompostingChanceRegistry.INSTANCE.add(Items.ROTTEN_FLESH, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.ROTTEN_FLESH_BLOCK, 0.85f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.ACACIA_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.BIRCH_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.DARK_OAK_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.JUNGLE_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.SPRUCE_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Hedge.WHITE_OAK_SMALL_HEDGE, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(NewWoods.WHITE_OAK_LEAVES, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(NewWoods.WHITE_OAK_SAPLING, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Items.BAMBOO, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(Items.GRASS_BLOCK, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Items.PODZOL, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Items.MYCELIUM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(Items.DIRT, 0.15f);
		CompostingChanceRegistry.INSTANCE.add(Items.COARSE_DIRT, 0.15f);
		CompostingChanceRegistry.INSTANCE.add(General.THATCH, 0.75f);
		CompostingChanceRegistry.INSTANCE.add(General.THATCH_STAIRS, 0.75f);
		CompostingChanceRegistry.INSTANCE.add(General.THATCH_SLAB, 0.65f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.APPLE_CRATE, 0.95f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.BEETROOT_CRATE, 0.95f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.BREAD_BOX, 1.0f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.CARROT_CRATE, 0.95f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.COOKIE_BLOCK, 1.0f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.POTATO_CRATE, 0.95f);
		CompostingChanceRegistry.INSTANCE.add(FoodBlocks.SWEET_BERRIES_CRATE, 0.50f);
		
// Other
		addStrippables();
		addPathBlocks();
	}


	public static void addStrippables() {
		AxeItem.STRIPPED_BLOCKS = new HashMap<>(AxeItem.STRIPPED_BLOCKS);
		AxeItem.STRIPPED_BLOCKS.put(NewWoods.WHITE_OAK_LOG, NewWoods.STRIPPED_WHITE_OAK_LOG);
		AxeItem.STRIPPED_BLOCKS.put(NewWoods.WHITE_OAK_WOOD, NewWoods.STRIPPED_WHITE_OAK_WOOD);
	}

	public static void addPathBlocks() {
		ShovelItem.PATH_STATES = new HashMap<>(ShovelItem.PATH_STATES);
		ShovelItem.PATH_STATES.put(Blocks.DIRT_PATH, General.PATH.getDefaultState());
	}
}
