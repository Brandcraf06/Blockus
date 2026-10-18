package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FrozenMagmaBlock extends Block {
    public static final MapCodec<FrozenMagmaBlock> CODEC = simpleCodec(FrozenMagmaBlock::new);

    public MapCodec<FrozenMagmaBlock> codec() {
        return CODEC;
    }

    public FrozenMagmaBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            if (livingEntity.canFreeze()) {
                entity.hurt(level.damageSources().freeze(), 1.0F);
            }

            super.stepOn(level, pos, onState, entity);
        }
    }
}
