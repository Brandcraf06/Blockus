package com.brand.blockus.worldgen;

import com.brand.blockus.content.BlockusBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricWorldgenProvider;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryWrapper;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BlockusWorldgenProvider extends FabricWorldgenProvider {
    public BlockusWorldgenProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {

        // limestone
        ConfiguredFeature<?, ?> LIMESTONE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.LIMESTONE.block.getDefaultState(), 64));
        RegistryEntry<ConfiguredFeature<?, ?>> limestone = entries.add(BlockusWorldgenFeatures.LIMESTONE, LIMESTONE);

        PlacedFeature PLACED_LIMESTONE_UPPER = new PlacedFeature(limestone, BlockusWorldgenFeatures.modifiersWithRarity(6, HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(128))));
        entries.add(BlockusWorldgenFeatures.PLACED_LIMESTONE_UPPER, PLACED_LIMESTONE_UPPER);

        PlacedFeature PLACED_LIMESTONE_LOWER= new PlacedFeature(limestone, BlockusWorldgenFeatures.modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(60))));
        entries.add(BlockusWorldgenFeatures.PLACED_LIMESTONE_LOWER, PLACED_LIMESTONE_LOWER);

        // marble
        ConfiguredFeature<?, ?> MARBLE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.MARBLE.block.getDefaultState(), 64));
        RegistryEntry<ConfiguredFeature<?, ?>> marble = entries.add(BlockusWorldgenFeatures.MARBLE, MARBLE);

        PlacedFeature PLACED_MARBLE = new PlacedFeature(marble, BlockusWorldgenFeatures.modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))));
        entries.add(BlockusWorldgenFeatures.PLACED_MARBLE, PLACED_MARBLE);

        // bluestone
        ConfiguredFeature<?, ?> BLUESTONE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), BlockusBlocks.BLUESTONE.block.getDefaultState(), 64));
        RegistryEntry<ConfiguredFeature<?, ?>> bluestone = entries.add(BlockusWorldgenFeatures.BLUESTONE, BLUESTONE);

        PlacedFeature PLACED_BLUESTONE = new PlacedFeature(bluestone, BlockusWorldgenFeatures.modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))));
        entries.add(BlockusWorldgenFeatures.PLACED_BLUESTONE, PLACED_BLUESTONE);

        // viridite
        ConfiguredFeature<?, ?> VIRIDITE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockusBlocks.VIRIDITE.block.getDefaultState(), 64));
        RegistryEntry<ConfiguredFeature<?, ?>> viridite = entries.add(BlockusWorldgenFeatures.VIRIDITE, VIRIDITE);

        PlacedFeature PLACED_VIRIDITE = new PlacedFeature(viridite, BlockusWorldgenFeatures.modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-4))));
        entries.add(BlockusWorldgenFeatures.PLACED_VIRIDITE, PLACED_VIRIDITE);

        // white oak
        ConfiguredFeature<?, ?> WHITE_OAK = new ConfiguredFeature<>(Feature.TREE, BlockusWorldgenFeatures.white_oak().build());
        RegistryEntry<ConfiguredFeature<?, ?>> whiteOak = entries.add(BlockusWorldgenFeatures.WHITE_OAK, WHITE_OAK);

        PlacedFeature PLACED_WHITE_OAK = new PlacedFeature(whiteOak, List.of(new PlacementModifier[]{RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))}));
        entries.add(BlockusWorldgenFeatures.PLACED_WHITE_OAK, PLACED_WHITE_OAK);

        PlacedFeature PLACED_WHITE_OAK_RARE = new PlacedFeature(whiteOak, List.of(new PlacementModifier[]{RarityFilterPlacementModifier.of(240), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(BlockusBlocks.WHITE_OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN))}));
        entries.add(BlockusWorldgenFeatures.PLACED_WHITE_OAK_RARE, PLACED_WHITE_OAK_RARE);

        PlacedFeature WHITE_OAK_CHECKED = new PlacedFeature(whiteOak, List.of(new PlacementModifier[]{PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING)}));
        entries.add(BlockusWorldgenFeatures.WHITE_OAK_CHECKED, WHITE_OAK_CHECKED);

        // legacy oak
        ConfiguredFeature<?, ?> LEGACY_OAK = new ConfiguredFeature<>(Feature.TREE, BlockusWorldgenFeatures.legacy_oak().build());
        RegistryEntry<ConfiguredFeature<?, ?>> legacyOak = entries.add(BlockusWorldgenFeatures.LEGACY_OAK, LEGACY_OAK);

        PlacedFeature LEGACY_OAK_CHECKED = new PlacedFeature(legacyOak, List.of(new PlacementModifier[]{PlacedFeatures.wouldSurvive(BlockusBlocks.LEGACY_SAPLING)}));
        entries.add(BlockusWorldgenFeatures.LEGACY_OAK_CHECKED, LEGACY_OAK_CHECKED);

        // rainbow rose
        ConfiguredFeature<?, ?> RAINBOW_ROSE = new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchFeatureConfig(12, 7, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockusBlocks.RAINBOW_ROSE)))));
        RegistryEntry<ConfiguredFeature<?, ?>> rainbowRose = entries.add(BlockusWorldgenFeatures.RAINBOW_ROSE, RAINBOW_ROSE);

        PlacedFeature PLACED_RAINBOW_ROSE = new PlacedFeature(rainbowRose, List.of(new PlacementModifier[]{SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()}));
        entries.add(BlockusWorldgenFeatures.PLACED_RAINBOW_ROSE, PLACED_RAINBOW_ROSE);
    }

    @Override
    public String getName() {
        return "Blockus World Gen";
    }
}
