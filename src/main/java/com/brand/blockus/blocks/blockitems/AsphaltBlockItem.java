package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.effect.BlockusEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class AsphaltBlockItem extends BlockItem {

    public AsphaltBlockItem(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        tooltip.add(CommonComponents.EMPTY);
        tooltip.add(Blockus.STEPPED_ON_TEXT);
        tooltip.add(CommonComponents.space().append(BlockusEffects.ASPHALT_SPRINT.value().getDisplayName()).withStyle(ChatFormatting.BLUE));
    }
}
