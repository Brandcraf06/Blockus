package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.OrientableBlockBase;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;

public class TimberFrameTypesB {

    private static final ArrayList<TimberFrameTypesB> LIST = new ArrayList<>();

    public final Block block;
    public final Block diagonal;
    public final Block cross;
    public final Block base;

    public TimberFrameTypesB(String type, Block base) {

        this.base = base;

        ItemGroup group = Blockus.BLOCKUS_BUILDING_BLOCKS;
        this.block =  BlocksRegistration.register(type+ "_timber_frame", new Block(FabricBlockSettings.copyOf(base)), group);
        this.diagonal =  BlocksRegistration.register(type + "_diagonal_timber_frame", new OrientableBlockBase(FabricBlockSettings.copyOf(base)), group);
        this.cross =  BlocksRegistration.register(type + "_cross_timber_frame", new Block(FabricBlockSettings.copyOf(base)), group);

        LIST.add(this);

    }

	public static ArrayList<TimberFrameTypesB> values() {
        return LIST;
    }
}
