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
    public final Block wall; // Nullable
    public final String type;
    public Block base;

    public BSSWTypes(String type, AbstractBlock.Settings blockSettings) {
        this(type, blockSettings, true);
    }

    public BSSWTypes(String type, AbstractBlock.Settings blockSettings, boolean includeWall) {
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
        this.wall = includeWall ? BlocksRegistration.registerWall(this.block) : null;

        LIST.add(this);
    }

    public BSSWTypes(String type, Block base, boolean includeWall) {
        this(type, AbstractBlock.Settings.copy(base), includeWall);
        this.base = base;
    }

    public BSSWTypes(String type, Block base) {
        this(type, AbstractBlock.Settings.copy(base));
        this.base = base;
    }

    public BSSWTypes(String type, Block base, MapColor mapcolor) {
        this(type, AbstractBlock.Settings.copy(base).mapColor(mapcolor));
        this.base = base;
    }

    public BSSWTypes(String type, Block base, MapColor mapcolor, boolean includeWall) {
        this(type, AbstractBlock.Settings.copy(base).mapColor(mapcolor), includeWall);
        this.base = base;
    }

    public BSSWTypes(String type, Block base, PistonBehavior pistonBehavior) {
        this(type, AbstractBlock.Settings.copy(base).pistonBehavior(pistonBehavior));
        this.base = base;
    }

    public BSSWTypes(String type, Block base, int luminance) {
        this(type, AbstractBlock.Settings.copy(base).luminance((state) -> luminance));
        this.base = base;
    }

    public BSSWTypes(String type, Block base, BlockSoundGroup sound) {
        this(type, AbstractBlock.Settings.copy(base).sounds(sound));
        this.base = base;
    }

    public BSSWTypes(String type, Block base, BlockSoundGroup sound, boolean includeWall) {
        this(type, AbstractBlock.Settings.copy(base).sounds(sound), includeWall);
        this.base = base;
    }

    public BSSWTypes(String type, Block base, float hardness, float resistance, MapColor mapcolor) {
        this(type, AbstractBlock.Settings.copy(base).strength(hardness, resistance).mapColor(mapcolor));
        this.base = base;
    }

    public BSSWTypes(String type, float hardness, float resistance, MapColor color, boolean includeWall) {
        this(type, AbstractBlock.Settings.create().mapColor(color).strength(hardness, resistance).sounds(BlockSoundGroup.STONE), includeWall);
    }

    public static ArrayList<BSSWTypes> values() {
        return LIST;
    }
}
