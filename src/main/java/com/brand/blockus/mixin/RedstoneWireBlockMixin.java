package com.brand.blockus.mixin;

import com.brand.blockus.content.BlockusBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RedstoneWireBlock.class)
public class RedstoneWireBlockMixin {

    @Inject(method = "connectsTo(Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/Direction;)Z", at = @At("RETURN"), cancellable = true)
    private static void ConnectsTo(BlockState state, Direction dir, CallbackInfoReturnable<Boolean> ci) {
        if (state.isOf(BlockusBlocks.REDSTONE_O_LANTERN)) {
            ci.setReturnValue(dir == state.get(CarvedPumpkinBlock.FACING).getOpposite());
        }
    }
}
