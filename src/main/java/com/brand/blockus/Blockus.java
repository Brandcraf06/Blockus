package com.brand.blockus;

import com.brand.blockus.content.*;
import me.shedaniel.cloth.api.dynamic.registry.v1.EarlyInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("deprecation")
public class Blockus implements ModInitializer, EarlyInitializer {
	
	public static final String MOD_ID = "blockus";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ItemGroup BLOCKUS_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_building_blocks"), () -> new ItemStack(BlazeBricks.BLAZE_BRICKS));
	public static final ItemGroup BLOCKUS_DECORATIONS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_decorations"), () -> new ItemStack(Hedge.SMALL_HEDGE));
	public static final ItemGroup BLOCKUS_REDSTONE = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_redstone"), () -> new ItemStack(General.REDSTONE_SAND));
	
	@Override
	public void onInitialize() {

		new StonesRelated();
		new NewStones();
		new NewWoods();
		new SmallLogs();
		new TimberFrame();
		new Hedge();
		new LargeFlowerPots();
		new Barrels();
		new GlazedTerracottaPillars();
		new GlassRelated();
		new Asphalt();
		new Shingles();
		new FluidBricks();
		new MagmaBricks();
		new NewBricks();
		new SandstoneBricks();
		new SoulSandstone();
		new PrismarineRelated();
		new EndStoneRelated();
		new PurpurRelated();
		new ObsidianRelated();
		new Rainbow();
		new RedstoneLamps();
		new PaperRelated();
		new NetherrackRelated();
		new NetherBricksRelated();
		new BlazeBricks();
		new FoodBlocks();
		new StainedStoneBricks();
		new PatternedWools();
		new ColoredTiles();
		new FuturneoBlocks();
		new General();
		new LegacyBlocks();
		new StonesSwitches();
		Instance.init();
	}
	
	@Override
	public void onEarlyInitialization() {
		// See BlockusConfiguredFeatures for more detail of why this is commented out
//		DynamicRegistryCallback.callback(Registry.BIOME_KEY).register((dynamicRegistryManager, registryKey, biome) -> {
//			BlockusGen.addMineables(registryKey, biome);
//			BlockusGen.addWhiteOakTrees(registryKey, biome);
//			BlockusGen.addPlainsWhiteOakTrees(registryKey, biome);
//		});
	}
	
	public static boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}
	
	public static boolean never(BlockState state, BlockView world, BlockPos pos) {
		return false;
	}
	
	public static boolean nothing(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return false;
	}
}

