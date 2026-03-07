package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.PostBlock;
import com.brand.blockus.utils.helper.BlockFactory;
import com.brand.blockus.utils.helper.WoodMaps;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public record WoodenPostBundle(Map<WoodMaps, WoodenPostVariants> woodMap) {

    public static final List<WoodenPostBundle> LIST = new ArrayList<>();

    public static List<WoodenPostBundle> values() {
        return LIST;
    }

    public static BlockBehaviour.Properties properties(Block base, boolean isBurnable) {
        BlockBehaviour.Properties blockProperties = BlockFactory.createCopy(base).forceSolidOn();
        return isBurnable ? blockProperties.ignitedByLava() : blockProperties;
    }

    public List<Block> all() {
        List<Block> list = new ArrayList<>();
        for (WoodMaps wood : WoodMaps.values()) {
            WoodenPostVariants variants = woodMap.get(wood);
            if (variants != null) {
                list.add(variants.block());
                list.add(variants.stripped());
            }
        }
        return list;
    }

    public record WoodenPostVariants(Block block, Block stripped) {
    }

    public static WoodenPostBundle register() {
        Map<WoodMaps, WoodenPostVariants> woodMap = new EnumMap<>(WoodMaps.class);

        for (WoodMaps wood : WoodMaps.values()) {
            Block log = WoodMaps.LOG_MAP.get(wood.getId());
            Block strippedLog = WoodMaps.STRIPPED_LOG_MAP.get(wood.getId());

            if (log == null || strippedLog == null) {
                continue;
            }

            String id = wood.getId() + "_post";

            Block block = BlockFactory.registerOf(id, PostBlock::new, properties(log, wood.data().isBurnable()));
            Block stripped = BlockFactory.registerOf("stripped_" + id, PostBlock::new, properties(strippedLog, wood.data().isBurnable()));

            woodMap.put(wood, new WoodenPostVariants(block, stripped));
        }

        WoodenPostBundle bundle = new WoodenPostBundle(woodMap);
        LIST.add(bundle);
        return bundle;
    }
}
