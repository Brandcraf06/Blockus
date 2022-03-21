package com.brand.blockus.content.types;

import com.brand.blockus.content.BlocksRegistration;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class PottedLargeTypes {
    private static final ArrayList<PottedLargeTypes> LIST = new ArrayList<>();

    public final Block block;

    public PottedLargeTypes(String type, Block plant) {

        this.block = BlocksRegistration.registerNoItem(type, BlocksRegistration.createPottedDoublePlant(plant));

        LIST.add(this);
    }

    public static ArrayList<PottedLargeTypes> values() {
        return LIST;
    }
}
