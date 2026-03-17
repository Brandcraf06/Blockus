package com.brand.blockus.mixin;

import com.brand.blockus.blocks.base.PostBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CeilingHangingSignBlock.class)
public class CeilingHangingSignBlockMixin {

    @Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
    private void canSurvive(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (state.getValue(CeilingHangingSignBlock.ATTACHED) && level.getBlockState(pos.above()).getBlock() instanceof PostBlock) {
            cir.setReturnValue(true);
        }
    }
}
