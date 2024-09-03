package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.world.World;

import java.util.List;

public class LegacyBlockItem extends BlockItem {
    private final String version;

    public LegacyBlockItem(Block block, Settings settings, String version) {
        super(block, settings);
        this.version = version;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        this.getBlock().appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable(Util.createTranslationKey("blockitem", Blockus.id("legacy"))).formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(ScreenTexts.EMPTY);
        tooltip.add(Text.literal(version).formatted(Formatting.ITALIC).formatted(Formatting.GRAY));

    }
}
