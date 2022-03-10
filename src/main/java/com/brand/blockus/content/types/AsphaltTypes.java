package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.StairsBase;
import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.blocks.blockitems.SpeedBlockItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum AsphaltTypes {

    ASPHALT(DyeColor.BLACK),
    WHITE_ASPHALT(DyeColor.WHITE),
    ORANGE_ASPHALT(DyeColor.ORANGE),
    MAGENTA_ASPHALT(DyeColor.MAGENTA),
    LIGHT_BLUE_ASPHALT(DyeColor.LIGHT_BLUE),
    YELLOW_ASPHALT(DyeColor.YELLOW),
    LIME_ASPHALT(DyeColor.LIME),
    PINK_ASPHALT(DyeColor.PINK),
    LIGHT_GRAY_ASPHALT(DyeColor.LIGHT_GRAY),
    GRAY_ASPHALT(DyeColor.GRAY),
    CYAN_ASPHALT(DyeColor.CYAN),
    PURPLE_ASPHALT(DyeColor.PURPLE),
    BLUE_ASPHALT(DyeColor.BLUE),
    BROWN_ASPHALT(DyeColor.BROWN),
    GREEN_ASPHALT(DyeColor.GREEN),
    RED_ASPHALT(DyeColor.RED);

    public final Block block;
    public final Block slab;
    public final Block stairs;

    private AsphaltTypes(DyeColor color) {
        String type = color.getName() + "_asphalt";
        String type2 = type.replace("black_asphalt", "asphalt");

        Block.Settings blockSettings = FabricBlockSettings.of(Material.STONE, color).strength(1.5f, 6.0f).requiresTool();

        this.block = Blockus.asphalt(type2, new AsphaltBlock(FabricBlockSettings.copyOf(blockSettings)));
        this.slab =  Blockus.asphalt(type2 + "_slab", new AsphaltSlab(FabricBlockSettings.copyOf(blockSettings)));
        this.stairs =  Blockus.asphalt(type2 + "_stairs", new AsphaltStairs(block.getDefaultState(), FabricBlockSettings.copyOf(blockSettings)));


    }

    public static AsphaltTypes initialize() {
        return null;
    }
}
