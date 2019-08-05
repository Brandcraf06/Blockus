package com.brand.blockus;

import com.brand.blockus.config.BlockusConfig;
import com.brand.blockus.content.ADGRelated;
import com.brand.blockus.content.Asphalt;
import com.brand.blockus.content.BambooPlanks;
import com.brand.blockus.content.Barrels;
import com.brand.blockus.content.BlazeBricks;
import com.brand.blockus.content.Bluestone;
import com.brand.blockus.content.ColoredTiles;
import com.brand.blockus.content.EndStoneRelated;
import com.brand.blockus.content.FoodBlocks;
import com.brand.blockus.content.GlassRelated;
import com.brand.blockus.content.GlazedTerracottaPillars;
import com.brand.blockus.content.Hedge;
import com.brand.blockus.content.LavaBricks;
import com.brand.blockus.content.LegacyBlocks;
import com.brand.blockus.content.Limestone;
import com.brand.blockus.content.MagmaBricks;
import com.brand.blockus.content.Marble;
import com.brand.blockus.content.NetherBricksRelated;
import com.brand.blockus.content.NetherrackRelated;
import com.brand.blockus.content.ObsidianRelated;
import com.brand.blockus.content.Other;
import com.brand.blockus.content.PaperRelated;
import com.brand.blockus.content.PatternedWools;
import com.brand.blockus.content.PrismarineRelated;
import com.brand.blockus.content.PurpurRelated;
import com.brand.blockus.content.QuartzRelated;
import com.brand.blockus.content.Rainbow;
import com.brand.blockus.content.RedstoneLamps;
import com.brand.blockus.content.SandstoneBricks;
import com.brand.blockus.content.SoakedBricks;
import com.brand.blockus.content.SoulSandstone;
import com.brand.blockus.content.StainedStoneBricks;
import com.brand.blockus.content.StoneRelated;
import com.brand.blockus.content.WaterBricks;
import com.brand.blockus.world.BlockusGen;

import me.sargunvohra.mcmods.autoconfig1.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Blockus implements ModInitializer {
	
	public static final String MOD_ID = "blockus";
	public static final String VERSION = "1.2.0";
	public static final String NAME = "Blockus";
	public static final BlockusConfig CONFIG = AutoConfig.register(BlockusConfig.class, GsonConfigSerializer::new).getConfig();
	public static final ItemGroup BLOCKUS_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_building_blocks"), () -> new ItemStack(LavaBricks.LAVA_BRICKS));
	public static final ItemGroup BLOCKUS_DECORATIONS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_decorations"), () -> new ItemStack(Hedge.SMALL_HEDGE));
	public static final ItemGroup BLOCKUS_REDSTONE = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_redstone"), () -> new ItemStack(Blocks.REDSTONE_BLOCK));

	@Override
	public void onInitialize() {
		StainedStoneBricks.init();
		PatternedWools.init();
		ColoredTiles.init();
		GlazedTerracottaPillars.init();
		GlassRelated.init();
		StoneRelated.init();
		Asphalt.init();
		ADGRelated.init();
		LavaBricks.init();
		WaterBricks.init();
		MagmaBricks.init();
		SoakedBricks.init();
		SandstoneBricks.init();
		SoulSandstone.init();
		PrismarineRelated.init();
		EndStoneRelated.init();
		PurpurRelated.init();
		ObsidianRelated.init();
		Rainbow.init();
		RedstoneLamps.init();
		Limestone.init();
		Marble.init();
		Bluestone.init();
		QuartzRelated.init();
		PaperRelated.init();
		NetherrackRelated.init();
		NetherBricksRelated.init();
		BlazeBricks.init();
		FoodBlocks.init();
		BambooPlanks.init();
		Hedge.init();
		new Barrels();
		Other.init();
		LegacyBlocks.init();
		instance.init();
		
		BlockusGen.addLimestone();
		BlockusGen.addMarble();
		BlockusGen.addBluestone();
	
   
	}
}
