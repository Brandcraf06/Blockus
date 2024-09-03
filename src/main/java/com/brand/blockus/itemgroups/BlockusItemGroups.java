package com.brand.blockus.itemgroups;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.ColoredTilesBundle;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class BlockusItemGroups {

    public static final RegistryKey<ItemGroup> BLOCKUS_BUILDING_BLOCKS = RegistryKey.of(RegistryKeys.ITEM_GROUP, Blockus.id("blockus_building_blocks"));
    public static final RegistryKey<ItemGroup> BLOCKUS_COLORED_BLOCKS = RegistryKey.of(RegistryKeys.ITEM_GROUP, Blockus.id("blockus_colored"));
    public static final RegistryKey<ItemGroup> BLOCKUS_COLORED_TILES = RegistryKey.of(RegistryKeys.ITEM_GROUP, Blockus.id("blockus_colored_tiles"));
    public static final RegistryKey<ItemGroup> BLOCKUS_NATURAL = RegistryKey.of(RegistryKeys.ITEM_GROUP, Blockus.id("blockus_natural"));
    public static final RegistryKey<ItemGroup> BLOCKUS_FUNCTIONAL_BLOCKS = RegistryKey.of(RegistryKeys.ITEM_GROUP, Blockus.id("blockus_functional"));
    public static final RegistryKey<ItemGroup> BLOCKUS_LEGACY_BLOCKS = RegistryKey.of(RegistryKeys.ITEM_GROUP, Blockus.id("blockus_legacy"));
    public static Text BLOCKUS_GROUPS_TEXT = Text.literal(" (Blockus)").formatted(Formatting.DARK_AQUA);

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, BLOCKUS_BUILDING_BLOCKS, FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blockus_building_blocks").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(BlockusBlocks.BLAZE_BRICKS.block))
            .build()
        );
        Registry.register(Registries.ITEM_GROUP, BLOCKUS_COLORED_BLOCKS, FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blockus_colored").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(BlockusBlocks.LIME_ASPHALT.block))
            .build()
        );
        Registry.register(Registries.ITEM_GROUP, BLOCKUS_COLORED_TILES, FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blockus_colored_tiles").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(ColoredTilesBundle.RED_BLUE_COLORED_TILES.block))
            .build()
        );
        Registry.register(Registries.ITEM_GROUP, BLOCKUS_NATURAL, FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blockus_natural").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(BlockusBlocks.WHITE_OAK_SAPLING))
            .build()
        );
        Registry.register(Registries.ITEM_GROUP, BLOCKUS_FUNCTIONAL_BLOCKS, FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blockus_functional").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(BlockusBlocks.REDSTONE_LANTERN))
            .build()
        );
        Registry.register(Registries.ITEM_GROUP, BLOCKUS_LEGACY_BLOCKS, FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blockus_legacy").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(BlockusBlocks.LEGACY_BRICKS))
            .build()
        );
    }
}
