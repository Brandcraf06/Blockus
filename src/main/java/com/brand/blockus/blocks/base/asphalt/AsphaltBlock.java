package com.brand.blockus.blocks.base.asphalt;

import com.brand.blockus.registry.effect.BlockusEffects;
import com.brand.blockus.registry.gamerule.BlockusGamerules;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AsphaltBlock extends Block {

    public AsphaltBlock(Settings settings) {
        super(settings);
    }

    public static void applySprintEffect(World world, Entity entity) {
        if (entity instanceof LivingEntity && world instanceof ServerWorld serverWorld) {
            if (serverWorld.getGameRules().getBoolean(BlockusGamerules.ENABLE_ASPHALT_SPRINT)) {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(BlockusEffects.ASPHALT_SPRINT, 5, 0, true, false, true));
            }
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        applySprintEffect(world, entity);
    }
}
