package com.brand.blockus.compatibility.data.provider.columns;

import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.BlockusColumnBlocks.BlockusColumnType;
import io.github.haykam821.columns.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BlockusColumnsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockusColumnsBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        FabricTagBuilder columnsTag = this.getOrCreateTagBuilder(Main.COLUMNS_BLOCK_TAG);
        for (BlockusColumnType columnType : BlockusColumnBlocks.COLUMN_TYPES) {
            columnsTag.addOptional(columnType.id);
        }
    }
}
