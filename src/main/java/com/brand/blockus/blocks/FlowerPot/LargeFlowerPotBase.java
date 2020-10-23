package com.brand.blockus.blocks.FlowerPot;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LargeFlowerPotBase extends LargeFlowerPotBlock {

	public LargeFlowerPotBase(Block content, String name) {
		super(content, FabricBlockSettings.of(Material.SUPPORTED).strength(0.5F, 1.0F).nonOpaque());
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_DECORATIONS)));
		
	   }

} 