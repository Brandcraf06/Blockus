package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class NetherStarBlockItem extends BlockItem {

    public NetherStarBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        this.getBlock().appendTooltip(stack, world, tooltip, context);
        tooltip.add(ScreenTexts.EMPTY);
        tooltip.add(Blockus.STEPPED_ON_TEXT);
        tooltip.add(ScreenTexts.space().append(StatusEffects.REGENERATION.getName()).append(" IV").formatted(Formatting.BLUE));
        tooltip.add(ScreenTexts.space().append(StatusEffects.ABSORPTION.getName()).append(" IV").formatted(Formatting.BLUE).append(" - 00:45"));
        tooltip.add(ScreenTexts.space().append(StatusEffects.STRENGTH.getName()).append(" III").formatted(Formatting.BLUE).append(" - 00:04"));
    }
}

