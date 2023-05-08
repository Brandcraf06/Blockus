package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;

public class BSSTypes {
    private static final ArrayList<BSSTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;

    private BSSTypes(String type, Block.Settings blockSettings) {

        ItemGroup group = Blockus.BLOCKUS_BUILDING_BLOCKS;
        this.block = BlocksRegistration.register(type, new Block(FabricBlockSettings.copyOf(blockSettings)), group);
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);

        LIST.add(this);
    }

    public BSSTypes(String type, Block base) {
        this(type, FabricBlockSettings.copyOf(base));
    }

    public BSSTypes(String type, Block base, MapColor mapcolor) {
        this(type, FabricBlockSettings.copyOf(base).mapColor(mapcolor));
    }

    public BSSTypes(String type, Block base, BlockSoundGroup sounds) {
        this(type, FabricBlockSettings.copyOf(base).sounds(sounds));
    }

    public BSSTypes(String type, float hardness, float resistance, MapColor mapcolor) {
        this(type, FabricBlockSettings.of(Material.STONE, mapcolor).strength(hardness, resistance).sounds(BlockSoundGroup.STONE));
    }

    public static ArrayList<BSSTypes> values() {
        return LIST;
    }
}
