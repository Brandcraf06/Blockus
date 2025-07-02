package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.asphalt.AsphaltBlock;
import com.brand.blockus.blocks.base.asphalt.AsphaltSlab;
import com.brand.blockus.blocks.base.asphalt.AsphaltStairs;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;

public class AsphaltBundle {
    public static final ArrayList<AsphaltBundle> LIST = new ArrayList<>();

    public final Block block;
    public final Block slab;
    public final Block stairs;

    public AsphaltBundle(DyeColor color) {
        String type = color.getId() + "_asphalt";
        String type2 = type.replace("black_asphalt", "asphalt");

        Block.Settings blockSettings = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASEDRUM).strength(1.5f, 6.0f).requiresTool();

        this.block = BlockFactory.registerOf(type2, AsphaltBlock::new, blockSettings);
        this.slab = BlockFactory.registerOf(type2 + "_slab", AsphaltSlab::new, AbstractBlock.Settings.copy(block));
        this.stairs = BlockFactory.registerOf(type2 + "_stairs", (settings) -> new AsphaltStairs(block.getDefaultState(), settings), AbstractBlock.Settings.copy(block));

        LIST.add(this);
    }
    public static ArrayList<AsphaltBundle> values() {
        return LIST;
    }
}
