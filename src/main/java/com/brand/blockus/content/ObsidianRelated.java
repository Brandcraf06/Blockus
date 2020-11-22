package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.Base.*;
import com.brand.blockus.blocks.Base.RequiredTool.BlockBaseRT;
import com.brand.blockus.blocks.Base.RequiredTool.PillarBaseRT;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ObsidianRelated {

    public static final BlockBaseRT OBSIDIAN_BRICKS = new BlockBaseRT("obsidian_bricks", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, Blockus.BLOCKUS_BUILDING_BLOCKS, FabricToolTags.PICKAXES, 3, MapColor.BLACK);
    public static final StairsBase OBSIDIAN_BRICKS_STAIRS = new StairsBase(OBSIDIAN_BRICKS.getDefaultState(), "obsidian_bricks_stairs", OBSIDIAN_BRICKS);
    public static final SlabBase OBSIDIAN_BRICKS_SLAB = new SlabBase("obsidian_bricks_slab", OBSIDIAN_BRICKS);
    public static final WallBase OBSIDIAN_BRICKS_WALL = new WallBase("obsidian_bricks_wall", OBSIDIAN_BRICKS);
    public static final PillarBaseRT OBSIDIAN_PILLAR = new PillarBaseRT("obsidian_pillar", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3, MapColor.BLACK);
    public static final PlayerFacingBlockBase OBSIDIAN_CIRCLE_PAVEMENT = new PlayerFacingBlockBase("obsidian_circle_pavement", 50.0F, 1200.0F, Material.STONE, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3, MapColor.BLACK);
    public static final DoorBase OBSIDIAN_REINFORCED_DOOR = new DoorBase("obsidian_reinforced_door", 50.0F, 1200.0F, Material.METAL, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3, MapColor.BLACK);
    public static final TrapdoorBase OBSIDIAN_REINFORCED_TRAPDOOR = new TrapdoorBase("obsidian_reinforced_trapdoor", 50.0F, 1200.0F, Material.METAL, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 3, MapColor.BLACK);

}
