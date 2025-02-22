package com.brand.blockus.blocks.base;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class LoveBlock extends Block {

    public LoveBlock(Settings settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            for (int int_1 = 0; int_1 < random.nextInt(1) + 1; ++int_1) {
                world.addParticleClient(ParticleTypes.HEART, (float) pos.getX() + 0.5F, (float) pos.getY() + 1.0F, (float) pos.getZ() + 0.5F, random.nextFloat() / 2.0F, 5.0E-5D, random.nextFloat() / 2.0F);
            }
        }
    }
}
