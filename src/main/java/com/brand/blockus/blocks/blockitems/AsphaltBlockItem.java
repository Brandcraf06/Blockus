package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.effect.BlockusEffects;
import net.minecraft.block.Block;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class AsphaltBlockItem extends BlockItem {

    public AsphaltBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(ScreenTexts.EMPTY);
        textConsumer.accept(Blockus.STEPPED_ON_TEXT);
        textConsumer.accept(ScreenTexts.space().append(BlockusEffects.ASPHALT_SPRINT.value().getName()).formatted(Formatting.BLUE));
    }
}
