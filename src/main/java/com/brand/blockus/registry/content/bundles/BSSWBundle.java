package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.BlockChecker;
import com.brand.blockus.utils.BlockFactory;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSWBundle {
    public static final ArrayList<BSSWBundle> LIST = new ArrayList<>();
    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block wall; // Nullable
    public final String type;
    public Block base;

    public BSSWBundle(String type, FabricBlockSettings blockSettings) {
        this(type, blockSettings, true);
    }

    public BSSWBundle(String type, FabricBlockSettings blockSettings, boolean includeWall) {
        Block blockInstance;
        this.type = type;

        if (BlockChecker.isAmethyst(type)) {
            blockInstance = new AmethystBlock(blockSettings);
        } else if (BlockChecker.isRedstone(type)) {
            blockInstance = new RedstoneBlock(blockSettings);
        } else {
            blockInstance = new Block(blockSettings);
        }

        this.block = BlockFactory.register(type, blockInstance);
        this.slab = BlockFactory.registerSlab(this.block);
        this.stairs = BlockFactory.registerStairs(this.block);
        this.wall = includeWall ? BlockFactory.registerWall(this.block) : null;

        LIST.add(this);
    }

    public BSSWBundle(String type, Block base, boolean includeWall) {
        this(type, FabricBlockSettings.copyOf(base), includeWall);
        this.base = base;
    }

    public BSSWBundle(String type, Block base) {
        this(type, FabricBlockSettings.copyOf(base));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, MapColor mapcolor) {
        this(type, FabricBlockSettings.copyOf(base).mapColor(mapcolor));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, MapColor mapcolor, boolean includeWall) {
        this(type, FabricBlockSettings.copyOf(base).mapColor(mapcolor), includeWall);
        this.base = base;
    }

    public BSSWBundle(String type, Block base, PistonBehavior pistonBehavior) {
        this(type, FabricBlockSettings.copyOf(base).pistonBehavior(pistonBehavior));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, int luminance) {
        this(type, FabricBlockSettings.copyOf(base).luminance((state) -> luminance));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, BlockSoundGroup sound) {
        this(type, FabricBlockSettings.copyOf(base).sounds(sound));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, BlockSoundGroup sound, boolean includeWall) {
        this(type, FabricBlockSettings.copyOf(base).sounds(sound), includeWall);
        this.base = base;
    }

    public BSSWBundle(String type, Block base, float hardness, float resistance, MapColor mapcolor) {
        this(type, FabricBlockSettings.copyOf(base).strength(hardness, resistance).mapColor(mapcolor));
        this.base = base;
    }

    public BSSWBundle(String type, float hardness, float resistance, MapColor color, boolean includeWall) {
        this(type, FabricBlockSettings.create().mapColor(color).strength(hardness, resistance).sounds(BlockSoundGroup.STONE), includeWall);
    }

    public static ArrayList<BSSWBundle> values() {
        return LIST;
    }
}
