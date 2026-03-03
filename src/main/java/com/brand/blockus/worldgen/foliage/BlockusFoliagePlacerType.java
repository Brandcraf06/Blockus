package com.brand.blockus.worldgen.foliage;

import com.brand.blockus.Blockus;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class BlockusFoliagePlacerType<P extends FoliagePlacer> {
    public static final FoliagePlacerType<WhiteOakFoliagePlacer> WHITE_OAK_FOLIAGE_PLACER;
    public final MapCodec<P> codec;

    public static <P extends FoliagePlacer> FoliagePlacerType register(String name, MapCodec<P> codec) {
        return Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, Blockus.id(name), new FoliagePlacerType(codec));
    }

    public BlockusFoliagePlacerType(MapCodec<P> codec) {
        this.codec = codec;
    }

    public MapCodec<P> codec() {
        return this.codec;
    }

    static {
        WHITE_OAK_FOLIAGE_PLACER = register("white_oak_foliage_placer", WhiteOakFoliagePlacer.CODEC);
    }
}
