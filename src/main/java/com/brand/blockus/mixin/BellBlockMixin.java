package com.brand.blockus.mixin;

import com.brand.blockus.blocks.base.PostBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BellAttachType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BellBlock.class)
public class BellBlockMixin {

    @Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
    private void canPlaceAt(BlockState state, LevelReader world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (state.getValue(BellBlock.ATTACHMENT) == BellAttachType.CEILING && world.getBlockState(pos.above()).getBlock() instanceof PostBlock) {
            cir.setReturnValue(true);
        }
    }
}
