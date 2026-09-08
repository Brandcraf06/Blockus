package com.brand.blockus.worldgen;

import com.brand.blockus.Blockus;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BlockStateProviders;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.PlaceOnGroundDecorator;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.worldgen.BlockusWorldgenFeatures.*;

public class BlockusWorldgenProvider extends FabricDynamicRegistryProvider {
    public static ResourceKey<BlockStateProvider> LEGACY_GRASS_BENEATH_TREE = key("legacy_grass_beneath_tree");

    public BlockusWorldgenProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries) {
        entries.add(registries.lookupOrThrow(Registries.FEATURE), LIMESTONE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_LIMESTONE_UPPER);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_LIMESTONE_LOWER);

        entries.add(registries.lookupOrThrow(Registries.FEATURE), MARBLE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_MARBLE);

        entries.add(registries.lookupOrThrow(Registries.FEATURE), BLUESTONE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_BLUESTONE);

        entries.add(registries.lookupOrThrow(Registries.FEATURE), VIRIDITE);
        entries.add(registries.lookupOrThrow(Registries.FEATURE), VIRIDITE_EXTRA);

        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_VIRIDITE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_VIRIDITE_EXTRA);

        entries.add(registries.lookupOrThrow(Registries.FEATURE), WHITE_OAK);
        entries.add(registries.lookupOrThrow(Registries.FEATURE), WHITE_OAK_LEAF_LITTER);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_WHITE_OAK);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_WHITE_OAK_RARE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), WHITE_OAK_CHECKED);
        entries.add(registries.lookupOrThrow(Registries.FEATURE), FALLEN_WHITE_OAK);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_FALLEN_WHITE_OAK);

        entries.add(registries.lookupOrThrow(Registries.FEATURE), LEGACY_OAK);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), LEGACY_OAK_CHECKED);

        entries.add(registries.lookupOrThrow(Registries.FEATURE), RAINBOW_ROSE);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), PLACED_RAINBOW_ROSE);
    }

    public static void bootstrapBlockStateProvider(BootstrapContext<BlockStateProvider> context) {
        context.register(LEGACY_GRASS_BENEATH_TREE, RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesTag(BlockTags.SUBSTRATE_OVERWORLD), BlockusBlocks.LEGACY_GRASS_BLOCK));
    }

    public static void bootstrapFeatures(BootstrapContext<Feature> context) {
        HolderGetter<BlockStateProvider> blockStateProviders = context.lookup(Registries.BLOCK_STATE_PROVIDER);
        Holder<BlockStateProvider> belowTrunkProvider = blockStateProviders.getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE);
        context.register(LIMESTONE, new OreFeature(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.LIMESTONE.block().defaultBlockState(), 64));
        context.register(MARBLE, new OreFeature(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.MARBLE.block().defaultBlockState(), 64));
        context.register(BLUESTONE, new OreFeature(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.BLUESTONE.block().defaultBlockState(), 64));
        context.register(VIRIDITE, new OreFeature(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockusBlocks.VIRIDITE.block().defaultBlockState(), 33));
        context.register(VIRIDITE_EXTRA, new OreFeature(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockusBlocks.VIRIDITE.block().defaultBlockState(), 42));

        PlaceOnGroundDecorator sparseLeafLitter = new PlaceOnGroundDecorator(96, 4, 2, Holder.direct(new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 3))));
        PlaceOnGroundDecorator thickLeafLitter = new PlaceOnGroundDecorator(150, 2, 2, Holder.direct(new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 4))));
        context.register(WHITE_OAK, createWhiteOak(belowTrunkProvider).build());
        context.register(WHITE_OAK_LEAF_LITTER, createWhiteOak(belowTrunkProvider).decorators(ImmutableList.of(sparseLeafLitter, thickLeafLitter)).build());
        context.register(FALLEN_WHITE_OAK, createFallenTrees(BlockusBlocks.WHITE_OAK_LOG, 4, 9).build());
        context.register(LEGACY_OAK, createLegacyOak(belowTrunkProvider, blockStateProviders.getOrThrow(LEGACY_GRASS_BENEATH_TREE)).build());
        context.register(RAINBOW_ROSE, new SimpleBlockFeature(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE)));
    }

    public static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        HolderGetter<Feature> configuredFeatures = context.lookup(Registries.FEATURE);

        // limestone
        Holder<Feature> limestone = configuredFeatures.getOrThrow(LIMESTONE);
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
        Holder<Feature> whiteOakLeafLitter = configuredFeatures.getOrThrow(WHITE_OAK_LEAF_LITTER);
        PlacementUtils.register(context, PLACED_WHITE_OAK, whiteOakLeafLitter, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.04F, 1), BlockusBlocks.WHITE_OAK_SAPLING));
        PlacementUtils.register(context, PLACED_WHITE_OAK_RARE, whiteOakLeafLitter, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0125F, 1), BlockusBlocks.WHITE_OAK_SAPLING));
        PlacementUtils.register(context, WHITE_OAK_CHECKED, configuredFeatures.getOrThrow(WHITE_OAK), PlacementUtils.filteredByBlockSurvival(BlockusBlocks.WHITE_OAK_SAPLING));
        PlacementUtils.register(context, PLACED_FALLEN_WHITE_OAK, configuredFeatures.getOrThrow(FALLEN_WHITE_OAK), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0125F, 1), BlockusBlocks.WHITE_OAK_SAPLING));

        // legacy oak
        PlacementUtils.register(context, LEGACY_OAK_CHECKED, configuredFeatures.getOrThrow(LEGACY_OAK), PlacementUtils.filteredByBlockSurvival(BlockusBlocks.LEGACY_SAPLING));

        // rainbow rose
        PlacementUtils.register(context, PLACED_RAINBOW_ROSE, configuredFeatures.getOrThrow(RAINBOW_ROSE), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome(), CountPlacement.of(12), OffsetPlacement.ofTriangle(7, 2), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE));
    }

    private static ResourceKey<BlockStateProvider> key(String id) {
        return ResourceKey.create(Registries.BLOCK_STATE_PROVIDER, Blockus.id(id));
    }

    @Override
    public String getName() {
        return "Blockus World Gen";
    }
}
