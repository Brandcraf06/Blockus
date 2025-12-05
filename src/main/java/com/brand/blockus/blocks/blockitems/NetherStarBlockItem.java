package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class NetherStarBlockItem extends BlockItem {

    public NetherStarBlockItem(Block block, Properties settings) {
        super(block, settings);
    }

    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        super.appendHoverText(stack, context, tooltip, options);
        tooltip.add(CommonComponents.EMPTY);
        tooltip.add(Component.translatable(Util.makeDescriptionId("blockitem", Blockus.id("when_stepped_on"))).withStyle(ChatFormatting.GRAY));
        tooltip.add(CommonComponents.space().append(MobEffects.REGENERATION.value().getDisplayName()).append(" IV").withStyle(ChatFormatting.BLUE));
        tooltip.add(CommonComponents.space().append(MobEffects.ABSORPTION.value().getDisplayName()).append(" IV").withStyle(ChatFormatting.BLUE).append(" - 00:45"));
        tooltip.add(CommonComponents.space().append(MobEffects.DAMAGE_BOOST.value().getDisplayName()).append(" III").withStyle(ChatFormatting.BLUE).append(" - 00:04"));
    }
}

