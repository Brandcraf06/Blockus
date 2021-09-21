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

public final class BlockusColumnBlocks {
    private BlockusColumnBlocks() {
        return;
    }

    private static void registerColumnBlockAndItem(String path, Block base) {
        Identifier id = new Identifier(Blockus.MOD_ID, path);

        Block block = new ColumnBlock(FabricBlockSettings.copy(base));
        Registry.register(Registry.BLOCK, id, block);

        Item item = new BlockItem(block, new Item.Settings().group(Blockus.BLOCKUS_DECORATIONS));
        Registry.register(Registry.ITEM, id, item);
    }

    public static void init() {
        registerColumnBlockAndItem("andesite_brick_column", BlockusBlocks.ANDESITE_BRICKS);
        registerColumnBlockAndItem("diorite_brick_column", BlockusBlocks.DIORITE_BRICKS);
        registerColumnBlockAndItem("granite_brick_column", BlockusBlocks.GRANITE_BRICKS);
        registerColumnBlockAndItem("dripstone_brick_column", BlockusBlocks.DRIPSTONE_BRICKS);
        registerColumnBlockAndItem("tuff_brick_column", BlockusBlocks.TUFF_BRICKS);
        registerColumnBlockAndItem("mossy_deepslate_brick_column", BlockusBlocks.MOSSY_DEEPSLATE_BRICKS);
        registerColumnBlockAndItem("crimson_warty_blackstone_brick_column", BlockusBlocks.CRIMSON_WARTY_BLACKSTONE_BRICKS);
        registerColumnBlockAndItem("warped_warty_blackstone_brick_column", BlockusBlocks.WARPED_WARTY_BLACKSTONE_BRICKS);
        registerColumnBlockAndItem("polished_basalt_brick_column", BlockusBlocks.POLISHED_BASALT_BRICKS);
        registerColumnBlockAndItem("limestone_column", BlockusBlocks.LIMESTONE);
        registerColumnBlockAndItem("limestone_brick_column", BlockusBlocks.LIMESTONE_BRICKS);
        registerColumnBlockAndItem("small_limestone_brick_column", BlockusBlocks.SMALL_LIMESTONE_BRICKS);
        registerColumnBlockAndItem("limestone_tile_column", BlockusBlocks.LIMESTONE_TILES);
        registerColumnBlockAndItem("marble_column", BlockusBlocks.MARBLE);
        registerColumnBlockAndItem("marble_brick_column", BlockusBlocks.MARBLE_BRICKS);
        registerColumnBlockAndItem("small_marble_brick_column", BlockusBlocks.SMALL_MARBLE_BRICKS);
        registerColumnBlockAndItem("marble_tile_column", BlockusBlocks.MARBLE_TILES);
        registerColumnBlockAndItem("bluestone_column", BlockusBlocks.BLUESTONE);
        registerColumnBlockAndItem("bluestone_tile_column", BlockusBlocks.BLUESTONE_TILES);
        registerColumnBlockAndItem("bluestone_brick_column", BlockusBlocks.BLUESTONE_BRICKS);
        registerColumnBlockAndItem("small_bluestone_brick_column", BlockusBlocks.SMALL_BLUESTONE_BRICKS);
        registerColumnBlockAndItem("lava_brick_column", BlockusBlocks.LAVA_BRICKS);
        registerColumnBlockAndItem("lava_polished_blackstone_brick_column", BlockusBlocks.LAVA_POLISHED_BLACKSTONE_BRICKS);
        registerColumnBlockAndItem("water_brick_column", BlockusBlocks.WATER_BRICKS);
        registerColumnBlockAndItem("snow_brick_column", BlockusBlocks.SNOW_BRICKS);
        registerColumnBlockAndItem("ice_brick_column", BlockusBlocks.ICE_BRICKS);
        registerColumnBlockAndItem("magma_brick_column", BlockusBlocks.MAGMA_BRICKS);
        registerColumnBlockAndItem("small_magma_brick_column", BlockusBlocks.SMALL_MAGMA_BRICKS);
        registerColumnBlockAndItem("blaze_brick_column", BlockusBlocks.BLAZE_BRICKS);
        registerColumnBlockAndItem("netherrack_brick_column", BlockusBlocks.NETHERRACK_BRICKS);
        registerColumnBlockAndItem("charred_nether_brick_column", BlockusBlocks.CHARRED_NETHER_BRICKS);
        registerColumnBlockAndItem("teal_nether_brick_column", BlockusBlocks.TEAL_NETHER_BRICKS);
        registerColumnBlockAndItem("obsidian_brick_column", BlockusBlocks.OBSIDIAN_BRICKS);
        registerColumnBlockAndItem("small_obsidian_brick_column", BlockusBlocks.SMALL_OBSIDIAN_BRICKS);
        registerColumnBlockAndItem("quartz_tile_column", BlockusBlocks.QUARTZ_TILES);
        registerColumnBlockAndItem("large_brick_column", BlockusBlocks.LARGE_BRICKS);
        registerColumnBlockAndItem("soaked_brick_column", BlockusBlocks.SOAKED_BRICKS);
        registerColumnBlockAndItem("sandy_brick_column", BlockusBlocks.SANDY_BRICKS);
        registerColumnBlockAndItem("charred_brick_column", BlockusBlocks.CHARRED_BRICKS);
        registerColumnBlockAndItem("sandstone_brick_column", BlockusBlocks.SANDSTONE_BRICKS);
        registerColumnBlockAndItem("small_sandstone_brick_column", BlockusBlocks.SMALL_SANDSTONE_BRICKS);
        registerColumnBlockAndItem("red_sandstone_brick_column", BlockusBlocks.RED_SANDSTONE_BRICKS);
        registerColumnBlockAndItem("small_red_sandstone_brick_column", BlockusBlocks.SMALL_RED_SANDSTONE_BRICKS);
        registerColumnBlockAndItem("soul_sandstone_column", BlockusBlocks.SOUL_SANDSTONE);
        registerColumnBlockAndItem("soul_sandstone_brick_column", BlockusBlocks.SOUL_SANDSTONE_BRICKS);
        registerColumnBlockAndItem("small_soul_sandstone_brick_column", BlockusBlocks.SMALL_SOUL_SANDSTONE_BRICKS);
        registerColumnBlockAndItem("honeycomb_brick_column", BlockusBlocks.HONEYCOMB_BRICKS);
        registerColumnBlockAndItem("small_end_stone_brick_column", BlockusBlocks.SMALL_PURPUR_BRICKS);
        registerColumnBlockAndItem("purpur_brick_column", BlockusBlocks.PURPUR_BRICKS);
        registerColumnBlockAndItem("small_purpur_brick_column", BlockusBlocks.SMALL_PURPUR_BRICKS);
        registerColumnBlockAndItem("phantom_purpur_brick_column", BlockusBlocks.PHANTOM_PURPUR_BRICKS);
        registerColumnBlockAndItem("small_phantom_purpur_brick_column", BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS);
        registerColumnBlockAndItem("rainbow_brick_column", BlockusBlocks.RAINBOW_BRICKS);
    }
}
