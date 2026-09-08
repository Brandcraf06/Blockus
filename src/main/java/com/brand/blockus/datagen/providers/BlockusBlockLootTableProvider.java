package com.brand.blockus.datagen.providers;

import com.brand.blockus.blocks.base.CookieBlock;
import com.brand.blockus.blocks.base.LargeFlowerPotBlock;
import com.brand.blockus.registry.content.bundles.*;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.storage.loot.IntLimit;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusBlockLootTableProvider extends FabricBlockLootSubProvider {

    public BlockusBlockLootTableProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {

        for (BSSWBundle bundle : BSSWBundle.values()) {
            this.addBlockStairsandSlabDrops(bundle.block(), bundle.stairs(), bundle.slab());
            if (bundle.wall() != null) {
                this.dropSelf(bundle.wall());
            }
        }

        for (DyedBSSWBundle bundle : DyedBSSWBundle.values()) {
            for (DyeColor color : DyeColor.values()) {
                this.addBlockStairsandSlabDrops(bundle.block().blocks().pick(color), bundle.stairs().blocks().pick(color), bundle.slab().blocks().pick(color));
                if (bundle.wall() != null) {
                    this.dropSelf(bundle.wall().blocks().pick(color));
                }
            }
        }

        for (CopperBSSWBundle bundle : CopperBSSWBundle.values()) {
            bundle.block().blocks().forEach(this::dropSelf);
            bundle.stairs().blocks().forEach(this::dropSelf);
            bundle.slab().blocks().forEach((block) -> this.add(block, this::createSlabItemTable));
            bundle.wall().blocks().forEach(this::dropSelf);
        }

        for (ConcreteBundle bundle : ConcreteBundle.values()) {
            for (DyeColor color : DyeColor.values()) {
                this.addBlockStairsandSlabDrops(bundle.block().blocks().pick(color), bundle.stairs().blocks().pick(color), bundle.slab().blocks().pick(color));
                this.addDrops(bundle.wall().blocks().pick(color), bundle.chiseled().blocks().pick(color), bundle.pillar().blocks().pick(color));
            }
        }

        for (AsphaltBundle bundle : AsphaltBundle.values()) {
            for (DyeColor color : DyeColor.values()) {
                this.addBlockStairsandSlabDrops(bundle.block().blocks().pick(color), bundle.stairs().blocks().pick(color), bundle.slab().blocks().pick(color));
            }
        }

        for (WoodBundle bundle : WoodBundle.values()) {
            this.addWoodSetDrop(bundle.planks(),
                bundle.stairs(),
                bundle.slab(),
                bundle.fence(),
                bundle.fenceGate(),
                bundle.door(),
                bundle.trapdoor(),
                bundle.pressurePlate(),
                bundle.button(),
                bundle.shelf(),
                bundle.standingSign(),
                bundle.ceilingHangingSign());
        }

        for (TimberFrameBundle bundle : TimberFrameBundle.values()) {
            for (Block block : bundle.all()) {
                this.addDrops(block);
            }
        }

        for (PottedLargeBundle bundle : PottedLargeBundle.values()) {
            this.addPottedLargePlantDrop(bundle.block());
        }

        for (WoolBundle bundle : WoolBundle.values()) {
            for (DyeColor color : DyeColor.values()) {
                this.addBlockStairsandSlabDrops(bundle.block().blocks().pick(color), bundle.stairs().blocks().pick(color), bundle.slab().blocks().pick(color));
                this.dropSelf(bundle.carpet().blocks().pick(color));
            }
        }

        for (ColoredTilesBundle bundle : ColoredTilesBundle.values()) {
            this.dropSelf(bundle.block());
        }

        for (WoodenPostBundle bundle : WoodenPostBundle.values()) {
            for (Block block : bundle.all()) {
                this.addDrops(block);
            }
        }

        for (ColorCollection<Block> blocks : List.of(NEON.blocks(), FUTURNEO_BLOCK.blocks(), GLAZED_TERRACOTTA_PILLAR.blocks(), DYED_REDSTONE_LAMP.blocks(), DYED_LIT_REDSTONE_LAMP.blocks(), COLORED_TILES.blocks())) {
            blocks.forEach(this::dropSelf);
        }

        for (ExtraWoodBundle<Block> bundle : List.of(HERRINGBONE_PLANKS, SMALL_LOGS)) {
            bundle.bundle().values().forEach(this::addDrops);
        }

        COPPER_LANTERN_BLOCK.blocks().forEach(this::dropSelf);
        COPPER_GATE.blocks().forEach((block) -> this.add(block, this::createDoorTable));

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

            // Sulfur
            HERRINGBONE_SULFUR_BRICKS,
            SULFUR_CIRCULAR_PAVING,
            SULFUR_PILLAR,
            POLISHED_SULFUR_PRESSURE_PLATE,
            POLISHED_SULFUR_BUTTON,

            // Cinnabar
            HERRINGBONE_CINNABAR_BRICKS,
            CINNABAR_CIRCULAR_PAVING,
            CINNABAR_PILLAR,
            POLISHED_CINNABAR_PRESSURE_PLATE,
            POLISHED_CINNABAR_BUTTON,

            // Wool
            RAINBOW_CARPET,

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
            COPPER_JACK_O_LANTERN,
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
            LIMESTONE_LINES,
            LOVE_BLOCK,
            MARBLE_BUTTON,
            MARBLE_CIRCULAR_PAVING,
            MARBLE_PILLAR,
            MARBLE_PRESSURE_PLATE,
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
            LIT_RAINBOW_LAMP,
            RAINBOW_NEON,
            RED_NETHER_BRICK_PILLAR,
            RED_SANDSTONE_PILLAR,
            LIT_REDSTONE_LAMP,
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
            CHOCOLATE_TABLET);

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
            PALE_OAK_HEDGE,
            RED_POPLAR_HEDGE,
            ORANGE_POPLAR_HEDGE,
            YELLOW_POPLAR_HEDGE,
            WHITE_OAK_HEDGE);

        this.addDropsWithSilkTouch(
            BEVELED_GLASS,
            BEVELED_GLASS_PANE,
            ICE_BRICK_WALL,
            ICE_BRICKS,
            ICE_PILLAR);

        for (ColorCollection<Block> blocks : List.of(STAINED_BEVELED_GLASS.blocks(), STAINED_BEVELED_GLASS_PANE.blocks())) {
            blocks.forEach(this::dropWhenSilkTouch);
        }

        this.add(RAINBOW_PETALS, this.createSegmentedBlockDrops(RAINBOW_PETALS));
        this.add(RAINBOW_BED, this.createSinglePropConditionTable(RAINBOW_BED, BedBlock.PART, BedPart.HEAD));

        this.addPottedPlantDropsBatch(POTTED_WHITE_OAK_SAPLING, POTTED_RAINBOW_ROSE, POTTED_LEGACY_SAPLING, POTTED_LEGACY_ROSE, POTTED_LEGACY_BLUE_ROSE);

        this.add(LEGACY_LEAVES, (block) -> this.createLeavesDrops(block, LEGACY_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(LEGACY_GLOWSTONE, this::glowstoneDrops);
        this.add(LEGACY_GRAVEL, (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.FLINT).when(BonusLevelTableCondition.bonusLevelFlatChance(enchantments.getOrThrow(Enchantments.FORTUNE), 0.1F, 0.14285715F, 0.25F, 1.0F)).otherwise(LootItem.lootTableItem(block)))));
        this.add(LEGACY_NETHER_REACTOR_CORE, (block) -> LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ContextIntProviders.exactly(3)).add(LootItem.lootTableItem(Items.DIAMOND)))).withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ContextIntProviders.exactly(6)).add(LootItem.lootTableItem(Items.IRON_INGOT)))));

        this.add(WHITE_OAK_LEAVES, (block) -> this.createOakLeavesDrops(block, WHITE_OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BLAZE_LANTERN, (block) -> this.createSingleItemTableWithSilkTouch(block, Items.BLAZE_POWDER, ContextIntProviders.exactly(9)));
        this.add(BURNT_PAPER_BLOCK, (block) -> this.createSingleItemTableWithSilkTouch(block, Items.GUNPOWDER, ContextIntProviders.exactly(2)));
        this.add(NETHER_STAR_BLOCK, (block) -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.NETHER_STAR).apply(SetItemCountFunction.setCount(ContextIntProviders.between(8, 9))).apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE), 2)).apply(LimitCount.limitCount(IntLimit.range(8, 9))))));
        this.add(RAINBOW_GLOWSTONE, this::glowstoneDrops);

        this.add(COOKIE_BLOCK, (block) -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(1)).add(this.applyExplosionDecay(block,
            LootItem.lootTableItem(Items.COOKIE).apply(setCookieCount(block, 9, 0))
                .apply(setCookieCount(block, 8, 1))
                .apply(setCookieCount(block, 7, 2))
                .apply(setCookieCount(block, 6, 3))
                .apply(setCookieCount(block, 5, 4))
                .apply(setCookieCount(block, 4, 5))
                .apply(setCookieCount(block, 3, 6))
                .apply(setCookieCount(block, 2, 7))
                .apply(setCookieCount(block, 1, 8))))));
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

    public void addWoodSetDrop(Block planks, Block stairs, Block slab, Block fence, Block fence_gate, Block door, Block trapdoor, Block pressure_plate, Block button, Block shelf, Block standing_sign, Block ceiling_hanging_sign) {
        this.addBlockStairsandSlabDrops(planks, stairs, slab);
        this.addDrops(fence, fence_gate, trapdoor, pressure_plate, button, shelf, standing_sign, ceiling_hanging_sign);
        this.add(door, this::createDoorTable);
    }

    public LootItemFunction.Builder setCookieCount(Block block, int count, int bites) {
        return SetItemCountFunction.setCount(ContextIntProviders.exactly(count)).when(MatchBlock.blockMatches(this.blocks, block, StatePropertiesPredicate.Builder.properties().hasProperty(CookieBlock.BITES, bites)));
    }

    public LootTable.Builder glowstoneDrops(Block block) {
        return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.GLOWSTONE_DUST).apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4))).apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))).apply(LimitCount.limitCount(IntLimit.range(1, 4)))));
    }

    public LootTable.Builder stickDrops(Block block) {
        return createSilkTouchOrShearsDispatchTable(block, (LootPoolEntryContainer.Builder)((UniformContainerBase.Builder)this.applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2))))).when(BonusLevelTableCondition.bonusLevelFlatChance(enchantments.getOrThrow(Enchantments.FORTUNE), 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F)));
    }

    public LootTable.Builder pottedLargePlantDrops(ItemLike plant) {
        return LootTable.lootTable().withPool(applyExplosionCondition(LARGE_FLOWER_POT, LootPool.lootPool().setRolls(ContextIntProviders.exactly(1)).add(LootItem.lootTableItem(LARGE_FLOWER_POT)))).withPool(applyExplosionCondition(plant, LootPool.lootPool().setRolls(ContextIntProviders.exactly(1)).add(LootItem.lootTableItem(plant))));
    }

    public void addPottedLargePlantDrop(Block block) {
        this.add(block, (flowerPot) -> this.pottedLargePlantDrops(((LargeFlowerPotBlock) flowerPot).getPotted()));
    }
}
