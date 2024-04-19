package com.brand.blockus.worldgen;

import com.brand.blockus.content.BlockusBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BlockusWorldgenProvider extends FabricDynamicRegistryProvider {
    public BlockusWorldgenProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, FabricDynamicRegistryProvider.Entries entries) {
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), BlockusWorldgenFeatures.LIMESTONE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.PLACED_LIMESTONE_UPPER);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.PLACED_LIMESTONE_LOWER);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), BlockusWorldgenFeatures.MARBLE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.PLACED_MARBLE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), BlockusWorldgenFeatures.BLUESTONE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.PLACED_BLUESTONE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), BlockusWorldgenFeatures.VIRIDITE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), BlockusWorldgenFeatures.VIRIDITE_EXTRA);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.PLACED_VIRIDITE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.PLACED_VIRIDITE_EXTRA);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), BlockusWorldgenFeatures.WHITE_OAK);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.PLACED_WHITE_OAK);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.PLACED_WHITE_OAK_RARE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.WHITE_OAK_CHECKED);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), BlockusWorldgenFeatures.LEGACY_OAK);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.LEGACY_OAK_CHECKED);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), BlockusWorldgenFeatures.RAINBOW_ROSE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), BlockusWorldgenFeatures.PLACED_RAINBOW_ROSE);
    }

    public static void bootstrapConfiguredFeatures(Registerable<ConfiguredFeature<?, ?>> registerable) {
        ConfiguredFeatures.register(registerable, BlockusWorldgenFeatures.LIMESTONE, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.LIMESTONE.block.getDefaultState(), 64));
        ConfiguredFeatures.register(registerable, BlockusWorldgenFeatures.MARBLE, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.MARBLE.block.getDefaultState(), 64));
        ConfiguredFeatures.register(registerable, BlockusWorldgenFeatures.BLUESTONE, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.BLUESTONE.block.getDefaultState(), 64));
        ConfiguredFeatures.register(registerable, BlockusWorldgenFeatures.VIRIDITE, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockusBlocks.VIRIDITE.block.getDefaultState(), 33));
        ConfiguredFeatures.register(registerable, BlockusWorldgenFeatures.VIRIDITE_EXTRA, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockusBlocks.VIRIDITE.block.getDefaultState(), 42));
        ConfiguredFeatures.register(registerable, BlockusWorldgenFeatures.WHITE_OAK, Feature.TREE, BlockusWorldgenFeatures.white_oak().build());
        ConfiguredFeatures.register(registerable, BlockusWorldgenFeatures.LEGACY_OAK, Feature.TREE, BlockusWorldgenFeatures.legacy_oak().build());
        ConfiguredFeatures.register(registerable, BlockusWorldgenFeatures.RAINBOW_ROSE, Feature.FLOWER, new RandomPatchFeatureConfig(12, 7, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE)))));
    }

    public static void bootstrapPlacedFeatures(Registerable<PlacedFeature> registerable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // limestone
        RegistryEntry<ConfiguredFeature<?, ?>> limestone = configuredFeatures.getOrThrow(BlockusWorldgenFeatures.LIMESTONE);
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.PLACED_LIMESTONE_UPPER, limestone, BlockusWorldgenFeatures.modifiersWithRarity(6, HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(128))));
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.PLACED_LIMESTONE_LOWER, limestone, BlockusWorldgenFeatures.modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))));

        // limestone
        RegistryEntry<ConfiguredFeature<?, ?>> marble = configuredFeatures.getOrThrow(BlockusWorldgenFeatures.MARBLE);
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.PLACED_MARBLE, marble, BlockusWorldgenFeatures.modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))));

        // bluestone
        RegistryEntry<ConfiguredFeature<?, ?>> bluestone = configuredFeatures.getOrThrow(BlockusWorldgenFeatures.BLUESTONE);
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.PLACED_BLUESTONE, bluestone, BlockusWorldgenFeatures.modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))));

        // viridite
        RegistryEntry<ConfiguredFeature<?, ?>> viridite = configuredFeatures.getOrThrow(BlockusWorldgenFeatures.VIRIDITE);
        RegistryEntry<ConfiguredFeature<?, ?>> viriditeExtra = configuredFeatures.getOrThrow(BlockusWorldgenFeatures.VIRIDITE_EXTRA);
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.PLACED_VIRIDITE, viridite, BlockusWorldgenFeatures.modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-16))));
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.PLACED_VIRIDITE_EXTRA, viriditeExtra, BlockusWorldgenFeatures.modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-16))));

        // white oak
        RegistryEntry<ConfiguredFeature<?, ?>> whiteOak = configuredFeatures.getOrThrow(BlockusWorldgenFeatures.WHITE_OAK);
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.PLACED_WHITE_OAK, whiteOak, RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)));
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.PLACED_WHITE_OAK_RARE, whiteOak, RarityFilterPlacementModifier.of(192), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)));
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.WHITE_OAK_CHECKED, whiteOak, PlacedFeatures.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING));

        // legacy oak
        RegistryEntry<ConfiguredFeature<?, ?>> legacyOak = configuredFeatures.getOrThrow(BlockusWorldgenFeatures.LEGACY_OAK);
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.LEGACY_OAK_CHECKED, legacyOak, PlacedFeatures.wouldSurvive(BlockusBlocks.LEGACY_SAPLING));

        // rainbow rose
        RegistryEntry<ConfiguredFeature<?, ?>> rainbowRose = configuredFeatures.getOrThrow(BlockusWorldgenFeatures.RAINBOW_ROSE);
        PlacedFeatures.register(registerable, BlockusWorldgenFeatures.PLACED_RAINBOW_ROSE, rainbowRose, SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    @Override
    public String getName() {
        return "Blockus World Gen";
    }
}
