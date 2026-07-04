package com.brand.blockus.datagen;

import com.brand.blockus.datagen.providers.*;
import com.brand.blockus.worldgen.BlockusWorldgenProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class BlockusDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {

        final FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(BlockusRecipeProvider::new);
        pack.addProvider(VanillaRecipeOverride::new);

        BlockusBlockTagProvider blockTags = pack.addProvider(BlockusBlockTagProvider::new);
        pack.addProvider((output, registries) -> new BlockusItemTagProvider(output, registries, blockTags));

        pack.addProvider(BlockusBlockLootTableProvider::new);
        pack.addProvider(BlockusWorldgenProvider::new);
        pack.addProvider(BlockusLangEnProvider::new);
        pack.addProvider(BlockusModelProvider::new);
//        pack.addProvider(BlockusPromenadeBlockLootTableProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, BlockusWorldgenProvider::bootstrapConfiguredFeatures);
        registryBuilder.add(Registries.PLACED_FEATURE, BlockusWorldgenProvider::bootstrapPlacedFeatures);
    }

    public static ResourceCondition getLoadCondition(String... modIds) {
        return ResourceConditions.allModsLoaded(modIds);
    }
}
