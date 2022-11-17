package com.brand.blockus.compatibility.data.provider.columns;

import io.github.haykam821.columns.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BlockusColumnsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public BlockusColumnsItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, BlockTagProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        this.copy(Main.COLUMNS_BLOCK_TAG, Main.COLUMNS_ITEM_TAG);
    }
}
