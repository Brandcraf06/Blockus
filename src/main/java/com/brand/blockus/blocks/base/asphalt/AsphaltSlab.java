package com.brand.blockus.blocks.base.asphalt;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AsphaltSlab extends SlabBlock {

    public AsphaltSlab(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        AsphaltBlock.applySprintEffect(world, entity);
    }
}
