package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class NetherStarBlockItem extends BlockItem {

    public NetherStarBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        super.appendTooltip(stack, context, tooltip, options);
        tooltip.add(ScreenTexts.EMPTY);
        tooltip.add(Blockus.STEPPED_ON_TEXT);
        tooltip.add(ScreenTexts.space().append(StatusEffects.REGENERATION.value().getName()).append(" IV").formatted(Formatting.BLUE));
        tooltip.add(ScreenTexts.space().append(StatusEffects.ABSORPTION.value().getName()).append(" IV").formatted(Formatting.BLUE).append(" - 00:45"));
        tooltip.add(ScreenTexts.space().append(StatusEffects.STRENGTH.value().getName()).append(" III").formatted(Formatting.BLUE).append(" - 00:04"));
    }
}

