package com.brand.blockus.blocks.blockitems;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class AsphaltBlockItem extends BlockItem {

    public AsphaltBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        this.getBlock().appendTooltip(stack, world, tooltip, context);
        tooltip.add(ScreenTexts.EMPTY);
        tooltip.add(Blockus.STEPPED_ON_TEXT);
        tooltip.add(ScreenTexts.space().append(Blockus.ASPHALT_SPRINT.getName()).formatted(Formatting.BLUE));
    }
}
