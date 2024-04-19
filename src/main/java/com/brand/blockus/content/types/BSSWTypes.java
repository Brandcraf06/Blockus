package com.brand.blockus.content.types;

import com.brand.blockus.content.BlocksRegistration;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSWTypes {
    public static final ArrayList<BSSWTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final String type;
    public final Block wall;

    public BSSWTypes(String type, AbstractBlock.Settings blockSettings) {
        Block blockInstance;
        this.type = type;

        if (BlocksRegistration.isAmethyst(type)) {
            blockInstance = new AmethystBlock(blockSettings);
        } else if (BlocksRegistration.isRedstone(type)) {
            blockInstance = new RedstoneBlock(blockSettings);
        } else {
            blockInstance = new Block(blockSettings);
        }

        this.block = BlocksRegistration.register(type, blockInstance);
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);
        this.wall = BlocksRegistration.registerWall(this.block);

        LIST.add(this);
    }

    public BSSWTypes(String type, Block base, MapColor mapcolor) {
        this(type, AbstractBlock.Settings.copy(base).mapColor(mapcolor));

    }

    public BSSWTypes(String type, Block base) {
        this(type, AbstractBlock.Settings.copy(base));
    }

    public BSSWTypes(String type, Block base, PistonBehavior pistonBehavior) {
        this(type, AbstractBlock.Settings.copy(base).pistonBehavior(pistonBehavior));
    }

    public BSSWTypes(String type, Block base, int luminance) {
        this(type, AbstractBlock.Settings.copy(base).luminance((state) -> luminance));

    }

    public BSSWTypes(String type, Block base, BlockSoundGroup sound) {
        this(type, AbstractBlock.Settings.copy(base).sounds(sound));

    }

    public BSSWTypes(String type, Block base, float hardness, float resistance, MapColor mapcolor) {
        this(type, AbstractBlock.Settings.copy(base).strength(hardness, resistance).mapColor(mapcolor));

    }

    public static ArrayList<BSSWTypes> values() {
        return LIST;
    }
}
