package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.ColoredTilesBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ColoredTilesBlockItem extends BlockItem {

    public String translationKey;

    public ColoredTilesBlockItem(Block block, Item.Settings settings) {
        super(block, settings);
    }

    @Override
    public String getTranslationKey() {
        return this.getColoredTilesTranslationKey();
    }

    public String getColoredTilesTranslationKey() {
        if (this.translationKey == null) {
            this.translationKey = Util.createTranslationKey("block", Blockus.id("colored_tiles"));
        }

        return this.translationKey;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if (this.getBlock() instanceof ColoredTilesBlock coloredTilesBlock) {
            tooltip.add(Text.translatable(Util.createTranslationKey("color", Identifier.tryParse(ColoredTilesBlock.getColor(coloredTilesBlock.tile1))))
                .formatted(Formatting.GRAY)
                .append(" & ")
                .append(Text.translatable(Util.createTranslationKey("color", Identifier.tryParse(ColoredTilesBlock.getColor(coloredTilesBlock.tile2))))
                    .formatted(Formatting.GRAY)));
        }
    }
}
