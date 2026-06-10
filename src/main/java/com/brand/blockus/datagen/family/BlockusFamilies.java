package com.brand.blockus.datagen.family;

import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.CopperBSSWBundle;
import com.brand.blockus.registry.content.bundles.WoodBundle;
import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopperCollection;

import java.util.Map;
import java.util.stream.Stream;

public class BlockusFamilies {
    public static final BlockFamily WHITE_OAK;
    public static final BlockFamily CHARRED;
    public static final BlockFamily RAW_BAMBOO;
    public static final WeatheringCopperCollection<BlockFamily> COPPER_BRICKS;
    public static final WeatheringCopperCollection<BlockFamily> COPPER_TUFF_BRICKS;

    public static final Map<Block, BlockFamily> MAP = Maps.newHashMap();

    static {
        // Woods
        WHITE_OAK = familyBuilder(BlockusBlocks.WHITE_OAK, false);
        CHARRED = familyBuilder(BlockusBlocks.CHARRED, false);
        RAW_BAMBOO = familyBuilder(BlockusBlocks.RAW_BAMBOO, true);

        // Copper
        COPPER_BRICKS = familyBuilder(BlockusBlocks.COPPER_BRICKS, "copper_bricks");
        COPPER_TUFF_BRICKS = familyBuilder(BlockusBlocks.COPPER_TUFF_BRICKS, "copper_tuff_bricks");
    }

    public static WeatheringCopperCollection<BlockFamily> familyBuilder(CopperBSSWBundle block, String name) {
        return WeatheringCopperCollection.createFamily((prefix, state) -> familyBuilder(block.block().blocks().waxed().pick(state)).slab(block.slab().blocks().waxed().pick(state)).stairs(block.stairs().blocks().waxed().pick(state)).wall(block.wall().blocks().waxed().pick(state)).recipeGroupPrefix(prefix + name).dontGenerateModel().generateStonecutterRecipe().getFamily(), (var0, state) -> familyBuilder(block.block().blocks().weathering().pick(state)).slab(block.slab().blocks().weathering().pick(state)).stairs(block.stairs().blocks().weathering().pick(state)).wall(block.wall().blocks().weathering().pick(state)).dontGenerateModel().generateStonecutterRecipe().getFamily());
    }

    public static BlockFamily familyBuilder(WoodBundle wood, boolean customFence) {
        BlockFamily.Builder builder = familyBuilder(wood.planks())
            .button(wood.button())
            .pressurePlate(wood.pressurePlate())
            .sign(wood.standingSign(), wood.wallSign())
            .slab(wood.slab())
            .stairs(wood.stairs())
            .door(wood.door())
            .trapdoor(wood.trapdoor())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks");

        if (customFence) {
            builder.customFence(wood.fence()).customFenceGate(wood.fenceGate());
        } else {
            builder.fence(wood.fence()).fenceGate(wood.fenceGate());
        }

        return builder.getFamily();
    }

    public static BlockFamily.Builder familyBuilder(Block base) {
        BlockFamily.Builder builder = new BlockFamily.Builder(base);
        BlockFamily blockFamily = MAP.put(base, builder.getFamily());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(base));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}

