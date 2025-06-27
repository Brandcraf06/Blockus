package com.brand.blockus.mixin;

import com.brand.blockus.registry.tag.BlockusBlockTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.dimension.NetherPortal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherPortal.class)
public class NetherPortalMixin {

    @Shadow @Mutable
    private static AbstractBlock.ContextPredicate IS_VALID_FRAME_BLOCK;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void validFrameBlock(CallbackInfo ci) {
        AbstractBlock.ContextPredicate original = IS_VALID_FRAME_BLOCK;
        IS_VALID_FRAME_BLOCK = (BlockState state, BlockView world, BlockPos pos) -> original.test(state, world, pos) || state.isIn(BlockusBlockTags.NETHER_PORTAL_FRAME_BLOCKS);
    }
}
