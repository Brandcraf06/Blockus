package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.GlazedLikeBlockBase;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class QuartzRelated {

    public static final BlockBase QUARTZ_BRICKS = new BlockBase("quartz_bricks", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final GlazedLikeBlockBase QUARTZ_CIRCLE_PAVEMENT = new GlazedLikeBlockBase("quartz_circle_pavement", 0.8f, 0.8f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MaterialColor.QUARTZ);

}
