package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BlockBase;
import com.brand.blockus.blocks.Base.PlayerFacingBlockBase;
import com.brand.blockus.blocks.Base.SlabBase;
import com.brand.blockus.blocks.Base.StairsBase;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;


public class NetherrackRelated {

    public static final BlockBase POLISHED_NETHERRACK = new BlockBase("polished_netherrack", 0.4f, 0.4f, Material.STONE, BlockSoundGroup.NETHERRACK, Blockus.BLOCKUS_BUILDING_BLOCKS, MapColor.NETHER);
    public static final StairsBase POLISHED_NETHERRACK_STAIRS = new StairsBase(POLISHED_NETHERRACK.getDefaultState(), "polished_netherrack_stairs", POLISHED_NETHERRACK);
    public static final SlabBase POLISHED_NETHERRACK_SLAB = new SlabBase("polished_netherrack_slab", POLISHED_NETHERRACK);
    public static final PlayerFacingBlockBase NETHERRACK_CIRCLE_PAVEMENT = new PlayerFacingBlockBase("netherrack_circle_pavement", 1.0f, 0.4f, Material.STONE, BlockSoundGroup.NETHERRACK, FabricToolTags.PICKAXES, 0, MapColor.NETHER);

}