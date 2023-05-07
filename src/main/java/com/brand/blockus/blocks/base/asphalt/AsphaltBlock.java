package com.brand.blockus.blocks.base.asphalt;

import com.brand.blockus.Blockus;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class AsphaltBlock extends Block {

    public AsphaltBlock(Settings settings) {
        super(settings);
    }

    public static void addTooltipInfo(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(ScreenTexts.EMPTY);
        tooltip.add(Blockus.STEPPED_ON_TEXT);
        tooltip.add(ScreenTexts.space().append(Blockus.ASPHALT_SPRINT.getName()).formatted(Formatting.BLUE));
    }

    public static void applySprintEffect(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(Blockus.ASPHALT_SPRINT, 5, 0, true, false, true));
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        applySprintEffect(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext context) {
        addTooltipInfo(stack, world, tooltip, context);
    }
}
