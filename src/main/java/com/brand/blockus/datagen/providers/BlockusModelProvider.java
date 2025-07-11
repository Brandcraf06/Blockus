package com.brand.blockus.datagen.providers;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.PostBlock;
import com.brand.blockus.datagen.family.BlockusFamilies;
import com.brand.blockus.datagen.models.BlockusModels;
import com.brand.blockus.datagen.models.BlockusTextureKey;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import static net.minecraft.client.data.BlockStateModelGenerator.*;

public class BlockusModelProvider extends FabricModelProvider {

    public BlockusModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {

        BlockusFamilies.getFamilies().filter(BlockFamily::shouldGenerateModels).forEach((family) -> {
            modelGenerator.registerCubeAllModelTexturePool(family.getBaseBlock()).family(family);
        });

        for (BSSWBundle BSSWBundle : BSSWBundle.values()) {
            // Rough Sandstones
            if (BSSWBundle.type().contains("rough") && BSSWBundle.type().contains("sandstone")) {
                this.registerBlockStairsSlabWithBottom(modelGenerator, BSSWBundle.block(), BSSWBundle.stairs(), BSSWBundle.slab(), BSSWBundle.base());
            }
            // Smooth Sandstones & Rough Basalt
            else if ((BSSWBundle.type().contains("smooth") && BSSWBundle.type().contains("sandstone")) ||
                BSSWBundle.block() == BlockusBlocks.ROUGH_BASALT.block()) {
                this.registerBlockStairsSlabWithTop(modelGenerator, BSSWBundle.block(), BSSWBundle.stairs(), BSSWBundle.slab(), BSSWBundle.base());
            }
            // Soul Sandstone
            else if (BSSWBundle.block() == BlockusBlocks.SOUL_SANDSTONE.block()) {
                this.registerBlockStairsSlabwithTopBottom(modelGenerator, BSSWBundle.block(), BSSWBundle.stairs(), BSSWBundle.slab());
            }
            // Autre
            else {
                this.registerBlockStairsAndSlab(modelGenerator, BSSWBundle.block(), BSSWBundle.stairs(), BSSWBundle.slab());
            }

            if (BSSWBundle.wall() != null) {
                this.registerWall(modelGenerator, BSSWBundle.wall(), BSSWBundle.block());
            }
        }

        for (ConcreteBundle concrete : ConcreteBundle.values()) {
            for (ConcreteBundle.ConcreteVariants variants : concrete.colorMap().values()) {
                this.registerBlockStairsSlabAndWall(modelGenerator, variants.block(), variants.stairs(), variants.slab(), variants.wall());
                modelGenerator.registerSimpleCubeAll(variants.chiseled());
                this.registerPillar(modelGenerator, variants.pillar());
            }
        }

        for (AsphaltBundle.AsphaltVariants asphaltBundle : BlockusBlocks.ASPHALT.colorMap().values()) {
            this.registerBlockStairsAndSlab(modelGenerator, asphaltBundle.block(), asphaltBundle.stairs(), asphaltBundle.slab());
        }

        for (WoolBundle woolBundle : WoolBundle.values()) {
            for (WoolBundle.WoolVariants variants : woolBundle.colorMap().values()) {
                this.registerBlockStairsAndSlab(modelGenerator, variants.block(), variants.stairs(), variants.slab());
                this.registerCarpet(modelGenerator, variants.block(), variants.carpet());
            }
        }

        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            registerColoredTiles(modelGenerator, coloredTilesVariants.block(), coloredTilesVariants.tile1(), coloredTilesVariants.tile2());
        }

        for (PottedLargeBundle pottedLargeBundle : PottedLargeBundle.values()) {
            modelGenerator.registerSimpleState(pottedLargeBundle.block());
        }
        modelGenerator.registerSimpleState(BlockusBlocks.LARGE_FLOWER_POT);

        // Copper
        registerCopperBlocks(modelGenerator, BlockusBlocks.COPPER_BRICKS, BlockusFamilies.COPPER_BRICKS);
        registerCopperBlocks(modelGenerator, BlockusBlocks.EXPOSED_COPPER_BRICKS, BlockusFamilies.EXPOSED_COPPER_BRICKS);
        registerCopperBlocks(modelGenerator, BlockusBlocks.WEATHERED_COPPER_BRICKS, BlockusFamilies.WEATHERED_COPPER_BRICKS);
        registerCopperBlocks(modelGenerator, BlockusBlocks.OXIDIZED_COPPER_BRICKS, BlockusFamilies.OXIDIZED_COPPER_BRICKS);
        registerCopperBlocks(modelGenerator, BlockusBlocks.COPPER_TUFF_BRICKS, BlockusFamilies.COPPER_TUFF_BRICKS);
        registerCopperBlocks(modelGenerator, BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS, BlockusFamilies.EXPOSED_COPPER_TUFF_BRICKS);
        registerCopperBlocks(modelGenerator, BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS, BlockusFamilies.WEATHERED_COPPER_TUFF_BRICKS);
        registerCopperBlocks(modelGenerator, BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS, BlockusFamilies.OXIDIZED_COPPER_TUFF_BRICKS);

