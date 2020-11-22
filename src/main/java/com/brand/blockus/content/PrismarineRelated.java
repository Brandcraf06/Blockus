package com.brand.blockus.content;


import com.brand.blockus.blocks.Base.PlayerFacingBlockBase;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class PrismarineRelated {

    public static final PlayerFacingBlockBase PRISMARINE_CIRCLE_PAVEMENT = new PlayerFacingBlockBase("prismarine_circle_pavement", 1.5f, 1.2f, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 0, MapColor.DIAMOND);

}
