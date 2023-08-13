package com.brand.blockus.content.types;

import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.RedstoneBlock;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSWTypes {
    public static final ArrayList<BSSWTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block wall;

    public BSSWTypes(String type, Block.Settings blockSettings) {
        Block blockInstance;

        if (BlocksRegistration.isAmethyst(type)) {
            blockInstance = new AmethystBlock(FabricBlockSettings.copyOf(blockSettings));
        } else if (BlocksRegistration.isRedstone(type)) {
            blockInstance = new RedstoneBlock(FabricBlockSettings.copyOf(blockSettings));
        } else {
            blockInstance = new Block(FabricBlockSettings.copyOf(blockSettings));
        }

        this.block = BlocksRegistration.register(type, blockInstance);
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);
        this.wall = BlocksRegistration.registerWall(this.block);

        LIST.add(this);
    }

    public BSSWTypes(String type, Block base, MapColor mapcolor) {
        this(type, FabricBlockSettings.copyOf(base).mapColor(mapcolor));

    }

    public BSSWTypes(String type, Block base) {
        this(type, FabricBlockSettings.copyOf(base));

    }

    public BSSWTypes(String type, Block base, int luminance) {
        this(type, FabricBlockSettings.copyOf(base).luminance(luminance));

    }

    public BSSWTypes(String type, Block base, BlockSoundGroup sound) {
        this(type, FabricBlockSettings.copyOf(base).sounds(sound));

    }

    public BSSWTypes(String type, Block base, float hardness, float resistance, MapColor mapcolor) {
        this(type, FabricBlockSettings.copyOf(base).strength(hardness, resistance).mapColor(mapcolor));

    }

    public static ArrayList<BSSWTypes> values() {
        return LIST;
    }
}
