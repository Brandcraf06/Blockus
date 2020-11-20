package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.BetterTool.BlockBaseHand;
import com.brand.blockus.blocks.Base.DoorBase;
import com.brand.blockus.blocks.Base.TrapdoorBase;
import com.brand.blockus.blocks.Paper.PaperLight;
import com.brand.blockus.blocks.Wood.WoodenPaneBase;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class PaperRelated {

    public static final BlockBaseHand PAPER_BLOCK = new BlockBaseHand("paper_block", 0.1f, 0.8f, Material.WOOL, BlockSoundGroup.GRASS, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.QUARTZ);
    public static final BlockBaseHand BURNED_PAPER_BLOCK = new BlockBaseHand("burned_paper_block", 0.1f, 0.8f, Material.WOOL, BlockSoundGroup.GRASS, Blockus.BLOCKUS_BUILDING_BLOCKS, MaterialColor.STONE);
    public static final WoodenPaneBase PAPER_WALL = new WoodenPaneBase("paper_wall", 0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD);
    public static final DoorBase PAPER_DOOR = new DoorBase("paper_door", 0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, MaterialColor.QUARTZ);
    public static final TrapdoorBase PAPER_TRAPDOOR = new TrapdoorBase("paper_trapdoor", 0.1f, 0.8f, Material.WOOD, BlockSoundGroup.WOOD, FabricToolTags.AXES, 0, MaterialColor.QUARTZ);
    public static final PaperLight PAPER_LAMP = new PaperLight("paper_lamp", 0.1f, 0.8f);

}
