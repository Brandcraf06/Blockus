package com.brand.blockus;

import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.promenade.BlockusPromenadeBlocks;
import com.brand.blockus.compatibility.content.promenade.BlockusPromenadeItems;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.content.types.*;
import com.brand.blockus.world.BlockusConfiguredFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blockus implements ModInitializer {

    public static final String MOD_ID = "blockus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ItemGroup BLOCKUS_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_building_blocks"), () -> new ItemStack(LightBlockTypes.BLAZE_BRICKS.block));
    public static final ItemGroup BLOCKUS_DECORATIONS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_decorations"), () -> new ItemStack(BlockusBlocks.OAK_SMALL_HEDGE));
    public static final ItemGroup BLOCKUS_REDSTONE = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_redstone"), () -> new ItemStack(BlockusBlocks.REDSTONE_SAND));
    public static final ItemGroup BLOCKUS_LEGACY = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_legacy"), () -> new ItemStack(BlockusBlocks.LEGACY_BRICKS));

    @Override
    public void onInitialize() {

        BlockTypes.initialize();
        WallTypes.initialize();
        LightBlockTypes.initialize();
        ShinglesTypes.initialize();
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
}

