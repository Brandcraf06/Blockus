package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.PostBlock;
import com.brand.blockus.utils.BlockFactory;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;

public class WoodenPostBundle {
    private static final ArrayList<WoodenPostBundle> LIST = new ArrayList<>();
    public final Block base;
    public final Block baseStripped;
    public final Block block;
    public final Block stripped;
    public boolean burnable;

    public WoodenPostBundle(String name, Block base, Block base2, boolean burnable) {
        this.base = base;
        this.baseStripped = base2;
        this.burnable = burnable;

        AbstractBlock.Settings blockSettings = AbstractBlock.Settings.copy(base).solid();

        if (burnable) {
            blockSettings = blockSettings.burnable();
        }

        this.block = BlockFactory.register(name, new PostBlock(blockSettings));
        this.stripped = BlockFactory.register("stripped_" + name, new PostBlock(blockSettings));

        LIST.add(this);
    }

    public WoodenPostBundle(String name, Block base, Block base2) {
        this(name, base, base2, true);
    }

    public static ArrayList<WoodenPostBundle> values() {
        return LIST;
    }

    public boolean isBurnable() {
        return this.burnable;
    }
}
