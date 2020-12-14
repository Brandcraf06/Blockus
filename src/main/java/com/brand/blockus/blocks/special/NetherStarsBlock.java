package com.brand.blockus.blocks.special;


import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetherStarsBlock extends Block {

    public NetherStarsBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world_1, BlockPos blockPos_1, Entity entity_1) {
        if (entity_1.getType() == EntityType.PLAYER) {
            ((LivingEntity) entity_1).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, 4, true, false, false));
            ((LivingEntity) entity_1).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 3, true, false, true));
            ((LivingEntity) entity_1).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4, true, false, true));
        }
    }
}
