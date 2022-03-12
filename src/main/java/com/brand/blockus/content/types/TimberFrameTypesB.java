package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.OrientableBlockBase;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;

public class TimberFrameTypesB {

    private static final ArrayList<TimberFrameTypesB> LIST = new ArrayList<>();

    public static final TimberFrameTypesB OAK_TIMBER_FRAME = new TimberFrameTypesB("oak", Blocks.OAK_PLANKS);
    public static final TimberFrameTypesB BIRCH_TIMBER_FRAME = new TimberFrameTypesB("birch", Blocks.BIRCH_PLANKS);
    public static final TimberFrameTypesB SPRUCE_TIMBER_FRAME = new TimberFrameTypesB("spruce", Blocks.SPRUCE_PLANKS);
    public static final TimberFrameTypesB JUNGLE_TIMBER_FRAME = new TimberFrameTypesB("jungle", Blocks.JUNGLE_PLANKS);
    public static final TimberFrameTypesB ACACIA_TIMBER_FRAME = new TimberFrameTypesB("acacia", Blocks.ACACIA_PLANKS);
    public static final TimberFrameTypesB DARK_OAK_TIMBER_FRAME = new TimberFrameTypesB("dark_oak", Blocks.DARK_OAK_PLANKS);
    public static final TimberFrameTypesB BAMBOO_TIMBER_FRAME = new TimberFrameTypesB("bamboo", WoodTypesB.BAMBOO.planks);
    public static final TimberFrameTypesB WHITE_OAK_TIMBER_FRAME = new TimberFrameTypesB("white_oak", WoodTypesB.WHITE_OAK.planks);

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
