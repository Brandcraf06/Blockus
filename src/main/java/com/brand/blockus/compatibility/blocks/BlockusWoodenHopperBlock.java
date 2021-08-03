package com.brand.blockus.compatibility.blocks;

import io.github.haykam821.woodenhoppers.block.WoodenHopperBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class BlockusWoodenHopperBlock extends WoodenHopperBlock {
    public BlockusWoodenHopperBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new BlockusWoodenHopperBlockEntity();
    }
}
