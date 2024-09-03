package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.utils.BlockFactory;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.Instrument;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;

public class AsphaltBundle {
    public static final ArrayList<AsphaltBundle> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;

    public AsphaltBundle(DyeColor color) {
        String type = color.getName() + "_asphalt";
        String type2 = type.replace("black_asphalt", "asphalt");

        Block.Settings blockSettings = FabricBlockSettings.create().mapColor(color).instrument(Instrument.BASEDRUM).strength(1.5f, 6.0f).requiresTool();

        this.block = BlockFactory.register(type2, new AsphaltBlock(blockSettings));
        this.slab = BlockFactory.register(type2 + "_slab", new AsphaltSlab(FabricBlockSettings.copyOf(block)));
        this.stairs = BlockFactory.register(type2 + "_stairs", new AsphaltStairs(block.getDefaultState(), FabricBlockSettings.copyOf(block)));

        LIST.add(this);
    }

    public static ArrayList<AsphaltBundle> values() {
        return LIST;
    }
}
