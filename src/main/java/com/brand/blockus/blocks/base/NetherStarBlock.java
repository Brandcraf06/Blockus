package com.brand.blockus.blocks.base;


import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class NetherStarBlock extends Block {

    public NetherStarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        if (entity.getType() == EntityType.PLAYER) {
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1, 3, true, false, false));
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 900, 3, true, false, true));
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, 80, 2, true, false, true));
        }
    }
}
