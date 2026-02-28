package com.brand.blockus.blocks.base;

import com.brand.blockus.utils.screen.LegacyStonecutterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LegacyStonecutterBlock extends Block {
    private static final Component TITLE = Component.translatable("container.stonecutter");

    public LegacyStonecutterBlock(Properties settings) {
        super(settings);
    }

    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world.isClientSide()) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(world, pos));
            player.awardStat(Stats.INTERACT_WITH_STONECUTTER);
            return InteractionResult.CONSUME;
        }
    }

    public MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
        return new SimpleMenuProvider((syncId, playerInventory, player) -> {
            return new LegacyStonecutterMenu(syncId, playerInventory, ContainerLevelAccess.create(world, pos));
        }, TITLE);
    }
}
