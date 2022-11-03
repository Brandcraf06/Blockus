package com.brand.blockus.data;

import com.brand.blockus.data.provider.BlockusBlockLootTableProvider;
import com.brand.blockus.data.provider.BlockusBlockTagProvider;
import com.brand.blockus.data.provider.BlockusItemTagProvider;
import com.brand.blockus.data.provider.BlockusRecipeProvider;
import com.brand.blockus.worldgen.BlockusWorldgenProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;

public class BlockusDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {

        final FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(BlockusRecipeProvider::new);

        BlockusBlockTagProvider blockTags = pack.addProvider(BlockusBlockTagProvider::new);
        pack.addProvider((output, registries) -> new BlockusItemTagProvider(output, registries, blockTags));


        pack.addProvider(BlockusBlockLootTableProvider::new);
        pack.addProvider(BlockusWorldgenProvider::new);


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
