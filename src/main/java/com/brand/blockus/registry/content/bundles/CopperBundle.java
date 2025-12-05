package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.OxidizableWallBlock;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraft.world.level.block.WeatheringCopperSlabBlock;
import net.minecraft.world.level.block.WeatheringCopperStairBlock;

import java.util.ArrayList;
import java.util.List;

public record CopperBundle(
    String type,
    Block base,
    Block block,
    Block stairs,
    Block slab,
    Block wall,
    Block blockWaxed,
    Block stairsWaxed,
    Block slabWaxed,
    Block wallWaxed
) {

    public static final List<CopperBundle> LIST = new ArrayList<>();

    public static List<CopperBundle> values() {
        return LIST;
    }

    public static Builder of(String type, OxidationType oxidation, Block base) {
        return new Builder(type, oxidation, base);
    }

    public List<Block> allBlocks() {
        return List.of(block, blockWaxed);
    }

    public List<Block> allSlabs() {
        return List.of(slab, slabWaxed);
    }

    public List<Block> allStairs() {
        return List.of(stairs, stairsWaxed);
    }

    public List<Block> allWalls() {
        return List.of(wall, wallWaxed);
    }

    public List<Block> allUnwaxed() {
        return List.of(block, stairs, slab, wall);
    }

    public List<Block> allWaxed() {
        return List.of(blockWaxed, stairsWaxed, slabWaxed, wallWaxed);
    }

    public List<Block> all() {
        return List.of(block, stairs, slab, wall, blockWaxed, stairsWaxed, slabWaxed, wallWaxed);
    }

    public enum OxidationType {
        UNAFFECTED(WeatherState.UNAFFECTED, ""),
        EXPOSED(WeatherState.EXPOSED, "exposed_"),
        WEATHERED(WeatherState.WEATHERED, "weathered_"),
        OXIDIZED(WeatherState.OXIDIZED, "oxidized_");

        private final WeatherState oxidationLevel;
        private final String prefix;

        OxidationType(WeatherState oxidationLevel, String prefix) {
            this.oxidationLevel = oxidationLevel;
            this.prefix = prefix;
        }

        public WeatherState getLevel() {
            return oxidationLevel;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    public static class Builder {
        public final String type;
        public final Block base;
        public final OxidationType oxidation;

        public Builder(String type, OxidationType oxidation, Block base) {
            this.type = type;
            this.base = base;
            this.oxidation = oxidation;
        }

        public CopperBundle register() {
            String prefix = oxidation.getPrefix();
            WeatherState oxidationLevel = oxidation.getLevel();
            Block block = BlockFactory.registerCopy(prefix + type, (settings) -> new WeatheringCopperFullBlock(oxidation.getLevel(), settings), base);
            Block blockWaxed = BlockFactory.registerCopy("waxed_" + prefix + type, base);
            CopperBundle bundle = new CopperBundle(type, base,
                block,
                BlockFactory.registerCopy(prefix + BlockFactory.replaceId(type) + "_stairs", (settings) -> new WeatheringCopperStairBlock(oxidationLevel, base.defaultBlockState(), settings), base),
                BlockFactory.registerCopy(prefix + BlockFactory.replaceId(type) + "_slab", (settings) -> new WeatheringCopperSlabBlock(oxidationLevel, settings), base),
                BlockFactory.registerCopy(prefix + BlockFactory.replaceId(type) + "_wall", (settings) -> new OxidizableWallBlock(oxidationLevel, settings), base),
                blockWaxed,
                BlockFactory.stairs(blockWaxed),
                BlockFactory.slab(blockWaxed),
                BlockFactory.wall(blockWaxed)
            );
            LIST.add(bundle);
            return bundle;
        }
    }
}
