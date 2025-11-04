package com.brand.blockus.blocks.base.asphalt;

import com.brand.blockus.registry.effect.BlockusEffects;
import com.brand.blockus.registry.gamerule.BlockusGamerules;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class AsphaltBlock extends Block {

    public AsphaltBlock(Properties settings) {
        super(settings);
    }

    public static void applySprintEffect(Level world, Entity entity) {
        if (entity instanceof LivingEntity && world instanceof ServerLevel serverWorld) {
            if (serverWorld.getGameRules().get(BlockusGamerules.ENABLE_ASPHALT_SPRINT)) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(BlockusEffects.ASPHALT_SPRINT, 5, 0, true, false, true));
            }
        }
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        applySprintEffect(world, entity);
    }
}
