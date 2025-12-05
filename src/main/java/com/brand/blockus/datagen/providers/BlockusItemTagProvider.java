package com.brand.blockus.datagen.providers;

import com.brand.blockus.registry.content.BlockusEntities;
import com.brand.blockus.registry.tag.BlockusBlockTags;
import com.brand.blockus.registry.tag.BlockusItemTags;
import com.brand.blockus.utils.helper.BlockOrder;
import com.brand.blockus.utils.helper.WoodMaps;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static com.brand.blockus.registry.content.BlockusBlocks.*;

public class BlockusItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public BlockusItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, BlockTagProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    private void copy(ResourceLocation id) {
        TagKey<Block> blockTag = TagKey.create(Registries.BLOCK, id);
        TagKey<Item> itemTag = TagKey.create(Registries.ITEM, id);

        this.copy(blockTag, itemTag);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        this.copy(BlockusBlockTags.BARRIERS, BlockusItemTags.BARRIERS);

        this.getOrCreateTagBuilder(ItemTags.BOATS)
            .add(BlockusEntities.RAW_BAMBOO_RAFT.getItem())
            .add(BlockusEntities.CHARRED_BOAT.getItem())
            .add(BlockusEntities.WHITE_OAK_BOAT.getItem());

        this.getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
            .add(BlockusEntities.RAW_BAMBOO_RAFT.getChestItem())
            .add(BlockusEntities.CHARRED_BOAT.getChestItem())
            .add(BlockusEntities.WHITE_OAK_BOAT.getChestItem());

        this.getOrCreateTagBuilder(ItemTags.SIGNS)
            .add(RAW_BAMBOO.sign())
            .add(CHARRED.sign())
            .add(WHITE_OAK.sign());

        this.copy(BlockTags.STONE_BUTTONS, ItemTags.STONE_BUTTONS);

        this.getOrCreateTagBuilder(ItemTags.HANGING_SIGNS)
            .add(RAW_BAMBOO.hangingSign())
            .add(CHARRED.hangingSign())
            .add(WHITE_OAK.hangingSign());

        this.copy(BlockusBlockTags.PATTERNED_WOOL, BlockusItemTags.PATTERNED_WOOL);
        this.copy(BlockusBlockTags.PATTERNED_CARPETS, BlockusItemTags.PATTERNED_CARPETS);
        this.copy(BlockusBlockTags.ALL_PATTERNED_WOOLS, BlockusItemTags.ALL_PATTERNED_WOOLS);

        this.copy(BlockusBlockTags.HEDGES, BlockusItemTags.HEDGES);

        this.copy(BlockusBlockTags.SOUL_SOILS, BlockusItemTags.SOUL_SOILS);

        this.getOrCreateTagBuilder(BlockusItemTags.STAINED_STONE_BRICKS)
            .add(Items.STONE_BRICKS);
        for (DyeColor color : BlockOrder.COLOR) {
            getOrCreateTagBuilder(BlockusItemTags.STAINED_STONE_BRICKS).add(STAINED_STONE_BRICKS.colorMap().get(color).block().asItem());
        }

        this.copy(BlockusBlockTags.WARPED_NETHER_GRASS, BlockusItemTags.WARPED_NETHER_GRASS);

        this.copy(BlockusBlockTags.WHITE_OAK_LOGS, BlockusItemTags.WHITE_OAK_LOGS);

        this.getOrCreateTagBuilder(BlockusItemTags.PLANKS_THAT_BURN)
            .add(Items.OAK_PLANKS)
            .add(Items.SPRUCE_PLANKS)
            .add(Items.BIRCH_PLANKS)
            .add(Items.JUNGLE_PLANKS)
            .add(Items.ACACIA_PLANKS)
            .add(Items.DARK_OAK_PLANKS)
            .add(Items.MANGROVE_PLANKS)
            .add(Items.CHERRY_PLANKS)
            .add(Items.BAMBOO_PLANKS)
            .add(RAW_BAMBOO.planks().asItem())
            .add(WHITE_OAK.planks().asItem())
            .add(LEGACY_PLANKS.asItem());

