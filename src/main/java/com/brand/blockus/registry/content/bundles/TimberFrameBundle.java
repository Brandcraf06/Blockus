package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.OrientableBlockBase;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.List;

public record TimberFrameBundle(
    Block base,
    boolean burnable,
    Block block,
    Block diagonal,
    Block cross,
    Block lattice,
    Block grate
) {

    public static final List<TimberFrameBundle> LIST = new ArrayList<>();

    public static List<TimberFrameBundle> values() {
        return LIST;
    }

    public static String getWood(Block block) {
        return Registries.BLOCK.getId(block).getPath().replace("_planks", "");
    }

    public static Builder of(Block base, boolean burnable) {
        return new Builder(base, burnable);
    }

    public static Builder of(Block base) {
        return new Builder(base, true);
    }

    public List<Block> timberFrames() {
        return List.of(block, diagonal, cross);
    }

    public List<Block> all() {
        return List.of(block, diagonal, cross, lattice, grate);
    }

    public static class Builder {
        public final Block base;
        public boolean burnable;

        public Builder(Block base, boolean burnable) {
            this.base = base;
            this.burnable = burnable;
        }

        public TimberFrameBundle register() {
            AbstractBlock.Settings blockSettings = BlockFactory.createCopy(base).solid();

            if (burnable) {
                blockSettings = blockSettings.burnable();
            }
            String type = getWood(base);
            TimberFrameBundle bundle = new TimberFrameBundle(base, burnable,
                BlockFactory.registerOf(type + "_timber_frame", blockSettings),
                BlockFactory.registerOf(type + "_diagonal_timber_frame", OrientableBlockBase::new, blockSettings),
                BlockFactory.registerOf(type + "_cross_timber_frame", blockSettings),
                BlockFactory.registerCopy(type + "_lattice", PaneBlock::new, base),
                BlockFactory.registerCopy(type + "_grate", GrateBlock::new, base, settings -> settings.nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never))
            );
            LIST.add(bundle);
            return bundle;
        }
    }
}
