package com.brand.blockus.blocks.base;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class LoveBlock extends Block {

    public LoveBlock(Properties settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) {
            for (int int_1 = 0; int_1 < random.nextInt(1) + 1; ++int_1) {
                world.addParticle(ParticleTypes.HEART, (float) pos.getX() + 0.5F, (float) pos.getY() + 1.0F, (float) pos.getZ() + 0.5F, random.nextFloat() / 2.0F, 5.0E-5D, random.nextFloat() / 2.0F);
            }
        }
    }
}
