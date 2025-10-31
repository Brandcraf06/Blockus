package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class LegacyBlockItem extends BlockItem {
    private final String version;

    public LegacyBlockItem(Block block, Properties settings, String version) {
        super(block, settings);
        this.version = version;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {
        textConsumer.accept(Component.translatable(Util.makeDescriptionId("blockitem", Blockus.id("legacy"))).withStyle(ChatFormatting.LIGHT_PURPLE));
        textConsumer.accept(CommonComponents.EMPTY);
        textConsumer.accept(Component.literal(version).withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));

    }
}
