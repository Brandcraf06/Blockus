package com.brand.blockus;

import com.brand.blockus.blocks.blockitems.SpeedBlockItem;
import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.promenade.BlockusPromenadeBlocks;
import com.brand.blockus.compatibility.content.promenade.BlockusPromenadeItems;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.content.types.AsphaltTypes;
import com.brand.blockus.content.types.BSSTypes;
import com.brand.blockus.content.types.BSSWTypes;
import com.brand.blockus.world.BlockusConfiguredFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blockus implements ModInitializer {

    public static final String MOD_ID = "blockus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ItemGroup BLOCKUS_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_building_blocks"), () -> new ItemStack(BSSWTypes.BLAZE_BRICKS.block));
    public static final ItemGroup BLOCKUS_DECORATIONS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_decorations"), () -> new ItemStack(BlockusBlocks.OAK_SMALL_HEDGE));
    public static final ItemGroup BLOCKUS_REDSTONE = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_redstone"), () -> new ItemStack(BlockusBlocks.REDSTONE_SAND));
    public static final ItemGroup BLOCKUS_LEGACY = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_legacy"), () -> new ItemStack(BlockusBlocks.LEGACY_BRICKS));

    @Override
    public void onInitialize() {

        BSSTypes.initialize();
        BSSWTypes.initialize();
        AsphaltTypes.initialize();


        new BlockusBlocks();
        new BlockusItems();

        if (FabricLoader.getInstance().isModLoaded("columns")) {
            BlockusColumnBlocks.init();
        }

        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            BlockusPromenadeBlocks.init();
            BlockusPromenadeItems.init();
        }

        Instance.init();

        BlockusConfiguredFeatures.registerConfiguredFeature();
    }

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    public static Block block(String name, Block block) {
        block = Registry.register(Registry.BLOCK, Blockus.id(name), block);
        item(name, new BlockItem(block, new Item.Settings().group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
        return block;
    }

    public static Block decoration(String name, Block block) {
        block = Registry.register(Registry.BLOCK, Blockus.id(name), block);
        item(name, new BlockItem(block, new Item.Settings().group(Blockus.BLOCKUS_DECORATIONS)));
        return block;
    }

    public static Block asphalt(String name, Block block) {
        block = Registry.register(Registry.BLOCK, Blockus.id(name), block);
        item(name, new SpeedBlockItem(block, new Item.Settings().group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
        return block;
    }

    public static Item item(String name, Item item) {
        return Registry.register(Registry.ITEM, Blockus.id(name), item);
    }
}

