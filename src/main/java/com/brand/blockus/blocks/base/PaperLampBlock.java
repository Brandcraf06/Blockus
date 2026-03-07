package com.brand.blockus.blocks.base;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PaperLampBlock extends Block {
    public static final VoxelShape LAMP = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);


    public PaperLampBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return LAMP;
    }

}
