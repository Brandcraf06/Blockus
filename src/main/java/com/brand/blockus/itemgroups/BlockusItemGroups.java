package com.brand.blockus.itemgroups;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.ColoredTilesBundle;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import static com.brand.blockus.registry.content.BlockusBlocks.ASPHALT;

public class BlockusItemGroups {

    public static final ResourceKey<CreativeModeTab> BLOCKUS_BUILDING_BLOCKS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Blockus.id("blockus_building_blocks"));
    public static final ResourceKey<CreativeModeTab> BLOCKUS_COLORED_BLOCKS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Blockus.id("blockus_colored"));
    public static final ResourceKey<CreativeModeTab> BLOCKUS_COLORED_TILES = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Blockus.id("blockus_colored_tiles"));
    public static final ResourceKey<CreativeModeTab> BLOCKUS_NATURAL = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Blockus.id("blockus_natural"));
    public static final ResourceKey<CreativeModeTab> BLOCKUS_FUNCTIONAL_BLOCKS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Blockus.id("blockus_functional"));
    public static final ResourceKey<CreativeModeTab> BLOCKUS_LEGACY_BLOCKS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Blockus.id("blockus_legacy"));
    public static Component BLOCKUS_GROUPS_TEXT = Component.literal(" (Blockus)").withStyle(ChatFormatting.DARK_AQUA);

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BLOCKUS_BUILDING_BLOCKS, FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup.blockus_building_blocks").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(BlockusBlocks.BLAZE_BRICKS.block()))
            .build()
        );
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BLOCKUS_COLORED_BLOCKS, FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup.blockus_colored").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(ASPHALT.colorMap().get(DyeColor.LIME).block()))
            .build()
        );
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BLOCKUS_COLORED_TILES, FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup.blockus_colored_tiles").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(ColoredTilesBundle.get(Blocks.CONCRETE.red(), Blocks.CONCRETE.blue()).block()))
            .build()
        );
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BLOCKUS_NATURAL, FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup.blockus_natural").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(BlockusBlocks.WHITE_OAK_SAPLING))
            .build()
        );
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BLOCKUS_FUNCTIONAL_BLOCKS, FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup.blockus_functional").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(BlockusBlocks.REDSTONE_LANTERN))
            .build()
        );
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BLOCKUS_LEGACY_BLOCKS, FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup.blockus_legacy").append(BLOCKUS_GROUPS_TEXT))
            .icon(() -> new ItemStack(BlockusBlocks.LEGACY_BRICKS))
            .build()
        );
    }
}
