package com.brand.blockus.blocks.base.asphalt;

import net.minecraft.block.SlabBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AsphaltSlab extends SlabBlock {

    public AsphaltSlab(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5, 2, true, false, false));
        }
    }
}
