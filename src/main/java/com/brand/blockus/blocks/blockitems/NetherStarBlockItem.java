package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class NetherStarBlockItem extends BlockItem {

    public NetherStarBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(ScreenTexts.EMPTY);
        textConsumer.accept(Blockus.STEPPED_ON_TEXT);
        textConsumer.accept(ScreenTexts.space().append(StatusEffects.REGENERATION.value().getName()).append(" IV").formatted(Formatting.BLUE));
        textConsumer.accept(ScreenTexts.space().append(StatusEffects.ABSORPTION.value().getName()).append(" IV").formatted(Formatting.BLUE).append(" - 00:45"));
        textConsumer.accept(ScreenTexts.space().append(StatusEffects.STRENGTH.value().getName()).append(" III").formatted(Formatting.BLUE).append(" - 00:04"));
    }
}

