package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.StairsBase;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum BSSWTypes {

    ANDESITE_BRICKS("andesite_bricks", Blocks.POLISHED_ANDESITE),
    DIORITE_BRICKS("diorite_bricks", Blocks.POLISHED_DIORITE),
    GRANITE_BRICKS("granite_bricks", Blocks.POLISHED_GRANITE),
    DRIPSTONE_BRICKS("dripstone_bricks", BSSTypes.POLISHED_DRIPSTONE.block),
    TUFF_BRICKS("tuff_bricks", BSSTypes.POLISHED_TUFF.block),
    MOSSY_DEEPSLATE_BRICKS("mossy_deepslate_bricks", Blocks.DEEPSLATE_BRICKS),
    CRIMSON_WARTY_BLACKSTONE_BRICKS("crimson_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE),
    WARPED_WARTY_BLACKSTONE_BRICKS("warped_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE),
    POLISHED_BASALT_BRICKS("polished_basalt_bricks", Blocks.POLISHED_BASALT),

    LIMESTONE("limestone", Blocks.STONE, MapColor.OAK_TAN),
    LIMESTONE_BRICKS("limestone_bricks", LIMESTONE.block),
    SMALL_LIMESTONE_BRICKS("small_limestone_bricks", LIMESTONE_BRICKS.block),
    LIMESTONE_TILES("limestone_tiles", LIMESTONE_BRICKS.block),

    MARBLE("marble", Blocks.STONE, MapColor.OFF_WHITE),
    MARBLE_BRICKS("marble_bricks", MARBLE.block),
    SMALL_MARBLE_BRICKS("small_marble_bricks", MARBLE_BRICKS.block),
    MARBLE_TILES("marble_tiles", MARBLE_BRICKS.block),

    BLUESTONE("bluestone", Blocks.STONE, MapColor.CYAN),
    BLUESTONE_BRICKS("bluestone_bricks", BLUESTONE.block),
    SMALL_BLUESTONE_BRICKS("small_bluestone_bricks", BLUESTONE_BRICKS.block),
    BLUESTONE_TILES("bluestone_tiles", BLUESTONE_BRICKS.block),

    LAVA_BRICKS("lava_bricks", Blocks.STONE_BRICKS, 15),
    LAVA_POLISHED_BLACKSTONE_BRICKS("lava_polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS, 15),
    MAGMA_BRICKS("magma_bricks", Blocks.MAGMA_BLOCK, 15),
    SMALL_MAGMA_BRICKS("small_magma_bricks", Blocks.MAGMA_BLOCK, 15),
    BLAZE_BRICKS("blaze_bricks", Blocks.NETHER_BRICKS, 15),

    WATER_BRICKS("water_bricks", Blocks.STONE_BRICKS),
    NETHERRACK_BRICKS("netherrack_bricks", Blocks.NETHERRACK),

    CHARRED_NETHER_BRICKS("charred_nether_bricks", Blocks.NETHER_BRICKS, MapColor.BLACK),
    TEAL_NETHER_BRICKS("teal_nether_bricks", Blocks.NETHER_BRICKS, MapColor.CYAN),

    OBSIDIAN_BRICKS("obsidian_bricks", Blocks.OBSIDIAN),
    SMALL_OBSIDIAN_BRICKS("small_obsidian_bricks", OBSIDIAN_BRICKS.block),

    QUARTZ_TILES("quartz_tiles", Blocks.QUARTZ_BLOCK),
    LARGE_BRICKS("large_bricks", Blocks.BRICKS),
    SOAKED_BRICKS("soaked_bricks", Blocks.BRICKS),
    SANDY_BRICKS("sandy_bricks", Blocks.BRICKS),
    CHARRED_BRICKS("charred_bricks", Blocks.BRICKS),
    RAINBOW_BRICKS("rainbow_bricks", Blocks.BRICKS),
    HONEYCOMB_BRICKS("honeycomb_bricks", Blocks.BRICKS),

    SANDSTONE_BRICKS("sandstone_bricks", Blocks.SANDSTONE),
    SMALL_SANDSTONE_BRICKS("small_sandstone_bricks", Blocks.SANDSTONE),

    RED_SANDSTONE_BRICKS("red_sandstone_bricks", Blocks.SANDSTONE),
    SMALL_RED_SANDSTONE_BRICKS("small_red_sandstone_bricks", Blocks.SANDSTONE),

    SOUL_SANDSTONE("soul_sandstone", Blocks.SANDSTONE, MapColor.BROWN),
    SOUL_SANDSTONE_BRICKS("soul_sandstone_bricks", SOUL_SANDSTONE.block),
    SMALL_SOUL_SANDSTONE_BRICKS("small_soul_sandstone_bricks", SOUL_SANDSTONE.block),

    PURPUR_BRICKS("purpur_bricks", Blocks.PURPUR_BLOCK),
    SMALL_PURPUR_BRICKS("small_purpur_bricks", Blocks.PURPUR_BLOCK),

    PHANTOM_PURPUR_BRICKS("phantom_purpur_bricks", Blocks.PURPUR_BLOCK),
    SMALL_PHANTOM_PURPUR_BRICKS("small_phantom_purpur_bricks", Blocks.PURPUR_BLOCK),

    SMALL_END_STONE_BRICKS("small_end_stone_bricks", Blocks.END_STONE),

    WHITE_STONE_BRICKS("white_stone_bricks", Blocks.STONE_BRICKS, MapColor.WHITE),
    ORANGE_STONE_BRICKS("orange_stone_bricks", Blocks.STONE_BRICKS, MapColor.ORANGE),
    MAGENTA_STONE_BRICKS("magenta_stone_bricks", Blocks.STONE_BRICKS, MapColor.MAGENTA),
    LIGHT_BLUE_STONE_BRICKS("light_blue_stone_bricks", Blocks.STONE_BRICKS, MapColor.LIGHT_BLUE),
    YELLOW_STONE_BRICKS("yellow_stone_bricks", Blocks.STONE_BRICKS, MapColor.YELLOW),
    LIME_STONE_BRICKS("lime_stone_bricks", Blocks.STONE_BRICKS, MapColor.LIME),
    PINK_STONE_BRICKS("pink_stone_bricks", Blocks.STONE_BRICKS, MapColor.PINK),
    GRAY_STONE_BRICKS("gray_stone_bricks", Blocks.STONE_BRICKS, MapColor.GRAY),
    CYAN_STONE_BRICKS("cyan_stone_bricks", Blocks.STONE_BRICKS, MapColor.CYAN),
    PURPLE_STONE_BRICKS("purple_stone_bricks", Blocks.STONE_BRICKS, MapColor.PURPLE),
    BLUE_STONE_BRICKS("blue_stone_bricks", Blocks.STONE_BRICKS, MapColor.BLUE),
    BROWN_STONE_BRICKS("brown_stone_bricks", Blocks.STONE_BRICKS, MapColor.BROWN),
    GREEN_STONE_BRICKS("green_stone_bricks", Blocks.STONE_BRICKS, MapColor.GREEN),
    RED_STONE_BRICKS("red_stone_bricks", Blocks.STONE_BRICKS, MapColor.RED),
    BLACK_STONE_BRICKS("black_stone_bricks", Blocks.STONE_BRICKS, MapColor.BLACK),

    WHITE_CONCRETE_BRICKS("white_concrete_bricks", Blocks.WHITE_CONCRETE),
    ORANGE_CONCRETE_BRICKS("orange_concrete_bricks", Blocks.ORANGE_CONCRETE),
    MAGENTA_CONCRETE_BRICKS("magenta_concrete_bricks", Blocks.MAGENTA_CONCRETE),
    LIGHT_BLUE_CONCRETE_BRICKS("light_blue_concrete_bricks", Blocks.LIGHT_BLUE_CONCRETE),
    YELLOW_CONCRETE_BRICKS("yellow_concrete_bricks", Blocks.YELLOW_CONCRETE),
    LIME_CONCRETE_BRICKS("lime_concrete_bricks", Blocks.LIME_CONCRETE),
    PINK_CONCRETE_BRICKS("pink_concrete_bricks", Blocks.PINK_CONCRETE),
    GRAY_CONCRETE_BRICKS("gray_concrete_bricks", Blocks.GRAY_CONCRETE),
    LIGHT_GRAY_CONCRETE_BRICKS("light_gray_concrete_bricks", Blocks.LIGHT_GRAY_CONCRETE),
    CYAN_CONCRETE_BRICKS("cyan_concrete_bricks", Blocks.CYAN_CONCRETE),
    PURPLE_CONCRETE_BRICKS("purple_concrete_bricks", Blocks.PURPLE_CONCRETE),
    BLUE_CONCRETE_BRICKS("blue_concrete_bricks", Blocks.BLUE_CONCRETE),
    BROWN_CONCRETE_BRICKS("brown_concrete_bricks", Blocks.BROWN_CONCRETE),
    GREEN_CONCRETE_BRICKS("green_concrete_bricks", Blocks.GREEN_CONCRETE),
    RED_CONCRETE_BRICKS("red_concrete_bricks", Blocks.RED_CONCRETE),
    BLACK_CONCRETE_BRICKS("black_concrete_bricks", Blocks.BLACK_CONCRETE);

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block wall;
    public final Block base;

    private BSSWTypes(String type, Block base, Block.Settings blockSettings) {
        String replace = type.replace("lava_polished_blackstone_bricks", "lava_polished_blackstone").replace("bricks", "brick").replace("tiles", "tile").replace("_block", "");

        this.base = base;

        this.block = Blockus.block(type, new Block(FabricBlockSettings.copyOf(blockSettings)));
        this.slab = Blockus.block(replace + "_slab", new SlabBlock(FabricBlockSettings.copyOf(blockSettings)));
        this.stairs = Blockus.block(replace + "_stairs", new StairsBase(this.block.getDefaultState(), FabricBlockSettings.copyOf(blockSettings)));
        this.wall = Blockus.decoration(replace + "_wall", new WallBlock(FabricBlockSettings.copyOf(blockSettings)));

    }

    private BSSWTypes(String type, Block base, MapColor mapcolor) {
        this(type, base, FabricBlockSettings.copyOf(base).mapColor(mapcolor));

    }

    private BSSWTypes(String type, Block base) {
        this(type, base, FabricBlockSettings.copyOf(base));

    }

    private BSSWTypes(String type, Block base, int luminance) {
        this(type, base, FabricBlockSettings.copyOf(base).luminance(luminance));

    }

    public static BSSWTypes initialize() {
        return null;
    }
}
