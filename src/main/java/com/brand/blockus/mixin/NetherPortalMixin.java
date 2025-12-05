package com.brand.blockus.mixin;

import com.brand.blockus.registry.tag.BlockusBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.PortalShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PortalShape.class)
public class NetherPortalMixin {

    @Shadow
    @Mutable
    private static BlockBehaviour.StatePredicate FRAME;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void validFrameBlock(CallbackInfo ci) {
        BlockBehaviour.StatePredicate original = FRAME;
        FRAME = (BlockState state, BlockGetter world, BlockPos pos) -> original.test(state, world, pos) || state.is(BlockusBlockTags.NETHER_PORTAL_FRAME_BLOCKS);
    }
}
