package com.brand.blockus.data;

import com.brand.blockus.data.providers.*;
import com.brand.blockus.modcompat.promenade.data.providers.BlockusPromenadeBlockLootTableProvider;
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
        pack.addProvider(BlockusModelProvider::new);
        pack.addProvider(BlockusPromenadeBlockLootTableProvider::new);
    }

    public static ConditionJsonProvider getLoadCondition(String... modIds) {
        return DefaultResourceConditions.allModsLoaded(modIds);
    }
}
