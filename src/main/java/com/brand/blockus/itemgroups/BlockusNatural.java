package com.brand.blockus.itemgroups;

import com.brand.blockus.Blockus;
import com.brand.blockus.compatibility.content.BlockusPromenadeBlocks;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BlockusNatural {

    private static final ItemGroup BLOCKUS_NATURAL = FabricItemGroup.builder(new Identifier(Blockus.MOD_ID, "blockus_natural"))
        .displayName(Text.translatable("itemGroup.blockus_natural"))
        .icon(() -> new ItemStack(BlockusBlocks.WHITE_OAK_SAPLING))
        .entries((enabledFeatures, entries, operatorEnabled) -> {

            entries.add(BlockusBlocks.PATH);
            entries.add(BlockusBlocks.LIMESTONE.block);
            entries.add(BlockusBlocks.MARBLE.block);
            entries.add(BlockusBlocks.BLUESTONE.block);
            entries.add(BlockusBlocks.VIRIDITE.block);

            entries.add(BlockusBlocks.WHITE_OAK_LOG);
            entries.add(BlockusBlocks.WHITE_OAK_SAPLING);
            entries.add(BlockusBlocks.WHITE_OAK_LEAVES);
            if (FabricLoader.getInstance().isModLoaded("promenade")) {
                entries.add(BlockusPromenadeBlocks.WHITE_OAK_LEAF_PILE);
            }

            entries.add(BlockusBlocks.OAK_SMALL_HEDGE);
            entries.add(BlockusBlocks.SPRUCE_SMALL_HEDGE);
            entries.add(BlockusBlocks.BIRCH_SMALL_HEDGE);
            entries.add(BlockusBlocks.JUNGLE_SMALL_HEDGE);
            entries.add(BlockusBlocks.ACACIA_SMALL_HEDGE);
            entries.add(BlockusBlocks.DARK_OAK_SMALL_HEDGE);
            entries.add(BlockusBlocks.MANGROVE_SMALL_HEDGE);
            entries.add(BlockusBlocks.WHITE_OAK_SMALL_HEDGE);
            entries.add(BlockusBlocks.CRIMSON_SMALL_HEDGE);
            entries.add(BlockusBlocks.WARPED_SMALL_HEDGE);
            entries.add(BlockusBlocks.AZALEA_SMALL_HEDGE);
            entries.add(BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE);
            entries.add(BlockusBlocks.MOSS_SMALL_HEDGE);
            if (FabricLoader.getInstance().isModLoaded("promenade")) {
                entries.add(BlockusPromenadeBlocks.SAP_MAPLE_SMALL_HEDGE);
                entries.add(BlockusPromenadeBlocks.VERMILION_MAPLE_SMALL_HEDGE);
                entries.add(BlockusPromenadeBlocks.FULVOUS_MAPLE_SMALL_HEDGE);
                entries.add(BlockusPromenadeBlocks.MIKADO_MAPLE_SMALL_HEDGE);
                entries.add(BlockusPromenadeBlocks.PINK_CHERRY_OAK_SMALL_HEDGE);
                entries.add(BlockusPromenadeBlocks.WHITE_CHERRY_OAK_SMALL_HEDGE);
                entries.add(BlockusPromenadeBlocks.PALM_SMALL_HEDGE);
                entries.add(BlockusPromenadeBlocks.DARK_AMARANTH_SMALL_HEDGE);
            }

            entries.add(BlockusBlocks.SOUL_O_LANTERN);

            entries.add(BlockusBlocks.RAINBOW_ROSE);
            entries.add(BlockusItems.RAINBOW_PETAL);

        })
        .build();
}
