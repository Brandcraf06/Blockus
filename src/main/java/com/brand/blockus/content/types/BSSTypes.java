package com.brand.blockus.content.types;

import com.brand.blockus.content.BlocksRegistration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSTypes {
    public static final ArrayList<BSSTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final String type;
    public Block base;

    public BSSTypes(String type, AbstractBlock.Settings blockSettings) {
        Block blockInstance;
        this.type = type;

        if (BlocksRegistration.isAmethyst(type)) {
            blockInstance = new AmethystBlock(blockSettings);
        } else {
            blockInstance = new Block(blockSettings);
        }

        this.block = BlocksRegistration.register(type, blockInstance);
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);

        LIST.add(this);
    }

    public BSSTypes(String type, Block base) {
        this(type, AbstractBlock.Settings.copy(base));
        this.base = base;
    }

    public BSSTypes(String type, Block base, MapColor color) {
        this(type, AbstractBlock.Settings.copy(base).mapColor(color));

    }

    public BSSTypes(String type, Block base, BlockSoundGroup sounds) {
        this(type, AbstractBlock.Settings.copy(base).sounds(sounds));
    }

    public BSSTypes(String type, float hardness, float resistance, MapColor color) {
        this(type, AbstractBlock.Settings.create().mapColor(color).strength(hardness, resistance).sounds(BlockSoundGroup.STONE));

    }

    public static ArrayList<BSSTypes> values() {
        return LIST;
    }
}
