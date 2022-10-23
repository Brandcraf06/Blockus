package com.brand.blockus.data;

import com.brand.blockus.data.provider.*;
import com.brand.blockus.compatibility.data.provider.columns.BlockusColumnsBlockLootTableProvider;
import com.brand.blockus.compatibility.data.provider.columns.BlockusColumnsBlockTagProvider;
import com.brand.blockus.compatibility.data.provider.columns.BlockusColumnsItemTagProvider;
import com.brand.blockus.compatibility.data.provider.columns.BlockusColumnsModelProvider;
import com.brand.blockus.compatibility.data.provider.columns.BlockusColumnsRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBuiltinRegistriesProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.server.QueueingWorldGenerationProgressListener;

public class BlockusDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        dataGenerator.addProvider(BlockusRecipeProvider::new);
        FabricTagProvider.BlockTagProvider blockTags = new BlockusBlockTagProvider(dataGenerator);
        dataGenerator.addProvider(blockTags);

        dataGenerator.addProvider(new BlockusItemTagProvider(dataGenerator, blockTags));

        dataGenerator.addProvider(BlockusBlockLootTableProvider::new);
        dataGenerator.addProvider(FabricBuiltinRegistriesProvider.forCurrentMod());


        dataGenerator.addProvider(BlockusColumnsBlockLootTableProvider::new);
        dataGenerator.addProvider(BlockusColumnsModelProvider::new);
        dataGenerator.addProvider(BlockusColumnsRecipeProvider::new);

        FabricTagProvider.BlockTagProvider columnsBlockTags = new BlockusColumnsBlockTagProvider(dataGenerator);
        dataGenerator.addProvider(columnsBlockTags);
        dataGenerator.addProvider(new BlockusColumnsItemTagProvider(dataGenerator, columnsBlockTags));
    }

    public static ConditionJsonProvider getLoadCondition(String... modIds) {
        return DefaultResourceConditions.allModsLoaded(modIds);
    }
}
