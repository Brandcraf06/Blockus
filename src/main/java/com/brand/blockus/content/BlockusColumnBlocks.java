package com.brand.blockus.content;

import com.brand.blockus.Blockus;

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
        registerColumnBlockAndItem("water_brick_column", BlockusBlocks.WATER_BRICKS);
        registerColumnBlockAndItem("snow_brick_column", BlockusBlocks.SNOW_BRICKS);
        registerColumnBlockAndItem("ice_brick_column", BlockusBlocks.ICE_BRICKS);
        registerColumnBlockAndItem("magma_brick_column", BlockusBlocks.MAGMA_BRICKS);
        registerColumnBlockAndItem("blaze_brick_column", BlockusBlocks.BLAZE_BRICKS);
        registerColumnBlockAndItem("charred_nether_brick_column", BlockusBlocks.CHARRED_NETHER_BRICKS);
        registerColumnBlockAndItem("teal_nether_brick_column", BlockusBlocks.TEAL_NETHER_BRICKS);
        registerColumnBlockAndItem("obsidian_brick_column", BlockusBlocks.OBSIDIAN_BRICKS);
        registerColumnBlockAndItem("large_brick_column", BlockusBlocks.LARGE_BRICKS);
        registerColumnBlockAndItem("soaked_brick_column", BlockusBlocks.SOAKED_BRICKS);
        registerColumnBlockAndItem("sandy_brick_column", BlockusBlocks.SANDY_BRICKS);
        registerColumnBlockAndItem("charred_brick_column", BlockusBlocks.CHARRED_BRICKS);
    }
}
