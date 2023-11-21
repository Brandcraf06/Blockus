/*
package com.brand.blockus.modcompat.promenade.data.providers;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.data.BlockusDatagen;
import com.brand.blockus.data.providers.BlockusBlockLootTableProvider;
import com.brand.blockus.modcompat.promenade.BlockusPromenadeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class BlockusPromenadeBlockLootTableProvider extends BlockusBlockLootTableProvider {
    public BlockusPromenadeBlockLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        addPottedLargePlantDrop(BlockusPromenadeBlocks.POTTED_SAP_MAPLE);
        addPottedLargePlantDrop(BlockusPromenadeBlocks.POTTED_VERMILION_MAPLE);
        addPottedLargePlantDrop(BlockusPromenadeBlocks.POTTED_FULVOUS_MAPLE);
        addPottedLargePlantDrop(BlockusPromenadeBlocks.POTTED_MIKADO_MAPLE);
        addPottedLargePlantDrop(BlockusPromenadeBlocks.POTTED_BLUSH_SAKURA);
        addPottedLargePlantDrop(BlockusPromenadeBlocks.POTTED_COTTON_SAKURA);
        addPottedLargePlantDrop(BlockusPromenadeBlocks.POTTED_PALM);
        addPottedLargePlantDrop(BlockusPromenadeBlocks.POTTED_DARK_AMARANTH);
        this.addDrop(BlockusPromenadeBlocks.MAPLE_SMALL_LOGS);
        this.addDrop(BlockusPromenadeBlocks.SAKURA_SMALL_LOGS);
        this.addDrop(BlockusPromenadeBlocks.PALM_SMALL_LOGS);
        this.addDrop(BlockusPromenadeBlocks.DARK_AMARANTH_SMALL_STEMS);
        this.addDrop(BlockusPromenadeBlocks.SAP_MAPLE_SMALL_HEDGE, this::stickDrops);
        this.addDrop(BlockusPromenadeBlocks.VERMILION_MAPLE_SMALL_HEDGE, this::stickDrops);
        this.addDrop(BlockusPromenadeBlocks.FULVOUS_MAPLE_SMALL_HEDGE, this::stickDrops);
        this.addDrop(BlockusPromenadeBlocks.MIKADO_MAPLE_SMALL_HEDGE, this::stickDrops);
        this.addDrop(BlockusPromenadeBlocks.BLUSH_SAKURA_SMALL_HEDGE, this::stickDrops);
        this.addDrop(BlockusPromenadeBlocks.COTTON_SAKURA_SMALL_HEDGE, this::stickDrops);
        this.addDrop(BlockusPromenadeBlocks.PALM_SMALL_HEDGE, this::stickDrops);
        this.addDrop(BlockusPromenadeBlocks.DARK_AMARANTH_SMALL_HEDGE);
        this.addDrop(BlockusPromenadeBlocks.BLUEBERRIES_CRATE);
        this.addDrop(BlockusPromenadeBlocks.WHITE_OAK_LEAF_PILE, (block) -> this.oakLeavesDrops(block, BlockusBlocks.WHITE_OAK_LEAVES, SAPLING_DROP_CHANCE));

    }

    @Override
    public void accept(BiConsumer<Identifier, Builder> exporter) {
        super.accept(this.withConditions(exporter, BlockusDatagen.getLoadCondition("promenade")));
    }

    @Override
    public String getName() {
        return "Promenade Block Loot Table";
    }
}


*/
