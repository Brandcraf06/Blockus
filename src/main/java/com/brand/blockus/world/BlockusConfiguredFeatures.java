package com.brand.blockus.world;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.NewStones;
import com.brand.blockus.content.NewWoods;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.Map;

public class BlockusConfiguredFeatures {

    public static final TreeFeatureConfig WHITE_OAK_TREE_CONFIG;
    public static final ConfiguredFeature<?, ?> LIMESTONE;
    public static final ConfiguredFeature<?, ?> BLUESTONE;
    public static final ConfiguredFeature<?, ?> MARBLE;
    public static final ConfiguredFeature<?, ?> WHITE_OAK_TREE;
    public static final ConfiguredFeature<?, ?> WHITE_OAK_TREE_RARE;
    private static final BlockState WHITE_OAK_LOG;
    private static final BlockState WHITE_OAK_LEAVES;

    // Will run when registerAndAddConfiguredFeatures is called
    static {
        WHITE_OAK_LOG = NewWoods.WHITE_OAK_LOG.getDefaultState();
        WHITE_OAK_LEAVES = NewWoods.WHITE_OAK_LEAVES.getDefaultState();
        WHITE_OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_OAK_LOG), new SimpleBlockStateProvider(WHITE_OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 5), new StraightTrunkPlacer(7, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();

        LIMESTONE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NewStones.LIMESTONE.getDefaultState(), 33)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(25, 0, 120)).spreadHorizontally().repeat(10));
        BLUESTONE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NewStones.BLUESTONE.getDefaultState(), 30)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 25)).spreadHorizontally().repeat(8));
        MARBLE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NewStones.MARBLE.getDefaultState(), 50)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 75)).spreadHorizontally().repeat(1));
        WHITE_OAK_TREE = Feature.TREE.configure(WHITE_OAK_TREE_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.05F, 1)));
        WHITE_OAK_TREE_RARE = Feature.TREE.configure(WHITE_OAK_TREE_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.0085F, 1)));

        registerConfiguredFeature();
    }

    public static void registerConfiguredFeature() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "limestone"), LIMESTONE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "bluestone"), BLUESTONE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "marble"), MARBLE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "white_oak_tree"), WHITE_OAK_TREE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Blockus.MOD_ID, "white_oak_tree_rare"), WHITE_OAK_TREE_RARE);
    }

    // Based on Applied-Energistics-2's way of registering and adding CFs.
    //
    // We are making an Instance of a ConfiguredFeature here in this class,
    // registering it to BuiltInRegisteries and adding it to the BuiltInRegisteries biomes.
    //
    // Now when we click on a world to enter, the DynamicRegisteries fires, copies the BuiltInRegisteries
    // entries and **makes its own instances** of everything in there. A copy of the object but not the
    // same object. Since we registered to the BuiltInRegisteries and added the CFs to BuiltInRegisteries
    // biomes, the CF Instance in the DynamicRegistries' CF registry and in the DynamicRegistries' biomes
    // will now match and things work smoothly.
    //
    // If we registered the CF to the BuiltInRegisteries CF registry BUT add this CF to the DynamicRegistries's
    // biomes by DynamicRegistryCallback.callback, the CF Instance the DynamicRegistry will make for it's
    // CF registry will not be the same object as the CF in the biome. THIS is the key point that causes so much
    // confusion. If we want to add to the biomes in the DynamicRegistries directly, we need to add our CF to the
    // DynamicRegistries's CF registry directly instead of the BuiltInRegistries. Basically, you can't mix and match
    // whether to register/add to BuiltIn or Dynamic. You have to either fully use BuiltIn or fully use Dynamic to
    // make life easier.
    public static void registerAndAddConfiguredFeatures() {
        for (Map.Entry<RegistryKey<Biome>, Biome> entry : BuiltinRegistries.BIOME.getEntries()) {
            BlockusGen.addMineables(entry.getKey(), entry.getValue());
            BlockusGen.addWhiteOakTrees(entry.getKey(), entry.getValue());
            BlockusGen.addPlainsWhiteOakTrees(entry.getKey(), entry.getValue());
        }
    }
}
