package com.brand.blockus.blocks.base.asphalt;

import com.brand.blockus.blocks.base.FullFacingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class RainbowAsphalt extends FullFacingBlock {

    public RainbowAsphalt(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        AsphaltBlock.applySprintEffect(entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext context) {
        AsphaltBlock.addTooltipInfo(tooltip);
    }
}
