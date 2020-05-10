package com.brand.blockus.blocks.Sapling;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PottedBlockBase extends FlowerPotBlock {

	public PottedBlockBase(Block content, String name) {
		super(content, FabricBlockSettings.of(Material.PART).breakInstantly().nonOpaque());
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
	}
}
