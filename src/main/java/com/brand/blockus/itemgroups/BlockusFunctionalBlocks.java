package com.brand.blockus.itemgroups;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BlockusFunctionalBlocks {

    private static final ItemGroup BLOCKUS_FUNCTIONAL_BLOCKS = FabricItemGroup.builder(new Identifier(Blockus.MOD_ID, "blockus_functional"))
        .displayName(Text.translatable("itemGroup.blockus_functional"))
        .icon(() -> new ItemStack(BlockusBlocks.REDSTONE_LANTERN))
        .entries((enabledFeatures, entries, operatorEnabled) -> {
            entries.add(BlockusBlocks.REDSTONE_LANTERN);

            entries.add(BlockusBlocks.LANTERN_BLOCK);
            entries.add(BlockusBlocks.SOUL_LANTERN_BLOCK);
            entries.add(BlockusBlocks.REDSTONE_LANTERN_BLOCK);

            entries.add(BlockusBlocks.REDSTONE_O_LANTERN);
            entries.add(BlockusBlocks.REDSTONE_SAND);

            entries.add(BlockusBlocks.GOLDEN_CHAIN);

            entries.add(BlockusBlocks.BLAZE_LANTERN);

            entries.add(BlockusBlocks.WHITE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP);
            entries.add(BlockusBlocks.GRAY_REDSTONE_LAMP);
            entries.add(BlockusBlocks.BROWN_REDSTONE_LAMP);
            entries.add(BlockusBlocks.RED_REDSTONE_LAMP);
            entries.add(BlockusBlocks.ORANGE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.YELLOW_REDSTONE_LAMP);
            entries.add(BlockusBlocks.LIME_REDSTONE_LAMP);
            entries.add(BlockusBlocks.GREEN_REDSTONE_LAMP);
            entries.add(BlockusBlocks.CYAN_REDSTONE_LAMP);
            entries.add(BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.BLUE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.PURPLE_REDSTONE_LAMP);
            entries.add(BlockusBlocks.MAGENTA_REDSTONE_LAMP);
            entries.add(BlockusBlocks.PINK_REDSTONE_LAMP);
            entries.add(BlockusBlocks.RAINBOW_LAMP);
            entries.add(BlockusBlocks.RAINBOW_GLOWSTONE);
            entries.add(BlockusBlocks.GLOWING_OBSIDIAN);

            entries.add(BlockusBlocks.LARGE_FLOWER_POT);

            entries.add(BlockusBlocks.TINTED_BEVELED_GLASS);

            entries.add(BlockusBlocks.WHITE_OAK.sign);
            entries.add(BlockusBlocks.CHARRED.sign);
            entries.add(BlockusBlocks.BAMBOO.sign);
            entries.add(BlockusBlocks.WHITE_OAK.boat);
            entries.add(BlockusBlocks.CHARRED.boat);
            entries.add(BlockusBlocks.BAMBOO.boat);
            entries.add(BlockusBlocks.WHITE_OAK.chest_boat);
            entries.add(BlockusBlocks.CHARRED.chest_boat);
            entries.add(BlockusBlocks.BAMBOO.chest_boat);

        })
        .build();
}
