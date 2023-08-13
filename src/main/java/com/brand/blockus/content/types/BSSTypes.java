package com.brand.blockus.content.types;

import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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

    public BSSTypes(String type, Block.Settings blockSettings) {
        Block blockInstance;
        this.type = type;

        if (BlocksRegistration.isAmethyst(type)) {
            blockInstance = new AmethystBlock(FabricBlockSettings.copyOf(blockSettings));
        } else {
            blockInstance = new Block(FabricBlockSettings.copyOf(blockSettings));
        }

        this.block = BlocksRegistration.register(type, blockInstance);
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);

        LIST.add(this);
    }

    public BSSTypes(String type, Block base) {
        this(type, FabricBlockSettings.copyOf(base));
        this.base = base;
    }

    public BSSTypes(String type, Block base, MapColor color) {
        this(type, FabricBlockSettings.copyOf(base).mapColor(color));

    }

    public BSSTypes(String type, Block base, BlockSoundGroup sounds) {
        this(type, FabricBlockSettings.copyOf(base).sounds(sounds));
    }

    public BSSTypes(String type, float hardness, float resistance, MapColor color) {
        this(type, FabricBlockSettings.create().mapColor(color).strength(hardness, resistance).sounds(BlockSoundGroup.STONE));

    }

    public static ArrayList<BSSTypes> values() {
        return LIST;
    }
}
