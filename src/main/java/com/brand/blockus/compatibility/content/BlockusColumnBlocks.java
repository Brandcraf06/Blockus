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
        Identifier id =  Blockus.id(path);

        Block block = new ColumnBlock(FabricBlockSettings.copy(base));
        Registry.register(Registry.BLOCK, id, block);

        Item item = new BlockItem(block, new Item.Settings().group(Blockus.BLOCKUS_DECORATIONS));
        Registry.register(Registry.ITEM, id, item);
    }

    public static void init() {
        registerColumnBlockAndItem("andesite_brick_column", BlockusBlocks.ANDESITE_BRICKS.block);
        registerColumnBlockAndItem("diorite_brick_column", BlockusBlocks.DIORITE_BRICKS.block);
        registerColumnBlockAndItem("granite_brick_column", BlockusBlocks.GRANITE_BRICKS.block);
        registerColumnBlockAndItem("dripstone_brick_column", BlockusBlocks.DRIPSTONE_BRICKS.block);
        registerColumnBlockAndItem("tuff_brick_column", BlockusBlocks.TUFF_BRICKS.block);
        registerColumnBlockAndItem("mossy_deepslate_brick_column", BlockusBlocks.MOSSY_DEEPSLATE_BRICKS.block);
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
        registerColumnBlockAndItem("small_end_stone_brick_column", BlockusBlocks.SMALL_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("purpur_brick_column", BlockusBlocks.PURPUR_BRICKS.block);
        registerColumnBlockAndItem("small_purpur_brick_column", BlockusBlocks.SMALL_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("phantom_purpur_brick_column", BlockusBlocks.PHANTOM_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("small_phantom_purpur_brick_column", BlockusBlocks.SMALL_PHANTOM_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("rainbow_brick_column", BlockusBlocks.RAINBOW_BRICKS.block);
    }
}
