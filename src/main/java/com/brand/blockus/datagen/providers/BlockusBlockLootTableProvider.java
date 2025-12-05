package com.brand.blockus.datagen.providers;

import com.brand.blockus.blocks.base.CookieBlock;
import com.brand.blockus.blocks.base.LargeFlowerPotBlock;
import com.brand.blockus.registry.content.BlockusBlocks;
import com.brand.blockus.registry.content.bundles.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusBlockLootTableProvider extends FabricBlockLootTableProvider {
    public final HolderLookup.Provider registryLookup;

    public BlockusBlockLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
        this.registryLookup = registryLookup.join();
    }

    @Override
    public void generate() {
        HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        for (BSSWBundle bsswType : BSSWBundle.values()) {
            this.addBlockStairsandSlabDrops(bsswType.block(), bsswType.stairs(), bsswType.slab());
            if (bsswType.wall() != null) {
                this.dropSelf(bsswType.wall());
            }
        }

        for (CopperBundle copper : CopperBundle.values()) {
            this.addBlockStairsandSlabDrops(copper.block(), copper.stairs(), copper.slab());
            this.addBlockStairsandSlabDrops(copper.blockWaxed(), copper.stairsWaxed(), copper.slabWaxed());
            this.dropSelf(copper.wall());
            this.dropSelf(copper.wallWaxed());
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
                this.dropSelf(variants.carpet());
            }
        }

        for (ColoredTilesBundle coloredTilesVariants : ColoredTilesBundle.values()) {
            this.dropSelf(coloredTilesVariants.block());
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

        this.addDrops(this::createSlabItemTable, CUT_SOUL_SANDSTONE_SLAB, NETHERITE_SLAB);
        this.addDrops(this::createDoorTable, BLACKSTONE_DOOR, GOLDEN_GATE, IRON_GATE, OBSIDIAN_REINFORCED_DOOR, PAPER_DOOR, STONE_DOOR);
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

        this.add(RAINBOW_PETALS, this.createPetalsDrops(RAINBOW_PETALS));
        this.addPottedPlantDropsBatch(POTTED_WHITE_OAK_SAPLING, POTTED_RAINBOW_ROSE, POTTED_LEGACY_SAPLING, POTTED_LEGACY_ROSE, POTTED_LEGACY_BLUE_ROSE);

        this.add(LEGACY_LEAVES, (block) -> this.createLeavesDrops(block, LEGACY_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(LEGACY_GLOWSTONE, this::glowstoneDrops);
        this.add(LEGACY_GRAVEL, (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.FLINT).when(BonusLevelTableCondition.bonusLevelFlatChance(impl.getOrThrow(Enchantments.FORTUNE), 0.1F, 0.14285715F, 0.25F, 1.0F)).otherwise(LootItem.lootTableItem(block)))));
        this.add(LEGACY_NETHER_REACTOR_CORE, (block) -> LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F)).add(LootItem.lootTableItem(Items.DIAMOND)))).withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(6.0F)).add(LootItem.lootTableItem(Items.IRON_INGOT)))));

        this.add(WHITE_OAK_LEAVES, (block) -> this.createOakLeavesDrops(block, WHITE_OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BLAZE_LANTERN, (block) -> this.createSingleItemTableWithSilkTouch(block, Items.BLAZE_POWDER, ConstantValue.exactly(9.0F)));
        this.add(BURNT_PAPER_BLOCK, (block) -> this.createSingleItemTableWithSilkTouch(block, Items.GUNPOWDER, ConstantValue.exactly(2.0F)));
        this.add(NETHER_STAR_BLOCK, (block) -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.NETHER_STAR).apply(SetItemCountFunction.setCount(UniformGenerator.between(8.0F, 9.0F))).apply(ApplyBonusCount.addUniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 2)).apply(LimitCount.limitCount(IntRange.range(8, 9))))));
        this.add(RAINBOW_GLOWSTONE, this::glowstoneDrops);

        this.add(COOKIE_BLOCK, (block) -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(this.applyExplosionDecay(block,
            LootItem.lootTableItem(Items.COOKIE).apply(setCookieCount(block, 9.0F, 0))
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
        for (Block block : blocks) this.dropSelf(block);
    }

    public void addDrops(Function<Block, LootTable.Builder> lootTableFunction, Block... blocks) {
        for (Block block : blocks) this.add(block, lootTableFunction.apply(block));
    }

    public void addDropsWithSilkTouch(Block... blocks) {
        for (Block block : blocks) this.dropWhenSilkTouch(block);
    }

    public void addPottedPlantDropsBatch(Block... blocks) {
        for (Block block : blocks) this.dropPottedContents(block);
    }

    public void addBlockStairsandSlabDrops(Block block, Block stairs, Block slab) {
        this.addDrops(block, stairs);
        this.add(slab, this::createSlabItemTable);
    }

    public void addWoodSetDrop(Block planks, Block stairs, Block slab, Block fence, Block fence_gate, Block door, Block trapdoor, Block pressure_plate, Block button, Block standing_sign, Block ceiling_hanging_sign) {
        this.addBlockStairsandSlabDrops(planks, stairs, slab);
        this.addDrops(fence, fence_gate, trapdoor, pressure_plate, button, standing_sign, ceiling_hanging_sign);
        this.add(door, this::createDoorTable);
    }

    public LootItemFunction.Builder setCookieCount(Block block, float count, int bites) {
        return SetItemCountFunction.setCount(ConstantValue.exactly(count)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(CookieBlock.BITES, bites)));
    }

    public LootTable.Builder glowstoneDrops(Block block) {
        HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.GLOWSTONE_DUST).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))).apply(ApplyBonusCount.addUniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))).apply(LimitCount.limitCount(IntRange.range(1, 4)))));
    }

    public LootTable.Builder stickDrops(Block block) {
        return createSilkTouchOrShearsDispatchTable(block, applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK)));
    }

    public LootTable.Builder pottedLargePlantDrops(ItemLike plant) {
        return LootTable.lootTable().withPool(applyExplosionCondition(LARGE_FLOWER_POT, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(LARGE_FLOWER_POT)))).withPool(applyExplosionCondition(plant, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(plant))));
    }

    public void addPottedLargePlantDrop(Block block) {
        this.add(block, (flowerPot) -> this.pottedLargePlantDrops(((LargeFlowerPotBlock) flowerPot).getContent()));
    }
}
