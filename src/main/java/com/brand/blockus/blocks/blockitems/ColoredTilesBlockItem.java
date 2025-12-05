package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.ColoredTilesBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class ColoredTilesBlockItem extends BlockItem {

    public String translationKey;

    public ColoredTilesBlockItem(Block block, Item.Properties settings) {
        super(block, settings);
    }

    @Override
    public String getDescriptionId() {
        return this.getColoredTilesTranslationKey();
    }

    public String getColoredTilesTranslationKey() {
        if (this.translationKey == null) {
            this.translationKey = Util.makeDescriptionId("block", Blockus.id("colored_tiles"));
        }

        return this.translationKey;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        if (this.getBlock() instanceof ColoredTilesBlock coloredTilesBlock) {
            tooltip.add(Component.translatable(Util.makeDescriptionId("color", ResourceLocation.tryParse(ColoredTilesBlock.getColor(coloredTilesBlock.tile1))))
                .withStyle(ChatFormatting.GRAY)
                .append(" & ")
                .append(Component.translatable(Util.makeDescriptionId("color", ResourceLocation.tryParse(ColoredTilesBlock.getColor(coloredTilesBlock.tile2))))
                    .withStyle(ChatFormatting.GRAY)));
        }
    }
}
