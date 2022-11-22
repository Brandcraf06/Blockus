package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSWTypes {
    private static final ArrayList<BSSWTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block wall;
    public final Block base;

    private BSSWTypes(String type, Block base, Block.Settings blockSettings) {
        this.base = base;

        ItemGroup group = Blockus.BLOCKUS_BUILDING_BLOCKS;
        this.block = BlocksRegistration.register(type, new Block(FabricBlockSettings.copyOf(blockSettings)), group);
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);
        this.wall = BlocksRegistration.registerWall(this.block);

        LIST.add(this);
    }

    public BSSWTypes(String type, Block base, MapColor mapcolor) {
        this(type, base, FabricBlockSettings.copyOf(base).mapColor(mapcolor));

    }

    public BSSWTypes(String type, Block base) {
        this(type, base, FabricBlockSettings.copyOf(base));

    }

    public BSSWTypes(String type, Block base, int luminance) {
        this(type, base, FabricBlockSettings.copyOf(base).luminance(luminance));

    }

    public BSSWTypes(String type, Block base, BlockSoundGroup sound) {
        this(type, base, FabricBlockSettings.copyOf(base).sounds(sound));

    }

    public static ArrayList<BSSWTypes> values() {
        return LIST;
    }
}
