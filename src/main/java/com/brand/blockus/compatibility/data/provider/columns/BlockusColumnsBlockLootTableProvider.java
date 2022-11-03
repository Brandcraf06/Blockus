package com.brand.blockus.compatibility.data.provider.columns;

import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.BlockusColumnBlocks.BlockusColumnType;
import com.brand.blockus.data.BlockusDatagen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class BlockusColumnsBlockLootTableProvider extends FabricBlockLootTableProvider {
    public BlockusColumnsBlockLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        for (BlockusColumnType columnType : BlockusColumnBlocks.COLUMN_TYPES) {
            this.addDrop(columnType.block);
        }
    }

    @Override
    public void accept(BiConsumer<Identifier, Builder> exporter) {
        super.accept(this.withConditions(exporter, BlockusDatagen.getLoadCondition("columns")));
    }
}
