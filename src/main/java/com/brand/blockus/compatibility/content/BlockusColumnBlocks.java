package com.brand.blockus.compatibility.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.types.BlockTypes;
import com.brand.blockus.content.types.LightBlockTypes;
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
        registerColumnBlockAndItem("andesite_brick_column", BlockTypes.ANDESITE_BRICKS.block);
        registerColumnBlockAndItem("diorite_brick_column", BlockTypes.DIORITE_BRICKS.block);
        registerColumnBlockAndItem("granite_brick_column", BlockTypes.GRANITE_BRICKS.block);
        registerColumnBlockAndItem("dripstone_brick_column", BlockTypes.DRIPSTONE_BRICKS.block);
        registerColumnBlockAndItem("tuff_brick_column", BlockTypes.TUFF_BRICKS.block);
        registerColumnBlockAndItem("mossy_deepslate_brick_column", BlockTypes.MOSSY_DEEPSLATE_BRICKS.block);
        registerColumnBlockAndItem("crimson_warty_blackstone_brick_column", BlockTypes.CRIMSON_WARTY_BLACKSTONE_BRICKS.block);
        registerColumnBlockAndItem("warped_warty_blackstone_brick_column", BlockTypes.WARPED_WARTY_BLACKSTONE_BRICKS.block);
        registerColumnBlockAndItem("polished_basalt_brick_column", BlockTypes.POLISHED_BASALT_BRICKS.block);
        registerColumnBlockAndItem("limestone_column", BlockTypes.LIMESTONE.block);
        registerColumnBlockAndItem("limestone_brick_column", BlockTypes.LIMESTONE_BRICKS.block);
        registerColumnBlockAndItem("small_limestone_brick_column", BlockTypes.SMALL_LIMESTONE_BRICKS.block);
        registerColumnBlockAndItem("limestone_tile_column", BlockTypes.LIMESTONE_TILES.block);
        registerColumnBlockAndItem("marble_column", BlockTypes.MARBLE.block);
        registerColumnBlockAndItem("marble_brick_column", BlockTypes.MARBLE_BRICKS.block);
        registerColumnBlockAndItem("small_marble_brick_column", BlockTypes.SMALL_MARBLE_BRICKS.block);
        registerColumnBlockAndItem("marble_tile_column", BlockTypes.MARBLE_TILES.block);
        registerColumnBlockAndItem("bluestone_column", BlockTypes.BLUESTONE.block);
        registerColumnBlockAndItem("bluestone_tile_column", BlockTypes.BLUESTONE_TILES.block);
        registerColumnBlockAndItem("bluestone_brick_column", BlockTypes.BLUESTONE_BRICKS.block);
        registerColumnBlockAndItem("small_bluestone_brick_column", BlockTypes.SMALL_BLUESTONE_BRICKS.block);
        registerColumnBlockAndItem("lava_brick_column", LightBlockTypes.LAVA_BRICKS.block);
        registerColumnBlockAndItem("lava_polished_blackstone_brick_column", LightBlockTypes.LAVA_POLISHED_BLACKSTONE_BRICKS.block);
        registerColumnBlockAndItem("water_brick_column", BlockTypes.WATER_BRICKS.block);
        registerColumnBlockAndItem("snow_brick_column", BlockusBlocks.SNOW_BRICKS);
        registerColumnBlockAndItem("ice_brick_column", BlockusBlocks.ICE_BRICKS);
        registerColumnBlockAndItem("magma_brick_column", LightBlockTypes.MAGMA_BRICKS.block);
        registerColumnBlockAndItem("small_magma_brick_column", LightBlockTypes.SMALL_MAGMA_BRICKS.block);
        registerColumnBlockAndItem("blaze_brick_column", LightBlockTypes.BLAZE_BRICKS.block);
        registerColumnBlockAndItem("netherrack_brick_column", BlockTypes.NETHERRACK_BRICKS.block);
        registerColumnBlockAndItem("charred_nether_brick_column", BlockTypes.CHARRED_NETHER_BRICKS.block);
        registerColumnBlockAndItem("teal_nether_brick_column", BlockTypes.TEAL_NETHER_BRICKS.block);
        registerColumnBlockAndItem("obsidian_brick_column", BlockTypes.OBSIDIAN_BRICKS.block);
        registerColumnBlockAndItem("small_obsidian_brick_column", BlockTypes.SMALL_OBSIDIAN_BRICKS.block);
        registerColumnBlockAndItem("quartz_tile_column", BlockTypes.QUARTZ_TILES.block);
        registerColumnBlockAndItem("large_brick_column", BlockTypes.LARGE_BRICKS.block);
        registerColumnBlockAndItem("soaked_brick_column", BlockTypes.SOAKED_BRICKS.block);
        registerColumnBlockAndItem("sandy_brick_column", BlockTypes.SANDY_BRICKS.block);
        registerColumnBlockAndItem("charred_brick_column", BlockTypes.CHARRED_BRICKS.block);
        registerColumnBlockAndItem("sandstone_brick_column", BlockTypes.SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("small_sandstone_brick_column", BlockTypes.SMALL_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("red_sandstone_brick_column", BlockTypes.RED_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("small_red_sandstone_brick_column", BlockTypes.SMALL_RED_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("soul_sandstone_column", BlockTypes.SOUL_SANDSTONE.block);
        registerColumnBlockAndItem("soul_sandstone_brick_column", BlockTypes.SOUL_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("small_soul_sandstone_brick_column", BlockTypes.SMALL_SOUL_SANDSTONE_BRICKS.block);
        registerColumnBlockAndItem("honeycomb_brick_column", BlockTypes.HONEYCOMB_BRICKS.block);
        registerColumnBlockAndItem("small_end_stone_brick_column", BlockTypes.SMALL_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("purpur_brick_column", BlockTypes.PURPUR_BRICKS.block);
        registerColumnBlockAndItem("small_purpur_brick_column", BlockTypes.SMALL_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("phantom_purpur_brick_column", BlockTypes.PHANTOM_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("small_phantom_purpur_brick_column", BlockTypes.SMALL_PHANTOM_PURPUR_BRICKS.block);
        registerColumnBlockAndItem("rainbow_brick_column", BlockTypes.RAINBOW_BRICKS.block);
    }
}
