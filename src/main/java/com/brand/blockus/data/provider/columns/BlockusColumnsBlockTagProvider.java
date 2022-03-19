package com.brand.blockus.data.provider.columns;

import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.BlockusColumnBlocks.BlockusColumnType;

import io.github.haykam821.columns.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;

public class BlockusColumnsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockusColumnsBlockTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        FabricTagBuilder<Block> columnsTag = this.getOrCreateTagBuilder(Main.COLUMNS_BLOCK_TAG);
        for (BlockusColumnType columnType : BlockusColumnBlocks.COLUMN_TYPES) {
            columnsTag.addOptional(columnType.id);
        }
    }
}
