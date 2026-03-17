package com.brand.blockus.mixin;

import com.brand.blockus.registry.tag.BlockusBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.portal.PortalShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BaseFireBlock.class)
public abstract class BaseFireBlockMixin {

    @Inject(method = "isPortal", at = @At("RETURN"), cancellable = true)
    private static void injectIsPortal(Level level, BlockPos pos, Direction forwardDirection, CallbackInfoReturnable<Boolean> cir) {
        if (level.dimension() != Level.OVERWORLD && level.dimension() != Level.NETHER) {
            cir.setReturnValue(false);
        } else {
            BlockPos.MutableBlockPos testPos = pos.mutable();
            boolean hasObsidian = false;

            for (Direction face : Direction.values()) {
                if (level.getBlockState(testPos.set(pos).move(face)).is(BlockusBlockTags.NETHER_PORTAL_FRAME_BLOCKS)) {
                    hasObsidian = true;
                    break;
                }
            }

            if (!hasObsidian) {
                cir.setReturnValue(false);
            } else {
                Direction.Axis preferredAxis = forwardDirection.getAxis().isHorizontal() ? forwardDirection.getCounterClockWise().getAxis() : Direction.Plane.HORIZONTAL.getRandomAxis(level.getRandom());
                cir.setReturnValue(PortalShape.findEmptyPortalShape(level, pos, preferredAxis).isPresent());
            }
        }
    }
}
