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
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum AsphaltTypes {

    ASPHALT("asphalt", DyeColor.BLACK),
    WHITE_ASPHALT("white_asphalt", DyeColor.WHITE),
    ORANGE_ASPHALT("orange_asphalt", DyeColor.ORANGE),
    MAGENTA_ASPHALT("magenta_asphalt", DyeColor.MAGENTA),
    LIGHT_BLUE_ASPHALT("light_blue_asphalt", DyeColor.LIGHT_BLUE),
    YELLOW_ASPHALT("yellow_asphalt", DyeColor.YELLOW),
    LIME_ASPHALT("lime_asphalt", DyeColor.LIME),
    PINK_ASPHALT("pink_asphalt", DyeColor.PINK),
    LIGHT_GRAY_ASPHALT("light_gray_asphalt", DyeColor.LIGHT_GRAY),
    GRAY_ASPHALT("gray_asphalt", DyeColor.GRAY),
    CYAN_ASPHALT("cyan_asphalt", DyeColor.CYAN),
    PURPLE_ASPHALT("purple_asphalt", DyeColor.PURPLE),
    BLUE_ASPHALT("blue_asphalt", DyeColor.BLUE),
    BROWN_ASPHALT("brown_asphalt", DyeColor.BROWN),
    GREEN_ASPHALT("green_asphalt", DyeColor.GREEN),
    RED_ASPHALT("red_asphalt", DyeColor.RED);

    public final AsphaltBlock block;
    public final AsphaltSlab slab;
    public final AsphaltStairs stairs;
    public final BlockItem item;
    public final BlockItem item_slab;
    public final BlockItem item_stairs;

    private AsphaltTypes(String type, DyeColor color) {
        Identifier id = new Identifier(Blockus.MOD_ID, type);
        Identifier id_slab = new Identifier(Blockus.MOD_ID, type + "_slab");
        Identifier id_stairs = new Identifier(Blockus.MOD_ID, type + "_stairs");

        Block.Settings blockSettings = FabricBlockSettings.of(Material.STONE, color).strength(1.5f, 6.0f).requiresTool();
        this.block = new AsphaltBlock(blockSettings);
        this.slab = new AsphaltSlab(blockSettings);
        this.stairs = new AsphaltStairs(block.getDefaultState(), blockSettings);

        Item.Settings itemSettings = new Item.Settings().group(Blockus.BLOCKUS_BUILDING_BLOCKS);
        this.item = new SpeedBlockItem(this.block, itemSettings);
        this.item_slab = new SpeedBlockItem(this.slab, itemSettings);
        this.item_stairs = new SpeedBlockItem(this.stairs, itemSettings);

        Registry.register(Registry.BLOCK, id, this.block);
        Registry.register(Registry.BLOCK, id_slab, this.slab);
        Registry.register(Registry.BLOCK, id_stairs, this.stairs);
        Registry.register(Registry.ITEM, id, this.item);
        Registry.register(Registry.ITEM, id_slab, this.item_slab);
        Registry.register(Registry.ITEM, id_stairs, this.item_stairs);

    }

    public static AsphaltTypes initialize() {
        return null;
    }
}
