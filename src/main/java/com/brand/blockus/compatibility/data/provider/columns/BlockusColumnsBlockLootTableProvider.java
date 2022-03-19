package com.brand.blockus.compatibility.data.provider.columns;

import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.BlockusColumnBlocks.BlockusColumnType;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class BlockusColumnsBlockLootTableProvider extends FabricBlockLootTableProvider {
    public BlockusColumnsBlockLootTableProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        for (BlockusColumnType columnType : BlockusColumnBlocks.COLUMN_TYPES) {
            this.addDrop(columnType.block);
        }
    }

    
}
