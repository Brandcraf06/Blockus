package com.brand.blockus.utils.helper;

import com.brand.blockus.registry.content.BlockusBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum WoodMaps {
    OAK("oak", Blocks.OAK_PLANKS, Blocks.OAK_SLAB, Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG, true),
    SPRUCE("spruce", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB, Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG, true),
    BIRCH("birch", Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB, Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG, true),
    JUNGLE("jungle", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB, Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG, true),
    ACACIA("acacia", Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB, Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, true),
    DARK_OAK("dark_oak", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, true),
    MANGROVE("mangrove", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_SLAB, Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG, true),
    CHERRY("cherry", Blocks.CHERRY_PLANKS, Blocks.CHERRY_SLAB, Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG, true),
    PALE_OAK("pale_oak", Blocks.PALE_OAK_PLANKS, Blocks.PALE_OAK_SLAB, Blocks.PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG, true),
    BAMBOO("bamboo", Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_SLAB, null, null, true),
    RAW_BAMBOO("raw_bamboo", BlockusBlocks.RAW_BAMBOO.planks(), BlockusBlocks.RAW_BAMBOO.slab(), null, null, true),
    WHITE_OAK("white_oak", BlockusBlocks.WHITE_OAK.planks(), BlockusBlocks.WHITE_OAK.slab(), BlockusBlocks.WHITE_OAK_LOG, BlockusBlocks.STRIPPED_WHITE_OAK_LOG, true),
    CRIMSON("crimson", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB, Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, false),
    WARPED("warped", Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB, Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, false),
    CHARRED("charred", BlockusBlocks.CHARRED.planks(), BlockusBlocks.CHARRED.slab(), null, null, false);

    public static final Map<String, WoodData> WOOD_DATA = Arrays.stream(values()).collect(Collectors.toMap(WoodMaps::getId, WoodMaps::data));
    public static final Map<String, Block> PLANKS_MAP = extract(WoodData::planks);
    public static final Map<String, Block> SLAB_MAP = extract(WoodData::slab);
    public static final Map<String, Block> LOG_MAP = extract(WoodData::log);
    public static final Map<String, Block> STRIPPED_LOG_MAP = extract(WoodData::strippedLog);
    public final String id;
    public final WoodData data;

    WoodMaps(String id, Block planks, Block slab, Block log, Block strippedLog, boolean isBurnable) {
        this.id = id;
        this.data = new WoodData(planks, slab, log, strippedLog, isBurnable);
    }

    public static <T> Map<String, T> extract(Function<WoodData, T> mapper) {
        return WOOD_DATA.entrySet().stream()
            .filter(e -> mapper.apply(e.getValue()) != null)
            .collect(Collectors.toMap(Map.Entry::getKey, e -> mapper.apply(e.getValue())));
    }

    public String getId() {
        return id;
    }

    public WoodData data() {
        return data;
    }

    public record WoodData(
        Block planks,
        Block slab,
        Block log,
        Block strippedLog,
        boolean isBurnable
    ) {
        public boolean isBurnable() {
            return isBurnable;
        }
    }
}
