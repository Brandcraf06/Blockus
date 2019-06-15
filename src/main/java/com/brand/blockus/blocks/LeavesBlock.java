package com.brand.blockus.blocks;

import com.brand.blockus.Blockus;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LeavesBlock extends Block {
	
	public static boolean translucentLeaves;

	public LeavesBlock(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).strength(hardness, resistance).build());
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
	}
	
	@Environment(EnvType.CLIENT)
	public static void setRenderingMode(boolean boolean_1) {
	    translucentLeaves = boolean_1;
	}

	public BlockRenderLayer getRenderLayer() {
		return translucentLeaves ? BlockRenderLayer.SOLID : BlockRenderLayer.TRANSLUCENT;
	}
}