        // Stone
        this.registerPillar(modelGenerator, BlockusBlocks.STONE_BRICK_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_STONE_BRICKS);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.STONE_CIRCULAR_PAVING);
        modelGenerator.registerDoor(BlockusBlocks.STONE_DOOR);
        modelGenerator.registerOrientableTrapdoor(BlockusBlocks.STONE_TRAPDOOR);
        this.registerSturdyStone(modelGenerator);
        this.registerSmoothStoneStairs(modelGenerator);

        // Andesite
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.ANDESITE_CIRCULAR_PAVING);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_ANDESITE_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CRACKED_ANDESITE_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_ANDESITE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_ANDESITE_BUTTON, Blocks.POLISHED_ANDESITE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_ANDESITE_BRICKS);

        // Diorite
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_DIORITE_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CRACKED_DIORITE_BRICKS);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.DIORITE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_DIORITE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_DIORITE_BUTTON, Blocks.POLISHED_DIORITE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_DIORITE_BRICKS);

        // Granite
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_GRANITE_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CRACKED_GRANITE_BRICKS);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.GRANITE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_GRANITE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_GRANITE_BUTTON, Blocks.POLISHED_GRANITE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_GRANITE_BRICKS);

        // Mud
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_MUD_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.MUD_BRICK_PILLAR);

        // Dripstone
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_DRIPSTONE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.DRIPSTONE_PILLAR);

        // Tuff
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CARVED_TUFF_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CRACKED_TUFF_BRICKS);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE, BlockusBlocks.POLISHED_TUFF_BUTTON, Blocks.POLISHED_TUFF);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.TUFF_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.TUFF_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_TUFF_BRICKS);

        // Deepslate
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.DEEPSLATE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.DEEPSLATE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE, BlockusBlocks.POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.STURDY_DEEPSLATE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_DEEPSLATE_BRICKS);

        // Sculk
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_SCULK_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.SCULK_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_SCULK_PRESSURE_PLATE, BlockusBlocks.POLISHED_SCULK_BUTTON, BlockusBlocks.POLISHED_SCULK.block());

        // Amethyst
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_AMETHYST);
        this.registerPillar(modelGenerator, BlockusBlocks.AMETHYST_PILLAR);
        this.registerAmethystLamp(modelGenerator);

        // Blackstone
        modelGenerator.registerOrientableTrapdoor(BlockusBlocks.BLACKSTONE_TRAPDOOR);
        this.registerCubeColumnNoSuffix(modelGenerator, BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.POLISHED_BLACKSTONE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_BLACKSTONE_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.STURDY_BLACKSTONE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_POLISHED_BLACKSTONE_BRICKS);
        modelGenerator.registerDoor(BlockusBlocks.BLACKSTONE_DOOR);

        // Basalt
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_POLISHED_BASALT);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.POLISHED_BASALT_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_BASALT_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE, BlockusBlocks.POLISHED_BASALT_BUTTON, TextureMap.getSubId(Blocks.POLISHED_BASALT, "_top"));
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_POLISHED_BASALT_BRICKS);

        // Limestone
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_LIMESTONE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_LIMESTONE_BRICKS, BlockusBlocks.POLISHED_LIMESTONE.block());
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.LIMESTONE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.LIMESTONE_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.CHISELED_LIMESTONE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.LIMESTONE_PRESSURE_PLATE, BlockusBlocks.LIMESTONE_BUTTON, BlockusBlocks.LIMESTONE.block());
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LIMESTONE_SQUARES);
        this.registerLines(modelGenerator, BlockusBlocks.LIMESTONE_LINES);

        // Marble
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_MARBLE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_MARBLE_BRICKS, BlockusBlocks.POLISHED_MARBLE.block());
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.MARBLE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.MARBLE_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.CHISELED_MARBLE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.MARBLE_PRESSURE_PLATE, BlockusBlocks.MARBLE_BUTTON, BlockusBlocks.MARBLE.block());
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.MARBLE_SQUARES);
        this.registerLines(modelGenerator, BlockusBlocks.MARBLE_LINES);

        // Bluestone
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.BLUESTONE_CIRCULAR_PAVING);
        this.registerLines(modelGenerator, BlockusBlocks.BLUESTONE_LINES);
        this.registerPillar(modelGenerator, BlockusBlocks.BLUESTONE_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.CHISELED_BLUESTONE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.BLUESTONE_PRESSURE_PLATE, BlockusBlocks.BLUESTONE_BUTTON, BlockusBlocks.BLUESTONE.block());
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.BLUESTONE_SQUARES);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_BLUESTONE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_BLUESTONE_BRICKS, BlockusBlocks.POLISHED_BLUESTONE.block());


        // Viridite
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_VIRIDITE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_VIRIDITE_BRICKS, BlockusBlocks.POLISHED_VIRIDITE.block());
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.VIRIDITE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.VIRIDITE_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.CHISELED_VIRIDITE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.VIRIDITE_PRESSURE_PLATE, BlockusBlocks.VIRIDITE_BUTTON, BlockusBlocks.VIRIDITE.block());
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.VIRIDITE_SQUARES);
        this.registerLines(modelGenerator, BlockusBlocks.VIRIDITE_LINES);

        // Lava & Water Bricks
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_LAVA_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_LAVA_POLISHED_BLACKSTONE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_WATER_BRICKS);

        // Snow & Ice Bricks
        this.registerPillar(modelGenerator, BlockusBlocks.SNOW_PILLAR);
        modelGenerator.registerCubeAllModelTexturePool(BlockusBlocks.ICE_BRICKS).wall(BlockusBlocks.ICE_BRICK_WALL);
        this.registerPillar(modelGenerator, BlockusBlocks.ICE_PILLAR);

        // Obsidian
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.GLOWING_OBSIDIAN);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.OBSIDIAN_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.OBSIDIAN_PILLAR);
        modelGenerator.registerOrientableTrapdoor(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR);
        modelGenerator.registerDoor(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR);
        this.registerPressurePlate(modelGenerator, BlockusBlocks.OBSIDIAN_PRESSURE_PLATE, TextureMap.getId(Blocks.OBSIDIAN));


        // Netherrack
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.NETHERRACK_CIRCULAR_PAVING);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE, BlockusBlocks.POLISHED_NETHERRACK_BUTTON, BlockusBlocks.POLISHED_NETHERRACK.block());

        // Quartz Blocks
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.QUARTZ_CIRCULAR_PAVING);

        // Magma Bricks
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_MAGMA_BRICKS);

        // Blaze Bricks
        this.registerPillar(modelGenerator, BlockusBlocks.BLAZE_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.BLAZE_LANTERN);

        // Nether Bricks
        this.registerPillar(modelGenerator, BlockusBlocks.NETHER_BRICK_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_NETHER_BRICKS);

        this.registerPillar(modelGenerator, BlockusBlocks.RED_NETHER_BRICK_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_RED_NETHER_BRICKS);

        this.registerPillar(modelGenerator, BlockusBlocks.CHARRED_NETHER_BRICK_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_CHARRED_NETHER_BRICKS);

        this.registerPillar(modelGenerator, BlockusBlocks.TEAL_NETHER_BRICK_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_TEAL_NETHER_BRICKS);

        // Prismarine
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_DARK_PRISMARINE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_PRISMARINE);
        this.registerPillar(modelGenerator, BlockusBlocks.DARK_PRISMARINE_PILLAR);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.PRISMARINE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.PRISMARINE_PILLAR);

        // Bricks
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_SOAKED_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_CHARRED_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_SANDY_BRICKS);

        // Resin Bricks
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_RESIN_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.RESIN_BRICK_PILLAR);

        // Sandstone
        this.registerPillar(modelGenerator, BlockusBlocks.SANDSTONE_PILLAR);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.GOLD_DECORATED_SANDSTONE, Blocks.SANDSTONE);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.LAPIS_DECORATED_SANDSTONE, Blocks.SANDSTONE);

        this.registerPillar(modelGenerator, BlockusBlocks.RED_SANDSTONE_PILLAR);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE, Blocks.RED_SANDSTONE);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.LAPIS_DECORATED_RED_SANDSTONE, Blocks.RED_SANDSTONE);

        // Soul Sandstone
        this.registerCubeColumn(modelGenerator, BlockusBlocks.CHISELED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());
        this.registerCubeColumn(modelGenerator, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());
        this.registerSlabwithTop(modelGenerator, BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());
        this.registerPillar(modelGenerator, BlockusBlocks.SOUL_SANDSTONE_PILLAR);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());
        this.registerCubeColumn(modelGenerator, BlockusBlocks.LAPIS_DECORATED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());

        // Rainbow
        modelGenerator.registerFlowerbed(BlockusBlocks.RAINBOW_PETALS);
        this.registerUpDefaultFacingBlock(modelGenerator, BlockusBlocks.RAINBOW_BLOCK);
        this.registerTopBottomFacingBottom(modelGenerator, BlockusBlocks.RAINBOW_ASPHALT);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.RAINBOW_ROSE, BlockusBlocks.POTTED_RAINBOW_ROSE, CrossType.NOT_TINTED);

        // Purpur Blocks
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_PURPUR);
        modelGenerator.registerSingleton(BlockusBlocks.PURPUR_DECORATED_END_STONE, TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        this.registerLines(modelGenerator, BlockusBlocks.PURPUR_LINES);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.PURPUR_SQUARES);

        // Phantom Purpur Blocks
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_PHANTOM_PURPUR);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.PHANTOM_PURPUR_DECORATED_END_STONE, BlockusBlocks.PURPUR_DECORATED_END_STONE);
        this.registerLines(modelGenerator, BlockusBlocks.PHANTOM_PURPUR_LINES);
        this.registerPillar(modelGenerator, BlockusBlocks.PHANTOM_PURPUR_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.PHANTOM_PURPUR_SQUARES);

        // End Stone
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_END_STONE_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CRACKED_END_STONE_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.END_STONE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE, BlockusBlocks.POLISHED_END_STONE_BUTTON, BlockusBlocks.POLISHED_END_STONE.block());
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_END_STONE_BRICKS);

        // White Oak Wood
        modelGenerator.registerLog(BlockusBlocks.WHITE_OAK_LOG).log(BlockusBlocks.WHITE_OAK_LOG).wood(BlockusBlocks.WHITE_OAK_WOOD);
        modelGenerator.registerSingleton(BlockusBlocks.WHITE_OAK_LEAVES, TexturedModel.LEAVES);
        modelGenerator.registerLog(BlockusBlocks.STRIPPED_WHITE_OAK_LOG).log(BlockusBlocks.STRIPPED_WHITE_OAK_LOG).wood(BlockusBlocks.STRIPPED_WHITE_OAK_WOOD);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.WHITE_OAK_SAPLING, BlockusBlocks.POTTED_WHITE_OAK_SAPLING, CrossType.NOT_TINTED);

        // Hanging Signs
        modelGenerator.registerHangingSign(BlockusBlocks.WHITE_OAK_LOG, BlockusBlocks.WHITE_OAK.ceilingHangingSign(), BlockusBlocks.WHITE_OAK.wallHangingSign());
        modelGenerator.registerHangingSign(BlockusBlocks.RAW_BAMBOO.planks(), BlockusBlocks.RAW_BAMBOO.ceilingHangingSign(), BlockusBlocks.RAW_BAMBOO.wallHangingSign());
        modelGenerator.registerHangingSign(BlockusBlocks.CHARRED.planks(), BlockusBlocks.CHARRED.ceilingHangingSign(), BlockusBlocks.CHARRED.wallHangingSign());

        // Herringbone Planks
        for (Block block : BlockusBlocks.HERRINGBONE_PLANKS.bundle().values()) {
            modelGenerator.registerSimpleCubeAll(block);
        }

        // Small Logs
        for (Block block : BlockusBlocks.SMALL_LOGS.bundle().values()) {
            this.registerAxisRotatedCubeColumn(modelGenerator, block);
        }

        // Posts
        for (var entry : BlockusBlocks.WOODEN_POST.woodMap().entrySet()) {
            this.registerPost(modelGenerator, entry.getValue().block(), WoodMaps.LOG_MAP.get(entry.getKey().getId()));
            this.registerPost(modelGenerator, entry.getValue().stripped(), WoodMaps.STRIPPED_LOG_MAP.get(entry.getKey().getId()));
        }

        // Timber Frames, Lattices & Wooden Grates
        for (var entry : BlockusBlocks.TIMBER_FRAME.woodMap().entrySet()) {
            modelGenerator.registerSimpleCubeAll(entry.getValue().block());
            modelGenerator.registerSimpleCubeAll(entry.getValue().cross());
            this.registerDiagonalTimberFrame(modelGenerator, entry.getValue().diagonal());
            modelGenerator.registerGlassAndPane(entry.getValue().grate(), entry.getValue().lattice());
        }

        // Small Hedges
        this.registerSmallHedge(modelGenerator, BlockusBlocks.OAK_HEDGE, Blocks.OAK_LEAVES, -12012264);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.SPRUCE_HEDGE, Blocks.SPRUCE_LEAVES, -10380959);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.BIRCH_HEDGE, Blocks.BIRCH_LEAVES, -8345771);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.JUNGLE_HEDGE, Blocks.JUNGLE_LEAVES, -12012264);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.ACACIA_HEDGE, Blocks.ACACIA_LEAVES, -12012264);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.DARK_OAK_HEDGE, Blocks.DARK_OAK_LEAVES, -12012264);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.MANGROVE_HEDGE, Blocks.MANGROVE_LEAVES, -7158200);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.CHERRY_HEDGE, Blocks.CHERRY_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.PALE_OAK_HEDGE, Blocks.PALE_OAK_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.WARPED_HEDGE, Blocks.WARPED_WART_BLOCK);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.CRIMSON_HEDGE, Blocks.NETHER_WART_BLOCK);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.WHITE_OAK_HEDGE, BlockusBlocks.WHITE_OAK_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.AZALEA_HEDGE, Blocks.AZALEA_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.FLOWERING_AZALEA_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.MOSS_HEDGE, Blocks.MOSS_BLOCK);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.PALE_MOSS_HEDGE, Blocks.PALE_MOSS_BLOCK);

        // Food Blocks
        this.registerFishCrate(modelGenerator, BlockusBlocks.COD_CRATE);
        this.registerFishCrate(modelGenerator, BlockusBlocks.PUFFERFISH_CRATE);
        this.registerFishCrate(modelGenerator, BlockusBlocks.SALMON_CRATE);
        this.registerFishCrate(modelGenerator, BlockusBlocks.TROPICAL_FISH_CRATE);
        this.registerCrate(modelGenerator, BlockusBlocks.SWEET_BERRIES_CRATE);
        this.registerCrate(modelGenerator, BlockusBlocks.GLOW_BERRIES_CRATE);
        this.registerCrate(modelGenerator, BlockusBlocks.POTATO_CRATE);
        this.registerCrate(modelGenerator, BlockusBlocks.APPLE_CRATE);
        this.registerCrate(modelGenerator, BlockusBlocks.GOLDEN_APPLE_CRATE);
        this.registerCrate(modelGenerator, BlockusBlocks.BEETROOT_CRATE);
        this.registerCrate(modelGenerator, BlockusBlocks.CARROT_CRATE);
        this.registerCrate(modelGenerator, BlockusBlocks.GOLDEN_CARROT_CRATE);
        this.registerBreadBox(modelGenerator, BlockusBlocks.BREAD_BOX);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHORUS_BLOCK);
        this.registerCookieBlock(modelGenerator);
        this.registerDirectionalCarpet(modelGenerator, BlockusBlocks.CHOCOLATE_SQUARES, BlockusBlocks.CHOCOLATE_TABLET);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHOCOLATE_SQUARES);

        // Redstone Lamps
        this.registerLitRedstoneLamp(modelGenerator, Blocks.REDSTONE_LAMP, BlockusBlocks.REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.RAINBOW_LAMP, BlockusBlocks.RAINBOW_LAMP_LIT);
        for (DyeColor color : DyeColor.values()) {
            this.registerRedstoneLamp(modelGenerator, BlockusBlocks.STAINED_REDSTONE_LAMP.colorMap().get(color), BlockusBlocks.STAINED_REDSTONE_LAMP_LIT.colorMap().get(color));
        }

        // Neon Blocks
        for (Block block : BlockusBlocks.NEON_BLOCK.colorMap().values()) {
            this.registerNeonBlock(modelGenerator, block);
        }
        this.registerNeonBlock(modelGenerator, BlockusBlocks.RAINBOW_NEON);

        // Futurneo Blocks
        for (Block block : BlockusBlocks.FUTURNEO_BLOCK.colorMap().values()) {
            modelGenerator.registerSimpleCubeAll(block);
        }
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK);

        // Glass - Beveled Glass
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.RAINBOW_BEVELED_GLASS, BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE);
        modelGenerator.registerGlassAndPane(BlockusBlocks.RAINBOW_GLASS, BlockusBlocks.RAINBOW_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.BEVELED_GLASS, BlockusBlocks.BEVELED_GLASS_PANE);
        for (DyeColor color : DyeColor.values()) {
            this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.STAINED_BEVELED_GLASS.colorMap().get(color), BlockusBlocks.STAINED_BEVELED_GLASS_PANE.colorMap().get(color));
        }
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.TINTED_BEVELED_GLASS);

        // Glazed Terracotta Pillars
        for (Block block : BlockusBlocks.GLAZED_TERRACOTTA_PILLAR.colorMap().values()) {
            this.registerPillar(modelGenerator, block);
        }

        // Paper
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.BURNT_PAPER_BLOCK);
        modelGenerator.registerGlassAndPane(BlockusBlocks.FRAMED_PAPER_BLOCK, BlockusBlocks.PAPER_WALL);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.PAPER_BLOCK);
        modelGenerator.registerOrientableTrapdoor(BlockusBlocks.PAPER_TRAPDOOR);
        modelGenerator.registerDoor(BlockusBlocks.PAPER_DOOR);
        modelGenerator.registerSimpleState(BlockusBlocks.PAPER_LAMP);

        // Lantern Blocks
        this.registerCubeColumn(modelGenerator, BlockusBlocks.LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        modelGenerator.registerLantern(BlockusBlocks.AMETHYST_LANTERN);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.AMETHYST_LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        modelGenerator.registerLantern(BlockusBlocks.REDSTONE_LANTERN);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.REDSTONE_LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.SOUL_LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        this.registerPumpkins(modelGenerator, BlockusBlocks.SOUL_O_LANTERN);
        this.registerPumpkins(modelGenerator, BlockusBlocks.REDSTONE_O_LANTERN);

        // Legacy
        this.registerLegacyStonecutter(modelGenerator, BlockusBlocks.LEGACY_STONECUTTER);
        modelGenerator.registerSingleton(BlockusBlocks.LEGACY_LEAVES, TexturedModel.LEAVES);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.LEGACY_SAPLING, BlockusBlocks.POTTED_LEGACY_SAPLING, CrossType.NOT_TINTED);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.LEGACY_LOG);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_NETHER_REACTOR_CORE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_BRICKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_COBBLESTONE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_FIRST_COBBLESTONE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_MOSSY_COBBLESTONE);
        this.registerCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_GRASS_BLOCK, Blocks.DIRT);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_GRAVEL);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_COAL_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_LAPIS_BLOCK);
        this.registerCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_IRON_BLOCK);
        this.registerCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_GOLD_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK);
        this.registerCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_DIAMOND_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_SPONGE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_CRYING_OBSIDIAN);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_GLOWING_OBSIDIAN);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LEGACY_GLOWSTONE);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.LEGACY_ROSE, BlockusBlocks.POTTED_LEGACY_ROSE, CrossType.NOT_TINTED);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.LEGACY_BLUE_ROSE, BlockusBlocks.POTTED_LEGACY_BLUE_ROSE, CrossType.NOT_TINTED);

        // Colored Tiles
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.RAINBOW_COLORED_TILES);
        for (DyeColor color : DyeColor.values()) {
            this.registerColoredTilesSimple(modelGenerator, BlockusBlocks.COLORED_TILES.colorMap().get(color));
        }

        // Other
        this.registerStairsAndSlab(modelGenerator, BlockusBlocks.NETHERITE_STAIRS, BlockusBlocks.NETHERITE_SLAB, Blocks.NETHERITE_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.NETHER_STAR_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.RAINBOW_GLOWSTONE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CAUTION_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHARCOAL_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.COMPANION_CUBE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.ENDER_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LOVE_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.MEMBRANE_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.REDSTONE_SAND);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.ROTTEN_FLESH_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.STARS_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.SUGAR_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.WEIGHT_STORAGE_CUBE);
        modelGenerator.registerItemModel(BlockusBlocks.GOLDEN_CHAIN.asItem());
        modelGenerator.registerItemModel(BlockusBlocks.GOLDEN_BARS);
        modelGenerator.registerItemModel(BlockusBlocks.WOODEN_FRAME);
        modelGenerator.registerItemModel(BlockusBlocks.IRON_GATE.asItem());
        modelGenerator.registerItemModel(BlockusBlocks.GOLDEN_GATE.asItem());
        registerInventoryItemModel(modelGenerator, BlockusBlocks.CAUTION_BARRIER);
        registerInventoryItemModel(modelGenerator, BlockusBlocks.ROAD_BARRIER);
        modelGenerator.registerParentedItemModel(BlockusBlocks.PATH, ModelIds.getBlockSubModelId(BlockusBlocks.PATH, "4"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator modelGenerator) {
        modelGenerator.register(BlockusEntities.CHARRED_BOAT.asItem(), Models.GENERATED);
        modelGenerator.register(BlockusEntities.CHARRED_CHEST_BOAT.asItem(), Models.GENERATED);
        modelGenerator.register(BlockusEntities.RAW_BAMBOO_RAFT.asItem(), Models.GENERATED);
        modelGenerator.register(BlockusEntities.RAW_BAMBOO_CHEST_RAFT.asItem(), Models.GENERATED);
        modelGenerator.register(BlockusEntities.WHITE_OAK_BOAT.asItem(), Models.GENERATED);
        modelGenerator.register(BlockusEntities.WHITE_OAK_CHEST_BOAT.asItem(), Models.GENERATED);
    }

    public final void registerInventoryItemModel(BlockStateModelGenerator modelGenerator, Block block) {
        modelGenerator.registerParentedItemModel(block, ModelIds.getBlockSubModelId(block, "_inventory"));
    }

    public final void registerPillar(BlockStateModelGenerator modelGenerator, Block block) {
        modelGenerator.registerAxisRotated(block, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
    }

    public final void registerLines(BlockStateModelGenerator modelGenerator, Block block) {
        modelGenerator.registerAxisRotated(block, TexturedModel.CUBE_ALL);
    }

    public final void registerBlockStairsSlabAndWall(BlockStateModelGenerator modelGenerator, Block block, Block stairs, Block slab, Block wall) {
        modelGenerator.registerCubeAllModelTexturePool(block).stairs(stairs).slab(slab).wall(wall);
    }

    public final void registerBlockStairsAndSlab(BlockStateModelGenerator modelGenerator, Block block, Block stairs, Block slab) {
        modelGenerator.registerCubeAllModelTexturePool(block).stairs(stairs).slab(slab);
    }

    public final void registerButtonAndPressurePlate(BlockStateModelGenerator modelGenerator, Block pressurePlateBlock, Block buttonBlock, Block textureID) {
        this.registerButton(modelGenerator, buttonBlock, TextureMap.getId(textureID));
        this.registerPressurePlate(modelGenerator, pressurePlateBlock, TextureMap.getId(textureID));
    }

    public final void registerButtonAndPressurePlate(BlockStateModelGenerator modelGenerator, Block pressurePlateBlock, Block buttonBlock, Identifier textureSource) {
        this.registerButton(modelGenerator, buttonBlock, textureSource);
        this.registerPressurePlate(modelGenerator, pressurePlateBlock, textureSource);
    }

    public final void registerPost(BlockStateModelGenerator modelGenerator, Block block, Block textureSource) {
        TextureMap textureMap = TextureMap.sideAndEndForTop(textureSource);
        Identifier identifier = BlockusModels.TEMPLATE_POST.upload(block, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = BlockusModels.TEMPLATE_POST_CONNECT.upload(block, textureMap, modelGenerator.modelCollector);
        Identifier identifier3 = BlockusModels.TEMPLATE_POST_CONNECT_TOP.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(createPostBlockState(block, identifier, identifier2, identifier3, Blockus.id("block/chain_connect"), Blockus.id("block/chain_connect_top")));
        modelGenerator.registerParentedItemModel(block, identifier);
    }

    public static BlockStateSupplier createPostBlockState(Block postBlock, Identifier postModelId, Identifier sideModelId, Identifier topModelId, Identifier chainModelId, Identifier topChainModelId) {
        return MultipartBlockStateSupplier.create(postBlock)
            .with(When.create().set(Properties.AXIS, Direction.Axis.X), BlockStateVariant.create().put(VariantSettings.MODEL, postModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(Properties.AXIS, Direction.Axis.Y), BlockStateVariant.create().put(VariantSettings.MODEL, postModelId).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(Properties.AXIS, Direction.Axis.Z), BlockStateVariant.create().put(VariantSettings.MODEL, postModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.NORTH, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, topModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.SOUTH, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, sideModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.EAST, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, topModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.WEST, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, sideModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.UP, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, topModelId).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.DOWN, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, sideModelId).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.NORTH, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, topChainModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.SOUTH, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, chainModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.EAST, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, topChainModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.WEST, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, chainModelId).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.UP, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, topChainModelId).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.DOWN, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, chainModelId).put(VariantSettings.UVLOCK, false));
    }

    public final void registerCookieBlock(BlockStateModelGenerator modelGenerator) {
        Block block = BlockusBlocks.COOKIE_BLOCK;
        Identifier identifier = TexturedModel.CUBE_ALL.upload(block, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateVariantMap.create(com.brand.blockus.utils.Properties.BITES_9)
            .register(0, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(block)))
            .register(1, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_slice1")))
            .register(2, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_slice2")))
            .register(3, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_slice3")))
            .register(4, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_slice4")))
            .register(5, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_slice5")))
            .register(6, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_slice6")))
            .register(7, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_slice7")))
            .register(8, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_slice8")))));
    }

    public final void registerAmethystLamp(BlockStateModelGenerator modelGenerator) {
        Block block = BlockusBlocks.AMETHYST_LAMP;
        Identifier identifier = TexturedModel.CUBE_ALL.upload(block, modelGenerator.modelCollector);
        Identifier identifier2 = modelGenerator.createSubModel(block, "_low", Models.CUBE_ALL, TextureMap::all);
        Identifier identifier3 = modelGenerator.createSubModel(block, "_medium", Models.CUBE_ALL, TextureMap::all);
        Identifier identifier4 = modelGenerator.createSubModel(block, "_high", Models.CUBE_ALL, TextureMap::all);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateVariantMap.create(Properties.POWER)
            .register(0, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(block)))
            .register(1, BlockStateVariant.create().put(VariantSettings.MODEL, identifier2))
            .register(2, BlockStateVariant.create().put(VariantSettings.MODEL, identifier2))
            .register(3, BlockStateVariant.create().put(VariantSettings.MODEL, identifier2))
            .register(4, BlockStateVariant.create().put(VariantSettings.MODEL, identifier2))
            .register(5, BlockStateVariant.create().put(VariantSettings.MODEL, identifier2))
            .register(6, BlockStateVariant.create().put(VariantSettings.MODEL, identifier3))
            .register(7, BlockStateVariant.create().put(VariantSettings.MODEL, identifier3))
            .register(8, BlockStateVariant.create().put(VariantSettings.MODEL, identifier3))
            .register(9, BlockStateVariant.create().put(VariantSettings.MODEL, identifier3))
            .register(10, BlockStateVariant.create().put(VariantSettings.MODEL, identifier3))
            .register(11, BlockStateVariant.create().put(VariantSettings.MODEL, identifier4))
            .register(12, BlockStateVariant.create().put(VariantSettings.MODEL, identifier4))
            .register(13, BlockStateVariant.create().put(VariantSettings.MODEL, identifier4))
            .register(14, BlockStateVariant.create().put(VariantSettings.MODEL, identifier4))
            .register(15, BlockStateVariant.create().put(VariantSettings.MODEL, identifier4))));
    }

    public final void registerSmallHedge(BlockStateModelGenerator modelGenerator, Block hedgeBlock, Block textureSource) {
        registerSmallHedge(modelGenerator, hedgeBlock, textureSource, false, 0);
    }

    public final void registerSmallHedge(BlockStateModelGenerator modelGenerator, Block hedgeBlock, Block textureSource, int tintColor) {
        registerSmallHedge(modelGenerator, hedgeBlock, textureSource, true, tintColor);
    }

    public final void registerSmallHedge(BlockStateModelGenerator modelGenerator, Block hedgeBlock, Block textureSource, boolean isTinted, int tintColor) {
        TextureMap textureMap = TextureMap.of(BlockusTextureKey.HEDGE, TextureMap.getId(textureSource));
        Identifier identifier = BlockusModels.TEMPLATE_HEDGE_POST.upload(hedgeBlock, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = BlockusModels.TEMPLATE_HEDGE_SIDE.upload(hedgeBlock, textureMap, modelGenerator.modelCollector);
        Identifier identifier3 = BlockusModels.TEMPLATE_HEDGE_SIDE_ALT.upload(hedgeBlock, textureMap, modelGenerator.modelCollector);
        Identifier identifier4 = BlockusModels.TEMPLATE_HEDGE_NOSIDE.upload(hedgeBlock, textureMap, modelGenerator.modelCollector);
        Identifier identifier5 = BlockusModels.TEMPLATE_HEDGE_NOSIDE_ALT.upload(hedgeBlock, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(hedgeBlock).with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.UVLOCK, true)).with(When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.UVLOCK, true).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.UVLOCK, true)).with(When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.UVLOCK, true).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.UVLOCK, true)).with(When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.UVLOCK, true)).with(When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.UVLOCK, true).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.UVLOCK, true).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
        Identifier identifier6 = BlockusModels.TEMPLATE_HEDGE_INVENTORY.upload(hedgeBlock, textureMap, modelGenerator.modelCollector);
        if (isTinted) {
            modelGenerator.registerTintedItemModel(hedgeBlock, identifier6, ItemModels.constantTintSource(tintColor));
        } else {
            modelGenerator.registerParentedItemModel(hedgeBlock, identifier6);
        }
    }

    public final void registerCarpet(BlockStateModelGenerator modelGenerator, Block wool, Block carpet) {
        Identifier identifier = TexturedModel.CARPET.get(wool).upload(carpet, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(carpet, identifier));
    }

    public final void registerDirectionalCarpet(BlockStateModelGenerator modelGenerator, Block block, Block carpet) {
        TexturedModel.CARPET.get(block).upload(carpet, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(carpet, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(carpet))).coordinate(createUpDefaultRotationStates()));
    }

    public final void registerBlockStairsSlabWithBottom(BlockStateModelGenerator modelGenerator, Block block, Block stairs, Block slab, Block base) {
        Identifier textureID = TextureMap.getSubId(base, "_bottom");
        TextureMap blockTextureMap = TextureMap.of(TextureKey.ALL, textureID);
        TextureMap textureMap = sideTopBottom(textureID);
        this.createBlock(modelGenerator, block, blockTextureMap);
        this.createStairs(modelGenerator, stairs, textureMap);
        this.createSlab(modelGenerator, slab, textureMap, getBlockId(block));
    }

    public final void registerBlockStairsSlabWithTop(BlockStateModelGenerator modelGenerator, Block block, Block stairs, Block slab, Block base) {
        Identifier textureID = TextureMap.getSubId(base, "_top");
        TextureMap blockTextureMap = TextureMap.of(TextureKey.ALL, textureID);
        TextureMap textureMap = sideTopBottom(textureID);
        this.createBlock(modelGenerator, block, blockTextureMap);
        this.createStairs(modelGenerator, stairs, textureMap);
        this.createSlab(modelGenerator, slab, textureMap, getBlockId(block));
    }

    public final void registerBlockStairsSlabwithTopBottom(BlockStateModelGenerator modelGenerator, Block block, Block stairs, Block slab) {
        TextureMap textureMap = sideTopBottom(TextureMap.getId(block), TextureMap.getSubId(block, "_top"), TextureMap.getSubId(block, "_bottom"));
        this.createBlock(modelGenerator, block, Models.CUBE_BOTTOM_TOP, textureMap);
        this.createStairs(modelGenerator, stairs, textureMap);
        this.createSlab(modelGenerator, slab, textureMap, getBlockId(block));
    }

    public final void registerStairs(BlockStateModelGenerator modelGenerator, Block block, Block textureSource) {
        TextureMap textureMap = sideTopBottom(TextureMap.getId(textureSource));
        this.createStairs(modelGenerator, block, textureMap);
    }

    public final void registerSlab(BlockStateModelGenerator modelGenerator, Block block, Block textureSource) {
        TextureMap textureMap = sideTopBottom(TextureMap.getId(textureSource));
        this.createSlab(modelGenerator, block, textureMap, TextureMap.getId(textureSource));
    }

    public final void registerStairsAndSlab(BlockStateModelGenerator modelGenerator, Block stairs, Block slab, Block block) {
        this.registerStairs(modelGenerator, stairs, block);
        this.registerSlab(modelGenerator, slab, block);
    }

    public final void registerSlabwithTop(BlockStateModelGenerator modelGenerator, Block block, Block textureSource, Block end) {
        TextureMap textureMap = sideTopBottom(TextureMap.getId(textureSource), TextureMap.getSubId(end, "_top"));
        this.createSlab(modelGenerator, block, textureMap, TextureMap.getId(textureSource));
    }

    public final void registerWall(BlockStateModelGenerator modelGenerator, Block block, Block textureSource) {
        TextureMap textureMap = TextureMap.of(TextureKey.WALL, TextureMap.getId(textureSource));
        this.createWall(modelGenerator, block, textureMap);
    }

    public final void registerButton(BlockStateModelGenerator modelGenerator, Block buttonBlock, Identifier textureSource) {
        TextureMap textureMap = TextureMap.texture(textureSource);
        Identifier identifier = Models.BUTTON.upload(buttonBlock, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = Models.BUTTON_PRESSED.upload(buttonBlock, textureMap, modelGenerator.modelCollector);
        Identifier identifier3 = Models.BUTTON_INVENTORY.upload(buttonBlock, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(buttonBlock, identifier, identifier2));
        modelGenerator.registerParentedItemModel(buttonBlock, identifier3);
    }

    public final void registerPressurePlate(BlockStateModelGenerator modelGenerator, Block pressurePlateBlock, Identifier textureSource) {
        TextureMap textureMap = TextureMap.texture(textureSource);
        Identifier identifier = Models.PRESSURE_PLATE_UP.upload(pressurePlateBlock, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = Models.PRESSURE_PLATE_DOWN.upload(pressurePlateBlock, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(pressurePlateBlock, identifier, identifier2));
    }

    public final void registerRedstoneLamp(BlockStateModelGenerator modelGenerator, Block block, Block lit) {
        registerLitRedstoneLamp(modelGenerator, block, lit);
        Identifier identifier = TexturedModel.CUBE_ALL.upload(block, modelGenerator.modelCollector);
        Identifier identifier2 = modelGenerator.createSubModel(block, "_on", Models.CUBE_ALL, TextureMap::all);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, identifier2, identifier)));
    }

    public final void registerLitRedstoneLamp(BlockStateModelGenerator modelGenerator, Block block, Block lit) {
        TextureMap textureMap = TextureMap.of(TextureKey.ALL, TextureMap.getSubId(block, "_on"));
        this.createBlock(modelGenerator, lit, textureMap);
    }

    public void createAxisRotatedCubeColumn(BlockStateModelGenerator modelGenerator, Block block, TextureMap textureMap) {
        Identifier identifier = Models.CUBE_COLUMN.upload(block, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = Models.CUBE_COLUMN_HORIZONTAL.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createAxisRotatedBlockState(block, identifier, identifier2));
    }

    public final void registerAxisRotatedCubeColumn(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = TextureMap.sideAndEndForTop(block);
        this.createAxisRotatedCubeColumn(modelGenerator, block, textureMap);
    }

    public final void registerAxisRotatedCubeColumn(BlockStateModelGenerator modelGenerator, Block block, Block end) {
        TextureMap textureMap = TextureMap.sideEnd(TextureMap.getId(block), TextureMap.getId(end));
        this.createAxisRotatedCubeColumn(modelGenerator, block, textureMap);
    }

    public final void registerCubeColumn(BlockStateModelGenerator modelGenerator, Block block, Block end) {
        TextureMap textureMap = TextureMap.sideEnd(TextureMap.getId(block), TextureMap.getSubId(end, "_top"));
        this.createBlock(modelGenerator, block, Models.CUBE_COLUMN, textureMap);
    }

    public final void registerCubeColumnNoSuffix(BlockStateModelGenerator modelGenerator, Block block, Block end) {
        TextureMap textureMap = TextureMap.sideEnd(TextureMap.getId(block), TextureMap.getId(end));
        this.createBlock(modelGenerator, block, Models.CUBE_COLUMN, textureMap);
    }

    public final void registerCubeBottomTop(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = sideTopBottom(TextureMap.getId(block), TextureMap.getSubId(block, "_top"), TextureMap.getSubId(block, "_bottom"));
        this.createBlock(modelGenerator, block, Models.CUBE_BOTTOM_TOP, textureMap);
    }

    public final void registerCubeBottomTop(BlockStateModelGenerator modelGenerator, Block block, Block bottom) {
        TextureMap textureMap = sideTopBottom(TextureMap.getId(block), TextureMap.getSubId(block, "_top"), TextureMap.getId(bottom));
        this.createBlock(modelGenerator, block, Models.CUBE_BOTTOM_TOP, textureMap);
    }

    public final void registerUpDefaultFacingBlock(BlockStateModelGenerator modelGenerator, Block block) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(block, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(createUpDefaultRotationStates()));
    }

    public final void registerTopBottomFacingBottom(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = sideTopBottom(TextureMap.getId(block), TextureMap.getSubId(block, "_top"), TextureMap.getSubId(block, "_bottom"));
        Identifier identifier = Models.CUBE_BOTTOM_TOP.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(createUpDefaultRotationStates()));
    }

    public final void registerPumpkins(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = TextureMap.sideEnd(Blocks.PUMPKIN);
        modelGenerator.registerNorthDefaultHorizontalRotatable(block, textureMap);
    }

    public final void registerSturdyStone(BlockStateModelGenerator modelGenerator) {
        Identifier identifier = TextureMap.getSubId(Blocks.FURNACE, "_top");
        this.createBlock(modelGenerator, BlockusBlocks.STURDY_STONE, TextureMap.of(TextureKey.ALL, identifier));
    }

    public final void registerSmoothStoneStairs(BlockStateModelGenerator modelGenerator) {
        TextureMap textureMap = sideTopBottom(TextureMap.getSubId(Blocks.SMOOTH_STONE_SLAB, "_side"), TextureMap.getId(Blocks.SMOOTH_STONE));
        this.createStairs(modelGenerator, BlockusBlocks.SMOOTH_STONE_STAIRS, textureMap);
    }

    public final void registerNeonBlock(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = TextureMap.of(TextureKey.ALL, TextureMap.getId(block));
        this.createBlock(modelGenerator, block, BlockusModels.NEON_BLOCK_TEMPLATE, textureMap);
    }

    public final void registerFishCrate(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = sideTopBottom(getBlockId("fish_crate_side"), TextureMap.getId(block), getBlockId("fish_crate_bottom"));
        this.createBlock(modelGenerator, block, Models.CUBE_BOTTOM_TOP, textureMap);
    }

    public final void registerCopperBlocks(BlockStateModelGenerator modelGenerator, CopperBundle block, BlockusFamilies.CopperFamily family) {
        modelGenerator.registerCubeAllModelTexturePool(block.block()).family(family.unwaxed).parented(block.block(), block.blockWaxed()).family(family.waxed);
    }

    public final void registerCrate(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = sideTop(TextureMap.getSubId(block, "_side"), TextureMap.getId(block));
        this.createBlock(modelGenerator, block, BlockusModels.CRATE_TEMPLATE, textureMap);
    }

    public final void registerBreadBox(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = frontTopSideBottom(block);
        Identifier identifier = Models.ORIENTABLE_WITH_BOTTOM.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    public void registerLegacyStonecutter(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = (new TextureMap()).put(TextureKey.PARTICLE, TextureMap.getSubId(block, "_front")).put(TextureKey.DOWN, TextureMap.getSubId(block, "_bottom")).put(TextureKey.UP, TextureMap.getSubId(block, "_top")).put(TextureKey.NORTH, TextureMap.getSubId(block, "_front")).put(TextureKey.SOUTH, TextureMap.getSubId(block, "_front")).put(TextureKey.EAST, TextureMap.getSubId(block, "_side")).put(TextureKey.WEST, TextureMap.getSubId(block, "_side"));
        this.createBlock(modelGenerator, block, Models.CUBE, textureMap);
    }

    private void registerDiagonalTimberFrame(BlockStateModelGenerator modelGenerator, Block block) {
        Identifier identifier = ModelIds.getBlockModelId(block);
        Identifier identifier2 = TextureMap.getSubId(block, "_right");
        Identifier identifier3 = TextureMap.getSubId(block, "_left");
        TextureMap textureMap = (new TextureMap()).put(TextureKey.PARTICLE, identifier2).put(TextureKey.NORTH, identifier2).put(TextureKey.SOUTH, identifier2).put(TextureKey.EAST, identifier2).put(TextureKey.WEST, identifier3).put(TextureKey.DOWN, identifier3).put(TextureKey.UP, identifier3);
        Models.CUBE.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
            .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
            .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R180))
            .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R270))
            .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R90))));
    }

    public final void registerBeveledGlassPane(BlockStateModelGenerator modelGenerator, Block glass, Block glassPane) {
        modelGenerator.registerSimpleCubeAll(glass);
        TextureMap textureMap = TextureMap.paneAndTopForEdge(glass, BlockusBlocks.BEVELED_GLASS_PANE);
        Identifier identifier = Models.TEMPLATE_GLASS_PANE_POST.upload(glassPane, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_GLASS_PANE_SIDE.upload(glassPane, textureMap, modelGenerator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(glassPane, textureMap, modelGenerator.modelCollector);
        Identifier identifier4 = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(glassPane, textureMap, modelGenerator.modelCollector);
        Identifier identifier5 = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(glassPane, textureMap, modelGenerator.modelCollector);
        Item item = glassPane.asItem();
        modelGenerator.registerItemModel(item, modelGenerator.uploadBlockItemModel(item, glass));
        modelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(glassPane).with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)).with(When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)).with(When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)).with(When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5)).with(When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
    }

    public static void registerColoredTiles(BlockStateModelGenerator modelGenerator, Block block, Block tile1, Block tile2) {
        TextureMap textures = tilesTextures(tile1, tile2);
        BlockusModels.CUBE_TILES.upload(block, textures, modelGenerator.modelCollector);
        BlockusModels.CUBE_TILES_2.upload(block, textures, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_AXIS)
            .register(Direction.Axis.X, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(block)))
            .register(Direction.Axis.Z, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block, "_2")))));
    }

    public final void registerColoredTilesSimple(BlockStateModelGenerator modelGenerator, Block block) {
        Identifier identifier = getModifiedBlockId(block, "_colored", "");
        this.createBlock(modelGenerator, block, TextureMap.of(TextureKey.ALL, identifier));
    }

    public final void createBlock(BlockStateModelGenerator modelGenerator, Block block, Model model, TextureMap textureMap) {
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, model.upload(block, textureMap, modelGenerator.modelCollector)));
    }

    public final void createBlock(BlockStateModelGenerator modelGenerator, Block block, TextureMap textureMap) {
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, Models.CUBE_ALL.upload(block, textureMap, modelGenerator.modelCollector)));
    }

    public final void createStairs(BlockStateModelGenerator modelGenerator, Block block, TextureMap textureMap) {
        Identifier identifier = Models.INNER_STAIRS.upload(block, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = Models.STAIRS.upload(block, textureMap, modelGenerator.modelCollector);
        Identifier identifier3 = Models.OUTER_STAIRS.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(block, identifier, identifier2, identifier3));
        modelGenerator.registerParentedItemModel(block, identifier2);
    }

    public final void createSlab(BlockStateModelGenerator modelGenerator, Block block, TextureMap textureMap, Identifier doubleSlab) {
        Identifier identifier = Models.SLAB.upload(block, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = Models.SLAB_TOP.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(block, identifier, identifier2, doubleSlab));
        modelGenerator.registerParentedItemModel(block, identifier);
    }

    public final void createWall(BlockStateModelGenerator modelGenerator, Block block, TextureMap textureMap) {
        Identifier identifier = Models.TEMPLATE_WALL_POST.upload(block, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_WALL_SIDE.upload(block, textureMap, modelGenerator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_WALL_SIDE_TALL.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(block, identifier, identifier2, identifier3));
        Identifier identifier4 = Models.WALL_INVENTORY.upload(block, textureMap, modelGenerator.modelCollector);
        modelGenerator.registerParentedItemModel(block, identifier4);
    }

    public static BlockStateVariantMap createUpDefaultRotationStates() {
        return BlockStateVariantMap.create(Properties.FACING)
            .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R180))
            .register(Direction.UP, BlockStateVariant.create())
            .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R180))
            .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R270))
            .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R90))
            .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.Y, VariantSettings.Rotation.R270));
    }

    public static Identifier getTilesId(Block block) {
        return getModifiedBlockId(block, "_concrete", "_tiles");
    }

    public static Identifier getBlockId(String id) {
        return Blockus.id("block/" + id);
    }

    public static Identifier getBlockId(Block block) {
        return Blockus.id("block/" + Registries.BLOCK.getId(block).getPath());
    }

    public static Identifier getModifiedBlockId(Block block, String target, String replacement) {
        return Blockus.id("block/" + Registries.BLOCK.getId(block).getPath().replace(target, replacement));
    }

