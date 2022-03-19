package com.brand.blockus.compatibility.data.provider.columns;

import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.BlockusColumnBlocks.BlockusColumnType;

import io.github.haykam821.columns.data.provider.ColumnsModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class BlockusColumnsModelProvider extends FabricModelProvider {
    public BlockusColumnsModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {
        for (BlockusColumnType columnType : BlockusColumnBlocks.COLUMN_TYPES) {
            ColumnsModelProvider.registerColumn(modelGenerator, columnType.block, columnType.base);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        return;
    }
}
