package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.BlockFactory;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.RedstoneBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSWBundle {
    public static final ArrayList<BSSWBundle> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final String type;
    public final Block wall;

    public BSSWBundle(String type, Block.Settings blockSettings) {
        Block blockInstance;
        this.type = type;

        if (BlockFactory.isAmethyst(type)) {
            blockInstance = new AmethystBlock(FabricBlockSettings.copyOf(blockSettings));
        } else if (BlockFactory.isRedstone(type)) {
            blockInstance = new RedstoneBlock(FabricBlockSettings.copyOf(blockSettings));
        } else {
            blockInstance = new Block(FabricBlockSettings.copyOf(blockSettings));
        }

        this.block = BlockFactory.register(type, blockInstance);
        this.slab = BlockFactory.registerSlab(this.block);
        this.stairs = BlockFactory.registerStairs(this.block);
        this.wall = BlockFactory.registerWall(this.block);

        LIST.add(this);
    }

    public BSSWBundle(String type, Block base, MapColor mapcolor) {
        this(type, FabricBlockSettings.copyOf(base).mapColor(mapcolor));

    }

    public BSSWBundle(String type, Block base) {
        this(type, FabricBlockSettings.copyOf(base));
    }

    public BSSWBundle(String type, Block base, PistonBehavior pistonBehavior) {
        this(type, FabricBlockSettings.copyOf(base).pistonBehavior(pistonBehavior));
    }

    public BSSWBundle(String type, Block base, int luminance) {
        this(type, FabricBlockSettings.copyOf(base).luminance(luminance));

    }

    public BSSWBundle(String type, Block base, BlockSoundGroup sound) {
        this(type, FabricBlockSettings.copyOf(base).sounds(sound));

    }

    public BSSWBundle(String type, Block base, float hardness, float resistance, MapColor mapcolor) {
        this(type, FabricBlockSettings.copyOf(base).strength(hardness, resistance).mapColor(mapcolor));

    }

    public static ArrayList<BSSWBundle> values() {
        return LIST;
    }
}