// TextureMaps

    private static TextureMap tilesTextures(Block tile1, Block tile2) {
        return (new TextureMap()).put(BlockusTextureKey.TILE_1, getTilesId(tile1)).put(BlockusTextureKey.TILE_2, getTilesId(tile2));
    }

    public static TextureMap sideTop(Identifier block, Identifier top) {
        return (new TextureMap()).put(TextureKey.SIDE, block).put(TextureKey.TOP, top);
    }

    public static TextureMap sideTopBottom(Identifier block, Identifier top, Identifier bottom) {
        return (new TextureMap()).put(TextureKey.SIDE, block).put(TextureKey.TOP, top).put(TextureKey.BOTTOM, bottom);
    }

    public static TextureMap sideTopBottom(Identifier block, Identifier end) {
        return (new TextureMap()).put(TextureKey.SIDE, block).put(TextureKey.TOP, end).put(TextureKey.BOTTOM, end);
    }

    public static TextureMap sideTopBottom(Identifier block) {
        return (new TextureMap()).put(TextureKey.SIDE, block).put(TextureKey.TOP, block).put(TextureKey.BOTTOM, block);
    }

    public static TextureMap frontTopSideBottom(Block block) {
        return (new TextureMap()).put(TextureKey.FRONT, TextureMap.getId(block)).put(TextureKey.TOP, TextureMap.getSubId(block, "_top")).put(TextureKey.SIDE, TextureMap.getSubId(block, "_side")).put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_side"));
    }

    // Tint
    public final void registerTintableCrossBlockState(BlockStateModelGenerator modelGenerator, Block block, CrossType tintType) {
        TextureMap textureMap = tintType.getTextureMap(block);
        this.registerTintableCrossBlockState(modelGenerator, block, textureMap);
    }

    public final void registerTintableCrossBlockState(BlockStateModelGenerator modelGenerator, Block block, TextureMap crossTexture) {
        Identifier identifier = Models.CROSS.upload(block, crossTexture, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, identifier));
    }

    public final void registerFlowerPotPlantAndItem(BlockStateModelGenerator modelGenerator, Block block, Block flowerPotBlock, CrossType crossType) {
        modelGenerator.registerItemModel(block.asItem(), crossType.registerItemModel(modelGenerator, block));
        this.registerFlowerPotPlant(modelGenerator, block, flowerPotBlock, crossType);
    }

    public final void registerFlowerPotPlant(BlockStateModelGenerator modelGenerator, Block plantBlock, Block flowerPotBlock, CrossType tintType) {
        this.registerTintableCrossBlockState(modelGenerator, plantBlock, tintType);
        TextureMap textureMap = tintType.getFlowerPotTextureMap(plantBlock);
        Identifier identifier = tintType.getFlowerPotCrossModel().upload(flowerPotBlock, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(flowerPotBlock, identifier));
    }
}
