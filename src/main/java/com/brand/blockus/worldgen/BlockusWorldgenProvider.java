package com.brand.blockus.worldgen;

import com.brand.blockus.registry.content.BlockusBlocks;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.PlaceOnGroundDecorator;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.worldgen.BlockusWorldgenFeatures.*;

public class BlockusWorldgenProvider extends FabricDynamicRegistryProvider {
    public BlockusWorldgenProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries) {
        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), LIMESTONE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_LIMESTONE_UPPER);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_LIMESTONE_LOWER);

        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), MARBLE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_MARBLE);

        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), BLUESTONE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_BLUESTONE);

        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), VIRIDITE);
        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), VIRIDITE_EXTRA);

        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_VIRIDITE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_VIRIDITE_EXTRA);

        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), WHITE_OAK);
        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), WHITE_OAK_LEAF_LITTER);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_WHITE_OAK);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_WHITE_OAK_RARE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), WHITE_OAK_CHECKED);
        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), FALLEN_WHITE_OAK);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_FALLEN_WHITE_OAK);

        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), LEGACY_OAK);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), LEGACY_OAK_CHECKED);

        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), RAINBOW_ROSE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_RAINBOW_ROSE);
    }

    public static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        BlockStateProvider belowTrunkProvider = TreeConfiguration.defaultPlaceBelowTreeTrunkProvider(context.lookup(Registries.BIOME));
        FeatureUtils.register(context, LIMESTONE, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.LIMESTONE.block().defaultBlockState(), 64));
        FeatureUtils.register(context, MARBLE, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.MARBLE.block().defaultBlockState(), 64));
        FeatureUtils.register(context, BLUESTONE, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.BLUESTONE.block().defaultBlockState(), 64));
        FeatureUtils.register(context, VIRIDITE, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockusBlocks.VIRIDITE.block().defaultBlockState(), 33));
        FeatureUtils.register(context, VIRIDITE_EXTRA, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockusBlocks.VIRIDITE.block().defaultBlockState(), 42));

        PlaceOnGroundDecorator placeOnGroundTreeDecorator = new PlaceOnGroundDecorator(96, 4, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 3)));
        PlaceOnGroundDecorator placeOnGroundTreeDecorator2 = new PlaceOnGroundDecorator(150, 2, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 4)));
        FeatureUtils.register(context, WHITE_OAK, Feature.TREE, createWhiteOak(belowTrunkProvider).build());
        FeatureUtils.register(context, WHITE_OAK_LEAF_LITTER, Feature.TREE, createWhiteOak(belowTrunkProvider).decorators(ImmutableList.of(placeOnGroundTreeDecorator, placeOnGroundTreeDecorator2)).build());
        FeatureUtils.register(context, FALLEN_WHITE_OAK, Feature.FALLEN_TREE, fallen(BlockusBlocks.WHITE_OAK_LOG, 4, 9).build());

        FeatureUtils.register(context, LEGACY_OAK, Feature.TREE, createLegacyOak(belowTrunkProvider).build());
        FeatureUtils.register(context, RAINBOW_ROSE, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlockusBlocks.RAINBOW_ROSE)));
    }

    public static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // limestone
        Holder<ConfiguredFeature<?, ?>> limestone = configuredFeatures.getOrThrow(LIMESTONE);
        PlacementUtils.register(context, PLACED_LIMESTONE_UPPER, limestone, modifiersWithRarity(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        PlacementUtils.register(context, PLACED_LIMESTONE_LOWER, limestone, modifiersWithCount(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64))));

        // limestone
        PlacementUtils.register(context, PLACED_MARBLE, configuredFeatures.getOrThrow(MARBLE), modifiersWithCount(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64))));

        // bluestone
        PlacementUtils.register(context, PLACED_BLUESTONE, configuredFeatures.getOrThrow(BLUESTONE), modifiersWithCount(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(0))));

        // viridite
        PlacementUtils.register(context, PLACED_VIRIDITE, configuredFeatures.getOrThrow(VIRIDITE), modifiersWithCount(1, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(-16))));
        PlacementUtils.register(context, PLACED_VIRIDITE_EXTRA, configuredFeatures.getOrThrow(VIRIDITE_EXTRA), modifiersWithCount(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(-16))));

        // white oak
        Holder<ConfiguredFeature<?, ?>> whiteOakLeafLitter = configuredFeatures.getOrThrow(WHITE_OAK_LEAF_LITTER);
        PlacementUtils.register(context, PLACED_WHITE_OAK, whiteOakLeafLitter, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.04F, 1), BlockusBlocks.WHITE_OAK_SAPLING));
        PlacementUtils.register(context, PLACED_WHITE_OAK_RARE, whiteOakLeafLitter, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0125F, 1), BlockusBlocks.WHITE_OAK_SAPLING));
        PlacementUtils.register(context, WHITE_OAK_CHECKED, configuredFeatures.getOrThrow(WHITE_OAK), PlacementUtils.filteredByBlockSurvival(BlockusBlocks.WHITE_OAK_SAPLING));
        PlacementUtils.register(context, PLACED_FALLEN_WHITE_OAK, configuredFeatures.getOrThrow(FALLEN_WHITE_OAK), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0125F, 1), BlockusBlocks.WHITE_OAK_SAPLING));

        // legacy oak
        PlacementUtils.register(context, LEGACY_OAK_CHECKED, configuredFeatures.getOrThrow(LEGACY_OAK), PlacementUtils.filteredByBlockSurvival(BlockusBlocks.LEGACY_SAPLING));

        // rainbow rose
        PlacementUtils.register(context, PLACED_RAINBOW_ROSE, configuredFeatures.getOrThrow(RAINBOW_ROSE), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome(), CountPlacement.of(12), RandomOffsetPlacement.ofTriangle(7, 2), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE));
    }

    @Override
    public String getName() {
        return "Blockus World Gen";
    }
}
