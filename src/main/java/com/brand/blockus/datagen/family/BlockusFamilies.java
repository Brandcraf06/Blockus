package com.brand.blockus.datagen.family;

import com.brand.blockus.registry.content.BlockusBlocks;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class BlockusFamilies {
    public static final BlockFamily WHITE_OAK;
    public static final BlockFamily CHARRED;
    public static final BlockFamily RAW_BAMBOO;
    public static final BlockFamily COPPER_BRICKS;
    public static final BlockFamily WAXED_COPPER_BRICKS;
    public static final BlockFamily EXPOSED_COPPER_BRICKS;
    public static final BlockFamily WAXED_EXPOSED_COPPER_BRICKS;
    public static final BlockFamily WEATHERED_COPPER_BRICKS;
    public static final BlockFamily WAXED_WEATHERED_COPPER_BRICKS;
    public static final BlockFamily OXIDIZED_COPPER_BRICKS;
    public static final BlockFamily WAXED_OXIDIZED_COPPER_BRICKS;
    public static final BlockFamily COPPERED_TUFF_BRICKS;
    public static final BlockFamily WAXED_COPPERED_TUFF_BRICKS;
    public static final BlockFamily EXPOSED_COPPERED_TUFF_BRICKS;
    public static final BlockFamily WAXED_EXPOSED_COPPERED_TUFF_BRICKS;
    public static final BlockFamily WEATHERED_COPPERED_TUFF_BRICKS;
    public static final BlockFamily WAXED_WEATHERED_COPPERED_TUFF_BRICKS;
    public static final BlockFamily OXIDIZED_COPPERED_TUFF_BRICKS;
    public static final BlockFamily WAXED_OXIDIZED_COPPERED_TUFF_BRICKS;

    public static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();


    static {
        // Woods
        WHITE_OAK = register(BlockusBlocks.WHITE_OAK.planks)
            .button(BlockusBlocks.WHITE_OAK.button)
            .fence(BlockusBlocks.WHITE_OAK.fence)
            .fenceGate(BlockusBlocks.WHITE_OAK.fence_gate)
            .pressurePlate(BlockusBlocks.WHITE_OAK.pressure_plate)
            .sign(BlockusBlocks.WHITE_OAK.standing_sign, BlockusBlocks.WHITE_OAK.wall_sign)
            .slab(BlockusBlocks.WHITE_OAK.slab)
            .stairs(BlockusBlocks.WHITE_OAK.stairs)
            .door(BlockusBlocks.WHITE_OAK.door)
            .trapdoor(BlockusBlocks.WHITE_OAK.trapdoor)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build();

        CHARRED = register(BlockusBlocks.CHARRED.planks)
            .button(BlockusBlocks.CHARRED.button)
            .fence(BlockusBlocks.CHARRED.fence)
            .fenceGate(BlockusBlocks.CHARRED.fence_gate)
            .pressurePlate(BlockusBlocks.CHARRED.pressure_plate)
            .sign(BlockusBlocks.CHARRED.standing_sign, BlockusBlocks.CHARRED.wall_sign)
            .slab(BlockusBlocks.CHARRED.slab)
            .stairs(BlockusBlocks.CHARRED.stairs)
            .door(BlockusBlocks.CHARRED.door)
            .trapdoor(BlockusBlocks.CHARRED.trapdoor)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build();

        RAW_BAMBOO = register(BlockusBlocks.RAW_BAMBOO.planks)
            .button(BlockusBlocks.RAW_BAMBOO.button)
            .customFence(BlockusBlocks.RAW_BAMBOO.fence)
            .customFenceGate(BlockusBlocks.RAW_BAMBOO.fence_gate)
            .pressurePlate(BlockusBlocks.RAW_BAMBOO.pressure_plate)
            .sign(BlockusBlocks.RAW_BAMBOO.standing_sign, BlockusBlocks.RAW_BAMBOO.wall_sign)
            .slab(BlockusBlocks.RAW_BAMBOO.slab)
            .stairs(BlockusBlocks.RAW_BAMBOO.stairs)
            .door(BlockusBlocks.RAW_BAMBOO.door)
            .trapdoor(BlockusBlocks.RAW_BAMBOO.trapdoor)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build();

        // Copper Bricks
        COPPER_BRICKS = register(BlockusBlocks.COPPER_BRICKS.block).slab(BlockusBlocks.COPPER_BRICKS.slab).stairs(BlockusBlocks.COPPER_BRICKS.stairs).wall(BlockusBlocks.COPPER_BRICKS.wall).noGenerateModels().build();
        WAXED_COPPER_BRICKS = register(BlockusBlocks.COPPER_BRICKS.blockWaxed).slab(BlockusBlocks.COPPER_BRICKS.slabWaxed).stairs(BlockusBlocks.COPPER_BRICKS.stairsWaxed).wall(BlockusBlocks.COPPER_BRICKS.wallWaxed).group("waxed_copper_bricks").noGenerateModels().build();
        EXPOSED_COPPER_BRICKS = register(BlockusBlocks.EXPOSED_COPPER_BRICKS.block).slab(BlockusBlocks.EXPOSED_COPPER_BRICKS.slab).stairs(BlockusBlocks.EXPOSED_COPPER_BRICKS.stairs).wall(BlockusBlocks.EXPOSED_COPPER_BRICKS.wall).noGenerateModels().build();
        WAXED_EXPOSED_COPPER_BRICKS = register(BlockusBlocks.EXPOSED_COPPER_BRICKS.blockWaxed).slab(BlockusBlocks.EXPOSED_COPPER_BRICKS.slabWaxed).stairs(BlockusBlocks.EXPOSED_COPPER_BRICKS.stairsWaxed).wall(BlockusBlocks.EXPOSED_COPPER_BRICKS.wallWaxed).group("waxed_exposed_copper_bricks").noGenerateModels().build();
        WEATHERED_COPPER_BRICKS = register(BlockusBlocks.WEATHERED_COPPER_BRICKS.block).slab(BlockusBlocks.WEATHERED_COPPER_BRICKS.slab).stairs(BlockusBlocks.WEATHERED_COPPER_BRICKS.stairs).wall(BlockusBlocks.WEATHERED_COPPER_BRICKS.wall).noGenerateModels().build();
        WAXED_WEATHERED_COPPER_BRICKS = register(BlockusBlocks.WEATHERED_COPPER_BRICKS.blockWaxed).slab(BlockusBlocks.WEATHERED_COPPER_BRICKS.slabWaxed).stairs(BlockusBlocks.WEATHERED_COPPER_BRICKS.stairsWaxed).wall(BlockusBlocks.WEATHERED_COPPER_BRICKS.wallWaxed).group("waxed_weathered_copper_bricks").noGenerateModels().build();
        OXIDIZED_COPPER_BRICKS = register(BlockusBlocks.OXIDIZED_COPPER_BRICKS.block).slab(BlockusBlocks.OXIDIZED_COPPER_BRICKS.slab).stairs(BlockusBlocks.OXIDIZED_COPPER_BRICKS.stairs).wall(BlockusBlocks.OXIDIZED_COPPER_BRICKS.wall).noGenerateModels().build();
        WAXED_OXIDIZED_COPPER_BRICKS = register(BlockusBlocks.OXIDIZED_COPPER_BRICKS.blockWaxed).slab(BlockusBlocks.OXIDIZED_COPPER_BRICKS.slabWaxed).stairs(BlockusBlocks.OXIDIZED_COPPER_BRICKS.stairsWaxed).wall(BlockusBlocks.OXIDIZED_COPPER_BRICKS.wallWaxed).group("waxed_oxidized_copper_bricks").noGenerateModels().build();

        // Coppered Tuff Bricks
        COPPERED_TUFF_BRICKS = register(BlockusBlocks.COPPER_TUFF_BRICKS.block).slab(BlockusBlocks.COPPER_TUFF_BRICKS.slab).stairs(BlockusBlocks.COPPER_TUFF_BRICKS.stairs).wall(BlockusBlocks.COPPER_TUFF_BRICKS.wall).noGenerateModels().build();
        WAXED_COPPERED_TUFF_BRICKS = register(BlockusBlocks.COPPER_TUFF_BRICKS.blockWaxed).slab(BlockusBlocks.COPPER_TUFF_BRICKS.slabWaxed).stairs(BlockusBlocks.COPPER_TUFF_BRICKS.stairsWaxed).wall(BlockusBlocks.COPPER_TUFF_BRICKS.wallWaxed).group("waxed_coppered_tuff_bricks").noGenerateModels().build();
        EXPOSED_COPPERED_TUFF_BRICKS = register(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.block).slab(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.slab).stairs(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.stairs).wall(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.wall).noGenerateModels().build();
        WAXED_EXPOSED_COPPERED_TUFF_BRICKS = register(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.blockWaxed).slab(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.slabWaxed).stairs(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.stairsWaxed).wall(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.wallWaxed).group("waxed_exposed_coppered_tuff_bricks").noGenerateModels().build();
        WEATHERED_COPPERED_TUFF_BRICKS = register(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.block).slab(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.slab).stairs(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.stairs).wall(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.wall).noGenerateModels().build();
        WAXED_WEATHERED_COPPERED_TUFF_BRICKS = register(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.blockWaxed).slab(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.slabWaxed).stairs(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.stairsWaxed).wall(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.wallWaxed).group("waxed_weathered_coppered_tuff_bricks").noGenerateModels().build();
        OXIDIZED_COPPERED_TUFF_BRICKS = register(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.block).slab(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.slab).stairs(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.stairs).wall(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.wall).noGenerateModels().build();
        WAXED_OXIDIZED_COPPERED_TUFF_BRICKS = register(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.blockWaxed).slab(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.slabWaxed).stairs(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.stairsWaxed).wall(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.wallWaxed).group("waxed_oxidized_coppered_tuff_bricks").noGenerateModels().build();
    }

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }
}

