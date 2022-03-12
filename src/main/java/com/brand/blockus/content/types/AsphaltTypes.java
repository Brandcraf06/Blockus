package com.brand.blockus.content.types;

import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;

public class AsphaltTypes {
    private static final ArrayList<AsphaltTypes> LIST = new ArrayList<>();

    public static final AsphaltTypes ASPHALT = new AsphaltTypes(DyeColor.BLACK);
    public static final AsphaltTypes WHITE_ASPHALT = new AsphaltTypes(DyeColor.WHITE);
    public static final AsphaltTypes ORANGE_ASPHALT = new AsphaltTypes(DyeColor.ORANGE);
    public static final AsphaltTypes MAGENTA_ASPHALT = new AsphaltTypes(DyeColor.MAGENTA);
    public static final AsphaltTypes LIGHT_BLUE_ASPHALT = new AsphaltTypes(DyeColor.LIGHT_BLUE);
    public static final AsphaltTypes YELLOW_ASPHALT = new AsphaltTypes(DyeColor.YELLOW);
    public static final AsphaltTypes LIME_ASPHALT = new AsphaltTypes(DyeColor.LIME);
    public static final AsphaltTypes PINK_ASPHALT = new AsphaltTypes(DyeColor.PINK);
    public static final AsphaltTypes LIGHT_GRAY_ASPHALT = new AsphaltTypes(DyeColor.LIGHT_GRAY);
    public static final AsphaltTypes GRAY_ASPHALT = new AsphaltTypes(DyeColor.GRAY);
    public static final AsphaltTypes CYAN_ASPHALT = new AsphaltTypes(DyeColor.CYAN);
    public static final AsphaltTypes PURPLE_ASPHALT = new AsphaltTypes(DyeColor.PURPLE);
    public static final AsphaltTypes BLUE_ASPHALT = new AsphaltTypes(DyeColor.BLUE);
    public static final AsphaltTypes BROWN_ASPHALT = new AsphaltTypes(DyeColor.BROWN);
    public static final AsphaltTypes GREEN_ASPHALT = new AsphaltTypes(DyeColor.GREEN);
    public static final AsphaltTypes RED_ASPHALT = new AsphaltTypes(DyeColor.RED);

    public final Block block;
    public final Block slab;
    public final Block stairs;

    private AsphaltTypes(DyeColor color) {
        String type = color.getName() + "_asphalt";
        String type2 = type.replace("black_asphalt", "asphalt");

        Block.Settings blockSettings = FabricBlockSettings.of(Material.STONE, color).strength(1.5f, 6.0f).requiresTool();

        this.block = BlocksRegistration.register(type2, new AsphaltBlock(blockSettings));
        this.slab = BlocksRegistration.register(type2 + "_slab", new AsphaltSlab(FabricBlockSettings.copyOf(block)));
        this.stairs = BlocksRegistration.register(type2 + "_stairs", new AsphaltStairs(block.getDefaultState(), FabricBlockSettings.copyOf(block)));

        LIST.add(this);
    }

    public static ArrayList<AsphaltTypes> values() {
        return LIST;
    }
}
