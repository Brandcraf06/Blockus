package com.brand.blockus.compatibility.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import io.github.haykam821.columns.block.ColumnBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashSet;
import java.util.Set;

public final class BlockusColumnBlocks {
    public static final Set<BlockusColumnType> COLUMN_TYPES = new HashSet<>();

    private BlockusColumnBlocks() {
        return;
    }

    private static void registerColumnBlockAndItem(String path, Block base) {
        Identifier id = Blockus.id(path);

        Block block = new ColumnBlock(FabricBlockSettings.copy(base));
        Registry.register(Registry.BLOCK, id, block);

        Item item = new BlockItem(block, new Item.Settings().group(Blockus.BLOCKUS_DECORATIONS));
        Registry.register(Registry.ITEM, id, item);

        COLUMN_TYPES.add(new BlockusColumnType(block, base, id));
    }

    public static void init() {
        registerColumnBlockAndItem("stone_tile_column", BlockusBlocks.STONE_TILES.block);
        registerColumnBlockAndItem("polished_blackstone_tile_column", BlockusBlocks.POLISHED_BLACKSTONE_TILES.block);
        registerColumnBlockAndItem("andesite_brick_column", BlockusBlocks.ANDESITE_BRICKS.block);
        registerColumnBlockAndItem("diorite_brick_column", BlockusBlocks.DIORITE_BRICKS.block);
        registerColumnBlockAndItem("granite_brick_column", BlockusBlocks.GRANITE_BRICKS.block);
        registerColumnBlockAndItem("dripstone_brick_column", BlockusBlocks.DRIPSTONE_BRICKS.block);
        registerColumnBlockAndItem("tuff_brick_column", BlockusBlocks.TUFF_BRICKS.block);
        registerColumnBlockAndItem("mossy_deepslate_brick_column", BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block);
        registerColumnBlockAndItem("amethyst_brick_column", BlockusBlocks.AMETHYST_BRICKS);
        registerColumnBlockAndItem("crimson_warty_blackstone_brick_column", BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS.block);
        registerColumnBlockAndItem("warped_warty_blackstone_brick_column", BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS.block);
        registerColumnBlockAndItem("polished_basalt_brick_column", BlockusBlocks.POLISHED_BASALT_BRICKS.block);
        registerColumnBlockAndItem("limestone_column", BlockusBlocks.LIMESTONE.block);
        registerColumnBlockAndItem("limestone_brick_column", BlockusBlocks.LIMESTONE_BRICKS.block);
        registerColumnBlockAndItem("small_limestone_brick_column", BlockusBlocks.SMALL_LIMESTONE_BRICKS.block);
        registerColumnBlockAndItem("limestone_tile_column", BlockusBlocks.LIMESTONE_TILES.block);
        registerColumnBlockAndItem("marble_column", BlockusBlocks.MARBLE.block);
        registerColumnBlockAndItem("marble_brick_column", BlockusBlocks.MARBLE_BRICKS.block);
        registerColumnBlockAndItem("small_marble_brick_column", BlockusBlocks.SMALL_MARBLE_BRICKS.block);
        registerColumnBlockAndItem("marble_tile_column", BlockusBlocks.MARBLE_TILES.block);
        registerColumnBlockAndItem("bluestone_column", BlockusBlocks.BLUESTONE.block);
        registerColumnBlockAndItem("bluestone_tile_column", BlockusBlocks.BLUESTONE_TILES.block);
        registerColumnBlockAndItem("bluestone_brick_column", BlockusBlocks.BLUESTONE_BRICKS.block);
        registerColumnBlockAndItem("small_bluestone_brick_column", BlockusBlocks.SMALL_BLUESTONE_BRICKS.block);
        registerColumnBlockAndItem("viridite_column", BlockusBlocks.VIRIDITE.block);
        registerColumnBlockAndItem("viridite_tile_column", BlockusBlocks.VIRIDITE_TILES.block);
        registerColumnBlockAndItem("viridite_brick_column", BlockusBlocks.VIRIDITE_BRICKS.block);
        registerColumnBlockAndItem("small_viridite_brick_column", BlockusBlocks.SMALL_VIRIDITE_BRICKS.block);
        registerColumnBlockAndItem("lava_brick_column", BlockusBlocks.LAVA_BRICKS.block);
        registerColumnBlockAndItem("lava_polished_blackstone_brick_column", BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        registerColumnBlockAndItem("water_brick_column", BlockusBlocks.WATER_BRICKS.block);
        registerColumnBlockAndItem("snow_brick_column", BlockusBlocks.SNOW_BRICKS);
        registerColumnBlockAndItem("ice_brick_column", BlockusBlocks.ICE_BRICKS);
        registerColumnBlockAndItem("magma_brick_column", BlockusBlocks.MAGMA_BRICKS.block);
        registerColumnBlockAndItem("small_magma_brick_column", BlockusBlocks.SMALL_MAGMA_BRICKS.block);
        registerColumnBlockAndItem("blaze_brick_column", BlockusBlocks.BLAZE_BRICKS.block);
        registerColumnBlockAndItem("netherrack_brick_column", BlockusBlocks.NETHERRACK_BRICKS.block);
        registerColumnBlockAndItem("charred_nether_brick_column", BlockusBlocks.CHARRED_NETHER_BRICKS.block);
        registerColumnBlockAndItem("teal_nether_brick_column", BlockusBlocks.TEAL_NETHER_BRICKS.block);
        registerColumnBlockAndItem("obsidian_brick_column", BlockusBlocks.OBSIDIAN_BRICKS.block);
        registerColumnBlockAndItem("small_obsidian_brick_column", BlockusBlocks.SMALL_OBSIDIAN_BRICKS.block);
        registerColumnBlockAndItem("quartz_tile_column", BlockusBlocks.QUARTZ_TILES.block);
        registerColumnBlockAndItem("large_brick_column", BlockusBlocks.LARGE_BRICKS.block);
        registerColumnBlockAndItem("soaked_brick_column", BlockusBlocks.SOAKED_BRICKS.block);
        registerColumnBlockAndItem("sandy_brick_column", BlockusBlocks.SANDY_BRICKS.block);
        registerColumnBlockAndItem("charred_brick_column", BlockusBlocks.CHARRED_BRICKS.block);
        registerColumnBlockAndItem("sandstone_brick_column", BlockusBlocks.SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("small_sandstone_brick_column", BlockusBlocks.SMALL_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("red_sandstone_brick_column", BlockusBlocks.RED_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("small_red_sandstone_brick_column", BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("soul_sandstone_column", BlockusBlocks.SOUL_SANDSTONE.block);
        registerColumnBlockAndItem("soul_sandstone_brick_column", BlockusBlocks.SOUL_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("small_soul_sandstone_brick_column", BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("honeycomb_brick_column", BlockusBlocks.HONEYCOMB_BRICKS.block);
        registerColumnBlockAndItem("small_end_stone_brick_column", BlockusBlocks.SMALL_END_STONE_BRICKS.block);
        registerColumnBlockAndItem("purpur_brick_column", BlockusBlocks.PURPUR_BRICKS.block);
        registerColumnBlockAndItem("small_purpur_brick_column", BlockusBlocks.SMALL_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("phantom_purpur_brick_column", BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("small_phantom_purpur_brick_column", BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("rainbow_brick_column", BlockusBlocks.RAINBOW_BRICKS.block);

        registerColumnBlockAndItem("white_stone_brick_column", BlockusBlocks.WHITE_STONE_BRICKS.block);
        registerColumnBlockAndItem("orange_stone_brick_column", BlockusBlocks.ORANGE_STONE_BRICKS.block);
        registerColumnBlockAndItem("magenta_stone_brick_column", BlockusBlocks.MAGENTA_STONE_BRICKS.block);
        registerColumnBlockAndItem("light_blue_stone_brick_column", BlockusBlocks.LIGHT_BLUE_STONE_BRICKS.block);
        registerColumnBlockAndItem("yellow_stone_brick_column", BlockusBlocks.YELLOW_STONE_BRICKS.block);
        registerColumnBlockAndItem("lime_stone_brick_column", BlockusBlocks.LIME_STONE_BRICKS.block);
        registerColumnBlockAndItem("pink_stone_brick_column", BlockusBlocks.PINK_STONE_BRICKS.block);
        registerColumnBlockAndItem("gray_stone_brick_column", BlockusBlocks.GRAY_STONE_BRICKS.block);
        registerColumnBlockAndItem("cyan_stone_brick_column", BlockusBlocks.CYAN_STONE_BRICKS.block);
        registerColumnBlockAndItem("purple_stone_brick_column", BlockusBlocks.PURPLE_STONE_BRICKS.block);
        registerColumnBlockAndItem("blue_stone_brick_column", BlockusBlocks.BLUE_STONE_BRICKS.block);
        registerColumnBlockAndItem("brown_stone_brick_column", BlockusBlocks.BROWN_STONE_BRICKS.block);
        registerColumnBlockAndItem("green_stone_brick_column", BlockusBlocks.GREEN_STONE_BRICKS.block);
        registerColumnBlockAndItem("red_stone_brick_column", BlockusBlocks.RED_STONE_BRICKS.block);
        registerColumnBlockAndItem("black_stone_brick_column", BlockusBlocks.BLACK_STONE_BRICKS.block);

        registerColumnBlockAndItem("white_concrete_brick_column", BlockusBlocks.WHITE_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("orange_concrete_brick_column", BlockusBlocks.ORANGE_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("magenta_concrete_brick_column", BlockusBlocks.MAGENTA_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("light_blue_concrete_brick_column", BlockusBlocks.LIGHT_BLUE_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("yellow_concrete_brick_column", BlockusBlocks.YELLOW_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("lime_concrete_brick_column", BlockusBlocks.LIME_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("pink_concrete_brick_column", BlockusBlocks.PINK_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("gray_concrete_brick_column", BlockusBlocks.GRAY_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("light_gray_concrete_brick_column", BlockusBlocks.LIGHT_GRAY_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("cyan_concrete_brick_column", BlockusBlocks.CYAN_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("purple_concrete_brick_column", BlockusBlocks.PURPLE_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("blue_concrete_brick_column", BlockusBlocks.BLUE_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("brown_concrete_brick_column", BlockusBlocks.BROWN_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("green_concrete_brick_column", BlockusBlocks.GREEN_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("red_concrete_brick_column", BlockusBlocks.RED_CONCRETE_BRICKS.block);
        registerColumnBlockAndItem("black_concrete_brick_column", BlockusBlocks.BLACK_CONCRETE_BRICKS.block);
    }

    public static class BlockusColumnType {
        public final Block block;
        public final Block base;
        public final Identifier id;

        private BlockusColumnType(Block block, Block base, Identifier id) {
            this.block = block;
            this.base = base;
            this.id = id;
        }
    }
}
