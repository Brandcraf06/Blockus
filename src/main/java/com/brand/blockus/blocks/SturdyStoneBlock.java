package com.brand.blockus.blocks;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SturdyStoneBlock extends Block {
    public SturdyStoneBlock(String name) {
        super(FabricBlockSettings.copy(Blocks.STONE));
        Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.BLOCK;
    }
}