package com.brand.blockus;

import com.brand.blockus.content.Other;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;

public class BlockusClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		ColorProviderRegistry.BLOCK.register((block, world, pos, layer) -> {
			BlockColorProvider provider = ColorProviderRegistry.BLOCK.get(Blocks.OAK_LEAVES);
			return provider == null ? -1 : provider.getColor(block, world, pos, layer);
		}, Other.SMALL_HEDGE);	
		
		ColorProviderRegistry.ITEM.register((item, layer) -> {
		ItemColorProvider provider = ColorProviderRegistry.ITEM.get(Other.SMALL_HEDGE);
		return provider == null ? -1 : provider.getColor(item, layer);
	    }, Other.SMALL_HEDGE);		
    }
}