package com.brand.blockus.mixin;

import com.brand.blockus.blocks.base.PostBlock;
import com.brand.blockus.registry.tag.BlockusBlockTags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BellBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConduitBlock;
import net.minecraft.block.enums.Attachment;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.dimension.NetherPortal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NetherPortal.class)
public class NetherPortalMixin {

    private static boolean validFrameBlock(AbstractBlock.ContextPredicate predicate, BlockState state, BlockView world, BlockPos pos, Operation<Boolean> original) {
        return original.call(predicate, state, world, pos) || state.isIn(BlockusBlockTags.NETHER_PORTAL_FRAME_BLOCKS);
    }

    @WrapOperation(method = "getWidth", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$ContextPredicate;test(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z"))
    private static boolean getWidth(AbstractBlock.ContextPredicate predicate, BlockState state, BlockView world, BlockPos pos, Operation<Boolean> original) {
        return validFrameBlock(predicate, state, world, pos, original);
    }

    @WrapOperation(method = "getPotentialHeight", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$ContextPredicate;test(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z"))
    private static boolean getPotentialHeight(AbstractBlock.ContextPredicate predicate, BlockState state, BlockView world, BlockPos pos, Operation<Boolean> original) {
        return validFrameBlock(predicate, state, world, pos, original);
    }

    @WrapOperation(method = "isHorizontalFrameValid", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$ContextPredicate;test(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z"))
    private static boolean isHorizontalFrameValid(AbstractBlock.ContextPredicate predicate, BlockState state, BlockView world, BlockPos pos, Operation<Boolean> original) {
        return validFrameBlock(predicate, state, world, pos, original);
    }
}
