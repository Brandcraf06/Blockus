package com.brand.blockus.blocks.base;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class LoveBlock extends Block {

    public LoveBlock(Settings settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
        if (random_1.nextInt(5) == 0) {
            for (int int_1 = 0; int_1 < random_1.nextInt(1) + 1; ++int_1) {
                world_1.addParticle(ParticleTypes.HEART, (float) blockPos_1.getX() + 0.5F, (float) blockPos_1.getY() + 1.0F, (float) blockPos_1.getZ() + 0.5F, random_1.nextFloat() / 2.0F, 5.0E-5D, random_1.nextFloat() / 2.0F);
            }
        }
    }
}
