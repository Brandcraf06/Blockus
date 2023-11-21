package com.brand.blockus;

import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusEntities;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.content.types.ColoredTilesTypes;
import com.brand.blockus.itemgroups.BlockusItemGroups;
import com.brand.blockus.itemgroups.content.*;
import com.brand.blockus.utils.effect.BlockusEffects;
import com.brand.blockus.worldgen.BlockusWorldgenFeatures;
import com.google.common.reflect.Reflection;
import net.fabricmc.api.ModInitializer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blockus implements ModInitializer {

    public static final String MOD_ID = "blockus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    @Override
    public void onInitialize() {

        Reflection.initialize(BlockusBlocks.class);
        Reflection.initialize(BlockusItems.class);
        Reflection.initialize(BlockusEntities.class);
        Reflection.initialize(ColoredTilesTypes.class);
        Reflection.initialize(BlockusEffects.class);

        BlockusItemGroups.init();
        BuildingBlocksGroup.init();
        ColoredGroups.init();
        NaturalGroup.init();
        FunctionalBlocksGroup.init();
        LegacyGroup.init();

       /* if (FabricLoader.getInstance().isModLoaded("promenade")) {
            BlockusPromenadeBlocks.init();
        }*/

        Instance.init();
        BlockusWorldgenFeatures.registerConfiguredFeature();

    }

    public static Text STEPPED_ON_TEXT = Text.translatable(Util.createTranslationKey("blockitem", Blockus.id("when_stepped_on"))).formatted(Formatting.GRAY);

}

