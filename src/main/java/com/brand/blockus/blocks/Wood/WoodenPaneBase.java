package com.brand.blockus.blocks.Wood;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WoodenPaneBase extends PaneBlock {

    public WoodenPaneBase(String name, float hardness, float resistance, Material material, BlockSoundGroup sound) {
        super(FabricBlockSettings.of(material, Blocks.DARK_OAK_LOG.getDefaultMapColor()).sounds(sound).breakByTool(FabricToolTags.AXES, 0).strength(hardness, resistance).nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_DECORATIONS)));
    }

}
