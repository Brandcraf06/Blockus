package com.brand.blockus.compatibility.blocks;

import com.brand.blockus.compatibility.content.BlockusWoodenHopperBlocks;
import io.github.haykam821.woodenhoppers.block.entity.WoodenHopperBlockEntity;
import net.minecraft.block.entity.BlockEntityType;

public class BlockusWoodenHopperBlockEntity extends WoodenHopperBlockEntity {
    @Override
    public BlockEntityType<?> getType() {
        return BlockusWoodenHopperBlocks.BLOCK_ENTITY_TYPE;
    }
}
