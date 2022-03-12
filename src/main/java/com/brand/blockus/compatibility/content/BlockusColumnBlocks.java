package com.brand.blockus.compatibility.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.types.BSSWTypes;
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
        registerColumnBlockAndItem("andesite_brick_column", BSSWTypes.ANDESITE_BRICKS.block);
        registerColumnBlockAndItem("diorite_brick_column", BSSWTypes.DIORITE_BRICKS.block);
        registerColumnBlockAndItem("granite_brick_column", BSSWTypes.GRANITE_BRICKS.block);
        registerColumnBlockAndItem("dripstone_brick_column", BSSWTypes.DRIPSTONE_BRICKS.block);
        registerColumnBlockAndItem("tuff_brick_column", BSSWTypes.TUFF_BRICKS.block);
        registerColumnBlockAndItem("mossy_deepslate_brick_column", BSSWTypes.MOSSY_DEEPSLATE_BRICKS.block);
        registerColumnBlockAndItem("crimson_warty_blackstone_brick_column", BSSWTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.block);
        registerColumnBlockAndItem("warped_warty_blackstone_brick_column", BSSWTypes.WARPED_WARTY_BLACKSTONE_BRICKS.block);
        registerColumnBlockAndItem("polished_basalt_brick_column", BSSWTypes.POLISHED_BASALT_BRICKS.block);
        registerColumnBlockAndItem("limestone_column", BSSWTypes.LIMESTONE.block);
        registerColumnBlockAndItem("limestone_brick_column", BSSWTypes.LIMESTONE_BRICKS.block);
        registerColumnBlockAndItem("small_limestone_brick_column", BSSWTypes.SMALL_LIMESTONE_BRICKS.block);
        registerColumnBlockAndItem("limestone_tile_column", BSSWTypes.LIMESTONE_TILES.block);
        registerColumnBlockAndItem("marble_column", BSSWTypes.MARBLE.block);
        registerColumnBlockAndItem("marble_brick_column", BSSWTypes.MARBLE_BRICKS.block);
        registerColumnBlockAndItem("small_marble_brick_column", BSSWTypes.SMALL_MARBLE_BRICKS.block);
        registerColumnBlockAndItem("marble_tile_column", BSSWTypes.MARBLE_TILES.block);
        registerColumnBlockAndItem("bluestone_column", BSSWTypes.BLUESTONE.block);
        registerColumnBlockAndItem("bluestone_tile_column", BSSWTypes.BLUESTONE_TILES.block);
        registerColumnBlockAndItem("bluestone_brick_column", BSSWTypes.BLUESTONE_BRICKS.block);
        registerColumnBlockAndItem("small_bluestone_brick_column", BSSWTypes.SMALL_BLUESTONE_BRICKS.block);
        registerColumnBlockAndItem("lava_brick_column", BSSWTypes.LAVA_BRICKS.block);
        registerColumnBlockAndItem("lava_polished_blackstone_brick_column", BSSWTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        registerColumnBlockAndItem("water_brick_column", BSSWTypes.WATER_BRICKS.block);
        registerColumnBlockAndItem("snow_brick_column", BlockusBlocks.SNOW_BRICKS);
        registerColumnBlockAndItem("ice_brick_column", BlockusBlocks.ICE_BRICKS);
        registerColumnBlockAndItem("magma_brick_column", BSSWTypes.MAGMA_BRICKS.block);
        registerColumnBlockAndItem("small_magma_brick_column", BSSWTypes.SMALL_MAGMA_BRICKS.block);
        registerColumnBlockAndItem("blaze_brick_column", BSSWTypes.BLAZE_BRICKS.block);
        registerColumnBlockAndItem("netherrack_brick_column", BSSWTypes.NETHERRACK_BRICKS.block);
        registerColumnBlockAndItem("charred_nether_brick_column", BSSWTypes.CHARRED_NETHER_BRICKS.block);
        registerColumnBlockAndItem("teal_nether_brick_column", BSSWTypes.TEAL_NETHER_BRICKS.block);
        registerColumnBlockAndItem("obsidian_brick_column", BSSWTypes.OBSIDIAN_BRICKS.block);
        registerColumnBlockAndItem("small_obsidian_brick_column", BSSWTypes.SMALL_OBSIDIAN_BRICKS.block);
        registerColumnBlockAndItem("quartz_tile_column", BSSWTypes.QUARTZ_TILES.block);
        registerColumnBlockAndItem("large_brick_column", BSSWTypes.LARGE_BRICKS.block);
        registerColumnBlockAndItem("soaked_brick_column", BSSWTypes.SOAKED_BRICKS.block);
        registerColumnBlockAndItem("sandy_brick_column", BSSWTypes.SANDY_BRICKS.block);
        registerColumnBlockAndItem("charred_brick_column", BSSWTypes.CHARRED_BRICKS.block);
        registerColumnBlockAndItem("sandstone_brick_column", BSSWTypes.SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("small_sandstone_brick_column", BSSWTypes.SMALL_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("red_sandstone_brick_column", BSSWTypes.RED_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("small_red_sandstone_brick_column", BSSWTypes.SMALL_RED_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("soul_sandstone_column", BSSWTypes.SOUL_SANDSTONE.block);
        registerColumnBlockAndItem("soul_sandstone_brick_column", BSSWTypes.SOUL_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("small_soul_sandstone_brick_column", BSSWTypes.SMALL_SOUL_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("honeycomb_brick_column", BSSWTypes.HONEYCOMB_BRICKS.block);
        registerColumnBlockAndItem("small_end_stone_brick_column", BSSWTypes.SMALL_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("purpur_brick_column", BSSWTypes.PURPUR_BRICKS.block);
        registerColumnBlockAndItem("small_purpur_brick_column", BSSWTypes.SMALL_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("phantom_purpur_brick_column", BSSWTypes.PHANTOM_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("small_phantom_purpur_brick_column", BSSWTypes.SMALL_PHANTOM_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("rainbow_brick_column", BSSWTypes.RAINBOW_BRICKS.block);
    }
}
