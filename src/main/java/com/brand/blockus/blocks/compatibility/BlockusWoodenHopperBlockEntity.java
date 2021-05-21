package com.brand.blockus.blocks.compatibility;

import com.brand.blockus.content.compatibility.BlockusWoodenHopperBlocks;

import io.github.haykam821.woodenhoppers.block.entity.WoodenHopperBlockEntity;
import net.minecraft.block.entity.BlockEntityType;

public class BlockusWoodenHopperBlockEntity extends WoodenHopperBlockEntity {
    @Override
    public BlockEntityType<?> getType() {
        return BlockusWoodenHopperBlocks.BLOCK_ENTITY_TYPE;
    }
}
