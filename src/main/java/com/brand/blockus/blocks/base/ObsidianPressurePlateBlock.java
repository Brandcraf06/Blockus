package com.brand.blockus.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BasePressurePlateBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class ObsidianPressurePlateBlock extends BasePressurePlateBlock {
    public static final MapCodec<ObsidianPressurePlateBlock> CODEC = simpleCodec(ObsidianPressurePlateBlock::new);
    public static final BooleanProperty POWERED;

    public MapCodec<ObsidianPressurePlateBlock> codec() {
        return CODEC;
    }

    public ObsidianPressurePlateBlock(BlockBehaviour.Properties properties) {
        super(properties, BlockSetType.STONE);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false));
    }

    protected int getSignalForState(BlockState state) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    protected BlockState setSignalForState(BlockState state, int rsOut) {
        return state.setValue(POWERED, rsOut > 0);
    }

    protected int getSignalStrength(Level world, BlockPos pos) {
        return getEntityCount(world, TOUCH_AABB.move(pos), Player.class) > 0 ? 15 : 0;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    static {
        POWERED = BlockStateProperties.POWERED;
    }
}
