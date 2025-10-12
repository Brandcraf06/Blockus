package com.brand.blockus.registry.content.bundles;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.*;
import net.minecraft.block.Oxidizable.OxidationLevel;
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

    public static <WaxedBlock extends Block, WeatheringBlock extends Block & Oxidizable> CopperBundle create(String baseId, TriFunction<String, Function<AbstractBlock.Settings, Block>, AbstractBlock.Settings, Block> registerFunction, Function<AbstractBlock.Settings, WaxedBlock> waxedBlockFactory, BiFunction<OxidationLevel, AbstractBlock.Settings, WeatheringBlock> unwaxedBlockFactory, Function<OxidationLevel, AbstractBlock.Settings> settingsFromOxidationLevel) {
        Block unaffected = registerFunction.apply(baseId, (Function)(settings) -> (Block)unwaxedBlockFactory.apply(OxidationLevel.UNAFFECTED, (AbstractBlock.Settings) settings), settingsFromOxidationLevel.apply(OxidationLevel.UNAFFECTED).mapColor(MapColor.ORANGE));
        Block exposed = registerFunction.apply("exposed_" + baseId, (Function)(settings) -> (Block)unwaxedBlockFactory.apply(OxidationLevel.EXPOSED, (AbstractBlock.Settings) settings), settingsFromOxidationLevel.apply(OxidationLevel.EXPOSED).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
        Block weathered = registerFunction.apply("weathered_" + baseId, (Function)(settings) -> (Block)unwaxedBlockFactory.apply(OxidationLevel.WEATHERED, (AbstractBlock.Settings) settings), settingsFromOxidationLevel.apply(OxidationLevel.WEATHERED).mapColor(MapColor.DARK_AQUA));
        Block oxidized = registerFunction.apply("oxidized_" + baseId, (Function)(settings) -> (Block)unwaxedBlockFactory.apply(OxidationLevel.OXIDIZED, (AbstractBlock.Settings) settings), settingsFromOxidationLevel.apply(OxidationLevel.OXIDIZED).mapColor(MapColor.TEAL));
        Objects.requireNonNull(waxedBlockFactory);
        Block waxed = registerFunction.apply("waxed_" + baseId, waxedBlockFactory::apply, settingsFromOxidationLevel.apply(OxidationLevel.UNAFFECTED).mapColor(MapColor.ORANGE));
        Objects.requireNonNull(waxedBlockFactory);
        Block waxedExposed = registerFunction.apply("waxed_exposed_" + baseId, waxedBlockFactory::apply, settingsFromOxidationLevel.apply(OxidationLevel.EXPOSED).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
        Objects.requireNonNull(waxedBlockFactory);
        Block waxedWeathered = registerFunction.apply("waxed_weathered_" + baseId, waxedBlockFactory::apply, settingsFromOxidationLevel.apply(OxidationLevel.WEATHERED).mapColor(MapColor.DARK_AQUA));
        Objects.requireNonNull(waxedBlockFactory);
        Block waxedOxidized = registerFunction.apply("waxed_oxidized_" + baseId, waxedBlockFactory::apply, settingsFromOxidationLevel.apply(OxidationLevel.OXIDIZED).mapColor(MapColor.TEAL));
        CopperBundle bundle = new CopperBundle(unaffected, exposed, weathered, oxidized, waxed, waxedExposed, waxedWeathered, waxedOxidized);
        LIST.add(bundle);
        return bundle;
    }

    public static BiFunction<OxidationLevel, AbstractBlock.Settings, OxidizableDoorBlock> oxidizableDoor(BlockSetType type) {
        return (oxidationLevel, settings) -> new OxidizableDoorBlock(type, oxidationLevel, settings);
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
