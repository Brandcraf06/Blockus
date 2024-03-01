package com.brand.blockus.data.providers;

import com.brand.blockus.blocks.base.CookieBlock;
import com.brand.blockus.blocks.base.LargeFlowerPotBlock;
import com.brand.blockus.content.BlockusItems;
import com.brand.blockus.content.types.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.LimitCountLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import java.util.function.Function;

import static com.brand.blockus.content.BlockusBlocks.*;

public class BlockusBlockLootTableProvider extends FabricBlockLootTableProvider {
    public BlockusBlockLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {

        for (BSSTypes bssType : BSSTypes.values()) {
            this.addBlockStairsandSlabDrops(bssType.block, bssType.stairs, bssType.slab);
        }

        for (BSSWTypes bsswType : BSSWTypes.values()) {
            this.addBlockStairsandSlabDrops(bsswType.block, bsswType.stairs, bsswType.slab);
            this.addDrop(bsswType.wall);
        }

        for (ConcreteTypes concreteType : ConcreteTypes.values()) {
            this.addBlockStairsandSlabDrops(concreteType.block, concreteType.stairs, concreteType.slab);
            this.addDrops(concreteType.wall, concreteType.chiseled, concreteType.pillar);
        }

        for (WoodTypes woodType : WoodTypes.values()) {
            this.addWoodSetDrop(woodType.planks,
                woodType.stairs,
                woodType.slab,
                woodType.fence,
                woodType.fence_gate,
                woodType.door,
                woodType.trapdoor,
                woodType.pressure_plate,
                woodType.button,
                woodType.standing_sign,
                woodType.ceiling_hanging_sign);
        }

        for (TimberFrameTypes timberFrameType : TimberFrameTypes.values()) {
            this.addDrops(timberFrameType.block, timberFrameType.diagonal, timberFrameType.cross);
        }

        for (AsphaltTypes asphaltTypes : AsphaltTypes.values()) {
            this.addBlockStairsandSlabDrops(asphaltTypes.block, asphaltTypes.stairs, asphaltTypes.slab);
        }

        for (PottedLargeTypes pottedLargeType : PottedLargeTypes.values()) {
            this.addPottedLargePlantDrop(pottedLargeType.block);
        }

        for (WoolTypes woolTypes : WoolTypes.values()) {
            this.addBlockStairsandSlabDrops(woolTypes.block, woolTypes.stairs, woolTypes.slab);
            this.addDrop(woolTypes.carpet);
        }

        for (ColoredTilesTypes coloredTilesTypes : ColoredTilesTypes.values()) {
            this.addDrop(coloredTilesTypes.block);
        }

        this.addDrops(CHISELED_MUD_BRICKS,
            MUD_BRICK_PILLAR,

            // Viridite
            CHISELED_VIRIDITE,
            CHISELED_VIRIDITE_PILLAR,
            VIRIDITE_BUTTON,
            VIRIDITE_CIRCULAR_PAVING,
            VIRIDITE_PILLAR,
            VIRIDITE_PRESSURE_PLATE,
            VIRIDITE_SQUARES,
            VIRIDITE_LINES,

            // Amethyst
            CHISELED_AMETHYST,
            AMETHYST_PILLAR,

            // Sculk
            CHISELED_SCULK_BRICKS,
            POLISHED_SCULK_BUTTON,
            SCULK_PILLAR,
            POLISHED_SCULK_PRESSURE_PLATE,

            // Herringbone Planks
            HERRINGBONE_OAK_PLANKS,
            HERRINGBONE_BIRCH_PLANKS,
            HERRINGBONE_SPRUCE_PLANKS,
            HERRINGBONE_JUNGLE_PLANKS,
            HERRINGBONE_ACACIA_PLANKS,
            HERRINGBONE_DARK_OAK_PLANKS,
            HERRINGBONE_MANGROVE_PLANKS,
            HERRINGBONE_CHERRY_PLANKS,
            HERRINGBONE_BAMBOO_PLANKS,
            HERRINGBONE_RAW_BAMBOO_PLANKS,
            HERRINGBONE_WHITE_OAK_PLANKS,
            HERRINGBONE_CRIMSON_PLANKS,
            HERRINGBONE_WARPED_PLANKS,
            HERRINGBONE_CHARRED_PLANKS,

            // Other
            LEGACY_LOG,
            LEGACY_SAPLING,
            ACACIA_SMALL_LOGS,
            ANDESITE_CIRCULAR_PAVING,
            APPLE_CRATE,
            BEETROOT_CRATE,
            BIRCH_SMALL_LOGS,
            BLACK_COLORED_TILES,
            BLACK_FUTURNEO_BLOCK,
            BLACK_GLAZED_TERRACOTTA_PILLAR,
            BLACK_NEON,
            BLACKSTONE_TRAPDOOR,
            BLAZE_PILLAR,
            BLUE_COLORED_TILES,
            BLUE_FUTURNEO_BLOCK,
            BLUE_GLAZED_TERRACOTTA_PILLAR,
            BLUE_NEON,
            BLUE_REDSTONE_LAMP,
            BLUE_REDSTONE_LAMP_LIT,
            BLUESTONE_BUTTON,
            BLUESTONE_CIRCULAR_PAVING,
            BLUESTONE_LINES,
            BLUESTONE_PILLAR,
            BLUESTONE_PRESSURE_PLATE,
            BLUESTONE_SQUARES,
            BREAD_BOX,
            BROWN_COLORED_TILES,
            BROWN_FUTURNEO_BLOCK,
            BROWN_GLAZED_TERRACOTTA_PILLAR,
            BROWN_NEON,
            BROWN_REDSTONE_LAMP,
            BROWN_REDSTONE_LAMP_LIT,
            CARROT_CRATE,
            CAUTION_BARRIER,
            CAUTION_BLOCK,
            CHARCOAL_BLOCK,
            CHARRED_NETHER_BRICK_PILLAR,
            CHERRY_SMALL_LOGS,
            CHISELED_ANDESITE_BRICKS,
            CHISELED_BLUESTONE,
            CHISELED_DARK_PRISMARINE,
            CHISELED_DIORITE_BRICKS,
            CHISELED_DRIPSTONE,
            CHISELED_END_STONE_BRICKS,
            CHISELED_GRANITE_BRICKS,
            CHISELED_LAVA_BRICKS,
            CHISELED_LAVA_POLISHED_BLACKSTONE,
            CHISELED_LIMESTONE,
            CHISELED_MAGMA_BRICKS,
            CHISELED_MARBLE,
            CHISELED_MARBLE_PILLAR,
            CHISELED_LIMESTONE_PILLAR,
            CHISELED_BLUESTONE_PILLAR,
            CHISELED_PHANTOM_PURPUR,
            CHISELED_POLISHED_BASALT,
            CHISELED_PRISMARINE,
            CHISELED_PURPUR,
            CHISELED_SOUL_SANDSTONE,
            CHISELED_TUFF,
            CHISELED_WATER_BRICKS,
            CHORUS_BLOCK,
            COD_CRATE,
            COMPANION_CUBE,
            CRACKED_ANDESITE_BRICKS,
            CRACKED_DIORITE_BRICKS,
            CRACKED_DRIPSTONE_BRICKS,
            CRACKED_END_STONE_BRICKS,
            CRACKED_GRANITE_BRICKS,
            CRACKED_OBSIDIAN_BRICKS,
            CRACKED_POLISHED_BASALT_BRICKS,
            CRACKED_TUFF_BRICKS,
            CRIMSON_SMALL_HEDGE,
            CRIMSON_SMALL_STEMS,
            CUT_SOUL_SANDSTONE,
            CYAN_COLORED_TILES,
            CYAN_FUTURNEO_BLOCK,
            CYAN_GLAZED_TERRACOTTA_PILLAR,
            CYAN_NEON,
            CYAN_REDSTONE_LAMP,
            CYAN_REDSTONE_LAMP_LIT,
            DARK_OAK_SMALL_LOGS,
            DARK_PRISMARINE_PILLAR,
            DEEPSLATE_CIRCULAR_PAVING,
            DEEPSLATE_PILLAR,
            DIORITE_CIRCULAR_PAVING,
            DRIPSTONE_PILLAR,
            END_STONE_PILLAR,
            ENDER_BLOCK,
            FRAMED_PAPER_BLOCK,
            GLOW_BERRIES_CRATE,
            GLOWING_OBSIDIAN,
            GOLD_DECORATED_POLISHED_BLACKSTONE,
            GOLD_DECORATED_RED_SANDSTONE,
            GOLD_DECORATED_SANDSTONE,
            GOLD_DECORATED_SOUL_SANDSTONE,
            GOLDEN_APPLE_CRATE,
            GOLDEN_BARS,
            GOLDEN_CARROT_CRATE,
            GOLDEN_CHAIN,
            GRANITE_CIRCULAR_PAVING,
            GRAY_BRIGHT_FUTURNEO_BLOCK,
            GRAY_COLORED_TILES,
            GRAY_FUTURNEO_BLOCK,
            GRAY_GLAZED_TERRACOTTA_PILLAR,
            GRAY_NEON,
            GRAY_REDSTONE_LAMP,
            GRAY_REDSTONE_LAMP_LIT,
            GREEN_COLORED_TILES,
            GREEN_FUTURNEO_BLOCK,
            GREEN_GLAZED_TERRACOTTA_PILLAR,
            GREEN_NEON,
            GREEN_REDSTONE_LAMP,
            GREEN_REDSTONE_LAMP_LIT,
            JUNGLE_SMALL_LOGS,
            LANTERN_BLOCK,
            LAPIS_DECORATED_RED_SANDSTONE,
            LAPIS_DECORATED_SANDSTONE,
            LAPIS_DECORATED_SOUL_SANDSTONE,
            LARGE_FLOWER_POT,
            LEGACY_BRICKS,
            LEGACY_COAL_BLOCK,
            LEGACY_COBBLESTONE,
            LEGACY_CRYING_OBSIDIAN,
            LEGACY_DIAMOND_BLOCK,
            LEGACY_EXPLOSION_PROOF_GOLD_BLOCK,
            LEGACY_FIRST_COBBLESTONE,
            LEGACY_FIRST_GRASS_BLOCK,
            LEGACY_GLOWING_OBSIDIAN,
            LEGACY_GOLD_BLOCK,
            LEGACY_GRASS_BLOCK,
            LEGACY_IRON_BLOCK,
            LEGACY_LAPIS_BLOCK,
            LEGACY_MOSSY_COBBLESTONE,
            LEGACY_PLANKS,
            LEGACY_SPONGE,
            LEGACY_STONECUTTER,
            LIGHT_BLUE_COLORED_TILES,
            LIGHT_BLUE_FUTURNEO_BLOCK,
            LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR,
            LIGHT_BLUE_NEON,
            LIGHT_BLUE_REDSTONE_LAMP,
            LIGHT_BLUE_REDSTONE_LAMP_LIT,
            LIGHT_GRAY_COLORED_TILES,
            LIGHT_GRAY_FUTURNEO_BLOCK,
            LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR,
            LIGHT_GRAY_NEON,
            LIGHT_GRAY_REDSTONE_LAMP,
            LIGHT_GRAY_REDSTONE_LAMP_LIT,
            LIME_COLORED_TILES,
            LIME_FUTURNEO_BLOCK,
            LIME_GLAZED_TERRACOTTA_PILLAR,
            LIME_NEON,
            LIME_REDSTONE_LAMP,
            LIME_REDSTONE_LAMP_LIT,
            LIMESTONE_BUTTON,
            LIMESTONE_CIRCULAR_PAVING,
            LIMESTONE_PILLAR,
            LIMESTONE_PRESSURE_PLATE,
            LIMESTONE_SQUARES,
            LIMESTONE_LINES,
            LOVE_BLOCK,
            MAGENTA_COLORED_TILES,
            MAGENTA_FUTURNEO_BLOCK,
            MAGENTA_GLAZED_TERRACOTTA_PILLAR,
            MAGENTA_NEON,
            MAGENTA_REDSTONE_LAMP,
            MAGENTA_REDSTONE_LAMP_LIT,
            MANGROVE_SMALL_LOGS,
            MARBLE_BUTTON,
            MARBLE_CIRCULAR_PAVING,
            MARBLE_PILLAR,
            MARBLE_PRESSURE_PLATE,
            MARBLE_SQUARES,
            MARBLE_LINES,
            MEMBRANE_BLOCK,
            MOSS_SMALL_HEDGE,
            NETHER_BRICK_PILLAR,
            NETHERITE_STAIRS,
            NETHERRACK_CIRCULAR_PAVING,
            OAK_SMALL_LOGS,
            OBSIDIAN_CIRCULAR_PAVING,
            OBSIDIAN_PILLAR,
            OBSIDIAN_PRESSURE_PLATE,
            OBSIDIAN_REINFORCED_TRAPDOOR,
            ORANGE_COLORED_TILES,
            ORANGE_FUTURNEO_BLOCK,
            ORANGE_GLAZED_TERRACOTTA_PILLAR,
            ORANGE_NEON,
            ORANGE_REDSTONE_LAMP,
            ORANGE_REDSTONE_LAMP_LIT,
            PAPER_BLOCK,
            PAPER_LAMP,
            PAPER_TRAPDOOR,
            PAPER_WALL,
            PATH,
            PHANTOM_PURPUR_DECORATED_END_STONE,
            PHANTOM_PURPUR_LINES,
            PHANTOM_PURPUR_PILLAR,
            PHANTOM_PURPUR_SQUARES,
            PINK_COLORED_TILES,
            PINK_FUTURNEO_BLOCK,
            PINK_GLAZED_TERRACOTTA_PILLAR,
            PINK_NEON,
            PINK_REDSTONE_LAMP,
            PINK_REDSTONE_LAMP_LIT,
            POLISHED_ANDESITE_BUTTON,
            POLISHED_ANDESITE_PILLAR,
            POLISHED_ANDESITE_PRESSURE_PLATE,
            POLISHED_BASALT_BUTTON,
            POLISHED_BASALT_CIRCULAR_PAVING,
            POLISHED_BASALT_PILLAR,
            POLISHED_BASALT_PRESSURE_PLATE,
            POLISHED_BLACKSTONE_CIRCULAR_PAVING,
            POLISHED_BLACKSTONE_PILLAR,
            POLISHED_CHARRED_NETHER_BRICKS,
            POLISHED_DEEPSLATE_BUTTON,
            POLISHED_DEEPSLATE_PRESSURE_PLATE,
            POLISHED_DIORITE_BUTTON,
            POLISHED_DIORITE_PILLAR,
            POLISHED_DIORITE_PRESSURE_PLATE,
            POLISHED_END_STONE_BUTTON,
            POLISHED_END_STONE_PRESSURE_PLATE,
            POLISHED_GRANITE_BUTTON,
            POLISHED_GRANITE_PILLAR,
            POLISHED_GRANITE_PRESSURE_PLATE,
            POLISHED_NETHER_BRICKS,
            POLISHED_NETHERRACK_BUTTON,
            POLISHED_NETHERRACK_PRESSURE_PLATE,
            POLISHED_RED_NETHER_BRICKS,
            POLISHED_TEAL_NETHER_BRICKS,
            POLISHED_TUFF_BUTTON,
            POLISHED_TUFF_PRESSURE_PLATE,
            POTATO_CRATE,
            PRISMARINE_CIRCULAR_PAVING,
            PRISMARINE_PILLAR,
            PUFFERFISH_CRATE,
            PURPLE_COLORED_TILES,
            PURPLE_FUTURNEO_BLOCK,
            PURPLE_GLAZED_TERRACOTTA_PILLAR,
            PURPLE_NEON,
            PURPLE_REDSTONE_LAMP,
            PURPLE_REDSTONE_LAMP_LIT,
            PURPUR_DECORATED_END_STONE,
            PURPUR_LINES,
            PURPUR_SQUARES,
            QUARTZ_CIRCULAR_PAVING,
            RAINBOW_ASPHALT,
            RAINBOW_BEVELED_GLASS,
            RAINBOW_BEVELED_GLASS_PANE,
            RAINBOW_BLOCK,
            RAINBOW_COLORED_TILES,
            RAINBOW_FUTURNEO_BLOCK,
            RAINBOW_GLASS,
            RAINBOW_GLASS_PANE,
            RAINBOW_LAMP,
            RAINBOW_LAMP_LIT,
            RED_COLORED_TILES,
            RED_FUTURNEO_BLOCK,
            RED_GLAZED_TERRACOTTA_PILLAR,
            RED_NEON,
            RED_NETHER_BRICK_PILLAR,
            RED_REDSTONE_LAMP,
            RED_REDSTONE_LAMP_LIT,
            RED_SANDSTONE_PILLAR,
            REDSTONE_LAMP_LIT,
            REDSTONE_LANTERN,
            REDSTONE_LANTERN_BLOCK,
            REDSTONE_SAND,
            ROAD_BARRIER,
            ROTTEN_FLESH_BLOCK,
            SALMON_CRATE,
            SANDSTONE_PILLAR,
            SMOOTH_STONE_STAIRS,
            SNOW_PILLAR,
            SOUL_LANTERN_BLOCK,
            SOUL_O_LANTERN,
            REDSTONE_O_LANTERN,
            SOUL_SANDSTONE_PILLAR,
            SPRUCE_SMALL_LOGS,
            STARS_BLOCK,
            STONE_BRICK_PILLAR,
            STONE_CIRCULAR_PAVING,
            STONE_TRAPDOOR,
            STRIPPED_WHITE_OAK_LOG,
            STRIPPED_WHITE_OAK_WOOD,
            STURDY_BLACKSTONE,
            STURDY_DEEPSLATE,
            STURDY_STONE,
            SUGAR_BLOCK,
            SWEET_BERRIES_CRATE,
            TEAL_NETHER_BRICK_PILLAR,
            TROPICAL_FISH_CRATE,
            TUFF_CIRCULAR_PAVING,
            TUFF_PILLAR,
            WARPED_SMALL_HEDGE,
            WARPED_SMALL_STEMS,
            WEIGHT_STORAGE_CUBE,
            WHITE_COLORED_TILES,
            WHITE_FUTURNEO_BLOCK,
            WHITE_GLAZED_TERRACOTTA_PILLAR,
            WHITE_NEON,
            WHITE_OAK_LOG,
            WHITE_OAK_SAPLING,
            WHITE_OAK_SMALL_LOGS,
            WHITE_OAK_WOOD,
            WHITE_REDSTONE_LAMP,
            WHITE_REDSTONE_LAMP_LIT,
            WOODEN_FRAME,
            YELLOW_COLORED_TILES,
            YELLOW_FUTURNEO_BLOCK,
            YELLOW_GLAZED_TERRACOTTA_PILLAR,
            YELLOW_NEON,
            YELLOW_REDSTONE_LAMP,
            YELLOW_REDSTONE_LAMP_LIT,
            HERRINGBONE_ANDESITE_BRICKS,
            HERRINGBONE_BRICKS,
            HERRINGBONE_CHARRED_BRICKS,
            HERRINGBONE_CHARRED_NETHER_BRICKS,
            HERRINGBONE_DEEPSLATE_BRICKS,
            HERRINGBONE_DIORITE_BRICKS,
            HERRINGBONE_END_STONE_BRICKS,
            HERRINGBONE_GRANITE_BRICKS,
            HERRINGBONE_NETHER_BRICKS,
            HERRINGBONE_POLISHED_BASALT_BRICKS,
            HERRINGBONE_POLISHED_BLACKSTONE_BRICKS,
            HERRINGBONE_RED_NETHER_BRICKS,
            HERRINGBONE_SANDY_BRICKS,
            HERRINGBONE_SOAKED_BRICKS,
            HERRINGBONE_STONE_BRICKS,
            HERRINGBONE_TEAL_NETHER_BRICKS,
            HERRINGBONE_TUFF_BRICKS,
            RAINBOW_ROSE,
            TINTED_BEVELED_GLASS,
            CHOCOLATE_TABLET,
            CHOCOLATE_SQUARES);

        this.addDrops(this::slabDrops, CUT_SOUL_SANDSTONE_SLAB, NETHERITE_SLAB);
        this.addDrops(this::doorDrops, BLACKSTONE_DOOR, GOLDEN_GATE, IRON_GATE, OBSIDIAN_REINFORCED_DOOR, PAPER_DOOR, STONE_DOOR);
        this.addDrops(this::stickDrops,
            ACACIA_SMALL_HEDGE,
            AZALEA_SMALL_HEDGE,
            FLOWERING_AZALEA_SMALL_HEDGE,
            BIRCH_SMALL_HEDGE,
            DARK_OAK_SMALL_HEDGE,
            JUNGLE_SMALL_HEDGE,
            OAK_SMALL_HEDGE,
            SPRUCE_SMALL_HEDGE,
            MANGROVE_SMALL_HEDGE,
            CHERRY_SMALL_HEDGE,
            WHITE_OAK_SMALL_HEDGE);

        this.addDropsWithSilkTouch(BEVELED_GLASS,
            BEVELED_GLASS_PANE,
            BLACK_BEVELED_GLASS,
            BLACK_BEVELED_GLASS_PANE,
            BLUE_BEVELED_GLASS,
            BLUE_BEVELED_GLASS_PANE,
            BROWN_BEVELED_GLASS,
            BROWN_BEVELED_GLASS_PANE,
            CYAN_BEVELED_GLASS,
            CYAN_BEVELED_GLASS_PANE,
            GRAY_BEVELED_GLASS,
            GRAY_BEVELED_GLASS_PANE,
            GREEN_BEVELED_GLASS,
            GREEN_BEVELED_GLASS_PANE,
            ICE_BRICK_WALL,
            ICE_BRICKS,
            ICE_PILLAR,
            LIGHT_BLUE_BEVELED_GLASS,
            LIGHT_BLUE_BEVELED_GLASS_PANE,
            LIGHT_GRAY_BEVELED_GLASS,
            LIGHT_GRAY_BEVELED_GLASS_PANE,
            LIME_BEVELED_GLASS,
            LIME_BEVELED_GLASS_PANE,
            MAGENTA_BEVELED_GLASS,
            MAGENTA_BEVELED_GLASS_PANE,
            ORANGE_BEVELED_GLASS,
            ORANGE_BEVELED_GLASS_PANE,
            PINK_BEVELED_GLASS,
            PINK_BEVELED_GLASS_PANE,
            PURPLE_BEVELED_GLASS,
            PURPLE_BEVELED_GLASS_PANE,
            RED_BEVELED_GLASS,
            RED_BEVELED_GLASS_PANE,
            WHITE_BEVELED_GLASS,
            WHITE_BEVELED_GLASS_PANE,
            YELLOW_BEVELED_GLASS,
            YELLOW_BEVELED_GLASS_PANE);

        this.addPottedPlantDropsBatch(POTTED_WHITE_OAK_SAPLING, POTTED_RAINBOW_ROSE, POTTED_LEGACY_SAPLING);

        this.addDrop(LEGACY_LEAVES, (block) -> this.leavesDrops(block, LEGACY_SAPLING, SAPLING_DROP_CHANCE));
        this.addDrop(LEGACY_GLOWSTONE, this::glowstoneDrops);
        this.addDrop(LEGACY_GRAVEL, (block) -> dropsWithSilkTouch(block, this.addSurvivesExplosionCondition(block, ItemEntry.builder(Items.FLINT).conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.1F, 0.14285715F, 0.25F, 1.0F)).alternatively(ItemEntry.builder(block)))));
        this.addDrop(LEGACY_NETHER_REACTOR_CORE, (block) -> LootTable.builder().pool(this.addSurvivesExplosionCondition(block, LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F)).with(ItemEntry.builder(Items.DIAMOND)))).pool(this.addSurvivesExplosionCondition(block, LootPool.builder().rolls(ConstantLootNumberProvider.create(6.0F)).with(ItemEntry.builder(Items.IRON_INGOT)))));

        this.addDrop(WHITE_OAK_LEAVES, (block) -> this.oakLeavesDrops(block, WHITE_OAK_SAPLING, SAPLING_DROP_CHANCE));
        this.addDrop(BLAZE_LANTERN, (block) -> this.drops(block, Items.BLAZE_POWDER, ConstantLootNumberProvider.create(9.0F)));
        this.addDrop(BURNT_PAPER_BLOCK, (block) -> this.drops(block, Items.GUNPOWDER, ConstantLootNumberProvider.create(2.0F)));
        this.addDrop(NETHER_STAR_BLOCK, (block) -> dropsWithSilkTouch(block, this.applyExplosionDecay(block, ItemEntry.builder(Items.NETHER_STAR).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0F, 9.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2)).apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(8, 9))))));
        this.addDrop(RAINBOW_GLOWSTONE, (block) -> glowstoneDrops(block).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).conditionally(WITHOUT_SILK_TOUCH).with((this.applyExplosionDecay(block, ItemEntry.builder(BlockusItems.RAINBOW_PETAL).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))).apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))).apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(1, 4)))))));

        this.addDrop(COOKIE_BLOCK, (block) -> LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(this.applyExplosionDecay(block,
            ItemEntry.builder(Items.COOKIE).apply(setCookieCount(block, 9.0F, 0))
                .apply(setCookieCount(block, 8.0F, 1))
                .apply(setCookieCount(block, 7.0F, 2))
                .apply(setCookieCount(block, 6.0F, 3))
                .apply(setCookieCount(block, 5.0F, 4))
                .apply(setCookieCount(block, 4.0F, 5))
                .apply(setCookieCount(block, 3.0F, 6))
                .apply(setCookieCount(block, 2.0F, 7))
                .apply(setCookieCount(block, 1.0F, 8))))));
    }


    public void addDrops(Block... blocks) {
        for (Block block : blocks) this.addDrop(block);
    }

    public void addDrops(Function<Block, LootTable.Builder> lootTableFunction, Block... blocks) {
        for (Block block : blocks) this.addDrop(block, lootTableFunction.apply(block));
    }

    public void addDropsWithSilkTouch(Block... blocks) {
        for (Block block : blocks) this.addDropWithSilkTouch(block);
    }

    public void addPottedPlantDropsBatch(Block... blocks) {
        for (Block block : blocks) this.addPottedPlantDrops(block);
    }

    public void addBlockStairsandSlabDrops(Block block, Block stairs, Block slab) {
        this.addDrops(block, stairs);
        this.addDrop(slab, this::slabDrops);
    }

    public void addWoodSetDrop(Block planks, Block stairs, Block slab, Block fence, Block fence_gate, Block door, Block trapdoor, Block pressure_plate, Block button, Block standing_sign, Block ceiling_hanging_sign) {
        this.addBlockStairsandSlabDrops(planks, stairs, slab);
        this.addDrops(fence, fence_gate, trapdoor, pressure_plate, button, standing_sign, ceiling_hanging_sign);
        this.addDrop(door, this::doorDrops);
    }

    public LootFunction.Builder setCookieCount(Block block, float count, int bites) {
        return SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)).conditionally(BlockStatePropertyLootCondition.builder(block).properties(net.minecraft.predicate.StatePredicate.Builder.create().exactMatch(CookieBlock.BITES, bites)));
    }

    public LootTable.Builder glowstoneDrops(Block block) {
        return dropsWithSilkTouch(block, this.applyExplosionDecay(block, ItemEntry.builder(Items.GLOWSTONE_DUST).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)).apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(1, 4)))));
    }

    public LootTable.Builder stickDrops(Block block) {
        return dropsWithSilkTouchOrShears(block, addSurvivesExplosionCondition(block, ItemEntry.builder(Items.STICK)));
    }

    public LootTable.Builder pottedLargePlantDrops(ItemConvertible plant) {
        return LootTable.builder().pool(addSurvivesExplosionCondition(LARGE_FLOWER_POT, LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(LARGE_FLOWER_POT)))).pool(addSurvivesExplosionCondition(plant, LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(plant))));
    }

    public void addPottedLargePlantDrop(Block block) {
        this.addDrop(block, (flowerPot) -> this.pottedLargePlantDrops(((LargeFlowerPotBlock) flowerPot).getContent()));
    }
}
