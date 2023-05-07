package com.brand.blockus.blocks.base.asphalt;


import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class AsphaltStairs extends StairsBlock {

    public AsphaltStairs(BlockState baseBlockState, Settings settings) {
        super(baseBlockState, settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        AsphaltBlock.applySprintEffect(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext context) {
        AsphaltBlock.addTooltipInfo(stack, world, tooltip, context);
    }
}
