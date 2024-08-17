package com.brand.blockus.blocks.base;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.BlockView;

import java.util.List;

public class ColoredTilesBlock extends HorizontalAxisBlock {

    public final Block tile1;
    public final Block tile2;
    public String translationKey;

    public ColoredTilesBlock(Block tile1, Block tile2, Settings settings) {
        super(settings);
        this.tile1 = tile1;
        this.tile2 = tile2;
    }

    public static String getColor(Block block) {
        return Registries.BLOCK.getId(block).getPath().replace("_concrete", "");
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
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable(Util.createTranslationKey("color", Identifier.tryParse(getColor(tile1)))).formatted(Formatting.GRAY).append(" & ").append(Text.translatable(Util.createTranslationKey("color", Identifier.tryParse(getColor(tile2)))).formatted(Formatting.GRAY)));
    }
}

