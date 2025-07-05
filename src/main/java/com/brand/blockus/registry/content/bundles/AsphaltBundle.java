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
import java.util.List;

public record AsphaltBundle(
    Block block,
    Block stairs,
    Block slab
) {

    public static final List<AsphaltBundle> LIST = new ArrayList<>();

    public static List<AsphaltBundle> values() {
        return LIST;
    }

    public static Builder of(DyeColor color) {
        return new Builder(color);
    }

    public List<Block> all() {
        return List.of(block, stairs, slab);
    }

    public static class Builder {
        public final DyeColor color;

        public Builder(DyeColor color) {
            this.color = color;
        }

        public AsphaltBundle register() {
            String type = color.getId() + "_asphalt";
            String type2 = type.replace("black_asphalt", "asphalt");

            Block.Settings blockSettings = BlockFactory.create().mapColor(color).instrument(NoteBlockInstrument.BASEDRUM).strength(1.5f, 6.0f).requiresTool();
            Block block = BlockFactory.registerOf(type2, AsphaltBlock::new, blockSettings);
            AsphaltBundle bundle = new AsphaltBundle(
                block,
                BlockFactory.registerOf(type2 + "_stairs", (settings) -> new AsphaltStairs(block.getDefaultState(), settings), AbstractBlock.Settings.copy(block)),
                BlockFactory.registerOf(type2 + "_slab", AsphaltSlab::new, AbstractBlock.Settings.copy(block))
            );
            LIST.add(bundle);
            return bundle;
        }
    }
}
