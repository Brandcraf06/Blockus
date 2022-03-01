package com.brand.blockus.data;

import com.brand.blockus.data.provider.BlockusBlockLootTableProvider;
import com.brand.blockus.data.provider.BlockusBlockTagProvider;
import com.brand.blockus.data.provider.BlockusItemTagProvider;
import com.brand.blockus.data.provider.BlockusRecipesProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class BlockusDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        dataGenerator.addProvider(BlockusRecipesProvider::new);
        FabricTagProvider.BlockTagProvider blockTags = new BlockusBlockTagProvider(dataGenerator);
        dataGenerator.addProvider(blockTags);

        dataGenerator.addProvider(new BlockusItemTagProvider(dataGenerator, blockTags));

        dataGenerator.addProvider(BlockusBlockLootTableProvider::new);

    }
}
