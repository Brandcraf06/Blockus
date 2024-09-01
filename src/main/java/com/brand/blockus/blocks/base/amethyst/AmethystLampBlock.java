package com.brand.blockus.blocks.base.amethyst;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AmethystLampBlock extends Block {
    public static final IntProperty POWER = Properties.POWER;

    public AmethystLampBlock(Settings settings) {
        super(settings.luminance(state -> state.get(POWER)));
        this.setDefaultState(this.stateManager.getDefaultState().with(POWER, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(POWER, Math.min(15, ctx.getWorld().getReceivedRedstonePower(ctx.getBlockPos())));
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (!world.isClient) {
            int power = Math.min(15, world.getReceivedRedstonePower(pos));
            if (power != state.get(POWER)) {
                world.setBlockState(pos, state.with(POWER, power), Block.NOTIFY_ALL);
            }
        }
    }
}
