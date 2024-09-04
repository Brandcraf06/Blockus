package com.brand.blockus.datagen.providers;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.PostBlock;
import com.brand.blockus.datagen.family.BlockusFamilies;
import com.brand.blockus.datagen.models.BlockusModels;
import com.brand.blockus.datagen.models.BlockusTextureKey;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.data.client.VariantSettings.Rotation;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import static net.minecraft.registry.Registries.BLOCK;

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
            if (BSSWBundle.type.contains("rough") && BSSWBundle.type.contains("sandstone")) {
                this.registerBlockStairsSlabWithBottom(modelGenerator, BSSWBundle.block, BSSWBundle.stairs, BSSWBundle.slab, BSSWBundle.base);
            }
            // Smooth Sandstones & Rough Basalt
            else if ((BSSWBundle.type.contains("smooth") && BSSWBundle.type.contains("sandstone")) ||
                BSSWBundle.block == BlockusBlocks.ROUGH_BASALT.block) {
                this.registerBlockStairsSlabWithTop(modelGenerator, BSSWBundle.block, BSSWBundle.stairs, BSSWBundle.slab, BSSWBundle.base);
            }
            // Soul Sandstone
            else if (BSSWBundle.block == BlockusBlocks.SOUL_SANDSTONE.block) {
                this.registerBlockStairsSlabwithTopBottom(modelGenerator, BSSWBundle.block, BSSWBundle.stairs, BSSWBundle.slab);
            }
            // Autre
            else {
                this.registerBlockStairsAndSlab(modelGenerator, BSSWBundle.block, BSSWBundle.stairs, BSSWBundle.slab);
            }

            if (BSSWBundle.wall != null) {
                this.registerWall(modelGenerator, BSSWBundle.wall, BSSWBundle.block);
            }
        }

        for (ConcreteBundle concreteType : ConcreteBundle.values()) {
            this.registerBlockStairsSlabAndWall(modelGenerator, concreteType.block, concreteType.stairs, concreteType.slab, concreteType.wall);
            modelGenerator.registerSimpleCubeAll(concreteType.chiseled);
            this.registerPillar(modelGenerator, concreteType.pillar);
        }

        for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
            modelGenerator.registerSimpleCubeAll(timberFrameBundle.block);
            modelGenerator.registerSimpleCubeAll(timberFrameBundle.cross);
            this.registerDiagonalTimberFrame(modelGenerator, timberFrameBundle.diagonal);
            modelGenerator.registerGlassPane(timberFrameBundle.grate, timberFrameBundle.lattice);
        }

        for (AsphaltBundle asphaltBundle : AsphaltBundle.values()) {
            this.registerBlockStairsAndSlab(modelGenerator, asphaltBundle.block, asphaltBundle.stairs, asphaltBundle.slab);
        }

        for (WoolBundle woolBundle : WoolBundle.values()) {
            this.registerBlockStairsAndSlab(modelGenerator, woolBundle.block, woolBundle.stairs, woolBundle.slab);
            this.registerCarpet(modelGenerator, woolBundle.block, woolBundle.carpet);
        }

        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            registerColoredTiles(modelGenerator, coloredTilesVariants.block, coloredTilesVariants.tile1, coloredTilesVariants.tile2);
        }

        // Copper
        modelGenerator.registerCubeAllModelTexturePool(BlockusBlocks.COPPER_BRICKS.block).family(BlockusFamilies.COPPER_BRICKS).parented(BlockusBlocks.COPPER_BRICKS.block, BlockusBlocks.COPPER_BRICKS.blockWaxed).family(BlockusFamilies.WAXED_COPPER_BRICKS);
        modelGenerator.registerCubeAllModelTexturePool(BlockusBlocks.EXPOSED_COPPER_BRICKS.block).family(BlockusFamilies.EXPOSED_COPPER_BRICKS).parented(BlockusBlocks.EXPOSED_COPPER_BRICKS.block, BlockusBlocks.EXPOSED_COPPER_BRICKS.blockWaxed).family(BlockusFamilies.WAXED_EXPOSED_COPPER_BRICKS);
        modelGenerator.registerCubeAllModelTexturePool(BlockusBlocks.WEATHERED_COPPER_BRICKS.block).family(BlockusFamilies.WEATHERED_COPPER_BRICKS).parented(BlockusBlocks.WEATHERED_COPPER_BRICKS.block, BlockusBlocks.WEATHERED_COPPER_BRICKS.blockWaxed).family(BlockusFamilies.WAXED_WEATHERED_COPPER_BRICKS);
        modelGenerator.registerCubeAllModelTexturePool(BlockusBlocks.OXIDIZED_COPPER_BRICKS.block).family(BlockusFamilies.OXIDIZED_COPPER_BRICKS).parented(BlockusBlocks.OXIDIZED_COPPER_BRICKS.block, BlockusBlocks.OXIDIZED_COPPER_BRICKS.blockWaxed).family(BlockusFamilies.WAXED_OXIDIZED_COPPER_BRICKS);
        modelGenerator.registerCubeAllModelTexturePool(BlockusBlocks.COPPER_TUFF_BRICKS.block).family(BlockusFamilies.COPPERED_TUFF_BRICKS).parented(BlockusBlocks.COPPER_TUFF_BRICKS.block, BlockusBlocks.COPPER_TUFF_BRICKS.blockWaxed).family(BlockusFamilies.WAXED_COPPERED_TUFF_BRICKS);
        modelGenerator.registerCubeAllModelTexturePool(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.block).family(BlockusFamilies.EXPOSED_COPPERED_TUFF_BRICKS).parented(BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.block, BlockusBlocks.EXPOSED_COPPER_TUFF_BRICKS.blockWaxed).family(BlockusFamilies.WAXED_EXPOSED_COPPERED_TUFF_BRICKS);
        modelGenerator.registerCubeAllModelTexturePool(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.block).family(BlockusFamilies.WEATHERED_COPPERED_TUFF_BRICKS).parented(BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.block, BlockusBlocks.WEATHERED_COPPER_TUFF_BRICKS.blockWaxed).family(BlockusFamilies.WAXED_WEATHERED_COPPERED_TUFF_BRICKS);
        modelGenerator.registerCubeAllModelTexturePool(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.block).family(BlockusFamilies.OXIDIZED_COPPERED_TUFF_BRICKS).parented(BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.block, BlockusBlocks.OXIDIZED_COPPER_TUFF_BRICKS.blockWaxed).family(BlockusFamilies.WAXED_OXIDIZED_COPPERED_TUFF_BRICKS);

        // Stone
        this.registerPillar(modelGenerator, BlockusBlocks.STONE_BRICK_PILLAR);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_STONE_BRICKS);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.STONE_CIRCULAR_PAVING);
        modelGenerator.registerDoor(BlockusBlocks.STONE_DOOR);
        modelGenerator.registerOrientableTrapdoor(BlockusBlocks.STONE_TRAPDOOR);
        this.registerSturdyStone(modelGenerator);

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
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_SCULK_PRESSURE_PLATE, BlockusBlocks.POLISHED_SCULK_BUTTON, BlockusBlocks.POLISHED_SCULK.block);

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
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_LIMESTONE_PILLAR, BlockusBlocks.POLISHED_LIMESTONE.block);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.LIMESTONE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.LIMESTONE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.LIMESTONE_PRESSURE_PLATE, BlockusBlocks.LIMESTONE_BUTTON, BlockusBlocks.LIMESTONE.block);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LIMESTONE_SQUARES);
        this.registerLines(modelGenerator, BlockusBlocks.LIMESTONE_LINES);

        // Marble
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_MARBLE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_MARBLE_PILLAR, BlockusBlocks.POLISHED_MARBLE.block);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.MARBLE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.MARBLE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.MARBLE_PRESSURE_PLATE, BlockusBlocks.MARBLE_BUTTON, BlockusBlocks.MARBLE.block);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.MARBLE_SQUARES);
        this.registerLines(modelGenerator, BlockusBlocks.MARBLE_LINES);

        // Bluestone
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.BLUESTONE_CIRCULAR_PAVING);
        this.registerLines(modelGenerator, BlockusBlocks.BLUESTONE_LINES);
        this.registerPillar(modelGenerator, BlockusBlocks.BLUESTONE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.BLUESTONE_PRESSURE_PLATE, BlockusBlocks.BLUESTONE_BUTTON, BlockusBlocks.BLUESTONE.block);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.BLUESTONE_SQUARES);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_BLUESTONE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_BLUESTONE_PILLAR, BlockusBlocks.POLISHED_BLUESTONE.block);


        // Viridite
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CHISELED_VIRIDITE);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHISELED_VIRIDITE_PILLAR, BlockusBlocks.POLISHED_VIRIDITE.block);
        modelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, BlockusBlocks.VIRIDITE_CIRCULAR_PAVING);
        this.registerPillar(modelGenerator, BlockusBlocks.VIRIDITE_PILLAR);
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.VIRIDITE_PRESSURE_PLATE, BlockusBlocks.VIRIDITE_BUTTON, BlockusBlocks.VIRIDITE.block);
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
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_NETHERRACK_PRESSURE_PLATE, BlockusBlocks.POLISHED_NETHERRACK_BUTTON, BlockusBlocks.POLISHED_NETHERRACK.block);

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

        // Sandstone
        this.registerPillar(modelGenerator, BlockusBlocks.SANDSTONE_PILLAR);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.GOLD_DECORATED_SANDSTONE, Blocks.SANDSTONE);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.LAPIS_DECORATED_SANDSTONE, Blocks.SANDSTONE);

        this.registerPillar(modelGenerator, BlockusBlocks.RED_SANDSTONE_PILLAR);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.GOLD_DECORATED_RED_SANDSTONE, Blocks.RED_SANDSTONE);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.LAPIS_DECORATED_RED_SANDSTONE, Blocks.RED_SANDSTONE);

        // Soul Sandstone
        this.registerCubeColumn(modelGenerator, BlockusBlocks.CHISELED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block);
        this.registerSlabwithTop(modelGenerator, BlockusBlocks.CUT_SOUL_SANDSTONE_SLAB, BlockusBlocks.CUT_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block);
        this.registerPillar(modelGenerator, BlockusBlocks.SOUL_SANDSTONE_PILLAR);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.GOLD_DECORATED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block);
        this.registerCubeColumn(modelGenerator, BlockusBlocks.LAPIS_DECORATED_SOUL_SANDSTONE, BlockusBlocks.SOUL_SANDSTONE.block);

        // Rainbow
        modelGenerator.registerFlowerbed(BlockusBlocks.RAINBOW_PETALS);
        this.registerUpDefaultFacingBlock(modelGenerator, BlockusBlocks.RAINBOW_BLOCK);
        this.registerTopBottomFacingBottom(modelGenerator, BlockusBlocks.RAINBOW_ASPHALT);
        modelGenerator.registerFlowerPotPlant(BlockusBlocks.RAINBOW_ROSE, BlockusBlocks.POTTED_RAINBOW_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);

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
        this.registerButtonAndPressurePlate(modelGenerator, BlockusBlocks.POLISHED_END_STONE_PRESSURE_PLATE, BlockusBlocks.POLISHED_END_STONE_BUTTON, BlockusBlocks.POLISHED_END_STONE.block);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_END_STONE_BRICKS);

        // White Oak Wood
        modelGenerator.registerLog(BlockusBlocks.WHITE_OAK_LOG).log(BlockusBlocks.WHITE_OAK_LOG).wood(BlockusBlocks.WHITE_OAK_WOOD);
        modelGenerator.registerSingleton(BlockusBlocks.WHITE_OAK_LEAVES, TexturedModel.LEAVES);
        modelGenerator.registerLog(BlockusBlocks.STRIPPED_WHITE_OAK_LOG).log(BlockusBlocks.STRIPPED_WHITE_OAK_LOG).wood(BlockusBlocks.STRIPPED_WHITE_OAK_WOOD);
        modelGenerator.registerFlowerPotPlant(BlockusBlocks.WHITE_OAK_SAPLING, BlockusBlocks.POTTED_WHITE_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        // Hanging Signs
        modelGenerator.registerHangingSign(BlockusBlocks.WHITE_OAK_LOG, BlockusBlocks.WHITE_OAK.ceiling_hanging_sign, BlockusBlocks.WHITE_OAK.wall_hanging_sign);
        modelGenerator.registerHangingSign(BlockusBlocks.RAW_BAMBOO.planks, BlockusBlocks.RAW_BAMBOO.ceiling_hanging_sign, BlockusBlocks.RAW_BAMBOO.wall_hanging_sign);
        modelGenerator.registerHangingSign(BlockusBlocks.CHARRED.planks, BlockusBlocks.CHARRED.ceiling_hanging_sign, BlockusBlocks.CHARRED.wall_hanging_sign);

        // Herringbone Planks
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_OAK_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_BIRCH_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_SPRUCE_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_JUNGLE_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_ACACIA_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_DARK_OAK_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_MANGROVE_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_CHERRY_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_RAW_BAMBOO_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_BAMBOO_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_CRIMSON_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_WARPED_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_CHARRED_PLANKS);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.HERRINGBONE_WHITE_OAK_PLANKS);

        // Small Logs
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.ACACIA_SMALL_LOGS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.BIRCH_SMALL_LOGS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CHERRY_SMALL_LOGS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.DARK_OAK_SMALL_LOGS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.JUNGLE_SMALL_LOGS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.MANGROVE_SMALL_LOGS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.OAK_SMALL_LOGS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.SPRUCE_SMALL_LOGS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.WHITE_OAK_SMALL_LOGS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.CRIMSON_SMALL_STEMS);
        this.registerAxisRotatedCubeColumn(modelGenerator, BlockusBlocks.WARPED_SMALL_STEMS);

        // Posts
        for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
            this.registerPost(modelGenerator, woodenPost.block, woodenPost.base);
            this.registerPost(modelGenerator, woodenPost.stripped, woodenPost.baseStripped);
        }

        // Small Hedges
        this.registerSmallHedge(modelGenerator, BlockusBlocks.OAK_SMALL_HEDGE, Blocks.OAK_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.SPRUCE_SMALL_HEDGE, Blocks.SPRUCE_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.BIRCH_SMALL_HEDGE, Blocks.BIRCH_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.JUNGLE_SMALL_HEDGE, Blocks.JUNGLE_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.ACACIA_SMALL_HEDGE, Blocks.ACACIA_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.DARK_OAK_SMALL_HEDGE, Blocks.DARK_OAK_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.MANGROVE_SMALL_HEDGE, Blocks.MANGROVE_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.CHERRY_SMALL_HEDGE, Blocks.CHERRY_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.WARPED_SMALL_HEDGE, Blocks.WARPED_WART_BLOCK);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.CRIMSON_SMALL_HEDGE, Blocks.NETHER_WART_BLOCK);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.WHITE_OAK_SMALL_HEDGE, BlockusBlocks.WHITE_OAK_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.AZALEA_SMALL_HEDGE, Blocks.AZALEA_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.FLOWERING_AZALEA_SMALL_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES);
        this.registerSmallHedge(modelGenerator, BlockusBlocks.MOSS_SMALL_HEDGE, Blocks.MOSS_BLOCK);

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
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.BLUE_REDSTONE_LAMP, BlockusBlocks.BLUE_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.BROWN_REDSTONE_LAMP, BlockusBlocks.BROWN_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.CYAN_REDSTONE_LAMP, BlockusBlocks.CYAN_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.GRAY_REDSTONE_LAMP, BlockusBlocks.GRAY_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.GREEN_REDSTONE_LAMP, BlockusBlocks.GREEN_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP, BlockusBlocks.LIGHT_BLUE_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP, BlockusBlocks.LIGHT_GRAY_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.LIME_REDSTONE_LAMP, BlockusBlocks.LIME_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.MAGENTA_REDSTONE_LAMP, BlockusBlocks.MAGENTA_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.ORANGE_REDSTONE_LAMP, BlockusBlocks.ORANGE_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.PINK_REDSTONE_LAMP, BlockusBlocks.PINK_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.PURPLE_REDSTONE_LAMP, BlockusBlocks.PURPLE_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.RED_REDSTONE_LAMP, BlockusBlocks.RED_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.WHITE_REDSTONE_LAMP, BlockusBlocks.WHITE_REDSTONE_LAMP_LIT);
        this.registerRedstoneLamp(modelGenerator, BlockusBlocks.YELLOW_REDSTONE_LAMP, BlockusBlocks.YELLOW_REDSTONE_LAMP_LIT);

        // Neon Blocks
        this.registerNeonBlock(modelGenerator, BlockusBlocks.BLACK_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.BLUE_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.BROWN_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.CYAN_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.GRAY_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.GREEN_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.LIGHT_BLUE_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.LIGHT_GRAY_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.LIME_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.MAGENTA_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.ORANGE_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.PINK_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.PURPLE_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.RED_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.WHITE_NEON);
        this.registerNeonBlock(modelGenerator, BlockusBlocks.YELLOW_NEON);

        // Futurneo Blocks
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.RAINBOW_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.BLACK_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.BLUE_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.BROWN_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.CYAN_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.GRAY_BRIGHT_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.GRAY_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.GREEN_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LIGHT_BLUE_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LIGHT_GRAY_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.LIME_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.MAGENTA_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.ORANGE_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.PINK_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.PURPLE_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.RED_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.WHITE_FUTURNEO_BLOCK);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.YELLOW_FUTURNEO_BLOCK);

        // Glass - Beveled Glass
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.RAINBOW_BEVELED_GLASS, BlockusBlocks.RAINBOW_BEVELED_GLASS_PANE);
        modelGenerator.registerGlassPane(BlockusBlocks.RAINBOW_GLASS, BlockusBlocks.RAINBOW_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.BEVELED_GLASS, BlockusBlocks.BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.BLACK_BEVELED_GLASS, BlockusBlocks.BLACK_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.BLUE_BEVELED_GLASS, BlockusBlocks.BLUE_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.BROWN_BEVELED_GLASS, BlockusBlocks.BROWN_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.CYAN_BEVELED_GLASS, BlockusBlocks.CYAN_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.GRAY_BEVELED_GLASS, BlockusBlocks.GRAY_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.GREEN_BEVELED_GLASS, BlockusBlocks.GREEN_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS, BlockusBlocks.LIGHT_BLUE_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS, BlockusBlocks.LIGHT_GRAY_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.LIME_BEVELED_GLASS, BlockusBlocks.LIME_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.MAGENTA_BEVELED_GLASS, BlockusBlocks.MAGENTA_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.ORANGE_BEVELED_GLASS, BlockusBlocks.ORANGE_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.PINK_BEVELED_GLASS, BlockusBlocks.PINK_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.PURPLE_BEVELED_GLASS, BlockusBlocks.PURPLE_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.RED_BEVELED_GLASS, BlockusBlocks.RED_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.WHITE_BEVELED_GLASS, BlockusBlocks.WHITE_BEVELED_GLASS_PANE);
        this.registerBeveledGlassPane(modelGenerator, BlockusBlocks.YELLOW_BEVELED_GLASS, BlockusBlocks.YELLOW_BEVELED_GLASS_PANE);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.TINTED_BEVELED_GLASS);

        // Glazed Terracotta Pillars
        this.registerPillar(modelGenerator, BlockusBlocks.BLACK_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.BLUE_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.BROWN_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.CYAN_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.GRAY_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.GREEN_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.LIME_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.MAGENTA_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.ORANGE_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.PINK_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.PURPLE_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.RED_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.WHITE_GLAZED_TERRACOTTA_PILLAR);
        this.registerPillar(modelGenerator, BlockusBlocks.YELLOW_GLAZED_TERRACOTTA_PILLAR);

        // Paper
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.BURNT_PAPER_BLOCK);
        modelGenerator.registerGlassPane(BlockusBlocks.FRAMED_PAPER_BLOCK, BlockusBlocks.PAPER_WALL);
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.PAPER_BLOCK);
        modelGenerator.registerOrientableTrapdoor(BlockusBlocks.PAPER_TRAPDOOR);
        modelGenerator.registerDoor(BlockusBlocks.PAPER_DOOR);

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
        modelGenerator.registerFlowerPotPlant(BlockusBlocks.LEGACY_SAPLING, BlockusBlocks.POTTED_LEGACY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
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
        modelGenerator.registerFlowerPotPlant(BlockusBlocks.LEGACY_ROSE, BlockusBlocks.POTTED_LEGACY_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGenerator.registerFlowerPotPlant(BlockusBlocks.LEGACY_BLUE_ROSE, BlockusBlocks.POTTED_LEGACY_BLUE_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);

        // Colored Tiles
        modelGenerator.registerSimpleCubeAll(BlockusBlocks.RAINBOW_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.BLACK_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.BLUE_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.BROWN_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.CYAN_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.GRAY_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.GREEN_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.LIGHT_BLUE_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.LIGHT_GRAY_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.LIME_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.MAGENTA_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.ORANGE_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.PINK_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.PURPLE_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.RED_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.WHITE_COLORED_TILES);
        registerColoredTilesSimple(modelGenerator, BlockusBlocks.YELLOW_COLORED_TILES);

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
    }

    @Override
    public void generateItemModels(ItemModelGenerator modelGenerator) {
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
            .with(When.create().set(Properties.AXIS, Direction.Axis.X), BlockStateVariant.create().put(VariantSettings.MODEL, postModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.Y, Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(Properties.AXIS, Direction.Axis.Y), BlockStateVariant.create().put(VariantSettings.MODEL, postModelId).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(Properties.AXIS, Direction.Axis.Z), BlockStateVariant.create().put(VariantSettings.MODEL, postModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.NORTH, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, topModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.SOUTH, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, sideModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.EAST, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, topModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.Y, Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.WEST, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, sideModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.Y, Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.UP, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, topModelId).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.DOWN, PostBlock.ConnectionType.POST), BlockStateVariant.create().put(VariantSettings.MODEL, sideModelId).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.NORTH, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, topChainModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.SOUTH, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, chainModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.EAST, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, topChainModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.Y, Rotation.R90).put(VariantSettings.UVLOCK, false))
            .with(When.create().set(PostBlock.WEST, PostBlock.ConnectionType.CHAIN), BlockStateVariant.create().put(VariantSettings.MODEL, chainModelId).put(VariantSettings.X, Rotation.R90).put(VariantSettings.Y, Rotation.R90).put(VariantSettings.UVLOCK, false))
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

    public final void registerSmallHedge(BlockStateModelGenerator modelGenerator, Block wallBlock, Block textureSource) {
        TextureMap textureMap = TextureMap.of(BlockusTextureKey.HEDGE, TextureMap.getId(textureSource));
        Identifier identifier = BlockusModels.TEMPLATE_SMALL_HEDGE_END.upload(wallBlock, textureMap, modelGenerator.modelCollector);
        Identifier identifier2 = BlockusModels.TEMPLATE_SMALL_HEDGE_SIDE.upload(wallBlock, textureMap, modelGenerator.modelCollector);
        Identifier identifier3 = BlockusModels.TEMPLATE_SMALL_HEDGE_SIDE_TALL.upload(wallBlock, textureMap, modelGenerator.modelCollector);
        modelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wallBlock, identifier, identifier2, identifier3));
        Identifier identifier4 = BlockusModels.TEMPLATE_SMALL_HEDGE_INVENTORY.upload(wallBlock, textureMap, modelGenerator.modelCollector);
        modelGenerator.registerParentedItemModel(wallBlock, identifier4);
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

    public final void registerNeonBlock(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = TextureMap.of(TextureKey.ALL, TextureMap.getId(block));
        this.createBlock(modelGenerator, block, BlockusModels.NEON_BLOCK_TEMPLATE, textureMap);
    }

    public final void registerFishCrate(BlockStateModelGenerator modelGenerator, Block block) {
        TextureMap textureMap = sideTopBottom(getBlockId("fish_crate_side"), TextureMap.getId(block), getBlockId("fish_crate_bottom"));
        this.createBlock(modelGenerator, block, Models.CUBE_BOTTOM_TOP, textureMap);
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
        Models.GENERATED.upload(ModelIds.getItemModelId(item), TextureMap.layer0(glass), modelGenerator.modelCollector);
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
        return Blockus.id("block/" + BLOCK.getId(block).getPath());
    }

    public static Identifier getModifiedBlockId(Block block, String target, String replacement) {
        return Blockus.id("block/" + BLOCK.getId(block).getPath().replace(target, replacement));
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
}
