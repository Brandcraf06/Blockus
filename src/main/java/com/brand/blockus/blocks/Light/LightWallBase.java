package com.brand.blockus.blocks.Light;


import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.WallBlock;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LightWallBase extends WallBlock {

	public LightWallBase(String name, float hardness, float resistance, Material material, BlockSoundGroup sound, int lightlevel) {
		super(FabricBlockSettings.of(material).sounds(sound).lightLevel(lightlevel).requiresTool().strength(hardness, resistance));
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_DECORATIONS)));
	}
	
}
