package com.brand.blockus.blocks.special.asphalt;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AsphaltBlock extends Block {

    public AsphaltBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world_1, BlockPos blockPos_1, Entity target) {
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5, 2, true, false, false));
        }
    }
}
