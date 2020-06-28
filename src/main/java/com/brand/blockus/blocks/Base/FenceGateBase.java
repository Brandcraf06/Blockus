package com.brand.blockus.blocks.Base;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FenceGateBase extends FenceGateBlock {
	
	public FenceGateBase(String name, float hardness, float resistance, MaterialColor color) {
		super(FabricBlockSettings.of(Material.WOOD, color).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0).strength(hardness, resistance));
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_REDSTONE)));
	}
}
