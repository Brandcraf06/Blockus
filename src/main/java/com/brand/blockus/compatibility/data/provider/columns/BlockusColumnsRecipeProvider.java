package com.brand.blockus.compatibility.data.provider.columns;

import java.util.function.Consumer;

import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.BlockusColumnBlocks.BlockusColumnType;
import com.brand.blockus.data.BlockusDatagen;

import io.github.haykam821.columns.data.provider.ColumnsRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

public class BlockusColumnsRecipeProvider extends FabricRecipeProvider {
    public BlockusColumnsRecipeProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        Consumer<RecipeJsonProvider> columnsExporter = this.withConditions(exporter, BlockusDatagen.getLoadCondition("columns"));
        for (BlockusColumnType columnType : BlockusColumnBlocks.COLUMN_TYPES) {
            ColumnsRecipeProvider.offerColumnRecipe(columnsExporter, columnType.block, columnType.base);
            ColumnsRecipeProvider.offerColumnStonecuttingRecipe(columnsExporter, columnType.block, columnType.base);
        }
    }
}
