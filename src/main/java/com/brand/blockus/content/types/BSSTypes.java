package com.brand.blockus.content.types;

import com.brand.blockus.blocks.base.amethyst.AmethystSlabBlock;
import com.brand.blockus.blocks.base.amethyst.AmethystStairsBlock;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSTypes {
    private static final ArrayList<BSSTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;

    private BSSTypes(String type, Block.Settings blockSettings) {

        if (!type.contains("amethyst")) {
            this.block = BlocksRegistration.register(type, new Block(FabricBlockSettings.copyOf(blockSettings)));
            this.slab = BlocksRegistration.registerSlab(this.block);
            this.stairs = BlocksRegistration.registerStairs(this.block);
        } else {
            this.block = BlocksRegistration.register(type, new AmethystBlock(FabricBlockSettings.copyOf(blockSettings)));
            this.stairs = BlocksRegistration.register(type + "_stairs", new AmethystStairsBlock(this.block.getDefaultState(), FabricBlockSettings.copy(this.block)));
            this.slab = BlocksRegistration.register(type + "_slab", new AmethystSlabBlock(FabricBlockSettings.copy(this.block)));
        }

        LIST.add(this);
    }


    public BSSTypes(String type, Block base) {
        this(type, FabricBlockSettings.copyOf(base));
    }

    public BSSTypes(String type, Block base, MapColor color) {
        this(type, FabricBlockSettings.copyOf(base).mapColor(color));

    }

    public BSSTypes(String type, Block base, BlockSoundGroup sounds) {
        this(type, FabricBlockSettings.copyOf(base).sounds(sounds));
    }

    public BSSTypes(String type, float hardness, float resistance, MapColor color) {
        this(type, FabricBlockSettings.of().mapColor(color).strength(hardness, resistance).sounds(BlockSoundGroup.STONE));

    }

    public static ArrayList<BSSTypes> values() {
        return LIST;
    }
}
