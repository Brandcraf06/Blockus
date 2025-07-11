package com.brand.blockus.worldgen;

import com.brand.blockus.registry.content.BlockusBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.*;

import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.worldgen.BlockusWorldgenFeatures.*;

public class BlockusWorldgenProvider extends FabricDynamicRegistryProvider {
    public BlockusWorldgenProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, FabricDynamicRegistryProvider.Entries entries) {
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), LIMESTONE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), PLACED_LIMESTONE_UPPER);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), PLACED_LIMESTONE_LOWER);

        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), MARBLE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), PLACED_MARBLE);

        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), BLUESTONE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), PLACED_BLUESTONE);

        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), VIRIDITE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), VIRIDITE_EXTRA);

        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), PLACED_VIRIDITE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), PLACED_VIRIDITE_EXTRA);

        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), WHITE_OAK);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), PLACED_WHITE_OAK);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), PLACED_WHITE_OAK_RARE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), WHITE_OAK_CHECKED);

        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), LEGACY_OAK);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), LEGACY_OAK_CHECKED);

        entries.add(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), RAINBOW_ROSE);
        entries.add(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), PLACED_RAINBOW_ROSE);
    }

    public static void bootstrapConfiguredFeatures(Registerable<ConfiguredFeature<?, ?>> registerable) {
        ConfiguredFeatures.register(registerable, LIMESTONE, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.LIMESTONE.block().getDefaultState(), 64));
        ConfiguredFeatures.register(registerable, MARBLE, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.MARBLE.block().getDefaultState(), 64));
        ConfiguredFeatures.register(registerable, BLUESTONE, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.BLUESTONE.block().getDefaultState(), 64));
        ConfiguredFeatures.register(registerable, VIRIDITE, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockusBlocks.VIRIDITE.block().getDefaultState(), 33));
        ConfiguredFeatures.register(registerable, VIRIDITE_EXTRA, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockusBlocks.VIRIDITE.block().getDefaultState(), 42));

        ConfiguredFeatures.register(registerable, WHITE_OAK, Feature.TREE, white_oak().build());

        ConfiguredFeatures.register(registerable, LEGACY_OAK, Feature.TREE, legacy_oak().build());

        ConfiguredFeatures.register(registerable, RAINBOW_ROSE, Feature.FLOWER, new RandomPatchFeatureConfig(12, 7, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE)))));
    }

    public static void bootstrapPlacedFeatures(Registerable<PlacedFeature> registerable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // limestone
        RegistryEntry<ConfiguredFeature<?, ?>> limestone = configuredFeatures.getOrThrow(LIMESTONE);
        PlacedFeatures.register(registerable, PLACED_LIMESTONE_UPPER, limestone, modifiersWithRarity(6, HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(128))));
        PlacedFeatures.register(registerable, PLACED_LIMESTONE_LOWER, limestone, modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))));

        // limestone
        PlacedFeatures.register(registerable, PLACED_MARBLE, configuredFeatures.getOrThrow(MARBLE), modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))));

        // bluestone
        PlacedFeatures.register(registerable, PLACED_BLUESTONE, configuredFeatures.getOrThrow(BLUESTONE), modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))));

        // viridite
        PlacedFeatures.register(registerable, PLACED_VIRIDITE, configuredFeatures.getOrThrow(VIRIDITE), modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-16))));
        PlacedFeatures.register(registerable, PLACED_VIRIDITE_EXTRA, configuredFeatures.getOrThrow(VIRIDITE_EXTRA), modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-16))));

        // white oak
        RegistryEntry<ConfiguredFeature<?, ?>> whiteOak = configuredFeatures.getOrThrow(WHITE_OAK);
        PlacedFeatures.register(registerable, PLACED_WHITE_OAK, whiteOak, VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.04F, 1), BlockusBlocks.WHITE_OAK_SAPLING));
        PlacedFeatures.register(registerable, PLACED_WHITE_OAK_RARE, whiteOak, VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.0125F, 1), BlockusBlocks.WHITE_OAK_SAPLING));
        PlacedFeatures.register(registerable, WHITE_OAK_CHECKED, configuredFeatures.getOrThrow(WHITE_OAK), PlacedFeatures.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING));

        // legacy oak
        PlacedFeatures.register(registerable, LEGACY_OAK_CHECKED, configuredFeatures.getOrThrow(LEGACY_OAK), PlacedFeatures.wouldSurvive(BlockusBlocks.LEGACY_SAPLING));

        // rainbow rose
        PlacedFeatures.register(registerable, PLACED_RAINBOW_ROSE, configuredFeatures.getOrThrow(RAINBOW_ROSE), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    @Override
    public String getName() {
        return "Blockus World Gen";
    }
}
