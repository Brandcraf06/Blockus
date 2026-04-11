package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.WoodMaps;
import net.minecraft.world.level.block.Block;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class ExtraWoodBundle<T> {
    private final Map<String, T> blocks;

    private ExtraWoodBundle(Map<String, T> blocks) {
        this.blocks = Map.copyOf(blocks);
    }

    public Map<String, T> bundle() {
        return blocks;
    }

    public T get(String wood) {
        return blocks.get(wood);
    }

    public static <T> ExtraWoodBundle<T> of(Function<String, T> blockFactory) {
        Map<String, T> map = new LinkedHashMap<>();
        for (WoodMaps wood : WoodMaps.values()) {
            T block = blockFactory.apply(wood.getId());
            if (block != null) {
                map.put(wood.getId(), block);
            }
        }
        return new ExtraWoodBundle<>(map);
    }

    public static ExtraWoodBundle<BSSWBundle> register(Function<String, String> string, Function<String, Block> baseBlockProvider, Set<WoodMaps> exclude) {
        Map<String, BSSWBundle> map = new LinkedHashMap<>();
        for (WoodMaps wood : WoodMaps.values()) {
            if (exclude.contains(wood)) continue;
            String id = string.apply(wood.getId());
            Block baseBlock = baseBlockProvider.apply(wood.getId());
            BSSWBundle bundle = BSSWBundle.of(id, baseBlock).includeWall(false).register();
            map.put(wood.getId(), bundle);
        }
        return new ExtraWoodBundle<>(map);
    }

    public static ExtraWoodBundle<BSSWBundle> register(Function<String, String> string, Function<String, Block> baseBlockProvider) {
        return register(string, baseBlockProvider, Set.of());
    }

    public static Set<WoodMaps> exclude(WoodMaps... types) {
        return Set.of(types);
    }
}
