package com.brand.blockus;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.world.BlockusConfiguredFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Blockus implements ModInitializer {

    public static final String MOD_ID = "blockus";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup BLOCKUS_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_building_blocks"), () -> new ItemStack(BlockusBlocks.BLAZE_BRICKS));
    public static final ItemGroup BLOCKUS_DECORATIONS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_decorations"), () -> new ItemStack(BlockusBlocks.OAK_SMALL_HEDGE));
    public static final ItemGroup BLOCKUS_REDSTONE = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_redstone"), () -> new ItemStack(BlockusBlocks.REDSTONE_SAND));

    @Override
    public void onInitialize() {

        new BlockusBlocks();
        Instance.init();
        BlockusConfiguredFeatures.registerConfiguredFeature();
        BlockusConfiguredFeatures.registerBiomeModifications();
    }
}

