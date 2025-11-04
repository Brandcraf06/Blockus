package com.brand.blockus.datagen.providers;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.PostBlock;
import com.brand.blockus.datagen.family.BlockusFamilies;
import com.brand.blockus.datagen.models.BlockusModels;
import com.brand.blockus.datagen.models.BlockusTextureKey;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.BlockusBlockStateProperties;
import com.brand.blockus.utils.helper.BlockOrder;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class BlockusModelProvider extends FabricModelProvider {

    public BlockusModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGenerator) {

        BlockusFamilies.getFamilies().filter(BlockFamily::shouldGenerateModel).forEach((family) -> {
            modelGenerator.family(family.getBaseBlock()).generateFor(family);
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
                modelGenerator.createTrivialCube(variants.chiseled());
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
            modelGenerator.createNonTemplateModelBlock(pottedLargeBundle.block());
        }
        modelGenerator.createNonTemplateModelBlock(BlockusBlocks.LARGE_FLOWER_POT);

        // Shelf
        modelGenerator.createShelf(BlockusBlocks.WHITE_OAK.shelf(), BlockusBlocks.STRIPPED_WHITE_OAK_LOG);
        modelGenerator.createShelf(BlockusBlocks.RAW_BAMBOO.shelf(), Blocks.BAMBOO_BLOCK);
        modelGenerator.createShelf(BlockusBlocks.CHARRED.shelf(), BlockusBlocks.CHARRED.planks());

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
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_STONE_BRICKS);
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.STONE_CIRCULAR_PAVING);
        modelGenerator.createDoor(BlockusBlocks.STONE_DOOR);
        modelGenerator.createOrientableTrapdoor(BlockusBlocks.STONE_TRAPDOOR);
        this.registerSturdyStone(modelGenerator);
        this.registerSmoothStoneStairs(modelGenerator);

        // Andesite
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.ANDESITE_CIRCULAR_PAVING);
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_ANDESITE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_ANDESITE_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_ANDESITE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_ANDESITE_BUTTON, Blocks.POLISHED_ANDESITE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_ANDESITE_BRICKS);

        // Diorite
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_DIORITE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_DIORITE_BRICKS);
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.DIORITE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_DIORITE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_DIORITE_BUTTON, Blocks.POLISHED_DIORITE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_DIORITE_BRICKS);

        // Granite
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_GRANITE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_GRANITE_BRICKS);
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.GRANITE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_GRANITE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_GRANITE_BUTTON, Blocks.POLISHED_GRANITE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_GRANITE_BRICKS);

        // Mud
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_MUD_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.MUD_BRICK_PILLAR);

        // Dripstone
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_DRIPSTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.DRIPSTONE_PILLAR);

        // Tuff
        modelGenerator.createTrivialCube(BlockusBlocks.CARVED_TUFF_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_TUFF_BRICKS);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE, BlockusBlocks.POLISHED_TUFF_BUTTON, Blocks.POLISHED_TUFF);
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.TUFF_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.TUFF_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_TUFF_BRICKS);

        // Deepslate
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.DEEPSLATE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.DEEPSLATE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE, BlockusBlocks.POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);
        modelGenerator.createTrivialCube(BlockusBlocks.STURDY_DEEPSLATE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_DEEPSLATE_BRICKS);

        // Sculk
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_SCULK_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.SCULK_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_SCULK_PRESSURE_PLATE, BlockusBlocks.POLISHED_SCULK_BUTTON, BlockusBlocks.POLISHED_SCULK.block());

        // Amethyst
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_AMETHYST);
        this.registerPillar(modelGenerator, BlockusBlocks.AMETHYST_PILLAR);
        this.registerAmethystLamp(modelGenerator);

        // Blackstone
        modelGenerator.createOrientableTrapdoor(BlockusBlocks.BLACKSTONE_TRAPDOOR);
        this.registerCubeColumnNoSuffix(modelGenerator, BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.POLISHED_BLACKSTONE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_BLACKSTONE_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.STURDY_BLACKSTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_POLISHED_BLACKSTONE_BRICKS);
        modelGenerator.createDoor(BlockusBlocks.BLACKSTONE_DOOR);

        // Basalt
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_POLISHED_BASALT);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS);
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.POLISHED_BASALT_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.POLISHED_BASALT_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE, BlockusBlocks.POLISHED_BASALT_BUTTON, TextureMapping.getBlockTexture(Blocks.POLISHED_BASALT, "_top"));
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_POLISHED_BASALT_BRICKS);

        // Limestone
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_LIMESTONE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_LIMESTONE_BRICKS, BlockusBlocks.POLISHED_LIMESTONE.block());
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.LIMESTONE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.LIMESTONE_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.CHISELED_LIMESTONE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.LIMESTONE_PRESSURE_PLATE, BlockusBlocks.LIMESTONE_BUTTON, BlockusBlocks.LIMESTONE.block());
        modelGenerator.createTrivialCube(BlockusBlocks.LIMESTONE_SQUARES);
        this.registerLines(modelGenerator, BlockusBlocks.LIMESTONE_LINES);

        // Marble
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_MARBLE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_MARBLE_BRICKS, BlockusBlocks.POLISHED_MARBLE.block());
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.MARBLE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.MARBLE_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.CHISELED_MARBLE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.MARBLE_PRESSURE_PLATE, BlockusBlocks.MARBLE_BUTTON, BlockusBlocks.MARBLE.block());
        modelGenerator.createTrivialCube(BlockusBlocks.MARBLE_SQUARES);
        this.registerLines(modelGenerator, BlockusBlocks.MARBLE_LINES);

        // Bluestone
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.BLUESTONE_CIRCULAR_PAVING);
        this.registerLines(modelGenerator, BlockusBlocks.BLUESTONE_LINES);
        this.registerPillar(modelGenerator, BlockusBlocks.BLUESTONE_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.CHISELED_BLUESTONE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.BLUESTONE_PRESSURE_PLATE, BlockusBlocks.BLUESTONE_BUTTON, BlockusBlocks.BLUESTONE.block());
        modelGenerator.createTrivialCube(BlockusBlocks.BLUESTONE_SQUARES);
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_BLUESTONE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_BLUESTONE_BRICKS, BlockusBlocks.POLISHED_BLUESTONE.block());


        // Viridite
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_VIRIDITE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_VIRIDITE_BRICKS, BlockusBlocks.POLISHED_VIRIDITE.block());
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.VIRIDITE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.VIRIDITE_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.CHISELED_VIRIDITE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.VIRIDITE_PRESSURE_PLATE, BlockusBlocks.VIRIDITE_BUTTON, BlockusBlocks.VIRIDITE.block());
        modelGenerator.createTrivialCube(BlockusBlocks.VIRIDITE_SQUARES);
        this.registerLines(modelGenerator, BlockusBlocks.VIRIDITE_LINES);

        // Lava & Water Bricks
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_LAVA_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_LAVA_POLISHED_BLACKSTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_WATER_BRICKS);

        // Snow & Ice Bricks
        this.registerPillar(modelGenerator, BlockusBlocks.SNOW_PILLAR);
        modelGenerator.family(BlockusBlocks.ICE_BRICKS).wall(BlockusBlocks.ICE_BRICK_WALL);
        this.registerPillar(modelGenerator, BlockusBlocks.ICE_PILLAR);

        // Obsidian
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.GLOWING_OBSIDIAN);
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.OBSIDIAN_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.OBSIDIAN_PILLAR);
        modelGenerator.createOrientableTrapdoor(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR);
        modelGenerator.createDoor(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR);
        this.registerPressurePlate(modelGenerator, BlockusBlocks.OBSIDIAN_PRESSURE_PLATE, TextureMapping.getBlockTexture(Blocks.OBSIDIAN));


        // Netherrack
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.NETHERRACK_CIRCULAR_PAVING);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE, BlockusBlocks.POLISHED_NETHERRACK_BUTTON, BlockusBlocks.POLISHED_NETHERRACK.block());

        // Quartz Blocks
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.QUARTZ_CIRCULAR_PAVING);

        // Magma Bricks
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_MAGMA_BRICKS);

        // Blaze Bricks
        this.registerPillar(modelGenerator, BlockusBlocks.BLAZE_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.BLAZE_LANTERN);

        // Nether Bricks
        this.registerPillar(modelGenerator, BlockusBlocks.NETHER_BRICK_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_NETHER_BRICKS);

        this.registerPillar(modelGenerator, BlockusBlocks.RED_NETHER_BRICK_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_RED_NETHER_BRICKS);

        this.registerPillar(modelGenerator, BlockusBlocks.CHARRED_NETHER_BRICK_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_CHARRED_NETHER_BRICKS);

        this.registerPillar(modelGenerator, BlockusBlocks.TEAL_NETHER_BRICK_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_TEAL_NETHER_BRICKS);

        // Prismarine
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_DARK_PRISMARINE);
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_PRISMARINE);
        this.registerPillar(modelGenerator, BlockusBlocks.DARK_PRISMARINE_PILLAR);
        modelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.PRISMARINE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.PRISMARINE_PILLAR);

        // Bricks
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_SOAKED_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_CHARRED_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_SANDY_BRICKS);

        // Resin Bricks
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_RESIN_BRICKS);
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
        modelGenerator.createFlowerBed(BlockusBlocks.RAINBOW_PETALS);
        this.registerUpDefaultFacingBlock(modelGenerator, BlockusBlocks.RAINBOW_BLOCK);
        this.registerTopBottomFacingBottom(modelGenerator, BlockusBlocks.RAINBOW_ASPHALT);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.RAINBOW_ROSE, BlockusBlocks.POTTED_RAINBOW_ROSE, PlantType.NOT_TINTED);

        // Purpur Blocks
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_PURPUR);
        modelGenerator.createTrivialBlock(BlockusBlocks.PURPUR_DECORATED_END_STONE, TexturedModel.COLUMN_ALT);
        this.registerLines(modelGenerator, BlockusBlocks.PURPUR_LINES);
        modelGenerator.createTrivialCube(BlockusBlocks.PURPUR_SQUARES);

        // Phantom Purpur Blocks
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_PHANTOM_PURPUR);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.PHANTOM_PURPUR_DECORATED_END_STONE, BlockusBlocks.PURPUR_DECORATED_END_STONE);
        this.registerLines(modelGenerator, BlockusBlocks.PHANTOM_PURPUR_LINES);
        this.registerPillar(modelGenerator, BlockusBlocks.PHANTOM_PURPUR_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.PHANTOM_PURPUR_SQUARES);

        // End Stone
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_END_STONE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_END_STONE_BRICKS);
        this.registerPillar(modelGenerator, BlockusBlocks.END_STONE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE, BlockusBlocks.POLISHED_END_STONE_BUTTON, BlockusBlocks.POLISHED_END_STONE.block());
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_END_STONE_BRICKS);

        // White Oak Wood
        modelGenerator.woodProvider(BlockusBlocks.WHITE_OAK_LOG).logWithHorizontal(BlockusBlocks.WHITE_OAK_LOG).wood(BlockusBlocks.WHITE_OAK_WOOD);
        modelGenerator.createTrivialBlock(BlockusBlocks.WHITE_OAK_LEAVES, TexturedModel.LEAVES);
        modelGenerator.woodProvider(BlockusBlocks.STRIPPED_WHITE_OAK_LOG).logWithHorizontal(BlockusBlocks.STRIPPED_WHITE_OAK_LOG).wood(BlockusBlocks.STRIPPED_WHITE_OAK_WOOD);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.WHITE_OAK_SAPLING, BlockusBlocks.POTTED_WHITE_OAK_SAPLING, PlantType.NOT_TINTED);

        // Hanging Signs
        modelGenerator.createHangingSign(BlockusBlocks.WHITE_OAK_LOG, BlockusBlocks.WHITE_OAK.ceilingHangingSign(), BlockusBlocks.WHITE_OAK.wallHangingSign());
        modelGenerator.createHangingSign(BlockusBlocks.RAW_BAMBOO.planks(), BlockusBlocks.RAW_BAMBOO.ceilingHangingSign(), BlockusBlocks.RAW_BAMBOO.wallHangingSign());
        modelGenerator.createHangingSign(BlockusBlocks.CHARRED.planks(), BlockusBlocks.CHARRED.ceilingHangingSign(), BlockusBlocks.CHARRED.wallHangingSign());

        // Herringbone Planks
        for (Block block : BlockusBlocks.HERRINGBONE_PLANKS.bundle().values()) {
            modelGenerator.createTrivialCube(block);
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
            modelGenerator.createTrivialCube(entry.getValue().block());
            modelGenerator.createTrivialCube(entry.getValue().cross());
            this.registerDiagonalTimberFrame(modelGenerator, entry.getValue().diagonal());
            modelGenerator.createGlassBlocks(entry.getValue().grate(), entry.getValue().lattice());
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
        modelGenerator.createTrivialCube(BlockusBlocks.CHOCOLATE_SQUARES);

        // Redstone Lamps
        this.registerLitRedstoneLamp(modelGenerator, Blocks.REDSTONE_LAMP, BlockusBlocks.REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.RAINBOW_LAMP, BlockusBlocks.RAINBOW_LAMP_LIT);
        for (DyeColor color : BlockOrder.COLOR) {
            this.registerRedstoneLamp(modelGenerator, BlockusBlocks.STAINED_REDSTONE_LAMP.colorMap().get(color), BlockusBlocks.STAINED_REDSTONE_LAMP_LIT.colorMap().get(color));
        }

        // Neon Blocks
        for (Block block : BlockusBlocks.NEON_BLOCK.colorMap().values()) {
            this.registerNeonBlock(modelGenerator, block);
        }
        this.registerNeonBlock(modelGenerator, BlockusBlocks.RAINBOW_NEON);

        // Futurneo Blocks
        for (Block block : BlockusBlocks.FUTURNEO_BLOCK.colorMap().values()) {
            modelGenerator.createTrivialCube(block);
        }
        modelGenerator.createTrivialCube(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK);

        // Glass - Beveled Glass
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.RAINBOW_BEVELED_GLASS, BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE);
        modelGenerator.createGlassBlocks(BlockusBlocks.RAINBOW_GLASS, BlockusBlocks.RAINBOW_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.BEVELED_GLASS, BlockusBlocks.BEVELED_GLASS_PANE);
        for (DyeColor color : BlockOrder.COLOR) {
            this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.STAINED_BEVELED_GLASS.colorMap().get(color), BlockusBlocks.STAINED_BEVELED_GLASS_PANE.colorMap().get(color));
        }
        modelGenerator.createTrivialCube(BlockusBlocks.TINTED_BEVELED_GLASS);

        // Glazed Terracotta Pillars
        for (Block block : BlockusBlocks.GLAZED_TERRACOTTA_PILLAR.colorMap().values()) {
            this.registerPillar(modelGenerator, block);
        }

        // Paper
        modelGenerator.createTrivialCube(BlockusBlocks.BURNT_PAPER_BLOCK);
        modelGenerator.createGlassBlocks(BlockusBlocks.FRAMED_PAPER_BLOCK, BlockusBlocks.PAPER_WALL);
        modelGenerator.createTrivialCube(BlockusBlocks.PAPER_BLOCK);
        modelGenerator.createOrientableTrapdoor(BlockusBlocks.PAPER_TRAPDOOR);
        modelGenerator.createDoor(BlockusBlocks.PAPER_DOOR);
        modelGenerator.createNonTemplateModelBlock(BlockusBlocks.PAPER_LAMP);

        // Lantern Blocks
        this.registerCubeColumn(modelGenerator, BlockusBlocks.LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        modelGenerator.createLantern(BlockusBlocks.AMETHYST_LANTERN);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.AMETHYST_LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        modelGenerator.createLantern(BlockusBlocks.REDSTONE_LANTERN);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.REDSTONE_LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.SOUL_LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        BlockusBlocks.COPPER_LANTERN_BLOCK.getWaxingMap().forEach((unwaxed, waxed) -> this.registerCopperCubeColumn(modelGenerator, unwaxed, waxed));
        this.registerPumpkins(modelGenerator, BlockusBlocks.SOUL_O_LANTERN);
        this.registerPumpkins(modelGenerator, BlockusBlocks.COPPER_JACK_O_LANTERN);
        this.registerPumpkins(modelGenerator, BlockusBlocks.REDSTONE_O_LANTERN);

        // Legacy
        this.registerLegacyStonecutter(modelGenerator, BlockusBlocks.LEGACY_STONECUTTER);
        modelGenerator.createTrivialBlock(BlockusBlocks.LEGACY_LEAVES, TexturedModel.LEAVES);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.LEGACY_SAPLING, BlockusBlocks.POTTED_LEGACY_SAPLING, PlantType.NOT_TINTED);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.LEGACY_LOG);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_NETHER_REACTOR_CORE);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_PLANKS);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_COBBLESTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_FIRST_COBBLESTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_MOSSY_COBBLESTONE);
        this.registerCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_GRASS_BLOCK, Blocks.DIRT);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_GRAVEL);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_COAL_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_LAPIS_BLOCK);
        this.registerCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_IRON_BLOCK);
        this.registerCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_GOLD_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK);
        this.registerCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_DIAMOND_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_SPONGE);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_CRYING_OBSIDIAN);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_GLOWING_OBSIDIAN);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_GLOWSTONE);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.LEGACY_ROSE, BlockusBlocks.POTTED_LEGACY_ROSE, PlantType.NOT_TINTED);
        registerFlowerPotPlantAndItem(modelGenerator, BlockusBlocks.LEGACY_BLUE_ROSE, BlockusBlocks.POTTED_LEGACY_BLUE_ROSE, PlantType.NOT_TINTED);

        // Colored Tiles
        modelGenerator.createTrivialCube(BlockusBlocks.RAINBOW_COLORED_TILES);
        for (DyeColor color : BlockOrder.COLOR) {
            this.registerColoredTilesSimple(modelGenerator, BlockusBlocks.COLORED_TILES.colorMap().get(color));
        }

        // Other
        this.registerStairsAndSlab(modelGenerator, BlockusBlocks.NETHERITE_STAIRS, BlockusBlocks.NETHERITE_SLAB, Blocks.NETHERITE_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.NETHER_STAR_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.RAINBOW_GLOWSTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.CAUTION_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.CHARCOAL_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.COMPANION_CUBE);
        modelGenerator.createTrivialCube(BlockusBlocks.ENDER_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.LOVE_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.MEMBRANE_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.REDSTONE_SAND);
        modelGenerator.createTrivialCube(BlockusBlocks.ROTTEN_FLESH_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.STARS_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.SUGAR_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.WEIGHT_STORAGE_CUBE);
        modelGenerator.registerSimpleFlatItemModel(BlockusBlocks.GOLDEN_CHAIN.asItem());
        modelGenerator.registerSimpleFlatItemModel(BlockusBlocks.GOLDEN_BARS);
        modelGenerator.registerSimpleFlatItemModel(BlockusBlocks.WOODEN_FRAME);
        this.registerGate(modelGenerator, BlockusBlocks.IRON_GATE);
        this.registerGate(modelGenerator, BlockusBlocks.GOLDEN_GATE);
        BlockusBlocks.COPPER_GATE.getWaxingMap().forEach((unwaxed, waxed) -> this.registerCopperGate(modelGenerator, unwaxed, waxed));
        registerInventoryItemModel(modelGenerator, BlockusBlocks.CAUTION_BARRIER);
        registerInventoryItemModel(modelGenerator, BlockusBlocks.ROAD_BARRIER);
        modelGenerator.registerSimpleItemModel(BlockusBlocks.PATH, ModelLocationUtils.getModelLocation(BlockusBlocks.PATH, "4"));
    }

    @Override
    public void generateItemModels(ItemModelGenerators modelGenerator) {
        modelGenerator.generateFlatItem(BlockusEntities.CHARRED_BOAT.asItem(), ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusEntities.CHARRED_CHEST_BOAT.asItem(), ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusEntities.RAW_BAMBOO_RAFT.asItem(), ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusEntities.RAW_BAMBOO_CHEST_RAFT.asItem(), ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusEntities.WHITE_OAK_BOAT.asItem(), ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusEntities.WHITE_OAK_CHEST_BOAT.asItem(), ModelTemplates.FLAT_ITEM);
    }

    public final void registerInventoryItemModel(BlockModelGenerators modelGenerator, Block block) {
        modelGenerator.registerSimpleItemModel(block, ModelLocationUtils.getModelLocation(block, "_inventory"));
    }

    public final void registerPillar(BlockModelGenerators modelGenerator, Block block) {
        modelGenerator.createRotatedPillarWithHorizontalVariant(block, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    }

    public final void registerLines(BlockModelGenerators modelGenerator, Block block) {
        modelGenerator.createAxisAlignedPillarBlock(block, TexturedModel.CUBE);
    }

    public final void registerBlockStairsSlabAndWall(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab, Block wall) {
        modelGenerator.family(block).stairs(stairs).slab(slab).wall(wall);
    }

    public final void registerBlockStairsAndSlab(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab) {
        modelGenerator.family(block).stairs(stairs).slab(slab);
    }

    public final void registerButtonAndPressurePlate(BlockModelGenerators modelGenerator, Block pressurePlateBlock, Block buttonBlock, Block textureID) {
        this.registerButton(modelGenerator, buttonBlock, TextureMapping.getBlockTexture(textureID));
        this.registerPressurePlate(modelGenerator, pressurePlateBlock, TextureMapping.getBlockTexture(textureID));
    }

    public final void registerButtonAndPressurePlate(BlockModelGenerators modelGenerator, Block pressurePlateBlock, Block buttonBlock, Identifier textureSource) {
        this.registerButton(modelGenerator, buttonBlock, textureSource);
        this.registerPressurePlate(modelGenerator, pressurePlateBlock, textureSource);
    }

    public final void registerPost(BlockModelGenerators modelGenerator, Block block, Block textureSource) {
        TextureMapping textureMap = TextureMapping.logColumn(textureSource);
        Identifier identifier = BlockusModels.TEMPLATE_POST.create(block, textureMap, modelGenerator.modelOutput);
        MultiVariant modelVariant = plainVariant(BlockusModels.TEMPLATE_POST_CONNECT.create(block, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant2 = plainVariant(BlockusModels.TEMPLATE_POST_CONNECT_TOP.create(block, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createPostBlockState(block, plainVariant(identifier), modelVariant, modelVariant2, plainVariant(Blockus.id("block/chain_connect")), plainVariant(Blockus.id("block/chain_connect_top"))));
        modelGenerator.registerSimpleItemModel(block, identifier);
    }

    public static BlockModelDefinitionGenerator createPostBlockState(Block postBlock, MultiVariant postModelId, MultiVariant sideModelId, MultiVariant topModelId, MultiVariant chainModelId, MultiVariant topChainModelId) {
        return MultiPartGenerator.multiPart(postBlock)
            .with(condition().term(BlockStateProperties.AXIS, Direction.Axis.X), postModelId.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(BlockStateProperties.AXIS, Direction.Axis.Y), postModelId)
            .with(condition().term(BlockStateProperties.AXIS, Direction.Axis.Z), postModelId.with(X_ROT_90))
            .with(condition().term(PostBlock.NORTH, PostBlock.ConnectionType.POST), topModelId.with(X_ROT_90))
            .with(condition().term(PostBlock.SOUTH, PostBlock.ConnectionType.POST), sideModelId.with(X_ROT_90))
            .with(condition().term(PostBlock.EAST, PostBlock.ConnectionType.POST), topModelId.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(PostBlock.WEST, PostBlock.ConnectionType.POST), sideModelId.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(PostBlock.UP, PostBlock.ConnectionType.POST), topModelId)
            .with(condition().term(PostBlock.DOWN, PostBlock.ConnectionType.POST), sideModelId)
            .with(condition().term(PostBlock.NORTH, PostBlock.ConnectionType.CHAIN), topChainModelId.with(X_ROT_90))
            .with(condition().term(PostBlock.SOUTH, PostBlock.ConnectionType.CHAIN), chainModelId.with(X_ROT_90))
            .with(condition().term(PostBlock.EAST, PostBlock.ConnectionType.CHAIN), topChainModelId.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(PostBlock.WEST, PostBlock.ConnectionType.CHAIN), chainModelId.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(PostBlock.UP, PostBlock.ConnectionType.CHAIN), topChainModelId)
            .with(condition().term(PostBlock.DOWN, PostBlock.ConnectionType.CHAIN), chainModelId);
    }

    public final void registerCookieBlock(BlockModelGenerators modelGenerator) {
        Block block = BlockusBlocks.COOKIE_BLOCK;
        MultiVariant modelVariant = plainVariant(TexturedModel.CUBE.create(block, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockusBlockStateProperties.BITES_9)
            .select(0, plainVariant(ModelLocationUtils.getModelLocation(block)))
            .select(1, plainVariant(ModelLocationUtils.getModelLocation(block, "_slice1")))
            .select(2, plainVariant(ModelLocationUtils.getModelLocation(block, "_slice2")))
            .select(3, plainVariant(ModelLocationUtils.getModelLocation(block, "_slice3")))
            .select(4, plainVariant(ModelLocationUtils.getModelLocation(block, "_slice4")))
            .select(5, plainVariant(ModelLocationUtils.getModelLocation(block, "_slice5")))
            .select(6, plainVariant(ModelLocationUtils.getModelLocation(block, "_slice6")))
            .select(7, plainVariant(ModelLocationUtils.getModelLocation(block, "_slice7")))
            .select(8, plainVariant(ModelLocationUtils.getModelLocation(block, "_slice8")))));
    }

    public final void registerAmethystLamp(BlockModelGenerators modelGenerator) {
        Block block = BlockusBlocks.AMETHYST_LAMP;
        MultiVariant modelVariant = plainVariant(TexturedModel.CUBE.create(block, modelGenerator.modelOutput));
        MultiVariant modelVariant2 = plainVariant(modelGenerator.createSuffixedVariant(block, "_low", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        MultiVariant modelVariant3 = plainVariant(modelGenerator.createSuffixedVariant(block, "_medium", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        MultiVariant modelVariant4 = plainVariant(modelGenerator.createSuffixedVariant(block, "_high", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.POWER)
            .select(0, plainVariant(ModelLocationUtils.getModelLocation(block)))
            .select(1, modelVariant2)
            .select(2, modelVariant2)
            .select(3, modelVariant2)
            .select(4, modelVariant2)
            .select(5, modelVariant2)
            .select(6, modelVariant3)
            .select(7, modelVariant3)
            .select(8, modelVariant3)
            .select(9, modelVariant3)
            .select(10, modelVariant3)
            .select(11, modelVariant4)
            .select(12, modelVariant4)
            .select(13, modelVariant4)
            .select(14, modelVariant4)
            .select(15, modelVariant4)));
    }

    public final void registerSmallHedge(BlockModelGenerators modelGenerator, Block hedgeBlock, Block textureSource) {
        registerSmallHedge(modelGenerator, hedgeBlock, textureSource, false, 0);
    }

    public final void registerSmallHedge(BlockModelGenerators modelGenerator, Block hedgeBlock, Block textureSource, int tintColor) {
        registerSmallHedge(modelGenerator, hedgeBlock, textureSource, true, tintColor);
    }

    public final void registerSmallHedge(BlockModelGenerators modelGenerator, Block hedgeBlock, Block textureSource, boolean isTinted, int tintColor) {
        TextureMapping textureMap = TextureMapping.singleSlot(BlockusTextureKey.HEDGE, TextureMapping.getBlockTexture(textureSource));
        MultiVariant weightedVariant = plainVariant(BlockusModels.TEMPLATE_HEDGE_POST.create(hedgeBlock, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant2 = plainVariant(BlockusModels.TEMPLATE_HEDGE_SIDE.create(hedgeBlock, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant3 = plainVariant(BlockusModels.TEMPLATE_HEDGE_SIDE_ALT.create(hedgeBlock, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant4 = plainVariant(BlockusModels.TEMPLATE_HEDGE_NOSIDE.create(hedgeBlock, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant5 = plainVariant(BlockusModels.TEMPLATE_HEDGE_NOSIDE_ALT.create(hedgeBlock, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(hedgeBlock).with(weightedVariant).with(condition().term(BlockStateProperties.NORTH, true), weightedVariant2.with(UV_LOCK)).with(condition().term(BlockStateProperties.EAST, true), weightedVariant2.with(Y_ROT_90).with(UV_LOCK)).with(condition().term(BlockStateProperties.SOUTH, true), weightedVariant3.with(UV_LOCK)).with(condition().term(BlockStateProperties.WEST, true), weightedVariant3.with(Y_ROT_90).with(UV_LOCK)).with(condition().term(BlockStateProperties.NORTH, false), weightedVariant4.with(UV_LOCK)).with(condition().term(BlockStateProperties.EAST, false), weightedVariant5.with(UV_LOCK)).with(condition().term(BlockStateProperties.SOUTH, false), weightedVariant5.with(Y_ROT_90).with(UV_LOCK)).with(condition().term(BlockStateProperties.WEST, false), weightedVariant4.with(Y_ROT_270).with(UV_LOCK)));
        Identifier identifier = BlockusModels.TEMPLATE_HEDGE_INVENTORY.create(hedgeBlock, textureMap, modelGenerator.modelOutput);
        if (isTinted) {
            modelGenerator.registerSimpleTintedItemModel(hedgeBlock, identifier, ItemModelUtils.constantTint(tintColor));
        } else {
            modelGenerator.registerSimpleItemModel(hedgeBlock, identifier);
        }
    }

    public final void registerCarpet(BlockModelGenerators modelGenerator, Block wool, Block carpet) {
        MultiVariant modelVariant = plainVariant(TexturedModel.CARPET.get(wool).create(carpet, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createSimpleBlock(carpet, modelVariant));
    }

    public final void registerDirectionalCarpet(BlockModelGenerators modelGenerator, Block block, Block carpet) {
        TexturedModel.CARPET.get(block).create(carpet, modelGenerator.modelOutput);
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(carpet, plainVariant(ModelLocationUtils.getModelLocation(carpet))).with(createUpDefaultRotationStates()));
    }

    public final void registerBlockStairsSlabWithBottom(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab, Block base) {
        Identifier textureID = TextureMapping.getBlockTexture(base, "_bottom");
        TextureMapping blockTextureMap = TextureMapping.singleSlot(TextureSlot.ALL, textureID);
        TextureMapping textureMap = sideTopBottom(textureID);
        this.createBlock(modelGenerator, block, blockTextureMap);
        this.createStairs(modelGenerator, stairs, textureMap);
        this.createSlab(modelGenerator, slab, textureMap, getBlockId(block));
    }

    public final void registerBlockStairsSlabWithTop(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab, Block base) {
        Identifier textureID = TextureMapping.getBlockTexture(base, "_top");
        TextureMapping blockTextureMap = TextureMapping.singleSlot(TextureSlot.ALL, textureID);
        TextureMapping textureMap = sideTopBottom(textureID);
        this.createBlock(modelGenerator, block, blockTextureMap);
        this.createStairs(modelGenerator, stairs, textureMap);
        this.createSlab(modelGenerator, slab, textureMap, getBlockId(block));
    }

    public final void registerBlockStairsSlabwithTopBottom(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab) {
        TextureMapping textureMap = sideTopBottom(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(block, "_top"), TextureMapping.getBlockTexture(block, "_bottom"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_BOTTOM_TOP, textureMap);
        this.createStairs(modelGenerator, stairs, textureMap);
        this.createSlab(modelGenerator, slab, textureMap, getBlockId(block));
    }

    public final void registerStairs(BlockModelGenerators modelGenerator, Block block, Block textureSource) {
        TextureMapping textureMap = sideTopBottom(TextureMapping.getBlockTexture(textureSource));
        this.createStairs(modelGenerator, block, textureMap);
    }

    public final void registerSlab(BlockModelGenerators modelGenerator, Block block, Block textureSource) {
        TextureMapping textureMap = sideTopBottom(TextureMapping.getBlockTexture(textureSource));
        this.createSlab(modelGenerator, block, textureMap, TextureMapping.getBlockTexture(textureSource));
    }

    public final void registerStairsAndSlab(BlockModelGenerators modelGenerator, Block stairs, Block slab, Block block) {
        this.registerStairs(modelGenerator, stairs, block);
        this.registerSlab(modelGenerator, slab, block);
    }

    public final void registerSlabwithTop(BlockModelGenerators modelGenerator, Block block, Block textureSource, Block end) {
        TextureMapping textureMap = sideTopBottom(TextureMapping.getBlockTexture(textureSource), TextureMapping.getBlockTexture(end, "_top"));
        this.createSlab(modelGenerator, block, textureMap, TextureMapping.getBlockTexture(textureSource));
    }

    public final void registerWall(BlockModelGenerators modelGenerator, Block block, Block textureSource) {
        TextureMapping textureMap = TextureMapping.singleSlot(TextureSlot.WALL, TextureMapping.getBlockTexture(textureSource));
        this.createWall(modelGenerator, block, textureMap);
    }

    public final void registerButton(BlockModelGenerators modelGenerator, Block buttonBlock, Identifier textureSource) {
        TextureMapping textureMap = TextureMapping.defaultTexture(textureSource);
        MultiVariant modelVariant = plainVariant(ModelTemplates.BUTTON.create(buttonBlock, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant2 = plainVariant(ModelTemplates.BUTTON_PRESSED.create(buttonBlock, textureMap, modelGenerator.modelOutput));
        Identifier identifier = ModelTemplates.BUTTON_INVENTORY.create(buttonBlock, textureMap, modelGenerator.modelOutput);
        modelGenerator.blockStateOutput.accept(createButton(buttonBlock, modelVariant, modelVariant2));
        modelGenerator.registerSimpleItemModel(buttonBlock, identifier);
    }

    public final void registerPressurePlate(BlockModelGenerators modelGenerator, Block pressurePlateBlock, Identifier textureSource) {
        TextureMapping textureMap = TextureMapping.defaultTexture(textureSource);
        MultiVariant modelVariant = plainVariant(ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlateBlock, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant2 = plainVariant(ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlateBlock, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createPressurePlate(pressurePlateBlock, modelVariant, modelVariant2));
    }

    public final void registerRedstoneLamp(BlockModelGenerators modelGenerator, Block block, Block lit) {
        registerLitRedstoneLamp(modelGenerator, block, lit);
        MultiVariant modelVariant = plainVariant(TexturedModel.CUBE.create(block, modelGenerator.modelOutput));
        MultiVariant modelVariant2 = plainVariant(modelGenerator.createSuffixedVariant(block, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(createBooleanModelDispatch(BlockStateProperties.LIT, modelVariant2, modelVariant)));

    }

    public final void registerLitRedstoneLamp(BlockModelGenerators modelGenerator, Block block, Block lit) {
        TextureMapping textureMap = TextureMapping.singleSlot(TextureSlot.ALL, TextureMapping.getBlockTexture(block, "_on"));
        this.createBlock(modelGenerator, lit, textureMap);
    }

    public void createAxisRotatedCubeColumn(BlockModelGenerators modelGenerator, Block block, TextureMapping textureMap) {
        MultiVariant modelVariant = plainVariant(ModelTemplates.CUBE_COLUMN.create(block, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant2 = plainVariant(ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(block, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createRotatedPillarWithHorizontalVariant(block, modelVariant, modelVariant2));
    }

    public final void registerAxisRotatedCubeColumn(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping textureMap = TextureMapping.logColumn(block);
        this.createAxisRotatedCubeColumn(modelGenerator, block, textureMap);
    }

    public final void registerAxisRotatedCubeColumn(BlockModelGenerators modelGenerator, Block block, Block end) {
        TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(end));
        this.createAxisRotatedCubeColumn(modelGenerator, block, textureMap);
    }

    public final void registerCubeColumn(BlockModelGenerators modelGenerator, Block block, Block end) {
        TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(end, "_top"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_COLUMN, textureMap);
    }

    public final void registerCopperCubeColumn(BlockModelGenerators modelGenerator, Block unwaxed, Block waxed) {
        TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(unwaxed), TextureMapping.getBlockTexture(unwaxed, "_top"));
        this.createBlock(modelGenerator, unwaxed, ModelTemplates.CUBE_COLUMN, textureMap);
        this.createBlock(modelGenerator, waxed, ModelTemplates.CUBE_COLUMN, textureMap);
    }

    public final void registerCubeColumnNoSuffix(BlockModelGenerators modelGenerator, Block block, Block end) {
        TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(end));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_COLUMN, textureMap);
    }

    public final void registerCubeBottomTop(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping textureMap = sideTopBottom(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(block, "_top"), TextureMapping.getBlockTexture(block, "_bottom"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_BOTTOM_TOP, textureMap);
    }

    public final void registerCubeBottomTop(BlockModelGenerators modelGenerator, Block block, Block bottom) {
        TextureMapping textureMap = sideTopBottom(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(block, "_top"), TextureMapping.getBlockTexture(bottom));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_BOTTOM_TOP, textureMap);
    }

    public final void registerUpDefaultFacingBlock(BlockModelGenerators modelGenerator, Block block) {
        MultiVariant modelVariant = plainVariant(TexturedModel.CUBE.create(block, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, modelVariant).with(createUpDefaultRotationStates()));
    }

    public final void registerTopBottomFacingBottom(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping textureMap = sideTopBottom(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(block, "_top"), TextureMapping.getBlockTexture(block, "_bottom"));
        MultiVariant modelVariant = plainVariant(ModelTemplates.CUBE_BOTTOM_TOP.create(block, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, modelVariant).with(createUpDefaultRotationStates()));
    }

    public final void registerPumpkins(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping textureMap = TextureMapping.column(Blocks.PUMPKIN);
        modelGenerator.createPumpkinVariant(block, textureMap);
    }

    public final void registerSturdyStone(BlockModelGenerators modelGenerator) {
        Identifier identifier = TextureMapping.getBlockTexture(Blocks.FURNACE, "_top");
        this.createBlock(modelGenerator, BlockusBlocks.STURDY_STONE, TextureMapping.singleSlot(TextureSlot.ALL, identifier));
    }

    public final void registerSmoothStoneStairs(BlockModelGenerators modelGenerator) {
        TextureMapping textureMap = sideTopBottom(TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE_SLAB, "_side"), TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE));
        this.createStairs(modelGenerator, BlockusBlocks.SMOOTH_STONE_STAIRS, textureMap);
    }

    public final void registerNeonBlock(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping textureMap = TextureMapping.singleSlot(TextureSlot.ALL, TextureMapping.getBlockTexture(block));
        this.createBlock(modelGenerator, block, BlockusModels.NEON_BLOCK_TEMPLATE, textureMap);
    }

    public final void registerFishCrate(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping textureMap = sideTopBottom(getBlockId("fish_crate_side"), TextureMapping.getBlockTexture(block), getBlockId("fish_crate_bottom"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_BOTTOM_TOP, textureMap);
    }

    public final void registerCopperBlocks(BlockModelGenerators modelGenerator, CopperBSSWBundle block, BlockusFamilies.CopperFamily family) {
        modelGenerator.family(block.block()).generateFor(family.unwaxed).donateModelTo(block.block(), block.blockWaxed()).generateFor(family.waxed);
    }

    public final void registerCrate(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping textureMap = sideTop(TextureMapping.getBlockTexture(block, "_side"), TextureMapping.getBlockTexture(block));
        this.createBlock(modelGenerator, block, BlockusModels.CRATE_TEMPLATE, textureMap);
    }

    public final void registerBreadBox(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping textureMap = frontTopSideBottom(block);
        MultiVariant modelVariant = plainVariant(ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM.create(block, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, modelVariant).with(PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING).select(Direction.EAST, Y_ROT_90).select(Direction.SOUTH, Y_ROT_180).select(Direction.WEST, Y_ROT_270).select(Direction.NORTH, NOP)));
    }

    public void registerLegacyStonecutter(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping textureMap = (new TextureMapping()).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_front")).put(TextureSlot.DOWN, TextureMapping.getBlockTexture(block, "_bottom")).put(TextureSlot.UP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.NORTH, TextureMapping.getBlockTexture(block, "_front")).put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(block, "_front")).put(TextureSlot.EAST, TextureMapping.getBlockTexture(block, "_side")).put(TextureSlot.WEST, TextureMapping.getBlockTexture(block, "_side"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE, textureMap);
    }

    private void registerDiagonalTimberFrame(BlockModelGenerators modelGenerator, Block block) {
        MultiVariant modelVariant = plainVariant(ModelLocationUtils.getModelLocation(block));
        Identifier identifier = TextureMapping.getBlockTexture(block, "_right");
        Identifier identifier2 = TextureMapping.getBlockTexture(block, "_left");
        TextureMapping textureMap = (new TextureMapping()).put(TextureSlot.PARTICLE, identifier).put(TextureSlot.NORTH, identifier).put(TextureSlot.SOUTH, identifier).put(TextureSlot.EAST, identifier).put(TextureSlot.WEST, identifier2).put(TextureSlot.DOWN, identifier2).put(TextureSlot.UP, identifier2);
        ModelTemplates.CUBE.create(block, textureMap, modelGenerator.modelOutput);
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
            .select(Direction.NORTH, modelVariant)
            .select(Direction.SOUTH, modelVariant.with(Y_ROT_180))
            .select(Direction.WEST, modelVariant.with(Y_ROT_270))
            .select(Direction.EAST, modelVariant.with(Y_ROT_90))));
    }

    public final void registerBeveledGlassPane(BlockModelGenerators modelGenerator, Block glass, Block glassPane) {
        modelGenerator.createTrivialCube(glass);
        TextureMapping textureMap = TextureMapping.pane(glass, BlockusBlocks.BEVELED_GLASS_PANE);
        MultiVariant modelVariant = plainVariant(ModelTemplates.STAINED_GLASS_PANE_POST.create(glassPane, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant2 = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE.create(glassPane, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant3 = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(glassPane, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant4 = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(glassPane, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant5 = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(glassPane, textureMap, modelGenerator.modelOutput));
        Item item = glassPane.asItem();
        modelGenerator.registerSimpleItemModel(item, modelGenerator.createFlatItemModelWithBlockTexture(item, glass));
        modelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(glassPane).with(modelVariant).with(condition().term(BlockStateProperties.NORTH, true), modelVariant2).with(condition().term(BlockStateProperties.EAST, true), modelVariant2.with(Y_ROT_90)).with(condition().term(BlockStateProperties.SOUTH, true), modelVariant3).with(condition().term(BlockStateProperties.WEST, true), modelVariant3.with(Y_ROT_90)).with(condition().term(BlockStateProperties.NORTH, false), modelVariant4).with(condition().term(BlockStateProperties.EAST, false), modelVariant5).with(condition().term(BlockStateProperties.SOUTH, false), modelVariant5.with(Y_ROT_90)).with(condition().term(BlockStateProperties.WEST, false), modelVariant4.with(Y_ROT_270)));
    }

    public static void registerColoredTiles(BlockModelGenerators modelGenerator, Block block, Block tile1, Block tile2) {
        TextureMapping textures = tilesTextures(tile1, tile2);
        BlockusModels.CUBE_TILES.create(block, textures, modelGenerator.modelOutput);
        BlockusModels.CUBE_TILES_2.create(block, textures, modelGenerator.modelOutput);
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_AXIS)
            .select(Direction.Axis.X, plainVariant(ModelLocationUtils.getModelLocation(block)))
            .select(Direction.Axis.Z, plainVariant(ModelLocationUtils.getModelLocation(block, "_2")))));
    }

    public final void registerColoredTilesSimple(BlockModelGenerators modelGenerator, Block block) {
        Identifier identifier = getModifiedBlockId(block, "_colored", "");
        this.createBlock(modelGenerator, block, TextureMapping.singleSlot(TextureSlot.ALL, identifier));
    }

    public final void createBlock(BlockModelGenerators modelGenerator, Block block, ModelTemplate model, TextureMapping textureMap) {
        modelGenerator.blockStateOutput.accept(createSimpleBlock(block, plainVariant(model.create(block, textureMap, modelGenerator.modelOutput))));
    }

    public final void createBlock(BlockModelGenerators modelGenerator, Block block, TextureMapping textureMap) {
        modelGenerator.blockStateOutput.accept(createSimpleBlock(block, plainVariant(ModelTemplates.CUBE_ALL.create(block, textureMap, modelGenerator.modelOutput))));
    }

    public final void createStairs(BlockModelGenerators modelGenerator, Block block, TextureMapping textureMap) {
        MultiVariant modelVariant = plainVariant(ModelTemplates.STAIRS_INNER.create(block, textureMap, modelGenerator.modelOutput));
        Identifier identifier = ModelTemplates.STAIRS_STRAIGHT.create(block, textureMap, modelGenerator.modelOutput);
        MultiVariant modelVariant2 = plainVariant(ModelTemplates.STAIRS_OUTER.create(block, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createStairs(block, modelVariant, plainVariant(identifier), modelVariant2));
        modelGenerator.registerSimpleItemModel(block, identifier);
    }

    public final void createSlab(BlockModelGenerators modelGenerator, Block block, TextureMapping textureMap, Identifier doubleSlab) {
        Identifier identifier = ModelTemplates.SLAB_BOTTOM.create(block, textureMap, modelGenerator.modelOutput);
        MultiVariant modelVariant = plainVariant(ModelTemplates.SLAB_TOP.create(block, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createSlab(block, plainVariant(identifier), modelVariant, plainVariant(doubleSlab)));
        modelGenerator.registerSimpleItemModel(block, identifier);
    }

    public final void createWall(BlockModelGenerators modelGenerator, Block block, TextureMapping textureMap) {
        MultiVariant modelVariant = plainVariant(ModelTemplates.WALL_POST.create(block, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant2 = plainVariant(ModelTemplates.WALL_LOW_SIDE.create(block, textureMap, modelGenerator.modelOutput));
        MultiVariant modelVariant3 = plainVariant(ModelTemplates.WALL_TALL_SIDE.create(block, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createWall(block, modelVariant, modelVariant2, modelVariant3));
        Identifier identifier = ModelTemplates.WALL_INVENTORY.create(block, textureMap, modelGenerator.modelOutput);
        modelGenerator.registerSimpleItemModel(block, identifier);
    }

    public void registerGate(BlockModelGenerators modelGenerator, Block gateBlock) {
        TextureMapping textureMap = TextureMapping.door(gateBlock);
        MultiVariant weightedVariant = plainVariant(BlockusModels.GATE_BOTTOM.create(gateBlock, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant2 = plainVariant(BlockusModels.GATE_BOTTOM_HINGE.create(gateBlock, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant3 = plainVariant(BlockusModels.GATE_TOP.create(gateBlock, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant4 = plainVariant(BlockusModels.GATE_TOP_HINGE.create(gateBlock, textureMap, modelGenerator.modelOutput));
        modelGenerator.registerSimpleFlatItemModel(gateBlock.asItem());
        modelGenerator.blockStateOutput.accept(createDoor(gateBlock, weightedVariant, weightedVariant2, weightedVariant2, weightedVariant, weightedVariant3, weightedVariant4, weightedVariant4, weightedVariant3));
    }

    public void registerCopperGate(BlockModelGenerators modelGenerator, Block unwaxed, Block waxed) {
        TextureMapping textureMap = TextureMapping.door(unwaxed);
        MultiVariant weightedVariant = plainVariant(BlockusModels.GATE_BOTTOM.create(unwaxed, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant2 = plainVariant(BlockusModels.GATE_BOTTOM_HINGE.create(unwaxed, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant3 = plainVariant(BlockusModels.GATE_TOP.create(unwaxed, textureMap, modelGenerator.modelOutput));
        MultiVariant weightedVariant4 = plainVariant(BlockusModels.GATE_TOP_HINGE.create(unwaxed, textureMap, modelGenerator.modelOutput));
        Identifier identifier = modelGenerator.createFlatItemModel(unwaxed.asItem());
        modelGenerator.registerSimpleItemModel(unwaxed.asItem(), identifier);
        modelGenerator.registerSimpleItemModel(waxed.asItem(), identifier);
        modelGenerator.blockStateOutput.accept(createDoor(unwaxed, weightedVariant, weightedVariant2, weightedVariant2, weightedVariant, weightedVariant3, weightedVariant4, weightedVariant4, weightedVariant3));
        modelGenerator.blockStateOutput.accept(createDoor(waxed, weightedVariant, weightedVariant2, weightedVariant2, weightedVariant, weightedVariant3, weightedVariant4, weightedVariant4, weightedVariant3));

    }

    public static PropertyDispatch createUpDefaultRotationStates() {
        return PropertyDispatch.modify(BlockStateProperties.FACING)
            .select(Direction.DOWN, X_ROT_180)
            .select(Direction.UP, NOP)
            .select(Direction.NORTH, X_ROT_270.then(Y_ROT_180))
            .select(Direction.SOUTH, X_ROT_270)
            .select(Direction.WEST, X_ROT_270.then(Y_ROT_90))
            .select(Direction.EAST, X_ROT_270.then(Y_ROT_270));
    }

    public static Identifier getTilesId(Block block) {
        return getModifiedBlockId(block, "_concrete", "_tiles");
    }

    public static Identifier getBlockId(String id) {
        return Blockus.id("block/" + id);
    }

    public static Identifier getBlockId(Block block) {
        return Blockus.id("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath());
    }

    public static Identifier getModifiedBlockId(Block block, String target, String replacement) {
        return Blockus.id("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath().replace(target, replacement));
    }

// TextureMaps

    private static TextureMapping tilesTextures(Block tile1, Block tile2) {
        return (new TextureMapping()).put(BlockusTextureKey.TILE_1, getTilesId(tile1)).put(BlockusTextureKey.TILE_2, getTilesId(tile2));
    }

    public static TextureMapping sideTop(Identifier block, Identifier top) {
        return (new TextureMapping()).put(TextureSlot.SIDE, block).put(TextureSlot.TOP, top);
    }

    public static TextureMapping sideTopBottom(Identifier block, Identifier top, Identifier bottom) {
        return (new TextureMapping()).put(TextureSlot.SIDE, block).put(TextureSlot.TOP, top).put(TextureSlot.BOTTOM, bottom);
    }

    public static TextureMapping sideTopBottom(Identifier block, Identifier end) {
        return (new TextureMapping()).put(TextureSlot.SIDE, block).put(TextureSlot.TOP, end).put(TextureSlot.BOTTOM, end);
    }

    public static TextureMapping sideTopBottom(Identifier block) {
        return (new TextureMapping()).put(TextureSlot.SIDE, block).put(TextureSlot.TOP, block).put(TextureSlot.BOTTOM, block);
    }

    public static TextureMapping frontTopSideBottom(Block block) {
        return (new TextureMapping()).put(TextureSlot.FRONT, TextureMapping.getBlockTexture(block)).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side")).put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_side"));
    }

    // Tint
    public final void registerTintableCrossBlockState(BlockModelGenerators modelGenerator, Block block, PlantType tintType) {
        TextureMapping textureMap = tintType.getTextureMapping(block);
        this.registerTintableCrossBlockState(modelGenerator, block, textureMap);
    }

    public final void registerTintableCrossBlockState(BlockModelGenerators modelGenerator, Block block, TextureMapping crossTexture) {
        MultiVariant modelVariant = plainVariant(ModelTemplates.CROSS.create(block, crossTexture, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createSimpleBlock(block, modelVariant));
    }

    public final void registerFlowerPotPlantAndItem(BlockModelGenerators modelGenerator, Block block, Block flowerPotBlock, PlantType crossType) {
        modelGenerator.registerSimpleItemModel(block.asItem(), crossType.createItemModel(modelGenerator, block));
        this.registerFlowerPotPlant(modelGenerator, block, flowerPotBlock, crossType);
    }

    public final void registerFlowerPotPlant(BlockModelGenerators modelGenerator, Block plantBlock, Block flowerPotBlock, PlantType tintType) {
        this.registerTintableCrossBlockState(modelGenerator, plantBlock, tintType);
        TextureMapping textureMap = tintType.getPlantTextureMapping(plantBlock);
        MultiVariant modelVariant = plainVariant(tintType.getCrossPot().create(flowerPotBlock, textureMap, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createSimpleBlock(flowerPotBlock, modelVariant));
    }
}
