package com.brand.blockus.blocks.base;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class LoveBlock extends Block {

    public LoveBlock(Properties settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState blockState_1, Level world_1, BlockPos blockPos_1, Random random_1) {
        if (random_1.nextInt(5) == 0) {
            for (int int_1 = 0; int_1 < random_1.nextInt(1) + 1; ++int_1) {
                world_1.addParticle(ParticleTypes.HEART, (float) blockPos_1.getX() + 0.5F, (float) blockPos_1.getY() + 1.0F, (float) blockPos_1.getZ() + 0.5F, random_1.nextFloat() / 2.0F, 5.0E-5D, random_1.nextFloat() / 2.0F);
            }
        }
    }
}
