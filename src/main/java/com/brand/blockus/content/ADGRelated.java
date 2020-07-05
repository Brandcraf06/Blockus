package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.*;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class ADGRelated {

    // andesite
    public static final BlockBase ANDESITE_BRICKS = new BlockBase("andesite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
    public static final StairsBase ANDESITE_BRICKS_STAIRS = new StairsBase(ADGRelated.ANDESITE_BRICKS.getDefaultState(), "andesite_bricks_stairs", ANDESITE_BRICKS);
    public static final SlabBase ANDESITE_BRICKS_SLAB = new SlabBase("andesite_bricks_slab", ANDESITE_BRICKS);
    public static final BlockBase ZIGZAGGED_ANDESITE = new BlockBase("zigzagged_andesite", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
    public static final GlazedLikeBlockBase ANDESITE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("andesite_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.STONE);
    public static final PillarBase POLISHED_ANDESITE_PILLAR = new PillarBase("polished_andesite_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.STONE);
    public static final BlockBase CHISELED_ANDESITE_BRICKS = new BlockBase("chiseled_andesite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
    public static final BlockBase CRACKED_ANDESITE_BRICKS = new BlockBase("cracked_andesite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);

    // diorite
    public static final BlockBase DIORITE_BRICKS = new BlockBase("diorite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final StairsBase DIORITE_BRICKS_STAIRS = new StairsBase(ADGRelated.DIORITE_BRICKS.getDefaultState(), "diorite_bricks_stairs", DIORITE_BRICKS);
    public static final SlabBase DIORITE_BRICKS_SLAB = new SlabBase("diorite_bricks_slab", DIORITE_BRICKS);
    public static final BlockBase ZIGZAGGED_DIORITE = new BlockBase("zigzagged_diorite", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final GlazedLikeBlockBase DIORITE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("diorite_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.QUARTZ);
    public static final PillarBase POLISHED_DIORITE_PILLAR = new PillarBase("polished_diorite_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.QUARTZ);
    public static final BlockBase CHISELED_DIORITE_BRICKS = new BlockBase("chiseled_diorite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final BlockBase CRACKED_DIORITE_BRICKS = new BlockBase("cracked_diorite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);

    // granite
    public static final BlockBase GRANITE_BRICKS = new BlockBase("granite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.DIRT);
    public static final StairsBase GRANITE_BRICKS_STAIRS = new StairsBase(ADGRelated.GRANITE_BRICKS.getDefaultState(), "granite_bricks_stairs", GRANITE_BRICKS);
    public static final SlabBase GRANITE_BRICKS_SLAB = new SlabBase("granite_bricks_slab", GRANITE_BRICKS);
    public static final BlockBase ZIGZAGGED_GRANITE = new BlockBase("zigzagged_granite", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.DIRT);
    public static final GlazedLikeBlockBase GRANITE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("granite_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.DIRT);
    public static final PillarBase POLISHED_GRANITE_PILLAR = new PillarBase("polished_granite_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.DIRT);
    public static final BlockBase CHISELED_GRANITE_BRICKS = new BlockBase("chiseled_granite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.DIRT);
    public static final BlockBase CRACKED_GRANITE_BRICKS = new BlockBase("cracked_granite_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.DIRT);
}