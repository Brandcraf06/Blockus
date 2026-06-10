package com.brand.blockus.worldgen.foliage;

import com.brand.blockus.Blockus;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public record BlockusFoliagePlacerType<P extends FoliagePlacer>(MapCodec<P> codec) {
    public static final FoliagePlacerType<WhiteOakFoliagePlacer> WHITE_OAK_FOLIAGE_PLACER;

    public static <P extends FoliagePlacer> FoliagePlacerType register(String name, MapCodec<P> codec) {
        return Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, Blockus.id(name), new FoliagePlacerType(codec));
    }

    static {
        WHITE_OAK_FOLIAGE_PLACER = register("white_oak_foliage_placer", WhiteOakFoliagePlacer.CODEC);
    }
}
