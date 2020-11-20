package com.brand.blockus.blocks.Light;


import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LightBlockBase extends Block {

    public LightBlockBase(String name, float hardness, float resistance, Material material, BlockSoundGroup sound, ItemGroup itemgroup, int luminance, MapColor color) {
        super(FabricBlockSettings.of(material, color).sounds(sound).luminance(luminance).requiresTool().strength(hardness, resistance));
        Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(itemgroup)));
    }

}
