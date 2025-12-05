package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class LegacyBlockItem extends BlockItem {
    private final String version;

    public LegacyBlockItem(Block block, Properties settings, String version) {
        super(block, settings);
        this.version = version;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        super.appendHoverText(stack, context, tooltip, options);
        this.getBlock().appendHoverText(stack, context, tooltip, options);
        tooltip.add(Component.translatable(Util.makeDescriptionId("blockitem", Blockus.id("legacy"))).withStyle(ChatFormatting.LIGHT_PURPLE));
        tooltip.add(CommonComponents.EMPTY);
        tooltip.add(Component.literal(version).withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));

    }
}
