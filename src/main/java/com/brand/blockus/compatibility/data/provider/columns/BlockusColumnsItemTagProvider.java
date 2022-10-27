package com.brand.blockus.compatibility.data.provider.columns;

import io.github.haykam821.columns.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class BlockusColumnsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public BlockusColumnsItemTagProvider(FabricDataOutput output, BlockTagProvider blockTagProvider) {
        super(output, blockTagProvider);
    }

    @Override
    protected void generateTags() {
        this.copy(Main.COLUMNS_BLOCK_TAG, Main.COLUMNS_ITEM_TAG);
    }
}
