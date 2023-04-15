package com.brand.blockus.data.family;

import com.brand.blockus.content.BlockusBlocks;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class BlockusBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();
    private static final String WOODEN_GROUP = "wooden";
    private static final String WOODEN_UNLOCK_CRITERION_NAME = "has_planks";
    public static final BlockFamily WHITE_OAK;
    public static final BlockFamily CHARRED;
    public static final BlockFamily RAW_BAMBOO;
    public static final BlockFamily POLISHED_AMETHYST;
    public static final BlockFamily AMETHYST_BRICK;
    public static final BlockFamily NETHERITE_BLOCK;

    static {
        // Woods
        WHITE_OAK = register(BlockusBlocks.WHITE_OAK.planks).button(BlockusBlocks.WHITE_OAK.button).fence(BlockusBlocks.WHITE_OAK.fence).fenceGate(BlockusBlocks.WHITE_OAK.fence_gate).pressurePlate(BlockusBlocks.WHITE_OAK.pressure_plate).sign(BlockusBlocks.WHITE_OAK.standing_sign, BlockusBlocks.WHITE_OAK.wall_sign).slab(BlockusBlocks.WHITE_OAK.slab).stairs(BlockusBlocks.WHITE_OAK.stairs).door(BlockusBlocks.WHITE_OAK.door).trapdoor(BlockusBlocks.WHITE_OAK.trapdoor).group("wooden").unlockCriterionName("has_planks").build();
        CHARRED = register(BlockusBlocks.CHARRED.planks).button(BlockusBlocks.CHARRED.button).fence(BlockusBlocks.CHARRED.fence).fenceGate(BlockusBlocks.CHARRED.fence_gate).pressurePlate(BlockusBlocks.CHARRED.pressure_plate).sign(BlockusBlocks.CHARRED.standing_sign, BlockusBlocks.CHARRED.wall_sign).slab(BlockusBlocks.CHARRED.slab).stairs(BlockusBlocks.CHARRED.stairs).door(BlockusBlocks.CHARRED.door).trapdoor(BlockusBlocks.CHARRED.trapdoor).group("wooden").unlockCriterionName("has_planks").build();
        RAW_BAMBOO = register(BlockusBlocks.RAW_BAMBOO.planks).button(BlockusBlocks.RAW_BAMBOO.button).fence(BlockusBlocks.RAW_BAMBOO.fence).fenceGate(BlockusBlocks.RAW_BAMBOO.fence_gate).pressurePlate(BlockusBlocks.RAW_BAMBOO.pressure_plate).sign(BlockusBlocks.RAW_BAMBOO.standing_sign, BlockusBlocks.RAW_BAMBOO.wall_sign).slab(BlockusBlocks.RAW_BAMBOO.slab).stairs(BlockusBlocks.RAW_BAMBOO.stairs).door(BlockusBlocks.RAW_BAMBOO.door).trapdoor(BlockusBlocks.RAW_BAMBOO.trapdoor).group("wooden").unlockCriterionName("has_planks").build();

        // Amethyst
        POLISHED_AMETHYST = register(BlockusBlocks.POLISHED_AMETHYST).stairs(BlockusBlocks.POLISHED_AMETHYST_STAIRS).slab(BlockusBlocks.POLISHED_AMETHYST_SLAB).build();
        AMETHYST_BRICK = register(BlockusBlocks.AMETHYST_BRICKS).wall(BlockusBlocks.AMETHYST_BRICK_WALL).stairs(BlockusBlocks.AMETHYST_BRICK_STAIRS).slab(BlockusBlocks.AMETHYST_BRICK_SLAB).build();

        // Other
        NETHERITE_BLOCK = register(Blocks.NETHERITE_BLOCK).stairs(BlockusBlocks.NETHERITE_STAIRS).slab(BlockusBlocks.NETHERITE_SLAB).build();
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

