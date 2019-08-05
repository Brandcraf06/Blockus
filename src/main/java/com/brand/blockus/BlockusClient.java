package com.brand.blockus;

import com.brand.blockus.content.Hedge;
import com.brand.blockus.content.WaterBricks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;

public class BlockusClient implements ClientModInitializer {

	@Override
public void onInitializeClient() {
		
		registerBlockColor(Hedge.SMALL_HEDGE, Blocks.OAK_LEAVES);
		registerBlockColor(Hedge.SPRUCE_SMALL_HEDGE, Blocks.SPRUCE_LEAVES);
		registerBlockColor(Hedge.BIRCH_SMALL_HEDGE, Blocks.BIRCH_LEAVES);
		registerBlockColor(Hedge.JUNGLE_SMALL_HEDGE, Blocks.JUNGLE_LEAVES);
		registerBlockColor(Hedge.ACACIA_SMALL_HEDGE, Blocks.ACACIA_LEAVES);
		registerBlockColor(Hedge.DARK_OAK_SMALL_HEDGE, Blocks.DARK_OAK_LEAVES);
		registerBlockColor(WaterBricks.WATER_BRICKS, Blocks.WATER);
		registerBlockColor(WaterBricks.WATER_BRICKS_STAIRS, Blocks.WATER);
		registerBlockColor(WaterBricks.WATER_BRICKS_SLAB, Blocks.WATER);
		registerBlockColor(WaterBricks.WATER_BRICKS_WALL, Blocks.WATER);
		registerBlockColor(WaterBricks.CHISELED_WATER_BRICKS, Blocks.WATER);
		
}
	
	public void registerBlockColor(Block block, Block templateBlock) {
		ColorProviderRegistry.BLOCK.register((block1, pos, world, layer) -> {
			BlockColorProvider provider = ColorProviderRegistry.BLOCK.get(templateBlock);
			return provider == null ? -1 : provider.getColor(block1, pos, world, layer);
		}, block);

		ColorProviderRegistry.ITEM.register((item, layer) -> {
			ItemColorProvider provider = ColorProviderRegistry.ITEM.get(templateBlock);
			return provider == null ? -1 : provider.getColor(item, layer);
		}, block.asItem());
	}

}