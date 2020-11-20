package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.*;
import com.brand.blockus.blocks.SturdyStoneBlock;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class StonesRelated {

    // stone
    public static final StairsBase SMOOTH_STONE_STAIRS = new StairsBase(Blocks.SMOOTH_STONE.getDefaultState(), "smooth_stone_stairs", Blocks.SMOOTH_STONE);
    public static final PillarBase STONE_BRICKS_PILLAR = new PillarBase("stone_bricks_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.STONE);
    public static final DoorBase STONE_DOOR = new DoorBase("stone_door", 1.5f, 20.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.STONE);
    public static final TrapdoorBase STONE_TRAPDOOR = new TrapdoorBase("stone_trapdoor", 1.5f, 20.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.STONE);
    public static final BlockBase ZIGZAGGED_STONE_BRICKS = new BlockBase("zigzagged_stone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
    public static final GlazedLikeBlockBase STONE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("stone_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.STONE);

    // andesite
    public static final BlockBase ANDESITE_BRICKS = new BlockBase("andesite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
    public static final StairsBase ANDESITE_BRICKS_STAIRS = new StairsBase(StonesRelated.ANDESITE_BRICKS.getDefaultState(), "andesite_bricks_stairs", ANDESITE_BRICKS);
    public static final SlabBase ANDESITE_BRICKS_SLAB = new SlabBase("andesite_bricks_slab", ANDESITE_BRICKS);
    public static final BlockBase ZIGZAGGED_ANDESITE = new BlockBase("zigzagged_andesite", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
    public static final GlazedLikeBlockBase ANDESITE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("andesite_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.STONE);
    public static final PillarBase POLISHED_ANDESITE_PILLAR = new PillarBase("polished_andesite_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.STONE);
    public static final BlockBase CHISELED_ANDESITE_BRICKS = new BlockBase("chiseled_andesite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
    public static final BlockBase CRACKED_ANDESITE_BRICKS = new BlockBase("cracked_andesite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);

    // diorite
    public static final BlockBase DIORITE_BRICKS = new BlockBase("diorite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final StairsBase DIORITE_BRICKS_STAIRS = new StairsBase(StonesRelated.DIORITE_BRICKS.getDefaultState(), "diorite_bricks_stairs", DIORITE_BRICKS);
    public static final SlabBase DIORITE_BRICKS_SLAB = new SlabBase("diorite_bricks_slab", DIORITE_BRICKS);
    public static final BlockBase ZIGZAGGED_DIORITE = new BlockBase("zigzagged_diorite", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final GlazedLikeBlockBase DIORITE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("diorite_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.QUARTZ);
    public static final PillarBase POLISHED_DIORITE_PILLAR = new PillarBase("polished_diorite_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.QUARTZ);
    public static final BlockBase CHISELED_DIORITE_BRICKS = new BlockBase("chiseled_diorite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final BlockBase CRACKED_DIORITE_BRICKS = new BlockBase("cracked_diorite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);

    // granite
    public static final BlockBase GRANITE_BRICKS = new BlockBase("granite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.DIRT);
    public static final StairsBase GRANITE_BRICKS_STAIRS = new StairsBase(StonesRelated.GRANITE_BRICKS.getDefaultState(), "granite_bricks_stairs", GRANITE_BRICKS);
    public static final SlabBase GRANITE_BRICKS_SLAB = new SlabBase("granite_bricks_slab", GRANITE_BRICKS);
    public static final BlockBase ZIGZAGGED_GRANITE = new BlockBase("zigzagged_granite", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.DIRT);
    public static final GlazedLikeBlockBase GRANITE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("granite_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.DIRT);
    public static final PillarBase POLISHED_GRANITE_PILLAR = new PillarBase("polished_granite_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.DIRT);
    public static final BlockBase CHISELED_GRANITE_BRICKS = new BlockBase("chiseled_granite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.DIRT);
    public static final BlockBase CRACKED_GRANITE_BRICKS = new BlockBase("cracked_granite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.DIRT);

    // blackstone
    public static final PillarBase POLISHED_BLACKSTONE_PILLAR = new PillarBase("polished_blackstone_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.BLACK);
    public static final BlockBase ZIGZAGGED_POLISHED_BLACKSTONE = new BlockBase("zigzagged_polished_blackstone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BLACK);
    public static final GlazedLikeBlockBase POLISHED_BLACKSTONE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("polished_blackstone_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.BLACK);

    public static final BlockBase CRIMSON_WARTY_BLACKSTONE_BRICKS = new BlockBase("crimson_warty_blackstone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BLACK);
    public static final WallBase CRIMSON_WARTY_BLACKSTONE_BRICKS_WALL = new WallBase("crimson_warty_blackstone_bricks_wall", CRIMSON_WARTY_BLACKSTONE_BRICKS);
    public static final StairsBase CRIMSON_WARTY_BLACKSTONE_BRICKS_STAIRS = new StairsBase(CRIMSON_WARTY_BLACKSTONE_BRICKS.getDefaultState(), "crimson_warty_blackstone_bricks_stairs", CRIMSON_WARTY_BLACKSTONE_BRICKS);
    public static final SlabBase CRIMSON_WARTY_BLACKSTONE_BRICKS_SLAB = new SlabBase("crimson_warty_blackstone_bricks_slab", CRIMSON_WARTY_BLACKSTONE_BRICKS);

    public static final BlockBase WARPED_WARTY_BLACKSTONE_BRICKS = new BlockBase("warped_warty_blackstone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.BLACK);
    public static final WallBase WARPED_WARTY_BLACKSTONE_BRICKS_WALL = new WallBase("warped_warty_blackstone_bricks_wall", WARPED_WARTY_BLACKSTONE_BRICKS);
    public static final StairsBase WARPED_WARTY_BLACKSTONE_BRICKS_STAIRS = new StairsBase(WARPED_WARTY_BLACKSTONE_BRICKS.getDefaultState(), "warped_warty_blackstone_bricks_stairs", WARPED_WARTY_BLACKSTONE_BRICKS);
    public static final SlabBase WARPED_WARTY_BLACKSTONE_BRICKS_SLAB = new SlabBase("warped_warty_blackstone_bricks_slab", WARPED_WARTY_BLACKSTONE_BRICKS);

    // sturdy stone
    public static final SturdyStoneBlock STURDY_STONE = new SturdyStoneBlock("sturdy_stone");
}