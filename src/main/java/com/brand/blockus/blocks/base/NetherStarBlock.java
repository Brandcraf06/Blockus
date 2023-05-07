package com.brand.blockus.blocks.base;


import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class NetherStarBlock extends Block {

    public NetherStarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity.getType() == EntityType.PLAYER) {
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, 3, true, false, false));
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 900, 3, true, false, true));
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80, 2, true, false, true));
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(ScreenTexts.EMPTY);
        tooltip.add(Blockus.STEPPED_ON_TEXT);
        tooltip.add(ScreenTexts.space().append(StatusEffects.REGENERATION.getName()).append(" IV").formatted(Formatting.BLUE));
        tooltip.add(ScreenTexts.space().append(StatusEffects.ABSORPTION.getName()).append(" IV").formatted(Formatting.BLUE).append(" - 00:45"));
        tooltip.add(ScreenTexts.space().append(StatusEffects.STRENGTH.getName()).append(" III").formatted(Formatting.BLUE).append(" - 00:04"));
    }
}
