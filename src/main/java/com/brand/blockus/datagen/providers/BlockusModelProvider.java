package com.brand.blockus.datagen.providers;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.PostBlock;
import com.brand.blockus.datagen.family.BlockusFamilies;
import com.brand.blockus.datagen.models.BlockusModels;
import com.brand.blockus.datagen.models.BlockusTextureSlot;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.BlockusItems;
import com.brand.blockus.registry.content.bundles.*;
import com.brand.blockus.utils.BlockusBlockStateProperties;
import com.brand.blockus.utils.helper.WoodMaps;
import com.mojang.math.Transformation;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WallSide;
import org.joml.Vector3f;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class BlockusModelProvider extends FabricModelProvider {

    public BlockusModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGenerator) {

        BlockusFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateModel).forEach((family) -> {
            modelGenerator.family(family.getBaseBlock()).generateFor(family);
        });

        for (BSSWBundle bundle : BSSWBundle.values()) {
            // Rough Sandstones
            if (bundle.type().contains("rough") && bundle.type().contains("sandstone")) {
                this.createBlockStairsSlabWithBottom(modelGenerator, bundle.block(), bundle.stairs(), bundle.slab(), bundle.base());
            }
            // Smooth Sandstones & Rough Basalt
            else if ((bundle.type().contains("smooth") && bundle.type().contains("sandstone")) ||
                bundle.block() == BlockusBlocks.ROUGH_BASALT.block()) {
                this.createBlockStairsSlabWithTop(modelGenerator, bundle.block(), bundle.stairs(), bundle.slab(), bundle.base());
            }
            // Soul Sandstone
            else if (bundle.block() == BlockusBlocks.SOUL_SANDSTONE.block()) {
                this.createBlockStairsSlabwithTopBottom(modelGenerator, bundle.block(), bundle.stairs(), bundle.slab());
            }
            // Autre
            else {
                this.createBlockStairsAndSlab(modelGenerator, bundle.block(), bundle.stairs(), bundle.slab());
            }

            if (bundle.wall() != null) {
                this.createWall(modelGenerator, bundle.wall(), bundle.block());
            }
        }

        for (DyedBSSWBundle bundle : DyedBSSWBundle.values()) {
            for (DyeColor color : DyeColor.values()) {
                this.createBlockStairsAndSlab(modelGenerator, bundle.block().blocks().pick(color), bundle.stairs().blocks().pick(color), bundle.slab().blocks().pick(color));
                if (bundle.wall() != null) {
                    this.createWall(modelGenerator, bundle.wall().blocks().pick(color), bundle.block().blocks().pick(color));
                }
            }
        }

        for (ConcreteBundle bundle : ConcreteBundle.values()) {
            for (DyeColor color : DyeColor.values()) {
                this.createBlockStairsSlabAndWall(modelGenerator, bundle.block().blocks().pick(color), bundle.stairs().blocks().pick(color), bundle.slab().blocks().pick(color), bundle.wall().blocks().pick(color));
                modelGenerator.createTrivialCube(bundle.chiseled().blocks().pick(color));
                this.createPillar(modelGenerator, bundle.pillar().blocks().pick(color));
            }
        }

        for (AsphaltBundle bundle : AsphaltBundle.values()) {
            for (DyeColor color : DyeColor.values()) {
                this.createBlockStairsAndSlab(modelGenerator, bundle.block().blocks().pick(color), bundle.stairs().blocks().pick(color), bundle.slab().blocks().pick(color));
            }
        }

        for (WoolBundle bundle : WoolBundle.values()) {
            for (DyeColor color : DyeColor.values()) {
                this.createBlockStairsAndSlab(modelGenerator, bundle.block().blocks().pick(color), bundle.stairs().blocks().pick(color), bundle.slab().blocks().pick(color));
                this.createCarpet(modelGenerator, bundle.block().blocks().pick(color), bundle.carpet().blocks().pick(color));
            }
        }

        modelGenerator.createTrivialCube(BlockusBlocks.RAINBOW_WOOL);
        this.createCarpet(modelGenerator, BlockusBlocks.RAINBOW_WOOL, BlockusBlocks.RAINBOW_CARPET);
        this.createBed(modelGenerator, BlockusBlocks.RAINBOW_BED);

        for (ColoredTilesBundle bundle : ColoredTilesBundle.values()) {
            createColoredTiles(modelGenerator, bundle.block(), bundle.tile1(), bundle.tile2());
        }

        // Large Pots
        createLargeFlowerPot(modelGenerator, BlockusBlocks.POTTED_ROSE_BUSH.block(), Blocks.ROSE_BUSH);
        createLargeFlowerPot(modelGenerator, BlockusBlocks.POTTED_LILAC.block(), Blocks.LILAC);
        createLargeFlowerPot(modelGenerator, BlockusBlocks.POTTED_PEONY.block(), Blocks.PEONY);
        createPottedPitcherPlant(modelGenerator, BlockusBlocks.POTTED_PITCHER_PLANT.block());
        createLargeFlowerPot(modelGenerator, BlockusBlocks.POTTED_LARGE_FERN.block(), Blocks.LARGE_FERN);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_OAK.block(), Blocks.OAK_LEAVES, Blocks.OAK_LOG);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_SPRUCE.block(), Blocks.SPRUCE_LEAVES, Blocks.SPRUCE_LOG);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_BIRCH.block(), Blocks.BIRCH_LEAVES, Blocks.BIRCH_LOG);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_JUNGLE.block(), Blocks.JUNGLE_LEAVES, Blocks.JUNGLE_LOG);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_ACACIA.block(), Blocks.ACACIA_LEAVES, Blocks.ACACIA_LOG);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_DARK_OAK.block(), Blocks.DARK_OAK_LEAVES, Blocks.DARK_OAK_LOG);
        modelGenerator.createNonTemplateModelBlock(BlockusBlocks.POTTED_MANGROVE.block());
        createTreePot(modelGenerator, BlockusBlocks.POTTED_CHERRY_BLOSSOM.block(), Blocks.CHERRY_LEAVES, Blocks.CHERRY_LOG, Blocks.MOSS_BLOCK);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_PALE_OAK.block(), Blocks.PALE_OAK_LEAVES, Blocks.PALE_OAK_LOG, Blocks.PALE_MOSS_BLOCK);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_WHITE_OAK.block(), BlockusBlocks.WHITE_OAK_LEAVES, BlockusBlocks.WHITE_OAK_LOG);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_LEGACY_TREE.block(), BlockusBlocks.LEGACY_LEAVES, BlockusBlocks.LEGACY_LOG, "legacy_grass_block_top");
        createHugeRedMushroomPot(modelGenerator, BlockusBlocks.POTTED_HUGE_RED_MUSHROOM.block());
        modelGenerator.createNonTemplateModelBlock(BlockusBlocks.POTTED_HUGE_BROWN_MUSHROOM.block());
        createTreePot(modelGenerator, BlockusBlocks.POTTED_HUGE_CRIMSON_FUNGUS.block(), Blocks.NETHER_WART_BLOCK, Blocks.CRIMSON_STEM, Blocks.CRIMSON_NYLIUM);
        createTreePot(modelGenerator, BlockusBlocks.POTTED_HUGE_WARPED_FUNGUS.block(), Blocks.WARPED_WART_BLOCK, Blocks.WARPED_STEM, Blocks.WARPED_NYLIUM);
        modelGenerator.createNonTemplateModelBlock(BlockusBlocks.POTTED_CACTUS_LARGE.block());
        modelGenerator.createNonTemplateModelBlock(BlockusBlocks.POTTED_BAMBOO_LARGE.block());
        createPottedAzaleaLarge(modelGenerator, BlockusBlocks.POTTED_AZALEA_LARGE.block(), Blocks.AZALEA);
        createPottedAzaleaLarge(modelGenerator, BlockusBlocks.POTTED_FLOWERING_AZALEA_LARGE.block(), Blocks.FLOWERING_AZALEA);
        modelGenerator.createNonTemplateModelBlock(BlockusBlocks.LARGE_FLOWER_POT);

        // Shelf
        modelGenerator.createShelf(BlockusBlocks.WHITE_OAK.shelf(), BlockusBlocks.STRIPPED_WHITE_OAK_LOG);
        modelGenerator.createShelf(BlockusBlocks.RAW_BAMBOO.shelf(), Blocks.BAMBOO_BLOCK);
        modelGenerator.createShelf(BlockusBlocks.CHARRED.shelf(), BlockusBlocks.CHARRED.planks());

        // Copper
        createCopperBlocks(modelGenerator, BlockusBlocks.COPPER_BRICKS, BlockusFamilies.COPPER_BRICKS);
        createCopperBlocks(modelGenerator, BlockusBlocks.COPPER_TUFF_BRICKS, BlockusFamilies.COPPER_TUFF_BRICKS);

        // Stone
        this.createPillar(modelGenerator, BlockusBlocks.STONE_BRICK_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_STONE_BRICKS);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.STONE_CIRCULAR_PAVING);
        modelGenerator.createDoor(BlockusBlocks.STONE_DOOR);
        modelGenerator.createOrientableTrapdoor(BlockusBlocks.STONE_TRAPDOOR);
        this.createSturdyStone(modelGenerator);
        this.createSmoothStoneStairs(modelGenerator);

        // Andesite
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.ANDESITE_CIRCULAR_PAVING);
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_ANDESITE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_ANDESITE_BRICKS);
        this.createPillar(modelGenerator, BlockusBlocks.POLISHED_ANDESITE_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_ANDESITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_ANDESITE_BUTTON, Blocks.POLISHED_ANDESITE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_ANDESITE_BRICKS);

        // Diorite
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_DIORITE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_DIORITE_BRICKS);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.DIORITE_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.POLISHED_DIORITE_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_DIORITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_DIORITE_BUTTON, Blocks.POLISHED_DIORITE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_DIORITE_BRICKS);

        // Granite
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_GRANITE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_GRANITE_BRICKS);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.GRANITE_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.POLISHED_GRANITE_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_GRANITE_PRESSURE_PLATE, BlockusBlocks.POLISHED_GRANITE_BUTTON, Blocks.POLISHED_GRANITE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_GRANITE_BRICKS);

        // Mud
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_MUD_BRICKS);
        this.createPillar(modelGenerator, BlockusBlocks.MUD_BRICK_PILLAR);

        // Dripstone
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_DRIPSTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_DRIPSTONE_BRICKS);
        this.createPillar(modelGenerator, BlockusBlocks.DRIPSTONE_PILLAR);

        // Sulfur
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_SULFUR_PRESSURE_PLATE, BlockusBlocks.POLISHED_SULFUR_BUTTON, Blocks.POLISHED_SULFUR);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.SULFUR_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.SULFUR_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_SULFUR_BRICKS);

        // Cinnabar
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_CINNABAR_PRESSURE_PLATE, BlockusBlocks.POLISHED_CINNABAR_BUTTON, Blocks.POLISHED_CINNABAR);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.CINNABAR_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.CINNABAR_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_CINNABAR_BRICKS);

        // Tuff
        modelGenerator.createTrivialCube(BlockusBlocks.CARVED_TUFF_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_TUFF_BRICKS);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_TUFF_PRESSURE_PLATE, BlockusBlocks.POLISHED_TUFF_BUTTON, Blocks.POLISHED_TUFF);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.TUFF_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.TUFF_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_TUFF_BRICKS);

        // Deepslate
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.DEEPSLATE_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.DEEPSLATE_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE, BlockusBlocks.POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);
        modelGenerator.createTrivialCube(BlockusBlocks.STURDY_DEEPSLATE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_DEEPSLATE_BRICKS);

        // Sculk
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_SCULK_BRICKS);
        this.createPillar(modelGenerator, BlockusBlocks.SCULK_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_SCULK_PRESSURE_PLATE, BlockusBlocks.POLISHED_SCULK_BUTTON, BlockusBlocks.POLISHED_SCULK.block());

        // Amethyst
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_AMETHYST);
        this.createPillar(modelGenerator, BlockusBlocks.AMETHYST_PILLAR);
        this.createAmethystLamp(modelGenerator);

        // Blackstone
        modelGenerator.createOrientableTrapdoor(BlockusBlocks.BLACKSTONE_TRAPDOOR);
        this.createCubeColumnNoSuffix(modelGenerator, BlockusBlocks.GOLD_DECORATED_POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.POLISHED_BLACKSTONE_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.POLISHED_BLACKSTONE_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.STURDY_BLACKSTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_POLISHED_BLACKSTONE_BRICKS);
        modelGenerator.createDoor(BlockusBlocks.BLACKSTONE_DOOR);

        // Basalt
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_POLISHED_BASALT);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_POLISHED_BASALT_BRICKS);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.POLISHED_BASALT_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.POLISHED_BASALT_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_BASALT_PRESSURE_PLATE, BlockusBlocks.POLISHED_BASALT_BUTTON, Blocks.POLISHED_BASALT, "_top");
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_POLISHED_BASALT_BRICKS);

        // Limestone
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_LIMESTONE);
        this.createAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_LIMESTONE_BRICKS, BlockusBlocks.POLISHED_LIMESTONE.block());
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.LIMESTONE_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.LIMESTONE_PILLAR);
        this.createPillar(modelGenerator, BlockusBlocks.CHISELED_LIMESTONE_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.LIMESTONE_PRESSURE_PLATE, BlockusBlocks.LIMESTONE_BUTTON, BlockusBlocks.LIMESTONE.block());
        this.createLinesBlock(modelGenerator, BlockusBlocks.LIMESTONE_LINES);

        // Marble
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_MARBLE);
        this.createAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_MARBLE_BRICKS, BlockusBlocks.POLISHED_MARBLE.block());
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.MARBLE_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.MARBLE_PILLAR);
        this.createPillar(modelGenerator, BlockusBlocks.CHISELED_MARBLE_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.MARBLE_PRESSURE_PLATE, BlockusBlocks.MARBLE_BUTTON, BlockusBlocks.MARBLE.block());
        this.createLinesBlock(modelGenerator, BlockusBlocks.MARBLE_LINES);

        // Bluestone
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.BLUESTONE_CIRCULAR_PAVING);
        this.createLinesBlock(modelGenerator, BlockusBlocks.BLUESTONE_LINES);
        this.createPillar(modelGenerator, BlockusBlocks.BLUESTONE_PILLAR);
        this.createPillar(modelGenerator, BlockusBlocks.CHISELED_BLUESTONE_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.BLUESTONE_PRESSURE_PLATE, BlockusBlocks.BLUESTONE_BUTTON, BlockusBlocks.BLUESTONE.block());
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_BLUESTONE);
        this.createAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_BLUESTONE_BRICKS, BlockusBlocks.POLISHED_BLUESTONE.block());


        // Viridite
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_VIRIDITE);
        this.createAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_VIRIDITE_BRICKS, BlockusBlocks.POLISHED_VIRIDITE.block());
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.VIRIDITE_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.VIRIDITE_PILLAR);
        this.createPillar(modelGenerator, BlockusBlocks.CHISELED_VIRIDITE_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.VIRIDITE_PRESSURE_PLATE, BlockusBlocks.VIRIDITE_BUTTON, BlockusBlocks.VIRIDITE.block());
        this.createLinesBlock(modelGenerator, BlockusBlocks.VIRIDITE_LINES);

        // Lava & Water Bricks
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_LAVA_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_LAVA_POLISHED_BLACKSTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_WATER_BRICKS);

        // Snow & Ice Bricks
        this.createPillar(modelGenerator, BlockusBlocks.SNOW_PILLAR);
        modelGenerator.family(BlockusBlocks.ICE_BRICKS).wall(BlockusBlocks.ICE_BRICK_WALL);
        this.createPillar(modelGenerator, BlockusBlocks.ICE_PILLAR);

        // Obsidian
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_OBSIDIAN_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.GLOWING_OBSIDIAN);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.OBSIDIAN_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.OBSIDIAN_PILLAR);
        modelGenerator.createOrientableTrapdoor(BlockusBlocks.OBSIDIAN_REINFORCED_TRAPDOOR);
        modelGenerator.createDoor(BlockusBlocks.OBSIDIAN_REINFORCED_DOOR);
        this.createPressurePlate(modelGenerator, BlockusBlocks.OBSIDIAN_PRESSURE_PLATE, TextureMapping.getBlockTexture(Blocks.OBSIDIAN));


        // Netherrack
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.NETHERRACK_CIRCULAR_PAVING);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE, BlockusBlocks.POLISHED_NETHERRACK_BUTTON, BlockusBlocks.POLISHED_NETHERRACK.block());

        // Quartz Blocks
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.QUARTZ_CIRCULAR_PAVING);

        // Magma Bricks
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_MAGMA_BRICKS);

        // Blaze Bricks
        this.createPillar(modelGenerator, BlockusBlocks.BLAZE_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.BLAZE_LANTERN);

        // Nether Bricks
        this.createPillar(modelGenerator, BlockusBlocks.NETHER_BRICK_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_NETHER_BRICKS);

        this.createPillar(modelGenerator, BlockusBlocks.RED_NETHER_BRICK_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_RED_NETHER_BRICKS);

        this.createPillar(modelGenerator, BlockusBlocks.CHARRED_NETHER_BRICK_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_CHARRED_NETHER_BRICKS);

        this.createPillar(modelGenerator, BlockusBlocks.TEAL_NETHER_BRICK_PILLAR);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_TEAL_NETHER_BRICKS);

        // Prismarine
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_DARK_PRISMARINE);
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_PRISMARINE);
        this.createPillar(modelGenerator, BlockusBlocks.DARK_PRISMARINE_PILLAR);
        this.createBlockWithStateRotations(modelGenerator, TexturedModel.GLAZED_TERRACOTTA, BlockusBlocks.PRISMARINE_CIRCULAR_PAVING);
        this.createPillar(modelGenerator, BlockusBlocks.PRISMARINE_PILLAR);

        // Bricks
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_SOAKED_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_CHARRED_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_SANDY_BRICKS);

        // Resin Bricks
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_RESIN_BRICKS);
        this.createPillar(modelGenerator, BlockusBlocks.RESIN_BRICK_PILLAR);

        // Sandstone
        this.createPillar(modelGenerator, BlockusBlocks.SANDSTONE_PILLAR);
        this.createCubeColumn(modelGenerator, BlockusBlocks.GOLD_DECORATED_SANDSTONE, Blocks.SANDSTONE);
        this.createCubeColumn(modelGenerator, BlockusBlocks.LAPIS_DECORATED_SANDSTONE, Blocks.SANDSTONE);

        this.createPillar(modelGenerator, BlockusBlocks.RED_SANDSTONE_PILLAR);
        this.createCubeColumn(modelGenerator, BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE, Blocks.RED_SANDSTONE);
        this.createCubeColumn(modelGenerator, BlockusBlocks.LAPIS_DECORATED_RED_SANDSTONE, Blocks.RED_SANDSTONE);

        // Soul Sandstone
        this.createCubeColumn(modelGenerator, BlockusBlocks.CHISELED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());
        this.createCubeColumn(modelGenerator, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());
        this.createSlabwithTop(modelGenerator, BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());
        this.createPillar(modelGenerator, BlockusBlocks.SOUL_SANDSTONE_PILLAR);
        this.createCubeColumn(modelGenerator, BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());
        this.createCubeColumn(modelGenerator, BlockusBlocks.LAPIS_DECORATED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block());

        // Rainbow
        modelGenerator.createFlowerBed(BlockusBlocks.RAINBOW_PETALS);
        this.createUpDefaultFacingBlock(modelGenerator, BlockusBlocks.RAINBOW_BLOCK);
        this.createTopBottomFacingBottom(modelGenerator, BlockusBlocks.RAINBOW_ASPHALT);
        modelGenerator.createPlantWithDefaultItem(BlockusBlocks.RAINBOW_ROSE, BlockusBlocks.POTTED_RAINBOW_ROSE, PlantType.NOT_TINTED);

        // Purpur Blocks
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_PURPUR);
        this.createCubeColumn(modelGenerator, BlockusBlocks.PURPUR_DECORATED_END_STONE, BlockusBlocks.PURPUR_DECORATED_END_STONE);
        this.createLinesBlock(modelGenerator, BlockusBlocks.PURPUR_LINES);

        // Phantom Purpur Blocks
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_PHANTOM_PURPUR);
        this.createCubeColumn(modelGenerator, BlockusBlocks.PHANTOM_PURPUR_DECORATED_END_STONE, BlockusBlocks.PURPUR_DECORATED_END_STONE);
        this.createLinesBlock(modelGenerator, BlockusBlocks.PHANTOM_PURPUR_LINES);
        this.createPillar(modelGenerator, BlockusBlocks.PHANTOM_PURPUR_PILLAR);

        // End Stone
        modelGenerator.createTrivialCube(BlockusBlocks.CHISELED_END_STONE_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.CRACKED_END_STONE_BRICKS);
        this.createPillar(modelGenerator, BlockusBlocks.END_STONE_PILLAR);
        this.createButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE, BlockusBlocks.POLISHED_END_STONE_BUTTON, BlockusBlocks.POLISHED_END_STONE.block());
        modelGenerator.createTrivialCube(BlockusBlocks.HERRINGBONE_END_STONE_BRICKS);

        // White Oak Wood
        modelGenerator.woodProvider(BlockusBlocks.WHITE_OAK_LOG).logWithHorizontal(BlockusBlocks.WHITE_OAK_LOG).wood(BlockusBlocks.WHITE_OAK_WOOD);
        modelGenerator.createTrivialBlock(BlockusBlocks.WHITE_OAK_LEAVES, TexturedModel.LEAVES);
        modelGenerator.woodProvider(BlockusBlocks.STRIPPED_WHITE_OAK_LOG).logWithHorizontal(BlockusBlocks.STRIPPED_WHITE_OAK_LOG).wood(BlockusBlocks.STRIPPED_WHITE_OAK_WOOD);
        modelGenerator.createPlantWithDefaultItem(BlockusBlocks.WHITE_OAK_SAPLING, BlockusBlocks.POTTED_WHITE_OAK_SAPLING, PlantType.NOT_TINTED);

        // Hanging Signs
        createHangingSign(modelGenerator, BlockusBlocks.WHITE_OAK_LOG, BlockusBlocks.WHITE_OAK.ceilingHangingSign(), BlockusBlocks.WHITE_OAK.wallHangingSign());
        createHangingSign(modelGenerator, BlockusBlocks.RAW_BAMBOO.planks(), BlockusBlocks.RAW_BAMBOO.ceilingHangingSign(), BlockusBlocks.RAW_BAMBOO.wallHangingSign());
        createHangingSign(modelGenerator, BlockusBlocks.CHARRED.planks(), BlockusBlocks.CHARRED.ceilingHangingSign(), BlockusBlocks.CHARRED.wallHangingSign());

        // Herringbone Planks
        for (Block block : BlockusBlocks.HERRINGBONE_PLANKS.bundle().values()) {
            modelGenerator.createTrivialCube(block);
        }

        // Small Logs
        for (Block block : BlockusBlocks.SMALL_LOGS.bundle().values()) {
            this.createAxisRotatedCubeColumn(modelGenerator, block);
        }

        // Posts
        for (var entry : BlockusBlocks.WOODEN_POST.woodMap().entrySet()) {
            this.createPost(modelGenerator, entry.getValue().block(), WoodMaps.LOG_MAP.get(entry.getKey().getId()));
            this.createPost(modelGenerator, entry.getValue().stripped(), WoodMaps.STRIPPED_LOG_MAP.get(entry.getKey().getId()));
        }

        // Timber Frames, Lattices & Wooden Grates
        for (var entry : BlockusBlocks.TIMBER_FRAME.woodMap().entrySet()) {
            modelGenerator.createTrivialCube(entry.getValue().block());
            modelGenerator.createTrivialCube(entry.getValue().cross());
            this.createDiagonalTimberFrame(modelGenerator, entry.getValue().diagonal());
            modelGenerator.createGlassBlocks(entry.getValue().grate(), entry.getValue().lattice());
        }

        // Hedges
        this.createHedge(modelGenerator, BlockusBlocks.OAK_HEDGE, Blocks.OAK_LEAVES, -12012264);
        this.createHedge(modelGenerator, BlockusBlocks.SPRUCE_HEDGE, Blocks.SPRUCE_LEAVES, -10380959);
        this.createHedge(modelGenerator, BlockusBlocks.BIRCH_HEDGE, Blocks.BIRCH_LEAVES, -8345771);
        this.createHedge(modelGenerator, BlockusBlocks.JUNGLE_HEDGE, Blocks.JUNGLE_LEAVES, -12012264);
        this.createHedge(modelGenerator, BlockusBlocks.ACACIA_HEDGE, Blocks.ACACIA_LEAVES, -12012264);
        this.createHedge(modelGenerator, BlockusBlocks.DARK_OAK_HEDGE, Blocks.DARK_OAK_LEAVES, -12012264);
        this.createHedge(modelGenerator, BlockusBlocks.MANGROVE_HEDGE, Blocks.MANGROVE_LEAVES, -7158200);
        this.createHedge(modelGenerator, BlockusBlocks.CHERRY_HEDGE, Blocks.CHERRY_LEAVES);
        this.createHedge(modelGenerator, BlockusBlocks.PALE_OAK_HEDGE, Blocks.PALE_OAK_LEAVES);
        this.createHedge(modelGenerator, BlockusBlocks.WARPED_HEDGE, Blocks.WARPED_WART_BLOCK);
        this.createHedge(modelGenerator, BlockusBlocks.CRIMSON_HEDGE, Blocks.NETHER_WART_BLOCK);
        this.createHedge(modelGenerator, BlockusBlocks.WHITE_OAK_HEDGE, BlockusBlocks.WHITE_OAK_LEAVES);
        this.createHedge(modelGenerator, BlockusBlocks.AZALEA_HEDGE, Blocks.AZALEA_LEAVES);
        this.createHedge(modelGenerator, BlockusBlocks.FLOWERING_AZALEA_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES);
        this.createHedge(modelGenerator, BlockusBlocks.MOSS_HEDGE, Blocks.MOSS_BLOCK);
        this.createHedge(modelGenerator, BlockusBlocks.PALE_MOSS_HEDGE, Blocks.PALE_MOSS_BLOCK);

        // Food Blocks
        this.createFishCrate(modelGenerator, BlockusBlocks.COD_CRATE);
        this.createFishCrate(modelGenerator, BlockusBlocks.PUFFERFISH_CRATE);
        this.createFishCrate(modelGenerator, BlockusBlocks.SALMON_CRATE);
        this.createFishCrate(modelGenerator, BlockusBlocks.TROPICAL_FISH_CRATE);
        this.createCrate(modelGenerator, BlockusBlocks.SWEET_BERRIES_CRATE);
        this.createCrate(modelGenerator, BlockusBlocks.GLOW_BERRIES_CRATE);
        this.createCrate(modelGenerator, BlockusBlocks.POTATO_CRATE);
        this.createCrate(modelGenerator, BlockusBlocks.APPLE_CRATE);
        this.createCrate(modelGenerator, BlockusBlocks.GOLDEN_APPLE_CRATE);
        this.createCrate(modelGenerator, BlockusBlocks.BEETROOT_CRATE);
        this.createCrate(modelGenerator, BlockusBlocks.CARROT_CRATE);
        this.createCrate(modelGenerator, BlockusBlocks.GOLDEN_CARROT_CRATE);
        this.createBreadBox(modelGenerator, BlockusBlocks.BREAD_BOX);
        this.createAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHORUS_BLOCK);
        this.createCookieBlock(modelGenerator);
        this.createDirectionalCarpet(modelGenerator, BlockusBlocks.CHOCOLATE_SQUARES.block(), BlockusBlocks.CHOCOLATE_TABLET);

        // Redstone Lamps
        this.createLitRedstoneLamp(modelGenerator, Blocks.REDSTONE_LAMP, BlockusBlocks.LIT_REDSTONE_LAMP);
        this.createRedstoneLamp(modelGenerator, BlockusBlocks.RAINBOW_LAMP, BlockusBlocks.LIT_RAINBOW_LAMP);
        ColorCollection.zipApply(BlockusBlocks.DYED_REDSTONE_LAMP.blocks(), BlockusBlocks.DYED_LIT_REDSTONE_LAMP.blocks(), (block, lit) -> this.createRedstoneLamp(modelGenerator, block, lit));

        // Neon Blocks
        BlockusBlocks.NEON.blocks().forEach((block) -> this.createNeonBlock(modelGenerator, block));
        this.createNeonBlock(modelGenerator, BlockusBlocks.RAINBOW_NEON);

        // Futurneo Blocks
        BlockusBlocks.FUTURNEO_BLOCK.blocks().forEach(modelGenerator::createTrivialCube);
        modelGenerator.createTrivialCube(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK);

        // Glass - Beveled Glass
        this.createBeveledGlassPane(modelGenerator, BlockusBlocks.RAINBOW_BEVELED_GLASS, BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE);
        modelGenerator.createGlassBlocks(BlockusBlocks.RAINBOW_GLASS, BlockusBlocks.RAINBOW_GLASS_PANE);
        modelGenerator.createGlassBlocks(BlockusBlocks.BEVELED_GLASS, BlockusBlocks.BEVELED_GLASS_PANE);
        ColorCollection.zipApply(BlockusBlocks.STAINED_BEVELED_GLASS.blocks(), BlockusBlocks.STAINED_BEVELED_GLASS_PANE.blocks(), (block, pane) -> this.createBeveledGlassPane(modelGenerator, block, pane));
        modelGenerator.createTrivialCube(BlockusBlocks.TINTED_BEVELED_GLASS);

        // Glazed Terracotta Pillars
        BlockusBlocks.GLAZED_TERRACOTTA_PILLAR.blocks().forEach((block) -> this.createPillar(modelGenerator, block));

        // Paper
        modelGenerator.createTrivialCube(BlockusBlocks.BURNT_PAPER_BLOCK);
        modelGenerator.createGlassBlocks(BlockusBlocks.FRAMED_PAPER_BLOCK, BlockusBlocks.PAPER_WALL);
        modelGenerator.createTrivialCube(BlockusBlocks.PAPER_BLOCK);
        modelGenerator.createOrientableTrapdoor(BlockusBlocks.PAPER_TRAPDOOR);
        modelGenerator.createDoor(BlockusBlocks.PAPER_DOOR);
        modelGenerator.createNonTemplateModelBlock(BlockusBlocks.PAPER_LAMP);

        // Lantern Blocks
        this.createCubeColumn(modelGenerator, BlockusBlocks.LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        modelGenerator.createLantern(BlockusBlocks.AMETHYST_LANTERN);
        this.createCubeColumn(modelGenerator, BlockusBlocks.AMETHYST_LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        modelGenerator.createLantern(BlockusBlocks.REDSTONE_LANTERN);
        this.createCubeColumn(modelGenerator, BlockusBlocks.REDSTONE_LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        this.createCubeColumn(modelGenerator, BlockusBlocks.SOUL_LANTERN_BLOCK, BlockusBlocks.LANTERN_BLOCK);
        BlockusBlocks.COPPER_LANTERN_BLOCK.blocks().zipUnwaxedWaxed((unwaxed, waxed) -> this.createCopperCubeColumn(modelGenerator, unwaxed, waxed));
        this.createPumpkins(modelGenerator, BlockusBlocks.SOUL_O_LANTERN);
        this.createPumpkins(modelGenerator, BlockusBlocks.COPPER_JACK_O_LANTERN);
        this.createPumpkins(modelGenerator, BlockusBlocks.REDSTONE_O_LANTERN);

        // Legacy
        this.createLegacyStonecutter(modelGenerator, BlockusBlocks.LEGACY_STONECUTTER);
        modelGenerator.createTrivialBlock(BlockusBlocks.LEGACY_LEAVES, TexturedModel.LEAVES);
        modelGenerator.createPlantWithDefaultItem(BlockusBlocks.LEGACY_SAPLING, BlockusBlocks.POTTED_LEGACY_SAPLING, PlantType.NOT_TINTED);
        this.createAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.LEGACY_LOG);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_NETHER_REACTOR_CORE);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_PLANKS);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_BRICKS);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_COBBLESTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_FIRST_COBBLESTONE);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_MOSSY_COBBLESTONE);
        this.createCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_GRASS_BLOCK, Blocks.DIRT);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_FIRST_GRASS_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_GRAVEL);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_COAL_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_LAPIS_BLOCK);
        this.createCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_IRON_BLOCK);
        this.createCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_GOLD_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_EXPLOSION_PROOF_GOLD_BLOCK);
        this.createCubeBottomTop(modelGenerator, BlockusBlocks.LEGACY_DIAMOND_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_SPONGE);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_CRYING_OBSIDIAN);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_GLOWING_OBSIDIAN);
        modelGenerator.createTrivialCube(BlockusBlocks.LEGACY_GLOWSTONE);
        modelGenerator.createPlantWithDefaultItem(BlockusBlocks.LEGACY_ROSE, BlockusBlocks.POTTED_LEGACY_ROSE, PlantType.NOT_TINTED);
        modelGenerator.createPlantWithDefaultItem(BlockusBlocks.LEGACY_BLUE_ROSE, BlockusBlocks.POTTED_LEGACY_BLUE_ROSE, PlantType.NOT_TINTED);

        // Colored Tiles
        BlockusBlocks.COLORED_TILES.blocks().forEach((block) -> this.createColoredTilesSimple(modelGenerator, block));
        modelGenerator.createTrivialCube(BlockusBlocks.RAINBOW_COLORED_TILES);

        // Other
        this.createStairsAndSlab(modelGenerator, BlockusBlocks.NETHERITE_STAIRS, BlockusBlocks.NETHERITE_SLAB, Blocks.NETHERITE_BLOCK);
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
        this.createNeonBlock(modelGenerator, BlockusBlocks.STARS_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.SUGAR_BLOCK);
        modelGenerator.createTrivialCube(BlockusBlocks.WEIGHT_STORAGE_CUBE);
        modelGenerator.registerSimpleFlatItemModel(BlockusBlocks.GOLDEN_CHAIN.asItem());
        modelGenerator.createAxisAlignedPillarBlockCustomModel(BlockusBlocks.GOLDEN_CHAIN, plainVariant(TexturedModel.CHAIN.create(BlockusBlocks.GOLDEN_CHAIN, modelGenerator.modelOutput)));
        modelGenerator.createBarsAndItem(BlockusBlocks.GOLDEN_BARS);
        modelGenerator.registerSimpleFlatItemModel(BlockusBlocks.WOODEN_FRAME);
        this.createGate(modelGenerator, BlockusBlocks.IRON_GATE);
        this.createGate(modelGenerator, BlockusBlocks.GOLDEN_GATE);
        BlockusBlocks.COPPER_GATE.blocks().zipUnwaxedWaxed((unwaxed, waxed) -> this.createCopperGate(modelGenerator, unwaxed, waxed));
        this.createBarrier(modelGenerator, BlockusBlocks.CAUTION_BARRIER);
        this.createBarrier(modelGenerator, BlockusBlocks.ROAD_BARRIER);
        modelGenerator.registerSimpleItemModel(BlockusBlocks.PATH, ModelLocationUtils.getModelLocation(BlockusBlocks.PATH, "4"));
    }

    @Override
    public void generateItemModels(ItemModelGenerators modelGenerator) {
        modelGenerator.generateFlatItem(BlockusItems.CHARRED_BOAT, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusItems.CHARRED_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusItems.RAW_BAMBOO_RAFT, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusItems.RAW_BAMBOO_CHEST_RAFT, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusItems.WHITE_OAK_BOAT, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(BlockusItems.WHITE_OAK_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
    }

    public final void createPillar(BlockModelGenerators modelGenerator, Block block) {
        modelGenerator.createRotatedPillarWithHorizontalVariant(block, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
    }

    public final void createLinesBlock(BlockModelGenerators modelGenerator, Block block) {
        modelGenerator.createAxisAlignedPillarBlock(block, TexturedModel.CUBE);
    }

    public final void createBlockStairsSlabAndWall(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab, Block wall) {
        modelGenerator.family(block).stairs(stairs).slab(slab).wall(wall);
    }

    public final void createBlockStairsAndSlab(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab) {
        modelGenerator.family(block).stairs(stairs).slab(slab);
    }

    public final void createButtonAndPressurePlate(BlockModelGenerators modelGenerator, Block pressurePlate, Block button, Block texture) {
        this.createButton(modelGenerator, button, TextureMapping.getBlockTexture(texture));
        this.createPressurePlate(modelGenerator, pressurePlate, TextureMapping.getBlockTexture(texture));
    }

    public final void createButtonAndPressurePlate(BlockModelGenerators modelGenerator, Block pressurePlate, Block button, Block texture, String suffix) {
        this.createButton(modelGenerator, button, TextureMapping.getBlockTexture(texture, suffix));
        this.createPressurePlate(modelGenerator, pressurePlate, TextureMapping.getBlockTexture(texture, suffix));
    }

    public final void createPost(BlockModelGenerators modelGenerator, Block block, Block texture) {
        TextureMapping mapping = TextureMapping.logColumn(texture);
        Identifier model = BlockusModels.POST.create(block, mapping, modelGenerator.modelOutput);
        MultiVariant postConnect = plainVariant(BlockusModels.POST_CONNECT.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant postConnectTop = plainVariant(BlockusModels.POST_CONNECT_TOP.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createPostBlockState(block, plainVariant(model), postConnect, postConnectTop, plainVariant(Blockus.id("block/chain_connect")), plainVariant(Blockus.id("block/chain_connect_top"))));
        modelGenerator.registerSimpleItemModel(block, model);
    }

    public static BlockModelDefinitionGenerator createPostBlockState(Block postBlock, MultiVariant postModel, MultiVariant sideModel, MultiVariant topModel, MultiVariant chainModel, MultiVariant topChainModel) {
        return MultiPartGenerator.multiPart(postBlock)
            .with(condition().term(BlockStateProperties.AXIS, Direction.Axis.X), postModel.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(BlockStateProperties.AXIS, Direction.Axis.Y), postModel)
            .with(condition().term(BlockStateProperties.AXIS, Direction.Axis.Z), postModel.with(X_ROT_90))
            .with(condition().term(PostBlock.NORTH, PostBlock.ConnectionType.POST), topModel.with(X_ROT_90))
            .with(condition().term(PostBlock.SOUTH, PostBlock.ConnectionType.POST), sideModel.with(X_ROT_90))
            .with(condition().term(PostBlock.EAST, PostBlock.ConnectionType.POST), topModel.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(PostBlock.WEST, PostBlock.ConnectionType.POST), sideModel.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(PostBlock.UP, PostBlock.ConnectionType.POST), topModel)
            .with(condition().term(PostBlock.DOWN, PostBlock.ConnectionType.POST), sideModel)
            .with(condition().term(PostBlock.NORTH, PostBlock.ConnectionType.CHAIN), topChainModel.with(X_ROT_90))
            .with(condition().term(PostBlock.SOUTH, PostBlock.ConnectionType.CHAIN), chainModel.with(X_ROT_90))
            .with(condition().term(PostBlock.EAST, PostBlock.ConnectionType.CHAIN), topChainModel.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(PostBlock.WEST, PostBlock.ConnectionType.CHAIN), chainModel.with(X_ROT_90).with(Y_ROT_90))
            .with(condition().term(PostBlock.UP, PostBlock.ConnectionType.CHAIN), topChainModel)
            .with(condition().term(PostBlock.DOWN, PostBlock.ConnectionType.CHAIN), chainModel);
    }

    public final void createCookieBlock(BlockModelGenerators modelGenerator) {
        Block block = BlockusBlocks.COOKIE_BLOCK;
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
        modelGenerator.registerSimpleItemModel(block, TexturedModel.CUBE.create(block, modelGenerator.modelOutput));
    }

    public final void createAmethystLamp(BlockModelGenerators modelGenerator) {
        Block block = BlockusBlocks.AMETHYST_LAMP;
        MultiVariant low = plainVariant(modelGenerator.createSuffixedVariant(block, "_low", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        MultiVariant medium = plainVariant(modelGenerator.createSuffixedVariant(block, "_medium", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        MultiVariant high = plainVariant(modelGenerator.createSuffixedVariant(block, "_high", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.POWER)
            .select(0, plainVariant(ModelLocationUtils.getModelLocation(block)))
            .select(1, low).select(2, low).select(3, low).select(4, low).select(5, low)
            .select(6, medium).select(7, medium).select(8, medium).select(9, medium).select(10, medium)
            .select(11, high).select(12, high).select(13, high).select(14, high).select(15, high)));
        modelGenerator.registerSimpleItemModel(block, TexturedModel.CUBE.create(block, modelGenerator.modelOutput));
    }

    public final void createHedge(BlockModelGenerators modelGenerator, Block block, Block texture) {
        createHedge(modelGenerator, block, texture, false, 0);
    }

    public final void createHedge(BlockModelGenerators modelGenerator, Block block, Block texture, int tintColor) {
        createHedge(modelGenerator, block, texture, true, tintColor);
    }

    public final void createHedge(BlockModelGenerators modelGenerator, Block block, Block texture, boolean isTinted, int tintColor) {
        TextureMapping mapping = TextureMapping.singleSlot(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(texture));
        MultiVariant post = plainVariant(BlockusModels.HEDGE_POST.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant side = plainVariant(BlockusModels.HEDGE_SIDE.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant sideAlt = plainVariant(BlockusModels.HEDGE_SIDE_ALT.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant noSide = plainVariant(BlockusModels.HEDGE_NOSIDE.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant noSideAlt = plainVariant(BlockusModels.HEDGE_NOSIDE_ALT.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(block).with(post).with(condition().term(BlockStateProperties.NORTH, true), side.with(UV_LOCK)).with(condition().term(BlockStateProperties.EAST, true), side.with(Y_ROT_90).with(UV_LOCK)).with(condition().term(BlockStateProperties.SOUTH, true), sideAlt.with(UV_LOCK)).with(condition().term(BlockStateProperties.WEST, true), sideAlt.with(Y_ROT_90).with(UV_LOCK)).with(condition().term(BlockStateProperties.NORTH, false), noSide.with(UV_LOCK)).with(condition().term(BlockStateProperties.EAST, false), noSideAlt.with(UV_LOCK)).with(condition().term(BlockStateProperties.SOUTH, false), noSideAlt.with(Y_ROT_90).with(UV_LOCK)).with(condition().term(BlockStateProperties.WEST, false), noSide.with(Y_ROT_270).with(UV_LOCK)));
        Identifier inventory = BlockusModels.HEDGE_INVENTORY.create(block, mapping, modelGenerator.modelOutput);
        if (isTinted) {
            modelGenerator.registerSimpleTintedItemModel(block, inventory, ItemModelUtils.constantTint(tintColor));
        } else {
            modelGenerator.registerSimpleItemModel(block, inventory);
        }
    }

    public final void createBed(BlockModelGenerators modelGenerator, Block bed) {
        Identifier head = ModelTemplates.BED_HEAD.createWithSuffix(bed, "_" + BedPart.HEAD, TextureMapping.bed(bed, BedPart.HEAD), modelGenerator.modelOutput);
        Identifier foot = ModelTemplates.BED_FOOT.createWithSuffix(bed, "_" + BedPart.FOOT, TextureMapping.bed(bed, BedPart.FOOT), modelGenerator.modelOutput);
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createBed(bed, plainVariant(head), plainVariant(foot)));
        modelGenerator.itemModelOutput.accept(bed.asItem(), ItemModelUtils.composite(ItemModelUtils.plainModel(head), ItemModelUtils.plainModel(foot, new Transformation(new Vector3f(0.0F, 0.0F, 1.0F), null, null, null))));
    }

    public final void createCarpet(BlockModelGenerators modelGenerator, Block wool, Block carpet) {
        MultiVariant model = plainVariant(TexturedModel.CARPET.get(wool).create(carpet, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createSimpleBlock(carpet, model));
    }

    public final void createDirectionalCarpet(BlockModelGenerators modelGenerator, Block block, Block carpet) {
        TexturedModel.CARPET.get(block).create(carpet, modelGenerator.modelOutput);
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(carpet, plainVariant(ModelLocationUtils.getModelLocation(carpet))).with(createUpDefaultRotationStates()));
    }

    public final void createBlockStairsSlabWithBottom(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab, Block base) {
        Material texture = TextureMapping.getBlockTexture(base, "_bottom");
        TextureMapping blockMapping = TextureMapping.singleSlot(TextureSlot.ALL, texture);
        TextureMapping mapping = sideTopBottom(texture);
        this.createBlock(modelGenerator, block, blockMapping);
        this.createStairs(modelGenerator, stairs, mapping);
        this.createSlab(modelGenerator, slab, mapping, getBlockId(block));
    }

    public final void createBlockStairsSlabWithTop(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab, Block base) {
        Material texture = TextureMapping.getBlockTexture(base, "_top");
        TextureMapping blockMapping = TextureMapping.singleSlot(TextureSlot.ALL, texture);
        TextureMapping mapping = sideTopBottom(texture);
        this.createBlock(modelGenerator, block, blockMapping);
        this.createStairs(modelGenerator, stairs, mapping);
        this.createSlab(modelGenerator, slab, mapping, getBlockId(block));
    }

    public final void createBlockStairsSlabwithTopBottom(BlockModelGenerators modelGenerator, Block block, Block stairs, Block slab) {
        TextureMapping mapping = sideTopBottom(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(block, "_top"), TextureMapping.getBlockTexture(block, "_bottom"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_BOTTOM_TOP, mapping);
        this.createStairs(modelGenerator, stairs, mapping);
        this.createSlab(modelGenerator, slab, mapping, getBlockId(block));
    }

    public final void createStairs(BlockModelGenerators modelGenerator, Block block, Block texture) {
        TextureMapping mapping = sideTopBottom(TextureMapping.getBlockTexture(texture));
        this.createStairs(modelGenerator, block, mapping);
    }

    public final void createSlab(BlockModelGenerators modelGenerator, Block block, Block texture) {
        TextureMapping mapping = sideTopBottom(TextureMapping.getBlockTexture(texture));
        this.createSlab(modelGenerator, block, mapping, TextureMapping.getBlockTexture(texture).sprite());
    }

    public final void createStairsAndSlab(BlockModelGenerators modelGenerator, Block stairs, Block slab, Block block) {
        this.createStairs(modelGenerator, stairs, block);
        this.createSlab(modelGenerator, slab, block);
    }

    public final void createSlabwithTop(BlockModelGenerators modelGenerator, Block block, Block texture, Block end) {
        TextureMapping mapping = sideTopBottom(TextureMapping.getBlockTexture(texture), TextureMapping.getBlockTexture(end, "_top"));
        this.createSlab(modelGenerator, block, mapping, TextureMapping.getBlockTexture(texture).sprite());
    }

    public final void createWall(BlockModelGenerators modelGenerator, Block block, Block texture) {
        TextureMapping mapping = TextureMapping.singleSlot(TextureSlot.WALL, TextureMapping.getBlockTexture(texture));
        this.createWall(modelGenerator, block, mapping);
    }

    public final void createButton(BlockModelGenerators modelGenerator, Block block, Material texture) {
        TextureMapping mapping = TextureMapping.defaultTexture(texture);
        MultiVariant normal = plainVariant(ModelTemplates.BUTTON.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant pressed = plainVariant(ModelTemplates.BUTTON_PRESSED.create(block, mapping, modelGenerator.modelOutput));
        Identifier model = ModelTemplates.BUTTON_INVENTORY.create(block, mapping, modelGenerator.modelOutput);
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createButton(block, normal, pressed));
        modelGenerator.registerSimpleItemModel(block, model);
    }

    public final void createPressurePlate(BlockModelGenerators modelGenerator, Block block, Material texture) {
        TextureMapping mapping = TextureMapping.defaultTexture(texture);
        MultiVariant off = plainVariant(ModelTemplates.PRESSURE_PLATE_UP.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant on = plainVariant(ModelTemplates.PRESSURE_PLATE_DOWN.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createPressurePlate(block, off, on));
    }

    public final void createRedstoneLamp(BlockModelGenerators modelGenerator, Block block, Block lit) {
        createLitRedstoneLamp(modelGenerator, block, lit);
        MultiVariant off = plainVariant(TexturedModel.CUBE.create(block, modelGenerator.modelOutput));
        MultiVariant on = plainVariant(modelGenerator.createSuffixedVariant(block, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(createBooleanModelDispatch(BlockStateProperties.LIT, on, off)));
    }

    public final void createLitRedstoneLamp(BlockModelGenerators modelGenerator, Block block, Block lit) {
        TextureMapping mapping = TextureMapping.singleSlot(TextureSlot.ALL, TextureMapping.getBlockTexture(block, "_on"));
        this.createBlock(modelGenerator, lit, mapping);
    }

    public void createAxisRotatedCubeColumn(BlockModelGenerators modelGenerator, Block block, TextureMapping mapping) {
        MultiVariant model = plainVariant(ModelTemplates.CUBE_COLUMN.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant horizontalModel = plainVariant(ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createRotatedPillarWithHorizontalVariant(block, model, horizontalModel));
    }

    public final void createAxisRotatedCubeColumn(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = TextureMapping.logColumn(block);
        this.createAxisRotatedCubeColumn(modelGenerator, block, mapping);
    }

    public final void createAxisRotatedCubeColumn(BlockModelGenerators modelGenerator, Block block, Block end) {
        TextureMapping mapping = TextureMapping.column(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(end));
        this.createAxisRotatedCubeColumn(modelGenerator, block, mapping);
    }

    public final void createCubeColumn(BlockModelGenerators modelGenerator, Block block, Block end) {
        TextureMapping mapping = TextureMapping.column(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(end, "_top"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_COLUMN, mapping);
    }

    public final void createCopperCubeColumn(BlockModelGenerators modelGenerator, Block unwaxed, Block waxed) {
        TextureMapping mapping = TextureMapping.column(TextureMapping.getBlockTexture(unwaxed), TextureMapping.getBlockTexture(unwaxed, "_top"));
        this.createBlock(modelGenerator, unwaxed, ModelTemplates.CUBE_COLUMN, mapping);
        this.createBlock(modelGenerator, waxed, ModelTemplates.CUBE_COLUMN, mapping);
    }

    public final void createCubeColumnNoSuffix(BlockModelGenerators modelGenerator, Block block, Block end) {
        TextureMapping mapping = TextureMapping.column(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(end));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_COLUMN, mapping);
    }

    public final void createCubeBottomTop(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = sideTopBottom(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(block, "_top"), TextureMapping.getBlockTexture(block, "_bottom"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_BOTTOM_TOP, mapping);
    }

    public final void createCubeBottomTop(BlockModelGenerators modelGenerator, Block block, Block bottom) {
        TextureMapping mapping = sideTopBottom(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(block, "_top"), TextureMapping.getBlockTexture(bottom));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_BOTTOM_TOP, mapping);
    }

    public final void createUpDefaultFacingBlock(BlockModelGenerators modelGenerator, Block block) {
        MultiVariant model = plainVariant(TexturedModel.CUBE.create(block, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, model).with(createUpDefaultRotationStates()));
    }

    public final void createTopBottomFacingBottom(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = sideTopBottom(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(block, "_top"), TextureMapping.getBlockTexture(block, "_bottom"));
        MultiVariant model = plainVariant(ModelTemplates.CUBE_BOTTOM_TOP.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, model).with(createUpDefaultRotationStates()));
    }

    public final void createPumpkins(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = TextureMapping.column(Blocks.PUMPKIN);
        modelGenerator.createPumpkinVariant(block, mapping);
    }

    public final void createSturdyStone(BlockModelGenerators modelGenerator) {
        Material texture = TextureMapping.getBlockTexture(Blocks.FURNACE, "_top");
        this.createBlock(modelGenerator, BlockusBlocks.STURDY_STONE, TextureMapping.singleSlot(TextureSlot.ALL, texture));
    }

    public final void createSmoothStoneStairs(BlockModelGenerators modelGenerator) {
        TextureMapping mapping = sideTopBottom(TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE_SLAB, "_side"), TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE));
        this.createStairs(modelGenerator, BlockusBlocks.SMOOTH_STONE_STAIRS, mapping);
    }

    public final void createNeonBlock(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = TextureMapping.singleSlot(TextureSlot.ALL, TextureMapping.getBlockTexture(block));
        this.createBlock(modelGenerator, block, BlockusModels.NEON_BLOCK_TEMPLATE, mapping);
    }

    public final void createFishCrate(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = sideTopBottom(getBlockId("fish_crate_side"), TextureMapping.getBlockTexture(block), getBlockId("fish_crate_bottom"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE_BOTTOM_TOP, mapping);
    }

    public final void createCopperBlocks(BlockModelGenerators modelGenerator, CopperBSSWBundle block, WeatheringCopperCollection<BlockFamily> family) {
        WeatheringCopper.WeatherState.forEach((state) -> modelGenerator.family(block.block().blocks().weathering().pick(state)).generateFor(family.weathering().pick(state)).donateModelTo(block.block().blocks().weathering().pick(state), block.block().blocks().waxed().pick(state)).generateFor(family.waxed().pick(state)));
    }

    public final void createCrate(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = sideTop(TextureMapping.getBlockTexture(block, "_side"), TextureMapping.getBlockTexture(block));
        this.createBlock(modelGenerator, block, BlockusModels.CRATE_TEMPLATE, mapping);
    }

    public final void createBreadBox(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = frontTopSideBottom(block);
        MultiVariant model = plainVariant(ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, model).with(PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING).select(Direction.EAST, Y_ROT_90).select(Direction.SOUTH, Y_ROT_180).select(Direction.WEST, Y_ROT_270).select(Direction.NORTH, NOP)));
    }

    public void createLegacyStonecutter(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = (new TextureMapping()).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_front")).put(TextureSlot.DOWN, TextureMapping.getBlockTexture(block, "_bottom")).put(TextureSlot.UP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.NORTH, TextureMapping.getBlockTexture(block, "_front")).put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(block, "_front")).put(TextureSlot.EAST, TextureMapping.getBlockTexture(block, "_side")).put(TextureSlot.WEST, TextureMapping.getBlockTexture(block, "_side"));
        this.createBlock(modelGenerator, block, ModelTemplates.CUBE, mapping);
    }

    private void createDiagonalTimberFrame(BlockModelGenerators modelGenerator, Block block) {
        MultiVariant model = plainVariant(ModelLocationUtils.getModelLocation(block));
        Material right = TextureMapping.getBlockTexture(block, "_right");
        Material left = TextureMapping.getBlockTexture(block, "_left");
        TextureMapping mapping = (new TextureMapping()).put(TextureSlot.PARTICLE, right).put(TextureSlot.NORTH, right).put(TextureSlot.SOUTH, right).put(TextureSlot.EAST, right).put(TextureSlot.WEST, left).put(TextureSlot.DOWN, left).put(TextureSlot.UP, left);
        ModelTemplates.CUBE.create(block, mapping, modelGenerator.modelOutput);
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
            .select(Direction.NORTH, model)
            .select(Direction.SOUTH, model.with(Y_ROT_180))
            .select(Direction.WEST, model.with(Y_ROT_270))
            .select(Direction.EAST, model.with(Y_ROT_90))));
    }

    public final void createBeveledGlassPane(BlockModelGenerators modelGenerator, Block block, Block pane) {
        modelGenerator.createTrivialBlock(block, TexturedModel.CUBE.updateTexture(TextureMapping::forceAllTranslucent));
        TextureMapping paneMapping = TextureMapping.pane(block, BlockusBlocks.BEVELED_GLASS_PANE).forceAllTranslucent();
        MultiVariant post = plainVariant(ModelTemplates.STAINED_GLASS_PANE_POST.create(pane, paneMapping, modelGenerator.modelOutput));
        MultiVariant side = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE.create(pane, paneMapping, modelGenerator.modelOutput));
        MultiVariant sideAlt = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(pane, paneMapping, modelGenerator.modelOutput));
        MultiVariant noSide = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(pane, paneMapping, modelGenerator.modelOutput));
        MultiVariant noSideAlt = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(pane, paneMapping, modelGenerator.modelOutput));
        Item paneItem = pane.asItem();
        modelGenerator.registerSimpleItemModel(paneItem, modelGenerator.createFlatItemModelWithBlockTexture(paneItem, block));
        modelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(pane).with(post).with(condition().term(BlockStateProperties.NORTH, true), side).with(condition().term(BlockStateProperties.EAST, true), side.with(Y_ROT_90)).with(condition().term(BlockStateProperties.SOUTH, true), sideAlt).with(condition().term(BlockStateProperties.WEST, true), sideAlt.with(Y_ROT_90)).with(condition().term(BlockStateProperties.NORTH, false), noSide).with(condition().term(BlockStateProperties.EAST, false), noSideAlt).with(condition().term(BlockStateProperties.SOUTH, false), noSideAlt.with(Y_ROT_90)).with(condition().term(BlockStateProperties.WEST, false), noSide.with(Y_ROT_270)));
    }

    public static void createColoredTiles(BlockModelGenerators modelGenerator, Block block, Block tile1, Block tile2) {
        TextureMapping textures = tilesTextures(tile1, tile2);
        BlockusModels.CUBE_TILES.create(block, textures, modelGenerator.modelOutput);
        BlockusModels.CUBE_TILES_2.create(block, textures, modelGenerator.modelOutput);
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_AXIS)
            .select(Direction.Axis.X, plainVariant(ModelLocationUtils.getModelLocation(block)))
            .select(Direction.Axis.Z, plainVariant(ModelLocationUtils.getModelLocation(block, "_2")))));
    }

    public final void createColoredTilesSimple(BlockModelGenerators modelGenerator, Block block) {
        Material texture = getModifiedBlockId(block, "_colored", "");
        this.createBlock(modelGenerator, block, TextureMapping.singleSlot(TextureSlot.ALL, texture));
    }

    public final void createBlock(BlockModelGenerators modelGenerator, Block block, ModelTemplate model, TextureMapping mapping) {
        modelGenerator.blockStateOutput.accept(createSimpleBlock(block, plainVariant(model.create(block, mapping, modelGenerator.modelOutput))));
    }

    public final void createBlock(BlockModelGenerators modelGenerator, Block block, TextureMapping mapping) {
        modelGenerator.blockStateOutput.accept(createSimpleBlock(block, plainVariant(ModelTemplates.CUBE_ALL.create(block, mapping, modelGenerator.modelOutput))));
    }

    public final void createHangingSign(BlockModelGenerators modelGenerator, Block particleBlock, Block hangingSign, Block wallVariant) {
        TextureMapping mapping = (new TextureMapping()).put(TextureSlot.ALL, TextureMapping.getBlockTexture(hangingSign)).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(particleBlock));
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createHangingSign(hangingSign, BlockModelGenerators.plainVariant(ModelTemplates.HANGING_SIGN_ROT_0.create(ModelLocationUtils.getModelLocation(hangingSign, "_rot_0"), mapping, modelGenerator.modelOutput)), BlockModelGenerators.plainVariant(ModelTemplates.HANGING_SIGN_ROT_1.create(ModelLocationUtils.getModelLocation(hangingSign, "_rot_1"), mapping, modelGenerator.modelOutput)), BlockModelGenerators.plainVariant(ModelTemplates.HANGING_SIGN_ROT_2.create(ModelLocationUtils.getModelLocation(hangingSign, "_rot_2"), mapping, modelGenerator.modelOutput)), BlockModelGenerators.plainVariant(ModelTemplates.HANGING_SIGN_ROT_3.create(ModelLocationUtils.getModelLocation(hangingSign, "_rot_3"), mapping, modelGenerator.modelOutput)), BlockModelGenerators.plainVariant(ModelTemplates.ATTACHED_HANGING_SIGN_ROT_0.create(ModelLocationUtils.getModelLocation(hangingSign, "_attached_rot_0"), mapping, modelGenerator.modelOutput)), BlockModelGenerators.plainVariant(ModelTemplates.ATTACHED_HANGING_SIGN_ROT_1.create(ModelLocationUtils.getModelLocation(hangingSign, "_attached_rot_1"), mapping, modelGenerator.modelOutput)), BlockModelGenerators.plainVariant(ModelTemplates.ATTACHED_HANGING_SIGN_ROT_2.create(ModelLocationUtils.getModelLocation(hangingSign, "_attached_rot_2"), mapping, modelGenerator.modelOutput)), BlockModelGenerators.plainVariant(ModelTemplates.ATTACHED_HANGING_SIGN_ROT_3.create(ModelLocationUtils.getModelLocation(hangingSign, "_attached_rot_3"), mapping, modelGenerator.modelOutput))));
        MultiVariant wallModel = BlockModelGenerators.plainVariant(ModelTemplates.WALL_HANGING_SIGN.create(wallVariant, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(wallVariant, wallModel).with(PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING).select(Direction.SOUTH, NOP).select(Direction.WEST, Y_ROT_90).select(Direction.NORTH, Y_ROT_180).select(Direction.EAST, Y_ROT_270)));
        modelGenerator.registerSimpleFlatItemModel(hangingSign.asItem());
    }

    public final void createStairs(BlockModelGenerators modelGenerator, Block block, TextureMapping mapping) {
        MultiVariant inner = plainVariant(ModelTemplates.STAIRS_INNER.create(block, mapping, modelGenerator.modelOutput));
        Identifier straight = ModelTemplates.STAIRS_STRAIGHT.create(block, mapping, modelGenerator.modelOutput);
        MultiVariant outer = plainVariant(ModelTemplates.STAIRS_OUTER.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createStairs(block, inner, plainVariant(straight), outer));
        modelGenerator.registerSimpleItemModel(block, straight);
    }

    public final void createSlab(BlockModelGenerators modelGenerator, Block block, TextureMapping mapping, Identifier doubleSlab) {
        Identifier bottom = ModelTemplates.SLAB_BOTTOM.create(block, mapping, modelGenerator.modelOutput);
        MultiVariant top = plainVariant(ModelTemplates.SLAB_TOP.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createSlab(block, BlockModelGenerators.plainVariant(bottom), top, BlockModelGenerators.plainVariant(doubleSlab)));
        modelGenerator.registerSimpleItemModel(block, bottom);
    }

    public static BlockModelDefinitionGenerator createBarrier(Block block, MultiVariant post, MultiVariant side) {
        return MultiPartGenerator.multiPart(block).with(condition().term(BlockStateProperties.UP, true), post).with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.LOW), side).with(condition().term(BlockStateProperties.EAST_WALL, WallSide.LOW), side.with(Y_ROT_90)).with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.LOW), side.with(Y_ROT_180)).with(condition().term(BlockStateProperties.WEST_WALL, WallSide.LOW), side.with(Y_ROT_270)).with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.TALL), side).with(condition().term(BlockStateProperties.EAST_WALL, WallSide.TALL), side.with(Y_ROT_90)).with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.TALL), side.with(Y_ROT_180)).with(condition().term(BlockStateProperties.WEST_WALL, WallSide.TALL), side.with(Y_ROT_270));
    }

    public final void createBarrier(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = TextureMapping.singleSlot(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block));
        MultiVariant post = plainVariant(BlockusModels.BARRIER_POST.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant side = plainVariant(BlockusModels.BARRIER_SIDE.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(createBarrier(block, post, side));
        Identifier inventory = BlockusModels.BARRIER_INVENTORY.create(block, mapping, modelGenerator.modelOutput);
        modelGenerator.registerSimpleItemModel(block, inventory);
    }

    public final void createWall(BlockModelGenerators modelGenerator, Block block, TextureMapping mapping) {
        MultiVariant post = plainVariant(ModelTemplates.WALL_POST.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant lowSide = plainVariant(ModelTemplates.WALL_LOW_SIDE.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant tallSide = plainVariant(ModelTemplates.WALL_TALL_SIDE.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createWall(block, post, lowSide, tallSide));
        Identifier inventory = ModelTemplates.WALL_INVENTORY.create(block, mapping, modelGenerator.modelOutput);
        modelGenerator.registerSimpleItemModel(block, inventory);
    }

    public void createGate(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = TextureMapping.door(block);
        MultiVariant bottom = plainVariant(BlockusModels.GATE_BOTTOM.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant bottomHinge = plainVariant(BlockusModels.GATE_BOTTOM_HINGE.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant top = plainVariant(BlockusModels.GATE_TOP.create(block, mapping, modelGenerator.modelOutput));
        MultiVariant topHinge = plainVariant(BlockusModels.GATE_TOP_HINGE.create(block, mapping, modelGenerator.modelOutput));
        modelGenerator.registerSimpleFlatItemModel(block.asItem());
        modelGenerator.blockStateOutput.accept(createDoor(block, bottom, bottomHinge, bottomHinge, bottom, top, topHinge, topHinge, top));
    }

    public void createCopperGate(BlockModelGenerators modelGenerator, Block unwaxed, Block waxed) {
        TextureMapping mapping = TextureMapping.door(unwaxed);
        MultiVariant bottom = plainVariant(BlockusModels.GATE_BOTTOM.create(unwaxed, mapping, modelGenerator.modelOutput));
        MultiVariant bottomHinge = plainVariant(BlockusModels.GATE_BOTTOM_HINGE.create(unwaxed, mapping, modelGenerator.modelOutput));
        MultiVariant top = plainVariant(BlockusModels.GATE_TOP.create(unwaxed, mapping, modelGenerator.modelOutput));
        MultiVariant topHinge = plainVariant(BlockusModels.GATE_TOP_HINGE.create(unwaxed, mapping, modelGenerator.modelOutput));
        Identifier itemModel = modelGenerator.createFlatItemModel(unwaxed.asItem());
        modelGenerator.registerSimpleItemModel(unwaxed.asItem(), itemModel);
        modelGenerator.registerSimpleItemModel(waxed.asItem(), itemModel);
        modelGenerator.blockStateOutput.accept(createDoor(unwaxed, bottom, bottomHinge, bottomHinge, bottom, top, topHinge, topHinge, top));
        modelGenerator.blockStateOutput.accept(createDoor(waxed, bottom, bottomHinge, bottomHinge, bottom, top, topHinge, topHinge, top));
    }

    public final void createTreePot(BlockModelGenerators modelGenerator, Block block, Block leaves, Block log, Block soil) {
        TextureMapping mapping = treePot(leaves, log, TextureMapping.getBlockTexture(log, "_top"), TextureMapping.getBlockTexture(soil));
        this.createBlock(modelGenerator, block, BlockusModels.TREE_POT, mapping);
    }

    public final void createTreePot(BlockModelGenerators modelGenerator, Block block, Block leaves, Block log) {
        createTreePot(modelGenerator, block, leaves, log, Blocks.DIRT);
    }

    public final void createTreePot(BlockModelGenerators modelGenerator, Block block, Block leaves, Block log, String soil) {
        TextureMapping mapping = treePot(leaves, log, TextureMapping.getBlockTexture(log, "_top"), getBlockId(soil));
        this.createBlock(modelGenerator, block, BlockusModels.TREE_POT, mapping);
    }

    public final void createHugeRedMushroomPot(BlockModelGenerators modelGenerator, Block block) {
        TextureMapping mapping = treePot(Blocks.RED_MUSHROOM_BLOCK, Blocks.MUSHROOM_STEM, TextureMapping.getBlockTexture(Blocks.MUSHROOM_STEM), getBlockId(Identifier.withDefaultNamespace("mycelium_top")));
        this.createBlock(modelGenerator, block, BlockusModels.TREE_POT, mapping);
    }

    public final void createLargeFlowerPot(BlockModelGenerators modelGenerator, Block block, Material top, Material bottom) {
        TextureMapping mapping = topBottom(top, bottom).put(BlockusTextureSlot.SOIL, TextureMapping.getBlockTexture(Blocks.DIRT));
        this.createBlock(modelGenerator, block, BlockusModels.LARGE_FLOWER_POT_DOUBLE_CROSS, mapping);
    }

    public final void createLargeFlowerPot(BlockModelGenerators modelGenerator, Block block, Block flower) {
        createLargeFlowerPot(modelGenerator, block, TextureMapping.getBlockTexture(flower, "_top"), TextureMapping.getBlockTexture(flower, "_bottom"));
    }

    public final void createPottedPitcherPlant(BlockModelGenerators modelGenerator, Block block) {
        createLargeFlowerPot(modelGenerator, block, TextureMapping.getBlockTexture(Blocks.PITCHER_CROP, "_top_stage_4"), TextureMapping.getBlockTexture(Blocks.PITCHER_CROP, "_bottom_stage_4"));
    }

    public final void createPottedAzaleaLarge(BlockModelGenerators modelGenerator, Block block, Block azalea) {
        TextureMapping mapping = TextureMapping.cubeTop(azalea);
        this.createBlock(modelGenerator, block, BlockusModels.POTTED_AZALEA_LARGE, mapping);
    }

    public final void createBlockWithStateRotations(BlockModelGenerators modelGenerator, TexturedModel.Provider modelProvider, Block block) {
        MultiVariant model = plainVariant(modelProvider.create(block, modelGenerator.modelOutput));
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, model).with(PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING).select(Direction.SOUTH, NOP).select(Direction.WEST, Y_ROT_90).select(Direction.NORTH, Y_ROT_180).select(Direction.EAST, Y_ROT_270)));
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

    public static Material getTilesId(Block block) {
        return getModifiedBlockId(block, "_concrete", "_tiles");
    }

    public static Material getBlockId(Identifier id) {
        return new Material(id.withPath((path) -> "block/" + path));
    }

    public static Material getBlockId(String name) {
        return getBlockId(Blockus.id(name));
    }

    public static Identifier getBlockId(Block block) {
        return Blockus.id("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath());
    }

    public static Material getModifiedBlockId(Block block, String target, String replacement) {
        Identifier id = Blockus.id(BuiltInRegistries.BLOCK.getKey(block).getPath().replace(target, replacement));
        return new Material(id.withPrefix("block/"));
    }

// TextureMaps

    public static TextureMapping tilesTextures(Block tile1, Block tile2) {
        return (new TextureMapping()).put(BlockusTextureSlot.TILE_1, getTilesId(tile1)).put(BlockusTextureSlot.TILE_2, getTilesId(tile2));
    }

    public static TextureMapping sideTop(Material block, Material top) {
        return (new TextureMapping()).put(TextureSlot.SIDE, block).put(TextureSlot.TOP, top);
    }

    public static TextureMapping topBottom(Material top, Material bottom) {
        return (new TextureMapping()).put(TextureSlot.TOP, top).put(TextureSlot.BOTTOM, bottom);
    }

    public static TextureMapping sideTopBottom(Material block, Material top, Material bottom) {
        return (new TextureMapping()).put(TextureSlot.SIDE, block).put(TextureSlot.TOP, top).put(TextureSlot.BOTTOM, bottom);
    }

    public static TextureMapping sideTopBottom(Material block, Material end) {
        return (new TextureMapping()).put(TextureSlot.SIDE, block).put(TextureSlot.TOP, end).put(TextureSlot.BOTTOM, end);
    }

    public static TextureMapping sideTopBottom(Material block) {
        return (new TextureMapping()).put(TextureSlot.SIDE, block).put(TextureSlot.TOP, block).put(TextureSlot.BOTTOM, block);
    }

    public static TextureMapping frontTopSideBottom(Block block) {
        return (new TextureMapping()).put(TextureSlot.FRONT, TextureMapping.getBlockTexture(block)).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side")).put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_side"));
    }

    public static TextureMapping treePot(Block leaves, Block log, Material logTop, Material soil) {
        return (new TextureMapping()).put(BlockusTextureSlot.LEAVES, TextureMapping.getBlockTexture(leaves)).put(BlockusTextureSlot.LOG, TextureMapping.getBlockTexture(log)).put(BlockusTextureSlot.LOG_TOP, logTop).put(BlockusTextureSlot.SOIL, soil);
    }
}
