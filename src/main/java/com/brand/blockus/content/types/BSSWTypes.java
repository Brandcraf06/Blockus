package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;

public class BSSWTypes {
    private static final ArrayList<BSSWTypes> LIST = new ArrayList<>();

    public static final BSSWTypes ANDESITE_BRICKS = new BSSWTypes("andesite_bricks", Blocks.POLISHED_ANDESITE);
    public static final BSSWTypes DIORITE_BRICKS = new BSSWTypes("diorite_bricks", Blocks.POLISHED_DIORITE);
    public static final BSSWTypes GRANITE_BRICKS = new BSSWTypes("granite_bricks", Blocks.POLISHED_GRANITE);
    public static final BSSWTypes DRIPSTONE_BRICKS = new BSSWTypes("dripstone_bricks", BSSTypes.POLISHED_DRIPSTONE.block);
    public static final BSSWTypes TUFF_BRICKS = new BSSWTypes("tuff_bricks", BSSTypes.POLISHED_TUFF.block);
    public static final BSSWTypes MOSSY_DEEPSLATE_BRICKS = new BSSWTypes("mossy_deepslate_bricks", Blocks.DEEPSLATE_BRICKS);
    public static final BSSWTypes CRIMSON_WARTY_BLACKSTONE_BRICKS = new BSSWTypes("crimson_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE);
    public static final BSSWTypes WARPED_WARTY_BLACKSTONE_BRICKS = new BSSWTypes("warped_warty_blackstone_bricks", Blocks.POLISHED_BLACKSTONE);
    public static final BSSWTypes POLISHED_BASALT_BRICKS = new BSSWTypes("polished_basalt_bricks", Blocks.POLISHED_BASALT);
    
    public static final BSSWTypes LIMESTONE = new BSSWTypes("limestone", Blocks.STONE, MapColor.OAK_TAN);
    public static final BSSWTypes LIMESTONE_BRICKS = new BSSWTypes("limestone_bricks", LIMESTONE.block);
    public static final BSSWTypes SMALL_LIMESTONE_BRICKS = new BSSWTypes("small_limestone_bricks", LIMESTONE_BRICKS.block);
    public static final BSSWTypes LIMESTONE_TILES = new BSSWTypes("limestone_tiles", LIMESTONE_BRICKS.block);

    public static final BSSWTypes MARBLE = new BSSWTypes("marble", Blocks.STONE, MapColor.OFF_WHITE);
    public static final BSSWTypes MARBLE_BRICKS = new BSSWTypes("marble_bricks", MARBLE.block);
    public static final BSSWTypes SMALL_MARBLE_BRICKS = new BSSWTypes("small_marble_bricks", MARBLE_BRICKS.block);
    public static final BSSWTypes MARBLE_TILES = new BSSWTypes("marble_tiles", MARBLE_BRICKS.block);

    public static final BSSWTypes BLUESTONE = new BSSWTypes("bluestone", Blocks.STONE, MapColor.CYAN);
    public static final BSSWTypes BLUESTONE_BRICKS = new BSSWTypes("bluestone_bricks", BLUESTONE.block);
    public static final BSSWTypes SMALL_BLUESTONE_BRICKS = new BSSWTypes("small_bluestone_bricks", BLUESTONE_BRICKS.block);
    public static final BSSWTypes BLUESTONE_TILES = new BSSWTypes("bluestone_tiles", BLUESTONE_BRICKS.block);

    public static final BSSWTypes LAVA_BRICKS = new BSSWTypes("lava_bricks", Blocks.STONE_BRICKS, 15);
    public static final BSSWTypes LAVA_POLISHED_BLACKSTONE_BRICKS = new BSSWTypes("lava_polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS, 15);
    public static final BSSWTypes MAGMA_BRICKS = new BSSWTypes("magma_bricks", Blocks.MAGMA_BLOCK, 15);
    public static final BSSWTypes SMALL_MAGMA_BRICKS = new BSSWTypes("small_magma_bricks", Blocks.MAGMA_BLOCK, 15);
    public static final BSSWTypes BLAZE_BRICKS = new BSSWTypes("blaze_bricks", Blocks.NETHER_BRICKS, 15);

    public static final BSSWTypes WATER_BRICKS = new BSSWTypes("water_bricks", Blocks.STONE_BRICKS);
    public static final BSSWTypes NETHERRACK_BRICKS = new BSSWTypes("netherrack_bricks", Blocks.NETHERRACK);

    public static final BSSWTypes CHARRED_NETHER_BRICKS = new BSSWTypes("charred_nether_bricks", Blocks.NETHER_BRICKS, MapColor.BLACK);
    public static final BSSWTypes TEAL_NETHER_BRICKS = new BSSWTypes("teal_nether_bricks", Blocks.NETHER_BRICKS, MapColor.CYAN);

    public static final BSSWTypes OBSIDIAN_BRICKS = new BSSWTypes("obsidian_bricks", Blocks.OBSIDIAN);
    public static final BSSWTypes SMALL_OBSIDIAN_BRICKS = new BSSWTypes("small_obsidian_bricks", OBSIDIAN_BRICKS.block);

    public static final BSSWTypes QUARTZ_TILES = new BSSWTypes("quartz_tiles", Blocks.QUARTZ_BLOCK);
    public static final BSSWTypes LARGE_BRICKS = new BSSWTypes("large_bricks", Blocks.BRICKS);
    public static final BSSWTypes SOAKED_BRICKS = new BSSWTypes("soaked_bricks", Blocks.BRICKS);
    public static final BSSWTypes SANDY_BRICKS = new BSSWTypes("sandy_bricks", Blocks.BRICKS);
    public static final BSSWTypes CHARRED_BRICKS = new BSSWTypes("charred_bricks", Blocks.BRICKS);
    public static final BSSWTypes RAINBOW_BRICKS = new BSSWTypes("rainbow_bricks", Blocks.BRICKS);
    public static final BSSWTypes HONEYCOMB_BRICKS = new BSSWTypes("honeycomb_bricks", Blocks.BRICKS);

    public static final BSSWTypes SANDSTONE_BRICKS = new BSSWTypes("sandstone_bricks", Blocks.SANDSTONE);
    public static final BSSWTypes SMALL_SANDSTONE_BRICKS = new BSSWTypes("small_sandstone_bricks", Blocks.SANDSTONE);

    public static final BSSWTypes RED_SANDSTONE_BRICKS = new BSSWTypes("red_sandstone_bricks", Blocks.SANDSTONE);
    public static final BSSWTypes SMALL_RED_SANDSTONE_BRICKS = new BSSWTypes("small_red_sandstone_bricks", Blocks.SANDSTONE);

    public static final BSSWTypes SOUL_SANDSTONE = new BSSWTypes("soul_sandstone", Blocks.SANDSTONE, MapColor.BROWN);
    public static final BSSWTypes SOUL_SANDSTONE_BRICKS = new BSSWTypes("soul_sandstone_bricks", SOUL_SANDSTONE.block);
    public static final BSSWTypes SMALL_SOUL_SANDSTONE_BRICKS = new BSSWTypes("small_soul_sandstone_bricks", SOUL_SANDSTONE.block);

    public static final BSSWTypes PURPUR_BRICKS = new BSSWTypes("purpur_bricks", Blocks.PURPUR_BLOCK);
    public static final BSSWTypes SMALL_PURPUR_BRICKS = new BSSWTypes("small_purpur_bricks", Blocks.PURPUR_BLOCK);

    public static final BSSWTypes PHANTOM_PURPUR_BRICKS = new BSSWTypes("phantom_purpur_bricks", Blocks.PURPUR_BLOCK);
    public static final BSSWTypes SMALL_PHANTOM_PURPUR_BRICKS = new BSSWTypes("small_phantom_purpur_bricks", Blocks.PURPUR_BLOCK);

    public static final BSSWTypes SMALL_END_STONE_BRICKS = new BSSWTypes("small_end_stone_bricks", Blocks.END_STONE);

    public static final BSSWTypes WHITE_STONE_BRICKS = new BSSWTypes("white_stone_bricks", Blocks.STONE_BRICKS, MapColor.WHITE);
    public static final BSSWTypes ORANGE_STONE_BRICKS = new BSSWTypes("orange_stone_bricks", Blocks.STONE_BRICKS, MapColor.ORANGE);
    public static final BSSWTypes MAGENTA_STONE_BRICKS = new BSSWTypes("magenta_stone_bricks", Blocks.STONE_BRICKS, MapColor.MAGENTA);
    public static final BSSWTypes LIGHT_BLUE_STONE_BRICKS = new BSSWTypes("light_blue_stone_bricks", Blocks.STONE_BRICKS, MapColor.LIGHT_BLUE);
    public static final BSSWTypes YELLOW_STONE_BRICKS = new BSSWTypes("yellow_stone_bricks", Blocks.STONE_BRICKS, MapColor.YELLOW);
    public static final BSSWTypes LIME_STONE_BRICKS = new BSSWTypes("lime_stone_bricks", Blocks.STONE_BRICKS, MapColor.LIME);
    public static final BSSWTypes PINK_STONE_BRICKS = new BSSWTypes("pink_stone_bricks", Blocks.STONE_BRICKS, MapColor.PINK);
    public static final BSSWTypes GRAY_STONE_BRICKS = new BSSWTypes("gray_stone_bricks", Blocks.STONE_BRICKS, MapColor.GRAY);
    public static final BSSWTypes CYAN_STONE_BRICKS = new BSSWTypes("cyan_stone_bricks", Blocks.STONE_BRICKS, MapColor.CYAN);
    public static final BSSWTypes PURPLE_STONE_BRICKS = new BSSWTypes("purple_stone_bricks", Blocks.STONE_BRICKS, MapColor.PURPLE);
    public static final BSSWTypes BLUE_STONE_BRICKS = new BSSWTypes("blue_stone_bricks", Blocks.STONE_BRICKS, MapColor.BLUE);
    public static final BSSWTypes BROWN_STONE_BRICKS = new BSSWTypes("brown_stone_bricks", Blocks.STONE_BRICKS, MapColor.BROWN);
    public static final BSSWTypes GREEN_STONE_BRICKS = new BSSWTypes("green_stone_bricks", Blocks.STONE_BRICKS, MapColor.GREEN);
    public static final BSSWTypes RED_STONE_BRICKS = new BSSWTypes("red_stone_bricks", Blocks.STONE_BRICKS, MapColor.RED);
    public static final BSSWTypes BLACK_STONE_BRICKS = new BSSWTypes("black_stone_bricks", Blocks.STONE_BRICKS, MapColor.BLACK);

    public static final BSSWTypes WHITE_CONCRETE_BRICKS = new BSSWTypes("white_concrete_bricks", Blocks.WHITE_CONCRETE);
    public static final BSSWTypes ORANGE_CONCRETE_BRICKS = new BSSWTypes("orange_concrete_bricks", Blocks.ORANGE_CONCRETE);
    public static final BSSWTypes MAGENTA_CONCRETE_BRICKS = new BSSWTypes("magenta_concrete_bricks", Blocks.MAGENTA_CONCRETE);
    public static final BSSWTypes LIGHT_BLUE_CONCRETE_BRICKS = new BSSWTypes("light_blue_concrete_bricks", Blocks.LIGHT_BLUE_CONCRETE);
    public static final BSSWTypes YELLOW_CONCRETE_BRICKS = new BSSWTypes("yellow_concrete_bricks", Blocks.YELLOW_CONCRETE);
    public static final BSSWTypes LIME_CONCRETE_BRICKS = new BSSWTypes("lime_concrete_bricks", Blocks.LIME_CONCRETE);
    public static final BSSWTypes PINK_CONCRETE_BRICKS = new BSSWTypes("pink_concrete_bricks", Blocks.PINK_CONCRETE);
    public static final BSSWTypes GRAY_CONCRETE_BRICKS = new BSSWTypes("gray_concrete_bricks", Blocks.GRAY_CONCRETE);
    public static final BSSWTypes LIGHT_GRAY_CONCRETE_BRICKS = new BSSWTypes("light_gray_concrete_bricks", Blocks.LIGHT_GRAY_CONCRETE);
    public static final BSSWTypes CYAN_CONCRETE_BRICKS = new BSSWTypes("cyan_concrete_bricks", Blocks.CYAN_CONCRETE);
    public static final BSSWTypes PURPLE_CONCRETE_BRICKS = new BSSWTypes("purple_concrete_bricks", Blocks.PURPLE_CONCRETE);
    public static final BSSWTypes BLUE_CONCRETE_BRICKS = new BSSWTypes("blue_concrete_bricks", Blocks.BLUE_CONCRETE);
    public static final BSSWTypes BROWN_CONCRETE_BRICKS = new BSSWTypes("brown_concrete_bricks", Blocks.BROWN_CONCRETE);
    public static final BSSWTypes GREEN_CONCRETE_BRICKS = new BSSWTypes("green_concrete_bricks", Blocks.GREEN_CONCRETE);
    public static final BSSWTypes RED_CONCRETE_BRICKS = new BSSWTypes("red_concrete_bricks", Blocks.RED_CONCRETE);
    public static final BSSWTypes BLACK_CONCRETE_BRICKS = new BSSWTypes("black_concrete_bricks", Blocks.BLACK_CONCRETE);

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block wall;
    public final Block base;

    private BSSWTypes(String type, Block base, Block.Settings blockSettings) {
        String replace = type.replace("lava_polished_blackstone_bricks", "lava_polished_blackstone").replace("bricks", "brick").replace("tiles", "tile").replace("_block", "");

        this.base = base;

        ItemGroup group = Blockus.BLOCKUS_BUILDING_BLOCKS;
        this.block = BlocksRegistration.register(type, new Block(FabricBlockSettings.copyOf(blockSettings)), group);
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);
        this.wall = BlocksRegistration.registerWall(this.block);

        LIST.add(this);
    }

    private BSSWTypes(String type, Block base, MapColor mapcolor) {
        this(type, base, FabricBlockSettings.copyOf(base).mapColor(mapcolor));

    }

    public BSSWTypes(String type, Block base) {
        this(type, base, FabricBlockSettings.copyOf(base));

    }

    private BSSWTypes(String type, Block base, int luminance) {
        this(type, base, FabricBlockSettings.copyOf(base).luminance(luminance));

    }

    public static ArrayList<BSSWTypes> values() {
        return LIST;
    }
}
