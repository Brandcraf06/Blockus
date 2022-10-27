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

        final FabricDataGenerator.Pack pack = dataGenerator.create();
        pack.addProvider(BlockusRecipeProvider::new);

        BlockusBlockTagProvider blockTags = pack.addProvider(BlockusBlockTagProvider::new);
        pack.addProvider((FabricDataGenerator.Pack.Factory<BlockusItemTagProvider>) output -> new BlockusItemTagProvider(output, blockTags));

        pack.addProvider(BlockusBlockLootTableProvider::new);
        pack.addProvider(FabricBuiltinRegistriesProvider.forCurrentMod());


//        pack.addProvider(BlockusColumnsBlockLootTableProvider::new);
//        pack.addProvider(BlockusColumnsModelProvider::new);
//        pack.addProvider(BlockusColumnsRecipeProvider::new);

//        BlockusColumnsBlockTagProvider columnsBlockTags = pack.addProvider(BlockusColumnsBlockTagProvider::new);
//        pack.addProvider((FabricDataGenerator.Pack.Factory<BlockusColumnsItemTagProvider>) output -> new BlockusColumnsItemTagProvider(output, columnsBlockTags));
    }

    public static ConditionJsonProvider getLoadCondition(String... modIds) {
        return DefaultResourceConditions.allModsLoaded(modIds);
    }
}
