package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.blocks.base.ColoredTilesBlock;
import net.minecraft.block.Block;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.function.Consumer;

public class ColoredTilesBlockItem extends BlockItem {

    public ColoredTilesBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        if (this.getBlock() instanceof ColoredTilesBlock coloredTilesBlock) {
            textConsumer.accept(Text.translatable(Util.createTranslationKey("color", Identifier.tryParse(ColoredTilesBlock.getColor(coloredTilesBlock.tile1))))
                .formatted(Formatting.GRAY)
                .append(" & ")
                .append(Text.translatable(Util.createTranslationKey("color", Identifier.tryParse(ColoredTilesBlock.getColor(coloredTilesBlock.tile2))))
                    .formatted(Formatting.GRAY)));
        }
    }
}
