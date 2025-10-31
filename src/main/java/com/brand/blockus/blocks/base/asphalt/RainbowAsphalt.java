package com.brand.blockus.blocks.base.asphalt;

import com.brand.blockus.blocks.base.FullFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class RainbowAsphalt extends FullFacingBlock {

    public RainbowAsphalt(Properties settings) {
        super(settings);
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        AsphaltBlock.applySprintEffect(world, entity);
    }
}
