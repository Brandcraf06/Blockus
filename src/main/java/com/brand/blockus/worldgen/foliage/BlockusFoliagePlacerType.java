package com.brand.blockus.worldgen.foliage;

import com.brand.blockus.Blockus;
import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class BlockusFoliagePlacerType<P extends FoliagePlacer> {
    public static final FoliagePlacerType<WhiteOakFoliagePlacer> WHITE_OAK_FOLIAGE_PLACER;
    public final MapCodec<P> codec;

    public static <P extends FoliagePlacer> FoliagePlacerType register(String id, MapCodec<P> codec) {
        return Registry.register(Registries.FOLIAGE_PLACER_TYPE, Blockus.id(id), new FoliagePlacerType(codec));
    }

    public BlockusFoliagePlacerType(MapCodec<P> codec) {
        this.codec = codec;
    }

    public MapCodec<P> getCodec() {
        return this.codec;
    }

    static {
        WHITE_OAK_FOLIAGE_PLACER = register("white_oak_foliage_placer", WhiteOakFoliagePlacer.CODEC);
    }
}
