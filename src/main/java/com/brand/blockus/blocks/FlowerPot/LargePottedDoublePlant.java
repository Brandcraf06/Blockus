package com.brand.blockus.blocks.FlowerPot;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LargePottedDoublePlant extends LargeFlowerPotBlock {

	public LargePottedDoublePlant(Block content, String name) {
		super(content, FabricBlockSettings.of(Material.SUPPORTED).breakByHand(true).strength(0.5F, 1.0F).nonOpaque());
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
	}
}
