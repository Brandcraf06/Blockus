package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.blocks.blockitems.SpeedBlockItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
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

    public final AsphaltBlock block;
    public final AsphaltSlab slab;
    public final AsphaltStairs stairs;
    public final SpeedBlockItem item;
    public final SpeedBlockItem item_slab;
    public final SpeedBlockItem item_stairs;

    private AsphaltTypes(DyeColor color) {
        String type = color.getName() + "_asphalt";
        String type2 = type.replace("black_asphalt", "asphalt");
        Identifier id = Blockus.id(type2);
        Identifier id_slab = Blockus.id(type2 + "_slab");
        Identifier id_stairs = Blockus.id(type2 + "_stairs");

        Block.Settings blockSettings = FabricBlockSettings.of(Material.STONE, color).strength(1.5f, 6.0f).requiresTool();
        Item.Settings itemSettings = new Item.Settings().group(Blockus.BLOCKUS_BUILDING_BLOCKS);

        this.block = Registry.register(Registry.BLOCK, id, new AsphaltBlock(blockSettings));
        this.slab =  Registry.register(Registry.BLOCK, id_slab, new AsphaltSlab(blockSettings));
        this.stairs =  Registry.register(Registry.BLOCK, id_stairs, new AsphaltStairs(block.getDefaultState(), blockSettings));

        this.item =  Registry.register(Registry.ITEM, id, new SpeedBlockItem(this.block, itemSettings));
        this.item_slab =  Registry.register(Registry.ITEM, id_slab, new SpeedBlockItem(this.slab, itemSettings));
        this.item_stairs =  Registry.register(Registry.ITEM, id_stairs, new SpeedBlockItem(this.stairs, itemSettings));

    }

    public static AsphaltTypes initialize() {
        return null;
    }
}
