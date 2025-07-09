package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.helper.BlockBuilder;
import com.brand.blockus.utils.helper.BlockMaps;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.DyeColor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public record StainedBSSWBundle(Map<DyeColor, BSSWBundle> colorMap) {

    public static Builder of(String id, Map<DyeColor, Block> baseBlockColorMap) {
        return new Builder(id, baseBlockColorMap);
    }

    public static Builder of(String id, Block baseBlock) {
        return new Builder(id, Arrays.stream(DyeColor.values()).collect(Collectors.toMap(color -> color, color -> baseBlock)));
    }

    public Block[] all() {
        List<Block> blocks = new ArrayList<>();
        for (BSSWBundle bsswBundle : colorMap.values()) {
            blocks.addAll(Arrays.asList(bsswBundle.all()));
        }
        return blocks.toArray(new Block[0]);
    }

    public static class Builder {
        private final String id;
        private final Map<DyeColor, Block> baseBlockColorMap;
        private Function<AbstractBlock.Settings, AbstractBlock.Settings> settings = null;
        private boolean includeWall = true;
        private boolean useMapColor = false;


        public Builder(String id, Map<DyeColor, Block> baseBlockColorMap) {
            this.id = id;
            this.baseBlockColorMap = baseBlockColorMap;
        }

        public Builder settings(Function<AbstractBlock.Settings, AbstractBlock.Settings> settings) {
            this.settings = settings;
            return this;
        }

        public Builder useMapColor() {
            this.useMapColor = true;
            return this;
        }

        public Builder includeWall(boolean include) {
            this.includeWall = include;
            return this;
        }

        public StainedBSSWBundle register() {
            Map<DyeColor, BSSWBundle> colorMap = new EnumMap<>(DyeColor.class);

            for (DyeColor color : DyeColor.values()) {
                String blockPath = color.getId() + "_" + this.id;
                Block baseBlock = baseBlockColorMap.get(color);
                BlockBuilder blockBuilder = new BlockBuilder(baseBlock);

                if (settings != null) {
                    blockBuilder.settings(settings);
                }

                if (useMapColor) {
                    blockBuilder.settings(s -> s.mapColor(BlockMaps.COLOR_MAP.get(color)));
                }

                BSSWBundle bundle = BSSWBundle.of(blockPath, blockBuilder).includeWall(includeWall).register();

                colorMap.put(color, bundle);
            }

            return new StainedBSSWBundle(colorMap);
        }
    }
}
