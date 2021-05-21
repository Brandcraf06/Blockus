package com.brand.blockus.content.compatibility;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.compatibility.BlockusWoodenHopperBlock;
import com.brand.blockus.content.BlockusBlocks;

import io.github.haykam821.woodenhoppers.block.entity.WoodenHopperBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class BlockusWoodenHopperBlocks {
    private static final Block BAMBOO_HOPPER = registerHopperBlockAndItem("bamboo_hopper", BlockusBlocks.BAMBOO_PLANKS);
    private static final Block CHARRED_HOPPER = registerHopperBlockAndItem("charred_hopper", BlockusBlocks.CHARRED_PLANKS);
    private static final Block WHITE_OAK_HOPPER = registerHopperBlockAndItem("white_oak_hopper", BlockusBlocks.WHITE_OAK_PLANKS);

    private static final Identifier BLOCK_ENTITY_TYPE_ID = new Identifier(Blockus.MOD_ID, "wooden_hopper");
    public static final BlockEntityType<WoodenHopperBlockEntity> BLOCK_ENTITY_TYPE = BlockEntityType.Builder
        .create(WoodenHopperBlockEntity::new, BAMBOO_HOPPER, CHARRED_HOPPER, WHITE_OAK_HOPPER)
        .build(null);

    private BlockusWoodenHopperBlocks() {
        return;
    }

    private static Block registerHopperBlockAndItem(String path, Block base) {
        Identifier id = new Identifier(Blockus.MOD_ID, path);

        Block block = new BlockusWoodenHopperBlock(FabricBlockSettings.of(Material.WOOD, base.getDefaultMaterialColor()).strength(2).sounds(BlockSoundGroup.WOOD).nonOpaque());
        Registry.register(Registry.BLOCK, id, block);

        Item item = new BlockItem(block, new Item.Settings().group(Blockus.BLOCKUS_REDSTONE));
        Registry.register(Registry.ITEM, id, item);

        return block;
    }

    public static void init() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, BLOCK_ENTITY_TYPE_ID, BLOCK_ENTITY_TYPE);
    }
}
