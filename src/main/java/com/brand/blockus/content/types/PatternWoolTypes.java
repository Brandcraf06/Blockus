package com.brand.blockus.content.types;

import com.brand.blockus.content.BlocksRegistration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
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

        Block.Settings blockSettings = FabricBlockSettings.of(Material.GENERIC, color).strength(0.8F).sounds(BlockSoundGroup.WOOL);

        this.block = BlocksRegistration.register(type, new Block(blockSettings));
        this.slab = BlocksRegistration.registerSlab(this.block);
        this.stairs = BlocksRegistration.registerStairs(this.block);
        this.carpet = BlocksRegistration.register(type.replace("wool", "carpet"), new DyedCarpetBlock(dyecolor, FabricBlockSettings.of(Material.ALLOWS_MOVEMENT_LIGHT_PASSES_THROUGH_NOT_SOLID, color).strength(0.1F).sounds(BlockSoundGroup.WOOL)));


        LIST.add(this);
    }

    public static ArrayList<PatternWoolTypes> values() {
        return LIST;
    }
}
