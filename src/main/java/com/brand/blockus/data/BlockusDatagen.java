package com.brand.blockus.data;

import com.brand.blockus.data.generators.*;
import com.brand.blockus.worldgen.BlockusWorldgenProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;

public class BlockusDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {

        final FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(BlockusRecipeGenerator::new);

        BlockusBlockTagGenerator blockTags = pack.addProvider(BlockusBlockTagGenerator::new);
        pack.addProvider((output, registries) -> new BlockusItemTagGenerator(output, registries, blockTags));


        pack.addProvider(BlockusBlockLootTableGenerator::new);
        pack.addProvider(BlockusWorldgenProvider::new);
        pack.addProvider(BlockusModelGenerator::new);

//        pack.addProvider(BlockusPromenadeBlockLootTableGenerator::new);
    }

    public static ConditionJsonProvider getLoadCondition(String... modIds) {
        return DefaultResourceConditions.allModsLoaded(modIds);
    }
}
