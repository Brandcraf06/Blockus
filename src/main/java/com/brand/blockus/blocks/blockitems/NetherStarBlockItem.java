package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Util;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class NetherStarBlockItem extends BlockItem {

    public NetherStarBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {
        textConsumer.accept(CommonComponents.EMPTY);
        textConsumer.accept(Component.translatable(Util.makeDescriptionId("blockitem", Blockus.id("when_stepped_on"))).withStyle(ChatFormatting.GRAY));
        textConsumer.accept(CommonComponents.space().append(MobEffects.REGENERATION.value().getDisplayName()).append(" IV").withStyle(ChatFormatting.BLUE));
        textConsumer.accept(CommonComponents.space().append(MobEffects.ABSORPTION.value().getDisplayName()).append(" IV").withStyle(ChatFormatting.BLUE).append(" - 00:45"));
        textConsumer.accept(CommonComponents.space().append(MobEffects.STRENGTH.value().getDisplayName()).append(" III").withStyle(ChatFormatting.BLUE).append(" - 00:04"));
    }
}

