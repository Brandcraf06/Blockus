package com.brand.blockus.mixin;

import com.brand.blockus.world.BlockusConfiguredFeatures;
import net.minecraft.Bootstrap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bootstrap.class)
public class BootstrapMixin {

    @Inject(method = "initialize", at = @At(value = "TAIL"), require = 1, allow = 1)
    private static void afterInitialize(CallbackInfo ci) {
        BlockusConfiguredFeatures.registerAndAddConfiguredFeatures();
    }

}