package com.brand.blockus.blocks.base.asphalt;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AsphaltStairs extends StairBlock {

    public AsphaltStairs(BlockState baseBlockState, Properties properties) {
        super(baseBlockState, properties);
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        AsphaltBlock.applySprintEffect(world, entity);
    }
}
