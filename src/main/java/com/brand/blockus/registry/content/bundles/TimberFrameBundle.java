package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.OrientableBlockBase;
import com.brand.blockus.blocks.base.PostBlock;
import com.brand.blockus.utils.helper.BlockFactory;
import com.brand.blockus.utils.helper.WoodMaps;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public record TimberFrameBundle(Map<WoodMaps, TimberFrameVariants> woodMap) {

    public static final List<TimberFrameBundle> LIST = new ArrayList<>();

    public static List<TimberFrameBundle> values() {
        return LIST;
    }

    public static AbstractBlock.Settings settings(Block base, boolean isBurnable) {
        AbstractBlock.Settings blockSettings = BlockFactory.createCopy(base).solid();
        return isBurnable ? blockSettings.burnable() : blockSettings;
    }

    public List<Block> all() {
        List<Block> list = new ArrayList<>();
        for (WoodMaps wood : WoodMaps.values()) {
            TimberFrameVariants variants = woodMap.get(wood);
            if (variants != null) {
                list.add(variants.block());
                list.add(variants.diagonal());
                list.add(variants.cross());
                list.add(variants.lattice());
                list.add(variants.grate());
            }
        }
        return list;
    }

    public record TimberFrameVariants(Block block, Block diagonal, Block cross, Block lattice, Block grate) {}

    public static TimberFrameBundle register() {
        Map<WoodMaps, TimberFrameVariants> woodMap = new EnumMap<>(WoodMaps.class);

        for (WoodMaps wood : WoodMaps.values()) {
            Block planks = WoodMaps.PLANKS_MAP.get(wood.getId());
            if (planks == null) {
                System.err.println("[WARN] Missing planks for: " + wood.getId());
                continue;
            }
            Block block = BlockFactory.registerOf(wood.getId() + "_timber_frame", settings(planks, wood.data().isBurnable()));
            Block diagonal = BlockFactory.registerOf(wood.getId() + "_diagonal_timber_frame", OrientableBlockBase::new, settings(planks, wood.data().isBurnable()));
            Block cross = BlockFactory.registerOf(wood.getId() + "_cross_timber_frame", settings(planks, wood.data().isBurnable()));
            Block lattice = BlockFactory.registerCopy(wood.getId() + "_lattice", PaneBlock::new, planks);
            Block grate = BlockFactory.registerCopy(wood.getId() + "_grate", GrateBlock::new, planks, settings -> settings.nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never));

            woodMap.put(wood, new TimberFrameVariants(block, diagonal, cross, lattice, grate));
        }

        TimberFrameBundle bundle = new TimberFrameBundle(woodMap);
        LIST.add(bundle);
        return bundle;
    }
}
