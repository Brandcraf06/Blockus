package com.brand.blockus.blocks;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockPaper extends Block {
	
	public BlockPaper(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.WOOL).sounds(BlockSoundGroup.GRASS).breakByHand(true).strength(hardness, resistance).build());	
		Registry.BLOCK.register(new Identifier(Blockus.MOD_ID, name), this);
		Registry.ITEM.register(new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().stackSize(64).itemGroup(ItemGroup.BUILDING_BLOCKS)));
	}
	
}
