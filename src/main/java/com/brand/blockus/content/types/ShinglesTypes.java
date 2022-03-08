package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.StairsBase;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum ShinglesTypes {

    SHINGLES("shingles", Blocks.TERRACOTTA),
    WHITE_SHINGLES("white_shingles", Blocks.WHITE_TERRACOTTA),
    ORANGE_SHINGLES("orange_shingles", Blocks.ORANGE_TERRACOTTA),
    MAGENTA_SHINGLES("magenta_shingles", Blocks.MAGENTA_TERRACOTTA),
    LIGHT_BLUE_SHINGLES("light_blue_shingles", Blocks.LIGHT_BLUE_TERRACOTTA),
    YELLOW_SHINGLES("yellow_shingles", Blocks.YELLOW_TERRACOTTA),
    LIME_SHINGLES("lime_shingles", Blocks.LIME_TERRACOTTA),
    PINK_SHINGLES("pink_shingles", Blocks.PINK_TERRACOTTA),
    LIGHT_GRAY_SHINGLES("light_gray_shingles", Blocks.LIGHT_GRAY_TERRACOTTA),
    GRAY_SHINGLES("gray_shingles", Blocks.GRAY_TERRACOTTA),
    CYAN_SHINGLES("cyan_shingles", Blocks.CYAN_TERRACOTTA),
    PURPLE_SHINGLES("purple_shingles", Blocks.PURPLE_TERRACOTTA),
    BLUE_SHINGLES("blue_shingles", Blocks.BLUE_TERRACOTTA),
    BROWN_SHINGLES("brown_shingles", Blocks.BROWN_TERRACOTTA),
    GREEN_SHINGLES("green_shingles", Blocks.GREEN_TERRACOTTA),
    RED_SHINGLES("red_shingles", Blocks.RED_TERRACOTTA),
    BLACK_SHINGLES("black_shingles", Blocks.BLACK_TERRACOTTA);

    public final Block block;
    public final SlabBlock slab;
    public final StairsBase stairs;
    public final BlockItem item;
    public final BlockItem item_slab;
    public final BlockItem item_stairs;
    public final Block base;

    private ShinglesTypes(String type, Block base) {
        Identifier id = new Identifier(Blockus.MOD_ID, type);
        Identifier id_slab = new Identifier(Blockus.MOD_ID, type + "_slab");
        Identifier id_stairs = new Identifier(Blockus.MOD_ID, type + "_stairs");
        this.base = base;

        Block.Settings blockSettings = FabricBlockSettings.copyOf(base).sounds(BlockSoundGroup.NETHER_BRICKS);
        this.block = new Block(blockSettings);
        this.slab = new SlabBlock(blockSettings);
        this.stairs = new StairsBase(block.getDefaultState(), blockSettings);

        Item.Settings itemSettings = new Item.Settings().group(Blockus.BLOCKUS_BUILDING_BLOCKS);
        this.item = new BlockItem(this.block, itemSettings);
        this.item_slab = new BlockItem(this.slab, itemSettings);
        this.item_stairs = new BlockItem(this.stairs, itemSettings);

        Registry.register(Registry.BLOCK, id, this.block);
        Registry.register(Registry.BLOCK, id_slab, this.slab);
        Registry.register(Registry.BLOCK, id_stairs, this.stairs);
        Registry.register(Registry.ITEM, id, this.item);
        Registry.register(Registry.ITEM, id_slab, this.item_slab);
        Registry.register(Registry.ITEM, id_stairs, this.item_stairs);

    }

    public static ShinglesTypes initialize() {
        return null;
    }
}
