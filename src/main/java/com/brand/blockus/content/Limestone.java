package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.*;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class Limestone {

    public static final BlockBase LIMESTONE = new BlockBase("limestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.WOOD);
    public static final StairsBase LIMESTONE_STAIRS = new StairsBase(LIMESTONE.getDefaultState(), "limestone_stairs", LIMESTONE);
    public static final SlabBase LIMESTONE_SLAB = new SlabBase("limestone_slab", LIMESTONE);
    public static final BlockBase LIMESTONE_BRICKS = new BlockBase("limestone_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.WOOD);
    public static final StairsBase LIMESTONE_BRICKS_STAIRS = new StairsBase(LIMESTONE_BRICKS.getDefaultState(), "limestone_bricks_stairs", LIMESTONE_BRICKS);
    public static final SlabBase LIMESTONE_BRICKS_SLAB = new SlabBase("limestone_bricks_slab", LIMESTONE_BRICKS);
    public static final WallBase LIMESTONE_BRICKS_WALL = new WallBase("limestone_bricks_wall", LIMESTONE_BRICKS);
    public static final PillarBase LIMESTONE_PILLAR = new PillarBase("limestone_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.WOOD);
    public static final BlockBase CHISELED_LIMESTONE = new BlockBase("chiseled_limestone", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.WOOD);
    public static final GlazedLikeBlockBase LIMESTONE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("limestone_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.WOOD);

}
