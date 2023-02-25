package com.brand.blockus.blocks.base.asphalt;

import com.brand.blockus.Blockus;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AsphaltSlab extends SlabBlock {

    public AsphaltSlab(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(Blockus.ASPHALT_SPRINT, 5, 0, true, false, true));
        }
    }
}
