package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.blocks.base.ColoredTilesBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class ColoredTilesBlockItem extends BlockItem {

    public ColoredTilesBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {
        if (this.getBlock() instanceof ColoredTilesBlock coloredTilesBlock) {
            textConsumer.accept(Component.translatable(Util.makeDescriptionId("color", Identifier.tryParse(ColoredTilesBlock.getColor(coloredTilesBlock.tile1))))
                .withStyle(ChatFormatting.GRAY)
                .append(" & ")
                .append(Component.translatable(Util.makeDescriptionId("color", Identifier.tryParse(ColoredTilesBlock.getColor(coloredTilesBlock.tile2))))
                    .withStyle(ChatFormatting.GRAY)));
        }
    }
}
