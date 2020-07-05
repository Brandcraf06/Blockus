package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class HoneycombBricks {

    public static final BlockBase HONEYCOMB_BRICKS = new BlockBase("honeycomb_bricks", 0.6f, 1.0f, Material.ORGANIC_PRODUCT, BlockSoundGroup.CORAL, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.ORANGE);
    public static final WallBase HONEYCOMB_BRICKS_WALL = new WallBase("honeycomb_bricks_wall", HONEYCOMB_BRICKS);
    public static final StairsBase HONEYCOMB_BRICKS_STAIRS = new StairsBase(HONEYCOMB_BRICKS.getDefaultState(), "honeycomb_bricks_stairs", HONEYCOMB_BRICKS);
    public static final SlabBase HONEYCOMB_BRICKS_SLAB = new SlabBase("honeycomb_bricks_slab", HONEYCOMB_BRICKS);


}
