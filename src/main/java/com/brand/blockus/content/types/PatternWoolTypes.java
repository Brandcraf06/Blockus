package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;

public class PatternWoolTypes {
    private static final ArrayList<PatternWoolTypes> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block carpet;

    public PatternWoolTypes(DyeColor dyecolor, MapColor color) {
        String type = dyecolor.getName() + "_patterned_wool";

        ItemGroup group = Blockus.BLOCKUS_BUILDING_BLOCKS;

        Block.Settings blockSettings = FabricBlockSettings.of(Material.WOOL, color).strength(0.8F).sounds(BlockSoundGroup.WOOL);

        this.block = BlocksRegistration.register(type, new Block(blockSettings), group);
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);
        this.carpet = BlocksRegistration.registerDecoration(type.replace("wool", "carpet"), new DyedCarpetBlock(dyecolor, FabricBlockSettings.of(Material.CARPET, color).strength(0.1F).sounds(BlockSoundGroup.WOOL)));


        LIST.add(this);
    }

    public static ArrayList<PatternWoolTypes> values() {
        return LIST;
    }
}
