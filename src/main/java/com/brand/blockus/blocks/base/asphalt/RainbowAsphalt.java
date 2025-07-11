package com.brand.blockus.blocks.base.asphalt;

import com.brand.blockus.blocks.base.FullFacingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RainbowAsphalt extends FullFacingBlock {

    public RainbowAsphalt(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        AsphaltBlock.applySprintEffect(entity);
    }
}
