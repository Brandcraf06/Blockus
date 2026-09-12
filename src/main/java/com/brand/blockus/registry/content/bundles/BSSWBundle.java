package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.utils.BlockChecker;
import com.brand.blockus.utils.helper.BlockBuilder;
import com.brand.blockus.utils.helper.BlockFactory;
import com.brand.blockus.utils.references.BlockusIds;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public record BSSWBundle(
    String type,
    Block base,
    Block block,
    Block stairs,
    Block slab,
    Block wall // Nullable
) {

    public static final List<BSSWBundle> LIST = new ArrayList<>();

    public static List<BSSWBundle> values() {
        return LIST;
    }

    public static UnaryOperator<Item.Properties> itemProperties(ResourceKey<ContextIntProvider> burnTime, boolean isBurnable) {
        return isBurnable ? p -> p.cookingFuel(burnTime) : UnaryOperator.identity();
    }

    public static Builder of(String type, BlockBuilder blockBuilder) {
        return new Builder(type, blockBuilder);
    }

    public static Builder of(String type, Block base) {
        return new Builder(type, new BlockBuilder(base));
    }

    public static Builder of(String type, Block base, MapColor mapcolor) {
        return new Builder(type, new BlockBuilder(base).properties(properties -> properties.mapColor(mapcolor)));
    }

    public static Builder of(String type, Block base, int luminance) {
        return new Builder(type, new BlockBuilder(base).properties(properties -> properties.lightLevel((state) -> luminance)));
    }

    public static Builder of(String type, Block base, PushReaction pistonBehavior) {
        return new Builder(type, new BlockBuilder(base).properties(properties -> properties.pushReaction(pistonBehavior)));
    }

    public static Builder of(String type, Block base, SoundType sound) {
        return new Builder(type, new BlockBuilder(base).properties(properties -> properties.sound(sound)));
    }

    public static Builder of(String type, Block base, float hardness, float resistance, MapColor mapcolor) {
        return new Builder(type, new BlockBuilder(base).properties(properties -> properties.strength(hardness, resistance).mapColor(mapcolor)));
    }

    public static Builder of(String type, float hardness, float resistance, MapColor color) {
        return new Builder(type, new BlockBuilder(BlockFactory.create()).properties(properties -> properties.strength(hardness, resistance).mapColor(color)));
    }

    public BlockItemId[] allIds() {
        List<BlockItemId> list = new ArrayList<>();
        list.add(BlockBuilder.getId(block));
        list.add(BlockBuilder.getId(stairs));
        list.add(BlockBuilder.getId(slab));
        if (wall != null) {
            list.add(BlockBuilder.getId(wall));
        }
        return list.toArray(new BlockItemId[0]);
    }

    public Block[] all() {
        List<Block> list = new ArrayList<>();
        list.add(block);
        list.add(stairs);
        list.add(slab);
        if (wall != null) {
            list.add(wall);
        }
        return list.toArray(new Block[0]);
    }

    public BlockItemId[] idsNoWall() {
        List<BlockItemId> list = new ArrayList<>();
        list.add(BlockBuilder.getId(block));
        list.add(BlockBuilder.getId(stairs));
        list.add(BlockBuilder.getId(slab));
        return list.toArray(new BlockItemId[0]);
    }

    public List<Block> noWall() {
        return List.of(block, stairs, slab);
    }

    public static class Builder {
        public final String type;
        public final BlockBuilder blockBuilder;
        public boolean includeWall = true;

        public Builder(String type, BlockBuilder blockBuilder) {
            this.type = type;
            this.blockBuilder = blockBuilder;
        }

        public Builder includeWall(boolean include) {
            this.includeWall = include;
            return this;
        }

        public BSSWBundle register(boolean isBurnable) {
            Block base = blockBuilder.getBase();
            if (BlockChecker.isAmethyst(type)) {
                blockBuilder.factory(AmethystBlock::new);
            } else if (BlockChecker.isRedstone(type)) {
                blockBuilder.factory(PoweredBlock::new);
            } else {
                blockBuilder.factory(Block::new);
            }

            Block block;
            if (isBurnable) {
                block = blockBuilder.cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS).register(BlockusIds.create(type));
            } else if (base == Blocks.HAY_BLOCK) {
                block = blockBuilder.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH).register(BlockusIds.create(type));
            } else {
                block = blockBuilder.register(BlockusIds.create(type));
            }

            BSSWBundle bundle = new BSSWBundle(type,
                base,
                block,
                BlockFactory.stairs(block, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS, isBurnable)),
                BlockFactory.slab(block, itemProperties(ContextIntProviders.COOKING_TIME_WOOD_SLABS, isBurnable)),
                includeWall ? BlockFactory.wall(block) : null
            );
            LIST.add(bundle);
            return bundle;
        }

        public BSSWBundle register() {
            return register(false);
        }
    }
}


