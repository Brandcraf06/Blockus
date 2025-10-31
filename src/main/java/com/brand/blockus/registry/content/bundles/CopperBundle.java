package com.brand.blockus.registry.content.bundles;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.minecraft.world.level.block.WeatheringCopperDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import org.apache.commons.lang3.function.TriFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public record CopperBundle(Block unaffected, Block exposed, Block weathered, Block oxidized, Block waxed, Block waxedExposed, Block waxedWeathered, Block waxedOxidized) {

    public static final List<CopperBundle> LIST = new ArrayList<>();

    public static List<CopperBundle> values() {
        return LIST;
    }

    public static <WaxedBlock extends Block, WeatheringBlock extends Block & WeatheringCopper> CopperBundle create(String baseId, TriFunction<String, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> registerFunction, Function<BlockBehaviour.Properties, WaxedBlock> waxedBlockFactory, BiFunction<WeatherState, BlockBehaviour.Properties, WeatheringBlock> unwaxedBlockFactory, Function<WeatherState, BlockBehaviour.Properties> settingsFromOxidationLevel) {
        Block unaffected = registerFunction.apply(baseId, (Function)(settings) -> (Block)unwaxedBlockFactory.apply(WeatherState.UNAFFECTED, (BlockBehaviour.Properties) settings), settingsFromOxidationLevel.apply(WeatherState.UNAFFECTED).mapColor(MapColor.COLOR_ORANGE));
        Block exposed = registerFunction.apply("exposed_" + baseId, (Function)(settings) -> (Block)unwaxedBlockFactory.apply(WeatherState.EXPOSED, (BlockBehaviour.Properties) settings), settingsFromOxidationLevel.apply(WeatherState.EXPOSED).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
        Block weathered = registerFunction.apply("weathered_" + baseId, (Function)(settings) -> (Block)unwaxedBlockFactory.apply(WeatherState.WEATHERED, (BlockBehaviour.Properties) settings), settingsFromOxidationLevel.apply(WeatherState.WEATHERED).mapColor(MapColor.WARPED_STEM));
        Block oxidized = registerFunction.apply("oxidized_" + baseId, (Function)(settings) -> (Block)unwaxedBlockFactory.apply(WeatherState.OXIDIZED, (BlockBehaviour.Properties) settings), settingsFromOxidationLevel.apply(WeatherState.OXIDIZED).mapColor(MapColor.WARPED_NYLIUM));
        Objects.requireNonNull(waxedBlockFactory);
        Block waxed = registerFunction.apply("waxed_" + baseId, waxedBlockFactory::apply, settingsFromOxidationLevel.apply(WeatherState.UNAFFECTED).mapColor(MapColor.COLOR_ORANGE));
        Objects.requireNonNull(waxedBlockFactory);
        Block waxedExposed = registerFunction.apply("waxed_exposed_" + baseId, waxedBlockFactory::apply, settingsFromOxidationLevel.apply(WeatherState.EXPOSED).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
        Objects.requireNonNull(waxedBlockFactory);
        Block waxedWeathered = registerFunction.apply("waxed_weathered_" + baseId, waxedBlockFactory::apply, settingsFromOxidationLevel.apply(WeatherState.WEATHERED).mapColor(MapColor.WARPED_STEM));
        Objects.requireNonNull(waxedBlockFactory);
        Block waxedOxidized = registerFunction.apply("waxed_oxidized_" + baseId, waxedBlockFactory::apply, settingsFromOxidationLevel.apply(WeatherState.OXIDIZED).mapColor(MapColor.WARPED_NYLIUM));
        CopperBundle bundle = new CopperBundle(unaffected, exposed, weathered, oxidized, waxed, waxedExposed, waxedWeathered, waxedOxidized);
        LIST.add(bundle);
        return bundle;
    }

    public static BiFunction<WeatherState, BlockBehaviour.Properties, WeatheringCopperDoorBlock> oxidizableDoor(BlockSetType type) {
        return (oxidationLevel, settings) -> new WeatheringCopperDoorBlock(type, oxidationLevel, settings);
    }

    public ImmutableBiMap<Block, Block> getOxidizingMap() {
        return ImmutableBiMap.of(this.unaffected, this.exposed, this.exposed, this.weathered, this.weathered, this.oxidized);
    }

    public ImmutableBiMap<Block, Block> getWaxingMap() {
        return ImmutableBiMap.of(this.unaffected, this.waxed, this.exposed, this.waxedExposed, this.weathered, this.waxedWeathered, this.oxidized, this.waxedOxidized);
    }

    public ImmutableList<Block> getAll() {
        return ImmutableList.of(this.unaffected, this.waxed, this.exposed, this.waxedExposed, this.weathered, this.waxedWeathered, this.oxidized, this.waxedOxidized);
    }

    public void forEach(Consumer<Block> consumer) {
        consumer.accept(this.unaffected);
        consumer.accept(this.exposed);
        consumer.accept(this.weathered);
        consumer.accept(this.oxidized);
        consumer.accept(this.waxed);
        consumer.accept(this.waxedExposed);
        consumer.accept(this.waxedWeathered);
        consumer.accept(this.waxedOxidized);
    }
}
