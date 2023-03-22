package com.brand.blockus;

import com.brand.blockus.compatibility.content.BlockusColumnBlocks;
import com.brand.blockus.compatibility.content.BlockusPromenadeBlocks;
import com.brand.blockus.content.BlockusBlocks;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.utils.AsphaltStatusEffect;
import com.brand.blockus.world.BlockusConfiguredFeatures;
import com.google.common.reflect.Reflection;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blockus implements ModInitializer {

    public static final String MOD_ID = "blockus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ItemGroup BLOCKUS_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_building_blocks"), () -> new ItemStack(BlockusBlocks.BLAZE_BRICKS.block));
    public static final ItemGroup BLOCKUS_DECORATIONS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_decorations"), () -> new ItemStack(BlockusBlocks.OAK_SMALL_HEDGE));
    public static final ItemGroup BLOCKUS_REDSTONE = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_redstone"), () -> new ItemStack(BlockusBlocks.REDSTONE_SAND));
    public static final ItemGroup BLOCKUS_LEGACY = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_legacy"), () -> new ItemStack(BlockusBlocks.LEGACY_BRICKS));
    public static final StatusEffect ASPHALT_SPRINT = new AsphaltStatusEffect().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "ab0e24b0-f62d-4cf8-8d35-62989caa5b5f", 0.40D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

    @Override
    public void onInitialize() {

        Reflection.initialize(BlockusBlocks.class);
        Reflection.initialize(BlockusItems.class);

        if (FabricLoader.getInstance().isModLoaded("columns")) {
            BlockusColumnBlocks.init();
        }

        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            BlockusPromenadeBlocks.init();
        }

        Instance.init();

        BlockusConfiguredFeatures.registerConfiguredFeature();


        Registry.register(Registry.STATUS_EFFECT, Blockus.id("asphalt_sprint"), ASPHALT_SPRINT);

    }

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    public static Text STEPPED_ON_TEXT = Text.translatable(Util.createTranslationKey("blockitem", Blockus.id("when_stepped_on"))).formatted(Formatting.GRAY);
}

