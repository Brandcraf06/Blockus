package com.brand.blockus.blocks.Leaves;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LegacyLeavesBlock extends Block {

    public static boolean translucentLeaves;

    public LegacyLeavesBlock(String name, float hardness, float resistance) {
        super(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.SHEARS, 0).strength(hardness, resistance).nonOpaque()
                .allowsSpawning(Blockus::nothing).suffocates(Blockus::never).blockVision(Blockus::never));
        Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));

    }

}
