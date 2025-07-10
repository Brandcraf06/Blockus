package com.brand.blockus.datagen.providers;

import com.brand.blockus.blocks.base.CookieBlock;
import com.brand.blockus.blocks.base.LargeFlowerPotBlock;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
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
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusBlockLootTableProvider extends FabricBlockLootTableProvider {
    public final RegistryWrapper.WrapperLookup registryLookup;

    public BlockusBlockLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
        this.registryLookup = registryLookup.join();
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getOrThrow(RegistryKeys.ENCHANTMENT);

        for (BSSWBundle bsswType : BSSWBundle.values()) {
            this.addBlockStairsandSlabDrops(bsswType.block(), bsswType.stairs(), bsswType.slab());
            if (bsswType.wall() != null) {
                this.addDrop(bsswType.wall());
            }
        }

        for (CopperBundle copper : CopperBundle.values()) {
            this.addBlockStairsandSlabDrops(copper.block(), copper.stairs(), copper.slab());
            this.addBlockStairsandSlabDrops(copper.blockWaxed(), copper.stairsWaxed(), copper.slabWaxed());
            this.addDrop(copper.wall());
            this.addDrop(copper.wallWaxed());
        }

        for (ConcreteBundle concrete : ConcreteBundle.values()) {
            for (ConcreteBundle.ConcreteVariants variants : concrete.colorMap().values()) {
                this.addBlockStairsandSlabDrops(variants.block(), variants.stairs(), variants.slab());
                this.addDrops(variants.wall(), variants.chiseled(), variants.pillar());
            }
        }

        for (WoodBundle woodBundle : WoodBundle.values()) {
            this.addWoodSetDrop(woodBundle.planks(),
                woodBundle.stairs(),
                woodBundle.slab(),
                woodBundle.fence(),
                woodBundle.fenceGate(),
                woodBundle.door(),
                woodBundle.trapdoor(),
                woodBundle.pressurePlate(),
                woodBundle.button(),
                woodBundle.standingSign(),
                woodBundle.ceilingHangingSign());
        }

        for (TimberFrameBundle timberFrameBundle : TimberFrameBundle.values()) {
            for (Block block : timberFrameBundle.all()) {
                this.addDrops(block);
            }
        }

        for (var asphaltBundle : BlockusBlocks.ASPHALT.colorMap().values()) {
            this.addBlockStairsandSlabDrops(asphaltBundle.block(), asphaltBundle.stairs(), asphaltBundle.slab());
        }

        for (PottedLargeBundle pottedLargeBundle : PottedLargeBundle.values()) {
            this.addPottedLargePlantDrop(pottedLargeBundle.block());
        }

        for (WoolBundle woolBundle : WoolBundle.values()) {
            for (var variants : woolBundle.colorMap().values()) {
                this.addBlockStairsandSlabDrops(variants.block(), variants.stairs(), variants.slab());
                this.addDrop(variants.carpet());
            }
        }

        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            this.addDrop(coloredTilesVariants.block());
        }

        for (WoodenPostBundle woodenPost : WoodenPostBundle.values()) {
            for (Block block : woodenPost.all()) {
                this.addDrops(block);
            }
        }

        for (StainedBlockBundle stainedBlockBundle : List.of(NEON_BLOCK, FUTURNEO_BLOCK, GLAZED_TERRACOTTA_PILLAR, STAINED_REDSTONE_LAMP, STAINED_REDSTONE_LAMP_LIT, COLORED_TILES)) {
            stainedBlockBundle.colorMap().values().forEach(this::addDrops);
        }

        for (ExtraWoodBundle<Block> extraWoodBundle : List.of(HERRINGBONE_PLANKS, SMALL_LOGS)) {
            extraWoodBundle.bundle().values().forEach(this::addDrops);
        }



        this.addDrops(CHISELED_MUD_BRICKS,
            MUD_BRICK_PILLAR,

            // Viridite
            CHISELED_VIRIDITE,
            CHISELED_VIRIDITE_PILLAR,
            CHISELED_VIRIDITE_BRICKS,
            VIRIDITE_BUTTON,
            VIRIDITE_CIRCULAR_PAVING,
            VIRIDITE_PILLAR,
            VIRIDITE_PRESSURE_PLATE,
            VIRIDITE_SQUARES,
            VIRIDITE_LINES,

            // Amethyst
            CHISELED_AMETHYST,
            AMETHYST_PILLAR,
            AMETHYST_LAMP,
            AMETHYST_LANTERN,
            AMETHYST_LANTERN_BLOCK,

            // Sculk
            CHISELED_SCULK_BRICKS,
            POLISHED_SCULK_BUTTON,
            SCULK_PILLAR,
            POLISHED_SCULK_PRESSURE_PLATE,

            // Other
            LEGACY_LOG,
            LEGACY_SAPLING,
            ANDESITE_CIRCULAR_PAVING,
            APPLE_CRATE,
            BEETROOT_CRATE,
            BLACKSTONE_TRAPDOOR,
            BLAZE_PILLAR,
            BLUESTONE_BUTTON,
            BLUESTONE_CIRCULAR_PAVING,
            BLUESTONE_LINES,
            BLUESTONE_PILLAR,
            BLUESTONE_PRESSURE_PLATE,
            BLUESTONE_SQUARES,
            BREAD_BOX,
            CARROT_CRATE,
            CAUTION_BARRIER,
            CAUTION_BLOCK,
            CARVED_TUFF_BRICKS,
            CHARCOAL_BLOCK,
            CHARRED_NETHER_BRICK_PILLAR,
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
            CHISELED_MARBLE_BRICKS,
            CHISELED_LIMESTONE_PILLAR,
            CHISELED_LIMESTONE_BRICKS,
            CHISELED_BLUESTONE_PILLAR,
            CHISELED_BLUESTONE_BRICKS,
            CHISELED_PHANTOM_PURPUR,
            CHISELED_POLISHED_BASALT,
            CHISELED_PRISMARINE,
            CHISELED_PURPUR,
            CHISELED_SOUL_SANDSTONE,
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
            CRIMSON_HEDGE,
            CUT_SOUL_SANDSTONE,
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
            LEGACY_ROSE,
            LEGACY_BLUE_ROSE,
            LIMESTONE_BUTTON,
            LIMESTONE_CIRCULAR_PAVING,
            LIMESTONE_PILLAR,
            LIMESTONE_PRESSURE_PLATE,
            LIMESTONE_SQUARES,
            LIMESTONE_LINES,
            LOVE_BLOCK,
            MARBLE_BUTTON,
            MARBLE_CIRCULAR_PAVING,
            MARBLE_PILLAR,
            MARBLE_PRESSURE_PLATE,
            MARBLE_SQUARES,
            MARBLE_LINES,
            MEMBRANE_BLOCK,
            MOSS_HEDGE,
            NETHER_BRICK_PILLAR,
            NETHERITE_STAIRS,
            NETHERRACK_CIRCULAR_PAVING,
            OBSIDIAN_CIRCULAR_PAVING,
            OBSIDIAN_PILLAR,
            OBSIDIAN_PRESSURE_PLATE,
            OBSIDIAN_REINFORCED_TRAPDOOR,
            PALE_MOSS_HEDGE,
            PAPER_BLOCK,
            PAPER_LAMP,
            PAPER_TRAPDOOR,
            PAPER_WALL,
            PATH,
            PHANTOM_PURPUR_DECORATED_END_STONE,
            PHANTOM_PURPUR_LINES,
            PHANTOM_PURPUR_PILLAR,
            PHANTOM_PURPUR_SQUARES,
            POLISHED_ANDESITE_BUTTON,
            POLISHED_ANDESITE_PILLAR,
            POLISHED_ANDESITE_PRESSURE_PLATE,
            POLISHED_BASALT_BUTTON,
            POLISHED_BASALT_CIRCULAR_PAVING,
            POLISHED_BASALT_PILLAR,
            POLISHED_BASALT_PRESSURE_PLATE,
            POLISHED_BLACKSTONE_CIRCULAR_PAVING,
            POLISHED_BLACKSTONE_PILLAR,
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
            POLISHED_NETHERRACK_BUTTON,
            POLISHED_NETHERRACK_PRESSURE_PLATE,
            POLISHED_TUFF_BUTTON,
            POLISHED_TUFF_PRESSURE_PLATE,
            POTATO_CRATE,
            PRISMARINE_CIRCULAR_PAVING,
            PRISMARINE_PILLAR,
            PUFFERFISH_CRATE,
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
            RAINBOW_NEON,
            RED_NETHER_BRICK_PILLAR,
            RED_SANDSTONE_PILLAR,
            REDSTONE_LAMP_LIT,
            REDSTONE_LANTERN,
            REDSTONE_LANTERN_BLOCK,
            REDSTONE_SAND,
            RESIN_BRICK_PILLAR,
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
            WARPED_HEDGE,
            WEIGHT_STORAGE_CUBE,
            WHITE_OAK_LOG,
            WHITE_OAK_SAPLING,
            WHITE_OAK_WOOD,
            HERRINGBONE_ANDESITE_BRICKS,
            HERRINGBONE_BRICKS,
            HERRINGBONE_RESIN_BRICKS,
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
            ACACIA_HEDGE,
            AZALEA_HEDGE,
            FLOWERING_AZALEA_HEDGE,
            BIRCH_HEDGE,
            DARK_OAK_HEDGE,
            JUNGLE_HEDGE,
            OAK_HEDGE,
            SPRUCE_HEDGE,
            MANGROVE_HEDGE,
            CHERRY_HEDGE,
            PALE_OAK_HEDGE,
            WHITE_OAK_HEDGE);

        this.addDropsWithSilkTouch(
            BEVELED_GLASS,
            BEVELED_GLASS_PANE,
            ICE_BRICK_WALL,
            ICE_BRICKS,
            ICE_PILLAR);

        for (StainedBlockBundle bundle : List.of(STAINED_BEVELED_GLASS, STAINED_BEVELED_GLASS_PANE)) {
            bundle.colorMap().values().forEach(this::addDropsWithSilkTouch);
        }

        this.addDrop(RAINBOW_PETALS, this.segmentedDrops(RAINBOW_PETALS));
        this.addPottedPlantDropsBatch(POTTED_WHITE_OAK_SAPLING, POTTED_RAINBOW_ROSE, POTTED_LEGACY_SAPLING, POTTED_LEGACY_ROSE, POTTED_LEGACY_BLUE_ROSE);

        this.addDrop(LEGACY_LEAVES, (block) -> this.leavesDrops(block, LEGACY_SAPLING, SAPLING_DROP_CHANCE));
        this.addDrop(LEGACY_GLOWSTONE, this::glowstoneDrops);
        this.addDrop(LEGACY_GRAVEL, (block) -> dropsWithSilkTouch(block, this.addSurvivesExplosionCondition(block, ItemEntry.builder(Items.FLINT).conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), 0.1F, 0.14285715F, 0.25F, 1.0F)).alternatively(ItemEntry.builder(block)))));
        this.addDrop(LEGACY_NETHER_REACTOR_CORE, (block) -> LootTable.builder().pool(this.addSurvivesExplosionCondition(block, LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F)).with(ItemEntry.builder(Items.DIAMOND)))).pool(this.addSurvivesExplosionCondition(block, LootPool.builder().rolls(ConstantLootNumberProvider.create(6.0F)).with(ItemEntry.builder(Items.IRON_INGOT)))));

        this.addDrop(WHITE_OAK_LEAVES, (block) -> this.oakLeavesDrops(block, WHITE_OAK_SAPLING, SAPLING_DROP_CHANCE));
        this.addDrop(BLAZE_LANTERN, (block) -> this.drops(block, Items.BLAZE_POWDER, ConstantLootNumberProvider.create(9.0F)));
        this.addDrop(BURNT_PAPER_BLOCK, (block) -> this.drops(block, Items.GUNPOWDER, ConstantLootNumberProvider.create(2.0F)));
        this.addDrop(NETHER_STAR_BLOCK, (block) -> dropsWithSilkTouch(block, this.applyExplosionDecay(block, ItemEntry.builder(Items.NETHER_STAR).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0F, 9.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 2)).apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(8, 9))))));
        this.addDrop(RAINBOW_GLOWSTONE, this::glowstoneDrops);

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
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getOrThrow(RegistryKeys.ENCHANTMENT);
        return dropsWithSilkTouch(block, this.applyExplosionDecay(block, ItemEntry.builder(Items.GLOWSTONE_DUST).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))).apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(1, 4)))));
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
