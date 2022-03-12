package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSTypes {
    private static final ArrayList<BSSTypes> LIST = new ArrayList<>();

    public static final BSSTypes POLISHED_DRIPSTONE = new BSSTypes("polished_dripstone", Blocks.DRIPSTONE_BLOCK);
    public static final BSSTypes POLISHED_TUFF = new BSSTypes("polished_tuff", Blocks.TUFF);
    public static final BSSTypes ROUGH_BASALT = new BSSTypes("rough_basalt", Blocks.BASALT);

    public static final BSSTypes POLISHED_LIMESTONE = new BSSTypes("polished_limestone", BSSWTypes.LIMESTONE.block);
    public static final BSSTypes POLISHED_MARBLE = new BSSTypes("polished_marble", BSSWTypes.MARBLE.block);
    public static final BSSTypes POLISHED_BLUESTONE = new BSSTypes("polished_bluestone", BSSWTypes.BLUESTONE.block);
    public static final BSSTypes POLISHED_NETHERRACK = new BSSTypes("polished_netherrack", Blocks.NETHERRACK);

    public static final BSSTypes ROUGH_SANDSTONE = new BSSTypes("rough_sandstone", Blocks.SANDSTONE);
    public static final BSSTypes ROUGH_RED_SANDSTONE = new BSSTypes("rough_red_sandstone", Blocks.SANDSTONE);
    public static final BSSTypes ROUGH_SOUL_SANDSTONE = new BSSTypes("rough_soul_sandstone", BSSWTypes.SOUL_SANDSTONE.block);
    public static final BSSTypes SMOOTH_SOUL_SANDSTONE = new BSSTypes("smooth_soul_sandstone", BSSWTypes.SOUL_SANDSTONE.block);


    public static final BSSTypes POLISHED_PURPUR = new BSSTypes("polished_purpur", Blocks.PURPUR_BLOCK);
    public static final BSSTypes PHANTOM_PURPUR_BLOCK = new BSSTypes("phantom_purpur_block", Blocks.PURPUR_BLOCK);
    public static final BSSTypes POLISHED_PHANTOM_PURPUR = new BSSTypes("polished_phantom_purpur", Blocks.PURPUR_BLOCK);

    public static final BSSTypes POLISHED_END_STONE = new BSSTypes("polished_end_stone", Blocks.END_STONE);

    public static final BSSTypes SHINGLES = new BSSTypes("shingles", Blocks.TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes WHITE_SHINGLES = new BSSTypes("white_shingles", Blocks.WHITE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes ORANGE_SHINGLES = new BSSTypes("orange_shingles", Blocks.ORANGE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes MAGENTA_SHINGLES = new BSSTypes("magenta_shingles", Blocks.MAGENTA_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes LIGHT_BLUE_SHINGLES = new BSSTypes("light_blue_shingles", Blocks.LIGHT_BLUE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes YELLOW_SHINGLES = new BSSTypes("yellow_shingles", Blocks.YELLOW_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes LIME_SHINGLES = new BSSTypes("lime_shingles", Blocks.LIME_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes PINK_SHINGLES = new BSSTypes("pink_shingles", Blocks.PINK_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes LIGHT_GRAY_SHINGLES = new BSSTypes("light_gray_shingles", Blocks.LIGHT_GRAY_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes GRAY_SHINGLES = new BSSTypes("gray_shingles", Blocks.GRAY_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes CYAN_SHINGLES = new BSSTypes("cyan_shingles", Blocks.CYAN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes PURPLE_SHINGLES = new BSSTypes("purple_shingles", Blocks.PURPLE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes BLUE_SHINGLES = new BSSTypes("blue_shingles", Blocks.BLUE_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes BROWN_SHINGLES = new BSSTypes("brown_shingles", Blocks.BROWN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes GREEN_SHINGLES = new BSSTypes("green_shingles", Blocks.GREEN_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes RED_SHINGLES = new BSSTypes("red_shingles", Blocks.RED_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);
    public static final BSSTypes BLACK_SHINGLES = new BSSTypes("black_shingles", Blocks.BLACK_TERRACOTTA, BlockSoundGroup.NETHER_BRICKS);

    public static final BSSTypes THATCH = new BSSTypes("thatch", Blocks.HAY_BLOCK);
    public static final BSSTypes IRON_PLATING = new BSSTypes("iron_plating", Blocks.IRON_BLOCK, MapColor.STONE_GRAY);
    public static final BSSTypes GOLD_PLATING = new BSSTypes("gold_plating", Blocks.GOLD_BLOCK);

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block base;

    private BSSTypes(String type, Block base, Block.Settings blockSettings) {

        this.base = base;

        ItemGroup group = Blockus.BLOCKUS_BUILDING_BLOCKS;
        this.block = BlocksRegistration.register(type, new Block(FabricBlockSettings.copyOf(blockSettings)), group);
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);

        LIST.add(this);
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

    public static ArrayList<BSSTypes> values() {
        return LIST;
    }
}
