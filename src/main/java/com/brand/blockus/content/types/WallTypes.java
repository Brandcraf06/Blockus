package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum WallTypes {

    ANDESITE_BRICKS("andesite_bricks", Blocks.POLISHED_ANDESITE, MapColor.STONE_GRAY),
    DIORITE_BRICKS("diorite_bricks", Blocks.POLISHED_DIORITE, MapColor.OFF_WHITE),
    GRANITE_BRICKS("granite_bricks", Blocks.POLISHED_ANDESITE, MapColor.DIRT_BROWN),
    DRIPSTONE_BRICKS("dripstone_bricks", BlockTypes.POLISHED_DRIPSTONE.block, MapColor.TERRACOTTA_BROWN),
    TUFF_BRICKS("tuff_bricks", BlockTypes.POLISHED_TUFF.block, MapColor.TERRACOTTA_GRAY),
    MOSSY_DEEPSLATE_BRICKS("mossy_deepslate_bricks", Blocks.DEEPSLATE_BRICKS, MapColor.DEEPSLATE_GRAY),
    CRIMSON_WARTY_BLACKSTONE_BRICKS("crimson_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE, MapColor.BLACK),
    WARPED_WARTY_BLACKSTONE_BRICKS("warped_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE, MapColor.BLACK),
    POLISHED_BASALT_BRICKS("polished_basalt_bricks", Blocks.POLISHED_BASALT, MapColor.BLACK),

    LIMESTONE("limestone", Blocks.STONE, MapColor.OAK_TAN),
    LIMESTONE_BRICKS("limestone_bricks", BlockTypes.POLISHED_LIMESTONE.block, MapColor.OAK_TAN),
    SMALL_LIMESTONE_BRICKS("small_limestone_bricks", LIMESTONE_BRICKS.wall, MapColor.OAK_TAN),
    LIMESTONE_TILES("limestone_tiles", LIMESTONE_BRICKS.wall, MapColor.OAK_TAN),

    MARBLE("marble", Blocks.STONE, MapColor.OFF_WHITE),
    MARBLE_BRICKS("marble_bricks", BlockTypes.POLISHED_MARBLE.block, MapColor.OFF_WHITE),
    SMALL_MARBLE_BRICKS("small_marble_bricks", MARBLE_BRICKS.wall, MapColor.OFF_WHITE),
    MARBLE_TILES("marble_tiles", MARBLE_BRICKS.wall, MapColor.OFF_WHITE),

    BLUESTONE("bluestone", Blocks.STONE, MapColor.CYAN),
    BLUESTONE_BRICKS("bluestone_bricks", BlockTypes.POLISHED_BLUESTONE.block, MapColor.CYAN),
    SMALL_BLUESTONE_BRICKS("small_bluestone_bricks", BLUESTONE_BRICKS.wall, MapColor.CYAN),
    BLUESTONE_TILES("bluestone_tiles", BLUESTONE_BRICKS.wall, MapColor.CYAN),

    WATER_BRICKS("water_bricks", Blocks.STONE_BRICKS, MapColor.STONE_GRAY),
    NETHERRACK_BRICKS("netherrack_bricks", BlockTypes.POLISHED_NETHERRACK.block, MapColor.DARK_RED),

    CHARRED_NETHER_BRICKS("charred_nether_bricks", Blocks.NETHER_BRICKS, MapColor.BLACK),
    TEAL_NETHER_BRICKS("teal_nether_bricks", Blocks.NETHER_BRICKS, MapColor.CYAN),

    OBSIDIAN_BRICKS("obsidian_bricks", Blocks.OBSIDIAN, MapColor.BLACK),
    SMALL_OBSIDIAN_BRICKS("small_obsidian_bricks", OBSIDIAN_BRICKS.wall, MapColor.BLACK),

    QUARTZ_TILES("quartz_tiles", Blocks.QUARTZ_BLOCK, MapColor.OFF_WHITE),
    LARGE_BRICKS("large_bricks", Blocks.BRICKS, MapColor.RED),
    SOAKED_BRICKS("soaked_bricks", Blocks.BRICKS, MapColor.CYAN),
    SANDY_BRICKS("sandy_bricks", Blocks.BRICKS, MapColor.SPRUCE_BROWN),
    CHARRED_BRICKS("charred_bricks", Blocks.BRICKS, MapColor.BLACK),
    RAINBOW_BRICKS("rainbow_bricks", Blocks.BRICKS, MapColor.BLACK),
    HONEYCOMB_BRICKS("honeycomb_bricks", Blocks.BRICKS, MapColor.OFF_WHITE),

    SANDSTONE_BRICKS("sandstone_bricks", Blocks.SANDSTONE, MapColor.PALE_YELLOW),
    SMALL_SANDSTONE_BRICKS("small_sandstone_bricks", Blocks.SANDSTONE, MapColor.PALE_YELLOW),

    RED_SANDSTONE_BRICKS("red_sandstone_bricks", Blocks.SANDSTONE, MapColor.ORANGE),
    SMALL_RED_SANDSTONE_BRICKS("small_red_sandstone_bricks", Blocks.SANDSTONE, MapColor.ORANGE),

    SOUL_SANDSTONE("soul_sandstone", Blocks.SANDSTONE, MapColor.BROWN),
    SOUL_SANDSTONE_BRICKS("soul_sandstone_bricks", SOUL_SANDSTONE.wall, MapColor.BROWN),
    SMALL_SOUL_SANDSTONE_BRICKS("small_soul_sandstone_bricks", SOUL_SANDSTONE.wall, MapColor.BROWN),

    PURPUR_BRICKS("purpur_bricks", Blocks.PURPUR_BLOCK, MapColor.MAGENTA),
    SMALL_PURPUR_BRICKS("small_purpur_bricks", Blocks.PURPUR_BLOCK, MapColor.MAGENTA),

    PHANTOM_PURPUR_BRICKS("phantom_purpur_bricks", Blocks.PURPUR_BLOCK, MapColor.MAGENTA),
    SMALL_PHANTOM_PURPUR_BRICKS("small_phantom_purpur_bricks", Blocks.PURPUR_BLOCK, MapColor.MAGENTA),

    SMALL_END_STONE_BRICKS("small_end_stone_bricks", Blocks.END_STONE, MapColor.PALE_YELLOW),

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

    WHITE_CONCRETE_BRICKS("white_concrete_bricks", Blocks.WHITE_CONCRETE, MapColor.WHITE),
    ORANGE_CONCRETE_BRICKS("orange_concrete_bricks", Blocks.ORANGE_CONCRETE, MapColor.ORANGE),
    MAGENTA_CONCRETE_BRICKS("magenta_concrete_bricks", Blocks.MAGENTA_CONCRETE, MapColor.MAGENTA),
    LIGHT_BLUE_CONCRETE_BRICKS("light_blue_concrete_bricks", Blocks.LIGHT_BLUE_CONCRETE, MapColor.LIGHT_BLUE),
    YELLOW_CONCRETE_BRICKS("yellow_concrete_bricks", Blocks.YELLOW_CONCRETE, MapColor.YELLOW),
    LIME_CONCRETE_BRICKS("lime_concrete_bricks", Blocks.LIME_CONCRETE, MapColor.LIME),
    PINK_CONCRETE_BRICKS("pink_concrete_bricks", Blocks.PINK_CONCRETE, MapColor.PINK),
    GRAY_CONCRETE_BRICKS("gray_concrete_bricks", Blocks.GRAY_CONCRETE, MapColor.GRAY),
    LIGHT_GRAY_CONCRETE_BRICKS("light_gray_concrete_bricks", Blocks.LIGHT_GRAY_CONCRETE, MapColor.LIGHT_GRAY),
    CYAN_CONCRETE_BRICKS("cyan_concrete_bricks", Blocks.CYAN_CONCRETE, MapColor.CYAN),
    PURPLE_CONCRETE_BRICKS("purple_concrete_bricks", Blocks.PURPLE_CONCRETE, MapColor.PURPLE),
    BLUE_CONCRETE_BRICKS("blue_concrete_bricks", Blocks.BLUE_CONCRETE, MapColor.BLUE),
    BROWN_CONCRETE_BRICKS("brown_concrete_bricks", Blocks.BROWN_CONCRETE, MapColor.BROWN),
    GREEN_CONCRETE_BRICKS("green_concrete_bricks", Blocks.GREEN_CONCRETE, MapColor.GREEN),
    RED_CONCRETE_BRICKS("red_concrete_bricks", Blocks.RED_CONCRETE, MapColor.RED),
    BLACK_CONCRETE_BRICKS("black_concrete_bricks", Blocks.BLACK_CONCRETE, MapColor.BLACK),

    THATCH("thatch", Blocks.HAY_BLOCK, MapColor.YELLOW),
    IRON_PLATING("iron_plating", Blocks.IRON_BLOCK, MapColor.STONE_GRAY),
    GOLD_PLATING("gold_plating", Blocks.GOLD_BLOCK, MapColor.GOLD);

    public final Block wall;
    public final BlockItem item;
    public final Block base;

    private WallTypes(String type, Block base, MapColor mapcolor) {
        String replace = type.replace("bricks", "brick").replace("tiles", "tile");

        Identifier id = new Identifier(Blockus.MOD_ID, replace + "_wall");
        this.base = base;

        Block.Settings blockSettings = FabricBlockSettings.copyOf(base).mapColor(mapcolor);
        this.wall = new WallBlock(blockSettings);

        Item.Settings itemSettings = new Item.Settings().group(Blockus.BLOCKUS_DECORATIONS);
        this.item = new BlockItem(this.wall, itemSettings);

        Registry.register(Registry.BLOCK, id, this.wall);
        Registry.register(Registry.ITEM, id, this.item);
    }

    public static WallTypes initialize() {
        return null;
    }
}
