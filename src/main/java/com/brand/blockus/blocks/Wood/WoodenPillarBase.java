package com.brand.blockus.blocks.Wood;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class WoodenPillarBase extends PillarBlock {
	
	public WoodenPillarBase(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0).strength(hardness, resistance).build());
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
	}

}
