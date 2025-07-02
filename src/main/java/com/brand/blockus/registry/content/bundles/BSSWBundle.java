package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.BlockChecker;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;
import java.util.function.Function;

public class BSSWBundle {
    public static final ArrayList<BSSWBundle> LIST = new ArrayList<>();
    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block wall; // Nullable
    public final String type;
    public Block base;

    public BSSWBundle(String type, AbstractBlock.Settings blockSettings) {
        this(type, blockSettings, true);
    }

    public BSSWBundle(String type, AbstractBlock.Settings blockSettings, boolean includeWall) {
        this.type = type;

        Function<AbstractBlock.Settings, Block> factory;
        if (BlockChecker.isAmethyst(type)) {
            factory = AmethystBlock::new;
        } else if (BlockChecker.isRedstone(type)) {
            factory = RedstoneBlock::new;
        } else {
            factory = Block::new;
        }

        this.block = BlockFactory.registerOf(type, factory, blockSettings);
        this.slab = BlockFactory.slab(this.block);
        this.stairs = BlockFactory.stairs(this.block);
        this.wall = includeWall ? BlockFactory.wall(this.block) : null;

        LIST.add(this);
    }

    public BSSWBundle(String type, Block base, boolean includeWall) {
        this(type, BlockFactory.createCopy(base), includeWall);
        this.base = base;
    }

    public BSSWBundle(String type, Block base) {
        this(type, BlockFactory.createCopy(base));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, MapColor mapcolor) {
        this(type, BlockFactory.createCopy(base).mapColor(mapcolor));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, MapColor mapcolor, boolean includeWall) {
        this(type, BlockFactory.createCopy(base).mapColor(mapcolor), includeWall);
        this.base = base;
    }

    public BSSWBundle(String type, Block base, PistonBehavior pistonBehavior) {
        this(type, BlockFactory.createCopy(base).pistonBehavior(pistonBehavior));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, int luminance) {
        this(type, BlockFactory.createCopy(base).luminance((state) -> luminance));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, BlockSoundGroup sound) {
        this(type, BlockFactory.createCopy(base).sounds(sound));
        this.base = base;
    }

    public BSSWBundle(String type, Block base, BlockSoundGroup sound, boolean includeWall) {
        this(type, BlockFactory.createCopy(base).sounds(sound), includeWall);
        this.base = base;
    }

    public BSSWBundle(String type, Block base, float hardness, float resistance, MapColor mapcolor) {
        this(type, BlockFactory.createCopy(base).strength(hardness, resistance).mapColor(mapcolor));
        this.base = base;
    }

    public BSSWBundle(String type, float hardness, float resistance, MapColor color, boolean includeWall) {
        this(type, BlockFactory.create().mapColor(color).strength(hardness, resistance).sounds(BlockSoundGroup.STONE), includeWall);
    }

    public static ArrayList<BSSWBundle> values() {
        return LIST;
    }
}