        this.getOrCreateTagBuilder(BlockusItemTags.WOODEN_MOSAIC_THAT_BURN)
            .add(Blocks.BAMBOO_MOSAIC.asItem());
        for (var wood : WoodMaps.values()) {
            if (!wood.data().isBurnable()) continue;
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                this.getOrCreateTagBuilder(BlockusItemTags.HERRINGBONE_PLANKS_THAT_BURN).add(herringbonePlanks.asItem());
            }
            var woodMosaic = WOODEN_MOSAIC.bundle().get(wood.getId());
            if (woodMosaic != null) {
                this.getOrCreateTagBuilder(BlockusItemTags.WOODEN_MOSAIC_THAT_BURN).add(woodMosaic.block().asItem());
            }
        }

        this.copy(ResourceLocation.fromNamespaceAndPath("c", "planks_that_burn"));

        this.copy(BlockTags.ACACIA_LOGS, ItemTags.ACACIA_LOGS);

        this.copy(BlockTags.BIRCH_LOGS, ItemTags.BIRCH_LOGS);

        this.getOrCreateTagBuilder(ItemTags.BUTTONS)
            .add(POLISHED_ANDESITE_BUTTON.asItem())
            .add(POLISHED_DIORITE_BUTTON.asItem())
            .add(POLISHED_GRANITE_BUTTON.asItem())
            .add(LIMESTONE_BUTTON.asItem())
            .add(MARBLE_BUTTON.asItem())
            .add(BLUESTONE_BUTTON.asItem())
            .add(POLISHED_NETHERRACK_BUTTON.asItem())
            .add(POLISHED_END_STONE_BUTTON.asItem())
            .add(VIRIDITE_BUTTON.asItem());

        this.copy(BlockTags.CHERRY_LOGS, ItemTags.CHERRY_LOGS);

        this.copy(BlockTags.CRIMSON_STEMS, ItemTags.CRIMSON_STEMS);

        this.copy(BlockTags.DARK_OAK_LOGS, ItemTags.DARK_OAK_LOGS);

        this.copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);

        this.getOrCreateTagBuilder(ItemTags.DOORS)
            .add(PAPER_DOOR.asItem())
            .add(OBSIDIAN_REINFORCED_DOOR.asItem())
            .add(STONE_DOOR.asItem())
            .add(BLACKSTONE_DOOR.asItem());

        this.copy(BlockTags.FLOWERS, ItemTags.FLOWERS);

        this.getOrCreateTagBuilder(BlockusItemTags.NATURAL_ICE)
            .add(Items.ICE)
            .add(Items.PACKED_ICE)
            .add(Items.BLUE_ICE);

        this.copy(BlockTags.JUNGLE_LOGS, ItemTags.JUNGLE_LOGS);

        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);

        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

        this.copy(BlockTags.MANGROVE_LOGS, ItemTags.MANGROVE_LOGS);

        var nonFlammableWood = this.getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD);
        nonFlammableWood
            .add(CHARRED.planks().asItem())
            .add(CHARRED.slab().asItem())
            .add(CHARRED.pressurePlate().asItem())
            .add(CHARRED.fence().asItem())
            .add(CHARRED.trapdoor().asItem())
            .add(CHARRED.fenceGate().asItem())
            .add(CHARRED.stairs().asItem())
            .add(CHARRED.button().asItem())
            .add(CHARRED.door().asItem())
            .add(BlockusEntities.CHARRED_BOAT.getItem())
            .add(BlockusEntities.CHARRED_BOAT.getChestItem())
            .add(CHARRED.sign())
            .add(CHARRED.hangingSign())
            .add(SMALL_LOGS.get(WoodMaps.WARPED.getId()).asItem())
            .add(SMALL_LOGS.get(WoodMaps.CRIMSON.getId()).asItem());
        for (var wood : WoodMaps.values()) {
            if (wood.data().isBurnable()) continue;
            var woodMosaic = WOODEN_MOSAIC.bundle().get(wood.getId());
            if (woodMosaic != null) {
                nonFlammableWood.add(woodMosaic.block().asItem());
            }
            var mossyPlanks = MOSSY_PLANKS.bundle().get(wood.getId());
            if (mossyPlanks != null) {
                nonFlammableWood.add(mossyPlanks.block().asItem());
            }
            var herringbonePlanks = HERRINGBONE_PLANKS.bundle().get(wood.getId());
            if (herringbonePlanks != null) {
                nonFlammableWood.add(herringbonePlanks.asItem());
            }
        }

        this.copy(BlockTags.OAK_LOGS, ItemTags.OAK_LOGS);

        this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
            .add(LEGACY_GOLD_BLOCK.asItem())
            .add(LEGACY_EXPLOSION_PROOF_GOLD_BLOCK.asItem())
            .add(GOLDEN_CHAIN.asItem())
            .add(GOLDEN_BARS.asItem())
            .add(GOLDEN_GATE.asItem())
            .add(GOLD_DECORATED_SANDSTONE.asItem())
            .add(GOLD_DECORATED_RED_SANDSTONE.asItem())
            .add(GOLD_DECORATED_SOUL_SANDSTONE.asItem())
            .add(GOLD_DECORATED_POLISHED_BLACKSTONE.asItem())
            .add(GOLD_PLATING.block().asItem())
            .add(GOLD_PLATING.stairs().asItem())
            .add(GOLD_PLATING.slab().asItem())
            .add(GOLD_BRICKS.block().asItem())
            .add(GOLD_BRICKS.stairs().asItem())
            .add(GOLD_BRICKS.slab().asItem())
            .add(GOLD_BRICKS.wall().asItem())
            .add(GOLDEN_APPLE_CRATE.asItem())
            .add(GOLDEN_CARROT_CRATE.asItem());

        this.copy(BlockTags.PIGLIN_REPELLENTS, ItemTags.PIGLIN_REPELLENTS);

        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);

        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

        this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

        this.copy(BlockTags.SPRUCE_LOGS, ItemTags.SPRUCE_LOGS);

        this.getOrCreateTagBuilder(ItemTags.TRAPDOORS)
            .add(PAPER_TRAPDOOR.asItem())
            .add(OBSIDIAN_REINFORCED_TRAPDOOR.asItem())
            .add(STONE_TRAPDOOR.asItem())
            .add(BLACKSTONE_TRAPDOOR.asItem());

        this.copy(BlockTags.STAIRS, ItemTags.STAIRS);

        this.copy(BlockTags.SLABS, ItemTags.SLABS);

        this.copy(BlockTags.WALLS, ItemTags.WALLS);

        this.copy(BlockTags.WARPED_STEMS, ItemTags.WARPED_STEMS);

        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
            .add(RAW_BAMBOO.door().asItem())
            .add(CHARRED.door().asItem())
            .add(WHITE_OAK.door().asItem());

        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

        this.getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
            .add(RAW_BAMBOO.trapdoor().asItem())
            .add(CHARRED.trapdoor().asItem())
            .add(WHITE_OAK.trapdoor().asItem());

        this.getOrCreateTagBuilder(ItemTags.WOOL)
            .addTag(BlockusItemTags.PATTERNED_WOOL);

        this.copy(BlockTags.WOOL_CARPETS, ItemTags.WOOL_CARPETS);
        this.copy(BlockTags.DIRT, ItemTags.DIRT);

        // Conventional Item Tags
        this.getOrCreateTagBuilder(ConventionalItemTags.CHAINS)
            .add(GOLDEN_CHAIN.asItem());

    }
}
