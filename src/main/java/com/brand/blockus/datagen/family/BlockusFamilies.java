package com.brand.blockus.datagen.family;

import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.CopperBundle;
import com.brand.blockus.registry.content.bundles.WoodBundle;
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
    public static final CopperFamily COPPER_BRICKS;
    public static final CopperFamily EXPOSED_COPPER_BRICKS;
    public static final CopperFamily WEATHERED_COPPER_BRICKS;
    public static final CopperFamily OXIDIZED_COPPER_BRICKS;
    public static final CopperFamily COPPER_TUFF_BRICKS;
    public static final CopperFamily EXPOSED_COPPER_TUFF_BRICKS;
    public static final CopperFamily WEATHERED_COPPER_TUFF_BRICKS;
    public static final CopperFamily OXIDIZED_COPPER_TUFF_BRICKS;

    public static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();


    static {
        // Woods
        WHITE_OAK = register(BlockusBlocks.WHITE_OAK, false);
        CHARRED = register(BlockusBlocks.CHARRED, false);
        RAW_BAMBOO = register(BlockusBlocks.RAW_BAMBOO, true);

        // Copper Bricks
        COPPER_BRICKS = register(BlockusBlocks.COPPER_BRICKS);
        EXPOSED_COPPER_BRICKS = register(BlockusBlocks.EXPOSED_COPPER_BRICKS);
        WEATHERED_COPPER_BRICKS = register(BlockusBlocks.WEATHERED_COPPER_BRICKS);
        OXIDIZED_COPPER_BRICKS = register(BlockusBlocks.OXIDIZED_COPPER_BRICKS);

        // Copper Tuff Bricks
        COPPER_TUFF_BRICKS = register(BlockusBlocks.COPPER_TUFF_BRICKS);
        EXPOSED_COPPER_TUFF_BRICKS = register(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS);
        WEATHERED_COPPER_TUFF_BRICKS = register(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS);
        OXIDIZED_COPPER_TUFF_BRICKS = register(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS);
    }

    public static CopperFamily register(CopperBundle block) {
        BlockFamily unwaxed = register(block.block()).slab(block.slab()).stairs(block.stairs()).wall(block.wall()).noGenerateModels().build();
        BlockFamily waxed = register(block.blockWaxed()).slab(block.slabWaxed()).stairs(block.stairsWaxed()).wall(block.wallWaxed()).group("waxed_" + Registries.BLOCK.getId(block.block()).getPath()).noGenerateModels().build();
        return new CopperFamily(unwaxed, waxed);
    }

    public static BlockFamily register(WoodBundle wood, boolean customFence) {
        BlockFamily.Builder builder = register(wood.planks())
            .button(wood.button())
            .pressurePlate(wood.pressurePlate())
            .sign(wood.standingSign(), wood.wallSign())
            .slab(wood.slab())
            .stairs(wood.stairs())
            .door(wood.door())
            .trapdoor(wood.trapdoor())
            .group("wooden")
            .unlockCriterionName("has_planks");

        if (customFence) {
            builder.customFence(wood.fence()).customFenceGate(wood.fenceGate());
        } else {
            builder.fence(wood.fence()).fenceGate(wood.fenceGate());
        }

        return builder.build();
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

    public static class CopperFamily {
        public final BlockFamily unwaxed;
        public final BlockFamily waxed;

        public CopperFamily(BlockFamily unwaxed, BlockFamily waxed) {
            this.unwaxed = unwaxed;
            this.waxed = waxed;
        }
    }
}

