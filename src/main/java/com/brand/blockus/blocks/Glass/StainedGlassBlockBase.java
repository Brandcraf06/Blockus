package com.brand.blockus.blocks.Glass;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class StainedGlassBlockBase extends StainedGlassBlock {

	public StainedGlassBlockBase(String name, float hardness, float resistance, DyeColor color) {
	    super(color, FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).strength(hardness, resistance).nonOpaque()
	         .allowsSpawning(Blockus::nothing).solidBlock(Blockus::never).suffocates(Blockus::never).blockVision(Blockus::never));
	    Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
	    Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
   }
}