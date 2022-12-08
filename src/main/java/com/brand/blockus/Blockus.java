package com.brand.blockus;

import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.BlockusPromenadeBlocks;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.itemgroups.*;
import com.brand.blockus.worldgen.BlockusWorldgenFeatures;
import com.google.common.reflect.Reflection;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blockus implements ModInitializer {

    public static final String MOD_ID = "blockus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        Reflection.initialize(BlockusBlocks.class);
        Reflection.initialize(BlockusItems.class);

        Reflection.initialize(BlockusBuildingBlocks.class);
        Reflection.initialize(BlockusColoredBlocks.class);
        Reflection.initialize(BlockusNatural.class);
        Reflection.initialize(BlockusFunctionalBlocks.class);
        Reflection.initialize(BlockusLegacyBlocks.class);


       if (FabricLoader.getInstance().isModLoaded("columns")) {
            BlockusColumnBlocks.init();
       }

        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            BlockusPromenadeBlocks.init();
        }

        Instance.init();

        BlockusWorldgenFeatures.registerConfiguredFeature();
    }

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }
}

