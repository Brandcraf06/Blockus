package com.brand.blockus.blocks;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.state.property.IntProperty;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class Utils {
    public static final Tag<Block> SMALL_HEDGES = TagRegistry.block(new Identifier(Blockus.MOD_ID, "small_hedges"));
    public static final IntProperty BITES_9 = IntProperty.of("bites", 0, 8);
}
