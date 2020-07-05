package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class WaterBricks {

    public static final BlockBase WATER_BRICKS = new BlockBase("water_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
    public static final WallBase WATER_BRICKS_WALL = new WallBase("water_bricks_wall", WATER_BRICKS);
    public static final StairsBase WATER_BRICKS_STAIRS = new StairsBase(WATER_BRICKS.getDefaultState(), "water_bricks_stairs", WATER_BRICKS);
    public static final SlabBase WATER_BRICKS_SLAB = new SlabBase("water_bricks_slab", WATER_BRICKS);
    public static final BlockBase CHISELED_WATER_BRICKS = new BlockBase("chiseled_water_bricks", 1.5f, 6.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);


}
