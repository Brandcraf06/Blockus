package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.BlockFactory;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSBundle {
    public static final ArrayList<BSSBundle> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final String type;
    public Block base;

    public BSSBundle(String type, Block.Settings blockSettings) {
        Block blockInstance;
        this.type = type;

        if (BlockFactory.isAmethyst(type)) {
            blockInstance = new AmethystBlock(FabricBlockSettings.copyOf(blockSettings));
        } else {
            blockInstance = new Block(FabricBlockSettings.copyOf(blockSettings));
        }

        this.block = BlockFactory.register(type, blockInstance);
        this.slab = BlockFactory.registerSlab(this.block);
        this.stairs = BlockFactory.registerStairs(this.block);

        LIST.add(this);
    }

    public BSSBundle(String type, Block base) {
        this(type, FabricBlockSettings.copyOf(base));
        this.base = base;
    }

    public BSSBundle(String type, Block base, MapColor color) {
        this(type, FabricBlockSettings.copyOf(base).mapColor(color));

    }

    public BSSBundle(String type, Block base, BlockSoundGroup sounds) {
        this(type, FabricBlockSettings.copyOf(base).sounds(sounds));
    }

    public BSSBundle(String type, float hardness, float resistance, MapColor color) {
        this(type, FabricBlockSettings.create().mapColor(color).strength(hardness, resistance).sounds(BlockSoundGroup.STONE));

    }

    public static ArrayList<BSSBundle> values() {
        return LIST;
    }
}
