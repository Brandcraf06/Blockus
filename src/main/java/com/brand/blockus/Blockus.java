package com.brand.blockus;

import com.brand.blockus.content.*;
import com.brand.blockus.world.BlockusGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Blockus implements ModInitializer {

    public static final String MOD_ID = "blockus";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup BLOCKUS_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_building_blocks"), () -> new ItemStack(BlazeBricks.BLAZE_BRICKS));
    public static final ItemGroup BLOCKUS_DECORATIONS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_decorations"), () -> new ItemStack(Hedge.SMALL_HEDGE));
    public static final ItemGroup BLOCKUS_REDSTONE = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_redstone"), () -> new ItemStack(Other.REDSTONE_SAND));

    public static boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    public static boolean nothing(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    @Override
    public void onInitialize() {
        for (Biome biome : Registry.BIOME) {
            BlockusGen.addMineables(biome);
            BlockusGen.addWhiteOakTrees(biome);
            BlockusGen.addPlainsWhiteOakTrees(biome);
        }
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> BlockusGen.addMineables(biome));
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> BlockusGen.addPlainsWhiteOakTrees(biome));

        new WhiteOak();
        new CharredPlanks();
        new BambooPlanks();
        new Hedge();
        new LargeFlowerPots();
        new Barrels();
        new GlazedTerracottaPillars();
        new GlassRelated();
        new StoneRelated();
        new Asphalt();
        new ADGRelated();
        new LavaBricks();
        new WaterBricks();
        new MagmaBricks();
        new SoakedBricks();
        new SandstoneBricks();
        new HoneycombBricks();
        new SoulSandstone();
        new PrismarineRelated();
        new EndStoneRelated();
        new PurpurRelated();
        new ObsidianRelated();
        new Rainbow();
        new RedstoneLamps();
        new Limestone();
        new Marble();
        new Bluestone();
        new QuartzRelated();
        new PaperRelated();
        new NetherrackRelated();
        new NetherBricksRelated();
        new BlazeBricks();
        new FoodBlocks();
        new StainedStoneBricks();
        new PatternedWools();
        new ColoredTiles();
        new FuturneoBlocks();
        new Other();
        new LegacyBlocks();
        instance.init();

    }
}

