package com.brand.blockus.mixin;

import com.brand.blockus.registry.content.BlockusBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RedStoneWireBlock.class)
public class RedstoneWireBlockMixin {

    @Inject(method = "shouldConnectTo(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;)Z", at = @At("RETURN"), cancellable = true)
    private static void shouldConnectTo(BlockState state, Direction dir, CallbackInfoReturnable<Boolean> cir) {
        if (state.is(BlockusBlocks.REDSTONE_O_LANTERN)) {
            cir.setReturnValue(dir == state.getValue(CarvedPumpkinBlock.FACING).getOpposite());
        }
    }
}
