package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.*;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class Marble {

    public static final BlockBase MARBLE = new BlockBase("marble", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final StairsBase MARBLE_STAIRS = new StairsBase(MARBLE.getDefaultState(), "marble_stairs", MARBLE);
    public static final SlabBase MARBLE_SLAB = new SlabBase("marble_slab", MARBLE);
    public static final BlockBase MARBLE_BRICKS = new BlockBase("marble_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final StairsBase MARBLE_BRICKS_STAIRS = new StairsBase(MARBLE_BRICKS.getDefaultState(), "marble_bricks_stairs", MARBLE_BRICKS);
    public static final SlabBase MARBLE_BRICKS_SLAB = new SlabBase("marble_bricks_slab", MARBLE_BRICKS);
    public static final WallBase MARBLE_BRICKS_WALL = new WallBase("marble_bricks_wall", MARBLE_BRICKS);
    public static final PillarBase MARBLE_PILLAR = new PillarBase("marble_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.QUARTZ);
    public static final PillarBase CHISELED_MARBLE_PILLAR = new PillarBase("chiseled_marble_pillar", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, MaterialColor.QUARTZ);
    public static final BlockBase CHISELED_MARBLE = new BlockBase("chiseled_marble", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final GlazedLikeBlockBase MARBLE_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("marble_circle_pavement", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.QUARTZ);

}
