package com.brand.blockus.blocks.Base;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PaneBase extends PaneBlock {

    public PaneBase(String name, float hardness, float resistance, Material material, BlockSoundGroup sound) {
        super(FabricBlockSettings.of(material, MaterialColor.CLEAR).sounds(sound).requiresTool().strength(hardness, resistance).nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_DECORATIONS)));
    }

}
