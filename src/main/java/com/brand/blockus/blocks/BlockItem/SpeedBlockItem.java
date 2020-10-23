package com.brand.blockus.blocks.BlockItem;

import com.brand.blockus.Blockus;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class SpeedBlockItem extends BlockItem {

	public SpeedBlockItem(Block block, Settings settings) {
		super(block, settings);
	}
		
@Override
@Environment(EnvType.CLIENT)
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);
		this.getBlock().appendTooltip(stack, world, tooltip, context);
		tooltip.add((new TranslatableText(Blockus.MOD_ID + ".blockItem.givespeed")).formatted(Formatting.DARK_PURPLE));
		
		}
	}