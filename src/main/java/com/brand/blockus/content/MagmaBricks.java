package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import com.brand.blockus.blocks.Base.WallBase;
import com.brand.blockus.blocks.Light.LightBlockBase;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class MagmaBricks {

    public static LightBlockBase MAGMA_BRICKS = new LightBlockBase("magma_bricks", 0.5f, 1.0f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, 15, MaterialColor.NETHER);
    public static WallBase MAGMA_BRICKS_WALL = new WallBase("magma_bricks_wall", MAGMA_BRICKS);
    public static StairsBase MAGMA_BRICKS_STAIRS = new StairsBase(MAGMA_BRICKS.getDefaultState(), "magma_bricks_stairs", MAGMA_BRICKS);
    public static SlabBase MAGMA_BRICKS_SLAB = new SlabBase("magma_bricks_slab", MAGMA_BRICKS);

}
