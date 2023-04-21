package com.brand.blockus.itemgroups;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusEntities;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BlockusFunctionalBlocks {

    private static final RegistryKey<ItemGroup> BLOCKUS_FUNCTIONAL_BLOCKS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Blockus.MOD_ID, "blockus_functional"));

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, BLOCKUS_FUNCTIONAL_BLOCKS, FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blockus_functional"))
            .icon(() -> new ItemStack(BlockusBlocks.REDSTONE_LANTERN))
            .entries((enabledFeatures, entries) -> {

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
                entries.add(BlockusBlocks.RAW_BAMBOO.sign);
                entries.add(BlockusBlocks.WHITE_OAK.hanging_sign);
                entries.add(BlockusBlocks.CHARRED.hanging_sign);
                entries.add(BlockusBlocks.RAW_BAMBOO.hanging_sign);
                entries.add(BlockusEntities.WHITE_OAK_BOAT.getItem());
                entries.add(BlockusEntities.CHARRED_BOAT.getItem());
                entries.add(BlockusEntities.RAW_BAMBOO_RAFT.getItem());
                entries.add(BlockusEntities.WHITE_OAK_BOAT.getChestItem());
                entries.add(BlockusEntities.CHARRED_BOAT.getChestItem());
                entries.add(BlockusEntities.RAW_BAMBOO_RAFT.getChestItem());

            })
            .build()
        );
    }
}
