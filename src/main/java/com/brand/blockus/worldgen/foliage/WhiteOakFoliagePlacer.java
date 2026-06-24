package com.brand.blockus.worldgen.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class WhiteOakFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<WhiteOakFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((i) -> foliagePlacerParts(i).and(i.group(IntProviders.codec(4, 16).fieldOf("height").forGetter((p) -> p.height), Codec.floatRange(0.0F, 1.0F).fieldOf("wide_bottom_layer_hole_chance").forGetter((p) -> p.wideBottomLayerHoleChance), Codec.floatRange(0.0F, 1.0F).fieldOf("corner_hole_chance").forGetter((p) -> p.cornerHoleChance), Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_chance").forGetter((p) -> p.hangingLeavesChance), Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_extension_chance").forGetter((p) -> p.hangingLeavesExtensionChance))).apply(i, WhiteOakFoliagePlacer::new));
    private final IntProvider height;
    private final float wideBottomLayerHoleChance;
    private final float cornerHoleChance;
    private final float hangingLeavesChance;
    private final float hangingLeavesExtensionChance;

    public WhiteOakFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height, float wideBottomLayerHoleChance, float cornerHoleChance, float hangingLeavesChance, float hangingLeavesExtensionChance) {
        super(radius, offset);
        this.height = height;
        this.wideBottomLayerHoleChance = wideBottomLayerHoleChance;
        this.cornerHoleChance = cornerHoleChance;
        this.hangingLeavesChance = hangingLeavesChance;
        this.hangingLeavesExtensionChance = hangingLeavesExtensionChance;
    }

    protected FoliagePlacerType<?> type() {
        return BlockusFoliagePlacerType.WHITE_OAK_FOLIAGE_PLACER;
    }

    protected void createFoliage(WorldGenLevel level, FoliagePlacer.FoliageSetter foliageSetter, RandomSource random, TreeFeature config, int treeHeight, FoliagePlacer.FoliageAttachment foliageAttachment, int foliageHeight, int leafRadius, int offset) {
        boolean doubleTrunk = foliageAttachment.doubleTrunk();
        BlockPos foliagePos = foliageAttachment.pos().above(offset - 3);
        int currentRadius = leafRadius + foliageAttachment.radiusOffset() - 1;
        this.placeLeavesRow(level, foliageSetter, random, config, foliagePos, currentRadius - 1, foliageHeight - 3, doubleTrunk);
        this.placeLeavesRow(level, foliageSetter, random, config, foliagePos, currentRadius - 1, foliageHeight - 4, doubleTrunk);

        for (int y = foliageHeight - 5; y >= 0; --y) {
            this.placeLeavesRow(level, foliageSetter, random, config, foliagePos, currentRadius, y, doubleTrunk);
        }

        this.placeLeavesRowWithHangingLeavesBelow(level, foliageSetter, random, config, foliagePos, currentRadius, -1, doubleTrunk, this.hangingLeavesChance, this.hangingLeavesExtensionChance);
    }

    public int foliageHeight(RandomSource random, int treeHeight, TreeFeature config) {
        return this.height.sample(random);
    }

    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int currentRadius, boolean doubleTrunk) {
        if (y == -1 && (dx == currentRadius || dz == currentRadius) && random.nextFloat() < this.wideBottomLayerHoleChance) {
            return true;
        } else if (y == 3) {
            return (dx > 1 || dz > 1) && dx != 0 && dz != 0;
        } else {
            boolean corner = dx == currentRadius && dz == currentRadius;
            boolean wideLayer = currentRadius > 2;
            if (wideLayer) {
                return corner || dx + dz > currentRadius * 2 - 2 && random.nextFloat() < this.cornerHoleChance;
            } else {
                return corner && random.nextFloat() < this.cornerHoleChance;
            }
        }
    }
}
