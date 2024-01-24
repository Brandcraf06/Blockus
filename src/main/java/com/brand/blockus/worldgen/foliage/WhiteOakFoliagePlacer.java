package com.brand.blockus.worldgen.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class WhiteOakFoliagePlacer extends FoliagePlacer {
    public static final Codec<WhiteOakFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return fillFoliagePlacerFields(instance).and(instance.group(IntProvider.createValidatingCodec(4, 16).fieldOf("height").forGetter((foliagePlacer) -> {
            return foliagePlacer.height;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("wide_bottom_layer_hole_chance").forGetter((foliagePlacer) -> {
            return foliagePlacer.wideBottomLayerHoleChance;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("corner_hole_chance").forGetter((foliagePlacer) -> {
            return foliagePlacer.cornerHoleChance;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_chance").forGetter((foliagePlacer) -> {
            return foliagePlacer.hangingLeavesChance;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_extension_chance").forGetter((foliagePlacer) -> {
            return foliagePlacer.hangingLeavesExtensionChance;
        }))).apply(instance, WhiteOakFoliagePlacer::new);
    });
    public final IntProvider height;
    public final float wideBottomLayerHoleChance;
    public final float cornerHoleChance;
    public final float hangingLeavesChance;
    public final float hangingLeavesExtensionChance;

    public WhiteOakFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height, float wideBottomLayerHoleChance, float cornerHoleChance, float hangingLeavesChance, float hangingLeavesExtensionChance) {
        super(radius, offset);
        this.height = height;
        this.wideBottomLayerHoleChance = wideBottomLayerHoleChance;
        this.cornerHoleChance = cornerHoleChance;
        this.hangingLeavesChance = hangingLeavesChance;
        this.hangingLeavesExtensionChance = hangingLeavesExtensionChance;
    }

    protected FoliagePlacerType<?> getType() {
        return BlockusFoliagePlacerType.WHITE_OAK_FOLIAGE_PLACER;
    }

    protected void generate(TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, FoliagePlacer.TreeNode treeNode, int foliageHeight, int radius, int offset) {
        boolean bl = treeNode.isGiantTrunk();
        BlockPos blockPos = treeNode.getCenter().up(offset - 3);
        int i = radius + treeNode.getFoliageRadius() - 1;
        this.generateSquare(world, placer, random, config, blockPos, i - 1, foliageHeight - 3, bl);
        this.generateSquare(world, placer, random, config, blockPos, i - 1, foliageHeight - 4, bl);

        for (int j = foliageHeight - 5; j >= 0; --j) {
            this.generateSquare(world, placer, random, config, blockPos, i, j, bl);
        }

        this.generateSquareWithHangingLeaves(world, placer, random, config, blockPos, i, -1, bl, this.hangingLeavesChance, this.hangingLeavesExtensionChance);
    }

    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height.get(random);
    }

    public boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (y == -1 && (dx == radius || dz == radius) && random.nextFloat() < this.wideBottomLayerHoleChance) {
            return true;
        } else if (y == 3) {
            return (dx > 1 || dz > 1) && dx != 0 && dz != 0;
        } else {
            boolean bl = dx == radius && dz == radius;
            boolean bl2 = radius > 2;
            if (bl2) {
                return bl || dx + dz > radius * 2 - 2 && random.nextFloat() < this.cornerHoleChance;
            } else {
                return bl && random.nextFloat() < this.cornerHoleChance;
            }
        }
    }
}
