package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.StairsBase;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum BSSTypes {

    POLISHED_DRIPSTONE("polished_dripstone", Blocks.DRIPSTONE_BLOCK),
    POLISHED_TUFF("polished_tuff", Blocks.TUFF),
    ROUGH_BASALT("rough_basalt", Blocks.BASALT),

    POLISHED_LIMESTONE("polished_limestone", BSSWTypes.LIMESTONE.block),
    POLISHED_MARBLE("polished_marble", BSSWTypes.MARBLE.block),
    POLISHED_BLUESTONE("polished_bluestone", BSSWTypes.BLUESTONE.block),
    POLISHED_NETHERRACK("polished_netherrack", Blocks.NETHERRACK),

    ROUGH_SANDSTONE("rough_sandstone", Blocks.SANDSTONE),
    ROUGH_RED_SANDSTONE("rough_red_sandstone", Blocks.SANDSTONE),
    ROUGH_SOUL_SANDSTONE("rough_soul_sandstone", BSSWTypes.SOUL_SANDSTONE.block),
    SMOOTH_SOUL_SANDSTONE("smooth_soul_sandstone", BSSWTypes.SOUL_SANDSTONE.block),


    POLISHED_PURPUR("polished_purpur", Blocks.PURPUR_BLOCK),
    PHANTOM_PURPUR_BLOCK("phantom_purpur_block", Blocks.PURPUR_BLOCK),
    POLISHED_PHANTOM_PURPUR("polished_phantom_purpur", Blocks.PURPUR_BLOCK),

    POLISHED_END_STONE("polished_end_stone", Blocks.END_STONE),

    SHINGLES("shingles", Blocks.TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    WHITE_SHINGLES("white_shingles", Blocks.WHITE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    ORANGE_SHINGLES("orange_shingles", Blocks.ORANGE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    MAGENTA_SHINGLES("magenta_shingles", Blocks.MAGENTA_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    LIGHT_BLUE_SHINGLES("light_blue_shingles", Blocks.LIGHT_BLUE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    YELLOW_SHINGLES("yellow_shingles", Blocks.YELLOW_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    LIME_SHINGLES("lime_shingles", Blocks.LIME_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    PINK_SHINGLES("pink_shingles", Blocks.PINK_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    LIGHT_GRAY_SHINGLES("light_gray_shingles", Blocks.LIGHT_GRAY_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    GRAY_SHINGLES("gray_shingles", Blocks.GRAY_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    CYAN_SHINGLES("cyan_shingles", Blocks.CYAN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    PURPLE_SHINGLES("purple_shingles", Blocks.PURPLE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    BLUE_SHINGLES("blue_shingles", Blocks.BLUE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    BROWN_SHINGLES("brown_shingles", Blocks.BROWN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    GREEN_SHINGLES("green_shingles", Blocks.GREEN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    RED_SHINGLES("red_shingles", Blocks.RED_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),
    BLACK_SHINGLES("black_shingles", Blocks.BLACK_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS),

    THATCH("thatch", Blocks.HAY_BLOCK),
    IRON_PLATING("iron_plating", Blocks.IRON_BLOCK, MapColor.STONE_GRAY),
    GOLD_PLATING("gold_plating", Blocks.GOLD_BLOCK);

    public final Block block;
    public final SlabBlock slab;
    public final StairsBase stairs;
    public final BlockItem item;
    public final BlockItem item_slab;
    public final BlockItem item_stairs;
    public final Block base;

    private BSSTypes(String type, Block base, Block.Settings blockSettings) {
        String replace = type.replace("bricks", "brick").replace("tiles", "tile").replace("_block", "");

        Identifier id = Blockus.id(type);
        Identifier id_slab = Blockus.id(replace + "_slab");
        Identifier id_stairs = Blockus.id(replace + "_stairs");

        Item.Settings itemSettings = new Item.Settings().group(Blockus.BLOCKUS_BUILDING_BLOCKS);

        this.base = base;

        this.block = Registry.register(Registry.BLOCK, id, new Block(FabricBlockSettings.copyOf(blockSettings)));
        this.slab = Registry.register(Registry.BLOCK, id_slab, new SlabBlock(FabricBlockSettings.copyOf(blockSettings)));
        this.stairs = Registry.register(Registry.BLOCK, id_stairs, new StairsBase(this.block.getDefaultState(), FabricBlockSettings.copyOf(blockSettings)));

        this.item = Registry.register(Registry.ITEM, id, new BlockItem(this.block, itemSettings));
        this.item_slab = Registry.register(Registry.ITEM, id_slab, new BlockItem(this.slab, itemSettings));
        this.item_stairs = Registry.register(Registry.ITEM, id_stairs, new BlockItem(this.stairs, itemSettings));

    }

    private BSSTypes(String type, Block base) {
        this(type, base, FabricBlockSettings.copyOf(base));

    }

    private BSSTypes(String type, Block base, MapColor mapcolor) {
        this(type, base, FabricBlockSettings.copyOf(base).mapColor(mapcolor));

    }

    private BSSTypes(String type, Block base, BlockSoundGroup sounds) {
        this(type, base, FabricBlockSettings.copyOf(base).sounds(sounds));
    }

    public static BSSTypes initialize() {
        return null;
    }
}
