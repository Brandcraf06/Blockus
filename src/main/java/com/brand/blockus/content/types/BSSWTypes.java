package com.brand.blockus.content.types;

import com.brand.blockus.blocks.base.amethyst.AmethystSlabBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystStairsBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystWallBlock;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSWTypes {
    private static final ArrayList<BSSWTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block wall;

    private BSSWTypes(String type, Block.Settings blockSettings) {

        if (!type.contains("amethyst")) {
            this.block = BlocksRegistration.register(type, new Block(FabricBlockSettings.copyOf(blockSettings)));
            this.slab = BlocksRegistration.registerSlab(this.block);
            this.stairs = BlocksRegistration.registerStairs(this.block);
            this.wall = BlocksRegistration.registerWall(this.block);
        } else {
            this.block = BlocksRegistration.register(type, new AmethystBlock(FabricBlockSettings.copyOf(blockSettings)));
            this.stairs = BlocksRegistration.register(type + "_stairs", new AmethystStairsBlock(this.block.getDefaultState(), FabricBlockSettings.copy(this.block)));
            this.slab = BlocksRegistration.register(type + "_slab", new AmethystSlabBlock(FabricBlockSettings.copy(this.block)));
            this.wall = BlocksRegistration.register(type + "_wall", new AmethystWallBlock(FabricBlockSettings.copy(this.block)));

        }

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
